package com.otterly76.ott.color;

import com.otterly76.ott.Constants;
import net.minecraft.world.item.DyeColor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public final class ModPatterns {
    public static final List<ColorInfo> ALL_COLORS = new ArrayList<>();

    static {
        // Vanilla colors
        for (DyeColor dye : DyeColor.values()) {
            ALL_COLORS.add(new ColorInfo(dye.getName(), 0xFF000000 | dye.getTextureDiffuseColor()));
        }
        // Custom colors
        for (ModColorSets.ColorSet set : ModColorSets.ALL) {
            ALL_COLORS.add(new ColorInfo(set.name(), set.color()));
        }
    }

    public record ColorInfo(String name, int color) {}

    /**
     * Canonical pattern list — the single source of truth for which pattern block families exist.
     * <p>
     * The pattern textures live in the {@code ott_blocks} module (since "THE BIG SPLIT"), so the
     * filesystem scan in {@link #findPatterns()} cannot see them from the {@code ott} module's
     * resources, and a production jar has no filesystem path to scan at all. Relying on the scan
     * therefore collapsed the list to a single hard-coded fallback in production, leaving 9 of the
     * 10 pattern families (×33 colors) unregistered. This explicit list guarantees every family is
     * registered identically in dev and in a packaged jar; the scan below only <em>augments</em> it
     * when additional textures happen to be present in a dev checkout.
     */
    private static final List<String> KNOWN_PATTERNS = List.of(
            "banded_plastered_stone",
            "chiseled_plastered_stone",
            "delicate_plastered_stone",
            "dyed_cobblestone",
            "dyed_stone",
            "flat_roof_tiles",
            "gilded_plastered_stone",
            "layered_roof_tiles",
            "painted_planks",
            "plastered_stone"
    );

    /** Subset of {@link #KNOWN_PATTERNS} that ships a paired {@code _mask.png} → registered as pillars. */
    private static final Set<String> KNOWN_PILLAR_PATTERNS = Set.of(
            "banded_plastered_stone",
            "delicate_plastered_stone",
            "gilded_plastered_stone"
    );

    public static final List<String> PATTERNS = findPatterns();
    /** Patterns that have a paired {@code _mask.png} — registered as {@link net.minecraft.world.level.block.RotatedPillarBlock} with a two-layer tinted model. */
    public static final Set<String> PILLAR_PATTERNS = findPillarPatterns();

    private static Path getPatternsPath() {
        String sourceResources = System.getProperty("ott.sourceResources");
        return sourceResources != null
                ? Paths.get(sourceResources, "assets", Constants.MOD_ID, "textures", "block", "patterns")
                : Paths.get("src", "main", "resources", "assets", Constants.MOD_ID, "textures", "block", "patterns");
    }

    private static List<String> findPatterns() {
        // Seed from the canonical list so registration is identical in dev and in a production jar.
        List<String> patterns = new ArrayList<>(KNOWN_PATTERNS);
        try {
            Path assetsPath = getPatternsPath();
            if (Files.exists(assetsPath) && Files.isDirectory(assetsPath)) {
                try (Stream<Path> files = Files.list(assetsPath)) {
                    files.filter(f -> {
                                String name = f.getFileName().toString();
                                return name.endsWith(".png") && !name.endsWith("_mask.png");
                            })
                            .map(f -> f.getFileName().toString().replace(".png", ""))
                            .filter(name -> !patterns.contains(name))
                            .forEach(patterns::add);
                }
            }
        } catch (Exception ignored) {
        }
        return patterns;
    }

    private static Set<String> findPillarPatterns() {
        // Seed from the canonical pillar list so the production jar registers pillars correctly.
        Set<String> pillars = new HashSet<>(KNOWN_PILLAR_PATTERNS);
        try {
            Path assetsPath = getPatternsPath();
            if (Files.exists(assetsPath) && Files.isDirectory(assetsPath)) {
                try (Stream<Path> files = Files.list(assetsPath)) {
                    files.filter(f -> f.getFileName().toString().endsWith("_mask.png"))
                            .map(f -> f.getFileName().toString().replace("_mask.png", ""))
                            .filter(PATTERNS::contains)
                            .forEach(pillars::add);
                }
            }
        } catch (Exception ignored) {
        }
        return pillars;
    }

    private ModPatterns() {}
}