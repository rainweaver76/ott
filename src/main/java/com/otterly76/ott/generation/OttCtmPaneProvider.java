package com.otterly76.ott.generation;

import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generates blockstate JSON and 5 model JSON files for every CTM connecting pane block.
 *
 * <p>Each block gets:
 * <ul>
 *   <li>{@code blockstates/{name}.json} — 9-entry multipart (post + 4 side + 4 noside)
 *   <li>{@code models/block/glass/{name}_post.json}
 *   <li>{@code models/block/glass/{name}_side.json}
 *   <li>{@code models/block/glass/{name}_side_alt.json}
 *   <li>{@code models/block/glass/{name}_noside.json}
 *   <li>{@code models/block/glass/{name}_noside_alt.json}
 * </ul>
 */
public class OttCtmPaneProvider implements DataProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /** Name, textures, render type and layout for one CTM pane block. */
    private record PaneSpec(String name, String paneTexture, String edgeTexture,
                            String renderType, boolean vertical) {}

    private static final String[] WOOD_TYPES = {
        "oak", "spruce", "birch", "jungle", "acacia", "dark_oak",
        "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak"
    };

    private final PackOutput packOutput;

    public OttCtmPaneProvider(PackOutput packOutput) {
        this.packOutput = packOutput;
    }

    @Override
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        Path mainPath      = packOutput.getOutputFolder().resolve("../../main/resources/assets/ott").normalize();
        Path bsDir         = mainPath.resolve("blockstates");
        Path blockModelDir = mainPath.resolve("models/block/glass");
        Path itemModelDir  = mainPath.resolve("models/item");

        for (PaneSpec spec : buildSpecs()) {
            writeBlockstate(cache, bsDir.resolve(spec.name() + ".json"), spec.name());
            writeBlockPaneModels(cache, blockModelDir, spec);
            writeItemModel(cache, itemModelDir.resolve(spec.name() + ".json"), spec);
        }

        return CompletableFuture.completedFuture(null);
    }

    // ── spec list ─────────────────────────────────────────────────────────────

    private List<PaneSpec> buildSpecs() {
        List<PaneSpec> specs = new ArrayList<>();

        // ── wood window panes ─────────────────────────────────────────────────
        String[] verticalStyles = {"swirling", "bars", "covered", "diagonal", "large", "panes", "rounded", "slim"};
        for (String wood : WOOD_TYPES) {
            String planksEdge = "minecraft:block/" + wood + "_planks";
            for (String style : verticalStyles) {
                specs.add(new PaneSpec(
                    wood + "_window_" + style + "_ctm_pane",
                    "ott:block/" + wood + "_planks/ctm/" + wood + "_window_" + style,
                    planksEdge, "minecraft:cutout_mipped", true));
            }
            // tiles — full layout
            specs.add(new PaneSpec(
                wood + "_window_tiles_ctm_pane",
                "ott:block/" + wood + "_planks/ctm/" + wood + "_window_tiles",
                planksEdge, "minecraft:cutout_mipped", false));
        }

        // ── per DyeColor stained glass patterns ───────────────────────────────
        for (DyeColor color : DyeColor.values()) {
            String c          = color.getName();
            String sg         = "ott:block/" + c + "_stained_glass/ctm/";
            String vanillaEdge = "minecraft:block/" + c + "_stained_glass_pane_top";
            String leadedEdge = "ott:block/leaded_glass/leaded_glass_pane_edge";

            // arched — vertical
            specs.add(new PaneSpec("arched_" + c + "_stained_glass_ctm_pane",
                sg + "arched_" + c + "_stained_glass_ctm", leadedEdge, "minecraft:translucent", true));

            // framed glass (colour variant)
            specs.add(new PaneSpec(c + "_framed_glass_ctm_pane",
                sg + c + "_framed_glass", leadedEdge, "minecraft:translucent", false));

            // plain stained glass
            specs.add(new PaneSpec(c + "_stained_glass_ctm_pane",
                sg + c + "_stained_glass", vanillaEdge, "minecraft:translucent", false));

            // fancy
            specs.add(new PaneSpec("fancy_" + c + "_stained_glass_ctm_pane",
                sg + "fancy_" + c + "_stained_glass_ctm", leadedEdge, "minecraft:translucent", false));

            // golden framed — edge texture lives in golden_framed_glass/ctm/
            // light_blue texture filename has no "_stained_glass" suffix
            String goldenFile = c.equals("light_blue")
                    ? "golden_framed_light_blue"
                    : "golden_framed_" + c + "_stained_glass";
            specs.add(new PaneSpec("golden_framed_" + c + "_stained_glass_ctm_pane",
                "ott:block/golden_framed_glass/ctm/" + goldenFile,
                "ott:block/golden_framed_glass/ctm/golden_framed_glass_edge",
                "minecraft:translucent", false));

            // ornate
            specs.add(new PaneSpec("ornate_" + c + "_stained_glass_ctm_pane",
                sg + "ornate_" + c + "_stained_glass_ctm", leadedEdge, "minecraft:translucent", false));

            // raster
            specs.add(new PaneSpec("raster_" + c + "_stained_glass_ctm_pane",
                sg + "raster_" + c + "_stained_glass_ctm", leadedEdge, "minecraft:translucent", false));

            // scratched — lives in scratched/ctm/
            specs.add(new PaneSpec("scratched_glass_" + c + "_ctm_pane",
                "ott:block/scratched/ctm/scratched_glass_" + c,
                "ott:block/scratched/ctm/scratched_glass_" + c + "_edge", "minecraft:translucent", false));

            // small diamond
            specs.add(new PaneSpec("small_" + c + "_diamond_stained_glass_ctm_pane",
                sg + "small_" + c + "_diamond_stained_glass", leadedEdge, "minecraft:translucent", false));

            // tiled
            specs.add(new PaneSpec("tiled_" + c + "_stained_glass_ctm_pane",
                sg + "tiled_" + c + "_stained_glass_ctm", leadedEdge, "minecraft:translucent", false));

            // tinted borderless — lives in tinted/ctm/
            specs.add(new PaneSpec("tinted_borderless_glass_" + c + "_ctm_pane",
                "ott:block/tinted/ctm/tinted_borderless_glass_" + c,
                "ott:block/tinted/ctm/tinted_borderless_glass_" + c + "_edge", "minecraft:translucent", false));

            // borderless — lives in borderless/ctm/
            specs.add(new PaneSpec("borderless_glass_" + c + "_ctm_pane",
                "ott:block/borderless/ctm/borderless_glass_" + c,
                "ott:block/borderless/ctm/borderless_glass_" + c + "_edge", "minecraft:translucent", false));
        }

        // ── stained clear glass ───────────────────────────────────────────────
        for (DyeColor color : DyeColor.values()) {
            String c = color.getName();
            specs.add(new PaneSpec(c + "_stained_clear_glass_ctm_pane",
                "ott:block/" + c + "_stained_glass/ctm/" + c + "_stained_clear_glass",
                "ott:block/" + c + "_stained_glass/clear_glass_" + c + "_edge",
                "minecraft:translucent", false));
        }

        // ── plain (un-tinted/colourless) single-block variants ─────────────────
        specs.add(new PaneSpec("scratched_glass_ctm_pane",
            "ott:block/scratched/ctm/scratched_glass",
            "minecraft:block/glass_pane_top", "minecraft:cutout", false));

        specs.add(new PaneSpec("tinted_borderless_glass_ctm_pane",
            "ott:block/tinted/ctm/tinted_borderless_glass",
            "ott:block/tinted/ctm/tinted_glass_edge", "minecraft:translucent", false));

        specs.add(new PaneSpec("borderless_glass_ctm_pane",
            "ott:block/borderless/ctm/borderless_glass",
            "minecraft:block/glass_pane_top", "minecraft:cutout", false));

        return specs;
    }

    // ── blockstate writer ─────────────────────────────────────────────────────

    private void writeBlockstate(CachedOutput cache, Path file, String name) {
        String base = "ott:block/glass/" + name;

        JsonArray multipart = new JsonArray();

        // POST — always rendered
        JsonObject postApply = new JsonObject();
        postApply.addProperty("model", base + "_post");
        JsonObject postEntry = new JsonObject();
        postEntry.add("apply", postApply);
        multipart.add(postEntry);

        // SIDE arms (connected directions)
        addEntry(multipart, base + "_side",     "north", "true",   0);
        addEntry(multipart, base + "_side",     "east",  "true",  90);
        addEntry(multipart, base + "_side_alt", "south", "true",   0);
        addEntry(multipart, base + "_side_alt", "west",  "true",  90);

        // NOSIDE caps (disconnected directions)
        addEntry(multipart, base + "_noside",     "north", "false",   0);
        addEntry(multipart, base + "_noside_alt", "east",  "false",   0);
        addEntry(multipart, base + "_noside_alt", "south", "false",  90);
        addEntry(multipart, base + "_noside",     "west",  "false", 270);

        JsonObject root = new JsonObject();
        root.add("multipart", multipart);
        writeJson(cache, file, root);
    }

    private static void addEntry(JsonArray multipart, String model, String prop, String val, int y) {
        JsonObject when = new JsonObject();
        when.addProperty(prop, val);
        JsonObject apply = new JsonObject();
        apply.addProperty("model", model);
        if (y != 0) apply.addProperty("y", y);
        JsonObject entry = new JsonObject();
        entry.add("when", when);
        entry.add("apply", apply);
        multipart.add(entry);
    }

    // ── block model writer ────────────────────────────────────────────────────

    private void writeBlockPaneModels(CachedOutput cache, Path dir, PaneSpec spec) {
        String suf = spec.vertical() ? "_vertical" : "_full";
        writeBlockModel(cache, dir.resolve(spec.name() + "_post.json"),
            "ott:block/ctm/ctm_pane_post" + suf, spec);
        writeBlockModel(cache, dir.resolve(spec.name() + "_side.json"),
            "ott:block/ctm/ctm_pane_side" + suf, spec);
        writeBlockModel(cache, dir.resolve(spec.name() + "_side_alt.json"),
            "ott:block/ctm/ctm_pane_side_alt" + suf, spec);
        writeBlockModel(cache, dir.resolve(spec.name() + "_noside.json"),
            "ott:block/ctm/ctm_pane_noside" + suf, spec);
        writeBlockModel(cache, dir.resolve(spec.name() + "_noside_alt.json"),
            "ott:block/ctm/ctm_pane_noside_alt" + suf, spec);
    }

    private void writeBlockModel(CachedOutput cache, Path file, String parent, PaneSpec spec) {
        JsonObject textures = new JsonObject();
        textures.addProperty("pane", spec.paneTexture());
        textures.addProperty("edge", spec.edgeTexture());

        JsonArray paneConn = new JsonArray();
        JsonObject isSameBlock = new JsonObject();
        isSameBlock.addProperty("type", "is_same_block");
        paneConn.add(isSameBlock);
        JsonObject connections = new JsonObject();
        connections.add("pane", paneConn);

        JsonObject json = new JsonObject();
        json.addProperty("loader", "ott:mosaic");
        if (spec.vertical()) json.addProperty("layout", "vertical");
        json.addProperty("parent", parent);
        json.add("textures", textures);
        json.add("connections", connections);
        json.addProperty("render_type", spec.renderType());

        writeJson(cache, file, json);
    }

    // ── item model writer ─────────────────────────────────────────────────────

    private void writeItemModel(CachedOutput cache, Path file, PaneSpec spec) {
        JsonObject textures = new JsonObject();
        textures.addProperty("front", spec.paneTexture());
        textures.addProperty("side", spec.edgeTexture());
        String parent = "ott:item/glass_pane_ctm_" + (spec.vertical() ? "vertical" : "full");
        JsonObject json = new JsonObject();
        json.addProperty("parent", parent);
        json.add("textures", textures);
        json.addProperty("render_type", spec.renderType());
        writeJson(cache, file, json);
    }

    // ── utilities ─────────────────────────────────────────────────────────────

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
        return "OTT CTM Pane Provider";
    }
}
