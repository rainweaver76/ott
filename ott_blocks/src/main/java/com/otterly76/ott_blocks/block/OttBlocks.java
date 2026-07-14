package com.otterly76.ott_blocks.block;

import com.otterly76.ott_blocks.util.block.BlockSetTypeVariant;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OttBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("ott");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("ott");

    private static final Properties ST = Properties.ofFullCopy(Blocks.STONE);

    static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> b = BLOCKS.register(name, block);
        ITEMS.registerSimpleBlockItem(name, b);
        return b;
    }

    // ===== DOORS & TRAPDOORS — CSV-driven (wood_doors.csv / wood_trapdoors.csv) =====
    public static final Map<String, DeferredBlock<DoorBlock>> WOOD_DOORS = new LinkedHashMap<>();
    public static final Map<String, String> WOOD_DOOR_WOOD = new LinkedHashMap<>();
    public static final Map<String, String> WOOD_DOOR_TOP = new LinkedHashMap<>();
    public static final Map<String, String> WOOD_DOOR_BOTTOM = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<TrapDoorBlock>> WOOD_TRAPDOORS = new LinkedHashMap<>();
    public static final Map<String, String> WOOD_TRAPDOOR_WOOD = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<DoorBlock>> GLASS_DOORS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<TrapDoorBlock>> GLASS_TRAPDOORS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<net.minecraft.world.level.block.ChainBlock>> CHAINS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<net.minecraft.world.level.block.RedstoneLampBlock>> REDSTONE_LAMPS = new LinkedHashMap<>();

    private static DeferredBlock<DoorBlock> registerDoor(String name, BlockSetType bst, Block template) {
        DeferredBlock<DoorBlock> ret = BLOCKS.register(name, () -> new DoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(template)));
        ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    private static DeferredBlock<TrapDoorBlock> registerTrapdoor(String name, BlockSetType bst, Block template) {
        DeferredBlock<TrapDoorBlock> ret = BLOCKS.register(name, () -> new TrapDoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(template)));
        ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    private static BlockSetType woodBST(String wood) {
        return switch (wood) {
            case "spruce"   -> BlockSetType.SPRUCE;
            case "birch"    -> BlockSetType.BIRCH;
            case "jungle"   -> BlockSetType.JUNGLE;
            case "acacia"   -> BlockSetType.ACACIA;
            case "dark_oak" -> BlockSetType.DARK_OAK;
            case "mangrove" -> BlockSetType.MANGROVE;
            case "cherry"   -> BlockSetType.CHERRY;
            case "bamboo"   -> BlockSetType.BAMBOO;
            case "crimson"  -> BlockSetType.CRIMSON;
            case "warped"   -> BlockSetType.WARPED;
            case "pale_oak" -> BlockSetTypeVariant.PALE_OAK.getBlockSetType();
            default         -> BlockSetType.OAK;
        };
    }

    private static Block woodDoorTemplate(String wood) {
        return switch (wood) {
            case "spruce"   -> Blocks.SPRUCE_DOOR;
            case "birch"    -> Blocks.BIRCH_DOOR;
            case "jungle"   -> Blocks.JUNGLE_DOOR;
            case "acacia"   -> Blocks.ACACIA_DOOR;
            case "dark_oak" -> Blocks.DARK_OAK_DOOR;
            case "mangrove" -> Blocks.MANGROVE_DOOR;
            case "cherry"   -> Blocks.CHERRY_DOOR;
            case "bamboo"   -> Blocks.BAMBOO_DOOR;
            case "crimson"  -> Blocks.CRIMSON_DOOR;
            case "warped"   -> Blocks.WARPED_DOOR;
            default         -> Blocks.OAK_DOOR; // oak + pale_oak
        };
    }

    private static Block woodTrapdoorTemplate(String wood) {
        return switch (wood) {
            case "spruce"   -> Blocks.SPRUCE_TRAPDOOR;
            case "birch"    -> Blocks.BIRCH_TRAPDOOR;
            case "jungle"   -> Blocks.JUNGLE_TRAPDOOR;
            case "acacia"   -> Blocks.ACACIA_TRAPDOOR;
            case "dark_oak" -> Blocks.DARK_OAK_TRAPDOOR;
            case "mangrove" -> Blocks.MANGROVE_TRAPDOOR;
            case "cherry"   -> Blocks.CHERRY_TRAPDOOR;
            case "bamboo"   -> Blocks.BAMBOO_TRAPDOOR;
            case "crimson"  -> Blocks.CRIMSON_TRAPDOOR;
            case "warped"   -> Blocks.WARPED_TRAPDOOR;
            default         -> Blocks.OAK_TRAPDOOR; // oak + pale_oak
        };
    }

    private static void readCsv(String path, java.util.function.Consumer<String> action) {
        var stream = OttBlocks.class.getClassLoader().getResourceAsStream(path);
        if (stream == null) throw new IllegalStateException("Missing " + path + " on classpath");
        try (var r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            r.readLine(); // skip header
            String line;
            while ((line = r.readLine()) != null) {
                line = line.strip();
                if (!line.isEmpty() && !line.startsWith("#")) action.accept(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load " + path, e);
        }
    }

    private static void loadWoodDoors() {
        var stream = OttBlocks.class.getClassLoader().getResourceAsStream("assets/ott/wood_doors.csv");
        if (stream == null) throw new IllegalStateException("Missing assets/ott/wood_doors.csv on classpath");
        try (BufferedReader r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            r.readLine(); // skip header
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] col = line.split(",", -1);
                String name      = col[0].trim();
                String wood      = col[1].trim();
                String topTex    = col.length > 2 ? col[2].trim() : "";
                String bottomTex = col.length > 3 ? col[3].trim() : "";
                DeferredBlock<DoorBlock> block = registerDoor(name, woodBST(wood), woodDoorTemplate(wood));
                WOOD_DOORS.put(name, block);
                WOOD_DOOR_WOOD.put(name, wood);
                if (!topTex.isEmpty())    WOOD_DOOR_TOP.put(name, topTex);
                if (!bottomTex.isEmpty()) WOOD_DOOR_BOTTOM.put(name, bottomTex);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load wood_doors.csv", e);
        }
    }

    private static void loadWoodTrapdoors() {
        var stream = OttBlocks.class.getClassLoader().getResourceAsStream("assets/ott/wood_trapdoors.csv");
        if (stream == null) throw new IllegalStateException("Missing assets/ott/wood_trapdoors.csv on classpath");
        try (BufferedReader r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            r.readLine(); // skip header
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] col = line.split(",", -1);
                String name = col[0].trim();
                String wood = col[1].trim();
                DeferredBlock<TrapDoorBlock> block = registerTrapdoor(name, woodBST(wood), woodTrapdoorTemplate(wood));
                WOOD_TRAPDOORS.put(name, block);
                WOOD_TRAPDOOR_WOOD.put(name, wood);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load wood_trapdoors.csv", e);
        }
    }

    static {
        loadWoodDoors();
        loadWoodTrapdoors();

        BlockSetType glassBst = BlockSetTypeVariant.GLASS.getBlockSetType();
        GLASS_DOORS.put("glass_door", registerDoor("glass_door", glassBst, Blocks.GLASS));
        GLASS_TRAPDOORS.put("glass_trapdoor", registerTrapdoor("glass_trapdoor", glassBst, Blocks.GLASS));
        for (String c : new String[]{"black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray",
                "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"}) {
            Block stained = net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(
                    net.minecraft.resources.ResourceLocation.withDefaultNamespace(c + "_stained_glass"));
            GLASS_DOORS.put(c + "_stained_glass_door", registerDoor(c + "_stained_glass_door", glassBst, stained));
            GLASS_TRAPDOORS.put(c + "_stained_glass_trapdoor", registerTrapdoor(c + "_stained_glass_trapdoor", glassBst, stained));
        }
    }

    // ───── acacia_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_ACACIA_LEAVES = register("apple_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_ACACIA_LEAVES = register("cherry_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_ACACIA_LEAVES = register("dead_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_ACACIA_LEAVES = register("frosted_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_ACACIA_LEAVES = register("golden_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_ACACIA_LEAVES = register("golden_apple_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_ACACIA_LEAVES = register("golden_cherry_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_ACACIA_LEAVES = register("magenta_flower_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_ACACIA_LEAVES = register("orange_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_ACACIA_LEAVES = register("red_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_ACACIA_LEAVES = register("white_flower_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));

    // ───── birch_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_BIRCH_LEAVES = register("apple_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_BIRCH_LEAVES = register("cherry_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_BIRCH_LEAVES = register("dead_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_BIRCH_LEAVES = register("frosted_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_BIRCH_LEAVES = register("golden_apple_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_BIRCH_LEAVES = register("golden_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_BIRCH_LEAVES = register("golden_cherry_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_BIRCH_LEAVES = register("magenta_flower_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_BIRCH_LEAVES = register("orange_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_BIRCH_LEAVES = register("red_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_BIRCH_LEAVES = register("white_flower_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));

    // ───── black_marble ─────
    public static final DeferredBlock<Block> BLACK_MARBLE = register("black_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_BRICKS = register("black_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR = register("black_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR_CAP = register("black_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_SMALL_BRICKS = register("black_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_MARBLE_TILES = register("black_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_POLISHED_MARBLE = register("black_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── blue_marble ─────
    public static final DeferredBlock<Block> BLUE_MARBLE = register("blue_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_BRICKS = register("blue_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR = register("blue_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR_CAP = register("blue_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_SMALL_BRICKS = register("blue_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_MARBLE_TILES = register("blue_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_POLISHED_MARBLE = register("blue_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── brown_marble ─────
    public static final DeferredBlock<Block> BROWN_MARBLE = register("brown_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BROWN_MARBLE_BRICKS = register("brown_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> BROWN_MARBLE_PILLAR = register("brown_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BROWN_MARBLE_PILLAR_CAP = register("brown_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BROWN_MARBLE_SMALL_BRICKS = register("brown_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BROWN_MARBLE_TILES = register("brown_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BROWN_POLISHED_MARBLE = register("brown_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── cyan_marble ─────
    public static final DeferredBlock<Block> CYAN_MARBLE = register("cyan_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_BRICKS = register("cyan_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR = register("cyan_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR_CAP = register("cyan_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_SMALL_BRICKS = register("cyan_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_MARBLE_TILES = register("cyan_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_POLISHED_MARBLE = register("cyan_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── dark_oak_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_DARK_OAK_LEAVES = register("apple_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_DARK_OAK_LEAVES = register("cherry_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_DARK_OAK_LEAVES = register("dead_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_DARK_OAK_LEAVES = register("frosted_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_DARK_OAK_LEAVES = register("golden_apple_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_DARK_OAK_LEAVES = register("golden_cherry_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_DARK_OAK_LEAVES = register("golden_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_DARK_OAK_LEAVES = register("magenta_flower_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_DARK_OAK_LEAVES = register("orange_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_DARK_OAK_LEAVES = register("red_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_DARK_OAK_LEAVES = register("white_flower_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));

    // ───── end_stone ─────
    public static final DeferredBlock<Block> STONE_SLATED_END = register("stone_slated_end", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── glass ─────
    public static final DeferredBlock<Block> SOUL_GLASS = register("soul_glass", () -> new TransparentBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn((state, level, pos, type) -> false).isRedstoneConductor((state, level, pos) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false)));

    // ───── glass_pane ─────
    public static final DeferredBlock<IronBarsBlock> CIRCLE_OAK_GLASS_PANE = register("circle_oak_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LEADED_STAINED_GLASS_PANE = register("circular_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CLEAR_LEADED_GLASS_PANE = register("clear_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LEADED_GLASS_PANE = register("fancy_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LEADED_GLASS_PANE = register("large_diamond_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEADED_GLASS_PANE = register("leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEADED_WOVEN_GLASS_PANE = register("leaded_woven_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_BARRED_GLASS_PANE = register("oak_barred_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_DIAMOND_BORDERED_GLASS_PANE = register("oak_diamond_bordered_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_HORIZONTAL_LINED_GLASS_PANE = register("oak_horizontal_lined_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_LARGE_DIAMOND_GLASS_PANE = register("oak_large_diamond_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_LINE_BARED_GLASS_PANE = register("oak_line_bared_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_ORNATE_BARED_GLASS_PANE = register("oak_ornate_bared_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_SNOWFLAKE_GLASS_PANE = register("oak_snowflake_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WOVEN_GLASS_PANE = register("oak_woven_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LEADED_GLASS_PANE = register("ornate_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LEADED_GLASS_PANE = register("raster_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_DIAMOND_LEADED_GLASS_PANE = register("small_diamond_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SOUL_GLASS_PANE = register("soul_glass_pane", () -> new IronBarsBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn((state, level, pos, type) -> false).isRedstoneConductor((state, level, pos) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LEADED_GLASS_PANE = register("square_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_LEADED_GLASS_PANE = register("vertical_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    // ───── glowstone ─────
    public static final DeferredBlock<Block> REFINED_GLOWSTONE = register("refined_glowstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)));

    // ───── gray_marble ─────
    public static final DeferredBlock<Block> GRAY_MARBLE = register("gray_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRAY_MARBLE_BRICKS = register("gray_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> GRAY_MARBLE_PILLAR = register("gray_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GRAY_MARBLE_PILLAR_CAP = register("gray_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRAY_MARBLE_SMALL_BRICKS = register("gray_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GRAY_MARBLE_TILES = register("gray_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GRAY_POLISHED_MARBLE = register("gray_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── green_marble ─────
    public static final DeferredBlock<Block> GREEN_MARBLE = register("green_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_BRICKS = register("green_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR = register("green_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR_CAP = register("green_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_SMALL_BRICKS = register("green_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_MARBLE_TILES = register("green_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_POLISHED_MARBLE = register("green_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── jungle_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_JUNGLE_LEAVES = register("apple_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_JUNGLE_LEAVES = register("cherry_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_JUNGLE_LEAVES = register("dead_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_JUNGLE_LEAVES = register("frosted_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_JUNGLE_LEAVES = register("golden_apple_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_JUNGLE_LEAVES = register("golden_cherry_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_JUNGLE_LEAVES = register("golden_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_JUNGLE_LEAVES = register("magenta_flower_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_JUNGLE_LEAVES = register("orange_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_JUNGLE_LEAVES = register("red_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_JUNGLE_LEAVES = register("white_flower_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));

    // ───── light_blue_marble ─────
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE = register("light_blue_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_BRICKS = register("light_blue_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_BLUE_MARBLE_PILLAR = register("light_blue_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_BLUE_MARBLE_PILLAR_CAP = register("light_blue_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_SMALL_BRICKS = register("light_blue_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_TILES = register("light_blue_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_POLISHED_MARBLE = register("light_blue_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── light_gray_marble ─────
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE = register("light_gray_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_BRICKS = register("light_gray_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_GRAY_MARBLE_PILLAR = register("light_gray_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_GRAY_MARBLE_PILLAR_CAP = register("light_gray_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_SMALL_BRICKS = register("light_gray_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_TILES = register("light_gray_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_POLISHED_MARBLE = register("light_gray_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── lime_marble ─────
    public static final DeferredBlock<Block> LIME_MARBLE = register("lime_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_BRICKS = register("lime_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR = register("lime_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR_CAP = register("lime_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_SMALL_BRICKS = register("lime_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_MARBLE_TILES = register("lime_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_POLISHED_MARBLE = register("lime_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── magenta_marble ─────
    public static final DeferredBlock<Block> MAGENTA_MARBLE = register("magenta_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_BRICKS = register("magenta_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> MAGENTA_MARBLE_PILLAR = register("magenta_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> MAGENTA_MARBLE_PILLAR_CAP = register("magenta_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_SMALL_BRICKS = register("magenta_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_TILES = register("magenta_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> MAGENTA_POLISHED_MARBLE = register("magenta_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── oak_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_OAK_LEAVES = register("apple_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_OAK_LEAVES = register("cherry_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_OAK_LEAVES = register("dead_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_OAK_LEAVES = register("frosted_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_OAK_LEAVES = register("golden_apple_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_OAK_LEAVES = register("golden_cherry_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_OAK_LEAVES = register("golden_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_OAK_LEAVES = register("magenta_flower_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_OAK_LEAVES = register("orange_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_OAK_LEAVES = register("red_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_OAK_LEAVES = register("white_flower_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    // ───── ochre_froglight ─────
    public static final DeferredBlock<IronBarsBlock> GLASS_OCHRE_FROGLIGHT_PANE = register("glass_ochre_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // ───── orange_marble ─────
    public static final DeferredBlock<Block> ORANGE_MARBLE = register("orange_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_BRICKS = register("orange_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR = register("orange_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR_CAP = register("orange_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_SMALL_BRICKS = register("orange_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_TILES = register("orange_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_POLISHED_MARBLE = register("orange_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── pale_oak_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_PALE_OAK_LEAVES = register("apple_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_PALE_OAK_LEAVES = register("cherry_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_PALE_OAK_LEAVES = register("dead_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_PALE_OAK_LEAVES = register("frosted_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_PALE_OAK_LEAVES = register("golden_apple_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_PALE_OAK_LEAVES = register("golden_cherry_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_PALE_OAK_LEAVES = register("golden_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_PALE_OAK_LEAVES = register("magenta_flower_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_PALE_OAK_LEAVES = register("orange_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_PALE_OAK_LEAVES = register("red_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_PALE_OAK_LEAVES = register("white_flower_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    // ───── pearlescent_froglight ─────
    public static final DeferredBlock<IronBarsBlock> GLASS_PEARLESCENT_FROGLIGHT_PANE = register("glass_pearlescent_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // ───── pink_marble ─────
    public static final DeferredBlock<Block> PINK_MARBLE = register("pink_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_BRICKS = register("pink_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR = register("pink_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR_CAP = register("pink_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_SMALL_BRICKS = register("pink_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_MARBLE_TILES = register("pink_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_POLISHED_MARBLE = register("pink_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── purple_marble ─────
    public static final DeferredBlock<Block> PURPLE_MARBLE = register("purple_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_BRICKS = register("purple_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR = register("purple_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR_CAP = register("purple_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_SMALL_BRICKS = register("purple_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_TILES = register("purple_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_POLISHED_MARBLE = register("purple_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── red_marble ─────
    public static final DeferredBlock<Block> RED_MARBLE = register("red_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_BRICKS = register("red_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR = register("red_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR_CAP = register("red_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_SMALL_BRICKS = register("red_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_MARBLE_TILES = register("red_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_POLISHED_MARBLE = register("red_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── spruce_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_SPRUCE_LEAVES = register("apple_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_SPRUCE_LEAVES = register("cherry_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_SPRUCE_LEAVES = register("dead_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_SPRUCE_LEAVES = register("frosted_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_SPRUCE_LEAVES = register("golden_apple_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_SPRUCE_LEAVES = register("golden_cherry_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_SPRUCE_LEAVES = register("golden_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_SPRUCE_LEAVES = register("magenta_flower_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_SPRUCE_LEAVES = register("orange_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_SPRUCE_LEAVES = register("red_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_SPRUCE_LEAVES = register("white_flower_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    // ───── stone ─────
    public static final DeferredBlock<RotatedPillarBlock> CHISELED_PLASTERED_STONE_PILLAR = register("chiseled_plastered_stone_pillar", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> SLATED_STONE = register("slated_stone", () -> new RotatedPillarBlock(ST));

    // ───── verdant_froglight ─────
    public static final DeferredBlock<IronBarsBlock> GLASS_VERDANT_FROGLIGHT_PANE = register("glass_verdant_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // ───── white_marble ─────
    public static final DeferredBlock<Block> WHITE_MARBLE = register("white_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_BRICKS = register("white_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR = register("white_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR_CAP = register("white_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_SMALL_BRICKS = register("white_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_MARBLE_TILES = register("white_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_POLISHED_MARBLE = register("white_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── yellow_marble ─────
    public static final DeferredBlock<Block> YELLOW_MARBLE = register("yellow_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_BRICKS = register("yellow_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR = register("yellow_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR_CAP = register("yellow_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_SMALL_BRICKS = register("yellow_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_TILES = register("yellow_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_POLISHED_MARBLE = register("yellow_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── windows (by wood type) ─────
    public static final DeferredBlock<Block> ACACIA_WINDOW_BARS = register("acacia_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_BARS_PANE = register("acacia_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_COVERED = register("acacia_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_COVERED_PANE = register("acacia_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_DIAGONAL = register("acacia_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_DIAGONAL_PANE = register("acacia_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_LARGE = register("acacia_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_LARGE_PANE = register("acacia_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_PANES = register("acacia_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_PANES_PANE = register("acacia_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_ROUNDED = register("acacia_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_ROUNDED_PANE = register("acacia_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SLIM = register("acacia_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_SLIM_PANE = register("acacia_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SWIRLING = register("acacia_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_SWIRLING_PANE = register("acacia_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_TILES = register("acacia_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_TILES_PANE = register("acacia_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_BARS = register("bamboo_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_BARS_PANE = register("bamboo_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_COVERED = register("bamboo_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_COVERED_PANE = register("bamboo_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_DIAGONAL = register("bamboo_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_DIAGONAL_PANE = register("bamboo_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_LARGE = register("bamboo_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_LARGE_PANE = register("bamboo_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_PANES = register("bamboo_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_PANES_PANE = register("bamboo_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_ROUNDED = register("bamboo_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_ROUNDED_PANE = register("bamboo_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SLIM = register("bamboo_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_SLIM_PANE = register("bamboo_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SWIRLING = register("bamboo_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_SWIRLING_PANE = register("bamboo_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_TILES = register("bamboo_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_TILES_PANE = register("bamboo_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_BARS = register("birch_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_BARS_PANE = register("birch_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_COVERED = register("birch_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_COVERED_PANE = register("birch_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_DIAGONAL = register("birch_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_DIAGONAL_PANE = register("birch_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_LARGE = register("birch_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_LARGE_PANE = register("birch_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_PANES = register("birch_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_PANES_PANE = register("birch_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_ROUNDED = register("birch_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_ROUNDED_PANE = register("birch_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SLIM = register("birch_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_SLIM_PANE = register("birch_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SWIRLING = register("birch_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_SWIRLING_PANE = register("birch_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_TILES = register("birch_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_TILES_PANE = register("birch_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_BARS = register("cherry_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_BARS_PANE = register("cherry_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_COVERED = register("cherry_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_COVERED_PANE = register("cherry_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_DIAGONAL = register("cherry_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_DIAGONAL_PANE = register("cherry_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_LARGE = register("cherry_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_LARGE_PANE = register("cherry_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_PANES = register("cherry_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_PANES_PANE = register("cherry_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_ROUNDED = register("cherry_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_ROUNDED_PANE = register("cherry_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SLIM = register("cherry_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_SLIM_PANE = register("cherry_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SWIRLING = register("cherry_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_SWIRLING_PANE = register("cherry_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_TILES = register("cherry_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_TILES_PANE = register("cherry_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_BARS = register("crimson_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_BARS_PANE = register("crimson_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_COVERED = register("crimson_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_COVERED_PANE = register("crimson_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_DIAGONAL = register("crimson_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_DIAGONAL_PANE = register("crimson_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_LARGE = register("crimson_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_LARGE_PANE = register("crimson_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_PANES = register("crimson_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_PANES_PANE = register("crimson_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_ROUNDED = register("crimson_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_ROUNDED_PANE = register("crimson_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SLIM = register("crimson_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_SLIM_PANE = register("crimson_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SWIRLING = register("crimson_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_SWIRLING_PANE = register("crimson_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_TILES = register("crimson_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_TILES_PANE = register("crimson_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_BARS = register("dark_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_BARS_PANE = register("dark_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_COVERED = register("dark_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_COVERED_PANE = register("dark_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_DIAGONAL = register("dark_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_DIAGONAL_PANE = register("dark_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_LARGE = register("dark_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_LARGE_PANE = register("dark_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_PANES = register("dark_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_PANES_PANE = register("dark_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_ROUNDED = register("dark_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_ROUNDED_PANE = register("dark_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SLIM = register("dark_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_SLIM_PANE = register("dark_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SWIRLING = register("dark_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_SWIRLING_PANE = register("dark_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_TILES = register("dark_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_TILES_PANE = register("dark_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_BARS = register("jungle_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_BARS_PANE = register("jungle_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_COVERED = register("jungle_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_COVERED_PANE = register("jungle_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_DIAGONAL = register("jungle_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_DIAGONAL_PANE = register("jungle_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_LARGE = register("jungle_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_LARGE_PANE = register("jungle_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_PANES = register("jungle_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_PANES_PANE = register("jungle_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_ROUNDED = register("jungle_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_ROUNDED_PANE = register("jungle_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SLIM = register("jungle_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_SLIM_PANE = register("jungle_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SWIRLING = register("jungle_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_SWIRLING_PANE = register("jungle_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_TILES = register("jungle_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_TILES_PANE = register("jungle_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_BARS = register("mangrove_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_BARS_PANE = register("mangrove_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_COVERED = register("mangrove_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_COVERED_PANE = register("mangrove_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_DIAGONAL = register("mangrove_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_DIAGONAL_PANE = register("mangrove_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_LARGE = register("mangrove_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_LARGE_PANE = register("mangrove_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_PANES = register("mangrove_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_PANES_PANE = register("mangrove_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_ROUNDED = register("mangrove_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_ROUNDED_PANE = register("mangrove_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SLIM = register("mangrove_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_SLIM_PANE = register("mangrove_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SWIRLING = register("mangrove_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_SWIRLING_PANE = register("mangrove_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_TILES = register("mangrove_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_TILES_PANE = register("mangrove_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_BARS = register("oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_BARS_PANE = register("oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_COVERED = register("oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_COVERED_PANE = register("oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_DIAGONAL = register("oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_DIAGONAL_PANE = register("oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_LARGE = register("oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_LARGE_PANE = register("oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_PANES = register("oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_PANES_PANE = register("oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_ROUNDED = register("oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_ROUNDED_PANE = register("oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SLIM = register("oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_SLIM_PANE = register("oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SWIRLING = register("oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_SWIRLING_PANE = register("oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_TILES = register("oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_TILES_PANE = register("oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS = register("pale_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_BARS_PANE = register("pale_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED = register("pale_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_COVERED_PANE = register("pale_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL = register("pale_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_DIAGONAL_PANE = register("pale_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE = register("pale_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_LARGE_PANE = register("pale_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES = register("pale_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_PANES_PANE = register("pale_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED = register("pale_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_ROUNDED_PANE = register("pale_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM = register("pale_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SLIM_PANE = register("pale_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING = register("pale_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SWIRLING_PANE = register("pale_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES = register("pale_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_TILES_PANE = register("pale_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_BARS = register("spruce_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_BARS_PANE = register("spruce_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_COVERED = register("spruce_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_COVERED_PANE = register("spruce_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_DIAGONAL = register("spruce_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_DIAGONAL_PANE = register("spruce_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_LARGE = register("spruce_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_LARGE_PANE = register("spruce_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_PANES = register("spruce_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_PANES_PANE = register("spruce_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_ROUNDED = register("spruce_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_ROUNDED_PANE = register("spruce_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SLIM = register("spruce_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_SLIM_PANE = register("spruce_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SWIRLING = register("spruce_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_SWIRLING_PANE = register("spruce_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_TILES = register("spruce_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_TILES_PANE = register("spruce_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_BARS = register("warped_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_BARS_PANE = register("warped_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_COVERED = register("warped_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_COVERED_PANE = register("warped_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_DIAGONAL = register("warped_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_DIAGONAL_PANE = register("warped_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_LARGE = register("warped_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_LARGE_PANE = register("warped_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_PANES = register("warped_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_PANES_PANE = register("warped_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_ROUNDED = register("warped_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_ROUNDED_PANE = register("warped_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SLIM = register("warped_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_SLIM_PANE = register("warped_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SWIRLING = register("warped_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_SWIRLING_PANE = register("warped_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_TILES = register("warped_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_TILES_PANE = register("warped_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    // ───── misc ─────
    public static final DeferredBlock<Block> BAMBOO_THATCH = register("bamboo_thatch", () -> new Block(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> PINK_SALT_BLOCK = register("pink_salt_block", () -> new Block(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> POLISHED_PINK_SALT_BLOCK = register("polished_pink_salt_block", () -> new Block(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> ROOFING_SLATES = register("roofing_slates", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHEAT_THATCH = register("wheat_thatch", () -> new Block(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));

    public static final Map<String, DeferredBlock<Block>> CTM_BLOCKS = new LinkedHashMap<>();

    private static void registerCtmBlocksFromTsv() {
        var stream = OttBlocks.class.getClassLoader().getResourceAsStream("assets/ott/ctm_blocks.tsv");
        if (stream == null) throw new IllegalStateException("Missing assets/ott/ctm_blocks.tsv");
        try (var r = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            r.readLine(); // skip header
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isBlank() || line.startsWith("#")) continue;
                String[] parts = line.split("\t", 3);
                if (parts.length < 2 || parts[0].isBlank() || parts[1].isBlank()) continue;
                String name     = parts[0].strip();
                String material = parts[1].strip();
                if (CTM_BLOCKS.containsKey(name)) continue; // avoid double-registration
                DeferredBlock<Block> db = registerCtmBlock(name, material);
                CTM_BLOCKS.put(name, db);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read ctm_blocks.tsv", e);
        }
    }

    private static DeferredBlock<Block> registerCtmBlock(String name, String material) {
        boolean transparent = material.equals("glass") || material.equals("tinted_glass")
                || material.endsWith("_stained_glass");
        boolean crying = material.equals("crying_obsidian");
        if (crying) {
            return register(name, () -> {
                Block base = resolveCtmBase(material);
                return new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(base));
            });
        } else if (transparent) {
            return register(name, () -> {
                Block base = resolveCtmBase(material);
                return new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(base));
            });
        } else {
            return register(name, () -> {
                Block base = resolveCtmBase(material);
                return new Block(BlockBehaviour.Properties.ofFullCopy(base));
            });
        }
    }

    private static Block resolveCtmBase(String material) {
        net.minecraft.resources.ResourceLocation vanillaRl =
                net.minecraft.resources.ResourceLocation.withDefaultNamespace(material);
        Block vanilla = net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(vanillaRl);
        if (vanilla != Blocks.AIR) return vanilla;
        net.minecraft.resources.ResourceLocation ottRl =
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", material);
        Block ott = net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(ottRl);
        if (ott != Blocks.AIR) return ott;
        return Blocks.STONE; // safe fallback
    }

    public static void register(IEventBus eventBus) {
        OttTemplateBlocks.init();          // queue all template blocks (wool, carpet, cube_all, glass…)
        registerCtmBlocksFromTsv();        // queue CTM blocks + panes from ctm_blocks.tsv
        registerCtmBlocksFromTsv();        // register all CTM blocks from ctm_blocks.tsv
        registerChains();                  // queue decorative chains (loop, not <clinit> fields)
        registerRedstoneLamps();           // queue decorative redstone lamps (loop, not <clinit> fields)
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

    private static void registerRedstoneLamps() {
        readCsv("assets/ott/redstone_lamps.csv", name -> {
            DeferredBlock<net.minecraft.world.level.block.RedstoneLampBlock> b = BLOCKS.register(name,
                    () -> new net.minecraft.world.level.block.RedstoneLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP)));
            ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(b.get(), new net.minecraft.world.item.Item.Properties()));
            REDSTONE_LAMPS.put(name, b);
        });
    }

    private static void registerChains() {
        readCsv("assets/ott/chains.csv", name -> {
            DeferredBlock<net.minecraft.world.level.block.ChainBlock> b = BLOCKS.register(name,
                    () -> new net.minecraft.world.level.block.ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)));
            ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(b.get(), new net.minecraft.world.item.Item.Properties()));
            CHAINS.put(name, b);
        });
    }

    
    }