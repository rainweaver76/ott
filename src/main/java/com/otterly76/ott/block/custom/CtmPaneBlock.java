package com.otterly76.ott.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

/**
 * A glass pane that only extends arms toward same-type panes (and solid/wall blocks).
 * Prevents different CTM pane types from geometrically connecting to one another.
 */
public class CtmPaneBlock extends IronBarsBlock {

    public static final MapCodec<CtmPaneBlock> CODEC = simpleCodec(CtmPaneBlock::new);

    public CtmPaneBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull MapCodec<? extends IronBarsBlock> codec() {
        return CODEC;
    }

    // Suppress UP and DOWN edge faces when a same-type pane is directly above or below.
    // Without this, the arm's top/bottom #edge face shows as a stripe at every block boundary.
    // The glass body CTM tiles handle vertical seamlessness via T/B connectivity bits, so
    // hiding the edge faces at junctions does not expose any glass body border artifact.
    @Override
    public boolean skipRendering(@NotNull BlockState state, @NotNull BlockState adjacentState, @NotNull Direction side) {
        if ((side == Direction.UP || side == Direction.DOWN) && adjacentState.is(this)) return true;
        return super.skipRendering(state, adjacentState, side);
    }

    // attachsTo() is final in IronBarsBlock, so we override the two callers instead.

    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockGetter level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = level.getFluidState(pos);
        BlockPos northPos = pos.north(), southPos = pos.south(), westPos = pos.west(), eastPos = pos.east();
        BlockState northState = level.getBlockState(northPos);
        BlockState southState = level.getBlockState(southPos);
        BlockState westState  = level.getBlockState(westPos);
        BlockState eastState  = level.getBlockState(eastPos);
        return this.defaultBlockState()
            .setValue(NORTH, myAttachsTo(northState, northState.isFaceSturdy(level, northPos, Direction.SOUTH)))
            .setValue(SOUTH, myAttachsTo(southState, southState.isFaceSturdy(level, southPos, Direction.NORTH)))
            .setValue(WEST,  myAttachsTo(westState,  westState.isFaceSturdy(level, westPos,  Direction.EAST)))
            .setValue(EAST,  myAttachsTo(eastState,  eastState.isFaceSturdy(level, eastPos,  Direction.WEST)))
            .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    protected @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction,
                                              @NotNull BlockState neighborState, @NotNull LevelAccessor level,
                                              @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return direction.getAxis().isHorizontal()
            ? state.setValue(PROPERTY_BY_DIRECTION.get(direction),
                myAttachsTo(neighborState, neighborState.isFaceSturdy(level, neighborPos, direction.getOpposite())))
            : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    /**
     * Connects to: solid-faced blocks (excluding barrier/leaves/etc.), any pane/bar block
     * (IronBarsBlock subclasses — vanilla glass panes, CTM panes, iron bars, etc.), and walls.
     */
    private boolean myAttachsTo(BlockState neighbor, boolean solidSide) {
        return !Block.isExceptionForConnection(neighbor) && solidSide
            || neighbor.getBlock() instanceof IronBarsBlock
            || neighbor.is(BlockTags.WALLS);
    }
}