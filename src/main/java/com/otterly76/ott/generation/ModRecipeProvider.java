package com.otterly76.ott.generation;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import com.otterly76.ott.Constants;
import com.otterly76.ott.color.ModColorSets;
import com.otterly76.ott.block.IGradientBlock;
import com.otterly76.ott.block.ModBlocks;
import com.otterly76.ott_blocks.block.OttBlocks;
import com.otterly76.ott.item.ModItems;
import com.otterly76.ott.util.ModTags;
import com.otterly76.ott.recipe.BundleColoring;
import com.otterly76.ott.recipe.EngravingRecipe;
import com.otterly76.ott.recipe.WoodcuttingRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    private static Criterion<?> impossible() {
        return new Criterion<>(CriteriaTriggers.IMPOSSIBLE, new ImpossibleTrigger.TriggerInstance());
    }

    private record NoAdvancementOutput(RecipeOutput delegate) implements RecipeOutput {

        @Override
            public void accept(@NotNull ResourceLocation id, @NotNull Recipe<?> recipe, @Nullable AdvancementHolder advancement, ICondition @NotNull ... conditions) {
                delegate.accept(id, recipe, null, conditions);
            }

            @Override
            public Advancement.@NotNull Builder advancement() {
                return Advancement.Builder.recipeAdvancement();
            }
        }

    private ResourceLocation getRecipePath(String namespace, String recipeName) {
        return ResourceLocation.fromNamespaceAndPath(namespace, recipeName);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput exporter) {
        RecipeOutput noAdv = new NoAdvancementOutput(exporter);

        // Tiered shears — vanilla shears layout (two diagonal ingots)
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_SHEARS.get())
                .define('#', Items.GOLD_INGOT).pattern(" #").pattern("# ")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(noAdv, getRecipePath(Constants.MOD_ID, "golden_shears"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_SHEARS.get())
                .define('#', Items.DIAMOND).pattern(" #").pattern("# ")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(noAdv, getRecipePath(Constants.MOD_ID, "diamond_shears"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NETHERITE_SHEARS.get())
                .define('#', Items.NETHERITE_INGOT).pattern(" #").pattern("# ")
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(noAdv, getRecipePath(Constants.MOD_ID, "netherite_shears"));

        // Wood (backported pale oak + ott wood sets)
        this.woodRecipes(noAdv);

        // Copper (backported items and blocks)
        this.copperRecipes(noAdv);
        this.copperToolArmorRecipes(noAdv);

        // Shelves
        this.shelfRecipes(noAdv);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NAME_TAG)
                .define('P', Items.PAPER)
                .define('S', Items.STRING)
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(noAdv, getRecipePath(Constants.MOD_ID, "nametag"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOODCUTTER.get())
                .define('L', net.minecraft.tags.ItemTags.LOGS)
                .define('I', Items.IRON_INGOT)
                .pattern("   ")
                .pattern(" I ")
                .pattern("LLL")
                .unlockedBy("has_logs", has(net.minecraft.tags.ItemTags.LOGS))
                .save(noAdv, getRecipePath(Constants.MOD_ID, "woodcutter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENGRAVING_TABLE.get())
                .define('I', Items.IRON_INGOT)
                .define('S', Blocks.SMOOTH_STONE_SLAB)
                .define('C', Blocks.STONE)
                .pattern(" I ")
                .pattern("SSS")
                .pattern("C C")
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(noAdv, getRecipePath(Constants.MOD_ID, "engraving_table"));

        this.engraveRecipes(noAdv);
        this.ctmPaneRecipes(noAdv);
        this.recoveredWindowRecipes(noAdv);
        this.recoveredWaveRecipes(noAdv);
        this.stainedGlassGroupRecipes(noAdv);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GLASS_JAR.get())
                .define('G', Items.GLASS_PANE)
                .pattern("G G")
                .pattern("G G")
                .pattern("GGG")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath(Constants.MOD_ID, "glass_jar"));

        // Ott Critters
        this.ottCrittersRecipes(noAdv);

        // Custom Dyes
        this.addCustomDyeRecipes(noAdv);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GRAY_DYE)
                .requires(ModBlocks.CLOSED_EYEBLOSSOM.get())
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "gray_dye_from_closed_eyeblossom"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE)
                .requires(ModBlocks.OPEN_EYEBLOSSOM.get())
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "orange_dye_from_open_eyeblossom"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.BEEHIVE)
                .define('P', Items.OAK_PLANKS)
                .define('H', Items.HONEYCOMB)
                .pattern("PPP")
                .pattern("HHH")
                .pattern("PPP")
                .unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                .save(noAdv, getRecipePath("minecraft", "beehive"));

        // Custom wood beehive recipes
        java.util.Map<String, net.minecraft.world.item.Item> beehivePlanks = java.util.Map.ofEntries(
                java.util.Map.entry("acacia",   Items.ACACIA_PLANKS),
                java.util.Map.entry("bamboo",   Items.BAMBOO_PLANKS),
                java.util.Map.entry("birch",    Items.BIRCH_PLANKS),
                java.util.Map.entry("cherry",   Items.CHERRY_PLANKS),
                java.util.Map.entry("crimson",  Items.CRIMSON_PLANKS),
                java.util.Map.entry("dark_oak", Items.DARK_OAK_PLANKS),
                java.util.Map.entry("jungle",   Items.JUNGLE_PLANKS),
                java.util.Map.entry("mangrove", Items.MANGROVE_PLANKS),
                java.util.Map.entry("pale_oak", ModBlocks.PALE_OAK_PLANKS.get().asItem()),
                java.util.Map.entry("spruce",   Items.SPRUCE_PLANKS),
                java.util.Map.entry("warped",   Items.WARPED_PLANKS)
        );
        java.util.Map<String, net.minecraft.world.level.block.Block> beehiveBlocks = java.util.Map.ofEntries(
                java.util.Map.entry("acacia",   ModBlocks.ACACIA_BEEHIVE.get()),
                java.util.Map.entry("bamboo",   ModBlocks.BAMBOO_BEEHIVE.get()),
                java.util.Map.entry("birch",    ModBlocks.BIRCH_BEEHIVE.get()),
                java.util.Map.entry("cherry",   ModBlocks.CHERRY_BEEHIVE.get()),
                java.util.Map.entry("crimson",  ModBlocks.CRIMSON_BEEHIVE.get()),
                java.util.Map.entry("dark_oak", ModBlocks.DARK_OAK_BEEHIVE.get()),
                java.util.Map.entry("jungle",   ModBlocks.JUNGLE_BEEHIVE.get()),
                java.util.Map.entry("mangrove", ModBlocks.MANGROVE_BEEHIVE.get()),
                java.util.Map.entry("pale_oak", ModBlocks.PALE_OAK_BEEHIVE.get()),
                java.util.Map.entry("spruce",   ModBlocks.SPRUCE_BEEHIVE.get()),
                java.util.Map.entry("warped",   ModBlocks.WARPED_BEEHIVE.get())
        );
        beehivePlanks.forEach((wood, planks) -> {
            net.minecraft.world.level.block.Block result = beehiveBlocks.get(wood);
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
                    .define('P', planks)
                    .define('H', Items.HONEYCOMB)
                    .pattern("PPP")
                    .pattern("HHH")
                    .pattern("PPP")
                    .unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                    .save(noAdv, getRecipePath("ott", wood + "_beehive"));
        });
        // OTT wood set beehives
        ModBlocks.WOOD_SETS.forEach((wood, set) ->
                ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, set.beehive().get())
                        .define('P', set.planks().get())
                        .define('H', Items.HONEYCOMB)
                        .pattern("PPP")
                        .pattern("HHH")
                        .pattern("PPP")
                        .unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                        .save(exporter, getRecipePath("ott", wood + "_beehive")));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CREAKING_HEART.get())
                .define('#', ModBlocks.PALE_OAK_LOG.get())
                .define('O', ModBlocks.RESIN_BLOCK.get())
                .pattern("#")
                .pattern("O")
                .pattern("#")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "creaking_heart"));

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.SOUL_GLASS.get(),
                        0.1F,
                        200
                )
                .unlockedBy("has_soul_sand", has(Items.SOUL_SAND))
                .save(exporter, getRecipePath("ott", "soul_glass_from_smelting"));

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.RESIN_CLUMP.get()),
                        RecipeCategory.MISC,
                        ModItems.RESIN_BRICK.get(),
                        0.1F,
                        200
                )
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BLOCK.get())
                .define('#', ModBlocks.RESIN_CLUMP.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICKS.get())
                .define('#', ModItems.RESIN_BRICK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_bricks"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_STAIRS.get(), 4)
                .define('#', ModBlocks.RESIN_BRICKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_SLAB.get(), 6)
                .define('#', ModBlocks.RESIN_BRICKS.get())
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_WALL.get(), 6)
                .define('#', ModBlocks.RESIN_BRICKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick_wall"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_RESIN_BRICKS.get())
                .define('#', ModBlocks.RESIN_BRICK_SLAB.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "chiseled_resin_bricks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RESIN_CLUMP.get(), 9)
                .requires(ModBlocks.RESIN_BLOCK.get())
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_clump_from_resin_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PALE_MOSS_CARPET.get(), 3)
                .define('#', ModBlocks.PALE_MOSS_BLOCK.get())
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_moss_carpet"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(ModBlocks.RESIN_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.RESIN_BRICK_SLAB.get(),
                        2
                )
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick_slab_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(ModBlocks.RESIN_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.RESIN_BRICK_WALL.get()
                )
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick_wall_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(ModBlocks.RESIN_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.RESIN_BRICK_STAIRS.get()
                )
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "resin_brick_stairs_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(ModBlocks.RESIN_BRICKS.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.CHISELED_RESIN_BRICKS.get()
                )
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "chiseled_resin_bricks_from_stonecutting"));

        ModBlocks.ALL_GRADIENT_BLOCKS.forEach(deferredBlock -> createGradientRecipe(noAdv, deferredBlock.get()));

        SpecialRecipeBuilder.special(BundleColoring::new)
                .save(noAdv, getRecipePath("minecraft", "bundle_coloring"));

        // Tiny Coal and Charcoal
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TINY_COAL.get(), 9)
                .requires(Items.COAL)
                .unlockedBy("has_coal", has(Items.COAL))
                .save(noAdv);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL)
                .define('#', ModItems.TINY_COAL.get())
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_tiny_coal", has(ModItems.TINY_COAL.get()))
                .save(noAdv, getRecipePath("ott", "coal_from_tiny_coal"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TINY_CHARCOAL.get(), 9)
                .requires(Items.CHARCOAL)
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .save(noAdv);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHARCOAL)
                .define('#', ModItems.TINY_CHARCOAL.get())
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_tiny_charcoal", has(ModItems.TINY_CHARCOAL.get()))
                .save(noAdv, getRecipePath("ott", "charcoal_from_tiny_charcoal"));

        // Water Lantern
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WATER_LANTERN.get())
                .define('#', Items.IRON_INGOT)
                .define('G', Items.GLASS)
                .define('B', Items.WATER_BUCKET)
                .pattern("###")
                .pattern("GBG")
                .pattern("###")
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .save(noAdv);

        // Lava Lantern
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.LAVA_LANTERN.get())
                .define('#', Items.IRON_INGOT)
                .define('G', Items.GLASS)
                .define('B', Items.LAVA_BUCKET)
                .pattern("###")
                .pattern("GBG")
                .pattern("###")
                .unlockedBy("has_lava_bucket", has(Items.LAVA_BUCKET))
                .save(noAdv);

        // Protective Lantern
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PROTECTIVE_LANTERN.get())
                .define('#', Items.GOLD_INGOT)
                .define('G', Items.GLASS)
                .define('B', Items.FIRE_CHARGE)
                .pattern("###")
                .pattern("GBG")
                .pattern("###")
                .unlockedBy("has_fire_charge", has(Items.FIRE_CHARGE))
                .save(noAdv);

        // Smite Lantern
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SMITE_LANTERN.get())
                .define('#', Items.GOLD_INGOT)
                .define('G', Items.GLASS)
                .define('B', Items.MAGMA_CREAM)
                .pattern("###")
                .pattern("GBG")
                .pattern("###")
                .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
                .save(noAdv);

        this.addDyeingRecipes(noAdv);
        this.addPatternBlockRecipes(noAdv);
        this.addElevatorRecipes(noAdv);
        this.addSlabToBlockRecipes(noAdv);
        this.addMiscRecipes(noAdv);
        this.addSeaglassRecipes(noAdv);
        this.addBuildingMaterialRecipes(noAdv);
        this.addStonecutterRecipes(noAdv);

        this.mountsOfMayhemRecipes(noAdv);
    }

    private void addCustomDyeRecipes(RecipeOutput exporter) {
        List<Item> vanillaDyes = List.of(
                Items.WHITE_DYE, Items.PINK_DYE, Items.MAGENTA_DYE, Items.PURPLE_DYE,
                Items.BLUE_DYE, Items.LIGHT_BLUE_DYE, Items.CYAN_DYE, Items.GREEN_DYE,
                Items.LIME_DYE, Items.YELLOW_DYE, Items.ORANGE_DYE, Items.RED_DYE,
                Items.BROWN_DYE, Items.BLACK_DYE, Items.GRAY_DYE, Items.LIGHT_GRAY_DYE
        );

        for (int i = 0; i < ModColorSets.ALL.size(); i++) {
            ModColorSets.ColorSet colorSet = ModColorSets.ALL.get(i);
            if (colorSet.name().equals("navy")) continue; // has its own recipe below
            Item result = ModItems.CUSTOM_DYES.get(colorSet.name()).get();
            Item ingredient1 = vanillaDyes.get(i % vanillaDyes.size());
            Item ingredient2 = vanillaDyes.get((i + 1) % vanillaDyes.size());

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 2)
                    .requires(ingredient1)
                    .requires(ingredient2)
                    .unlockedBy("impossible", impossible())
                    .save(exporter, getRecipePath(Constants.MOD_ID, colorSet.name() + "_dye"));
        }

        // Navy dye: 1 blue dye + 1 charcoal dye → 2 navy dye
        if (ModItems.CUSTOM_DYES.containsKey("navy") && ModItems.CUSTOM_DYES.containsKey("charcoal")) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUSTOM_DYES.get("navy").get(), 2)
                    .requires(Items.BLUE_DYE)
                    .requires(ModItems.CUSTOM_DYES.get("charcoal").get())
                    .unlockedBy("impossible", impossible())
                    .save(exporter, getRecipePath(Constants.MOD_ID, "navy_dye"));
        }
    }


    private void addSeaglassRecipes(RecipeOutput exporter) {
        ModBlocks.SeaglassColorBlocks lightGray = ModBlocks.SEAGLASS_SETS.get("light_gray");

        // Smelting: dead coral blocks → light_gray seaglass variants
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DEAD_TUBE_CORAL_BLOCK), RecipeCategory.BUILDING_BLOCKS, lightGray.seaglass().get(), 0.1F, 200)
                .unlockedBy("has_dead_coral", has(Items.DEAD_TUBE_CORAL_BLOCK))
                .save(exporter, getRecipePath("ott", "light_gray_seaglass_from_smelting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DEAD_BRAIN_CORAL_BLOCK), RecipeCategory.BUILDING_BLOCKS, lightGray.bubblesSeaglass().get(), 0.1F, 200)
                .unlockedBy("has_dead_coral", has(Items.DEAD_BRAIN_CORAL_BLOCK))
                .save(exporter, getRecipePath("ott", "light_gray_bubbles_seaglass_from_smelting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DEAD_BUBBLE_CORAL_BLOCK), RecipeCategory.BUILDING_BLOCKS, lightGray.smoothSeaglass().get(), 0.1F, 200)
                .unlockedBy("has_dead_coral", has(Items.DEAD_BUBBLE_CORAL_BLOCK))
                .save(exporter, getRecipePath("ott", "light_gray_smooth_seaglass_from_smelting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DEAD_FIRE_CORAL_BLOCK), RecipeCategory.BUILDING_BLOCKS, lightGray.wavesSeaglass().get(), 0.1F, 200)
                .unlockedBy("has_dead_coral", has(Items.DEAD_FIRE_CORAL_BLOCK))
                .save(exporter, getRecipePath("ott", "light_gray_waves_seaglass_from_smelting"));

        // Dyeing: 8 light_gray seaglass + 1 dye → 8 colored seaglass
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            if (name.equals("light_gray")) continue;
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
            addSeaglassDyeRecipe(exporter, lightGray, ModBlocks.SEAGLASS_SETS.get(name), dye, name);
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            addSeaglassDyeRecipe(exporter, lightGray, ModBlocks.SEAGLASS_SETS.get(name), dye, name);
        }

        // Opal crystal set recipes
        addOpalSetRecipes(exporter, "white_opal", ModBlocks.OPAL_SETS.get("white_opal"), ModItems.WHITE_OPAL_CRYSTAL.get());
        addOpalSetRecipes(exporter, "black_opal", ModBlocks.OPAL_SETS.get("black_opal"), ModItems.BLACK_OPAL_CRYSTAL.get());
        addOpalSetRecipes(exporter, "fire_opal",  ModBlocks.OPAL_SETS.get("fire_opal"),  ModItems.FIRE_OPAL_CRYSTAL.get());
    }

    private void addSeaglassDyeRecipe(RecipeOutput exporter, ModBlocks.SeaglassColorBlocks source, ModBlocks.SeaglassColorBlocks target, Item dye, String colorName) {
        addSeaglassDyeVariant(exporter, source.seaglass().get(),        target.seaglass().get(),        dye, colorName + "_seaglass");
        addSeaglassDyeVariant(exporter, source.bubblesSeaglass().get(),  target.bubblesSeaglass().get(),  dye, colorName + "_bubbles_seaglass");
        addSeaglassDyeVariant(exporter, source.smoothSeaglass().get(),   target.smoothSeaglass().get(),   dye, colorName + "_smooth_seaglass");
        addSeaglassDyeVariant(exporter, source.wavesSeaglass().get(),    target.wavesSeaglass().get(),    dye, colorName + "_waves_seaglass");
    }

    private void addSeaglassDyeVariant(RecipeOutput exporter, Block source, Block result, Item dye, String recipeName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', source)
                .define('D', dye)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .unlockedBy("has_light_gray_seaglass", has(source))
                .save(exporter, getRecipePath("ott", recipeName + "_from_dyeing"));
    }

    private void addBuildingMaterialRecipes(RecipeOutput exporter) {
        // --- Unfired Clay Roof Tile: 8 clay balls + water bucket (ring) → 8 tiles ---
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNFIRED_CLAY_ROOF_TILE.get(), 8)
                .define('C', Items.CLAY_BALL)
                .define('W', Items.WATER_BUCKET)
                .pattern("CCC")
                .pattern("CWC")
                .pattern("CCC")
                .unlockedBy("has_clay", has(Items.CLAY_BALL))
                .save(exporter, getRecipePath("ott", "unfired_clay_roof_tile"));

        // --- Plaster Bucket: 8 bone meal + water bucket (ring) → 8 plaster buckets ---
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLASTER_BUCKET.get(), 8)
                .define('B', Items.BONE_MEAL)
                .define('W', Items.WATER_BUCKET)
                .pattern("BBB")
                .pattern("BWB")
                .pattern("BBB")
                .unlockedBy("has_bone_meal", has(Items.BONE_MEAL))
                .save(exporter, getRecipePath("ott", "plaster_bucket"));

        // --- Clay tile smelting: unfired → light_gray_clay_tile ---
        Item lightGrayClay = ModItems.CLAY_TILES.get("light_gray").get();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.UNFIRED_CLAY_ROOF_TILE.get()),
                        RecipeCategory.MISC, lightGrayClay, 0.1F, 200)
                .unlockedBy("has_unfired_clay_roof_tile", has(ModItems.UNFIRED_CLAY_ROOF_TILE.get()))
                .save(exporter, getRecipePath("ott", "light_gray_clay_tile_from_smelting"));

        // --- Clay tile dyeing: 8 light_gray + dye → 8 colored (all 32 colors, skip light_gray) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            if (name.equals("light_gray")) continue;
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
            addRingDyeRecipe(exporter, lightGrayClay, ModItems.CLAY_TILES.get(name).get(), dye, name + "_clay_tile");
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            addRingDyeRecipe(exporter, lightGrayClay, ModItems.CLAY_TILES.get(name).get(), dye, name + "_clay_tile");
        }

        // --- Flat roof tiles: 8 {color}_clay_tile (ring) → 8 {color}_flat_roof_tiles (same color) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Item clay = ModItems.CLAY_TILES.get(name).get();
            Block roof = ModBlocks.PATTERN_BLOCKS.get("flat_roof_tiles").get(name).get();
            addRingShapeRecipe(exporter, clay, roof, 8, name + "_flat_roof_tiles_from_clay");
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item clay = ModItems.CLAY_TILES.get(name).get();
            Block roof = ModBlocks.PATTERN_BLOCKS.get("flat_roof_tiles").get(name).get();
            addRingShapeRecipe(exporter, clay, roof, 8, name + "_flat_roof_tiles_from_clay");
        }

        // --- Layered roof tiles: 6 {color} clay tiles (2 rows) → 6 {color} layered roof tiles (all 32 colors) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Item clay = ModItems.CLAY_TILES.get(name).get();
            Block layered = ModBlocks.PATTERN_BLOCKS.get("layered_roof_tiles").get(name).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, layered, 6)
                    .define('C', clay)
                    .pattern("CCC")
                    .pattern("CCC")
                    .unlockedBy("has_clay_tile", has(clay))
                    .save(exporter, getRecipePath("ott", name + "_layered_roof_tiles"));
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item clay = ModItems.CLAY_TILES.get(name).get();
            Block layered = ModBlocks.PATTERN_BLOCKS.get("layered_roof_tiles").get(name).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, layered, 6)
                    .define('C', clay)
                    .pattern("CCC")
                    .pattern("CCC")
                    .unlockedBy("has_clay_tile", has(clay))
                    .save(exporter, getRecipePath("ott", name + "_layered_roof_tiles"));
        }

        // --- Plastered stone: 8 stone (ring) + plaster_bucket → 8 light_gray_plastered_stone ---
        Block lightGrayPlastered = ModBlocks.PATTERN_BLOCKS.get("plastered_stone").get("light_gray").get();
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, lightGrayPlastered, 8)
                .define('S', Items.STONE)
                .define('P', ModItems.PLASTER_BUCKET.get())
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .unlockedBy("has_plaster", has(ModItems.PLASTER_BUCKET.get()))
                .save(exporter, getRecipePath("ott", "light_gray_plastered_stone"));

        // --- Plastered stone dyeing: 8 light_gray + dye → 8 colored (all 32 colors, skip light_gray) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            if (name.equals("light_gray")) continue;
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
            addRingDyeRecipe(exporter, lightGrayPlastered, ModBlocks.PATTERN_BLOCKS.get("plastered_stone").get(name).get(), dye, name + "_plastered_stone");
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            addRingDyeRecipe(exporter, lightGrayPlastered, ModBlocks.PATTERN_BLOCKS.get("plastered_stone").get(name).get(), dye, name + "_plastered_stone");
        }

        // --- Chiseled plastered stone variants: white + dye → colored (1:1 and 8:8, skip white) ---
        for (String pattern : List.of(
                "chiseled_plastered_stone",
                "gilded_plastered_stone",
                "delicate_plastered_stone",
                "banded_plastered_stone")) {
            Block whiteBase = ModBlocks.PATTERN_BLOCKS.get(pattern).get("white").get();
            for (DyeColor color : DyeColor.values()) {
                String name = color.getName();
                if (name.equals("white")) continue;
                Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
                Block result = ModBlocks.PATTERN_BLOCKS.get(pattern).get(name).get();
                addRingDyeRecipe(exporter, whiteBase, result, dye, name + "_" + pattern);
                addSingleDyeRecipe(exporter, whiteBase, result, dye, name + "_" + pattern);
            }
            for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
                String name = colorSet.name();
                Item dye = ModItems.CUSTOM_DYES.get(name).get();
                Block result = ModBlocks.PATTERN_BLOCKS.get(pattern).get(name).get();
                addRingDyeRecipe(exporter, whiteBase, result, dye, name + "_" + pattern);
                addSingleDyeRecipe(exporter, whiteBase, result, dye, name + "_" + pattern);
            }
        }

        // --- Wheat thatch: 6 wheat (2 rows) → 1 wheat_thatch ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHEAT_THATCH.get())
                .define('W', Items.WHEAT)
                .pattern("WWW")
                .pattern("WWW")
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(exporter, getRecipePath("ott", "wheat_thatch"));

        // --- Bamboo thatch: 6 bamboo (2 rows) → 1 bamboo_thatch ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_THATCH.get())
                .define('B', Items.BAMBOO)
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy("has_bamboo", has(Items.BAMBOO))
                .save(exporter, getRecipePath("ott", "bamboo_thatch"));

        // --- Cobbled limestone smelting → limestone ---
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.COBBLED_LIMESTONE.get()),
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLAIN_LIMESTONE.get(), 0.1F, 200)
                .unlockedBy("has_cobbled_limestone", has(ModBlocks.COBBLED_LIMESTONE.get()))
                .save(exporter, getRecipePath("ott", "limestone_from_cobbled_limestone_smelting"));

        // --- Ornamented red wool: red_wool center + 4 gold nuggets at corners → 8 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORNAMENTED_RED_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.RED_WOOL)
                .pattern("N N")
                .pattern("NRN")
                .pattern("N N")
                .unlockedBy("has_red_wool", has(Items.RED_WOOL))
                .save(exporter, getRecipePath("ott", "ornamented_red_wool"));

        // --- Delicate red wool: red_wool center + 4 gold nuggets in + shape → 8 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DELICATE_RED_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.RED_WOOL)
                .pattern(" N ")
                .pattern("NRN")
                .pattern(" N ")
                .unlockedBy("has_red_wool", has(Items.RED_WOOL))
                .save(exporter, getRecipePath("ott", "delicate_red_wool"));

        // --- Ornamented / Delicate red carpet: 2 wool → 3 carpet ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ORNAMENTED_RED_CARPET.get(), 3)
                .define('W', ModBlocks.ORNAMENTED_RED_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_ornamented_red_wool", has(ModBlocks.ORNAMENTED_RED_WOOL.get()))
                .save(exporter, getRecipePath("ott", "ornamented_red_carpet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DELICATE_RED_CARPET.get(), 3)
                .define('W', ModBlocks.DELICATE_RED_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_delicate_red_wool", has(ModBlocks.DELICATE_RED_WOOL.get()))
                .save(exporter, getRecipePath("ott", "delicate_red_carpet"));

        // --- Ornamented blue wool ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORNAMENTED_BLUE_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.BLUE_WOOL)
                .pattern("N N")
                .pattern("NRN")
                .pattern("N N")
                .unlockedBy("has_blue_wool", has(Items.BLUE_WOOL))
                .save(exporter, getRecipePath("ott", "ornamented_blue_wool"));

        // --- Delicate blue wool ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DELICATE_BLUE_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.BLUE_WOOL)
                .pattern(" N ")
                .pattern("NRN")
                .pattern(" N ")
                .unlockedBy("has_blue_wool", has(Items.BLUE_WOOL))
                .save(exporter, getRecipePath("ott", "delicate_blue_wool"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ORNAMENTED_BLUE_CARPET.get(), 3)
                .define('W', ModBlocks.ORNAMENTED_BLUE_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_ornamented_blue_wool", has(ModBlocks.ORNAMENTED_BLUE_WOOL.get()))
                .save(exporter, getRecipePath("ott", "ornamented_blue_carpet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DELICATE_BLUE_CARPET.get(), 3)
                .define('W', ModBlocks.DELICATE_BLUE_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_delicate_blue_wool", has(ModBlocks.DELICATE_BLUE_WOOL.get()))
                .save(exporter, getRecipePath("ott", "delicate_blue_carpet"));

        // --- Ornamented green wool ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORNAMENTED_GREEN_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.GREEN_WOOL)
                .pattern("N N")
                .pattern("NRN")
                .pattern("N N")
                .unlockedBy("has_green_wool", has(Items.GREEN_WOOL))
                .save(exporter, getRecipePath("ott", "ornamented_green_wool"));

        // --- Delicate green wool ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DELICATE_GREEN_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.GREEN_WOOL)
                .pattern(" N ")
                .pattern("NRN")
                .pattern(" N ")
                .unlockedBy("has_green_wool", has(Items.GREEN_WOOL))
                .save(exporter, getRecipePath("ott", "delicate_green_wool"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ORNAMENTED_GREEN_CARPET.get(), 3)
                .define('W', ModBlocks.ORNAMENTED_GREEN_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_ornamented_green_wool", has(ModBlocks.ORNAMENTED_GREEN_WOOL.get()))
                .save(exporter, getRecipePath("ott", "ornamented_green_carpet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DELICATE_GREEN_CARPET.get(), 3)
                .define('W', ModBlocks.DELICATE_GREEN_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_delicate_green_wool", has(ModBlocks.DELICATE_GREEN_WOOL.get()))
                .save(exporter, getRecipePath("ott", "delicate_green_carpet"));

        // --- Ornamented purple wool ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORNAMENTED_PURPLE_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.PURPLE_WOOL)
                .pattern("N N")
                .pattern("NRN")
                .pattern("N N")
                .unlockedBy("has_purple_wool", has(Items.PURPLE_WOOL))
                .save(exporter, getRecipePath("ott", "ornamented_purple_wool"));

        // --- Delicate purple wool ---
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DELICATE_PURPLE_WOOL.get(), 8)
                .define('N', Items.GOLD_NUGGET)
                .define('R', Items.PURPLE_WOOL)
                .pattern(" N ")
                .pattern("NRN")
                .pattern(" N ")
                .unlockedBy("has_purple_wool", has(Items.PURPLE_WOOL))
                .save(exporter, getRecipePath("ott", "delicate_purple_wool"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ORNAMENTED_PURPLE_CARPET.get(), 3)
                .define('W', ModBlocks.ORNAMENTED_PURPLE_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_ornamented_purple_wool", has(ModBlocks.ORNAMENTED_PURPLE_WOOL.get()))
                .save(exporter, getRecipePath("ott", "ornamented_purple_carpet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DELICATE_PURPLE_CARPET.get(), 3)
                .define('W', ModBlocks.DELICATE_PURPLE_WOOL.get())
                .pattern("WW")
                .unlockedBy("has_delicate_purple_wool", has(ModBlocks.DELICATE_PURPLE_WOOL.get()))
                .save(exporter, getRecipePath("ott", "delicate_purple_carpet"));

        // --- Glazed terracotta smelting (16 custom colors) ---
        ModBlocks.COLOR_SETS.forEach((color, set) ->
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(set.terracotta().get()),
                                RecipeCategory.BUILDING_BLOCKS, set.glazedTerracotta().get(), 0.1F, 200)
                        .unlockedBy("has_terracotta", has(set.terracotta().get()))
                        .save(exporter, getRecipePath("ott", color + "_glazed_terracotta_from_smelting"))
        );

        // --- Dyed stone: 8 stone (ring) + dye → 8 dyed_stone (all 32 colors) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
            addRingDyeRecipe(exporter, Items.STONE, ModBlocks.PATTERN_BLOCKS.get("dyed_stone").get(name).get(), dye, name + "_dyed_stone");
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            addRingDyeRecipe(exporter, Items.STONE, ModBlocks.PATTERN_BLOCKS.get("dyed_stone").get(name).get(), dye, name + "_dyed_stone");
        }

        // --- Painted planks: 8 planks (ring, tag) + dye → 8 painted_planks (all 32 colors) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PATTERN_BLOCKS.get("painted_planks").get(name).get(), 8)
                    .define('#', ItemTags.PLANKS)
                    .define('D', dye)
                    .pattern("###")
                    .pattern("#D#")
                    .pattern("###")
                    .unlockedBy("has_planks", has(ItemTags.PLANKS))
                    .save(exporter, getRecipePath("ott", name + "_painted_planks_from_dyeing"));
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PATTERN_BLOCKS.get("painted_planks").get(name).get(), 8)
                    .define('#', ItemTags.PLANKS)
                    .define('D', dye)
                    .pattern("###")
                    .pattern("#D#")
                    .pattern("###")
                    .unlockedBy("has_planks", has(ItemTags.PLANKS))
                    .save(exporter, getRecipePath("ott", name + "_painted_planks_from_dyeing"));
        }


        // --- Stone bricks faucet: S/W/S (vertical center column) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.STONE_BRICKS_FAUCET.get())
                .define('S', Items.STONE_BRICKS)
                .define('W', Items.WATER_BUCKET)
                .pattern("S")
                .pattern("W")
                .pattern("S")
                .unlockedBy("has_stone_bricks", has(Items.STONE_BRICKS))
                .save(exporter, getRecipePath("ott", "stone_bricks_faucet"));

        // --- Stone bricks water jet: S/W/W (vertical center column) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.STONE_BRICKS_WATER_JET.get())
                .define('S', Items.STONE_BRICKS)
                .define('W', Items.WATER_BUCKET)
                .pattern("S")
                .pattern("W")
                .pattern("W")
                .unlockedBy("has_stone_bricks", has(Items.STONE_BRICKS))
                .save(exporter, getRecipePath("ott", "stone_bricks_water_jet"));

        // --- Water source trickle: W/W/W (vertical center column) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WATER_SOURCE_TRICKLE.get())
                .define('W', Items.WATER_BUCKET)
                .pattern("W")
                .pattern("W")
                .pattern("W")
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .save(exporter, getRecipePath("ott", "water_source_trickle"));

        // --- Weathering station: C_C/C_C/ICI (5 copper + 2 iron) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WEATHERING_STATION.get())
                .define('C', Items.COPPER_INGOT)
                .define('I', Items.IRON_INGOT)
                .pattern("C C")
                .pattern("C C")
                .pattern("ICI")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(exporter, getRecipePath("ott", "weathering_station"));

        // --- Stone lantern: SSS/GTG/SSS (6 stone + 2 glass panes + 1 torch) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.STONE_LANTERN.get())
                .define('S', Items.STONE)
                .define('G', Items.GLASS_PANE)
                .define('T', Items.TORCH)
                .pattern("SSS")
                .pattern("GTG")
                .pattern("SSS")
                .unlockedBy("has_stone", has(Items.STONE))
                .save(exporter, getRecipePath("ott", "stone_lantern"));

        // --- Iron fancy lantern: NIN/NTN/NIN (6 nuggets + 2 ingots + 1 torch) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_FANCY_LANTERN.get())
                .define('N', Items.IRON_NUGGET)
                .define('I', Items.IRON_INGOT)
                .define('T', Items.TORCH)
                .pattern("NIN")
                .pattern("NTN")
                .pattern("NIN")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(exporter, getRecipePath("ott", "iron_fancy_lantern"));

        // --- Bug net: diagonal (stick bottom-left, stick center, wool top-right) → 1 ---
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BUG_NET.get())
                .define('S', Items.STICK)
                .define('W', ItemTags.WOOL)
                .pattern("  W")
                .pattern(" S ")
                .pattern("S  ")
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(exporter, getRecipePath("ott", "bug_net"));

        // --- Futons: 3 matching wool (top row) + 3 wooden slabs (bottom row) → 1 futon (all 32 colors) ---
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Block woolBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(name + "_wool"));
            Block futon = ModBlocks.FUTONS.get(name).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, futon)
                    .define('W', woolBlock)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WWW")
                    .pattern("SSS")
                    .unlockedBy("has_wool", has(woolBlock))
                    .save(exporter, getRecipePath("ott", name + "_futon"));
        }
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Block woolBlock = ModBlocks.COLOR_SETS.get(name).wool().get();
            Block futon = ModBlocks.FUTONS.get(name).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, futon)
                    .define('W', woolBlock)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WWW")
                    .pattern("SSS")
                    .unlockedBy("has_wool", has(woolBlock))
                    .save(exporter, getRecipePath("ott", name + "_futon"));
        }
    }

    private void addRingDyeRecipe(RecipeOutput exporter, ItemLike source, ItemLike result, Item dye, String recipeName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', source)
                .define('D', dye)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .unlockedBy("has_source", has(source))
                .save(exporter, getRecipePath("ott", recipeName + "_from_dyeing"));
    }

    private void addSingleDyeRecipe(RecipeOutput exporter, ItemLike source, ItemLike result, Item dye, String recipeName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result)
                .requires(source)
                .requires(dye)
                .unlockedBy("has_source", has(source))
                .save(exporter, getRecipePath("ott", recipeName + "_from_dyeing_single"));
    }

    @SuppressWarnings("SameParameterValue")
    private void addRingShapeRecipe(RecipeOutput exporter, ItemLike ingredient, ItemLike result, int count, String recipeName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
                .define('#', ingredient)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_ingredient", has(ingredient))
                .save(exporter, getRecipePath("ott", recipeName));
    }

    private void mountsOfMayhemRecipes(RecipeOutput exporter) {
        {
            DeferredItem<AnimalArmorItem> i = ModItems.NETHERITE_HORSE_ARMOR;
            SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(Items.DIAMOND_HORSE_ARMOR),
                            Ingredient.of(Items.NETHERITE_INGOT),
                            RecipeCategory.MISC,
                            i.get()
                    )
                    .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                    .save(exporter, getRecipePath("minecraft", "netherite_horse_armor_smithing"));
        }
    }

    private void addMiscRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CHEST, 4)
                .define('#', net.minecraft.tags.ItemTags.LOGS)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_logs", has(net.minecraft.tags.ItemTags.LOGS))
                .save(exporter, getRecipePath("ott", "chest_from_logs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.HOPPER)
                .define('I', Items.IRON_INGOT)
                .define('L', net.minecraft.tags.ItemTags.LOGS)
                .pattern("ILI")
                .pattern("ILI")
                .pattern(" I ")
                .unlockedBy("has_logs", has(net.minecraft.tags.ItemTags.LOGS))
                .save(exporter, getRecipePath("ott", "hopper_from_logs"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.TORCH_ARROW.get(), 8)
                .requires(Items.ARROW)
                .requires(Items.TORCH)
                .unlockedBy("has_arrow", has(Items.ARROW))
                .unlockedBy("has_torch", has(Items.TORCH))
                .save(exporter, getRecipePath("ott", "torch_arrow"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, Items.SPECTRAL_ARROW, 2)
                .requires(Items.ARROW)
                .requires(ModItems.GLOW_GOOP.get(), 8)
                .unlockedBy("has_glow_goop", has(ModItems.GLOW_GOOP.get()))
                .save(exporter, getRecipePath("ott", "spectral_arrow_from_glow_goop"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.GLOW_BERRIES), RecipeCategory.MISC, ModItems.GLOW_GOOP.get(), 0.1F, 200)
                .unlockedBy("has_glow_berries", has(Items.GLOW_BERRIES))
                .save(exporter, getRecipePath("ott", "glow_goop_from_smelting"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.GLOWSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.REFINED_GLOWSTONE.get(), 0.1F, 200)
                .unlockedBy("has_glowstone", has(Items.GLOWSTONE))
                .save(exporter, getRecipePath("ott", "refined_glowstone_from_smelting"));
    }

    private void addDyeingRecipes(RecipeOutput exporter) {
        // Vanilla Colors
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));

            registerDyeingGroup(exporter, dye, name,
                    getItem(name + "_banner"),
                    getItem(name + "_candle"),
                    getItem(name + "_stained_glass"),
                    getItem(name + "_stained_glass_pane"),
                    getItem(name + "_shulker_box"),
                    getItem(name + "_concrete"),
                    getItem(name + "_concrete_powder"),
                    getItem(name + "_terracotta"),
                    getItem(name + "_wool"),
                    getItem(name + "_bed"),
                    getItem(name + "_carpet"),
                    false
            );
        }

        // Custom Colors
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            ModBlocks.ColorSetBlocks blocks = ModBlocks.COLOR_SETS.get(name);

            registerDyeingGroup(exporter, dye, name,
                    blocks.banner().get().asItem(),
                    blocks.candle().get().asItem(),
                    blocks.stainedGlass().get().asItem(),
                    blocks.stainedGlassPane().get().asItem(),
                    blocks.shulkerBox().get().asItem(),
                    blocks.concrete().get().asItem(),
                    blocks.concretePowder().get().asItem(),
                    blocks.terracotta().get().asItem(),
                    blocks.wool().get().asItem(),
                    blocks.bed().get().asItem(),
                    blocks.carpet().get().asItem(),
                    true
            );
        }
    }

    private static final Set<String> DEDICATED_PATTERN_RECIPES =
            Set.of("flat_roof_tiles", "layered_roof_tiles", "plastered_stone",
                   "chiseled_plastered_stone", "gilded_plastered_stone",
                   "delicate_plastered_stone", "banded_plastered_stone",
                   "dyed_stone", "painted_planks");

    private void addPatternBlockRecipes(RecipeOutput exporter) {
        for (Map.Entry<String, Map<String, DeferredBlock<Block>>> patternEntry : ModBlocks.PATTERN_BLOCKS.entrySet()) {
            String pattern = patternEntry.getKey();
            if (DEDICATED_PATTERN_RECIPES.contains(pattern)) continue;
            Map<String, DeferredBlock<Block>> colorMap = patternEntry.getValue();

            for (DyeColor color : DyeColor.values()) {
                String name = color.getName();
                DeferredBlock<Block> block = colorMap.get(name);
                if (block == null) continue;
                Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
                addDyedPatternRecipe(exporter, block.get(), dye, name + "_" + pattern);
            }

            for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
                String name = colorSet.name();
                DeferredBlock<Block> block = colorMap.get(name);
                if (block == null) continue;
                Item dye = ModItems.CUSTOM_DYES.get(name).get();
                addDyedPatternRecipe(exporter, block.get(), dye, name + "_" + pattern);
            }
        }
    }

    private void addDyedPatternRecipe(RecipeOutput exporter, Block result, Item dye, String recipeName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(Items.COBBLESTONE)
                .requires(dye)
                .unlockedBy("has_dye", has(dye))
                .save(exporter, getRecipePath("ott", recipeName + "_from_dyeing"));
    }

    private void addElevatorRecipes(RecipeOutput exporter) {
        // Craft: 8 matching wool + 1 ender pearl (3x3, pearl in center) → 8 elevators
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            com.otterly76.ott.block.custom.ElevatorBlock elevator = ModBlocks.ELEVATORS.get(name).get();
            Block woolBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(name + "_wool"));
            ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, elevator, 8)
                    .define('W', woolBlock)
                    .define('E', Items.ENDER_PEARL)
                    .pattern("WWW")
                    .pattern("WEW")
                    .pattern("WWW")
                    .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                    .save(exporter, getRecipePath("ott", name + "_elevator"));
        }

        // Vanilla-color redye: any elevator + vanilla dye → vanilla-colored elevator
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            Item dye = BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name + "_dye"));
            Block result = ModBlocks.ELEVATORS.get(name).get();
            ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, result)
                    .requires(net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("ott", "elevators")))
                    .requires(dye)
                    .unlockedBy("has_elevator", has(net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("ott", "elevators"))))
                    .save(exporter, getRecipePath("ott", name + "_elevator_from_dyeing"));
        }

        // Custom-color: 8 matching custom wool + 1 ender eye → 8 elevators
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Block woolBlock = ModBlocks.COLOR_SETS.get(name).wool().get();
            Block result = ModBlocks.ELEVATORS.get(name).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, result, 8)
                    .define('W', woolBlock)
                    .define('E', Items.ENDER_PEARL)
                    .pattern("WWW")
                    .pattern("WEW")
                    .pattern("WWW")
                    .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                    .save(exporter, getRecipePath("ott", name + "_elevator"));
        }

        // Custom-color redye: any elevator + custom dye → custom-colored elevator
        for (ModColorSets.ColorSet colorSet : ModColorSets.ALL) {
            String name = colorSet.name();
            Item dye = ModItems.CUSTOM_DYES.get(name).get();
            Block result = ModBlocks.ELEVATORS.get(name).get();
            ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, result)
                    .requires(net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("ott", "elevators")))
                    .requires(dye)
                    .unlockedBy("has_elevator", has(net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("ott", "elevators"))))
                    .save(exporter, getRecipePath("ott", name + "_elevator_from_dyeing"));
        }
    }

    private Item getItem(String name) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(name));
    }

    private void registerDyeingGroup(RecipeOutput exporter, Item dye, String colorName,
                                     Item banner, Item candle, Item glass, Item pane, Item shulker,
                                     Item concrete, Item powder, Item terracotta, Item wool, Item bed, Item carpet,
                                     boolean isCustom) {
        // 1:1 Shapeless
        addDyeingRecipe(exporter, banner, ModTags.ItemTags.DYEABLE_BANNERS, dye, colorName + "_banner", "has_any_banner");
        addDyeingRecipe(exporter, candle, ModTags.ItemTags.DYEABLE_CANDLES, dye, colorName + "_candle", "has_any_candle");
        addDyeingRecipe(exporter, glass, ModTags.ItemTags.DYEABLE_GLASS_BLOCKS, dye, colorName + "_glass", "has_any_glass");
        addDyeingRecipe(exporter, pane, ModTags.ItemTags.DYEABLE_GLASS_PANES, dye, colorName + "_pane", "has_any_pane");
        addDyeingRecipe(exporter, shulker, ModTags.ItemTags.DYEABLE_SHULKER_BOXES, dye, colorName + "_shulker_box", "has_any_shulker");
        addDyeingRecipe(exporter, concrete, ModTags.ItemTags.DYEABLE_CONCRETE, dye, colorName + "_concrete", "has_any_concrete");
        addDyeingRecipe(exporter, powder, ModTags.ItemTags.DYEABLE_CONCRETE_POWDER, dye, colorName + "_concrete_powder", "has_any_powder");
        addDyeingRecipe(exporter, terracotta, ModTags.ItemTags.DYEABLE_TERRACOTTA, dye, colorName + "_terracotta", "has_any_terracotta");

        addDyeingRecipe(exporter, wool, ItemTags.WOOL, dye, colorName + "_wool", "has_any_wool");
        addDyeingRecipe(exporter, bed, ItemTags.BEDS, dye, colorName + "_bed", "has_any_bed");
        addDyeingRecipe(exporter, carpet, ItemTags.WOOL_CARPETS, dye, colorName + "_carpet", "has_any_carpet");

        // 8:1 Shaped
        addShapedDyeingRecipe8(exporter, wool, ItemTags.WOOL, dye, colorName + "_wool", "has_any_wool");
        addShapedDyeingRecipe8(exporter, carpet, ItemTags.WOOL_CARPETS, dye, colorName + "_carpet", "has_any_carpet");
        addShapedDyeingRecipe8(exporter, glass, ModTags.ItemTags.DYEABLE_GLASS_BLOCKS, dye, colorName + "_glass", "has_any_glass");
        addShapedDyeingRecipe8(exporter, pane, ModTags.ItemTags.DYEABLE_GLASS_PANES, dye, colorName + "_pane", "has_any_pane");
        addShapedDyeingRecipe8(exporter, terracotta, ModTags.ItemTags.DYEABLE_TERRACOTTA, dye, colorName + "_terracotta", "has_any_terracotta");
        addShapedDyeingRecipe8(exporter, candle, ModTags.ItemTags.DYEABLE_CANDLES, dye, colorName + "_candle", "has_any_candle");
        addShapedDyeingRecipe8(exporter, concrete, ModTags.ItemTags.DYEABLE_CONCRETE, dye, colorName + "_concrete", "has_any_concrete");
        addShapedDyeingRecipe8(exporter, powder, ModTags.ItemTags.DYEABLE_CONCRETE_POWDER, dye, colorName + "_concrete_powder", "has_any_powder");

        if (isCustom) {
            addConcretePowderCrafting(exporter, powder, dye, colorName);
        }
    }

    private void addConcretePowderCrafting(RecipeOutput exporter, Item result, Item dye, String colorName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .requires(dye)
                .requires(ItemTags.SAND)
                .requires(ItemTags.SAND)
                .requires(ItemTags.SAND)
                .requires(ItemTags.SAND)
                .requires(Items.GRAVEL)
                .requires(Items.GRAVEL)
                .requires(Items.GRAVEL)
                .requires(Items.GRAVEL)
                .unlockedBy("has_dye", has(dye))
                .save(exporter, getRecipePath("ott", colorName + "_concrete_powder_crafting"));
    }

    private void addDyeingRecipe(RecipeOutput exporter, Item result, TagKey<Item> ingredientTag, Item dye, String recipeName, String criterionName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result)
                .requires(ingredientTag)
                .requires(dye)
                .unlockedBy(criterionName, has(ingredientTag))
                .save(exporter, getRecipePath("ott", recipeName + "_from_dyeing"));
    }

    private void addShapedDyeingRecipe8(RecipeOutput exporter, Item result, TagKey<Item> ingredientTag, Item dye, String recipeName, String criterionName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ingredientTag)
                .define('D', dye)
                .pattern("###")
                .pattern("#D#")
                .pattern("###")
                .unlockedBy(criterionName, has(ingredientTag))
                .save(exporter, getRecipePath("ott", recipeName + "_from_dyeing_8"));
    }

    private void shelfRecipes(RecipeOutput noAdv) {
        String[] shelfWoods = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak"};
        for (int i = 0; i < shelfWoods.length; i++) {
            String wood = shelfWoods[i];
            Block shelf = ModBlocks.SHELVES.get(i).get();
            Item log = switch (wood) {
                case "pale_oak" -> ModBlocks.STRIPPED_PALE_OAK_LOG.get().asItem();
                case "crimson", "warped" ->
                        BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace("stripped_" + wood + "_stem"));
                case "bamboo" -> Items.STRIPPED_BAMBOO_BLOCK;
                default ->
                        BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace("stripped_" + wood + "_log"));
            };

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shelf, 6)
                    .define('#', log)
                    .pattern("###")
                    .pattern("   ")
                    .pattern("###")
                    .unlockedBy("impossible", impossible())
                    .save(noAdv, getRecipePath("minecraft", wood + "_shelf"));
        }
        // OTT wood set shelves
        ModBlocks.WOOD_SETS.forEach((wood, set) ->
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.shelf().get(), 6)
                        .define('#', set.strippedLog().get())
                        .pattern("###")
                        .pattern("   ")
                        .pattern("###")
                        .unlockedBy("impossible", impossible())
                        .save(noAdv, getRecipePath("ott", wood + "_shelf")));
    }

    private void copperRecipes(RecipeOutput noAdv) {
        // Nuggets <-> Ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "copper_nugget"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT)
                .define('#', ModItems.COPPER_NUGGET.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "copper_ingot_from_nuggets"));

        // Smelting / Blasting for Nuggets
        Item[] smeltables = {
                ModItems.COPPER_PICKAXE.get(), ModItems.COPPER_SHOVEL.get(), ModItems.COPPER_AXE.get(),
                ModItems.COPPER_HOE.get(), ModItems.COPPER_SWORD.get(), ModItems.COPPER_HELMET.get(),
                ModItems.COPPER_CHESTPLATE.get(), ModItems.COPPER_LEGGINGS.get(), ModItems.COPPER_BOOTS.get(),
                ModItems.COPPER_HORSE_ARMOR.get()
        };
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(smeltables), RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 0.1F, 200)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "copper_nugget_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(smeltables), RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 0.1F, 100)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "copper_nugget_from_blasting"));

        // Copper Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_BARS.get("").get(), 16)
                .define('#', Items.COPPER_INGOT).pattern("###").pattern("###")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_bars"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.COPPER_BUTTONS.get("").get())
                .requires(Items.COPPER_INGOT)
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_button"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_CHAINS.get("").get())
                .define('I', Items.COPPER_INGOT).define('N', ModItems.COPPER_NUGGET.get()).pattern("N").pattern("I").pattern("N")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_chain"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_CHEST.get())
                .define('#', Items.COPPER_INGOT).pattern("###").pattern("# #").pattern("###")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_chest"));
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_DOORS.get("").get(), 3)
                .define('#', Items.COPPER_INGOT).pattern("##").pattern("##").pattern("##")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_door"));
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_TRAPDOORS.get("").get(), 2)
                .define('#', Items.COPPER_INGOT).pattern("###").pattern("###")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_trapdoor"));
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_PRESSURE_PLATES.get("").get())
                .define('#', Items.COPPER_INGOT).pattern("##")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_pressure_plate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_LANTERNS.get("").get())
                .define('#', ModItems.COPPER_NUGGET.get()).define('X', Items.TORCH).pattern("###").pattern("#X#").pattern("###")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_lantern"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_TORCH.get(), 4)
                .define('#', Items.COAL).define('S', Items.COPPER_INGOT).pattern("#").pattern("S")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_torch"));

        // Waxing recipes and button conversion
        String[] states = {"", "exposed_", "weathered_", "oxidized_"};
        for (String state : states) {
            registerWaxing(noAdv, ModBlocks.COPPER_BARS.get(state).get(), ModBlocks.COPPER_BARS.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_BUTTONS.get(state).get(), ModBlocks.COPPER_BUTTONS.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_CHAINS.get(state).get(), ModBlocks.COPPER_CHAINS.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_DOORS.get(state).get(), ModBlocks.COPPER_DOORS.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_TRAPDOORS.get(state).get(), ModBlocks.COPPER_TRAPDOORS.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_PRESSURE_PLATES.get(state).get(), ModBlocks.COPPER_PRESSURE_PLATES.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_LANTERNS.get(state).get(), ModBlocks.COPPER_LANTERNS.get("waxed_" + state).get());
            registerWaxing(noAdv, ModBlocks.COPPER_GOLEM_STATUES.get(state).get(), ModBlocks.COPPER_GOLEM_STATUES.get("waxed_" + state).get());
            
            if (ModBlocks.LIGHTNING_RODS.containsKey(state)) {
                registerWaxing(noAdv, ModBlocks.LIGHTNING_RODS.get(state).get(), ModBlocks.LIGHTNING_RODS.get("waxed_" + state).get());
            } else if (state.isEmpty()) {
                registerWaxing(noAdv, Items.LIGHTNING_ROD, ModBlocks.LIGHTNING_RODS.get("waxed_").get());
            }

            // Button from cut copper
            Item cutCopper = state.isEmpty() ? Items.CUT_COPPER : BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace(state + "cut_copper"));
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_BUTTONS.get(state).get())
                    .define('#', cutCopper)
                    .pattern("#")
                    .unlockedBy("impossible", impossible())
                    .save(noAdv, getRecipePath("minecraft", state + "copper_button_from_" + state + "cut_copper"));

            // Waxed button from waxed cut copper
            Item waxedCutCopper = state.isEmpty() ? Items.WAXED_CUT_COPPER : BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace("waxed_" + state + "cut_copper"));
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_BUTTONS.get("waxed_" + state).get())
                    .define('#', waxedCutCopper)
                    .pattern("#")
                    .unlockedBy("impossible", impossible())
                    .save(noAdv, getRecipePath("minecraft", "waxed_" + state + "copper_button_from_waxed_" + state + "cut_copper"));

            // Pressure plate from cut copper
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_PRESSURE_PLATES.get(state).get())
                    .define('#', cutCopper)
                    .pattern("##")
                    .unlockedBy("impossible", impossible())
                    .save(noAdv, getRecipePath("minecraft", state + "copper_pressure_plate_from_" + state + "cut_copper"));

            // Waxed pressure plate from waxed cut copper
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_PRESSURE_PLATES.get("waxed_" + state).get())
                    .define('#', waxedCutCopper)
                    .pattern("##")
                    .unlockedBy("impossible", impossible())
                    .save(noAdv, getRecipePath("minecraft", "waxed_" + state + "copper_pressure_plate_from_waxed_" + state + "cut_copper"));
        }
        
        registerWaxing(noAdv, ModBlocks.COPPER_CHEST.get(), ModBlocks.WAXED_COPPER_CHEST.get());
        registerWaxing(noAdv, ModBlocks.EXPOSED_COPPER_CHEST.get(), ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get());
        registerWaxing(noAdv, ModBlocks.WEATHERED_COPPER_CHEST.get(), ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get());
        registerWaxing(noAdv, ModBlocks.OXIDIZED_COPPER_CHEST.get(), ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get());
    }

    private void registerWaxing(RecipeOutput noAdv, ItemLike unaffected, ItemLike waxed) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxed)
                .requires(unaffected)
                .requires(Items.HONEYCOMB)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", BuiltInRegistries.ITEM.getKey(waxed.asItem()).getPath() + "_from_honeycomb"));
    }

    private void copperToolArmorRecipes(RecipeOutput noAdv) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD.get())
                .define('#', Items.COPPER_INGOT).define('S', Items.STICK).pattern("#").pattern("#").pattern("S")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_sword"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL.get())
                .define('#', Items.COPPER_INGOT).define('S', Items.STICK).pattern("#").pattern("S").pattern("S")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get())
                .define('#', Items.COPPER_INGOT).define('S', Items.STICK).pattern("###").pattern(" S ").pattern(" S ")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get())
                .define('#', Items.COPPER_INGOT).define('S', Items.STICK).pattern("##").pattern("#S").pattern(" S")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get())
                .define('#', Items.COPPER_INGOT).define('S', Items.STICK).pattern("##").pattern(" S").pattern(" S")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_HELMET.get())
                .define('#', Items.COPPER_INGOT).pattern("###").pattern("# #")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE.get())
                .define('#', Items.COPPER_INGOT).pattern("# #").pattern("###").pattern("###")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS.get())
                .define('#', Items.COPPER_INGOT).pattern("###").pattern("# #").pattern("# #")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_leggings"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS.get())
                .define('#', Items.COPPER_INGOT).pattern("# #").pattern("# #")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_HORSE_ARMOR.get())
                .define('#', Items.COPPER_INGOT).define('S', Items.LEATHER)
                .pattern("# #").pattern("#S#").pattern("# #")
                .unlockedBy("impossible", impossible()).save(noAdv, getRecipePath("minecraft", "copper_horse_armor"));
    }

    private void woodRecipes(RecipeOutput noAdv) {
        // --- Backported Pale Oak recipes (minecraft namespace) ---
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_PLANKS.get(), 4)
                .requires(ModTags.ItemTags.PALE_OAK_LOGS)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_planks"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_STAIRS.get(), 4)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_SLAB.get(), 6)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PALE_OAK_FENCE.get(), 3)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("#S#")
                .pattern("#S#")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_FENCE_GATE.get())
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("S#S")
                .pattern("S#S")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_fence_gate"));

        // sign + hanging sign (you said you want both)
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.PALE_OAK_SIGN.get(), 3)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_sign"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.PALE_OAK_HANGING_SIGN.get(), 6)
                .define('#', ModBlocks.STRIPPED_PALE_OAK_LOG.get())
                .define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_hanging_sign"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_DOOR.get(), 3)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_door"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_TRAPDOOR.get(), 2)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_trapdoor"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.PALE_OAK_BOAT.get())
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("# #")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_boat"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.PALE_OAK_CHEST_BOAT.get())
                .requires(ModItems.PALE_OAK_BOAT.get())
                .requires(Items.CHEST)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_chest_boat"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), 3)
                .define('#', ModBlocks.STRIPPED_PALE_OAK_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "stripped_pale_oak_wood"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_WOOD.get(), 3)
                .define('#', ModBlocks.PALE_OAK_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_wood"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_BUTTON.get())
                .requires(ModBlocks.PALE_OAK_PLANKS.get())
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_button"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_PRESSURE_PLATE.get())
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("minecraft", "pale_oak_pressure_plate"));

        // --- ott wood sets (ott namespace) ---
        ModBlocks.WOOD_SETS.forEach((setName, set) -> registerOttWoodSetRecipes(noAdv, setName, set));
    }

    private void registerOttWoodSetRecipes(RecipeOutput noAdv, String setName, ModBlocks.WoodSetBlocks set) {
        // Use tag-based “any log variant” per set: ott:<setName>_logs
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.planks().get(), 4)
                .requires(ModTags.ItemTags.woodSetLogs(setName))
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.planks().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.stairs().get(), 4)
                .define('#', set.planks().get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.stairs().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.slab().get(), 6)
                .define('#', set.planks().get())
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.slab().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, set.fence().get(), 3)
                .define('#', set.planks().get())
                .define('S', Items.STICK)
                .pattern("#S#")
                .pattern("#S#")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.fence().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, set.fenceGate().get())
                .define('#', set.planks().get())
                .define('S', Items.STICK)
                .pattern("S#S")
                .pattern("S#S")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.fenceGate().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, set.door().get(), 3)
                .define('#', set.planks().get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.door().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, set.trapdoor().get(), 2)
                .define('#', set.planks().get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.trapdoor().getId().getPath()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, set.button().get())
                .requires(set.planks().get())
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.button().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, set.pressurePlate().get())
                .define('#', set.planks().get())
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.pressurePlate().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.wood().get(), 3)
                .define('#', set.log().get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.wood().getId().getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.strippedWood().get(), 3)
                .define('#', set.strippedLog().get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", set.strippedWood().getId().getPath()));

        // Vanilla sign recipe: 6 planks + 1 stick -> 3 signs
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.WOOD_SET_SIGNS.get(setName).get(), 3)
                .define('#', set.planks().get())
                .define('S', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", setName + "_sign"));

        // Vanilla hanging sign recipe: chains + stripped logs -> 6 hanging signs
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.WOOD_SET_HANGING_SIGNS.get(setName).get(), 6)
                .define('#', set.strippedLog().get())
                .define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", setName + "_hanging_sign"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.WOOD_SET_BOATS.get(setName).get())
                .define('#', set.planks().get())
                .pattern("# #")
                .pattern("###")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", setName + "_boat"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, ModItems.WOOD_SET_CHEST_BOATS.get(setName).get())
                .requires(ModItems.WOOD_SET_BOATS.get(setName).get())
                .requires(Items.CHEST)
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", setName + "_chest_boat"));
    }

    private void createGradientRecipe(RecipeOutput noAdv, IGradientBlock gradientBlock) {
        Block block = (Block) gradientBlock;
        Block ingredient1 = gradientBlock.getBlockFromColor(gradientBlock.getFirstColor());
        Block ingredient2 = gradientBlock.getBlockFromColor(gradientBlock.getSecondColor());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, block, 2)
                .requires(ingredient1)
                .requires(ingredient2)
                .group("ott_gradient_blocks")
                .unlockedBy("impossible", impossible())
                .save(noAdv, getRecipePath("ott", gradientBlock.getRegistryID().getPath()));
    }

    private void ottCrittersRecipes(RecipeOutput noAdv) {
        // Smelting
        this.cooking(noAdv, List.of(ModItems.RAW_GOLDEN_SUNFISH_MEAT.get()), ModItems.COOKED_GOLDEN_SUNFISH_MEAT.get(), "cooked_golden_sunfish_meat");
        this.cooking(noAdv, List.of(ModItems.RAW_KRILL.get()), ModItems.FRIED_KRILL.get(), "fried_krill");
        this.cooking(noAdv, List.of(ModItems.RAW_SUNFISH_MEAT.get()), ModItems.COOKED_SUNFISH_MEAT.get(), "cooked_sunfish_meat");

        // Crafting
        // Salt
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SALT_BLOCK.get())
                .define('#', ModItems.PINK_SALT.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_pink_salt", has(ModItems.PINK_SALT.get()))
                .save(noAdv, getRecipePath("ott", "pink_salt_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PINK_SALT_BLOCK.get(), 4)
                .define('#', ModBlocks.PINK_SALT_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_pink_salt_block", has(ModBlocks.PINK_SALT_BLOCK.get()))
                .save(noAdv, getRecipePath("ott", "polished_pink_salt_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PINK_SALT_LAMP.get())
                .define('S', ModBlocks.POLISHED_PINK_SALT_BLOCK.get())
                .define('G', Items.GLOWSTONE_DUST)
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .unlockedBy("has_polished_pink_salt_block", has(ModBlocks.POLISHED_PINK_SALT_BLOCK.get()))
                .save(noAdv, getRecipePath("ott", "pink_salt_lamp"));

        // Catfish
        cooking(noAdv, List.of(ModItems.CATFISH.get()), ModItems.COOKED_CATFISH.get(), "cooked_catfish");
        // Bass
        cooking(noAdv, List.of(ModItems.BASS.get()), ModItems.COOKED_BASS.get(), "cooked_bass");
        // Snail
        cooking(noAdv, List.of(ModItems.RAW_SNAIL.get()), ModItems.COOKED_SNAIL.get(), "cooked_snail");
        // Shrimp
        cooking(noAdv, List.of(ModItems.RAW_SHRIMP.get()), ModItems.STEAMED_SHRIMP.get(), "steamed_shrimp");
        // Wild bird meat
        cooking(noAdv, List.of(ModItems.RAW_WILD_BIRD_MEAT.get()), ModItems.COOKED_WILD_BIRD_MEAT.get(), "cooked_wild_bird_meat");
        // Wild game meat
        cooking(noAdv, List.of(ModItems.RAW_WILD_GAME_MEAT.get()), ModItems.COOKED_WILD_GAME_MEAT.get(), "cooked_wild_game_meat");
        // Crab meat
        cooking(noAdv, List.of(ModItems.RAW_CRAB_MEAT.get()), ModItems.STEAMED_CRAB_MEAT.get(), "steamed_crab_meat");
        // Bonnethead shark
        cooking(noAdv, List.of(ModItems.RAW_BONNETHEAD.get()), ModItems.COOKED_BONNETHEAD.get(), "cooked_bonnethead");
        // Cichlid
        cooking(noAdv, List.of(ModItems.RAW_CICHLID.get()), ModItems.COOKED_CICHLID.get(), "cooked_cichlid");
        // Goblin shark
        cooking(noAdv, List.of(ModItems.RAW_GOBLIN_SHARK.get()), ModItems.COOKED_GOBLIN_SHARK.get(), "cooked_goblin_shark");
        // Guitarfish
        cooking(noAdv, List.of(ModItems.RAW_GUITARFISH.get()), ModItems.COOKED_GUITARFISH.get(), "cooked_guitarfish");
        // Lizard tail
        cooking(noAdv, List.of(ModItems.LIZARD_TAIL.get()), ModItems.COOKED_LIZARD_TAIL.get(), "cooked_lizard_tail");
        // Egg
        cooking(noAdv, List.of(Items.EGG), ModItems.COOKED_EGG.get(), "cooked_egg");
    }

    private void cooking(RecipeOutput exporter, List<ItemLike> ingredients, ItemLike result, String name) {
        int cookingTime = 200;
        float experience = 0.35F;
        RecipeCategory category = RecipeCategory.FOOD;
        oreSmelting(exporter, ingredients, category, result, experience, cookingTime, name);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredients.toArray(new ItemLike[0])), category, result, experience, cookingTime / 2)
                .unlockedBy("has_" + name, has(ingredients.getFirst()))
                .save(exporter, getRecipePath("ott", name + "_from_smoking"));
    }

    private void registerSlabToBlock(RecipeOutput exporter, Item slab, Item block, String name) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block)
                .define('#', slab)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_" + name, has(slab))
                .save(exporter, getRecipePath("ott", name + "_from_slabs"));
    }

    private void addSlabToBlockRecipes(RecipeOutput exporter) {
        // Vanilla Wood
        registerSlabToBlock(exporter, Items.OAK_SLAB, Items.OAK_PLANKS, "oak_planks");
        registerSlabToBlock(exporter, Items.SPRUCE_SLAB, Items.SPRUCE_PLANKS, "spruce_planks");
        registerSlabToBlock(exporter, Items.BIRCH_SLAB, Items.BIRCH_PLANKS, "birch_planks");
        registerSlabToBlock(exporter, Items.JUNGLE_SLAB, Items.JUNGLE_PLANKS, "jungle_planks");
        registerSlabToBlock(exporter, Items.ACACIA_SLAB, Items.ACACIA_PLANKS, "acacia_planks");
        registerSlabToBlock(exporter, Items.DARK_OAK_SLAB, Items.DARK_OAK_PLANKS, "dark_oak_planks");
        registerSlabToBlock(exporter, Items.MANGROVE_SLAB, Items.MANGROVE_PLANKS, "mangrove_planks");
        registerSlabToBlock(exporter, Items.CHERRY_SLAB, Items.CHERRY_PLANKS, "cherry_planks");
        registerSlabToBlock(exporter, Items.BAMBOO_SLAB, Items.BAMBOO_PLANKS, "bamboo_planks");
        registerSlabToBlock(exporter, Items.BAMBOO_MOSAIC_SLAB, Items.BAMBOO_MOSAIC, "bamboo_mosaic");
        registerSlabToBlock(exporter, Items.CRIMSON_SLAB, Items.CRIMSON_PLANKS, "crimson_planks");
        registerSlabToBlock(exporter, Items.WARPED_SLAB, Items.WARPED_PLANKS, "warped_planks");

        // Stones
        registerSlabToBlock(exporter, Items.STONE_SLAB, Items.STONE, "stone");
        registerSlabToBlock(exporter, Items.COBBLESTONE_SLAB, Items.COBBLESTONE, "cobblestone");
        registerSlabToBlock(exporter, Items.MOSSY_COBBLESTONE_SLAB, Items.MOSSY_COBBLESTONE, "mossy_cobblestone");
        registerSlabToBlock(exporter, Items.STONE_BRICK_SLAB, Items.STONE_BRICKS, "stone_bricks");
        registerSlabToBlock(exporter, Items.MOSSY_STONE_BRICK_SLAB, Items.MOSSY_STONE_BRICKS, "mossy_stone_bricks");
        registerSlabToBlock(exporter, Items.GRANITE_SLAB, Items.GRANITE, "granite");
        registerSlabToBlock(exporter, Items.DIORITE_SLAB, Items.DIORITE, "diorite");
        registerSlabToBlock(exporter, Items.ANDESITE_SLAB, Items.ANDESITE, "andesite");

        // Deepslate
        registerSlabToBlock(exporter, Items.COBBLED_DEEPSLATE_SLAB, Items.COBBLED_DEEPSLATE, "cobbled_deepslate");
        registerSlabToBlock(exporter, Items.DEEPSLATE_BRICK_SLAB, Items.DEEPSLATE_BRICKS, "deepslate_bricks");
        registerSlabToBlock(exporter, Items.DEEPSLATE_TILE_SLAB, Items.DEEPSLATE_TILES, "deepslate_tiles");

        // Blackstone
        registerSlabToBlock(exporter, Items.BLACKSTONE_SLAB, Items.BLACKSTONE, "blackstone");
        registerSlabToBlock(exporter, Items.POLISHED_BLACKSTONE_BRICK_SLAB, Items.POLISHED_BLACKSTONE_BRICKS, "polished_blackstone_bricks");

        // Sandstone
        registerSlabToBlock(exporter, Items.SMOOTH_SANDSTONE_SLAB, Items.SMOOTH_SANDSTONE, "smooth_sandstone");
        registerSlabToBlock(exporter, Items.SMOOTH_RED_SANDSTONE_SLAB, Items.SMOOTH_RED_SANDSTONE, "smooth_red_sandstone");

        // Tuff
        registerSlabToBlock(exporter, Items.TUFF_SLAB, Items.TUFF, "tuff");
        registerSlabToBlock(exporter, Items.TUFF_BRICK_SLAB, Items.TUFF_BRICKS, "tuff_bricks");

        // Prismarine
        registerSlabToBlock(exporter, Items.PRISMARINE_SLAB, Items.PRISMARINE, "prismarine");
        registerSlabToBlock(exporter, Items.PRISMARINE_BRICK_SLAB, Items.PRISMARINE_BRICKS, "prismarine_bricks");
        registerSlabToBlock(exporter, Items.DARK_PRISMARINE_SLAB, Items.DARK_PRISMARINE, "dark_prismarine");

        // Misc
        registerSlabToBlock(exporter, Items.BRICK_SLAB, Items.BRICKS, "bricks");
        registerSlabToBlock(exporter, Items.MUD_BRICK_SLAB, Items.MUD_BRICKS, "mud_bricks");
        registerSlabToBlock(exporter, Items.NETHER_BRICK_SLAB, Items.NETHER_BRICKS, "nether_bricks");
        registerSlabToBlock(exporter, Items.RED_NETHER_BRICK_SLAB, Items.RED_NETHER_BRICKS, "red_nether_bricks");
        registerSlabToBlock(exporter, Items.SMOOTH_QUARTZ_SLAB, Items.SMOOTH_QUARTZ, "smooth_quartz");
        registerSlabToBlock(exporter, Items.PURPUR_SLAB, Items.PURPUR_BLOCK, "purpur_block");
        registerSlabToBlock(exporter, Items.END_STONE_BRICK_SLAB, Items.END_STONE_BRICKS, "end_stone_bricks");

        // Copper
        registerSlabToBlock(exporter, Items.CUT_COPPER_SLAB, Items.CUT_COPPER, "cut_copper");
        registerSlabToBlock(exporter, Items.EXPOSED_CUT_COPPER_SLAB, Items.EXPOSED_CUT_COPPER, "exposed_cut_copper");
        registerSlabToBlock(exporter, Items.WEATHERED_CUT_COPPER_SLAB, Items.WEATHERED_CUT_COPPER, "weathered_cut_copper");
        registerSlabToBlock(exporter, Items.OXIDIZED_CUT_COPPER_SLAB, Items.OXIDIZED_CUT_COPPER, "oxidized_cut_copper");
        registerSlabToBlock(exporter, Items.WAXED_CUT_COPPER_SLAB, Items.WAXED_CUT_COPPER, "waxed_cut_copper");
        registerSlabToBlock(exporter, Items.WAXED_EXPOSED_CUT_COPPER_SLAB, Items.WAXED_EXPOSED_CUT_COPPER, "waxed_exposed_cut_copper");
        registerSlabToBlock(exporter, Items.WAXED_WEATHERED_CUT_COPPER_SLAB, Items.WAXED_WEATHERED_CUT_COPPER, "waxed_weathered_cut_copper");
        registerSlabToBlock(exporter, Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, Items.WAXED_OXIDIZED_CUT_COPPER, "waxed_oxidized_cut_copper");

        // Mod Slabs
        registerSlabToBlock(exporter, ModBlocks.PALE_OAK_SLAB.get().asItem(), ModBlocks.PALE_OAK_PLANKS.get().asItem(), "pale_oak_planks");
        registerSlabToBlock(exporter, ModBlocks.RESIN_BRICK_SLAB.get().asItem(), ModBlocks.RESIN_BRICKS.get().asItem(), "resin_bricks");

        ModBlocks.WOOD_SETS.forEach((setName, set) -> {
            registerSlabToBlock(exporter, set.slab().get().asItem(), set.planks().get().asItem(), setName + "_planks");
        });
    }

    private void addStonecutterRecipes(RecipeOutput exporter) {
        // --- Color set concrete → plate / edge / beam / pergola / geowindow / bannister / support ---
        ModBlocks.COLOR_SETS.forEach((color, set) -> {
            stonecutOne(exporter, set.concrete().get(), set.plate().get(),           color + "_plate_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.edge().get(),            color + "_edge_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.beam().get(),            color + "_beam_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.pergola().get(),         color + "_pergola_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.geometricWindow().get(), color + "_geowindow_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.bannister().get(),       color + "_bannister_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.supportSlab().get(),     color + "_support_slab_stonecutting");
            stonecutOne(exporter, set.concrete().get(), set.supportBeam().get(),     color + "_support_beam_stonecutting");
        });

        // (wood set planks → structural shapes moved to woodcutter below)

        // --- Stone set (input block → 8 architectural shapes) ---
        ModBlocks.STONE_SETS.forEach((name, set) -> {
            com.otterly76.ott.block.stone.ModStoneVariants.StoneVariant v =
                    com.otterly76.ott.block.stone.ModStoneVariants.byName(name);
            if (v == null) return;
            ItemLike src = v.input().get();
            stonecutOne(exporter, src, set.plate().get(),            name + "_plate_stonecutting");
            stonecutOne(exporter, src, set.edge().get(),             name + "_edge_stonecutting");
            stonecutOne(exporter, src, set.beam().get(),             name + "_beam_stonecutting");
            stonecutOne(exporter, src, set.pergola().get(),          name + "_pergola_stonecutting");
            stonecutOne(exporter, src, set.geometricWindow().get(),  name + "_geowindow_stonecutting");
            stonecutOne(exporter, src, set.bannister().get(),        name + "_bannister_stonecutting");
            stonecutOne(exporter, src, set.supportSlab().get(),      name + "_support_slab_stonecutting");
            stonecutOne(exporter, src, set.supportBeam().get(),      name + "_support_beam_stonecutting");
        });

        // --- Static blocks with known shape variants ---
        stonecutOne(exporter, ModBlocks.LIMESTONE_MASONRY.get(),                         ModBlocks.LIMESTONE_MASONRY_EDGE.get(),                        "limestone_masonry_edge_stonecutting");
        stonecutOne(exporter, ModBlocks.LIMESTONE_MASONRY.get(),                         ModBlocks.LIMESTONE_MASONRY_PLATE.get(),                       "limestone_masonry_plate_stonecutting");
        woodcutOne(exporter, ModBlocks.WHEAT_THATCH.get(),                              ModBlocks.WHEAT_THATCH_EDGE.get(),                             "wheat_thatch_edge_woodcutting");
        woodcutOne(exporter, ModBlocks.WHEAT_THATCH.get(),                              ModBlocks.WHEAT_THATCH_PLATE.get(),                            "wheat_thatch_plate_woodcutting");
        woodcutOne(exporter, ModBlocks.BAMBOO_THATCH.get(),                             ModBlocks.BAMBOO_THATCH_EDGE.get(),                            "bamboo_thatch_edge_woodcutting");
        woodcutOne(exporter, ModBlocks.BAMBOO_THATCH.get(),                             ModBlocks.BAMBOO_THATCH_PLATE.get(),                           "bamboo_thatch_plate_woodcutting");
        // --- Sandstone slender from smooth sandstone (base blocks only; all shapes via stone set) ---
        stonecutOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SANDSTONE_SLENDER_BRICKS.get(),            "sandstone_slender_bricks_from_smooth_sandstone_stonecutting");
        stonecutOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN.get(), "sandstone_slender_turquoise_pattern_from_smooth_sandstone_stonecutting");
        // --- Sandstone_crenelation from smooth sandstone ---
        stonecutOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SANDSTONE_CRENELATION.get(),          "sandstone_crenelation_from_smooth_sandstone_stonecutting");
        // --- Stone bricks masonry from stone ---
        stonecutOne(exporter, Blocks.STONE, ModBlocks.STONE_BRICKS_MASONRY.get(),       "stone_bricks_masonry_stonecutting");
        stonecutOne(exporter, Blocks.STONE, ModBlocks.STONE_BRICKS_MASONRY_EDGE.get(),  "stone_bricks_masonry_edge_stonecutting");
        stonecutOne(exporter, Blocks.STONE, ModBlocks.STONE_BRICKS_MASONRY_PLATE.get(), "stone_bricks_masonry_plate_stonecutting");
        // --- Stone bricks functional blocks from stone bricks ---
        stonecutOne(exporter, Blocks.STONE_BRICKS, ModBlocks.STONE_BRICKS_ARROWSLIT.get(),   "stone_bricks_arrowslit_stonecutting");
        stonecutOne(exporter, Blocks.STONE_BRICKS, ModBlocks.STONE_BRICKS_MACHICOLATION.get(),"stone_bricks_machicolation_stonecutting");
        stonecutOne(exporter, Blocks.STONE_BRICKS, ModBlocks.STONE_BRICKS_POOL.get(),         "stone_bricks_pool_stonecutting");
        stonecutOne(exporter, Blocks.STONE_BRICKS, ModBlocks.STONE_BRICKS_SMALL_POOL.get(),   "stone_bricks_small_pool_stonecutting");
        // --- Limestone stonecutter source ---
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.WATER_MOSAIC_TRADITIONAL.get(), "water_mosaic_traditional_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.WATER_MOSAIC_BORDER.get(),      "water_mosaic_border_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.WATER_MOSAIC_GEOMETRIC.get(),   "water_mosaic_geometric_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.WATER_MOSAIC_PATTERN.get(),     "water_mosaic_pattern_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.WATER_MOSAIC_DELICATE.get(),    "water_mosaic_delicate_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.WATER_MOSAIC_RECESS.get(),      "water_mosaic_recess_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.SPIRIT_MOSAIC_RECESS.get(),     "spirit_mosaic_recess_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.EARTH_MOSAIC_RECESS.get(),      "earth_mosaic_recess_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.FIRE_MOSAIC_RECESS.get(),       "fire_mosaic_recess_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.EARTH_MOSAIC_TRADITIONAL.get(), "earth_mosaic_traditional_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.EARTH_MOSAIC_BORDER.get(),      "earth_mosaic_border_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.EARTH_MOSAIC_GEOMETRIC.get(),   "earth_mosaic_geometric_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.EARTH_MOSAIC_PATTERN.get(),     "earth_mosaic_pattern_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.EARTH_MOSAIC_DELICATE.get(),    "earth_mosaic_delicate_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.FIRE_MOSAIC_TRADITIONAL.get(),  "fire_mosaic_traditional_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.FIRE_MOSAIC_BORDER.get(),       "fire_mosaic_border_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.FIRE_MOSAIC_GEOMETRIC.get(),    "fire_mosaic_geometric_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.FIRE_MOSAIC_PATTERN.get(),      "fire_mosaic_pattern_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.FIRE_MOSAIC_DELICATE.get(),     "fire_mosaic_delicate_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.SPIRIT_MOSAIC_TRADITIONAL.get(), "spirit_mosaic_traditional_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.SPIRIT_MOSAIC_BORDER.get(),     "spirit_mosaic_border_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.SPIRIT_MOSAIC_GEOMETRIC.get(),  "spirit_mosaic_geometric_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.SPIRIT_MOSAIC_PATTERN.get(),    "spirit_mosaic_pattern_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.SPIRIT_MOSAIC_DELICATE.get(),   "spirit_mosaic_delicate_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.AIR_MOSAIC_RECESS.get(),        "air_mosaic_recess_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.AIR_MOSAIC_TRADITIONAL.get(),   "air_mosaic_traditional_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.AIR_MOSAIC_BORDER.get(),        "air_mosaic_border_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.AIR_MOSAIC_GEOMETRIC.get(),     "air_mosaic_geometric_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.AIR_MOSAIC_PATTERN.get(),       "air_mosaic_pattern_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.AIR_MOSAIC_DELICATE.get(),      "air_mosaic_delicate_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.MOSAIC_FLOOR.get(),             "mosaic_floor_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.MOSAIC_FLOOR_DELICATE.get(),    "mosaic_floor_delicate_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.MOSAIC_FLOOR_ROSETTE.get(),     "mosaic_floor_rosette_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.ROMAN_FRESCO_RED.get(),         "roman_fresco_red_from_limestone_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.ROMAN_FRESCO_BLACK.get(),       "roman_fresco_black_from_limestone_stonecutting");
        // --- Limestone masonry from limestone ---
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.LIMESTONE_MASONRY.get(), "limestone_masonry_from_limestone_stonecutting");
        // --- Black marble stonecutting ---
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), OttBlocks.BLACK_MARBLE_BRICKS.get(),       "black_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), OttBlocks.BLACK_MARBLE_SMALL_BRICKS.get(), "black_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), OttBlocks.BLACK_MARBLE_TILES.get(),        "black_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), OttBlocks.BLACK_MARBLE_PILLAR.get(),       "black_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), OttBlocks.BLACK_MARBLE_PILLAR_CAP.get(),   "black_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), ModBlocks.BLACK_MARBLE_FANCY_FENCE.get(),  "black_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.BLACK_MARBLE.get(), ModBlocks.BLACK_MARBLE_FLOOR_TILE.get(), "black_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLACK_MARBLE.get(), OttBlocks.BLACK_MARBLE_DIAMOND_PAVERS.get(), "black_marble_diamond_pavers_stonecutting");
        // --- White marble stonecutting ---
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), OttBlocks.WHITE_MARBLE_BRICKS.get(),       "white_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), OttBlocks.WHITE_MARBLE_SMALL_BRICKS.get(), "white_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), OttBlocks.WHITE_MARBLE_TILES.get(),        "white_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), OttBlocks.WHITE_MARBLE_PILLAR.get(),       "white_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), OttBlocks.WHITE_MARBLE_PILLAR_CAP.get(),   "white_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), ModBlocks.WHITE_MARBLE_FANCY_FENCE.get(),  "white_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.WHITE_MARBLE.get(), ModBlocks.WHITE_MARBLE_FLOOR_TILE.get(), "white_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.WHITE_MARBLE.get(), OttBlocks.WHITE_MARBLE_DIAMOND_PAVERS.get(), "white_marble_diamond_pavers_stonecutting");
        // ── Amethyst Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), OttBlocks.AMETHYST_MARBLE_BRICKS.get(),       "amethyst_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), OttBlocks.AMETHYST_MARBLE_SMALL_BRICKS.get(), "amethyst_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), OttBlocks.AMETHYST_MARBLE_TILES.get(),        "amethyst_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), OttBlocks.AMETHYST_MARBLE_PILLAR.get(),       "amethyst_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), OttBlocks.AMETHYST_MARBLE_PILLAR_CAP.get(),   "amethyst_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), ModBlocks.AMETHYST_MARBLE_FANCY_FENCE.get(),  "amethyst_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.AMETHYST_MARBLE.get(), ModBlocks.AMETHYST_MARBLE_FLOOR_TILE.get(),   "amethyst_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.AMETHYST_MARBLE.get(), OttBlocks.AMETHYST_MARBLE_DIAMOND_PAVERS.get(),  "amethyst_marble_diamond_pavers_stonecutting");
        // ── Blue Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), OttBlocks.BLUE_MARBLE_BRICKS.get(),       "blue_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), OttBlocks.BLUE_MARBLE_SMALL_BRICKS.get(), "blue_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), OttBlocks.BLUE_MARBLE_TILES.get(),        "blue_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), OttBlocks.BLUE_MARBLE_PILLAR.get(),       "blue_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), OttBlocks.BLUE_MARBLE_PILLAR_CAP.get(),   "blue_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), ModBlocks.BLUE_MARBLE_FANCY_FENCE.get(),  "blue_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.BLUE_MARBLE.get(), ModBlocks.BLUE_MARBLE_FLOOR_TILE.get(),   "blue_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.BLUE_MARBLE.get(), OttBlocks.BLUE_MARBLE_DIAMOND_PAVERS.get(),  "blue_marble_diamond_pavers_stonecutting");
        // ── Cyan Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), OttBlocks.CYAN_MARBLE_BRICKS.get(),       "cyan_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), OttBlocks.CYAN_MARBLE_SMALL_BRICKS.get(), "cyan_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), OttBlocks.CYAN_MARBLE_TILES.get(),        "cyan_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), OttBlocks.CYAN_MARBLE_PILLAR.get(),       "cyan_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), OttBlocks.CYAN_MARBLE_PILLAR_CAP.get(),   "cyan_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), ModBlocks.CYAN_MARBLE_FANCY_FENCE.get(),  "cyan_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.CYAN_MARBLE.get(), ModBlocks.CYAN_MARBLE_FLOOR_TILE.get(),   "cyan_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.CYAN_MARBLE.get(), OttBlocks.CYAN_MARBLE_DIAMOND_PAVERS.get(),  "cyan_marble_diamond_pavers_stonecutting");
        // ── Green Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), OttBlocks.GREEN_MARBLE_BRICKS.get(),       "green_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), OttBlocks.GREEN_MARBLE_SMALL_BRICKS.get(), "green_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), OttBlocks.GREEN_MARBLE_TILES.get(),        "green_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), OttBlocks.GREEN_MARBLE_PILLAR.get(),       "green_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), OttBlocks.GREEN_MARBLE_PILLAR_CAP.get(),   "green_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), ModBlocks.GREEN_MARBLE_FANCY_FENCE.get(),  "green_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.GREEN_MARBLE.get(), ModBlocks.GREEN_MARBLE_FLOOR_TILE.get(),   "green_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.GREEN_MARBLE.get(), OttBlocks.GREEN_MARBLE_DIAMOND_PAVERS.get(),  "green_marble_diamond_pavers_stonecutting");
        // ── Lime Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), OttBlocks.LIME_MARBLE_BRICKS.get(),       "lime_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), OttBlocks.LIME_MARBLE_SMALL_BRICKS.get(), "lime_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), OttBlocks.LIME_MARBLE_TILES.get(),        "lime_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), OttBlocks.LIME_MARBLE_PILLAR.get(),       "lime_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), OttBlocks.LIME_MARBLE_PILLAR_CAP.get(),   "lime_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), ModBlocks.LIME_MARBLE_FANCY_FENCE.get(),  "lime_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.LIME_MARBLE.get(), ModBlocks.LIME_MARBLE_FLOOR_TILE.get(),   "lime_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.LIME_MARBLE.get(), OttBlocks.LIME_MARBLE_DIAMOND_PAVERS.get(),  "lime_marble_diamond_pavers_stonecutting");
        // ── Orange Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), OttBlocks.ORANGE_MARBLE_BRICKS.get(),       "orange_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), OttBlocks.ORANGE_MARBLE_SMALL_BRICKS.get(), "orange_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), OttBlocks.ORANGE_MARBLE_TILES.get(),        "orange_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), OttBlocks.ORANGE_MARBLE_PILLAR.get(),       "orange_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), OttBlocks.ORANGE_MARBLE_PILLAR_CAP.get(),   "orange_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), ModBlocks.ORANGE_MARBLE_FANCY_FENCE.get(),  "orange_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.ORANGE_MARBLE.get(), ModBlocks.ORANGE_MARBLE_FLOOR_TILE.get(),   "orange_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.ORANGE_MARBLE.get(), OttBlocks.ORANGE_MARBLE_DIAMOND_PAVERS.get(),  "orange_marble_diamond_pavers_stonecutting");
        // ── Pink Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), OttBlocks.PINK_MARBLE_BRICKS.get(),       "pink_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), OttBlocks.PINK_MARBLE_SMALL_BRICKS.get(), "pink_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), OttBlocks.PINK_MARBLE_TILES.get(),        "pink_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), OttBlocks.PINK_MARBLE_PILLAR.get(),       "pink_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), OttBlocks.PINK_MARBLE_PILLAR_CAP.get(),   "pink_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), ModBlocks.PINK_MARBLE_FANCY_FENCE.get(),  "pink_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.PINK_MARBLE.get(), ModBlocks.PINK_MARBLE_FLOOR_TILE.get(),   "pink_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.PINK_MARBLE.get(), OttBlocks.PINK_MARBLE_DIAMOND_PAVERS.get(),  "pink_marble_diamond_pavers_stonecutting");
        // ── Purple Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), OttBlocks.PURPLE_MARBLE_BRICKS.get(),       "purple_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), OttBlocks.PURPLE_MARBLE_SMALL_BRICKS.get(), "purple_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), OttBlocks.PURPLE_MARBLE_TILES.get(),        "purple_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), OttBlocks.PURPLE_MARBLE_PILLAR.get(),       "purple_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), OttBlocks.PURPLE_MARBLE_PILLAR_CAP.get(),   "purple_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), ModBlocks.PURPLE_MARBLE_FANCY_FENCE.get(),  "purple_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.PURPLE_MARBLE.get(), ModBlocks.PURPLE_MARBLE_FLOOR_TILE.get(),   "purple_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.PURPLE_MARBLE.get(), OttBlocks.PURPLE_MARBLE_DIAMOND_PAVERS.get(),  "purple_marble_diamond_pavers_stonecutting");
        // ── Red Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), OttBlocks.RED_MARBLE_BRICKS.get(),       "red_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), OttBlocks.RED_MARBLE_SMALL_BRICKS.get(), "red_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), OttBlocks.RED_MARBLE_TILES.get(),        "red_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), OttBlocks.RED_MARBLE_PILLAR.get(),       "red_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), OttBlocks.RED_MARBLE_PILLAR_CAP.get(),   "red_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), ModBlocks.RED_MARBLE_FANCY_FENCE.get(),  "red_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.RED_MARBLE.get(), ModBlocks.RED_MARBLE_FLOOR_TILE.get(),   "red_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.RED_MARBLE.get(), OttBlocks.RED_MARBLE_DIAMOND_PAVERS.get(),  "red_marble_diamond_pavers_stonecutting");
        // ── Yellow Marble stonecutting ──
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), OttBlocks.YELLOW_MARBLE_BRICKS.get(),       "yellow_marble_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), OttBlocks.YELLOW_MARBLE_SMALL_BRICKS.get(), "yellow_marble_small_bricks_stonecutting");
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), OttBlocks.YELLOW_MARBLE_TILES.get(),        "yellow_marble_tiles_stonecutting");
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), OttBlocks.YELLOW_MARBLE_PILLAR.get(),       "yellow_marble_pillar_stonecutting");
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), OttBlocks.YELLOW_MARBLE_PILLAR_CAP.get(),   "yellow_marble_pillar_cap_stonecutting");
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), ModBlocks.YELLOW_MARBLE_FANCY_FENCE.get(),  "yellow_marble_fancy_fence_stonecutting");
        stonecutMany(exporter, OttBlocks.YELLOW_MARBLE.get(), ModBlocks.YELLOW_MARBLE_FLOOR_TILE.get(),   "yellow_marble_floor_tile_stonecutting");
        stonecutOne(exporter,  OttBlocks.YELLOW_MARBLE.get(), OttBlocks.YELLOW_MARBLE_DIAMOND_PAVERS.get(),  "yellow_marble_diamond_pavers_stonecutting");
        stonecutOne(exporter, ModBlocks.PLAIN_LIMESTONE.get(), ModBlocks.MIXED_LIMESTONE_BRICKS.get(), "mixed_limestone_bricks_from_limestone_stonecutting");
        // --- Chiseled plastered stone from matching plastered stone ---
        ModBlocks.PATTERN_BLOCKS.get("plastered_stone").forEach((color, base) -> {
            var chiseled = ModBlocks.PATTERN_BLOCKS.get("chiseled_plastered_stone");
            if (chiseled != null && chiseled.containsKey(color))
                stonecutOne(exporter, base.get(), chiseled.get(color).get(), color + "_chiseled_plastered_stone_stonecutting");
        });
        // --- All wood structural shapes: ott wood sets (planks + log + wood + stripped) ---
        ModBlocks.WOOD_SETS.forEach((name, set) -> {
            woodcutStructural(exporter, set.planks().get(),       name + "_planks",       set);
            woodcutStructural(exporter, set.log().get(),          name + "_log",          set);
            woodcutStructural(exporter, set.wood().get(),         name + "_wood",         set);
            woodcutStructural(exporter, set.strippedLog().get(),  name + "_stripped_log", set);
            woodcutStructural(exporter, set.strippedWood().get(), name + "_stripped_wood",set);
        });
        // --- All wood structural shapes: vanilla + pale oak structural sets ---
        ModBlocks.VANILLA_STRUCTURAL_SETS.forEach((name, set) -> {
            switch (name) {
                case "pale_oak" -> {
                woodcutStructural(exporter, ModBlocks.PALE_OAK_PLANKS.get(),        name + "_planks",       set);
                woodcutStructural(exporter, ModBlocks.PALE_OAK_LOG.get(),           name + "_log",          set);
                woodcutStructural(exporter, ModBlocks.PALE_OAK_WOOD.get(),          name + "_wood",         set);
                woodcutStructural(exporter, ModBlocks.STRIPPED_PALE_OAK_LOG.get(),  name + "_stripped_log", set);
                woodcutStructural(exporter, ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), name + "_stripped_wood",set);
                }
                case "bamboo" -> {
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("bamboo_planks"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "bamboo_planks", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("bamboo_block"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "bamboo_block", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("stripped_bamboo_block"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "stripped_bamboo_block", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("bamboo_mosaic"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "bamboo_mosaic", set));
                }
                case "crimson", "warped" -> {
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace(name + "_planks"))
                        .ifPresent(b -> woodcutStructural(exporter, b, name + "_planks", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace(name + "_stem"))
                        .ifPresent(b -> woodcutStructural(exporter, b, name + "_stem", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace(name + "_hyphae"))
                        .ifPresent(b -> woodcutStructural(exporter, b, name + "_hyphae", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("stripped_" + name + "_stem"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "stripped_" + name + "_stem", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("stripped_" + name + "_hyphae"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "stripped_" + name + "_hyphae", set));
                }
                default -> {
                // Regular overworld wood (oak, spruce, birch, jungle, acacia, dark_oak, mangrove, cherry)
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace(name + "_planks"))
                        .ifPresent(b -> woodcutStructural(exporter, b, name + "_planks", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace(name + "_log"))
                        .ifPresent(b -> woodcutStructural(exporter, b, name + "_log", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace(name + "_wood"))
                        .ifPresent(b -> woodcutStructural(exporter, b, name + "_wood", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("stripped_" + name + "_log"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "stripped_" + name + "_log", set));
                BuiltInRegistries.BLOCK.getOptional(ResourceLocation.withDefaultNamespace("stripped_" + name + "_wood"))
                        .ifPresent(b -> woodcutStructural(exporter, b, "stripped_" + name + "_wood", set));
                }
            }
        });
    }

    private void stonecutOne(RecipeOutput exporter, ItemLike input, ItemLike output, String id) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output, 1)
                .unlockedBy("has_input", has(input))
                .save(exporter, getRecipePath("ott", id));
    }

    private void stonecutMany(RecipeOutput exporter, ItemLike input, ItemLike output, String id) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, output, 4)
                .unlockedBy("has_input", has(input))
                .save(exporter, getRecipePath("ott", id));
    }

    private void woodcutOne(RecipeOutput exporter, ItemLike input, ItemLike output, String id) {
        new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, WoodcuttingRecipe::new, Ingredient.of(input), output, 1)
                .unlockedBy("has_input", has(input))
                .save(exporter, getRecipePath("ott", id));
    }

    private void engraveOne(RecipeOutput exporter, ItemLike input, ItemLike output, String id) {
        new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, EngravingRecipe::new, Ingredient.of(input), output, 1)
                .unlockedBy("has_input", has(input))
                .save(exporter, getRecipePath("ott", id));
    }

    private void engraveTagged(RecipeOutput exporter, TagKey<Item> inputTag, ItemLike output, String id) {
        new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, EngravingRecipe::new, Ingredient.of(inputTag), output, 1)
                .unlockedBy("has_input", has(inputTag))
                .save(exporter, getRecipePath("ott", id));
    }

    /** Engraving recipe using a compound ingredient (group) — any member of the ingredient can be used as input. */
    private void engraveGroup(RecipeOutput exporter, Ingredient ingredient, ItemLike output, String id) {
        new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, EngravingRecipe::new, ingredient, output, 1)
                .unlockedBy("has_input", has(output))
                .save(exporter, getRecipePath("ott", id));
    }

    /**
     * Generates bidirectional engraving recipes for all stained glass material groups.
     * Each color has a group containing vanilla stained glass + all OTT block variants + all CTM pane variants.
     * Any member of the group can be used as input to obtain any other member.
     */
    private void stainedGlassGroupRecipes(RecipeOutput exporter) {
        // OTT block name → recipe ID (replaces the removed per-color individual recipes)
        String[][] blockTemplates = {
            {"arched_{c}_stained_glass_ctm",         "arched_{c}_stained_glass_pillar_engraving"},
            {"circular_{c}_stained_glass",            "circular_{c}_stained_glass_engraving"},
            {"fancy_{c}_stained_glass_ctm",           "fancy_{c}_stained_glass_pillar_engraving"},
            {"ornate_{c}_stained_glass_ctm",          "ornate_{c}_stained_glass_pillar_engraving"},
            {"raster_{c}_stained_glass_ctm",          "raster_{c}_stained_glass_pillar_engraving"},
            {"small_{c}_diamond_stained_glass",       "small_{c}_diamond_stained_glass_engraving"},
            {"tiled_{c}_stained_glass_ctm",           "tiled_{c}_stained_glass_pillar_engraving"},
            {"{c}_leaded_stained_glass",              "{c}_leaded_stained_glass_engraving"},
            {"fancy_{c}_stained_glass",               "fancy_{c}_stained_glass_engraving"},
            {"large_diamond_{c}_stained_glass",       "large_diamond_{c}_stained_glass_engraving"},
            {"ornate_{c}_stained_glass",              "ornate_{c}_stained_glass_engraving"},
            {"raster_{c}_stained_glass",              "raster_{c}_stained_glass_engraving"},
            {"small_{c}_stained_glass",               "small_{c}_stained_glass_engraving"},
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
            engraveGroup(exporter, group, vanillaGlass, c + "_stained_glass_from_group");

            // OTT blocks as outputs (same IDs as the removed individual recipes)
            for (String[] tpl : blockTemplates) {
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", tpl[0].replace("{c}", c)));
                if (b != Blocks.AIR) {
                    engraveGroup(exporter, group, b, tpl[1].replace("{c}", c));
                }
            }
            // CTM panes as outputs (same IDs as the removed section 3 recipes)
            for (String[] tpl : paneTemplates) {
                Block b = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", tpl[0].replace("{c}", c)));
                if (b != Blocks.AIR) {
                    engraveGroup(exporter, group, b, tpl[1].replace("{c}", c));
                }
            }
        }
    }

    private void engraveRecipes(RecipeOutput exporter) {
        // ── Stone → engraved stone variants ──────────────────────────────────────
        // ── New plain stone blocks ────────────────────────────────────────────────
        engraveOne(exporter, Blocks.STONE, ModBlocks.CHAOTIC_STONE_BRICKS,               "chaotic_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.CHAOTIC_MEDIUM_STONE_BRICKS,        "chaotic_medium_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.CHAOTIC_SMALL_STONE_BRICKS,         "chaotic_small_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.DIAMOND_STONE_PAVERS,               "diamond_stone_pavers_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.ENCASED_STONE_BRICKS,               "encased_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.FRENCH_STONE,                       "french_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.LARGE_ORNATE_STONE,                 "large_ornate_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.LARGE_STONE_TILE,                   "large_stone_tile_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.MESSY_STONE_TILES,                  "messy_stone_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.MOSAIC_STONE,                       "mosaic_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.NOTCHED_STONE_BRICKS,               "notched_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.ORNATE_STONE,                       "ornate_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.POISON_STONE,                       "poison_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.POLISHED_CUT_STONE,                 "polished_cut_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.POLISHED_STONE_TILES,               "polished_stone_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.PRISM_STONE,                        "prism_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.SLANTED_STONE,                      "slanted_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_ARRAY,                        "stone_array_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_BRAID,                        "stone_braid_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_DENT,                         "stone_dent_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_JELLYBEAN,                    "stone_jellybean_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_LAYERS,                       "stone_layers_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_PANEL,                        "stone_panel_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_ROAD,                         "stone_road_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_ZAG,                          "stone_zag_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.SUNKEN_STONE,                       "sunken_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.TRIPLE_STONE_BRICKS,                "triple_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.WEATHERED_STONE_BRICKS,             "weathered_stone_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.WEATHERED_TILED_STONE,              "weathered_tiled_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.WEAVER_STONE,                       "weaver_stone_engraving");
        // ── New carved/cut stone blocks ───────────────────────────────────────────
        engraveOne(exporter, Blocks.STONE, ModBlocks.CUT_STONE,                          "cut_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.ROUGH_CUT_STONE,                    "rough_cut_stone_engraving");
        // ── New stone pillars ─────────────────────────────────────────────────────
        engraveOne(exporter, Blocks.STONE, ModBlocks.SHEARED_STONE_PILLAR,               "sheared_stone_pillar_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.SLATED_STONE,                       "slated_stone_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_COLUMN,                       "stone_column_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_TWISTING_COLUMN,              "stone_twisting_column_engraving");
        // ── Chisel pillar blocks ──────────────────────────────────────────────────
        ModBlocks.CHISEL_PILLARS.forEach((name, block) ->
                engraveOne(exporter, Blocks.STONE, block, name + "_engraving"));
        // ── Legend blocks ─────────────────────────────────────────────────────────
        ModBlocks.CHISEL_LEGEND.forEach((name, block) ->
                engraveOne(exporter, Blocks.STONE, block, name + "_engraving"));

        // ── Stone bricks → masonry ────────────────────────────────────────────────
        engraveOne(exporter, Blocks.STONE_BRICKS, ModBlocks.STONE_BRICKS_MASONRY,          "stone_bricks_masonry_engraving");

        // ── Limestone → variants ──────────────────────────────────────────────────
        engraveOne(exporter, ModBlocks.PLAIN_LIMESTONE, ModBlocks.MIXED_LIMESTONE_BRICKS,  "mixed_limestone_bricks_engraving");
        engraveOne(exporter, ModBlocks.PLAIN_LIMESTONE, ModBlocks.LIMESTONE_MASONRY,       "limestone_masonry_engraving");

        // ── Smooth sandstone → mosaic + decorative ───────────────────────────────
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SANDSTONE_SLENDER_BRICKS,          "sandstone_slender_bricks_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN,"sandstone_slender_turquoise_pattern_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.AIR_MOSAIC_BORDER,                  "air_mosaic_border_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.AIR_MOSAIC_GEOMETRIC,               "air_mosaic_geometric_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.AIR_MOSAIC_PATTERN,                 "air_mosaic_pattern_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.AIR_MOSAIC_DELICATE,                "air_mosaic_delicate_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.AIR_MOSAIC_TRADITIONAL,             "air_mosaic_traditional_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.EARTH_MOSAIC_BORDER,                "earth_mosaic_border_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.EARTH_MOSAIC_GEOMETRIC,             "earth_mosaic_geometric_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.EARTH_MOSAIC_PATTERN,               "earth_mosaic_pattern_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.EARTH_MOSAIC_DELICATE,              "earth_mosaic_delicate_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.EARTH_MOSAIC_TRADITIONAL,           "earth_mosaic_traditional_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.FIRE_MOSAIC_BORDER,                 "fire_mosaic_border_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.FIRE_MOSAIC_GEOMETRIC,              "fire_mosaic_geometric_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.FIRE_MOSAIC_PATTERN,                "fire_mosaic_pattern_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.FIRE_MOSAIC_DELICATE,               "fire_mosaic_delicate_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.FIRE_MOSAIC_TRADITIONAL,            "fire_mosaic_traditional_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.WATER_MOSAIC_BORDER,                "water_mosaic_border_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.WATER_MOSAIC_GEOMETRIC,             "water_mosaic_geometric_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.WATER_MOSAIC_PATTERN,               "water_mosaic_pattern_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.WATER_MOSAIC_DELICATE,              "water_mosaic_delicate_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.WATER_MOSAIC_TRADITIONAL,           "water_mosaic_traditional_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SPIRIT_MOSAIC_BORDER,               "spirit_mosaic_border_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SPIRIT_MOSAIC_GEOMETRIC,            "spirit_mosaic_geometric_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SPIRIT_MOSAIC_PATTERN,              "spirit_mosaic_pattern_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SPIRIT_MOSAIC_DELICATE,             "spirit_mosaic_delicate_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.SPIRIT_MOSAIC_TRADITIONAL,          "spirit_mosaic_traditional_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.MOSAIC_FLOOR,                       "mosaic_floor_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.MOSAIC_FLOOR_DELICATE,              "mosaic_floor_delicate_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.MOSAIC_FLOOR_ROSETTE,               "mosaic_floor_rosette_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.ROMAN_FRESCO_RED,                   "roman_fresco_red_engraving");
        engraveOne(exporter, Blocks.SMOOTH_SANDSTONE, ModBlocks.ROMAN_FRESCO_BLACK,                 "roman_fresco_black_engraving");

        // ── Vanilla CTM blocks (one CTM variant each) ────────────────────────────

        // ── Vanilla pillar CTM blocks ────────────────────────────────────────────

        // ── White marble → variants ───────────────────────────────────────────────
        engraveOne(exporter, OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_BRICKS,       "white_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_SMALL_BRICKS, "white_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_TILES,        "white_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_POLISHED_MARBLE,     "white_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_PILLAR,       "white_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.WHITE_MARBLE, OttBlocks.WHITE_MARBLE_PILLAR_CAP,   "white_marble_pillar_cap_engraving");
        // ── Amethyst Marble engraving ──
        engraveOne(exporter, OttBlocks.AMETHYST_MARBLE, OttBlocks.AMETHYST_MARBLE_BRICKS,       "amethyst_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.AMETHYST_MARBLE, OttBlocks.AMETHYST_MARBLE_SMALL_BRICKS, "amethyst_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.AMETHYST_MARBLE, OttBlocks.AMETHYST_MARBLE_TILES,        "amethyst_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.AMETHYST_MARBLE, OttBlocks.AMETHYST_POLISHED_MARBLE,     "amethyst_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.AMETHYST_MARBLE, OttBlocks.AMETHYST_MARBLE_PILLAR,       "amethyst_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.AMETHYST_MARBLE, OttBlocks.AMETHYST_MARBLE_PILLAR_CAP,   "amethyst_marble_pillar_cap_engraving");
        // ── Blue Marble engraving ──
        engraveOne(exporter, OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_BRICKS,       "blue_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_SMALL_BRICKS, "blue_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_TILES,        "blue_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_POLISHED_MARBLE,     "blue_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_PILLAR,       "blue_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.BLUE_MARBLE, OttBlocks.BLUE_MARBLE_PILLAR_CAP,   "blue_marble_pillar_cap_engraving");
        // ── Cyan Marble engraving ──
        engraveOne(exporter, OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_BRICKS,       "cyan_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_SMALL_BRICKS, "cyan_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_TILES,        "cyan_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_POLISHED_MARBLE,     "cyan_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_PILLAR,       "cyan_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.CYAN_MARBLE, OttBlocks.CYAN_MARBLE_PILLAR_CAP,   "cyan_marble_pillar_cap_engraving");
        // ── Green Marble engraving ──
        engraveOne(exporter, OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_BRICKS,       "green_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_SMALL_BRICKS, "green_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_TILES,        "green_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_POLISHED_MARBLE,     "green_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_PILLAR,       "green_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.GREEN_MARBLE, OttBlocks.GREEN_MARBLE_PILLAR_CAP,   "green_marble_pillar_cap_engraving");
        // ── Lime Marble engraving ──
        engraveOne(exporter, OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_BRICKS,       "lime_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_SMALL_BRICKS, "lime_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_TILES,        "lime_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.LIME_MARBLE, OttBlocks.LIME_POLISHED_MARBLE,     "lime_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_PILLAR,       "lime_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.LIME_MARBLE, OttBlocks.LIME_MARBLE_PILLAR_CAP,   "lime_marble_pillar_cap_engraving");
        // ── Orange Marble engraving ──
        engraveOne(exporter, OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_BRICKS,       "orange_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_SMALL_BRICKS, "orange_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_TILES,        "orange_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_POLISHED_MARBLE,     "orange_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_PILLAR,       "orange_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.ORANGE_MARBLE, OttBlocks.ORANGE_MARBLE_PILLAR_CAP,   "orange_marble_pillar_cap_engraving");
        // ── Pink Marble engraving ──
        engraveOne(exporter, OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_BRICKS,       "pink_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_SMALL_BRICKS, "pink_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_TILES,        "pink_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.PINK_MARBLE, OttBlocks.PINK_POLISHED_MARBLE,     "pink_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_PILLAR,       "pink_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.PINK_MARBLE, OttBlocks.PINK_MARBLE_PILLAR_CAP,   "pink_marble_pillar_cap_engraving");
        // ── Purple Marble engraving ──
        engraveOne(exporter, OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_BRICKS,       "purple_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_SMALL_BRICKS, "purple_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_TILES,        "purple_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_POLISHED_MARBLE,     "purple_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_PILLAR,       "purple_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.PURPLE_MARBLE, OttBlocks.PURPLE_MARBLE_PILLAR_CAP,   "purple_marble_pillar_cap_engraving");
        // ── Red Marble engraving ──
        engraveOne(exporter, OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_BRICKS,       "red_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_SMALL_BRICKS, "red_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_TILES,        "red_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.RED_MARBLE, OttBlocks.RED_POLISHED_MARBLE,     "red_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_PILLAR,       "red_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.RED_MARBLE, OttBlocks.RED_MARBLE_PILLAR_CAP,   "red_marble_pillar_cap_engraving");
        // ── Yellow Marble engraving ──
        engraveOne(exporter, OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_BRICKS,       "yellow_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_SMALL_BRICKS, "yellow_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_TILES,        "yellow_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_POLISHED_MARBLE,     "yellow_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_PILLAR,       "yellow_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.YELLOW_MARBLE, OttBlocks.YELLOW_MARBLE_PILLAR_CAP,   "yellow_marble_pillar_cap_engraving");

        // ── Colored marble dye recipes (8 white marble + 1 dye → 8 colored marble) ──
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.AMETHYST_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.AMETHYST_SHARD)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "amethyst_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.BLUE_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.BLUE_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "blue_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.CYAN_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.CYAN_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "cyan_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.GREEN_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.GREEN_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "green_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.LIME_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.LIME_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "lime_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.ORANGE_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.ORANGE_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "orange_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.PINK_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.PINK_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "pink_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.PURPLE_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.PURPLE_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "purple_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.RED_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.RED_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "red_marble_from_dye"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, OttBlocks.YELLOW_MARBLE.get(), 8)
                .pattern("WWW").pattern("WDW").pattern("WWW")
                .define('W', OttBlocks.WHITE_MARBLE.get())
                .define('D', Items.YELLOW_DYE)
                .unlockedBy("has_white_marble", has(OttBlocks.WHITE_MARBLE.get()))
                .save(exporter, getRecipePath("ott", "yellow_marble_from_dye"));

        // ── Black marble → variants ───────────────────────────────────────────────
        engraveOne(exporter, OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_BRICKS,       "black_marble_bricks_engraving");
        engraveOne(exporter, OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_SMALL_BRICKS, "black_marble_small_bricks_engraving");
        engraveOne(exporter, OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_TILES,        "black_marble_tiles_engraving");
        engraveOne(exporter, OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_POLISHED_MARBLE,     "black_polished_marble_engraving");
        engraveOne(exporter, OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_PILLAR,       "black_marble_pillar_engraving");
        engraveOne(exporter, OttBlocks.BLACK_MARBLE, OttBlocks.BLACK_MARBLE_PILLAR_CAP,   "black_marble_pillar_cap_engraving");

        // ── White plastered stone → decorative variants ──────────────────────────
        Block whitePlastered = ModBlocks.PATTERN_BLOCKS.get("plastered_stone").get("white").get();
        engraveOne(exporter, whitePlastered,
                ModBlocks.PATTERN_BLOCKS.get("gilded_plastered_stone").get("white").get(),   "white_gilded_plastered_stone_engraving");
        engraveOne(exporter, whitePlastered,
                ModBlocks.PATTERN_BLOCKS.get("delicate_plastered_stone").get("white").get(), "white_delicate_plastered_stone_engraving");
        engraveOne(exporter, whitePlastered,
                ModBlocks.PATTERN_BLOCKS.get("banded_plastered_stone").get("white").get(),   "white_banded_plastered_stone_engraving");
        engraveOne(exporter, whitePlastered,
                ModBlocks.CHISELED_PLASTERED_STONE_PILLAR,                                   "chiseled_plastered_stone_pillar_engraving");

        // ── Wool → ornamented / delicate variants ─────────────────────────────────
        engraveOne(exporter, Blocks.RED_WOOL,    ModBlocks.ORNAMENTED_RED_WOOL,    "ornamented_red_wool_engraving");
        engraveOne(exporter, Blocks.RED_WOOL,    ModBlocks.DELICATE_RED_WOOL,      "delicate_red_wool_engraving");
        engraveOne(exporter, Blocks.BLUE_WOOL,   ModBlocks.ORNAMENTED_BLUE_WOOL,   "ornamented_blue_wool_engraving");
        engraveOne(exporter, Blocks.BLUE_WOOL,   ModBlocks.DELICATE_BLUE_WOOL,     "delicate_blue_wool_engraving");
        engraveOne(exporter, Blocks.GREEN_WOOL,  ModBlocks.ORNAMENTED_GREEN_WOOL,  "ornamented_green_wool_engraving");
        engraveOne(exporter, Blocks.GREEN_WOOL,  ModBlocks.DELICATE_GREEN_WOOL,    "delicate_green_wool_engraving");
        engraveOne(exporter, Blocks.PURPLE_WOOL, ModBlocks.ORNAMENTED_PURPLE_WOOL, "ornamented_purple_wool_engraving");
        engraveOne(exporter, Blocks.PURPLE_WOOL, ModBlocks.DELICATE_PURPLE_WOOL,   "delicate_purple_wool_engraving");

        // ── Wood door variants ────────────────────────────────────────────────────
        ModBlocks.WOOD_DOORS.forEach((wood, styleMap) -> {
            TagKey<Item> woodDoorsTag = TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/" + wood));
            styleMap.forEach((style, block) ->
                    engraveTagged(exporter, woodDoorsTag, block.get(), style + "_" + wood + "_door_engraving")
            );
        });

        // Extra wood doors, vanilla door/trapdoor outputs, and all trapdoors
        {
            // oak
            TagKey<Item> oakTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/oak"));
            engraveTagged(exporter, oakTag, Items.OAK_DOOR, "vanilla_oak_door_engraving");
            engraveTagged(exporter, oakTag, Items.OAK_TRAPDOOR, "vanilla_oak_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("japanese_oak_door").get(), "japanese_oak_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_bamboo_door").get(), "oak_bamboo_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_barn_door").get(), "oak_barn_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_beach_door").get(), "oak_beach_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_cottage_door").get(), "oak_cottage_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_four_panel_door").get(), "oak_four_panel_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_glass_door").get(), "oak_glass_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_japanese_door").get(), "oak_japanese_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_modern_door").get(), "oak_modern_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_mystic_door").get(), "oak_mystic_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_nether_door").get(), "oak_nether_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_paper_door").get(), "oak_paper_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_stable_door").get(), "oak_stable_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_swamp_door").get(), "oak_swamp_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_tropical_door").get(), "oak_tropical_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_waffle_door").get(), "oak_waffle_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_western_door").get(), "oak_western_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_whispering_door").get(), "oak_whispering_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_barn_glass_door").get(), "oak_barn_glass_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.EXTRA_DOORS.get("oak_stable_head_door").get(), "oak_stable_head_door_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_bamboo_trapdoor").get(), "oak_bamboo_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_barn_trapdoor").get(), "oak_barn_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_barred_trapdoor").get(), "oak_barred_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_beach_trapdoor").get(), "oak_beach_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_blossom_trapdoor").get(), "oak_blossom_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_cottage_trapdoor").get(), "oak_cottage_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_four_panel_trapdoor").get(), "oak_four_panel_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_glass_trapdoor").get(), "oak_glass_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_mystic_trapdoor").get(), "oak_mystic_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_paper_trapdoor").get(), "oak_paper_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_swamp_trapdoor").get(), "oak_swamp_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_tropical_trapdoor").get(), "oak_tropical_trapdoor_engraving");
            engraveTagged(exporter, oakTag, ModBlocks.WOOD_TRAPDOORS.get("oak_whispering_trapdoor").get(), "oak_whispering_trapdoor_engraving");
            // spruce
            TagKey<Item> spruceTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/spruce"));
            engraveTagged(exporter, spruceTag, Items.SPRUCE_DOOR, "vanilla_spruce_door_engraving");
            engraveTagged(exporter, spruceTag, Items.SPRUCE_TRAPDOOR, "vanilla_spruce_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("japanese_spruce_door").get(), "japanese_spruce_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_bamboo_door").get(), "spruce_bamboo_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_barn_door").get(), "spruce_barn_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_beach_door").get(), "spruce_beach_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_classic_door").get(), "spruce_classic_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_four_panel_door").get(), "spruce_four_panel_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_glass_door").get(), "spruce_glass_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_japanese_door").get(), "spruce_japanese_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_modern_door").get(), "spruce_modern_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_mystic_door").get(), "spruce_mystic_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_nether_door").get(), "spruce_nether_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_paper_door").get(), "spruce_paper_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_stable_door").get(), "spruce_stable_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_swamp_door").get(), "spruce_swamp_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_tropical_door").get(), "spruce_tropical_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_waffle_door").get(), "spruce_waffle_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_western_door").get(), "spruce_western_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_whispering_door").get(), "spruce_whispering_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_barn_glass_door").get(), "spruce_barn_glass_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.EXTRA_DOORS.get("spruce_stable_head_door").get(), "spruce_stable_head_door_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_bamboo_trapdoor").get(), "spruce_bamboo_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_barn_trapdoor").get(), "spruce_barn_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_barred_trapdoor").get(), "spruce_barred_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_barrel_trapdoor").get(), "spruce_barrel_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_beach_trapdoor").get(), "spruce_beach_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_blossom_trapdoor").get(), "spruce_blossom_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_classic_trapdoor").get(), "spruce_classic_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_four_panel_trapdoor").get(), "spruce_four_panel_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_glass_trapdoor").get(), "spruce_glass_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_mystic_trapdoor").get(), "spruce_mystic_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_paper_trapdoor").get(), "spruce_paper_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_swamp_trapdoor").get(), "spruce_swamp_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_tropical_trapdoor").get(), "spruce_tropical_trapdoor_engraving");
            engraveTagged(exporter, spruceTag, ModBlocks.WOOD_TRAPDOORS.get("spruce_whispering_trapdoor").get(), "spruce_whispering_trapdoor_engraving");
            // birch
            TagKey<Item> birchTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/birch"));
            engraveTagged(exporter, birchTag, Items.BIRCH_DOOR, "vanilla_birch_door_engraving");
            engraveTagged(exporter, birchTag, Items.BIRCH_TRAPDOOR, "vanilla_birch_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_bamboo_door").get(), "birch_bamboo_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_barn_door").get(), "birch_barn_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_beach_door").get(), "birch_beach_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_classic_door").get(), "birch_classic_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_cottage_door").get(), "birch_cottage_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_four_panel_door").get(), "birch_four_panel_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_glass_door").get(), "birch_glass_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_japanese_door").get(), "birch_japanese_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_modern_door").get(), "birch_modern_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_mystic_door").get(), "birch_mystic_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_nether_door").get(), "birch_nether_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_stable_door").get(), "birch_stable_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_swamp_door").get(), "birch_swamp_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_tropical_door").get(), "birch_tropical_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_waffle_door").get(), "birch_waffle_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_western_door").get(), "birch_western_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_whispering_door").get(), "birch_whispering_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("japanese_birch_door").get(), "japanese_birch_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_barn_glass_door").get(), "birch_barn_glass_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.EXTRA_DOORS.get("birch_stable_head_door").get(), "birch_stable_head_door_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_bamboo_trapdoor").get(), "birch_bamboo_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_barn_trapdoor").get(), "birch_barn_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_barred_trapdoor").get(), "birch_barred_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_barrel_trapdoor").get(), "birch_barrel_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_beach_trapdoor").get(), "birch_beach_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_blossom_trapdoor").get(), "birch_blossom_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_classic_trapdoor").get(), "birch_classic_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_cottage_trapdoor").get(), "birch_cottage_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_four_panel_trapdoor").get(), "birch_four_panel_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_glass_trapdoor").get(), "birch_glass_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_mystic_trapdoor").get(), "birch_mystic_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_swamp_trapdoor").get(), "birch_swamp_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_tropical_trapdoor").get(), "birch_tropical_trapdoor_engraving");
            engraveTagged(exporter, birchTag, ModBlocks.WOOD_TRAPDOORS.get("birch_whispering_trapdoor").get(), "birch_whispering_trapdoor_engraving");
            // jungle
            TagKey<Item> jungleTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/jungle"));
            engraveTagged(exporter, jungleTag, Items.JUNGLE_DOOR, "vanilla_jungle_door_engraving");
            engraveTagged(exporter, jungleTag, Items.JUNGLE_TRAPDOOR, "vanilla_jungle_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("japanese_jungle_door").get(), "japanese_jungle_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_bamboo_door").get(), "jungle_bamboo_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_barn_door").get(), "jungle_barn_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_classic_door").get(), "jungle_classic_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_cottage_door").get(), "jungle_cottage_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_four_panel_door").get(), "jungle_four_panel_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_glass_door").get(), "jungle_glass_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_japanese_door").get(), "jungle_japanese_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_modern_door").get(), "jungle_modern_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_mystic_door").get(), "jungle_mystic_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_nether_door").get(), "jungle_nether_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_paper_door").get(), "jungle_paper_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_stable_door").get(), "jungle_stable_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_swamp_door").get(), "jungle_swamp_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_tropical_door").get(), "jungle_tropical_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_waffle_door").get(), "jungle_waffle_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_western_door").get(), "jungle_western_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_whispering_door").get(), "jungle_whispering_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_barn_glass_door").get(), "jungle_barn_glass_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.EXTRA_DOORS.get("jungle_stable_head_door").get(), "jungle_stable_head_door_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_bamboo_trapdoor").get(), "jungle_bamboo_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_barn_trapdoor").get(), "jungle_barn_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_barred_trapdoor").get(), "jungle_barred_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_blossom_trapdoor").get(), "jungle_blossom_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_classic_trapdoor").get(), "jungle_classic_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_cottage_trapdoor").get(), "jungle_cottage_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_four_panel_trapdoor").get(), "jungle_four_panel_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_glass_trapdoor").get(), "jungle_glass_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_mystic_trapdoor").get(), "jungle_mystic_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_paper_trapdoor").get(), "jungle_paper_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_swamp_trapdoor").get(), "jungle_swamp_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_tropical_trapdoor").get(), "jungle_tropical_trapdoor_engraving");
            engraveTagged(exporter, jungleTag, ModBlocks.WOOD_TRAPDOORS.get("jungle_whispering_trapdoor").get(), "jungle_whispering_trapdoor_engraving");
            // acacia
            TagKey<Item> acaciaTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/acacia"));
            engraveTagged(exporter, acaciaTag, Items.ACACIA_DOOR, "vanilla_acacia_door_engraving");
            engraveTagged(exporter, acaciaTag, Items.ACACIA_TRAPDOOR, "vanilla_acacia_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_bamboo_door").get(), "acacia_bamboo_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_barn_door").get(), "acacia_barn_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_beach_door").get(), "acacia_beach_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_classic_door").get(), "acacia_classic_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_cottage_door").get(), "acacia_cottage_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_four_panel_door").get(), "acacia_four_panel_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_glass_door").get(), "acacia_glass_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_japanese_door").get(), "acacia_japanese_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_modern_door").get(), "acacia_modern_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_mystic_door").get(), "acacia_mystic_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_nether_door").get(), "acacia_nether_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_paper_door").get(), "acacia_paper_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_stable_door").get(), "acacia_stable_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_swamp_door").get(), "acacia_swamp_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_waffle_door").get(), "acacia_waffle_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_western_door").get(), "acacia_western_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_whispering_door").get(), "acacia_whispering_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("japanese_acacia_door").get(), "japanese_acacia_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_barn_glass_door").get(), "acacia_barn_glass_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.EXTRA_DOORS.get("acacia_stable_head_door").get(), "acacia_stable_head_door_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_bamboo_trapdoor").get(), "acacia_bamboo_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_barn_trapdoor").get(), "acacia_barn_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_barred_trapdoor").get(), "acacia_barred_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_barrel_trapdoor").get(), "acacia_barrel_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_beach_trapdoor").get(), "acacia_beach_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_blossom_trapdoor").get(), "acacia_blossom_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_classic_trapdoor").get(), "acacia_classic_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_cottage_trapdoor").get(), "acacia_cottage_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_four_panel_trapdoor").get(), "acacia_four_panel_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_glass_trapdoor").get(), "acacia_glass_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_mystic_trapdoor").get(), "acacia_mystic_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_paper_trapdoor").get(), "acacia_paper_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_swamp_trapdoor").get(), "acacia_swamp_trapdoor_engraving");
            engraveTagged(exporter, acaciaTag, ModBlocks.WOOD_TRAPDOORS.get("acacia_whispering_trapdoor").get(), "acacia_whispering_trapdoor_engraving");
            // dark_oak
            TagKey<Item> dark_oakTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/dark_oak"));
            engraveTagged(exporter, dark_oakTag, Items.DARK_OAK_DOOR, "vanilla_dark_oak_door_engraving");
            engraveTagged(exporter, dark_oakTag, Items.DARK_OAK_TRAPDOOR, "vanilla_dark_oak_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_bamboo_door").get(), "dark_oak_bamboo_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_barn_door").get(), "dark_oak_barn_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_beach_door").get(), "dark_oak_beach_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_classic_door").get(), "dark_oak_classic_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_cottage_door").get(), "dark_oak_cottage_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_glass_door").get(), "dark_oak_glass_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_japanese_door").get(), "dark_oak_japanese_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_modern_door").get(), "dark_oak_modern_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_mystic_door").get(), "dark_oak_mystic_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_nether_door").get(), "dark_oak_nether_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_paper_door").get(), "dark_oak_paper_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_stable_door").get(), "dark_oak_stable_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_swamp_door").get(), "dark_oak_swamp_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_tropical_door").get(), "dark_oak_tropical_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_waffle_door").get(), "dark_oak_waffle_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_western_door").get(), "dark_oak_western_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_whispering_door").get(), "dark_oak_whispering_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("japanese_dark_oak_door").get(), "japanese_dark_oak_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_barn_glass_door").get(), "dark_oak_barn_glass_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.EXTRA_DOORS.get("dark_oak_stable_head_door").get(), "dark_oak_stable_head_door_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_bamboo_trapdoor").get(), "dark_oak_bamboo_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_barn_trapdoor").get(), "dark_oak_barn_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_barred_trapdoor").get(), "dark_oak_barred_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_beach_trapdoor").get(), "dark_oak_beach_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_blossom_trapdoor").get(), "dark_oak_blossom_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_classic_trapdoor").get(), "dark_oak_classic_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_cottage_trapdoor").get(), "dark_oak_cottage_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_glass_trapdoor").get(), "dark_oak_glass_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_mystic_trapdoor").get(), "dark_oak_mystic_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_paper_trapdoor").get(), "dark_oak_paper_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_swamp_trapdoor").get(), "dark_oak_swamp_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_tropical_trapdoor").get(), "dark_oak_tropical_trapdoor_engraving");
            engraveTagged(exporter, dark_oakTag, ModBlocks.WOOD_TRAPDOORS.get("dark_oak_whispering_trapdoor").get(), "dark_oak_whispering_trapdoor_engraving");
            // mangrove
            TagKey<Item> mangroveTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/mangrove"));
            engraveTagged(exporter, mangroveTag, Items.MANGROVE_DOOR, "vanilla_mangrove_door_engraving");
            engraveTagged(exporter, mangroveTag, Items.MANGROVE_TRAPDOOR, "vanilla_mangrove_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("japanese_mangrove_door").get(), "japanese_mangrove_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_bamboo_door").get(), "mangrove_bamboo_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_barn_door").get(), "mangrove_barn_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_beach_door").get(), "mangrove_beach_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_classic_door").get(), "mangrove_classic_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_cottage_door").get(), "mangrove_cottage_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_four_panel_door").get(), "mangrove_four_panel_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_glass_door").get(), "mangrove_glass_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_japanese_door").get(), "mangrove_japanese_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_modern_door").get(), "mangrove_modern_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_mystic_door").get(), "mangrove_mystic_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_nether_door").get(), "mangrove_nether_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_paper_door").get(), "mangrove_paper_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_stable_door").get(), "mangrove_stable_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_tropical_door").get(), "mangrove_tropical_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_waffle_door").get(), "mangrove_waffle_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_western_door").get(), "mangrove_western_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_whispering_door").get(), "mangrove_whispering_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_barn_glass_door").get(), "mangrove_barn_glass_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.EXTRA_DOORS.get("mangrove_stable_head_door").get(), "mangrove_stable_head_door_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_bamboo_trapdoor").get(), "mangrove_bamboo_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_barn_trapdoor").get(), "mangrove_barn_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_barred_trapdoor").get(), "mangrove_barred_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_beach_trapdoor").get(), "mangrove_beach_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_blossom_trapdoor").get(), "mangrove_blossom_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_classic_trapdoor").get(), "mangrove_classic_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_cottage_trapdoor").get(), "mangrove_cottage_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_four_panel_trapdoor").get(), "mangrove_four_panel_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_glass_trapdoor").get(), "mangrove_glass_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_mystic_trapdoor").get(), "mangrove_mystic_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_paper_trapdoor").get(), "mangrove_paper_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_tropical_trapdoor").get(), "mangrove_tropical_trapdoor_engraving");
            engraveTagged(exporter, mangroveTag, ModBlocks.WOOD_TRAPDOORS.get("mangrove_whispering_trapdoor").get(), "mangrove_whispering_trapdoor_engraving");
            // cherry
            TagKey<Item> cherryTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/cherry"));
            engraveTagged(exporter, cherryTag, Items.CHERRY_DOOR, "vanilla_cherry_door_engraving");
            engraveTagged(exporter, cherryTag, Items.CHERRY_TRAPDOOR, "vanilla_cherry_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_bamboo_door").get(), "cherry_bamboo_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_barn_door").get(), "cherry_barn_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_beach_door").get(), "cherry_beach_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_classic_door").get(), "cherry_classic_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_cottage_door").get(), "cherry_cottage_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_four_panel_door").get(), "cherry_four_panel_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_glass_door").get(), "cherry_glass_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_japanese_door").get(), "cherry_japanese_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_modern_door").get(), "cherry_modern_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_mystic_door").get(), "cherry_mystic_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_nether_door").get(), "cherry_nether_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_paper_door").get(), "cherry_paper_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_stable_door").get(), "cherry_stable_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_swamp_door").get(), "cherry_swamp_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_tropical_door").get(), "cherry_tropical_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_western_door").get(), "cherry_western_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_whispering_door").get(), "cherry_whispering_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("japanese_cherry_door").get(), "japanese_cherry_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_barn_glass_door").get(), "cherry_barn_glass_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.EXTRA_DOORS.get("cherry_stable_head_door").get(), "cherry_stable_head_door_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_bamboo_trapdoor").get(), "cherry_bamboo_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_barn_trapdoor").get(), "cherry_barn_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_barred_trapdoor").get(), "cherry_barred_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_barrel_trapdoor").get(), "cherry_barrel_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_beach_trapdoor").get(), "cherry_beach_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_classic_trapdoor").get(), "cherry_classic_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_cottage_trapdoor").get(), "cherry_cottage_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_four_panel_trapdoor").get(), "cherry_four_panel_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_glass_trapdoor").get(), "cherry_glass_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_mystic_trapdoor").get(), "cherry_mystic_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_paper_trapdoor").get(), "cherry_paper_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_swamp_trapdoor").get(), "cherry_swamp_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_tropical_trapdoor").get(), "cherry_tropical_trapdoor_engraving");
            engraveTagged(exporter, cherryTag, ModBlocks.WOOD_TRAPDOORS.get("cherry_whispering_trapdoor").get(), "cherry_whispering_trapdoor_engraving");
            // bamboo
            TagKey<Item> bambooTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/bamboo"));
            engraveTagged(exporter, bambooTag, Items.BAMBOO_DOOR, "vanilla_bamboo_door_engraving");
            engraveTagged(exporter, bambooTag, Items.BAMBOO_TRAPDOOR, "vanilla_bamboo_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_barn_door").get(), "bamboo_barn_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_beach_door").get(), "bamboo_beach_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_classic_door").get(), "bamboo_classic_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_cottage_door").get(), "bamboo_cottage_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_four_panel_door").get(), "bamboo_four_panel_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_glass_door").get(), "bamboo_glass_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_japanese_door").get(), "bamboo_japanese_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_modern_door").get(), "bamboo_modern_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_mystic_door").get(), "bamboo_mystic_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_nether_door").get(), "bamboo_nether_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_paper_door").get(), "bamboo_paper_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_stable_door").get(), "bamboo_stable_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_swamp_door").get(), "bamboo_swamp_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_tropical_door").get(), "bamboo_tropical_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_waffle_door").get(), "bamboo_waffle_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_western_door").get(), "bamboo_western_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_whispering_door").get(), "bamboo_whispering_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("japanese_bamboo_door").get(), "japanese_bamboo_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_barn_glass_door").get(), "bamboo_barn_glass_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.EXTRA_DOORS.get("bamboo_stable_head_door").get(), "bamboo_stable_head_door_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_barn_trapdoor").get(), "bamboo_barn_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_barred_trapdoor").get(), "bamboo_barred_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_barrel_trapdoor").get(), "bamboo_barrel_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_beach_trapdoor").get(), "bamboo_beach_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_blossom_trapdoor").get(), "bamboo_blossom_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_classic_trapdoor").get(), "bamboo_classic_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_cottage_trapdoor").get(), "bamboo_cottage_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_four_panel_trapdoor").get(), "bamboo_four_panel_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_glass_trapdoor").get(), "bamboo_glass_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_mystic_trapdoor").get(), "bamboo_mystic_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_paper_trapdoor").get(), "bamboo_paper_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_swamp_trapdoor").get(), "bamboo_swamp_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_tropical_trapdoor").get(), "bamboo_tropical_trapdoor_engraving");
            engraveTagged(exporter, bambooTag, ModBlocks.WOOD_TRAPDOORS.get("bamboo_whispering_trapdoor").get(), "bamboo_whispering_trapdoor_engraving");
            // crimson
            TagKey<Item> crimsonTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/crimson"));
            engraveTagged(exporter, crimsonTag, Items.CRIMSON_DOOR, "vanilla_crimson_door_engraving");
            engraveTagged(exporter, crimsonTag, Items.CRIMSON_TRAPDOOR, "vanilla_crimson_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_bamboo_door").get(), "crimson_bamboo_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_barn_door").get(), "crimson_barn_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_beach_door").get(), "crimson_beach_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_classic_door").get(), "crimson_classic_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_cottage_door").get(), "crimson_cottage_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_four_panel_door").get(), "crimson_four_panel_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_glass_door").get(), "crimson_glass_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_japanese_door").get(), "crimson_japanese_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_modern_door").get(), "crimson_modern_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_mystic_door").get(), "crimson_mystic_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_paper_door").get(), "crimson_paper_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_stable_door").get(), "crimson_stable_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_swamp_door").get(), "crimson_swamp_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_tropical_door").get(), "crimson_tropical_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_waffle_door").get(), "crimson_waffle_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_western_door").get(), "crimson_western_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_whispering_door").get(), "crimson_whispering_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("japanese_crimson_door").get(), "japanese_crimson_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_barn_glass_door").get(), "crimson_barn_glass_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.EXTRA_DOORS.get("crimson_stable_head_door").get(), "crimson_stable_head_door_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_bamboo_trapdoor").get(), "crimson_bamboo_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_barn_trapdoor").get(), "crimson_barn_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_beach_trapdoor").get(), "crimson_beach_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_blossom_trapdoor").get(), "crimson_blossom_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_classic_trapdoor").get(), "crimson_classic_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_cottage_trapdoor").get(), "crimson_cottage_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_four_panel_trapdoor").get(), "crimson_four_panel_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_glass_trapdoor").get(), "crimson_glass_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_mystic_trapdoor").get(), "crimson_mystic_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_paper_trapdoor").get(), "crimson_paper_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_swamp_trapdoor").get(), "crimson_swamp_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_tropical_trapdoor").get(), "crimson_tropical_trapdoor_engraving");
            engraveTagged(exporter, crimsonTag, ModBlocks.WOOD_TRAPDOORS.get("crimson_whispering_trapdoor").get(), "crimson_whispering_trapdoor_engraving");
            // warped
            TagKey<Item> warpedTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/warped"));
            engraveTagged(exporter, warpedTag, Items.WARPED_DOOR, "vanilla_warped_door_engraving");
            engraveTagged(exporter, warpedTag, Items.WARPED_TRAPDOOR, "vanilla_warped_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("japanese_warped_door").get(), "japanese_warped_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_bamboo_door").get(), "warped_bamboo_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_barn_door").get(), "warped_barn_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_beach_door").get(), "warped_beach_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_classic_door").get(), "warped_classic_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_cottage_door").get(), "warped_cottage_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_four_panel_door").get(), "warped_four_panel_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_glass_door").get(), "warped_glass_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_japanese_door").get(), "warped_japanese_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_modern_door").get(), "warped_modern_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_nether_door").get(), "warped_nether_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_paper_door").get(), "warped_paper_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_stable_door").get(), "warped_stable_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_swamp_door").get(), "warped_swamp_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_tropical_door").get(), "warped_tropical_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_waffle_door").get(), "warped_waffle_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_western_door").get(), "warped_western_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_whispering_door").get(), "warped_whispering_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_barn_glass_door").get(), "warped_barn_glass_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.EXTRA_DOORS.get("warped_stable_head_door").get(), "warped_stable_head_door_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_bamboo_trapdoor").get(), "warped_bamboo_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_barn_trapdoor").get(), "warped_barn_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_barred_trapdoor").get(), "warped_barred_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_barrel_trapdoor").get(), "warped_barrel_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_beach_trapdoor").get(), "warped_beach_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_blossom_trapdoor").get(), "warped_blossom_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_classic_trapdoor").get(), "warped_classic_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_cottage_trapdoor").get(), "warped_cottage_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_four_panel_trapdoor").get(), "warped_four_panel_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_glass_trapdoor").get(), "warped_glass_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_paper_trapdoor").get(), "warped_paper_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_swamp_trapdoor").get(), "warped_swamp_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_tropical_trapdoor").get(), "warped_tropical_trapdoor_engraving");
            engraveTagged(exporter, warpedTag, ModBlocks.WOOD_TRAPDOORS.get("warped_whispering_trapdoor").get(), "warped_whispering_trapdoor_engraving");
            // pale_oak
            TagKey<Item> pale_oakTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/pale_oak"));
            engraveTagged(exporter, pale_oakTag, ModBlocks.PALE_OAK_DOOR.asItem(), "vanilla_pale_oak_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.PALE_OAK_TRAPDOOR.asItem(), "vanilla_pale_oak_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("japanese_pale_oak_door").get(), "japanese_pale_oak_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_bamboo_door").get(), "pale_oak_bamboo_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_barn_door").get(), "pale_oak_barn_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_beach_door").get(), "pale_oak_beach_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_classic_door").get(), "pale_oak_classic_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_cottage_door").get(), "pale_oak_cottage_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_four_panel_door").get(), "pale_oak_four_panel_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_glass_door").get(), "pale_oak_glass_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_japanese_door").get(), "pale_oak_japanese_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_modern_door").get(), "pale_oak_modern_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_mystic_door").get(), "pale_oak_mystic_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_nether_door").get(), "pale_oak_nether_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_paper_door").get(), "pale_oak_paper_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_stable_door").get(), "pale_oak_stable_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_swamp_door").get(), "pale_oak_swamp_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_tropical_door").get(), "pale_oak_tropical_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_waffle_door").get(), "pale_oak_waffle_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_western_door").get(), "pale_oak_western_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_barn_glass_door").get(), "pale_oak_barn_glass_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.EXTRA_DOORS.get("pale_oak_stable_head_door").get(), "pale_oak_stable_head_door_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_bamboo_trapdoor").get(), "pale_oak_bamboo_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_barn_trapdoor").get(), "pale_oak_barn_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_barred_trapdoor").get(), "pale_oak_barred_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_beach_trapdoor").get(), "pale_oak_beach_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_blossom_trapdoor").get(), "pale_oak_blossom_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_classic_trapdoor").get(), "pale_oak_classic_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_cottage_trapdoor").get(), "pale_oak_cottage_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_four_panel_trapdoor").get(), "pale_oak_four_panel_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_glass_trapdoor").get(), "pale_oak_glass_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_mystic_trapdoor").get(), "pale_oak_mystic_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_paper_trapdoor").get(), "pale_oak_paper_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_swamp_trapdoor").get(), "pale_oak_swamp_trapdoor_engraving");
            engraveTagged(exporter, pale_oakTag, ModBlocks.WOOD_TRAPDOORS.get("pale_oak_tropical_trapdoor").get(), "pale_oak_tropical_trapdoor_engraving");
        }
    
        // ── Batch CTM blocks ─────────────────────────────────────────────
        // Acacia Planks

        // Amethyst Block

        // Ancient Debris

        // Andesite

        // Bamboo Planks

        // Basalt

        // Birch Planks

        // Blackstone

        // Black Concrete


        // Black Terracotta

        // Black Wool

        // Blue Concrete

        // Blue Ice


        // Blue Terracotta

        // Blue Wool

        // Borderless Bricks

        // Bricks

        // Brown Concrete


        // Brown Terracotta

        // Brown Wool

        // Calcite

        // Cherry Planks
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CORNERED_CHERRY_PLANKS, "cornered_cherry_planks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CRATED_CHERRY_PLANKS, "crated_cherry_planks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.ENCLOSED_CHERRY_PLANKS, "enclosed_cherry_planks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.FRAMED_CHERRY_PLANKS, "framed_cherry_planks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.NATURAL_CHERRY_PLANKS, "natural_cherry_planks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.PEGGED_CHERRY_PLANKS, "pegged_cherry_planks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.WHIRLWIND_CHERRY_PLANKS, "whirlwind_cherry_planks_engraving");

        // Clay

        // Coal Block

        // Cobblestone

        // Crimson Planks
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CORNERED_CRIMSON_PLANKS, "cornered_crimson_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRATED_CRIMSON_PLANKS, "crated_crimson_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.ENCLOSED_CRIMSON_PLANKS, "enclosed_crimson_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.FRAMED_CRIMSON_PLANKS, "framed_crimson_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.NATURAL_CRIMSON_PLANKS, "natural_crimson_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.PEGGED_CRIMSON_PLANKS, "pegged_crimson_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.WHIRLWIND_CRIMSON_PLANKS, "whirlwind_crimson_planks_engraving");

        // Crying Obsidian

        // Cyan Concrete


        // Cyan Terracotta

        // Cyan Wool

        // Dark Oak Planks
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.CORNERED_DARK_OAK_PLANKS, "cornered_dark_oak_planks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.CRATED_DARK_OAK_PLANKS, "crated_dark_oak_planks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.ENCLOSED_DARK_OAK_PLANKS, "enclosed_dark_oak_planks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.FRAMED_DARK_OAK_PLANKS, "framed_dark_oak_planks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.NATURAL_DARK_OAK_PLANKS, "natural_dark_oak_planks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.PEGGED_DARK_OAK_PLANKS, "pegged_dark_oak_planks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.WHIRLWIND_DARK_OAK_PLANKS, "whirlwind_dark_oak_planks_engraving");

        // Dark Prismarine

        // Deepslate

        // Diorite

        // Dirt

        // Dripstone

        // End Stone

        // Gilded Blackston

        // Granite

        // Gray Concrete


        // Gray Terracotta

        // Gray Wool

        // Green Concrete


        // Green Terracotta

        // Green Wool

        // Ice

        // Jungle Planks
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.CORNERED_JUNGLE_PLANKS, "cornered_jungle_planks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.CRATED_JUNGLE_PLANKS, "crated_jungle_planks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.ENCLOSED_JUNGLE_PLANKS, "enclosed_jungle_planks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.FRAMED_JUNGLE_PLANKS, "framed_jungle_planks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.NATURAL_JUNGLE_PLANKS, "natural_jungle_planks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.PEGGED_JUNGLE_PLANKS, "pegged_jungle_planks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.WHIRLWIND_JUNGLE_PLANKS, "whirlwind_jungle_planks_engraving");

        // Lapis Block

        // Leaded Glass
        engraveOne(exporter, Blocks.GLASS, ModBlocks.CIRCULAR_LEADED_STAINED_GLASS, "circular_leaded_stained_glass_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.ORNATE_LEADED_GLASS_CTM, "ornate_leaded_glass_pillar_engraving");

        // Light Blue Concrete


        // Light Blue Terracotta

        // Light Blue Wool

        // Light Gray Concrete


        // Light Gray Terracotta

        // Light Gray Wool

        // Lime Concrete


        // Lime Terracotta

        // Lime Wool

        // Lodestone

        // Magenta Concrete


        // Magenta Terracotta

        // Magenta Wool

        // Magma Block

        // Mangrove Planks
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.BRICKED_MANGROVE_PLANKS, "bricked_mangrove_planks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.CORNERED_MANGROVE_PLANKS, "cornered_mangrove_planks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.CRATED_MANGROVE_PLANKS, "crated_mangrove_planks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.ENCLOSED_MANGROVE_PLANKS, "enclosed_mangrove_planks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.FRAMED_MANGROVE_PLANKS, "framed_mangrove_planks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.NATURAL_MANGROVE_PLANKS, "natural_mangrove_planks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.PEGGED_MANGROVE_PLANKS, "pegged_mangrove_planks_engraving");

        // Mossy Cobblestone

        // Mossy Stone

        // Mud

        // Mud Bricks

        // Netherrack

        // Nether Bricks

        // Oak Glass
        // Oak Glass Panes
        engraveOne(exporter, ModBlocks.CHISELED_GLASS.get(), ModBlocks.CHISELED_GLASS_CTM_PANE.get(), "chiseled_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.CLEAR_GLASS.get(), ModBlocks.CLEAR_GLASS_CTM_PANE.get(), "clear_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.DIRTY_GLASS.get(), ModBlocks.DIRTY_GLASS_CTM_PANE.get(), "dirty_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.FROSTED_GLASS.get(), ModBlocks.FROSTED_GLASS_CTM_PANE.get(), "frosted_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.ICE_GLASS.get(), ModBlocks.ICE_GLASS_CTM_PANE.get(), "ice_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.OBSIDIAN_FRAMED_GLASS.get(), ModBlocks.OBSIDIAN_FRAMED_GLASS_CTM_PANE.get(), "obsidian_framed_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.REINFORCED_GLASS.get(), ModBlocks.REINFORCED_GLASS_CTM_PANE.get(), "reinforced_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.SANDSTONE_FRAMED_GLASS.get(), ModBlocks.SANDSTONE_FRAMED_GLASS_CTM_PANE.get(), "sandstone_framed_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.STONE_FRAMED_GLASS.get(), ModBlocks.STONE_FRAMED_GLASS_CTM_PANE.get(), "stone_framed_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.TINTED_CLEAR_GLASS.get(), ModBlocks.TINTED_CLEAR_GLASS_CTM_PANE.get(), "tinted_clear_glass_ctm_pane_engraving");
        engraveOne(exporter, ModBlocks.TINTED_GLASS.get(), ModBlocks.TINTED_GLASS_CTM_PANE.get(), "tinted_glass_ctm_pane_engraving");

        // Oak Planks

        // Obsidian

        // Orange Concrete


        // Orange Terracotta

        // Orange Wool

        // Packed Ice

        // Packed Mud

        // Pink Concrete


        // Pink Terracotta

        // Pink Wool

        // Prismarine

        // Purple Concrete


        // Purple Terracotta

        // Purple Wool

        // Purpur Block

        // Quartz Block

        // Raw Copper Block

        // Raw Gold Block

        // Raw Iron Block

        // Redstone Block

        // Red Concrete

        // Red Nether Bricks

        // Red Sandstone


        // Red Terracotta

        // Red Wool

        // Sandstone

        // Smooth Stone

        // Snow Block

        // Spruce Planks
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.CORNERED_SPRUCE_PLANKS, "cornered_spruce_planks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.CRATED_SPRUCE_PLANKS, "crated_spruce_planks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.ENCLOSED_SPRUCE_PLANKS, "enclosed_spruce_planks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.FRAMED_SPRUCE_PLANKS, "framed_spruce_planks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.NATURAL_SPRUCE_PLANKS, "natural_spruce_planks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.PEGGED_SPRUCE_PLANKS, "pegged_spruce_planks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.WHIRLWIND_SPRUCE_PLANKS, "whirlwind_spruce_planks_engraving");

        // Terracotta

        // Tuff

        // Warped Planks
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.CORNERED_WARPED_PLANKS, "cornered_warped_planks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.CRATED_WARPED_PLANKS, "crated_warped_planks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.ENCLOSED_WARPED_PLANKS, "enclosed_warped_planks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.FRAMED_WARPED_PLANKS, "framed_warped_planks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.NATURAL_WARPED_PLANKS, "natural_warped_planks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.PEGGED_WARPED_PLANKS, "pegged_warped_planks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WHIRLWIND_WARPED_PLANKS, "whirlwind_warped_planks_engraving");

        // White Concrete


        // White Terracotta

        // White Wool

        // Yellow Concrete


        // Yellow Terracotta

        // Yellow Wool


        // ── New CTM compact/full/simple/horizontal block engraving recipes ──────
        // Blocks.ACACIA_PLANKS

        // Blocks.AMETHYST_BLOCK

        // Blocks.ANDESITE

        // Blocks.BAMBOO_PLANKS

        // Blocks.BASALT

        // Blocks.BIRCH_PLANKS

        // Blocks.BLACKSTONE

        // Blocks.BLUE_ICE

        // Blocks.BONE_BLOCK



        // Blocks.CALCITE

        // Blocks.CHERRY_PLANKS

        // Blocks.COAL_BLOCK


        // Blocks.COBBLED_DEEPSLATE


        // Blocks.COBBLESTONE


        // Blocks.COPPER_BLOCK
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK.get(), "copper_block_engraving");

        // Blocks.COPPER_GRATE
        engraveOne(exporter, Blocks.COPPER_GRATE, ModBlocks.COPPER_GRATE.get(), "copper_grate_engraving");

        // Blocks.CRIMSON_PLANKS

        // Blocks.DARK_OAK_PLANKS

        // Blocks.DEEPSLATE

        // Blocks.DIORITE

        // Blocks.EMERALD_BLOCK

        // Blocks.END_STONE

        // Blocks.EXPOSED_COPPER
        engraveOne(exporter, Blocks.EXPOSED_COPPER, ModBlocks.EXPOSED_COPPER_BLOCK.get(), "exposed_copper_block_engraving");

        // Blocks.EXPOSED_COPPER_GRATE
        engraveOne(exporter, Blocks.EXPOSED_COPPER_GRATE, ModBlocks.EXPOSED_COPPER_GRATE.get(), "exposed_copper_grate_engraving");

        // Blocks.GOLD_BLOCK

        // Blocks.GRANITE

        // Blocks.IRON_BLOCK

        // Blocks.JUNGLE_PLANKS

        // Blocks.LAPIS_BLOCK


        // ModBlocks.MIXED_LIMESTONE_BRICKS

        // Blocks.MANGROVE_PLANKS

        // Blocks.MOSSY_COBBLESTONE

        // Blocks.NETHERITE_BLOCK


        // Blocks.NETHERRACK

        // Blocks.NETHER_BRICKS

        // Blocks.OAK_PLANKS

        // Blocks.OBSIDIAN

        // Blocks.OXIDIZED_COPPER
        engraveOne(exporter, Blocks.OXIDIZED_COPPER, ModBlocks.OXIDIZED_COPPER_BLOCK.get(), "oxidized_copper_block_engraving");

        // Blocks.OXIDIZED_COPPER_GRATE
        engraveOne(exporter, Blocks.OXIDIZED_COPPER_GRATE, ModBlocks.OXIDIZED_COPPER_GRATE.get(), "oxidized_copper_grate_engraving");

        // Blocks.POLISHED_BASALT

        // Blocks.POLISHED_DEEPSLATE

        // Blocks.SANDSTONE

        // Blocks.TUFF

        // Blocks.QUARTZ_BLOCK

        // Blocks.REDSTONE_BLOCK

        // Blocks.RED_SANDSTONE

        // Blocks.SPRUCE_PLANKS

        // Blocks.STONE

        // Blocks.WARPED_PLANKS

        // Blocks.WEATHERED_COPPER
        engraveOne(exporter, Blocks.WEATHERED_COPPER, ModBlocks.WEATHERED_COPPER_BLOCK.get(), "weathered_copper_block_engraving");

        // Blocks.WEATHERED_COPPER_GRATE
        engraveOne(exporter, Blocks.WEATHERED_COPPER_GRATE, ModBlocks.WEATHERED_COPPER_GRATE.get(), "weathered_copper_grate_engraving");

        // ── Bookshelves (1:1 exchange group — any bookshelf ↔ any bookshelf) ──────
        engraveTagged(exporter, ModTags.ItemTags.BOOKSHELVES, net.minecraft.world.item.Items.BOOKSHELF, "bookshelf_engraving");
        ModBlocks.BOOKSHELVES.forEach((name, block) ->
                engraveTagged(exporter, ModTags.ItemTags.BOOKSHELVES, block, name + "_engraving"));


}

    // ── CTM Pane recipes (new batch) ──────────────────────────────────────────
    private void ctmPaneRecipes(RecipeOutput exporter) {
        // 1. Plain glass CTM panes (engraved from vanilla glass)
        engraveOne(exporter, Blocks.GLASS, ModBlocks.SCRATCHED_GLASS_CTM_PANE,         "scratched_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.BORDERLESS_GLASS_CTM_PANE,        "borderless_glass_ctm_pane_engraving");
        paneFrom6(exporter, ModBlocks.SCRATCHED_GLASS,       ModBlocks.SCRATCHED_GLASS_CTM_PANE,        "scratched_glass_ctm_pane_from_block");
        paneFrom6(exporter, ModBlocks.BORDERLESS_GLASS,      ModBlocks.BORDERLESS_GLASS_CTM_PANE,       "borderless_glass_ctm_pane_from_block");

        // 2. Tinted borderless CTM pane (engraved from vanilla tinted glass)
        engraveOne(exporter, Blocks.TINTED_GLASS, ModBlocks.TINTED_BORDERLESS_GLASS_CTM_PANE, "tinted_borderless_glass_ctm_pane_engraving");
        paneFrom6(exporter, ModBlocks.TINTED_BORDERLESS_GLASS, ModBlocks.TINTED_BORDERLESS_GLASS_CTM_PANE, "tinted_borderless_glass_ctm_pane_from_block");

        // 3. Per-color stained glass CTM panes are now handled inside stainedGlassGroupRecipes().
        // 3.5 Tinted-coloured CTM panes (separate from stained glass group — base is tinted glass)
        for (DyeColor color : DyeColor.values()) {
            String c = color.getName();
            String paneName = "tinted_borderless_glass_" + c + "_ctm_pane";
            Block pane = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", paneName));
            if (pane != Blocks.AIR) {
                engraveOne(exporter, Blocks.TINTED_GLASS, pane, paneName + "_engraving");
            }
        }

        // 4. Wood window CTM panes (engraved from planks, crafted 6→16 from the CTM block)
        String[] styles = {"bars", "covered", "diagonal", "large", "panes", "rounded", "slim", "swirling", "tiles"};
        String[] woods  = {"oak", "acacia", "birch", "jungle", "dark_oak", "spruce", "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak"};
        for (String wood : woods) {
            Block planks = BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(wood + "_planks"));
            for (String style : styles) {
                engravePaneFromBlock(exporter, planks,
                    wood + "_window_" + style + "_ctm",
                    wood + "_window_" + style + "_ctm_pane");
            }
        }

    }

    /** Recovered block engraving recipes (appended per recovery wave). */
    private void recoveredWaveRecipes(RecipeOutput exporter) {
        // --- granite (Wave 0) ---
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.BORDERED_GRANITE, "bordered_granite_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.BRICK_BORDERED_GRANITE, "brick_bordered_granite_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.CURLY_GRANITE_CTM, "curly_granite_pillar_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.CUT_GRANITE_COLUMN, "cut_granite_column_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.EDGED_GRANITE_BRICKS, "edged_granite_bricks_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.FINE_GRANITE_CTM, "fine_granite_pillar_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_PRISMARINE, "granite_prismarine_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.MASSIVE_GRANITE_BRICKS, "massive_granite_bricks_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.ORNATE_GRANITE_CTM, "ornate_granite_pillar_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.OVERLAPPING_GRANITE_TILES, "overlapping_granite_tiles_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.SIMPLE_GRANITE_CTM, "simple_granite_pillar_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.SMOOTH_GRANITE_COLUMN, "smooth_granite_column_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.THICK_INLAYED_GRANITE, "thick_inlayed_granite_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.TILED_BORDERED_GRANITE, "tiled_bordered_granite_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.TILED_GRANITE_COLUMN, "tiled_granite_column_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.TINY_BRICK_BORDERED_GRANITE, "tiny_brick_bordered_granite_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_BRICKS.get(), "granite_bricks_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_BRICK_PATTERN.get(), "granite_brick_pattern_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_BRICK_PAVING.get(), "granite_brick_paving_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_CUT_POLISHED.get(), "granite_cut_polished_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_CUT_SMALL_BRICK.get(), "granite_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_DIAGONAL_BRICKS.get(), "granite_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_DOTTED.get(), "granite_dotted_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_PAVING.get(), "granite_paving_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_POLISHED.get(), "granite_polished_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_ROTATED_BRICKS.get(), "granite_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_SQUARES.get(), "granite_squares_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_TILES.get(), "granite_tiles_engraving");
        engraveOne(exporter, Blocks.GRANITE, ModBlocks.GRANITE_WAVY.get(), "granite_wavy_engraving");
        // --- RECOVERED WAVE1 ---
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_BEAMS.get(), "acacia_planks_beams_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_BRICK_PATTERN.get(), "acacia_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_BRICK_PAVING.get(), "acacia_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_BRICKS.get(), "acacia_planks_bricks_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_CRATE.get(), "acacia_planks_crate_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_DIAGONAL_STRIPES.get(), "acacia_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_DIAGONAL_TILES.get(), "acacia_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_DOTTED.get(), "acacia_planks_dotted_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_FLOORING.get(), "acacia_planks_flooring_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_LARGE_TILES.get(), "acacia_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_PANEL, "acacia_planks_panel_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_PATTERN.get(), "acacia_planks_pattern_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_ROTATED_BRICKS.get(), "acacia_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_SMALL_BRICKS.get(), "acacia_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_SMALL_TILES.get(), "acacia_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_SQUARES.get(), "acacia_planks_squares_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_TILES.get(), "acacia_planks_tiles_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_WAVY.get(), "acacia_planks_wavy_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS_WOVEN.get(), "acacia_planks_woven_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_BEAMS.get(), "amethyst_block_beams_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES.get(), "amethyst_block_bordered_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_BRICKS.get(), "amethyst_block_bricks_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_CTM.get(), "amethyst_block_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_CUT.get(), "amethyst_block_cut_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_EDGED.get(), "amethyst_block_edged_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_POLISHED.get(), "amethyst_block_polished_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_SHINY.get(), "amethyst_block_shiny_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK_TILES.get(), "amethyst_block_tiles_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_BRICK_PATTERN.get(), "andesite_brick_pattern_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_BRICK_PAVING.get(), "andesite_brick_paving_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_BRICKS.get(), "andesite_bricks_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_CUT_POLISHED.get(), "andesite_cut_polished_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_CUT_SMALL_BRICK.get(), "andesite_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_DIAGONAL_BRICKS.get(), "andesite_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_DOTTED.get(), "andesite_dotted_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_PAVING.get(), "andesite_paving_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_POLISHED.get(), "andesite_polished_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_ROTATED_BRICKS.get(), "andesite_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_SQUARES.get(), "andesite_squares_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_TILES.get(), "andesite_tiles_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ANDESITE_WAVY.get(), "andesite_wavy_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.ARCHED_LEADED_GLASS_CTM, "arched_leaded_glass_pillar_engraving");
        engraveOne(exporter, ModBlocks.ARCHED_LEADED_GLASS_CTM.get(), ModBlocks.ARCHED_LEADED_GLASS_CTM_PANE.get(), "arched_leaded_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_BEAMS.get(), "bamboo_planks_beams_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_BRICK_PATTERN.get(), "bamboo_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_BRICK_PAVING.get(), "bamboo_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_BRICKS.get(), "bamboo_planks_bricks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_CRATE.get(), "bamboo_planks_crate_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_DIAGONAL_STRIPES.get(), "bamboo_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_DIAGONAL_TILES.get(), "bamboo_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_DOTTED.get(), "bamboo_planks_dotted_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_FLOORING.get(), "bamboo_planks_flooring_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_LARGE_TILES.get(), "bamboo_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_PANEL, "bamboo_planks_panel_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_PATTERN.get(), "bamboo_planks_pattern_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_ROTATED_BRICKS.get(), "bamboo_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_SMALL_BRICKS.get(), "bamboo_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_SMALL_TILES.get(), "bamboo_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_SQUARES.get(), "bamboo_planks_squares_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_TILES.get(), "bamboo_planks_tiles_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_WAVY.get(), "bamboo_planks_wavy_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS_WOVEN.get(), "bamboo_planks_woven_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_BEAMS.get(), "basalt_beams_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_BORDERED.get(), "basalt_bordered_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_BORDERED_POLISHED.get(), "basalt_bordered_polished_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_BRICKS.get(), "basalt_bricks_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_DIAGONAL_TILES.get(), "basalt_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_PATTERN.get(), "basalt_pattern_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_PATTERNED.get(), "basalt_patterned_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BASALT_TILES.get(), "basalt_tiles_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_BEAMS.get(), "birch_planks_beams_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_BRICK_PATTERN.get(), "birch_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_BRICK_PAVING.get(), "birch_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_BRICKS.get(), "birch_planks_bricks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_CRATE.get(), "birch_planks_crate_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_DIAGONAL_STRIPES.get(), "birch_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_DIAGONAL_TILES.get(), "birch_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_DOTTED.get(), "birch_planks_dotted_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_FLOORING.get(), "birch_planks_flooring_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_LARGE_TILES.get(), "birch_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_PANEL, "birch_planks_panel_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_PATTERN.get(), "birch_planks_pattern_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_ROTATED_BRICKS.get(), "birch_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_SMALL_BRICKS.get(), "birch_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_SMALL_TILES.get(), "birch_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_SQUARES.get(), "birch_planks_squares_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_TILES.get(), "birch_planks_tiles_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_WAVY.get(), "birch_planks_wavy_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS_WOVEN.get(), "birch_planks_woven_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.BLACK_CONCRETE_CTM, "black_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.BLACK_CONCRETE_PANEL, "black_concrete_panel_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.BLACK_TERRACOTTA_COLUMN, "black_terracotta_column_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.BLACK_TERRACOTTA_CTM, "black_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BLACKSTONE_BRICK_PATTERN.get(), "blackstone_brick_pattern_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BLACKSTONE_BRICK_PAVING.get(), "blackstone_brick_paving_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BLACKSTONE_DIAGONAL_BRICKS.get(), "blackstone_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BLACKSTONE_POLISHED.get(), "blackstone_polished_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BLACKSTONE_ROTATED_BRICKS.get(), "blackstone_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BLACKSTONE_TILES.get(), "blackstone_tiles_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.BLUE_CONCRETE_CTM, "blue_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.BLUE_CONCRETE_PANEL, "blue_concrete_panel_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_BORDERED.get(), "blue_ice_bordered_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_BRICKS.get(), "blue_ice_bricks_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_CHISELED.get(), "blue_ice_chiseled_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_CTM.get(), "blue_ice_pillar_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_PATTERNED.get(), "blue_ice_patterned_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_SLANTED_TILES.get(), "blue_ice_slanted_tiles_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_TILES.get(), "blue_ice_tiles_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.BLUE_TERRACOTTA_COLUMN, "blue_terracotta_column_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.BLUE_TERRACOTTA_CTM, "blue_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK_BORDERED.get(), "bone_block_bordered_engraving");
        engraveOne(exporter, Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK_CHISELED.get(), "bone_block_chiseled_engraving");
        engraveOne(exporter, Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK_CONNECTING.get(), "bone_block_connecting_engraving");
        engraveOne(exporter, Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK_DECORATED_BORDERED.get(), "bone_block_decorated_bordered_engraving");
        engraveOne(exporter, Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK_INVERTED_TILES.get(), "bone_block_inverted_tiles_engraving");
        engraveOne(exporter, Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK_PATTERNED.get(), "bone_block_patterned_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.BORDERED_AMETHYST_BLOCK, "bordered_amethyst_block_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.BORDERED_ANCIENT_DEBRIS, "bordered_ancient_debris_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BORDERED_BASALT, "bordered_basalt_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BORDERED_BLACKSTONE, "bordered_blackstone_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BORDERED_BLUE_ICE, "bordered_blue_ice_engraving");
        // --- RECOVERED WAVE2 ---
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.BORDERED_BORDERLESS_BRICKS, "bordered_borderless_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.BORDERED_BRICKS, "bordered_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.BORDERED_CALCITE, "bordered_calcite_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.BORDERED_CLAY, "bordered_clay_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.BORDERED_COAL_BLOCK, "bordered_coal_block_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.BORDERED_COBBLESTONE, "bordered_cobblestone_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.BORDERED_CRYING_OBSIDIAN, "bordered_crying_obsidian_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.BORDERED_DARK_PRISMARINE, "bordered_dark_prismarine_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.BORDERED_DEEPSLATE, "bordered_deepslate_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.BORDERED_DIORITE, "bordered_diorite_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.BORDERED_DIRT, "bordered_dirt_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.BORDERED_DRIPSTONE_BLOCK, "bordered_dripstone_block_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.BORDERED_END_STONE, "bordered_end_stone_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.BORDERED_GILDED_BLACKSTONE, "bordered_gilded_blackstone_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.BORDERED_ICE, "bordered_ice_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.BORDERED_LAPIS_BLOCK, "bordered_lapis_block_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.BORDERED_LODESTONE, "bordered_lodestone_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.BORDERED_MAGMA_BLOCK, "bordered_magma_block_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.BORDERED_MOSSY_COBBLESTONE, "bordered_mossy_cobblestone_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.BORDERED_MOSSY_STONE_BRICKS, "bordered_mossy_stone_bricks_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.BORDERED_MUD, "bordered_mud_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.BORDERED_MUD_BRICKS, "bordered_mud_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.BORDERED_NETHER_BRICKS, "bordered_nether_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.BORDERED_NETHERRACK, "bordered_netherrack_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.BORDERED_OBSIDIAN, "bordered_obsidian_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.BORDERED_PACKED_ICE, "bordered_packed_ice_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.BORDERED_PACKED_MUD, "bordered_packed_mud_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.BORDERED_PRISMARINE, "bordered_prismarine_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.BORDERED_PURPUR_BLOCK, "bordered_purpur_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.BORDERED_QUARTZ_BLOCK, "bordered_quartz_block_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.BORDERED_RAW_COPPER_BLOCK, "bordered_raw_copper_block_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.BORDERED_RAW_GOLD_BLOCK, "bordered_raw_gold_block_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.BORDERED_RAW_IRON_BLOCK, "bordered_raw_iron_block_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.BORDERED_RED_NETHER_BRICKS, "bordered_red_nether_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.BORDERED_RED_SANDSTONE, "bordered_red_sandstone_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.BORDERED_REDSTONE_BLOCK, "bordered_redstone_block_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.BORDERED_SANDSTONE, "bordered_sandstone_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.BORDERED_SMOOTH_STONE, "bordered_smooth_stone_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.BORDERED_SNOW_BLOCK, "bordered_snow_block_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.BORDERED_TUFF, "bordered_tuff_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.BRICK_BORDERED_AMETHYST_BLOCK, "brick_bordered_amethyst_block_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.BRICK_BORDERED_ANCIENT_DEBRIS, "brick_bordered_ancient_debris_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.BRICK_BORDERED_ANDESITE, "brick_bordered_andesite_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.BRICK_BORDERED_BASALT, "brick_bordered_basalt_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.BRICK_BORDERED_BLACKSTONE, "brick_bordered_blackstone_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.BRICK_BORDERED_BLUE_ICE, "brick_bordered_blue_ice_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.BRICK_BORDERED_BORDERLESS_BRICKS, "brick_bordered_borderless_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.BRICK_BORDERED_BRICKS, "brick_bordered_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.BRICK_BORDERED_CALCITE, "brick_bordered_calcite_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.BRICK_BORDERED_CLAY, "brick_bordered_clay_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.BRICK_BORDERED_COAL_BLOCK, "brick_bordered_coal_block_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.BRICK_BORDERED_COBBLESTONE, "brick_bordered_cobblestone_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.BRICK_BORDERED_CRYING_OBSIDIAN, "brick_bordered_crying_obsidian_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.BRICK_BORDERED_DARK_PRISMARINE, "brick_bordered_dark_prismarine_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.BRICK_BORDERED_DEEPSLATE, "brick_bordered_deepslate_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.BRICK_BORDERED_DIORITE, "brick_bordered_diorite_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.BRICK_BORDERED_DIRT, "brick_bordered_dirt_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.BRICK_BORDERED_DRIPSTONE_BLOCK, "brick_bordered_dripstone_block_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.BRICK_BORDERED_END_STONE, "brick_bordered_end_stone_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.BRICK_BORDERED_GILDED_BLACKSTONE, "brick_bordered_gilded_blackstone_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.BRICK_BORDERED_ICE, "brick_bordered_ice_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.BRICK_BORDERED_LAPIS_BLOCK, "brick_bordered_lapis_block_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.BRICK_BORDERED_LODESTONE, "brick_bordered_lodestone_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.BRICK_BORDERED_MAGMA_BLOCK, "brick_bordered_magma_block_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.BRICK_BORDERED_MOSSY_COBBLESTONE, "brick_bordered_mossy_cobblestone_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.BRICK_BORDERED_MOSSY_STONE_BRICKS, "brick_bordered_mossy_stone_bricks_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.BRICK_BORDERED_MUD, "brick_bordered_mud_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.BRICK_BORDERED_MUD_BRICKS, "brick_bordered_mud_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.BRICK_BORDERED_NETHER_BRICKS, "brick_bordered_nether_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.BRICK_BORDERED_NETHERRACK, "brick_bordered_netherrack_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.BRICK_BORDERED_OBSIDIAN, "brick_bordered_obsidian_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.BRICK_BORDERED_PACKED_ICE, "brick_bordered_packed_ice_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.BRICK_BORDERED_PACKED_MUD, "brick_bordered_packed_mud_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.BRICK_BORDERED_PRISMARINE, "brick_bordered_prismarine_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.BRICK_BORDERED_PURPUR_BLOCK, "brick_bordered_purpur_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.BRICK_BORDERED_QUARTZ_BLOCK, "brick_bordered_quartz_block_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.BRICK_BORDERED_RAW_COPPER_BLOCK, "brick_bordered_raw_copper_block_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.BRICK_BORDERED_RAW_GOLD_BLOCK, "brick_bordered_raw_gold_block_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.BRICK_BORDERED_RAW_IRON_BLOCK, "brick_bordered_raw_iron_block_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.BRICK_BORDERED_RED_NETHER_BRICKS, "brick_bordered_red_nether_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.BRICK_BORDERED_RED_SANDSTONE, "brick_bordered_red_sandstone_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.BRICK_BORDERED_REDSTONE_BLOCK, "brick_bordered_redstone_block_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.BRICK_BORDERED_SANDSTONE, "brick_bordered_sandstone_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.BRICK_BORDERED_SMOOTH_STONE, "brick_bordered_smooth_stone_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.BRICK_BORDERED_SNOW_BLOCK, "brick_bordered_snow_block_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.BRICK_BORDERED_TUFF, "brick_bordered_tuff_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.BROWN_CONCRETE_CTM, "brown_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.BROWN_CONCRETE_PANEL, "brown_concrete_panel_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.BROWN_TERRACOTTA_COLUMN, "brown_terracotta_column_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.BROWN_TERRACOTTA_CTM, "brown_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.CALCITE_CUT_POLISHED.get(), "calcite_cut_polished_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.CALCITE_CUT_SMALL_BRICK.get(), "calcite_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.CARVED_MUD_BRICKS_CTM, "carved_mud_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.CARVED_MUD_CTM, "carved_mud_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.CARVED_PACKED_MUD_CTM, "carved_packed_mud_pillar_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_BEAMS.get(), "cherry_planks_beams_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_BRICK_PATTERN.get(), "cherry_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_BRICK_PAVING.get(), "cherry_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_BRICKS.get(), "cherry_planks_bricks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_CRATE.get(), "cherry_planks_crate_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_DIAGONAL_STRIPES.get(), "cherry_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_DIAGONAL_TILES.get(), "cherry_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_DOTTED.get(), "cherry_planks_dotted_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_FLOORING.get(), "cherry_planks_flooring_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_LARGE_TILES.get(), "cherry_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_PANEL, "cherry_planks_panel_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_PATTERN.get(), "cherry_planks_pattern_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_ROTATED_BRICKS.get(), "cherry_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_SMALL_BRICKS.get(), "cherry_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_SMALL_TILES.get(), "cherry_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_SQUARES.get(), "cherry_planks_squares_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_TILES.get(), "cherry_planks_tiles_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_WAVY.get(), "cherry_planks_wavy_engraving");
        engraveOne(exporter, Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS_WOVEN.get(), "cherry_planks_woven_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.CIRCULAR_BLACK_TERRACOTTA, "circular_black_terracotta_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.CIRCULAR_BLUE_TERRACOTTA, "circular_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.CIRCULAR_BROWN_TERRACOTTA, "circular_brown_terracotta_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.CIRCULAR_CYAN_TERRACOTTA, "circular_cyan_terracotta_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.CIRCULAR_GRAY_TERRACOTTA, "circular_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.CIRCULAR_GREEN_TERRACOTTA, "circular_green_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.CIRCULAR_LIGHT_BLUE_TERRACOTTA, "circular_light_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.CIRCULAR_LIGHT_GRAY_TERRACOTTA, "circular_light_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.CIRCULAR_LIME_TERRACOTTA, "circular_lime_terracotta_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.CIRCULAR_MAGENTA_TERRACOTTA, "circular_magenta_terracotta_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.CIRCULAR_ORANGE_TERRACOTTA, "circular_orange_terracotta_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.CIRCULAR_PINK_TERRACOTTA, "circular_pink_terracotta_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.CIRCULAR_PURPLE_TERRACOTTA, "circular_purple_terracotta_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.CIRCULAR_RED_TERRACOTTA, "circular_red_terracotta_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.CIRCULAR_TERRACOTTA, "circular_terracotta_engraving");
        engraveOne(exporter, Blocks.WHITE_TERRACOTTA, ModBlocks.CIRCULAR_WHITE_TERRACOTTA, "circular_white_terracotta_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.CIRCULAR_YELLOW_TERRACOTTA, "circular_yellow_terracotta_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.CLEAR_LEADED_GLASS, "clear_leaded_glass_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.CLEAR_LEADED_GLASS_CTM, "clear_leaded_glass_pillar_engraving");
        engraveOne(exporter, ModBlocks.CLEAR_LEADED_GLASS_CTM.get(), ModBlocks.CLEAR_LEADED_GLASS_CTM_PANE.get(), "clear_leaded_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_CARVED.get(), "coal_block_carved_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_CHISELED.get(), "coal_block_chiseled_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_CIRCLES.get(), "coal_block_circles_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_COMPACTED.get(), "coal_block_compacted_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_OVALS.get(), "coal_block_ovals_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_PATTERN.get(), "coal_block_pattern_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_ROTATED_BRICKS.get(), "coal_block_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_SMALL_TILES.get(), "coal_block_small_tiles_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK_STRIPES.get(), "coal_block_stripes_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_BEAMS.get(), "cobbled_deepslate_beams_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_BRICK_PATTERN.get(), "cobbled_deepslate_brick_pattern_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_BRICK_PAVING.get(), "cobbled_deepslate_brick_paving_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_BRICKS.get(), "cobbled_deepslate_bricks_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_LARGE_TILES.get(), "cobbled_deepslate_large_tiles_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_PAVING.get(), "cobbled_deepslate_paving_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_PULVERIZED.get(), "cobbled_deepslate_pulverized_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_ROTATED_BRICKS.get(), "cobbled_deepslate_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_SMALL_TILES.get(), "cobbled_deepslate_small_tiles_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_SQUARES.get(), "cobbled_deepslate_squares_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_STRIPES.get(), "cobbled_deepslate_stripes_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_TILES.get(), "cobbled_deepslate_tiles_engraving");
        engraveOne(exporter, Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_WORN_STRIPES.get(), "cobbled_deepslate_worn_stripes_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_BEAMS.get(), "cobblestone_beams_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_BRICK_PATTERN.get(), "cobblestone_brick_pattern_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_BRICK_PAVING.get(), "cobblestone_brick_paving_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_CHISELED_BORDER.get(), "cobblestone_chiseled_border_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_CROSSES.get(), "cobblestone_crosses_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_DENTED.get(), "cobblestone_dented_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_INVERTED_DENTED.get(), "cobblestone_inverted_dented_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_PAVING.get(), "cobblestone_paving_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_PULVERIZED.get(), "cobblestone_pulverized_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_ROTATED_BRICKS.get(), "cobblestone_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_SMALL_TILES.get(), "cobblestone_small_tiles_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_SQUARES.get(), "cobblestone_squares_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_STRIPES.get(), "cobblestone_stripes_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_TILES.get(), "cobblestone_tiles_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_WORN_STRIPES.get(), "cobblestone_worn_stripes_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_BARS.get(), "copper_block_bars_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_CIRCLES.get(), "copper_block_circles_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_GEARS.get(), "copper_block_gears_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_LINES.get(), "copper_block_lines_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_PATTERN.get(), "copper_block_pattern_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_POLISHED.get(), "copper_block_polished_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_SHAFTS.get(), "copper_block_shafts_engraving");
        engraveOne(exporter, Blocks.COPPER_BLOCK, ModBlocks.COPPER_BLOCK_SMALL_BRICKS.get(), "copper_block_small_bricks_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.CORNERED_ACACIA_PLANKS, "cornered_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.CORNERED_BAMBOO_PLANKS, "cornered_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.CORNERED_BIRCH_PLANKS, "cornered_birch_planks_engraving");
        engraveOne(exporter, Blocks.BLACK_WOOL, ModBlocks.CORNERED_BLACK_WOOL, "cornered_black_wool_engraving");
        engraveOne(exporter, Blocks.BLUE_WOOL, ModBlocks.CORNERED_BLUE_WOOL, "cornered_blue_wool_engraving");
        engraveOne(exporter, Blocks.BROWN_WOOL, ModBlocks.CORNERED_BROWN_WOOL, "cornered_brown_wool_engraving");
        engraveOne(exporter, Blocks.CYAN_WOOL, ModBlocks.CORNERED_CYAN_WOOL, "cornered_cyan_wool_engraving");
        engraveOne(exporter, Blocks.GRAY_WOOL, ModBlocks.CORNERED_GRAY_WOOL, "cornered_gray_wool_engraving");
        engraveOne(exporter, Blocks.GREEN_WOOL, ModBlocks.CORNERED_GREEN_WOOL, "cornered_green_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_WOOL, ModBlocks.CORNERED_LIGHT_BLUE_WOOL, "cornered_light_blue_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_WOOL, ModBlocks.CORNERED_LIGHT_GRAY_WOOL, "cornered_light_gray_wool_engraving");
        engraveOne(exporter, Blocks.LIME_WOOL, ModBlocks.CORNERED_LIME_WOOL, "cornered_lime_wool_engraving");
        engraveOne(exporter, Blocks.MAGENTA_WOOL, ModBlocks.CORNERED_MAGENTA_WOOL, "cornered_magenta_wool_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.CORNERED_OAK_PLANKS, "cornered_oak_planks_engraving");
        engraveOne(exporter, Blocks.ORANGE_WOOL, ModBlocks.CORNERED_ORANGE_WOOL, "cornered_orange_wool_engraving");
        engraveOne(exporter, Blocks.PINK_WOOL, ModBlocks.CORNERED_PINK_WOOL, "cornered_pink_wool_engraving");
        engraveOne(exporter, Blocks.PURPLE_WOOL, ModBlocks.CORNERED_PURPLE_WOOL, "cornered_purple_wool_engraving");
        engraveOne(exporter, Blocks.RED_WOOL, ModBlocks.CORNERED_RED_WOOL, "cornered_red_wool_engraving");
        engraveOne(exporter, Blocks.WHITE_WOOL, ModBlocks.CORNERED_WHITE_WOOL, "cornered_white_wool_engraving");
        engraveOne(exporter, Blocks.YELLOW_WOOL, ModBlocks.CORNERED_YELLOW_WOOL, "cornered_yellow_wool_engraving");
        engraveOne(exporter, Blocks.BLACK_WOOL, ModBlocks.CRAFTED_BLACK_WOOL, "crafted_black_wool_engraving");
        engraveOne(exporter, Blocks.BLUE_WOOL, ModBlocks.CRAFTED_BLUE_WOOL, "crafted_blue_wool_engraving");
        engraveOne(exporter, Blocks.BROWN_WOOL, ModBlocks.CRAFTED_BROWN_WOOL, "crafted_brown_wool_engraving");
        engraveOne(exporter, Blocks.CYAN_WOOL, ModBlocks.CRAFTED_CYAN_WOOL, "crafted_cyan_wool_engraving");
        engraveOne(exporter, Blocks.GRAY_WOOL, ModBlocks.CRAFTED_GRAY_WOOL, "crafted_gray_wool_engraving");
        engraveOne(exporter, Blocks.GREEN_WOOL, ModBlocks.CRAFTED_GREEN_WOOL, "crafted_green_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_WOOL, ModBlocks.CRAFTED_LIGHT_BLUE_WOOL, "crafted_light_blue_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_WOOL, ModBlocks.CRAFTED_LIGHT_GRAY_WOOL, "crafted_light_gray_wool_engraving");
        engraveOne(exporter, Blocks.LIME_WOOL, ModBlocks.CRAFTED_LIME_WOOL, "crafted_lime_wool_engraving");
        engraveOne(exporter, Blocks.MAGENTA_WOOL, ModBlocks.CRAFTED_MAGENTA_WOOL, "crafted_magenta_wool_engraving");
        engraveOne(exporter, Blocks.ORANGE_WOOL, ModBlocks.CRAFTED_ORANGE_WOOL, "crafted_orange_wool_engraving");
        engraveOne(exporter, Blocks.PINK_WOOL, ModBlocks.CRAFTED_PINK_WOOL, "crafted_pink_wool_engraving");
        engraveOne(exporter, Blocks.PURPLE_WOOL, ModBlocks.CRAFTED_PURPLE_WOOL, "crafted_purple_wool_engraving");
        engraveOne(exporter, Blocks.RED_WOOL, ModBlocks.CRAFTED_RED_WOOL, "crafted_red_wool_engraving");
        engraveOne(exporter, Blocks.WHITE_WOOL, ModBlocks.CRAFTED_WHITE_WOOL, "crafted_white_wool_engraving");
        engraveOne(exporter, Blocks.YELLOW_WOOL, ModBlocks.CRAFTED_YELLOW_WOOL, "crafted_yellow_wool_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.CRATED_ACACIA_PLANKS, "crated_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.CRATED_BAMBOO_PLANKS, "crated_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.CRATED_BIRCH_PLANKS, "crated_birch_planks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.CRATED_OAK_PLANKS, "crated_oak_planks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_BEAMS.get(), "crimson_planks_beams_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_BRICK_PATTERN.get(), "crimson_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_BRICK_PAVING.get(), "crimson_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_BRICKS.get(), "crimson_planks_bricks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_CRATE.get(), "crimson_planks_crate_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_DIAGONAL_STRIPES.get(), "crimson_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_DIAGONAL_TILES.get(), "crimson_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_DOTTED.get(), "crimson_planks_dotted_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_FLOORING.get(), "crimson_planks_flooring_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_LARGE_TILES.get(), "crimson_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_PANEL, "crimson_planks_panel_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_PATTERN.get(), "crimson_planks_pattern_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_ROTATED_BRICKS.get(), "crimson_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_SMALL_BRICKS.get(), "crimson_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_SMALL_TILES.get(), "crimson_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_SQUARES.get(), "crimson_planks_squares_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_TILES.get(), "crimson_planks_tiles_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_WAVY.get(), "crimson_planks_wavy_engraving");
        engraveOne(exporter, Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS_WOVEN.get(), "crimson_planks_woven_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.CURLED_BLACK_TERRACOTTA, "curled_black_terracotta_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.CURLED_BLUE_TERRACOTTA, "curled_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.CURLED_BROWN_TERRACOTTA, "curled_brown_terracotta_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.CURLED_CYAN_TERRACOTTA, "curled_cyan_terracotta_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.CURLED_GRAY_TERRACOTTA, "curled_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.CURLED_GREEN_TERRACOTTA, "curled_green_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.CURLED_LIGHT_BLUE_TERRACOTTA, "curled_light_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.CURLED_LIGHT_GRAY_TERRACOTTA, "curled_light_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.CURLED_LIME_TERRACOTTA, "curled_lime_terracotta_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.CURLED_MAGENTA_TERRACOTTA, "curled_magenta_terracotta_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.CURLED_ORANGE_TERRACOTTA, "curled_orange_terracotta_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.CURLED_PINK_TERRACOTTA, "curled_pink_terracotta_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.CURLED_PURPLE_TERRACOTTA, "curled_purple_terracotta_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.CURLED_RED_TERRACOTTA, "curled_red_terracotta_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.CURLED_TERRACOTTA, "curled_terracotta_engraving");
        engraveOne(exporter, Blocks.WHITE_TERRACOTTA, ModBlocks.CURLED_WHITE_TERRACOTTA, "curled_white_terracotta_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.CURLED_YELLOW_TERRACOTTA, "curled_yellow_terracotta_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.CURLY_AMETHYST_BLOCK_CTM, "curly_amethyst_block_pillar_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.CURLY_ANCIENT_DEBRIS_CTM, "curly_ancient_debris_pillar_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.CURLY_ANDESITE_CTM, "curly_andesite_pillar_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.CURLY_BASALT_CTM, "curly_basalt_pillar_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.CURLY_BLACKSTONE_CTM, "curly_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.CURLY_BLUE_ICE_CTM, "curly_blue_ice_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.CURLY_BORDERLESS_BRICKS_CTM, "curly_borderless_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.CURLY_BRICKS_CTM, "curly_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.CURLY_CALCITE_CTM, "curly_calcite_pillar_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.CURLY_CLAY_CTM, "curly_clay_pillar_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.CURLY_COAL_BLOCK_CTM, "curly_coal_block_pillar_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.CURLY_COBBLESTONE_CTM, "curly_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.CURLY_CRYING_OBSIDIAN_CTM, "curly_crying_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.CURLY_DARK_PRISMARINE_CTM, "curly_dark_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.CURLY_DEEPSLATE_CTM, "curly_deepslate_pillar_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.CURLY_DIORITE_CTM, "curly_diorite_pillar_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.CURLY_DIRT_CTM, "curly_dirt_pillar_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.CURLY_DRIPSTONE_BLOCK_CTM, "curly_dripstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.CURLY_END_STONE_CTM, "curly_end_stone_pillar_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.CURLY_GILDED_BLACKSTONE_CTM, "curly_gilded_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.CURLY_ICE_CTM, "curly_ice_pillar_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.CURLY_LAPIS_BLOCK_CTM, "curly_lapis_block_pillar_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.CURLY_LODESTONE_CTM, "curly_lodestone_pillar_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.CURLY_MAGMA_BLOCK_CTM, "curly_magma_block_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.CURLY_MOSSY_COBBLESTONE_CTM, "curly_mossy_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.CURLY_MOSSY_STONE_BRICKS_CTM, "curly_mossy_stone_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.CURLY_MUD_BRICKS_CTM, "curly_mud_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.CURLY_MUD_CTM, "curly_mud_pillar_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.CURLY_NETHER_BRICKS_CTM, "curly_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.CURLY_NETHERRACK_CTM, "curly_netherrack_pillar_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.CURLY_OBSIDIAN_CTM, "curly_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.CURLY_PACKED_ICE_CTM, "curly_packed_ice_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.CURLY_PACKED_MUD_CTM, "curly_packed_mud_pillar_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.CURLY_PRISMARINE_CTM, "curly_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.CURLY_PURPUR_BLOCK_CTM, "curly_purpur_block_pillar_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.CURLY_QUARTZ_BLOCK_CTM, "curly_quartz_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.CURLY_RAW_COPPER_BLOCK_CTM, "curly_raw_copper_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.CURLY_RAW_GOLD_BLOCK_CTM, "curly_raw_gold_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.CURLY_RAW_IRON_BLOCK_CTM, "curly_raw_iron_block_pillar_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.CURLY_RED_NETHER_BRICKS_CTM, "curly_red_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.CURLY_RED_SANDSTONE_CTM, "curly_red_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.CURLY_REDSTONE_BLOCK_CTM, "curly_redstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.CURLY_SANDSTONE_CTM, "curly_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.CURLY_SMOOTH_STONE_CTM, "curly_smooth_stone_pillar_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.CURLY_SNOW_BLOCK_CTM, "curly_snow_block_pillar_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.CURLY_TUFF_CTM, "curly_tuff_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.CUT_AMETHYST_BLOCK_COLUMN, "cut_amethyst_block_column_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.CUT_ANCIENT_DEBRIS_COLUMN, "cut_ancient_debris_column_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.CUT_ANDESITE_COLUMN, "cut_andesite_column_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.CUT_BASALT_COLUMN, "cut_basalt_column_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.CUT_BLACKSTONE_COLUMN, "cut_blackstone_column_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.CUT_BLANK_STONE,                      "cut_blank_stone_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.CUT_BLUE_ICE_COLUMN, "cut_blue_ice_column_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.CUT_BORDERLESS_BRICKS_COLUMN, "cut_borderless_bricks_column_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.CUT_BRICKS_COLUMN, "cut_bricks_column_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.CUT_CALCITE_COLUMN, "cut_calcite_column_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.CUT_CLAY_COLUMN, "cut_clay_column_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.CUT_COAL_BLOCK_COLUMN, "cut_coal_block_column_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.CUT_COBBLESTONE_COLUMN, "cut_cobblestone_column_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.CUT_CRYING_OBSIDIAN_COLUMN, "cut_crying_obsidian_column_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.CUT_DARK_PRISMARINE_COLUMN, "cut_dark_prismarine_column_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.CUT_DEEPSLATE_COLUMN, "cut_deepslate_column_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.CUT_DIORITE_COLUMN, "cut_diorite_column_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.CUT_DIRT_COLUMN, "cut_dirt_column_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.CUT_DRIPSTONE_BLOCK_COLUMN, "cut_dripstone_block_column_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.CUT_END_STONE_COLUMN, "cut_end_stone_column_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.CUT_GILDED_BLACKSTONE_COLUMN, "cut_gilded_blackstone_column_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.CUT_ICE_COLUMN, "cut_ice_column_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.CUT_LAPIS_BLOCK_COLUMN, "cut_lapis_block_column_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.CUT_LODESTONE_COLUMN, "cut_lodestone_column_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.CUT_MAGMA_BLOCK_COLUMN, "cut_magma_block_column_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.CUT_MOSSY_COBBLESTONE_COLUMN, "cut_mossy_cobblestone_column_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.CUT_MOSSY_STONE_BRICKS_COLUMN, "cut_mossy_stone_bricks_column_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.CUT_NETHER_BRICKS_COLUMN, "cut_nether_bricks_column_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.CUT_NETHERRACK_COLUMN, "cut_netherrack_column_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.CUT_OBSIDIAN_COLUMN, "cut_obsidian_column_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.CUT_PACKED_ICE_COLUMN, "cut_packed_ice_column_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.CUT_PRISMARINE_COLUMN, "cut_prismarine_column_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.CUT_PURPUR_BLOCK_COLUMN, "cut_purpur_block_column_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.CUT_QUARTZ_BLOCK_COLUMN, "cut_quartz_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.CUT_RAW_COPPER_BLOCK_COLUMN, "cut_raw_copper_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.CUT_RAW_GOLD_BLOCK_COLUMN, "cut_raw_gold_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.CUT_RAW_IRON_BLOCK_COLUMN, "cut_raw_iron_block_column_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.CUT_RED_NETHER_BRICKS_COLUMN, "cut_red_nether_bricks_column_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.CUT_RED_SANDSTONE_COLUMN, "cut_red_sandstone_column_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.CUT_REDSTONE_BLOCK_COLUMN, "cut_redstone_block_column_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.CUT_SANDSTONE_COLUMN, "cut_sandstone_column_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.CUT_SMOOTH_STONE_COLUMN, "cut_smooth_stone_column_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.CUT_SNOW_BLOCK_COLUMN, "cut_snow_block_column_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.CUT_TUFF_COLUMN, "cut_tuff_column_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.CYAN_CONCRETE_CTM, "cyan_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.CYAN_CONCRETE_PANEL, "cyan_concrete_panel_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.CYAN_TERRACOTTA_COLUMN, "cyan_terracotta_column_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.CYAN_TERRACOTTA_CTM, "cyan_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_BEAMS.get(), "dark_oak_planks_beams_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_BRICK_PATTERN.get(), "dark_oak_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_BRICK_PAVING.get(), "dark_oak_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_BRICKS.get(), "dark_oak_planks_bricks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_CRATE.get(), "dark_oak_planks_crate_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_DIAGONAL_STRIPES.get(), "dark_oak_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_DIAGONAL_TILES.get(), "dark_oak_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_DOTTED.get(), "dark_oak_planks_dotted_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_FLOORING.get(), "dark_oak_planks_flooring_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_LARGE_TILES.get(), "dark_oak_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_PANEL, "dark_oak_planks_panel_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_PATTERN.get(), "dark_oak_planks_pattern_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_ROTATED_BRICKS.get(), "dark_oak_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_SMALL_BRICKS.get(), "dark_oak_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_SMALL_TILES.get(), "dark_oak_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_SQUARES.get(), "dark_oak_planks_squares_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_TILES.get(), "dark_oak_planks_tiles_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_WAVY.get(), "dark_oak_planks_wavy_engraving");
        engraveOne(exporter, Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS_WOVEN.get(), "dark_oak_planks_woven_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.DEEPSLATE_CUT_POLISHED.get(), "deepslate_cut_polished_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.DEEPSLATE_CUT_SMALL_BRICK.get(), "deepslate_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_BRICK_PATTERN.get(), "diorite_brick_pattern_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_BRICK_PAVING.get(), "diorite_brick_paving_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_BRICKS.get(), "diorite_bricks_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_CUT_POLISHED.get(), "diorite_cut_polished_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_CUT_SMALL_BRICK.get(), "diorite_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_DIAGONAL_BRICKS.get(), "diorite_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_DOTTED.get(), "diorite_dotted_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_PAVING.get(), "diorite_paving_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_POLISHED.get(), "diorite_polished_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_ROTATED_BRICKS.get(), "diorite_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_SQUARES.get(), "diorite_squares_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_TILES.get(), "diorite_tiles_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.DIORITE_WAVY.get(), "diorite_wavy_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.EDGED_AMETHYST_BLOCK_BRICKS, "edged_amethyst_block_bricks_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.EDGED_ANCIENT_DEBRIS_BRICKS, "edged_ancient_debris_bricks_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.EDGED_ANDESITE_BRICKS, "edged_andesite_bricks_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.EDGED_BASALT_BRICKS, "edged_basalt_bricks_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.EDGED_BLACKSTONE_BRICKS, "edged_blackstone_bricks_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.EDGED_BLUE_ICE_BRICKS, "edged_blue_ice_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.EDGED_BORDERLESS_BRICKS_BRICKS, "edged_borderless_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.EDGED_BRICKS_BRICKS, "edged_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.EDGED_CALCITE_BRICKS, "edged_calcite_bricks_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.EDGED_CLAY_BRICKS, "edged_clay_bricks_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.EDGED_COAL_BLOCK_BRICKS, "edged_coal_block_bricks_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.EDGED_COBBLESTONE_BRICKS, "edged_cobblestone_bricks_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.EDGED_CRYING_OBSIDIAN_BRICKS, "edged_crying_obsidian_bricks_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.EDGED_DARK_PRISMARINE_BRICKS, "edged_dark_prismarine_bricks_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.EDGED_DEEPSLATE_BRICKS, "edged_deepslate_bricks_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.EDGED_DIORITE_BRICKS, "edged_diorite_bricks_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.EDGED_DIRT_BRICKS, "edged_dirt_bricks_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.EDGED_DRIPSTONE_BLOCK_BRICKS, "edged_dripstone_block_bricks_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.EDGED_END_STONE_BRICKS, "edged_end_stone_bricks_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.EDGED_GILDED_BLACKSTONE_BRICKS, "edged_gilded_blackstone_bricks_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.EDGED_ICE_BRICKS, "edged_ice_bricks_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.EDGED_LAPIS_BLOCK_BRICKS, "edged_lapis_block_bricks_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.EDGED_LODESTONE_BRICKS, "edged_lodestone_bricks_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.EDGED_MAGMA_BLOCK_BRICKS, "edged_magma_block_bricks_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.EDGED_MOSSY_COBBLESTONE_BRICKS, "edged_mossy_cobblestone_bricks_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.EDGED_MOSSY_STONE_BRICKS_BRICKS, "edged_mossy_stone_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.EDGED_MUD, "edged_mud_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.EDGED_MUD_BRICKS_BRICKS, "edged_mud_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.EDGED_NETHER_BRICKS_BRICKS, "edged_nether_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.EDGED_NETHERRACK_BRICKS, "edged_netherrack_bricks_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.EDGED_OBSIDIAN_BRICKS, "edged_obsidian_bricks_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.EDGED_PACKED_ICE_BRICKS, "edged_packed_ice_bricks_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.EDGED_PACKED_MUD_BRICKS, "edged_packed_mud_bricks_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.EDGED_PRISMARINE_BRICKS, "edged_prismarine_bricks_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.EDGED_PURPUR_BLOCK_BRICKS, "edged_purpur_block_bricks_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.EDGED_QUARTZ_BLOCK_BRICKS, "edged_quartz_block_bricks_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.EDGED_RAW_COPPER_BLOCK_BRICKS, "edged_raw_copper_block_bricks_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.EDGED_RAW_GOLD_BLOCK_BRICKS, "edged_raw_gold_block_bricks_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.EDGED_RAW_IRON_BLOCK_BRICKS, "edged_raw_iron_block_bricks_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.EDGED_RED_NETHER_BRICKS_BRICKS, "edged_red_nether_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.EDGED_RED_SANDSTONE_BRICKS, "edged_red_sandstone_bricks_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.EDGED_REDSTONE_BLOCK_BRICKS, "edged_redstone_block_bricks_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.EDGED_SANDSTONE_BRICKS, "edged_sandstone_bricks_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.EDGED_SMOOTH_STONE_BRICKS, "edged_smooth_stone_bricks_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.EDGED_SNOW_BLOCK_BRICKS, "edged_snow_block_bricks_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.EDGED_TUFF_BRICKS, "edged_tuff_bricks_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_BORDERED_CROSSES.get(), "emerald_block_bordered_crosses_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_BORDERED_PLATING.get(), "emerald_block_bordered_plating_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_CHISELED.get(), "emerald_block_chiseled_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_CLOVERS.get(), "emerald_block_clovers_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_CRYSTAL.get(), "emerald_block_crystal_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_PATTERNED.get(), "emerald_block_patterned_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_PATTERNED_SQUARES.get(), "emerald_block_patterned_squares_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_POLISHED.get(), "emerald_block_polished_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_STRIPED.get(), "emerald_block_striped_engraving");
        engraveOne(exporter, Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK_WAXED.get(), "emerald_block_waxed_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.ENCLOSED_ACACIA_PLANKS, "enclosed_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.ENCLOSED_BAMBOO_PLANKS, "enclosed_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.ENCLOSED_BIRCH_PLANKS, "enclosed_birch_planks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.ENCLOSED_OAK_PLANKS, "enclosed_oak_planks_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_BLOBS.get(), "end_stone_blobs_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_BRICK_PATTERN.get(), "end_stone_brick_pattern_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_BRICK_PAVING.get(), "end_stone_brick_paving_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_CHISELED.get(), "end_stone_chiseled_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_CRUSHED.get(), "end_stone_crushed_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_DIAGONAL_BRICKS.get(), "end_stone_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_MESH.get(), "end_stone_mesh_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_PAVING.get(), "end_stone_paving_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_POLISHED.get(), "end_stone_polished_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_ROTATED_BRICKS.get(), "end_stone_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_SCALES.get(), "end_stone_scales_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_SMALL_TILES.get(), "end_stone_small_tiles_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_SPIRAL_PATTERN.get(), "end_stone_spiral_pattern_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_SQUARES.get(), "end_stone_squares_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.END_STONE_TILES.get(), "end_stone_tiles_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.FANCY_LEADED_GLASS, "fancy_leaded_glass_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.FANCY_MUD_BRICKS_CTM, "fancy_mud_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.FANCY_MUD_CTM, "fancy_mud_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.FANCY_PACKED_MUD_CTM, "fancy_packed_mud_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.FINE_AMETHYST_BLOCK_CTM, "fine_amethyst_block_pillar_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.FINE_ANCIENT_DEBRIS_CTM, "fine_ancient_debris_pillar_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.FINE_ANDESITE_CTM, "fine_andesite_pillar_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.FINE_BASALT_CTM, "fine_basalt_pillar_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.FINE_BLACKSTONE_CTM, "fine_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.FINE_BLUE_ICE_CTM, "fine_blue_ice_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.FINE_BORDERLESS_BRICKS_CTM, "fine_borderless_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.FINE_BRICKS_CTM, "fine_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.FINE_CALCITE_CTM, "fine_calcite_pillar_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.FINE_CLAY_CTM, "fine_clay_pillar_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.FINE_COAL_BLOCK_CTM, "fine_coal_block_pillar_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.FINE_COBBLESTONE_CTM, "fine_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.FINE_CRYING_OBSIDIAN_CTM, "fine_crying_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.FINE_DARK_PRISMARINE_CTM, "fine_dark_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.FINE_DEEPSLATE_CTM, "fine_deepslate_pillar_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.FINE_DIORITE_CTM, "fine_diorite_pillar_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.FINE_DIRT_CTM, "fine_dirt_pillar_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.FINE_DRIPSTONE_BLOCK_CTM, "fine_dripstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.FINE_END_STONE_CTM, "fine_end_stone_pillar_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.FINE_GILDED_BLACKSTONE_CTM, "fine_gilded_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.FINE_ICE_CTM, "fine_ice_pillar_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.FINE_LAPIS_BLOCK_CTM, "fine_lapis_block_pillar_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.FINE_LODESTONE_CTM, "fine_lodestone_pillar_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.FINE_MAGMA_BLOCK_CTM, "fine_magma_block_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.FINE_MOSSY_COBBLESTONE_CTM, "fine_mossy_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.FINE_MOSSY_STONE_BRICKS_CTM, "fine_mossy_stone_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.FINE_MUD_BRICKS_CTM, "fine_mud_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.FINE_MUD_CTM, "fine_mud_pillar_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.FINE_NETHER_BRICKS_CTM, "fine_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.FINE_NETHERRACK_CTM, "fine_netherrack_pillar_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.FINE_OBSIDIAN_CTM, "fine_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.FINE_PACKED_ICE_CTM, "fine_packed_ice_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.FINE_PACKED_MUD_CTM, "fine_packed_mud_pillar_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.FINE_PRISMARINE_CTM, "fine_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.FINE_PURPUR_BLOCK_CTM, "fine_purpur_block_pillar_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.FINE_QUARTZ_BLOCK_CTM, "fine_quartz_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.FINE_RAW_COPPER_BLOCK_CTM, "fine_raw_copper_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.FINE_RAW_GOLD_BLOCK_CTM, "fine_raw_gold_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.FINE_RAW_IRON_BLOCK_CTM, "fine_raw_iron_block_pillar_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.FINE_RED_NETHER_BRICKS_CTM, "fine_red_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.FINE_RED_SANDSTONE_CTM, "fine_red_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.FINE_REDSTONE_BLOCK_CTM, "fine_redstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.FINE_SANDSTONE_CTM, "fine_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.FINE_SMOOTH_STONE_CTM, "fine_smooth_stone_pillar_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.FINE_SNOW_BLOCK_CTM, "fine_snow_block_pillar_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.FINE_TUFF_CTM, "fine_tuff_pillar_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.FRAMED_ACACIA_PLANKS, "framed_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.FRAMED_BAMBOO_PLANKS, "framed_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.FRAMED_BIRCH_PLANKS, "framed_birch_planks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.FRAMED_OAK_PLANKS, "framed_oak_planks_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK.get(), "gold_block_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_BEAMS.get(), "gold_block_beams_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_BORDERED.get(), "gold_block_bordered_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_LINES.get(), "gold_block_lines_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_PATTERN.get(), "gold_block_pattern_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_POLISHED.get(), "gold_block_polished_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_SCALES.get(), "gold_block_scales_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_SMALL_BRICKS.get(), "gold_block_small_bricks_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_SMALL_TILES.get(), "gold_block_small_tiles_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_STRIPED.get(), "gold_block_striped_engraving");
        engraveOne(exporter, Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK_TILES.get(), "gold_block_tiles_engraving");
        // --- RECOVERED WAVE3 ---
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.GRAY_CONCRETE_CTM, "gray_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.GRAY_CONCRETE_PANEL, "gray_concrete_panel_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.GRAY_TERRACOTTA_COLUMN, "gray_terracotta_column_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.GRAY_TERRACOTTA_CTM, "gray_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.GREEN_CONCRETE_CTM, "green_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.GREEN_CONCRETE_PANEL, "green_concrete_panel_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.GREEN_TERRACOTTA_COLUMN, "green_terracotta_column_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.GREEN_TERRACOTTA_CTM, "green_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.GRILL_BLACK_CONCRETE, "grill_black_concrete_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.GRILL_BLUE_CONCRETE, "grill_blue_concrete_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.GRILL_BROWN_CONCRETE, "grill_brown_concrete_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.GRILL_CYAN_CONCRETE, "grill_cyan_concrete_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.GRILL_GRAY_CONCRETE, "grill_gray_concrete_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.GRILL_GREEN_CONCRETE, "grill_green_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.GRILL_LIGHT_BLUE_CONCRETE, "grill_light_blue_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.GRILL_LIGHT_GRAY_CONCRETE, "grill_light_gray_concrete_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.GRILL_LIME_CONCRETE, "grill_lime_concrete_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.GRILL_MAGENTA_CONCRETE, "grill_magenta_concrete_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.GRILL_ORANGE_CONCRETE, "grill_orange_concrete_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.GRILL_PINK_CONCRETE, "grill_pink_concrete_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.GRILL_PURPLE_CONCRETE, "grill_purple_concrete_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.GRILL_RED_CONCRETE, "grill_red_concrete_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.GRILL_WHITE_CONCRETE, "grill_white_concrete_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.GRILL_YELLOW_CONCRETE, "grill_yellow_concrete_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.HARD_MUD, "hard_mud_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.HARD_MUD_BRICKS, "hard_mud_bricks_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.HARD_PACKED_MUD, "hard_packed_mud_engraving");
        engraveOne(exporter, Blocks.BLACK_WOOL, ModBlocks.HARSH_QUILTED_BLACK_WOOL, "harsh_quilted_black_wool_engraving");
        engraveOne(exporter, Blocks.BLUE_WOOL, ModBlocks.HARSH_QUILTED_BLUE_WOOL, "harsh_quilted_blue_wool_engraving");
        engraveOne(exporter, Blocks.BROWN_WOOL, ModBlocks.HARSH_QUILTED_BROWN_WOOL, "harsh_quilted_brown_wool_engraving");
        engraveOne(exporter, Blocks.CYAN_WOOL, ModBlocks.HARSH_QUILTED_CYAN_WOOL, "harsh_quilted_cyan_wool_engraving");
        engraveOne(exporter, Blocks.GRAY_WOOL, ModBlocks.HARSH_QUILTED_GRAY_WOOL, "harsh_quilted_gray_wool_engraving");
        engraveOne(exporter, Blocks.GREEN_WOOL, ModBlocks.HARSH_QUILTED_GREEN_WOOL, "harsh_quilted_green_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_WOOL, ModBlocks.HARSH_QUILTED_LIGHT_BLUE_WOOL, "harsh_quilted_light_blue_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_WOOL, ModBlocks.HARSH_QUILTED_LIGHT_GRAY_WOOL, "harsh_quilted_light_gray_wool_engraving");
        engraveOne(exporter, Blocks.LIME_WOOL, ModBlocks.HARSH_QUILTED_LIME_WOOL, "harsh_quilted_lime_wool_engraving");
        engraveOne(exporter, Blocks.MAGENTA_WOOL, ModBlocks.HARSH_QUILTED_MAGENTA_WOOL, "harsh_quilted_magenta_wool_engraving");
        engraveOne(exporter, Blocks.ORANGE_WOOL, ModBlocks.HARSH_QUILTED_ORANGE_WOOL, "harsh_quilted_orange_wool_engraving");
        engraveOne(exporter, Blocks.PINK_WOOL, ModBlocks.HARSH_QUILTED_PINK_WOOL, "harsh_quilted_pink_wool_engraving");
        engraveOne(exporter, Blocks.PURPLE_WOOL, ModBlocks.HARSH_QUILTED_PURPLE_WOOL, "harsh_quilted_purple_wool_engraving");
        engraveOne(exporter, Blocks.RED_WOOL, ModBlocks.HARSH_QUILTED_RED_WOOL, "harsh_quilted_red_wool_engraving");
        engraveOne(exporter, Blocks.WHITE_WOOL, ModBlocks.HARSH_QUILTED_WHITE_WOOL, "harsh_quilted_white_wool_engraving");
        engraveOne(exporter, Blocks.YELLOW_WOOL, ModBlocks.HARSH_QUILTED_YELLOW_WOOL, "harsh_quilted_yellow_wool_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.HEXAGONICAL_BLACK_TERRACOTTA, "hexagonical_black_terracotta_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.HEXAGONICAL_BLUE_TERRACOTTA, "hexagonical_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.HEXAGONICAL_BROWN_TERRACOTTA, "hexagonical_brown_terracotta_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.HEXAGONICAL_CYAN_TERRACOTTA, "hexagonical_cyan_terracotta_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.HEXAGONICAL_GRAY_TERRACOTTA, "hexagonical_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.HEXAGONICAL_GREEN_TERRACOTTA, "hexagonical_green_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.HEXAGONICAL_LIGHT_BLUE_TERRACOTTA, "hexagonical_light_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.HEXAGONICAL_LIGHT_GRAY_TERRACOTTA, "hexagonical_light_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.HEXAGONICAL_LIME_TERRACOTTA, "hexagonical_lime_terracotta_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.HEXAGONICAL_MAGENTA_TERRACOTTA, "hexagonical_magenta_terracotta_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.HEXAGONICAL_ORANGE_TERRACOTTA, "hexagonical_orange_terracotta_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.HEXAGONICAL_PINK_TERRACOTTA, "hexagonical_pink_terracotta_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.HEXAGONICAL_PURPLE_TERRACOTTA, "hexagonical_purple_terracotta_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.HEXAGONICAL_RED_TERRACOTTA, "hexagonical_red_terracotta_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.HEXAGONICAL_TERRACOTTA, "hexagonical_terracotta_engraving");
        engraveOne(exporter, Blocks.WHITE_TERRACOTTA, ModBlocks.HEXAGONICAL_WHITE_TERRACOTTA, "hexagonical_white_terracotta_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.HEXAGONICAL_YELLOW_TERRACOTTA, "hexagonical_yellow_terracotta_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.INSCRIBED_BLACK_TERRACOTTA, "inscribed_black_terracotta_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.INSCRIBED_BLUE_TERRACOTTA, "inscribed_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.INSCRIBED_BROWN_TERRACOTTA, "inscribed_brown_terracotta_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.INSCRIBED_CYAN_TERRACOTTA, "inscribed_cyan_terracotta_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.INSCRIBED_GRAY_TERRACOTTA, "inscribed_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.INSCRIBED_GREEN_TERRACOTTA, "inscribed_green_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.INSCRIBED_LIGHT_BLUE_TERRACOTTA, "inscribed_light_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.INSCRIBED_LIGHT_GRAY_TERRACOTTA, "inscribed_light_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.INSCRIBED_LIME_TERRACOTTA, "inscribed_lime_terracotta_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.INSCRIBED_MAGENTA_TERRACOTTA, "inscribed_magenta_terracotta_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.INSCRIBED_ORANGE_TERRACOTTA, "inscribed_orange_terracotta_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.INSCRIBED_PINK_TERRACOTTA, "inscribed_pink_terracotta_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.INSCRIBED_PURPLE_TERRACOTTA, "inscribed_purple_terracotta_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.INSCRIBED_RED_TERRACOTTA, "inscribed_red_terracotta_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.INSCRIBED_TERRACOTTA, "inscribed_terracotta_engraving");
        engraveOne(exporter, Blocks.WHITE_TERRACOTTA, ModBlocks.INSCRIBED_WHITE_TERRACOTTA, "inscribed_white_terracotta_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.INSCRIBED_YELLOW_TERRACOTTA, "inscribed_yellow_terracotta_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK.get(), "iron_block_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_BORDERED.get(), "iron_block_bordered_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_CHISELED.get(), "iron_block_chiseled_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_CONNECTING.get(), "iron_block_connecting_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_FRAMED.get(), "iron_block_framed_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_GEARS.get(), "iron_block_gears_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_LINES.get(), "iron_block_lines_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_PATTERNED.get(), "iron_block_patterned_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_PIPES.get(), "iron_block_pipes_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_POLISHED.get(), "iron_block_polished_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_PROCESSED.get(), "iron_block_processed_engraving");
        engraveOne(exporter, Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK_SMALL_BRICKS.get(), "iron_block_small_bricks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_BEAMS.get(), "jungle_planks_beams_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_BRICK_PATTERN.get(), "jungle_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_BRICK_PAVING.get(), "jungle_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_BRICKS.get(), "jungle_planks_bricks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_CRATE.get(), "jungle_planks_crate_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_DIAGONAL_STRIPES.get(), "jungle_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_DIAGONAL_TILES.get(), "jungle_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_DOTTED.get(), "jungle_planks_dotted_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_FLOORING.get(), "jungle_planks_flooring_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_LARGE_TILES.get(), "jungle_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_PATTERN.get(), "jungle_planks_pattern_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_ROTATED_BRICKS.get(), "jungle_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_SMALL_BRICKS.get(), "jungle_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_SMALL_TILES.get(), "jungle_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_SQUARES.get(), "jungle_planks_squares_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_TILES.get(), "jungle_planks_tiles_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_WAVY.get(), "jungle_planks_wavy_engraving");
        engraveOne(exporter, Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS_WOVEN.get(), "jungle_planks_woven_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK.get(), "lapis_block_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_BORDERED.get(), "lapis_block_bordered_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_CONNECTING.get(), "lapis_block_connecting_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_DECORATED.get(), "lapis_block_decorated_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_GLOSSY.get(), "lapis_block_glossy_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_INVERTED_TILES.get(), "lapis_block_inverted_tiles_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_MOSAIC.get(), "lapis_block_mosaic_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_PATTERN.get(), "lapis_block_pattern_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_POLISHED.get(), "lapis_block_polished_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_SCALES.get(), "lapis_block_scales_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_SMALL_TILES.get(), "lapis_block_small_tiles_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_STRIPES.get(), "lapis_block_stripes_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK_TILES.get(), "lapis_block_tiles_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.LARGE_DIAMOND_LEADED_GLASS, "large_diamond_leaded_glass_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.LARGE_MUD_BRICKS_SIGIL, "large_mud_bricks_sigil_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.LARGE_MUD_SIGIL, "large_mud_sigil_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.LARGE_PACKED_MUD_SIGIL, "large_packed_mud_sigil_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.LEAD_WOVEN_GLASS, "lead_woven_glass_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_CONCRETE_CTM, "light_blue_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_CONCRETE_PANEL, "light_blue_concrete_panel_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA_COLUMN, "light_blue_terracotta_column_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA_CTM, "light_blue_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_CONCRETE_CTM, "light_gray_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_CONCRETE_PANEL, "light_gray_concrete_panel_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA_COLUMN, "light_gray_terracotta_column_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA_CTM, "light_gray_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.LIME_CONCRETE_CTM, "lime_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.LIME_CONCRETE_PANEL, "lime_concrete_panel_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.LIME_TERRACOTTA_COLUMN, "lime_terracotta_column_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.LIME_TERRACOTTA_CTM, "lime_terracotta_pillar_engraving");
        engraveOne(exporter, ModBlocks.MIXED_LIMESTONE_BRICKS, ModBlocks.LIMESTONE_CUT_POLISHED.get(), "limestone_cut_polished_engraving");
        engraveOne(exporter, ModBlocks.MIXED_LIMESTONE_BRICKS, ModBlocks.LIMESTONE_CUT_SMALL_BRICK.get(), "limestone_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.LOREFUL_MUD, "loreful_mud_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.LOREFUL_MUD_BRICKS, "loreful_mud_bricks_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.LOREFUL_PACKED_MUD, "loreful_packed_mud_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_CONCRETE_CTM, "magenta_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_CONCRETE_PANEL, "magenta_concrete_panel_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.MAGENTA_TERRACOTTA_COLUMN, "magenta_terracotta_column_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.MAGENTA_TERRACOTTA_CTM, "magenta_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_BEAMS.get(), "mangrove_planks_beams_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_BRICK_PATTERN.get(), "mangrove_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_BRICK_PAVING.get(), "mangrove_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_BRICKS.get(), "mangrove_planks_bricks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_CRATE.get(), "mangrove_planks_crate_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_DIAGONAL_STRIPES.get(), "mangrove_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_DIAGONAL_TILES.get(), "mangrove_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_DOTTED.get(), "mangrove_planks_dotted_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_FLOORING.get(), "mangrove_planks_flooring_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_LARGE_TILES.get(), "mangrove_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_PANEL, "mangrove_planks_panel_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_PATTERN.get(), "mangrove_planks_pattern_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_ROTATED_BRICKS.get(), "mangrove_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_SMALL_BRICKS.get(), "mangrove_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_SMALL_TILES.get(), "mangrove_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_SQUARES.get(), "mangrove_planks_squares_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_TILES.get(), "mangrove_planks_tiles_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_WAVY.get(), "mangrove_planks_wavy_engraving");
        engraveOne(exporter, Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS_WOVEN.get(), "mangrove_planks_woven_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.MASSIVE_AMETHYST_BLOCK_BRICKS, "massive_amethyst_block_bricks_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.MASSIVE_ANCIENT_DEBRIS_BRICKS, "massive_ancient_debris_bricks_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.MASSIVE_ANDESITE_BRICKS, "massive_andesite_bricks_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.MASSIVE_BASALT_BRICKS, "massive_basalt_bricks_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.MASSIVE_BLACKSTONE_BRICKS, "massive_blackstone_bricks_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.MASSIVE_BLUE_ICE_BRICKS, "massive_blue_ice_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.MASSIVE_BORDERLESS_BRICKS_BRICKS, "massive_borderless_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.MASSIVE_BRICKS_BRICKS, "massive_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.MASSIVE_CALCITE_BRICKS, "massive_calcite_bricks_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.MASSIVE_CLAY_BRICKS, "massive_clay_bricks_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.MASSIVE_COAL_BLOCK_BRICKS, "massive_coal_block_bricks_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.MASSIVE_COBBLESTONE_BRICKS, "massive_cobblestone_bricks_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.MASSIVE_CRYING_OBSIDIAN_BRICKS, "massive_crying_obsidian_bricks_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.MASSIVE_DARK_PRISMARINE_BRICKS, "massive_dark_prismarine_bricks_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.MASSIVE_DEEPSLATE_BRICKS, "massive_deepslate_bricks_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.MASSIVE_DIORITE_BRICKS, "massive_diorite_bricks_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.MASSIVE_DIRT_BRICKS, "massive_dirt_bricks_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.MASSIVE_DRIPSTONE_BLOCK_BRICKS, "massive_dripstone_block_bricks_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.MASSIVE_END_STONE_BRICKS, "massive_end_stone_bricks_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.MASSIVE_GILDED_BLACKSTONE_BRICKS, "massive_gilded_blackstone_bricks_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.MASSIVE_ICE_BRICKS, "massive_ice_bricks_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.MASSIVE_LAPIS_BLOCK_BRICKS, "massive_lapis_block_bricks_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.MASSIVE_LODESTONE_BRICKS, "massive_lodestone_bricks_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.MASSIVE_MAGMA_BLOCK_BRICKS, "massive_magma_block_bricks_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MASSIVE_MOSSY_COBBLESTONE_BRICKS, "massive_mossy_cobblestone_bricks_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.MASSIVE_MOSSY_STONE_BRICKS_BRICKS, "massive_mossy_stone_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.MASSIVE_MUD_BRICKS, "massive_mud_bricks_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.MASSIVE_MUD_BRICKS_BRICKS, "massive_mud_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.MASSIVE_NETHER_BRICKS_BRICKS, "massive_nether_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.MASSIVE_NETHERRACK_BRICKS, "massive_netherrack_bricks_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.MASSIVE_OBSIDIAN_BRICKS, "massive_obsidian_bricks_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.MASSIVE_PACKED_ICE_BRICKS, "massive_packed_ice_bricks_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.MASSIVE_PACKED_MUD_BRICKS, "massive_packed_mud_bricks_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.MASSIVE_PRISMARINE_BRICKS, "massive_prismarine_bricks_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.MASSIVE_PURPUR_BLOCK_BRICKS, "massive_purpur_block_bricks_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.MASSIVE_QUARTZ_BLOCK_BRICKS, "massive_quartz_block_bricks_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.MASSIVE_RAW_COPPER_BLOCK_BRICKS, "massive_raw_copper_block_bricks_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.MASSIVE_RAW_GOLD_BLOCK_BRICKS, "massive_raw_gold_block_bricks_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.MASSIVE_RAW_IRON_BLOCK_BRICKS, "massive_raw_iron_block_bricks_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.MASSIVE_RED_NETHER_BRICKS_BRICKS, "massive_red_nether_bricks_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.MASSIVE_RED_SANDSTONE_BRICKS, "massive_red_sandstone_bricks_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.MASSIVE_REDSTONE_BLOCK_BRICKS, "massive_redstone_block_bricks_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.MASSIVE_SANDSTONE_BRICKS, "massive_sandstone_bricks_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.MASSIVE_SMOOTH_STONE_BRICKS, "massive_smooth_stone_bricks_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.MASSIVE_SNOW_BLOCK_BRICKS, "massive_snow_block_bricks_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.MASSIVE_TUFF_BRICKS, "massive_tuff_bricks_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_BEAMS.get(), "mossy_cobblestone_beams_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_DENTED.get(), "mossy_cobblestone_dented_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_INVERTED_DENTED.get(), "mossy_cobblestone_inverted_dented_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_PAVING.get(), "mossy_cobblestone_paving_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_SMALL_TILES.get(), "mossy_cobblestone_small_tiles_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_SQUARES.get(), "mossy_cobblestone_squares_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_STRIPES.get(), "mossy_cobblestone_stripes_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_WORN_STRIPES.get(), "mossy_cobblestone_worn_stripes_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.NATURAL_ACACIA_PLANKS, "natural_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.NATURAL_BAMBOO_PLANKS, "natural_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.NATURAL_BIRCH_PLANKS, "natural_birch_planks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.NATURAL_OAK_PLANKS, "natural_oak_planks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_BEAMS.get(), "nether_bricks_beams_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_BRICK_PATTERN.get(), "nether_bricks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_BRICK_PAVING.get(), "nether_bricks_brick_paving_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_CHISELED_SQUARES.get(), "nether_bricks_chiseled_squares_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_DIAGONAL_BRICKS.get(), "nether_bricks_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_LARGE_BRICKS.get(), "nether_bricks_large_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_LARGE_TILES.get(), "nether_bricks_large_tiles_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_ROTATED_BRICKS.get(), "nether_bricks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_SMALL_TILES.get(), "nether_bricks_small_tiles_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_SMOOTH.get(), "nether_bricks_smooth_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_SQUARES.get(), "nether_bricks_squares_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS_TILES.get(), "nether_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_BEAMS.get(), "netherite_block_beams_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_BRICKS.get(), "netherite_block_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_CHISELED.get(), "netherite_block_chiseled_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_COMPACTED.get(), "netherite_block_compacted_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_DECORATED.get(), "netherite_block_decorated_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_DIAGONAL_TILES.get(), "netherite_block_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_INDENTED.get(), "netherite_block_indented_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_PATTERNED.get(), "netherite_block_patterned_engraving");
        engraveOne(exporter, Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK_SMALL_TILES.get(), "netherite_block_small_tiles_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_BEAMS.get(), "netherrack_beams_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_BRICK_PATTERN.get(), "netherrack_brick_pattern_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_BRICK_PAVING.get(), "netherrack_brick_paving_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_BRICKS.get(), "netherrack_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_DENTED.get(), "netherrack_dented_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_ROTATED_BRICKS.get(), "netherrack_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_SMALL_TILES.get(), "netherrack_small_tiles_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_STRIPES.get(), "netherrack_stripes_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.NETHERRACK_TILES.get(), "netherrack_tiles_engraving");
        engraveOne(exporter, ModBlocks.OAK_BARRED_GLASS_CTM.get(), ModBlocks.OAK_BARRED_GLASS_CTM_PANE.get(), "oak_barred_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_BORDERED_GLASS, "oak_bordered_glass_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_BORDERED_GLASS_CTM, "oak_bordered_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_BORDERED_GLASS_CTM.get(), ModBlocks.OAK_BORDERED_GLASS_CTM_PANE.get(), "oak_bordered_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_DIAMOND_BORDERED_GLASS, "oak_diamond_bordered_glass_engraving");
        engraveOne(exporter, ModBlocks.OAK_DIAMOND_BORDERED_GLASS.get(), ModBlocks.OAK_DIAMOND_BORDERED_GLASS_PANE.get(), "oak_diamond_bordered_glass_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM, "oak_diamond_bordered_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM.get(), ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM_PANE.get(), "oak_diamond_bordered_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_HORIZONTAL_LINED_GLASS, "oak_horizontal_lined_glass_engraving");
        engraveOne(exporter, ModBlocks.OAK_HORIZONTAL_LINED_GLASS.get(), ModBlocks.OAK_HORIZONTAL_LINED_GLASS_PANE.get(), "oak_horizontal_lined_glass_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM, "oak_horizontal_lined_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM.get(), ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM_PANE.get(), "oak_horizontal_lined_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_LARGE_DIAMOND_GLASS, "oak_large_diamond_glass_engraving");
        engraveOne(exporter, ModBlocks.OAK_LARGE_DIAMOND_GLASS.get(), ModBlocks.OAK_LARGE_DIAMOND_GLASS_PANE.get(), "oak_large_diamond_glass_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM, "oak_large_diamond_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM.get(), ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM_PANE.get(), "oak_large_diamond_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_LINE_BARED_GLASS, "oak_line_bared_glass_engraving");
        engraveOne(exporter, ModBlocks.OAK_LINE_BARED_GLASS.get(), ModBlocks.OAK_LINE_BARED_GLASS_PANE.get(), "oak_line_bared_glass_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_LINE_BARED_GLASS_CTM, "oak_line_bared_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_LINE_BARED_GLASS_CTM.get(), ModBlocks.OAK_LINE_BARED_GLASS_CTM_PANE.get(), "oak_line_bared_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_ORNATE_BARED_GLASS, "oak_ornate_bared_glass_engraving");
        engraveOne(exporter, ModBlocks.OAK_ORNATE_BARED_GLASS.get(), ModBlocks.OAK_ORNATE_BARED_GLASS_PANE.get(), "oak_ornate_bared_glass_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_ORNATE_BARED_GLASS_CTM, "oak_ornate_bared_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_ORNATE_BARED_GLASS_CTM.get(), ModBlocks.OAK_ORNATE_BARED_GLASS_CTM_PANE.get(), "oak_ornate_bared_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_BEAMS.get(), "oak_planks_beams_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_BRICK_PATTERN.get(), "oak_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_BRICK_PAVING.get(), "oak_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_BRICKS.get(), "oak_planks_bricks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_CRATE.get(), "oak_planks_crate_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_DIAGONAL_STRIPES.get(), "oak_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_DIAGONAL_TILES.get(), "oak_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_DOTTED.get(), "oak_planks_dotted_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_FLOORING.get(), "oak_planks_flooring_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_LARGE_TILES.get(), "oak_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_PANEL, "oak_planks_panel_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_PATTERN.get(), "oak_planks_pattern_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_ROTATED_BRICKS.get(), "oak_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_SMALL_BRICKS.get(), "oak_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_SMALL_TILES.get(), "oak_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_SQUARES.get(), "oak_planks_squares_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_TILES.get(), "oak_planks_tiles_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_WAVY.get(), "oak_planks_wavy_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS_WOVEN.get(), "oak_planks_woven_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_WOVEN_GLASS, "oak_woven_glass_engraving");
        engraveOne(exporter, ModBlocks.OAK_WOVEN_GLASS.get(), ModBlocks.OAK_WOVEN_GLASS_PANE.get(), "oak_woven_glass_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.OAK_WOVEN_GLASS_CTM, "oak_woven_glass_ctm_engraving");
        engraveOne(exporter, ModBlocks.OAK_WOVEN_GLASS_CTM.get(), ModBlocks.OAK_WOVEN_GLASS_CTM_PANE.get(), "oak_woven_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BORDERED.get(), "obsidian_bordered_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BRICK_PATTERN.get(), "obsidian_brick_pattern_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BRICK_PAVING.get(), "obsidian_brick_paving_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BRICKS.get(), "obsidian_bricks_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_CHISELED.get(), "obsidian_chiseled_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_CHISELED_CIRCLES.get(), "obsidian_chiseled_circles_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_DARK.get(), "obsidian_dark_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_ROTATED_BRICKS.get(), "obsidian_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_SPOTS.get(), "obsidian_spots_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_SQUARES.get(), "obsidian_squares_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_STRIPES.get(), "obsidian_stripes_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_TILES.get(), "obsidian_tiles_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_CONCRETE_CTM, "orange_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_CONCRETE_PANEL, "orange_concrete_panel_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.ORANGE_TERRACOTTA_COLUMN, "orange_terracotta_column_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.ORANGE_TERRACOTTA_CTM, "orange_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.ORNATE_AMETHYST_BLOCK_CTM, "ornate_amethyst_block_pillar_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.ORNATE_ANCIENT_DEBRIS_CTM, "ornate_ancient_debris_pillar_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.ORNATE_ANDESITE_CTM, "ornate_andesite_pillar_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.ORNATE_BASALT_CTM, "ornate_basalt_pillar_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.ORNATE_BLACKSTONE_CTM, "ornate_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.ORNATE_BLUE_ICE_CTM, "ornate_blue_ice_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.ORNATE_BORDERLESS_BRICKS_CTM, "ornate_borderless_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.ORNATE_BRICKS_CTM, "ornate_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.ORNATE_CALCITE_CTM, "ornate_calcite_pillar_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.ORNATE_CLAY_CTM, "ornate_clay_pillar_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.ORNATE_COAL_BLOCK_CTM, "ornate_coal_block_pillar_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.ORNATE_COBBLESTONE_CTM, "ornate_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.ORNATE_CRYING_OBSIDIAN_CTM, "ornate_crying_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.ORNATE_DARK_PRISMARINE_CTM, "ornate_dark_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.ORNATE_DEEPSLATE_CTM, "ornate_deepslate_pillar_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.ORNATE_DIORITE_CTM, "ornate_diorite_pillar_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.ORNATE_DIRT_CTM, "ornate_dirt_pillar_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.ORNATE_DRIPSTONE_BLOCK_CTM, "ornate_dripstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.ORNATE_END_STONE_CTM, "ornate_end_stone_pillar_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.ORNATE_GILDED_BLACKSTONE_CTM, "ornate_gilded_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.ORNATE_ICE_CTM, "ornate_ice_pillar_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.ORNATE_LAPIS_BLOCK_CTM, "ornate_lapis_block_pillar_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.ORNATE_LEADED_GLASS, "ornate_leaded_glass_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.ORNATE_LODESTONE_CTM, "ornate_lodestone_pillar_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.ORNATE_MAGMA_BLOCK_CTM, "ornate_magma_block_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.ORNATE_MOSSY_COBBLESTONE_CTM, "ornate_mossy_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.ORNATE_MOSSY_STONE_BRICKS_CTM, "ornate_mossy_stone_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.ORNATE_MUD_BRICKS_CTM, "ornate_mud_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.ORNATE_MUD_CTM, "ornate_mud_pillar_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.ORNATE_NETHER_BRICKS_CTM, "ornate_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.ORNATE_NETHERRACK_CTM, "ornate_netherrack_pillar_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.ORNATE_OBSIDIAN_CTM, "ornate_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.ORNATE_PACKED_ICE_CTM, "ornate_packed_ice_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.ORNATE_PACKED_MUD_CTM, "ornate_packed_mud_pillar_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.ORNATE_PRISMARINE_CTM, "ornate_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.ORNATE_PURPUR_BLOCK_CTM, "ornate_purpur_block_pillar_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.ORNATE_QUARTZ_BLOCK_CTM, "ornate_quartz_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.ORNATE_RAW_COPPER_BLOCK_CTM, "ornate_raw_copper_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.ORNATE_RAW_GOLD_BLOCK_CTM, "ornate_raw_gold_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.ORNATE_RAW_IRON_BLOCK_CTM, "ornate_raw_iron_block_pillar_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.ORNATE_RED_NETHER_BRICKS_CTM, "ornate_red_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.ORNATE_RED_SANDSTONE_CTM, "ornate_red_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.ORNATE_REDSTONE_BLOCK_CTM, "ornate_redstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.ORNATE_SANDSTONE_CTM, "ornate_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.ORNATE_SMOOTH_STONE_CTM, "ornate_smooth_stone_pillar_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.ORNATE_SNOW_BLOCK_CTM, "ornate_snow_block_pillar_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.ORNATE_TUFF_CTM, "ornate_tuff_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.OVERLAPPING_AMETHYST_BLOCK_TILES, "overlapping_amethyst_block_tiles_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.OVERLAPPING_ANCIENT_DEBRIS_TILES, "overlapping_ancient_debris_tiles_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.OVERLAPPING_ANDESITE_TILES, "overlapping_andesite_tiles_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.OVERLAPPING_BASALT_TILES, "overlapping_basalt_tiles_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.OVERLAPPING_BLACKSTONE_TILES, "overlapping_blackstone_tiles_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.OVERLAPPING_BLUE_ICE_TILES, "overlapping_blue_ice_tiles_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.OVERLAPPING_BORDERLESS_BRICKS_TILES, "overlapping_borderless_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.OVERLAPPING_BRICKS_TILES, "overlapping_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.OVERLAPPING_CALCITE_TILES, "overlapping_calcite_tiles_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.OVERLAPPING_CLAY_TILES, "overlapping_clay_tiles_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.OVERLAPPING_COAL_BLOCK_TILES, "overlapping_coal_block_tiles_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.OVERLAPPING_COBBLESTONE_TILES, "overlapping_cobblestone_tiles_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.OVERLAPPING_CRYING_OBSIDIAN_TILES, "overlapping_crying_obsidian_tiles_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.OVERLAPPING_DARK_PRISMARINE_TILES, "overlapping_dark_prismarine_tiles_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.OVERLAPPING_DEEPSLATE_TILES, "overlapping_deepslate_tiles_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.OVERLAPPING_DIORITE_TILES, "overlapping_diorite_tiles_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.OVERLAPPING_DIRT_TILES, "overlapping_dirt_tiles_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.OVERLAPPING_DRIPSTONE_BLOCK_TILES, "overlapping_dripstone_block_tiles_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.OVERLAPPING_END_STONE_TILES, "overlapping_end_stone_tiles_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.OVERLAPPING_GILDED_BLACKSTONE_TILES, "overlapping_gilded_blackstone_tiles_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.OVERLAPPING_ICE_TILES, "overlapping_ice_tiles_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.OVERLAPPING_LAPIS_BLOCK_TILES, "overlapping_lapis_block_tiles_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.OVERLAPPING_LODESTONE_TILES, "overlapping_lodestone_tiles_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.OVERLAPPING_MAGMA_BLOCK_TILES, "overlapping_magma_block_tiles_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.OVERLAPPING_MOSSY_COBBLESTONE_TILES, "overlapping_mossy_cobblestone_tiles_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.OVERLAPPING_MOSSY_STONE_BRICKS_TILES, "overlapping_mossy_stone_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.OVERLAPPING_MUD_BRICKS_TILES, "overlapping_mud_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.OVERLAPPING_MUD_TILES, "overlapping_mud_tiles_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.OVERLAPPING_NETHER_BRICKS_TILES, "overlapping_nether_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.OVERLAPPING_NETHERRACK_TILES, "overlapping_netherrack_tiles_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.OVERLAPPING_OBSIDIAN_TILES, "overlapping_obsidian_tiles_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.OVERLAPPING_PACKED_ICE_TILES, "overlapping_packed_ice_tiles_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.OVERLAPPING_PACKED_MUD_TILES, "overlapping_packed_mud_tiles_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.OVERLAPPING_PRISMARINE_TILES, "overlapping_prismarine_tiles_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.OVERLAPPING_PURPUR_BLOCK_TILES, "overlapping_purpur_block_tiles_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.OVERLAPPING_QUARTZ_BLOCK_TILES, "overlapping_quartz_block_tiles_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.OVERLAPPING_RAW_COPPER_BLOCK_TILES, "overlapping_raw_copper_block_tiles_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.OVERLAPPING_RAW_GOLD_BLOCK_TILES, "overlapping_raw_gold_block_tiles_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.OVERLAPPING_RAW_IRON_BLOCK_TILES, "overlapping_raw_iron_block_tiles_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.OVERLAPPING_RED_NETHER_BRICKS_TILES, "overlapping_red_nether_bricks_tiles_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.OVERLAPPING_RED_SANDSTONE_TILES, "overlapping_red_sandstone_tiles_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.OVERLAPPING_REDSTONE_BLOCK_TILES, "overlapping_redstone_block_tiles_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.OVERLAPPING_SANDSTONE_TILES, "overlapping_sandstone_tiles_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.OVERLAPPING_SMOOTH_STONE_TILES, "overlapping_smooth_stone_tiles_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.OVERLAPPING_SNOW_BLOCK_TILES, "overlapping_snow_block_tiles_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.OVERLAPPING_TUFF_TILES, "overlapping_tuff_tiles_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.PEGGED_ACACIA_PLANKS, "pegged_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.PEGGED_BIRCH_PLANKS, "pegged_birch_planks_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.PEGGED_BLACK_CONCRETE, "pegged_black_concrete_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.PEGGED_BLUE_CONCRETE, "pegged_blue_concrete_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.PEGGED_BROWN_CONCRETE, "pegged_brown_concrete_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.PEGGED_CYAN_CONCRETE, "pegged_cyan_concrete_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.PEGGED_GRAY_CONCRETE, "pegged_gray_concrete_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.PEGGED_GREEN_CONCRETE, "pegged_green_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.PEGGED_LIGHT_BLUE_CONCRETE, "pegged_light_blue_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.PEGGED_LIGHT_GRAY_CONCRETE, "pegged_light_gray_concrete_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.PEGGED_LIME_CONCRETE, "pegged_lime_concrete_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.PEGGED_MAGENTA_CONCRETE, "pegged_magenta_concrete_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.PEGGED_OAK_PLANKS, "pegged_oak_planks_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.PEGGED_ORANGE_CONCRETE, "pegged_orange_concrete_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.PEGGED_PINK_CONCRETE, "pegged_pink_concrete_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.PEGGED_PURPLE_CONCRETE, "pegged_purple_concrete_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.PEGGED_RED_CONCRETE, "pegged_red_concrete_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.PEGGED_WHITE_CONCRETE, "pegged_white_concrete_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.PEGGED_YELLOW_CONCRETE, "pegged_yellow_concrete_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.PINK_CONCRETE_CTM, "pink_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.PINK_CONCRETE_PANEL, "pink_concrete_panel_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.PINK_TERRACOTTA_COLUMN, "pink_terracotta_column_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.PINK_TERRACOTTA_CTM, "pink_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.POLISHED_AMETHYST_BLOCK, "polished_amethyst_block_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.POLISHED_ANCIENT_DEBRIS, "polished_ancient_debris_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.POLISHED_BAMBOO_PLANKS, "polished_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.POLISHED_BASALT, "polished_basalt_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.POLISHED_BIRCH_PLANKS, "polished_birch_planks_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.POLISHED_BLUE_ICE, "polished_blue_ice_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.POLISHED_BORDERLESS_BRICKS, "polished_borderless_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.POLISHED_BRICKS, "polished_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.POLISHED_CALCITE, "polished_calcite_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.POLISHED_CLAY, "polished_clay_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.POLISHED_COAL_BLOCK, "polished_coal_block_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.POLISHED_COBBLESTONE, "polished_cobblestone_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.POLISHED_CRYING_OBSIDIAN, "polished_crying_obsidian_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.POLISHED_DARK_PRISMARINE, "polished_dark_prismarine_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.POLISHED_DEEPSLATE, "polished_deepslate_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.POLISHED_DIRT, "polished_dirt_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.POLISHED_DRIPSTONE_BLOCK, "polished_dripstone_block_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.POLISHED_END_STONE, "polished_end_stone_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.POLISHED_GILDED_BLACKSTONE, "polished_gilded_blackstone_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.POLISHED_ICE, "polished_ice_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.POLISHED_LAPIS_BLOCK, "polished_lapis_block_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.POLISHED_LODESTONE, "polished_lodestone_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.POLISHED_MAGMA_BLOCK, "polished_magma_block_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.POLISHED_MOSSY_COBBLESTONE, "polished_mossy_cobblestone_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.POLISHED_MOSSY_STONE_BRICKS, "polished_mossy_stone_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.POLISHED_NETHER_BRICKS, "polished_nether_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.POLISHED_NETHERRACK, "polished_netherrack_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.POLISHED_OBSIDIAN, "polished_obsidian_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.POLISHED_PACKED_ICE, "polished_packed_ice_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.POLISHED_PRISMARINE, "polished_prismarine_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.POLISHED_PURPUR_BLOCK, "polished_purpur_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.POLISHED_QUARTZ_BLOCK, "polished_quartz_block_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.POLISHED_RAW_COPPER_BLOCK, "polished_raw_copper_block_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.POLISHED_RAW_GOLD_BLOCK, "polished_raw_gold_block_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.POLISHED_RAW_IRON_BLOCK, "polished_raw_iron_block_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.POLISHED_RED_NETHER_BRICKS, "polished_red_nether_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.POLISHED_RED_SANDSTONE, "polished_red_sandstone_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.POLISHED_REDSTONE_BLOCK, "polished_redstone_block_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.POLISHED_SANDSTONE, "polished_sandstone_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.POLISHED_SMOOTH_STONE, "polished_smooth_stone_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.POLISHED_SNOW_BLOCK, "polished_snow_block_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.POLISHED_TUFF, "polished_tuff_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_CONCRETE_CTM, "purple_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_CONCRETE_PANEL, "purple_concrete_panel_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.PURPLE_TERRACOTTA_COLUMN, "purple_terracotta_column_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.PURPLE_TERRACOTTA_CTM, "purple_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK.get(), "quartz_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_BORDERED.get(), "quartz_block_bordered_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_BRICK_PAVING.get(), "quartz_block_brick_paving_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_CHISELED_CTM.get(), "quartz_block_chiseled_pillar_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_CONNECTING.get(), "quartz_block_connecting_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_CROSSES.get(), "quartz_block_crosses_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_DIAGONAL_TILES.get(), "quartz_block_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_PATTERN.get(), "quartz_block_pattern_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_ROTATED_BRICKS.get(), "quartz_block_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_ROWS.get(), "quartz_block_rows_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_SCALES.get(), "quartz_block_scales_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_SMALL_TILES.get(), "quartz_block_small_tiles_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_SQUARES.get(), "quartz_block_squares_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_STRIPES.get(), "quartz_block_stripes_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK_TILES.get(), "quartz_block_tiles_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.RASTER_LEADED_GLASS, "raster_leaded_glass_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.RASTER_LEADED_GLASS_CTM, "raster_leaded_glass_pillar_engraving");
        engraveOne(exporter, ModBlocks.RASTER_LEADED_GLASS_CTM.get(), ModBlocks.RASTER_LEADED_GLASS_CTM_PANE.get(), "raster_leaded_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.BLACK_WOOL, ModBlocks.RECTANGLE_BLACK_WOOL, "rectangle_black_wool_engraving");
        engraveOne(exporter, Blocks.BLUE_WOOL, ModBlocks.RECTANGLE_BLUE_WOOL, "rectangle_blue_wool_engraving");
        engraveOne(exporter, Blocks.BROWN_WOOL, ModBlocks.RECTANGLE_BROWN_WOOL, "rectangle_brown_wool_engraving");
        // --- RECOVERED WAVE4 ---
        engraveOne(exporter, Blocks.CYAN_WOOL, ModBlocks.RECTANGLE_CYAN_WOOL, "rectangle_cyan_wool_engraving");
        engraveOne(exporter, Blocks.GRAY_WOOL, ModBlocks.RECTANGLE_GRAY_WOOL, "rectangle_gray_wool_engraving");
        engraveOne(exporter, Blocks.GREEN_WOOL, ModBlocks.RECTANGLE_GREEN_WOOL, "rectangle_green_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_WOOL, ModBlocks.RECTANGLE_LIGHT_BLUE_WOOL, "rectangle_light_blue_wool_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_WOOL, ModBlocks.RECTANGLE_LIGHT_GRAY_WOOL, "rectangle_light_gray_wool_engraving");
        engraveOne(exporter, Blocks.LIME_WOOL, ModBlocks.RECTANGLE_LIME_WOOL, "rectangle_lime_wool_engraving");
        engraveOne(exporter, Blocks.MAGENTA_WOOL, ModBlocks.RECTANGLE_MAGENTA_WOOL, "rectangle_magenta_wool_engraving");
        engraveOne(exporter, Blocks.ORANGE_WOOL, ModBlocks.RECTANGLE_ORANGE_WOOL, "rectangle_orange_wool_engraving");
        engraveOne(exporter, Blocks.PINK_WOOL, ModBlocks.RECTANGLE_PINK_WOOL, "rectangle_pink_wool_engraving");
        engraveOne(exporter, Blocks.PURPLE_WOOL, ModBlocks.RECTANGLE_PURPLE_WOOL, "rectangle_purple_wool_engraving");
        engraveOne(exporter, Blocks.RED_WOOL, ModBlocks.RECTANGLE_RED_WOOL, "rectangle_red_wool_engraving");
        engraveOne(exporter, Blocks.WHITE_WOOL, ModBlocks.RECTANGLE_WHITE_WOOL, "rectangle_white_wool_engraving");
        engraveOne(exporter, Blocks.YELLOW_WOOL, ModBlocks.RECTANGLE_YELLOW_WOOL, "rectangle_yellow_wool_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.RED_CONCRETE_CTM, "red_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.RED_CONCRETE_PANEL, "red_concrete_panel_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_BRICK_PATTERN.get(), "red_sandstone_brick_pattern_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_BRICK_PAVING.get(), "red_sandstone_brick_paving_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_BRICKS.get(), "red_sandstone_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_DIAGONAL_BRICKS.get(), "red_sandstone_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_LARGE_TILES.get(), "red_sandstone_large_tiles_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_POLISHED.get(), "red_sandstone_polished_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_ROTATED_BRICKS.get(), "red_sandstone_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_TILES.get(), "red_sandstone_tiles_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.RED_TERRACOTTA_COLUMN, "red_terracotta_column_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.RED_TERRACOTTA_CTM, "red_terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_BORDERED.get(), "redstone_block_bordered_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_BRICKS.get(), "redstone_block_bricks_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_CHISELED_CLOVERS.get(), "redstone_block_chiseled_clovers_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_CIRCLES.get(), "redstone_block_circles_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_COMPRESSED.get(), "redstone_block_compressed_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_CTM.get(), "redstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_DIAGONAL_TILES.get(), "redstone_block_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_PATTERNED.get(), "redstone_block_patterned_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_PAVING.get(), "redstone_block_paving_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_POLISHED.get(), "redstone_block_polished_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_SCALES.get(), "redstone_block_scales_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK_SMALL_TILES.get(), "redstone_block_small_tiles_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_BRICK_PATTERN.get(), "sandstone_brick_pattern_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_BRICK_PAVING.get(), "sandstone_brick_paving_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_BRICKS.get(), "sandstone_bricks_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_DIAGONAL_BRICKS.get(), "sandstone_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_LARGE_TILES.get(), "sandstone_large_tiles_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_POLISHED.get(), "sandstone_polished_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_ROTATED_BRICKS.get(), "sandstone_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SANDSTONE_TILES.get(), "sandstone_tiles_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.SCALY_MUD, "scaly_mud_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.SCALY_PACKED_MUD, "scaly_packed_mud_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.SIMPLE_AMETHYST_BLOCK_CTM, "simple_amethyst_block_pillar_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.SIMPLE_ANCIENT_DEBRIS_CTM, "simple_ancient_debris_pillar_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.SIMPLE_ANDESITE_CTM, "simple_andesite_pillar_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.SIMPLE_BASALT_CTM, "simple_basalt_pillar_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.SIMPLE_BLACKSTONE_CTM, "simple_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.SIMPLE_BLUE_ICE_CTM, "simple_blue_ice_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.SIMPLE_BORDERLESS_BRICKS_CTM, "simple_borderless_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.SIMPLE_BRICKS_CTM, "simple_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.SIMPLE_CALCITE_CTM, "simple_calcite_pillar_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.SIMPLE_CLAY_CTM, "simple_clay_pillar_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.SIMPLE_COAL_BLOCK_CTM, "simple_coal_block_pillar_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.SIMPLE_COBBLESTONE_CTM, "simple_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.SIMPLE_CRYING_OBSIDIAN_CTM, "simple_crying_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.SIMPLE_DARK_PRISMARINE_CTM, "simple_dark_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.SIMPLE_DEEPSLATE_CTM, "simple_deepslate_pillar_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.SIMPLE_DIORITE_CTM, "simple_diorite_pillar_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.SIMPLE_DIRT_CTM, "simple_dirt_pillar_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.SIMPLE_DRIPSTONE_BLOCK_CTM, "simple_dripstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.SIMPLE_END_STONE_CTM, "simple_end_stone_pillar_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.SIMPLE_GILDED_BLACKSTONE_CTM, "simple_gilded_blackstone_pillar_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.SIMPLE_ICE_CTM, "simple_ice_pillar_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.SIMPLE_LAPIS_BLOCK_CTM, "simple_lapis_block_pillar_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.SIMPLE_LODESTONE_CTM, "simple_lodestone_pillar_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.SIMPLE_MAGMA_BLOCK_CTM, "simple_magma_block_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.SIMPLE_MOSSY_COBBLESTONE_CTM, "simple_mossy_cobblestone_pillar_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.SIMPLE_MOSSY_STONE_BRICKS_CTM, "simple_mossy_stone_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.SIMPLE_MUD_BRICKS_CTM, "simple_mud_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.SIMPLE_MUD_CTM, "simple_mud_pillar_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.SIMPLE_NETHER_BRICKS_CTM, "simple_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.SIMPLE_NETHERRACK_CTM, "simple_netherrack_pillar_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.SIMPLE_OBSIDIAN_CTM, "simple_obsidian_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.SIMPLE_PACKED_ICE_CTM, "simple_packed_ice_pillar_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.SIMPLE_PACKED_MUD_CTM, "simple_packed_mud_pillar_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.SIMPLE_PRISMARINE_CTM, "simple_prismarine_pillar_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.SIMPLE_PURPUR_BLOCK_CTM, "simple_purpur_block_pillar_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.SIMPLE_QUARTZ_BLOCK_CTM, "simple_quartz_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.SIMPLE_RAW_COPPER_BLOCK_CTM, "simple_raw_copper_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.SIMPLE_RAW_GOLD_BLOCK_CTM, "simple_raw_gold_block_pillar_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.SIMPLE_RAW_IRON_BLOCK_CTM, "simple_raw_iron_block_pillar_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.SIMPLE_RED_NETHER_BRICKS_CTM, "simple_red_nether_bricks_pillar_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.SIMPLE_RED_SANDSTONE_CTM, "simple_red_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.SIMPLE_REDSTONE_BLOCK_CTM, "simple_redstone_block_pillar_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SIMPLE_SANDSTONE_CTM, "simple_sandstone_pillar_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.SIMPLE_SMOOTH_STONE_CTM, "simple_smooth_stone_pillar_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.SIMPLE_SNOW_BLOCK_CTM, "simple_snow_block_pillar_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.SIMPLE_TUFF_CTM, "simple_tuff_pillar_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.SMALL_BLACK_TERRACOTTA_TILES, "small_black_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.SMALL_BLUE_TERRACOTTA_TILES, "small_blue_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.SMALL_BROWN_TERRACOTTA_TILES, "small_brown_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.SMALL_CYAN_TERRACOTTA_TILES, "small_cyan_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.SMALL_DIAMOND_LEADED_GLASS, "small_diamond_leaded_glass_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM, "small_diamond_leaded_glass_pillar_engraving");
        engraveOne(exporter, ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM.get(), ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM_PANE.get(), "small_diamond_leaded_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.SMALL_GRAY_TERRACOTTA_TILES, "small_gray_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.SMALL_GREEN_TERRACOTTA_TILES, "small_green_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.SMALL_LIGHT_BLUE_TERRACOTTA_TILES, "small_light_blue_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.SMALL_LIGHT_GRAY_TERRACOTTA_TILES, "small_light_gray_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.SMALL_LIME_TERRACOTTA_TILES, "small_lime_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.SMALL_MAGENTA_TERRACOTTA_TILES, "small_magenta_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.SMALL_ORANGE_TERRACOTTA_TILES, "small_orange_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.SMALL_PINK_TERRACOTTA_TILES, "small_pink_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.SMALL_PURPLE_TERRACOTTA_TILES, "small_purple_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.SMALL_RED_TERRACOTTA_TILES, "small_red_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.SMALL_TERRACOTTA_TILES, "small_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.WHITE_TERRACOTTA, ModBlocks.SMALL_WHITE_TERRACOTTA_TILES, "small_white_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.SMALL_YELLOW_TERRACOTTA_TILES, "small_yellow_terracotta_tiles_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.SMOOTH_AMETHYST_BLOCK_COLUMN, "smooth_amethyst_block_column_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.SMOOTH_ANCIENT_DEBRIS_COLUMN, "smooth_ancient_debris_column_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.SMOOTH_ANDESITE_COLUMN, "smooth_andesite_column_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.SMOOTH_BASALT_COLUMN, "smooth_basalt_column_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.SMOOTH_BLACK_CONCRETE, "smooth_black_concrete_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.SMOOTH_BLACKSTONE_COLUMN, "smooth_blackstone_column_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.SMOOTH_BLUE_CONCRETE, "smooth_blue_concrete_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.SMOOTH_BLUE_ICE_COLUMN, "smooth_blue_ice_column_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.SMOOTH_BORDERLESS_BRICKS_COLUMN, "smooth_borderless_bricks_column_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.SMOOTH_BRICKS_COLUMN, "smooth_bricks_column_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.SMOOTH_BROWN_CONCRETE, "smooth_brown_concrete_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.SMOOTH_CALCITE_COLUMN, "smooth_calcite_column_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.SMOOTH_CLAY_COLUMN, "smooth_clay_column_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.SMOOTH_COAL_BLOCK_COLUMN, "smooth_coal_block_column_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.SMOOTH_COBBLESTONE_COLUMN, "smooth_cobblestone_column_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.SMOOTH_CRYING_OBSIDIAN_COLUMN, "smooth_crying_obsidian_column_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.SMOOTH_CYAN_CONCRETE, "smooth_cyan_concrete_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.SMOOTH_DARK_PRISMARINE_COLUMN, "smooth_dark_prismarine_column_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.SMOOTH_DEEPSLATE_COLUMN, "smooth_deepslate_column_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.SMOOTH_DIORITE_COLUMN, "smooth_diorite_column_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.SMOOTH_DIRT_COLUMN, "smooth_dirt_column_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.SMOOTH_DRIPSTONE_BLOCK_COLUMN, "smooth_dripstone_block_column_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.SMOOTH_END_STONE_COLUMN, "smooth_end_stone_column_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.SMOOTH_GILDED_BLACKSTONE_COLUMN, "smooth_gilded_blackstone_column_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.SMOOTH_GRAY_CONCRETE, "smooth_gray_concrete_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.SMOOTH_GREEN_CONCRETE, "smooth_green_concrete_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.SMOOTH_ICE_COLUMN, "smooth_ice_column_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.SMOOTH_LAPIS_BLOCK_COLUMN, "smooth_lapis_block_column_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.SMOOTH_LIGHT_BLUE_CONCRETE, "smooth_light_blue_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.SMOOTH_LIGHT_GRAY_CONCRETE, "smooth_light_gray_concrete_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.SMOOTH_LIME_CONCRETE, "smooth_lime_concrete_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.SMOOTH_LODESTONE_COLUMN, "smooth_lodestone_column_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.SMOOTH_MAGENTA_CONCRETE, "smooth_magenta_concrete_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.SMOOTH_MAGMA_BLOCK_COLUMN, "smooth_magma_block_column_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.SMOOTH_MOSSY_COBBLESTONE_COLUMN, "smooth_mossy_cobblestone_column_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.SMOOTH_MOSSY_STONE_BRICKS_COLUMN, "smooth_mossy_stone_bricks_column_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.SMOOTH_NETHER_BRICKS_COLUMN, "smooth_nether_bricks_column_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.SMOOTH_NETHERRACK_COLUMN, "smooth_netherrack_column_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.SMOOTH_OBSIDIAN_COLUMN, "smooth_obsidian_column_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.SMOOTH_ORANGE_CONCRETE, "smooth_orange_concrete_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.SMOOTH_PACKED_ICE_COLUMN, "smooth_packed_ice_column_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.SMOOTH_PINK_CONCRETE, "smooth_pink_concrete_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.SMOOTH_PRISMARINE_COLUMN, "smooth_prismarine_column_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.SMOOTH_PURPLE_CONCRETE, "smooth_purple_concrete_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.SMOOTH_PURPUR_BLOCK_COLUMN, "smooth_purpur_block_column_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.SMOOTH_QUARTZ_BLOCK_COLUMN, "smooth_quartz_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.SMOOTH_RAW_COPPER_BLOCK_COLUMN, "smooth_raw_copper_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.SMOOTH_RAW_GOLD_BLOCK_COLUMN, "smooth_raw_gold_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.SMOOTH_RAW_IRON_BLOCK_COLUMN, "smooth_raw_iron_block_column_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.SMOOTH_RED_CONCRETE, "smooth_red_concrete_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.SMOOTH_RED_NETHER_BRICKS_COLUMN, "smooth_red_nether_bricks_column_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.SMOOTH_RED_SANDSTONE_COLUMN, "smooth_red_sandstone_column_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.SMOOTH_REDSTONE_BLOCK_COLUMN, "smooth_redstone_block_column_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.SMOOTH_SANDSTONE_COLUMN, "smooth_sandstone_column_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.SMOOTH_SMOOTH_STONE_COLUMN, "smooth_smooth_stone_column_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.SMOOTH_SNOW_BLOCK_COLUMN, "smooth_snow_block_column_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.SMOOTH_TUFF_COLUMN, "smooth_tuff_column_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.SMOOTH_WHITE_CONCRETE, "smooth_white_concrete_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.SMOOTH_YELLOW_CONCRETE, "smooth_yellow_concrete_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_BEAMS.get(), "spruce_planks_beams_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_BRICK_PATTERN.get(), "spruce_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_BRICK_PAVING.get(), "spruce_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_BRICKS.get(), "spruce_planks_bricks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_CRATE.get(), "spruce_planks_crate_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_DIAGONAL_STRIPES.get(), "spruce_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_DIAGONAL_TILES.get(), "spruce_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_DOTTED.get(), "spruce_planks_dotted_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_FLOORING.get(), "spruce_planks_flooring_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_LARGE_TILES.get(), "spruce_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_PANEL, "spruce_planks_panel_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_PATTERN.get(), "spruce_planks_pattern_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_ROTATED_BRICKS.get(), "spruce_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_SMALL_BRICKS.get(), "spruce_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_SMALL_TILES.get(), "spruce_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_SQUARES.get(), "spruce_planks_squares_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_TILES.get(), "spruce_planks_tiles_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_WAVY.get(), "spruce_planks_wavy_engraving");
        engraveOne(exporter, Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS_WOVEN.get(), "spruce_planks_woven_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.SQUARE_LEADED_GLASS, "square_leaded_glass_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.SQUARE_OAK_GLASS, "square_oak_glass_engraving");
        engraveOne(exporter, ModBlocks.SQUARE_OAK_GLASS_CTM.get(), ModBlocks.SQUARE_OAK_GLASS_CTM_PANE.get(), "square_oak_glass_ctm_pane_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.SQUARE_OAK_GLASS_CTM, "square_oak_glass_ctm_engraving");
        engraveOne(exporter, Blocks.BLACK_TERRACOTTA, ModBlocks.STARRY_BLACK_TERRACOTTA, "starry_black_terracotta_engraving");
        engraveOne(exporter, Blocks.BLUE_TERRACOTTA, ModBlocks.STARRY_BLUE_TERRACOTTA, "starry_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.BROWN_TERRACOTTA, ModBlocks.STARRY_BROWN_TERRACOTTA, "starry_brown_terracotta_engraving");
        engraveOne(exporter, Blocks.CYAN_TERRACOTTA, ModBlocks.STARRY_CYAN_TERRACOTTA, "starry_cyan_terracotta_engraving");
        engraveOne(exporter, Blocks.GRAY_TERRACOTTA, ModBlocks.STARRY_GRAY_TERRACOTTA, "starry_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.GREEN_TERRACOTTA, ModBlocks.STARRY_GREEN_TERRACOTTA, "starry_green_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.STARRY_LIGHT_BLUE_TERRACOTTA, "starry_light_blue_terracotta_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.STARRY_LIGHT_GRAY_TERRACOTTA, "starry_light_gray_terracotta_engraving");
        engraveOne(exporter, Blocks.LIME_TERRACOTTA, ModBlocks.STARRY_LIME_TERRACOTTA, "starry_lime_terracotta_engraving");
        engraveOne(exporter, Blocks.MAGENTA_TERRACOTTA, ModBlocks.STARRY_MAGENTA_TERRACOTTA, "starry_magenta_terracotta_engraving");
        engraveOne(exporter, Blocks.ORANGE_TERRACOTTA, ModBlocks.STARRY_ORANGE_TERRACOTTA, "starry_orange_terracotta_engraving");
        engraveOne(exporter, Blocks.PINK_TERRACOTTA, ModBlocks.STARRY_PINK_TERRACOTTA, "starry_pink_terracotta_engraving");
        engraveOne(exporter, Blocks.PURPLE_TERRACOTTA, ModBlocks.STARRY_PURPLE_TERRACOTTA, "starry_purple_terracotta_engraving");
        engraveOne(exporter, Blocks.RED_TERRACOTTA, ModBlocks.STARRY_RED_TERRACOTTA, "starry_red_terracotta_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.STARRY_TERRACOTTA, "starry_terracotta_engraving");
        engraveOne(exporter, Blocks.WHITE_TERRACOTTA, ModBlocks.STARRY_WHITE_TERRACOTTA, "starry_white_terracotta_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.STARRY_YELLOW_TERRACOTTA, "starry_yellow_terracotta_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_BIG_TILES.get(), "stone_big_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_BORDERED.get(), "stone_bordered_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_BRICK_PATTERN.get(), "stone_brick_pattern_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_BRICK_PAVING.get(), "stone_brick_paving_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_CHISELED_BRICKS.get(), "stone_chiseled_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_CRUSHED.get(), "stone_crushed_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_DIAGONAL_BRICKS.get(), "stone_diagonal_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_PATH.get(), "stone_path_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_ROTATED_BRICKS.get(), "stone_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SLATED_END.get(), "stone_slated_end_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMALL_BRICKS.get(), "stone_small_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMALL_TILES.get(), "stone_small_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMOOTH.get(), "stone_smooth_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMOOTH_BRICK_PAVING.get(), "stone_smooth_brick_paving_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMOOTH_LARGE_TILES.get(), "stone_smooth_large_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMOOTH_ROTATED_BRICKS.get(), "stone_smooth_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SMOOTH_TILES.get(), "stone_smooth_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_SQUARES.get(), "stone_squares_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_TILES.get(), "stone_tiles_engraving");
        engraveOne(exporter, Blocks.STONE, ModBlocks.STONE_WAVES.get(), "stone_waves_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.STRIPED_BLACK_CONCRETE, "striped_black_concrete_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.STRIPED_BLUE_CONCRETE, "striped_blue_concrete_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.STRIPED_BROWN_CONCRETE, "striped_brown_concrete_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.STRIPED_CYAN_CONCRETE, "striped_cyan_concrete_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.STRIPED_GRAY_CONCRETE, "striped_gray_concrete_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.STRIPED_GREEN_CONCRETE, "striped_green_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.STRIPED_LIGHT_BLUE_CONCRETE, "striped_light_blue_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.STRIPED_LIGHT_GRAY_CONCRETE, "striped_light_gray_concrete_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.STRIPED_LIME_CONCRETE, "striped_lime_concrete_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.STRIPED_MAGENTA_CONCRETE, "striped_magenta_concrete_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.STRIPED_ORANGE_CONCRETE, "striped_orange_concrete_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.STRIPED_PINK_CONCRETE, "striped_pink_concrete_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.STRIPED_PURPLE_CONCRETE, "striped_purple_concrete_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.STRIPED_RED_CONCRETE, "striped_red_concrete_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.STRIPED_WHITE_CONCRETE, "striped_white_concrete_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.STRIPED_YELLOW_CONCRETE, "striped_yellow_concrete_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.TERRACOTTA_COLUMN, "terracotta_column_engraving");
        engraveOne(exporter, Blocks.TERRACOTTA, ModBlocks.TERRACOTTA_CTM, "terracotta_pillar_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.THICK_INLAYED_AMETHYST_BLOCK, "thick_inlayed_amethyst_block_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.THICK_INLAYED_ANCIENT_DEBRIS, "thick_inlayed_ancient_debris_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.THICK_INLAYED_ANDESITE, "thick_inlayed_andesite_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.THICK_INLAYED_BASALT, "thick_inlayed_basalt_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.THICK_INLAYED_BLACKSTONE, "thick_inlayed_blackstone_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.THICK_INLAYED_BLUE_ICE, "thick_inlayed_blue_ice_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.THICK_INLAYED_BORDERLESS_BRICKS, "thick_inlayed_borderless_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.THICK_INLAYED_BRICKS, "thick_inlayed_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.THICK_INLAYED_CALCITE, "thick_inlayed_calcite_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.THICK_INLAYED_CLAY, "thick_inlayed_clay_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.THICK_INLAYED_COAL_BLOCK, "thick_inlayed_coal_block_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.THICK_INLAYED_COBBLESTONE, "thick_inlayed_cobblestone_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.THICK_INLAYED_CRYING_OBSIDIAN, "thick_inlayed_crying_obsidian_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.THICK_INLAYED_DARK_PRISMARINE, "thick_inlayed_dark_prismarine_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.THICK_INLAYED_DEEPSLATE, "thick_inlayed_deepslate_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.THICK_INLAYED_DIORITE, "thick_inlayed_diorite_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.THICK_INLAYED_DIRT, "thick_inlayed_dirt_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.THICK_INLAYED_DRIPSTONE_BLOCK, "thick_inlayed_dripstone_block_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.THICK_INLAYED_END_STONE, "thick_inlayed_end_stone_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.THICK_INLAYED_GILDED_BLACKSTONE, "thick_inlayed_gilded_blackstone_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.THICK_INLAYED_ICE, "thick_inlayed_ice_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.THICK_INLAYED_LAPIS_BLOCK, "thick_inlayed_lapis_block_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.THICK_INLAYED_LODESTONE, "thick_inlayed_lodestone_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.THICK_INLAYED_MAGMA_BLOCK, "thick_inlayed_magma_block_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.THICK_INLAYED_MOSSY_COBBLESTONE, "thick_inlayed_mossy_cobblestone_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.THICK_INLAYED_MOSSY_STONE_BRICKS, "thick_inlayed_mossy_stone_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.THICK_INLAYED_NETHER_BRICKS, "thick_inlayed_nether_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.THICK_INLAYED_NETHERRACK, "thick_inlayed_netherrack_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.THICK_INLAYED_OBSIDIAN, "thick_inlayed_obsidian_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.THICK_INLAYED_PACKED_ICE, "thick_inlayed_packed_ice_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.THICK_INLAYED_PRISMARINE, "thick_inlayed_prismarine_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.THICK_INLAYED_PURPUR_BLOCK, "thick_inlayed_purpur_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.THICK_INLAYED_QUARTZ_BLOCK, "thick_inlayed_quartz_block_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.THICK_INLAYED_RAW_COPPER_BLOCK, "thick_inlayed_raw_copper_block_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.THICK_INLAYED_RAW_GOLD_BLOCK, "thick_inlayed_raw_gold_block_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.THICK_INLAYED_RAW_IRON_BLOCK, "thick_inlayed_raw_iron_block_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.THICK_INLAYED_RED_NETHER_BRICKS, "thick_inlayed_red_nether_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.THICK_INLAYED_RED_SANDSTONE, "thick_inlayed_red_sandstone_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.THICK_INLAYED_REDSTONE_BLOCK, "thick_inlayed_redstone_block_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.THICK_INLAYED_SANDSTONE, "thick_inlayed_sandstone_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.THICK_INLAYED_SMOOTH_STONE, "thick_inlayed_smooth_stone_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.THICK_INLAYED_SNOW_BLOCK, "thick_inlayed_snow_block_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.THICK_INLAYED_TUFF, "thick_inlayed_tuff_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.TIED_BAMBOO_PLANKS, "tied_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.TILED_AMETHYST_BLOCK_COLUMN, "tiled_amethyst_block_column_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.TILED_ANCIENT_DEBRIS_COLUMN, "tiled_ancient_debris_column_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.TILED_ANDESITE_COLUMN, "tiled_andesite_column_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.TILED_BASALT_COLUMN, "tiled_basalt_column_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.TILED_BLACKSTONE_COLUMN, "tiled_blackstone_column_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.TILED_BLUE_ICE_COLUMN, "tiled_blue_ice_column_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.TILED_BORDERED_AMETHYST_BLOCK, "tiled_bordered_amethyst_block_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.TILED_BORDERED_ANCIENT_DEBRIS, "tiled_bordered_ancient_debris_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.TILED_BORDERED_ANDESITE, "tiled_bordered_andesite_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.TILED_BORDERED_BASALT, "tiled_bordered_basalt_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.TILED_BORDERED_BLACKSTONE, "tiled_bordered_blackstone_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.TILED_BORDERED_BLUE_ICE, "tiled_bordered_blue_ice_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.TILED_BORDERED_BORDERLESS_BRICKS, "tiled_bordered_borderless_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.TILED_BORDERED_BRICKS, "tiled_bordered_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.TILED_BORDERED_CALCITE, "tiled_bordered_calcite_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.TILED_BORDERED_CLAY, "tiled_bordered_clay_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.TILED_BORDERED_COAL_BLOCK, "tiled_bordered_coal_block_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.TILED_BORDERED_COBBLESTONE, "tiled_bordered_cobblestone_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.TILED_BORDERED_CRYING_OBSIDIAN, "tiled_bordered_crying_obsidian_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.TILED_BORDERED_DARK_PRISMARINE, "tiled_bordered_dark_prismarine_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.TILED_BORDERED_DEEPSLATE, "tiled_bordered_deepslate_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.TILED_BORDERED_DIORITE, "tiled_bordered_diorite_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.TILED_BORDERED_DIRT, "tiled_bordered_dirt_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.TILED_BORDERED_DRIPSTONE_BLOCK, "tiled_bordered_dripstone_block_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.TILED_BORDERED_END_STONE, "tiled_bordered_end_stone_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.TILED_BORDERED_GILDED_BLACKSTONE, "tiled_bordered_gilded_blackstone_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.TILED_BORDERED_ICE, "tiled_bordered_ice_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.TILED_BORDERED_LAPIS_BLOCK, "tiled_bordered_lapis_block_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.TILED_BORDERED_LODESTONE, "tiled_bordered_lodestone_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.TILED_BORDERED_MAGMA_BLOCK, "tiled_bordered_magma_block_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.TILED_BORDERED_MOSSY_COBBLESTONE, "tiled_bordered_mossy_cobblestone_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.TILED_BORDERED_MOSSY_STONE_BRICKS, "tiled_bordered_mossy_stone_bricks_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.TILED_BORDERED_MUD, "tiled_bordered_mud_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.TILED_BORDERED_MUD_BRICKS, "tiled_bordered_mud_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.TILED_BORDERED_NETHER_BRICKS, "tiled_bordered_nether_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.TILED_BORDERED_NETHERRACK, "tiled_bordered_netherrack_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.TILED_BORDERED_OBSIDIAN, "tiled_bordered_obsidian_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.TILED_BORDERED_PACKED_ICE, "tiled_bordered_packed_ice_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.TILED_BORDERED_PACKED_MUD, "tiled_bordered_packed_mud_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.TILED_BORDERED_PRISMARINE, "tiled_bordered_prismarine_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.TILED_BORDERED_PURPUR_BLOCK, "tiled_bordered_purpur_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.TILED_BORDERED_QUARTZ_BLOCK, "tiled_bordered_quartz_block_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.TILED_BORDERED_RAW_COPPER_BLOCK, "tiled_bordered_raw_copper_block_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.TILED_BORDERED_RAW_GOLD_BLOCK, "tiled_bordered_raw_gold_block_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.TILED_BORDERED_RAW_IRON_BLOCK, "tiled_bordered_raw_iron_block_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.TILED_BORDERED_RED_NETHER_BRICKS, "tiled_bordered_red_nether_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.TILED_BORDERED_RED_SANDSTONE, "tiled_bordered_red_sandstone_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.TILED_BORDERED_REDSTONE_BLOCK, "tiled_bordered_redstone_block_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.TILED_BORDERED_SANDSTONE, "tiled_bordered_sandstone_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.TILED_BORDERED_SMOOTH_STONE, "tiled_bordered_smooth_stone_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.TILED_BORDERED_SNOW_BLOCK, "tiled_bordered_snow_block_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.TILED_BORDERED_TUFF, "tiled_bordered_tuff_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.TILED_BORDERLESS_BRICKS_COLUMN, "tiled_borderless_bricks_column_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.TILED_BRICKS_COLUMN, "tiled_bricks_column_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.TILED_CALCITE_COLUMN, "tiled_calcite_column_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.TILED_CLAY_COLUMN, "tiled_clay_column_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.TILED_COAL_BLOCK_COLUMN, "tiled_coal_block_column_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.TILED_COBBLESTONE_COLUMN, "tiled_cobblestone_column_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.TILED_CRYING_OBSIDIAN_COLUMN, "tiled_crying_obsidian_column_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.TILED_DARK_PRISMARINE_COLUMN, "tiled_dark_prismarine_column_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.TILED_DEEPSLATE_COLUMN, "tiled_deepslate_column_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.TILED_DIORITE_COLUMN, "tiled_diorite_column_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.TILED_DIRT_COLUMN, "tiled_dirt_column_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.TILED_DRIPSTONE_BLOCK_COLUMN, "tiled_dripstone_block_column_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.TILED_END_STONE_COLUMN, "tiled_end_stone_column_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.TILED_GILDED_BLACKSTONE_COLUMN, "tiled_gilded_blackstone_column_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.TILED_ICE_COLUMN, "tiled_ice_column_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.TILED_LAPIS_BLOCK_COLUMN, "tiled_lapis_block_column_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.TILED_LODESTONE_COLUMN, "tiled_lodestone_column_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.TILED_MAGMA_BLOCK_COLUMN, "tiled_magma_block_column_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.TILED_MOSSY_COBBLESTONE_COLUMN, "tiled_mossy_cobblestone_column_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.TILED_MOSSY_STONE_BRICKS_COLUMN, "tiled_mossy_stone_bricks_column_engraving");
        engraveOne(exporter, Blocks.MUD_BRICKS, ModBlocks.TILED_MUD_BRICKS_COLUMN, "tiled_mud_bricks_column_engraving");
        engraveOne(exporter, Blocks.MUD, ModBlocks.TILED_MUD_COLUMN, "tiled_mud_column_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.TILED_NETHER_BRICKS_COLUMN, "tiled_nether_bricks_column_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.TILED_NETHERRACK_COLUMN, "tiled_netherrack_column_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.TILED_OBSIDIAN_COLUMN, "tiled_obsidian_column_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.TILED_PACKED_ICE_COLUMN, "tiled_packed_ice_column_engraving");
        engraveOne(exporter, Blocks.PACKED_MUD, ModBlocks.TILED_PACKED_MUD_COLUMN, "tiled_packed_mud_column_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.TILED_PRISMARINE_COLUMN, "tiled_prismarine_column_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.TILED_PURPUR_BLOCK_COLUMN, "tiled_purpur_block_column_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.TILED_QUARTZ_BLOCK_COLUMN, "tiled_quartz_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.TILED_RAW_COPPER_BLOCK_COLUMN, "tiled_raw_copper_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.TILED_RAW_GOLD_BLOCK_COLUMN, "tiled_raw_gold_block_column_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.TILED_RAW_IRON_BLOCK_COLUMN, "tiled_raw_iron_block_column_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.TILED_RED_NETHER_BRICKS_COLUMN, "tiled_red_nether_bricks_column_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.TILED_RED_SANDSTONE_COLUMN, "tiled_red_sandstone_column_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.TILED_REDSTONE_BLOCK_COLUMN, "tiled_redstone_block_column_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.TILED_SANDSTONE_COLUMN, "tiled_sandstone_column_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.TILED_SMOOTH_STONE_COLUMN, "tiled_smooth_stone_column_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.TILED_SNOW_BLOCK_COLUMN, "tiled_snow_block_column_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.TILED_TUFF_COLUMN, "tiled_tuff_column_engraving");
        engraveOne(exporter, Blocks.AMETHYST_BLOCK, ModBlocks.TINY_BRICK_BORDERED_AMETHYST_BLOCK, "tiny_brick_bordered_amethyst_block_engraving");
        engraveOne(exporter, Blocks.ANCIENT_DEBRIS, ModBlocks.TINY_BRICK_BORDERED_ANCIENT_DEBRIS, "tiny_brick_bordered_ancient_debris_engraving");
        engraveOne(exporter, Blocks.ANDESITE, ModBlocks.TINY_BRICK_BORDERED_ANDESITE, "tiny_brick_bordered_andesite_engraving");
        engraveOne(exporter, Blocks.BASALT, ModBlocks.TINY_BRICK_BORDERED_BASALT, "tiny_brick_bordered_basalt_engraving");
        engraveOne(exporter, Blocks.BLACKSTONE, ModBlocks.TINY_BRICK_BORDERED_BLACKSTONE, "tiny_brick_bordered_blackstone_engraving");
        engraveOne(exporter, Blocks.BLUE_ICE, ModBlocks.TINY_BRICK_BORDERED_BLUE_ICE, "tiny_brick_bordered_blue_ice_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.TINY_BRICK_BORDERED_BORDERLESS_BRICKS, "tiny_brick_bordered_borderless_bricks_engraving");
        engraveOne(exporter, Blocks.BRICKS, ModBlocks.TINY_BRICK_BORDERED_BRICKS, "tiny_brick_bordered_bricks_engraving");
        engraveOne(exporter, Blocks.CALCITE, ModBlocks.TINY_BRICK_BORDERED_CALCITE, "tiny_brick_bordered_calcite_engraving");
        engraveOne(exporter, Blocks.CLAY, ModBlocks.TINY_BRICK_BORDERED_CLAY, "tiny_brick_bordered_clay_engraving");
        engraveOne(exporter, Blocks.COAL_BLOCK, ModBlocks.TINY_BRICK_BORDERED_COAL_BLOCK, "tiny_brick_bordered_coal_block_engraving");
        engraveOne(exporter, Blocks.COBBLESTONE, ModBlocks.TINY_BRICK_BORDERED_COBBLESTONE, "tiny_brick_bordered_cobblestone_engraving");
        engraveOne(exporter, Blocks.CRYING_OBSIDIAN, ModBlocks.TINY_BRICK_BORDERED_CRYING_OBSIDIAN, "tiny_brick_bordered_crying_obsidian_engraving");
        engraveOne(exporter, Blocks.DARK_PRISMARINE, ModBlocks.TINY_BRICK_BORDERED_DARK_PRISMARINE, "tiny_brick_bordered_dark_prismarine_engraving");
        engraveOne(exporter, Blocks.DEEPSLATE, ModBlocks.TINY_BRICK_BORDERED_DEEPSLATE, "tiny_brick_bordered_deepslate_engraving");
        engraveOne(exporter, Blocks.DIORITE, ModBlocks.TINY_BRICK_BORDERED_DIORITE, "tiny_brick_bordered_diorite_engraving");
        engraveOne(exporter, Blocks.DIRT, ModBlocks.TINY_BRICK_BORDERED_DIRT, "tiny_brick_bordered_dirt_engraving");
        engraveOne(exporter, Blocks.DRIPSTONE_BLOCK, ModBlocks.TINY_BRICK_BORDERED_DRIPSTONE_BLOCK, "tiny_brick_bordered_dripstone_block_engraving");
        engraveOne(exporter, Blocks.END_STONE, ModBlocks.TINY_BRICK_BORDERED_END_STONE, "tiny_brick_bordered_end_stone_engraving");
        engraveOne(exporter, Blocks.GILDED_BLACKSTONE, ModBlocks.TINY_BRICK_BORDERED_GILDED_BLACKSTONE, "tiny_brick_bordered_gilded_blackstone_engraving");
        engraveOne(exporter, Blocks.ICE, ModBlocks.TINY_BRICK_BORDERED_ICE, "tiny_brick_bordered_ice_engraving");
        engraveOne(exporter, Blocks.LAPIS_BLOCK, ModBlocks.TINY_BRICK_BORDERED_LAPIS_BLOCK, "tiny_brick_bordered_lapis_block_engraving");
        engraveOne(exporter, Blocks.LODESTONE, ModBlocks.TINY_BRICK_BORDERED_LODESTONE, "tiny_brick_bordered_lodestone_engraving");
        engraveOne(exporter, Blocks.MAGMA_BLOCK, ModBlocks.TINY_BRICK_BORDERED_MAGMA_BLOCK, "tiny_brick_bordered_magma_block_engraving");
        engraveOne(exporter, Blocks.MOSSY_COBBLESTONE, ModBlocks.TINY_BRICK_BORDERED_MOSSY_COBBLESTONE, "tiny_brick_bordered_mossy_cobblestone_engraving");
        engraveOne(exporter, Blocks.MOSSY_STONE_BRICKS, ModBlocks.TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS, "tiny_brick_bordered_mossy_stone_bricks_engraving");
        engraveOne(exporter, Blocks.NETHER_BRICKS, ModBlocks.TINY_BRICK_BORDERED_NETHER_BRICKS, "tiny_brick_bordered_nether_bricks_engraving");
        engraveOne(exporter, Blocks.NETHERRACK, ModBlocks.TINY_BRICK_BORDERED_NETHERRACK, "tiny_brick_bordered_netherrack_engraving");
        engraveOne(exporter, Blocks.OBSIDIAN, ModBlocks.TINY_BRICK_BORDERED_OBSIDIAN, "tiny_brick_bordered_obsidian_engraving");
        engraveOne(exporter, Blocks.PACKED_ICE, ModBlocks.TINY_BRICK_BORDERED_PACKED_ICE, "tiny_brick_bordered_packed_ice_engraving");
        engraveOne(exporter, Blocks.PRISMARINE, ModBlocks.TINY_BRICK_BORDERED_PRISMARINE, "tiny_brick_bordered_prismarine_engraving");
        engraveOne(exporter, Blocks.PURPUR_BLOCK, ModBlocks.TINY_BRICK_BORDERED_PURPUR_BLOCK, "tiny_brick_bordered_purpur_block_engraving");
        engraveOne(exporter, Blocks.QUARTZ_BLOCK, ModBlocks.TINY_BRICK_BORDERED_QUARTZ_BLOCK, "tiny_brick_bordered_quartz_block_engraving");
        engraveOne(exporter, Blocks.RAW_COPPER_BLOCK, ModBlocks.TINY_BRICK_BORDERED_RAW_COPPER_BLOCK, "tiny_brick_bordered_raw_copper_block_engraving");
        engraveOne(exporter, Blocks.RAW_GOLD_BLOCK, ModBlocks.TINY_BRICK_BORDERED_RAW_GOLD_BLOCK, "tiny_brick_bordered_raw_gold_block_engraving");
        engraveOne(exporter, Blocks.RAW_IRON_BLOCK, ModBlocks.TINY_BRICK_BORDERED_RAW_IRON_BLOCK, "tiny_brick_bordered_raw_iron_block_engraving");
        engraveOne(exporter, Blocks.RED_NETHER_BRICKS, ModBlocks.TINY_BRICK_BORDERED_RED_NETHER_BRICKS, "tiny_brick_bordered_red_nether_bricks_engraving");
        engraveOne(exporter, Blocks.RED_SANDSTONE, ModBlocks.TINY_BRICK_BORDERED_RED_SANDSTONE, "tiny_brick_bordered_red_sandstone_engraving");
        engraveOne(exporter, Blocks.REDSTONE_BLOCK, ModBlocks.TINY_BRICK_BORDERED_REDSTONE_BLOCK, "tiny_brick_bordered_redstone_block_engraving");
        engraveOne(exporter, Blocks.SANDSTONE, ModBlocks.TINY_BRICK_BORDERED_SANDSTONE, "tiny_brick_bordered_sandstone_engraving");
        engraveOne(exporter, Blocks.SMOOTH_STONE, ModBlocks.TINY_BRICK_BORDERED_SMOOTH_STONE, "tiny_brick_bordered_smooth_stone_engraving");
        engraveOne(exporter, Blocks.SNOW_BLOCK, ModBlocks.TINY_BRICK_BORDERED_SNOW_BLOCK, "tiny_brick_bordered_snow_block_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.TINY_BRICK_BORDERED_TUFF, "tiny_brick_bordered_tuff_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.TUFF_CUT_POLISHED.get(), "tuff_cut_polished_engraving");
        engraveOne(exporter, Blocks.TUFF, ModBlocks.TUFF_CUT_SMALL_BRICK.get(), "tuff_cut_small_brick_engraving");
        engraveOne(exporter, Blocks.GLASS, ModBlocks.VERTICAL_LEADED_GLASS, "vertical_leaded_glass_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_BEAMS.get(), "warped_planks_beams_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_BRICK_PATTERN.get(), "warped_planks_brick_pattern_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_BRICK_PAVING.get(), "warped_planks_brick_paving_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_BRICKS.get(), "warped_planks_bricks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_CRATE.get(), "warped_planks_crate_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_DIAGONAL_STRIPES.get(), "warped_planks_diagonal_stripes_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_DIAGONAL_TILES.get(), "warped_planks_diagonal_tiles_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_DOTTED.get(), "warped_planks_dotted_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_FLOORING.get(), "warped_planks_flooring_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_LARGE_TILES.get(), "warped_planks_large_tiles_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_PANEL, "warped_planks_panel_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_PATTERN.get(), "warped_planks_pattern_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_ROTATED_BRICKS.get(), "warped_planks_rotated_bricks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_SMALL_BRICKS.get(), "warped_planks_small_bricks_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_SMALL_TILES.get(), "warped_planks_small_tiles_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_SQUARES.get(), "warped_planks_squares_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_TILES.get(), "warped_planks_tiles_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_WAVY.get(), "warped_planks_wavy_engraving");
        engraveOne(exporter, Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS_WOVEN.get(), "warped_planks_woven_engraving");
        engraveOne(exporter, Blocks.ACACIA_PLANKS, ModBlocks.WHIRLWIND_ACACIA_PLANKS, "whirlwind_acacia_planks_engraving");
        engraveOne(exporter, Blocks.BAMBOO_PLANKS, ModBlocks.WHIRLWIND_BAMBOO_PLANKS, "whirlwind_bamboo_planks_engraving");
        engraveOne(exporter, Blocks.BIRCH_PLANKS, ModBlocks.WHIRLWIND_BIRCH_PLANKS, "whirlwind_birch_planks_engraving");
        engraveOne(exporter, Blocks.OAK_PLANKS, ModBlocks.WHIRLWIND_OAK_PLANKS, "whirlwind_oak_planks_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.WHITE_CONCRETE_CTM, "white_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.WHITE_CONCRETE_PANEL, "white_concrete_panel_engraving");
        engraveOne(exporter, Blocks.BLACK_CONCRETE, ModBlocks.WIRED_BLACK_CONCRETE, "wired_black_concrete_engraving");
        engraveOne(exporter, Blocks.BLUE_CONCRETE, ModBlocks.WIRED_BLUE_CONCRETE, "wired_blue_concrete_engraving");
        engraveOne(exporter, Blocks.BROWN_CONCRETE, ModBlocks.WIRED_BROWN_CONCRETE, "wired_brown_concrete_engraving");
        engraveOne(exporter, Blocks.CYAN_CONCRETE, ModBlocks.WIRED_CYAN_CONCRETE, "wired_cyan_concrete_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.WIRED_GRAY_CONCRETE, "wired_gray_concrete_engraving");
        engraveOne(exporter, Blocks.GREEN_CONCRETE, ModBlocks.WIRED_GREEN_CONCRETE, "wired_green_concrete_engraving");
        engraveOne(exporter, Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.WIRED_LIGHT_BLUE_CONCRETE, "wired_light_blue_concrete_engraving");
        engraveOne(exporter, Blocks.GRAY_CONCRETE, ModBlocks.WIRED_LIGHT_GRAY_CONCRETE, "wired_light_gray_concrete_engraving");
        engraveOne(exporter, Blocks.LIME_CONCRETE, ModBlocks.WIRED_LIME_CONCRETE, "wired_lime_concrete_engraving");
        engraveOne(exporter, Blocks.MAGENTA_CONCRETE, ModBlocks.WIRED_MAGENTA_CONCRETE, "wired_magenta_concrete_engraving");
        engraveOne(exporter, Blocks.ORANGE_CONCRETE, ModBlocks.WIRED_ORANGE_CONCRETE, "wired_orange_concrete_engraving");
        engraveOne(exporter, Blocks.PINK_CONCRETE, ModBlocks.WIRED_PINK_CONCRETE, "wired_pink_concrete_engraving");
        engraveOne(exporter, Blocks.PURPLE_CONCRETE, ModBlocks.WIRED_PURPLE_CONCRETE, "wired_purple_concrete_engraving");
        engraveOne(exporter, Blocks.RED_CONCRETE, ModBlocks.WIRED_RED_CONCRETE, "wired_red_concrete_engraving");
        engraveOne(exporter, Blocks.WHITE_CONCRETE, ModBlocks.WIRED_WHITE_CONCRETE, "wired_white_concrete_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.WIRED_YELLOW_CONCRETE, "wired_yellow_concrete_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_CONCRETE_CTM, "yellow_concrete_pillar_engraving");
        engraveOne(exporter, Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_CONCRETE_PANEL, "yellow_concrete_panel_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.YELLOW_TERRACOTTA_COLUMN, "yellow_terracotta_column_engraving");
        engraveOne(exporter, Blocks.YELLOW_TERRACOTTA, ModBlocks.YELLOW_TERRACOTTA_CTM, "yellow_terracotta_pillar_engraving");
        // --- RECOVERED PURPUR_CTM ---
    }

    private void recoveredWindowRecipes(RecipeOutput exporter) {
        String[] styles = {"bars", "covered", "diagonal", "large", "panes", "rounded", "slim", "swirling", "tiles"};
        String[] woods  = {"acacia", "birch", "crimson", "dark_oak", "jungle", "mangrove", "oak", "spruce", "warped"};
        String[] suffixes = {"", "_pane", "_ctm_pane"};
        for (String wood : woods) {
            Block planks = BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(wood + "_planks"));
            if (planks == Blocks.AIR) continue;
            for (String style : styles) {
                for (String suf : suffixes) {
                    String id = wood + "_window_" + style + suf;
                    Block out = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", id));
                    if (out == Blocks.AIR) continue;
                    // _ctm_pane: skip if the _ctm full block exists — ctmPaneRecipes() owns that recipe id (avoid duplicate).
                    if (suf.equals("_ctm_pane")) {
                        Block ctm = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", wood + "_window_" + style + "_ctm"));
                        if (ctm != Blocks.AIR) continue;
                    }
                    engraveOne(exporter, planks, out, id + "_engraving");
                }
            }
        }
    }

    private void engravePaneFromBlock(RecipeOutput exporter, ItemLike material, String blockOttName, String paneName) {
        Block block = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", blockOttName));
        Block pane  = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", paneName));
        if (block == Blocks.AIR || pane == Blocks.AIR) return;
        engraveOne(exporter, material, pane, paneName + "_engraving");
        paneFrom6(exporter, block, pane, paneName + "_from_block");
    }

    /** Engraves material → pane, and uses material itself as the 6-block source (e.g. vanilla stained glass → plain CTM pane). */
    private void engravePaneSelfBlock(RecipeOutput exporter, ItemLike material, String paneName) {
        Block pane = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", paneName));
        if (pane == Blocks.AIR) return;
        engraveOne(exporter, material, pane, paneName + "_engraving");
        paneFrom6(exporter, material, pane, paneName + "_from_block");
    }

    /** Shaped recipe: 6 of block (2×3) → 16 panes. */
    private void paneFrom6(RecipeOutput exporter, ItemLike block, ItemLike pane, String id) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pane, 16)
                .define('G', block)
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy(getHasName(block), has(block))
                .save(exporter, getRecipePath("ott", id));
    }

    private void woodcutStructural(RecipeOutput exporter, ItemLike input, String prefix, ModBlocks.WoodSetBlocks set) {
        woodcutOne(exporter, input, set.planksPlate().get(),     prefix + "_plate_woodcutting");
        woodcutOne(exporter, input, set.planksEdge().get(),      prefix + "_edge_woodcutting");
        woodcutOne(exporter, input, set.beam().get(),            prefix + "_beam_woodcutting");
        woodcutOne(exporter, input, set.pergola().get(),         prefix + "_pergola_woodcutting");
        woodcutOne(exporter, input, set.geometricWindow().get(), prefix + "_geowindow_woodcutting");
        woodcutOne(exporter, input, set.bannister().get(),       prefix + "_bannister_woodcutting");
        woodcutOne(exporter, input, set.supportSlab().get(),     prefix + "_support_slab_woodcutting");
        woodcutOne(exporter, input, set.supportBeam().get(),     prefix + "_support_beam_woodcutting");
    }

    private void woodcutStructural(RecipeOutput exporter, ItemLike input, String prefix, ModBlocks.WoodStructuralBlocks set) {
        woodcutOne(exporter, input, set.planksPlate().get(),     prefix + "_plate_woodcutting");
        woodcutOne(exporter, input, set.planksEdge().get(),      prefix + "_edge_woodcutting");
        woodcutOne(exporter, input, set.beam().get(),            prefix + "_beam_woodcutting");
        woodcutOne(exporter, input, set.pergola().get(),         prefix + "_pergola_woodcutting");
        woodcutOne(exporter, input, set.geometricWindow().get(), prefix + "_geowindow_woodcutting");
        woodcutOne(exporter, input, set.bannister().get(),       prefix + "_bannister_woodcutting");
        woodcutOne(exporter, input, set.supportSlab().get(),     prefix + "_support_slab_woodcutting");
        woodcutOne(exporter, input, set.supportBeam().get(),     prefix + "_support_beam_woodcutting");
    }

    private void addOpalSetRecipes(@NotNull RecipeOutput exporter, @NotNull String name,
                                   @NotNull ModBlocks.OpalSet set, @NotNull Item crystal) {
        // 4 crystals in 2×2 → 1 crystal_block (storage block)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.crystalBlock().get())
                .define('C', crystal)
                .pattern("CC")
                .pattern("CC")
                .unlockedBy("has_crystal", has(crystal))
                .save(exporter, getRecipePath("ott", name + "_from_crystals"));

        // crystal_block → 4 crystals (shapeless decompose)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, crystal, 4)
                .requires(set.crystalBlock().get())
                .unlockedBy("has_" + name + "_crystal_block", has(set.crystalBlock().get()))
                .save(exporter, getRecipePath("ott", name + "_decompose"));

        // ── Stonecutter cascade ──────────────────────────────────────────────
        // From base: every decorative variant
        stonecutOne(exporter, set.base().get(), set.polished().get(),   "polished_" + name + "_from_base");
        stonecutOne(exporter, set.base().get(), set.cut().get(),        "cut_" + name + "_from_base");
        stonecutOne(exporter, set.base().get(), set.bricks().get(),     name + "_bricks_from_base");
        stonecutOne(exporter, set.base().get(), set.smallBricks().get(),"small_" + name + "_bricks_from_base");
        stonecutOne(exporter, set.base().get(), set.chiseled().get(),   "chiseled_" + name + "_from_base");
        stonecutOne(exporter, set.base().get(), set.pillar().get(),     name + "_pillar_from_base");
        stonecutOne(exporter, set.base().get(), set.tiles().get(),      name + "_tiles_from_base");
        stonecutOne(exporter, set.base().get(), set.smallTiles().get(), "small_" + name + "_tiles_from_base");
        stonecutOne(exporter, set.base().get(), set.tiling().get(),     name + "_tiling_from_base");
        // From polished
        stonecutOne(exporter, set.polished().get(), set.cut().get(),        "cut_" + name + "_from_polished");
        stonecutOne(exporter, set.polished().get(), set.bricks().get(),     name + "_bricks_from_polished");
        stonecutOne(exporter, set.polished().get(), set.smallBricks().get(),"small_" + name + "_bricks_from_polished");
        stonecutOne(exporter, set.polished().get(), set.chiseled().get(),   "chiseled_" + name + "_from_polished");
        stonecutOne(exporter, set.polished().get(), set.pillar().get(),     name + "_pillar_from_polished");
        stonecutOne(exporter, set.polished().get(), set.tiles().get(),      name + "_tiles_from_polished");
        stonecutOne(exporter, set.polished().get(), set.smallTiles().get(), "small_" + name + "_tiles_from_polished");
        stonecutOne(exporter, set.polished().get(), set.tiling().get(),     name + "_tiling_from_polished");
        // From cut
        stonecutOne(exporter, set.cut().get(), set.bricks().get(),     name + "_bricks_from_cut");
        stonecutOne(exporter, set.cut().get(), set.smallBricks().get(),"small_" + name + "_bricks_from_cut");
        stonecutOne(exporter, set.cut().get(), set.chiseled().get(),   "chiseled_" + name + "_from_cut");
        stonecutOne(exporter, set.cut().get(), set.tiles().get(),      name + "_tiles_from_cut");
        stonecutOne(exporter, set.cut().get(), set.smallTiles().get(), "small_" + name + "_tiles_from_cut");
        stonecutOne(exporter, set.cut().get(), set.tiling().get(),     name + "_tiling_from_cut");
        // From bricks
        stonecutOne(exporter, set.bricks().get(), set.smallBricks().get(), "small_" + name + "_bricks_from_bricks");
        stonecutOne(exporter, set.bricks().get(), set.tiles().get(),       name + "_tiles_from_bricks");
        stonecutOne(exporter, set.bricks().get(), set.smallTiles().get(),  "small_" + name + "_tiles_from_bricks");
        stonecutOne(exporter, set.bricks().get(), set.tiling().get(),      name + "_tiling_from_bricks");
        // From tiles
        stonecutOne(exporter, set.tiles().get(), set.smallTiles().get(), "small_" + name + "_tiles_from_tiles");
        stonecutOne(exporter, set.tiles().get(), set.tiling().get(),     name + "_tiling_from_tiles");
        // From small_tiles
        stonecutOne(exporter, set.smallTiles().get(), set.tiling().get(), name + "_tiling_from_small_tiles");

        // crystal → 1 base opal block (smelting + blasting)
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(crystal),
                        RecipeCategory.BUILDING_BLOCKS,
                        set.base().get(),
                        0.1F, 200)
                .unlockedBy("has_" + name + "_crystal", has(crystal))
                .save(exporter, getRecipePath("ott", name + "_from_crystal_smelting"));
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(crystal),
                        RecipeCategory.BUILDING_BLOCKS,
                        set.base().get(),
                        0.1F, 100)
                .unlockedBy("has_" + name + "_crystal", has(crystal))
                .save(exporter, getRecipePath("ott", name + "_from_crystal_blasting"));

        // glass: smelt polished → 1 opal glass
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(set.polished().get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        set.glass().get(),
                        0.1F, 200)
                .unlockedBy("has_polished_" + name, has(set.polished().get()))
                .save(exporter, getRecipePath("ott", name + "_glass_from_smelting"));

        // ── Engraving (base block → each decorative variant, like stone → stone variants) ──
        java.util.List<net.minecraft.world.level.block.Block> decorative = java.util.List.of(
                set.polished().get(), set.cut().get(), set.bricks().get(), set.smallBricks().get(),
                set.chiseled().get(), set.pillar().get(), set.tiles().get(), set.smallTiles().get(),
                set.glass().get(), set.glassPane().get(), set.tiling().get()
        );
        for (net.minecraft.world.level.block.Block output : decorative) {
            String outputPath = net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(output).getPath();
            engraveOne(exporter, set.base().get(), output, name + "_to_" + outputPath);
        }
        // ── Engraving (all decorative variants convertible 1:1 between each other) ──
        for (net.minecraft.world.level.block.Block input : decorative) {
            String inputPath = net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(input).getPath();
            for (net.minecraft.world.level.block.Block output : decorative) {
                if (input != output) {
                    String outputPath = net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(output).getPath();
                    engraveOne(exporter, input, output, inputPath + "_to_" + outputPath);
                }
            }
        }
    }
}