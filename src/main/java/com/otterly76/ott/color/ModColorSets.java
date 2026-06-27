package com.otterly76.ott.color;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom colour-set definitions, loaded from {@code assets/ott/color_sets.csv}
 * (columns: {@code name,hex,display}). Add a colour = add a CSV row; the registrar,
 * texture generator, datagen and lang all key off this list.
 */
public final class ModColorSets {
    private ModColorSets() {}

    public static final List<ColorSet> ALL = load();

    private static List<ColorSet> load() {
        List<ColorSet> list = new ArrayList<>();
        var loader = ModColorSets.class.getClassLoader();
        try (var in = loader.getResourceAsStream("assets/ott/color_sets.csv")) {
            if (in == null) throw new IllegalStateException("assets/ott/color_sets.csv not found on classpath");
            try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                String line;
                while ((line = r.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("#") || line.startsWith("name,")) continue;
                    String[] p = line.split(",", -1);
                    String name = p[0].trim();
                    int color = Integer.parseUnsignedInt(p[1].trim(), 16);
                    String display = p.length > 2 ? p[2].trim() : "";
                    list.add(new ColorSet(name, color, display));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load color_sets.csv", e);
        }
        return List.copyOf(list);
    }

    public record ColorSet(String name, int color, String display) {
        public ColorSet {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("ColorSet name must not be blank");
            }
        }
    }
}
