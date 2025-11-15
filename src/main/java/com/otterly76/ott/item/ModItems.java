package com.otterly76.ott.item;

import com.otterly76.ott.Constants;
import com.otterly76.ott.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    static {
        ModBlocks.getAllGradientBlocks().forEach(block -> ITEMS.register(block.getId().getPath(), () -> new GradientItem<>(new Item.Properties(), block.get())));
    }

    public static final DeferredItem<Item> OTTER = ITEMS.register("otter", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_00 = registerBlockItem("testblock_00", ModBlocks.TESTBLOCK_00);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_01 = registerBlockItem("testblock_01", ModBlocks.TESTBLOCK_01);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_02 = registerBlockItem("testblock_02", ModBlocks.TESTBLOCK_02);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_03 = registerBlockItem("testblock_03", ModBlocks.TESTBLOCK_03);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_10 = registerBlockItem("testblock_10", ModBlocks.TESTBLOCK_10);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_11 = registerBlockItem("testblock_11", ModBlocks.TESTBLOCK_11);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_12 = registerBlockItem("testblock_12", ModBlocks.TESTBLOCK_12);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_13 = registerBlockItem("testblock_13", ModBlocks.TESTBLOCK_13);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_20 = registerBlockItem("testblock_20", ModBlocks.TESTBLOCK_20);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_21 = registerBlockItem("testblock_21", ModBlocks.TESTBLOCK_21);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_22 = registerBlockItem("testblock_22", ModBlocks.TESTBLOCK_22);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_23 = registerBlockItem("testblock_23", ModBlocks.TESTBLOCK_23);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_30 = registerBlockItem("testblock_30", ModBlocks.TESTBLOCK_30);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_31 = registerBlockItem("testblock_31", ModBlocks.TESTBLOCK_31);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_32 = registerBlockItem("testblock_32", ModBlocks.TESTBLOCK_32);
    public static final DeferredHolder<Item, BlockItem> TESTBLOCK_33 = registerBlockItem("testblock_33", ModBlocks.TESTBLOCK_33);

    public static final DeferredHolder<Item, BlockItem> LIMESTONE_00 = registerBlockItem("limestone_00", ModBlocks.LIMESTONE_00);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_01 = registerBlockItem("limestone_01", ModBlocks.LIMESTONE_01);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_02 = registerBlockItem("limestone_02", ModBlocks.LIMESTONE_02);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_03 = registerBlockItem("limestone_03", ModBlocks.LIMESTONE_03);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_10 = registerBlockItem("limestone_10", ModBlocks.LIMESTONE_10);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_11 = registerBlockItem("limestone_11", ModBlocks.LIMESTONE_11);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_12 = registerBlockItem("limestone_12", ModBlocks.LIMESTONE_12);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_13 = registerBlockItem("limestone_13", ModBlocks.LIMESTONE_13);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_20 = registerBlockItem("limestone_20", ModBlocks.LIMESTONE_20);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_21 = registerBlockItem("limestone_21", ModBlocks.LIMESTONE_21);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_22 = registerBlockItem("limestone_22", ModBlocks.LIMESTONE_22);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_23 = registerBlockItem("limestone_23", ModBlocks.LIMESTONE_23);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_30 = registerBlockItem("limestone_30", ModBlocks.LIMESTONE_30);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_31 = registerBlockItem("limestone_31", ModBlocks.LIMESTONE_31);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_32 = registerBlockItem("limestone_32", ModBlocks.LIMESTONE_32);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_33 = registerBlockItem("limestone_33", ModBlocks.LIMESTONE_33);

    private static DeferredHolder<Item, BlockItem> registerBlockItem(String name, DeferredBlock<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}