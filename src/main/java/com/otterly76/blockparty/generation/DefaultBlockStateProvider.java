package com.otterly76.blockparty.generation;

import com.otterly76.blockparty.Constants;
import com.otterly76.blockparty.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

public class DefaultBlockStateProvider extends BlockStateProvider {

    public DefaultBlockStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, Constants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.getAllConcreteBlocks().forEach(this::registerStatesAndModelsFor);
    }

    private void registerStatesAndModelsFor(DeferredBlock<Block> block) {
        final ModelFile blockModel = models().cubeAll("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), modLoc("block/concrete/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
        simpleBlock(block.get(), blockModel);
    }

    @NotNull
    @Override
    public String getName() {
        return "Default BlockStates Provider";
    }
}
