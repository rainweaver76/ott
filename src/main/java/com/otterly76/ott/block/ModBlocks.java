package com.otterly76.ott.block;

import com.otterly76.ott.entity.custom.Butterfly;
import com.otterly76.ott.block.custom.*;
import com.otterly76.ott.color.ModPatterns;
import com.otterly76.ott.particle.ModParticle;
import net.minecraft.world.level.biome.Biome;
import com.otterly76.ott.crop.ThornyHedgeSprouts;
import com.otterly76.ott.hedge.ModHedgeVariants;
import com.otterly76.ott.sound.ModSounds;
import com.otterly76.ott.util.block.BlockSetTypeVariant;
import com.otterly76.ott.util.block.WoodTypeVariant;
import com.otterly76.ott.util.block.ModSkullType;
import net.minecraft.world.level.block.grower.TreeGrower;
import com.otterly76.ott.worldgen.feature.TheGardenAwakensFeatures;
import com.otterly76.ott.wood.ModWoodSets;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.otterly76.ott.Constants.MOD_ID;

@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "SameReturnValue"})
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Blocks MINECRAFT_BLOCKS = DeferredRegister.createBlocks("minecraft");
    public static final DeferredRegister.Items MINECRAFT_ITEMS = DeferredRegister.createItems("minecraft");
    public static final DeferredRegister.Items OTT_ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final List<DeferredBlock<? extends IGradientBlock>> ALL_GRADIENT_BLOCKS = new ArrayList<>();
    public static final Map<String, DeferredBlock<Block>> BOOKSHELVES = new LinkedHashMap<>();

    private static final List<DeferredBlock<? extends IGradientBlock>> ALL_CONCRETE_BLOCKS = new ArrayList<>();
    private static final List<DeferredBlock<? extends IGradientBlock>> ALL_TERRACOTTA_BLOCKS = new ArrayList<>();
    private static final List<DeferredBlock<? extends IGradientBlock>> ALL_WOOL_BLOCKS = new ArrayList<>();
    private static final List<DeferredBlock<? extends IGradientBlock>> ALL_STAINED_GLASS_BLOCKS = new ArrayList<>();
    private static final List<DeferredBlock<? extends IGradientBlock>> ALL_CONCRETE_POWDER_BLOCKS = new ArrayList<>();

    public static final List<DeferredBlock<? extends Block>> SEAGLASS = new ArrayList<>();

    public static final List<DeferredBlock<? extends Block>> TESTBLOCK = new ArrayList<>();

    public static final Map<String, DeferredBlock<ElevatorBlock>> ELEVATORS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<FutonBlock>> FUTONS = new LinkedHashMap<>();


    private static <T extends Block> DeferredBlock<T> register(String name, java.util.function.Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> DeferredBlock<T> registerTestblock(String name, java.util.function.Supplier<T> block) {
        DeferredBlock<T> ret = register(name, block);
        TESTBLOCK.add(ret);
        return ret;
    }

    public static final DeferredBlock<Block> TESTBLOCK_00 = registerTestblock("testblock_00", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_01 = registerTestblock("testblock_01", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_02 = registerTestblock("testblock_02", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_03 = registerTestblock("testblock_03", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_10 = registerTestblock("testblock_10", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_11 = registerTestblock("testblock_11", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_12 = registerTestblock("testblock_12", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_13 = registerTestblock("testblock_13", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_20 = registerTestblock("testblock_20", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_21 = registerTestblock("testblock_21", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_22 = registerTestblock("testblock_22", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_23 = registerTestblock("testblock_23", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_30 = registerTestblock("testblock_30", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_31 = registerTestblock("testblock_31", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_32 = registerTestblock("testblock_32", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TESTBLOCK_33 = registerTestblock("testblock_33", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<ChrysalisBlock> CHRYSALIS = register("chrysalis", () -> new ChrysalisBlock(Block.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).sound(SoundType.GRASS).noOcclusion().randomTicks()));


    private static <T extends Block> DeferredBlock<T> registerSeaglass(String name, java.util.function.Supplier<T> block) {
        DeferredBlock<T> ret = register(name, block);
        SEAGLASS.add(ret);
        return ret;
    }

    public static final DeferredBlock<Block> ETHEREAL1_BUBBLES_SEAGLASS = registerSeaglass("ethereal1_bubbles_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL1_SEAGLASS = registerSeaglass("ethereal1_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL1_SMOOTH_SEAGLASS = registerSeaglass("ethereal1_smooth_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL1_WAVES_SEAGLASS = registerSeaglass("ethereal1_waves_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL2_BUBBLES_SEAGLASS = registerSeaglass("ethereal2_bubbles_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL2_SEAGLASS = registerSeaglass("ethereal2_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL2_SMOOTH_SEAGLASS = registerSeaglass("ethereal2_smooth_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL2_WAVES_SEAGLASS = registerSeaglass("ethereal2_waves_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL3_BUBBLES_SEAGLASS = registerSeaglass("ethereal3_bubbles_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL3_SEAGLASS = registerSeaglass("ethereal3_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL3_SMOOTH_SEAGLASS = registerSeaglass("ethereal3_smooth_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL3_WAVES_SEAGLASS = registerSeaglass("ethereal3_waves_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL4_BUBBLES_SEAGLASS = registerSeaglass("ethereal4_bubbles_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL4_SEAGLASS = registerSeaglass("ethereal4_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL4_SMOOTH_SEAGLASS = registerSeaglass("ethereal4_smooth_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ETHEREAL4_WAVES_SEAGLASS = registerSeaglass("ethereal4_waves_seaglass", () -> new TransparentBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()));

    public static final DeferredBlock<Block> SOUL_GLASS = register("soul_glass",
            () -> new TransparentBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion()
                    .isValidSpawn((state, level, pos, type) -> false)
                    .isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<IronBarsBlock> SOUL_GLASS_PANE = register("soul_glass_pane",
            () -> new IronBarsBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion()
                    .isValidSpawn((state, level, pos, type) -> false)
                    .isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<Block> SOUL_GLASS_CTM = register("soul_glass_ctm",
            () -> new TransparentBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion()
                    .isValidSpawn((state, level, pos, type) -> false)
                    .isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<CtmPaneBlock> SOUL_GLASS_CTM_PANE = register("soul_glass_ctm_pane",
            () -> new CtmPaneBlock(Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    public static final DeferredBlock<Block> PINK_SALT_BLOCK = register("pink_salt_block", () -> new Block(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> POLISHED_PINK_SALT_BLOCK = register("polished_pink_salt_block", () -> new Block(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> PINK_SALT_LAMP = register("pink_salt_lamp", () -> new SaltLampBlock(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.IRON_XYLOPHONE).strength(0.3F).sound(SoundType.GLASS).lightLevel(state -> state.getValue(SaltLampBlock.LIT) ? 15 : 0).noOcclusion()));
    public static final DeferredBlock<Block> PINK_SALT_DUST = register("pink_salt_dust", () -> new SaltPlacedBlock(Properties.of().mapColor(MapColor.SNOW).noCollission().instabreak().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> OAK_NEST = register("oak_nest", () -> new OakNestBlock(Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion()));

    /**
     * Per-wood door styles, keyed by wood name, matching exactly the available textures.
     */
    public static final Map<String, List<String>> WOOD_DOOR_STYLES = new LinkedHashMap<>();
    /**
     * Acacia door styles (canonical reference; no {@code barred} variant).
     */
    public static final List<String> DOOR_STYLES = List.of("paper");
    public static final Map<String, Map<String, DeferredBlock<DoorBlock>>> WOOD_DOORS = new LinkedHashMap<>();
    /** New-style door blocks not covered by WOOD_DOORS (e.g. oak_bamboo_door, oak_barn_glass_door). */
    public static final Map<String, DeferredBlock<DoorBlock>> EXTRA_DOORS = new LinkedHashMap<>();
    /** All custom trapdoor blocks keyed by full block name. */
    public static final Map<String, DeferredBlock<TrapDoorBlock>> WOOD_TRAPDOORS = new LinkedHashMap<>();

    public static final DeferredBlock<BeehiveBlock> ACACIA_BEEHIVE = register("acacia_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> BAMBOO_BEEHIVE = register("bamboo_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> BIRCH_BEEHIVE = register("birch_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> CHERRY_BEEHIVE = register("cherry_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> CRIMSON_BEEHIVE = register("crimson_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> DARK_OAK_BEEHIVE = register("dark_oak_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> JUNGLE_BEEHIVE = register("jungle_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> MANGROVE_BEEHIVE = register("mangrove_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> PALE_OAK_BEEHIVE = register("pale_oak_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> SPRUCE_BEEHIVE = register("spruce_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));
    public static final DeferredBlock<BeehiveBlock> WARPED_BEEHIVE = register("warped_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)));

    public static final DeferredBlock<AlligatorEggBlock> ALLIGATOR_EGG = register("alligator_egg", () -> new AlligatorEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.5F).sound(SoundType.METAL).noOcclusion().randomTicks()));
    public static final DeferredBlock<TortoiseEggBlock> TORTOISE_EGG = register("tortoise_egg", () -> new TortoiseEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.5F).sound(SoundType.METAL).noOcclusion().randomTicks()));
    public static final DeferredBlock<SnailEggBlock> SNAIL_EGG = register("snail_egg", () -> new SnailEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.0F).sound(SoundType.FROGSPAWN).noCollission().noOcclusion()));
    public static final DeferredBlock<Block> REFINED_GLOWSTONE = register("refined_glowstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)));
    public static final DeferredBlock<Block> GLOW_GOOP = register("glow_goop", () -> new GlowGoopBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).noCollission().noOcclusion().instabreak().lightLevel(GlowGoopBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<com.otterly76.ott.block.custom.SilkCocoonBlock> SILK_COCOON = register("silk_cocoon", () -> new com.otterly76.ott.block.custom.SilkCocoonBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<SaplingBlock> PALE_OAK_SAPLING = registerBackportedBlock("pale_oak_sapling", () -> new SaplingBlock(new TreeGrower("pale_oak", Optional.of(TheGardenAwakensFeatures.PALE_OAK_BONEMEAL), Optional.empty(), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)), false);
    public static final DeferredBlock<FlowerPotBlock> POTTED_PALE_OAK_SAPLING = registerBackportedBlock("potted_pale_oak_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PALE_OAK_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).noOcclusion()), false);

    public static final DeferredBlock<Block> PROTECTIVE_LANTERN = BLOCKS.register("protective_lantern",
            () -> new ProtectiveLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)));

    public static final DeferredBlock<Block> WATER_LANTERN = BLOCKS.register("water_lantern",
            () -> new FluidLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), FluidLanternBlock.Type.WATER));

    public static final DeferredBlock<Block> LAVA_LANTERN = BLOCKS.register("lava_lantern",
            () -> new FluidLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), FluidLanternBlock.Type.LAVA));

    public static final DeferredBlock<BigLilyPadBlock> BIG_LILY_PAD = BLOCKS.register("big_lily_pad",
            () -> new BigLilyPadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).noOcclusion()));

    public static final DeferredBlock<Block> SMITE_LANTERN = BLOCKS.register("smite_lantern",
            () -> new SmiteLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)));

    /**
     * Your original "real hedge" block (damage/bonemeal/etc). Keep separate.
     */
    public static final DeferredBlock<ThornyHedgeBlock> THORNY_HEDGE =
            BLOCKS.register("thorny_hedge", () -> new ThornyHedgeBlock(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> THORNY_HEDGE_SPROUTS =
            BLOCKS.register("thorny_hedge_sprouts", () -> new ThornyHedgeSprouts(Block.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final Map<String, DeferredBlock<Block>> PARTICLE_HEDGES = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> CREEPING_HEDGES = new LinkedHashMap<>();


    private static DeferredBlock<DoorBlock> registerDoor(String name, net.minecraft.world.level.block.state.properties.BlockSetType bst, Block template) {
        DeferredBlock<DoorBlock> ret = BLOCKS.register(name, () -> new DoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(template)));
        OTT_ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    private static DeferredBlock<TrapDoorBlock> registerTrapdoor(String name, net.minecraft.world.level.block.state.properties.BlockSetType bst, Block template) {
        DeferredBlock<TrapDoorBlock> ret = BLOCKS.register(name, () -> new TrapDoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(template)));
        OTT_ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    private static DeferredBlock<Block> registerBookshelf(String name) {
        DeferredBlock<Block> ret = BLOCKS.register(name, () -> new RotatedPillarBlock(Properties.of().strength(1.5f).sound(SoundType.WOOD)));
        OTT_ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    private static <T extends Block> DeferredBlock<T> registerBackportedBlock(String name, java.util.function.Supplier<T> block) {
        return registerBackportedBlock(name, block, true);
    }

    private static <T extends Block> DeferredBlock<T> registerBackportedBlock(String name, java.util.function.Supplier<T> block, boolean createItem) {
        DeferredBlock<T> ret = MINECRAFT_BLOCKS.register(name, block);
        if (createItem) {
            MINECRAFT_ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        }
        return ret;
    }

    public static final DeferredBlock<Block> PALE_MOSS_BLOCK = registerBackportedBlock("pale_moss_block", () -> new PaleMossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<Block> PALE_MOSS_CARPET = registerBackportedBlock("pale_moss_carpet", () -> new MossyCarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_CARPET).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<HangingMossBlock> PALE_HANGING_MOSS = registerBackportedBlock("pale_hanging_moss", () -> new HangingMossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HANGING_ROOTS).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<RotatedPillarBlock> PALE_OAK_LOG = registerBackportedBlock("pale_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.QUARTZ : MapColor.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PALE_OAK_WOOD = registerBackportedBlock("pale_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_PALE_OAK_LOG = registerBackportedBlock("stripped_pale_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_PALE_OAK_WOOD = registerBackportedBlock("stripped_pale_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.QUARTZ)));

    public static final DeferredBlock<Block> PALE_OAK_PLANKS = registerBackportedBlock("pale_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<StairBlock> PALE_OAK_STAIRS = registerBackportedBlock("pale_oak_stairs", () -> new StairBlock(PALE_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PALE_OAK_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> PALE_OAK_SLAB = registerBackportedBlock("pale_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PALE_OAK_PLANKS.get())));
    public static final DeferredBlock<FenceBlock> PALE_OAK_FENCE = registerBackportedBlock("pale_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<FenceGateBlock> PALE_OAK_FENCE_GATE = registerBackportedBlock("pale_oak_fence_gate", () -> new FenceGateBlock(WoodTypeVariant.PALE_OAK.getWoodType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<DoorBlock> PALE_OAK_DOOR = registerBackportedBlock("pale_oak_door", () -> new DoorBlock(BlockSetTypeVariant.PALE_OAK.getBlockSetType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<TrapDoorBlock> PALE_OAK_TRAPDOOR = registerBackportedBlock("pale_oak_trapdoor", () -> new TrapDoorBlock(BlockSetTypeVariant.PALE_OAK.getBlockSetType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<PressurePlateBlock> PALE_OAK_PRESSURE_PLATE = registerBackportedBlock("pale_oak_pressure_plate", () -> new PressurePlateBlock(BlockSetTypeVariant.PALE_OAK.getBlockSetType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<ButtonBlock> PALE_OAK_BUTTON = registerBackportedBlock("pale_oak_button", () -> new ButtonBlock(BlockSetTypeVariant.PALE_OAK.getBlockSetType(), 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<StandingSignBlock> PALE_OAK_SIGN = registerBackportedBlock("pale_oak_sign", () -> new StandingSignBlock(WoodTypeVariant.PALE_OAK.getWoodType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY)), false);
    public static final DeferredBlock<WallSignBlock> PALE_OAK_WALL_SIGN = registerBackportedBlock("pale_oak_wall_sign", () -> new WallSignBlock(WoodTypeVariant.PALE_OAK.getWoodType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY)), false);
    public static final DeferredBlock<CeilingHangingSignBlock> PALE_OAK_HANGING_SIGN = registerBackportedBlock("pale_oak_hanging_sign", () -> new CeilingHangingSignBlock(WoodTypeVariant.PALE_OAK.getWoodType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY)), false);
    public static final DeferredBlock<WallHangingSignBlock> PALE_OAK_WALL_HANGING_SIGN = registerBackportedBlock("pale_oak_wall_hanging_sign", () -> new WallHangingSignBlock(WoodTypeVariant.PALE_OAK.getWoodType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY)), false);

    public static final DeferredBlock<LeavesBlock> PALE_OAK_LEAVES = registerBackportedBlock("pale_oak_leaves", () -> new ParticleLeavesBlock(50, ModParticle.PALE_OAK_LEAVES, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_GREEN)));

    public static final DeferredBlock<EyeblossomBlock> CLOSED_EYEBLOSSOM = registerBackportedBlock("closed_eyeblossom", () -> new EyeblossomBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final DeferredBlock<EyeblossomBlock> OPEN_EYEBLOSSOM = registerBackportedBlock("open_eyeblossom", () -> new EyeblossomBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_ORANGE).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).lightLevel((state) -> 11).randomTicks()));
    public static final DeferredBlock<FlowerPotBlock> POTTED_CLOSED_EYEBLOSSOM = registerBackportedBlock("potted_closed_eyeblossom", () -> new EyeblossomFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CLOSED_EYEBLOSSOM, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY).randomTicks()), false);
    public static final DeferredBlock<FlowerPotBlock> POTTED_OPEN_EYEBLOSSOM = registerBackportedBlock("potted_open_eyeblossom", () -> new EyeblossomFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, OPEN_EYEBLOSSOM, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY).lightLevel((state) -> 11).randomTicks()), false);

    public static final DeferredBlock<CreakingHeartBlock> CREAKING_HEART = registerBackportedBlock("creaking_heart", () -> new CreakingHeartBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(10.0F).sound(ModSounds.CREAKING_HEART).lightLevel(state -> state.getValue(com.otterly76.ott.registry.ModBlockStateProperties.CREAKING_HEART_STATE) == com.otterly76.ott.util.block.CreakingHeartState.AWAKE ? 15 : 0)));
    public static final DeferredBlock<ResinClumpBlock> RESIN_CLUMP = registerBackportedBlock("resin_clump", () -> new ResinClumpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK_VEIN).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN)));
    public static final DeferredBlock<Block> RESIN_BLOCK = registerBackportedBlock("resin_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN)));
    public static final DeferredBlock<Block> RESIN_BRICKS = registerBackportedBlock("resin_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN_BRICKS)));
    public static final DeferredBlock<StairBlock> RESIN_BRICK_STAIRS = registerBackportedBlock("resin_brick_stairs", () -> new StairBlock(RESIN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_STAIRS).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN_BRICKS)));
    public static final DeferredBlock<SlabBlock> RESIN_BRICK_SLAB = registerBackportedBlock("resin_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN_BRICKS)));
    public static final DeferredBlock<WallBlock> RESIN_BRICK_WALL = registerBackportedBlock("resin_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_WALL).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN_BRICKS)));
    public static final DeferredBlock<Block> CHISELED_RESIN_BRICKS = registerBackportedBlock("chiseled_resin_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.COLOR_ORANGE).sound(ModSounds.RESIN_BRICKS)));

    public static final DeferredBlock<DriedGhastBlock> DRIED_GHAST = registerBackportedBlock("dried_ghast", () -> new DriedGhastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instabreak().sound(ModSounds.DRIED_GHAST).noOcclusion().randomTicks()));
    public static final DeferredBlock<ActualBushBlock> BUSH = registerBackportedBlock("bush", () -> new ActualBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FireflyBushBlock> FIREFLY_BUSH = registerBackportedBlock("firefly_bush", () -> new FireflyBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).ignitedByLava().lightLevel((state) -> 2).noCollission().instabreak().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WILDFLOWERS = registerBackportedBlock("wildflowers", () -> new com.otterly76.ott.block.custom.WildflowersBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PALE_WILDFLOWERS = BLOCKS.register("pale_wildflowers", () -> new com.otterly76.ott.block.custom.WildflowersBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<LeafLitterBlock> LEAF_LITTER = registerBackportedBlock("leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).replaceable().noCollission().sound(ModSounds.LEAF_LITTER).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<CactusFlowerBlock> CACTUS_FLOWER = registerBackportedBlock("cactus_flower", () -> new CactusFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().ignitedByLava().sound(ModSounds.CACTUS_FLOWER).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ShortDryGrassBlock> SHORT_DRY_GRASS = registerBackportedBlock("short_dry_grass", () -> new ShortDryGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<TallDryGrassBlock> TALL_DRY_GRASS = registerBackportedBlock("tall_dry_grass", () -> new TallDryGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<CopperChestBlock> COPPER_CHEST = registerBackportedBlock("copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<CopperChestBlock> EXPOSED_COPPER_CHEST = registerBackportedBlock("exposed_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<CopperChestBlock> WEATHERED_COPPER_CHEST = registerBackportedBlock("weathered_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<CopperChestBlock> OXIDIZED_COPPER_CHEST = registerBackportedBlock("oxidized_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);

    public static final DeferredBlock<CopperChestBlock> WAXED_COPPER_CHEST = registerBackportedBlock("waxed_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<CopperChestBlock> WAXED_EXPOSED_COPPER_CHEST = registerBackportedBlock("waxed_exposed_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<CopperChestBlock> WAXED_WEATHERED_COPPER_CHEST = registerBackportedBlock("waxed_weathered_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<CopperChestBlock> WAXED_OXIDIZED_COPPER_CHEST = registerBackportedBlock("waxed_oxidized_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.COPPER)), false);
    public static final DeferredBlock<Block> WEATHERING_STATION = register("weathering_station", () -> new com.otterly76.ott.block.custom.WeatheringStationBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<Block> WOODCUTTER = register("woodcutter", () -> new com.otterly76.ott.block.custom.WoodcutterBlock(BlockBehaviour.Properties.of().strength(3.5f).sound(SoundType.WOOD).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> ENGRAVING_TABLE = register("engraving_table", () -> new com.otterly76.ott.block.custom.EngravingTableBlock(BlockBehaviour.Properties.of().strength(3.5f).sound(SoundType.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final List<DeferredBlock<com.otterly76.ott.block.shelf.ShelfBlock>> SHELVES = new ArrayList<>();
    public static final Map<String, Supplier<? extends com.otterly76.ott.block.custom.CopperGolemStatueBlock>> COPPER_GOLEM_STATUES = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_BUTTONS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_DOORS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_TRAPDOORS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_LANTERNS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_SOUL_LANTERNS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_CHAINS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_BARS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_HOPPERS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_LADDERS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_CAULDRONS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_WATER_CAULDRONS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_LAVA_CAULDRONS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_POWDER_SNOW_CAULDRONS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_RAILS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_ANVILS = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> COPPER_PRESSURE_PLATES = new LinkedHashMap<>();
    public static final Map<String, Supplier<? extends Block>> LIGHTNING_RODS = new LinkedHashMap<>();
    public static final DeferredBlock<Block> COPPER_TORCH = registerBackportedBlock("copper_torch", () -> new CopperTorchBlock(ModParticle.COPPER_FIRE_FLAME, BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(s -> 14).sound(SoundType.WOOD)), false);
    public static final DeferredBlock<Block> COPPER_WALL_TORCH = registerBackportedBlock("copper_wall_torch", () -> new CopperWallTorchBlock(ModParticle.COPPER_FIRE_FLAME, BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(s -> 14).sound(SoundType.WOOD).lootFrom(COPPER_TORCH)), false);
    public static final DeferredBlock<SkullBlock> DRAGON_SKULL = BLOCKS.register("dragon_skull", () -> new SkullBlock(ModSkullType.DRAGON_SKULL, BlockBehaviour.Properties.ofFullCopy(Blocks.DRAGON_HEAD).noOcclusion()));
    public static final DeferredBlock<WallSkullBlock> DRAGON_WALL_SKULL = BLOCKS.register("dragon_wall_skull", () -> new NonOccludingWallSkullBlock(ModSkullType.DRAGON_SKULL, BlockBehaviour.Properties.ofFullCopy(Blocks.DRAGON_WALL_HEAD).noOcclusion().lootFrom(DRAGON_SKULL)));

    private static void register3DBlockItem(DeferredBlock<? extends Block> block) {
        MINECRAFT_ITEMS.register(block.getId().getPath(), () -> new com.otterly76.ott.item.custom.Copper3DBlockItem(block.get(), new net.minecraft.world.item.Item.Properties()));
    }

    private static void registerDynamicBlocks() {
        for (Butterfly.Variant variant : Butterfly.Variant.values()) {
            BUTTERFLY_JARS.put(variant, BLOCKS.register("butterfly_jar_" + variant.getName(),
                    () -> new com.otterly76.ott.block.custom.ButterflyJarBlock(variant, BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.3F).sound(SoundType.GLASS).noOcclusion())));
        }

        MINECRAFT_ITEMS.register("copper_torch", () -> new net.minecraft.world.item.StandingAndWallBlockItem(COPPER_TORCH.get(), COPPER_WALL_TORCH.get(), new net.minecraft.world.item.Item.Properties(), net.minecraft.core.Direction.DOWN));

        register3DBlockItem(COPPER_CHEST);
        register3DBlockItem(EXPOSED_COPPER_CHEST);
        register3DBlockItem(WEATHERED_COPPER_CHEST);
        register3DBlockItem(OXIDIZED_COPPER_CHEST);
        register3DBlockItem(WAXED_COPPER_CHEST);
        register3DBlockItem(WAXED_EXPOSED_COPPER_CHEST);
        register3DBlockItem(WAXED_WEATHERED_COPPER_CHEST);
        register3DBlockItem(WAXED_OXIDIZED_COPPER_CHEST);

        String[] shelfWoods = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak"};
        for (String wood : shelfWoods) {
            SHELVES.add(registerBackportedBlock(wood + "_shelf", () -> new com.otterly76.ott.block.shelf.ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion())));
        }

        // Bookshelves — RotatedPillarBlock, OTT namespace, side = bookshelf texture, end = wood planks
        for (String name : List.of("acacia_bookshelf", "bamboo_bookshelf", "birch_bookshelf", "cherry_bookshelf", "crimson_bookshelf", "dark_oak_bookshelf", "jungle_bookshelf", "mangrove_bookshelf", "spruce_bookshelf", "warped_bookshelf")) {
            BOOKSHELVES.put(name, registerBookshelf(name));
        }

        // Per-wood style lists (must exactly match available texture files)
        WOOD_DOOR_STYLES.put("oak", List.of());
        WOOD_DOOR_STYLES.put("spruce", List.of());
        WOOD_DOOR_STYLES.put("birch", List.of());
        WOOD_DOOR_STYLES.put("jungle", List.of());
        WOOD_DOOR_STYLES.put("acacia", DOOR_STYLES);
        WOOD_DOOR_STYLES.put("dark_oak", List.of());
        WOOD_DOOR_STYLES.put("mangrove", List.of());
        WOOD_DOOR_STYLES.put("cherry", List.of());
        WOOD_DOOR_STYLES.put("bamboo", List.of());
        WOOD_DOOR_STYLES.put("crimson", List.of());
        WOOD_DOOR_STYLES.put("warped", List.of());

        String[] woodDoorNames = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "crimson", "warped"};
        BlockSetType[] woodBSTs = {BlockSetType.OAK, BlockSetType.SPRUCE, BlockSetType.BIRCH, BlockSetType.JUNGLE, BlockSetType.ACACIA, BlockSetType.DARK_OAK, BlockSetType.MANGROVE, BlockSetType.CHERRY, BlockSetType.BAMBOO, BlockSetType.CRIMSON, BlockSetType.WARPED};
        Block[] vanillaDoors = {Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.MANGROVE_DOOR, Blocks.CHERRY_DOOR, Blocks.BAMBOO_DOOR, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR};
        for (int i = 0; i < woodDoorNames.length; i++) {
            String wood = woodDoorNames[i];
            BlockSetType bst = woodBSTs[i];
            Block vanillaDoor = vanillaDoors[i];
            List<String> styles = WOOD_DOOR_STYLES.get(wood);
            Map<String, DeferredBlock<DoorBlock>> woodMap = new LinkedHashMap<>();
            WOOD_DOORS.put(wood, woodMap);
            for (String style : styles) {
                woodMap.put(style, register(style + "_" + wood + "_door",
                        () -> new DoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(vanillaDoor))));
            }
        }
        // Extra wood doors (new-style naming, not in WOOD_DOORS)
        EXTRA_DOORS.put("japanese_oak_door", registerDoor("japanese_oak_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_bamboo_door", registerDoor("oak_bamboo_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_barn_door", registerDoor("oak_barn_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_beach_door", registerDoor("oak_beach_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_cottage_door", registerDoor("oak_cottage_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_four_panel_door", registerDoor("oak_four_panel_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_glass_door", registerDoor("oak_glass_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_japanese_door", registerDoor("oak_japanese_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_modern_door", registerDoor("oak_modern_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_mystic_door", registerDoor("oak_mystic_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_nether_door", registerDoor("oak_nether_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_paper_door", registerDoor("oak_paper_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_stable_door", registerDoor("oak_stable_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_swamp_door", registerDoor("oak_swamp_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_tropical_door", registerDoor("oak_tropical_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_waffle_door", registerDoor("oak_waffle_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_western_door", registerDoor("oak_western_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_whispering_door", registerDoor("oak_whispering_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_barn_glass_door", registerDoor("oak_barn_glass_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("oak_stable_head_door", registerDoor("oak_stable_head_door", BlockSetType.OAK, Blocks.OAK_DOOR));
        EXTRA_DOORS.put("japanese_spruce_door", registerDoor("japanese_spruce_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_bamboo_door", registerDoor("spruce_bamboo_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_barn_door", registerDoor("spruce_barn_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_beach_door", registerDoor("spruce_beach_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_classic_door", registerDoor("spruce_classic_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_four_panel_door", registerDoor("spruce_four_panel_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_glass_door", registerDoor("spruce_glass_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_japanese_door", registerDoor("spruce_japanese_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_modern_door", registerDoor("spruce_modern_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_mystic_door", registerDoor("spruce_mystic_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_nether_door", registerDoor("spruce_nether_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_paper_door", registerDoor("spruce_paper_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_stable_door", registerDoor("spruce_stable_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_swamp_door", registerDoor("spruce_swamp_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_tropical_door", registerDoor("spruce_tropical_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_waffle_door", registerDoor("spruce_waffle_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_western_door", registerDoor("spruce_western_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_whispering_door", registerDoor("spruce_whispering_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_barn_glass_door", registerDoor("spruce_barn_glass_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("spruce_stable_head_door", registerDoor("spruce_stable_head_door", BlockSetType.SPRUCE, Blocks.SPRUCE_DOOR));
        EXTRA_DOORS.put("birch_bamboo_door", registerDoor("birch_bamboo_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_barn_door", registerDoor("birch_barn_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_beach_door", registerDoor("birch_beach_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_classic_door", registerDoor("birch_classic_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_cottage_door", registerDoor("birch_cottage_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_four_panel_door", registerDoor("birch_four_panel_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_glass_door", registerDoor("birch_glass_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_japanese_door", registerDoor("birch_japanese_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_modern_door", registerDoor("birch_modern_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_mystic_door", registerDoor("birch_mystic_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_nether_door", registerDoor("birch_nether_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_stable_door", registerDoor("birch_stable_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_swamp_door", registerDoor("birch_swamp_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_tropical_door", registerDoor("birch_tropical_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_waffle_door", registerDoor("birch_waffle_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_western_door", registerDoor("birch_western_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_whispering_door", registerDoor("birch_whispering_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("japanese_birch_door", registerDoor("japanese_birch_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_barn_glass_door", registerDoor("birch_barn_glass_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("birch_stable_head_door", registerDoor("birch_stable_head_door", BlockSetType.BIRCH, Blocks.BIRCH_DOOR));
        EXTRA_DOORS.put("japanese_jungle_door", registerDoor("japanese_jungle_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_bamboo_door", registerDoor("jungle_bamboo_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_barn_door", registerDoor("jungle_barn_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_classic_door", registerDoor("jungle_classic_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_cottage_door", registerDoor("jungle_cottage_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_four_panel_door", registerDoor("jungle_four_panel_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_glass_door", registerDoor("jungle_glass_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_japanese_door", registerDoor("jungle_japanese_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_modern_door", registerDoor("jungle_modern_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_mystic_door", registerDoor("jungle_mystic_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_nether_door", registerDoor("jungle_nether_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_paper_door", registerDoor("jungle_paper_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_stable_door", registerDoor("jungle_stable_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_swamp_door", registerDoor("jungle_swamp_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_tropical_door", registerDoor("jungle_tropical_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_waffle_door", registerDoor("jungle_waffle_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_western_door", registerDoor("jungle_western_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_whispering_door", registerDoor("jungle_whispering_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_barn_glass_door", registerDoor("jungle_barn_glass_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("jungle_stable_head_door", registerDoor("jungle_stable_head_door", BlockSetType.JUNGLE, Blocks.JUNGLE_DOOR));
        EXTRA_DOORS.put("acacia_bamboo_door", registerDoor("acacia_bamboo_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_barn_door", registerDoor("acacia_barn_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_beach_door", registerDoor("acacia_beach_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_classic_door", registerDoor("acacia_classic_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_cottage_door", registerDoor("acacia_cottage_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_four_panel_door", registerDoor("acacia_four_panel_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_glass_door", registerDoor("acacia_glass_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_japanese_door", registerDoor("acacia_japanese_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_modern_door", registerDoor("acacia_modern_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_mystic_door", registerDoor("acacia_mystic_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_nether_door", registerDoor("acacia_nether_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_paper_door", registerDoor("acacia_paper_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_stable_door", registerDoor("acacia_stable_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_swamp_door", registerDoor("acacia_swamp_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_waffle_door", registerDoor("acacia_waffle_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_western_door", registerDoor("acacia_western_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_whispering_door", registerDoor("acacia_whispering_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("japanese_acacia_door", registerDoor("japanese_acacia_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_barn_glass_door", registerDoor("acacia_barn_glass_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("acacia_stable_head_door", registerDoor("acacia_stable_head_door", BlockSetType.ACACIA, Blocks.ACACIA_DOOR));
        EXTRA_DOORS.put("dark_oak_bamboo_door", registerDoor("dark_oak_bamboo_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_barn_door", registerDoor("dark_oak_barn_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_beach_door", registerDoor("dark_oak_beach_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_classic_door", registerDoor("dark_oak_classic_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_cottage_door", registerDoor("dark_oak_cottage_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_glass_door", registerDoor("dark_oak_glass_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_japanese_door", registerDoor("dark_oak_japanese_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_modern_door", registerDoor("dark_oak_modern_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_mystic_door", registerDoor("dark_oak_mystic_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_nether_door", registerDoor("dark_oak_nether_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_paper_door", registerDoor("dark_oak_paper_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_stable_door", registerDoor("dark_oak_stable_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_swamp_door", registerDoor("dark_oak_swamp_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_tropical_door", registerDoor("dark_oak_tropical_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_waffle_door", registerDoor("dark_oak_waffle_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_western_door", registerDoor("dark_oak_western_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_whispering_door", registerDoor("dark_oak_whispering_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("japanese_dark_oak_door", registerDoor("japanese_dark_oak_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_barn_glass_door", registerDoor("dark_oak_barn_glass_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("dark_oak_stable_head_door", registerDoor("dark_oak_stable_head_door", BlockSetType.DARK_OAK, Blocks.DARK_OAK_DOOR));
        EXTRA_DOORS.put("japanese_mangrove_door", registerDoor("japanese_mangrove_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_bamboo_door", registerDoor("mangrove_bamboo_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_barn_door", registerDoor("mangrove_barn_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_beach_door", registerDoor("mangrove_beach_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_classic_door", registerDoor("mangrove_classic_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_cottage_door", registerDoor("mangrove_cottage_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_four_panel_door", registerDoor("mangrove_four_panel_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_glass_door", registerDoor("mangrove_glass_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_japanese_door", registerDoor("mangrove_japanese_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_modern_door", registerDoor("mangrove_modern_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_mystic_door", registerDoor("mangrove_mystic_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_nether_door", registerDoor("mangrove_nether_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_paper_door", registerDoor("mangrove_paper_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_stable_door", registerDoor("mangrove_stable_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_tropical_door", registerDoor("mangrove_tropical_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_waffle_door", registerDoor("mangrove_waffle_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_western_door", registerDoor("mangrove_western_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_whispering_door", registerDoor("mangrove_whispering_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_barn_glass_door", registerDoor("mangrove_barn_glass_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("mangrove_stable_head_door", registerDoor("mangrove_stable_head_door", BlockSetType.MANGROVE, Blocks.MANGROVE_DOOR));
        EXTRA_DOORS.put("cherry_bamboo_door", registerDoor("cherry_bamboo_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_barn_door", registerDoor("cherry_barn_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_beach_door", registerDoor("cherry_beach_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_classic_door", registerDoor("cherry_classic_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_cottage_door", registerDoor("cherry_cottage_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_four_panel_door", registerDoor("cherry_four_panel_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_glass_door", registerDoor("cherry_glass_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_japanese_door", registerDoor("cherry_japanese_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_modern_door", registerDoor("cherry_modern_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_mystic_door", registerDoor("cherry_mystic_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_nether_door", registerDoor("cherry_nether_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_paper_door", registerDoor("cherry_paper_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_stable_door", registerDoor("cherry_stable_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_swamp_door", registerDoor("cherry_swamp_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_tropical_door", registerDoor("cherry_tropical_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_western_door", registerDoor("cherry_western_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_whispering_door", registerDoor("cherry_whispering_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("japanese_cherry_door", registerDoor("japanese_cherry_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_barn_glass_door", registerDoor("cherry_barn_glass_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("cherry_stable_head_door", registerDoor("cherry_stable_head_door", BlockSetType.CHERRY, Blocks.CHERRY_DOOR));
        EXTRA_DOORS.put("bamboo_barn_door", registerDoor("bamboo_barn_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_beach_door", registerDoor("bamboo_beach_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_classic_door", registerDoor("bamboo_classic_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_cottage_door", registerDoor("bamboo_cottage_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_four_panel_door", registerDoor("bamboo_four_panel_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_glass_door", registerDoor("bamboo_glass_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_japanese_door", registerDoor("bamboo_japanese_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_modern_door", registerDoor("bamboo_modern_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_mystic_door", registerDoor("bamboo_mystic_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_nether_door", registerDoor("bamboo_nether_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_paper_door", registerDoor("bamboo_paper_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_stable_door", registerDoor("bamboo_stable_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_swamp_door", registerDoor("bamboo_swamp_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_tropical_door", registerDoor("bamboo_tropical_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_waffle_door", registerDoor("bamboo_waffle_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_western_door", registerDoor("bamboo_western_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_whispering_door", registerDoor("bamboo_whispering_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("japanese_bamboo_door", registerDoor("japanese_bamboo_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_barn_glass_door", registerDoor("bamboo_barn_glass_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("bamboo_stable_head_door", registerDoor("bamboo_stable_head_door", BlockSetType.BAMBOO, Blocks.BAMBOO_DOOR));
        EXTRA_DOORS.put("crimson_bamboo_door", registerDoor("crimson_bamboo_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_barn_door", registerDoor("crimson_barn_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_beach_door", registerDoor("crimson_beach_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_classic_door", registerDoor("crimson_classic_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_cottage_door", registerDoor("crimson_cottage_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_four_panel_door", registerDoor("crimson_four_panel_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_glass_door", registerDoor("crimson_glass_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_japanese_door", registerDoor("crimson_japanese_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_modern_door", registerDoor("crimson_modern_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_mystic_door", registerDoor("crimson_mystic_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_paper_door", registerDoor("crimson_paper_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_stable_door", registerDoor("crimson_stable_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_swamp_door", registerDoor("crimson_swamp_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_tropical_door", registerDoor("crimson_tropical_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_waffle_door", registerDoor("crimson_waffle_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_western_door", registerDoor("crimson_western_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_whispering_door", registerDoor("crimson_whispering_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("japanese_crimson_door", registerDoor("japanese_crimson_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_barn_glass_door", registerDoor("crimson_barn_glass_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("crimson_stable_head_door", registerDoor("crimson_stable_head_door", BlockSetType.CRIMSON, Blocks.CRIMSON_DOOR));
        EXTRA_DOORS.put("japanese_warped_door", registerDoor("japanese_warped_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_bamboo_door", registerDoor("warped_bamboo_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_barn_door", registerDoor("warped_barn_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_beach_door", registerDoor("warped_beach_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_classic_door", registerDoor("warped_classic_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_cottage_door", registerDoor("warped_cottage_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_four_panel_door", registerDoor("warped_four_panel_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_glass_door", registerDoor("warped_glass_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_japanese_door", registerDoor("warped_japanese_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_modern_door", registerDoor("warped_modern_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_nether_door", registerDoor("warped_nether_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_paper_door", registerDoor("warped_paper_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_stable_door", registerDoor("warped_stable_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_swamp_door", registerDoor("warped_swamp_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_tropical_door", registerDoor("warped_tropical_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_waffle_door", registerDoor("warped_waffle_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_western_door", registerDoor("warped_western_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_whispering_door", registerDoor("warped_whispering_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_barn_glass_door", registerDoor("warped_barn_glass_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("warped_stable_head_door", registerDoor("warped_stable_head_door", BlockSetType.WARPED, Blocks.WARPED_DOOR));
        EXTRA_DOORS.put("japanese_pale_oak_door", registerDoor("japanese_pale_oak_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_bamboo_door", registerDoor("pale_oak_bamboo_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_barn_door", registerDoor("pale_oak_barn_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_beach_door", registerDoor("pale_oak_beach_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_classic_door", registerDoor("pale_oak_classic_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_cottage_door", registerDoor("pale_oak_cottage_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_four_panel_door", registerDoor("pale_oak_four_panel_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_glass_door", registerDoor("pale_oak_glass_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_japanese_door", registerDoor("pale_oak_japanese_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_modern_door", registerDoor("pale_oak_modern_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_mystic_door", registerDoor("pale_oak_mystic_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_nether_door", registerDoor("pale_oak_nether_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_paper_door", registerDoor("pale_oak_paper_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_stable_door", registerDoor("pale_oak_stable_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_swamp_door", registerDoor("pale_oak_swamp_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_tropical_door", registerDoor("pale_oak_tropical_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_waffle_door", registerDoor("pale_oak_waffle_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_western_door", registerDoor("pale_oak_western_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_barn_glass_door", registerDoor("pale_oak_barn_glass_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_stable_head_door", registerDoor("pale_oak_stable_head_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));

        // Wood trapdoors (all new)
        WOOD_TRAPDOORS.put("oak_bamboo_trapdoor", registerTrapdoor("oak_bamboo_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_barn_trapdoor", registerTrapdoor("oak_barn_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_barred_trapdoor", registerTrapdoor("oak_barred_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_beach_trapdoor", registerTrapdoor("oak_beach_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_blossom_trapdoor", registerTrapdoor("oak_blossom_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_cottage_trapdoor", registerTrapdoor("oak_cottage_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_four_panel_trapdoor", registerTrapdoor("oak_four_panel_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_glass_trapdoor", registerTrapdoor("oak_glass_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_mystic_trapdoor", registerTrapdoor("oak_mystic_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_paper_trapdoor", registerTrapdoor("oak_paper_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_swamp_trapdoor", registerTrapdoor("oak_swamp_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_tropical_trapdoor", registerTrapdoor("oak_tropical_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("oak_whispering_trapdoor", registerTrapdoor("oak_whispering_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_bamboo_trapdoor", registerTrapdoor("spruce_bamboo_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_barn_trapdoor", registerTrapdoor("spruce_barn_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_barred_trapdoor", registerTrapdoor("spruce_barred_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_barrel_trapdoor", registerTrapdoor("spruce_barrel_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_beach_trapdoor", registerTrapdoor("spruce_beach_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_blossom_trapdoor", registerTrapdoor("spruce_blossom_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_classic_trapdoor", registerTrapdoor("spruce_classic_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_four_panel_trapdoor", registerTrapdoor("spruce_four_panel_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_glass_trapdoor", registerTrapdoor("spruce_glass_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_mystic_trapdoor", registerTrapdoor("spruce_mystic_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_paper_trapdoor", registerTrapdoor("spruce_paper_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_swamp_trapdoor", registerTrapdoor("spruce_swamp_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_tropical_trapdoor", registerTrapdoor("spruce_tropical_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("spruce_whispering_trapdoor", registerTrapdoor("spruce_whispering_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_bamboo_trapdoor", registerTrapdoor("birch_bamboo_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_barn_trapdoor", registerTrapdoor("birch_barn_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_barred_trapdoor", registerTrapdoor("birch_barred_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_barrel_trapdoor", registerTrapdoor("birch_barrel_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_beach_trapdoor", registerTrapdoor("birch_beach_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_blossom_trapdoor", registerTrapdoor("birch_blossom_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_classic_trapdoor", registerTrapdoor("birch_classic_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_cottage_trapdoor", registerTrapdoor("birch_cottage_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_four_panel_trapdoor", registerTrapdoor("birch_four_panel_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_glass_trapdoor", registerTrapdoor("birch_glass_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_mystic_trapdoor", registerTrapdoor("birch_mystic_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_swamp_trapdoor", registerTrapdoor("birch_swamp_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_tropical_trapdoor", registerTrapdoor("birch_tropical_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("birch_whispering_trapdoor", registerTrapdoor("birch_whispering_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_bamboo_trapdoor", registerTrapdoor("jungle_bamboo_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_barn_trapdoor", registerTrapdoor("jungle_barn_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_barred_trapdoor", registerTrapdoor("jungle_barred_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_blossom_trapdoor", registerTrapdoor("jungle_blossom_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_classic_trapdoor", registerTrapdoor("jungle_classic_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_cottage_trapdoor", registerTrapdoor("jungle_cottage_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_four_panel_trapdoor", registerTrapdoor("jungle_four_panel_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_glass_trapdoor", registerTrapdoor("jungle_glass_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_mystic_trapdoor", registerTrapdoor("jungle_mystic_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_paper_trapdoor", registerTrapdoor("jungle_paper_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_swamp_trapdoor", registerTrapdoor("jungle_swamp_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_tropical_trapdoor", registerTrapdoor("jungle_tropical_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("jungle_whispering_trapdoor", registerTrapdoor("jungle_whispering_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_bamboo_trapdoor", registerTrapdoor("acacia_bamboo_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_barn_trapdoor", registerTrapdoor("acacia_barn_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_barred_trapdoor", registerTrapdoor("acacia_barred_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_barrel_trapdoor", registerTrapdoor("acacia_barrel_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_beach_trapdoor", registerTrapdoor("acacia_beach_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_blossom_trapdoor", registerTrapdoor("acacia_blossom_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_classic_trapdoor", registerTrapdoor("acacia_classic_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_cottage_trapdoor", registerTrapdoor("acacia_cottage_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_four_panel_trapdoor", registerTrapdoor("acacia_four_panel_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_glass_trapdoor", registerTrapdoor("acacia_glass_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_mystic_trapdoor", registerTrapdoor("acacia_mystic_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_paper_trapdoor", registerTrapdoor("acacia_paper_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_swamp_trapdoor", registerTrapdoor("acacia_swamp_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("acacia_whispering_trapdoor", registerTrapdoor("acacia_whispering_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_bamboo_trapdoor", registerTrapdoor("dark_oak_bamboo_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_barn_trapdoor", registerTrapdoor("dark_oak_barn_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_barred_trapdoor", registerTrapdoor("dark_oak_barred_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_beach_trapdoor", registerTrapdoor("dark_oak_beach_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_blossom_trapdoor", registerTrapdoor("dark_oak_blossom_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_classic_trapdoor", registerTrapdoor("dark_oak_classic_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_cottage_trapdoor", registerTrapdoor("dark_oak_cottage_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_glass_trapdoor", registerTrapdoor("dark_oak_glass_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_mystic_trapdoor", registerTrapdoor("dark_oak_mystic_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_paper_trapdoor", registerTrapdoor("dark_oak_paper_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_swamp_trapdoor", registerTrapdoor("dark_oak_swamp_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_tropical_trapdoor", registerTrapdoor("dark_oak_tropical_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("dark_oak_whispering_trapdoor", registerTrapdoor("dark_oak_whispering_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_bamboo_trapdoor", registerTrapdoor("mangrove_bamboo_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_barn_trapdoor", registerTrapdoor("mangrove_barn_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_barred_trapdoor", registerTrapdoor("mangrove_barred_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_beach_trapdoor", registerTrapdoor("mangrove_beach_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_blossom_trapdoor", registerTrapdoor("mangrove_blossom_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_classic_trapdoor", registerTrapdoor("mangrove_classic_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_cottage_trapdoor", registerTrapdoor("mangrove_cottage_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_four_panel_trapdoor", registerTrapdoor("mangrove_four_panel_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_glass_trapdoor", registerTrapdoor("mangrove_glass_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_mystic_trapdoor", registerTrapdoor("mangrove_mystic_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_paper_trapdoor", registerTrapdoor("mangrove_paper_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_tropical_trapdoor", registerTrapdoor("mangrove_tropical_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_whispering_trapdoor", registerTrapdoor("mangrove_whispering_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_bamboo_trapdoor", registerTrapdoor("cherry_bamboo_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_barn_trapdoor", registerTrapdoor("cherry_barn_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_barred_trapdoor", registerTrapdoor("cherry_barred_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_barrel_trapdoor", registerTrapdoor("cherry_barrel_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_beach_trapdoor", registerTrapdoor("cherry_beach_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_classic_trapdoor", registerTrapdoor("cherry_classic_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_cottage_trapdoor", registerTrapdoor("cherry_cottage_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_four_panel_trapdoor", registerTrapdoor("cherry_four_panel_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_glass_trapdoor", registerTrapdoor("cherry_glass_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_mystic_trapdoor", registerTrapdoor("cherry_mystic_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_paper_trapdoor", registerTrapdoor("cherry_paper_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_swamp_trapdoor", registerTrapdoor("cherry_swamp_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_tropical_trapdoor", registerTrapdoor("cherry_tropical_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cherry_whispering_trapdoor", registerTrapdoor("cherry_whispering_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_barn_trapdoor", registerTrapdoor("bamboo_barn_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_barred_trapdoor", registerTrapdoor("bamboo_barred_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_barrel_trapdoor", registerTrapdoor("bamboo_barrel_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_beach_trapdoor", registerTrapdoor("bamboo_beach_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_blossom_trapdoor", registerTrapdoor("bamboo_blossom_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_classic_trapdoor", registerTrapdoor("bamboo_classic_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_cottage_trapdoor", registerTrapdoor("bamboo_cottage_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_four_panel_trapdoor", registerTrapdoor("bamboo_four_panel_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_glass_trapdoor", registerTrapdoor("bamboo_glass_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_mystic_trapdoor", registerTrapdoor("bamboo_mystic_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_paper_trapdoor", registerTrapdoor("bamboo_paper_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_swamp_trapdoor", registerTrapdoor("bamboo_swamp_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_tropical_trapdoor", registerTrapdoor("bamboo_tropical_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("bamboo_whispering_trapdoor", registerTrapdoor("bamboo_whispering_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_bamboo_trapdoor", registerTrapdoor("crimson_bamboo_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_barn_trapdoor", registerTrapdoor("crimson_barn_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_beach_trapdoor", registerTrapdoor("crimson_beach_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_blossom_trapdoor", registerTrapdoor("crimson_blossom_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_classic_trapdoor", registerTrapdoor("crimson_classic_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_cottage_trapdoor", registerTrapdoor("crimson_cottage_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_four_panel_trapdoor", registerTrapdoor("crimson_four_panel_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_glass_trapdoor", registerTrapdoor("crimson_glass_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_mystic_trapdoor", registerTrapdoor("crimson_mystic_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_paper_trapdoor", registerTrapdoor("crimson_paper_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_swamp_trapdoor", registerTrapdoor("crimson_swamp_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_tropical_trapdoor", registerTrapdoor("crimson_tropical_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("crimson_whispering_trapdoor", registerTrapdoor("crimson_whispering_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_bamboo_trapdoor", registerTrapdoor("warped_bamboo_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_barn_trapdoor", registerTrapdoor("warped_barn_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_barred_trapdoor", registerTrapdoor("warped_barred_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_barrel_trapdoor", registerTrapdoor("warped_barrel_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_beach_trapdoor", registerTrapdoor("warped_beach_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_blossom_trapdoor", registerTrapdoor("warped_blossom_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_classic_trapdoor", registerTrapdoor("warped_classic_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_cottage_trapdoor", registerTrapdoor("warped_cottage_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_four_panel_trapdoor", registerTrapdoor("warped_four_panel_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_glass_trapdoor", registerTrapdoor("warped_glass_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_paper_trapdoor", registerTrapdoor("warped_paper_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_swamp_trapdoor", registerTrapdoor("warped_swamp_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_tropical_trapdoor", registerTrapdoor("warped_tropical_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_whispering_trapdoor", registerTrapdoor("warped_whispering_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_bamboo_trapdoor", registerTrapdoor("pale_oak_bamboo_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_barn_trapdoor", registerTrapdoor("pale_oak_barn_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_barred_trapdoor", registerTrapdoor("pale_oak_barred_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_beach_trapdoor", registerTrapdoor("pale_oak_beach_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_blossom_trapdoor", registerTrapdoor("pale_oak_blossom_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_classic_trapdoor", registerTrapdoor("pale_oak_classic_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_cottage_trapdoor", registerTrapdoor("pale_oak_cottage_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_four_panel_trapdoor", registerTrapdoor("pale_oak_four_panel_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_glass_trapdoor", registerTrapdoor("pale_oak_glass_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_mystic_trapdoor", registerTrapdoor("pale_oak_mystic_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_paper_trapdoor", registerTrapdoor("pale_oak_paper_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_swamp_trapdoor", registerTrapdoor("pale_oak_swamp_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_tropical_trapdoor", registerTrapdoor("pale_oak_tropical_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));

        String[] copperStates = {"", "exposed_", "weathered_", "oxidized_"};
        WeatheringCopper.WeatherState[] states = {WeatheringCopper.WeatherState.UNAFFECTED, WeatheringCopper.WeatherState.EXPOSED, WeatheringCopper.WeatherState.WEATHERED, WeatheringCopper.WeatherState.OXIDIZED};

        for (int i = 0; i < copperStates.length; i++) {
            String stateName = copperStates[i];
            WeatheringCopper.WeatherState state = states[i];

            COPPER_BUTTONS.put(stateName, registerBackportedBlock(stateName + "copper_button", () -> new com.otterly76.ott.block.custom.CopperButtonBlock(state, net.minecraft.world.level.block.state.properties.BlockSetType.IRON, 30, BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.COPPER))));
            COPPER_BUTTONS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_button", () -> new com.otterly76.ott.block.custom.CopperButtonBlock(state, net.minecraft.world.level.block.state.properties.BlockSetType.IRON, 30, BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.COPPER))));

            COPPER_PRESSURE_PLATES.put(stateName, registerBackportedBlock(stateName + "copper_pressure_plate", () -> new com.otterly76.ott.block.custom.CopperPressurePlateBlock(state, net.minecraft.world.level.block.state.properties.BlockSetType.COPPER, BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.COPPER))));
            COPPER_PRESSURE_PLATES.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_pressure_plate", () -> new com.otterly76.ott.block.custom.CopperPressurePlateBlock(state, net.minecraft.world.level.block.state.properties.BlockSetType.COPPER, BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.COPPER))));

            // In 1.21.1, all 8 variants of copper doors and trapdoors are vanilla.
            // We use vanilla instances from the Blocks class to avoid duplicate registration issues and NPEs during baking.
            switch (stateName) {
                case "" -> {
                    COPPER_DOORS.put("", () -> Blocks.COPPER_DOOR);
                    COPPER_DOORS.put("waxed_", () -> Blocks.WAXED_COPPER_DOOR);
                    COPPER_TRAPDOORS.put("", () -> Blocks.COPPER_TRAPDOOR);
                    COPPER_TRAPDOORS.put("waxed_", () -> Blocks.WAXED_COPPER_TRAPDOOR);
                }
                case "exposed_" -> {
                    COPPER_DOORS.put("exposed_", () -> Blocks.EXPOSED_COPPER_DOOR);
                    COPPER_DOORS.put("waxed_exposed_", () -> Blocks.WAXED_EXPOSED_COPPER_DOOR);
                    COPPER_TRAPDOORS.put("exposed_", () -> Blocks.EXPOSED_COPPER_TRAPDOOR);
                    COPPER_TRAPDOORS.put("waxed_exposed_", () -> Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
                }
                case "weathered_" -> {
                    COPPER_DOORS.put("weathered_", () -> Blocks.WEATHERED_COPPER_DOOR);
                    COPPER_DOORS.put("waxed_weathered_", () -> Blocks.WAXED_WEATHERED_COPPER_DOOR);
                    COPPER_TRAPDOORS.put("weathered_", () -> Blocks.WEATHERED_COPPER_TRAPDOOR);
                    COPPER_TRAPDOORS.put("waxed_weathered_", () -> Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
                }
                case "oxidized_" -> {
                    COPPER_DOORS.put("oxidized_", () -> Blocks.OXIDIZED_COPPER_DOOR);
                    COPPER_DOORS.put("waxed_oxidized_", () -> Blocks.WAXED_OXIDIZED_COPPER_DOOR);
                    COPPER_TRAPDOORS.put("oxidized_", () -> Blocks.OXIDIZED_COPPER_TRAPDOOR);
                    COPPER_TRAPDOORS.put("waxed_oxidized_", () -> Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
                }
            }

            var statue = registerBackportedBlock(stateName + "copper_golem_statue", () -> new com.otterly76.ott.block.custom.CopperGolemStatueBlock(state, BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.COPPER)), false);
            COPPER_GOLEM_STATUES.put(stateName, statue);
            register3DBlockItem(statue);

            var waxedStatue = registerBackportedBlock("waxed_" + stateName + "copper_golem_statue", () -> new com.otterly76.ott.block.custom.CopperGolemStatueBlock(state, BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.COPPER)), false);
            COPPER_GOLEM_STATUES.put("waxed_" + stateName, waxedStatue);
            register3DBlockItem(waxedStatue);

            COPPER_LANTERNS.put(stateName, registerBackportedBlock(stateName + "copper_lantern", () -> new com.otterly76.ott.block.custom.WeatheringCopperLanternBlock(state, BlockBehaviour.Properties.of().strength(3.5f).sound(SoundType.LANTERN).lightLevel(s -> 15).noOcclusion())));
            COPPER_LANTERNS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_lantern", () -> new com.otterly76.ott.block.custom.WeatheringCopperLanternBlock(state, BlockBehaviour.Properties.of().strength(3.5f).sound(SoundType.LANTERN).lightLevel(s -> 15).noOcclusion())));

            COPPER_SOUL_LANTERNS.put(stateName, registerBackportedBlock(stateName + "copper_soul_lantern", () -> new com.otterly76.ott.block.custom.WeatheringCopperLanternBlock(state, BlockBehaviour.Properties.of().strength(3.5f).sound(SoundType.LANTERN).lightLevel(s -> 10).noOcclusion())));
            COPPER_SOUL_LANTERNS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_soul_lantern", () -> new com.otterly76.ott.block.custom.WeatheringCopperLanternBlock(state, BlockBehaviour.Properties.of().strength(3.5f).sound(SoundType.LANTERN).lightLevel(s -> 10).noOcclusion())));

            COPPER_CHAINS.put(stateName, registerBackportedBlock(stateName + "copper_chain", () -> new com.otterly76.ott.block.custom.WeatheringCopperChainBlock(state, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.CHAIN).noOcclusion())));
            COPPER_CHAINS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_chain", () -> new com.otterly76.ott.block.custom.WeatheringCopperChainBlock(state, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.CHAIN).noOcclusion())));

            COPPER_BARS.put(stateName, registerBackportedBlock(stateName + "copper_bars", () -> new com.otterly76.ott.block.custom.WeatheringCopperBarsBlock(state, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.COPPER).noOcclusion())));
            COPPER_BARS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_bars", () -> new com.otterly76.ott.block.custom.WeatheringCopperBarsBlock(state, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.COPPER).noOcclusion())));

            COPPER_HOPPERS.put(stateName, registerBackportedBlock(stateName + "copper_hopper", () -> new com.otterly76.ott.block.custom.CopperHopperBlock(state, BlockBehaviour.Properties.of().strength(3.0f, 4.8f).sound(SoundType.COPPER).noOcclusion())));
            COPPER_HOPPERS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_hopper", () -> new com.otterly76.ott.block.custom.CopperHopperBlock(state, BlockBehaviour.Properties.of().strength(3.0f, 4.8f).sound(SoundType.COPPER).noOcclusion())));

            COPPER_LADDERS.put(stateName, registerBackportedBlock(stateName + "copper_ladder", () -> new com.otterly76.ott.block.custom.WeatheringCopperLadderBlock(state, BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.COPPER).noOcclusion().requiresCorrectToolForDrops())));
            COPPER_LADDERS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_ladder", () -> new com.otterly76.ott.block.custom.WeatheringCopperLadderBlock(state, BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.COPPER).noOcclusion().requiresCorrectToolForDrops())));

            COPPER_CAULDRONS.put(stateName, registerBackportedBlock(stateName + "copper_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperCauldronBlock(state, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_EMPTY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(2.0F).sound(SoundType.COPPER).noOcclusion().pushReaction(PushReaction.BLOCK))));
            COPPER_CAULDRONS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperCauldronBlock(state, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_EMPTY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(2.0F).sound(SoundType.COPPER).noOcclusion().pushReaction(PushReaction.BLOCK))));

            // Filled Cauldrons
            // Note: Interaction maps are set to COPPER_EMPTY/WATER/etc.
            COPPER_WATER_CAULDRONS.put(stateName, registerBackportedBlock(stateName + "copper_water_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperLayeredCauldronBlock(state, Biome.Precipitation.RAIN, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_WATER, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER_CAULDRON).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).pushReaction(PushReaction.BLOCK)), false));
            COPPER_WATER_CAULDRONS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_water_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperLayeredCauldronBlock(state, Biome.Precipitation.RAIN, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_WATER, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER_CAULDRON).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).pushReaction(PushReaction.BLOCK)), false));

            COPPER_LAVA_CAULDRONS.put(stateName, registerBackportedBlock(stateName + "copper_lava_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperLavaCauldronBlock(state, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_LAVA, BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA_CAULDRON).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).pushReaction(PushReaction.BLOCK)), false));
            COPPER_LAVA_CAULDRONS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_lava_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperLavaCauldronBlock(state, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_LAVA, BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA_CAULDRON).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).pushReaction(PushReaction.BLOCK)), false));

            COPPER_POWDER_SNOW_CAULDRONS.put(stateName, registerBackportedBlock(stateName + "copper_powder_snow_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperLayeredCauldronBlock(state, Biome.Precipitation.SNOW, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_POWDER_SNOW, BlockBehaviour.Properties.ofFullCopy(Blocks.POWDER_SNOW_CAULDRON).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).pushReaction(PushReaction.BLOCK)), false));
            COPPER_POWDER_SNOW_CAULDRONS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_powder_snow_cauldron", () -> new com.otterly76.ott.block.custom.WeatheringCopperLayeredCauldronBlock(state, Biome.Precipitation.SNOW, com.otterly76.ott.handler.CauldronInteractionHandler.COPPER_POWDER_SNOW, BlockBehaviour.Properties.ofFullCopy(Blocks.POWDER_SNOW_CAULDRON).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).pushReaction(PushReaction.BLOCK)), false));

            COPPER_RAILS.put(stateName, registerBackportedBlock(stateName + "copper_rail", () -> new com.otterly76.ott.block.custom.WeatheringCopperRailBlock(state, BlockBehaviour.Properties.of().noCollission().strength(0.7F).sound(SoundType.COPPER))));
            COPPER_RAILS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "copper_rail", () -> new com.otterly76.ott.block.custom.WeatheringCopperRailBlock(state, BlockBehaviour.Properties.of().noCollission().strength(0.7F).sound(SoundType.COPPER))));

            if (stateName.isEmpty()) {
                LIGHTNING_RODS.put("", () -> Blocks.LIGHTNING_ROD);
            } else {
                LIGHTNING_RODS.put(stateName, registerBackportedBlock(stateName + "lightning_rod", () -> new com.otterly76.ott.block.custom.WeatheringCopperLightningRodBlock(state, BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.COPPER))));
            }
            LIGHTNING_RODS.put("waxed_" + stateName, registerBackportedBlock("waxed_" + stateName + "lightning_rod", () -> new com.otterly76.ott.block.custom.WeatheringCopperLightningRodBlock(state, BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.COPPER))));
        }

        for (String damagePrefix : new String[]{"", "chipped_", "damaged_"}) {
            for (int i = 0; i < copperStates.length; i++) {
                String stateName = copperStates[i];
                WeatheringCopper.WeatherState state = states[i];
                COPPER_ANVILS.put(damagePrefix + stateName, registerBackportedBlock(damagePrefix + stateName + "copper_anvil", () -> new com.otterly76.ott.block.custom.WeatheringCopperAnvilBlock(state, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.ANVIL).requiresCorrectToolForDrops())));
                COPPER_ANVILS.put("waxed_" + damagePrefix + stateName, registerBackportedBlock("waxed_" + damagePrefix + stateName + "copper_anvil", () -> new com.otterly76.ott.block.custom.WeatheringCopperAnvilBlock(state, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.ANVIL).requiresCorrectToolForDrops())));
            }
        }

        registerGradientBlocks(Blocks.WHITE_CONCRETE, GradientConcreteBlock::new, ALL_CONCRETE_BLOCKS::add);
        registerGradientBlocks(Blocks.WHITE_TERRACOTTA, GradientTerracottaBlock::new, ALL_TERRACOTTA_BLOCKS::add);
        registerGradientBlocks(Blocks.WHITE_WOOL, GradientWoolBlock::new, ALL_WOOL_BLOCKS::add);
        registerGradientBlocks(Blocks.WHITE_STAINED_GLASS, GradientStainedGlassBlock::new, ALL_STAINED_GLASS_BLOCKS::add);
        registerGradientBlocks(Blocks.WHITE_CONCRETE_POWDER, GradientConcretePowderBlock::new, ALL_CONCRETE_POWDER_BLOCKS::add);

        // Register all ott wood sets
        ModWoodSets.ALL.forEach(set -> WOOD_SETS.put(set.name(), com.otterly76.ott.block.wood.WoodSetBlockRegistrar.registerOttWoodSet(set.name())));

        // Register vanilla wood structural blocks
        // Oak already has dedicated static block fields; wrap them rather than re-registering.
        VANILLA_STRUCTURAL_SETS.put("oak", new WoodStructuralBlocks(
                OAK_PERGOLA, OAK_BEAM, OAK_PLANKS_PLATE, OAK_PLANKS_EDGE,
                OAK_BANNISTER, OAK_SUPPORT_SLAB, OAK_SUPPORT_BEAM, OAK_GEOMETRIC_WINDOW));
        for (String name : List.of("spruce", "birch", "jungle", "acacia", "dark_oak",
                "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak")) {
            VANILLA_STRUCTURAL_SETS.put(name, com.otterly76.ott.block.wood.WoodSetBlockRegistrar.registerVanillaStructural(name));
        }

        // Register all ott color sets
        com.otterly76.ott.color.ModColorSets.ALL.forEach(set -> COLOR_SETS.put(set.name(), com.otterly76.ott.block.color.ColorSetBlockRegistrar.registerOttColorSet(set.name())));

        // Register all stone shape sets
        com.otterly76.ott.block.stone.ModStoneVariants.ALL.forEach(v ->
                STONE_SETS.put(v.name(), com.otterly76.ott.block.stone.StoneSetBlockRegistrar.registerStoneSet(v)));

        // Register seaglass for all colors (vanilla dyes + custom color sets)
        for (com.otterly76.ott.color.ModPatterns.ColorInfo color : com.otterly76.ott.color.ModPatterns.ALL_COLORS) {
            final String c = color.name();
            SEAGLASS_SETS.put(c, new SeaglassColorBlocks(
                    register(c + "_seaglass", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion())),
                    register(c + "_bubbles_seaglass", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion())),
                    register(c + "_smooth_seaglass", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion())),
                    register(c + "_waves_seaglass", () -> new Block(Properties.of().strength(4.0f).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()))
            ));
        }

        // Register opal sets
        for (String opalName : List.of("white_opal", "black_opal", "fire_opal")) {
            OPAL_SETS.put(opalName, registerOpalSet(opalName));
        }

        registerPatternBlocks();

        // Register all particle hedges
        ModHedgeVariants.ALL.forEach(variant -> {
            PARTICLE_HEDGES.put(variant.name(), BLOCKS.register(
                    variant.name() + "_hedge",
                    () -> new ParticleHedgeBlock(
                            Properties.of().strength(1.0f).sound(SoundType.GRASS).noOcclusion(),
                            variant.leafParticle()
                    )
            ));

            CREEPING_HEDGES.put(variant.name(), BLOCKS.register(
                    variant.name() + "_creeping_hedge",
                    () -> new ParticleCreepingHedgeBlock(
                            Properties.of().strength(1.0f).sound(SoundType.GRASS).noOcclusion(),
                            variant.leafParticle(),
                            variant.creepOverlayTexture()
                    )
            ));
        });

        registerElevators();
        registerFutons();
    }

    private static void registerFutons() {
        for (com.otterly76.ott.color.ModPatterns.ColorInfo color : com.otterly76.ott.color.ModPatterns.ALL_COLORS) {
            final String colorName = color.name();
            final net.minecraft.world.item.DyeColor dyeColor = toDyeColor(colorName);
            FUTONS.put(colorName, BLOCKS.register(
                    colorName + "_futon",
                    () -> new FutonBlock(dyeColor, Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion())
            ));
        }
    }

    private static net.minecraft.world.item.DyeColor toDyeColor(String name) {
        for (net.minecraft.world.item.DyeColor c : net.minecraft.world.item.DyeColor.values()) {
            if (c.getName().equals(name)) return c;
        }
        return net.minecraft.world.item.DyeColor.WHITE;
    }

    private static void registerElevators() {
        for (ModPatterns.ColorInfo color : ModPatterns.ALL_COLORS) {
            final String colorName = color.name();
            ELEVATORS.put(colorName, BLOCKS.register(
                    colorName + "_elevator",
                    () -> new ElevatorBlock(colorName,
                            BlockBehaviour.Properties.of()
                                    .strength(0.8f)
                                    .sound(SoundType.WOOL))
            ));
        }
    }

    private static void registerPatternBlocks() {
        for (String pattern : com.otterly76.ott.color.ModPatterns.PATTERNS) {
            boolean isPillar = com.otterly76.ott.color.ModPatterns.PILLAR_PATTERNS.contains(pattern);
            Map<String, DeferredBlock<Block>> colorMap = new LinkedHashMap<>();
            for (com.otterly76.ott.color.ModPatterns.ColorInfo color : com.otterly76.ott.color.ModPatterns.ALL_COLORS) {
                String base = color.name() + "_" + pattern;
                colorMap.put(color.name(), isPillar
                        ? registerAsPillar(base)
                        : register(base, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE))));
            }
            PATTERN_BLOCKS.put(pattern, colorMap);
        }
    }

    /**
     * Registers a {@link RotatedPillarBlock} and stores it in the {@code DeferredBlock<Block>} map via an unchecked cast (safe: RotatedPillarBlock extends Block).
     */
    @SuppressWarnings("unchecked")
    private static DeferredBlock<Block> registerAsPillar(String name) {
        DeferredBlock<?> holder = BLOCKS.register(name,
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
        return (DeferredBlock<Block>) holder;
    }

    private static <T extends Block & IGradientBlock> void registerGradientBlocks(Block block, GradientBlockBuilder<T> builder, Consumer<DeferredBlock<? extends IGradientBlock>> adder) {
        // We loop through ALL colors for both slots
        for (final DyeColor color1 : DyeColor.values()) {
            for (final DyeColor color2 : DyeColor.values()) {
                // Only skip if the colors are identical
                if (color1 != color2) {
                    final String blockBaseName = BuiltInRegistries.BLOCK.getKey(block).getPath().replace("white_", "");

                    // This will naturally create both "red_blue_..." and "blue_red_..."
                    final String fullName = String.format("%s_%s_%s", color1.getName(), color2.getName(), blockBaseName);

                    DeferredBlock<? extends IGradientBlock> gradientBlock = BLOCKS.register(fullName, () ->
                            builder.create(BlockBehaviour.Properties.ofFullCopy(block), color1, color2, color -> "%s_%s".formatted(color.getName(), blockBaseName))
                    );

                    adder.accept(gradientBlock);
                    ALL_GRADIENT_BLOCKS.add(gradientBlock);
                }
            }
        }
    }

    public static Collection<DeferredBlock<? extends IGradientBlock>> getAllGradientBlocks() {
        return ALL_GRADIENT_BLOCKS;
    }

    public static Collection<DeferredBlock<? extends IGradientBlock>> getAllGradientConcreteBlocks() {
        return ALL_CONCRETE_BLOCKS;
    }

    public static Collection<DeferredBlock<? extends IGradientBlock>> getAllGradientTerracottaBlocks() {
        return ALL_TERRACOTTA_BLOCKS;
    }

    public static Collection<DeferredBlock<? extends IGradientBlock>> getAllGradientWoolBlocks() {
        return ALL_WOOL_BLOCKS;
    }

    public static Collection<DeferredBlock<? extends IGradientBlock>> getAllGradientStainedGlassBlocks() {
        return ALL_STAINED_GLASS_BLOCKS;
    }

    public static Collection<DeferredBlock<? extends IGradientBlock>> getAllGradientConcretePowderBlocks() {
        return ALL_CONCRETE_POWDER_BLOCKS;
    }

    /**
     * ott wood sets (ott namespace). Key = set name (e.g. "starlight").
     */
    public static final Map<String, WoodSetBlocks> WOOD_SETS = new LinkedHashMap<>();


    /**
     * ott color sets (ott namespace). Key = color name (e.g. "aquamarine").
     */
    public static final Map<String, ColorSetBlocks> COLOR_SETS = new LinkedHashMap<>();

    /**
     * Stone-type shape sets (ott namespace). Key = variant name (e.g. "stone", "granite").
     */
    public static final Map<String, StoneSetBlocks> STONE_SETS = new LinkedHashMap<>();

    /**
     * Seaglass color sets (ott namespace). Key = color name, covers all vanilla dyes + custom color sets.
     */
    public static final Map<String, SeaglassColorBlocks> SEAGLASS_SETS = new LinkedHashMap<>();

    /**
     * Opal crystal sets (ott namespace). Keys: "white_opal", "black_opal", "fire_opal".
     */
    public static final Map<String, OpalSet> OPAL_SETS = new LinkedHashMap<>();

    /**
     * ott pattern blocks (ott namespace). Key1 = pattern name, Key2 = color name.
     */
    public static final Map<String, Map<String, DeferredBlock<Block>>> PATTERN_BLOCKS = new LinkedHashMap<>();

    public record ColorSetBlocks(
            DeferredBlock<CandleBlock> candle,
            DeferredBlock<Block> concrete,
            DeferredBlock<ColoredFallingBlock> concretePowder,
            DeferredBlock<GlazedTerracottaBlock> glazedTerracotta,
            DeferredBlock<ShulkerBoxBlock> shulkerBox,
            DeferredBlock<StainedGlassBlock> stainedGlass,
            DeferredBlock<StainedGlassPaneBlock> stainedGlassPane,
            DeferredBlock<Block> terracotta,
            DeferredBlock<Block> wool,
            DeferredBlock<BedBlock> bed,
            DeferredBlock<CarpetBlock> carpet,
            DeferredBlock<BannerBlock> banner,
            DeferredBlock<WallBannerBlock> wallBanner,
            DeferredBlock<PlateBlock> plate,
            DeferredBlock<EdgeBlock> edge,
            DeferredBlock<BeamBlock> beam,
            DeferredBlock<PergolaBlock> pergola,
            DeferredBlock<Block> geometricWindow,
            DeferredBlock<com.otterly76.ott.block.custom.BannisterBlock> bannister,
            DeferredBlock<com.otterly76.ott.block.custom.SupportSlabBlock> supportSlab,
            DeferredBlock<com.otterly76.ott.block.custom.SupportBeamBlock> supportBeam
    ) {
    }

    public record StoneSetBlocks(
            DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> plate,
            DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> edge,
            DeferredBlock<com.otterly76.ott.block.custom.BeamBlock> beam,
            DeferredBlock<com.otterly76.ott.block.custom.PergolaBlock> pergola,
            DeferredBlock<com.otterly76.ott.block.custom.GeometricWindowBlock> geometricWindow,
            DeferredBlock<com.otterly76.ott.block.custom.BannisterBlock> bannister,
            DeferredBlock<com.otterly76.ott.block.custom.SupportSlabBlock> supportSlab,
            DeferredBlock<com.otterly76.ott.block.custom.SupportBeamBlock> supportBeam
    ) {
    }

    public record SeaglassColorBlocks(
            DeferredBlock<Block> seaglass,
            DeferredBlock<Block> bubblesSeaglass,
            DeferredBlock<Block> smoothSeaglass,
            DeferredBlock<Block> wavesSeaglass
    ) {
    }

    public record OpalSet(
            DeferredBlock<Block> base,
            DeferredBlock<Block> crystalBlock,
            DeferredBlock<Block> budding,
            DeferredBlock<AmethystClusterBlock> cluster,
            DeferredBlock<AmethystClusterBlock> largeBud,
            DeferredBlock<AmethystClusterBlock> mediumBud,
            DeferredBlock<AmethystClusterBlock> smallBud,
            DeferredBlock<Block> bricks,
            DeferredBlock<Block> smallBricks,
            DeferredBlock<Block> polished,
            DeferredBlock<Block> chiseled,
            DeferredBlock<RotatedPillarBlock> pillar,
            DeferredBlock<Block> cut,
            DeferredBlock<Block> tiles,
            DeferredBlock<Block> smallTiles,
            DeferredBlock<Block> glass,
            DeferredBlock<IronBarsBlock> glassPane,
            DeferredBlock<GlazedTerracottaBlock> tiling
    ) {
    }

    public record WoodSetBlocks(
            DeferredBlock<RotatedPillarBlock> log,
            DeferredBlock<RotatedPillarBlock> wood,
            DeferredBlock<RotatedPillarBlock> strippedLog,
            DeferredBlock<RotatedPillarBlock> strippedWood,
            DeferredBlock<Block> planks,
            DeferredBlock<StairBlock> stairs,
            DeferredBlock<SlabBlock> slab,
            DeferredBlock<FenceBlock> fence,
            DeferredBlock<FenceGateBlock> fenceGate,
            DeferredBlock<DoorBlock> door,
            DeferredBlock<TrapDoorBlock> trapdoor,
            DeferredBlock<ButtonBlock> button,
            DeferredBlock<PressurePlateBlock> pressurePlate,
            DeferredBlock<LeavesBlock> leaves,
            DeferredBlock<SaplingBlock> sapling,
            DeferredBlock<FlowerPotBlock> pottedSapling,
            DeferredBlock<StandingSignBlock> sign,
            DeferredBlock<WallSignBlock> wallSign,
            DeferredBlock<CeilingHangingSignBlock> hangingSign,
            DeferredBlock<WallHangingSignBlock> wallHangingSign,
            DeferredBlock<com.otterly76.ott.block.custom.PergolaBlock> pergola,
            DeferredBlock<com.otterly76.ott.block.custom.BeamBlock> beam,
            DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> planksPlate,
            DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> planksEdge,
            DeferredBlock<com.otterly76.ott.block.custom.BannisterBlock> bannister,
            DeferredBlock<com.otterly76.ott.block.custom.SupportSlabBlock> supportSlab,
            DeferredBlock<com.otterly76.ott.block.custom.SupportBeamBlock> supportBeam,
            DeferredBlock<Block> geometricWindow,
            DeferredBlock<BeehiveBlock> beehive,
            DeferredBlock<com.otterly76.ott.block.shelf.ShelfBlock> shelf
    ) {
    }

    /**
     * Vanilla wood structural blocks (ott namespace). Key = vanilla set name (e.g. "oak").
     */
    public static final Map<String, WoodStructuralBlocks> VANILLA_STRUCTURAL_SETS = new LinkedHashMap<>();

    public record WoodStructuralBlocks(
            DeferredBlock<com.otterly76.ott.block.custom.PergolaBlock> pergola,
            DeferredBlock<com.otterly76.ott.block.custom.BeamBlock> beam,
            DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> planksPlate,
            DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> planksEdge,
            DeferredBlock<com.otterly76.ott.block.custom.BannisterBlock> bannister,
            DeferredBlock<com.otterly76.ott.block.custom.SupportSlabBlock> supportSlab,
            DeferredBlock<com.otterly76.ott.block.custom.SupportBeamBlock> supportBeam,
            DeferredBlock<Block> geometricWindow
    ) {
    }

    public static final DeferredBlock<Block> GLASS_JAR = BLOCKS.register("glass_jar",
            () -> new com.otterly76.ott.block.custom.GlassJarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    public static final DeferredBlock<Block> FIREFLY_IN_A_JAR = BLOCKS.register("firefly_in_a_jar",
            () -> new com.otterly76.ott.block.custom.FireflyJarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.3F).sound(SoundType.GLASS).noOcclusion().lightLevel((state) -> 7)));

    public static final DeferredBlock<Block> FIREFLIES_IN_A_JAR = BLOCKS.register("fireflies_in_a_jar",
            () -> new com.otterly76.ott.block.custom.FireflyJarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.3F).sound(SoundType.GLASS).noOcclusion().lightLevel((state) -> 11)));

    public static final DeferredBlock<Block> FIREFLY_JAR = BLOCKS.register("firefly_jar",
            () -> new com.otterly76.ott.block.custom.FireflyJarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.3F).sound(SoundType.GLASS).noOcclusion().lightLevel((state) -> 15)));

    public static final Map<Butterfly.Variant, DeferredBlock<Block>> BUTTERFLY_JARS = new HashMap<>();
    public static final DeferredBlock<Block> CATERPILLAR_JAR = BLOCKS.register("caterpillar_jar",
            () -> new com.otterly76.ott.block.custom.CaterpillarJarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    // --- Ecologics ---
    public static final DeferredBlock<CoconutBlock> COCONUT = BLOCKS.register("coconut",
            () -> new CoconutBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));

    // --- Friends and Foes ---
    public static final DeferredBlock<CrabEggBlock> CRAB_EGG = BLOCKS.register("crab_egg",
            () -> new CrabEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.5F).sound(SoundType.METAL).noOcclusion().randomTicks()));

    // -------------------------------------------------------------------------
    // --- Mosaic / Fresco decorative blocks ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<Block> WATER_MOSAIC_BORDER = register("water_mosaic_border",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_GEOMETRIC = register("water_mosaic_geometric",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_PATTERN = register("water_mosaic_pattern",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_DELICATE = register("water_mosaic_delicate",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_TRADITIONAL = register("water_mosaic_traditional",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterMosaicRecessBlock> WATER_MOSAIC_RECESS = register("water_mosaic_recess",
            () -> new com.otterly76.ott.block.custom.WaterMosaicRecessBlock(
                    net.minecraft.world.level.block.Blocks.STONE_BRICKS.defaultBlockState(),
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterMosaicRecessBlock> SPIRIT_MOSAIC_RECESS = register("spirit_mosaic_recess",
            () -> new com.otterly76.ott.block.custom.WaterMosaicRecessBlock(
                    net.minecraft.world.level.block.Blocks.STONE_BRICKS.defaultBlockState(),
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterMosaicRecessBlock> AIR_MOSAIC_RECESS = register("air_mosaic_recess",
            () -> new com.otterly76.ott.block.custom.WaterMosaicRecessBlock(
                    net.minecraft.world.level.block.Blocks.STONE_BRICKS.defaultBlockState(),
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterMosaicRecessBlock> EARTH_MOSAIC_RECESS = register("earth_mosaic_recess",
            () -> new com.otterly76.ott.block.custom.WaterMosaicRecessBlock(
                    net.minecraft.world.level.block.Blocks.STONE_BRICKS.defaultBlockState(),
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterMosaicRecessBlock> FIRE_MOSAIC_RECESS = register("fire_mosaic_recess",
            () -> new com.otterly76.ott.block.custom.WaterMosaicRecessBlock(
                    net.minecraft.world.level.block.Blocks.STONE_BRICKS.defaultBlockState(),
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> EARTH_MOSAIC_BORDER = register("earth_mosaic_border",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_GEOMETRIC = register("earth_mosaic_geometric",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_PATTERN = register("earth_mosaic_pattern",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_DELICATE = register("earth_mosaic_delicate",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_TRADITIONAL = register("earth_mosaic_traditional",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_BORDER = register("fire_mosaic_border",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_GEOMETRIC = register("fire_mosaic_geometric",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_PATTERN = register("fire_mosaic_pattern",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_DELICATE = register("fire_mosaic_delicate",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_TRADITIONAL = register("fire_mosaic_traditional",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_BORDER = register("spirit_mosaic_border",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_GEOMETRIC = register("spirit_mosaic_geometric",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_PATTERN = register("spirit_mosaic_pattern",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_DELICATE = register("spirit_mosaic_delicate",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_TRADITIONAL = register("spirit_mosaic_traditional",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_BORDER = register("air_mosaic_border",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_GEOMETRIC = register("air_mosaic_geometric",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_PATTERN = register("air_mosaic_pattern",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_DELICATE = register("air_mosaic_delicate",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_TRADITIONAL = register("air_mosaic_traditional",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MOSAIC_FLOOR = register("mosaic_floor",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MOSAIC_FLOOR_DELICATE = register("mosaic_floor_delicate",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MOSAIC_FLOOR_ROSETTE = register("mosaic_floor_rosette",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROMAN_FRESCO_RED = register("roman_fresco_red",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROMAN_FRESCO_BLACK = register("roman_fresco_black",
            () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    // -------------------------------------------------------------------------
    // --- Stone brick functional blocks ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<com.otterly76.ott.block.custom.ArrowslitBlock> STONE_BRICKS_ARROWSLIT = register("stone_bricks_arrowslit",
            () -> new com.otterly76.ott.block.custom.ArrowslitBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.MachincolationBlock> STONE_BRICKS_MACHICOLATION = register("stone_bricks_machicolation",
            () -> new com.otterly76.ott.block.custom.MachincolationBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterTrickleSourceBlock> WATER_SOURCE_TRICKLE = register("water_source_trickle",
            () -> new com.otterly76.ott.block.custom.WaterTrickleSourceBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.FaucetBlock> STONE_BRICKS_FAUCET = register("stone_bricks_faucet",
            () -> new com.otterly76.ott.block.custom.FaucetBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.PoolBlock> STONE_BRICKS_POOL = register("stone_bricks_pool",
            () -> new com.otterly76.ott.block.custom.PoolBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.SmallPoolBlock> STONE_BRICKS_SMALL_POOL = register("stone_bricks_small_pool",
            () -> new com.otterly76.ott.block.custom.SmallPoolBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.WaterJetBlock> STONE_BRICKS_WATER_JET = register("stone_bricks_water_jet",
            () -> new com.otterly76.ott.block.custom.WaterJetBlock(
                    Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));

    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Limestone ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<Block> LIMESTONE_MASONRY = register("limestone_masonry",
            () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<EdgeBlock> LIMESTONE_MASONRY_EDGE = register("limestone_masonry_edge",
            () -> new EdgeBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<PlateBlock> LIMESTONE_MASONRY_PLATE = register("limestone_masonry_plate",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> COBBLED_LIMESTONE = register("cobbled_limestone",
            () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PLAIN_LIMESTONE = register("limestone",
            () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MIXED_LIMESTONE_BRICKS = register("mixed_limestone_bricks",
            () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Marble (Roman) ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<Block> BLACK_MARBLE = register("black_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_BRICKS = register("black_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_MARBLE_SMALL_BRICKS = register("black_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_MARBLE_TILES = register("black_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_POLISHED_MARBLE = register("black_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR = register("black_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR_CAP = register("black_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE = register("white_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_BRICKS = register("white_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_MARBLE_SMALL_BRICKS = register("white_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_MARBLE_TILES = register("white_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_POLISHED_MARBLE = register("white_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR = register("white_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR_CAP = register("white_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> BLACK_MARBLE_FLOOR_TILE = register("black_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> WHITE_MARBLE_FLOOR_TILE = register("white_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> WHITE_MARBLE_FANCY_FENCE = register("white_marble_fancy_fence",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    public static final DeferredBlock<PlateBlock> BLACK_MARBLE_FANCY_FENCE = register("black_marble_fancy_fence",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    public static final DeferredBlock<Block> WHITE_MARBLE_DIAMOND_PAVERS = register("white_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_DIAMOND_PAVERS = register("black_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ── Amethyst Marble ──
    public static final DeferredBlock<Block> AMETHYST_MARBLE = register("amethyst_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_BRICKS = register("amethyst_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_SMALL_BRICKS = register("amethyst_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> AMETHYST_MARBLE_TILES = register("amethyst_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> AMETHYST_POLISHED_MARBLE = register("amethyst_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> AMETHYST_MARBLE_PILLAR = register("amethyst_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> AMETHYST_MARBLE_PILLAR_CAP = register("amethyst_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> AMETHYST_MARBLE_FLOOR_TILE = register("amethyst_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> AMETHYST_MARBLE_FANCY_FENCE = register("amethyst_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Blue Marble ──
    public static final DeferredBlock<Block> BLUE_MARBLE = register("blue_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_BRICKS = register("blue_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_MARBLE_SMALL_BRICKS = register("blue_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_MARBLE_TILES = register("blue_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_POLISHED_MARBLE = register("blue_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR = register("blue_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR_CAP = register("blue_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> BLUE_MARBLE_FLOOR_TILE = register("blue_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> BLUE_MARBLE_FANCY_FENCE = register("blue_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Cyan Marble ──
    public static final DeferredBlock<Block> CYAN_MARBLE = register("cyan_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_BRICKS = register("cyan_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_MARBLE_SMALL_BRICKS = register("cyan_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_MARBLE_TILES = register("cyan_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_POLISHED_MARBLE = register("cyan_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR = register("cyan_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR_CAP = register("cyan_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> CYAN_MARBLE_FLOOR_TILE = register("cyan_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> CYAN_MARBLE_FANCY_FENCE = register("cyan_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Green Marble ──
    public static final DeferredBlock<Block> GREEN_MARBLE = register("green_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_BRICKS = register("green_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_MARBLE_SMALL_BRICKS = register("green_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_MARBLE_TILES = register("green_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_POLISHED_MARBLE = register("green_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR = register("green_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR_CAP = register("green_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> GREEN_MARBLE_FLOOR_TILE = register("green_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> GREEN_MARBLE_FANCY_FENCE = register("green_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Lime Marble ──
    public static final DeferredBlock<Block> LIME_MARBLE = register("lime_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_BRICKS = register("lime_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_MARBLE_SMALL_BRICKS = register("lime_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_MARBLE_TILES = register("lime_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_POLISHED_MARBLE = register("lime_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR = register("lime_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR_CAP = register("lime_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> LIME_MARBLE_FLOOR_TILE = register("lime_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> LIME_MARBLE_FANCY_FENCE = register("lime_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Orange Marble ──
    public static final DeferredBlock<Block> ORANGE_MARBLE = register("orange_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_BRICKS = register("orange_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_SMALL_BRICKS = register("orange_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_TILES = register("orange_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_POLISHED_MARBLE = register("orange_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR = register("orange_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR_CAP = register("orange_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> ORANGE_MARBLE_FLOOR_TILE = register("orange_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> ORANGE_MARBLE_FANCY_FENCE = register("orange_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Pink Marble ──
    public static final DeferredBlock<Block> PINK_MARBLE = register("pink_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_BRICKS = register("pink_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_MARBLE_SMALL_BRICKS = register("pink_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_MARBLE_TILES = register("pink_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_POLISHED_MARBLE = register("pink_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR = register("pink_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR_CAP = register("pink_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> PINK_MARBLE_FLOOR_TILE = register("pink_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> PINK_MARBLE_FANCY_FENCE = register("pink_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Purple Marble ──
    public static final DeferredBlock<Block> PURPLE_MARBLE = register("purple_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_BRICKS = register("purple_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_SMALL_BRICKS = register("purple_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_TILES = register("purple_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_POLISHED_MARBLE = register("purple_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR = register("purple_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR_CAP = register("purple_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> PURPLE_MARBLE_FLOOR_TILE = register("purple_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> PURPLE_MARBLE_FANCY_FENCE = register("purple_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Red Marble ──
    public static final DeferredBlock<Block> RED_MARBLE = register("red_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_BRICKS = register("red_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_MARBLE_SMALL_BRICKS = register("red_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_MARBLE_TILES = register("red_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_POLISHED_MARBLE = register("red_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR = register("red_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR_CAP = register("red_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> RED_MARBLE_FLOOR_TILE = register("red_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> RED_MARBLE_FANCY_FENCE = register("red_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Yellow Marble ──
    public static final DeferredBlock<Block> YELLOW_MARBLE = register("yellow_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_BRICKS = register("yellow_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_SMALL_BRICKS = register("yellow_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_TILES = register("yellow_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_POLISHED_MARBLE = register("yellow_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR = register("yellow_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR_CAP = register("yellow_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> YELLOW_MARBLE_FLOOR_TILE = register("yellow_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> YELLOW_MARBLE_FANCY_FENCE = register("yellow_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Diamond Pavers (10 new colors) ──
    public static final DeferredBlock<Block> AMETHYST_MARBLE_DIAMOND_PAVERS = register("amethyst_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_DIAMOND_PAVERS = register("blue_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_DIAMOND_PAVERS = register("cyan_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_DIAMOND_PAVERS = register("green_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_DIAMOND_PAVERS = register("lime_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_DIAMOND_PAVERS = register("orange_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_DIAMOND_PAVERS = register("pink_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_DIAMOND_PAVERS = register("purple_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_DIAMOND_PAVERS = register("red_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_DIAMOND_PAVERS = register("yellow_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<PlateBlock> SANDSTONE_CRENELATION = register("sandstone_crenelation",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));

    public static final DeferredBlock<Block> ROOFING_SLATES = register("roofing_slates",
            () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> WHEAT_THATCH = register("wheat_thatch",
            () -> new Block(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<EdgeBlock> WHEAT_THATCH_EDGE = register("wheat_thatch_edge",
            () -> new EdgeBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<PlateBlock> WHEAT_THATCH_PLATE = register("wheat_thatch_plate",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> BAMBOO_THATCH = register("bamboo_thatch",
            () -> new Block(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<EdgeBlock> BAMBOO_THATCH_EDGE = register("bamboo_thatch_edge",
            () -> new EdgeBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<PlateBlock> BAMBOO_THATCH_PLATE = register("bamboo_thatch_plate",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> STONE_BRICKS_MASONRY = register("stone_bricks_masonry", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> STONE_BRICKS_MASONRY_EDGE = register("stone_bricks_masonry_edge", () -> new com.otterly76.ott.block.custom.EdgeBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> STONE_BRICKS_MASONRY_PLATE = register("stone_bricks_masonry_plate", () -> new com.otterly76.ott.block.custom.PlateBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RakedGravelBlock> CURVED_RAKED_GRAVEL = register("curved_raked_gravel", () -> new RakedGravelBlock(true, Properties.ofFullCopy(Blocks.GRAVEL)));
    public static final DeferredBlock<RakedGravelBlock> STRAIGHT_RAKED_GRAVEL = register("straight_raked_gravel", () -> new RakedGravelBlock(false, Properties.ofFullCopy(Blocks.GRAVEL)));

    public static final DeferredBlock<Block> SANDSTONE_SLENDER_BRICKS = register("sandstone_slender_bricks", () -> new Block(Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SANDSTONE_SLENDER_TURQUOISE_PATTERN = register("sandstone_slender_turquoise_pattern", () -> new Block(Properties.ofFullCopy(Blocks.SANDSTONE)));

    public static final DeferredBlock<Block> ORNAMENTED_RED_WOOL = register("ornamented_red_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DELICATE_RED_WOOL = register("delicate_red_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> ORNAMENTED_RED_CARPET = register("ornamented_red_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_RED_CARPET = register("delicate_red_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> ORNAMENTED_BLUE_WOOL = register("ornamented_blue_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DELICATE_BLUE_WOOL = register("delicate_blue_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> ORNAMENTED_BLUE_CARPET = register("ornamented_blue_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_BLUE_CARPET = register("delicate_blue_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> ORNAMENTED_GREEN_WOOL = register("ornamented_green_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DELICATE_GREEN_WOOL = register("delicate_green_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> ORNAMENTED_GREEN_CARPET = register("ornamented_green_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_GREEN_CARPET = register("delicate_green_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> ORNAMENTED_PURPLE_WOOL = register("ornamented_purple_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DELICATE_PURPLE_WOOL = register("delicate_purple_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> ORNAMENTED_PURPLE_CARPET = register("ornamented_purple_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_PURPLE_CARPET = register("delicate_purple_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));

    public static final DeferredBlock<com.otterly76.ott.block.custom.PergolaBlock> OAK_PERGOLA = register("oak_pergola",
            () -> new com.otterly76.ott.block.custom.PergolaBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.BeamBlock> OAK_BEAM = register("oak_beam",
            () -> new com.otterly76.ott.block.custom.BeamBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> OAK_PLANKS_PLATE = register("oak_planks_plate",
            () -> new com.otterly76.ott.block.custom.PlateBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> OAK_PLANKS_EDGE = register("oak_planks_edge",
            () -> new com.otterly76.ott.block.custom.EdgeBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.BannisterBlock> OAK_BANNISTER = register("oak_bannister",
            () -> new com.otterly76.ott.block.custom.BannisterBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.SupportSlabBlock> OAK_SUPPORT_SLAB = register("oak_support_slab",
            () -> new com.otterly76.ott.block.custom.SupportSlabBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<com.otterly76.ott.block.custom.SupportBeamBlock> OAK_SUPPORT_BEAM = register("oak_support_beam",
            () -> new com.otterly76.ott.block.custom.SupportBeamBlock(
                    Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<Block> OAK_GEOMETRIC_WINDOW = register("oak_geometric_window",
            () -> new com.otterly76.ott.block.custom.GeometricWindowBlock(Properties.of().strength(1.5f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<PlacedLanternBlock> STONE_LANTERN = register("stone_lantern", () -> new PlacedLanternBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<LitPlacedLanternBlock> IRON_FANCY_LANTERN = register("iron_fancy_lantern", () -> new LitPlacedLanternBlock(Properties.of().strength(3.5f).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion().lightLevel(s -> s.getValue(LitPlacedLanternBlock.LIT) ? 15 : 0)));
    public static final DeferredBlock<StarlightLampBlock> STARLIGHT_LAMP = register("starlight_lamp", () -> new StarlightLampBlock(Properties.of().strength(0.5F).sound(SoundType.GLASS).noOcclusion().lightLevel(s -> 15)));

    private static final Properties ST = Properties.ofFullCopy(Blocks.STONE);

    // --- Plain cube_all ---

    // --- Column (RotatedPillarBlock) ---

    // --- Static decorative (plain cube_all, future CTM cousins pending) ---
    public static final DeferredBlock<RotatedPillarBlock> CHISELED_PLASTERED_STONE_PILLAR = register("chiseled_plastered_stone_pillar", () -> new RotatedPillarBlock(ST));

    // CTM vertical pillars

    // --- New plain cube_all stone blocks ---
    public static final DeferredBlock<Block> CHAOTIC_STONE_BRICKS = register("chaotic_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> CHAOTIC_MEDIUM_STONE_BRICKS = register("chaotic_medium_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> CHAOTIC_SMALL_STONE_BRICKS = register("chaotic_small_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> DIAMOND_STONE_PAVERS = register("diamond_stone_pavers", () -> new Block(ST));
    public static final DeferredBlock<Block> ENCASED_STONE_BRICKS = register("encased_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> FRENCH_STONE = register("french_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> LARGE_ORNATE_STONE = register("large_ornate_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> LARGE_STONE_TILE = register("large_stone_tile", () -> new Block(ST));
    public static final DeferredBlock<Block> MESSY_STONE_TILES = register("messy_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> MOSAIC_STONE = register("mosaic_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> NOTCHED_STONE_BRICKS = register("notched_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> ORNATE_STONE = register("ornate_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> POISON_STONE = register("poison_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> POLISHED_CUT_STONE = register("polished_cut_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> POLISHED_STONE_TILES = register("polished_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> PRISM_STONE = register("prism_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> SLANTED_STONE = register("slanted_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_ARRAY = register("stone_array", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_BRAID = register("stone_braid", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_DENT = register("stone_dent", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_JELLYBEAN = register("stone_jellybean", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_LAYERS = register("stone_layers", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_PANEL = register("stone_panel", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_ROAD = register("stone_road", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_ZAG = register("stone_zag", () -> new Block(ST));
    public static final DeferredBlock<Block> SUNKEN_STONE = register("sunken_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> TRIPLE_STONE_BRICKS = register("triple_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> WEATHERED_STONE_BRICKS = register("weathered_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> WEATHERED_TILED_STONE = register("weathered_tiled_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> WEAVER_STONE = register("weaver_stone", () -> new Block(ST));

    // --- New RotatedPillarBlock stone blocks ---
    public static final DeferredBlock<RotatedPillarBlock> CUT_STONE = register("cut_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> ROUGH_CUT_STONE = register("rough_cut_stone", () -> new RotatedPillarBlock(ST));

    // --- New RotatedPillarBlocks ---
    public static final DeferredBlock<RotatedPillarBlock> SHEARED_STONE_PILLAR = register("sheared_stone_pillar", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> SLATED_STONE = register("slated_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> STONE_COLUMN = register("stone_column", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> STONE_TWISTING_COLUMN = register("stone_twisting_column", () -> new RotatedPillarBlock(ST));

    // ── Batch CTM blocks ─────────────────────────────────────────────────────
    // ── Acacia Planks ──

    // ── Acacia Leaves ──

    // ── Birch Leaves ──

    // ── Dark Oak Leaves ──

    // ── Jungle Leaves ──

    // ── Oak Leaves ──

    // ── Spruce Leaves ──

    // ── Amethyst Block ──

    // ── Ancient Debris ──

    // ── Andesite ──

    // ── Bamboo Planks ──

    // ── Basalt ──

    // ── Birch Planks ──

    // ── Blackstone ──

    // ── Black Concrete ──

    // ── Black Stained Glass ──
    public static final DeferredBlock<Block> BLACK_LEADED_STAINED_GLASS =
            register("black_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));

    // ── Black Terracotta ──

    // ── Black Wool ──

    // ── Blue Concrete ──

    // ── Blue Ice ──

    // ── Blue Stained Glass ──
    public static final DeferredBlock<Block> BLUE_LEADED_STAINED_GLASS =
            register("blue_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));

    // ── Blue Terracotta ──

    // ── Blue Wool ──

    // ── Borderless Bricks ──

    // ── Bricks ──

    // ── Brown Concrete ──

    // ── Brown Stained Glass ──
    public static final DeferredBlock<Block> BROWN_LEADED_STAINED_GLASS =
            register("brown_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));

    // ── Brown Terracotta ──

    // ── Brown Wool ──

    // ── Calcite ──

    // ── Cherry Planks ──
    public static final DeferredBlock<Block> CORNERED_CHERRY_PLANKS =
            register("cornered_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRATED_CHERRY_PLANKS =
            register("crated_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_CHERRY_PLANKS =
            register("enclosed_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_CHERRY_PLANKS =
            register("framed_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_CHERRY_PLANKS =
            register("natural_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_CHERRY_PLANKS =
            register("pegged_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_CHERRY_PLANKS =
            register("whirlwind_cherry_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    // ── Clay ──

    // ── Coal Block ──

    // ── Cobblestone ──

    // ── Crimson Planks ──
    public static final DeferredBlock<Block> CORNERED_CRIMSON_PLANKS =
            register("cornered_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> CRATED_CRIMSON_PLANKS =
            register("crated_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_CRIMSON_PLANKS =
            register("enclosed_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_CRIMSON_PLANKS =
            register("framed_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_CRIMSON_PLANKS =
            register("natural_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_CRIMSON_PLANKS =
            register("pegged_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_CRIMSON_PLANKS =
            register("whirlwind_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));

    // ── Crying Obsidian ──

    // ── Cyan Concrete ──

    // ── Cyan Stained Glass ──
    public static final DeferredBlock<Block> CYAN_LEADED_STAINED_GLASS =
            register("cyan_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));

    // ── Cyan Terracotta ──

    // ── Cyan Wool ──

    // ── Dark Oak Planks ──
    public static final DeferredBlock<Block> CORNERED_DARK_OAK_PLANKS =
            register("cornered_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> CRATED_DARK_OAK_PLANKS =
            register("crated_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_DARK_OAK_PLANKS =
            register("enclosed_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_DARK_OAK_PLANKS =
            register("framed_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_DARK_OAK_PLANKS =
            register("natural_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_DARK_OAK_PLANKS =
            register("pegged_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_DARK_OAK_PLANKS =
            register("whirlwind_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));

    // ── Dark Prismarine ──

    // ── Deepslate ──

    // ── Diorite ──

    // ── Dirt ──

    // ── Dripstone ──

    // ── End Stone ──

    // ── Gilded Blackston ──

    // ── Granite ──

    // ── Gray Concrete ──

    // ── Gray Stained Glass ──
    public static final DeferredBlock<Block> GRAY_LEADED_STAINED_GLASS =
            register("gray_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));

    // ── Gray Terracotta ──

    // ── Gray Wool ──

    // ── Green Concrete ──

    // ── Green Stained Glass ──
    public static final DeferredBlock<Block> GREEN_LEADED_STAINED_GLASS =
            register("green_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));

    // ── Green Terracotta ──

    // ── Green Wool ──

    // ── Ice ──

    // ── Jungle Planks ──
    public static final DeferredBlock<Block> CORNERED_JUNGLE_PLANKS =
            register("cornered_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> CRATED_JUNGLE_PLANKS =
            register("crated_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_JUNGLE_PLANKS =
            register("enclosed_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_JUNGLE_PLANKS =
            register("framed_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_JUNGLE_PLANKS =
            register("natural_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_JUNGLE_PLANKS =
            register("pegged_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_JUNGLE_PLANKS =
            register("whirlwind_jungle_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));

    // ── Lapis Block ──

    // ── Leaded Glass ──
    public static final DeferredBlock<Block> CIRCULAR_LEADED_STAINED_GLASS =
            register("circular_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_LEADED_GLASS_CTM =
            register("ornate_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));

    // ── Light Blue Concrete ──

    // ── Light Blue Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_BLUE_STAINED_GLASS =
            register("circular_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_BLUE_STAINED_GLASS_CTM =
            register("fancy_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM =
            register("ornate_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_BLUE_STAINED_GLASS_CTM =
            register("raster_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS =
            register("small_light_blue_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_BLUE_STAINED_GLASS_CTM =
            register("tiled_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_LEADED_STAINED_GLASS =
            register("light_blue_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_BLUE_STAINED_GLASS =
            register("fancy_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS =
            register("large_diamond_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_BLUE_STAINED_GLASS =
            register("ornate_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_BLUE_STAINED_GLASS =
            register("raster_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_STAINED_GLASS =
            register("small_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LIGHT_BLUE_STAINED_GLASS =
            register("square_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_BLUE_STAINED_GLASS =
            register("tiled_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS =
            register("vertical_striped_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_LIGHT_BLUE_STAINED_GLASS =
            register("woven_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));

    // ── Light Blue Terracotta ──

    // ── Light Blue Wool ──

    // ── Light Gray Concrete ──

    // ── Light Gray Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_GRAY_STAINED_GLASS =
            register("circular_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_GRAY_STAINED_GLASS_CTM =
            register("fancy_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM =
            register("ornate_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_GRAY_STAINED_GLASS_CTM =
            register("raster_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS =
            register("small_light_gray_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_GRAY_STAINED_GLASS_CTM =
            register("tiled_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_LEADED_STAINED_GLASS =
            register("light_gray_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_GRAY_STAINED_GLASS =
            register("fancy_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS =
            register("large_diamond_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_GRAY_STAINED_GLASS =
            register("ornate_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_GRAY_STAINED_GLASS =
            register("raster_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_STAINED_GLASS =
            register("small_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LIGHT_GRAY_STAINED_GLASS =
            register("square_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_GRAY_STAINED_GLASS =
            register("tiled_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS =
            register("vertical_striped_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_LIGHT_GRAY_STAINED_GLASS =
            register("woven_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));

    // ── Light Gray Terracotta ──

    // ── Light Gray Wool ──

    // ── Lime Concrete ──

    // ── Lime Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_LIME_STAINED_GLASS =
            register("circular_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIME_STAINED_GLASS_CTM =
            register("fancy_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIME_STAINED_GLASS_CTM =
            register("ornate_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIME_STAINED_GLASS_CTM =
            register("raster_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIME_DIAMOND_STAINED_GLASS =
            register("small_lime_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIME_STAINED_GLASS_CTM =
            register("tiled_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIME_LEADED_STAINED_GLASS =
            register("lime_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIME_STAINED_GLASS =
            register("fancy_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LIME_STAINED_GLASS =
            register("large_diamond_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIME_STAINED_GLASS =
            register("ornate_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIME_STAINED_GLASS =
            register("raster_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIME_STAINED_GLASS =
            register("small_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LIME_STAINED_GLASS =
            register("square_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIME_STAINED_GLASS =
            register("tiled_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_LIME_STAINED_GLASS =
            register("vertical_striped_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_LIME_STAINED_GLASS =
            register("woven_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));

    // ── Lime Terracotta ──

    // ── Lime Wool ──

    // ── Lodestone ──

    // ── Magenta Concrete ──

    // ── Magenta Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_MAGENTA_STAINED_GLASS =
            register("circular_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_MAGENTA_STAINED_GLASS_CTM =
            register("fancy_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_MAGENTA_STAINED_GLASS_CTM =
            register("ornate_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_MAGENTA_STAINED_GLASS_CTM =
            register("raster_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_DIAMOND_STAINED_GLASS =
            register("small_magenta_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_MAGENTA_STAINED_GLASS_CTM =
            register("tiled_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> MAGENTA_LEADED_STAINED_GLASS =
            register("magenta_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_MAGENTA_STAINED_GLASS =
            register("fancy_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_MAGENTA_STAINED_GLASS =
            register("large_diamond_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_MAGENTA_STAINED_GLASS =
            register("ornate_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_MAGENTA_STAINED_GLASS =
            register("raster_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_STAINED_GLASS =
            register("small_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_MAGENTA_STAINED_GLASS =
            register("square_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_MAGENTA_STAINED_GLASS =
            register("tiled_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_MAGENTA_STAINED_GLASS =
            register("vertical_striped_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_MAGENTA_STAINED_GLASS =
            register("woven_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));

    // ── Magenta Terracotta ──

    // ── Magenta Wool ──

    // ── Magma Block ──

    // ── Mangrove Planks ──
    public static final DeferredBlock<Block> BRICKED_MANGROVE_PLANKS =
            register("bricked_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_MANGROVE_PLANKS =
            register("cornered_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CRATED_MANGROVE_PLANKS =
            register("crated_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_MANGROVE_PLANKS =
            register("enclosed_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_MANGROVE_PLANKS =
            register("framed_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_MANGROVE_PLANKS =
            register("natural_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_MANGROVE_PLANKS =
            register("pegged_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));

    // ── Mossy Cobblestone ──

    // ── Mossy Stone ──

    // ── Mud ──

    // ── Mud Bricks ──

    // ── Netherrack ──

    // ── Nether Bricks ──

    // ── Oak Glass ──

    // ── Oak Planks ──

    // ── Obsidian ──

    // ── Orange Concrete ──

    // ── Orange Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_ORANGE_STAINED_GLASS =
            register("circular_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_ORANGE_STAINED_GLASS_CTM =
            register("fancy_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_ORANGE_STAINED_GLASS_CTM =
            register("ornate_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_ORANGE_STAINED_GLASS_CTM =
            register("raster_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_ORANGE_DIAMOND_STAINED_GLASS =
            register("small_orange_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_ORANGE_STAINED_GLASS_CTM =
            register("tiled_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORANGE_LEADED_STAINED_GLASS =
            register("orange_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_ORANGE_STAINED_GLASS =
            register("fancy_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_ORANGE_STAINED_GLASS =
            register("large_diamond_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_ORANGE_STAINED_GLASS =
            register("ornate_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_ORANGE_STAINED_GLASS =
            register("raster_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_ORANGE_STAINED_GLASS =
            register("small_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_ORANGE_STAINED_GLASS =
            register("square_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_ORANGE_STAINED_GLASS =
            register("tiled_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_ORANGE_STAINED_GLASS =
            register("vertical_striped_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_ORANGE_STAINED_GLASS =
            register("woven_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));

    // ── Orange Terracotta ──

    // ── Orange Wool ──

    // ── Packed Ice ──

    // ── Packed Mud ──

    // ── Pink Concrete ──

    // ── Pink Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_PINK_STAINED_GLASS =
            register("circular_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PINK_STAINED_GLASS_CTM =
            register("fancy_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PINK_STAINED_GLASS_CTM =
            register("ornate_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PINK_STAINED_GLASS_CTM =
            register("raster_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PINK_DIAMOND_STAINED_GLASS =
            register("small_pink_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PINK_STAINED_GLASS_CTM =
            register("tiled_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> PINK_LEADED_STAINED_GLASS =
            register("pink_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PINK_STAINED_GLASS =
            register("fancy_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_PINK_STAINED_GLASS =
            register("large_diamond_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PINK_STAINED_GLASS =
            register("ornate_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PINK_STAINED_GLASS =
            register("raster_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PINK_STAINED_GLASS =
            register("small_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_PINK_STAINED_GLASS =
            register("square_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PINK_STAINED_GLASS =
            register("tiled_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_PINK_STAINED_GLASS =
            register("vertical_striped_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_PINK_STAINED_GLASS =
            register("woven_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));

    // ── Pink Terracotta ──

    // ── Pink Wool ──

    // ── Prismarine ──

    // ── Purple Concrete ──

    // ── Purple Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_PURPLE_STAINED_GLASS =
            register("circular_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PURPLE_STAINED_GLASS_CTM =
            register("fancy_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PURPLE_STAINED_GLASS_CTM =
            register("ornate_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PURPLE_STAINED_GLASS_CTM =
            register("raster_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PURPLE_DIAMOND_STAINED_GLASS =
            register("small_purple_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PURPLE_STAINED_GLASS_CTM =
            register("tiled_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> PURPLE_LEADED_STAINED_GLASS =
            register("purple_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PURPLE_STAINED_GLASS =
            register("fancy_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_PURPLE_STAINED_GLASS =
            register("large_diamond_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PURPLE_STAINED_GLASS =
            register("ornate_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PURPLE_STAINED_GLASS =
            register("raster_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PURPLE_STAINED_GLASS =
            register("small_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_PURPLE_STAINED_GLASS =
            register("square_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PURPLE_STAINED_GLASS =
            register("tiled_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_PURPLE_STAINED_GLASS =
            register("vertical_striped_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_PURPLE_STAINED_GLASS =
            register("woven_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));

    // ── Purple Terracotta ──

    // ── Purple Wool ──

    // ── Purpur Block ──

    // ── Quartz Block ──

    // ── Raw Copper Block ──

    // ── Raw Gold Block ──

    // ── Raw Iron Block ──

    // ── Redstone Block ──

    // ── Red Concrete ──

    // ── Red Nether Bricks ──

    // ── Red Sandstone ──

    // ── Red Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_RED_STAINED_GLASS =
            register("circular_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_RED_STAINED_GLASS_CTM =
            register("fancy_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_RED_STAINED_GLASS_CTM =
            register("ornate_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_RED_STAINED_GLASS_CTM =
            register("raster_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_RED_DIAMOND_STAINED_GLASS =
            register("small_red_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_RED_STAINED_GLASS_CTM =
            register("tiled_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RED_LEADED_STAINED_GLASS =
            register("red_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_RED_STAINED_GLASS =
            register("fancy_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_RED_STAINED_GLASS =
            register("large_diamond_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_RED_STAINED_GLASS =
            register("ornate_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_RED_STAINED_GLASS =
            register("raster_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_RED_STAINED_GLASS =
            register("small_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_RED_STAINED_GLASS =
            register("square_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_RED_STAINED_GLASS =
            register("tiled_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_RED_STAINED_GLASS =
            register("vertical_striped_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_RED_STAINED_GLASS =
            register("woven_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));

    // ── Red Terracotta ──

    // ── Red Wool ──

    // ── Sandstone ──

    // ── Smooth Stone ──

    // ── Snow Block ──

    // ── Spruce Planks ──
    public static final DeferredBlock<Block> CORNERED_SPRUCE_PLANKS =
            register("cornered_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> CRATED_SPRUCE_PLANKS =
            register("crated_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_SPRUCE_PLANKS =
            register("enclosed_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_SPRUCE_PLANKS =
            register("framed_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_SPRUCE_PLANKS =
            register("natural_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_SPRUCE_PLANKS =
            register("pegged_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_SPRUCE_PLANKS =
            register("whirlwind_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));

    // ── Terracotta ──

    // ── Tuff ──

    // ── Warped Planks ──
    public static final DeferredBlock<Block> CORNERED_WARPED_PLANKS =
            register("cornered_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> CRATED_WARPED_PLANKS =
            register("crated_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_WARPED_PLANKS =
            register("enclosed_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_WARPED_PLANKS =
            register("framed_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_WARPED_PLANKS =
            register("natural_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_WARPED_PLANKS =
            register("pegged_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_WARPED_PLANKS =
            register("whirlwind_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // ── White Concrete ──

    // ── White Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_WHITE_STAINED_GLASS =
            register("circular_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_WHITE_STAINED_GLASS_CTM =
            register("fancy_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_WHITE_STAINED_GLASS_CTM =
            register("ornate_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_WHITE_STAINED_GLASS_CTM =
            register("raster_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_WHITE_DIAMOND_STAINED_GLASS =
            register("small_white_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_WHITE_STAINED_GLASS_CTM =
            register("tiled_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WHITE_LEADED_STAINED_GLASS =
            register("white_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_WHITE_STAINED_GLASS =
            register("fancy_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_WHITE_STAINED_GLASS =
            register("large_diamond_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_WHITE_STAINED_GLASS =
            register("ornate_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_WHITE_STAINED_GLASS =
            register("raster_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_WHITE_STAINED_GLASS =
            register("small_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_WHITE_STAINED_GLASS =
            register("square_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_WHITE_STAINED_GLASS =
            register("tiled_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_WHITE_STAINED_GLASS =
            register("vertical_striped_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_WHITE_STAINED_GLASS =
            register("woven_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));

    // ── White Terracotta ──

    // ── White Wool ──

    // ── Yellow Concrete ──

    // ── Yellow Stained Glass ──
    public static final DeferredBlock<Block> CIRCULAR_YELLOW_STAINED_GLASS =
            register("circular_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_YELLOW_STAINED_GLASS_CTM =
            register("fancy_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_YELLOW_STAINED_GLASS_CTM =
            register("ornate_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_YELLOW_STAINED_GLASS_CTM =
            register("raster_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_YELLOW_DIAMOND_STAINED_GLASS =
            register("small_yellow_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_YELLOW_STAINED_GLASS_CTM =
            register("tiled_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> YELLOW_LEADED_STAINED_GLASS =
            register("yellow_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_YELLOW_STAINED_GLASS =
            register("fancy_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_YELLOW_STAINED_GLASS =
            register("large_diamond_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_YELLOW_STAINED_GLASS =
            register("ornate_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_YELLOW_STAINED_GLASS =
            register("raster_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_YELLOW_STAINED_GLASS =
            register("small_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_YELLOW_STAINED_GLASS =
            register("square_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_YELLOW_STAINED_GLASS =
            register("tiled_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_YELLOW_STAINED_GLASS =
            register("vertical_striped_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_YELLOW_STAINED_GLASS =
            register("woven_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));

    // ── Yellow Terracotta ──

    // ── Yellow Wool ──

    // ── New CTM batch blocks ──────────────────────────────────────────────
    public static final DeferredBlock<Block> BLACK_FRAMED_GLASS = register("black_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLACK_STAINED_CLEAR_GLASS = register("black_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_FRAMED_GLASS = register("blue_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_STAINED_CLEAR_GLASS = register("blue_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BROWN_FRAMED_GLASS = register("brown_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BROWN_STAINED_CLEAR_GLASS = register("brown_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CHISELED_GLASS = register("chiseled_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS = register("clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CYAN_FRAMED_GLASS = register("cyan_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CYAN_STAINED_CLEAR_GLASS = register("cyan_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> DIRTY_GLASS = register("dirty_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FRAMED_GLASS = register("framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FROSTED_GLASS = register("frosted_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_BLACK_STAINED_GLASS = register("golden_framed_black_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_BLUE_STAINED_GLASS = register("golden_framed_blue_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_BROWN_STAINED_GLASS = register("golden_framed_brown_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_CYAN_STAINED_GLASS = register("golden_framed_cyan_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_GRAY_STAINED_GLASS = register("golden_framed_gray_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_GREEN_STAINED_GLASS = register("golden_framed_green_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS = register("golden_framed_light_blue_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS = register("golden_framed_light_gray_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_LIME_STAINED_GLASS = register("golden_framed_lime_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_MAGENTA_STAINED_GLASS = register("golden_framed_magenta_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_ORANGE_STAINED_GLASS = register("golden_framed_orange_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_PINK_STAINED_GLASS = register("golden_framed_pink_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_PURPLE_STAINED_GLASS = register("golden_framed_purple_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_RED_STAINED_GLASS = register("golden_framed_red_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_STAINED_GLASS = register("golden_framed_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_WHITE_STAINED_GLASS = register("golden_framed_white_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_YELLOW_STAINED_GLASS = register("golden_framed_yellow_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GRAY_FRAMED_GLASS = register("gray_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GRAY_STAINED_CLEAR_GLASS = register("gray_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_FRAMED_GLASS = register("green_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_STAINED_CLEAR_GLASS = register("green_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_FRAMED_GLASS = register("light_blue_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_CLEAR_GLASS = register("light_blue_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_FRAMED_GLASS = register("light_gray_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_CLEAR_GLASS = register("light_gray_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_FRAMED_GLASS = register("lime_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_STAINED_CLEAR_GLASS = register("lime_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_FRAMED_GLASS = register("magenta_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_STAINED_CLEAR_GLASS = register("magenta_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OBSIDIAN_FRAMED_GLASS = register("obsidian_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORANGE_FRAMED_GLASS = register("orange_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORANGE_STAINED_CLEAR_GLASS = register("orange_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICK_PATTERN = register("pale_oak_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_FRAMED_GLASS = register("pink_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PINK_STAINED_CLEAR_GLASS = register("pink_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE = register("polished_limestone", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_FRAMED_GLASS = register("purple_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPLE_STAINED_CLEAR_GLASS = register("purple_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RED_FRAMED_GLASS = register("red_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RED_STAINED_CLEAR_GLASS = register("red_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SANDSTONE_FRAMED_GLASS = register("sandstone_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SEA_LANTERN = register("sea_lantern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_FRAMED_GLASS = register("stone_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_CLEAR_GLASS = register("tinted_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WHITE_FRAMED_GLASS = register("white_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WHITE_STAINED_CLEAR_GLASS = register("white_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_FRAMED_GLASS = register("yellow_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_STAINED_CLEAR_GLASS = register("yellow_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLACK_STAINED_GLASS = register("black_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_STAINED_GLASS = register("blue_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS = register("borderless_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_BLACK = register("borderless_glass_black", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_BLUE = register("borderless_glass_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_BROWN = register("borderless_glass_brown", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_CYAN = register("borderless_glass_cyan", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_GRAY = register("borderless_glass_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_GREEN = register("borderless_glass_green", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_LIGHT_BLUE = register("borderless_glass_light_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_LIGHT_GRAY = register("borderless_glass_light_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_LIME = register("borderless_glass_lime", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_MAGENTA = register("borderless_glass_magenta", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_ORANGE = register("borderless_glass_orange", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_PINK = register("borderless_glass_pink", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_PURPLE = register("borderless_glass_purple", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_RED = register("borderless_glass_red", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_WHITE = register("borderless_glass_white", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_YELLOW = register("borderless_glass_yellow", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BROWN_STAINED_GLASS = register("brown_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> COPPER_BLOCK = register("copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_GRATE = register("copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CYAN_STAINED_GLASS = register("cyan_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> EXPOSED_COPPER_BLOCK = register("exposed_copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EXPOSED_COPPER_GRATE = register("exposed_copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> GRAY_STAINED_GLASS = register("gray_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_STAINED_GLASS = register("green_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ICE_GLASS = register("ice_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS = register("light_blue_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS = register("light_gray_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_STAINED_GLASS = register("lime_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS = register("magenta_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORANGE_STAINED_GLASS = register("orange_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OXIDIZED_COPPER_BLOCK = register("oxidized_copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OXIDIZED_COPPER_GRATE = register("oxidized_copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BEAMS = register("pale_oak_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICK_PAVING = register("pale_oak_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_CRATE = register("pale_oak_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_DIAGONAL_STRIPES = register("pale_oak_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_DIAGONAL_TILES = register("pale_oak_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_DOTTED = register("pale_oak_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_FLOORING = register("pale_oak_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_LARGE_TILES = register("pale_oak_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_PATTERN = register("pale_oak_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_ROTATED_BRICKS = register("pale_oak_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_SMALL_BRICKS = register("pale_oak_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_SMALL_TILES = register("pale_oak_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_SQUARES = register("pale_oak_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_TILES = register("pale_oak_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_WAVY = register("pale_oak_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_WOVEN = register("pale_oak_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_STAINED_GLASS = register("pink_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPLE_STAINED_GLASS = register("purple_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RED_STAINED_GLASS = register("red_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> REINFORCED_GLASS = register("reinforced_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS = register("scratched_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_BLACK = register("scratched_glass_black", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_BLUE = register("scratched_glass_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_BROWN = register("scratched_glass_brown", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_CYAN = register("scratched_glass_cyan", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_GRAY = register("scratched_glass_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_GREEN = register("scratched_glass_green", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_LIGHT_BLUE = register("scratched_glass_light_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_LIGHT_GRAY = register("scratched_glass_light_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_LIME = register("scratched_glass_lime", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_MAGENTA = register("scratched_glass_magenta", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_ORANGE = register("scratched_glass_orange", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_PINK = register("scratched_glass_pink", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_PURPLE = register("scratched_glass_purple", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_RED = register("scratched_glass_red", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_WHITE = register("scratched_glass_white", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_YELLOW = register("scratched_glass_yellow", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS = register("tinted_borderless_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_BLACK = register("tinted_borderless_glass_black", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_BLUE = register("tinted_borderless_glass_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_BROWN = register("tinted_borderless_glass_brown", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_CYAN = register("tinted_borderless_glass_cyan", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_GRAY = register("tinted_borderless_glass_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_GREEN = register("tinted_borderless_glass_green", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_LIGHT_BLUE = register("tinted_borderless_glass_light_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_LIGHT_GRAY = register("tinted_borderless_glass_light_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_LIME = register("tinted_borderless_glass_lime", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_MAGENTA = register("tinted_borderless_glass_magenta", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_ORANGE = register("tinted_borderless_glass_orange", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_PINK = register("tinted_borderless_glass_pink", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_PURPLE = register("tinted_borderless_glass_purple", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_RED = register("tinted_borderless_glass_red", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_WHITE = register("tinted_borderless_glass_white", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_YELLOW = register("tinted_borderless_glass_yellow", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_GLASS = register("tinted_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WEATHERED_COPPER_BLOCK = register("weathered_copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WEATHERED_COPPER_GRATE = register("weathered_copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WHITE_STAINED_GLASS = register("white_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_STAINED_GLASS = register("yellow_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICKS = register("pale_oak_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    // ── Bamboo Windows CTM ──
    public static final DeferredBlock<Block> BAMBOO_WINDOW_BARS_CTM = register("bamboo_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_COVERED_CTM = register("bamboo_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_DIAGONAL_CTM = register("bamboo_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_LARGE_CTM = register("bamboo_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_PANES_CTM = register("bamboo_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_ROUNDED_CTM = register("bamboo_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SLIM_CTM = register("bamboo_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SWIRLING_CTM = register("bamboo_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_TILES_CTM = register("bamboo_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    // ── Cherry Windows CTM ──
    public static final DeferredBlock<Block> CHERRY_WINDOW_BARS_CTM = register("cherry_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_COVERED_CTM = register("cherry_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_DIAGONAL_CTM = register("cherry_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_LARGE_CTM = register("cherry_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_PANES_CTM = register("cherry_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_ROUNDED_CTM = register("cherry_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SLIM_CTM = register("cherry_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SWIRLING_CTM = register("cherry_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_TILES_CTM = register("cherry_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS_CTM = register("pale_oak_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED_CTM = register("pale_oak_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL_CTM = register("pale_oak_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE_CTM = register("pale_oak_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES_CTM = register("pale_oak_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED_CTM = register("pale_oak_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM_CTM = register("pale_oak_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING_CTM = register("pale_oak_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES_CTM = register("pale_oak_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ── Plain window blocks (cube_column) ──────────────────────────────────────────
    // ── Bamboo Windows ──
    public static final DeferredBlock<Block> BAMBOO_WINDOW_BARS = register("bamboo_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_COVERED = register("bamboo_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_DIAGONAL = register("bamboo_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_LARGE = register("bamboo_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_PANES = register("bamboo_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_ROUNDED = register("bamboo_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SLIM = register("bamboo_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SWIRLING = register("bamboo_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    // ── Cherry Windows ──
    public static final DeferredBlock<Block> CHERRY_WINDOW_BARS = register("cherry_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_COVERED = register("cherry_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_DIAGONAL = register("cherry_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_LARGE = register("cherry_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_PANES = register("cherry_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_ROUNDED = register("cherry_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SLIM = register("cherry_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SWIRLING = register("cherry_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS = register("pale_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED = register("pale_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL = register("pale_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE = register("pale_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES = register("pale_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED = register("pale_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM = register("pale_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING = register("pale_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES = register("pale_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ── Glass/ plain blocks ───────────────────────────────────────────────────────
    public static final DeferredBlock<Block> LEADED_GLASS = register("leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> GLASS_OCHRE_FROGLIGHT = register("glass_ochre_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GLASS_PEARLESCENT_FROGLIGHT = register("glass_pearlescent_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GLASS_VERDANT_FROGLIGHT = register("glass_verdant_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));

    // ── Pane blocks ───────────────────────────────────────────────────────────────
    // ── Bamboo Window Panes ──
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_BARS_PANE = register("bamboo_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_COVERED_PANE = register("bamboo_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_DIAGONAL_PANE = register("bamboo_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_LARGE_PANE = register("bamboo_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_PANES_PANE = register("bamboo_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_ROUNDED_PANE = register("bamboo_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_SLIM_PANE = register("bamboo_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_SWIRLING_PANE = register("bamboo_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_TILES_PANE = register("bamboo_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    // ── Cherry Window Panes ──
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_BARS_PANE = register("cherry_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_COVERED_PANE = register("cherry_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_DIAGONAL_PANE = register("cherry_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_LARGE_PANE = register("cherry_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_PANES_PANE = register("cherry_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_ROUNDED_PANE = register("cherry_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_SLIM_PANE = register("cherry_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_SWIRLING_PANE = register("cherry_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_TILES_PANE = register("cherry_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_BARS_PANE = register("pale_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_COVERED_PANE = register("pale_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_DIAGONAL_PANE = register("pale_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_LARGE_PANE = register("pale_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_PANES_PANE = register("pale_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_ROUNDED_PANE = register("pale_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SLIM_PANE = register("pale_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SWIRLING_PANE = register("pale_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_TILES_PANE = register("pale_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LEADED_STAINED_GLASS_PANE = register("circular_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BLACK_LEADED_STAINED_GLASS_PANE = register("black_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BLUE_LEADED_STAINED_GLASS_PANE = register("blue_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BROWN_LEADED_STAINED_GLASS_PANE = register("brown_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CYAN_LEADED_STAINED_GLASS_PANE = register("cyan_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GRAY_LEADED_STAINED_GLASS_PANE = register("gray_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GREEN_LEADED_STAINED_GLASS_PANE = register("green_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LIGHT_BLUE_STAINED_GLASS_PANE = register("circular_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LIGHT_BLUE_LEADED_STAINED_GLASS_PANE = register("light_blue_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LIGHT_BLUE_STAINED_GLASS_PANE = register("fancy_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS_PANE = register("large_diamond_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LIGHT_BLUE_STAINED_GLASS_PANE = register("ornate_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LIGHT_BLUE_STAINED_GLASS_PANE = register("raster_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_LIGHT_BLUE_STAINED_GLASS_PANE = register("small_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LIGHT_BLUE_STAINED_GLASS_PANE = register("square_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_LIGHT_BLUE_STAINED_GLASS_PANE = register("tiled_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS_PANE = register("vertical_striped_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_LIGHT_BLUE_STAINED_GLASS_PANE = register("woven_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LIGHT_GRAY_STAINED_GLASS_PANE = register("circular_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LIGHT_GRAY_LEADED_STAINED_GLASS_PANE = register("light_gray_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LIGHT_GRAY_STAINED_GLASS_PANE = register("fancy_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS_PANE = register("large_diamond_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LIGHT_GRAY_STAINED_GLASS_PANE = register("ornate_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LIGHT_GRAY_STAINED_GLASS_PANE = register("raster_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_LIGHT_GRAY_STAINED_GLASS_PANE = register("small_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LIGHT_GRAY_STAINED_GLASS_PANE = register("square_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_LIGHT_GRAY_STAINED_GLASS_PANE = register("tiled_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS_PANE = register("vertical_striped_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_LIGHT_GRAY_STAINED_GLASS_PANE = register("woven_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LIME_STAINED_GLASS_PANE = register("circular_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LIME_LEADED_STAINED_GLASS_PANE = register("lime_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LIME_STAINED_GLASS_PANE = register("fancy_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LIME_STAINED_GLASS_PANE = register("large_diamond_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LIME_STAINED_GLASS_PANE = register("ornate_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LIME_STAINED_GLASS_PANE = register("raster_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_LIME_STAINED_GLASS_PANE = register("small_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LIME_STAINED_GLASS_PANE = register("square_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_LIME_STAINED_GLASS_PANE = register("tiled_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_LIME_STAINED_GLASS_PANE = register("vertical_striped_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_LIME_STAINED_GLASS_PANE = register("woven_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_MAGENTA_STAINED_GLASS_PANE = register("circular_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MAGENTA_LEADED_STAINED_GLASS_PANE = register("magenta_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_MAGENTA_STAINED_GLASS_PANE = register("fancy_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_MAGENTA_STAINED_GLASS_PANE = register("large_diamond_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_MAGENTA_STAINED_GLASS_PANE = register("ornate_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_MAGENTA_STAINED_GLASS_PANE = register("raster_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_MAGENTA_STAINED_GLASS_PANE = register("small_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_MAGENTA_STAINED_GLASS_PANE = register("square_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_MAGENTA_STAINED_GLASS_PANE = register("tiled_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_MAGENTA_STAINED_GLASS_PANE = register("vertical_striped_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_MAGENTA_STAINED_GLASS_PANE = register("woven_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_ORANGE_STAINED_GLASS_PANE = register("circular_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORANGE_LEADED_STAINED_GLASS_PANE = register("orange_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_ORANGE_STAINED_GLASS_PANE = register("fancy_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_ORANGE_STAINED_GLASS_PANE = register("large_diamond_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_ORANGE_STAINED_GLASS_PANE = register("ornate_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_ORANGE_STAINED_GLASS_PANE = register("raster_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_ORANGE_STAINED_GLASS_PANE = register("small_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_ORANGE_STAINED_GLASS_PANE = register("square_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_ORANGE_STAINED_GLASS_PANE = register("tiled_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_ORANGE_STAINED_GLASS_PANE = register("vertical_striped_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_ORANGE_STAINED_GLASS_PANE = register("woven_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_PINK_STAINED_GLASS_PANE = register("circular_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PINK_LEADED_STAINED_GLASS_PANE = register("pink_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_PINK_STAINED_GLASS_PANE = register("fancy_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_PINK_STAINED_GLASS_PANE = register("large_diamond_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_PINK_STAINED_GLASS_PANE = register("ornate_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_PINK_STAINED_GLASS_PANE = register("raster_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_PINK_STAINED_GLASS_PANE = register("small_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_PINK_STAINED_GLASS_PANE = register("square_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_PINK_STAINED_GLASS_PANE = register("tiled_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_PINK_STAINED_GLASS_PANE = register("vertical_striped_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_PINK_STAINED_GLASS_PANE = register("woven_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_PURPLE_STAINED_GLASS_PANE = register("circular_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PURPLE_LEADED_STAINED_GLASS_PANE = register("purple_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_PURPLE_STAINED_GLASS_PANE = register("fancy_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_PURPLE_STAINED_GLASS_PANE = register("large_diamond_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_PURPLE_STAINED_GLASS_PANE = register("ornate_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_PURPLE_STAINED_GLASS_PANE = register("raster_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_PURPLE_STAINED_GLASS_PANE = register("small_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_PURPLE_STAINED_GLASS_PANE = register("square_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_PURPLE_STAINED_GLASS_PANE = register("tiled_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_PURPLE_STAINED_GLASS_PANE = register("vertical_striped_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_PURPLE_STAINED_GLASS_PANE = register("woven_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_RED_STAINED_GLASS_PANE = register("circular_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RED_LEADED_STAINED_GLASS_PANE = register("red_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_RED_STAINED_GLASS_PANE = register("fancy_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_RED_STAINED_GLASS_PANE = register("large_diamond_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_RED_STAINED_GLASS_PANE = register("ornate_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_RED_STAINED_GLASS_PANE = register("raster_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_RED_STAINED_GLASS_PANE = register("small_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_RED_STAINED_GLASS_PANE = register("square_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_RED_STAINED_GLASS_PANE = register("tiled_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_RED_STAINED_GLASS_PANE = register("vertical_striped_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_RED_STAINED_GLASS_PANE = register("woven_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_WHITE_STAINED_GLASS_PANE = register("circular_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WHITE_LEADED_STAINED_GLASS_PANE = register("white_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_WHITE_STAINED_GLASS_PANE = register("fancy_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_WHITE_STAINED_GLASS_PANE = register("large_diamond_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_WHITE_STAINED_GLASS_PANE = register("ornate_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_WHITE_STAINED_GLASS_PANE = register("raster_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_WHITE_STAINED_GLASS_PANE = register("small_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_WHITE_STAINED_GLASS_PANE = register("square_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_WHITE_STAINED_GLASS_PANE = register("tiled_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_WHITE_STAINED_GLASS_PANE = register("vertical_striped_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_WHITE_STAINED_GLASS_PANE = register("woven_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_YELLOW_STAINED_GLASS_PANE = register("circular_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> YELLOW_LEADED_STAINED_GLASS_PANE = register("yellow_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_YELLOW_STAINED_GLASS_PANE = register("fancy_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_YELLOW_STAINED_GLASS_PANE = register("large_diamond_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_YELLOW_STAINED_GLASS_PANE = register("ornate_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_YELLOW_STAINED_GLASS_PANE = register("raster_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_YELLOW_STAINED_GLASS_PANE = register("small_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_YELLOW_STAINED_GLASS_PANE = register("square_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_YELLOW_STAINED_GLASS_PANE = register("tiled_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_YELLOW_STAINED_GLASS_PANE = register("vertical_striped_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_YELLOW_STAINED_GLASS_PANE = register("woven_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEADED_GLASS_PANE = register("leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHISELED_GLASS_CTM_PANE = register("chiseled_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CLEAR_GLASS_CTM_PANE = register("clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DIRTY_GLASS_CTM_PANE = register("dirty_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FROSTED_GLASS_CTM_PANE = register("frosted_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ICE_GLASS_CTM_PANE = register("ice_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OBSIDIAN_FRAMED_GLASS_CTM_PANE = register("obsidian_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> REINFORCED_GLASS_CTM_PANE = register("reinforced_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SANDSTONE_FRAMED_GLASS_CTM_PANE = register("sandstone_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> STONE_FRAMED_GLASS_CTM_PANE = register("stone_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_CLEAR_GLASS_CTM_PANE = register("tinted_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_GLASS_CTM_PANE = register("tinted_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    // -- CTM connecting window panes -- wood types
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_SWIRLING_CTM_PANE = register("cherry_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_BARS_CTM_PANE = register("cherry_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_COVERED_CTM_PANE = register("cherry_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_DIAGONAL_CTM_PANE = register("cherry_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_LARGE_CTM_PANE = register("cherry_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_PANES_CTM_PANE = register("cherry_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_ROUNDED_CTM_PANE = register("cherry_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_SLIM_CTM_PANE = register("cherry_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_TILES_CTM_PANE = register("cherry_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_SWIRLING_CTM_PANE = register("bamboo_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_BARS_CTM_PANE = register("bamboo_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_COVERED_CTM_PANE = register("bamboo_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_DIAGONAL_CTM_PANE = register("bamboo_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_LARGE_CTM_PANE = register("bamboo_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_PANES_CTM_PANE = register("bamboo_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_ROUNDED_CTM_PANE = register("bamboo_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_SLIM_CTM_PANE = register("bamboo_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_TILES_CTM_PANE = register("bamboo_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_SWIRLING_CTM_PANE = register("pale_oak_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_BARS_CTM_PANE = register("pale_oak_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_COVERED_CTM_PANE = register("pale_oak_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_DIAGONAL_CTM_PANE = register("pale_oak_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_LARGE_CTM_PANE = register("pale_oak_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_PANES_CTM_PANE = register("pale_oak_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_ROUNDED_CTM_PANE = register("pale_oak_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_SLIM_CTM_PANE = register("pale_oak_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_TILES_CTM_PANE = register("pale_oak_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    // -- CTM connecting panes -- stained glass patterns
    public static final DeferredBlock<CtmPaneBlock> WHITE_FRAMED_GLASS_CTM_PANE = register("white_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WHITE_STAINED_GLASS_CTM_PANE = register("white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_WHITE_STAINED_GLASS_CTM_PANE = register("fancy_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_WHITE_STAINED_GLASS_CTM_PANE = register("golden_framed_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_WHITE_STAINED_GLASS_CTM_PANE = register("ornate_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_WHITE_STAINED_GLASS_CTM_PANE = register("raster_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_WHITE_CTM_PANE = register("scratched_glass_white_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_white_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_WHITE_STAINED_GLASS_CTM_PANE = register("tiled_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_WHITE_CTM_PANE = register("tinted_borderless_glass_white_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_WHITE_CTM_PANE = register("borderless_glass_white_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORANGE_FRAMED_GLASS_CTM_PANE = register("orange_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORANGE_STAINED_GLASS_CTM_PANE = register("orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_ORANGE_STAINED_GLASS_CTM_PANE = register("fancy_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_ORANGE_STAINED_GLASS_CTM_PANE = register("golden_framed_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_ORANGE_STAINED_GLASS_CTM_PANE = register("ornate_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_ORANGE_STAINED_GLASS_CTM_PANE = register("raster_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_ORANGE_CTM_PANE = register("scratched_glass_orange_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_orange_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_ORANGE_STAINED_GLASS_CTM_PANE = register("tiled_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_ORANGE_CTM_PANE = register("tinted_borderless_glass_orange_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_ORANGE_CTM_PANE = register("borderless_glass_orange_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MAGENTA_FRAMED_GLASS_CTM_PANE = register("magenta_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MAGENTA_STAINED_GLASS_CTM_PANE = register("magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_MAGENTA_STAINED_GLASS_CTM_PANE = register("fancy_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_MAGENTA_STAINED_GLASS_CTM_PANE = register("golden_framed_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_MAGENTA_STAINED_GLASS_CTM_PANE = register("ornate_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_MAGENTA_STAINED_GLASS_CTM_PANE = register("raster_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_MAGENTA_CTM_PANE = register("scratched_glass_magenta_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_magenta_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_MAGENTA_STAINED_GLASS_CTM_PANE = register("tiled_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_MAGENTA_CTM_PANE = register("tinted_borderless_glass_magenta_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_MAGENTA_CTM_PANE = register("borderless_glass_magenta_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_BLUE_FRAMED_GLASS_CTM_PANE = register("light_blue_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("fancy_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("golden_framed_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("ornate_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("raster_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_LIGHT_BLUE_CTM_PANE = register("scratched_glass_light_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_light_blue_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("tiled_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE = register("tinted_borderless_glass_light_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE = register("borderless_glass_light_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> YELLOW_FRAMED_GLASS_CTM_PANE = register("yellow_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> YELLOW_STAINED_GLASS_CTM_PANE = register("yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_YELLOW_STAINED_GLASS_CTM_PANE = register("fancy_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_YELLOW_STAINED_GLASS_CTM_PANE = register("golden_framed_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_YELLOW_STAINED_GLASS_CTM_PANE = register("ornate_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_YELLOW_STAINED_GLASS_CTM_PANE = register("raster_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_YELLOW_CTM_PANE = register("scratched_glass_yellow_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_yellow_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_YELLOW_STAINED_GLASS_CTM_PANE = register("tiled_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_YELLOW_CTM_PANE = register("tinted_borderless_glass_yellow_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_YELLOW_CTM_PANE = register("borderless_glass_yellow_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIME_FRAMED_GLASS_CTM_PANE = register("lime_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIME_STAINED_GLASS_CTM_PANE = register("lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LIME_STAINED_GLASS_CTM_PANE = register("fancy_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_LIME_STAINED_GLASS_CTM_PANE = register("golden_framed_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LIME_STAINED_GLASS_CTM_PANE = register("ornate_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LIME_STAINED_GLASS_CTM_PANE = register("raster_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_LIME_CTM_PANE = register("scratched_glass_lime_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_LIME_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_lime_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_LIME_STAINED_GLASS_CTM_PANE = register("tiled_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_LIME_CTM_PANE = register("tinted_borderless_glass_lime_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_LIME_CTM_PANE = register("borderless_glass_lime_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PINK_FRAMED_GLASS_CTM_PANE = register("pink_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PINK_STAINED_GLASS_CTM_PANE = register("pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_PINK_STAINED_GLASS_CTM_PANE = register("fancy_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_PINK_STAINED_GLASS_CTM_PANE = register("golden_framed_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_PINK_STAINED_GLASS_CTM_PANE = register("ornate_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_PINK_STAINED_GLASS_CTM_PANE = register("raster_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_PINK_CTM_PANE = register("scratched_glass_pink_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_PINK_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_pink_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_PINK_STAINED_GLASS_CTM_PANE = register("tiled_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_PINK_CTM_PANE = register("tinted_borderless_glass_pink_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_PINK_CTM_PANE = register("borderless_glass_pink_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GRAY_FRAMED_GLASS_CTM_PANE = register("gray_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GRAY_STAINED_GLASS_CTM_PANE = register("gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_GRAY_STAINED_GLASS_CTM_PANE = register("golden_framed_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_GRAY_CTM_PANE = register("scratched_glass_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_GRAY_CTM_PANE = register("tinted_borderless_glass_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_GRAY_CTM_PANE = register("borderless_glass_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_GRAY_FRAMED_GLASS_CTM_PANE = register("light_gray_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("fancy_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("golden_framed_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("ornate_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("raster_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_LIGHT_GRAY_CTM_PANE = register("scratched_glass_light_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_light_gray_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("tiled_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE = register("tinted_borderless_glass_light_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE = register("borderless_glass_light_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CYAN_FRAMED_GLASS_CTM_PANE = register("cyan_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CYAN_STAINED_GLASS_CTM_PANE = register("cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_CYAN_STAINED_GLASS_CTM_PANE = register("golden_framed_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_CYAN_CTM_PANE = register("scratched_glass_cyan_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_CYAN_CTM_PANE = register("tinted_borderless_glass_cyan_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_CYAN_CTM_PANE = register("borderless_glass_cyan_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PURPLE_FRAMED_GLASS_CTM_PANE = register("purple_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PURPLE_STAINED_GLASS_CTM_PANE = register("purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_PURPLE_STAINED_GLASS_CTM_PANE = register("fancy_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_PURPLE_STAINED_GLASS_CTM_PANE = register("golden_framed_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_PURPLE_STAINED_GLASS_CTM_PANE = register("ornate_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_PURPLE_STAINED_GLASS_CTM_PANE = register("raster_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_PURPLE_CTM_PANE = register("scratched_glass_purple_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_purple_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_PURPLE_STAINED_GLASS_CTM_PANE = register("tiled_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_PURPLE_CTM_PANE = register("tinted_borderless_glass_purple_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_PURPLE_CTM_PANE = register("borderless_glass_purple_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLUE_FRAMED_GLASS_CTM_PANE = register("blue_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLUE_STAINED_GLASS_CTM_PANE = register("blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_BLUE_STAINED_GLASS_CTM_PANE = register("golden_framed_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_BLUE_CTM_PANE = register("scratched_glass_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_BLUE_CTM_PANE = register("tinted_borderless_glass_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_BLUE_CTM_PANE = register("borderless_glass_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BROWN_FRAMED_GLASS_CTM_PANE = register("brown_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BROWN_STAINED_GLASS_CTM_PANE = register("brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_BROWN_STAINED_GLASS_CTM_PANE = register("golden_framed_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_BROWN_CTM_PANE = register("scratched_glass_brown_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_BROWN_CTM_PANE = register("tinted_borderless_glass_brown_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_BROWN_CTM_PANE = register("borderless_glass_brown_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GREEN_FRAMED_GLASS_CTM_PANE = register("green_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GREEN_STAINED_GLASS_CTM_PANE = register("green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_GREEN_STAINED_GLASS_CTM_PANE = register("golden_framed_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_GREEN_CTM_PANE = register("scratched_glass_green_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_GREEN_CTM_PANE = register("tinted_borderless_glass_green_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_GREEN_CTM_PANE = register("borderless_glass_green_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RED_FRAMED_GLASS_CTM_PANE = register("red_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RED_STAINED_GLASS_CTM_PANE = register("red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_RED_STAINED_GLASS_CTM_PANE = register("fancy_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_RED_STAINED_GLASS_CTM_PANE = register("golden_framed_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_RED_STAINED_GLASS_CTM_PANE = register("ornate_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_RED_STAINED_GLASS_CTM_PANE = register("raster_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_RED_CTM_PANE = register("scratched_glass_red_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_RED_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_red_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_RED_STAINED_GLASS_CTM_PANE = register("tiled_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_RED_CTM_PANE = register("tinted_borderless_glass_red_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_RED_CTM_PANE = register("borderless_glass_red_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLACK_FRAMED_GLASS_CTM_PANE = register("black_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLACK_STAINED_GLASS_CTM_PANE = register("black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_BLACK_STAINED_GLASS_CTM_PANE = register("golden_framed_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_BLACK_CTM_PANE = register("scratched_glass_black_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_BLACK_CTM_PANE = register("tinted_borderless_glass_black_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_BLACK_CTM_PANE = register("borderless_glass_black_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    // -- CTM connecting panes -- plain variants
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_CTM_PANE = register("scratched_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_CTM_PANE = register("tinted_borderless_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_CTM_PANE = register("borderless_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WHITE_STAINED_CLEAR_GLASS_CTM_PANE = register("white_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORANGE_STAINED_CLEAR_GLASS_CTM_PANE = register("orange_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MAGENTA_STAINED_CLEAR_GLASS_CTM_PANE = register("magenta_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_BLUE_STAINED_CLEAR_GLASS_CTM_PANE = register("light_blue_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> YELLOW_STAINED_CLEAR_GLASS_CTM_PANE = register("yellow_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIME_STAINED_CLEAR_GLASS_CTM_PANE = register("lime_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PINK_STAINED_CLEAR_GLASS_CTM_PANE = register("pink_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GRAY_STAINED_CLEAR_GLASS_CTM_PANE = register("gray_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_GRAY_STAINED_CLEAR_GLASS_CTM_PANE = register("light_gray_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CYAN_STAINED_CLEAR_GLASS_CTM_PANE = register("cyan_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PURPLE_STAINED_CLEAR_GLASS_CTM_PANE = register("purple_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLUE_STAINED_CLEAR_GLASS_CTM_PANE = register("blue_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BROWN_STAINED_CLEAR_GLASS_CTM_PANE = register("brown_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GREEN_STAINED_CLEAR_GLASS_CTM_PANE = register("green_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RED_STAINED_CLEAR_GLASS_CTM_PANE = register("red_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLACK_STAINED_CLEAR_GLASS_CTM_PANE = register("black_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));    public static final DeferredBlock<IronBarsBlock> GLASS_OCHRE_FROGLIGHT_PANE = register("glass_ochre_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<IronBarsBlock> GLASS_PEARLESCENT_FROGLIGHT_PANE = register("glass_pearlescent_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<IronBarsBlock> GLASS_VERDANT_FROGLIGHT_PANE = register("glass_verdant_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // --- Chisel pillar blocks (RotatedPillarBlock, end=chiseled_stone, side=stone_chisels/{name}) ---
    public static final Map<String, DeferredBlock<RotatedPillarBlock>> CHISEL_PILLARS = new java.util.LinkedHashMap<>();
    private static final java.util.List<String> CHISEL_PILLAR_NAMES = java.util.List.of(
            "chiseled_stone_bricks_caveat_amethyst", "chiseled_stone_bricks_caveat_copper",
            "chiseled_stone_bricks_caveat_coppere", "chiseled_stone_bricks_caveat_coppero",
            "chiseled_stone_bricks_caveat_copperw", "chiseled_stone_bricks_caveat_diamond",
            "chiseled_stone_bricks_caveat_emerald", "chiseled_stone_bricks_caveat_glowstone",
            "chiseled_stone_bricks_caveat_gold", "chiseled_stone_bricks_caveat_iron",
            "chiseled_stone_bricks_caveat_lapis", "chiseled_stone_bricks_caveat_netherite",
            "chiseled_stone_bricks_caveat_netherite_broken", "chiseled_stone_bricks_caveat_quartz",
            "chiseled_stone_bricks_caveat_redstone_active", "chiseled_stone_bricks_caveat_redstone_inactive",
            "chiseled_stone_bricks_doom", "chiseled_stone_bricks_doom_amethyst",
            "chiseled_stone_bricks_doom_copper", "chiseled_stone_bricks_doom_coppere",
            "chiseled_stone_bricks_doom_coppero", "chiseled_stone_bricks_doom_copperw",
            "chiseled_stone_bricks_doom_diamond", "chiseled_stone_bricks_doom_emerald",
            "chiseled_stone_bricks_doom_glowstone", "chiseled_stone_bricks_doom_gold",
            "chiseled_stone_bricks_doom_iron", "chiseled_stone_bricks_doom_lapis",
            "chiseled_stone_bricks_doom_netherite", "chiseled_stone_bricks_doom_quartz",
            "chiseled_stone_bricks_doom_redstone_active", "chiseled_stone_bricks_doom_redstone_inactive",
            "chiseled_stone_bricks_etch", "chiseled_stone_bricks_etch_amethyst",
            "chiseled_stone_bricks_etch_copper", "chiseled_stone_bricks_etch_coppere",
            "chiseled_stone_bricks_etch_coppero", "chiseled_stone_bricks_etch_copperw",
            "chiseled_stone_bricks_etch_diamond", "chiseled_stone_bricks_etch_emerald",
            "chiseled_stone_bricks_etch_glowstone", "chiseled_stone_bricks_etch_gold",
            "chiseled_stone_bricks_etch_iron", "chiseled_stone_bricks_etch_lapis",
            "chiseled_stone_bricks_etch_redstone_active", "chiseled_stone_bricks_etch_redstone_inactive",
            "chiseled_stone_bricks_etching_netherite", "chiseled_stone_bricks_etching_quartz",
            "chiseled_stone_bricks_frame", "chiseled_stone_bricks_frame_amethyst",
            "chiseled_stone_bricks_frame_copper", "chiseled_stone_bricks_frame_coppere",
            "chiseled_stone_bricks_frame_coppero", "chiseled_stone_bricks_frame_copperw",
            "chiseled_stone_bricks_frame_diamond", "chiseled_stone_bricks_frame_emerald",
            "chiseled_stone_bricks_frame_glowstone", "chiseled_stone_bricks_frame_gold",
            "chiseled_stone_bricks_frame_iron", "chiseled_stone_bricks_frame_lapis",
            "chiseled_stone_bricks_frame_netherite", "chiseled_stone_bricks_frame_quartz",
            "chiseled_stone_bricks_frame_redstone_active", "chiseled_stone_bricks_frame_redstone_inactive",
            "chiseled_stone_bricks_groan", "chiseled_stone_bricks_groan_amethyst",
            "chiseled_stone_bricks_groan_copper", "chiseled_stone_bricks_groan_coppere",
            "chiseled_stone_bricks_groan_coppero", "chiseled_stone_bricks_groan_copperw",
            "chiseled_stone_bricks_groan_diamond", "chiseled_stone_bricks_groan_emerald",
            "chiseled_stone_bricks_groan_glowstone", "chiseled_stone_bricks_groan_gold",
            "chiseled_stone_bricks_groan_iron", "chiseled_stone_bricks_groan_lapis",
            "chiseled_stone_bricks_groan_netherite", "chiseled_stone_bricks_groan_quartz",
            "chiseled_stone_bricks_groan_redstone_active", "chiseled_stone_bricks_groan_redstone_inactive",
            "chiseled_stone_bricks_hieroglyph", "chiseled_stone_bricks_hieroglyph_amethyst",
            "chiseled_stone_bricks_hieroglyph_copper", "chiseled_stone_bricks_hieroglyph_coppere",
            "chiseled_stone_bricks_hieroglyph_coppero", "chiseled_stone_bricks_hieroglyph_copperw",
            "chiseled_stone_bricks_hieroglyph_diamond", "chiseled_stone_bricks_hieroglyph_emerald",
            "chiseled_stone_bricks_hieroglyph_glowstone", "chiseled_stone_bricks_hieroglyph_gold",
            "chiseled_stone_bricks_hieroglyph_iron", "chiseled_stone_bricks_hieroglyph_lapis",
            "chiseled_stone_bricks_hieroglyph_netherite", "chiseled_stone_bricks_hieroglyph_quartz",
            "chiseled_stone_bricks_hieroglyph_redstone_active", "chiseled_stone_bricks_hieroglyph_redstone_inactive",
            "chiseled_stone_bricks_nexus", "chiseled_stone_bricks_nexus_amethyst",
            "chiseled_stone_bricks_nexus_copper", "chiseled_stone_bricks_nexus_coppere",
            "chiseled_stone_bricks_nexus_coppero", "chiseled_stone_bricks_nexus_copperw",
            "chiseled_stone_bricks_nexus_diamond", "chiseled_stone_bricks_nexus_emerald",
            "chiseled_stone_bricks_nexus_glowstone", "chiseled_stone_bricks_nexus_gold",
            "chiseled_stone_bricks_nexus_iron", "chiseled_stone_bricks_nexus_lapis",
            "chiseled_stone_bricks_nexus_quartz",
            "chiseled_stone_bricks_nexus_redstone_active", "chiseled_stone_bricks_nexus_redstone_inactive",
            "chiseled_stone_bricks_skull", "chiseled_stone_bricks_skull_amethyst",
            "chiseled_stone_bricks_skull_copper", "chiseled_stone_bricks_skull_coppere",
            "chiseled_stone_bricks_skull_coppero", "chiseled_stone_bricks_skull_copperw",
            "chiseled_stone_bricks_skull_diamond", "chiseled_stone_bricks_skull_emerald",
            "chiseled_stone_bricks_skull_glowstone", "chiseled_stone_bricks_skull_gold",
            "chiseled_stone_bricks_skull_iron", "chiseled_stone_bricks_skull_lapis",
            "chiseled_stone_bricks_skull_netherite", "chiseled_stone_bricks_skull_quartz",
            "chiseled_stone_bricks_skull_redstone_active", "chiseled_stone_bricks_skull_redstone_inactive",
            "chiseled_stone_bricks_snout", "chiseled_stone_bricks_snout_amethyst",
            "chiseled_stone_bricks_snout_copper", "chiseled_stone_bricks_snout_coppere",
            "chiseled_stone_bricks_snout_coppero", "chiseled_stone_bricks_snout_copperw",
            "chiseled_stone_bricks_snout_diamond", "chiseled_stone_bricks_snout_emerald",
            "chiseled_stone_bricks_snout_glowstone", "chiseled_stone_bricks_snout_gold",
            "chiseled_stone_bricks_snout_iron", "chiseled_stone_bricks_snout_lapis",
            "chiseled_stone_bricks_snout_netherite", "chiseled_stone_bricks_snout_quartz",
            "chiseled_stone_bricks_snout_redstone_active", "chiseled_stone_bricks_snout_redstone_inactive",
            "chiseled_stone_bricks_swirl", "chiseled_stone_bricks_swirl_amethyst",
            "chiseled_stone_bricks_swirl_copper", "chiseled_stone_bricks_swirl_coppere",
            "chiseled_stone_bricks_swirl_coppero", "chiseled_stone_bricks_swirl_copperw",
            "chiseled_stone_bricks_swirl_diamond", "chiseled_stone_bricks_swirl_emerald",
            "chiseled_stone_bricks_swirl_glowstone", "chiseled_stone_bricks_swirl_gold",
            "chiseled_stone_bricks_swirl_iron", "chiseled_stone_bricks_swirl_lapis",
            "chiseled_stone_bricks_swirl_netherite", "chiseled_stone_bricks_swirl_quartz",
            "chiseled_stone_bricks_swirl_redstone_active", "chiseled_stone_bricks_swirl_redstone_inactive"
    );

    static {
        CHISEL_PILLAR_NAMES.forEach(name ->
                CHISEL_PILLARS.put(name, register(name, () -> new RotatedPillarBlock(ST))));
    }

    // --- Legend blocks (HorizontalBlock, directional) ---
    public static final Map<String, DeferredBlock<HorizontalBlock>> CHISEL_LEGEND = new java.util.LinkedHashMap<>();
    private static final java.util.List<String> CHISEL_LEGEND_NAMES = java.util.List.of(
            "chiseled_stone_legend", "chiseled_stone_legend_amethyst", "chiseled_stone_legend_copper",
            "chiseled_stone_legend_coppere", "chiseled_stone_legend_coppero", "chiseled_stone_legend_copperw",
            "chiseled_stone_legend_diamond", "chiseled_stone_legend_emerald", "chiseled_stone_legend_glowstone",
            "chiseled_stone_legend_gold", "chiseled_stone_legend_iron", "chiseled_stone_legend_lapis",
            "chiseled_stone_legend_netherite", "chiseled_stone_legend_quartz",
            "chiseled_stone_legend_redstonea", "chiseled_stone_legend_redstonei"
    );

    static {
        CHISEL_LEGEND_NAMES.forEach(name ->
                CHISEL_LEGEND.put(name, register(name, () -> new HorizontalBlock(ST))));
    }

    public static void register(IEventBus eventBus) {
        registerDynamicBlocks();
        BLOCKS.register(eventBus);
        MINECRAFT_BLOCKS.register(eventBus);
        MINECRAFT_ITEMS.register(eventBus);
        OTT_ITEMS.register(eventBus);
    }

    private static OpalSet registerOpalSet(String name) {
        Properties solid = Properties.of().strength(1.5F).sound(SoundType.AMETHYST).lightLevel(s -> 7).requiresCorrectToolForDrops();
        Properties glass = Properties.of().strength(1.5F).sound(SoundType.AMETHYST).lightLevel(s -> 7).requiresCorrectToolForDrops().noOcclusion();
        Properties cluster = Properties.of().strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).lightLevel(s -> 7).requiresCorrectToolForDrops().noOcclusion();
        return new OpalSet(
                register(name, () -> new Block(solid)),
                register(name + "_crystal_block", () -> new Block(solid)),
                register("budding_" + name, () -> new BuddingAmethystBlock(solid)),
                register(name + "_cluster", () -> new AmethystClusterBlock(7, 3, cluster)),
                register("large_" + name + "_bud", () -> new AmethystClusterBlock(5, 3, cluster)),
                register("medium_" + name + "_bud", () -> new AmethystClusterBlock(4, 3, cluster)),
                register("small_" + name + "_bud", () -> new AmethystClusterBlock(3, 4, cluster)),
                register(name + "_bricks", () -> new Block(solid)),
                register("small_" + name + "_bricks", () -> new Block(solid)),
                register("polished_" + name, () -> new Block(solid)),
                register("chiseled_" + name, () -> new Block(solid)),
                register(name + "_pillar", () -> new RotatedPillarBlock(solid)),
                register("cut_" + name, () -> new Block(solid)),
                register(name + "_tiles", () -> new Block(solid)),
                register("small_" + name + "_tiles", () -> new Block(solid)),
                register(name + "_glass", () -> new Block(glass)),
                register(name + "_glass_pane", () -> new IronBarsBlock(glass)),
                register(name + "_tiling", () -> new GlazedTerracottaBlock(solid))
        );
    }

    @FunctionalInterface
    private interface GradientBlockBuilder<T extends Block & IGradientBlock> {
        T create(Properties properties, DyeColor firstColor, DyeColor secondColor, Function<DyeColor, String> textureNameMapper);
    }
}