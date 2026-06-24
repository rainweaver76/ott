package com.otterly76.ott.engraving;

import com.otterly76.ott.Constants;
import com.otterly76.ott.block.ModBlocks;
import com.otterly76.ott.util.ModTags;
import com.otterly76.ott_blocks.block.OttBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

/**
 * Single source of truth for "everything you can make at the engraving table".
 * {@link #enumerate} walks every engraving in canonical order; a {@link Sink} decides what to do
 * with each (emit a recipe at datagen via ModRecipeProvider, or collect the output for the creative tab).
 * The enumeration body was lifted verbatim from ModRecipeProvider's engraveRecipes /
 * recoveredWaveRecipes / stainedGlassGroupRecipes (engraveX(exporter,…) -> s.x(…)).
 */
public final class EngravingEntries {
    private EngravingEntries() {}

    /** Receives each engraving as (input, output, recipeId). */
    public interface Sink {
        void one(ItemLike input, ItemLike output, String id);
        void tagged(TagKey<Item> tag, ItemLike output, String id);
        void group(Ingredient ingredient, ItemLike output, String id);
    }

    /** {@code ott:material/<name>} item tag key used to group engraving inputs. */
    static TagKey<Item> materialTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/" + name));
    }

    /** Every engraving, in canonical (definition) order. */
    public static void enumerate(Sink s) {
        enumerateSolid(s);
        enumerateGlass(s);
    }

    private static void enumerateSolid(Sink s) {
        // ═══════ per-material engravings (alphabetical) ═══════
        // ── acacia_planks ──
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_BEAMS.get(), "acacia_planks_beams_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_BRICKS.get(), "acacia_planks_bricks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_BRICK_PATTERN.get(), "acacia_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_BRICK_PAVING.get(), "acacia_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_CRATE.get(), "acacia_planks_crate_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_DIAGONAL_STRIPES.get(), "acacia_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_DIAGONAL_TILES.get(), "acacia_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_DOTTED.get(), "acacia_planks_dotted_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_FLOORING.get(), "acacia_planks_flooring_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_LARGE_TILES.get(), "acacia_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_PANEL, "acacia_planks_panel_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_PATTERN.get(), "acacia_planks_pattern_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_ROTATED_BRICKS.get(), "acacia_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_SMALL_BRICKS.get(), "acacia_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_SMALL_TILES.get(), "acacia_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_SQUARES.get(), "acacia_planks_squares_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_TILES.get(), "acacia_planks_tiles_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_TILES_STATIC, "acacia_planks_tiles_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_WAVY.get(), "acacia_planks_wavy_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ACACIA_PLANKS_WOVEN.get(), "acacia_planks_woven_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.CORNERED_ACACIA_PLANKS, "cornered_acacia_planks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.CRATED_ACACIA_PLANKS, "crated_acacia_planks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.ENCLOSED_ACACIA_PLANKS, "enclosed_acacia_planks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.FRAMED_ACACIA_PLANKS, "framed_acacia_planks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.NATURAL_ACACIA_PLANKS, "natural_acacia_planks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.PEGGED_ACACIA_PLANKS, "pegged_acacia_planks_ctm_engraving");
        s.tagged( materialTag("acacia_planks"), OttBlocks.WHIRLWIND_ACACIA_PLANKS, "whirlwind_acacia_planks_ctm_engraving");
        // ── amethyst_block ──
        s.one( Blocks.AMETHYST_BLOCK, OttBlocks.AMETHYST_BLOCK_CTM.get(), "amethyst_block_pillar_engraving");
        s.one( Blocks.AMETHYST_BLOCK, OttBlocks.CURLY_AMETHYST_BLOCK_CTM, "curly_amethyst_block_pillar_engraving");
        s.one( Blocks.AMETHYST_BLOCK, OttBlocks.FINE_AMETHYST_BLOCK_CTM, "fine_amethyst_block_pillar_engraving");
        s.one( Blocks.AMETHYST_BLOCK, OttBlocks.ORNATE_AMETHYST_BLOCK_CTM, "ornate_amethyst_block_pillar_engraving");
        s.one( Blocks.AMETHYST_BLOCK, OttBlocks.SIMPLE_AMETHYST_BLOCK_CTM, "simple_amethyst_block_pillar_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_BEAMS.get(), "amethyst_block_beams_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES.get(), "amethyst_block_bordered_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_BRICKS.get(), "amethyst_block_bricks_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_CUT.get(), "amethyst_block_cut_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_EDGED.get(), "amethyst_block_edged_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_SHINY.get(), "amethyst_block_shiny_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.AMETHYST_BLOCK_TILES.get(), "amethyst_block_tiles_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.BORDERED_AMETHYST_BLOCK, "bordered_amethyst_block_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.BRICK_BORDERED_AMETHYST_BLOCK, "brick_bordered_amethyst_block_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.CUT_AMETHYST_BLOCK_COLUMN, "cut_amethyst_block_column_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.EDGED_AMETHYST_BLOCK_BRICKS, "edged_amethyst_block_bricks_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.MASSIVE_AMETHYST_BLOCK_BRICKS, "massive_amethyst_block_bricks_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.OVERLAPPING_AMETHYST_BLOCK_TILES, "overlapping_amethyst_block_tiles_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.POLISHED_AMETHYST_BLOCK, "polished_amethyst_block_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.SMOOTH_AMETHYST_BLOCK_COLUMN, "smooth_amethyst_block_column_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.THICK_INLAYED_AMETHYST_BLOCK, "thick_inlayed_amethyst_block_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.TILED_AMETHYST_BLOCK_COLUMN, "tiled_amethyst_block_column_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.TILED_BORDERED_AMETHYST_BLOCK, "tiled_bordered_amethyst_block_ctm_engraving");
        s.tagged( materialTag("amethyst_block"), OttBlocks.TINY_BRICK_BORDERED_AMETHYST_BLOCK, "tiny_brick_bordered_amethyst_block_ctm_engraving");
        // ── ancient_debris ──
        s.one( Blocks.ANCIENT_DEBRIS, OttBlocks.CURLY_ANCIENT_DEBRIS_CTM, "curly_ancient_debris_pillar_engraving");
        s.one( Blocks.ANCIENT_DEBRIS, OttBlocks.FINE_ANCIENT_DEBRIS_CTM, "fine_ancient_debris_pillar_engraving");
        s.one( Blocks.ANCIENT_DEBRIS, OttBlocks.ORNATE_ANCIENT_DEBRIS_CTM, "ornate_ancient_debris_pillar_engraving");
        s.one( Blocks.ANCIENT_DEBRIS, OttBlocks.SIMPLE_ANCIENT_DEBRIS_CTM, "simple_ancient_debris_pillar_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.BORDERED_ANCIENT_DEBRIS, "bordered_ancient_debris_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.BRICK_BORDERED_ANCIENT_DEBRIS, "brick_bordered_ancient_debris_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.CUT_ANCIENT_DEBRIS_COLUMN, "cut_ancient_debris_column_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.EDGED_ANCIENT_DEBRIS_BRICKS, "edged_ancient_debris_bricks_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.MASSIVE_ANCIENT_DEBRIS_BRICKS, "massive_ancient_debris_bricks_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.OVERLAPPING_ANCIENT_DEBRIS_TILES, "overlapping_ancient_debris_tiles_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.POLISHED_ANCIENT_DEBRIS, "polished_ancient_debris_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.SMOOTH_ANCIENT_DEBRIS_COLUMN, "smooth_ancient_debris_column_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.THICK_INLAYED_ANCIENT_DEBRIS, "thick_inlayed_ancient_debris_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.TILED_ANCIENT_DEBRIS_COLUMN, "tiled_ancient_debris_column_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.TILED_BORDERED_ANCIENT_DEBRIS, "tiled_bordered_ancient_debris_ctm_engraving");
        s.tagged( materialTag("ancient_debris"), OttBlocks.TINY_BRICK_BORDERED_ANCIENT_DEBRIS, "tiny_brick_bordered_ancient_debris_ctm_engraving");
        // ── andesite ──
        s.one( Blocks.ANDESITE, OttBlocks.CURLY_ANDESITE_CTM, "curly_andesite_pillar_engraving");
        s.one( Blocks.ANDESITE, OttBlocks.FINE_ANDESITE_CTM, "fine_andesite_pillar_engraving");
        s.one( Blocks.ANDESITE, OttBlocks.ORNATE_ANDESITE_CTM, "ornate_andesite_pillar_engraving");
        s.one( Blocks.ANDESITE, OttBlocks.SIMPLE_ANDESITE_CTM, "simple_andesite_pillar_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_BRICKS.get(), "andesite_bricks_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_BRICK_PATTERN.get(), "andesite_brick_pattern_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_BRICK_PAVING.get(), "andesite_brick_paving_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_CUT_POLISHED.get(), "andesite_cut_polished_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_CUT_SMALL_BRICK.get(), "andesite_cut_small_brick_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_DIAGONAL_BRICKS.get(), "andesite_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_DOTTED.get(), "andesite_dotted_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_PAVING.get(), "andesite_paving_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_POLISHED.get(), "andesite_polished_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_ROTATED_BRICKS.get(), "andesite_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_SQUARES.get(), "andesite_squares_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_TILES.get(), "andesite_tiles_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.ANDESITE_WAVY.get(), "andesite_wavy_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.BRICK_BORDERED_ANDESITE, "brick_bordered_andesite_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.CUT_ANDESITE_COLUMN, "cut_andesite_column_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.EDGED_ANDESITE_BRICKS, "edged_andesite_bricks_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.MASSIVE_ANDESITE_BRICKS, "massive_andesite_bricks_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.OVERLAPPING_ANDESITE_TILES, "overlapping_andesite_tiles_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.SMOOTH_ANDESITE_COLUMN, "smooth_andesite_column_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.THICK_INLAYED_ANDESITE, "thick_inlayed_andesite_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.TILED_ANDESITE_COLUMN, "tiled_andesite_column_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.TILED_BORDERED_ANDESITE, "tiled_bordered_andesite_ctm_engraving");
        s.tagged( materialTag("andesite"), OttBlocks.TINY_BRICK_BORDERED_ANDESITE, "tiny_brick_bordered_andesite_ctm_engraving");
        // ── bamboo_planks ──
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_BEAMS.get(), "bamboo_planks_beams_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_BRICKS.get(), "bamboo_planks_bricks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_BRICK_PATTERN.get(), "bamboo_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_BRICK_PAVING.get(), "bamboo_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_CRATE.get(), "bamboo_planks_crate_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_DIAGONAL_STRIPES.get(), "bamboo_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_DIAGONAL_TILES.get(), "bamboo_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_DOTTED.get(), "bamboo_planks_dotted_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_FLOORING.get(), "bamboo_planks_flooring_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_LARGE_TILES.get(), "bamboo_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_PANEL, "bamboo_planks_panel_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_PATTERN.get(), "bamboo_planks_pattern_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_ROTATED_BRICKS.get(), "bamboo_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_SMALL_BRICKS.get(), "bamboo_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_SMALL_TILES.get(), "bamboo_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_SQUARES.get(), "bamboo_planks_squares_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_TILES.get(), "bamboo_planks_tiles_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_WAVY.get(), "bamboo_planks_wavy_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.BAMBOO_PLANKS_WOVEN.get(), "bamboo_planks_woven_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.CORNERED_BAMBOO_PLANKS, "cornered_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.CRATED_BAMBOO_PLANKS, "crated_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.ENCLOSED_BAMBOO_PLANKS, "enclosed_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.FRAMED_BAMBOO_PLANKS, "framed_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.NATURAL_BAMBOO_PLANKS, "natural_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.PEGGED_BAMBOO_PLANKS, "pegged_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.POLISHED_BAMBOO_PLANKS, "polished_bamboo_planks_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.TIED_BAMBOO_PLANKS, "tied_bamboo_planks_ctm_engraving");
        s.tagged( materialTag("bamboo_planks"), OttBlocks.WHIRLWIND_BAMBOO_PLANKS, "whirlwind_bamboo_planks_ctm_engraving");
        // ── basalt ──
        s.one( Blocks.BASALT, OttBlocks.CURLY_BASALT_CTM, "curly_basalt_pillar_engraving");
        s.one( Blocks.BASALT, OttBlocks.FINE_BASALT_CTM, "fine_basalt_pillar_engraving");
        s.one( Blocks.BASALT, OttBlocks.ORNATE_BASALT_CTM, "ornate_basalt_pillar_engraving");
        s.one( Blocks.BASALT, OttBlocks.SIMPLE_BASALT_CTM, "simple_basalt_pillar_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_BEAMS.get(), "basalt_beams_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_BORDERED.get(), "basalt_bordered_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_BORDERED_POLISHED.get(), "basalt_bordered_polished_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_BRICKS.get(), "basalt_bricks_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_DIAGONAL_TILES.get(), "basalt_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_PATTERN.get(), "basalt_pattern_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_PATTERNED.get(), "basalt_patterned_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BASALT_TILES.get(), "basalt_tiles_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BORDERED_BASALT, "bordered_basalt_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.BRICK_BORDERED_BASALT, "brick_bordered_basalt_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.CUT_BASALT_COLUMN, "cut_basalt_column_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.EDGED_BASALT_BRICKS, "edged_basalt_bricks_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.MASSIVE_BASALT_BRICKS, "massive_basalt_bricks_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.OVERLAPPING_BASALT_TILES, "overlapping_basalt_tiles_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.POLISHED_BASALT, "polished_basalt_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.SMOOTH_BASALT_COLUMN, "smooth_basalt_column_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.THICK_INLAYED_BASALT, "thick_inlayed_basalt_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.TILED_BASALT_COLUMN, "tiled_basalt_column_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.TILED_BORDERED_BASALT, "tiled_bordered_basalt_ctm_engraving");
        s.tagged( materialTag("basalt"), OttBlocks.TINY_BRICK_BORDERED_BASALT, "tiny_brick_bordered_basalt_ctm_engraving");
        // ── birch_planks ──
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_BEAMS.get(), "birch_planks_beams_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_BRICKS.get(), "birch_planks_bricks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_BRICK_PATTERN.get(), "birch_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_BRICK_PAVING.get(), "birch_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_CRATE.get(), "birch_planks_crate_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_DIAGONAL_STRIPES.get(), "birch_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_DIAGONAL_TILES.get(), "birch_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_DOTTED.get(), "birch_planks_dotted_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_FLOORING.get(), "birch_planks_flooring_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_LARGE_TILES.get(), "birch_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_PANEL, "birch_planks_panel_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_PATTERN.get(), "birch_planks_pattern_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_ROTATED_BRICKS.get(), "birch_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_SMALL_BRICKS.get(), "birch_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_SMALL_TILES.get(), "birch_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_SQUARES.get(), "birch_planks_squares_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_TILES.get(), "birch_planks_tiles_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_WAVY.get(), "birch_planks_wavy_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.BIRCH_PLANKS_WOVEN.get(), "birch_planks_woven_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.CORNERED_BIRCH_PLANKS, "cornered_birch_planks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.CRATED_BIRCH_PLANKS, "crated_birch_planks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.ENCLOSED_BIRCH_PLANKS, "enclosed_birch_planks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.FRAMED_BIRCH_PLANKS, "framed_birch_planks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.NATURAL_BIRCH_PLANKS, "natural_birch_planks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.PEGGED_BIRCH_PLANKS, "pegged_birch_planks_ctm_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.POLISHED_BIRCH_PLANKS, "polished_birch_planks_engraving");
        s.tagged( materialTag("birch_planks"), OttBlocks.WHIRLWIND_BIRCH_PLANKS, "whirlwind_birch_planks_ctm_engraving");
        // ── black_concrete ──
        s.one( Blocks.BLACK_CONCRETE, OttBlocks.BLACK_CONCRETE_CTM, "black_concrete_pillar_engraving");
        s.tagged( materialTag("black_concrete"), OttBlocks.BLACK_CONCRETE_PANEL, "black_concrete_panel_ctm_engraving");
        s.tagged( materialTag("black_concrete"), OttBlocks.GRILL_BLACK_CONCRETE, "grill_black_concrete_ctm_engraving");
        s.tagged( materialTag("black_concrete"), OttBlocks.PEGGED_BLACK_CONCRETE, "pegged_black_concrete_ctm_engraving");
        s.tagged( materialTag("black_concrete"), OttBlocks.SMOOTH_BLACK_CONCRETE, "smooth_black_concrete_ctm_engraving");
        s.tagged( materialTag("black_concrete"), OttBlocks.STRIPED_BLACK_CONCRETE, "striped_black_concrete_ctm_engraving");
        s.tagged( materialTag("black_concrete"), OttBlocks.WIRED_BLACK_CONCRETE, "wired_black_concrete_ctm_engraving");
        // ── black_marble ──
        s.one( OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_BRICKS,       "black_marble_bricks_engraving");
        s.one( OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_PILLAR,       "black_marble_pillar_engraving");
        s.one( OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_PILLAR_CAP,   "black_marble_pillar_cap_engraving");
        s.one( OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_SMALL_BRICKS, "black_marble_small_bricks_engraving");
        s.one( OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_TILES,        "black_marble_tiles_engraving");
        s.one( OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_POLISHED_MARBLE,     "black_polished_marble_engraving");
        // ── black_terracotta ──
        s.one( Blocks.BLACK_TERRACOTTA, OttBlocks.BLACK_TERRACOTTA_CTM, "black_terracotta_pillar_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.BLACK_TERRACOTTA_COLUMN, "black_terracotta_column_ctm_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.CIRCULAR_BLACK_TERRACOTTA, "circular_black_terracotta_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.CURLED_BLACK_TERRACOTTA, "curled_black_terracotta_ctm_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.HEXAGONICAL_BLACK_TERRACOTTA, "hexagonical_black_terracotta_ctm_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.INSCRIBED_BLACK_TERRACOTTA, "inscribed_black_terracotta_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.SMALL_BLACK_TERRACOTTA_TILES, "small_black_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("black_terracotta"), OttBlocks.STARRY_BLACK_TERRACOTTA, "starry_black_terracotta_engraving");
        // ── blackstone ──
        s.one( Blocks.BLACKSTONE, OttBlocks.CURLY_BLACKSTONE_CTM, "curly_blackstone_pillar_engraving");
        s.one( Blocks.BLACKSTONE, OttBlocks.FINE_BLACKSTONE_CTM, "fine_blackstone_pillar_engraving");
        s.one( Blocks.BLACKSTONE, OttBlocks.ORNATE_BLACKSTONE_CTM, "ornate_blackstone_pillar_engraving");
        s.one( Blocks.BLACKSTONE, OttBlocks.SIMPLE_BLACKSTONE_CTM, "simple_blackstone_pillar_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BLACKSTONE_BRICK_PATTERN.get(), "blackstone_brick_pattern_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BLACKSTONE_BRICK_PAVING.get(), "blackstone_brick_paving_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BLACKSTONE_DIAGONAL_BRICKS.get(), "blackstone_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BLACKSTONE_POLISHED.get(), "blackstone_polished_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BLACKSTONE_ROTATED_BRICKS.get(), "blackstone_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BLACKSTONE_TILES.get(), "blackstone_tiles_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BORDERED_BLACKSTONE, "bordered_blackstone_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.BRICK_BORDERED_BLACKSTONE, "brick_bordered_blackstone_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.CUT_BLACKSTONE_COLUMN, "cut_blackstone_column_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.EDGED_BLACKSTONE_BRICKS, "edged_blackstone_bricks_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.MASSIVE_BLACKSTONE_BRICKS, "massive_blackstone_bricks_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.OVERLAPPING_BLACKSTONE_TILES, "overlapping_blackstone_tiles_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.SMOOTH_BLACKSTONE_COLUMN, "smooth_blackstone_column_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.THICK_INLAYED_BLACKSTONE, "thick_inlayed_blackstone_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.TILED_BLACKSTONE_COLUMN, "tiled_blackstone_column_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.TILED_BORDERED_BLACKSTONE, "tiled_bordered_blackstone_ctm_engraving");
        s.tagged( materialTag("blackstone"), OttBlocks.TINY_BRICK_BORDERED_BLACKSTONE, "tiny_brick_bordered_blackstone_ctm_engraving");
        // ── blue_concrete ──
        s.one( Blocks.BLUE_CONCRETE, OttBlocks.BLUE_CONCRETE_CTM, "blue_concrete_pillar_engraving");
        s.tagged( materialTag("blue_concrete"), OttBlocks.BLUE_CONCRETE_PANEL, "blue_concrete_panel_ctm_engraving");
        s.tagged( materialTag("blue_concrete"), OttBlocks.GRILL_BLUE_CONCRETE, "grill_blue_concrete_ctm_engraving");
        s.tagged( materialTag("blue_concrete"), OttBlocks.PEGGED_BLUE_CONCRETE, "pegged_blue_concrete_ctm_engraving");
        s.tagged( materialTag("blue_concrete"), OttBlocks.SMOOTH_BLUE_CONCRETE, "smooth_blue_concrete_ctm_engraving");
        s.tagged( materialTag("blue_concrete"), OttBlocks.STRIPED_BLUE_CONCRETE, "striped_blue_concrete_ctm_engraving");
        s.tagged( materialTag("blue_concrete"), OttBlocks.WIRED_BLUE_CONCRETE, "wired_blue_concrete_ctm_engraving");
        // ── blue_ice ──
        s.one( Blocks.BLUE_ICE, OttBlocks.BLUE_ICE_CTM.get(), "blue_ice_pillar_engraving");
        s.one( Blocks.BLUE_ICE, OttBlocks.CURLY_BLUE_ICE_CTM, "curly_blue_ice_pillar_engraving");
        s.one( Blocks.BLUE_ICE, OttBlocks.FINE_BLUE_ICE_CTM, "fine_blue_ice_pillar_engraving");
        s.one( Blocks.BLUE_ICE, OttBlocks.ORNATE_BLUE_ICE_CTM, "ornate_blue_ice_pillar_engraving");
        s.one( Blocks.BLUE_ICE, OttBlocks.SIMPLE_BLUE_ICE_CTM, "simple_blue_ice_pillar_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BLUE_ICE_BORDERED.get(), "blue_ice_bordered_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BLUE_ICE_BRICKS.get(), "blue_ice_bricks_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BLUE_ICE_CHISELED.get(), "blue_ice_chiseled_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BLUE_ICE_PATTERNED.get(), "blue_ice_patterned_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BLUE_ICE_SLANTED_TILES.get(), "blue_ice_slanted_tiles_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BLUE_ICE_TILES.get(), "blue_ice_tiles_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BORDERED_BLUE_ICE, "bordered_blue_ice_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.BRICK_BORDERED_BLUE_ICE, "brick_bordered_blue_ice_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.CUT_BLUE_ICE_COLUMN, "cut_blue_ice_column_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.EDGED_BLUE_ICE_BRICKS, "edged_blue_ice_bricks_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.MASSIVE_BLUE_ICE_BRICKS, "massive_blue_ice_bricks_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.OVERLAPPING_BLUE_ICE_TILES, "overlapping_blue_ice_tiles_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.POLISHED_BLUE_ICE, "polished_blue_ice_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.SMOOTH_BLUE_ICE_COLUMN, "smooth_blue_ice_column_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.THICK_INLAYED_BLUE_ICE, "thick_inlayed_blue_ice_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.TILED_BLUE_ICE_COLUMN, "tiled_blue_ice_column_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.TILED_BORDERED_BLUE_ICE, "tiled_bordered_blue_ice_ctm_engraving");
        s.tagged( materialTag("blue_ice"), OttBlocks.TINY_BRICK_BORDERED_BLUE_ICE, "tiny_brick_bordered_blue_ice_ctm_engraving");
        // ── blue_marble ──
        s.one( OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_BRICKS,       "blue_marble_bricks_engraving");
        s.one( OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_PILLAR,       "blue_marble_pillar_engraving");
        s.one( OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_PILLAR_CAP,   "blue_marble_pillar_cap_engraving");
        s.one( OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_SMALL_BRICKS, "blue_marble_small_bricks_engraving");
        s.one( OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_TILES,        "blue_marble_tiles_engraving");
        s.one( OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_POLISHED_MARBLE,     "blue_polished_marble_engraving");
        // ── blue_terracotta ──
        s.one( Blocks.BLUE_TERRACOTTA, OttBlocks.BLUE_TERRACOTTA_CTM, "blue_terracotta_pillar_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.BLUE_TERRACOTTA_COLUMN, "blue_terracotta_column_ctm_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.CIRCULAR_BLUE_TERRACOTTA, "circular_blue_terracotta_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.CURLED_BLUE_TERRACOTTA, "curled_blue_terracotta_ctm_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.HEXAGONICAL_BLUE_TERRACOTTA, "hexagonical_blue_terracotta_ctm_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.INSCRIBED_BLUE_TERRACOTTA, "inscribed_blue_terracotta_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.SMALL_BLUE_TERRACOTTA_TILES, "small_blue_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("blue_terracotta"), OttBlocks.STARRY_BLUE_TERRACOTTA, "starry_blue_terracotta_engraving");
        // ── bone_block ──
        s.one( Blocks.BONE_BLOCK, OttBlocks.BONE_BLOCK_BORDERED.get(), "bone_block_bordered_ctm_engraving");
        s.one( Blocks.BONE_BLOCK, OttBlocks.BONE_BLOCK_CHISELED.get(), "bone_block_chiseled_ctm_engraving");
        s.one( Blocks.BONE_BLOCK, OttBlocks.BONE_BLOCK_CONNECTING.get(), "bone_block_connecting_engraving");
        s.one( Blocks.BONE_BLOCK, OttBlocks.BONE_BLOCK_DECORATED_BORDERED.get(), "bone_block_decorated_bordered_ctm_engraving");
        s.one( Blocks.BONE_BLOCK, OttBlocks.BONE_BLOCK_INVERTED_TILES.get(), "bone_block_inverted_tiles_ctm_engraving");
        s.one( Blocks.BONE_BLOCK, OttBlocks.BONE_BLOCK_PATTERNED.get(), "bone_block_patterned_ctm_engraving");
        // ── borderless_bricks ──
        s.tagged( materialTag("borderless_bricks"), OttBlocks.BORDERED_BORDERLESS_BRICKS, "bordered_borderless_bricks_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.BRICK_BORDERED_BORDERLESS_BRICKS, "brick_bordered_borderless_bricks_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.CUT_BORDERLESS_BRICKS_COLUMN, "cut_borderless_bricks_column_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.EDGED_BORDERLESS_BRICKS_BRICKS, "edged_borderless_bricks_bricks_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.MASSIVE_BORDERLESS_BRICKS_BRICKS, "massive_borderless_bricks_bricks_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.OVERLAPPING_BORDERLESS_BRICKS_TILES, "overlapping_borderless_bricks_tiles_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.POLISHED_BORDERLESS_BRICKS, "polished_borderless_bricks_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.SMOOTH_BORDERLESS_BRICKS_COLUMN, "smooth_borderless_bricks_column_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.THICK_INLAYED_BORDERLESS_BRICKS, "thick_inlayed_borderless_bricks_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.TILED_BORDERED_BORDERLESS_BRICKS, "tiled_bordered_borderless_bricks_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.TILED_BORDERLESS_BRICKS_COLUMN, "tiled_borderless_bricks_column_ctm_engraving");
        s.tagged( materialTag("borderless_bricks"), OttBlocks.TINY_BRICK_BORDERED_BORDERLESS_BRICKS, "tiny_brick_bordered_borderless_bricks_ctm_engraving");
        // ── bricks ──
        s.one( Blocks.BRICKS, OttBlocks.CURLY_BORDERLESS_BRICKS_CTM, "curly_borderless_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.CURLY_BRICKS_CTM, "curly_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.FINE_BORDERLESS_BRICKS_CTM, "fine_borderless_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.FINE_BRICKS_CTM, "fine_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.ORNATE_BORDERLESS_BRICKS_CTM, "ornate_borderless_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.ORNATE_BRICKS_CTM, "ornate_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.SIMPLE_BORDERLESS_BRICKS_CTM, "simple_borderless_bricks_pillar_engraving");
        s.one( Blocks.BRICKS, OttBlocks.SIMPLE_BRICKS_CTM, "simple_bricks_pillar_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.BORDERED_BRICKS, "bordered_bricks_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.BRICK_BORDERED_BRICKS, "brick_bordered_bricks_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.CUT_BRICKS_COLUMN, "cut_bricks_column_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.EDGED_BRICKS_BRICKS, "edged_bricks_bricks_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.MASSIVE_BRICKS_BRICKS, "massive_bricks_bricks_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.OVERLAPPING_BRICKS_TILES, "overlapping_bricks_tiles_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.POLISHED_BRICKS, "polished_bricks_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.SMOOTH_BRICKS_COLUMN, "smooth_bricks_column_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.THICK_INLAYED_BRICKS, "thick_inlayed_bricks_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.TILED_BORDERED_BRICKS, "tiled_bordered_bricks_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.TILED_BRICKS_COLUMN, "tiled_bricks_column_ctm_engraving");
        s.tagged( materialTag("bricks"), OttBlocks.TINY_BRICK_BORDERED_BRICKS, "tiny_brick_bordered_bricks_ctm_engraving");
        // ── brown_concrete ──
        s.one( Blocks.BROWN_CONCRETE, OttBlocks.BROWN_CONCRETE_CTM, "brown_concrete_pillar_engraving");
        s.tagged( materialTag("brown_concrete"), OttBlocks.BROWN_CONCRETE_PANEL, "brown_concrete_panel_ctm_engraving");
        s.tagged( materialTag("brown_concrete"), OttBlocks.GRILL_BROWN_CONCRETE, "grill_brown_concrete_ctm_engraving");
        s.tagged( materialTag("brown_concrete"), OttBlocks.PEGGED_BROWN_CONCRETE, "pegged_brown_concrete_ctm_engraving");
        s.tagged( materialTag("brown_concrete"), OttBlocks.SMOOTH_BROWN_CONCRETE, "smooth_brown_concrete_ctm_engraving");
        s.tagged( materialTag("brown_concrete"), OttBlocks.STRIPED_BROWN_CONCRETE, "striped_brown_concrete_ctm_engraving");
        s.tagged( materialTag("brown_concrete"), OttBlocks.WIRED_BROWN_CONCRETE, "wired_brown_concrete_ctm_engraving");
        // ── brown_marble ──
        s.one( OttBlocks.BROWN_MARBLE, OttBlocks.BROWN_MARBLE_BRICKS,       "brown_marble_bricks_engraving");
        s.one( OttBlocks.BROWN_MARBLE, OttBlocks.BROWN_MARBLE_PILLAR,       "brown_marble_pillar_engraving");
        s.one( OttBlocks.BROWN_MARBLE, OttBlocks.BROWN_MARBLE_PILLAR_CAP,   "brown_marble_pillar_cap_engraving");
        s.one( OttBlocks.BROWN_MARBLE, OttBlocks.BROWN_MARBLE_SMALL_BRICKS, "brown_marble_small_bricks_engraving");
        s.one( OttBlocks.BROWN_MARBLE, OttBlocks.BROWN_MARBLE_TILES,        "brown_marble_tiles_engraving");
        s.one( OttBlocks.BROWN_MARBLE, OttBlocks.BROWN_POLISHED_MARBLE,     "brown_polished_marble_engraving");
        // ── brown_terracotta ──
        s.one( Blocks.BROWN_TERRACOTTA, OttBlocks.BROWN_TERRACOTTA_CTM, "brown_terracotta_pillar_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.BROWN_TERRACOTTA_COLUMN, "brown_terracotta_column_ctm_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.CIRCULAR_BROWN_TERRACOTTA, "circular_brown_terracotta_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.CURLED_BROWN_TERRACOTTA, "curled_brown_terracotta_ctm_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.HEXAGONICAL_BROWN_TERRACOTTA, "hexagonical_brown_terracotta_ctm_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.INSCRIBED_BROWN_TERRACOTTA, "inscribed_brown_terracotta_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.SMALL_BROWN_TERRACOTTA_TILES, "small_brown_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("brown_terracotta"), OttBlocks.STARRY_BROWN_TERRACOTTA, "starry_brown_terracotta_engraving");
        // ── calcite ──
        s.one( Blocks.CALCITE, OttBlocks.CURLY_CALCITE_CTM, "curly_calcite_pillar_engraving");
        s.one( Blocks.CALCITE, OttBlocks.FINE_CALCITE_CTM, "fine_calcite_pillar_engraving");
        s.one( Blocks.CALCITE, OttBlocks.ORNATE_CALCITE_CTM, "ornate_calcite_pillar_engraving");
        s.one( Blocks.CALCITE, OttBlocks.SIMPLE_CALCITE_CTM, "simple_calcite_pillar_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.BORDERED_CALCITE, "bordered_calcite_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.BRICK_BORDERED_CALCITE, "brick_bordered_calcite_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.CALCITE_CUT_POLISHED.get(), "calcite_cut_polished_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.CALCITE_CUT_SMALL_BRICK.get(), "calcite_cut_small_brick_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.CUT_CALCITE_COLUMN, "cut_calcite_column_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.EDGED_CALCITE_BRICKS, "edged_calcite_bricks_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.MASSIVE_CALCITE_BRICKS, "massive_calcite_bricks_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.OVERLAPPING_CALCITE_TILES, "overlapping_calcite_tiles_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.POLISHED_CALCITE, "polished_calcite_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.SMOOTH_CALCITE_COLUMN, "smooth_calcite_column_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.THICK_INLAYED_CALCITE, "thick_inlayed_calcite_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.TILED_BORDERED_CALCITE, "tiled_bordered_calcite_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.TILED_CALCITE_COLUMN, "tiled_calcite_column_ctm_engraving");
        s.tagged( materialTag("calcite"), OttBlocks.TINY_BRICK_BORDERED_CALCITE, "tiny_brick_bordered_calcite_ctm_engraving");
        // ── cherry_planks ──
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_BEAMS.get(), "cherry_planks_beams_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_BRICKS.get(), "cherry_planks_bricks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_BRICK_PATTERN.get(), "cherry_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_BRICK_PAVING.get(), "cherry_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_CRATE.get(), "cherry_planks_crate_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_DIAGONAL_STRIPES.get(), "cherry_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_DIAGONAL_TILES.get(), "cherry_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_DOTTED.get(), "cherry_planks_dotted_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_FLOORING.get(), "cherry_planks_flooring_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_LARGE_TILES.get(), "cherry_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_PANEL, "cherry_planks_panel_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_PATTERN.get(), "cherry_planks_pattern_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_ROTATED_BRICKS.get(), "cherry_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_SMALL_BRICKS.get(), "cherry_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_SMALL_TILES.get(), "cherry_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_SQUARES.get(), "cherry_planks_squares_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_TILES.get(), "cherry_planks_tiles_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_WAVY.get(), "cherry_planks_wavy_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CHERRY_PLANKS_WOVEN.get(), "cherry_planks_woven_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CORNERED_CHERRY_PLANKS, "cornered_cherry_planks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.CRATED_CHERRY_PLANKS, "crated_cherry_planks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.ENCLOSED_CHERRY_PLANKS, "enclosed_cherry_planks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.FRAMED_CHERRY_PLANKS, "framed_cherry_planks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.NATURAL_CHERRY_PLANKS, "natural_cherry_planks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.PEGGED_CHERRY_PLANKS, "pegged_cherry_planks_ctm_engraving");
        s.tagged( materialTag("cherry_planks"), OttBlocks.WHIRLWIND_CHERRY_PLANKS, "whirlwind_cherry_planks_ctm_engraving");
        // ── clay ──
        s.one( Blocks.CLAY, OttBlocks.CURLY_CLAY_CTM, "curly_clay_pillar_engraving");
        s.one( Blocks.CLAY, OttBlocks.FINE_CLAY_CTM, "fine_clay_pillar_engraving");
        s.one( Blocks.CLAY, OttBlocks.ORNATE_CLAY_CTM, "ornate_clay_pillar_engraving");
        s.one( Blocks.CLAY, OttBlocks.SIMPLE_CLAY_CTM, "simple_clay_pillar_engraving");
        s.tagged( materialTag("clay"), OttBlocks.BORDERED_CLAY, "bordered_clay_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.BRICK_BORDERED_CLAY, "brick_bordered_clay_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.CUT_CLAY_COLUMN, "cut_clay_column_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.EDGED_CLAY_BRICKS, "edged_clay_bricks_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.MASSIVE_CLAY_BRICKS, "massive_clay_bricks_engraving");
        s.tagged( materialTag("clay"), OttBlocks.OVERLAPPING_CLAY_TILES, "overlapping_clay_tiles_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.POLISHED_CLAY, "polished_clay_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.SMOOTH_CLAY_COLUMN, "smooth_clay_column_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.THICK_INLAYED_CLAY, "thick_inlayed_clay_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.TILED_BORDERED_CLAY, "tiled_bordered_clay_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.TILED_CLAY_COLUMN, "tiled_clay_column_ctm_engraving");
        s.tagged( materialTag("clay"), OttBlocks.TINY_BRICK_BORDERED_CLAY, "tiny_brick_bordered_clay_ctm_engraving");
        // ── coal_block ──
        s.one( Blocks.COAL_BLOCK, OttBlocks.CURLY_COAL_BLOCK_CTM, "curly_coal_block_pillar_engraving");
        s.one( Blocks.COAL_BLOCK, OttBlocks.FINE_COAL_BLOCK_CTM, "fine_coal_block_pillar_engraving");
        s.one( Blocks.COAL_BLOCK, OttBlocks.ORNATE_COAL_BLOCK_CTM, "ornate_coal_block_pillar_engraving");
        s.one( Blocks.COAL_BLOCK, OttBlocks.SIMPLE_COAL_BLOCK_CTM, "simple_coal_block_pillar_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.BORDERED_COAL_BLOCK, "bordered_coal_block_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.BRICK_BORDERED_COAL_BLOCK, "brick_bordered_coal_block_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_CARVED.get(), "coal_block_carved_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_CHISELED.get(), "coal_block_chiseled_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_CIRCLES.get(), "coal_block_circles_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_COMPACTED.get(), "coal_block_compacted_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_OVALS.get(), "coal_block_ovals_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_PATTERN.get(), "coal_block_pattern_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_ROTATED_BRICKS.get(), "coal_block_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_SMALL_TILES.get(), "coal_block_small_tiles_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.COAL_BLOCK_STRIPES.get(), "coal_block_stripes_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.CUT_COAL_BLOCK_COLUMN, "cut_coal_block_column_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.EDGED_COAL_BLOCK_BRICKS, "edged_coal_block_bricks_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.MASSIVE_COAL_BLOCK_BRICKS, "massive_coal_block_bricks_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.OVERLAPPING_COAL_BLOCK_TILES, "overlapping_coal_block_tiles_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.POLISHED_COAL_BLOCK, "polished_coal_block_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.SMOOTH_COAL_BLOCK_COLUMN, "smooth_coal_block_column_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.THICK_INLAYED_COAL_BLOCK, "thick_inlayed_coal_block_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.TILED_BORDERED_COAL_BLOCK, "tiled_bordered_coal_block_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.TILED_COAL_BLOCK_COLUMN, "tiled_coal_block_column_ctm_engraving");
        s.tagged( materialTag("coal_block"), OttBlocks.TINY_BRICK_BORDERED_COAL_BLOCK, "tiny_brick_bordered_coal_block_ctm_engraving");
        // ── cobbled_deepslate ──
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_BEAMS.get(), "cobbled_deepslate_beams_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_BRICKS.get(), "cobbled_deepslate_bricks_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_BRICK_PATTERN.get(), "cobbled_deepslate_brick_pattern_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_BRICK_PAVING.get(), "cobbled_deepslate_brick_paving_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_LARGE_TILES.get(), "cobbled_deepslate_large_tiles_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_PAVING.get(), "cobbled_deepslate_paving_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_PULVERIZED.get(), "cobbled_deepslate_pulverized_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_ROTATED_BRICKS.get(), "cobbled_deepslate_rotated_bricks_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_SMALL_TILES.get(), "cobbled_deepslate_small_tiles_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_SQUARES.get(), "cobbled_deepslate_squares_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_STRIPES.get(), "cobbled_deepslate_stripes_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_TILES.get(), "cobbled_deepslate_tiles_ctm_engraving");
        s.one( Blocks.COBBLED_DEEPSLATE, OttBlocks.COBBLED_DEEPSLATE_WORN_STRIPES.get(), "cobbled_deepslate_worn_stripes_ctm_engraving");
        // ── cobblestone ──
        s.one( Blocks.COBBLESTONE, OttBlocks.CURLY_COBBLESTONE_CTM, "curly_cobblestone_pillar_engraving");
        s.one( Blocks.COBBLESTONE, OttBlocks.FINE_COBBLESTONE_CTM, "fine_cobblestone_pillar_engraving");
        s.one( Blocks.COBBLESTONE, OttBlocks.ORNATE_COBBLESTONE_CTM, "ornate_cobblestone_pillar_engraving");
        s.one( Blocks.COBBLESTONE, OttBlocks.SIMPLE_COBBLESTONE_CTM, "simple_cobblestone_pillar_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.BORDERED_COBBLESTONE, "bordered_cobblestone_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.BRICK_BORDERED_COBBLESTONE, "brick_bordered_cobblestone_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_BEAMS.get(), "cobblestone_beams_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_BRICK_PATTERN.get(), "cobblestone_brick_pattern_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_BRICK_PAVING.get(), "cobblestone_brick_paving_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_CHISELED_BORDER.get(), "cobblestone_chiseled_border_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_CROSSES.get(), "cobblestone_crosses_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_DENTED.get(), "cobblestone_dented_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_INVERTED_DENTED.get(), "cobblestone_inverted_dented_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_PAVING.get(), "cobblestone_paving_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_PULVERIZED.get(), "cobblestone_pulverized_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_ROTATED_BRICKS.get(), "cobblestone_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_SMALL_TILES.get(), "cobblestone_small_tiles_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_SQUARES.get(), "cobblestone_squares_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_STRIPES.get(), "cobblestone_stripes_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_TILES.get(), "cobblestone_tiles_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.COBBLESTONE_WORN_STRIPES.get(), "cobblestone_worn_stripes_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.CUT_COBBLESTONE_COLUMN, "cut_cobblestone_column_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.EDGED_COBBLESTONE_BRICKS, "edged_cobblestone_bricks_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.MASSIVE_COBBLESTONE_BRICKS, "massive_cobblestone_bricks_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.OVERLAPPING_COBBLESTONE_TILES, "overlapping_cobblestone_tiles_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.POLISHED_COBBLESTONE, "polished_cobblestone_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.SMOOTH_COBBLESTONE_COLUMN, "smooth_cobblestone_column_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.THICK_INLAYED_COBBLESTONE, "thick_inlayed_cobblestone_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.TILED_BORDERED_COBBLESTONE, "tiled_bordered_cobblestone_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.TILED_COBBLESTONE_COLUMN, "tiled_cobblestone_column_ctm_engraving");
        s.tagged( materialTag("cobblestone"), OttBlocks.TINY_BRICK_BORDERED_COBBLESTONE, "tiny_brick_bordered_cobblestone_ctm_engraving");
        // ── copper_block ──
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK.get(), "copper_block_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_BARS.get(), "copper_block_bars_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_CIRCLES.get(), "copper_block_circles_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_GEARS.get(), "copper_block_gears_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_LINES.get(), "copper_block_lines_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_PATTERN.get(), "copper_block_pattern_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_POLISHED.get(), "copper_block_polished_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_SHAFTS.get(), "copper_block_shafts_ctm_engraving");
        s.tagged( materialTag("copper_block"), OttBlocks.COPPER_BLOCK_SMALL_BRICKS.get(), "copper_block_small_bricks_ctm_engraving");
        // ── copper_grate ──
        s.tagged( materialTag("copper_grate"), OttBlocks.COPPER_GRATE.get(), "copper_grate_ctm_engraving");
        // ── crimson_planks ──
        s.tagged( materialTag("crimson_planks"), OttBlocks.CORNERED_CRIMSON_PLANKS, "cornered_crimson_planks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRATED_CRIMSON_PLANKS, "crated_crimson_planks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_BEAMS.get(), "crimson_planks_beams_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_BRICKS.get(), "crimson_planks_bricks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_BRICK_PATTERN.get(), "crimson_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_BRICK_PAVING.get(), "crimson_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_CRATE.get(), "crimson_planks_crate_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_DIAGONAL_STRIPES.get(), "crimson_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_DIAGONAL_TILES.get(), "crimson_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_DOTTED.get(), "crimson_planks_dotted_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_FLOORING.get(), "crimson_planks_flooring_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_LARGE_TILES.get(), "crimson_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_PANEL, "crimson_planks_panel_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_PATTERN.get(), "crimson_planks_pattern_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_ROTATED_BRICKS.get(), "crimson_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_SMALL_BRICKS.get(), "crimson_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_SMALL_TILES.get(), "crimson_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_SQUARES.get(), "crimson_planks_squares_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_TILES.get(), "crimson_planks_tiles_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_WAVY.get(), "crimson_planks_wavy_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.CRIMSON_PLANKS_WOVEN.get(), "crimson_planks_woven_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.ENCLOSED_CRIMSON_PLANKS, "enclosed_crimson_planks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.FRAMED_CRIMSON_PLANKS, "framed_crimson_planks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.NATURAL_CRIMSON_PLANKS, "natural_crimson_planks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.PEGGED_CRIMSON_PLANKS, "pegged_crimson_planks_ctm_engraving");
        s.tagged( materialTag("crimson_planks"), OttBlocks.WHIRLWIND_CRIMSON_PLANKS, "whirlwind_crimson_planks_ctm_engraving");
        // ── crying_obsidian ──
        s.one( Blocks.CRYING_OBSIDIAN, OttBlocks.CURLY_CRYING_OBSIDIAN_CTM, "curly_crying_obsidian_pillar_engraving");
        s.one( Blocks.CRYING_OBSIDIAN, OttBlocks.FINE_CRYING_OBSIDIAN_CTM, "fine_crying_obsidian_pillar_engraving");
        s.one( Blocks.CRYING_OBSIDIAN, OttBlocks.ORNATE_CRYING_OBSIDIAN_CTM, "ornate_crying_obsidian_pillar_engraving");
        s.one( Blocks.CRYING_OBSIDIAN, OttBlocks.SIMPLE_CRYING_OBSIDIAN_CTM, "simple_crying_obsidian_pillar_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.BORDERED_CRYING_OBSIDIAN, "bordered_crying_obsidian_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.BRICK_BORDERED_CRYING_OBSIDIAN, "brick_bordered_crying_obsidian_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.CUT_CRYING_OBSIDIAN_COLUMN, "cut_crying_obsidian_column_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.EDGED_CRYING_OBSIDIAN_BRICKS, "edged_crying_obsidian_bricks_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.MASSIVE_CRYING_OBSIDIAN_BRICKS, "massive_crying_obsidian_bricks_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.OVERLAPPING_CRYING_OBSIDIAN_TILES, "overlapping_crying_obsidian_tiles_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.POLISHED_CRYING_OBSIDIAN, "polished_crying_obsidian_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.SMOOTH_CRYING_OBSIDIAN_COLUMN, "smooth_crying_obsidian_column_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.THICK_INLAYED_CRYING_OBSIDIAN, "thick_inlayed_crying_obsidian_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.TILED_BORDERED_CRYING_OBSIDIAN, "tiled_bordered_crying_obsidian_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.TILED_CRYING_OBSIDIAN_COLUMN, "tiled_crying_obsidian_column_ctm_engraving");
        s.tagged( materialTag("crying_obsidian"), OttBlocks.TINY_BRICK_BORDERED_CRYING_OBSIDIAN, "tiny_brick_bordered_crying_obsidian_ctm_engraving");
        // ── cyan_concrete ──
        s.one( Blocks.CYAN_CONCRETE, OttBlocks.CYAN_CONCRETE_CTM, "cyan_concrete_pillar_engraving");
        s.tagged( materialTag("cyan_concrete"), OttBlocks.CYAN_CONCRETE_PANEL, "cyan_concrete_panel_ctm_engraving");
        s.tagged( materialTag("cyan_concrete"), OttBlocks.GRILL_CYAN_CONCRETE, "grill_cyan_concrete_ctm_engraving");
        s.tagged( materialTag("cyan_concrete"), OttBlocks.PEGGED_CYAN_CONCRETE, "pegged_cyan_concrete_ctm_engraving");
        s.tagged( materialTag("cyan_concrete"), OttBlocks.SMOOTH_CYAN_CONCRETE, "smooth_cyan_concrete_ctm_engraving");
        s.tagged( materialTag("cyan_concrete"), OttBlocks.STRIPED_CYAN_CONCRETE, "striped_cyan_concrete_ctm_engraving");
        s.tagged( materialTag("cyan_concrete"), OttBlocks.WIRED_CYAN_CONCRETE, "wired_cyan_concrete_ctm_engraving");
        // ── cyan_marble ──
        s.one( OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_BRICKS,       "cyan_marble_bricks_engraving");
        s.one( OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_PILLAR,       "cyan_marble_pillar_engraving");
        s.one( OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_PILLAR_CAP,   "cyan_marble_pillar_cap_engraving");
        s.one( OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_SMALL_BRICKS, "cyan_marble_small_bricks_engraving");
        s.one( OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_TILES,        "cyan_marble_tiles_engraving");
        s.one( OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_POLISHED_MARBLE,     "cyan_polished_marble_engraving");
        // ── cyan_terracotta ──
        s.one( Blocks.CYAN_TERRACOTTA, OttBlocks.CYAN_TERRACOTTA_CTM, "cyan_terracotta_pillar_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.CIRCULAR_CYAN_TERRACOTTA, "circular_cyan_terracotta_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.CURLED_CYAN_TERRACOTTA, "curled_cyan_terracotta_ctm_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.CYAN_TERRACOTTA_COLUMN, "cyan_terracotta_column_ctm_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.HEXAGONICAL_CYAN_TERRACOTTA, "hexagonical_cyan_terracotta_ctm_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.INSCRIBED_CYAN_TERRACOTTA, "inscribed_cyan_terracotta_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.SMALL_CYAN_TERRACOTTA_TILES, "small_cyan_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("cyan_terracotta"), OttBlocks.STARRY_CYAN_TERRACOTTA, "starry_cyan_terracotta_engraving");
        // ── dark_oak_planks ──
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.CORNERED_DARK_OAK_PLANKS, "cornered_dark_oak_planks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.CRATED_DARK_OAK_PLANKS, "crated_dark_oak_planks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_BEAMS.get(), "dark_oak_planks_beams_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_BRICKS.get(), "dark_oak_planks_bricks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_BRICK_PATTERN.get(), "dark_oak_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_BRICK_PAVING.get(), "dark_oak_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_CRATE.get(), "dark_oak_planks_crate_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_DIAGONAL_STRIPES.get(), "dark_oak_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_DIAGONAL_TILES.get(), "dark_oak_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_DOTTED.get(), "dark_oak_planks_dotted_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_FLOORING.get(), "dark_oak_planks_flooring_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_LARGE_TILES.get(), "dark_oak_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_PANEL, "dark_oak_planks_panel_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_PATTERN.get(), "dark_oak_planks_pattern_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_ROTATED_BRICKS.get(), "dark_oak_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_SMALL_BRICKS.get(), "dark_oak_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_SMALL_TILES.get(), "dark_oak_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_SQUARES.get(), "dark_oak_planks_squares_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_TILES.get(), "dark_oak_planks_tiles_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_WAVY.get(), "dark_oak_planks_wavy_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.DARK_OAK_PLANKS_WOVEN.get(), "dark_oak_planks_woven_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.ENCLOSED_DARK_OAK_PLANKS, "enclosed_dark_oak_planks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.FRAMED_DARK_OAK_PLANKS, "framed_dark_oak_planks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.NATURAL_DARK_OAK_PLANKS, "natural_dark_oak_planks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.PEGGED_DARK_OAK_PLANKS, "pegged_dark_oak_planks_ctm_engraving");
        s.tagged( materialTag("dark_oak_planks"), OttBlocks.WHIRLWIND_DARK_OAK_PLANKS, "whirlwind_dark_oak_planks_ctm_engraving");
        // ── dark_prismarine ──
        s.one( Blocks.DARK_PRISMARINE, OttBlocks.CURLY_DARK_PRISMARINE_CTM, "curly_dark_prismarine_pillar_engraving");
        s.one( Blocks.DARK_PRISMARINE, OttBlocks.FINE_DARK_PRISMARINE_CTM, "fine_dark_prismarine_pillar_engraving");
        s.one( Blocks.DARK_PRISMARINE, OttBlocks.ORNATE_DARK_PRISMARINE_CTM, "ornate_dark_prismarine_pillar_engraving");
        s.one( Blocks.DARK_PRISMARINE, OttBlocks.SIMPLE_DARK_PRISMARINE_CTM, "simple_dark_prismarine_pillar_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.BORDERED_DARK_PRISMARINE, "bordered_dark_prismarine_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.BRICK_BORDERED_DARK_PRISMARINE, "brick_bordered_dark_prismarine_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.CUT_DARK_PRISMARINE_COLUMN, "cut_dark_prismarine_column_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.EDGED_DARK_PRISMARINE_BRICKS, "edged_dark_prismarine_bricks_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.MASSIVE_DARK_PRISMARINE_BRICKS, "massive_dark_prismarine_bricks_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.OVERLAPPING_DARK_PRISMARINE_TILES, "overlapping_dark_prismarine_tiles_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.POLISHED_DARK_PRISMARINE, "polished_dark_prismarine_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.SMOOTH_DARK_PRISMARINE_COLUMN, "smooth_dark_prismarine_column_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.THICK_INLAYED_DARK_PRISMARINE, "thick_inlayed_dark_prismarine_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.TILED_BORDERED_DARK_PRISMARINE, "tiled_bordered_dark_prismarine_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.TILED_DARK_PRISMARINE_COLUMN, "tiled_dark_prismarine_column_ctm_engraving");
        s.tagged( materialTag("dark_prismarine"), OttBlocks.TINY_BRICK_BORDERED_DARK_PRISMARINE, "tiny_brick_bordered_dark_prismarine_ctm_engraving");
        // ── deepslate ──
        s.one( Blocks.DEEPSLATE, OttBlocks.CURLY_DEEPSLATE_CTM, "curly_deepslate_pillar_engraving");
        s.one( Blocks.DEEPSLATE, OttBlocks.FINE_DEEPSLATE_CTM, "fine_deepslate_pillar_engraving");
        s.one( Blocks.DEEPSLATE, OttBlocks.ORNATE_DEEPSLATE_CTM, "ornate_deepslate_pillar_engraving");
        s.one( Blocks.DEEPSLATE, OttBlocks.SIMPLE_DEEPSLATE_CTM, "simple_deepslate_pillar_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.BORDERED_DEEPSLATE, "bordered_deepslate_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.BRICK_BORDERED_DEEPSLATE, "brick_bordered_deepslate_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.CUT_DEEPSLATE_COLUMN, "cut_deepslate_column_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.DEEPSLATE_CUT_POLISHED.get(), "deepslate_cut_polished_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.DEEPSLATE_CUT_SMALL_BRICK.get(), "deepslate_cut_small_brick_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.EDGED_DEEPSLATE_BRICKS, "edged_deepslate_bricks_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.MASSIVE_DEEPSLATE_BRICKS, "massive_deepslate_bricks_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.OVERLAPPING_DEEPSLATE_TILES, "overlapping_deepslate_tiles_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.POLISHED_DEEPSLATE, "polished_deepslate_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.SMOOTH_DEEPSLATE_COLUMN, "smooth_deepslate_column_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.THICK_INLAYED_DEEPSLATE, "thick_inlayed_deepslate_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.TILED_BORDERED_DEEPSLATE, "tiled_bordered_deepslate_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.TILED_DEEPSLATE_COLUMN, "tiled_deepslate_column_ctm_engraving");
        s.tagged( materialTag("deepslate"), OttBlocks.TINY_BRICK_BORDERED_DEEPSLATE, "tiny_brick_bordered_deepslate_ctm_engraving");
        // ── diorite ──
        s.one( Blocks.DIORITE, OttBlocks.CURLY_DIORITE_CTM, "curly_diorite_pillar_engraving");
        s.one( Blocks.DIORITE, OttBlocks.FINE_DIORITE_CTM, "fine_diorite_pillar_engraving");
        s.one( Blocks.DIORITE, OttBlocks.ORNATE_DIORITE_CTM, "ornate_diorite_pillar_engraving");
        s.one( Blocks.DIORITE, OttBlocks.SIMPLE_DIORITE_CTM, "simple_diorite_pillar_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.BORDERED_DIORITE, "bordered_diorite_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.BRICK_BORDERED_DIORITE, "brick_bordered_diorite_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.CUT_DIORITE_COLUMN, "cut_diorite_column_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_BRICKS.get(), "diorite_bricks_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_BRICK_PATTERN.get(), "diorite_brick_pattern_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_BRICK_PAVING.get(), "diorite_brick_paving_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_CUT_POLISHED.get(), "diorite_cut_polished_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_CUT_SMALL_BRICK.get(), "diorite_cut_small_brick_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_DIAGONAL_BRICKS.get(), "diorite_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_DOTTED.get(), "diorite_dotted_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_PAVING.get(), "diorite_paving_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_POLISHED.get(), "diorite_polished_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_ROTATED_BRICKS.get(), "diorite_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_SQUARES.get(), "diorite_squares_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_TILES.get(), "diorite_tiles_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.DIORITE_WAVY.get(), "diorite_wavy_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.EDGED_DIORITE_BRICKS, "edged_diorite_bricks_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.MASSIVE_DIORITE_BRICKS, "massive_diorite_bricks_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.OVERLAPPING_DIORITE_TILES, "overlapping_diorite_tiles_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.SMOOTH_DIORITE_COLUMN, "smooth_diorite_column_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.THICK_INLAYED_DIORITE, "thick_inlayed_diorite_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.TILED_BORDERED_DIORITE, "tiled_bordered_diorite_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.TILED_DIORITE_COLUMN, "tiled_diorite_column_ctm_engraving");
        s.tagged( materialTag("diorite"), OttBlocks.TINY_BRICK_BORDERED_DIORITE, "tiny_brick_bordered_diorite_ctm_engraving");
        // ── dirt ──
        s.one( Blocks.DIRT, OttBlocks.CURLY_DIRT_CTM, "curly_dirt_pillar_engraving");
        s.one( Blocks.DIRT, OttBlocks.FINE_DIRT_CTM, "fine_dirt_pillar_engraving");
        s.one( Blocks.DIRT, OttBlocks.ORNATE_DIRT_CTM, "ornate_dirt_pillar_engraving");
        s.one( Blocks.DIRT, OttBlocks.SIMPLE_DIRT_CTM, "simple_dirt_pillar_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.BORDERED_DIRT, "bordered_dirt_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.BRICK_BORDERED_DIRT, "brick_bordered_dirt_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.CUT_DIRT_COLUMN, "cut_dirt_column_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.EDGED_DIRT_BRICKS, "edged_dirt_bricks_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.MASSIVE_DIRT_BRICKS, "massive_dirt_bricks_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.OVERLAPPING_DIRT_TILES, "overlapping_dirt_tiles_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.POLISHED_DIRT, "polished_dirt_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.SMOOTH_DIRT_COLUMN, "smooth_dirt_column_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.THICK_INLAYED_DIRT, "thick_inlayed_dirt_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.TILED_BORDERED_DIRT, "tiled_bordered_dirt_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.TILED_DIRT_COLUMN, "tiled_dirt_column_ctm_engraving");
        s.tagged( materialTag("dirt"), OttBlocks.TINY_BRICK_BORDERED_DIRT, "tiny_brick_bordered_dirt_ctm_engraving");
        // ── dripstone_block ──
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.BORDERED_DRIPSTONE_BLOCK, "bordered_dripstone_block_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.BRICK_BORDERED_DRIPSTONE_BLOCK, "brick_bordered_dripstone_block_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.CURLY_DRIPSTONE_BLOCK_CTM, "curly_dripstone_block_pillar_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.CUT_DRIPSTONE_BLOCK_COLUMN, "cut_dripstone_block_column_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.EDGED_DRIPSTONE_BLOCK_BRICKS, "edged_dripstone_block_bricks_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.FINE_DRIPSTONE_BLOCK_CTM, "fine_dripstone_block_pillar_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.MASSIVE_DRIPSTONE_BLOCK_BRICKS, "massive_dripstone_block_bricks_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.ORNATE_DRIPSTONE_BLOCK_CTM, "ornate_dripstone_block_pillar_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.OVERLAPPING_DRIPSTONE_BLOCK_TILES, "overlapping_dripstone_block_tiles_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.SIMPLE_DRIPSTONE_BLOCK_CTM, "simple_dripstone_block_pillar_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.SMOOTH_DRIPSTONE_BLOCK_COLUMN, "smooth_dripstone_block_column_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.THICK_INLAYED_DRIPSTONE_BLOCK, "thick_inlayed_dripstone_block_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.TILED_BORDERED_DRIPSTONE_BLOCK, "tiled_bordered_dripstone_block_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.TILED_DRIPSTONE_BLOCK_COLUMN, "tiled_dripstone_block_column_ctm_engraving");
        s.one( Blocks.DRIPSTONE_BLOCK, OttBlocks.TINY_BRICK_BORDERED_DRIPSTONE_BLOCK, "tiny_brick_bordered_dripstone_block_ctm_engraving");
        // ── emerald_block ──
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_BORDERED_CROSSES.get(), "emerald_block_bordered_crosses_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_BORDERED_PLATING.get(), "emerald_block_bordered_plating_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_CHISELED.get(), "emerald_block_chiseled_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_CLOVERS.get(), "emerald_block_clovers_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_CRYSTAL.get(), "emerald_block_crystal_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_CTM,          "emerald_block_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_PATTERNED.get(), "emerald_block_patterned_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_PATTERNED_SQUARES.get(), "emerald_block_patterned_squares_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_POLISHED.get(), "emerald_block_polished_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_STRIPED.get(), "emerald_block_striped_ctm_engraving");
        s.tagged( materialTag("emerald_block"), OttBlocks.EMERALD_BLOCK_WAXED.get(), "emerald_block_waxed_ctm_engraving");
        // ── end_stone ──
        s.one( Blocks.END_STONE, OttBlocks.CURLY_END_STONE_CTM, "curly_end_stone_pillar_engraving");
        s.one( Blocks.END_STONE, OttBlocks.FINE_END_STONE_CTM, "fine_end_stone_pillar_engraving");
        s.one( Blocks.END_STONE, OttBlocks.ORNATE_END_STONE_CTM, "ornate_end_stone_pillar_engraving");
        s.one( Blocks.END_STONE, OttBlocks.SIMPLE_END_STONE_CTM, "simple_end_stone_pillar_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.BORDERED_END_STONE, "bordered_end_stone_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.BRICK_BORDERED_END_STONE, "brick_bordered_end_stone_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.CUT_END_STONE_COLUMN, "cut_end_stone_column_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.EDGED_END_STONE_BRICKS, "edged_end_stone_bricks_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_BLOBS.get(), "end_stone_blobs_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_BRICK_PATTERN.get(), "end_stone_brick_pattern_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_BRICK_PAVING.get(), "end_stone_brick_paving_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_CHISELED.get(), "end_stone_chiseled_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_CRUSHED.get(), "end_stone_crushed_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_DIAGONAL_BRICKS.get(), "end_stone_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_MESH.get(), "end_stone_mesh_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_PAVING.get(), "end_stone_paving_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_ROTATED_BRICKS.get(), "end_stone_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_SCALES.get(), "end_stone_scales_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_SMALL_TILES.get(), "end_stone_small_tiles_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_SPIRAL_PATTERN.get(), "end_stone_spiral_pattern_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_SQUARES.get(), "end_stone_squares_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.END_STONE_TILES.get(), "end_stone_tiles_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.MASSIVE_END_STONE_BRICKS, "massive_end_stone_bricks_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.OVERLAPPING_END_STONE_TILES, "overlapping_end_stone_tiles_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.POLISHED_END_STONE, "polished_end_stone_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.SMOOTH_END_STONE_COLUMN, "smooth_end_stone_column_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.THICK_INLAYED_END_STONE, "thick_inlayed_end_stone_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.TILED_BORDERED_END_STONE, "tiled_bordered_end_stone_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.TILED_END_STONE_COLUMN, "tiled_end_stone_column_ctm_engraving");
        s.tagged( materialTag("end_stone"), OttBlocks.TINY_BRICK_BORDERED_END_STONE, "tiny_brick_bordered_end_stone_ctm_engraving");
        // ── exposed_copper ──
        s.tagged( materialTag("exposed_copper"), OttBlocks.EXPOSED_COPPER_BLOCK.get(), "exposed_copper_block_ctm_engraving");
        // ── exposed_copper_grate ──
        s.tagged( materialTag("exposed_copper_grate"), OttBlocks.EXPOSED_COPPER_GRATE.get(), "exposed_copper_grate_ctm_engraving");
        // ── gilded_blackstone ──
        s.one( Blocks.GILDED_BLACKSTONE, OttBlocks.CURLY_GILDED_BLACKSTONE_CTM, "curly_gilded_blackstone_pillar_engraving");
        s.one( Blocks.GILDED_BLACKSTONE, OttBlocks.FINE_GILDED_BLACKSTONE_CTM, "fine_gilded_blackstone_pillar_engraving");
        s.one( Blocks.GILDED_BLACKSTONE, OttBlocks.ORNATE_GILDED_BLACKSTONE_CTM, "ornate_gilded_blackstone_pillar_engraving");
        s.one( Blocks.GILDED_BLACKSTONE, OttBlocks.SIMPLE_GILDED_BLACKSTONE_CTM, "simple_gilded_blackstone_pillar_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.BORDERED_GILDED_BLACKSTONE, "bordered_gilded_blackstone_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.BRICK_BORDERED_GILDED_BLACKSTONE, "brick_bordered_gilded_blackstone_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.CUT_GILDED_BLACKSTONE_COLUMN, "cut_gilded_blackstone_column_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.EDGED_GILDED_BLACKSTONE_BRICKS, "edged_gilded_blackstone_bricks_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.MASSIVE_GILDED_BLACKSTONE_BRICKS, "massive_gilded_blackstone_bricks_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.OVERLAPPING_GILDED_BLACKSTONE_TILES, "overlapping_gilded_blackstone_tiles_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.POLISHED_GILDED_BLACKSTONE, "polished_gilded_blackstone_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.SMOOTH_GILDED_BLACKSTONE_COLUMN, "smooth_gilded_blackstone_column_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.THICK_INLAYED_GILDED_BLACKSTONE, "thick_inlayed_gilded_blackstone_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.TILED_BORDERED_GILDED_BLACKSTONE, "tiled_bordered_gilded_blackstone_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.TILED_GILDED_BLACKSTONE_COLUMN, "tiled_gilded_blackstone_column_ctm_engraving");
        s.tagged( materialTag("gilded_blackstone"), OttBlocks.TINY_BRICK_BORDERED_GILDED_BLACKSTONE, "tiny_brick_bordered_gilded_blackstone_ctm_engraving");
        // ── glass ──
        s.one( Blocks.GLASS, OttBlocks.ARCHED_LEADED_GLASS_CTM, "arched_leaded_glass_pillar_engraving");
        s.one( Blocks.GLASS, OttBlocks.CIRCULAR_LEADED_STAINED_GLASS, "circular_leaded_stained_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.CLEAR_LEADED_GLASS, "clear_leaded_glass_ctm_engraving");
        s.one( Blocks.GLASS, OttBlocks.CLEAR_LEADED_GLASS_CTM, "clear_leaded_glass_pillar_engraving");
        s.one( Blocks.GLASS, OttBlocks.FANCY_LEADED_GLASS, "fancy_leaded_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.LARGE_DIAMOND_LEADED_GLASS, "large_diamond_leaded_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.LEADED_GLASS, "leaded_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.LEADED_WOVEN_GLASS, "leaded_woven_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_BORDERED_GLASS, "oak_bordered_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_DIAMOND_BORDERED_GLASS, "oak_diamond_bordered_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_HORIZONTAL_LINED_GLASS, "oak_horizontal_lined_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_LARGE_DIAMOND_GLASS, "oak_large_diamond_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_LINE_BARED_GLASS, "oak_line_bared_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_ORNATE_BARED_GLASS, "oak_ornate_bared_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.OAK_WOVEN_GLASS, "oak_woven_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.ORNATE_LEADED_GLASS, "ornate_leaded_glass_ctm_engraving");
        s.one( Blocks.GLASS, OttBlocks.ORNATE_LEADED_GLASS_CTM, "ornate_leaded_glass_pillar_engraving");
        s.one( Blocks.GLASS, OttBlocks.RASTER_LEADED_GLASS, "raster_leaded_glass_ctm_engraving");
        s.one( Blocks.GLASS, OttBlocks.RASTER_LEADED_GLASS_CTM, "raster_leaded_glass_pillar_engraving");
        s.one( Blocks.GLASS, OttBlocks.SMALL_DIAMOND_LEADED_GLASS, "small_diamond_leaded_glass_ctm_engraving");
        s.one( Blocks.GLASS, OttBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM, "small_diamond_leaded_glass_pillar_engraving");
        s.one( Blocks.GLASS, OttBlocks.SQUARE_LEADED_GLASS, "square_leaded_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.SQUARE_OAK_GLASS, "square_oak_glass_engraving");
        s.one( Blocks.GLASS, OttBlocks.VERTICAL_LEADED_GLASS, "vertical_leaded_glass_engraving");
        s.tagged( materialTag("glass"),               OttBlocks.FANCY_LEADED_GLASS_CTM,     "fancy_leaded_glass_pillar_engraving");
        s.tagged( materialTag("glass"), OttBlocks.BORDERLESS_GLASS,          "borderless_glass_ctm_engraving");
        s.tagged( materialTag("glass"), OttBlocks.FRAMED_GLASS,              "framed_glass_ctm_engraving");
        s.tagged( materialTag("glass"), OttBlocks.GOLDEN_FRAMED_STAINED_GLASS, "golden_framed_stained_glass_ctm_engraving");
        s.tagged( materialTag("glass"), OttBlocks.RED_SANDSTONE_FRAMED_GLASS, "red_sandstone_framed_glass_ctm_engraving");
        s.tagged( materialTag("glass"), OttBlocks.SCRATCHED_GLASS,           "scratched_glass_ctm_engraving");
        // ── gold_block ──
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK.get(), "gold_block_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_BEAMS.get(), "gold_block_beams_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_BORDERED.get(), "gold_block_bordered_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_LINES.get(), "gold_block_lines_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_PATTERN.get(), "gold_block_pattern_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_POLISHED.get(), "gold_block_polished_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_SCALES.get(), "gold_block_scales_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_SMALL_BRICKS.get(), "gold_block_small_bricks_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_SMALL_TILES.get(), "gold_block_small_tiles_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_STRIPED.get(), "gold_block_striped_ctm_engraving");
        s.tagged( materialTag("gold_block"), OttBlocks.GOLD_BLOCK_TILES.get(), "gold_block_tiles_ctm_engraving");
        // ── granite ──
        s.one( Blocks.GRANITE, OttBlocks.CURLY_GRANITE_CTM, "curly_granite_pillar_engraving");
        s.one( Blocks.GRANITE, OttBlocks.FINE_GRANITE_CTM, "fine_granite_pillar_engraving");
        s.one( Blocks.GRANITE, OttBlocks.ORNATE_GRANITE_CTM, "ornate_granite_pillar_engraving");
        s.one( Blocks.GRANITE, OttBlocks.SIMPLE_GRANITE_CTM, "simple_granite_pillar_engraving");
        s.tagged( materialTag("granite"), OttBlocks.BORDERED_GRANITE, "bordered_granite_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.BRICK_BORDERED_GRANITE, "brick_bordered_granite_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.CUT_GRANITE_COLUMN, "cut_granite_column_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.EDGED_GRANITE_BRICKS, "edged_granite_bricks_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_BRICKS.get(), "granite_bricks_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_BRICK_PATTERN.get(), "granite_brick_pattern_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_BRICK_PAVING.get(), "granite_brick_paving_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_CUT_POLISHED.get(), "granite_cut_polished_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_CUT_SMALL_BRICK.get(), "granite_cut_small_brick_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_DIAGONAL_BRICKS.get(), "granite_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_DOTTED.get(), "granite_dotted_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_PAVING.get(), "granite_paving_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_POLISHED.get(), "granite_polished_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_PRISMARINE, "granite_prismarine_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_ROTATED_BRICKS.get(), "granite_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_SQUARES.get(), "granite_squares_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_TILES.get(), "granite_tiles_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.GRANITE_WAVY.get(), "granite_wavy_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.MASSIVE_GRANITE_BRICKS, "massive_granite_bricks_engraving");
        s.tagged( materialTag("granite"), OttBlocks.OVERLAPPING_GRANITE_TILES, "overlapping_granite_tiles_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.SMOOTH_GRANITE_COLUMN, "smooth_granite_column_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.THICK_INLAYED_GRANITE, "thick_inlayed_granite_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.TILED_BORDERED_GRANITE, "tiled_bordered_granite_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.TILED_GRANITE_COLUMN, "tiled_granite_column_ctm_engraving");
        s.tagged( materialTag("granite"), OttBlocks.TINY_BRICK_BORDERED_GRANITE, "tiny_brick_bordered_granite_ctm_engraving");
        // ── gray_concrete ──
        s.one( Blocks.GRAY_CONCRETE, OttBlocks.GRAY_CONCRETE_CTM, "gray_concrete_pillar_engraving");
        s.tagged( materialTag("gray_concrete"), OttBlocks.GRAY_CONCRETE_PANEL, "gray_concrete_panel_ctm_engraving");
        s.tagged( materialTag("gray_concrete"), OttBlocks.GRILL_GRAY_CONCRETE, "grill_gray_concrete_ctm_engraving");
        s.tagged( materialTag("gray_concrete"), OttBlocks.PEGGED_GRAY_CONCRETE, "pegged_gray_concrete_ctm_engraving");
        s.tagged( materialTag("gray_concrete"), OttBlocks.SMOOTH_GRAY_CONCRETE, "smooth_gray_concrete_ctm_engraving");
        s.tagged( materialTag("gray_concrete"), OttBlocks.STRIPED_GRAY_CONCRETE, "striped_gray_concrete_ctm_engraving");
        s.tagged( materialTag("gray_concrete"), OttBlocks.WIRED_GRAY_CONCRETE, "wired_gray_concrete_ctm_engraving");
        // ── gray_marble ──
        s.one( OttBlocks.GRAY_MARBLE, OttBlocks.GRAY_MARBLE_BRICKS,       "gray_marble_bricks_engraving");
        s.one( OttBlocks.GRAY_MARBLE, OttBlocks.GRAY_MARBLE_PILLAR,       "gray_marble_pillar_engraving");
        s.one( OttBlocks.GRAY_MARBLE, OttBlocks.GRAY_MARBLE_PILLAR_CAP,   "gray_marble_pillar_cap_engraving");
        s.one( OttBlocks.GRAY_MARBLE, OttBlocks.GRAY_MARBLE_SMALL_BRICKS, "gray_marble_small_bricks_engraving");
        s.one( OttBlocks.GRAY_MARBLE, OttBlocks.GRAY_MARBLE_TILES,        "gray_marble_tiles_engraving");
        s.one( OttBlocks.GRAY_MARBLE, OttBlocks.GRAY_POLISHED_MARBLE,     "gray_polished_marble_engraving");
        // ── gray_terracotta ──
        s.one( Blocks.GRAY_TERRACOTTA, OttBlocks.GRAY_TERRACOTTA_CTM, "gray_terracotta_pillar_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.CIRCULAR_GRAY_TERRACOTTA, "circular_gray_terracotta_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.CURLED_GRAY_TERRACOTTA, "curled_gray_terracotta_ctm_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.GRAY_TERRACOTTA_COLUMN, "gray_terracotta_column_ctm_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.HEXAGONICAL_GRAY_TERRACOTTA, "hexagonical_gray_terracotta_ctm_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.INSCRIBED_GRAY_TERRACOTTA, "inscribed_gray_terracotta_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.SMALL_GRAY_TERRACOTTA_TILES, "small_gray_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("gray_terracotta"), OttBlocks.STARRY_GRAY_TERRACOTTA, "starry_gray_terracotta_engraving");
        // ── green_concrete ──
        s.one( Blocks.GREEN_CONCRETE, OttBlocks.GREEN_CONCRETE_CTM, "green_concrete_pillar_engraving");
        s.tagged( materialTag("green_concrete"), OttBlocks.GREEN_CONCRETE_PANEL, "green_concrete_panel_ctm_engraving");
        s.tagged( materialTag("green_concrete"), OttBlocks.GRILL_GREEN_CONCRETE, "grill_green_concrete_ctm_engraving");
        s.tagged( materialTag("green_concrete"), OttBlocks.PEGGED_GREEN_CONCRETE, "pegged_green_concrete_ctm_engraving");
        s.tagged( materialTag("green_concrete"), OttBlocks.SMOOTH_GREEN_CONCRETE, "smooth_green_concrete_ctm_engraving");
        s.tagged( materialTag("green_concrete"), OttBlocks.STRIPED_GREEN_CONCRETE, "striped_green_concrete_ctm_engraving");
        s.tagged( materialTag("green_concrete"), OttBlocks.WIRED_GREEN_CONCRETE, "wired_green_concrete_ctm_engraving");
        // ── green_marble ──
        s.one( OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_BRICKS,       "green_marble_bricks_engraving");
        s.one( OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_PILLAR,       "green_marble_pillar_engraving");
        s.one( OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_PILLAR_CAP,   "green_marble_pillar_cap_engraving");
        s.one( OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_SMALL_BRICKS, "green_marble_small_bricks_engraving");
        s.one( OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_TILES,        "green_marble_tiles_engraving");
        s.one( OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_POLISHED_MARBLE,     "green_polished_marble_engraving");
        // ── green_terracotta ──
        s.one( Blocks.GREEN_TERRACOTTA, OttBlocks.GREEN_TERRACOTTA_CTM, "green_terracotta_pillar_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.CIRCULAR_GREEN_TERRACOTTA, "circular_green_terracotta_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.CURLED_GREEN_TERRACOTTA, "curled_green_terracotta_ctm_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.GREEN_TERRACOTTA_COLUMN, "green_terracotta_column_ctm_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.HEXAGONICAL_GREEN_TERRACOTTA, "hexagonical_green_terracotta_ctm_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.INSCRIBED_GREEN_TERRACOTTA, "inscribed_green_terracotta_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.SMALL_GREEN_TERRACOTTA_TILES, "small_green_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("green_terracotta"), OttBlocks.STARRY_GREEN_TERRACOTTA, "starry_green_terracotta_engraving");
        // ── ice ──
        s.one( Blocks.ICE, OttBlocks.CURLY_ICE_CTM, "curly_ice_pillar_engraving");
        s.one( Blocks.ICE, OttBlocks.FINE_ICE_CTM, "fine_ice_pillar_engraving");
        s.one( Blocks.ICE, OttBlocks.ORNATE_ICE_CTM, "ornate_ice_pillar_engraving");
        s.one( Blocks.ICE, OttBlocks.SIMPLE_ICE_CTM, "simple_ice_pillar_engraving");
        s.tagged( materialTag("ice"), OttBlocks.BORDERED_ICE, "bordered_ice_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.BRICK_BORDERED_ICE, "brick_bordered_ice_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.CUT_ICE_COLUMN, "cut_ice_column_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.EDGED_ICE_BRICKS, "edged_ice_bricks_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.MASSIVE_ICE_BRICKS, "massive_ice_bricks_engraving");
        s.tagged( materialTag("ice"), OttBlocks.OVERLAPPING_ICE_TILES, "overlapping_ice_tiles_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.POLISHED_ICE, "polished_ice_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.SMOOTH_ICE_COLUMN, "smooth_ice_column_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.THICK_INLAYED_ICE, "thick_inlayed_ice_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.TILED_BORDERED_ICE, "tiled_bordered_ice_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.TILED_ICE_COLUMN, "tiled_ice_column_ctm_engraving");
        s.tagged( materialTag("ice"), OttBlocks.TINY_BRICK_BORDERED_ICE, "tiny_brick_bordered_ice_ctm_engraving");
        // ── iron_block ──
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK.get(), "iron_block_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_BORDERED.get(), "iron_block_bordered_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_CHISELED.get(), "iron_block_chiseled_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_CONNECTING.get(), "iron_block_connecting_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_FRAMED.get(), "iron_block_framed_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_GEARS.get(), "iron_block_gears_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_LINES.get(), "iron_block_lines_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_PATTERNED.get(), "iron_block_patterned_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_PIPES.get(), "iron_block_pipes_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_POLISHED.get(), "iron_block_polished_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_PROCESSED.get(), "iron_block_processed_ctm_engraving");
        s.tagged( materialTag("iron_block"), OttBlocks.IRON_BLOCK_SMALL_BRICKS.get(), "iron_block_small_bricks_ctm_engraving");
        // ── jungle_planks ──
        s.tagged( materialTag("jungle_planks"), OttBlocks.CORNERED_JUNGLE_PLANKS, "cornered_jungle_planks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.CRATED_JUNGLE_PLANKS, "crated_jungle_planks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.ENCLOSED_JUNGLE_PLANKS, "enclosed_jungle_planks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.FRAMED_JUNGLE_PLANKS, "framed_jungle_planks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_BEAMS.get(), "jungle_planks_beams_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_BRICKS.get(), "jungle_planks_bricks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_BRICK_PATTERN.get(), "jungle_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_BRICK_PAVING.get(), "jungle_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_CRATE.get(), "jungle_planks_crate_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_DIAGONAL_STRIPES.get(), "jungle_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_DIAGONAL_TILES.get(), "jungle_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_DOTTED.get(), "jungle_planks_dotted_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_FLOORING.get(), "jungle_planks_flooring_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_LARGE_TILES.get(), "jungle_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_PANEL.get(), "jungle_planks_panel_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_PATTERN.get(), "jungle_planks_pattern_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_ROTATED_BRICKS.get(), "jungle_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_SMALL_BRICKS.get(), "jungle_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_SMALL_TILES.get(), "jungle_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_SQUARES.get(), "jungle_planks_squares_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_TILES.get(), "jungle_planks_tiles_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_WAVY.get(), "jungle_planks_wavy_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.JUNGLE_PLANKS_WOVEN.get(), "jungle_planks_woven_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.NATURAL_JUNGLE_PLANKS, "natural_jungle_planks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.PEGGED_JUNGLE_PLANKS, "pegged_jungle_planks_ctm_engraving");
        s.tagged( materialTag("jungle_planks"), OttBlocks.WHIRLWIND_JUNGLE_PLANKS, "whirlwind_jungle_planks_ctm_engraving");
        // ── lapis_block ──
        s.one( Blocks.LAPIS_BLOCK, OttBlocks.CURLY_LAPIS_BLOCK_CTM, "curly_lapis_block_pillar_engraving");
        s.one( Blocks.LAPIS_BLOCK, OttBlocks.FINE_LAPIS_BLOCK_CTM, "fine_lapis_block_pillar_engraving");
        s.one( Blocks.LAPIS_BLOCK, OttBlocks.ORNATE_LAPIS_BLOCK_CTM, "ornate_lapis_block_pillar_engraving");
        s.one( Blocks.LAPIS_BLOCK, OttBlocks.SIMPLE_LAPIS_BLOCK_CTM, "simple_lapis_block_pillar_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.BORDERED_LAPIS_BLOCK, "bordered_lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.BRICK_BORDERED_LAPIS_BLOCK, "brick_bordered_lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.CUT_LAPIS_BLOCK_COLUMN, "cut_lapis_block_column_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.DELICATE_LAPIS_BLOCK, "delicate_lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.EDGED_LAPIS_BLOCK_BRICKS, "edged_lapis_block_bricks_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK.get(), "lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_BORDERED.get(), "lapis_block_bordered_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_CONNECTING.get(), "lapis_block_connecting_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_DECORATED.get(), "lapis_block_decorated_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_GLOSSY.get(), "lapis_block_glossy_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_INVERTED_TILES.get(), "lapis_block_inverted_tiles_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_MOSAIC.get(), "lapis_block_mosaic_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_PATTERN.get(), "lapis_block_pattern_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_SCALES.get(), "lapis_block_scales_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_SMALL_TILES.get(), "lapis_block_small_tiles_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_STRIPES.get(), "lapis_block_stripes_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.LAPIS_BLOCK_TILES.get(), "lapis_block_tiles_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.MASSIVE_LAPIS_BLOCK_BRICKS, "massive_lapis_block_bricks_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.OVERLAPPING_LAPIS_BLOCK_TILES, "overlapping_lapis_block_tiles_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.POLISHED_LAPIS_BLOCK, "polished_lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.SMOOTH_LAPIS_BLOCK_COLUMN, "smooth_lapis_block_column_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.THICK_INLAYED_LAPIS_BLOCK, "thick_inlayed_lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.TILED_BORDERED_LAPIS_BLOCK, "tiled_bordered_lapis_block_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.TILED_LAPIS_BLOCK_COLUMN, "tiled_lapis_block_column_ctm_engraving");
        s.tagged( materialTag("lapis_block"), OttBlocks.TINY_BRICK_BORDERED_LAPIS_BLOCK, "tiny_brick_bordered_lapis_block_ctm_engraving");
        // ── leaded_glass ──
        s.one( OttBlocks.LEADED_GLASS.get(), OttBlocks.LEADED_GLASS_PANE.get(), "leaded_glass_pane_engraving");
        // ── light_blue_concrete ──
        s.one( Blocks.LIGHT_BLUE_CONCRETE, OttBlocks.LIGHT_BLUE_CONCRETE_CTM, "light_blue_concrete_pillar_engraving");
        s.tagged( materialTag("light_blue_concrete"), OttBlocks.GRILL_LIGHT_BLUE_CONCRETE, "grill_light_blue_concrete_ctm_engraving");
        s.tagged( materialTag("light_blue_concrete"), OttBlocks.LIGHT_BLUE_CONCRETE_PANEL, "light_blue_concrete_panel_ctm_engraving");
        s.tagged( materialTag("light_blue_concrete"), OttBlocks.PEGGED_LIGHT_BLUE_CONCRETE, "pegged_light_blue_concrete_ctm_engraving");
        s.tagged( materialTag("light_blue_concrete"), OttBlocks.SMOOTH_LIGHT_BLUE_CONCRETE, "smooth_light_blue_concrete_ctm_engraving");
        s.tagged( materialTag("light_blue_concrete"), OttBlocks.STRIPED_LIGHT_BLUE_CONCRETE, "striped_light_blue_concrete_ctm_engraving");
        s.tagged( materialTag("light_blue_concrete"), OttBlocks.WIRED_LIGHT_BLUE_CONCRETE, "wired_light_blue_concrete_ctm_engraving");
        // ── light_blue_marble ──
        s.one( OttBlocks.LIGHT_BLUE_MARBLE, OttBlocks.LIGHT_BLUE_MARBLE_BRICKS,       "light_blue_marble_bricks_engraving");
        s.one( OttBlocks.LIGHT_BLUE_MARBLE, OttBlocks.LIGHT_BLUE_MARBLE_PILLAR,       "light_blue_marble_pillar_engraving");
        s.one( OttBlocks.LIGHT_BLUE_MARBLE, OttBlocks.LIGHT_BLUE_MARBLE_PILLAR_CAP,   "light_blue_marble_pillar_cap_engraving");
        s.one( OttBlocks.LIGHT_BLUE_MARBLE, OttBlocks.LIGHT_BLUE_MARBLE_SMALL_BRICKS, "light_blue_marble_small_bricks_engraving");
        s.one( OttBlocks.LIGHT_BLUE_MARBLE, OttBlocks.LIGHT_BLUE_MARBLE_TILES,        "light_blue_marble_tiles_engraving");
        s.one( OttBlocks.LIGHT_BLUE_MARBLE, OttBlocks.LIGHT_BLUE_POLISHED_MARBLE,     "light_blue_polished_marble_engraving");
        // ── light_blue_terracotta ──
        s.one( Blocks.LIGHT_BLUE_TERRACOTTA, OttBlocks.LIGHT_BLUE_TERRACOTTA_CTM, "light_blue_terracotta_pillar_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.CIRCULAR_LIGHT_BLUE_TERRACOTTA, "circular_light_blue_terracotta_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.CURLED_LIGHT_BLUE_TERRACOTTA, "curled_light_blue_terracotta_ctm_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.HEXAGONICAL_LIGHT_BLUE_TERRACOTTA, "hexagonical_light_blue_terracotta_ctm_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.INSCRIBED_LIGHT_BLUE_TERRACOTTA, "inscribed_light_blue_terracotta_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.LIGHT_BLUE_TERRACOTTA_COLUMN, "light_blue_terracotta_column_ctm_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.SMALL_LIGHT_BLUE_TERRACOTTA_TILES, "small_light_blue_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("light_blue_terracotta"), OttBlocks.STARRY_LIGHT_BLUE_TERRACOTTA, "starry_light_blue_terracotta_engraving");
        // ── light_gray_concrete ──
        s.one( Blocks.LIGHT_GRAY_CONCRETE, OttBlocks.LIGHT_GRAY_CONCRETE_CTM, "light_gray_concrete_pillar_engraving");
        s.tagged( materialTag("light_gray_concrete"), OttBlocks.GRILL_LIGHT_GRAY_CONCRETE, "grill_light_gray_concrete_ctm_engraving");
        s.tagged( materialTag("light_gray_concrete"), OttBlocks.LIGHT_GRAY_CONCRETE_PANEL, "light_gray_concrete_panel_ctm_engraving");
        s.tagged( materialTag("light_gray_concrete"), OttBlocks.PEGGED_LIGHT_GRAY_CONCRETE, "pegged_light_gray_concrete_ctm_engraving");
        s.tagged( materialTag("light_gray_concrete"), OttBlocks.SMOOTH_LIGHT_GRAY_CONCRETE, "smooth_light_gray_concrete_ctm_engraving");
        s.tagged( materialTag("light_gray_concrete"), OttBlocks.STRIPED_LIGHT_GRAY_CONCRETE, "striped_light_gray_concrete_ctm_engraving");
        s.tagged( materialTag("light_gray_concrete"), OttBlocks.WIRED_LIGHT_GRAY_CONCRETE, "wired_light_gray_concrete_ctm_engraving");
        // ── light_gray_marble ──
        s.one( OttBlocks.LIGHT_GRAY_MARBLE, OttBlocks.LIGHT_GRAY_MARBLE_BRICKS,       "light_gray_marble_bricks_engraving");
        s.one( OttBlocks.LIGHT_GRAY_MARBLE, OttBlocks.LIGHT_GRAY_MARBLE_PILLAR,       "light_gray_marble_pillar_engraving");
        s.one( OttBlocks.LIGHT_GRAY_MARBLE, OttBlocks.LIGHT_GRAY_MARBLE_PILLAR_CAP,   "light_gray_marble_pillar_cap_engraving");
        s.one( OttBlocks.LIGHT_GRAY_MARBLE, OttBlocks.LIGHT_GRAY_MARBLE_SMALL_BRICKS, "light_gray_marble_small_bricks_engraving");
        s.one( OttBlocks.LIGHT_GRAY_MARBLE, OttBlocks.LIGHT_GRAY_MARBLE_TILES,        "light_gray_marble_tiles_engraving");
        s.one( OttBlocks.LIGHT_GRAY_MARBLE, OttBlocks.LIGHT_GRAY_POLISHED_MARBLE,     "light_gray_polished_marble_engraving");
        // ── light_gray_terracotta ──
        s.one( Blocks.LIGHT_GRAY_TERRACOTTA, OttBlocks.LIGHT_GRAY_TERRACOTTA_CTM, "light_gray_terracotta_pillar_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.CIRCULAR_LIGHT_GRAY_TERRACOTTA, "circular_light_gray_terracotta_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.CURLED_LIGHT_GRAY_TERRACOTTA, "curled_light_gray_terracotta_ctm_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.HEXAGONICAL_LIGHT_GRAY_TERRACOTTA, "hexagonical_light_gray_terracotta_ctm_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.INSCRIBED_LIGHT_GRAY_TERRACOTTA, "inscribed_light_gray_terracotta_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.LIGHT_GRAY_TERRACOTTA_COLUMN, "light_gray_terracotta_column_ctm_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.SMALL_LIGHT_GRAY_TERRACOTTA_TILES, "small_light_gray_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("light_gray_terracotta"), OttBlocks.STARRY_LIGHT_GRAY_TERRACOTTA, "starry_light_gray_terracotta_engraving");
        // ── lime_concrete ──
        s.one( Blocks.LIME_CONCRETE, OttBlocks.LIME_CONCRETE_CTM, "lime_concrete_pillar_engraving");
        s.tagged( materialTag("lime_concrete"), OttBlocks.GRILL_LIME_CONCRETE, "grill_lime_concrete_ctm_engraving");
        s.tagged( materialTag("lime_concrete"), OttBlocks.LIME_CONCRETE_PANEL, "lime_concrete_panel_ctm_engraving");
        s.tagged( materialTag("lime_concrete"), OttBlocks.PEGGED_LIME_CONCRETE, "pegged_lime_concrete_ctm_engraving");
        s.tagged( materialTag("lime_concrete"), OttBlocks.SMOOTH_LIME_CONCRETE, "smooth_lime_concrete_ctm_engraving");
        s.tagged( materialTag("lime_concrete"), OttBlocks.STRIPED_LIME_CONCRETE, "striped_lime_concrete_ctm_engraving");
        s.tagged( materialTag("lime_concrete"), OttBlocks.WIRED_LIME_CONCRETE, "wired_lime_concrete_ctm_engraving");
        // ── lime_marble ──
        s.one( OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_BRICKS,       "lime_marble_bricks_engraving");
        s.one( OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_PILLAR,       "lime_marble_pillar_engraving");
        s.one( OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_PILLAR_CAP,   "lime_marble_pillar_cap_engraving");
        s.one( OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_SMALL_BRICKS, "lime_marble_small_bricks_engraving");
        s.one( OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_TILES,        "lime_marble_tiles_engraving");
        s.one( OttBlocks.LIME_MARBLE, OttBlocks.LIME_POLISHED_MARBLE,     "lime_polished_marble_engraving");
        // ── lime_terracotta ──
        s.one( Blocks.LIME_TERRACOTTA, OttBlocks.LIME_TERRACOTTA_CTM, "lime_terracotta_pillar_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.CIRCULAR_LIME_TERRACOTTA, "circular_lime_terracotta_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.CURLED_LIME_TERRACOTTA, "curled_lime_terracotta_ctm_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.HEXAGONICAL_LIME_TERRACOTTA, "hexagonical_lime_terracotta_ctm_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.INSCRIBED_LIME_TERRACOTTA, "inscribed_lime_terracotta_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.LIME_TERRACOTTA_COLUMN, "lime_terracotta_column_ctm_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.SMALL_LIME_TERRACOTTA_TILES, "small_lime_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("lime_terracotta"), OttBlocks.STARRY_LIME_TERRACOTTA, "starry_lime_terracotta_engraving");
        // ── limestone ──
        s.tagged( materialTag("limestone"), OttBlocks.LIMESTONE_CUT_POLISHED.get(), "limestone_cut_polished_ctm_engraving");
        s.tagged( materialTag("limestone"), OttBlocks.LIMESTONE_CUT_SMALL_BRICK.get(), "limestone_cut_small_brick_ctm_engraving");
        // ── lodestone ──
        s.one( Blocks.LODESTONE, OttBlocks.CURLY_LODESTONE_CTM, "curly_lodestone_pillar_engraving");
        s.one( Blocks.LODESTONE, OttBlocks.FINE_LODESTONE_CTM, "fine_lodestone_pillar_engraving");
        s.one( Blocks.LODESTONE, OttBlocks.ORNATE_LODESTONE_CTM, "ornate_lodestone_pillar_engraving");
        s.one( Blocks.LODESTONE, OttBlocks.SIMPLE_LODESTONE_CTM, "simple_lodestone_pillar_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.BORDERED_LODESTONE, "bordered_lodestone_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.BRICK_BORDERED_LODESTONE, "brick_bordered_lodestone_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.CUT_LODESTONE_COLUMN, "cut_lodestone_column_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.EDGED_LODESTONE_BRICKS, "edged_lodestone_bricks_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.MASSIVE_LODESTONE_BRICKS, "massive_lodestone_bricks_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.OVERLAPPING_LODESTONE_TILES, "overlapping_lodestone_tiles_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.POLISHED_LODESTONE, "polished_lodestone_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.SMOOTH_LODESTONE_COLUMN, "smooth_lodestone_column_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.THICK_INLAYED_LODESTONE, "thick_inlayed_lodestone_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.TILED_BORDERED_LODESTONE, "tiled_bordered_lodestone_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.TILED_LODESTONE_COLUMN, "tiled_lodestone_column_ctm_engraving");
        s.tagged( materialTag("lodestone"), OttBlocks.TINY_BRICK_BORDERED_LODESTONE, "tiny_brick_bordered_lodestone_ctm_engraving");
        // ── magenta_concrete ──
        s.one( Blocks.MAGENTA_CONCRETE, OttBlocks.MAGENTA_CONCRETE_CTM, "magenta_concrete_pillar_engraving");
        s.tagged( materialTag("magenta_concrete"), OttBlocks.GRILL_MAGENTA_CONCRETE, "grill_magenta_concrete_ctm_engraving");
        s.tagged( materialTag("magenta_concrete"), OttBlocks.MAGENTA_CONCRETE_PANEL, "magenta_concrete_panel_ctm_engraving");
        s.tagged( materialTag("magenta_concrete"), OttBlocks.PEGGED_MAGENTA_CONCRETE, "pegged_magenta_concrete_ctm_engraving");
        s.tagged( materialTag("magenta_concrete"), OttBlocks.SMOOTH_MAGENTA_CONCRETE, "smooth_magenta_concrete_ctm_engraving");
        s.tagged( materialTag("magenta_concrete"), OttBlocks.STRIPED_MAGENTA_CONCRETE, "striped_magenta_concrete_ctm_engraving");
        s.tagged( materialTag("magenta_concrete"), OttBlocks.WIRED_MAGENTA_CONCRETE, "wired_magenta_concrete_ctm_engraving");
        // ── magenta_marble ──
        s.one( OttBlocks.MAGENTA_MARBLE, OttBlocks.MAGENTA_MARBLE_BRICKS,       "magenta_marble_bricks_engraving");
        s.one( OttBlocks.MAGENTA_MARBLE, OttBlocks.MAGENTA_MARBLE_PILLAR,       "magenta_marble_pillar_engraving");
        s.one( OttBlocks.MAGENTA_MARBLE, OttBlocks.MAGENTA_MARBLE_PILLAR_CAP,   "magenta_marble_pillar_cap_engraving");
        s.one( OttBlocks.MAGENTA_MARBLE, OttBlocks.MAGENTA_MARBLE_SMALL_BRICKS, "magenta_marble_small_bricks_engraving");
        s.one( OttBlocks.MAGENTA_MARBLE, OttBlocks.MAGENTA_MARBLE_TILES,        "magenta_marble_tiles_engraving");
        s.one( OttBlocks.MAGENTA_MARBLE, OttBlocks.MAGENTA_POLISHED_MARBLE,     "magenta_polished_marble_engraving");
        // ── magenta_terracotta ──
        s.one( Blocks.MAGENTA_TERRACOTTA, OttBlocks.MAGENTA_TERRACOTTA_CTM, "magenta_terracotta_pillar_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.CIRCULAR_MAGENTA_TERRACOTTA, "circular_magenta_terracotta_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.CURLED_MAGENTA_TERRACOTTA, "curled_magenta_terracotta_ctm_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.HEXAGONICAL_MAGENTA_TERRACOTTA, "hexagonical_magenta_terracotta_ctm_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.INSCRIBED_MAGENTA_TERRACOTTA, "inscribed_magenta_terracotta_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.MAGENTA_TERRACOTTA_COLUMN, "magenta_terracotta_column_ctm_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.SMALL_MAGENTA_TERRACOTTA_TILES, "small_magenta_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("magenta_terracotta"), OttBlocks.STARRY_MAGENTA_TERRACOTTA, "starry_magenta_terracotta_engraving");
        // ── magma_block ──
        s.one( Blocks.MAGMA_BLOCK, OttBlocks.CURLY_MAGMA_BLOCK_CTM, "curly_magma_block_pillar_engraving");
        s.one( Blocks.MAGMA_BLOCK, OttBlocks.FINE_MAGMA_BLOCK_CTM, "fine_magma_block_pillar_engraving");
        s.one( Blocks.MAGMA_BLOCK, OttBlocks.ORNATE_MAGMA_BLOCK_CTM, "ornate_magma_block_pillar_engraving");
        s.one( Blocks.MAGMA_BLOCK, OttBlocks.SIMPLE_MAGMA_BLOCK_CTM, "simple_magma_block_pillar_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.BORDERED_MAGMA_BLOCK, "bordered_magma_block_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.BRICK_BORDERED_MAGMA_BLOCK, "brick_bordered_magma_block_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.CUT_MAGMA_BLOCK_COLUMN, "cut_magma_block_column_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.EDGED_MAGMA_BLOCK_BRICKS, "edged_magma_block_bricks_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.MASSIVE_MAGMA_BLOCK_BRICKS, "massive_magma_block_bricks_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.OVERLAPPING_MAGMA_BLOCK_TILES, "overlapping_magma_block_tiles_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.POLISHED_MAGMA_BLOCK, "polished_magma_block_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.SMOOTH_MAGMA_BLOCK_COLUMN, "smooth_magma_block_column_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.THICK_INLAYED_MAGMA_BLOCK, "thick_inlayed_magma_block_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.TILED_BORDERED_MAGMA_BLOCK, "tiled_bordered_magma_block_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.TILED_MAGMA_BLOCK_COLUMN, "tiled_magma_block_column_ctm_engraving");
        s.tagged( materialTag("magma_block"), OttBlocks.TINY_BRICK_BORDERED_MAGMA_BLOCK, "tiny_brick_bordered_magma_block_ctm_engraving");
        // ── mangrove_planks ──
        s.tagged( materialTag("mangrove_planks"), OttBlocks.CORNERED_MANGROVE_PLANKS, "cornered_mangrove_planks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.CRATED_MANGROVE_PLANKS, "crated_mangrove_planks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.ENCLOSED_MANGROVE_PLANKS, "enclosed_mangrove_planks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.FRAMED_MANGROVE_PLANKS, "framed_mangrove_planks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_BEAMS.get(), "mangrove_planks_beams_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_BRICKS.get(), "mangrove_planks_bricks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_BRICK_PATTERN.get(), "mangrove_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_BRICK_PAVING.get(), "mangrove_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_CRATE.get(), "mangrove_planks_crate_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_DIAGONAL_STRIPES.get(), "mangrove_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_DIAGONAL_TILES.get(), "mangrove_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_DOTTED.get(), "mangrove_planks_dotted_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_FLOORING.get(), "mangrove_planks_flooring_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_LARGE_TILES.get(), "mangrove_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_PANEL, "mangrove_planks_panel_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_PATTERN.get(), "mangrove_planks_pattern_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_ROTATED_BRICKS.get(), "mangrove_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_SMALL_BRICKS.get(), "mangrove_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_SMALL_TILES.get(), "mangrove_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_SQUARES.get(), "mangrove_planks_squares_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_TILES.get(), "mangrove_planks_tiles_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_WAVY.get(), "mangrove_planks_wavy_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.MANGROVE_PLANKS_WOVEN.get(), "mangrove_planks_woven_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.NATURAL_MANGROVE_PLANKS, "natural_mangrove_planks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.PEGGED_MANGROVE_PLANKS, "pegged_mangrove_planks_ctm_engraving");
        s.tagged( materialTag("mangrove_planks"), OttBlocks.WHIRLWIND_MANGROVE_PLANKS, "whirlwind_mangrove_planks_ctm_engraving");
        // ── mossy_cobblestone ──
        s.one( Blocks.MOSSY_COBBLESTONE, OttBlocks.CURLY_MOSSY_COBBLESTONE_CTM, "curly_mossy_cobblestone_pillar_engraving");
        s.one( Blocks.MOSSY_COBBLESTONE, OttBlocks.FINE_MOSSY_COBBLESTONE_CTM, "fine_mossy_cobblestone_pillar_engraving");
        s.one( Blocks.MOSSY_COBBLESTONE, OttBlocks.ORNATE_MOSSY_COBBLESTONE_CTM, "ornate_mossy_cobblestone_pillar_engraving");
        s.one( Blocks.MOSSY_COBBLESTONE, OttBlocks.SIMPLE_MOSSY_COBBLESTONE_CTM, "simple_mossy_cobblestone_pillar_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.BORDERED_MOSSY_COBBLESTONE, "bordered_mossy_cobblestone_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.BRICK_BORDERED_MOSSY_COBBLESTONE, "brick_bordered_mossy_cobblestone_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.CUT_MOSSY_COBBLESTONE_COLUMN, "cut_mossy_cobblestone_column_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.EDGED_MOSSY_COBBLESTONE_BRICKS, "edged_mossy_cobblestone_bricks_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MASSIVE_MOSSY_COBBLESTONE_BRICKS, "massive_mossy_cobblestone_bricks_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_BEAMS.get(), "mossy_cobblestone_beams_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_DENTED.get(), "mossy_cobblestone_dented_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_INVERTED_DENTED.get(), "mossy_cobblestone_inverted_dented_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_PAVING.get(), "mossy_cobblestone_paving_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_SMALL_TILES.get(), "mossy_cobblestone_small_tiles_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_SQUARES.get(), "mossy_cobblestone_squares_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_STRIPES.get(), "mossy_cobblestone_stripes_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.MOSSY_COBBLESTONE_WORN_STRIPES.get(), "mossy_cobblestone_worn_stripes_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.OVERLAPPING_MOSSY_COBBLESTONE_TILES, "overlapping_mossy_cobblestone_tiles_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.POLISHED_MOSSY_COBBLESTONE, "polished_mossy_cobblestone_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.SMOOTH_MOSSY_COBBLESTONE_COLUMN, "smooth_mossy_cobblestone_column_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.THICK_INLAYED_MOSSY_COBBLESTONE, "thick_inlayed_mossy_cobblestone_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.TILED_BORDERED_MOSSY_COBBLESTONE, "tiled_bordered_mossy_cobblestone_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.TILED_MOSSY_COBBLESTONE_COLUMN, "tiled_mossy_cobblestone_column_ctm_engraving");
        s.tagged( materialTag("mossy_cobblestone"), OttBlocks.TINY_BRICK_BORDERED_MOSSY_COBBLESTONE, "tiny_brick_bordered_mossy_cobblestone_ctm_engraving");
        // ── mossy_stone_bricks ──
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.BORDERED_MOSSY_STONE_BRICKS, "bordered_mossy_stone_bricks_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.BRICK_BORDERED_MOSSY_STONE_BRICKS, "brick_bordered_mossy_stone_bricks_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.CURLY_MOSSY_STONE_BRICKS_CTM, "curly_mossy_stone_bricks_pillar_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.CUT_MOSSY_STONE_BRICKS_COLUMN, "cut_mossy_stone_bricks_column_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.EDGED_MOSSY_STONE_BRICKS_BRICKS, "edged_mossy_stone_bricks_bricks_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.FINE_MOSSY_STONE_BRICKS_CTM, "fine_mossy_stone_bricks_pillar_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.MASSIVE_MOSSY_STONE_BRICKS_BRICKS, "massive_mossy_stone_bricks_bricks_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.ORNATE_MOSSY_STONE_BRICKS_CTM, "ornate_mossy_stone_bricks_pillar_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.OVERLAPPING_MOSSY_STONE_BRICKS_TILES, "overlapping_mossy_stone_bricks_tiles_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.POLISHED_MOSSY_STONE_BRICKS, "polished_mossy_stone_bricks_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.SIMPLE_MOSSY_STONE_BRICKS_CTM, "simple_mossy_stone_bricks_pillar_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.SMOOTH_MOSSY_STONE_BRICKS_COLUMN, "smooth_mossy_stone_bricks_column_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.THICK_INLAYED_MOSSY_STONE_BRICKS, "thick_inlayed_mossy_stone_bricks_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.TILED_BORDERED_MOSSY_STONE_BRICKS, "tiled_bordered_mossy_stone_bricks_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.TILED_MOSSY_STONE_BRICKS_COLUMN, "tiled_mossy_stone_bricks_column_ctm_engraving");
        s.one( Blocks.MOSSY_STONE_BRICKS, OttBlocks.TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS, "tiny_brick_bordered_mossy_stone_bricks_ctm_engraving");
        // ── mud ──
        s.one( Blocks.MUD, OttBlocks.CARVED_MUD_CTM, "carved_mud_pillar_engraving");
        s.one( Blocks.MUD, OttBlocks.CURLY_MUD_CTM, "curly_mud_pillar_engraving");
        s.one( Blocks.MUD, OttBlocks.FANCY_MUD_CTM, "fancy_mud_pillar_engraving");
        s.one( Blocks.MUD, OttBlocks.FINE_MUD_CTM, "fine_mud_pillar_engraving");
        s.one( Blocks.MUD, OttBlocks.ORNATE_MUD_CTM, "ornate_mud_pillar_engraving");
        s.one( Blocks.MUD, OttBlocks.SIMPLE_MUD_CTM, "simple_mud_pillar_engraving");
        s.tagged( materialTag("mud"), OttBlocks.BORDERED_MUD, "bordered_mud_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.BRICK_BORDERED_MUD, "brick_bordered_mud_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.EDGED_MUD, "edged_mud_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.HARD_MUD, "hard_mud_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.LARGE_MUD_SIGIL, "large_mud_sigil_engraving");
        s.tagged( materialTag("mud"), OttBlocks.LOREFUL_MUD, "loreful_mud_engraving");
        s.tagged( materialTag("mud"), OttBlocks.MASSIVE_MUD_BRICKS, "massive_mud_bricks_engraving");
        s.tagged( materialTag("mud"), OttBlocks.OVERLAPPING_MUD_TILES, "overlapping_mud_tiles_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.SCALY_MUD, "scaly_mud_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.TILED_BORDERED_MUD, "tiled_bordered_mud_ctm_engraving");
        s.tagged( materialTag("mud"), OttBlocks.TILED_MUD_COLUMN, "tiled_mud_column_ctm_engraving");
        // ── mud_bricks ──
        s.one( Blocks.MUD_BRICKS, OttBlocks.CARVED_MUD_BRICKS_CTM, "carved_mud_bricks_pillar_engraving");
        s.one( Blocks.MUD_BRICKS, OttBlocks.CURLY_MUD_BRICKS_CTM, "curly_mud_bricks_pillar_engraving");
        s.one( Blocks.MUD_BRICKS, OttBlocks.FANCY_MUD_BRICKS_CTM, "fancy_mud_bricks_pillar_engraving");
        s.one( Blocks.MUD_BRICKS, OttBlocks.FINE_MUD_BRICKS_CTM, "fine_mud_bricks_pillar_engraving");
        s.one( Blocks.MUD_BRICKS, OttBlocks.ORNATE_MUD_BRICKS_CTM, "ornate_mud_bricks_pillar_engraving");
        s.one( Blocks.MUD_BRICKS, OttBlocks.SIMPLE_MUD_BRICKS_CTM, "simple_mud_bricks_pillar_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.BORDERED_MUD_BRICKS, "bordered_mud_bricks_ctm_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.BRICK_BORDERED_MUD_BRICKS, "brick_bordered_mud_bricks_ctm_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.EDGED_MUD_BRICKS_BRICKS, "edged_mud_bricks_bricks_ctm_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.HARD_MUD_BRICKS, "hard_mud_bricks_ctm_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.LARGE_MUD_BRICKS_SIGIL, "large_mud_bricks_sigil_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.LOREFUL_MUD_BRICKS, "loreful_mud_bricks_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.MASSIVE_MUD_BRICKS_BRICKS, "massive_mud_bricks_bricks_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.OVERLAPPING_MUD_BRICKS_TILES, "overlapping_mud_bricks_tiles_ctm_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.TILED_BORDERED_MUD_BRICKS, "tiled_bordered_mud_bricks_ctm_engraving");
        s.tagged( materialTag("mud_bricks"), OttBlocks.TILED_MUD_BRICKS_COLUMN, "tiled_mud_bricks_column_ctm_engraving");
        // ── nether_bricks ──
        s.one( Blocks.NETHER_BRICKS, OttBlocks.CURLY_NETHER_BRICKS_CTM, "curly_nether_bricks_pillar_engraving");
        s.one( Blocks.NETHER_BRICKS, OttBlocks.FINE_NETHER_BRICKS_CTM, "fine_nether_bricks_pillar_engraving");
        s.one( Blocks.NETHER_BRICKS, OttBlocks.ORNATE_NETHER_BRICKS_CTM, "ornate_nether_bricks_pillar_engraving");
        s.one( Blocks.NETHER_BRICKS, OttBlocks.SIMPLE_NETHER_BRICKS_CTM, "simple_nether_bricks_pillar_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.BORDERED_NETHER_BRICKS, "bordered_nether_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.BRICK_BORDERED_NETHER_BRICKS, "brick_bordered_nether_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.CUT_NETHER_BRICKS_COLUMN, "cut_nether_bricks_column_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.EDGED_NETHER_BRICKS_BRICKS, "edged_nether_bricks_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.MASSIVE_NETHER_BRICKS_BRICKS, "massive_nether_bricks_bricks_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_BEAMS.get(), "nether_bricks_beams_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_BRICK_PATTERN.get(), "nether_bricks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_BRICK_PAVING.get(), "nether_bricks_brick_paving_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_CHISELED_SQUARES.get(), "nether_bricks_chiseled_squares_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_DIAGONAL_BRICKS.get(), "nether_bricks_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_LARGE_BRICKS.get(), "nether_bricks_large_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_LARGE_TILES.get(), "nether_bricks_large_tiles_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_ROTATED_BRICKS.get(), "nether_bricks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_SMALL_TILES.get(), "nether_bricks_small_tiles_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_SMOOTH.get(), "nether_bricks_smooth_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_SQUARES.get(), "nether_bricks_squares_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.NETHER_BRICKS_TILES.get(), "nether_bricks_tiles_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.OVERLAPPING_NETHER_BRICKS_TILES, "overlapping_nether_bricks_tiles_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.POLISHED_NETHER_BRICKS, "polished_nether_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.SMOOTH_NETHER_BRICKS_COLUMN, "smooth_nether_bricks_column_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.THICK_INLAYED_NETHER_BRICKS, "thick_inlayed_nether_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.TILED_BORDERED_NETHER_BRICKS, "tiled_bordered_nether_bricks_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.TILED_NETHER_BRICKS_COLUMN, "tiled_nether_bricks_column_ctm_engraving");
        s.tagged( materialTag("nether_bricks"), OttBlocks.TINY_BRICK_BORDERED_NETHER_BRICKS, "tiny_brick_bordered_nether_bricks_ctm_engraving");
        // ── netherite_block ──
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_BEAMS.get(), "netherite_block_beams_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_BRICKS.get(), "netherite_block_bricks_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_CHISELED.get(), "netherite_block_chiseled_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_COMPACTED.get(), "netherite_block_compacted_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_DECORATED.get(), "netherite_block_decorated_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_DIAGONAL_TILES.get(), "netherite_block_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_INDENTED.get(), "netherite_block_indented_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_PATTERNED.get(), "netherite_block_patterned_ctm_engraving");
        s.tagged( materialTag("netherite_block"), OttBlocks.NETHERITE_BLOCK_SMALL_TILES.get(), "netherite_block_small_tiles_ctm_engraving");
        // ── netherrack ──
        s.one( Blocks.NETHERRACK, OttBlocks.CURLY_NETHERRACK_CTM, "curly_netherrack_pillar_engraving");
        s.one( Blocks.NETHERRACK, OttBlocks.FINE_NETHERRACK_CTM, "fine_netherrack_pillar_engraving");
        s.one( Blocks.NETHERRACK, OttBlocks.ORNATE_NETHERRACK_CTM, "ornate_netherrack_pillar_engraving");
        s.one( Blocks.NETHERRACK, OttBlocks.SIMPLE_NETHERRACK_CTM, "simple_netherrack_pillar_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.BORDERED_NETHERRACK, "bordered_netherrack_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.BRICK_BORDERED_NETHERRACK, "brick_bordered_netherrack_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.CUT_NETHERRACK_COLUMN, "cut_netherrack_column_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.EDGED_NETHERRACK_BRICKS, "edged_netherrack_bricks_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.MASSIVE_NETHERRACK_BRICKS, "massive_netherrack_bricks_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_BEAMS.get(), "netherrack_beams_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_BRICKS.get(), "netherrack_bricks_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_BRICK_PATTERN.get(), "netherrack_brick_pattern_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_BRICK_PAVING.get(), "netherrack_brick_paving_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_DENTED.get(), "netherrack_dented_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_ROTATED_BRICKS.get(), "netherrack_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_SMALL_TILES.get(), "netherrack_small_tiles_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_STRIPES.get(), "netherrack_stripes_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.NETHERRACK_TILES.get(), "netherrack_tiles_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.OVERLAPPING_NETHERRACK_TILES, "overlapping_netherrack_tiles_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.POLISHED_NETHERRACK, "polished_netherrack_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.SMOOTH_NETHERRACK_COLUMN, "smooth_netherrack_column_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.THICK_INLAYED_NETHERRACK, "thick_inlayed_netherrack_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.TILED_BORDERED_NETHERRACK, "tiled_bordered_netherrack_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.TILED_NETHERRACK_COLUMN, "tiled_netherrack_column_ctm_engraving");
        s.tagged( materialTag("netherrack"), OttBlocks.TINY_BRICK_BORDERED_NETHERRACK, "tiny_brick_bordered_netherrack_ctm_engraving");
        // ── oak_diamond_bordered_glass ──
        s.one( OttBlocks.OAK_DIAMOND_BORDERED_GLASS.get(), OttBlocks.OAK_DIAMOND_BORDERED_GLASS_PANE.get(), "oak_diamond_bordered_glass_pane_engraving");
        // ── oak_horizontal_lined_glass ──
        s.one( OttBlocks.OAK_HORIZONTAL_LINED_GLASS.get(), OttBlocks.OAK_HORIZONTAL_LINED_GLASS_PANE.get(), "oak_horizontal_lined_glass_pane_engraving");
        // ── oak_large_diamond_glass ──
        s.one( OttBlocks.OAK_LARGE_DIAMOND_GLASS.get(), OttBlocks.OAK_LARGE_DIAMOND_GLASS_PANE.get(), "oak_large_diamond_glass_pane_engraving");
        // ── oak_line_bared_glass ──
        s.one( OttBlocks.OAK_LINE_BARED_GLASS.get(), OttBlocks.OAK_LINE_BARED_GLASS_PANE.get(), "oak_line_bared_glass_pane_engraving");
        // ── oak_ornate_bared_glass ──
        s.one( OttBlocks.OAK_ORNATE_BARED_GLASS.get(), OttBlocks.OAK_ORNATE_BARED_GLASS_PANE.get(), "oak_ornate_bared_glass_pane_engraving");
        // ── oak_planks ──
        s.tagged( materialTag("oak_planks"),          OttBlocks.CIRCLE_OAK_GLASS,           "circle_oak_glass_engraving");
        s.tagged( materialTag("oak_planks"),          OttBlocks.OAK_BARRED_GLASS,           "oak_barred_glass_engraving");
        s.tagged( materialTag("oak_planks"),          OttBlocks.OAK_BARRED_GLASS_CTM,       "oak_barred_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"),          OttBlocks.OAK_SNOWFLAKE_GLASS,        "oak_snowflake_glass_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.CORNERED_OAK_PLANKS, "cornered_oak_planks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.CRATED_OAK_PLANKS, "crated_oak_planks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.ENCLOSED_OAK_PLANKS, "enclosed_oak_planks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.FRAMED_OAK_PLANKS, "framed_oak_planks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.NATURAL_OAK_PLANKS, "natural_oak_planks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_BORDERED_GLASS_CTM, "oak_bordered_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM, "oak_diamond_bordered_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM, "oak_horizontal_lined_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_LARGE_DIAMOND_GLASS_CTM, "oak_large_diamond_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_LINE_BARED_GLASS_CTM, "oak_line_bared_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_ORNATE_BARED_GLASS_CTM, "oak_ornate_bared_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_BEAMS.get(), "oak_planks_beams_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_BRICKS.get(), "oak_planks_bricks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_BRICK_PATTERN.get(), "oak_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_BRICK_PAVING.get(), "oak_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_CRATE.get(), "oak_planks_crate_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_DIAGONAL_STRIPES.get(), "oak_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_DIAGONAL_TILES.get(), "oak_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_DOTTED.get(), "oak_planks_dotted_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_FLOORING.get(), "oak_planks_flooring_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_LARGE_TILES.get(), "oak_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_PANEL, "oak_planks_panel_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_PATTERN.get(), "oak_planks_pattern_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_ROTATED_BRICKS.get(), "oak_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_SMALL_BRICKS.get(), "oak_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_SMALL_TILES.get(), "oak_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_SQUARES.get(), "oak_planks_squares_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_TILES.get(), "oak_planks_tiles_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_WAVY.get(), "oak_planks_wavy_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_PLANKS_WOVEN.get(), "oak_planks_woven_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.OAK_WOVEN_GLASS_CTM, "oak_woven_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.PEGGED_OAK_PLANKS, "pegged_oak_planks_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.SQUARE_OAK_GLASS_CTM, "square_oak_glass_ctm_engraving");
        s.tagged( materialTag("oak_planks"), OttBlocks.WHIRLWIND_OAK_PLANKS, "whirlwind_oak_planks_ctm_engraving");
        // ── oak_woven_glass ──
        s.one( OttBlocks.OAK_WOVEN_GLASS.get(), OttBlocks.OAK_WOVEN_GLASS_PANE.get(), "oak_woven_glass_pane_engraving");
        // ── obsidian ──
        s.one( Blocks.OBSIDIAN, OttBlocks.CURLY_OBSIDIAN_CTM, "curly_obsidian_pillar_engraving");
        s.one( Blocks.OBSIDIAN, OttBlocks.FINE_OBSIDIAN_CTM, "fine_obsidian_pillar_engraving");
        s.one( Blocks.OBSIDIAN, OttBlocks.ORNATE_OBSIDIAN_CTM, "ornate_obsidian_pillar_engraving");
        s.one( Blocks.OBSIDIAN, OttBlocks.SIMPLE_OBSIDIAN_CTM, "simple_obsidian_pillar_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.BORDERED_OBSIDIAN, "bordered_obsidian_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.BRICK_BORDERED_OBSIDIAN, "brick_bordered_obsidian_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.CUT_OBSIDIAN_COLUMN, "cut_obsidian_column_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.EDGED_OBSIDIAN_BRICKS, "edged_obsidian_bricks_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.MASSIVE_OBSIDIAN_BRICKS, "massive_obsidian_bricks_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_BORDERED.get(), "obsidian_bordered_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_BRICKS.get(), "obsidian_bricks_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_BRICK_PATTERN.get(), "obsidian_brick_pattern_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_BRICK_PAVING.get(), "obsidian_brick_paving_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_CHISELED.get(), "obsidian_chiseled_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_CHISELED_CIRCLES.get(), "obsidian_chiseled_circles_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_DARK.get(), "obsidian_dark_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_ROTATED_BRICKS.get(), "obsidian_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_SPOTS.get(), "obsidian_spots_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_SQUARES.get(), "obsidian_squares_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_STRIPES.get(), "obsidian_stripes_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OBSIDIAN_TILES.get(), "obsidian_tiles_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.OVERLAPPING_OBSIDIAN_TILES, "overlapping_obsidian_tiles_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.POLISHED_OBSIDIAN, "polished_obsidian_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.SMOOTH_OBSIDIAN_COLUMN, "smooth_obsidian_column_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.THICK_INLAYED_OBSIDIAN, "thick_inlayed_obsidian_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.TILED_BORDERED_OBSIDIAN, "tiled_bordered_obsidian_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.TILED_OBSIDIAN_COLUMN, "tiled_obsidian_column_ctm_engraving");
        s.tagged( materialTag("obsidian"), OttBlocks.TINY_BRICK_BORDERED_OBSIDIAN, "tiny_brick_bordered_obsidian_ctm_engraving");
        // ── ochre_froglight ──
        s.tagged( materialTag("ochre_froglight"),       OttBlocks.GLASS_OCHRE_FROGLIGHT,       "glass_ochre_froglight_engraving");
        // ── orange_concrete ──
        s.one( Blocks.ORANGE_CONCRETE, OttBlocks.ORANGE_CONCRETE_CTM, "orange_concrete_pillar_engraving");
        s.tagged( materialTag("orange_concrete"), OttBlocks.GRILL_ORANGE_CONCRETE, "grill_orange_concrete_ctm_engraving");
        s.tagged( materialTag("orange_concrete"), OttBlocks.ORANGE_CONCRETE_PANEL, "orange_concrete_panel_ctm_engraving");
        s.tagged( materialTag("orange_concrete"), OttBlocks.PEGGED_ORANGE_CONCRETE, "pegged_orange_concrete_ctm_engraving");
        s.tagged( materialTag("orange_concrete"), OttBlocks.SMOOTH_ORANGE_CONCRETE, "smooth_orange_concrete_ctm_engraving");
        s.tagged( materialTag("orange_concrete"), OttBlocks.STRIPED_ORANGE_CONCRETE, "striped_orange_concrete_ctm_engraving");
        s.tagged( materialTag("orange_concrete"), OttBlocks.WIRED_ORANGE_CONCRETE, "wired_orange_concrete_ctm_engraving");
        // ── orange_marble ──
        s.one( OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_BRICKS,       "orange_marble_bricks_engraving");
        s.one( OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_PILLAR,       "orange_marble_pillar_engraving");
        s.one( OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_PILLAR_CAP,   "orange_marble_pillar_cap_engraving");
        s.one( OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_SMALL_BRICKS, "orange_marble_small_bricks_engraving");
        s.one( OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_TILES,        "orange_marble_tiles_engraving");
        s.one( OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_POLISHED_MARBLE,     "orange_polished_marble_engraving");
        // ── orange_terracotta ──
        s.one( Blocks.ORANGE_TERRACOTTA, OttBlocks.ORANGE_TERRACOTTA_CTM, "orange_terracotta_pillar_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.CIRCULAR_ORANGE_TERRACOTTA, "circular_orange_terracotta_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.CURLED_ORANGE_TERRACOTTA, "curled_orange_terracotta_ctm_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.HEXAGONICAL_ORANGE_TERRACOTTA, "hexagonical_orange_terracotta_ctm_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.INSCRIBED_ORANGE_TERRACOTTA, "inscribed_orange_terracotta_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.ORANGE_TERRACOTTA_COLUMN, "orange_terracotta_column_ctm_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.SMALL_ORANGE_TERRACOTTA_TILES, "small_orange_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("orange_terracotta"), OttBlocks.STARRY_ORANGE_TERRACOTTA, "starry_orange_terracotta_engraving");
        // ── oxidized_copper ──
        s.tagged( materialTag("oxidized_copper"), OttBlocks.OXIDIZED_COPPER_BLOCK.get(), "oxidized_copper_block_ctm_engraving");
        // ── oxidized_copper_grate ──
        s.tagged( materialTag("oxidized_copper_grate"), OttBlocks.OXIDIZED_COPPER_GRATE.get(), "oxidized_copper_grate_ctm_engraving");
        // ── packed_ice ──
        s.one( Blocks.PACKED_ICE, OttBlocks.CURLY_PACKED_ICE_CTM, "curly_packed_ice_pillar_engraving");
        s.one( Blocks.PACKED_ICE, OttBlocks.FINE_PACKED_ICE_CTM, "fine_packed_ice_pillar_engraving");
        s.one( Blocks.PACKED_ICE, OttBlocks.ORNATE_PACKED_ICE_CTM, "ornate_packed_ice_pillar_engraving");
        s.one( Blocks.PACKED_ICE, OttBlocks.SIMPLE_PACKED_ICE_CTM, "simple_packed_ice_pillar_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.BORDERED_PACKED_ICE, "bordered_packed_ice_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.BRICK_BORDERED_PACKED_ICE, "brick_bordered_packed_ice_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.CUT_PACKED_ICE_COLUMN, "cut_packed_ice_column_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.EDGED_PACKED_ICE_BRICKS, "edged_packed_ice_bricks_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.MASSIVE_PACKED_ICE_BRICKS, "massive_packed_ice_bricks_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.OVERLAPPING_PACKED_ICE_TILES, "overlapping_packed_ice_tiles_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.POLISHED_PACKED_ICE, "polished_packed_ice_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.SMOOTH_PACKED_ICE_COLUMN, "smooth_packed_ice_column_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.THICK_INLAYED_PACKED_ICE, "thick_inlayed_packed_ice_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.TILED_BORDERED_PACKED_ICE, "tiled_bordered_packed_ice_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.TILED_PACKED_ICE_COLUMN, "tiled_packed_ice_column_ctm_engraving");
        s.tagged( materialTag("packed_ice"), OttBlocks.TINY_BRICK_BORDERED_PACKED_ICE, "tiny_brick_bordered_packed_ice_ctm_engraving");
        // ── packed_mud ──
        s.one( Blocks.PACKED_MUD, OttBlocks.CARVED_PACKED_MUD_CTM, "carved_packed_mud_pillar_engraving");
        s.one( Blocks.PACKED_MUD, OttBlocks.CURLY_PACKED_MUD_CTM, "curly_packed_mud_pillar_engraving");
        s.one( Blocks.PACKED_MUD, OttBlocks.FANCY_PACKED_MUD_CTM, "fancy_packed_mud_pillar_engraving");
        s.one( Blocks.PACKED_MUD, OttBlocks.FINE_PACKED_MUD_CTM, "fine_packed_mud_pillar_engraving");
        s.one( Blocks.PACKED_MUD, OttBlocks.ORNATE_PACKED_MUD_CTM, "ornate_packed_mud_pillar_engraving");
        s.one( Blocks.PACKED_MUD, OttBlocks.SIMPLE_PACKED_MUD_CTM, "simple_packed_mud_pillar_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.BORDERED_PACKED_MUD, "bordered_packed_mud_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.BRICK_BORDERED_PACKED_MUD, "brick_bordered_packed_mud_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.EDGED_PACKED_MUD_BRICKS, "edged_packed_mud_bricks_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.HARD_PACKED_MUD, "hard_packed_mud_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.LARGE_PACKED_MUD_SIGIL, "large_packed_mud_sigil_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.LOREFUL_PACKED_MUD, "loreful_packed_mud_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.MASSIVE_PACKED_MUD_BRICKS, "massive_packed_mud_bricks_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.OVERLAPPING_PACKED_MUD_TILES, "overlapping_packed_mud_tiles_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.SCALY_PACKED_MUD, "scaly_packed_mud_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.TILED_BORDERED_PACKED_MUD, "tiled_bordered_packed_mud_ctm_engraving");
        s.tagged( materialTag("packed_mud"), OttBlocks.TILED_PACKED_MUD_COLUMN, "tiled_packed_mud_column_ctm_engraving");
        // ── pale_oak_planks ──
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_BEAMS.get(), "pale_oak_planks_beams_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_BRICKS.get(), "pale_oak_planks_bricks_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_BRICK_PATTERN.get(), "pale_oak_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_BRICK_PAVING.get(), "pale_oak_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_CRATE.get(), "pale_oak_planks_crate_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_DIAGONAL_STRIPES.get(), "pale_oak_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_DIAGONAL_TILES.get(), "pale_oak_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_DOTTED.get(), "pale_oak_planks_dotted_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_FLOORING.get(), "pale_oak_planks_flooring_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_LARGE_TILES.get(), "pale_oak_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_PATTERN.get(), "pale_oak_planks_pattern_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_ROTATED_BRICKS.get(), "pale_oak_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_SMALL_BRICKS.get(), "pale_oak_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_SMALL_TILES.get(), "pale_oak_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_SQUARES.get(), "pale_oak_planks_squares_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_TILES.get(), "pale_oak_planks_tiles_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_WAVY.get(), "pale_oak_planks_wavy_ctm_engraving");
        s.tagged( materialTag("pale_oak_planks"), OttBlocks.PALE_OAK_PLANKS_WOVEN.get(), "pale_oak_planks_woven_ctm_engraving");
        // ── pearlescent_froglight ──
        s.tagged( materialTag("pearlescent_froglight"), OttBlocks.GLASS_PEARLESCENT_FROGLIGHT, "glass_pearlescent_froglight_engraving");
        // ── pink_concrete ──
        s.one( Blocks.PINK_CONCRETE, OttBlocks.PINK_CONCRETE_CTM, "pink_concrete_pillar_engraving");
        s.tagged( materialTag("pink_concrete"), OttBlocks.GRILL_PINK_CONCRETE, "grill_pink_concrete_ctm_engraving");
        s.tagged( materialTag("pink_concrete"), OttBlocks.PEGGED_PINK_CONCRETE, "pegged_pink_concrete_ctm_engraving");
        s.tagged( materialTag("pink_concrete"), OttBlocks.PINK_CONCRETE_PANEL, "pink_concrete_panel_ctm_engraving");
        s.tagged( materialTag("pink_concrete"), OttBlocks.SMOOTH_PINK_CONCRETE, "smooth_pink_concrete_ctm_engraving");
        s.tagged( materialTag("pink_concrete"), OttBlocks.STRIPED_PINK_CONCRETE, "striped_pink_concrete_ctm_engraving");
        s.tagged( materialTag("pink_concrete"), OttBlocks.WIRED_PINK_CONCRETE, "wired_pink_concrete_ctm_engraving");
        // ── pink_marble ──
        s.one( OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_BRICKS,       "pink_marble_bricks_engraving");
        s.one( OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_PILLAR,       "pink_marble_pillar_engraving");
        s.one( OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_PILLAR_CAP,   "pink_marble_pillar_cap_engraving");
        s.one( OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_SMALL_BRICKS, "pink_marble_small_bricks_engraving");
        s.one( OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_TILES,        "pink_marble_tiles_engraving");
        s.one( OttBlocks.PINK_MARBLE, OttBlocks.PINK_POLISHED_MARBLE,     "pink_polished_marble_engraving");
        // ── pink_terracotta ──
        s.one( Blocks.PINK_TERRACOTTA, OttBlocks.PINK_TERRACOTTA_CTM, "pink_terracotta_pillar_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.CIRCULAR_PINK_TERRACOTTA, "circular_pink_terracotta_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.CURLED_PINK_TERRACOTTA, "curled_pink_terracotta_ctm_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.HEXAGONICAL_PINK_TERRACOTTA, "hexagonical_pink_terracotta_ctm_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.INSCRIBED_PINK_TERRACOTTA, "inscribed_pink_terracotta_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.PINK_TERRACOTTA_COLUMN, "pink_terracotta_column_ctm_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.SMALL_PINK_TERRACOTTA_TILES, "small_pink_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("pink_terracotta"), OttBlocks.STARRY_PINK_TERRACOTTA, "starry_pink_terracotta_engraving");
        // ── plain_limestone ──
        s.one( OttBlocks.PLAIN_LIMESTONE, OttBlocks.LIMESTONE_MASONRY,       "limestone_masonry_engraving");
        s.one( OttBlocks.PLAIN_LIMESTONE, OttBlocks.MIXED_LIMESTONE_BRICKS,  "mixed_limestone_bricks_engraving");
        s.one( OttBlocks.PLAIN_LIMESTONE, OttBlocks.POLISHED_LIMESTONE,      "polished_limestone_ctm_engraving");
        // ── prismarine ──
        s.one( Blocks.PRISMARINE, OttBlocks.BORDERED_PRISMARINE, "bordered_prismarine_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.BRICK_BORDERED_PRISMARINE, "brick_bordered_prismarine_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.CURLY_PRISMARINE_CTM, "curly_prismarine_pillar_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.CUT_PRISMARINE_COLUMN, "cut_prismarine_column_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.EDGED_PRISMARINE_BRICKS, "edged_prismarine_bricks_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.FINE_PRISMARINE_CTM, "fine_prismarine_pillar_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.MASSIVE_PRISMARINE_BRICKS, "massive_prismarine_bricks_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.ORNATE_PRISMARINE_CTM, "ornate_prismarine_pillar_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.OVERLAPPING_PRISMARINE_TILES, "overlapping_prismarine_tiles_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.POLISHED_PRISMARINE, "polished_prismarine_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.SIMPLE_PRISMARINE_CTM, "simple_prismarine_pillar_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.SMOOTH_PRISMARINE_COLUMN, "smooth_prismarine_column_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.THICK_INLAYED_PRISMARINE, "thick_inlayed_prismarine_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.TILED_BORDERED_PRISMARINE, "tiled_bordered_prismarine_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.TILED_PRISMARINE_COLUMN, "tiled_prismarine_column_ctm_engraving");
        s.one( Blocks.PRISMARINE, OttBlocks.TINY_BRICK_BORDERED_PRISMARINE, "tiny_brick_bordered_prismarine_ctm_engraving");
        // ── purple_concrete ──
        s.one( Blocks.PURPLE_CONCRETE, OttBlocks.PURPLE_CONCRETE_CTM, "purple_concrete_pillar_engraving");
        s.tagged( materialTag("purple_concrete"), OttBlocks.GRILL_PURPLE_CONCRETE, "grill_purple_concrete_ctm_engraving");
        s.tagged( materialTag("purple_concrete"), OttBlocks.PEGGED_PURPLE_CONCRETE, "pegged_purple_concrete_ctm_engraving");
        s.tagged( materialTag("purple_concrete"), OttBlocks.PURPLE_CONCRETE_PANEL, "purple_concrete_panel_ctm_engraving");
        s.tagged( materialTag("purple_concrete"), OttBlocks.SMOOTH_PURPLE_CONCRETE, "smooth_purple_concrete_ctm_engraving");
        s.tagged( materialTag("purple_concrete"), OttBlocks.STRIPED_PURPLE_CONCRETE, "striped_purple_concrete_ctm_engraving");
        s.tagged( materialTag("purple_concrete"), OttBlocks.WIRED_PURPLE_CONCRETE, "wired_purple_concrete_ctm_engraving");
        // ── purple_marble ──
        s.one( OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_BRICKS,       "purple_marble_bricks_engraving");
        s.one( OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_PILLAR,       "purple_marble_pillar_engraving");
        s.one( OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_PILLAR_CAP,   "purple_marble_pillar_cap_engraving");
        s.one( OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_SMALL_BRICKS, "purple_marble_small_bricks_engraving");
        s.one( OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_TILES,        "purple_marble_tiles_engraving");
        s.one( OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_POLISHED_MARBLE,     "purple_polished_marble_engraving");
        // ── purple_terracotta ──
        s.one( Blocks.PURPLE_TERRACOTTA, OttBlocks.PURPLE_TERRACOTTA_CTM, "purple_terracotta_pillar_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.CIRCULAR_PURPLE_TERRACOTTA, "circular_purple_terracotta_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.CURLED_PURPLE_TERRACOTTA, "curled_purple_terracotta_ctm_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.HEXAGONICAL_PURPLE_TERRACOTTA, "hexagonical_purple_terracotta_ctm_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.INSCRIBED_PURPLE_TERRACOTTA, "inscribed_purple_terracotta_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.PURPLE_TERRACOTTA_COLUMN, "purple_terracotta_column_ctm_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.SMALL_PURPLE_TERRACOTTA_TILES, "small_purple_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("purple_terracotta"), OttBlocks.STARRY_PURPLE_TERRACOTTA, "starry_purple_terracotta_engraving");
        // ── purpur_block ──
        s.one( Blocks.PURPUR_BLOCK, OttBlocks.CURLY_PURPUR_BLOCK_CTM, "curly_purpur_block_pillar_engraving");
        s.one( Blocks.PURPUR_BLOCK, OttBlocks.FINE_PURPUR_BLOCK_CTM, "fine_purpur_block_pillar_engraving");
        s.one( Blocks.PURPUR_BLOCK, OttBlocks.ORNATE_PURPUR_BLOCK_CTM, "ornate_purpur_block_pillar_engraving");
        s.one( Blocks.PURPUR_BLOCK, OttBlocks.SIMPLE_PURPUR_BLOCK_CTM, "simple_purpur_block_pillar_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.BORDERED_PURPUR_BLOCK, "bordered_purpur_block_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.BRICK_BORDERED_PURPUR_BLOCK, "brick_bordered_purpur_block_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.CUT_PURPUR_BLOCK_COLUMN, "cut_purpur_block_column_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.EDGED_PURPUR_BLOCK_BRICKS, "edged_purpur_block_bricks_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.MASSIVE_PURPUR_BLOCK_BRICKS, "massive_purpur_block_bricks_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.OVERLAPPING_PURPUR_BLOCK_TILES, "overlapping_purpur_block_tiles_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.POLISHED_PURPUR_BLOCK, "polished_purpur_block_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.PURPUR_COLUMN_CTM, "purpur_column_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.SMOOTH_PURPUR_BLOCK_COLUMN, "smooth_purpur_block_column_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.THICK_INLAYED_PURPUR_BLOCK, "thick_inlayed_purpur_block_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.TILED_BORDERED_PURPUR_BLOCK, "tiled_bordered_purpur_block_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.TILED_PURPUR_BLOCK_COLUMN, "tiled_purpur_block_column_ctm_engraving");
        s.tagged( materialTag("purpur_block"), OttBlocks.TINY_BRICK_BORDERED_PURPUR_BLOCK, "tiny_brick_bordered_purpur_block_ctm_engraving");
        // ── quartz_block ──
        s.one( Blocks.QUARTZ_BLOCK, OttBlocks.CURLY_QUARTZ_BLOCK_CTM, "curly_quartz_block_pillar_engraving");
        s.one( Blocks.QUARTZ_BLOCK, OttBlocks.FINE_QUARTZ_BLOCK_CTM, "fine_quartz_block_pillar_engraving");
        s.one( Blocks.QUARTZ_BLOCK, OttBlocks.ORNATE_QUARTZ_BLOCK_CTM, "ornate_quartz_block_pillar_engraving");
        s.one( Blocks.QUARTZ_BLOCK, OttBlocks.QUARTZ_BLOCK_CHISELED_CTM.get(), "quartz_block_chiseled_pillar_engraving");
        s.one( Blocks.QUARTZ_BLOCK, OttBlocks.SIMPLE_QUARTZ_BLOCK_CTM, "simple_quartz_block_pillar_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.BORDERED_QUARTZ_BLOCK, "bordered_quartz_block_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.BRICK_BORDERED_QUARTZ_BLOCK, "brick_bordered_quartz_block_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.CUT_QUARTZ_BLOCK_COLUMN, "cut_quartz_block_column_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.EDGED_QUARTZ_BLOCK_BRICKS, "edged_quartz_block_bricks_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.MASSIVE_QUARTZ_BLOCK_BRICKS, "massive_quartz_block_bricks_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.OVERLAPPING_QUARTZ_BLOCK_TILES, "overlapping_quartz_block_tiles_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.POLISHED_QUARTZ_BLOCK, "polished_quartz_block_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_BORDERED.get(), "quartz_block_bordered_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_BRICK_PAVING.get(), "quartz_block_brick_paving_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_CONNECTING.get(), "quartz_block_connecting_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_CROSSES.get(), "quartz_block_crosses_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_DIAGONAL_TILES.get(), "quartz_block_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_PATTERN.get(), "quartz_block_pattern_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_ROTATED_BRICKS.get(), "quartz_block_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_ROWS.get(), "quartz_block_rows_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_SCALES.get(), "quartz_block_scales_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_SMALL_TILES.get(), "quartz_block_small_tiles_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_SQUARES.get(), "quartz_block_squares_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_STRIPES.get(), "quartz_block_stripes_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.QUARTZ_BLOCK_TILES.get(), "quartz_block_tiles_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.SMOOTH_QUARTZ_BLOCK_COLUMN, "smooth_quartz_block_column_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.THICK_INLAYED_QUARTZ_BLOCK, "thick_inlayed_quartz_block_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.TILED_BORDERED_QUARTZ_BLOCK, "tiled_bordered_quartz_block_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.TILED_QUARTZ_BLOCK_COLUMN, "tiled_quartz_block_column_ctm_engraving");
        s.tagged( materialTag("quartz_block"), OttBlocks.TINY_BRICK_BORDERED_QUARTZ_BLOCK, "tiny_brick_bordered_quartz_block_ctm_engraving");
        // ── raw_copper_block ──
        s.one( Blocks.RAW_COPPER_BLOCK, OttBlocks.CURLY_RAW_COPPER_BLOCK_CTM, "curly_raw_copper_block_pillar_engraving");
        s.one( Blocks.RAW_COPPER_BLOCK, OttBlocks.FINE_RAW_COPPER_BLOCK_CTM, "fine_raw_copper_block_pillar_engraving");
        s.one( Blocks.RAW_COPPER_BLOCK, OttBlocks.ORNATE_RAW_COPPER_BLOCK_CTM, "ornate_raw_copper_block_pillar_engraving");
        s.one( Blocks.RAW_COPPER_BLOCK, OttBlocks.SIMPLE_RAW_COPPER_BLOCK_CTM, "simple_raw_copper_block_pillar_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.BORDERED_RAW_COPPER_BLOCK, "bordered_raw_copper_block_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.BRICK_BORDERED_RAW_COPPER_BLOCK, "brick_bordered_raw_copper_block_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.CUT_RAW_COPPER_BLOCK_COLUMN, "cut_raw_copper_block_column_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.EDGED_RAW_COPPER_BLOCK_BRICKS, "edged_raw_copper_block_bricks_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.MASSIVE_RAW_COPPER_BLOCK_BRICKS, "massive_raw_copper_block_bricks_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.OVERLAPPING_RAW_COPPER_BLOCK_TILES, "overlapping_raw_copper_block_tiles_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.POLISHED_RAW_COPPER_BLOCK, "polished_raw_copper_block_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.SMOOTH_RAW_COPPER_BLOCK_COLUMN, "smooth_raw_copper_block_column_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.THICK_INLAYED_RAW_COPPER_BLOCK, "thick_inlayed_raw_copper_block_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.TILED_BORDERED_RAW_COPPER_BLOCK, "tiled_bordered_raw_copper_block_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.TILED_RAW_COPPER_BLOCK_COLUMN, "tiled_raw_copper_block_column_ctm_engraving");
        s.tagged( materialTag("raw_copper_block"), OttBlocks.TINY_BRICK_BORDERED_RAW_COPPER_BLOCK, "tiny_brick_bordered_raw_copper_block_ctm_engraving");
        // ── raw_gold_block ──
        s.one( Blocks.RAW_GOLD_BLOCK, OttBlocks.CURLY_RAW_GOLD_BLOCK_CTM, "curly_raw_gold_block_pillar_engraving");
        s.one( Blocks.RAW_GOLD_BLOCK, OttBlocks.FINE_RAW_GOLD_BLOCK_CTM, "fine_raw_gold_block_pillar_engraving");
        s.one( Blocks.RAW_GOLD_BLOCK, OttBlocks.ORNATE_RAW_GOLD_BLOCK_CTM, "ornate_raw_gold_block_pillar_engraving");
        s.one( Blocks.RAW_GOLD_BLOCK, OttBlocks.SIMPLE_RAW_GOLD_BLOCK_CTM, "simple_raw_gold_block_pillar_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.BORDERED_RAW_GOLD_BLOCK, "bordered_raw_gold_block_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.BRICK_BORDERED_RAW_GOLD_BLOCK, "brick_bordered_raw_gold_block_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.CUT_RAW_GOLD_BLOCK_COLUMN, "cut_raw_gold_block_column_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.EDGED_RAW_GOLD_BLOCK_BRICKS, "edged_raw_gold_block_bricks_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.MASSIVE_RAW_GOLD_BLOCK_BRICKS, "massive_raw_gold_block_bricks_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.OVERLAPPING_RAW_GOLD_BLOCK_TILES, "overlapping_raw_gold_block_tiles_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.POLISHED_RAW_GOLD_BLOCK, "polished_raw_gold_block_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.SMOOTH_RAW_GOLD_BLOCK_COLUMN, "smooth_raw_gold_block_column_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.THICK_INLAYED_RAW_GOLD_BLOCK, "thick_inlayed_raw_gold_block_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.TILED_BORDERED_RAW_GOLD_BLOCK, "tiled_bordered_raw_gold_block_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.TILED_RAW_GOLD_BLOCK_COLUMN, "tiled_raw_gold_block_column_ctm_engraving");
        s.tagged( materialTag("raw_gold_block"), OttBlocks.TINY_BRICK_BORDERED_RAW_GOLD_BLOCK, "tiny_brick_bordered_raw_gold_block_ctm_engraving");
        // ── raw_iron_block ──
        s.one( Blocks.RAW_IRON_BLOCK, OttBlocks.CURLY_RAW_IRON_BLOCK_CTM, "curly_raw_iron_block_pillar_engraving");
        s.one( Blocks.RAW_IRON_BLOCK, OttBlocks.FINE_RAW_IRON_BLOCK_CTM, "fine_raw_iron_block_pillar_engraving");
        s.one( Blocks.RAW_IRON_BLOCK, OttBlocks.ORNATE_RAW_IRON_BLOCK_CTM, "ornate_raw_iron_block_pillar_engraving");
        s.one( Blocks.RAW_IRON_BLOCK, OttBlocks.SIMPLE_RAW_IRON_BLOCK_CTM, "simple_raw_iron_block_pillar_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.BORDERED_RAW_IRON_BLOCK, "bordered_raw_iron_block_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.BRICK_BORDERED_RAW_IRON_BLOCK, "brick_bordered_raw_iron_block_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.CUT_RAW_IRON_BLOCK_COLUMN, "cut_raw_iron_block_column_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.EDGED_RAW_IRON_BLOCK_BRICKS, "edged_raw_iron_block_bricks_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.MASSIVE_RAW_IRON_BLOCK_BRICKS, "massive_raw_iron_block_bricks_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.OVERLAPPING_RAW_IRON_BLOCK_TILES, "overlapping_raw_iron_block_tiles_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.POLISHED_RAW_IRON_BLOCK, "polished_raw_iron_block_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.SMOOTH_RAW_IRON_BLOCK_COLUMN, "smooth_raw_iron_block_column_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.THICK_INLAYED_RAW_IRON_BLOCK, "thick_inlayed_raw_iron_block_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.TILED_BORDERED_RAW_IRON_BLOCK, "tiled_bordered_raw_iron_block_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.TILED_RAW_IRON_BLOCK_COLUMN, "tiled_raw_iron_block_column_ctm_engraving");
        s.tagged( materialTag("raw_iron_block"), OttBlocks.TINY_BRICK_BORDERED_RAW_IRON_BLOCK, "tiny_brick_bordered_raw_iron_block_ctm_engraving");
        // ── red_concrete ──
        s.one( Blocks.RED_CONCRETE, OttBlocks.RED_CONCRETE_CTM, "red_concrete_pillar_engraving");
        s.tagged( materialTag("red_concrete"), OttBlocks.GRILL_RED_CONCRETE, "grill_red_concrete_ctm_engraving");
        s.tagged( materialTag("red_concrete"), OttBlocks.PEGGED_RED_CONCRETE, "pegged_red_concrete_ctm_engraving");
        s.tagged( materialTag("red_concrete"), OttBlocks.RED_CONCRETE_PANEL, "red_concrete_panel_ctm_engraving");
        s.tagged( materialTag("red_concrete"), OttBlocks.SMOOTH_RED_CONCRETE, "smooth_red_concrete_ctm_engraving");
        s.tagged( materialTag("red_concrete"), OttBlocks.STRIPED_RED_CONCRETE, "striped_red_concrete_ctm_engraving");
        s.tagged( materialTag("red_concrete"), OttBlocks.WIRED_RED_CONCRETE, "wired_red_concrete_ctm_engraving");
        // ── red_marble ──
        s.one( OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_BRICKS,       "red_marble_bricks_engraving");
        s.one( OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_PILLAR,       "red_marble_pillar_engraving");
        s.one( OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_PILLAR_CAP,   "red_marble_pillar_cap_engraving");
        s.one( OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_SMALL_BRICKS, "red_marble_small_bricks_engraving");
        s.one( OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_TILES,        "red_marble_tiles_engraving");
        s.one( OttBlocks.RED_MARBLE, OttBlocks.RED_POLISHED_MARBLE,     "red_polished_marble_engraving");
        // ── red_nether_bricks ──
        s.one( Blocks.RED_NETHER_BRICKS, OttBlocks.CURLY_RED_NETHER_BRICKS_CTM, "curly_red_nether_bricks_pillar_engraving");
        s.one( Blocks.RED_NETHER_BRICKS, OttBlocks.FINE_RED_NETHER_BRICKS_CTM, "fine_red_nether_bricks_pillar_engraving");
        s.one( Blocks.RED_NETHER_BRICKS, OttBlocks.ORNATE_RED_NETHER_BRICKS_CTM, "ornate_red_nether_bricks_pillar_engraving");
        s.one( Blocks.RED_NETHER_BRICKS, OttBlocks.SIMPLE_RED_NETHER_BRICKS_CTM, "simple_red_nether_bricks_pillar_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.BORDERED_RED_NETHER_BRICKS, "bordered_red_nether_bricks_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.BRICK_BORDERED_RED_NETHER_BRICKS, "brick_bordered_red_nether_bricks_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.CUT_RED_NETHER_BRICKS_COLUMN, "cut_red_nether_bricks_column_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.EDGED_RED_NETHER_BRICKS_BRICKS, "edged_red_nether_bricks_bricks_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.MASSIVE_RED_NETHER_BRICKS_BRICKS, "massive_red_nether_bricks_bricks_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.OVERLAPPING_RED_NETHER_BRICKS_TILES, "overlapping_red_nether_bricks_tiles_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.POLISHED_RED_NETHER_BRICKS, "polished_red_nether_bricks_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.SMOOTH_RED_NETHER_BRICKS_COLUMN, "smooth_red_nether_bricks_column_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.THICK_INLAYED_RED_NETHER_BRICKS, "thick_inlayed_red_nether_bricks_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.TILED_BORDERED_RED_NETHER_BRICKS, "tiled_bordered_red_nether_bricks_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.TILED_RED_NETHER_BRICKS_COLUMN, "tiled_red_nether_bricks_column_ctm_engraving");
        s.tagged( materialTag("red_nether_bricks"), OttBlocks.TINY_BRICK_BORDERED_RED_NETHER_BRICKS, "tiny_brick_bordered_red_nether_bricks_ctm_engraving");
        // ── red_sandstone ──
        s.one( Blocks.RED_SANDSTONE, OttBlocks.CURLY_RED_SANDSTONE_CTM, "curly_red_sandstone_pillar_engraving");
        s.one( Blocks.RED_SANDSTONE, OttBlocks.FINE_RED_SANDSTONE_CTM, "fine_red_sandstone_pillar_engraving");
        s.one( Blocks.RED_SANDSTONE, OttBlocks.ORNATE_RED_SANDSTONE_CTM, "ornate_red_sandstone_pillar_engraving");
        s.one( Blocks.RED_SANDSTONE, OttBlocks.SIMPLE_RED_SANDSTONE_CTM, "simple_red_sandstone_pillar_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.BORDERED_RED_SANDSTONE, "bordered_red_sandstone_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.BRICK_BORDERED_RED_SANDSTONE, "brick_bordered_red_sandstone_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.CUT_RED_SANDSTONE_COLUMN, "cut_red_sandstone_column_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.EDGED_RED_SANDSTONE_BRICKS, "edged_red_sandstone_bricks_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.MASSIVE_RED_SANDSTONE_BRICKS, "massive_red_sandstone_bricks_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.OVERLAPPING_RED_SANDSTONE_TILES, "overlapping_red_sandstone_tiles_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.POLISHED_RED_SANDSTONE, "polished_red_sandstone_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_BRICKS.get(), "red_sandstone_bricks_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_BRICK_PATTERN.get(), "red_sandstone_brick_pattern_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_BRICK_PAVING.get(), "red_sandstone_brick_paving_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_DIAGONAL_BRICKS.get(), "red_sandstone_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_LARGE_TILES.get(), "red_sandstone_large_tiles_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_ROTATED_BRICKS.get(), "red_sandstone_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.RED_SANDSTONE_TILES.get(), "red_sandstone_tiles_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.SMOOTH_RED_SANDSTONE_COLUMN, "smooth_red_sandstone_column_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.THICK_INLAYED_RED_SANDSTONE, "thick_inlayed_red_sandstone_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.TILED_BORDERED_RED_SANDSTONE, "tiled_bordered_red_sandstone_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.TILED_RED_SANDSTONE_COLUMN, "tiled_red_sandstone_column_ctm_engraving");
        s.tagged( materialTag("red_sandstone"), OttBlocks.TINY_BRICK_BORDERED_RED_SANDSTONE, "tiny_brick_bordered_red_sandstone_ctm_engraving");
        // ── red_terracotta ──
        s.one( Blocks.RED_TERRACOTTA, OttBlocks.RED_TERRACOTTA_CTM, "red_terracotta_pillar_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.CIRCULAR_RED_TERRACOTTA, "circular_red_terracotta_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.CURLED_RED_TERRACOTTA, "curled_red_terracotta_ctm_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.HEXAGONICAL_RED_TERRACOTTA, "hexagonical_red_terracotta_ctm_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.INSCRIBED_RED_TERRACOTTA, "inscribed_red_terracotta_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.RED_TERRACOTTA_COLUMN, "red_terracotta_column_ctm_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.SMALL_RED_TERRACOTTA_TILES, "small_red_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("red_terracotta"), OttBlocks.STARRY_RED_TERRACOTTA, "starry_red_terracotta_engraving");
        // ── redstone_block ──
        s.one( Blocks.REDSTONE_BLOCK, OttBlocks.CURLY_REDSTONE_BLOCK_CTM, "curly_redstone_block_pillar_engraving");
        s.one( Blocks.REDSTONE_BLOCK, OttBlocks.FINE_REDSTONE_BLOCK_CTM, "fine_redstone_block_pillar_engraving");
        s.one( Blocks.REDSTONE_BLOCK, OttBlocks.ORNATE_REDSTONE_BLOCK_CTM, "ornate_redstone_block_pillar_engraving");
        s.one( Blocks.REDSTONE_BLOCK, OttBlocks.REDSTONE_BLOCK_CTM.get(), "redstone_block_pillar_engraving");
        s.one( Blocks.REDSTONE_BLOCK, OttBlocks.SIMPLE_REDSTONE_BLOCK_CTM, "simple_redstone_block_pillar_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.BORDERED_REDSTONE_BLOCK, "bordered_redstone_block_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.BRICK_BORDERED_REDSTONE_BLOCK, "brick_bordered_redstone_block_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.CUT_REDSTONE_BLOCK_COLUMN, "cut_redstone_block_column_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.EDGED_REDSTONE_BLOCK_BRICKS, "edged_redstone_block_bricks_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.MASSIVE_REDSTONE_BLOCK_BRICKS, "massive_redstone_block_bricks_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.OVERLAPPING_REDSTONE_BLOCK_TILES, "overlapping_redstone_block_tiles_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.POLISHED_REDSTONE_BLOCK, "polished_redstone_block_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_BORDERED.get(), "redstone_block_bordered_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_BRICKS.get(), "redstone_block_bricks_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_CHISELED_CLOVERS.get(), "redstone_block_chiseled_clovers_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_CIRCLES.get(), "redstone_block_circles_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_COMPRESSED.get(), "redstone_block_compressed_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_DIAGONAL_TILES.get(), "redstone_block_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_PATTERNED.get(), "redstone_block_patterned_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_PAVING.get(), "redstone_block_paving_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_SCALES.get(), "redstone_block_scales_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.REDSTONE_BLOCK_SMALL_TILES.get(), "redstone_block_small_tiles_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.SMOOTH_REDSTONE_BLOCK_COLUMN, "smooth_redstone_block_column_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.THICK_INLAYED_REDSTONE_BLOCK, "thick_inlayed_redstone_block_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.TILED_BORDERED_REDSTONE_BLOCK, "tiled_bordered_redstone_block_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.TILED_REDSTONE_BLOCK_COLUMN, "tiled_redstone_block_column_ctm_engraving");
        s.tagged( materialTag("redstone_block"), OttBlocks.TINY_BRICK_BORDERED_REDSTONE_BLOCK, "tiny_brick_bordered_redstone_block_ctm_engraving");
        // ── sandstone ──
        s.one( Blocks.SANDSTONE, OttBlocks.CURLY_SANDSTONE_CTM, "curly_sandstone_pillar_engraving");
        s.one( Blocks.SANDSTONE, OttBlocks.FINE_SANDSTONE_CTM, "fine_sandstone_pillar_engraving");
        s.one( Blocks.SANDSTONE, OttBlocks.ORNATE_SANDSTONE_CTM, "ornate_sandstone_pillar_engraving");
        s.one( Blocks.SANDSTONE, OttBlocks.SIMPLE_SANDSTONE_CTM, "simple_sandstone_pillar_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.BORDERED_SANDSTONE, "bordered_sandstone_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.BRICK_BORDERED_SANDSTONE, "brick_bordered_sandstone_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.CUT_SANDSTONE_COLUMN, "cut_sandstone_column_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.EDGED_SANDSTONE_BRICKS, "edged_sandstone_bricks_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.MASSIVE_SANDSTONE_BRICKS, "massive_sandstone_bricks_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.OVERLAPPING_SANDSTONE_TILES, "overlapping_sandstone_tiles_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.POLISHED_SANDSTONE, "polished_sandstone_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_BRICKS.get(), "sandstone_bricks_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_BRICK_PATTERN.get(), "sandstone_brick_pattern_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_BRICK_PAVING.get(), "sandstone_brick_paving_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_DIAGONAL_BRICKS.get(), "sandstone_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_LARGE_TILES.get(), "sandstone_large_tiles_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_ROTATED_BRICKS.get(), "sandstone_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SANDSTONE_TILES.get(), "sandstone_tiles_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.SMOOTH_SANDSTONE_COLUMN, "smooth_sandstone_column_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.THICK_INLAYED_SANDSTONE, "thick_inlayed_sandstone_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.TILED_BORDERED_SANDSTONE, "tiled_bordered_sandstone_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.TILED_SANDSTONE_COLUMN, "tiled_sandstone_column_ctm_engraving");
        s.tagged( materialTag("sandstone"), OttBlocks.TINY_BRICK_BORDERED_SANDSTONE, "tiny_brick_bordered_sandstone_ctm_engraving");
        // ── sea_lantern ──
        s.one( Blocks.SEA_LANTERN, OttBlocks.SEA_LANTERN,                     "sea_lantern_ctm_engraving");
        // ── smooth_sandstone ──
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.AIR_MOSAIC_BORDER,                  "air_mosaic_border_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.AIR_MOSAIC_DELICATE,                "air_mosaic_delicate_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.AIR_MOSAIC_GEOMETRIC,               "air_mosaic_geometric_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.AIR_MOSAIC_PATTERN,                 "air_mosaic_pattern_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.AIR_MOSAIC_TRADITIONAL,             "air_mosaic_traditional_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.EARTH_MOSAIC_BORDER,                "earth_mosaic_border_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.EARTH_MOSAIC_DELICATE,              "earth_mosaic_delicate_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.EARTH_MOSAIC_GEOMETRIC,             "earth_mosaic_geometric_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.EARTH_MOSAIC_PATTERN,               "earth_mosaic_pattern_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.EARTH_MOSAIC_TRADITIONAL,           "earth_mosaic_traditional_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.FIRE_MOSAIC_BORDER,                 "fire_mosaic_border_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.FIRE_MOSAIC_DELICATE,               "fire_mosaic_delicate_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.FIRE_MOSAIC_GEOMETRIC,              "fire_mosaic_geometric_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.FIRE_MOSAIC_PATTERN,                "fire_mosaic_pattern_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.FIRE_MOSAIC_TRADITIONAL,            "fire_mosaic_traditional_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.MOSAIC_FLOOR,                       "mosaic_floor_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.MOSAIC_FLOOR_DELICATE,              "mosaic_floor_delicate_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.MOSAIC_FLOOR_ROSETTE,               "mosaic_floor_rosette_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.ROMAN_FRESCO_BLACK,                 "roman_fresco_black_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.ROMAN_FRESCO_RED,                   "roman_fresco_red_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SANDSTONE_SLENDER_BRICKS,          "sandstone_slender_bricks_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN,"sandstone_slender_turquoise_pattern_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SPIRIT_MOSAIC_BORDER,               "spirit_mosaic_border_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SPIRIT_MOSAIC_DELICATE,             "spirit_mosaic_delicate_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SPIRIT_MOSAIC_GEOMETRIC,            "spirit_mosaic_geometric_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SPIRIT_MOSAIC_PATTERN,              "spirit_mosaic_pattern_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.SPIRIT_MOSAIC_TRADITIONAL,          "spirit_mosaic_traditional_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.WATER_MOSAIC_BORDER,                "water_mosaic_border_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.WATER_MOSAIC_DELICATE,              "water_mosaic_delicate_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.WATER_MOSAIC_GEOMETRIC,             "water_mosaic_geometric_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.WATER_MOSAIC_PATTERN,               "water_mosaic_pattern_engraving");
        s.one( Blocks.SMOOTH_SANDSTONE, OttBlocks.WATER_MOSAIC_TRADITIONAL,           "water_mosaic_traditional_engraving");
        // ── smooth_stone ──
        s.one( Blocks.SMOOTH_STONE, OttBlocks.CURLY_SMOOTH_STONE_CTM, "curly_smooth_stone_pillar_engraving");
        s.one( Blocks.SMOOTH_STONE, OttBlocks.FINE_SMOOTH_STONE_CTM, "fine_smooth_stone_pillar_engraving");
        s.one( Blocks.SMOOTH_STONE, OttBlocks.ORNATE_SMOOTH_STONE_CTM, "ornate_smooth_stone_pillar_engraving");
        s.one( Blocks.SMOOTH_STONE, OttBlocks.SIMPLE_SMOOTH_STONE_CTM, "simple_smooth_stone_pillar_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.BORDERED_SMOOTH_STONE, "bordered_smooth_stone_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.BRICK_BORDERED_SMOOTH_STONE, "brick_bordered_smooth_stone_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.CUT_SMOOTH_STONE_COLUMN, "cut_smooth_stone_column_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.EDGED_SMOOTH_STONE_BRICKS, "edged_smooth_stone_bricks_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.MASSIVE_SMOOTH_STONE_BRICKS, "massive_smooth_stone_bricks_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.OVERLAPPING_SMOOTH_STONE_TILES, "overlapping_smooth_stone_tiles_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.POLISHED_SMOOTH_STONE, "polished_smooth_stone_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.SMOOTH_SMOOTH_STONE_COLUMN, "smooth_smooth_stone_column_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.THICK_INLAYED_SMOOTH_STONE, "thick_inlayed_smooth_stone_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.TILED_BORDERED_SMOOTH_STONE, "tiled_bordered_smooth_stone_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.TILED_SMOOTH_STONE_COLUMN, "tiled_smooth_stone_column_ctm_engraving");
        s.tagged( materialTag("smooth_stone"), OttBlocks.TINY_BRICK_BORDERED_SMOOTH_STONE, "tiny_brick_bordered_smooth_stone_ctm_engraving");
        // ── snow_block ──
        s.one( Blocks.SNOW_BLOCK, OttBlocks.CURLY_SNOW_BLOCK_CTM, "curly_snow_block_pillar_engraving");
        s.one( Blocks.SNOW_BLOCK, OttBlocks.FINE_SNOW_BLOCK_CTM, "fine_snow_block_pillar_engraving");
        s.one( Blocks.SNOW_BLOCK, OttBlocks.ORNATE_SNOW_BLOCK_CTM, "ornate_snow_block_pillar_engraving");
        s.one( Blocks.SNOW_BLOCK, OttBlocks.SIMPLE_SNOW_BLOCK_CTM, "simple_snow_block_pillar_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.BORDERED_SNOW_BLOCK, "bordered_snow_block_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.BRICK_BORDERED_SNOW_BLOCK, "brick_bordered_snow_block_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.CUT_SNOW_BLOCK_COLUMN, "cut_snow_block_column_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.EDGED_SNOW_BLOCK_BRICKS, "edged_snow_block_bricks_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.MASSIVE_SNOW_BLOCK_BRICKS, "massive_snow_block_bricks_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.OVERLAPPING_SNOW_BLOCK_TILES, "overlapping_snow_block_tiles_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.POLISHED_SNOW_BLOCK, "polished_snow_block_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.SMOOTH_SNOW_BLOCK_COLUMN, "smooth_snow_block_column_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.THICK_INLAYED_SNOW_BLOCK, "thick_inlayed_snow_block_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.TILED_BORDERED_SNOW_BLOCK, "tiled_bordered_snow_block_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.TILED_SNOW_BLOCK_COLUMN, "tiled_snow_block_column_ctm_engraving");
        s.tagged( materialTag("snow_block"), OttBlocks.TINY_BRICK_BORDERED_SNOW_BLOCK, "tiny_brick_bordered_snow_block_ctm_engraving");
        // ── spruce_planks ──
        s.tagged( materialTag("spruce_planks"), OttBlocks.CORNERED_SPRUCE_PLANKS, "cornered_spruce_planks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.CRATED_SPRUCE_PLANKS, "crated_spruce_planks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.ENCLOSED_SPRUCE_PLANKS, "enclosed_spruce_planks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.FRAMED_SPRUCE_PLANKS, "framed_spruce_planks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.NATURAL_SPRUCE_PLANKS, "natural_spruce_planks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.PEGGED_SPRUCE_PLANKS, "pegged_spruce_planks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_BEAMS.get(), "spruce_planks_beams_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_BRICKS.get(), "spruce_planks_bricks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_BRICK_PATTERN.get(), "spruce_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_BRICK_PAVING.get(), "spruce_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_CRATE.get(), "spruce_planks_crate_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_DIAGONAL_STRIPES.get(), "spruce_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_DIAGONAL_TILES.get(), "spruce_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_DOTTED.get(), "spruce_planks_dotted_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_FLOORING.get(), "spruce_planks_flooring_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_LARGE_TILES.get(), "spruce_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_PANEL, "spruce_planks_panel_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_PATTERN.get(), "spruce_planks_pattern_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_ROTATED_BRICKS.get(), "spruce_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_SMALL_BRICKS.get(), "spruce_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_SMALL_TILES.get(), "spruce_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_SQUARES.get(), "spruce_planks_squares_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_TILES.get(), "spruce_planks_tiles_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_WAVY.get(), "spruce_planks_wavy_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.SPRUCE_PLANKS_WOVEN.get(), "spruce_planks_woven_ctm_engraving");
        s.tagged( materialTag("spruce_planks"), OttBlocks.WHIRLWIND_SPRUCE_PLANKS, "whirlwind_spruce_planks_ctm_engraving");
        // ── stone ──
        s.one( Blocks.STONE, OttBlocks.CHAOTIC_MEDIUM_STONE_BRICKS,        "chaotic_medium_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.CHAOTIC_SMALL_STONE_BRICKS,         "chaotic_small_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.CHAOTIC_STONE_BRICKS,               "chaotic_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.DIAMOND_STONE_PAVERS,               "diamond_stone_pavers_engraving");
        s.one( Blocks.STONE, OttBlocks.ENCASED_STONE_BRICKS,               "encased_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.FRENCH_STONE,                       "french_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.LARGE_ORNATE_STONE,                 "large_ornate_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.LARGE_STONE_TILE,                   "large_stone_tile_engraving");
        s.one( Blocks.STONE, OttBlocks.MESSY_STONE_TILES,                  "messy_stone_tiles_engraving");
        s.one( Blocks.STONE, OttBlocks.MOSAIC_STONE,                       "mosaic_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.NOTCHED_STONE_BRICKS,               "notched_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.ORNATE_STONE,                       "ornate_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.POISON_STONE,                       "poison_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.POLISHED_CUT_STONE,                 "polished_cut_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.POLISHED_STONE_TILES,               "polished_stone_tiles_engraving");
        s.one( Blocks.STONE, OttBlocks.PRISM_STONE,                        "prism_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.SHEARED_STONE_PILLAR,               "sheared_stone_pillar_engraving");
        s.one( Blocks.STONE, OttBlocks.SLANTED_STONE,                      "slanted_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.SLATED_STONE,                       "slated_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_ARRAY,                        "stone_array_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_BRAID,                        "stone_braid_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_COLUMN,                       "stone_column_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_DENT,                         "stone_dent_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_JELLYBEAN,                    "stone_jellybean_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_LAYERS,                       "stone_layers_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_PANEL,                        "stone_panel_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_ROAD,                         "stone_road_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_TWISTING_COLUMN,              "stone_twisting_column_engraving");
        s.one( Blocks.STONE, OttBlocks.STONE_ZAG,                          "stone_zag_engraving");
        s.one( Blocks.STONE, OttBlocks.SUNKEN_STONE,                       "sunken_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.TRIPLE_STONE_BRICKS,                "triple_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.WEATHERED_STONE_BRICKS,             "weathered_stone_bricks_engraving");
        s.one( Blocks.STONE, OttBlocks.WEATHERED_TILED_STONE,              "weathered_tiled_stone_engraving");
        s.one( Blocks.STONE, OttBlocks.WEAVER_STONE,                       "weaver_stone_engraving");
        s.tagged( materialTag("stone"), OttBlocks.CUT_BLANK_STONE, "cut_blank_stone_engraving");
        s.tagged( materialTag("stone"), OttBlocks.CUT_STONE, "cut_stone_engraving");
        s.tagged( materialTag("stone"), OttBlocks.MASSIVE_STONE_BRICKS, "massive_stone_bricks_engraving");
        s.tagged( materialTag("stone"), OttBlocks.ROUGH_CUT_STONE, "rough_cut_stone_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_BIG_TILES.get(), "stone_big_tiles_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_BORDERED.get(), "stone_bordered_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_BRICK_PATTERN.get(), "stone_brick_pattern_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_BRICK_PAVING.get(), "stone_brick_paving_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_CHISELED_BRICKS.get(), "stone_chiseled_bricks_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_CRUSHED.get(), "stone_crushed_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_DIAGONAL_BRICKS.get(), "stone_diagonal_bricks_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_PATH.get(), "stone_path_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_ROTATED_BRICKS.get(), "stone_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SLATED_END.get(), "stone_slated_end_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMALL_BRICKS.get(), "stone_small_bricks_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMALL_TILES.get(), "stone_small_tiles_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMOOTH.get(), "stone_smooth_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMOOTH_BRICK_PAVING.get(), "stone_smooth_brick_paving_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMOOTH_LARGE_TILES.get(), "stone_smooth_large_tiles_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMOOTH_ROTATED_BRICKS.get(), "stone_smooth_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SMOOTH_TILES.get(), "stone_smooth_tiles_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_SQUARES.get(), "stone_squares_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_TILES.get(), "stone_tiles_ctm_engraving");
        s.tagged( materialTag("stone"), OttBlocks.STONE_WAVES.get(), "stone_waves_ctm_engraving");
        // ── stone_bricks ──
        s.one( Blocks.STONE_BRICKS, OttBlocks.STONE_BRICKS_MASONRY,          "stone_bricks_masonry_engraving");
        // ── terracotta ──
        s.one( Blocks.TERRACOTTA, OttBlocks.TERRACOTTA_CTM, "terracotta_pillar_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.CIRCULAR_TERRACOTTA, "circular_terracotta_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.CURLED_TERRACOTTA, "curled_terracotta_ctm_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.HEXAGONICAL_TERRACOTTA, "hexagonical_terracotta_ctm_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.INSCRIBED_TERRACOTTA, "inscribed_terracotta_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.SMALL_TERRACOTTA_TILES, "small_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.STARRY_TERRACOTTA, "starry_terracotta_engraving");
        s.tagged( materialTag("terracotta"), OttBlocks.TERRACOTTA_COLUMN, "terracotta_column_ctm_engraving");
        // ── tinted_glass ──
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS, "tinted_borderless_glass_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_BLACK, "tinted_borderless_glass_black_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_BLUE, "tinted_borderless_glass_blue_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_BROWN, "tinted_borderless_glass_brown_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_CYAN, "tinted_borderless_glass_cyan_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_GRAY, "tinted_borderless_glass_gray_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_GREEN, "tinted_borderless_glass_green_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_LIGHT_BLUE, "tinted_borderless_glass_light_blue_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_LIGHT_GRAY, "tinted_borderless_glass_light_gray_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_LIME, "tinted_borderless_glass_lime_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_MAGENTA, "tinted_borderless_glass_magenta_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_ORANGE, "tinted_borderless_glass_orange_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_PINK, "tinted_borderless_glass_pink_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_PURPLE, "tinted_borderless_glass_purple_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_RED, "tinted_borderless_glass_red_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_WHITE, "tinted_borderless_glass_white_ctm_engraving");
        s.tagged( materialTag("tinted_glass"), OttBlocks.TINTED_BORDERLESS_GLASS_YELLOW, "tinted_borderless_glass_yellow_ctm_engraving");
        // ── tuff ──
        s.one( Blocks.TUFF, OttBlocks.CURLY_TUFF_CTM, "curly_tuff_pillar_engraving");
        s.one( Blocks.TUFF, OttBlocks.FINE_TUFF_CTM, "fine_tuff_pillar_engraving");
        s.one( Blocks.TUFF, OttBlocks.ORNATE_TUFF_CTM, "ornate_tuff_pillar_engraving");
        s.one( Blocks.TUFF, OttBlocks.SIMPLE_TUFF_CTM, "simple_tuff_pillar_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.BORDERED_TUFF, "bordered_tuff_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.BRICK_BORDERED_TUFF, "brick_bordered_tuff_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.CUT_TUFF_COLUMN, "cut_tuff_column_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.EDGED_TUFF_BRICKS, "edged_tuff_bricks_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.MASSIVE_TUFF_BRICKS, "massive_tuff_bricks_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.OVERLAPPING_TUFF_TILES, "overlapping_tuff_tiles_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.POLISHED_TUFF, "polished_tuff_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.SMOOTH_TUFF_COLUMN, "smooth_tuff_column_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.THICK_INLAYED_TUFF, "thick_inlayed_tuff_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.TILED_BORDERED_TUFF, "tiled_bordered_tuff_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.TILED_TUFF_COLUMN, "tiled_tuff_column_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.TINY_BRICK_BORDERED_TUFF, "tiny_brick_bordered_tuff_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.TUFF_CUT_POLISHED.get(), "tuff_cut_polished_ctm_engraving");
        s.tagged( materialTag("tuff"), OttBlocks.TUFF_CUT_SMALL_BRICK.get(), "tuff_cut_small_brick_ctm_engraving");
        // ── verdant_froglight ──
        s.tagged( materialTag("verdant_froglight"),     OttBlocks.GLASS_VERDANT_FROGLIGHT,     "glass_verdant_froglight_engraving");
        // ── warped_planks ──
        s.tagged( materialTag("warped_planks"), OttBlocks.CORNERED_WARPED_PLANKS, "cornered_warped_planks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.CRATED_WARPED_PLANKS, "crated_warped_planks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.ENCLOSED_WARPED_PLANKS, "enclosed_warped_planks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.FRAMED_WARPED_PLANKS, "framed_warped_planks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.NATURAL_WARPED_PLANKS, "natural_warped_planks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.PEGGED_WARPED_PLANKS, "pegged_warped_planks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_BEAMS.get(), "warped_planks_beams_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_BRICKS.get(), "warped_planks_bricks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_BRICK_PATTERN.get(), "warped_planks_brick_pattern_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_BRICK_PAVING.get(), "warped_planks_brick_paving_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_CRATE.get(), "warped_planks_crate_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_DIAGONAL_STRIPES.get(), "warped_planks_diagonal_stripes_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_DIAGONAL_TILES.get(), "warped_planks_diagonal_tiles_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_DOTTED.get(), "warped_planks_dotted_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_FLOORING.get(), "warped_planks_flooring_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_LARGE_TILES.get(), "warped_planks_large_tiles_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_PANEL, "warped_planks_panel_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_PATTERN.get(), "warped_planks_pattern_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_ROTATED_BRICKS.get(), "warped_planks_rotated_bricks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_SMALL_BRICKS.get(), "warped_planks_small_bricks_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_SMALL_TILES.get(), "warped_planks_small_tiles_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_SQUARES.get(), "warped_planks_squares_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_TILES.get(), "warped_planks_tiles_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_WAVY.get(), "warped_planks_wavy_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WARPED_PLANKS_WOVEN.get(), "warped_planks_woven_ctm_engraving");
        s.tagged( materialTag("warped_planks"), OttBlocks.WHIRLWIND_WARPED_PLANKS, "whirlwind_warped_planks_ctm_engraving");
        // ── weathered_copper ──
        s.tagged( materialTag("weathered_copper"), OttBlocks.WEATHERED_COPPER_BLOCK.get(), "weathered_copper_block_ctm_engraving");
        // ── weathered_copper_grate ──
        s.tagged( materialTag("weathered_copper_grate"), OttBlocks.WEATHERED_COPPER_GRATE.get(), "weathered_copper_grate_ctm_engraving");
        // ── white_concrete ──
        s.one( Blocks.WHITE_CONCRETE, OttBlocks.WHITE_CONCRETE_CTM, "white_concrete_pillar_engraving");
        s.tagged( materialTag("white_concrete"), OttBlocks.GRILL_WHITE_CONCRETE, "grill_white_concrete_ctm_engraving");
        s.tagged( materialTag("white_concrete"), OttBlocks.PEGGED_WHITE_CONCRETE, "pegged_white_concrete_ctm_engraving");
        s.tagged( materialTag("white_concrete"), OttBlocks.SMOOTH_WHITE_CONCRETE, "smooth_white_concrete_ctm_engraving");
        s.tagged( materialTag("white_concrete"), OttBlocks.STRIPED_WHITE_CONCRETE, "striped_white_concrete_ctm_engraving");
        s.tagged( materialTag("white_concrete"), OttBlocks.WHITE_CONCRETE_PANEL, "white_concrete_panel_ctm_engraving");
        s.tagged( materialTag("white_concrete"), OttBlocks.WIRED_WHITE_CONCRETE, "wired_white_concrete_ctm_engraving");
        // ── white_marble ──
        s.one( OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_BRICKS,       "white_marble_bricks_engraving");
        s.one( OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_PILLAR,       "white_marble_pillar_engraving");
        s.one( OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_PILLAR_CAP,   "white_marble_pillar_cap_engraving");
        s.one( OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_SMALL_BRICKS, "white_marble_small_bricks_engraving");
        s.one( OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_TILES,        "white_marble_tiles_engraving");
        s.one( OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_POLISHED_MARBLE,     "white_polished_marble_engraving");
        // ── white_terracotta ──
        s.one( Blocks.WHITE_TERRACOTTA, OttBlocks.WHITE_TERRACOTTA_CTM, "white_terracotta_pillar_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.CIRCULAR_WHITE_TERRACOTTA, "circular_white_terracotta_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.CURLED_WHITE_TERRACOTTA, "curled_white_terracotta_ctm_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.HEXAGONICAL_WHITE_TERRACOTTA, "hexagonical_white_terracotta_ctm_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.INSCRIBED_WHITE_TERRACOTTA, "inscribed_white_terracotta_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.SMALL_WHITE_TERRACOTTA_TILES, "small_white_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.STARRY_WHITE_TERRACOTTA, "starry_white_terracotta_engraving");
        s.tagged( materialTag("white_terracotta"), OttBlocks.WHITE_TERRACOTTA_COLUMN, "white_terracotta_column_ctm_engraving");
        // ── yellow_concrete ──
        s.one( Blocks.YELLOW_CONCRETE, OttBlocks.YELLOW_CONCRETE_CTM, "yellow_concrete_pillar_engraving");
        s.tagged( materialTag("yellow_concrete"), OttBlocks.GRILL_YELLOW_CONCRETE, "grill_yellow_concrete_ctm_engraving");
        s.tagged( materialTag("yellow_concrete"), OttBlocks.PEGGED_YELLOW_CONCRETE, "pegged_yellow_concrete_ctm_engraving");
        s.tagged( materialTag("yellow_concrete"), OttBlocks.SMOOTH_YELLOW_CONCRETE, "smooth_yellow_concrete_ctm_engraving");
        s.tagged( materialTag("yellow_concrete"), OttBlocks.STRIPED_YELLOW_CONCRETE, "striped_yellow_concrete_ctm_engraving");
        s.tagged( materialTag("yellow_concrete"), OttBlocks.WIRED_YELLOW_CONCRETE, "wired_yellow_concrete_ctm_engraving");
        s.tagged( materialTag("yellow_concrete"), OttBlocks.YELLOW_CONCRETE_PANEL, "yellow_concrete_panel_ctm_engraving");
        // ── yellow_marble ──
        s.one( OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_BRICKS,       "yellow_marble_bricks_engraving");
        s.one( OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_PILLAR,       "yellow_marble_pillar_engraving");
        s.one( OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_PILLAR_CAP,   "yellow_marble_pillar_cap_engraving");
        s.one( OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_SMALL_BRICKS, "yellow_marble_small_bricks_engraving");
        s.one( OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_TILES,        "yellow_marble_tiles_engraving");
        s.one( OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_POLISHED_MARBLE,     "yellow_polished_marble_engraving");
        // ── yellow_terracotta ──
        s.one( Blocks.YELLOW_TERRACOTTA, OttBlocks.YELLOW_TERRACOTTA_CTM, "yellow_terracotta_pillar_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.CIRCULAR_YELLOW_TERRACOTTA, "circular_yellow_terracotta_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.CURLED_YELLOW_TERRACOTTA, "curled_yellow_terracotta_ctm_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.HEXAGONICAL_YELLOW_TERRACOTTA, "hexagonical_yellow_terracotta_ctm_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.INSCRIBED_YELLOW_TERRACOTTA, "inscribed_yellow_terracotta_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.SMALL_YELLOW_TERRACOTTA_TILES, "small_yellow_terracotta_tiles_ctm_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.STARRY_YELLOW_TERRACOTTA, "starry_yellow_terracotta_engraving");
        s.tagged( materialTag("yellow_terracotta"), OttBlocks.YELLOW_TERRACOTTA_COLUMN, "yellow_terracotta_column_ctm_engraving");

        // ═══════ bulk / data-driven & special (loops, arrays, wood doors, leaves) ═══════
        com.otterly76.ott_blocks.block.OttTemplateBlocks.BY_NAME.forEach((name, block) ->
                s.tagged(
                        materialTag(com.otterly76.ott_blocks.block.OttTemplateBlocks.MATERIAL_BY_NAME.get(name)),
                        block, name + "_engraving"));

        String[][] uncategorizedStone = {
            {"asurine_cut_polished_ctm","asurine"},
            {"asurine_cut_small_brick_ctm","asurine"},
            {"crimsite_cut_polished_ctm","crimsite"},
            {"crimsite_cut_small_brick_ctm","crimsite"},
            {"curly_dark_prismarine_ctm","dark_prismarine"},
            {"curly_dirt_ctm","dirt"},
            {"curly_dripstone_block_ctm","dripstone"},
            {"curly_prismarine_ctm","prismarine"},
            {"curly_purpur_block_ctm","purpur_block"},
            {"curly_red_nether_bricks_ctm","red_nether_bricks"},
            {"dark_prismarine_beams_ctm","dark_prismarine"},
            {"dark_prismarine_brick_paving_ctm","dark_prismarine"},
            {"dark_prismarine_bricks_ctm","dark_prismarine"},
            {"dark_prismarine_dotted_ctm","dark_prismarine"},
            {"dark_prismarine_fabric_ctm","dark_prismarine"},
            {"dark_prismarine_large_tiles_ctm","dark_prismarine"},
            {"dark_prismarine_rotated_bricks_ctm","dark_prismarine"},
            {"dark_prismarine_rows_ctm","dark_prismarine"},
            {"dark_prismarine_squares_ctm","dark_prismarine"},
            {"dark_prismarine_tiles_ctm","dark_prismarine"},
            {"dark_prismarine_wavy_ctm","dark_prismarine"},
            {"dark_prismarine_woven_ctm","dark_prismarine"},
            {"diamond_block_chiseled_ctm","diamond_block"},
            {"diamond_block_chiseled_cubes_ctm","diamond_block"},
            {"diamond_block_connecting_ctm","diamond_block"},
            {"diamond_block_ctm","diamond_block"},
            {"diamond_block_grid_ctm","diamond_block"},
            {"diamond_block_jewel_block_ctm","diamond_block"},
            {"diamond_block_polished_ctm","diamond_block"},
            {"diamond_block_rhombuses_ctm","diamond_block"},
            {"diamond_block_shiny_bordered_ctm","diamond_block"},
            {"diamond_block_small_tiles_ctm","diamond_block"},
            {"dirt_blobs_ctm","dirt"},
            {"dirt_bricks_ctm","dirt"},
            {"dirt_chunks_ctm","dirt"},
            {"dirt_clumps_ctm","dirt"},
            {"dirt_large_tiles_ctm","dirt"},
            {"dirt_small_bricks_ctm","dirt"},
            {"dirt_small_tiles_ctm","dirt"},
            {"dirt_smooth_clumps_ctm","dirt"},
            {"dirt_soil_ctm","dirt"},
            {"dirt_squares_ctm","dirt"},
            {"dirt_tiles_ctm","dirt"},
            {"dirt_tilled_ctm","dirt"},
            {"dripstone_cut_polished_ctm","dripstone"},
            {"dripstone_cut_small_brick_ctm","dripstone"},
            {"fine_dark_prismarine_ctm","dark_prismarine"},
            {"fine_dirt_ctm","dirt"},
            {"fine_dripstone_block_ctm","dripstone"},
            {"fine_prismarine_ctm","prismarine"},
            {"fine_purpur_block_ctm","purpur_block"},
            {"fine_red_nether_bricks_ctm","red_nether_bricks"},
            {"glowstone_brick_pattern_ctm","glowstone"},
            {"glowstone_brick_paving_ctm","glowstone"},
            {"glowstone_bricks_ctm","glowstone"},
            {"glowstone_crushed_ctm","glowstone"},
            {"glowstone_large_tiles_ctm","glowstone"},
            {"glowstone_rotated_bricks_ctm","glowstone"},
            {"glowstone_small_tiles_ctm","glowstone"},
            {"glowstone_smooth_ctm","glowstone"},
            {"glowstone_tiles_ctm","glowstone"},
            {"ochrum_cut_polished_ctm","ochrum"},
            {"ochrum_cut_small_brick_ctm","ochrum"},
            {"ornate_dark_prismarine_ctm","dark_prismarine"},
            {"ornate_dirt_ctm","dirt"},
            {"ornate_dripstone_block_ctm","dripstone"},
            {"ornate_prismarine_ctm","prismarine"},
            {"ornate_purpur_block_ctm","purpur_block"},
            {"ornate_red_nether_bricks_ctm","red_nether_bricks"},
            {"polished_dripstone_ctm","dripstone"},
            {"prismarine_bricks_beams_ctm","prismarine"},
            {"prismarine_bricks_brick_pattern_ctm","prismarine"},
            {"prismarine_bricks_brick_paving_ctm","prismarine"},
            {"prismarine_bricks_bricks_ctm","prismarine"},
            {"prismarine_bricks_chiseled_circles_ctm","prismarine"},
            {"prismarine_bricks_chiseled_squares_ctm","prismarine"},
            {"prismarine_bricks_diagonal_bricks_ctm","prismarine"},
            {"prismarine_bricks_diagonal_tiles_ctm","prismarine"},
            {"prismarine_bricks_dotted_ctm","prismarine"},
            {"prismarine_bricks_pillars_ctm","prismarine"},
            {"prismarine_bricks_rotated_bricks_ctm","prismarine"},
            {"prismarine_bricks_rows_ctm","prismarine"},
            {"prismarine_bricks_small_tiles_ctm","prismarine"},
            {"prismarine_bricks_squares_ctm","prismarine"},
            {"prismarine_bricks_tiles_ctm","prismarine"},
            {"prismarine_bricks_wavy_ctm","prismarine"},
            {"prismarine_bricks_woven_ctm","prismarine"},
            {"purpur_brick_pattern_ctm","purpur_block"},
            {"purpur_brick_paving_ctm","purpur_block"},
            {"purpur_bricks_ctm","purpur_block"},
            {"purpur_diagonal_bricks_ctm","purpur_block"},
            {"purpur_diagonal_tiles_ctm","purpur_block"},
            {"purpur_dotted_ctm","purpur_block"},
            {"purpur_fabric_ctm","purpur_block"},
            {"purpur_jagged_pattern_ctm","purpur_block"},
            {"purpur_large_tiles_ctm","purpur_block"},
            {"purpur_organic_pattern_ctm","purpur_block"},
            {"purpur_rotated_bricks_ctm","purpur_block"},
            {"purpur_slanted_tiles_ctm","purpur_block"},
            {"purpur_small_tiles_ctm","purpur_block"},
            {"purpur_spiral_pattern_ctm","purpur_block"},
            {"purpur_squares_ctm","purpur_block"},
            {"purpur_tiles_ctm","purpur_block"},
            {"purpur_woven_ctm","purpur_block"},
            {"red_nether_bricks_beams_ctm","red_nether_bricks"},
            {"red_nether_bricks_brick_pattern_ctm","red_nether_bricks"},
            {"red_nether_bricks_brick_paving_ctm","red_nether_bricks"},
            {"red_nether_bricks_chiseled_squares_ctm","red_nether_bricks"},
            {"red_nether_bricks_diagonal_bricks_ctm","red_nether_bricks"},
            {"red_nether_bricks_large_bricks_ctm","red_nether_bricks"},
            {"red_nether_bricks_large_tiles_ctm","red_nether_bricks"},
            {"red_nether_bricks_rotated_bricks_ctm","red_nether_bricks"},
            {"red_nether_bricks_small_tiles_ctm","red_nether_bricks"},
            {"red_nether_bricks_smooth_ctm","red_nether_bricks"},
            {"red_nether_bricks_squares_ctm","red_nether_bricks"},
            {"red_nether_bricks_tiles_ctm","red_nether_bricks"},
            {"rose_quartz_bricks_ctm","rose_quartz"},
            {"rose_quartz_chiseled_ctm","rose_quartz"},
            {"rose_quartz_crushed_ctm","rose_quartz"},
            {"rose_quartz_polished_block_ctm","rose_quartz"},
            {"rose_quartz_squares_ctm","rose_quartz"},
            {"rose_quartz_tiles_ctm","rose_quartz"},
            {"scorchia_cut_polished_ctm","scorchia"},
            {"scorchia_cut_small_brick_ctm","scorchia"},
            {"scoria_cut_polished_ctm","scoria"},
            {"scoria_cut_small_brick_ctm","scoria"},
            {"simple_dark_prismarine_ctm","dark_prismarine"},
            {"simple_dirt_ctm","dirt"},
            {"simple_dripstone_block_ctm","dripstone"},
            {"simple_prismarine_ctm","prismarine"},
            {"simple_purpur_block_ctm","purpur_block"},
            {"simple_red_nether_bricks_ctm","red_nether_bricks"},
            {"veridium_cut_polished_ctm","veridium"},
            {"veridium_cut_small_brick_ctm","veridium"},
        };

        for (String[] usE : uncategorizedStone) {
            Block usB = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", usE[0]));
            if (usB != Blocks.AIR) s.tagged(materialTag(usE[1]), usB, usE[0] + "_engraving");
        }

        for (String[] csE : new String[][]{ {"cut_sandstone_ctm","sandstone"}, {"cut_red_sandstone_ctm","red_sandstone"} }) {
            Block csB = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", csE[0]));
            if (csB != Blocks.AIR) s.tagged(materialTag(csE[1]), csB, csE[0] + "_engraving");
        }

        String[][] uncategorizedRest = {
            {"amethyst_block_ctm","amethyst_block"},
            {"arched_leaded_glass_ctm","glass"},
            {"blue_ice_ctm","blue_ice"},
            {"bone_block_ctm","bone_block"},
            {"borderless_glass_black_ctm","black_stained_glass"},
            {"borderless_glass_blue_ctm","blue_stained_glass"},
            {"borderless_glass_brown_ctm","brown_stained_glass"},
            {"borderless_glass_cyan_ctm","cyan_stained_glass"},
            {"borderless_glass_gray_ctm","gray_stained_glass"},
            {"borderless_glass_green_ctm","green_stained_glass"},
            {"borderless_glass_light_blue_ctm","light_blue_stained_glass"},
            {"borderless_glass_light_gray_ctm","light_gray_stained_glass"},
            {"borderless_glass_lime_ctm","lime_stained_glass"},
            {"borderless_glass_magenta_ctm","magenta_stained_glass"},
            {"borderless_glass_orange_ctm","orange_stained_glass"},
            {"borderless_glass_pink_ctm","pink_stained_glass"},
            {"borderless_glass_purple_ctm","purple_stained_glass"},
            {"borderless_glass_red_ctm","red_stained_glass"},
            {"borderless_glass_white_ctm","white_stained_glass"},
            {"borderless_glass_yellow_ctm","yellow_stained_glass"},
            {"carved_mud_bricks_ctm","mud_bricks"},
            {"carved_mud_ctm","mud"},
            {"carved_packed_mud_ctm","packed_mud"},
            {"chiseled_glass_ctm","glass"},
            {"clear_glass_ctm","glass"},
            {"curly_amethyst_block_ctm","amethyst_block"},
            {"curly_ancient_debris_ctm","ancient_debris"},
            {"curly_andesite_ctm","andesite"},
            {"curly_basalt_ctm","basalt"},
            {"curly_blackstone_ctm","blackstone"},
            {"curly_blue_ice_ctm","blue_ice"},
            {"curly_borderless_bricks_ctm","borderless_bricks"},
            {"curly_bricks_ctm","bricks"},
            {"curly_calcite_ctm","calcite"},
            {"curly_clay_ctm","clay"},
            {"curly_coal_block_ctm","coal_block"},
            {"curly_cobblestone_ctm","cobblestone"},
            {"curly_crying_obsidian_ctm","crying_obsidian"},
            {"curly_deepslate_ctm","deepslate"},
            {"curly_diorite_ctm","diorite"},
            {"curly_end_stone_ctm","end_stone"},
            {"curly_gilded_blackstone_ctm","gilded_blackstone"},
            {"curly_granite_ctm","granite"},
            {"curly_ice_ctm","ice"},
            {"curly_lapis_block_ctm","lapis_block"},
            {"curly_lodestone_ctm","lodestone"},
            {"curly_magma_block_ctm","magma_block"},
            {"curly_mossy_cobblestone_ctm","mossy_cobblestone"},
            {"curly_mossy_stone_bricks_ctm","mossy_stone_bricks"},
            {"curly_mud_bricks_ctm","mud_bricks"},
            {"curly_mud_ctm","mud"},
            {"curly_nether_bricks_ctm","nether_bricks"},
            {"curly_netherrack_ctm","netherrack"},
            {"curly_obsidian_ctm","obsidian"},
            {"curly_packed_ice_ctm","packed_ice"},
            {"curly_packed_mud_ctm","packed_mud"},
            {"curly_quartz_block_ctm","quartz_block"},
            {"curly_raw_copper_block_ctm","raw_copper_block"},
            {"curly_raw_gold_block_ctm","raw_gold_block"},
            {"curly_raw_iron_block_ctm","raw_iron_block"},
            {"curly_red_sandstone_ctm","red_sandstone"},
            {"curly_redstone_block_ctm","redstone_block"},
            {"curly_sandstone_ctm","sandstone"},
            {"curly_smooth_stone_ctm","smooth_stone"},
            {"curly_snow_block_ctm","snow_block"},
            {"curly_tuff_ctm","tuff"},
            {"dirty_glass_ctm","glass"},
            {"fancy_leaded_glass_ctm","glass"},
            {"fancy_mud_bricks_ctm","mud_bricks"},
            {"fancy_mud_ctm","mud"},
            {"fancy_packed_mud_ctm","packed_mud"},
            {"fine_amethyst_block_ctm","amethyst_block"},
            {"fine_ancient_debris_ctm","ancient_debris"},
            {"fine_andesite_ctm","andesite"},
            {"fine_basalt_ctm","basalt"},
            {"fine_blackstone_ctm","blackstone"},
            {"fine_blue_ice_ctm","blue_ice"},
            {"fine_borderless_bricks_ctm","borderless_bricks"},
            {"fine_bricks_ctm","bricks"},
            {"fine_calcite_ctm","calcite"},
            {"fine_clay_ctm","clay"},
            {"fine_coal_block_ctm","coal_block"},
            {"fine_cobblestone_ctm","cobblestone"},
            {"fine_crying_obsidian_ctm","crying_obsidian"},
            {"fine_deepslate_ctm","deepslate"},
            {"fine_diorite_ctm","diorite"},
            {"fine_end_stone_ctm","end_stone"},
            {"fine_gilded_blackstone_ctm","gilded_blackstone"},
            {"fine_granite_ctm","granite"},
            {"fine_ice_ctm","ice"},
            {"fine_lapis_block_ctm","lapis_block"},
            {"fine_lodestone_ctm","lodestone"},
            {"fine_magma_block_ctm","magma_block"},
            {"fine_mossy_cobblestone_ctm","mossy_cobblestone"},
            {"fine_mossy_stone_bricks_ctm","mossy_stone_bricks"},
            {"fine_mud_bricks_ctm","mud_bricks"},
            {"fine_mud_ctm","mud"},
            {"fine_nether_bricks_ctm","nether_bricks"},
            {"fine_netherrack_ctm","netherrack"},
            {"fine_obsidian_ctm","obsidian"},
            {"fine_packed_ice_ctm","packed_ice"},
            {"fine_packed_mud_ctm","packed_mud"},
            {"fine_quartz_block_ctm","quartz_block"},
            {"fine_raw_copper_block_ctm","raw_copper_block"},
            {"fine_raw_gold_block_ctm","raw_gold_block"},
            {"fine_raw_iron_block_ctm","raw_iron_block"},
            {"fine_red_sandstone_ctm","red_sandstone"},
            {"fine_redstone_block_ctm","redstone_block"},
            {"fine_sandstone_ctm","sandstone"},
            {"fine_smooth_stone_ctm","smooth_stone"},
            {"fine_snow_block_ctm","snow_block"},
            {"fine_tuff_ctm","tuff"},
            {"frosted_glass_ctm","glass"},
            {"glass_ctm","glass"},
            {"golden_framed_black_stained_glass_ctm","black_stained_glass"},
            {"golden_framed_blue_stained_glass_ctm","blue_stained_glass"},
            {"golden_framed_brown_stained_glass_ctm","brown_stained_glass"},
            {"golden_framed_cyan_stained_glass_ctm","cyan_stained_glass"},
            {"golden_framed_gray_stained_glass_ctm","gray_stained_glass"},
            {"golden_framed_green_stained_glass_ctm","green_stained_glass"},
            {"golden_framed_light_blue_stained_glass_ctm","light_blue_stained_glass"},
            {"golden_framed_light_gray_stained_glass_ctm","light_gray_stained_glass"},
            {"golden_framed_lime_stained_glass_ctm","lime_stained_glass"},
            {"golden_framed_magenta_stained_glass_ctm","magenta_stained_glass"},
            {"golden_framed_orange_stained_glass_ctm","orange_stained_glass"},
            {"golden_framed_pink_stained_glass_ctm","pink_stained_glass"},
            {"golden_framed_purple_stained_glass_ctm","purple_stained_glass"},
            {"golden_framed_red_stained_glass_ctm","red_stained_glass"},
            {"golden_framed_white_stained_glass_ctm","white_stained_glass"},
            {"golden_framed_yellow_stained_glass_ctm","yellow_stained_glass"},
            {"ice_glass_ctm","ice"},
            {"obsidian_framed_glass_ctm","obsidian"},
            {"ornate_amethyst_block_ctm","amethyst_block"},
            {"ornate_ancient_debris_ctm","ancient_debris"},
            {"ornate_andesite_ctm","andesite"},
            {"ornate_basalt_ctm","basalt"},
            {"ornate_blackstone_ctm","blackstone"},
            {"ornate_blue_ice_ctm","blue_ice"},
            {"ornate_borderless_bricks_ctm","borderless_bricks"},
            {"ornate_bricks_ctm","bricks"},
            {"ornate_calcite_ctm","calcite"},
            {"ornate_clay_ctm","clay"},
            {"ornate_coal_block_ctm","coal_block"},
            {"ornate_cobblestone_ctm","cobblestone"},
            {"ornate_crying_obsidian_ctm","crying_obsidian"},
            {"ornate_deepslate_ctm","deepslate"},
            {"ornate_diorite_ctm","diorite"},
            {"ornate_end_stone_ctm","end_stone"},
            {"ornate_gilded_blackstone_ctm","gilded_blackstone"},
            {"ornate_granite_ctm","granite"},
            {"ornate_ice_ctm","ice"},
            {"ornate_lapis_block_ctm","lapis_block"},
            {"ornate_lodestone_ctm","lodestone"},
            {"ornate_magma_block_ctm","magma_block"},
            {"ornate_mossy_cobblestone_ctm","mossy_cobblestone"},
            {"ornate_mossy_stone_bricks_ctm","mossy_stone_bricks"},
            {"ornate_mud_bricks_ctm","mud_bricks"},
            {"ornate_mud_ctm","mud"},
            {"ornate_nether_bricks_ctm","nether_bricks"},
            {"ornate_netherrack_ctm","netherrack"},
            {"ornate_obsidian_ctm","obsidian"},
            {"ornate_packed_ice_ctm","packed_ice"},
            {"ornate_packed_mud_ctm","packed_mud"},
            {"ornate_quartz_block_ctm","quartz_block"},
            {"ornate_raw_copper_block_ctm","raw_copper_block"},
            {"ornate_raw_gold_block_ctm","raw_gold_block"},
            {"ornate_raw_iron_block_ctm","raw_iron_block"},
            {"ornate_red_sandstone_ctm","red_sandstone"},
            {"ornate_redstone_block_ctm","redstone_block"},
            {"ornate_sandstone_ctm","sandstone"},
            {"ornate_smooth_stone_ctm","smooth_stone"},
            {"ornate_snow_block_ctm","snow_block"},
            {"ornate_tuff_ctm","tuff"},
            {"quartz_block_chiseled_ctm","quartz_block"},
            {"quartz_block_ctm","quartz_block"},
            {"redstone_block_ctm","redstone_block"},
            {"reinforced_glass_ctm","glass"},
            {"sandstone_framed_glass_ctm","sandstone"},
            {"scratched_glass_black_ctm","black_stained_glass"},
            {"scratched_glass_blue_ctm","blue_stained_glass"},
            {"scratched_glass_brown_ctm","brown_stained_glass"},
            {"scratched_glass_cyan_ctm","cyan_stained_glass"},
            {"scratched_glass_gray_ctm","gray_stained_glass"},
            {"scratched_glass_green_ctm","green_stained_glass"},
            {"scratched_glass_light_blue_ctm","light_blue_stained_glass"},
            {"scratched_glass_light_gray_ctm","light_gray_stained_glass"},
            {"scratched_glass_lime_ctm","lime_stained_glass"},
            {"scratched_glass_magenta_ctm","magenta_stained_glass"},
            {"scratched_glass_orange_ctm","orange_stained_glass"},
            {"scratched_glass_pink_ctm","pink_stained_glass"},
            {"scratched_glass_purple_ctm","purple_stained_glass"},
            {"scratched_glass_red_ctm","red_stained_glass"},
            {"scratched_glass_white_ctm","white_stained_glass"},
            {"scratched_glass_yellow_ctm","yellow_stained_glass"},
            {"simple_amethyst_block_ctm","amethyst_block"},
            {"simple_ancient_debris_ctm","ancient_debris"},
            {"simple_andesite_ctm","andesite"},
            {"simple_basalt_ctm","basalt"},
            {"simple_blackstone_ctm","blackstone"},
            {"simple_blue_ice_ctm","blue_ice"},
            {"simple_borderless_bricks_ctm","borderless_bricks"},
            {"simple_bricks_ctm","bricks"},
            {"simple_calcite_ctm","calcite"},
            {"simple_clay_ctm","clay"},
            {"simple_coal_block_ctm","coal_block"},
            {"simple_cobblestone_ctm","cobblestone"},
            {"simple_crying_obsidian_ctm","crying_obsidian"},
            {"simple_deepslate_ctm","deepslate"},
            {"simple_diorite_ctm","diorite"},
            {"simple_end_stone_ctm","end_stone"},
            {"simple_gilded_blackstone_ctm","gilded_blackstone"},
            {"simple_granite_ctm","granite"},
            {"simple_ice_ctm","ice"},
            {"simple_lapis_block_ctm","lapis_block"},
            {"simple_lodestone_ctm","lodestone"},
            {"simple_magma_block_ctm","magma_block"},
            {"simple_mossy_cobblestone_ctm","mossy_cobblestone"},
            {"simple_mossy_stone_bricks_ctm","mossy_stone_bricks"},
            {"simple_mud_bricks_ctm","mud_bricks"},
            {"simple_mud_ctm","mud"},
            {"simple_nether_bricks_ctm","nether_bricks"},
            {"simple_netherrack_ctm","netherrack"},
            {"simple_obsidian_ctm","obsidian"},
            {"simple_packed_ice_ctm","packed_ice"},
            {"simple_packed_mud_ctm","packed_mud"},
            {"simple_quartz_block_ctm","quartz_block"},
            {"simple_raw_copper_block_ctm","raw_copper_block"},
            {"simple_raw_gold_block_ctm","raw_gold_block"},
            {"simple_raw_iron_block_ctm","raw_iron_block"},
            {"simple_red_sandstone_ctm","red_sandstone"},
            {"simple_redstone_block_ctm","redstone_block"},
            {"simple_sandstone_ctm","sandstone"},
            {"simple_smooth_stone_ctm","smooth_stone"},
            {"simple_snow_block_ctm","snow_block"},
            {"simple_tuff_ctm","tuff"},
            {"soul_glass_ctm","glass"},
            {"stone_framed_glass_ctm","stone"},
            {"tinted_clear_glass_ctm","glass"},
            {"tinted_glass_ctm","tinted_glass"},
        };

        for (String[] rE : uncategorizedRest) {
            Block rB = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", rE[0]));
            if (rB != Blocks.AIR) s.tagged(materialTag(rE[1]), rB, rE[0] + "_engraving");
        }

        java.util.stream.Stream.of(
                ModBlocks.CHISEL_PILLARS, ModBlocks.CHISEL_PILLARS_RS,
                ModBlocks.CHISEL_LEGEND, ModBlocks.CHISEL_LEGEND_RS
        ).forEach(map -> map.forEach((name, block) ->
                s.one( Blocks.STONE, block, name + "_engraving")));

        for (ModBlocks.ChiselStone cs : ModBlocks.CHISEL_CHAOS) {
            for (String v : ModBlocks.CHISEL_VARIANTS) {
                for (String inlay : ModBlocks.CHISEL_INLAYS) {
                    String n = "chiseled_" + cs.prefix() + "_" + v + (inlay.isEmpty() ? "" : "_" + inlay);
                    s.one( cs.base(), ModBlocks.CHISEL_CHAOS_PILLARS.get(n), n + "_engraving");
                }
                String rn = "chiseled_" + cs.prefix() + "_" + v + "_redstone";
                s.one( cs.base(), ModBlocks.CHISEL_CHAOS_PILLARS_RS.get(rn), rn + "_engraving");
            }
            for (String inlay : ModBlocks.CHISEL_INLAYS) {
                String ln = "chiseled_" + cs.prefix() + "_legend" + (inlay.isEmpty() ? "" : "_" + inlay);
                s.one( cs.base(), ModBlocks.CHISEL_CHAOS_LEGENDS.get(ln), ln + "_engraving");
            }
            String lrn = "chiseled_" + cs.prefix() + "_legend_redstone";
            s.one( cs.base(), ModBlocks.CHISEL_CHAOS_LEGENDS_RS.get(lrn), lrn + "_engraving");
        }

        Block whitePlastered = ModBlocks.PATTERN_BLOCKS.get("plastered_stone").get("white").get();

        s.one( whitePlastered,
                ModBlocks.PATTERN_BLOCKS.get("gilded_plastered_stone").get("white").get(),   "white_gilded_plastered_stone_engraving");

        s.one( whitePlastered,
                ModBlocks.PATTERN_BLOCKS.get("delicate_plastered_stone").get("white").get(), "white_delicate_plastered_stone_engraving");

        s.one( whitePlastered,
                ModBlocks.PATTERN_BLOCKS.get("banded_plastered_stone").get("white").get(),   "white_banded_plastered_stone_engraving");

        s.one( whitePlastered,
                OttBlocks.CHISELED_PLASTERED_STONE_PILLAR,                                   "chiseled_plastered_stone_pillar_engraving");

        for (String style : OttBlocks.DECO_STYLES) {
            for (String color : OttBlocks.STYLED_CARPET_COLORS) {
                for (String suf : new String[]{"_wool", "_wool_ctm"}) {
                    String wn = style + "_" + color + suf;
                    s.tagged( materialTag(color + "_wool"),
                            OttBlocks.DECO_WOOL.get(wn).get(), wn + "_engraving");
                }
            }
        }

        for (String style : OttBlocks.STYLED_CARPET_STYLES) {
            for (String color : OttBlocks.STYLED_CARPET_COLORS) {
                for (String suf : new String[]{"_wool", "_wool_ctm"}) {
                    String wn = style + "_" + color + suf;
                    s.tagged( materialTag(color + "_wool"),
                            OttBlocks.STYLED_WOOL.get(wn).get(), wn + "_engraving");
                }
            }
        }

        OttBlocks.WOOD_DOORS.forEach((wood, styleMap) -> {
            TagKey<Item> woodDoorsTag = TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/" + wood));
            styleMap.forEach((style, block) ->
                    s.tagged( woodDoorsTag, block.get(), style + "_" + wood + "_door_engraving")
            );
        });

        {
            // oak
            TagKey<Item> oakTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/oak"));
            s.tagged( oakTag, Items.OAK_DOOR, "vanilla_oak_door_engraving");
            s.tagged( oakTag, Items.OAK_TRAPDOOR, "vanilla_oak_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("japanese_oak_door").get(), "japanese_oak_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_bamboo_door").get(), "oak_bamboo_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_barn_door").get(), "oak_barn_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_beach_door").get(), "oak_beach_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_cottage_door").get(), "oak_cottage_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_four_panel_door").get(), "oak_four_panel_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_glass_door").get(), "oak_glass_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_japanese_door").get(), "oak_japanese_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_modern_door").get(), "oak_modern_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_mystic_door").get(), "oak_mystic_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_nether_door").get(), "oak_nether_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_paper_door").get(), "oak_paper_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_stable_door").get(), "oak_stable_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_swamp_door").get(), "oak_swamp_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_tropical_door").get(), "oak_tropical_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_waffle_door").get(), "oak_waffle_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_whispering_door").get(), "oak_whispering_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_barn_glass_door").get(), "oak_barn_glass_door_engraving");
            s.tagged( oakTag, OttBlocks.EXTRA_DOORS.get("oak_stable_head_door").get(), "oak_stable_head_door_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_bamboo_trapdoor").get(), "oak_bamboo_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_barn_trapdoor").get(), "oak_barn_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_barred_trapdoor").get(), "oak_barred_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_beach_trapdoor").get(), "oak_beach_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_blossom_trapdoor").get(), "oak_blossom_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_cottage_trapdoor").get(), "oak_cottage_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_four_panel_trapdoor").get(), "oak_four_panel_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_glass_trapdoor").get(), "oak_glass_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_mystic_trapdoor").get(), "oak_mystic_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_paper_trapdoor").get(), "oak_paper_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_swamp_trapdoor").get(), "oak_swamp_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_tropical_trapdoor").get(), "oak_tropical_trapdoor_engraving");
            s.tagged( oakTag, OttBlocks.WOOD_TRAPDOORS.get("oak_whispering_trapdoor").get(), "oak_whispering_trapdoor_engraving");

            // spruce
            TagKey<Item> spruceTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/spruce"));
            s.tagged( spruceTag, Items.SPRUCE_DOOR, "vanilla_spruce_door_engraving");
            s.tagged( spruceTag, Items.SPRUCE_TRAPDOOR, "vanilla_spruce_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("japanese_spruce_door").get(), "japanese_spruce_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_bamboo_door").get(), "spruce_bamboo_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_barn_door").get(), "spruce_barn_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_beach_door").get(), "spruce_beach_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_classic_door").get(), "spruce_classic_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_four_panel_door").get(), "spruce_four_panel_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_glass_door").get(), "spruce_glass_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_japanese_door").get(), "spruce_japanese_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_modern_door").get(), "spruce_modern_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_mystic_door").get(), "spruce_mystic_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_nether_door").get(), "spruce_nether_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_paper_door").get(), "spruce_paper_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_stable_door").get(), "spruce_stable_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_swamp_door").get(), "spruce_swamp_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_tropical_door").get(), "spruce_tropical_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_waffle_door").get(), "spruce_waffle_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_whispering_door").get(), "spruce_whispering_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_barn_glass_door").get(), "spruce_barn_glass_door_engraving");
            s.tagged( spruceTag, OttBlocks.EXTRA_DOORS.get("spruce_stable_head_door").get(), "spruce_stable_head_door_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_bamboo_trapdoor").get(), "spruce_bamboo_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_barn_trapdoor").get(), "spruce_barn_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_barred_trapdoor").get(), "spruce_barred_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_barrel_trapdoor").get(), "spruce_barrel_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_beach_trapdoor").get(), "spruce_beach_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_blossom_trapdoor").get(), "spruce_blossom_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_classic_trapdoor").get(), "spruce_classic_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_four_panel_trapdoor").get(), "spruce_four_panel_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_glass_trapdoor").get(), "spruce_glass_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_mystic_trapdoor").get(), "spruce_mystic_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_paper_trapdoor").get(), "spruce_paper_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_swamp_trapdoor").get(), "spruce_swamp_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_tropical_trapdoor").get(), "spruce_tropical_trapdoor_engraving");
            s.tagged( spruceTag, OttBlocks.WOOD_TRAPDOORS.get("spruce_whispering_trapdoor").get(), "spruce_whispering_trapdoor_engraving");

            // birch
            TagKey<Item> birchTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/birch"));
            s.tagged( birchTag, Items.BIRCH_DOOR, "vanilla_birch_door_engraving");
            s.tagged( birchTag, Items.BIRCH_TRAPDOOR, "vanilla_birch_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_bamboo_door").get(), "birch_bamboo_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_barn_door").get(), "birch_barn_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_beach_door").get(), "birch_beach_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_classic_door").get(), "birch_classic_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_cottage_door").get(), "birch_cottage_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_four_panel_door").get(), "birch_four_panel_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_glass_door").get(), "birch_glass_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_japanese_door").get(), "birch_japanese_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_modern_door").get(), "birch_modern_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_mystic_door").get(), "birch_mystic_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_nether_door").get(), "birch_nether_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_stable_door").get(), "birch_stable_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_swamp_door").get(), "birch_swamp_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_tropical_door").get(), "birch_tropical_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_waffle_door").get(), "birch_waffle_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_whispering_door").get(), "birch_whispering_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("japanese_birch_door").get(), "japanese_birch_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_barn_glass_door").get(), "birch_barn_glass_door_engraving");
            s.tagged( birchTag, OttBlocks.EXTRA_DOORS.get("birch_stable_head_door").get(), "birch_stable_head_door_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_bamboo_trapdoor").get(), "birch_bamboo_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_barn_trapdoor").get(), "birch_barn_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_barred_trapdoor").get(), "birch_barred_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_barrel_trapdoor").get(), "birch_barrel_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_beach_trapdoor").get(), "birch_beach_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_blossom_trapdoor").get(), "birch_blossom_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_classic_trapdoor").get(), "birch_classic_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_cottage_trapdoor").get(), "birch_cottage_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_four_panel_trapdoor").get(), "birch_four_panel_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_glass_trapdoor").get(), "birch_glass_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_mystic_trapdoor").get(), "birch_mystic_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_swamp_trapdoor").get(), "birch_swamp_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_tropical_trapdoor").get(), "birch_tropical_trapdoor_engraving");
            s.tagged( birchTag, OttBlocks.WOOD_TRAPDOORS.get("birch_whispering_trapdoor").get(), "birch_whispering_trapdoor_engraving");

            // jungle
            TagKey<Item> jungleTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/jungle"));
            s.tagged( jungleTag, Items.JUNGLE_DOOR, "vanilla_jungle_door_engraving");
            s.tagged( jungleTag, Items.JUNGLE_TRAPDOOR, "vanilla_jungle_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("japanese_jungle_door").get(), "japanese_jungle_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_bamboo_door").get(), "jungle_bamboo_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_barn_door").get(), "jungle_barn_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_classic_door").get(), "jungle_classic_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_cottage_door").get(), "jungle_cottage_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_four_panel_door").get(), "jungle_four_panel_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_glass_door").get(), "jungle_glass_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_japanese_door").get(), "jungle_japanese_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_modern_door").get(), "jungle_modern_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_mystic_door").get(), "jungle_mystic_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_nether_door").get(), "jungle_nether_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_paper_door").get(), "jungle_paper_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_stable_door").get(), "jungle_stable_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_swamp_door").get(), "jungle_swamp_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_tropical_door").get(), "jungle_tropical_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_waffle_door").get(), "jungle_waffle_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_whispering_door").get(), "jungle_whispering_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_barn_glass_door").get(), "jungle_barn_glass_door_engraving");
            s.tagged( jungleTag, OttBlocks.EXTRA_DOORS.get("jungle_stable_head_door").get(), "jungle_stable_head_door_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_bamboo_trapdoor").get(), "jungle_bamboo_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_barn_trapdoor").get(), "jungle_barn_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_barred_trapdoor").get(), "jungle_barred_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_blossom_trapdoor").get(), "jungle_blossom_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_classic_trapdoor").get(), "jungle_classic_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_cottage_trapdoor").get(), "jungle_cottage_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_four_panel_trapdoor").get(), "jungle_four_panel_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_glass_trapdoor").get(), "jungle_glass_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_mystic_trapdoor").get(), "jungle_mystic_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_paper_trapdoor").get(), "jungle_paper_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_swamp_trapdoor").get(), "jungle_swamp_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_tropical_trapdoor").get(), "jungle_tropical_trapdoor_engraving");
            s.tagged( jungleTag, OttBlocks.WOOD_TRAPDOORS.get("jungle_whispering_trapdoor").get(), "jungle_whispering_trapdoor_engraving");

            // acacia
            TagKey<Item> acaciaTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/acacia"));
            s.tagged( acaciaTag, Items.ACACIA_DOOR, "vanilla_acacia_door_engraving");
            s.tagged( acaciaTag, Items.ACACIA_TRAPDOOR, "vanilla_acacia_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_bamboo_door").get(), "acacia_bamboo_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_barn_door").get(), "acacia_barn_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_beach_door").get(), "acacia_beach_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_classic_door").get(), "acacia_classic_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_cottage_door").get(), "acacia_cottage_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_four_panel_door").get(), "acacia_four_panel_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_glass_door").get(), "acacia_glass_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_japanese_door").get(), "acacia_japanese_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_modern_door").get(), "acacia_modern_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_mystic_door").get(), "acacia_mystic_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_nether_door").get(), "acacia_nether_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_paper_door").get(), "acacia_paper_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_stable_door").get(), "acacia_stable_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_swamp_door").get(), "acacia_swamp_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_waffle_door").get(), "acacia_waffle_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_whispering_door").get(), "acacia_whispering_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("japanese_acacia_door").get(), "japanese_acacia_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_barn_glass_door").get(), "acacia_barn_glass_door_engraving");
            s.tagged( acaciaTag, OttBlocks.EXTRA_DOORS.get("acacia_stable_head_door").get(), "acacia_stable_head_door_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_bamboo_trapdoor").get(), "acacia_bamboo_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_barn_trapdoor").get(), "acacia_barn_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_barred_trapdoor").get(), "acacia_barred_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_barrel_trapdoor").get(), "acacia_barrel_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_beach_trapdoor").get(), "acacia_beach_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_blossom_trapdoor").get(), "acacia_blossom_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_classic_trapdoor").get(), "acacia_classic_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_cottage_trapdoor").get(), "acacia_cottage_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_four_panel_trapdoor").get(), "acacia_four_panel_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_glass_trapdoor").get(), "acacia_glass_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_mystic_trapdoor").get(), "acacia_mystic_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_paper_trapdoor").get(), "acacia_paper_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_swamp_trapdoor").get(), "acacia_swamp_trapdoor_engraving");
            s.tagged( acaciaTag, OttBlocks.WOOD_TRAPDOORS.get("acacia_whispering_trapdoor").get(), "acacia_whispering_trapdoor_engraving");

            // dark_oak
            TagKey<Item> dark_oakTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/dark_oak"));
            s.tagged( dark_oakTag, Items.DARK_OAK_DOOR, "vanilla_dark_oak_door_engraving");
            s.tagged( dark_oakTag, Items.DARK_OAK_TRAPDOOR, "vanilla_dark_oak_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_bamboo_door").get(), "dark_oak_bamboo_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_barn_door").get(), "dark_oak_barn_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_beach_door").get(), "dark_oak_beach_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_classic_door").get(), "dark_oak_classic_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_cottage_door").get(), "dark_oak_cottage_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_glass_door").get(), "dark_oak_glass_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_japanese_door").get(), "dark_oak_japanese_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_modern_door").get(), "dark_oak_modern_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_mystic_door").get(), "dark_oak_mystic_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_nether_door").get(), "dark_oak_nether_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_paper_door").get(), "dark_oak_paper_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_stable_door").get(), "dark_oak_stable_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_swamp_door").get(), "dark_oak_swamp_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_tropical_door").get(), "dark_oak_tropical_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_waffle_door").get(), "dark_oak_waffle_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_whispering_door").get(), "dark_oak_whispering_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("japanese_dark_oak_door").get(), "japanese_dark_oak_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_barn_glass_door").get(), "dark_oak_barn_glass_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.EXTRA_DOORS.get("dark_oak_stable_head_door").get(), "dark_oak_stable_head_door_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_bamboo_trapdoor").get(), "dark_oak_bamboo_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_barn_trapdoor").get(), "dark_oak_barn_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_barred_trapdoor").get(), "dark_oak_barred_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_beach_trapdoor").get(), "dark_oak_beach_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_blossom_trapdoor").get(), "dark_oak_blossom_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_classic_trapdoor").get(), "dark_oak_classic_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_cottage_trapdoor").get(), "dark_oak_cottage_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_glass_trapdoor").get(), "dark_oak_glass_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_mystic_trapdoor").get(), "dark_oak_mystic_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_paper_trapdoor").get(), "dark_oak_paper_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_swamp_trapdoor").get(), "dark_oak_swamp_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_tropical_trapdoor").get(), "dark_oak_tropical_trapdoor_engraving");
            s.tagged( dark_oakTag, OttBlocks.WOOD_TRAPDOORS.get("dark_oak_whispering_trapdoor").get(), "dark_oak_whispering_trapdoor_engraving");

            // mangrove
            TagKey<Item> mangroveTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/mangrove"));
            s.tagged( mangroveTag, Items.MANGROVE_DOOR, "vanilla_mangrove_door_engraving");
            s.tagged( mangroveTag, Items.MANGROVE_TRAPDOOR, "vanilla_mangrove_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("japanese_mangrove_door").get(), "japanese_mangrove_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_bamboo_door").get(), "mangrove_bamboo_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_barn_door").get(), "mangrove_barn_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_beach_door").get(), "mangrove_beach_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_classic_door").get(), "mangrove_classic_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_cottage_door").get(), "mangrove_cottage_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_four_panel_door").get(), "mangrove_four_panel_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_glass_door").get(), "mangrove_glass_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_japanese_door").get(), "mangrove_japanese_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_modern_door").get(), "mangrove_modern_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_mystic_door").get(), "mangrove_mystic_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_nether_door").get(), "mangrove_nether_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_paper_door").get(), "mangrove_paper_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_stable_door").get(), "mangrove_stable_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_tropical_door").get(), "mangrove_tropical_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_waffle_door").get(), "mangrove_waffle_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_whispering_door").get(), "mangrove_whispering_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_barn_glass_door").get(), "mangrove_barn_glass_door_engraving");
            s.tagged( mangroveTag, OttBlocks.EXTRA_DOORS.get("mangrove_stable_head_door").get(), "mangrove_stable_head_door_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_bamboo_trapdoor").get(), "mangrove_bamboo_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_barn_trapdoor").get(), "mangrove_barn_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_barred_trapdoor").get(), "mangrove_barred_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_beach_trapdoor").get(), "mangrove_beach_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_blossom_trapdoor").get(), "mangrove_blossom_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_classic_trapdoor").get(), "mangrove_classic_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_cottage_trapdoor").get(), "mangrove_cottage_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_four_panel_trapdoor").get(), "mangrove_four_panel_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_glass_trapdoor").get(), "mangrove_glass_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_mystic_trapdoor").get(), "mangrove_mystic_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_paper_trapdoor").get(), "mangrove_paper_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_tropical_trapdoor").get(), "mangrove_tropical_trapdoor_engraving");
            s.tagged( mangroveTag, OttBlocks.WOOD_TRAPDOORS.get("mangrove_whispering_trapdoor").get(), "mangrove_whispering_trapdoor_engraving");

            // cherry
            TagKey<Item> cherryTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/cherry"));
            s.tagged( cherryTag, Items.CHERRY_DOOR, "vanilla_cherry_door_engraving");
            s.tagged( cherryTag, Items.CHERRY_TRAPDOOR, "vanilla_cherry_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_bamboo_door").get(), "cherry_bamboo_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_barn_door").get(), "cherry_barn_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_beach_door").get(), "cherry_beach_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_classic_door").get(), "cherry_classic_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_cottage_door").get(), "cherry_cottage_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_four_panel_door").get(), "cherry_four_panel_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_glass_door").get(), "cherry_glass_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_japanese_door").get(), "cherry_japanese_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_modern_door").get(), "cherry_modern_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_mystic_door").get(), "cherry_mystic_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_nether_door").get(), "cherry_nether_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_paper_door").get(), "cherry_paper_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_stable_door").get(), "cherry_stable_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_swamp_door").get(), "cherry_swamp_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_tropical_door").get(), "cherry_tropical_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_whispering_door").get(), "cherry_whispering_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("japanese_cherry_door").get(), "japanese_cherry_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_barn_glass_door").get(), "cherry_barn_glass_door_engraving");
            s.tagged( cherryTag, OttBlocks.EXTRA_DOORS.get("cherry_stable_head_door").get(), "cherry_stable_head_door_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_bamboo_trapdoor").get(), "cherry_bamboo_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_barn_trapdoor").get(), "cherry_barn_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_barred_trapdoor").get(), "cherry_barred_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_barrel_trapdoor").get(), "cherry_barrel_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_beach_trapdoor").get(), "cherry_beach_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_classic_trapdoor").get(), "cherry_classic_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_cottage_trapdoor").get(), "cherry_cottage_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_four_panel_trapdoor").get(), "cherry_four_panel_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_glass_trapdoor").get(), "cherry_glass_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_mystic_trapdoor").get(), "cherry_mystic_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_paper_trapdoor").get(), "cherry_paper_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_swamp_trapdoor").get(), "cherry_swamp_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_tropical_trapdoor").get(), "cherry_tropical_trapdoor_engraving");
            s.tagged( cherryTag, OttBlocks.WOOD_TRAPDOORS.get("cherry_whispering_trapdoor").get(), "cherry_whispering_trapdoor_engraving");

            // bamboo
            TagKey<Item> bambooTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/bamboo"));
            s.tagged( bambooTag, Items.BAMBOO_DOOR, "vanilla_bamboo_door_engraving");
            s.tagged( bambooTag, Items.BAMBOO_TRAPDOOR, "vanilla_bamboo_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_barn_door").get(), "bamboo_barn_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_beach_door").get(), "bamboo_beach_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_classic_door").get(), "bamboo_classic_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_cottage_door").get(), "bamboo_cottage_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_four_panel_door").get(), "bamboo_four_panel_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_glass_door").get(), "bamboo_glass_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_japanese_door").get(), "bamboo_japanese_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_modern_door").get(), "bamboo_modern_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_mystic_door").get(), "bamboo_mystic_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_nether_door").get(), "bamboo_nether_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_paper_door").get(), "bamboo_paper_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_stable_door").get(), "bamboo_stable_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_swamp_door").get(), "bamboo_swamp_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_tropical_door").get(), "bamboo_tropical_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_waffle_door").get(), "bamboo_waffle_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_whispering_door").get(), "bamboo_whispering_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("japanese_bamboo_door").get(), "japanese_bamboo_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_barn_glass_door").get(), "bamboo_barn_glass_door_engraving");
            s.tagged( bambooTag, OttBlocks.EXTRA_DOORS.get("bamboo_stable_head_door").get(), "bamboo_stable_head_door_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_barn_trapdoor").get(), "bamboo_barn_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_barred_trapdoor").get(), "bamboo_barred_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_barrel_trapdoor").get(), "bamboo_barrel_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_beach_trapdoor").get(), "bamboo_beach_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_blossom_trapdoor").get(), "bamboo_blossom_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_classic_trapdoor").get(), "bamboo_classic_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_cottage_trapdoor").get(), "bamboo_cottage_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_four_panel_trapdoor").get(), "bamboo_four_panel_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_glass_trapdoor").get(), "bamboo_glass_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_mystic_trapdoor").get(), "bamboo_mystic_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_paper_trapdoor").get(), "bamboo_paper_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_swamp_trapdoor").get(), "bamboo_swamp_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_tropical_trapdoor").get(), "bamboo_tropical_trapdoor_engraving");
            s.tagged( bambooTag, OttBlocks.WOOD_TRAPDOORS.get("bamboo_whispering_trapdoor").get(), "bamboo_whispering_trapdoor_engraving");

            // crimson
            TagKey<Item> crimsonTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/crimson"));
            s.tagged( crimsonTag, Items.CRIMSON_DOOR, "vanilla_crimson_door_engraving");
            s.tagged( crimsonTag, Items.CRIMSON_TRAPDOOR, "vanilla_crimson_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_bamboo_door").get(), "crimson_bamboo_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_barn_door").get(), "crimson_barn_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_beach_door").get(), "crimson_beach_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_classic_door").get(), "crimson_classic_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_cottage_door").get(), "crimson_cottage_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_four_panel_door").get(), "crimson_four_panel_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_glass_door").get(), "crimson_glass_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_japanese_door").get(), "crimson_japanese_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_modern_door").get(), "crimson_modern_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_mystic_door").get(), "crimson_mystic_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_paper_door").get(), "crimson_paper_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_stable_door").get(), "crimson_stable_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_swamp_door").get(), "crimson_swamp_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_tropical_door").get(), "crimson_tropical_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_waffle_door").get(), "crimson_waffle_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_whispering_door").get(), "crimson_whispering_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("japanese_crimson_door").get(), "japanese_crimson_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_barn_glass_door").get(), "crimson_barn_glass_door_engraving");
            s.tagged( crimsonTag, OttBlocks.EXTRA_DOORS.get("crimson_stable_head_door").get(), "crimson_stable_head_door_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_bamboo_trapdoor").get(), "crimson_bamboo_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_barn_trapdoor").get(), "crimson_barn_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_beach_trapdoor").get(), "crimson_beach_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_blossom_trapdoor").get(), "crimson_blossom_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_classic_trapdoor").get(), "crimson_classic_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_cottage_trapdoor").get(), "crimson_cottage_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_four_panel_trapdoor").get(), "crimson_four_panel_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_glass_trapdoor").get(), "crimson_glass_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_mystic_trapdoor").get(), "crimson_mystic_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_paper_trapdoor").get(), "crimson_paper_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_swamp_trapdoor").get(), "crimson_swamp_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_tropical_trapdoor").get(), "crimson_tropical_trapdoor_engraving");
            s.tagged( crimsonTag, OttBlocks.WOOD_TRAPDOORS.get("crimson_whispering_trapdoor").get(), "crimson_whispering_trapdoor_engraving");

            // warped
            TagKey<Item> warpedTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/warped"));
            s.tagged( warpedTag, Items.WARPED_DOOR, "vanilla_warped_door_engraving");
            s.tagged( warpedTag, Items.WARPED_TRAPDOOR, "vanilla_warped_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("japanese_warped_door").get(), "japanese_warped_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_bamboo_door").get(), "warped_bamboo_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_barn_door").get(), "warped_barn_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_beach_door").get(), "warped_beach_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_classic_door").get(), "warped_classic_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_cottage_door").get(), "warped_cottage_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_four_panel_door").get(), "warped_four_panel_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_glass_door").get(), "warped_glass_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_japanese_door").get(), "warped_japanese_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_modern_door").get(), "warped_modern_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_nether_door").get(), "warped_nether_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_paper_door").get(), "warped_paper_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_stable_door").get(), "warped_stable_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_swamp_door").get(), "warped_swamp_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_tropical_door").get(), "warped_tropical_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_waffle_door").get(), "warped_waffle_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_whispering_door").get(), "warped_whispering_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_barn_glass_door").get(), "warped_barn_glass_door_engraving");
            s.tagged( warpedTag, OttBlocks.EXTRA_DOORS.get("warped_stable_head_door").get(), "warped_stable_head_door_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_bamboo_trapdoor").get(), "warped_bamboo_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_barn_trapdoor").get(), "warped_barn_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_barred_trapdoor").get(), "warped_barred_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_barrel_trapdoor").get(), "warped_barrel_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_beach_trapdoor").get(), "warped_beach_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_blossom_trapdoor").get(), "warped_blossom_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_classic_trapdoor").get(), "warped_classic_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_cottage_trapdoor").get(), "warped_cottage_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_four_panel_trapdoor").get(), "warped_four_panel_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_glass_trapdoor").get(), "warped_glass_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_paper_trapdoor").get(), "warped_paper_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_swamp_trapdoor").get(), "warped_swamp_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_tropical_trapdoor").get(), "warped_tropical_trapdoor_engraving");
            s.tagged( warpedTag, OttBlocks.WOOD_TRAPDOORS.get("warped_whispering_trapdoor").get(), "warped_whispering_trapdoor_engraving");

            // pale_oak
            TagKey<Item> pale_oakTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/pale_oak"));
            s.tagged( pale_oakTag, ModBlocks.PALE_OAK_DOOR.asItem(), "vanilla_pale_oak_door_engraving");
            s.tagged( pale_oakTag, ModBlocks.PALE_OAK_TRAPDOOR.asItem(), "vanilla_pale_oak_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("japanese_pale_oak_door").get(), "japanese_pale_oak_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_bamboo_door").get(), "pale_oak_bamboo_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_barn_door").get(), "pale_oak_barn_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_beach_door").get(), "pale_oak_beach_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_classic_door").get(), "pale_oak_classic_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_cottage_door").get(), "pale_oak_cottage_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_four_panel_door").get(), "pale_oak_four_panel_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_glass_door").get(), "pale_oak_glass_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_japanese_door").get(), "pale_oak_japanese_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_modern_door").get(), "pale_oak_modern_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_mystic_door").get(), "pale_oak_mystic_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_nether_door").get(), "pale_oak_nether_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_paper_door").get(), "pale_oak_paper_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_stable_door").get(), "pale_oak_stable_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_swamp_door").get(), "pale_oak_swamp_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_tropical_door").get(), "pale_oak_tropical_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_waffle_door").get(), "pale_oak_waffle_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_barn_glass_door").get(), "pale_oak_barn_glass_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.EXTRA_DOORS.get("pale_oak_stable_head_door").get(), "pale_oak_stable_head_door_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_bamboo_trapdoor").get(), "pale_oak_bamboo_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_barn_trapdoor").get(), "pale_oak_barn_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_barred_trapdoor").get(), "pale_oak_barred_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_beach_trapdoor").get(), "pale_oak_beach_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_blossom_trapdoor").get(), "pale_oak_blossom_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_classic_trapdoor").get(), "pale_oak_classic_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_cottage_trapdoor").get(), "pale_oak_cottage_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_four_panel_trapdoor").get(), "pale_oak_four_panel_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_glass_trapdoor").get(), "pale_oak_glass_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_mystic_trapdoor").get(), "pale_oak_mystic_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_paper_trapdoor").get(), "pale_oak_paper_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_swamp_trapdoor").get(), "pale_oak_swamp_trapdoor_engraving");
            s.tagged( pale_oakTag, OttBlocks.WOOD_TRAPDOORS.get("pale_oak_tropical_trapdoor").get(), "pale_oak_tropical_trapdoor_engraving");
        }

        s.tagged( ModTags.ItemTags.BOOKSHELVES, net.minecraft.world.item.Items.BOOKSHELF, "bookshelf_engraving");

        ModBlocks.BOOKSHELVES.forEach((name, block) ->
                s.tagged( ModTags.ItemTags.BOOKSHELVES, block, name + "_engraving"));

        String[] leafVariants = {"apple", "cherry", "dead", "frosted", "golden", "golden_apple",
                "golden_cherry", "magenta_flower", "orange", "red", "white_flower"};

        String[] leafWoods = {"acacia", "birch", "dark_oak", "jungle", "oak", "spruce", "pale_oak"};

        for (String wood : leafWoods) {
            for (String var : leafVariants) {
                String name = var + "_" + wood + "_leaves";
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", name));
                if (b != Blocks.AIR) s.tagged(materialTag(wood + "_leaves"), b, name + "_engraving");
            }
        }

    }

    private static void enumerateGlass(Sink s) {
        // OTT block name → recipe ID (replaces the removed per-color individual recipes)
        String[][] blockTemplates = {
            {"arched_{c}_stained_glass_ctm",         "arched_{c}_stained_glass_pillar_engraving"},
            {"circular_{c}_stained_glass",            "circular_{c}_stained_glass_engraving"},
            {"fancy_{c}_stained_glass_ctm",           "fancy_{c}_stained_glass_pillar_engraving"},
            {"ornate_{c}_stained_glass_ctm",          "ornate_{c}_stained_glass_pillar_engraving"},
            {"raster_{c}_stained_glass_ctm",          "raster_{c}_stained_glass_pillar_engraving"},
            {"small_{c}_diamond_stained_glass_ctm",       "small_{c}_diamond_stained_glass_ctm_engraving"},
            {"tiled_{c}_stained_glass_ctm",           "tiled_{c}_stained_glass_pillar_engraving"},
            {"{c}_leaded_stained_glass",              "{c}_leaded_stained_glass_engraving"},
            {"fancy_{c}_stained_glass",               "fancy_{c}_stained_glass_engraving"},
            {"large_diamond_{c}_stained_glass",       "large_diamond_{c}_stained_glass_engraving"},
            {"ornate_{c}_stained_glass",              "ornate_{c}_stained_glass_engraving"},
            {"raster_{c}_stained_glass",              "raster_{c}_stained_glass_engraving"},
            {"small_{c}_diamond_stained_glass",               "small_{c}_diamond_stained_glass_engraving"},
            {"square_{c}_stained_glass",              "square_{c}_stained_glass_engraving"},
            {"tiled_{c}_stained_glass",               "tiled_{c}_stained_glass_engraving"},
            {"vertical_striped_{c}_stained_glass",    "vertical_striped_{c}_stained_glass_engraving"},
            {"woven_{c}_stained_glass",               "woven_{c}_stained_glass_engraving"},
        };
        // OTT CTM pane name → recipe ID (replaces removed section 3 of ctmPaneRecipes)
        String[][] paneTemplates = {
            {"arched_{c}_stained_glass_ctm_pane",               "arched_{c}_stained_glass_ctm_pane_engraving"},
            {"{c}_framed_glass_ctm_pane",                        "{c}_framed_glass_ctm_pane_engraving"},
            {"{c}_stained_glass_ctm_pane",                       "{c}_stained_glass_ctm_pane_engraving"},
            {"fancy_{c}_stained_glass_ctm_pane",                 "fancy_{c}_stained_glass_ctm_pane_engraving"},
            {"golden_framed_{c}_stained_glass_ctm_pane",         "golden_framed_{c}_stained_glass_ctm_pane_engraving"},
            {"ornate_{c}_stained_glass_ctm_pane",                "ornate_{c}_stained_glass_ctm_pane_engraving"},
            {"raster_{c}_stained_glass_ctm_pane",                "raster_{c}_stained_glass_ctm_pane_engraving"},
            {"scratched_glass_{c}_ctm_pane",                     "scratched_glass_{c}_ctm_pane_engraving"},
            {"small_{c}_diamond_stained_glass_ctm_pane",         "small_{c}_diamond_stained_glass_ctm_pane_engraving"},
            {"tiled_{c}_stained_glass_ctm_pane",                 "tiled_{c}_stained_glass_ctm_pane_engraving"},
            {"borderless_glass_{c}_ctm_pane",                    "borderless_glass_{c}_ctm_pane_engraving"},
            {"{c}_stained_clear_glass_ctm_pane",                 "{c}_stained_clear_glass_ctm_pane_engraving"},
        };

        for (DyeColor color : DyeColor.values()) {
            String c = color.getName();
            Block vanillaGlass = BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(c + "_stained_glass"));

            // Collect all group members
            java.util.List<Item> groupItems = new java.util.ArrayList<>();
            groupItems.add(vanillaGlass.asItem());

            for (String[] tpl : blockTemplates) {
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", tpl[0].replace("{c}", c)));
                if (b != Blocks.AIR) groupItems.add(b.asItem());
            }
            for (String[] tpl : paneTemplates) {
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", tpl[0].replace("{c}", c)));
                if (b != Blocks.AIR) groupItems.add(b.asItem());
            }

            Ingredient group = Ingredient.of(groupItems.toArray(new Item[0]));

            // Vanilla glass as output (new — allows any OTT variant → vanilla)
            s.group( group, vanillaGlass, c + "_stained_glass_from_group");

            // OTT blocks as outputs (same IDs as the removed individual recipes)
            for (String[] tpl : blockTemplates) {
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", tpl[0].replace("{c}", c)));
                if (b != Blocks.AIR) {
                    s.group( group, b, tpl[1].replace("{c}", c));
                }
            }
            // CTM panes as outputs (same IDs as the removed section 3 recipes)
            for (String[] tpl : paneTemplates) {
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", tpl[0].replace("{c}", c)));
                if (b != Blocks.AIR) {
                    s.group( group, b, tpl[1].replace("{c}", c));
                }
            }
        }
    }

    // ---- Creative-tab view: unique outputs in enumeration order (built lazily, runtime-safe) ----
    private static java.util.List<ItemLike> tabItems;

    /** Unique engraving outputs, first-seen order — drives the ENGRAVED creative tab. */
    public static synchronized java.util.List<ItemLike> tabItems() {
        if (tabItems == null) {
            java.util.LinkedHashMap<Item, ItemLike> byItem = new java.util.LinkedHashMap<>();
            // Only ott-namespace outputs belong in the OTT tab (engraving can also yield vanilla glass/doors).
            java.util.function.Consumer<ItemLike> add = o -> {
                if (BuiltInRegistries.ITEM.getKey(o.asItem()).getNamespace().equals("ott")) byItem.putIfAbsent(o.asItem(), o);
            };
            Sink collect = new Sink() {
                @Override public void one(ItemLike i, ItemLike o, String id)    { add.accept(o); }
                @Override public void tagged(TagKey<Item> t, ItemLike o, String id) { add.accept(o); }
                @Override public void group(Ingredient g, ItemLike o, String id)   { add.accept(o); }
            };
            enumerate(collect);
            tabItems = java.util.List.copyOf(byItem.values());
        }
        return tabItems;
    }
}