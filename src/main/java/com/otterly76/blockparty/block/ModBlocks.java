package com.otterly76.blockparty.block;

import com.otterly76.blockparty.Constants;
import com.otterly76.blockparty.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    private static final List<DeferredBlock<Block>> ALL_CONCRETE_BLOCKS = new ArrayList<>();

    static {
        for (final DyeColor color1 : DyeColor.values()) {
            for (final DyeColor color2 : DyeColor.values()) {
                if (color1 != color2) {
                    final String fullName = String.format("%s2%s_concrete", color1.getName(), color2.getName());
                    ALL_CONCRETE_BLOCKS.add(registerBlock(fullName,
                            () -> new Block(BlockBehaviour.Properties.of()
                                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE))));
                }
            }
        }
    }

    public static Collection<DeferredBlock<Block>> getAllConcreteBlocks() {
        return ALL_CONCRETE_BLOCKS;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}