package com.otterly76.ott.generation;

import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Data-driven generator for connecting (CTM) block assets. Reads the manifest
 * {@code assets/ott/ctm_blocks.tsv} (tab-separated: {@code name material template render layout
 * textures connections item}) and, for every row whose block is registered, emits three files:
 * <ul>
 *   <li>blockstate {@code blockstates/<name>.json} (single-variant) — into ott_blocks
 *   <li>block model {@code models/block/<material>/<name>.json} ({@code ott:mosaic}) — into ott_blocks
 *   <li>item model {@code models/item/<name>.json} — into the root (ott) module, where CTM item models live
 * </ul>
 *
 * <p>Replaces ~1,900 hand-authored mosaic JSONs with one manifest + this generator. Wool/carpet CTM
 * (whose blockstate/item are owned by {@link OttBlockStateProvider}) and {@code _ctm_pane} blocks
 * (owned by {@link OttCtmPaneProvider}) are out of scope and not listed in the manifest.
 *
 * <p>Geometry/UVs come from the unmigrated parent templates in
 * {@code ott_blocks/.../models/block/ctm/}; this provider only writes the per-block model that
 * references a parent + supplies textures/connections/layout/render.
 */
public class OttCtmModelProvider implements DataProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String MANIFEST = "assets/ott/ctm_blocks.tsv";

    private record Row(String name, String material, String template, String render,
                       String layout, String textures, String connections, String item, String itemRender) {}

    private final PackOutput packOutput;

    public OttCtmModelProvider(PackOutput packOutput) {
        this.packOutput = packOutput;
    }

    @Override
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        // Block assets are ott_blocks content; item models live in the root (ott) module — match where
        // the committed files already are. packOutput = ott/src/generated/resources → climb to project root.
        Path obAssets   = packOutput.getOutputFolder().resolve("../../../ott_blocks/src/main/resources/assets/ott").normalize();
        Path rootAssets = packOutput.getOutputFolder().resolve("../../../src/main/resources/assets/ott").normalize();
        Path bsDir       = obAssets.resolve("blockstates");
        Path blockModels = obAssets.resolve("models/block");
        Path itemModels  = rootAssets.resolve("models/item");

        List<Row> rows = readManifest();
        List<String> missing = new ArrayList<>();

        for (Row r : rows) {
            if (!BuiltInRegistries.BLOCK.containsKey(ResourceLocation.fromNamespaceAndPath("ott", r.name()))) {
                continue; // block not registered (removed in a trim) — skip, don't emit orphan assets
            }
            writeJson(cache, bsDir.resolve(r.name() + ".json"), blockstate(r));
            writeJson(cache, blockModels.resolve(r.material() + "/" + r.name() + ".json"), blockModel(r));
            writeJson(cache, itemModels.resolve(r.name() + ".json"), itemModel(r));
        }

        // Coverage check: every registered, in-scope _ctm block must have a manifest row.
        java.util.Set<String> manifestNames = new java.util.HashSet<>();
        for (Row r : rows) manifestNames.add(r.name());
        for (var entry : com.otterly76.ott_blocks.block.OttBlocks.BLOCKS.getEntries()) {
            String path = entry.getId().getPath();
            if (!path.endsWith("_ctm") || path.endsWith("_pane")) continue;
            if (isWoolOrCarpet(path)) continue; // owned by OttBlockStateProvider
            if (!manifestNames.contains(path)) missing.add(path);
        }
        if (!missing.isEmpty()) {
            throw new IllegalStateException("ctm_blocks.tsv is missing " + missing.size()
                    + " registered _ctm block(s), e.g. " + missing.subList(0, Math.min(10, missing.size())));
        }

        return CompletableFuture.completedFuture(null);
    }

    private static boolean isWoolOrCarpet(String path) {
        return com.otterly76.ott_blocks.block.OttBlocks.DECO_WOOL.containsKey(path)
                || com.otterly76.ott_blocks.block.OttBlocks.STYLED_WOOL.containsKey(path)
                || com.otterly76.ott_blocks.block.OttBlocks.DECO_CARPET.containsKey(path)
                || com.otterly76.ott_blocks.block.OttBlocks.STYLED_CARPET.containsKey(path);
    }

    // ── JSON builders (mirror of the verified Python generator) ─────────────────

    private JsonObject blockstate(Row r) {
        JsonObject apply = new JsonObject();
        apply.addProperty("model", "ott:block/" + r.material() + "/" + r.name());
        JsonObject variant = new JsonObject();
        variant.add("", apply);
        JsonObject root = new JsonObject();
        root.add("variants", variant);
        return root;
    }

    private JsonObject blockModel(Row r) {
        JsonObject m = new JsonObject();
        m.addProperty("loader", "ott:mosaic");
        m.addProperty("parent", "ott:block/ctm/" + r.template());
        if (!r.layout().isEmpty()) m.addProperty("layout", r.layout());

        JsonObject textures = new JsonObject();
        for (Map.Entry<String, String> e : parseTextures(r.textures()).entrySet()) {
            textures.addProperty(e.getKey(), e.getValue());
        }
        m.add("textures", textures);

        if (!r.connections().isEmpty()) {
            JsonObject conn = new JsonObject();
            for (String entry : r.connections().split("\\|")) {
                int c = entry.indexOf(':');
                JsonArray rules = new JsonArray();
                JsonObject isSame = new JsonObject();
                isSame.addProperty("type", "is_same_block");
                rules.add(isSame);
                if (c < 0) {
                    conn.add(entry, rules);
                } else {
                    JsonObject nested = new JsonObject();
                    nested.addProperty("layout", entry.substring(c + 1));
                    nested.add("rules", rules);
                    conn.add(entry.substring(0, c), nested);
                }
            }
            m.add("connections", conn);
        }
        if (!r.render().isEmpty()) m.addProperty("render_type", r.render());
        return m;
    }

    private JsonObject itemModel(Row r) {
        JsonObject m = new JsonObject();
        if ("solo".equals(r.item())) {
            m.addProperty("parent", "ott:block/ctm/item_pieces_solo");
            Map<String, String> tx = parseTextures(r.textures());
            String prim = tx.getOrDefault("all", tx.get("side"));
            JsonObject textures = new JsonObject();
            textures.addProperty("all", prim);
            m.add("textures", textures);
            if (!r.itemRender().isEmpty()) m.addProperty("render_type", r.itemRender());
        } else {
            m.addProperty("parent", "ott:block/" + r.material() + "/" + r.name());
        }
        return m;
    }

    private static Map<String, String> parseTextures(String s) {
        Map<String, String> out = new LinkedHashMap<>();
        if (s.isEmpty()) return out;
        for (String kv : s.split("\\|")) {
            int eq = kv.indexOf('=');
            out.put(kv.substring(0, eq), kv.substring(eq + 1));
        }
        return out;
    }

    // ── manifest reader ─────────────────────────────────────────────────────────

    private List<Row> readManifest() {
        List<Row> rows = new ArrayList<>();
        var stream = OttCtmModelProvider.class.getClassLoader().getResourceAsStream(MANIFEST);
        if (stream == null) throw new IllegalStateException("Missing " + MANIFEST + " on classpath");
        try (BufferedReader r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            boolean header = true;
            while ((line = r.readLine()) != null) {
                if (header) { header = false; continue; }
                if (line.isEmpty()) continue;
                String[] p = line.split("\t", -1);
                if (p.length < 9) throw new IllegalStateException("Bad ctm_blocks.tsv row: " + line);
                rows.add(new Row(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading " + MANIFEST, e);
        }
        return rows;
    }

    private void writeJson(CachedOutput cache, Path file, JsonObject json) {
        byte[] bytes = GSON.toJson(json).getBytes(StandardCharsets.UTF_8);
        try {
            cache.writeIfNeeded(file, bytes, Hashing.sha256().hashBytes(bytes));
        } catch (IOException e) {
            throw new RuntimeException("Failed to write " + file, e);
        }
    }

    @Override
    @NotNull
    public String getName() {
        return "OTT CTM Model Provider";
    }
}
