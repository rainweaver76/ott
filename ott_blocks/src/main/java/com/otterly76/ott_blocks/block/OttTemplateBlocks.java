package com.otterly76.ott_blocks.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CryingObsidianBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Unified, data-driven registrar for template-based blocks.
 * Reads {@code assets/ott/block_templates.csv} (header: {@code name,material,template,render})
 * and registers each block into {@link OttBlocks#BLOCKS}/{@link OttBlocks#ITEMS}, choosing the
 * block class by {@code template}. Loop-driven (not thousands of static fields) to avoid the
 * 64KB {@code <clinit>} bytecode limit on {@link OttBlocks}.
 *
 * <p>Templates are also rendered by {@code OttBlockStateProvider} (model/blockstate) by reading
 * {@link #TEMPLATE_BY_NAME}/{@link #RENDER_BY_NAME}. Current templates: {@code cube_all},
 * {@code cube_column}, {@code glass}. Future (framework-ready): {@code leaves}, {@code iron_bars},
 * {@code plant}, {@code door}, {@code trapdoor}, {@code wool} (+ carpet), {@code pane}.
 */
public final class OttTemplateBlocks {
    /** name -> registered block (insertion order = CSV order = sorted by material then name). */
    public static final Map<String, DeferredBlock<Block>> BY_NAME = new LinkedHashMap<>();
    /** name -> material folder (texture dir + property source). */
    public static final Map<String, String> MATERIAL_BY_NAME = new LinkedHashMap<>();
    /** name -> template id (cube_all/cube_column/glass/...). */
    public static final Map<String, String> TEMPLATE_BY_NAME = new LinkedHashMap<>();
    /** name -> render hint ("", solid, cutout, cutout_mipped, translucent). */
    public static final Map<String, String> RENDER_BY_NAME = new LinkedHashMap<>();

    /** material folder -> vanilla base block whose properties are copied. */
    private static final Map<String, Block> BASE = new HashMap<>();
    static {
        BASE.put("acacia_planks", Blocks.ACACIA_PLANKS);
        BASE.put("amethyst_block", Blocks.AMETHYST_BLOCK);
        BASE.put("ancient_debris", Blocks.ANCIENT_DEBRIS);
        BASE.put("andesite", Blocks.ANDESITE);
        BASE.put("asurine", Blocks.STONE);
        BASE.put("bamboo_planks", Blocks.BAMBOO_PLANKS);
        BASE.put("basalt", Blocks.BASALT);
        BASE.put("birch_planks", Blocks.BIRCH_PLANKS);
        BASE.put("black_concrete", Blocks.BLACK_CONCRETE);
        BASE.put("black_glazed_terracotta", Blocks.BLACK_GLAZED_TERRACOTTA);
        BASE.put("black_terracotta", Blocks.BLACK_TERRACOTTA);
        BASE.put("black_wool", Blocks.BLACK_WOOL);
        BASE.put("blackstone", Blocks.BLACKSTONE);
        BASE.put("bloodstone", Blocks.STONE);
        BASE.put("blue_concrete", Blocks.BLUE_CONCRETE);
        BASE.put("blue_glazed_terracotta", Blocks.BLUE_GLAZED_TERRACOTTA);
        BASE.put("blue_ice", Blocks.BLUE_ICE);
        BASE.put("blue_terracotta", Blocks.BLUE_TERRACOTTA);
        BASE.put("blue_wool", Blocks.BLUE_WOOL);
        BASE.put("borderless_bricks", Blocks.BRICKS);
        BASE.put("bricks", Blocks.BRICKS);
        BASE.put("brown_concrete", Blocks.BROWN_CONCRETE);
        BASE.put("brown_glazed_terracotta", Blocks.BROWN_GLAZED_TERRACOTTA);
        BASE.put("brown_mushroom_block", Blocks.BROWN_MUSHROOM_BLOCK);
        BASE.put("brown_terracotta", Blocks.BROWN_TERRACOTTA);
        BASE.put("brown_wool", Blocks.BROWN_WOOL);
        BASE.put("calcite", Blocks.CALCITE);
        BASE.put("cherry_planks", Blocks.CHERRY_PLANKS);
        BASE.put("clay", Blocks.CLAY);
        BASE.put("coal_block", Blocks.COAL_BLOCK);
        BASE.put("cobblestone", Blocks.COBBLESTONE);
        BASE.put("crimsite", Blocks.STONE);
        BASE.put("crimson_planks", Blocks.CRIMSON_PLANKS);
        BASE.put("cyan_concrete", Blocks.CYAN_CONCRETE);
        BASE.put("cyan_glazed_terracotta", Blocks.CYAN_GLAZED_TERRACOTTA);
        BASE.put("cyan_terracotta", Blocks.CYAN_TERRACOTTA);
        BASE.put("cyan_wool", Blocks.CYAN_WOOL);
        BASE.put("dark_limestone", Blocks.STONE);
        BASE.put("dark_oak_planks", Blocks.DARK_OAK_PLANKS);
        BASE.put("dark_prismarine", Blocks.DARK_PRISMARINE);
        BASE.put("deepslate", Blocks.DEEPSLATE);
        BASE.put("diamond_block", Blocks.DIAMOND_BLOCK);
        BASE.put("diorite", Blocks.DIORITE);
        BASE.put("dirt", Blocks.DIRT);
        BASE.put("dripstone_block", Blocks.DRIPSTONE_BLOCK);
        BASE.put("emerald_block", Blocks.EMERALD_BLOCK);
        BASE.put("end_stone", Blocks.END_STONE);
        BASE.put("gilded_blackstone", Blocks.GILDED_BLACKSTONE);
        BASE.put("gold_block", Blocks.GOLD_BLOCK);
        BASE.put("granite", Blocks.GRANITE);
        BASE.put("gravel", Blocks.GRAVEL);
        BASE.put("gray_concrete", Blocks.GRAY_CONCRETE);
        BASE.put("gray_glazed_terracotta", Blocks.GRAY_GLAZED_TERRACOTTA);
        BASE.put("gray_terracotta", Blocks.GRAY_TERRACOTTA);
        BASE.put("gray_wool", Blocks.GRAY_WOOL);
        BASE.put("green_concrete", Blocks.GREEN_CONCRETE);
        BASE.put("green_glazed_terracotta", Blocks.GREEN_GLAZED_TERRACOTTA);
        BASE.put("green_terracotta", Blocks.GREEN_TERRACOTTA);
        BASE.put("green_wool", Blocks.GREEN_WOOL);
        BASE.put("ice", Blocks.ICE);
        BASE.put("iron_block", Blocks.IRON_BLOCK);
        BASE.put("jungle_planks", Blocks.JUNGLE_PLANKS);
        BASE.put("lapis_block", Blocks.LAPIS_BLOCK);
        BASE.put("light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE);
        BASE.put("light_blue_glazed_terracotta", Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        BASE.put("light_blue_terracotta", Blocks.LIGHT_BLUE_TERRACOTTA);
        BASE.put("light_blue_wool", Blocks.LIGHT_BLUE_WOOL);
        BASE.put("light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE);
        BASE.put("light_gray_glazed_terracotta", Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        BASE.put("light_gray_terracotta", Blocks.LIGHT_GRAY_TERRACOTTA);
        BASE.put("light_gray_wool", Blocks.LIGHT_GRAY_WOOL);
        BASE.put("lime_concrete", Blocks.LIME_CONCRETE);
        BASE.put("lime_glazed_terracotta", Blocks.LIME_GLAZED_TERRACOTTA);
        BASE.put("lime_terracotta", Blocks.LIME_TERRACOTTA);
        BASE.put("lime_wool", Blocks.LIME_WOOL);
        BASE.put("limestone", Blocks.STONE);
        BASE.put("lodestone", Blocks.LODESTONE);
        BASE.put("magenta_concrete", Blocks.MAGENTA_CONCRETE);
        BASE.put("magenta_glazed_terracotta", Blocks.MAGENTA_GLAZED_TERRACOTTA);
        BASE.put("magenta_terracotta", Blocks.MAGENTA_TERRACOTTA);
        BASE.put("magenta_wool", Blocks.MAGENTA_WOOL);
        BASE.put("magma_block", Blocks.MAGMA_BLOCK);
        BASE.put("mangrove_planks", Blocks.MANGROVE_PLANKS);
        BASE.put("moss_block", Blocks.MOSS_BLOCK);
        BASE.put("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE);
        BASE.put("mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS);
        BASE.put("mud", Blocks.MUD);
        BASE.put("mud_bricks", Blocks.MUD_BRICKS);
        BASE.put("mushroom_stem", Blocks.MUSHROOM_STEM);
        BASE.put("nether_bricks", Blocks.NETHER_BRICKS);
        BASE.put("nether_wart_block", Blocks.NETHER_WART_BLOCK);
        BASE.put("netherite_block", Blocks.NETHERITE_BLOCK);
        BASE.put("netherrack", Blocks.NETHERRACK);
        BASE.put("oak_planks", Blocks.OAK_PLANKS);
        BASE.put("obsidian", Blocks.OBSIDIAN);
        BASE.put("ochrum", Blocks.STONE);
        BASE.put("orange_concrete", Blocks.ORANGE_CONCRETE);
        BASE.put("orange_glazed_terracotta", Blocks.ORANGE_GLAZED_TERRACOTTA);
        BASE.put("orange_terracotta", Blocks.ORANGE_TERRACOTTA);
        BASE.put("orange_wool", Blocks.ORANGE_WOOL);
        BASE.put("packed_ice", Blocks.PACKED_ICE);
        BASE.put("packed_mud", Blocks.PACKED_MUD);
        BASE.put("pink_concrete", Blocks.PINK_CONCRETE);
        BASE.put("pink_glazed_terracotta", Blocks.PINK_GLAZED_TERRACOTTA);
        BASE.put("pink_terracotta", Blocks.PINK_TERRACOTTA);
        BASE.put("pink_wool", Blocks.PINK_WOOL);
        BASE.put("prismarine", Blocks.PRISMARINE);
        BASE.put("purple_concrete", Blocks.PURPLE_CONCRETE);
        BASE.put("purple_glazed_terracotta", Blocks.PURPLE_GLAZED_TERRACOTTA);
        BASE.put("purple_terracotta", Blocks.PURPLE_TERRACOTTA);
        BASE.put("purple_wool", Blocks.PURPLE_WOOL);
        BASE.put("purpur_block", Blocks.PURPUR_BLOCK);
        BASE.put("quartz_block", Blocks.QUARTZ_BLOCK);
        BASE.put("raw_copper_block", Blocks.RAW_COPPER_BLOCK);
        BASE.put("raw_gold_block", Blocks.RAW_GOLD_BLOCK);
        BASE.put("raw_iron_block", Blocks.RAW_IRON_BLOCK);
        BASE.put("red_concrete", Blocks.RED_CONCRETE);
        BASE.put("red_glazed_terracotta", Blocks.RED_GLAZED_TERRACOTTA);
        BASE.put("red_mushroom_block", Blocks.RED_MUSHROOM_BLOCK);
        BASE.put("red_nether_bricks", Blocks.RED_NETHER_BRICKS);
        BASE.put("red_sandstone", Blocks.RED_SANDSTONE);
        BASE.put("red_terracotta", Blocks.RED_TERRACOTTA);
        BASE.put("red_wool", Blocks.RED_WOOL);
        BASE.put("redstone_block", Blocks.REDSTONE_BLOCK);
        BASE.put("rose_quartz", Blocks.STONE);
        BASE.put("sand", Blocks.SAND);
        BASE.put("sandstone", Blocks.SANDSTONE);
        BASE.put("scorchia", Blocks.STONE);
        BASE.put("scoria", Blocks.STONE);
        BASE.put("smooth_stone", Blocks.SMOOTH_STONE);
        BASE.put("snow_block", Blocks.SNOW_BLOCK);
        BASE.put("soul_sand", Blocks.SOUL_SAND);
        BASE.put("sponge", Blocks.SPONGE);
        BASE.put("spruce_planks", Blocks.SPRUCE_PLANKS);
        BASE.put("stone", Blocks.STONE);
        BASE.put("terracotta", Blocks.TERRACOTTA);
        BASE.put("tuff", Blocks.TUFF);
        BASE.put("veridium", Blocks.STONE);
        BASE.put("warped_planks", Blocks.WARPED_PLANKS);
        BASE.put("warped_wart_block", Blocks.WARPED_WART_BLOCK);
        BASE.put("waxed_copper_block", Blocks.WAXED_COPPER_BLOCK);
        BASE.put("waxed_exposed_copper", Blocks.WAXED_EXPOSED_COPPER);
        BASE.put("waxed_oxidized_copper", Blocks.WAXED_OXIDIZED_COPPER);
        BASE.put("waxed_weathered_copper", Blocks.WAXED_WEATHERED_COPPER);
        BASE.put("white_concrete", Blocks.WHITE_CONCRETE);
        BASE.put("white_glazed_terracotta", Blocks.WHITE_GLAZED_TERRACOTTA);
        BASE.put("white_terracotta", Blocks.WHITE_TERRACOTTA);
        BASE.put("white_wool", Blocks.WHITE_WOOL);
        BASE.put("yellow_concrete", Blocks.YELLOW_CONCRETE);
        BASE.put("yellow_glazed_terracotta", Blocks.YELLOW_GLAZED_TERRACOTTA);
        BASE.put("yellow_terracotta", Blocks.YELLOW_TERRACOTTA);
        BASE.put("yellow_wool", Blocks.YELLOW_WOOL);
    }

    private OttTemplateBlocks() {}

    public static void init() {
        if (!BY_NAME.isEmpty()) return;
        var stream = OttTemplateBlocks.class.getClassLoader().getResourceAsStream("assets/ott/block_templates.csv");
        if (stream == null) throw new IllegalStateException("Missing assets/ott/block_templates.csv on classpath");
        try (BufferedReader r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#") || line.startsWith("name,")) continue; // skip blanks/comments/header
                String[] p = line.split(",", -1);
                String name = p[0].trim();
                String material = p[1].trim();
                String template = p.length > 2 && !p[2].trim().isEmpty() ? p[2].trim() : "cube_all";
                String render = p.length > 3 ? p[3].trim() : "";
                DeferredBlock<Block> db = register(name, material, template);
                BY_NAME.put(name, db);
                MATERIAL_BY_NAME.put(name, material);
                TEMPLATE_BY_NAME.put(name, template);
                RENDER_BY_NAME.put(name, render);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load block_templates.csv", e);
        }
    }

    private static Block base(String material) {
        Block b = BASE.get(material);
        if (b == null) throw new IllegalStateException("No base block for material: " + material);
        return b;
    }

    private static DeferredBlock<Block> register(String name, String material, String template) {
        if ("glass".equals(template)) {
            return OttBlocks.register(name,
                    () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(base(material)).noOcclusion()));
        }
        // cube_all, cube_column, and anything else: plain Block (crying_obsidian gets its drip-particle class)
        if ("crying_obsidian".equals(material)) {
            return OttBlocks.register(name,
                    () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
        }
        return OttBlocks.register(name, () -> new Block(BlockBehaviour.Properties.ofFullCopy(base(material))));
    }
}
