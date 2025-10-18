package com.otterly76.blockparty.block;

import com.otterly76.blockparty.Constants;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);
    public static final DeferredHolder<Block, Block> GRADIENT_BLOCK = BLOCKS.register("gradient_block", registryName -> new GradientBlock());
}