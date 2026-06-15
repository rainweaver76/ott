package com.otterly76.ott.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class PaxelItem extends DiggerItem {

    private static final Set<ItemAbility> PAXEL_ACTIONS;
    static {
        PAXEL_ACTIONS = new HashSet<>();
        PAXEL_ACTIONS.addAll(ItemAbilities.DEFAULT_PICKAXE_ACTIONS);
        PAXEL_ACTIONS.addAll(ItemAbilities.DEFAULT_AXE_ACTIONS);
        PAXEL_ACTIONS.addAll(ItemAbilities.DEFAULT_SHOVEL_ACTIONS);
        PAXEL_ACTIONS.addAll(ItemAbilities.DEFAULT_SWORD_ACTIONS);
    }

    /**
     * A combined pickaxe + axe + shovel + sword tool definition. In 1.21.1 the mining speed and
     * "correct tool for drops" both come from a {@link Tool} component, so we build one that covers
     * every block category the paxel should "count" for. Rules are evaluated in order; the first
     * matching rule supplies the speed / drop-correctness for a given block.
     * <p>
     * {@code DiggerItem} bakes a pickaxe-only component onto the item and cannot be told to use this
     * one, so {@link #getDestroySpeed} and {@link #isCorrectToolForDrops} are routed through it directly.
     */
    private final Tool paxelTool;

    public PaxelItem(Tier tier, Item.Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
        this.paxelTool = new Tool(
                List.of(
                        // Blocks too hard for this tier never drop (e.g. obsidian for a stone paxel).
                        Tool.Rule.deniesDrops(tier.getIncorrectBlocksForDrops()),
                        // Sword behaviour: instantly shears cobwebs and they drop.
                        Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F),
                        // Pickaxe / axe / shovel: mine at full tier speed and count as the correct tool.
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, tier.getSpeed()),
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, tier.getSpeed()),
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_SHOVEL, tier.getSpeed()),
                        // Sword behaviour: extra speed on leaves / plants / other sword-efficient blocks.
                        Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)
                ),
                1.0F,
                1
        );
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return this.paxelTool.getMiningSpeed(state);
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, @NotNull BlockState state) {
        return this.paxelTool.isCorrectForDrops(state);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility ability) {
        return PAXEL_ACTIONS.contains(ability);
    }
}
