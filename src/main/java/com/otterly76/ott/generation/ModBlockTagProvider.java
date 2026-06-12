package com.otterly76.ott.generation;

import com.otterly76.ott_blocks.block.OttBlocks;

import com.otterly76.ott.Constants;
import com.otterly76.ott.block.*;
import com.otterly76.ott_blocks.block.CtmPaneBlock;
import com.otterly76.ott.block.custom.TileBlock;
import com.otterly76.ott.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        // --- 1. DEFINE ALL TAG KEYS (The "Identity") ---
        TagKey<Block> ottConcreteKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/concrete"));
        TagKey<Block> ottConcretePowderKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/concrete_powder"));
        TagKey<Block> ottWoolKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/wool"));
        TagKey<Block> ottStainedGlassKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/stained_glass"));
        TagKey<Block> ottTerracottaKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/terracotta"));

        TagKey<Block> structurizeWeakKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("structurize", "weak_solid_blocks"));

        TagKey<Block> cConcretesKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "concretes"));
        TagKey<Block> cConcretePowdersKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "concrete_powders"));
        TagKey<Block> cWoolKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "wool"));
        TagKey<Block> cTerracottaKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "terracotta"));
        TagKey<Block> cDyedKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "dyed"));
        TagKey<Block> cGlassKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass"));
        TagKey<Block> cGlassBlocksKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass_blocks"));
        TagKey<Block> cGlassBlocksCheapKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass_blocks_cheap"));
        TagKey<Block> cGlassBlocksColoredKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass_blocks/colored"));
        TagKey<Block> cGlassPanesKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass_panes"));
        TagKey<Block> cGlassPanesColoredKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "glass_panes/colored"));

        TagKey<Block> paleOakLogsKey = ModTags.Blocks.PALE_OAK_LOGS;

        TagKey<Block> ottHedgesKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hedge"));

        TagKey<Block> doDefaultKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "default"));
        TagKey<Block> doConcreteKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "concrete"));
        TagKey<Block> doCopperKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "copper"));
        TagKey<Block> doGlacedTerracottaKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "glaced_terracotta"));
        TagKey<Block> doFramedLightCenterKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "framed_light_center"));
        TagKey<Block> doWallMaterialsKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "wall_materials"));
        TagKey<Block> doStairsMaterialsKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "stairs_materials"));
        TagKey<Block> doShinglesCoverKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "shingles_cover"));
        TagKey<Block> doAllBrickMaterialsKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "all_brick_materials"));


        // --- 2. INITIALIZE BUILDERS (The "Appenders") ---
        var ottConcrete = this.tag(ottConcreteKey);
        var ottConcretePowder = this.tag(ottConcretePowderKey);
        var ottWool = this.tag(ottWoolKey);
        var ottStainedGlass = this.tag(ottStainedGlassKey);
        var ottTerracotta = this.tag(ottTerracottaKey);

        var mcConcrete = this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("concrete")));
        var mcConcretePowder = this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("concrete_powder")));
        var mcStainedGlass = this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("stained_glass")));

        var pickaxeTag = this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
        var shovelTag = this.tag(BlockTags.MINEABLE_WITH_SHOVEL);
        var axeTag = this.tag(BlockTags.MINEABLE_WITH_AXE);
        var hoeTag = this.tag(BlockTags.MINEABLE_WITH_HOE);
        var shearsTag = this.tag(BlockTags.create(ResourceLocation.withDefaultNamespace("mineable/shears")));
        var needsStoneToolTag = this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(ModTags.Blocks.CREAKING_HEART_HOLDERS).add(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        this.tag(ModTags.Blocks.HAPPY_GHAST_AVOIDS).add(Blocks.LAVA, Blocks.FIRE, Blocks.SOUL_FIRE);
        this.tag(ModTags.Blocks.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS).add(Blocks.SAND, Blocks.RED_SAND);
        this.tag(ModTags.Blocks.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS).add(Blocks.SAND, Blocks.RED_SAND, Blocks.TERRACOTTA);
        this.tag(ModTags.Blocks.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS).add(Blocks.SAND, Blocks.RED_SAND, Blocks.SOUL_SAND, Blocks.SOUL_SOIL);
        this.tag(ModTags.Blocks.ALLOWS_LEAF_LITTER).add(ModBlocks.PALE_OAK_LEAVES.get());
        this.tag(ModTags.Blocks.SPAWN_FALLING_LEAVES).add(ModBlocks.PALE_OAK_LEAVES.get());
        this.tag(ModTags.Blocks.CAMELS_SPAWNABLE_ON).add(Blocks.SAND, Blocks.RED_SAND);
        this.tag(ModTags.Blocks.ALLIGATOR_EGG_LAYABLE_ON).add(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.SAND, Blocks.MUD);
        this.tag(ModTags.Blocks.TORTOISE_EGG_LAYABLE_ON).add(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.SAND, Blocks.MUD);
        this.tag(ModTags.Blocks.PORTAL_FRAME_BLOCKS).add(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN).addTag(ModTags.Blocks.C_OBSIDIAN);
        this.tag(ModTags.Blocks.C_OBSIDIAN).add(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN);
        this.tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        this.tag(ModTags.Blocks.COPPER)
                .add(Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER, Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER)
                .add(Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_OXIDIZED_COPPER);

        var woodenShelves = this.tag(ModTags.Blocks.WOODEN_SHELVES);
        ModBlocks.SHELVES.forEach(db -> woodenShelves.add(db.get()));

        this.tag(ModTags.Blocks.PATHS).add(Blocks.DIRT_PATH).addTag(com.minecolonies.api.items.ModTags.pathingBlocks);
        this.tag(ModTags.Blocks.STONE)
                .addTag(BlockTags.BASE_STONE_OVERWORLD)
                .addTag(BlockTags.BASE_STONE_NETHER)
                .add(Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DEEPSLATE, Blocks.TUFF);

        // --- 3. REGISTRY LOOP (Populate ott: and behavior tags) ---
        java.util.stream.Stream.concat(ModBlocks.BLOCKS.getEntries().stream(), com.otterly76.ott_blocks.block.OttBlocks.BLOCKS.getEntries().stream()).forEach(deferredBlock -> {
            Block block = deferredBlock.value();

            switch (block) {
                case GradientConcreteBlock concrete -> {
                    this.tag(doDefaultKey).add(concrete);
                    ottConcrete.add(concrete);
                    mcConcrete.add(concrete);
                    pickaxeTag.add(concrete);
                }
                case GradientConcretePowderBlock powder -> {
                    this.tag(doDefaultKey).add(powder);
                    ottConcretePowder.add(powder);
                    mcConcretePowder.add(powder);
                    shovelTag.add(powder);
                }
                case GradientWoolBlock wool -> {
                    this.tag(doDefaultKey).add(wool);
                    ottWool.add(wool);
                    this.tag(BlockTags.WOOL).add(wool);
                }
                case GradientTerracottaBlock terracotta -> {
                    this.tag(doDefaultKey).add(terracotta);
                    ottTerracotta.add(terracotta);
                    this.tag(BlockTags.TERRACOTTA).add(terracotta);
                    pickaxeTag.add(terracotta);
                }
                case GradientStainedGlassBlock glass -> {
                    this.tag(doDefaultKey).add(glass);
                    ottStainedGlass.add(glass);
                    mcStainedGlass.add(glass);
                    this.tag(BlockTags.IMPERMEABLE).add(glass);
                }
                case CtmPaneBlock ctmPane -> {
                    this.tag(cGlassKey).add(ctmPane);
                    this.tag(cGlassPanesKey).add(ctmPane);
                    this.tag(ModTags.Blocks.CTM_BLOCKS).add(ctmPane);
                }
                case TransparentBlock transparent -> {
                    String blockPath = BuiltInRegistries.BLOCK.getKey(transparent).getPath();
                    boolean isWindowBlock = blockPath.contains("_window_");
                    // A TransparentBlock is CTM if:
                    // (a) its name ends with _ctm, OR
                    // (b) a {name}_ctm_pane exists but {name}_ctm does NOT
                    //     (means this IS the CTM block, not the non-CTM sibling of one)
                    boolean endsWithCtm = blockPath.endsWith("_ctm");
                    boolean hasPaneVariant = BuiltInRegistries.BLOCK.containsKey(
                        ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, blockPath + "_ctm_pane"));
                    boolean hasCtmSibling = BuiltInRegistries.BLOCK.containsKey(
                        ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, blockPath + "_ctm"));
                    boolean isCtm = endsWithCtm || (hasPaneVariant && !hasCtmSibling);
                    if (isCtm) {
                        // CTM glass blocks: tag them, give them glass/impermeable tags where appropriate,
                        // but exclude from c:glass_blocks (AC input) and doDefaultKey (DO material).
                        this.tag(ModTags.Blocks.CTM_BLOCKS).add(transparent);
                        if (!isWindowBlock) {
                            this.tag(cGlassKey).add(transparent);
                            this.tag(BlockTags.IMPERMEABLE).add(transparent);
                        }
                    } else if (!isWindowBlock) {
                        // Non-CTM, non-window glass: full tag set
                        this.tag(cGlassKey).add(transparent);
                        this.tag(cGlassBlocksKey).add(transparent);
                        this.tag(BlockTags.IMPERMEABLE).add(transparent);
                        this.tag(doDefaultKey).add(transparent);
                    } else {
                        // Window blocks (non-CTM architectural glass+wood): DO material but not glass tags
                        this.tag(doDefaultKey).add(transparent);
                    }
                }
                case TileBlock tileBlock -> {
                    // Carpet-style floor tiles — pickaxe mineable but excluded from DO material inputs
                    this.tag(ModTags.Blocks.FLOOR_TILES).add(tileBlock);
                    pickaxeTag.add(tileBlock);
                }
                // Carpets — thin floor coverings, excluded from DO material inputs
                case CarpetBlock carpetBlock -> this.tag(ModTags.Blocks.FLOOR_TILES).add(carpetBlock);
                default -> {
                    String bPath = BuiltInRegistries.BLOCK.getKey(block).getPath();
                    if (bPath.endsWith("_ctm") || bPath.endsWith("_connecting")
                            || bPath.startsWith("bordered_") || bPath.contains("_bordered_")) {
                        // CTM blocks (including bordered variants that lack the _ctm suffix)
                        this.tag(ModTags.Blocks.CTM_BLOCKS).add(block);
                        pickaxeTag.add(block);
                    } else if (bPath.contains("_marble")) {
                        // Marble blocks: always pickaxe mineable, but ONLY full-cube shapes
                        // belong in DO material tags. Exclude non-cube structural shapes
                        // (plate/edge/beam/pergola/bannister/support beam/support slab).
                        pickaxeTag.add(block);
                        boolean nonCubeShape = bPath.contains("_plate") || bPath.contains("_edge")
                                || bPath.contains("_beam") || bPath.contains("_pergola")
                                || bPath.contains("_bannister") || bPath.contains("_support_slab")
                                || bPath.contains("_geometric_window") || bPath.contains("_fancy_fence");
                        if (!nonCubeShape) {
                            this.tag(doDefaultKey).add(block);
                        }
                    }
                }
            }
        });

        // --- 3.1 POPULATE minecraft: tags for backported blocks ---
        ModBlocks.MINECRAFT_BLOCKS.getEntries().forEach(deferredBlock -> {
            Block block = deferredBlock.value();

            if (block instanceof BaseRailBlock) this.tag(BlockTags.RAILS).add(block);
            if (block instanceof DoorBlock) this.tag(BlockTags.DOORS).add(block);
            if (block instanceof TrapDoorBlock) this.tag(BlockTags.TRAPDOORS).add(block);
            if (block instanceof PressurePlateBlock) this.tag(BlockTags.PRESSURE_PLATES).add(block);
            if (block instanceof LadderBlock) this.tag(BlockTags.CLIMBABLE).add(block);
            if (block instanceof AbstractCauldronBlock) this.tag(BlockTags.CAULDRONS).add(block);
            if (block instanceof com.otterly76.ott.block.custom.WeatheringCopperAnvilBlock) this.tag(BlockTags.ANVIL).add(block);
            if (block instanceof LanternBlock) this.tag(ModTags.Blocks.LANTERNS).add(block);
            if (block instanceof LightningRodBlock) this.tag(ModTags.Blocks.LIGHTNING_RODS).add(block);
            if (block instanceof com.otterly76.ott.block.custom.CopperChestBlock) this.tag(ModTags.Blocks.COPPER_CHESTS).add(block);

            // Mineability
            if (block instanceof WeatheringCopper ||
                    block instanceof BaseRailBlock || block instanceof LanternBlock || block instanceof ChainBlock ||
                    block instanceof IronBarsBlock || block instanceof HopperBlock || block instanceof LightningRodBlock ||
                    block instanceof AbstractCauldronBlock) {
                pickaxeTag.add(block);
                needsStoneToolTag.add(block);
            }
            if (block instanceof DoorBlock || block instanceof TrapDoorBlock) {
                if (block instanceof WeatheringCopper) {
                    pickaxeTag.add(block);
                } else {
                    axeTag.add(block);
                }
            }
            if (block instanceof PressurePlateBlock && !(block instanceof WeatheringCopper)) {
                axeTag.add(block);
            }
            if (block instanceof ButtonBlock && !(block instanceof WeatheringCopper)) {
                axeTag.add(block);
            }
            if (block instanceof LadderBlock) {
                pickaxeTag.add(block);
                axeTag.add(block);
            }
        });

        // --- 4. HIERARCHY (Nesting our tags into Common and MineColonies) ---

        // Linking to DO categories
        this.tag(doConcreteKey).addTag(ottConcreteKey);

        // Linking to groups that contain all colored variants
        addCommonLinkageTags(this.tag(cDyedKey), ottConcreteKey, ottConcretePowderKey, ottWoolKey, ottStainedGlassKey, ottTerracottaKey);

        // Use the dyed group for other external grouping tags
        this.tag(com.minecolonies.api.items.ModTags.tier2blocks).addTag(cDyedKey);

        // Individual category links
        this.tag(cConcretesKey).addTag(ottConcreteKey);
        this.tag(cConcretePowdersKey).addTag(ottConcretePowderKey);
        this.tag(cWoolKey).addTag(ottWoolKey);
        this.tag(cTerracottaKey).addTag(ottTerracottaKey);

        // Glass linking
        this.tag(cGlassKey).addTag(ottStainedGlassKey);
        this.tag(cGlassBlocksKey).addTag(ottStainedGlassKey);
        this.tag(cGlassBlocksCheapKey).addTag(ottStainedGlassKey);
        this.tag(cGlassBlocksColoredKey).addTag(ottStainedGlassKey);

        // MineColonies Hierarchy
        this.tag(com.minecolonies.api.items.ModTags.tier1blocks).addTag(ottWoolKey).addTag(ottTerracottaKey);

        this.tag(structurizeWeakKey).addTag(ottConcretePowderKey);

        // Linking to Common Wood
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "planks"))).addTag(BlockTags.PLANKS);
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "logs"))).addTag(BlockTags.LOGS);

        // --- 5. STATIC & INDIVIDUAL ADDITIONS ---
        pickaxeTag.add(OttBlocks.MIXED_LIMESTONE_BRICKS.value()); this.tag(doDefaultKey).add(OttBlocks.MIXED_LIMESTONE_BRICKS.value());
        pickaxeTag.add(OttBlocks.PLAIN_LIMESTONE.value());
        needsStoneToolTag.add(OttBlocks.PLAIN_LIMESTONE.value());
        ModBlocks.SEAGLASS.forEach(d -> {
            this.tag(BlockTags.IMPERMEABLE).add(d.value());
            pickaxeTag.add(d.value());
            this.tag(cGlassKey).add(d.value());
            this.tag(cGlassBlocksKey).add(d.value());
            this.tag(cGlassBlocksColoredKey).add(d.value());
            this.tag(doDefaultKey).add(d.value());
        });
        ModBlocks.SEAGLASS_SETS.values().forEach(set -> {
            Block[] all = { set.seaglass().get(), set.bubblesSeaglass().get(), set.smoothSeaglass().get(), set.wavesSeaglass().get() };
            this.tag(BlockTags.IMPERMEABLE).add(all);
            pickaxeTag.add(all);
            this.tag(cGlassKey).add(all);
            this.tag(cGlassBlocksKey).add(all);
            this.tag(cGlassBlocksColoredKey).add(all);
            this.tag(doDefaultKey).add(all);
        });
        ModBlocks.TESTBLOCK.forEach(d -> this.tag(doDefaultKey).add(d.value()));
        this.tag(doDefaultKey).add(OttBlocks.PINK_SALT_BLOCK.get(), OttBlocks.POLISHED_PINK_SALT_BLOCK.get());
        this.tag(doDefaultKey).add(OttBlocks.WATER_MOSAIC_TRADITIONAL.get());
        this.tag(doDefaultKey).add(OttBlocks.EARTH_MOSAIC_TRADITIONAL.get());
        this.tag(doDefaultKey).add(OttBlocks.FIRE_MOSAIC_TRADITIONAL.get());
        this.tag(doDefaultKey).add(OttBlocks.SPIRIT_MOSAIC_TRADITIONAL.get());
        this.tag(doDefaultKey).add(OttBlocks.AIR_MOSAIC_TRADITIONAL.get());
        ModBlocks.PARTICLE_HEDGES.values().forEach(h -> this.tag(doDefaultKey).add(h.value()));
        ModBlocks.PATTERN_BLOCKS.values().forEach(colorMap -> colorMap.values().forEach(d -> this.tag(doDefaultKey).add(d.value())));
        ModBlocks.FUTONS.values().forEach(d -> {
            this.tag(BlockTags.BEDS).add(d.value());
            axeTag.add(d.value());
        });

        this.tag(doDefaultKey).add(
                OttBlocks.PLAIN_LIMESTONE.get(),
                OttBlocks.COBBLED_LIMESTONE.get(),
                OttBlocks.REFINED_GLOWSTONE.get(),
                OttBlocks.WHEAT_THATCH.get(),
                OttBlocks.BAMBOO_THATCH.get(),
                OttBlocks.ROOFING_SLATES.get(),
                OttBlocks.BLACK_MARBLE.get(),
                OttBlocks.BLACK_MARBLE_BRICKS.get(),
                OttBlocks.BLACK_MARBLE_SMALL_BRICKS.get(),
                OttBlocks.BLACK_MARBLE_TILES.get(),
                OttBlocks.BLACK_POLISHED_MARBLE.get(),
                OttBlocks.BLACK_MARBLE_PILLAR.get(),
                OttBlocks.BLACK_MARBLE_PILLAR_CAP.get(),
                OttBlocks.WHITE_MARBLE.get(),
                OttBlocks.WHITE_MARBLE_BRICKS.get(),
                OttBlocks.WHITE_MARBLE_SMALL_BRICKS.get(),
                OttBlocks.WHITE_MARBLE_TILES.get(),
                OttBlocks.WHITE_POLISHED_MARBLE.get(),
                OttBlocks.WHITE_MARBLE_PILLAR.get(),
                OttBlocks.WHITE_MARBLE_PILLAR_CAP.get(),
                OttBlocks.SANDSTONE_SLENDER_BRICKS.get(),
                OttBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN.get(),
                OttBlocks.STONE_BRICKS_MASONRY.get(),
                OttBlocks.ORNAMENTED_RED_WOOL.get(),
                OttBlocks.DELICATE_RED_WOOL.get(),
                OttBlocks.ORNAMENTED_BLUE_WOOL.get(),
                OttBlocks.DELICATE_BLUE_WOOL.get(),
                OttBlocks.ORNAMENTED_GREEN_WOOL.get(),
                OttBlocks.DELICATE_GREEN_WOOL.get(),
                OttBlocks.ORNAMENTED_PURPLE_WOOL.get(),
                OttBlocks.DELICATE_PURPLE_WOOL.get(),
                OttBlocks.WATER_MOSAIC_BORDER.get(),
                OttBlocks.WATER_MOSAIC_GEOMETRIC.get(),
                OttBlocks.WATER_MOSAIC_PATTERN.get(),
                OttBlocks.WATER_MOSAIC_DELICATE.get(),
                OttBlocks.EARTH_MOSAIC_BORDER.get(),
                OttBlocks.EARTH_MOSAIC_GEOMETRIC.get(),
                OttBlocks.EARTH_MOSAIC_PATTERN.get(),
                OttBlocks.EARTH_MOSAIC_DELICATE.get(),
                OttBlocks.FIRE_MOSAIC_BORDER.get(),
                OttBlocks.FIRE_MOSAIC_GEOMETRIC.get(),
                OttBlocks.FIRE_MOSAIC_PATTERN.get(),
                OttBlocks.FIRE_MOSAIC_DELICATE.get(),
                OttBlocks.SPIRIT_MOSAIC_BORDER.get(),
                OttBlocks.SPIRIT_MOSAIC_GEOMETRIC.get(),
                OttBlocks.SPIRIT_MOSAIC_PATTERN.get(),
                OttBlocks.SPIRIT_MOSAIC_DELICATE.get(),
                OttBlocks.AIR_MOSAIC_BORDER.get(),
                OttBlocks.AIR_MOSAIC_GEOMETRIC.get(),
                OttBlocks.AIR_MOSAIC_PATTERN.get(),
                OttBlocks.AIR_MOSAIC_DELICATE.get(),
                OttBlocks.MOSAIC_FLOOR.get(),
                OttBlocks.MOSAIC_FLOOR_DELICATE.get(),
                OttBlocks.MOSAIC_FLOOR_ROSETTE.get(),
                OttBlocks.ROMAN_FRESCO_RED.get(),
                OttBlocks.ROMAN_FRESCO_BLACK.get(),
                OttBlocks.LIMESTONE_MASONRY.get()
        );

        // Stone variant blocks (plain cube_all + pillar only — CTM blocks excluded from DO)
        this.tag(doDefaultKey).add(
                OttBlocks.CHISELED_PLASTERED_STONE_PILLAR.get()
        );

        // ── Batch CTM blocks ─────────────────────────────────────────────
        this.tag(ModTags.Blocks.CTM_BLOCKS).add(
                OttBlocks.CORNERED_CHERRY_PLANKS.get(),
                OttBlocks.CRATED_CHERRY_PLANKS.get(),
                OttBlocks.ENCLOSED_CHERRY_PLANKS.get(),
                OttBlocks.FRAMED_CHERRY_PLANKS.get(),
                OttBlocks.NATURAL_CHERRY_PLANKS.get(),
                OttBlocks.PEGGED_CHERRY_PLANKS.get(),
                OttBlocks.WHIRLWIND_CHERRY_PLANKS.get(),
                OttBlocks.CORNERED_CRIMSON_PLANKS.get(),
                OttBlocks.CRATED_CRIMSON_PLANKS.get(),
                OttBlocks.ENCLOSED_CRIMSON_PLANKS.get(),
                OttBlocks.FRAMED_CRIMSON_PLANKS.get(),
                OttBlocks.NATURAL_CRIMSON_PLANKS.get(),
                OttBlocks.PEGGED_CRIMSON_PLANKS.get(),
                OttBlocks.WHIRLWIND_CRIMSON_PLANKS.get(),
                OttBlocks.CORNERED_DARK_OAK_PLANKS.get(),
                OttBlocks.CRATED_DARK_OAK_PLANKS.get(),
                OttBlocks.ENCLOSED_DARK_OAK_PLANKS.get(),
                OttBlocks.FRAMED_DARK_OAK_PLANKS.get(),
                OttBlocks.NATURAL_DARK_OAK_PLANKS.get(),
                OttBlocks.PEGGED_DARK_OAK_PLANKS.get(),
                OttBlocks.WHIRLWIND_DARK_OAK_PLANKS.get(),
                OttBlocks.CORNERED_JUNGLE_PLANKS.get(),
                OttBlocks.CRATED_JUNGLE_PLANKS.get(),
                OttBlocks.ENCLOSED_JUNGLE_PLANKS.get(),
                OttBlocks.FRAMED_JUNGLE_PLANKS.get(),
                OttBlocks.NATURAL_JUNGLE_PLANKS.get(),
                OttBlocks.PEGGED_JUNGLE_PLANKS.get(),
                OttBlocks.WHIRLWIND_JUNGLE_PLANKS.get(),
                OttBlocks.ORNATE_LEADED_GLASS_CTM.get(),
                OttBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_LIME_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_LIME_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_LIME_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_LIME_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_LIME_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_MAGENTA_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_MAGENTA_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_MAGENTA_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_MAGENTA_STAINED_GLASS_CTM.get(),
                OttBlocks.BRICKED_MANGROVE_PLANKS.get(),
                OttBlocks.CORNERED_MANGROVE_PLANKS.get(),
                OttBlocks.CRATED_MANGROVE_PLANKS.get(),
                OttBlocks.ENCLOSED_MANGROVE_PLANKS.get(),
                OttBlocks.FRAMED_MANGROVE_PLANKS.get(),
                OttBlocks.NATURAL_MANGROVE_PLANKS.get(),
                OttBlocks.PEGGED_MANGROVE_PLANKS.get(),
                OttBlocks.FANCY_ORANGE_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_ORANGE_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_ORANGE_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_ORANGE_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_PINK_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_PINK_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_PINK_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_PINK_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_PINK_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_PURPLE_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_PURPLE_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_PURPLE_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_PURPLE_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_RED_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_RED_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_RED_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_RED_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_RED_STAINED_GLASS_CTM.get(),
                OttBlocks.CORNERED_SPRUCE_PLANKS.get(),
                OttBlocks.CRATED_SPRUCE_PLANKS.get(),
                OttBlocks.ENCLOSED_SPRUCE_PLANKS.get(),
                OttBlocks.FRAMED_SPRUCE_PLANKS.get(),
                OttBlocks.NATURAL_SPRUCE_PLANKS.get(),
                OttBlocks.PEGGED_SPRUCE_PLANKS.get(),
                OttBlocks.WHIRLWIND_SPRUCE_PLANKS.get(),
                OttBlocks.CORNERED_WARPED_PLANKS.get(),
                OttBlocks.CRATED_WARPED_PLANKS.get(),
                OttBlocks.ENCLOSED_WARPED_PLANKS.get(),
                OttBlocks.FRAMED_WARPED_PLANKS.get(),
                OttBlocks.NATURAL_WARPED_PLANKS.get(),
                OttBlocks.PEGGED_WARPED_PLANKS.get(),
                OttBlocks.WHIRLWIND_WARPED_PLANKS.get(),
                OttBlocks.FANCY_WHITE_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_WHITE_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_WHITE_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_WHITE_STAINED_GLASS_CTM.get(),
                OttBlocks.FANCY_YELLOW_STAINED_GLASS_CTM.get(),
                OttBlocks.ORNATE_YELLOW_STAINED_GLASS_CTM.get(),
                OttBlocks.RASTER_YELLOW_STAINED_GLASS_CTM.get(),
                OttBlocks.SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM.get(),
                OttBlocks.TILED_YELLOW_STAINED_GLASS_CTM.get()
        );

        // New stone variant blocks — DO default
        this.tag(doDefaultKey).add(
                OttBlocks.CHAOTIC_STONE_BRICKS.get(), OttBlocks.CHAOTIC_MEDIUM_STONE_BRICKS.get(),
                OttBlocks.CHAOTIC_SMALL_STONE_BRICKS.get(), OttBlocks.DIAMOND_STONE_PAVERS.get(),
                OttBlocks.ENCASED_STONE_BRICKS.get(), OttBlocks.FRENCH_STONE.get(),
                OttBlocks.LARGE_ORNATE_STONE.get(), OttBlocks.LARGE_STONE_TILE.get(),
                OttBlocks.MESSY_STONE_TILES.get(), OttBlocks.MOSAIC_STONE.get(),
                OttBlocks.NOTCHED_STONE_BRICKS.get(), OttBlocks.ORNATE_STONE.get(),
                OttBlocks.POISON_STONE.get(), OttBlocks.POLISHED_CUT_STONE.get(),
                OttBlocks.POLISHED_STONE_TILES.get(), OttBlocks.PRISM_STONE.get(),
                OttBlocks.SLANTED_STONE.get(), OttBlocks.STONE_ARRAY.get(),
                OttBlocks.STONE_BRAID.get(), OttBlocks.STONE_DENT.get(),
                OttBlocks.STONE_JELLYBEAN.get(), OttBlocks.STONE_LAYERS.get(),
                OttBlocks.STONE_PANEL.get(), OttBlocks.STONE_ROAD.get(),
                OttBlocks.STONE_ZAG.get(), OttBlocks.SUNKEN_STONE.get(),
                OttBlocks.TRIPLE_STONE_BRICKS.get(), OttBlocks.WEATHERED_STONE_BRICKS.get(),
                OttBlocks.WEATHERED_TILED_STONE.get(), OttBlocks.WEAVER_STONE.get(),
                 OttBlocks.CUT_STONE.get(),
                OttBlocks.ROUGH_CUT_STONE.get(),
                OttBlocks.SHEARED_STONE_PILLAR.get(), OttBlocks.SLATED_STONE.get(),
                OttBlocks.STONE_COLUMN.get(), OttBlocks.STONE_TWISTING_COLUMN.get()
        );
        ModBlocks.CHISEL_PILLARS.values().forEach(d -> this.tag(doDefaultKey).add(d.get()));
        ModBlocks.CHISEL_LEGEND.values().forEach(d -> this.tag(doDefaultKey).add(d.get()));

        // New stone variant blocks — pickaxe

        // Domum Ornamentum material tags
        this.tag(doCopperKey).addTag(ModTags.Blocks.COPPER);
        this.tag(doFramedLightCenterKey).add(OttBlocks.REFINED_GLOWSTONE.get());
        ModBlocks.COLOR_SETS.values().forEach(set -> this.tag(doGlacedTerracottaKey).add(set.glazedTerracotta().get()));

        // Nest our entire default set into each DO shape-type tag so future additions propagate automatically.
        this.tag(doWallMaterialsKey).addTag(doDefaultKey);
        this.tag(doStairsMaterialsKey).addTag(doDefaultKey);
        this.tag(doShinglesCoverKey).addTag(doDefaultKey);
        this.tag(doAllBrickMaterialsKey).addTag(doDefaultKey);


        // CTM / Connecting blocks — drives the "Connecting" tooltip in TooltipHandler
        this.tag(ModTags.Blocks.CTM_BLOCKS).add(
                // Elemental mosaics
                OttBlocks.WATER_MOSAIC_BORDER.get(),
                OttBlocks.WATER_MOSAIC_GEOMETRIC.get(),
                OttBlocks.WATER_MOSAIC_PATTERN.get(),
                OttBlocks.WATER_MOSAIC_DELICATE.get(),
                OttBlocks.EARTH_MOSAIC_BORDER.get(),
                OttBlocks.EARTH_MOSAIC_GEOMETRIC.get(),
                OttBlocks.EARTH_MOSAIC_PATTERN.get(),
                OttBlocks.EARTH_MOSAIC_DELICATE.get(),
                OttBlocks.FIRE_MOSAIC_BORDER.get(),
                OttBlocks.FIRE_MOSAIC_GEOMETRIC.get(),
                OttBlocks.FIRE_MOSAIC_PATTERN.get(),
                OttBlocks.FIRE_MOSAIC_DELICATE.get(),
                OttBlocks.AIR_MOSAIC_BORDER.get(),
                OttBlocks.AIR_MOSAIC_GEOMETRIC.get(),
                OttBlocks.AIR_MOSAIC_PATTERN.get(),
                OttBlocks.AIR_MOSAIC_DELICATE.get(),
                OttBlocks.SPIRIT_MOSAIC_BORDER.get(),
                OttBlocks.SPIRIT_MOSAIC_GEOMETRIC.get(),
                OttBlocks.SPIRIT_MOSAIC_PATTERN.get(),
                OttBlocks.SPIRIT_MOSAIC_DELICATE.get(),
                // Mosaic floor
                OttBlocks.MOSAIC_FLOOR.get(),
                OttBlocks.MOSAIC_FLOOR_DELICATE.get(),
                OttBlocks.MOSAIC_FLOOR_ROSETTE.get(),
                // Decorative stone
                OttBlocks.ROMAN_FRESCO_RED.get(),
                OttBlocks.ROMAN_FRESCO_BLACK.get(),
                OttBlocks.LIMESTONE_MASONRY.get(),
                OttBlocks.STONE_BRICKS_MASONRY.get(),
                // CTM polished/vanilla variants
                // Ornamented / delicate wool & carpet
                OttBlocks.ORNAMENTED_RED_WOOL.get(),
                OttBlocks.DELICATE_RED_WOOL.get(),
                ModBlocks.ORNAMENTED_RED_CARPET.get(),
                ModBlocks.DELICATE_RED_CARPET.get(),
                OttBlocks.ORNAMENTED_BLUE_WOOL.get(),
                OttBlocks.DELICATE_BLUE_WOOL.get(),
                ModBlocks.ORNAMENTED_BLUE_CARPET.get(),
                ModBlocks.DELICATE_BLUE_CARPET.get(),
                OttBlocks.ORNAMENTED_GREEN_WOOL.get(),
                OttBlocks.DELICATE_GREEN_WOOL.get(),
                ModBlocks.ORNAMENTED_GREEN_CARPET.get(),
                ModBlocks.DELICATE_GREEN_CARPET.get(),
                OttBlocks.ORNAMENTED_PURPLE_WOOL.get(),
                OttBlocks.DELICATE_PURPLE_WOOL.get(),
                ModBlocks.ORNAMENTED_PURPLE_CARPET.get(),
                ModBlocks.DELICATE_PURPLE_CARPET.get()
                // CTM vertical pillars
        );

        // Stone CTM connecting blocks

        // ── New CTM connecting blocks (batch additions) ─────────────────────
