package com.otterly76.ott_blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Entry point for the {@code ott_blocks} mod.
 *
 * <p>This is the bottom layer of the two-mod split: it owns all block content but never depends on the
 * functional {@code ott} mod. Crucially, all blocks register under the shared <b>{@code ott}</b> namespace
 * (NeoForge allows any mod to register into any namespace), so block IDs, asset paths and existing worlds
 * are unaffected by the split.</p>
 *
 * <p>Batch 1 of the split only proves the multi-mod build pipeline with a single throwaway block
 * ({@code ott:split_test}). Real block content is migrated in later waves.</p>
 */
@Mod(OttBlocksMod.MOD_ID)
public class OttBlocksMod {
    /** The loader-facing mod id. */
    public static final String MOD_ID = "ott_blocks";
    /** The namespace all block content registers under (shared with the {@code ott} mod). */
    public static final String CONTENT_NAMESPACE = "ott";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CONTENT_NAMESPACE);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CONTENT_NAMESPACE);

    // --- Batch 1 skeleton-proof block (throwaway; removed once a real wave lands) ---
    public static final DeferredBlock<Block> SPLIT_TEST = BLOCKS.register("split_test",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final DeferredItem<BlockItem> SPLIT_TEST_ITEM = ITEMS.registerSimpleBlockItem("split_test", SPLIT_TEST);

    public OttBlocksMod(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(SPLIT_TEST_ITEM);
        }
    }
}
