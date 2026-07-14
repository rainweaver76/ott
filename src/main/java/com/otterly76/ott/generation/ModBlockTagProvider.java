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

    /** Imported-block materials mined with an axe (wood planks, mushroom, wart blocks). */
    private static final java.util.Set<String> IMPORT_AXE_MATERIALS = java.util.Set.of(
            "acacia_planks", "bamboo_planks", "birch_planks", "cherry_planks", "crimson_planks",
            "dark_oak_planks", "jungle_planks", "mangrove_planks", "oak_planks", "spruce_planks", "warped_planks",
            "mushroom_stem", "brown_mushroom_block", "red_mushroom_block", "nether_wart_block", "warped_wart_block");
    /** Imported-block materials mined with a shovel (soils). */
    private static final java.util.Set<String> IMPORT_SHOVEL_MATERIALS = java.util.Set.of(
            "dirt", "mud", "clay", "sand", "gravel", "soul_sand", "moss_block", "snow_block");

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

        // Decorative chains — pickaxe-mineable like vanilla chain.
        com.otterly76.ott_blocks.block.OttBlocks.CHAINS.values().forEach(b -> pickaxeTag.add(b.get()));
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
                    String importMat = com.otterly76.ott_blocks.block.OttTemplateBlocks.MATERIAL_BY_NAME.get(bPath);
                    if (importMat != null) {
                        // Imported plain cube_all decorative blocks: tool by material, all are DO material cubes.
                        if (IMPORT_AXE_MATERIALS.contains(importMat)) {
                            axeTag.add(block);
                        } else if (IMPORT_SHOVEL_MATERIALS.contains(importMat)) {
                            shovelTag.add(block);
                        } else {
                            pickaxeTag.add(block);
                        }
                        this.tag(doDefaultKey).add(block);
                        if (importMat.endsWith("concrete")) {
                            ottConcrete.add(block);
                            mcConcrete.add(block);
                        } else if (importMat.endsWith("glazed_terracotta")) {
                            this.tag(doGlacedTerracottaKey).add(block);
                        } else if (importMat.contains("copper")) {
                            this.tag(doCopperKey).add(block);
                        }
                    } else if (bPath.endsWith("_ctm")) {
                        // CTM (connecting) blocks — uniform _ctm suffix
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

        // Auto-derived static (non-connecting) glass panes: glass tags only, mirroring the CtmPaneBlock
        // case minus CTM_BLOCKS (no "Connecting" tooltip). No mineable tag — glass breaks instantly by hand.
        com.otterly76.ott_blocks.block.OttTemplateBlocks.GLASS_PANES.values().forEach(db -> {
            Block pane = db.get();
            this.tag(cGlassKey).add(pane);
            this.tag(cGlassPanesKey).add(pane);
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
        this.tag(doDefaultKey).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_traditional")));
        this.tag(doDefaultKey).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_traditional")));
        this.tag(doDefaultKey).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_traditional")));
        this.tag(doDefaultKey).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_traditional")));
        this.tag(doDefaultKey).add(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_traditional")));
        ModBlocks.PARTICLE_HEDGES.values().forEach(h -> this.tag(doDefaultKey).add(h.value()));
        ModBlocks.PATTERN_BLOCKS.values().forEach(colorMap -> colorMap.values().forEach(d -> this.tag(doDefaultKey).add(d.value())));
        ModBlocks.FUTONS.values().forEach(d -> {
            this.tag(BlockTags.BEDS).add(d.value());
            axeTag.add(d.value());
        });

        this.tag(doDefaultKey).add(
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
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "stone_bricks_masonry")),
                // (delicate/ornamented wool DO-materials now added via the deco-family loop below)
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "mosaic_floor")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "mosaic_floor_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "mosaic_floor_rosette")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "roman_fresco_red")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "roman_fresco_black"))
        );

        // Stone variant blocks (plain cube_all + pillar only — CTM blocks excluded from DO)
        this.tag(doDefaultKey).add(
                OttBlocks.CHISELED_PLASTERED_STONE_PILLAR.get()
        );

        // ── Batch CTM blocks: now handled by loop over CTM_BLOCKS below ──────
        // Legacy "stone" legends (hand-built path) — pickaxe-mineable + DO material.
        java.util.stream.Stream.of(
                ModBlocks.CHISEL_LEGEND.values(), ModBlocks.CHISEL_LEGEND_RS.values()
        ).flatMap(java.util.Collection::stream).forEach(d -> { pickaxeTag.add(d.get()); this.tag(doDefaultKey).add(d.get()); });
        // Unified chisel set: all pillars + all chaos legends (incl. redstone) — pickaxe-mineable + DO material.
        java.util.stream.Stream.of(
                ModBlocks.CHISEL_CHAOS_PILLARS.values(), ModBlocks.CHISEL_CHAOS_PILLARS_RS.values(),
                ModBlocks.CHISEL_CHAOS_LEGENDS.values(), ModBlocks.CHISEL_CHAOS_LEGENDS_RS.values()
        ).flatMap(java.util.Collection::stream).forEach(d -> { pickaxeTag.add(d.get()); this.tag(doDefaultKey).add(d.get()); });

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
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "water_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "earth_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "fire_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "air_mosaic_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_border")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_geometric")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_pattern")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "spirit_mosaic_delicate")),
                // Mosaic floor
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "mosaic_floor")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "mosaic_floor_delicate")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "mosaic_floor_rosette")),
                // Decorative stone
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "roman_fresco_red")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "roman_fresco_black")),
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", "stone_bricks_masonry"))
                // CTM polished/vanilla variants
                // (delicate/ornamented wool & carpet now handled by the deco-family loop below)
                // CTM vertical pillars
        );

        // Wool and carpet blocks — all registered via OttTemplateBlocks.BY_NAME now.
        // Wool cubes (cube_all template) → DO material; CTM wools (_ctm suffix) → CTM_BLOCKS.
        // Carpets (carpet/carpet_ctm template) → tagged via the CarpetBlock loop above.
        com.otterly76.ott_blocks.block.OttTemplateBlocks.TEMPLATE_BY_NAME.forEach((name, template) -> {
            var db = com.otterly76.ott_blocks.block.OttTemplateBlocks.BY_NAME.get(name);
            if (db == null) return;
            if ("cube_all".equals(template) && name.endsWith("_wool")) {
                this.tag(doDefaultKey).add(db.get());
                if (name.endsWith("_wool_ctm")) this.tag(ModTags.Blocks.CTM_BLOCKS).add(db.get());
            }
            if ("carpet_ctm".equals(template)) this.tag(ModTags.Blocks.CTM_BLOCKS).add(db.get());
        });

        // Stone CTM connecting blocks — now handled by loop over CTM_BLOCKS below

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
        pickaxeTag.add(OttBlocks.SOUL_GLASS.get(), OttBlocks.SOUL_GLASS_PANE.get());
        this.tag(ModTags.Blocks.CTM_BLOCKS).add(OttBlocks.SOUL_GLASS.get());
        this.tag(BlockTags.IMPERMEABLE).add(OttBlocks.SOUL_GLASS.get(), OttBlocks.SOUL_GLASS_PANE.get());
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

        OttBlocks.WOOD_DOORS.forEach((name, db) -> {
            String wood = OttBlocks.WOOD_DOOR_WOOD.get(name);
            Block door = db.get();
            this.tag(BlockTags.DOORS).add(door);
            this.tag(BlockTags.WOODEN_DOORS).add(door);
            axeTag.add(door);
            this.tag(TagKey.create(Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/" + wood))).add(door);
        });
        OttBlocks.WOOD_TRAPDOORS.forEach((name, db) -> {
            String wood = OttBlocks.WOOD_TRAPDOOR_WOOD.get(name);
            Block trap = db.get();
            this.tag(BlockTags.TRAPDOORS).add(trap);
            this.tag(BlockTags.WOODEN_TRAPDOORS).add(trap);
            axeTag.add(trap);
            this.tag(TagKey.create(Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "material/" + wood))).add(trap);
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