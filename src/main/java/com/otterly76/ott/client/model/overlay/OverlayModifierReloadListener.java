package com.otterly76.ott.client.model.overlay;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.event.ModelEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

/**
 * Loads terrain overlay modifier descriptors from config files in
 * {@code assets/ott/ott_overlay_modifiers/}.
 *
 * <ul>
 *   <li>Any file whose name ends with {@code _tier_config.json} defines one
 *       <em>independent domain</em>.  Tier comparisons are scoped entirely
 *       within that domain — blocks in different domains never overlay each
 *       other.  Add as many domain files as needed (e.g.
 *       {@code stone_tier_config.json}, {@code wood_tier_config.json}).</li>
 *   <li>{@code overlay_config.json} is shared across all domains and maps
 *       block IDs to their overlay model path(s).</li>
 * </ul>
 *
 * <p>Within a domain, a block at tier T has its overlay applied to every block
 * in the same domain whose tier is strictly less than T.  Blocks at the same
 * tier never overlay each other.  Rendering order at shared corners is
 * determined by ascending tier (lower tier renders first = bottom layer).
 */
public class OverlayModifierReloadListener {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson   GSON   = new GsonBuilder().setLenient().create();

    private static final ResourceLocation OVERLAY_CONFIG =
            ResourceLocation.fromNamespaceAndPath("ott", "ott_overlay_modifiers/overlay_config.json");

    /** Folder scanned for {@code *_tier_config.json} domain files. */
    private static final String TIER_CONFIG_FOLDER = "ott_overlay_modifiers";
    private static final String TIER_CONFIG_SUFFIX  = "_tier_config.json";

    public static final OverlayModifierReloadListener INSTANCE = new OverlayModifierReloadListener();

    /**
     * Maps each target block-state model location to the ordered list of overlay
     * model locations that should be appended to it.  Populated in registerModels().
     */
    private final Map<ModelResourceLocation, List<ResourceLocation>> modifiers = new HashMap<>();

    private OverlayModifierReloadListener() {}

    // ── Model events ──────────────────────────────────────────────────────────

    /**
     * Scans for all {@code *_tier_config.json} domain files, processes each
     * independently against the shared overlay_config, then registers all
     * referenced overlay models.
     * Call from ModelEvent.RegisterAdditional.
     */
    public void registerModels(@NotNull ModelEvent.RegisterAdditional event) {
        ResourceManager rm = Minecraft.getInstance().getResourceManager();

        // Load the shared overlay config once
        Map<ResourceLocation, List<ResourceLocation>> overlayConfig = loadOverlayConfig(rm);
        if (overlayConfig.isEmpty()) return;

        // Scan for all *_tier_config.json files (one per domain)
        Map<ResourceLocation, Resource> domainFiles = rm.listResources(
                TIER_CONFIG_FOLDER,
                loc -> loc.getNamespace().equals("ott") && loc.getPath().endsWith(TIER_CONFIG_SUFFIX)
        );

        if (domainFiles.isEmpty()) {
            LOGGER.warn("[OTT] No *_tier_config.json files found in {}", TIER_CONFIG_FOLDER);
            return;
        }

        modifiers.clear();

        for (Map.Entry<ResourceLocation, Resource> entry : domainFiles.entrySet()) {
            ResourceLocation configLoc = entry.getKey();
            Map<ResourceLocation, Integer> blockTiers = loadTierConfigFromResource(entry.getValue(), configLoc);
            if (blockTiers.isEmpty()) continue;

            LOGGER.debug("[OTT] Processing domain '{}' ({} blocks)", configLoc, blockTiers.size());
            processDomain(blockTiers, overlayConfig);
        }

        LOGGER.debug("[OTT] Overlay modifiers loaded for {} block-state entries across {} domain(s)",
                modifiers.size(), domainFiles.size());

        // Register every distinct overlay model so the baking system picks it up
        Set<ResourceLocation> allModels = new HashSet<>();
        for (List<ResourceLocation> overlays : modifiers.values()) {
            allModels.addAll(overlays);
        }
        for (ResourceLocation loc : allModels) {
            event.register(ModelResourceLocation.standalone(loc));
        }
    }

    /**
     * Wraps each target block-state model with an OverlayModifierBakedModel.
     * Call from ModelEvent.ModifyBakingResult.
     */
    public void applyModifiers(@NotNull ModelEvent.ModifyBakingResult event) {
        Map<ModelResourceLocation, BakedModel> models = event.getModels();

        for (Map.Entry<ModelResourceLocation, List<ResourceLocation>> entry : modifiers.entrySet()) {
            ModelResourceLocation target   = entry.getKey();
            BakedModel            original = models.get(target);
            if (original == null) continue;

            List<BakedModel> overlayModels = new ArrayList<>();
            for (ResourceLocation overlayLoc : entry.getValue()) {
                BakedModel overlay = models.get(ModelResourceLocation.standalone(overlayLoc));
                if (overlay != null) {
                    overlayModels.add(overlay);
                } else {
                    LOGGER.warn("[OTT] Overlay model '{}' was not baked", overlayLoc);
                }
            }
            if (overlayModels.isEmpty()) continue;

            models.put(target, new OverlayModifierBakedModel(original, overlayModels));
        }
    }