// ── Batch CTM blocks (new additions) ───────────────────────────────
        this.tag(ModTags.Blocks.CTM_BLOCKS).add(
        OttBlocks.GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS.get()
        );
        this.tag(ModTags.Blocks.CTM_BLOCKS).add(
        OttBlocks.BAMBOO_WINDOW_BARS_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_COVERED_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_DIAGONAL_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_LARGE_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_PANES_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_ROUNDED_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_SLIM_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_SWIRLING_CTM.get(),
        OttBlocks.BAMBOO_WINDOW_TILES_CTM.get(),
        OttBlocks.CHERRY_WINDOW_BARS_CTM.get(),
        OttBlocks.CHERRY_WINDOW_COVERED_CTM.get(),
        OttBlocks.CHERRY_WINDOW_DIAGONAL_CTM.get(),
        OttBlocks.CHERRY_WINDOW_LARGE_CTM.get(),
        OttBlocks.CHERRY_WINDOW_PANES_CTM.get(),
        OttBlocks.CHERRY_WINDOW_ROUNDED_CTM.get(),
        OttBlocks.CHERRY_WINDOW_SLIM_CTM.get(),
        OttBlocks.CHERRY_WINDOW_SWIRLING_CTM.get(),
        OttBlocks.CHERRY_WINDOW_TILES_CTM.get(),
        OttBlocks.BLACK_FRAMED_GLASS.get(),
        OttBlocks.BLACK_STAINED_CLEAR_GLASS.get(),
        OttBlocks.BLACK_STAINED_GLASS.get(),
        OttBlocks.BLUE_FRAMED_GLASS.get(),
        OttBlocks.BLUE_STAINED_CLEAR_GLASS.get(),
        OttBlocks.BLUE_STAINED_GLASS.get(),
        OttBlocks.BORDERLESS_GLASS.get(),
        OttBlocks.BORDERLESS_GLASS_BLACK.get(),
        OttBlocks.BORDERLESS_GLASS_BLUE.get(),
        OttBlocks.BORDERLESS_GLASS_BROWN.get(),
        OttBlocks.BORDERLESS_GLASS_CYAN.get(),
        OttBlocks.BORDERLESS_GLASS_GRAY.get(),
        OttBlocks.BORDERLESS_GLASS_GREEN.get(),
        OttBlocks.BORDERLESS_GLASS_LIGHT_BLUE.get(),
        OttBlocks.BORDERLESS_GLASS_LIGHT_GRAY.get(),
        OttBlocks.BORDERLESS_GLASS_LIME.get(),
        OttBlocks.BORDERLESS_GLASS_MAGENTA.get(),
        OttBlocks.BORDERLESS_GLASS_ORANGE.get(),
        OttBlocks.BORDERLESS_GLASS_PINK.get(),
        OttBlocks.BORDERLESS_GLASS_PURPLE.get(),
        OttBlocks.BORDERLESS_GLASS_RED.get(),
        OttBlocks.BORDERLESS_GLASS_WHITE.get(),
        OttBlocks.BORDERLESS_GLASS_YELLOW.get(),
        OttBlocks.BROWN_FRAMED_GLASS.get(),
        OttBlocks.BROWN_STAINED_CLEAR_GLASS.get(),
        OttBlocks.BROWN_STAINED_GLASS.get(),
        OttBlocks.CHISELED_GLASS.get(),
        OttBlocks.CLEAR_GLASS.get(),
        OttBlocks.COPPER_BLOCK.get(),
        OttBlocks.COPPER_GRATE.get(),
        OttBlocks.CYAN_FRAMED_GLASS.get(),
        OttBlocks.CYAN_STAINED_CLEAR_GLASS.get(),
        OttBlocks.CYAN_STAINED_GLASS.get(),
        OttBlocks.DIRTY_GLASS.get(),
        OttBlocks.EXPOSED_COPPER_BLOCK.get(),
        OttBlocks.EXPOSED_COPPER_GRATE.get(),
        OttBlocks.FRAMED_GLASS.get(),
        OttBlocks.FROSTED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_BLACK_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_BLUE_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_BROWN_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_CYAN_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_GRAY_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_GREEN_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_LIME_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_MAGENTA_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_ORANGE_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_PINK_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_PURPLE_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_RED_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_WHITE_STAINED_GLASS.get(),
        OttBlocks.GOLDEN_FRAMED_YELLOW_STAINED_GLASS.get(),
        OttBlocks.GRAY_FRAMED_GLASS.get(),
        OttBlocks.GRAY_STAINED_CLEAR_GLASS.get(),
        OttBlocks.GRAY_STAINED_GLASS.get(),
        OttBlocks.GREEN_FRAMED_GLASS.get(),
        OttBlocks.GREEN_STAINED_CLEAR_GLASS.get(),
        OttBlocks.GREEN_STAINED_GLASS.get(),
        OttBlocks.ICE_GLASS.get(),
        OttBlocks.LIGHT_BLUE_FRAMED_GLASS.get(),
        OttBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS.get(),
        OttBlocks.LIGHT_BLUE_STAINED_GLASS.get(),
        OttBlocks.LIGHT_GRAY_FRAMED_GLASS.get(),
        OttBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS.get(),
        OttBlocks.LIGHT_GRAY_STAINED_GLASS.get(),
        OttBlocks.LIME_FRAMED_GLASS.get(),
        OttBlocks.LIME_STAINED_CLEAR_GLASS.get(),
        OttBlocks.LIME_STAINED_GLASS.get(),
        OttBlocks.MAGENTA_FRAMED_GLASS.get(),
        OttBlocks.MAGENTA_STAINED_CLEAR_GLASS.get(),
        OttBlocks.MAGENTA_STAINED_GLASS.get(),
        OttBlocks.OBSIDIAN_FRAMED_GLASS.get(),
        OttBlocks.ORANGE_FRAMED_GLASS.get(),
        OttBlocks.ORANGE_STAINED_CLEAR_GLASS.get(),
        OttBlocks.ORANGE_STAINED_GLASS.get(),
        OttBlocks.OXIDIZED_COPPER_BLOCK.get(),
        OttBlocks.OXIDIZED_COPPER_GRATE.get(),
        OttBlocks.PALE_OAK_PLANKS_BEAMS.get(),
        OttBlocks.PALE_OAK_PLANKS_BRICKS.get(),
        OttBlocks.PALE_OAK_PLANKS_BRICK_PATTERN.get(),
        OttBlocks.PALE_OAK_PLANKS_BRICK_PAVING.get(),
        OttBlocks.PALE_OAK_PLANKS_CRATE.get(),
        OttBlocks.PALE_OAK_PLANKS_DIAGONAL_STRIPES.get(),
        OttBlocks.PALE_OAK_PLANKS_DIAGONAL_TILES.get(),
        OttBlocks.PALE_OAK_PLANKS_DOTTED.get(),
        OttBlocks.PALE_OAK_PLANKS_FLOORING.get(),
        OttBlocks.PALE_OAK_PLANKS_LARGE_TILES.get(),
        OttBlocks.PALE_OAK_PLANKS_PATTERN.get(),
        OttBlocks.PALE_OAK_PLANKS_ROTATED_BRICKS.get(),
        OttBlocks.PALE_OAK_PLANKS_SMALL_BRICKS.get(),
        OttBlocks.PALE_OAK_PLANKS_SMALL_TILES.get(),
        OttBlocks.PALE_OAK_PLANKS_SQUARES.get(),
        OttBlocks.PALE_OAK_PLANKS_TILES.get(),
        OttBlocks.PALE_OAK_PLANKS_WAVY.get(),
        OttBlocks.PALE_OAK_PLANKS_WOVEN.get(),
        OttBlocks.PINK_FRAMED_GLASS.get(),
        OttBlocks.PINK_STAINED_CLEAR_GLASS.get(),
        OttBlocks.PINK_STAINED_GLASS.get(),
        OttBlocks.POLISHED_LIMESTONE.get(),
        OttBlocks.PURPLE_FRAMED_GLASS.get(),
        OttBlocks.PURPLE_STAINED_CLEAR_GLASS.get(),
        OttBlocks.PURPLE_STAINED_GLASS.get(),
        OttBlocks.RED_FRAMED_GLASS.get(),
        OttBlocks.RED_STAINED_CLEAR_GLASS.get(),
        OttBlocks.RED_STAINED_GLASS.get(),
        OttBlocks.REINFORCED_GLASS.get(),
        OttBlocks.SANDSTONE_FRAMED_GLASS.get(),
        OttBlocks.SCRATCHED_GLASS.get(),
        OttBlocks.SCRATCHED_GLASS_BLACK.get(),
        OttBlocks.SCRATCHED_GLASS_BLUE.get(),
        OttBlocks.SCRATCHED_GLASS_BROWN.get(),
        OttBlocks.SCRATCHED_GLASS_CYAN.get(),
        OttBlocks.SCRATCHED_GLASS_GRAY.get(),
        OttBlocks.SCRATCHED_GLASS_GREEN.get(),
        OttBlocks.SCRATCHED_GLASS_LIGHT_BLUE.get(),
        OttBlocks.SCRATCHED_GLASS_LIGHT_GRAY.get(),
        OttBlocks.SCRATCHED_GLASS_LIME.get(),
        OttBlocks.SCRATCHED_GLASS_MAGENTA.get(),
        OttBlocks.SCRATCHED_GLASS_ORANGE.get(),
        OttBlocks.SCRATCHED_GLASS_PINK.get(),
        OttBlocks.SCRATCHED_GLASS_PURPLE.get(),
        OttBlocks.SCRATCHED_GLASS_RED.get(),
        OttBlocks.SCRATCHED_GLASS_WHITE.get(),
        OttBlocks.SCRATCHED_GLASS_YELLOW.get(),
        OttBlocks.SEA_LANTERN.get(),
        OttBlocks.STONE_FRAMED_GLASS.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_BLACK.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_BLUE.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_BROWN.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_CYAN.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_GRAY.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_GREEN.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_LIGHT_BLUE.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_LIGHT_GRAY.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_LIME.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_MAGENTA.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_ORANGE.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_PINK.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_PURPLE.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_RED.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_WHITE.get(),
        OttBlocks.TINTED_BORDERLESS_GLASS_YELLOW.get(),
        OttBlocks.TINTED_CLEAR_GLASS.get(),
        OttBlocks.TINTED_GLASS.get(),
        OttBlocks.WEATHERED_COPPER_BLOCK.get(),
        OttBlocks.WEATHERED_COPPER_GRATE.get(),
        OttBlocks.WHITE_FRAMED_GLASS.get(),
        OttBlocks.WHITE_STAINED_CLEAR_GLASS.get(),
        OttBlocks.WHITE_STAINED_GLASS.get(),
        OttBlocks.YELLOW_FRAMED_GLASS.get(),
        OttBlocks.YELLOW_STAINED_CLEAR_GLASS.get(),
        OttBlocks.YELLOW_STAINED_GLASS.get()
        );



        var ottHedges = this.tag(ottHedgesKey);
        ottHedges.add(ModBlocks.THORNY_HEDGE.value());
        ModBlocks.PARTICLE_HEDGES.values().forEach(h -> ottHedges.add(h.value()));
        ModBlocks.CREEPING_HEDGES.values().forEach(h -> ottHedges.add(h.value()));

        axeTag.add(ModBlocks.CREAKING_HEART.value(), ModBlocks.PROTECTIVE_LANTERN.value(), ModBlocks.SMITE_LANTERN.value());
        axeTag.add(ModBlocks.DRAGON_SKULL.get(), ModBlocks.DRAGON_WALL_SKULL.get());
        axeTag.add(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        axeTag.add(ModBlocks.PALE_OAK_PLANKS.get(), ModBlocks.PALE_OAK_STAIRS.get(), ModBlocks.PALE_OAK_SLAB.get(), ModBlocks.PALE_OAK_FENCE.get(), ModBlocks.PALE_OAK_FENCE_GATE.get());
        axeTag.add(ModBlocks.PALE_OAK_DOOR.get(), ModBlocks.PALE_OAK_TRAPDOOR.get(), ModBlocks.PALE_OAK_BUTTON.get(), ModBlocks.PALE_OAK_PRESSURE_PLATE.get());

        hoeTag.add(ModBlocks.PALE_MOSS_BLOCK.value(), ModBlocks.PALE_MOSS_CARPET.value(), ModBlocks.THORNY_HEDGE.value());
        hoeTag.add(ModBlocks.PALE_OAK_LEAVES.value());
        pickaxeTag.add(ModBlocks.RESIN_BRICKS.value(), ModBlocks.CHISELED_RESIN_BRICKS.value(), ModBlocks.RESIN_BRICK_SLAB.value(), ModBlocks.RESIN_BLOCK.value(), ModBlocks.RESIN_BRICK_STAIRS.value(), ModBlocks.RESIN_BRICK_WALL.value());
        pickaxeTag.add(OttBlocks.PINK_SALT_BLOCK.value(), ModBlocks.PINK_SALT_LAMP.value());
        pickaxeTag.add(OttBlocks.SOUL_GLASS.get(), OttBlocks.SOUL_GLASS_PANE.get(),
                OttBlocks.SOUL_GLASS_CTM.get(), OttBlocks.SOUL_GLASS_CTM_PANE.get());
        this.tag(ModTags.Blocks.CTM_BLOCKS).add(
                OttBlocks.CHISELED_GLASS_CTM_PANE.get(),
                OttBlocks.CLEAR_GLASS_CTM_PANE.get(),
                OttBlocks.DIRTY_GLASS_CTM_PANE.get(),
                OttBlocks.FROSTED_GLASS_CTM_PANE.get(),
                OttBlocks.ICE_GLASS_CTM_PANE.get(),
                OttBlocks.OBSIDIAN_FRAMED_GLASS_CTM_PANE.get(),
                OttBlocks.REINFORCED_GLASS_CTM_PANE.get(),
                OttBlocks.SANDSTONE_FRAMED_GLASS_CTM_PANE.get(),
                OttBlocks.STONE_FRAMED_GLASS_CTM_PANE.get(),
                OttBlocks.TINTED_CLEAR_GLASS_CTM_PANE.get(),
                OttBlocks.TINTED_GLASS_CTM_PANE.get(),
                OttBlocks.SOUL_GLASS_CTM_PANE.get()
        );
        mcStainedGlass.add(OttBlocks.SOUL_GLASS.get(), OttBlocks.SOUL_GLASS_CTM.get());
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("stained_glass_panes"))).add(
                OttBlocks.SOUL_GLASS_PANE.get(), OttBlocks.SOUL_GLASS_CTM_PANE.get());
        this.tag(BlockTags.IMPERMEABLE).add(OttBlocks.SOUL_GLASS.get(), OttBlocks.SOUL_GLASS_PANE.get(),
                OttBlocks.SOUL_GLASS_CTM.get());
        this.tag(doDefaultKey).add(OttBlocks.SOUL_GLASS.get());

        // Opal sets — pickaxe mineable + DO default for all 18 blocks × 3 types
        ModBlocks.OPAL_SETS.values().forEach(set -> {
            pickaxeTag.add(
                    set.base().get(), set.crystalBlock().get(), set.budding().get(),
                    set.cluster().get(), set.largeBud().get(), set.mediumBud().get(), set.smallBud().get(),
                    set.bricks().get(), set.smallBricks().get(), set.polished().get(), set.chiseled().get(),
                    set.pillar().get(), set.cut().get(), set.tiles().get(), set.smallTiles().get(),
                    set.glass().get(), set.glassPane().get(), set.tiling().get()
            );
            this.tag(doDefaultKey).add(
                    set.base().get(), set.crystalBlock().get(), set.budding().get(),
                    set.bricks().get(), set.smallBricks().get(), set.polished().get(), set.chiseled().get(),
                    set.pillar().get(), set.cut().get(), set.tiles().get(), set.smallTiles().get(),
                    set.glass().get(), set.tiling().get()
            );
        });

        axeTag.add(ModBlocks.ACACIA_BEEHIVE.get(), ModBlocks.BAMBOO_BEEHIVE.get(), ModBlocks.BIRCH_BEEHIVE.get(), ModBlocks.CHERRY_BEEHIVE.get(), ModBlocks.CRIMSON_BEEHIVE.get());
        axeTag.add(ModBlocks.DARK_OAK_BEEHIVE.get(), ModBlocks.JUNGLE_BEEHIVE.get(), ModBlocks.MANGROVE_BEEHIVE.get(), ModBlocks.PALE_OAK_BEEHIVE.get(), ModBlocks.SPRUCE_BEEHIVE.get(), ModBlocks.WARPED_BEEHIVE.get());

        ModBlocks.WOOD_DOORS.forEach((wood, styleMap) -> {
            Block vanillaWoodDoor = switch (wood) {
                case "oak"      -> Blocks.OAK_DOOR;
                case "spruce"   -> Blocks.SPRUCE_DOOR;
                case "birch"    -> Blocks.BIRCH_DOOR;
                case "jungle"   -> Blocks.JUNGLE_DOOR;
                case "acacia"   -> Blocks.ACACIA_DOOR;
                case "dark_oak" -> Blocks.DARK_OAK_DOOR;
                case "mangrove" -> Blocks.MANGROVE_DOOR;
                case "cherry"   -> Blocks.CHERRY_DOOR;
                case "bamboo"   -> Blocks.BAMBOO_DOOR;
                case "crimson"  -> Blocks.CRIMSON_DOOR;
                case "warped"   -> Blocks.WARPED_DOOR;
                default -> throw new IllegalStateException("Unknown wood type for door tags: " + wood);
            };
            var woodMaterialTag = this.tag(TagKey.create(Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/" + wood)));
            woodMaterialTag.add(vanillaWoodDoor);
            styleMap.values().forEach(db -> {
                Block door = db.get();
                this.tag(BlockTags.DOORS).add(door);
                this.tag(BlockTags.WOODEN_DOORS).add(door);
                axeTag.add(door);
                woodMaterialTag.add(door);
            });
        });

        shearsTag.add(ModBlocks.PALE_OAK_LEAVES.value(), ModBlocks.PALE_HANGING_MOSS.value(), ModBlocks.PALE_MOSS_BLOCK.value(), ModBlocks.PALE_MOSS_CARPET.value(), ModBlocks.CLOSED_EYEBLOSSOM.value(), ModBlocks.OPEN_EYEBLOSSOM.value());

        this.tag(BlockTags.create(ResourceLocation.withDefaultNamespace("combination_step_sound_blocks"))).add(ModBlocks.RESIN_CLUMP.value());
        addWoodSetTags(
                paleOakLogsKey,
                ModBlocks.PALE_OAK_LOG.get(),
                ModBlocks.PALE_OAK_WOOD.get(),
                ModBlocks.STRIPPED_PALE_OAK_LOG.get(),
                ModBlocks.STRIPPED_PALE_OAK_WOOD.get(),
                ModBlocks.PALE_OAK_PLANKS.get(),
                ModBlocks.PALE_OAK_LEAVES.get(),
                ModBlocks.PALE_OAK_SLAB.get(),
                ModBlocks.PALE_OAK_STAIRS.get(),
                ModBlocks.PALE_OAK_FENCE.get(),
                ModBlocks.PALE_OAK_FENCE_GATE.get(),
                ModBlocks.PALE_OAK_DOOR.get(),
                ModBlocks.PALE_OAK_TRAPDOOR.get(),
                ModBlocks.PALE_OAK_BUTTON.get(),
                ModBlocks.PALE_OAK_PRESSURE_PLATE.get(),
                ModBlocks.PALE_OAK_SIGN.get(),
                ModBlocks.PALE_OAK_WALL_SIGN.get(),
                ModBlocks.PALE_OAK_HANGING_SIGN.get(),
                ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get()
        );

        ModBlocks.WOOD_SETS.forEach((setName, set) -> {
            this.tag(doDefaultKey).add(set.log().value(), set.wood().value(), set.strippedLog().value(), set.strippedWood().value(), set.planks().value(), set.leaves().value());
            addWoodSetTags(
                    ModTags.Blocks.woodSetLogs(setName),
                    set.log().get(),
                    set.wood().get(),
                    set.strippedLog().get(),
                    set.strippedWood().get(),
                    set.planks().get(),
                    set.leaves().get(),
                    set.slab().get(),
                    set.stairs().get(),
                    set.fence().get(),
                    set.fenceGate().get(),
                    set.door().get(),
                    set.trapdoor().get(),
                    set.button().get(),
                    set.pressurePlate().get(),
                    set.sign().get(),
                    set.wallSign().get(),
                    set.hangingSign().get(),
                    set.wallHangingSign().get()
            );
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(set.beehive().value(), set.shelf().value());
            this.tag(BlockTags.BEEHIVES).add(set.beehive().value());
        });

        ModBlocks.COLOR_SETS.values().forEach(this::addColorSetTags);

        // Stone shape sets — all 8 shapes are pickaxe-mineable
        ModBlocks.STONE_SETS.values().forEach(set ->
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                        set.plate().getKey(), set.edge().getKey(), set.beam().getKey(),
                        set.pergola().getKey(), set.geometricWindow().getKey(),
                        set.bannister().getKey(), set.supportSlab().getKey(), set.supportBeam().getKey()
                )
        );

        // --- 6. VANILLA OVERRIDES ---
        this.tag(BlockTags.LEAVES).add(ModBlocks.PALE_OAK_LEAVES.value());
        this.tag(BlockTags.PLANKS).add(ModBlocks.PALE_OAK_PLANKS.value());
        this.tag(BlockTags.DIRT).add(ModBlocks.PALE_MOSS_BLOCK.value());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.PALE_OAK_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.PALE_OAK_FENCE.get());
        this.tag(BlockTags.STANDING_SIGNS).add(ModBlocks.PALE_OAK_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(ModBlocks.PALE_OAK_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.PALE_OAK_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get());

        this.tag(BlockTags.REPLACEABLE_BY_TREES).add(ModBlocks.PALE_MOSS_BLOCK.value());
        this.tag(BlockTags.FLOWERS).add(ModBlocks.CLOSED_EYEBLOSSOM.value(), ModBlocks.OPEN_EYEBLOSSOM.value(), ModBlocks.WILDFLOWERS.value(), ModBlocks.BUSH.value(), ModBlocks.FIREFLY_BUSH.value(), ModBlocks.CACTUS_FLOWER.value());
        this.tag(BlockTags.SMALL_FLOWERS).add(ModBlocks.CLOSED_EYEBLOSSOM.value(), ModBlocks.OPEN_EYEBLOSSOM.value(), ModBlocks.WILDFLOWERS.value(), ModBlocks.BUSH.value(), ModBlocks.FIREFLY_BUSH.value(), ModBlocks.CACTUS_FLOWER.value());
        this.tag(BlockTags.REPLACEABLE).add(ModBlocks.WILDFLOWERS.value(), ModBlocks.BUSH.value(), ModBlocks.SHORT_DRY_GRASS.value(), ModBlocks.TALL_DRY_GRASS.value(), ModBlocks.LEAF_LITTER.value());

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.SILK_COCOON.get());
        this.tag(ModTags.Blocks.FERRET_DIG_GROUNDS).add(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT, Blocks.MOSS_BLOCK, Blocks.SAND, Blocks.RED_SAND);

        // ── Per-colour stained glass: add to colored subtags and minecraft:stained_glass ──
        // (The registry loop above handles c:glass_blocks and c:glass via TransparentBlock/CtmPaneBlock cases)
        for (DyeColor color : DyeColor.values()) {
            String c = color.getName();
            // Stained glass BLOCK variants (coloured, non-tinted)
            String[] coloredBlockNames = {
                "arched_" + c + "_stained_glass_ctm",
                c + "_framed_glass",
                "fancy_" + c + "_stained_glass_ctm",
                "fancy_" + c + "_stained_glass",
                "golden_framed_" + c + "_stained_glass",
                "ornate_" + c + "_stained_glass_ctm",
                "ornate_" + c + "_stained_glass",
                "raster_" + c + "_stained_glass_ctm",
                "raster_" + c + "_stained_glass",
                "scratched_glass_" + c,
                "small_" + c + "_diamond_stained_glass",
                "tiled_" + c + "_stained_glass_ctm",
                "tiled_" + c + "_stained_glass",
                "borderless_glass_" + c,
                c + "_stained_clear_glass",
                "circular_" + c + "_stained_glass",
                "large_diamond_" + c + "_stained_glass",
                "small_" + c + "_stained_glass",
                "square_" + c + "_stained_glass",
                "vertical_striped_" + c + "_stained_glass",
                "woven_" + c + "_stained_glass",
                c + "_leaded_stained_glass"
            };
            for (String name : coloredBlockNames) {
                Block block = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", name));
                if (block != Blocks.AIR) {
                    this.tag(cGlassBlocksColoredKey).add(block);
                    mcStainedGlass.add(block);
                }
            }
            // Tinted coloured block — colored but not stained_glass
            Block tintedColored = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", "tinted_borderless_glass_" + c));
            if (tintedColored != Blocks.AIR) {
                this.tag(cGlassBlocksColoredKey).add(tintedColored);
            }

            // CTM pane coloured variants
            String[] coloredPaneNames = {
                "arched_" + c + "_stained_glass_ctm_pane",
                c + "_framed_glass_ctm_pane",
                c + "_stained_glass_ctm_pane",
                "fancy_" + c + "_stained_glass_ctm_pane",
                "golden_framed_" + c + "_stained_glass_ctm_pane",
                "ornate_" + c + "_stained_glass_ctm_pane",
                "raster_" + c + "_stained_glass_ctm_pane",
                "scratched_glass_" + c + "_ctm_pane",
                "small_" + c + "_diamond_stained_glass_ctm_pane",
                "tiled_" + c + "_stained_glass_ctm_pane",
                "borderless_glass_" + c + "_ctm_pane",
                c + "_stained_clear_glass_ctm_pane",
                "tinted_borderless_glass_" + c + "_ctm_pane"
            };
            for (String name : coloredPaneNames) {
                Block pane = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ott", name));
                if (pane != Blocks.AIR) {
                    this.tag(cGlassPanesColoredKey).add(pane);
                }
            }
        }
    }

    @SafeVarargs
    private void addCommonLinkageTags(TagAppender<Block> appender, TagKey<Block>... tags) {
        for (TagKey<Block> tag : tags) {
            appender.addTag(tag);
        }
    }

    private void addWoodSetTags(TagKey<Block> logTag, Block log, Block wood, Block strippedLog, Block strippedWood,
                                Block planks, Block leaves, Block slab, Block stairs, Block fence, Block fenceGate,
                                Block door, Block trapdoor, Block button, Block pressurePlate, Block sign,
                                Block wallSign, Block hangingSign, Block wallHangingSign) {
        this.tag(logTag).add(log, wood, strippedLog, strippedWood);
        this.tag(BlockTags.LOGS).addTag(logTag);
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(logTag);
        this.tag(BlockTags.PLANKS).add(planks);
        this.tag(BlockTags.LEAVES).add(leaves);
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(leaves);
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(planks, slab, stairs, fence, fenceGate, door, trapdoor, button, pressurePlate, sign, wallSign, hangingSign, wallHangingSign);
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(leaves);
        this.tag(BlockTags.create(ResourceLocation.withDefaultNamespace("mineable/shears"))).add(leaves);
        this.tag(BlockTags.WOODEN_SLABS).add(slab);
        this.tag(BlockTags.WOODEN_STAIRS).add(stairs);
        this.tag(BlockTags.WOODEN_FENCES).add(fence);
        this.tag(BlockTags.FENCE_GATES).add(fenceGate);
        this.tag(BlockTags.WOODEN_DOORS).add(door);
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(trapdoor);
        this.tag(BlockTags.WOODEN_BUTTONS).add(button);
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(pressurePlate);
        this.tag(BlockTags.STANDING_SIGNS).add(sign);
        this.tag(BlockTags.WALL_SIGNS).add(wallSign);
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(hangingSign);
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(wallHangingSign);
    }

    private void addColorSetTags(ModBlocks.ColorSetBlocks set) {
        this.tag(BlockTags.CANDLES).add(set.candle().getKey());
        this.tag(BlockTags.SHULKER_BOXES).add(set.shulkerBox().getKey());
        this.tag(BlockTags.WOOL).add(set.wool().getKey());
        this.tag(BlockTags.BEDS).add(set.bed().getKey());
        this.tag(BlockTags.WOOL_CARPETS).add(set.carpet().getKey());
        this.tag(BlockTags.BANNERS).add(set.banner().getKey()).addOptional(set.wallBanner().getId());
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("stained_glass"))).add(set.stainedGlass().getKey());
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("stained_glass_panes"))).add(set.stainedGlassPane().getKey());
        this.tag(BlockTags.IMPERMEABLE).add(set.stainedGlass().getKey()).add(set.stainedGlassPane().getKey());

        // Mineable tags
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                set.concrete().getKey(),
                set.terracotta().getKey(),
                set.glazedTerracotta().getKey(),
                set.shulkerBox().getKey(),
                set.stainedGlass().getKey(),
                set.stainedGlassPane().getKey(),
                set.plate().getKey(),
                set.edge().getKey(),
                set.geometricWindow().getKey(),
                set.bannister().getKey(),
                set.supportSlab().getKey(),
                set.supportBeam().getKey()
        );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(set.concretePowder().getKey());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(set.bed().getKey()).add(set.banner().getKey()).addOptional(set.wallBanner().getId())
                .add(set.beam().getKey()).add(set.pergola().getKey());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(set.carpet().getKey());

        // Mod/Common tags
        TagKey<Block> ottConcreteKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/concrete"));
        TagKey<Block> ottConcretePowderKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/concrete_powder"));
        TagKey<Block> ottWoolKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/wool"));
        TagKey<Block> ottStainedGlassKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/stained_glass"));
        TagKey<Block> ottTerracottaKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/terracotta"));

        this.tag(ottConcreteKey).add(set.concrete().get());
        this.tag(ottConcretePowderKey).add(set.concretePowder().get());
        this.tag(ottWoolKey).add(set.wool().get());
        this.tag(ottStainedGlassKey).add(set.stainedGlass().get());
        this.tag(ottTerracottaKey).add(set.terracotta().get());

        // Add to vanilla tags being tracked in this provider (if they exist)
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("concrete"))).add(set.concrete().get());
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("concrete_powder"))).add(set.concretePowder().get());
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("stained_glass"))).add(set.stainedGlass().get());

        // Add to Domum Ornamentum default (building materials only)
        TagKey<Block> doDefaultKey = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("domum_ornamentum", "default"));
        this.tag(doDefaultKey).add(
                set.concrete().get(), set.concretePowder().get(),
                set.glazedTerracotta().get(), set.stainedGlass().get(),
                set.terracotta().get(), set.wool().get()
        );
    }

}