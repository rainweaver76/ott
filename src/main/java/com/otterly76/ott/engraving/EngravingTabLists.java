package com.otterly76.ott.engraving;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads the ENGRAVED creative tab from data/ott/engraving_tab/*.csv.
 * One file per category in order: stone, gem, copper, concrete, terracotta, wool, glass, wood, other.
 * Each CSV has one ott: block path per line; lines starting with # are comments.
 */
public final class EngravingTabLists {
    private static final Logger LOGGER = LoggerFactory.getLogger(EngravingTabLists.class);

    private static final String[] CATEGORIES = {
            "stone", "wood", "concrete", "terracotta", "wool", "glass", "gem", "copper", "chisels", "other"
    };

    private static volatile List<ItemLike> cached;

    public static List<ItemLike> allItems() {
        if (cached == null) {
            synchronized (EngravingTabLists.class) {
                if (cached == null) {
                    List<ItemLike> result = new ArrayList<>();
                    for (String cat : CATEGORIES) {
                        result.addAll(loadCategory(cat));
                    }
                    cached = List.copyOf(result);
                }
            }
        }
        return cached;
    }

    private static List<ItemLike> loadCategory(String name) {
        String path = "/data/ott/engraving_tab/" + name + ".csv";
        InputStream is = EngravingTabLists.class.getResourceAsStream(path);
        if (is == null) {
            LOGGER.warn("EngravingTabLists: missing resource {}", path);
            return List.of();
        }
        List<ItemLike> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.strip().replace("﻿", ""); // strip UTF-8 BOM if spreadsheet editor added it
                if (line.isEmpty() || line.startsWith("#")) continue;
                ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("ott", line);
                var block = BuiltInRegistries.BLOCK.get(rl);
                if (block == Blocks.AIR) {
                    LOGGER.warn("EngravingTabLists: unknown block '{}' in {}.csv", line, name);
                } else {
                    result.add(block);
                }
            }
        } catch (Exception e) {
            LOGGER.error("EngravingTabLists: failed to read {}", path, e);
        }
        return result;
    }

    private EngravingTabLists() {}
}