    // ── Domain processing ─────────────────────────────────────────────────────

    /**
     * Processes one tier domain independently.  Only overlay-config entries
     * whose block IDs appear in this domain's tier map are considered; tier
     * comparisons are scoped entirely to this domain.
     */
    private void processDomain(Map<ResourceLocation, Integer> blockTiers,
                                Map<ResourceLocation, List<ResourceLocation>> overlayConfig) {
        // Group blocks in this domain by tier (sorted ascending)
        Map<Integer, List<ResourceLocation>> tierToBlocks = new TreeMap<>();
        for (Map.Entry<ResourceLocation, Integer> e : blockTiers.entrySet()) {
            tierToBlocks.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }

        // Collect overlay entries that belong to this domain, sorted by ascending tier
        List<Map.Entry<ResourceLocation, List<ResourceLocation>>> sortedOverlays = new ArrayList<>();
        for (Map.Entry<ResourceLocation, List<ResourceLocation>> e : overlayConfig.entrySet()) {
            if (blockTiers.containsKey(e.getKey())) {
                sortedOverlays.add(e);
            }
        }
        sortedOverlays.sort(Comparator.comparingInt(e -> blockTiers.getOrDefault(e.getKey(), 0)));

        for (Map.Entry<ResourceLocation, List<ResourceLocation>> entry : sortedOverlays) {
            ResourceLocation blockId      = entry.getKey();
            List<ResourceLocation> models = entry.getValue();
            int tier = blockTiers.get(blockId);

            // Targets = all blocks in this domain with tier strictly less than this block's tier
            for (Map.Entry<Integer, List<ResourceLocation>> tierEntry : tierToBlocks.entrySet()) {
                if (tierEntry.getKey() < tier) {
                    for (ResourceLocation targetId : tierEntry.getValue()) {
                        expandBlock(targetId, models);
                    }
                }
            }
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /** Expands all block states for {@code blockId} and appends the overlay models. */
    private void expandBlock(ResourceLocation blockId, List<ResourceLocation> overlayModels) {
        if (!BuiltInRegistries.BLOCK.containsKey(blockId)) {
            LOGGER.warn("[OTT] Overlay target '{}' is not a registered block — add it to the correct tier config?", blockId);
            return;
        }
        Block block = BuiltInRegistries.BLOCK.get(blockId);
        if (block == Blocks.AIR) return;

        block.getStateDefinition().getPossibleStates().stream()
                .map(BlockModelShaper::stateToModelLocation)
                .forEach(mrl -> modifiers.computeIfAbsent(mrl, k -> new ArrayList<>())
                        .addAll(overlayModels));
    }

    // ── Config file loaders ───────────────────────────────────────────────────

    private Map<ResourceLocation, Integer> loadTierConfigFromResource(Resource resource,
                                                                       ResourceLocation sourceLoc) {
        try (Reader reader = resource.openAsReader()) {
            JsonObject json  = GSON.fromJson(reader, JsonObject.class);
            JsonObject tiers = json.getAsJsonObject("tiers");
            Map<ResourceLocation, Integer> result = new HashMap<>();
            for (Map.Entry<String, JsonElement> e : tiers.entrySet()) {
                result.put(ResourceLocation.parse(e.getKey()), e.getValue().getAsInt());
            }
            return result;
        } catch (Exception e) {
            LOGGER.error("[OTT] Failed to load tier config '{}': {}", sourceLoc, e.getMessage());
            return Map.of();
        }
    }

    private Map<ResourceLocation, List<ResourceLocation>> loadOverlayConfig(ResourceManager rm) {
        Optional<Resource> opt = rm.getResource(OVERLAY_CONFIG);
        if (opt.isEmpty()) {
            LOGGER.error("[OTT] overlay_config.json not found at {}", OVERLAY_CONFIG);
            return Map.of();
        }
        try (Reader reader = opt.get().openAsReader()) {
            JsonObject json     = GSON.fromJson(reader, JsonObject.class);
            JsonObject overlays = json.getAsJsonObject("overlays");
            Map<ResourceLocation, List<ResourceLocation>> result = new HashMap<>();
            for (Map.Entry<String, JsonElement> e : overlays.entrySet()) {
                List<ResourceLocation> models = new ArrayList<>();
                if (e.getValue().isJsonArray()) {
                    for (JsonElement el : e.getValue().getAsJsonArray()) {
                        if (el.isJsonPrimitive()) {
                            models.add(ResourceLocation.parse(el.getAsString()));
                        }
                    }
                }
                if (!models.isEmpty()) {
                    result.put(ResourceLocation.parse(e.getKey()), models);
                }
            }
            LOGGER.debug("[OTT] overlay_config.json loaded: {} overlay entries", result.size());
            return result;
        } catch (Exception e) {
            LOGGER.error("[OTT] Failed to load overlay_config.json: {}", e.getMessage());
            return Map.of();
        }
    }
}
