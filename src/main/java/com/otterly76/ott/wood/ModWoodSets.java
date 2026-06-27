package com.otterly76.ott.wood;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom wood-set definitions, loaded from {@code assets/ott/wood_sets.csv}
 * (columns: {@code name,display}). Add a wood = add a CSV row; the registrar and
 * datagen key off this list. (Unlike colour sets, wood textures are hand-drawn art,
 * so there is no tint generator.)
 */
public final class ModWoodSets {
    private ModWoodSets() {}

    public static final List<WoodSet> ALL = load();

    private static List<WoodSet> load() {
        List<WoodSet> list = new ArrayList<>();
        var loader = ModWoodSets.class.getClassLoader();
        try (var in = loader.getResourceAsStream("assets/ott/wood_sets.csv")) {
            if (in == null) throw new IllegalStateException("assets/ott/wood_sets.csv not found on classpath");
            try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                String line;
                while ((line = r.readLine()) != null) {
                    String t = line.trim();
                    if (t.isEmpty() || t.startsWith("#") || t.startsWith("name,")) continue;
                    String[] p = line.split(",", -1);
                    String name = p[0].trim();
                    String display = p.length > 1 ? p[1].trim() : "";
                    list.add(new WoodSet(name, display));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load wood_sets.csv", e);
        }
        return List.copyOf(list);
    }

    public record WoodSet(String name, String display) {
        public WoodSet {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("WoodSet name must not be blank");
            }
        }
    }
}
