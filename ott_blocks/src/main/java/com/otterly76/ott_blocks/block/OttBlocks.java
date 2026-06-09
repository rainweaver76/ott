package com.otterly76.ott_blocks.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * Block registrar for the {@code ott_blocks} mod. Owns all migrated full-cube decorative blocks,
 * registered under the shared <b>{@code ott}</b> namespace so block IDs/assets/worlds are unchanged.
 *
 * <p>Each {@link #register} also registers a plain {@link net.minecraft.world.item.BlockItem} under the
 * same id, replacing the old per-block {@code ModItems.registerBlockItem} call in {@code ott}.</p>
 */
public class OttBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("ott");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("ott");

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> b = BLOCKS.register(name, block);
        ITEMS.registerSimpleBlockItem(name, b);
        return b;
    }

    // ===== MARBLE (wave 1) =====
    // (marble block fields inserted here)
    public static final DeferredBlock<Block> BLACK_MARBLE = register("black_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_BRICKS = register("black_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_MARBLE_SMALL_BRICKS = register("black_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_MARBLE_TILES = register("black_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_POLISHED_MARBLE = register("black_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR = register("black_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR_CAP = register("black_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE = register("white_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_BRICKS = register("white_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_MARBLE_SMALL_BRICKS = register("white_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_MARBLE_TILES = register("white_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_POLISHED_MARBLE = register("white_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR = register("white_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR_CAP = register("white_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_DIAMOND_PAVERS = register("white_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_DIAMOND_PAVERS = register("black_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE = register("amethyst_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_BRICKS = register("amethyst_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_SMALL_BRICKS = register("amethyst_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_TILES = register("amethyst_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> AMETHYST_POLISHED_MARBLE = register("amethyst_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> AMETHYST_MARBLE_PILLAR = register("amethyst_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> AMETHYST_MARBLE_PILLAR_CAP = register("amethyst_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE = register("blue_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_BRICKS = register("blue_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_MARBLE_SMALL_BRICKS = register("blue_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_MARBLE_TILES = register("blue_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_POLISHED_MARBLE = register("blue_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR = register("blue_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR_CAP = register("blue_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE = register("cyan_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_BRICKS = register("cyan_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_MARBLE_SMALL_BRICKS = register("cyan_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_MARBLE_TILES = register("cyan_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_POLISHED_MARBLE = register("cyan_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR = register("cyan_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR_CAP = register("cyan_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE = register("green_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_BRICKS = register("green_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_MARBLE_SMALL_BRICKS = register("green_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_MARBLE_TILES = register("green_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_POLISHED_MARBLE = register("green_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR = register("green_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR_CAP = register("green_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE = register("lime_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_BRICKS = register("lime_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_MARBLE_SMALL_BRICKS = register("lime_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_MARBLE_TILES = register("lime_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_POLISHED_MARBLE = register("lime_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR = register("lime_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR_CAP = register("lime_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE = register("orange_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_BRICKS = register("orange_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_SMALL_BRICKS = register("orange_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_TILES = register("orange_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_POLISHED_MARBLE = register("orange_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR = register("orange_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR_CAP = register("orange_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE = register("pink_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_BRICKS = register("pink_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_MARBLE_SMALL_BRICKS = register("pink_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_MARBLE_TILES = register("pink_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_POLISHED_MARBLE = register("pink_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR = register("pink_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR_CAP = register("pink_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE = register("purple_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_BRICKS = register("purple_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_SMALL_BRICKS = register("purple_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_TILES = register("purple_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_POLISHED_MARBLE = register("purple_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR = register("purple_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR_CAP = register("purple_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE = register("red_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_BRICKS = register("red_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_MARBLE_SMALL_BRICKS = register("red_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_MARBLE_TILES = register("red_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_POLISHED_MARBLE = register("red_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR = register("red_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR_CAP = register("red_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE = register("yellow_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_BRICKS = register("yellow_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_SMALL_BRICKS = register("yellow_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_TILES = register("yellow_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_POLISHED_MARBLE = register("yellow_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR = register("yellow_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR_CAP = register("yellow_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_DIAMOND_PAVERS = register("amethyst_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_DIAMOND_PAVERS = register("blue_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_DIAMOND_PAVERS = register("cyan_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_DIAMOND_PAVERS = register("green_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_DIAMOND_PAVERS = register("lime_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_DIAMOND_PAVERS = register("orange_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_DIAMOND_PAVERS = register("pink_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_DIAMOND_PAVERS = register("purple_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_DIAMOND_PAVERS = register("red_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_DIAMOND_PAVERS = register("yellow_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
