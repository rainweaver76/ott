package com.otterly76.ott.block.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.ldtteam.domumornamentum.block.AbstractBlockPane;
import com.ldtteam.domumornamentum.block.ICachedItemGroupBlock;
import com.ldtteam.domumornamentum.block.IMateriallyTexturedBlock;
import com.ldtteam.domumornamentum.block.IMateriallyTexturedBlockComponent;
import com.ldtteam.domumornamentum.block.components.SimpleRetexturableComponent;
import com.ldtteam.domumornamentum.entity.block.MateriallyTexturedBlockEntity;
import com.ldtteam.domumornamentum.recipe.architectscutter.ArchitectsCutterRecipeBuilder;
import com.ldtteam.domumornamentum.util.BlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A DO-style glass pane block that connects N/S/E/W and accepts any glass block as
 * its material via the Architect's Cutter.
 */
public class OttGlassPaneBlock extends AbstractBlockPane<OttGlassPaneBlock>
        implements IMateriallyTexturedBlock, ICachedItemGroupBlock, EntityBlock
{
    // Use c:glass_blocks so only plain vanilla glass appears in the Architect's Cutter.
    // OTT specialty glass is excluded from c:glass_blocks, so CTM blocks and architectural
    // glass won't appear as valid inputs.
    private static final TagKey<Block> GLASS_MATERIALS =
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass_blocks"));

    public static final List<IMateriallyTexturedBlockComponent> COMPONENTS =
            ImmutableList.<IMateriallyTexturedBlockComponent>builder()
                    .add(new SimpleRetexturableComponent(
                            ResourceLocation.withDefaultNamespace("block/glass"),
                            GLASS_MATERIALS,
                            Blocks.GLASS))
                    .build();

    private final List<ItemStack> fillItemGroupCache = Lists.newArrayList();

    public OttGlassPaneBlock()
    {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE)
                .mapColor(MapColor.NONE)
                .isRedstoneConductor((state, getter, pos) -> false));
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }

    @Override
    public @NotNull List<IMateriallyTexturedBlockComponent> getComponents()
    {
        return COMPONENTS;
    }

    @Override
    public IMateriallyTexturedBlockComponent getMainComponent()
    {
        return COMPONENTS.getFirst();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(final @NotNull BlockPos blockPos, final @NotNull BlockState blockState)
    {
        return new MateriallyTexturedBlockEntity(blockPos, blockState);
    }

    @Override
    public void resetCache()
    {
        fillItemGroupCache.clear();
    }

    @NotNull
    @Override
    public ItemStack getCloneItemStack(final @NotNull BlockState state, final @NotNull HitResult target,
                                       final @NotNull LevelReader world, final @NotNull BlockPos pos,
                                       final @NotNull Player player)
    {
        return BlockUtils.getMaterializedItemStack(world.getBlockEntity(pos), world.registryAccess());
    }

    @Override
    public void buildRecipes(final @NotNull RecipeOutput recipeOutput)
    {
        new ArchitectsCutterRecipeBuilder(this, RecipeCategory.DECORATIONS)
                .count(COMPONENTS.size() * 3)
                .save(recipeOutput);
    }

    @Override
    public float getExplosionResistance(@NotNull BlockState state, @NotNull BlockGetter level,
                                        @NotNull BlockPos pos, @NotNull Explosion explosion)
    {
        return getDOExplosionResistance(super::getExplosionResistance, state, level, pos, explosion);
    }

    @Override
    public float getDestroyProgress(final @NotNull BlockState state, final @NotNull Player player,
                                    final @NotNull BlockGetter level, final @NotNull BlockPos pos)
    {
        return getDODestroyProgress(super::getDestroyProgress, state, player, level, pos);
    }

    @NotNull
    @Override
    public SoundType getSoundType(final @NotNull BlockState state, final @NotNull LevelReader level,
                                  final @NotNull BlockPos pos, final @Nullable Entity entity)
    {
        return getDOSoundType(super::getSoundType, state, level, pos, entity);
    }

    @Override
    public void fillItemCategory(final @NotNull NonNullList<ItemStack> items)
    {
        fillDOItemCategory(this, items, fillItemGroupCache);
    }
}
