package com.otterly76.ott.block;

import com.otterly76.ott.entity.custom.Butterfly;
import com.otterly76.ott.block.custom.*;
import com.otterly76.ott.color.ModPatterns;
import com.otterly76.ott_blocks.particle.OttBlockParticles;
import net.minecraft.world.level.biome.Biome;
import com.otterly76.ott.crop.ThornyHedgeSprouts;
import com.otterly76.ott.hedge.ModHedgeVariants;
import com.otterly76.ott_blocks.sound.OttBlockSounds;
import com.otterly76.ott.util.block.BlockSetTypeVariant;
import com.otterly76.ott.util.block.WoodTypeVariant;
import com.otterly76.ott.util.block.ModSkullType;
import net.minecraft.world.level.block.grower.TreeGrower;
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

    public static final DeferredBlock<CtmPaneBlock> SOUL_GLASS_CTM_PANE = register("soul_glass_ctm_pane",
            () -> new CtmPaneBlock(Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

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
    public static final List<String> DOOR_STYLES = List.of("beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed");
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
    public static final DeferredBlock<Block> GLOW_GOOP = register("glow_goop", () -> new GlowGoopBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).noCollission().noOcclusion().instabreak().lightLevel(GlowGoopBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<com.otterly76.ott.block.custom.SilkCocoonBlock> SILK_COCOON = register("silk_cocoon", () -> new com.otterly76.ott.block.custom.SilkCocoonBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<SaplingBlock> PALE_OAK_SAPLING = registerBackportedBlock("pale_oak_sapling", () -> new SaplingBlock(new TreeGrower("pale_oak", Optional.of(net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.CONFIGURED_FEATURE, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(MOD_ID, "pale_oak_bonemeal"))), Optional.empty(), Optional.empty()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)), false);
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

    public static final DeferredBlock<LeavesBlock> PALE_OAK_LEAVES = registerBackportedBlock("pale_oak_leaves", () -> new ParticleLeavesBlock(50, OttBlockParticles.PALE_OAK_LEAVES, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_GREEN)));

    public static final DeferredBlock<EyeblossomBlock> CLOSED_EYEBLOSSOM = registerBackportedBlock("closed_eyeblossom", () -> new EyeblossomBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final DeferredBlock<EyeblossomBlock> OPEN_EYEBLOSSOM = registerBackportedBlock("open_eyeblossom", () -> new EyeblossomBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_ORANGE).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).lightLevel((state) -> 11).randomTicks()));
    public static final DeferredBlock<FlowerPotBlock> POTTED_CLOSED_EYEBLOSSOM = registerBackportedBlock("potted_closed_eyeblossom", () -> new EyeblossomFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CLOSED_EYEBLOSSOM, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY).randomTicks()), false);
    public static final DeferredBlock<FlowerPotBlock> POTTED_OPEN_EYEBLOSSOM = registerBackportedBlock("potted_open_eyeblossom", () -> new EyeblossomFlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, OPEN_EYEBLOSSOM, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY).lightLevel((state) -> 11).randomTicks()), false);

    public static final DeferredBlock<CreakingHeartBlock> CREAKING_HEART = registerBackportedBlock("creaking_heart", () -> new CreakingHeartBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(10.0F).sound(OttBlockSounds.CREAKING_HEART).lightLevel(state -> state.getValue(com.otterly76.ott.registry.ModBlockStateProperties.CREAKING_HEART_STATE) == com.otterly76.ott.util.block.CreakingHeartState.AWAKE ? 15 : 0)));
    public static final DeferredBlock<ResinClumpBlock> RESIN_CLUMP = registerBackportedBlock("resin_clump", () -> new ResinClumpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK_VEIN).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN)));
    public static final DeferredBlock<Block> RESIN_BLOCK = registerBackportedBlock("resin_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN)));
    public static final DeferredBlock<Block> RESIN_BRICKS = registerBackportedBlock("resin_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN_BRICKS)));
    public static final DeferredBlock<StairBlock> RESIN_BRICK_STAIRS = registerBackportedBlock("resin_brick_stairs", () -> new StairBlock(RESIN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_STAIRS).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN_BRICKS)));
    public static final DeferredBlock<SlabBlock> RESIN_BRICK_SLAB = registerBackportedBlock("resin_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN_BRICKS)));
    public static final DeferredBlock<WallBlock> RESIN_BRICK_WALL = registerBackportedBlock("resin_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_WALL).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN_BRICKS)));
    public static final DeferredBlock<Block> CHISELED_RESIN_BRICKS = registerBackportedBlock("chiseled_resin_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).mapColor(MapColor.COLOR_ORANGE).sound(OttBlockSounds.RESIN_BRICKS)));

    public static final DeferredBlock<DriedGhastBlock> DRIED_GHAST = registerBackportedBlock("dried_ghast", () -> new DriedGhastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instabreak().sound(OttBlockSounds.DRIED_GHAST).noOcclusion().randomTicks()));
    public static final DeferredBlock<ActualBushBlock> BUSH = registerBackportedBlock("bush", () -> new ActualBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FireflyBushBlock> FIREFLY_BUSH = registerBackportedBlock("firefly_bush", () -> new FireflyBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).ignitedByLava().lightLevel((state) -> 2).noCollission().instabreak().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WILDFLOWERS = registerBackportedBlock("wildflowers", () -> new com.otterly76.ott.block.custom.WildflowersBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PALE_WILDFLOWERS = BLOCKS.register("pale_wildflowers", () -> new com.otterly76.ott.block.custom.WildflowersBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<LeafLitterBlock> LEAF_LITTER = registerBackportedBlock("leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).replaceable().noCollission().sound(OttBlockSounds.LEAF_LITTER).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<CactusFlowerBlock> CACTUS_FLOWER = registerBackportedBlock("cactus_flower", () -> new CactusFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().ignitedByLava().sound(OttBlockSounds.CACTUS_FLOWER).pushReaction(PushReaction.DESTROY)));
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
    public static final DeferredBlock<Block> COPPER_TORCH = registerBackportedBlock("copper_torch", () -> new CopperTorchBlock(OttBlockParticles.COPPER_FIRE_FLAME, BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(s -> 14).sound(SoundType.WOOD)), false);
    public static final DeferredBlock<Block> COPPER_WALL_TORCH = registerBackportedBlock("copper_wall_torch", () -> new CopperWallTorchBlock(OttBlockParticles.COPPER_FIRE_FLAME, BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(s -> 14).sound(SoundType.WOOD).lootFrom(COPPER_TORCH)), false);
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
        for (String name : List.of(
                "acacia_bookshelf", "ancient_cubed_oak_bookshelf", "ancient_oak_bookshelf",
                "ancient_oak_large_bookshelf", "ancient_vertical_oak_bookshelf", "bamboo_bookshelf",
                "birch_bookshelf", "botanical_oak_bookshelf", "botanical_oak_cubed_bookshelf",
                "botanical_oak_large_bookshelf", "cherry_bookshelf", "crimson_bookshelf",
                "cubed_oak_bookshelf", "cubed_oak_empty_bookshelf", "cubed_oak_spaced_bookshelf",
                "cubed_oak_webbed_bookshelf", "curvy_bookshelf", "dark_oak_bookshelf",
                "dusty_bookshelf", "full_bookshelf", "historical_oak_bookshelf",
                "historical_oak_large_bookshelf", "jungle_bookshelf", "mangrove_bookshelf",
                "mixed_cubed_oak_bookshelf", "mixed_oak_bookshelf", "mixed_oak_large_bookshelf",
                "oak_bookshelf", "oak_empty_bookshelf", "oak_large_bookshelf",
                "oak_lighted_bookshelf", "oak_lighted_large_bookshelf", "oak_spaced_bookshelf",
                "oak_spaced_large_bookshelf", "oak_webbed_bookshelf", "oak_webbed_large_bookshelf",
                "spruce_bookshelf", "vertical_botanical_oak_bookshelf", "vertical_mixed_oak_bookshelf",
                "vertical_oak_bookshelf", "vertical_oak_lighted_bookshelf", "vertical_oak_webbed_bookshelf",
                "warped_bookshelf"
        )) {
            BOOKSHELVES.put(name, registerBookshelf(name));
        }

        // Per-wood style lists (must exactly match available texture files)
        WOOD_DOOR_STYLES.put("oak", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed"));
        WOOD_DOOR_STYLES.put("spruce", List.of("barred", "beach", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed"));
        WOOD_DOOR_STYLES.put("birch", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed"));
        WOOD_DOOR_STYLES.put("jungle", List.of("barred", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed"));
        WOOD_DOOR_STYLES.put("acacia", DOOR_STYLES);
        WOOD_DOOR_STYLES.put("dark_oak", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed"));
        WOOD_DOOR_STYLES.put("mangrove", List.of("barred", "beach", "boarded", "cut", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "reinforced", "secret", "sliding", "supported", "tile_windowed", "windowed"));
        WOOD_DOOR_STYLES.put("cherry", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled"));
        WOOD_DOOR_STYLES.put("bamboo", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled"));
        WOOD_DOOR_STYLES.put("crimson", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "tile_windowed", "tiled", "windowed"));
        WOOD_DOOR_STYLES.put("warped", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed"));

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
        // ===== RECOVERED TRAPDOORS =====
        WOOD_TRAPDOORS.put("airy_birch_trapdoor", registerTrapdoor("airy_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_crimson_trapdoor", registerTrapdoor("airy_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_dark_oak_trapdoor", registerTrapdoor("airy_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_jungle_trapdoor", registerTrapdoor("airy_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_mangrove_trapdoor", registerTrapdoor("airy_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_oak_trapdoor", registerTrapdoor("airy_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_spruce_trapdoor", registerTrapdoor("airy_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("airy_warped_trapdoor", registerTrapdoor("airy_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_acacia_trapdoor", registerTrapdoor("barred_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_bamboo_trapdoor", registerTrapdoor("barred_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_birch_trapdoor", registerTrapdoor("barred_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_cherry_trapdoor", registerTrapdoor("barred_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_crimson_trapdoor", registerTrapdoor("barred_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_dark_oak_trapdoor", registerTrapdoor("barred_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_jungle_trapdoor", registerTrapdoor("barred_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_mangrove_trapdoor", registerTrapdoor("barred_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_oak_trapdoor", registerTrapdoor("barred_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_spruce_trapdoor", registerTrapdoor("barred_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("barred_warped_trapdoor", registerTrapdoor("barred_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_acacia_trapdoor", registerTrapdoor("checkered_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_bamboo_trapdoor", registerTrapdoor("checkered_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_birch_trapdoor", registerTrapdoor("checkered_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_cherry_trapdoor", registerTrapdoor("checkered_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_crimson_trapdoor", registerTrapdoor("checkered_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_dark_oak_trapdoor", registerTrapdoor("checkered_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_jungle_trapdoor", registerTrapdoor("checkered_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_mangrove_trapdoor", registerTrapdoor("checkered_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_oak_trapdoor", registerTrapdoor("checkered_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_spruce_trapdoor", registerTrapdoor("checkered_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("checkered_warped_trapdoor", registerTrapdoor("checkered_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_acacia_trapdoor", registerTrapdoor("classic_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_bamboo_trapdoor", registerTrapdoor("classic_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_birch_trapdoor", registerTrapdoor("classic_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_cherry_trapdoor", registerTrapdoor("classic_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_crimson_trapdoor", registerTrapdoor("classic_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_dark_oak_trapdoor", registerTrapdoor("classic_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_jungle_trapdoor", registerTrapdoor("classic_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_mangrove_trapdoor", registerTrapdoor("classic_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_spruce_trapdoor", registerTrapdoor("classic_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_warped_trapdoor", registerTrapdoor("classic_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_acacia_trapdoor", registerTrapdoor("classic_windowed_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_bamboo_trapdoor", registerTrapdoor("classic_windowed_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_birch_trapdoor", registerTrapdoor("classic_windowed_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_cherry_trapdoor", registerTrapdoor("classic_windowed_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_crimson_trapdoor", registerTrapdoor("classic_windowed_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_dark_oak_trapdoor", registerTrapdoor("classic_windowed_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_jungle_trapdoor", registerTrapdoor("classic_windowed_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_mangrove_trapdoor", registerTrapdoor("classic_windowed_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_oak_trapdoor", registerTrapdoor("classic_windowed_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_spruce_trapdoor", registerTrapdoor("classic_windowed_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("classic_windowed_warped_trapdoor", registerTrapdoor("classic_windowed_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_acacia_trapdoor", registerTrapdoor("cobweb_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_bamboo_trapdoor", registerTrapdoor("cobweb_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_birch_trapdoor", registerTrapdoor("cobweb_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_cherry_trapdoor", registerTrapdoor("cobweb_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_crimson_trapdoor", registerTrapdoor("cobweb_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_dark_oak_trapdoor", registerTrapdoor("cobweb_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_jungle_trapdoor", registerTrapdoor("cobweb_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_mangrove_trapdoor", registerTrapdoor("cobweb_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_oak_trapdoor", registerTrapdoor("cobweb_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_spruce_trapdoor", registerTrapdoor("cobweb_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("cobweb_warped_trapdoor", registerTrapdoor("cobweb_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_acacia_trapdoor", registerTrapdoor("distorted_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_bamboo_trapdoor", registerTrapdoor("distorted_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_birch_trapdoor", registerTrapdoor("distorted_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_cherry_trapdoor", registerTrapdoor("distorted_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_crimson_trapdoor", registerTrapdoor("distorted_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_dark_oak_trapdoor", registerTrapdoor("distorted_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_jungle_trapdoor", registerTrapdoor("distorted_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_oak_trapdoor", registerTrapdoor("distorted_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("distorted_spruce_trapdoor", registerTrapdoor("distorted_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_acacia_trapdoor", registerTrapdoor("fancy_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_bamboo_trapdoor", registerTrapdoor("fancy_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_birch_trapdoor", registerTrapdoor("fancy_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_cherry_trapdoor", registerTrapdoor("fancy_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_crimson_trapdoor", registerTrapdoor("fancy_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_dark_oak_trapdoor", registerTrapdoor("fancy_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_oak_trapdoor", registerTrapdoor("fancy_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("fancy_spruce_trapdoor", registerTrapdoor("fancy_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_acacia_trapdoor", registerTrapdoor("golden_barred_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_bamboo_trapdoor", registerTrapdoor("golden_barred_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_birch_trapdoor", registerTrapdoor("golden_barred_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_cherry_trapdoor", registerTrapdoor("golden_barred_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_crimson_trapdoor", registerTrapdoor("golden_barred_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_dark_oak_trapdoor", registerTrapdoor("golden_barred_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_jungle_trapdoor", registerTrapdoor("golden_barred_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_mangrove_trapdoor", registerTrapdoor("golden_barred_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_oak_trapdoor", registerTrapdoor("golden_barred_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_spruce_trapdoor", registerTrapdoor("golden_barred_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("golden_barred_warped_trapdoor", registerTrapdoor("golden_barred_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_acacia_trapdoor", registerTrapdoor("heavy_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_bamboo_trapdoor", registerTrapdoor("heavy_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_birch_trapdoor", registerTrapdoor("heavy_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_cherry_trapdoor", registerTrapdoor("heavy_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_crimson_trapdoor", registerTrapdoor("heavy_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_dark_oak_trapdoor", registerTrapdoor("heavy_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_jungle_trapdoor", registerTrapdoor("heavy_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_mangrove_trapdoor", registerTrapdoor("heavy_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_oak_trapdoor", registerTrapdoor("heavy_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("heavy_warped_trapdoor", registerTrapdoor("heavy_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_acacia_trapdoor", registerTrapdoor("iron_barred_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_bamboo_trapdoor", registerTrapdoor("iron_barred_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_birch_trapdoor", registerTrapdoor("iron_barred_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_cherry_trapdoor", registerTrapdoor("iron_barred_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_crimson_trapdoor", registerTrapdoor("iron_barred_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_dark_oak_trapdoor", registerTrapdoor("iron_barred_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_jungle_trapdoor", registerTrapdoor("iron_barred_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_mangrove_trapdoor", registerTrapdoor("iron_barred_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_oak_trapdoor", registerTrapdoor("iron_barred_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_spruce_trapdoor", registerTrapdoor("iron_barred_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("iron_barred_warped_trapdoor", registerTrapdoor("iron_barred_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_acacia_trapdoor", registerTrapdoor("leafy_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_bamboo_trapdoor", registerTrapdoor("leafy_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_birch_trapdoor", registerTrapdoor("leafy_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_cherry_trapdoor", registerTrapdoor("leafy_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_crimson_trapdoor", registerTrapdoor("leafy_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_dark_oak_trapdoor", registerTrapdoor("leafy_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_jungle_trapdoor", registerTrapdoor("leafy_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_mangrove_trapdoor", registerTrapdoor("leafy_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_oak_trapdoor", registerTrapdoor("leafy_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_spruce_trapdoor", registerTrapdoor("leafy_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("leafy_warped_trapdoor", registerTrapdoor("leafy_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("mangrove_mangrove_trapdoor", registerTrapdoor("mangrove_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_acacia_trapdoor", registerTrapdoor("meshed_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_bamboo_trapdoor", registerTrapdoor("meshed_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_birch_trapdoor", registerTrapdoor("meshed_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_cherry_trapdoor", registerTrapdoor("meshed_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_crimson_trapdoor", registerTrapdoor("meshed_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_dark_oak_trapdoor", registerTrapdoor("meshed_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_jungle_trapdoor", registerTrapdoor("meshed_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_mangrove_trapdoor", registerTrapdoor("meshed_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_oak_trapdoor", registerTrapdoor("meshed_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_spruce_trapdoor", registerTrapdoor("meshed_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("meshed_warped_trapdoor", registerTrapdoor("meshed_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_acacia_trapdoor", registerTrapdoor("overgrown_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_bamboo_trapdoor", registerTrapdoor("overgrown_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_birch_trapdoor", registerTrapdoor("overgrown_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_cherry_trapdoor", registerTrapdoor("overgrown_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_crimson_trapdoor", registerTrapdoor("overgrown_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_dark_oak_trapdoor", registerTrapdoor("overgrown_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_jungle_trapdoor", registerTrapdoor("overgrown_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_mangrove_trapdoor", registerTrapdoor("overgrown_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_oak_trapdoor", registerTrapdoor("overgrown_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_spruce_trapdoor", registerTrapdoor("overgrown_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("overgrown_warped_trapdoor", registerTrapdoor("overgrown_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_acacia_trapdoor", registerTrapdoor("pointless_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_bamboo_trapdoor", registerTrapdoor("pointless_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_birch_trapdoor", registerTrapdoor("pointless_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_cherry_trapdoor", registerTrapdoor("pointless_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_crimson_trapdoor", registerTrapdoor("pointless_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_dark_oak_trapdoor", registerTrapdoor("pointless_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_jungle_trapdoor", registerTrapdoor("pointless_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_mangrove_trapdoor", registerTrapdoor("pointless_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_oak_trapdoor", registerTrapdoor("pointless_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_spruce_trapdoor", registerTrapdoor("pointless_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("pointless_warped_trapdoor", registerTrapdoor("pointless_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_acacia_trapdoor", registerTrapdoor("screened_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_bamboo_trapdoor", registerTrapdoor("screened_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_cherry_trapdoor", registerTrapdoor("screened_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_crimson_trapdoor", registerTrapdoor("screened_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_dark_oak_trapdoor", registerTrapdoor("screened_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_jungle_trapdoor", registerTrapdoor("screened_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_mangrove_trapdoor", registerTrapdoor("screened_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_oak_trapdoor", registerTrapdoor("screened_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_spruce_trapdoor", registerTrapdoor("screened_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("screened_warped_trapdoor", registerTrapdoor("screened_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_acacia_trapdoor", registerTrapdoor("slotted_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_bamboo_trapdoor", registerTrapdoor("slotted_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_birch_trapdoor", registerTrapdoor("slotted_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_cherry_trapdoor", registerTrapdoor("slotted_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_crimson_trapdoor", registerTrapdoor("slotted_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_dark_oak_trapdoor", registerTrapdoor("slotted_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_jungle_trapdoor", registerTrapdoor("slotted_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_mangrove_trapdoor", registerTrapdoor("slotted_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_oak_trapdoor", registerTrapdoor("slotted_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_spruce_trapdoor", registerTrapdoor("slotted_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("slotted_warped_trapdoor", registerTrapdoor("slotted_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_acacia_trapdoor", registerTrapdoor("solid_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_bamboo_trapdoor", registerTrapdoor("solid_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_birch_trapdoor", registerTrapdoor("solid_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_cherry_trapdoor", registerTrapdoor("solid_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_crimson_trapdoor", registerTrapdoor("solid_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_dark_oak_trapdoor", registerTrapdoor("solid_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_jungle_trapdoor", registerTrapdoor("solid_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_mangrove_trapdoor", registerTrapdoor("solid_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_oak_trapdoor", registerTrapdoor("solid_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_spruce_trapdoor", registerTrapdoor("solid_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("solid_warped_trapdoor", registerTrapdoor("solid_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_acacia_trapdoor", registerTrapdoor("suspicious_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_bamboo_trapdoor", registerTrapdoor("suspicious_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_birch_trapdoor", registerTrapdoor("suspicious_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_cherry_trapdoor", registerTrapdoor("suspicious_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_dark_oak_trapdoor", registerTrapdoor("suspicious_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_jungle_trapdoor", registerTrapdoor("suspicious_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_mangrove_trapdoor", registerTrapdoor("suspicious_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_oak_trapdoor", registerTrapdoor("suspicious_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_spruce_trapdoor", registerTrapdoor("suspicious_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("suspicious_warped_trapdoor", registerTrapdoor("suspicious_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_acacia_trapdoor", registerTrapdoor("twisted_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_bamboo_trapdoor", registerTrapdoor("twisted_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_birch_trapdoor", registerTrapdoor("twisted_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_cherry_trapdoor", registerTrapdoor("twisted_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_crimson_trapdoor", registerTrapdoor("twisted_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_dark_oak_trapdoor", registerTrapdoor("twisted_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_jungle_trapdoor", registerTrapdoor("twisted_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_mangrove_trapdoor", registerTrapdoor("twisted_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_oak_trapdoor", registerTrapdoor("twisted_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_spruce_trapdoor", registerTrapdoor("twisted_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("twisted_warped_trapdoor", registerTrapdoor("twisted_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_acacia_trapdoor", registerTrapdoor("vined_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_bamboo_trapdoor", registerTrapdoor("vined_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_birch_trapdoor", registerTrapdoor("vined_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_cherry_trapdoor", registerTrapdoor("vined_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_crimson_trapdoor", registerTrapdoor("vined_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_dark_oak_trapdoor", registerTrapdoor("vined_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_jungle_trapdoor", registerTrapdoor("vined_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_mangrove_trapdoor", registerTrapdoor("vined_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_oak_trapdoor", registerTrapdoor("vined_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_spruce_trapdoor", registerTrapdoor("vined_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("vined_warped_trapdoor", registerTrapdoor("vined_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warped_warped_trapdoor", registerTrapdoor("warped_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_acacia_trapdoor", registerTrapdoor("warted_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_bamboo_trapdoor", registerTrapdoor("warted_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_birch_trapdoor", registerTrapdoor("warted_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_cherry_trapdoor", registerTrapdoor("warted_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_crimson_trapdoor", registerTrapdoor("warted_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_dark_oak_trapdoor", registerTrapdoor("warted_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_jungle_trapdoor", registerTrapdoor("warted_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_mangrove_trapdoor", registerTrapdoor("warted_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_oak_trapdoor", registerTrapdoor("warted_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_spruce_trapdoor", registerTrapdoor("warted_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("warted_warped_trapdoor", registerTrapdoor("warted_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_acacia_trapdoor", registerTrapdoor("windowed_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_bamboo_trapdoor", registerTrapdoor("windowed_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_birch_trapdoor", registerTrapdoor("windowed_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_cherry_trapdoor", registerTrapdoor("windowed_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_crimson_trapdoor", registerTrapdoor("windowed_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_dark_oak_trapdoor", registerTrapdoor("windowed_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_jungle_trapdoor", registerTrapdoor("windowed_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_mangrove_trapdoor", registerTrapdoor("windowed_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_oak_trapdoor", registerTrapdoor("windowed_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_spruce_trapdoor", registerTrapdoor("windowed_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("windowed_warped_trapdoor", registerTrapdoor("windowed_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_acacia_trapdoor", registerTrapdoor("woven_acacia_trapdoor", BlockSetType.ACACIA, Blocks.ACACIA_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_bamboo_trapdoor", registerTrapdoor("woven_bamboo_trapdoor", BlockSetType.BAMBOO, Blocks.BAMBOO_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_birch_trapdoor", registerTrapdoor("woven_birch_trapdoor", BlockSetType.BIRCH, Blocks.BIRCH_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_cherry_trapdoor", registerTrapdoor("woven_cherry_trapdoor", BlockSetType.CHERRY, Blocks.CHERRY_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_crimson_trapdoor", registerTrapdoor("woven_crimson_trapdoor", BlockSetType.CRIMSON, Blocks.CRIMSON_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_dark_oak_trapdoor", registerTrapdoor("woven_dark_oak_trapdoor", BlockSetType.DARK_OAK, Blocks.DARK_OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_jungle_trapdoor", registerTrapdoor("woven_jungle_trapdoor", BlockSetType.JUNGLE, Blocks.JUNGLE_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_mangrove_trapdoor", registerTrapdoor("woven_mangrove_trapdoor", BlockSetType.MANGROVE, Blocks.MANGROVE_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_oak_trapdoor", registerTrapdoor("woven_oak_trapdoor", BlockSetType.OAK, Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_spruce_trapdoor", registerTrapdoor("woven_spruce_trapdoor", BlockSetType.SPRUCE, Blocks.SPRUCE_TRAPDOOR));
        WOOD_TRAPDOORS.put("woven_warped_trapdoor", registerTrapdoor("woven_warped_trapdoor", BlockSetType.WARPED, Blocks.WARPED_TRAPDOOR));

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
    public static final DeferredBlock<EdgeBlock> LIMESTONE_MASONRY_EDGE = register("limestone_masonry_edge",
            () -> new EdgeBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<PlateBlock> LIMESTONE_MASONRY_PLATE = register("limestone_masonry_plate",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Marble (Roman) ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<TileBlock> BLACK_MARBLE_FLOOR_TILE = register("black_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<TileBlock> WHITE_MARBLE_FLOOR_TILE = register("white_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> WHITE_MARBLE_FANCY_FENCE = register("white_marble_fancy_fence",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    public static final DeferredBlock<PlateBlock> BLACK_MARBLE_FANCY_FENCE = register("black_marble_fancy_fence",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));

    // ── Amethyst Marble ──
    public static final DeferredBlock<TileBlock> AMETHYST_MARBLE_FLOOR_TILE = register("amethyst_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> AMETHYST_MARBLE_FANCY_FENCE = register("amethyst_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Blue Marble ──
    public static final DeferredBlock<TileBlock> BLUE_MARBLE_FLOOR_TILE = register("blue_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> BLUE_MARBLE_FANCY_FENCE = register("blue_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Cyan Marble ──
    public static final DeferredBlock<TileBlock> CYAN_MARBLE_FLOOR_TILE = register("cyan_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> CYAN_MARBLE_FANCY_FENCE = register("cyan_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Green Marble ──
    public static final DeferredBlock<TileBlock> GREEN_MARBLE_FLOOR_TILE = register("green_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> GREEN_MARBLE_FANCY_FENCE = register("green_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Lime Marble ──
    public static final DeferredBlock<TileBlock> LIME_MARBLE_FLOOR_TILE = register("lime_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> LIME_MARBLE_FANCY_FENCE = register("lime_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Orange Marble ──
    public static final DeferredBlock<TileBlock> ORANGE_MARBLE_FLOOR_TILE = register("orange_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> ORANGE_MARBLE_FANCY_FENCE = register("orange_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Pink Marble ──
    public static final DeferredBlock<TileBlock> PINK_MARBLE_FLOOR_TILE = register("pink_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> PINK_MARBLE_FANCY_FENCE = register("pink_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Purple Marble ──
    public static final DeferredBlock<TileBlock> PURPLE_MARBLE_FLOOR_TILE = register("purple_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> PURPLE_MARBLE_FANCY_FENCE = register("purple_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Red Marble ──
    public static final DeferredBlock<TileBlock> RED_MARBLE_FLOOR_TILE = register("red_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> RED_MARBLE_FANCY_FENCE = register("red_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Yellow Marble ──
    public static final DeferredBlock<TileBlock> YELLOW_MARBLE_FLOOR_TILE = register("yellow_marble_floor_tile", () -> new TileBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<PlateBlock> YELLOW_MARBLE_FANCY_FENCE = register("yellow_marble_fancy_fence", () -> new PlateBlock(Properties.ofFullCopy(Blocks.STONE).strength(3.0f, 5.0f).noOcclusion()));
    // ── Diamond Pavers (10 new colors) ──

    public static final DeferredBlock<PlateBlock> SANDSTONE_CRENELATION = register("sandstone_crenelation",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));


    public static final DeferredBlock<EdgeBlock> WHEAT_THATCH_EDGE = register("wheat_thatch_edge",
            () -> new EdgeBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<PlateBlock> WHEAT_THATCH_PLATE = register("wheat_thatch_plate",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<EdgeBlock> BAMBOO_THATCH_EDGE = register("bamboo_thatch_edge",
            () -> new EdgeBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<PlateBlock> BAMBOO_THATCH_PLATE = register("bamboo_thatch_plate",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));

    public static final DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> STONE_BRICKS_MASONRY_EDGE = register("stone_bricks_masonry_edge", () -> new com.otterly76.ott.block.custom.EdgeBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> STONE_BRICKS_MASONRY_PLATE = register("stone_bricks_masonry_plate", () -> new com.otterly76.ott.block.custom.PlateBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RakedGravelBlock> CURVED_RAKED_GRAVEL = register("curved_raked_gravel", () -> new RakedGravelBlock(true, Properties.ofFullCopy(Blocks.GRAVEL)));
    public static final DeferredBlock<RakedGravelBlock> STRAIGHT_RAKED_GRAVEL = register("straight_raked_gravel", () -> new RakedGravelBlock(false, Properties.ofFullCopy(Blocks.GRAVEL)));


    public static final DeferredBlock<CarpetBlock> ORNAMENTED_RED_CARPET = register("ornamented_red_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_RED_CARPET = register("delicate_red_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> ORNAMENTED_BLUE_CARPET = register("ornamented_blue_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_BLUE_CARPET = register("delicate_blue_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> ORNAMENTED_GREEN_CARPET = register("ornamented_green_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<CarpetBlock> DELICATE_GREEN_CARPET = register("delicate_green_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL)));
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

    // CTM vertical pillars

    // --- New plain cube_all stone blocks ---

    // --- New RotatedPillarBlock stone blocks ---

    // --- New RotatedPillarBlocks ---

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
    // ── Bamboo Windows CTM ──
    // ── Cherry Windows CTM ──

    // ── Plain window blocks (cube_column) ──────────────────────────────────────────
    // ── Bamboo Windows ──
    // ── Cherry Windows ──

    // ── Glass/ plain blocks ───────────────────────────────────────────────────────

    // ── Pane blocks ───────────────────────────────────────────────────────────────
    // ── Bamboo Window Panes ──
    // ── Cherry Window Panes ──
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

    // ===== RECOVERED WINDOW BLOCKS =====
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_COVERED_CTM_PANE = register("acacia_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_DIAGONAL_CTM_PANE = register("acacia_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_LARGE_CTM_PANE = register("acacia_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_PANES_CTM_PANE = register("acacia_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_ROUNDED_CTM_PANE = register("acacia_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_SLIM_CTM_PANE = register("acacia_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_SWIRLING_CTM_PANE = register("acacia_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_TILES_CTM_PANE = register("acacia_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_BARS_CTM_PANE = register("birch_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_DIAGONAL_CTM_PANE = register("birch_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_LARGE_CTM_PANE = register("birch_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_PANES_CTM_PANE = register("birch_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_ROUNDED_CTM_PANE = register("birch_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_SLIM_CTM_PANE = register("birch_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_SWIRLING_CTM_PANE = register("birch_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_TILES_CTM_PANE = register("birch_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_BARS_CTM_PANE = register("crimson_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_COVERED_CTM_PANE = register("crimson_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_LARGE_CTM_PANE = register("crimson_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_PANES_CTM_PANE = register("crimson_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_ROUNDED_CTM_PANE = register("crimson_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_SLIM_CTM_PANE = register("crimson_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_SWIRLING_CTM_PANE = register("crimson_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_TILES_CTM_PANE = register("crimson_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_BARS_CTM_PANE = register("dark_oak_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_COVERED_CTM_PANE = register("dark_oak_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_DIAGONAL_CTM_PANE = register("dark_oak_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_LARGE_CTM_PANE = register("dark_oak_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_PANES_CTM_PANE = register("dark_oak_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_ROUNDED_CTM_PANE = register("dark_oak_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_SLIM_CTM_PANE = register("dark_oak_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_SWIRLING_CTM_PANE = register("dark_oak_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_TILES_CTM_PANE = register("dark_oak_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_BARS_CTM_PANE = register("jungle_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_COVERED_CTM_PANE = register("jungle_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_DIAGONAL_CTM_PANE = register("jungle_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_LARGE_CTM_PANE = register("jungle_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_PANES_CTM_PANE = register("jungle_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_ROUNDED_CTM_PANE = register("jungle_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_SWIRLING_CTM_PANE = register("jungle_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_TILES_CTM_PANE = register("jungle_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_BARS_CTM_PANE = register("mangrove_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_COVERED_CTM_PANE = register("mangrove_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_DIAGONAL_CTM_PANE = register("mangrove_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_LARGE_CTM_PANE = register("mangrove_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_PANES_CTM_PANE = register("mangrove_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_SLIM_CTM_PANE = register("mangrove_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_SWIRLING_CTM_PANE = register("mangrove_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_TILES_CTM_PANE = register("mangrove_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_BARS_CTM_PANE = register("oak_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_COVERED_CTM_PANE = register("oak_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_DIAGONAL_CTM_PANE = register("oak_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_LARGE_CTM_PANE = register("oak_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_ROUNDED_CTM_PANE = register("oak_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_SLIM_CTM_PANE = register("oak_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_SWIRLING_CTM_PANE = register("oak_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_TILES_CTM_PANE = register("oak_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_BARS_CTM_PANE = register("spruce_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_COVERED_CTM_PANE = register("spruce_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_DIAGONAL_CTM_PANE = register("spruce_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_LARGE_CTM_PANE = register("spruce_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_PANES_CTM_PANE = register("spruce_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_ROUNDED_CTM_PANE = register("spruce_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_SLIM_CTM_PANE = register("spruce_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_TILES_CTM_PANE = register("spruce_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_BARS_CTM_PANE = register("warped_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_COVERED_CTM_PANE = register("warped_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_DIAGONAL_CTM_PANE = register("warped_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_LARGE_CTM_PANE = register("warped_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_PANES_CTM_PANE = register("warped_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_ROUNDED_CTM_PANE = register("warped_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_SLIM_CTM_PANE = register("warped_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_TILES_CTM_PANE = register("warped_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));


    // ===== RECOVERED GRANITE =====
    public static final DeferredBlock<Block> BORDERED_GRANITE =
            register("bordered_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_GRANITE =
            register("brick_bordered_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CURLY_GRANITE_CTM =
            register("curly_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CUT_GRANITE_COLUMN =
            register("cut_granite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> EDGED_GRANITE_BRICKS =
            register("edged_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> FINE_GRANITE_CTM =
            register("fine_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> GRANITE_PRISMARINE =
            register("granite_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> MASSIVE_GRANITE_BRICKS =
            register("massive_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> ORNATE_GRANITE_CTM =
            register("ornate_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> OVERLAPPING_GRANITE_TILES =
            register("overlapping_granite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> SIMPLE_GRANITE_CTM =
            register("simple_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> SMOOTH_GRANITE_COLUMN =
            register("smooth_granite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_GRANITE =
            register("thick_inlayed_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_GRANITE =
            register("tiled_bordered_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> TILED_GRANITE_COLUMN =
            register("tiled_granite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_GRANITE =
            register("tiny_brick_bordered_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));


    // ===== RECOVERED WAVE1 =====
    public static final DeferredBlock<Block> ACACIA_PLANKS_PANEL =
            register("acacia_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_BARS_CTM_PANE = register("acacia_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<LeavesBlock> APPLE_ACACIA_LEAVES =
            register("apple_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> APPLE_BIRCH_LEAVES =
            register("apple_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> APPLE_DARK_OAK_LEAVES =
            register("apple_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> APPLE_JUNGLE_LEAVES =
            register("apple_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> APPLE_OAK_LEAVES =
            register("apple_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> APPLE_SPRUCE_LEAVES =
            register("apple_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> ARCHED_BLACK_STAINED_GLASS_CTM =
            register("arched_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_BLACK_STAINED_GLASS_CTM_PANE = register("arched_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_BLUE_STAINED_GLASS_CTM =
            register("arched_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_BLUE_STAINED_GLASS_CTM_PANE = register("arched_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_BROWN_STAINED_GLASS_CTM =
            register("arched_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_BROWN_STAINED_GLASS_CTM_PANE = register("arched_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_CYAN_STAINED_GLASS_CTM =
            register("arched_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_CYAN_STAINED_GLASS_CTM_PANE = register("arched_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_GRAY_STAINED_GLASS_CTM =
            register("arched_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_GRAY_STAINED_GLASS_CTM_PANE = register("arched_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_GREEN_STAINED_GLASS_CTM =
            register("arched_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_GREEN_STAINED_GLASS_CTM_PANE = register("arched_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_LEADED_GLASS_CTM =
            register("arched_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LEADED_GLASS_CTM_PANE = register("arched_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM =
            register("arched_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("arched_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM =
            register("arched_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("arched_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_LIME_STAINED_GLASS_CTM =
            register("arched_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LIME_STAINED_GLASS_CTM_PANE = register("arched_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_MAGENTA_STAINED_GLASS_CTM =
            register("arched_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_MAGENTA_STAINED_GLASS_CTM_PANE = register("arched_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_ORANGE_STAINED_GLASS_CTM =
            register("arched_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_ORANGE_STAINED_GLASS_CTM_PANE = register("arched_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_PINK_STAINED_GLASS_CTM =
            register("arched_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_PINK_STAINED_GLASS_CTM_PANE = register("arched_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_PURPLE_STAINED_GLASS_CTM =
            register("arched_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_PURPLE_STAINED_GLASS_CTM_PANE = register("arched_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_RED_STAINED_GLASS_CTM =
            register("arched_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_RED_STAINED_GLASS_CTM_PANE = register("arched_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_WHITE_STAINED_GLASS_CTM =
            register("arched_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_WHITE_STAINED_GLASS_CTM_PANE = register("arched_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ARCHED_YELLOW_STAINED_GLASS_CTM =
            register("arched_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ARCHED_YELLOW_STAINED_GLASS_CTM_PANE = register("arched_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_PANEL =
            register("bamboo_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_PANEL =
            register("birch_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_COVERED_CTM_PANE = register("birch_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BLACK_CONCRETE_CTM =
            register("black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_CONCRETE_PANEL =
            register("black_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_COLUMN =
            register("black_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_CTM =
            register("black_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_CTM =
            register("blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_PANEL =
            register("blue_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_COLUMN =
            register("blue_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_CTM =
            register("blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> BORDERED_AMETHYST_BLOCK =
            register("bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_ANCIENT_DEBRIS =
            register("bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> BORDERED_BASALT =
            register("bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> BORDERED_BLACKSTONE =
            register("bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> BORDERED_BLUE_ICE =
            register("bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));


    // ===== RECOVERED WAVE2 =====
    public static final DeferredBlock<Block> BORDERED_BORDERLESS_BRICKS =
            register("bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BORDERED_BRICKS =
            register("bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BORDERED_CALCITE =
            register("bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> BORDERED_CLAY =
            register("bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> BORDERED_COAL_BLOCK =
            register("bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_COBBLESTONE =
            register("bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> BORDERED_CRYING_OBSIDIAN =
            register("bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> BORDERED_DARK_PRISMARINE =
            register("bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> BORDERED_DEEPSLATE =
            register("bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> BORDERED_DIORITE =
            register("bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> BORDERED_DIRT =
            register("bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> BORDERED_DRIPSTONE_BLOCK =
            register("bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_END_STONE =
            register("bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> BORDERED_GILDED_BLACKSTONE =
            register("bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> BORDERED_ICE =
            register("bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> BORDERED_LAPIS_BLOCK =
            register("bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_LODESTONE =
            register("bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> BORDERED_MAGMA_BLOCK =
            register("bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_MOSSY_COBBLESTONE =
            register("bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> BORDERED_MOSSY_STONE_BRICKS =
            register("bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> BORDERED_MUD =
            register("bordered_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> BORDERED_MUD_BRICKS =
            register("bordered_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> BORDERED_NETHER_BRICKS =
            register("bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> BORDERED_NETHERRACK =
            register("bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> BORDERED_OBSIDIAN =
            register("bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> BORDERED_PACKED_ICE =
            register("bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> BORDERED_PACKED_MUD =
            register("bordered_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> BORDERED_PRISMARINE =
            register("bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> BORDERED_PURPUR_BLOCK =
            register("bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_QUARTZ_BLOCK =
            register("bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_RAW_COPPER_BLOCK =
            register("bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_RAW_GOLD_BLOCK =
            register("bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_RAW_IRON_BLOCK =
            register("bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_RED_NETHER_BRICKS =
            register("bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> BORDERED_RED_SANDSTONE =
            register("bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> BORDERED_REDSTONE_BLOCK =
            register("bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_SANDSTONE =
            register("bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> BORDERED_SMOOTH_STONE =
            register("bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> BORDERED_SNOW_BLOCK =
            register("bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> BORDERED_TUFF =
            register("bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> BRICK_BORDERED_AMETHYST_BLOCK =
            register("brick_bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ANCIENT_DEBRIS =
            register("brick_bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ANDESITE =
            register("brick_bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BASALT =
            register("brick_bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BLACKSTONE =
            register("brick_bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BLUE_ICE =
            register("brick_bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BORDERLESS_BRICKS =
            register("brick_bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BRICKS =
            register("brick_bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CALCITE =
            register("brick_bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CLAY =
            register("brick_bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> BRICK_BORDERED_COAL_BLOCK =
            register("brick_bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_COBBLESTONE =
            register("brick_bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CRYING_OBSIDIAN =
            register("brick_bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DARK_PRISMARINE =
            register("brick_bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DEEPSLATE =
            register("brick_bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DIORITE =
            register("brick_bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DIRT =
            register("brick_bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DRIPSTONE_BLOCK =
            register("brick_bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_END_STONE =
            register("brick_bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_GILDED_BLACKSTONE =
            register("brick_bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ICE =
            register("brick_bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_LAPIS_BLOCK =
            register("brick_bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_LODESTONE =
            register("brick_bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MAGMA_BLOCK =
            register("brick_bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MOSSY_COBBLESTONE =
            register("brick_bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MOSSY_STONE_BRICKS =
            register("brick_bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MUD =
            register("brick_bordered_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MUD_BRICKS =
            register("brick_bordered_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_NETHER_BRICKS =
            register("brick_bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_NETHERRACK =
            register("brick_bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_OBSIDIAN =
            register("brick_bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PACKED_ICE =
            register("brick_bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PACKED_MUD =
            register("brick_bordered_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PRISMARINE =
            register("brick_bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PURPUR_BLOCK =
            register("brick_bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_QUARTZ_BLOCK =
            register("brick_bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_COPPER_BLOCK =
            register("brick_bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_GOLD_BLOCK =
            register("brick_bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_IRON_BLOCK =
            register("brick_bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RED_NETHER_BRICKS =
            register("brick_bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RED_SANDSTONE =
            register("brick_bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_REDSTONE_BLOCK =
            register("brick_bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SANDSTONE =
            register("brick_bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SMOOTH_STONE =
            register("brick_bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SNOW_BLOCK =
            register("brick_bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_TUFF =
            register("brick_bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> BROWN_CONCRETE_CTM =
            register("brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_CONCRETE_PANEL =
            register("brown_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_COLUMN =
            register("brown_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_CTM =
            register("brown_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CARVED_MUD_BRICKS_CTM =
            register("carved_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> CARVED_MUD_CTM =
            register("carved_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CARVED_PACKED_MUD_CTM =
            register("carved_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<LeavesBlock> CHERRY_ACACIA_LEAVES =
            register("cherry_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_BIRCH_LEAVES =
            register("cherry_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_DARK_OAK_LEAVES =
            register("cherry_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_JUNGLE_LEAVES =
            register("cherry_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_OAK_LEAVES =
            register("cherry_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_PANEL =
            register("cherry_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<LeavesBlock> CHERRY_SPRUCE_LEAVES =
            register("cherry_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> CIRCULAR_BLACK_STAINED_GLASS =
            register("circular_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BLACK_TERRACOTTA =
            register("circular_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BLUE_STAINED_GLASS =
            register("circular_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BLUE_TERRACOTTA =
            register("circular_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BROWN_STAINED_GLASS =
            register("circular_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BROWN_TERRACOTTA =
            register("circular_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_CYAN_STAINED_GLASS =
            register("circular_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_CYAN_TERRACOTTA =
            register("circular_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_GRAY_STAINED_GLASS =
            register("circular_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_GRAY_TERRACOTTA =
            register("circular_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_GREEN_STAINED_GLASS =
            register("circular_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_GREEN_TERRACOTTA =
            register("circular_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_BLUE_TERRACOTTA =
            register("circular_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_GRAY_TERRACOTTA =
            register("circular_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_LIME_TERRACOTTA =
            register("circular_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_MAGENTA_TERRACOTTA =
            register("circular_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_ORANGE_TERRACOTTA =
            register("circular_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_PINK_TERRACOTTA =
            register("circular_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_PURPLE_TERRACOTTA =
            register("circular_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_RED_TERRACOTTA =
            register("circular_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_TERRACOTTA =
            register("circular_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_WHITE_TERRACOTTA =
            register("circular_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_YELLOW_TERRACOTTA =
            register("circular_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> CLEAR_LEADED_GLASS =
            register("clear_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CLEAR_LEADED_GLASS_CTM =
            register("clear_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CLEAR_LEADED_GLASS_CTM_PANE = register("clear_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CORNERED_ACACIA_PLANKS =
            register("cornered_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_BAMBOO_PLANKS =
            register("cornered_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_BIRCH_PLANKS =
            register("cornered_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_BLACK_WOOL =
            register("cornered_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> CORNERED_BLUE_WOOL =
            register("cornered_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> CORNERED_BROWN_WOOL =
            register("cornered_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> CORNERED_CYAN_WOOL =
            register("cornered_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> CORNERED_GRAY_WOOL =
            register("cornered_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> CORNERED_GREEN_WOOL =
            register("cornered_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CORNERED_LIGHT_BLUE_WOOL =
            register("cornered_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> CORNERED_LIGHT_GRAY_WOOL =
            register("cornered_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> CORNERED_LIME_WOOL =
            register("cornered_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> CORNERED_MAGENTA_WOOL =
            register("cornered_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> CORNERED_OAK_PLANKS =
            register("cornered_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_ORANGE_WOOL =
            register("cornered_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> CORNERED_PINK_WOOL =
            register("cornered_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> CORNERED_PURPLE_WOOL =
            register("cornered_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> CORNERED_RED_WOOL =
            register("cornered_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> CORNERED_WHITE_WOOL =
            register("cornered_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CORNERED_YELLOW_WOOL =
            register("cornered_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_BLACK_WOOL =
            register("crafted_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_BLUE_WOOL =
            register("crafted_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_BROWN_WOOL =
            register("crafted_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_CYAN_WOOL =
            register("crafted_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_GRAY_WOOL =
            register("crafted_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_GREEN_WOOL =
            register("crafted_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_LIGHT_BLUE_WOOL =
            register("crafted_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_LIGHT_GRAY_WOOL =
            register("crafted_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_LIME_WOOL =
            register("crafted_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_MAGENTA_WOOL =
            register("crafted_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_ORANGE_WOOL =
            register("crafted_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_PINK_WOOL =
            register("crafted_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_PURPLE_WOOL =
            register("crafted_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_RED_WOOL =
            register("crafted_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_WHITE_WOOL =
            register("crafted_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_YELLOW_WOOL =
            register("crafted_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> CRATED_ACACIA_PLANKS =
            register("crated_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> CRATED_BAMBOO_PLANKS =
            register("crated_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> CRATED_BIRCH_PLANKS =
            register("crated_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> CRATED_OAK_PLANKS =
            register("crated_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_PANEL =
            register("crimson_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_DIAGONAL_CTM_PANE = register("crimson_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CURLED_BLACK_TERRACOTTA =
            register("curled_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BLUE_TERRACOTTA =
            register("curled_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BROWN_TERRACOTTA =
            register("curled_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_CYAN_TERRACOTTA =
            register("curled_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_GRAY_TERRACOTTA =
            register("curled_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_GREEN_TERRACOTTA =
            register("curled_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIGHT_BLUE_TERRACOTTA =
            register("curled_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIGHT_GRAY_TERRACOTTA =
            register("curled_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIME_TERRACOTTA =
            register("curled_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_MAGENTA_TERRACOTTA =
            register("curled_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_ORANGE_TERRACOTTA =
            register("curled_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_PINK_TERRACOTTA =
            register("curled_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_PURPLE_TERRACOTTA =
            register("curled_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_RED_TERRACOTTA =
            register("curled_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_TERRACOTTA =
            register("curled_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_WHITE_TERRACOTTA =
            register("curled_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_YELLOW_TERRACOTTA =
            register("curled_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLY_AMETHYST_BLOCK_CTM =
            register("curly_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CURLY_ANCIENT_DEBRIS_CTM =
            register("curly_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> CURLY_ANDESITE_CTM =
            register("curly_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CURLY_BASALT_CTM =
            register("curly_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CURLY_BLACKSTONE_CTM =
            register("curly_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> CURLY_BLUE_ICE_CTM =
            register("curly_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> CURLY_BORDERLESS_BRICKS_CTM =
            register("curly_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CURLY_BRICKS_CTM =
            register("curly_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CURLY_CALCITE_CTM =
            register("curly_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CURLY_CLAY_CTM =
            register("curly_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> CURLY_COAL_BLOCK_CTM =
            register("curly_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> CURLY_COBBLESTONE_CTM =
            register("curly_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> CURLY_CRYING_OBSIDIAN_CTM =
            register("curly_crying_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> CURLY_DARK_PRISMARINE_CTM =
            register("curly_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CURLY_DEEPSLATE_CTM =
            register("curly_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> CURLY_DIORITE_CTM =
            register("curly_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CURLY_DIRT_CTM =
            register("curly_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> CURLY_DRIPSTONE_BLOCK_CTM =
            register("curly_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CURLY_END_STONE_CTM =
            register("curly_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> CURLY_GILDED_BLACKSTONE_CTM =
            register("curly_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> CURLY_ICE_CTM =
            register("curly_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> CURLY_LAPIS_BLOCK_CTM =
            register("curly_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> CURLY_LODESTONE_CTM =
            register("curly_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> CURLY_MAGMA_BLOCK_CTM =
            register("curly_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> CURLY_MOSSY_COBBLESTONE_CTM =
            register("curly_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> CURLY_MOSSY_STONE_BRICKS_CTM =
            register("curly_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> CURLY_MUD_BRICKS_CTM =
            register("curly_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> CURLY_MUD_CTM =
            register("curly_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CURLY_NETHER_BRICKS_CTM =
            register("curly_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> CURLY_NETHERRACK_CTM =
            register("curly_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> CURLY_OBSIDIAN_CTM =
            register("curly_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> CURLY_PACKED_ICE_CTM =
            register("curly_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CURLY_PACKED_MUD_CTM =
            register("curly_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> CURLY_PRISMARINE_CTM =
            register("curly_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> CURLY_PURPUR_BLOCK_CTM =
            register("curly_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> CURLY_QUARTZ_BLOCK_CTM =
            register("curly_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_COPPER_BLOCK_CTM =
            register("curly_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_GOLD_BLOCK_CTM =
            register("curly_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_IRON_BLOCK_CTM =
            register("curly_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RED_NETHER_BRICKS_CTM =
            register("curly_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> CURLY_RED_SANDSTONE_CTM =
            register("curly_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CURLY_REDSTONE_BLOCK_CTM =
            register("curly_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> CURLY_SANDSTONE_CTM =
            register("curly_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CURLY_SMOOTH_STONE_CTM =
            register("curly_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> CURLY_SNOW_BLOCK_CTM =
            register("curly_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> CURLY_TUFF_CTM =
            register("curly_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> CUT_AMETHYST_BLOCK_COLUMN =
            register("cut_amethyst_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CUT_ANCIENT_DEBRIS_COLUMN =
            register("cut_ancient_debris_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> CUT_ANDESITE_COLUMN =
            register("cut_andesite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CUT_BASALT_COLUMN =
            register("cut_basalt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CUT_BLACKSTONE_COLUMN =
            register("cut_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> CUT_BLUE_ICE_COLUMN =
            register("cut_blue_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> CUT_BORDERLESS_BRICKS_COLUMN =
            register("cut_borderless_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CUT_BRICKS_COLUMN =
            register("cut_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CUT_CALCITE_COLUMN =
            register("cut_calcite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CUT_CLAY_COLUMN =
            register("cut_clay_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> CUT_COAL_BLOCK_COLUMN =
            register("cut_coal_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> CUT_COBBLESTONE_COLUMN =
            register("cut_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> CUT_CRYING_OBSIDIAN_COLUMN =
            register("cut_crying_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> CUT_DARK_PRISMARINE_COLUMN =
            register("cut_dark_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CUT_DEEPSLATE_COLUMN =
            register("cut_deepslate_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> CUT_DIORITE_COLUMN =
            register("cut_diorite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CUT_DIRT_COLUMN =
            register("cut_dirt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> CUT_DRIPSTONE_BLOCK_COLUMN =
            register("cut_dripstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CUT_END_STONE_COLUMN =
            register("cut_end_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> CUT_GILDED_BLACKSTONE_COLUMN =
            register("cut_gilded_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> CUT_ICE_COLUMN =
            register("cut_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> CUT_LAPIS_BLOCK_COLUMN =
            register("cut_lapis_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> CUT_LODESTONE_COLUMN =
            register("cut_lodestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> CUT_MAGMA_BLOCK_COLUMN =
            register("cut_magma_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> CUT_MOSSY_COBBLESTONE_COLUMN =
            register("cut_mossy_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> CUT_MOSSY_STONE_BRICKS_COLUMN =
            register("cut_mossy_stone_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> CUT_NETHER_BRICKS_COLUMN =
            register("cut_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> CUT_NETHERRACK_COLUMN =
            register("cut_netherrack_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> CUT_OBSIDIAN_COLUMN =
            register("cut_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> CUT_PACKED_ICE_COLUMN =
            register("cut_packed_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CUT_PRISMARINE_COLUMN =
            register("cut_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> CUT_PURPUR_BLOCK_COLUMN =
            register("cut_purpur_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> CUT_QUARTZ_BLOCK_COLUMN =
            register("cut_quartz_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_COPPER_BLOCK_COLUMN =
            register("cut_raw_copper_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_GOLD_BLOCK_COLUMN =
            register("cut_raw_gold_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_IRON_BLOCK_COLUMN =
            register("cut_raw_iron_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> CUT_RED_NETHER_BRICKS_COLUMN =
            register("cut_red_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> CUT_RED_SANDSTONE_COLUMN =
            register("cut_red_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CUT_REDSTONE_BLOCK_COLUMN =
            register("cut_redstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> CUT_SANDSTONE_COLUMN =
            register("cut_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CUT_SMOOTH_STONE_COLUMN =
            register("cut_smooth_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> CUT_SNOW_BLOCK_COLUMN =
            register("cut_snow_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> CUT_TUFF_COLUMN =
            register("cut_tuff_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> CYAN_CONCRETE_CTM =
            register("cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_CONCRETE_PANEL =
            register("cyan_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_COLUMN =
            register("cyan_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_CTM =
            register("cyan_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_PANEL =
            register("dark_oak_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<LeavesBlock> DEAD_ACACIA_LEAVES =
            register("dead_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_BIRCH_LEAVES =
            register("dead_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_DARK_OAK_LEAVES =
            register("dead_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_JUNGLE_LEAVES =
            register("dead_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_OAK_LEAVES =
            register("dead_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_SPRUCE_LEAVES =
            register("dead_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> EDGED_AMETHYST_BLOCK_BRICKS =
            register("edged_amethyst_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> EDGED_ANCIENT_DEBRIS_BRICKS =
            register("edged_ancient_debris_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> EDGED_ANDESITE_BRICKS =
            register("edged_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> EDGED_BASALT_BRICKS =
            register("edged_basalt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> EDGED_BLACKSTONE_BRICKS =
            register("edged_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> EDGED_BLUE_ICE_BRICKS =
            register("edged_blue_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> EDGED_BORDERLESS_BRICKS_BRICKS =
            register("edged_borderless_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> EDGED_BRICKS_BRICKS =
            register("edged_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> EDGED_CALCITE_BRICKS =
            register("edged_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> EDGED_CLAY_BRICKS =
            register("edged_clay_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> EDGED_COAL_BLOCK_BRICKS =
            register("edged_coal_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> EDGED_COBBLESTONE_BRICKS =
            register("edged_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> EDGED_CRYING_OBSIDIAN_BRICKS =
            register("edged_crying_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> EDGED_DARK_PRISMARINE_BRICKS =
            register("edged_dark_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> EDGED_DEEPSLATE_BRICKS =
            register("edged_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> EDGED_DIORITE_BRICKS =
            register("edged_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> EDGED_DIRT_BRICKS =
            register("edged_dirt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> EDGED_DRIPSTONE_BLOCK_BRICKS =
            register("edged_dripstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> EDGED_END_STONE_BRICKS =
            register("edged_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> EDGED_GILDED_BLACKSTONE_BRICKS =
            register("edged_gilded_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> EDGED_ICE_BRICKS =
            register("edged_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> EDGED_LAPIS_BLOCK_BRICKS =
            register("edged_lapis_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> EDGED_LODESTONE_BRICKS =
            register("edged_lodestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> EDGED_MAGMA_BLOCK_BRICKS =
            register("edged_magma_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> EDGED_MOSSY_COBBLESTONE_BRICKS =
            register("edged_mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> EDGED_MOSSY_STONE_BRICKS_BRICKS =
            register("edged_mossy_stone_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> EDGED_MUD =
            register("edged_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> EDGED_MUD_BRICKS_BRICKS =
            register("edged_mud_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> EDGED_NETHER_BRICKS_BRICKS =
            register("edged_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> EDGED_NETHERRACK_BRICKS =
            register("edged_netherrack_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> EDGED_OBSIDIAN_BRICKS =
            register("edged_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> EDGED_PACKED_ICE_BRICKS =
            register("edged_packed_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> EDGED_PACKED_MUD_BRICKS =
            register("edged_packed_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> EDGED_PRISMARINE_BRICKS =
            register("edged_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> EDGED_PURPUR_BLOCK_BRICKS =
            register("edged_purpur_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> EDGED_QUARTZ_BLOCK_BRICKS =
            register("edged_quartz_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_COPPER_BLOCK_BRICKS =
            register("edged_raw_copper_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_GOLD_BLOCK_BRICKS =
            register("edged_raw_gold_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_IRON_BLOCK_BRICKS =
            register("edged_raw_iron_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RED_NETHER_BRICKS_BRICKS =
            register("edged_red_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> EDGED_RED_SANDSTONE_BRICKS =
            register("edged_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> EDGED_REDSTONE_BLOCK_BRICKS =
            register("edged_redstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> EDGED_SANDSTONE_BRICKS =
            register("edged_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> EDGED_SMOOTH_STONE_BRICKS =
            register("edged_smooth_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> EDGED_SNOW_BLOCK_BRICKS =
            register("edged_snow_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> EDGED_TUFF_BRICKS =
            register("edged_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> ENCLOSED_ACACIA_PLANKS =
            register("enclosed_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_BAMBOO_PLANKS =
            register("enclosed_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_BIRCH_PLANKS =
            register("enclosed_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_OAK_PLANKS =
            register("enclosed_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FANCY_BLACK_STAINED_GLASS =
            register("fancy_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLACK_STAINED_GLASS_CTM =
            register("fancy_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> FANCY_BLACK_STAINED_GLASS_CTM_PANE = register("fancy_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_BLUE_STAINED_GLASS =
            register("fancy_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLUE_STAINED_GLASS_CTM =
            register("fancy_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> FANCY_BLUE_STAINED_GLASS_CTM_PANE = register("fancy_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_BROWN_STAINED_GLASS =
            register("fancy_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BROWN_STAINED_GLASS_CTM =
            register("fancy_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> FANCY_BROWN_STAINED_GLASS_CTM_PANE = register("fancy_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_CYAN_STAINED_GLASS =
            register("fancy_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_CYAN_STAINED_GLASS_CTM =
            register("fancy_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> FANCY_CYAN_STAINED_GLASS_CTM_PANE = register("fancy_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_GRAY_STAINED_GLASS =
            register("fancy_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GRAY_STAINED_GLASS_CTM =
            register("fancy_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> FANCY_GRAY_STAINED_GLASS_CTM_PANE = register("fancy_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_GREEN_STAINED_GLASS =
            register("fancy_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GREEN_STAINED_GLASS_CTM =
            register("fancy_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> FANCY_GREEN_STAINED_GLASS_CTM_PANE = register("fancy_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_LEADED_GLASS =
            register("fancy_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_LEADED_GLASS_CTM =
            register("fancy_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LEADED_GLASS_CTM_PANE = register("fancy_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_MUD_BRICKS_CTM =
            register("fancy_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> FANCY_MUD_CTM =
            register("fancy_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FANCY_PACKED_MUD_CTM =
            register("fancy_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FINE_AMETHYST_BLOCK_CTM =
            register("fine_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> FINE_ANCIENT_DEBRIS_CTM =
            register("fine_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> FINE_ANDESITE_CTM =
            register("fine_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> FINE_BASALT_CTM =
            register("fine_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> FINE_BLACKSTONE_CTM =
            register("fine_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> FINE_BLUE_ICE_CTM =
            register("fine_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> FINE_BORDERLESS_BRICKS_CTM =
            register("fine_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> FINE_BRICKS_CTM =
            register("fine_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> FINE_CALCITE_CTM =
            register("fine_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> FINE_CLAY_CTM =
            register("fine_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> FINE_COAL_BLOCK_CTM =
            register("fine_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> FINE_COBBLESTONE_CTM =
            register("fine_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> FINE_CRYING_OBSIDIAN_CTM =
            register("fine_crying_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> FINE_DARK_PRISMARINE_CTM =
            register("fine_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> FINE_DEEPSLATE_CTM =
            register("fine_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> FINE_DIORITE_CTM =
            register("fine_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> FINE_DIRT_CTM =
            register("fine_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> FINE_DRIPSTONE_BLOCK_CTM =
            register("fine_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> FINE_END_STONE_CTM =
            register("fine_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> FINE_GILDED_BLACKSTONE_CTM =
            register("fine_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> FINE_ICE_CTM =
            register("fine_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> FINE_LAPIS_BLOCK_CTM =
            register("fine_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> FINE_LODESTONE_CTM =
            register("fine_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> FINE_MAGMA_BLOCK_CTM =
            register("fine_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> FINE_MOSSY_COBBLESTONE_CTM =
            register("fine_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> FINE_MOSSY_STONE_BRICKS_CTM =
            register("fine_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> FINE_MUD_BRICKS_CTM =
            register("fine_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> FINE_MUD_CTM =
            register("fine_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FINE_NETHER_BRICKS_CTM =
            register("fine_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> FINE_NETHERRACK_CTM =
            register("fine_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> FINE_OBSIDIAN_CTM =
            register("fine_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> FINE_PACKED_ICE_CTM =
            register("fine_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> FINE_PACKED_MUD_CTM =
            register("fine_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FINE_PRISMARINE_CTM =
            register("fine_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> FINE_PURPUR_BLOCK_CTM =
            register("fine_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> FINE_QUARTZ_BLOCK_CTM =
            register("fine_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_COPPER_BLOCK_CTM =
            register("fine_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_GOLD_BLOCK_CTM =
            register("fine_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_IRON_BLOCK_CTM =
            register("fine_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> FINE_RED_NETHER_BRICKS_CTM =
            register("fine_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> FINE_RED_SANDSTONE_CTM =
            register("fine_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> FINE_REDSTONE_BLOCK_CTM =
            register("fine_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> FINE_SANDSTONE_CTM =
            register("fine_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> FINE_SMOOTH_STONE_CTM =
            register("fine_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> FINE_SNOW_BLOCK_CTM =
            register("fine_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> FINE_TUFF_CTM =
            register("fine_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> FRAMED_ACACIA_PLANKS =
            register("framed_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_BAMBOO_PLANKS =
            register("framed_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_BIRCH_PLANKS =
            register("framed_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_OAK_PLANKS =
            register("framed_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<LeavesBlock> FROSTED_ACACIA_LEAVES =
            register("frosted_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_BIRCH_LEAVES =
            register("frosted_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_DARK_OAK_LEAVES =
            register("frosted_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_JUNGLE_LEAVES =
            register("frosted_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_OAK_LEAVES =
            register("frosted_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_SPRUCE_LEAVES =
            register("frosted_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_ACACIA_LEAVES =
            register("golden_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_ACACIA_LEAVES =
            register("golden_apple_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_BIRCH_LEAVES =
            register("golden_apple_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_DARK_OAK_LEAVES =
            register("golden_apple_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));


    // ===== RECOVERED WAVE3 =====
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_JUNGLE_LEAVES =
            register("golden_apple_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_OAK_LEAVES =
            register("golden_apple_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_SPRUCE_LEAVES =
            register("golden_apple_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_BIRCH_LEAVES =
            register("golden_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_ACACIA_LEAVES =
            register("golden_cherry_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_BIRCH_LEAVES =
            register("golden_cherry_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_DARK_OAK_LEAVES =
            register("golden_cherry_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_JUNGLE_LEAVES =
            register("golden_cherry_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_OAK_LEAVES =
            register("golden_cherry_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_SPRUCE_LEAVES =
            register("golden_cherry_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_DARK_OAK_LEAVES =
            register("golden_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_JUNGLE_LEAVES =
            register("golden_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_OAK_LEAVES =
            register("golden_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_SPRUCE_LEAVES =
            register("golden_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> GRAY_CONCRETE_CTM =
            register("gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_CONCRETE_PANEL =
            register("gray_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_COLUMN =
            register("gray_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_CTM =
            register("gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_CONCRETE_CTM =
            register("green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_CONCRETE_PANEL =
            register("green_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_COLUMN =
            register("green_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_CTM =
            register("green_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> GRILL_BLACK_CONCRETE =
            register("grill_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BLUE_CONCRETE =
            register("grill_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BROWN_CONCRETE =
            register("grill_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_CYAN_CONCRETE =
            register("grill_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_GRAY_CONCRETE =
            register("grill_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_GREEN_CONCRETE =
            register("grill_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_LIGHT_BLUE_CONCRETE =
            register("grill_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_LIGHT_GRAY_CONCRETE =
            register("grill_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_LIME_CONCRETE =
            register("grill_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_MAGENTA_CONCRETE =
            register("grill_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_ORANGE_CONCRETE =
            register("grill_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_PINK_CONCRETE =
            register("grill_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_PURPLE_CONCRETE =
            register("grill_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_RED_CONCRETE =
            register("grill_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_WHITE_CONCRETE =
            register("grill_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_YELLOW_CONCRETE =
            register("grill_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> HARD_MUD =
            register("hard_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> HARD_MUD_BRICKS =
            register("hard_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> HARD_PACKED_MUD =
            register("hard_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> HARSH_QUILTED_BLACK_WOOL =
            register("harsh_quilted_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_BLUE_WOOL =
            register("harsh_quilted_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_BROWN_WOOL =
            register("harsh_quilted_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_CYAN_WOOL =
            register("harsh_quilted_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_GRAY_WOOL =
            register("harsh_quilted_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_GREEN_WOOL =
            register("harsh_quilted_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_LIGHT_BLUE_WOOL =
            register("harsh_quilted_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_LIGHT_GRAY_WOOL =
            register("harsh_quilted_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_LIME_WOOL =
            register("harsh_quilted_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_MAGENTA_WOOL =
            register("harsh_quilted_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_ORANGE_WOOL =
            register("harsh_quilted_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_PINK_WOOL =
            register("harsh_quilted_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_PURPLE_WOOL =
            register("harsh_quilted_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_RED_WOOL =
            register("harsh_quilted_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_WHITE_WOOL =
            register("harsh_quilted_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_YELLOW_WOOL =
            register("harsh_quilted_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> HEXAGONICAL_BLACK_TERRACOTTA =
            register("hexagonical_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BLUE_TERRACOTTA =
            register("hexagonical_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BROWN_TERRACOTTA =
            register("hexagonical_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_CYAN_TERRACOTTA =
            register("hexagonical_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_GRAY_TERRACOTTA =
            register("hexagonical_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_GREEN_TERRACOTTA =
            register("hexagonical_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIGHT_BLUE_TERRACOTTA =
            register("hexagonical_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIGHT_GRAY_TERRACOTTA =
            register("hexagonical_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIME_TERRACOTTA =
            register("hexagonical_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_MAGENTA_TERRACOTTA =
            register("hexagonical_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_ORANGE_TERRACOTTA =
            register("hexagonical_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_PINK_TERRACOTTA =
            register("hexagonical_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_PURPLE_TERRACOTTA =
            register("hexagonical_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_RED_TERRACOTTA =
            register("hexagonical_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_TERRACOTTA =
            register("hexagonical_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_WHITE_TERRACOTTA =
            register("hexagonical_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_YELLOW_TERRACOTTA =
            register("hexagonical_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BLACK_TERRACOTTA =
            register("inscribed_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BLUE_TERRACOTTA =
            register("inscribed_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BROWN_TERRACOTTA =
            register("inscribed_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_CYAN_TERRACOTTA =
            register("inscribed_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_GRAY_TERRACOTTA =
            register("inscribed_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_GREEN_TERRACOTTA =
            register("inscribed_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIGHT_BLUE_TERRACOTTA =
            register("inscribed_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIGHT_GRAY_TERRACOTTA =
            register("inscribed_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIME_TERRACOTTA =
            register("inscribed_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_MAGENTA_TERRACOTTA =
            register("inscribed_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_ORANGE_TERRACOTTA =
            register("inscribed_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_PINK_TERRACOTTA =
            register("inscribed_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_PURPLE_TERRACOTTA =
            register("inscribed_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_RED_TERRACOTTA =
            register("inscribed_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_TERRACOTTA =
            register("inscribed_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_WHITE_TERRACOTTA =
            register("inscribed_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_YELLOW_TERRACOTTA =
            register("inscribed_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_SLIM_CTM_PANE = register("jungle_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BLACK_STAINED_GLASS =
            register("large_diamond_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BLUE_STAINED_GLASS =
            register("large_diamond_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BROWN_STAINED_GLASS =
            register("large_diamond_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_CYAN_STAINED_GLASS =
            register("large_diamond_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_GRAY_STAINED_GLASS =
            register("large_diamond_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_GREEN_STAINED_GLASS =
            register("large_diamond_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LEADED_GLASS =
            register("large_diamond_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LARGE_MUD_BRICKS_SIGIL =
            register("large_mud_bricks_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> LARGE_MUD_SIGIL =
            register("large_mud_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> LARGE_PACKED_MUD_SIGIL =
            register("large_packed_mud_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> LEAD_WOVEN_GLASS =
            register("lead_woven_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_CTM =
            register("light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_PANEL =
            register("light_blue_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_COLUMN =
            register("light_blue_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_CTM =
            register("light_blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_CTM =
            register("light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_PANEL =
            register("light_gray_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_COLUMN =
            register("light_gray_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_CTM =
            register("light_gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_CONCRETE_CTM =
            register("lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> LIME_CONCRETE_PANEL =
            register("lime_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_COLUMN =
            register("lime_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_CTM =
            register("lime_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> LOREFUL_MUD =
            register("loreful_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> LOREFUL_MUD_BRICKS =
            register("loreful_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> LOREFUL_PACKED_MUD =
            register("loreful_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_CTM =
            register("magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_PANEL =
            register("magenta_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_ACACIA_LEAVES =
            register("magenta_flower_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_BIRCH_LEAVES =
            register("magenta_flower_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_DARK_OAK_LEAVES =
            register("magenta_flower_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_JUNGLE_LEAVES =
            register("magenta_flower_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_OAK_LEAVES =
            register("magenta_flower_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_SPRUCE_LEAVES =
            register("magenta_flower_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_COLUMN =
            register("magenta_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_CTM =
            register("magenta_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_PANEL =
            register("mangrove_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_ROUNDED_CTM_PANE = register("mangrove_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MASSIVE_AMETHYST_BLOCK_BRICKS =
            register("massive_amethyst_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_ANCIENT_DEBRIS_BRICKS =
            register("massive_ancient_debris_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> MASSIVE_ANDESITE_BRICKS =
            register("massive_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> MASSIVE_BASALT_BRICKS =
            register("massive_basalt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> MASSIVE_BLACKSTONE_BRICKS =
            register("massive_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> MASSIVE_BLUE_ICE_BRICKS =
            register("massive_blue_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> MASSIVE_BORDERLESS_BRICKS_BRICKS =
            register("massive_borderless_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_BRICKS_BRICKS =
            register("massive_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_CALCITE_BRICKS =
            register("massive_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> MASSIVE_CLAY_BRICKS =
            register("massive_clay_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> MASSIVE_COAL_BLOCK_BRICKS =
            register("massive_coal_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_COBBLESTONE_BRICKS =
            register("massive_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> MASSIVE_CRYING_OBSIDIAN_BRICKS =
            register("massive_crying_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> MASSIVE_DARK_PRISMARINE_BRICKS =
            register("massive_dark_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> MASSIVE_DEEPSLATE_BRICKS =
            register("massive_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MASSIVE_DIORITE_BRICKS =
            register("massive_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> MASSIVE_DIRT_BRICKS =
            register("massive_dirt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> MASSIVE_DRIPSTONE_BLOCK_BRICKS =
            register("massive_dripstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_END_STONE_BRICKS =
            register("massive_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> MASSIVE_GILDED_BLACKSTONE_BRICKS =
            register("massive_gilded_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> MASSIVE_ICE_BRICKS =
            register("massive_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> MASSIVE_LAPIS_BLOCK_BRICKS =
            register("massive_lapis_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_LODESTONE_BRICKS =
            register("massive_lodestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> MASSIVE_MAGMA_BLOCK_BRICKS =
            register("massive_magma_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_MOSSY_COBBLESTONE_BRICKS =
            register("massive_mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> MASSIVE_MOSSY_STONE_BRICKS_BRICKS =
            register("massive_mossy_stone_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_MUD_BRICKS =
            register("massive_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> MASSIVE_MUD_BRICKS_BRICKS =
            register("massive_mud_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_NETHER_BRICKS_BRICKS =
            register("massive_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_NETHERRACK_BRICKS =
            register("massive_netherrack_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> MASSIVE_OBSIDIAN_BRICKS =
            register("massive_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> MASSIVE_PACKED_ICE_BRICKS =
            register("massive_packed_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> MASSIVE_PACKED_MUD_BRICKS =
            register("massive_packed_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> MASSIVE_PRISMARINE_BRICKS =
            register("massive_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> MASSIVE_PURPUR_BLOCK_BRICKS =
            register("massive_purpur_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_QUARTZ_BLOCK_BRICKS =
            register("massive_quartz_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_COPPER_BLOCK_BRICKS =
            register("massive_raw_copper_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_GOLD_BLOCK_BRICKS =
            register("massive_raw_gold_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_IRON_BLOCK_BRICKS =
            register("massive_raw_iron_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RED_NETHER_BRICKS_BRICKS =
            register("massive_red_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_RED_SANDSTONE_BRICKS =
            register("massive_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> MASSIVE_REDSTONE_BLOCK_BRICKS =
            register("massive_redstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_SANDSTONE_BRICKS =
            register("massive_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> MASSIVE_SMOOTH_STONE_BRICKS =
            register("massive_smooth_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> MASSIVE_SNOW_BLOCK_BRICKS =
            register("massive_snow_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_TUFF_BRICKS =
            register("massive_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> NATURAL_ACACIA_PLANKS =
            register("natural_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_BAMBOO_PLANKS =
            register("natural_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_BIRCH_PLANKS =
            register("natural_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_OAK_PLANKS =
            register("natural_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> OAK_BARRED_GLASS_CTM =
            register("oak_barred_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_BARRED_GLASS_CTM_PANE = register("oak_barred_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_BORDERED_GLASS_CTM =
            register("oak_bordered_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_BORDERED_GLASS_CTM_PANE = register("oak_bordered_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_DIAMOND_BORDERED_GLASS_CTM =
            register("oak_diamond_bordered_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_DIAMOND_BORDERED_GLASS_CTM_PANE = register("oak_diamond_bordered_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_HORIZONTAL_LINED_GLASS_CTM =
            register("oak_horizontal_lined_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_HORIZONTAL_LINED_GLASS_CTM_PANE = register("oak_horizontal_lined_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LARGE_DIAMOND_GLASS_CTM =
            register("oak_large_diamond_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_LARGE_DIAMOND_GLASS_CTM_PANE = register("oak_large_diamond_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LINE_BARED_GLASS_CTM =
            register("oak_line_bared_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_LINE_BARED_GLASS_CTM_PANE = register("oak_line_bared_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_ORNATE_BARED_GLASS_CTM =
            register("oak_ornate_bared_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_ORNATE_BARED_GLASS_CTM_PANE = register("oak_ornate_bared_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_PLANKS_PANEL =
            register("oak_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_PANES_CTM_PANE = register("oak_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WOVEN_GLASS_CTM =
            register("oak_woven_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WOVEN_GLASS_CTM_PANE = register("oak_woven_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<LeavesBlock> ORANGE_ACACIA_LEAVES =
            register("orange_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_BIRCH_LEAVES =
            register("orange_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_CTM =
            register("orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_PANEL =
            register("orange_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<LeavesBlock> ORANGE_DARK_OAK_LEAVES =
            register("orange_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_JUNGLE_LEAVES =
            register("orange_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_OAK_LEAVES =
            register("orange_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_SPRUCE_LEAVES =
            register("orange_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_COLUMN =
            register("orange_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_CTM =
            register("orange_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> ORNATE_AMETHYST_BLOCK_CTM =
            register("ornate_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_ANCIENT_DEBRIS_CTM =
            register("ornate_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> ORNATE_ANDESITE_CTM =
            register("ornate_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> ORNATE_BASALT_CTM =
            register("ornate_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> ORNATE_BLACK_STAINED_GLASS =
            register("ornate_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLACK_STAINED_GLASS_CTM =
            register("ornate_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_BLACK_STAINED_GLASS_CTM_PANE = register("ornate_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_BLACKSTONE_CTM =
            register("ornate_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> ORNATE_BLUE_ICE_CTM =
            register("ornate_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> ORNATE_BLUE_STAINED_GLASS =
            register("ornate_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLUE_STAINED_GLASS_CTM =
            register("ornate_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_BLUE_STAINED_GLASS_CTM_PANE = register("ornate_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_BORDERLESS_BRICKS_CTM =
            register("ornate_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> ORNATE_BRICKS_CTM =
            register("ornate_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> ORNATE_BROWN_STAINED_GLASS =
            register("ornate_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BROWN_STAINED_GLASS_CTM =
            register("ornate_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_BROWN_STAINED_GLASS_CTM_PANE = register("ornate_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_CALCITE_CTM =
            register("ornate_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> ORNATE_CLAY_CTM =
            register("ornate_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> ORNATE_COAL_BLOCK_CTM =
            register("ornate_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_COBBLESTONE_CTM =
            register("ornate_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> ORNATE_CRYING_OBSIDIAN_CTM =
            register("ornate_crying_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> ORNATE_CYAN_STAINED_GLASS =
            register("ornate_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_CYAN_STAINED_GLASS_CTM =
            register("ornate_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_CYAN_STAINED_GLASS_CTM_PANE = register("ornate_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_DARK_PRISMARINE_CTM =
            register("ornate_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> ORNATE_DEEPSLATE_CTM =
            register("ornate_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> ORNATE_DIORITE_CTM =
            register("ornate_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> ORNATE_DIRT_CTM =
            register("ornate_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> ORNATE_DRIPSTONE_BLOCK_CTM =
            register("ornate_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_END_STONE_CTM =
            register("ornate_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> ORNATE_GILDED_BLACKSTONE_CTM =
            register("ornate_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> ORNATE_GRAY_STAINED_GLASS =
            register("ornate_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GRAY_STAINED_GLASS_CTM =
            register("ornate_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_GRAY_STAINED_GLASS_CTM_PANE = register("ornate_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_GREEN_STAINED_GLASS =
            register("ornate_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GREEN_STAINED_GLASS_CTM =
            register("ornate_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_GREEN_STAINED_GLASS_CTM_PANE = register("ornate_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_ICE_CTM =
            register("ornate_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> ORNATE_LAPIS_BLOCK_CTM =
            register("ornate_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_LEADED_GLASS =
            register("ornate_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_LODESTONE_CTM =
            register("ornate_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> ORNATE_MAGMA_BLOCK_CTM =
            register("ornate_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_MOSSY_COBBLESTONE_CTM =
            register("ornate_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> ORNATE_MOSSY_STONE_BRICKS_CTM =
            register("ornate_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_MUD_BRICKS_CTM =
            register("ornate_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_MUD_CTM =
            register("ornate_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> ORNATE_NETHER_BRICKS_CTM =
            register("ornate_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_NETHERRACK_CTM =
            register("ornate_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> ORNATE_OBSIDIAN_CTM =
            register("ornate_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> ORNATE_PACKED_ICE_CTM =
            register("ornate_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> ORNATE_PACKED_MUD_CTM =
            register("ornate_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> ORNATE_PRISMARINE_CTM =
            register("ornate_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> ORNATE_PURPUR_BLOCK_CTM =
            register("ornate_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_QUARTZ_BLOCK_CTM =
            register("ornate_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_COPPER_BLOCK_CTM =
            register("ornate_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_GOLD_BLOCK_CTM =
            register("ornate_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_IRON_BLOCK_CTM =
            register("ornate_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RED_NETHER_BRICKS_CTM =
            register("ornate_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_RED_SANDSTONE_CTM =
            register("ornate_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> ORNATE_REDSTONE_BLOCK_CTM =
            register("ornate_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_SANDSTONE_CTM =
            register("ornate_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> ORNATE_SMOOTH_STONE_CTM =
            register("ornate_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> ORNATE_SNOW_BLOCK_CTM =
            register("ornate_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_TUFF_CTM =
            register("ornate_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> OVERLAPPING_AMETHYST_BLOCK_TILES =
            register("overlapping_amethyst_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_ANCIENT_DEBRIS_TILES =
            register("overlapping_ancient_debris_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> OVERLAPPING_ANDESITE_TILES =
            register("overlapping_andesite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> OVERLAPPING_BASALT_TILES =
            register("overlapping_basalt_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> OVERLAPPING_BLACKSTONE_TILES =
            register("overlapping_blackstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_BLUE_ICE_TILES =
            register("overlapping_blue_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_BORDERLESS_BRICKS_TILES =
            register("overlapping_borderless_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_BRICKS_TILES =
            register("overlapping_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_CALCITE_TILES =
            register("overlapping_calcite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> OVERLAPPING_CLAY_TILES =
            register("overlapping_clay_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> OVERLAPPING_COAL_BLOCK_TILES =
            register("overlapping_coal_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_COBBLESTONE_TILES =
            register("overlapping_cobblestone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_CRYING_OBSIDIAN_TILES =
            register("overlapping_crying_obsidian_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> OVERLAPPING_DARK_PRISMARINE_TILES =
            register("overlapping_dark_prismarine_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> OVERLAPPING_DEEPSLATE_TILES =
            register("overlapping_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> OVERLAPPING_DIORITE_TILES =
            register("overlapping_diorite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> OVERLAPPING_DIRT_TILES =
            register("overlapping_dirt_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> OVERLAPPING_DRIPSTONE_BLOCK_TILES =
            register("overlapping_dripstone_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_END_STONE_TILES =
            register("overlapping_end_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> OVERLAPPING_GILDED_BLACKSTONE_TILES =
            register("overlapping_gilded_blackstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_ICE_TILES =
            register("overlapping_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_LAPIS_BLOCK_TILES =
            register("overlapping_lapis_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_LODESTONE_TILES =
            register("overlapping_lodestone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_MAGMA_BLOCK_TILES =
            register("overlapping_magma_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_MOSSY_COBBLESTONE_TILES =
            register("overlapping_mossy_cobblestone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_MOSSY_STONE_BRICKS_TILES =
            register("overlapping_mossy_stone_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_MUD_BRICKS_TILES =
            register("overlapping_mud_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_MUD_TILES =
            register("overlapping_mud_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> OVERLAPPING_NETHER_BRICKS_TILES =
            register("overlapping_nether_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_NETHERRACK_TILES =
            register("overlapping_netherrack_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> OVERLAPPING_OBSIDIAN_TILES =
            register("overlapping_obsidian_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> OVERLAPPING_PACKED_ICE_TILES =
            register("overlapping_packed_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_PACKED_MUD_TILES =
            register("overlapping_packed_mud_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> OVERLAPPING_PRISMARINE_TILES =
            register("overlapping_prismarine_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> OVERLAPPING_PURPUR_BLOCK_TILES =
            register("overlapping_purpur_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_QUARTZ_BLOCK_TILES =
            register("overlapping_quartz_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_COPPER_BLOCK_TILES =
            register("overlapping_raw_copper_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_GOLD_BLOCK_TILES =
            register("overlapping_raw_gold_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_IRON_BLOCK_TILES =
            register("overlapping_raw_iron_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RED_NETHER_BRICKS_TILES =
            register("overlapping_red_nether_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_RED_SANDSTONE_TILES =
            register("overlapping_red_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_REDSTONE_BLOCK_TILES =
            register("overlapping_redstone_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_SANDSTONE_TILES =
            register("overlapping_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_SMOOTH_STONE_TILES =
            register("overlapping_smooth_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> OVERLAPPING_SNOW_BLOCK_TILES =
            register("overlapping_snow_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_TUFF_TILES =
            register("overlapping_tuff_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> PEGGED_ACACIA_PLANKS =
            register("pegged_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_BIRCH_PLANKS =
            register("pegged_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_BLACK_CONCRETE =
            register("pegged_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BLUE_CONCRETE =
            register("pegged_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BROWN_CONCRETE =
            register("pegged_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_CYAN_CONCRETE =
            register("pegged_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_GRAY_CONCRETE =
            register("pegged_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_GREEN_CONCRETE =
            register("pegged_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIGHT_BLUE_CONCRETE =
            register("pegged_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIGHT_GRAY_CONCRETE =
            register("pegged_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIME_CONCRETE =
            register("pegged_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_MAGENTA_CONCRETE =
            register("pegged_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_OAK_PLANKS =
            register("pegged_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_ORANGE_CONCRETE =
            register("pegged_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_PINK_CONCRETE =
            register("pegged_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_PURPLE_CONCRETE =
            register("pegged_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_RED_CONCRETE =
            register("pegged_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_WHITE_CONCRETE =
            register("pegged_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_YELLOW_CONCRETE =
            register("pegged_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> PINK_CONCRETE_CTM =
            register("pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PINK_CONCRETE_PANEL =
            register("pink_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_COLUMN =
            register("pink_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_CTM =
            register("pink_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> POLISHED_AMETHYST_BLOCK =
            register("polished_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_ANCIENT_DEBRIS =
            register("polished_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> POLISHED_BAMBOO_PLANKS =
            register("polished_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> POLISHED_BASALT =
            register("polished_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> POLISHED_BIRCH_PLANKS =
            register("polished_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> POLISHED_BLUE_ICE =
            register("polished_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> POLISHED_BORDERLESS_BRICKS =
            register("polished_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> POLISHED_BRICKS =
            register("polished_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> POLISHED_CALCITE =
            register("polished_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> POLISHED_CLAY =
            register("polished_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> POLISHED_COAL_BLOCK =
            register("polished_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_COBBLESTONE =
            register("polished_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> POLISHED_CRYING_OBSIDIAN =
            register("polished_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> POLISHED_DARK_PRISMARINE =
            register("polished_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> POLISHED_DEEPSLATE =
            register("polished_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> POLISHED_DIRT =
            register("polished_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_BLOCK =
            register("polished_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_END_STONE =
            register("polished_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> POLISHED_GILDED_BLACKSTONE =
            register("polished_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> POLISHED_ICE =
            register("polished_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> POLISHED_LAPIS_BLOCK =
            register("polished_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_LODESTONE =
            register("polished_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> POLISHED_MAGMA_BLOCK =
            register("polished_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_MOSSY_COBBLESTONE =
            register("polished_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> POLISHED_MOSSY_STONE_BRICKS =
            register("polished_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_NETHER_BRICKS =
            register("polished_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_NETHERRACK =
            register("polished_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN =
            register("polished_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> POLISHED_PACKED_ICE =
            register("polished_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> POLISHED_PRISMARINE =
            register("polished_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> POLISHED_PURPUR_BLOCK =
            register("polished_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_QUARTZ_BLOCK =
            register("polished_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_COPPER_BLOCK =
            register("polished_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_GOLD_BLOCK =
            register("polished_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_IRON_BLOCK =
            register("polished_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RED_NETHER_BRICKS =
            register("polished_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_RED_SANDSTONE =
            register("polished_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_REDSTONE_BLOCK =
            register("polished_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_SANDSTONE =
            register("polished_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_SMOOTH_STONE =
            register("polished_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> POLISHED_SNOW_BLOCK =
            register("polished_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_TUFF =
            register("polished_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_CTM =
            register("purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_PANEL =
            register("purple_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_COLUMN =
            register("purple_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_CTM =
            register("purple_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> RASTER_BLACK_STAINED_GLASS =
            register("raster_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLACK_STAINED_GLASS_CTM =
            register("raster_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RASTER_BLACK_STAINED_GLASS_CTM_PANE = register("raster_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_BLUE_STAINED_GLASS =
            register("raster_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLUE_STAINED_GLASS_CTM =
            register("raster_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RASTER_BLUE_STAINED_GLASS_CTM_PANE = register("raster_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_BROWN_STAINED_GLASS =
            register("raster_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BROWN_STAINED_GLASS_CTM =
            register("raster_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RASTER_BROWN_STAINED_GLASS_CTM_PANE = register("raster_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_CYAN_STAINED_GLASS =
            register("raster_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_CYAN_STAINED_GLASS_CTM =
            register("raster_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RASTER_CYAN_STAINED_GLASS_CTM_PANE = register("raster_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_GRAY_STAINED_GLASS =
            register("raster_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GRAY_STAINED_GLASS_CTM =
            register("raster_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RASTER_GRAY_STAINED_GLASS_CTM_PANE = register("raster_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_GREEN_STAINED_GLASS =
            register("raster_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GREEN_STAINED_GLASS_CTM =
            register("raster_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RASTER_GREEN_STAINED_GLASS_CTM_PANE = register("raster_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_LEADED_GLASS =
            register("raster_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_LEADED_GLASS_CTM =
            register("raster_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LEADED_GLASS_CTM_PANE = register("raster_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RECTANGLE_BLACK_WOOL =
            register("rectangle_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_BLUE_WOOL =
            register("rectangle_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_BROWN_WOOL =
            register("rectangle_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));


    // ===== RECOVERED WAVE4 =====
    public static final DeferredBlock<Block> RECTANGLE_CYAN_WOOL =
            register("rectangle_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_GRAY_WOOL =
            register("rectangle_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_GREEN_WOOL =
            register("rectangle_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_LIGHT_BLUE_WOOL =
            register("rectangle_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_LIGHT_GRAY_WOOL =
            register("rectangle_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_LIME_WOOL =
            register("rectangle_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_MAGENTA_WOOL =
            register("rectangle_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_ORANGE_WOOL =
            register("rectangle_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_PINK_WOOL =
            register("rectangle_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_PURPLE_WOOL =
            register("rectangle_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_RED_WOOL =
            register("rectangle_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_WHITE_WOOL =
            register("rectangle_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_YELLOW_WOOL =
            register("rectangle_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<LeavesBlock> RED_ACACIA_LEAVES =
            register("red_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_BIRCH_LEAVES =
            register("red_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<Block> RED_CONCRETE_CTM =
            register("red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> RED_CONCRETE_PANEL =
            register("red_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<LeavesBlock> RED_DARK_OAK_LEAVES =
            register("red_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_JUNGLE_LEAVES =
            register("red_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_OAK_LEAVES =
            register("red_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_SPRUCE_LEAVES =
            register("red_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_COLUMN =
            register("red_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_CTM =
            register("red_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> SCALY_MUD =
            register("scaly_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> SCALY_PACKED_MUD =
            register("scaly_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> SIMPLE_AMETHYST_BLOCK_CTM =
            register("simple_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_ANCIENT_DEBRIS_CTM =
            register("simple_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> SIMPLE_ANDESITE_CTM =
            register("simple_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> SIMPLE_BASALT_CTM =
            register("simple_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> SIMPLE_BLACKSTONE_CTM =
            register("simple_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> SIMPLE_BLUE_ICE_CTM =
            register("simple_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> SIMPLE_BORDERLESS_BRICKS_CTM =
            register("simple_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_BRICKS_CTM =
            register("simple_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_CALCITE_CTM =
            register("simple_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> SIMPLE_CLAY_CTM =
            register("simple_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> SIMPLE_COAL_BLOCK_CTM =
            register("simple_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_COBBLESTONE_CTM =
            register("simple_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> SIMPLE_CRYING_OBSIDIAN_CTM =
            register("simple_crying_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> SIMPLE_DARK_PRISMARINE_CTM =
            register("simple_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> SIMPLE_DEEPSLATE_CTM =
            register("simple_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SIMPLE_DIORITE_CTM =
            register("simple_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> SIMPLE_DIRT_CTM =
            register("simple_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> SIMPLE_DRIPSTONE_BLOCK_CTM =
            register("simple_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_END_STONE_CTM =
            register("simple_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> SIMPLE_GILDED_BLACKSTONE_CTM =
            register("simple_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> SIMPLE_ICE_CTM =
            register("simple_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> SIMPLE_LAPIS_BLOCK_CTM =
            register("simple_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_LODESTONE_CTM =
            register("simple_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> SIMPLE_MAGMA_BLOCK_CTM =
            register("simple_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_MOSSY_COBBLESTONE_CTM =
            register("simple_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> SIMPLE_MOSSY_STONE_BRICKS_CTM =
            register("simple_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_MUD_BRICKS_CTM =
            register("simple_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_MUD_CTM =
            register("simple_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> SIMPLE_NETHER_BRICKS_CTM =
            register("simple_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_NETHERRACK_CTM =
            register("simple_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> SIMPLE_OBSIDIAN_CTM =
            register("simple_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> SIMPLE_PACKED_ICE_CTM =
            register("simple_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> SIMPLE_PACKED_MUD_CTM =
            register("simple_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> SIMPLE_PRISMARINE_CTM =
            register("simple_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> SIMPLE_PURPUR_BLOCK_CTM =
            register("simple_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_QUARTZ_BLOCK_CTM =
            register("simple_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_COPPER_BLOCK_CTM =
            register("simple_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_GOLD_BLOCK_CTM =
            register("simple_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_IRON_BLOCK_CTM =
            register("simple_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RED_NETHER_BRICKS_CTM =
            register("simple_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_RED_SANDSTONE_CTM =
            register("simple_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> SIMPLE_REDSTONE_BLOCK_CTM =
            register("simple_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_SANDSTONE_CTM =
            register("simple_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SIMPLE_SMOOTH_STONE_CTM =
            register("simple_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> SIMPLE_SNOW_BLOCK_CTM =
            register("simple_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_TUFF_CTM =
            register("simple_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> SMALL_BLACK_DIAMOND_STAINED_GLASS =
            register("small_black_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> SMALL_BLACK_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_black_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_BLACK_STAINED_GLASS =
            register("small_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLACK_TERRACOTTA_TILES =
            register("small_black_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BLUE_DIAMOND_STAINED_GLASS =
            register("small_blue_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> SMALL_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_blue_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_BLUE_STAINED_GLASS =
            register("small_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLUE_TERRACOTTA_TILES =
            register("small_blue_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BROWN_DIAMOND_STAINED_GLASS =
            register("small_brown_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> SMALL_BROWN_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_brown_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_BROWN_STAINED_GLASS =
            register("small_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BROWN_TERRACOTTA_TILES =
            register("small_brown_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_CYAN_DIAMOND_STAINED_GLASS =
            register("small_cyan_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> SMALL_CYAN_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_cyan_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_CYAN_STAINED_GLASS =
            register("small_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_CYAN_TERRACOTTA_TILES =
            register("small_cyan_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_DIAMOND_LEADED_GLASS =
            register("small_diamond_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_DIAMOND_LEADED_GLASS_CTM =
            register("small_diamond_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_DIAMOND_LEADED_GLASS_CTM_PANE = register("small_diamond_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_GRAY_DIAMOND_STAINED_GLASS =
            register("small_gray_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> SMALL_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_gray_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_GRAY_STAINED_GLASS =
            register("small_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GRAY_TERRACOTTA_TILES =
            register("small_gray_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_GREEN_DIAMOND_STAINED_GLASS =
            register("small_green_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> SMALL_GREEN_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_green_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_GREEN_STAINED_GLASS =
            register("small_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GREEN_TERRACOTTA_TILES =
            register("small_green_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_TERRACOTTA_TILES =
            register("small_light_blue_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_TERRACOTTA_TILES =
            register("small_light_gray_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIME_TERRACOTTA_TILES =
            register("small_lime_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_TERRACOTTA_TILES =
            register("small_magenta_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_ORANGE_TERRACOTTA_TILES =
            register("small_orange_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_PINK_TERRACOTTA_TILES =
            register("small_pink_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_PURPLE_TERRACOTTA_TILES =
            register("small_purple_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_RED_TERRACOTTA_TILES =
            register("small_red_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_TERRACOTTA_TILES =
            register("small_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_WHITE_TERRACOTTA_TILES =
            register("small_white_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_YELLOW_TERRACOTTA_TILES =
            register("small_yellow_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> SMOOTH_AMETHYST_BLOCK_COLUMN =
            register("smooth_amethyst_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_ANCIENT_DEBRIS_COLUMN =
            register("smooth_ancient_debris_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> SMOOTH_ANDESITE_COLUMN =
            register("smooth_andesite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> SMOOTH_BASALT_COLUMN =
            register("smooth_basalt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> SMOOTH_BLACK_CONCRETE =
            register("smooth_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BLACKSTONE_COLUMN =
            register("smooth_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> SMOOTH_BLUE_CONCRETE =
            register("smooth_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BLUE_ICE_COLUMN =
            register("smooth_blue_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> SMOOTH_BORDERLESS_BRICKS_COLUMN =
            register("smooth_borderless_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_BRICKS_COLUMN =
            register("smooth_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_BROWN_CONCRETE =
            register("smooth_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_CALCITE_COLUMN =
            register("smooth_calcite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> SMOOTH_CLAY_COLUMN =
            register("smooth_clay_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> SMOOTH_COAL_BLOCK_COLUMN =
            register("smooth_coal_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_COBBLESTONE_COLUMN =
            register("smooth_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> SMOOTH_CRYING_OBSIDIAN_COLUMN =
            register("smooth_crying_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> SMOOTH_CYAN_CONCRETE =
            register("smooth_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_DARK_PRISMARINE_COLUMN =
            register("smooth_dark_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> SMOOTH_DEEPSLATE_COLUMN =
            register("smooth_deepslate_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SMOOTH_DIORITE_COLUMN =
            register("smooth_diorite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> SMOOTH_DIRT_COLUMN =
            register("smooth_dirt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> SMOOTH_DRIPSTONE_BLOCK_COLUMN =
            register("smooth_dripstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_END_STONE_COLUMN =
            register("smooth_end_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> SMOOTH_GILDED_BLACKSTONE_COLUMN =
            register("smooth_gilded_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> SMOOTH_GRAY_CONCRETE =
            register("smooth_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_GREEN_CONCRETE =
            register("smooth_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_ICE_COLUMN =
            register("smooth_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> SMOOTH_LAPIS_BLOCK_COLUMN =
            register("smooth_lapis_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_LIGHT_BLUE_CONCRETE =
            register("smooth_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIGHT_GRAY_CONCRETE =
            register("smooth_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIME_CONCRETE =
            register("smooth_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LODESTONE_COLUMN =
            register("smooth_lodestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> SMOOTH_MAGENTA_CONCRETE =
            register("smooth_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_MAGMA_BLOCK_COLUMN =
            register("smooth_magma_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_MOSSY_COBBLESTONE_COLUMN =
            register("smooth_mossy_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> SMOOTH_MOSSY_STONE_BRICKS_COLUMN =
            register("smooth_mossy_stone_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_NETHER_BRICKS_COLUMN =
            register("smooth_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_NETHERRACK_COLUMN =
            register("smooth_netherrack_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> SMOOTH_OBSIDIAN_COLUMN =
            register("smooth_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> SMOOTH_ORANGE_CONCRETE =
            register("smooth_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PACKED_ICE_COLUMN =
            register("smooth_packed_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> SMOOTH_PINK_CONCRETE =
            register("smooth_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PRISMARINE_COLUMN =
            register("smooth_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> SMOOTH_PURPLE_CONCRETE =
            register("smooth_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PURPUR_BLOCK_COLUMN =
            register("smooth_purpur_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_QUARTZ_BLOCK_COLUMN =
            register("smooth_quartz_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_COPPER_BLOCK_COLUMN =
            register("smooth_raw_copper_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_GOLD_BLOCK_COLUMN =
            register("smooth_raw_gold_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_IRON_BLOCK_COLUMN =
            register("smooth_raw_iron_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RED_CONCRETE =
            register("smooth_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_RED_NETHER_BRICKS_COLUMN =
            register("smooth_red_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_RED_SANDSTONE_COLUMN =
            register("smooth_red_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> SMOOTH_REDSTONE_BLOCK_COLUMN =
            register("smooth_redstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_SANDSTONE_COLUMN =
            register("smooth_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SMOOTH_SMOOTH_STONE_COLUMN =
            register("smooth_smooth_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> SMOOTH_SNOW_BLOCK_COLUMN =
            register("smooth_snow_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_TUFF_COLUMN =
            register("smooth_tuff_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> SMOOTH_WHITE_CONCRETE =
            register("smooth_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_YELLOW_CONCRETE =
            register("smooth_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_PANEL =
            register("spruce_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_SWIRLING_CTM_PANE = register("spruce_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SQUARE_BLACK_STAINED_GLASS =
            register("square_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BLUE_STAINED_GLASS =
            register("square_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BROWN_STAINED_GLASS =
            register("square_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_CYAN_STAINED_GLASS =
            register("square_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_GRAY_STAINED_GLASS =
            register("square_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_GREEN_STAINED_GLASS =
            register("square_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LEADED_GLASS =
            register("square_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SQUARE_OAK_GLASS_CTM =
            register("square_oak_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SQUARE_OAK_GLASS_CTM_PANE = register("square_oak_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> STARRY_BLACK_TERRACOTTA =
            register("starry_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BLUE_TERRACOTTA =
            register("starry_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BROWN_TERRACOTTA =
            register("starry_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_CYAN_TERRACOTTA =
            register("starry_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_GRAY_TERRACOTTA =
            register("starry_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_GREEN_TERRACOTTA =
            register("starry_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIGHT_BLUE_TERRACOTTA =
            register("starry_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIGHT_GRAY_TERRACOTTA =
            register("starry_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIME_TERRACOTTA =
            register("starry_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_MAGENTA_TERRACOTTA =
            register("starry_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_ORANGE_TERRACOTTA =
            register("starry_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_PINK_TERRACOTTA =
            register("starry_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_PURPLE_TERRACOTTA =
            register("starry_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_RED_TERRACOTTA =
            register("starry_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_TERRACOTTA =
            register("starry_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_WHITE_TERRACOTTA =
            register("starry_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_YELLOW_TERRACOTTA =
            register("starry_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> STRIPED_BLACK_CONCRETE =
            register("striped_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BLUE_CONCRETE =
            register("striped_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BROWN_CONCRETE =
            register("striped_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_CYAN_CONCRETE =
            register("striped_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_GRAY_CONCRETE =
            register("striped_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_GREEN_CONCRETE =
            register("striped_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIGHT_BLUE_CONCRETE =
            register("striped_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIGHT_GRAY_CONCRETE =
            register("striped_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIME_CONCRETE =
            register("striped_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_MAGENTA_CONCRETE =
            register("striped_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_ORANGE_CONCRETE =
            register("striped_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_PINK_CONCRETE =
            register("striped_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_PURPLE_CONCRETE =
            register("striped_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_RED_CONCRETE =
            register("striped_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_WHITE_CONCRETE =
            register("striped_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_YELLOW_CONCRETE =
            register("striped_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> TERRACOTTA_COLUMN =
            register("terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> TERRACOTTA_CTM =
            register("terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> THICK_INLAYED_AMETHYST_BLOCK =
            register("thick_inlayed_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_ANCIENT_DEBRIS =
            register("thick_inlayed_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> THICK_INLAYED_ANDESITE =
            register("thick_inlayed_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BASALT =
            register("thick_inlayed_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> THICK_INLAYED_BLACKSTONE =
            register("thick_inlayed_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BLUE_ICE =
            register("thick_inlayed_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BORDERLESS_BRICKS =
            register("thick_inlayed_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_BRICKS =
            register("thick_inlayed_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_CALCITE =
            register("thick_inlayed_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_CLAY =
            register("thick_inlayed_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> THICK_INLAYED_COAL_BLOCK =
            register("thick_inlayed_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_COBBLESTONE =
            register("thick_inlayed_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_CRYING_OBSIDIAN =
            register("thick_inlayed_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> THICK_INLAYED_DARK_PRISMARINE =
            register("thick_inlayed_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DEEPSLATE =
            register("thick_inlayed_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DIORITE =
            register("thick_inlayed_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DIRT =
            register("thick_inlayed_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> THICK_INLAYED_DRIPSTONE_BLOCK =
            register("thick_inlayed_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_END_STONE =
            register("thick_inlayed_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_GILDED_BLACKSTONE =
            register("thick_inlayed_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_ICE =
            register("thick_inlayed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_LAPIS_BLOCK =
            register("thick_inlayed_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_LODESTONE =
            register("thick_inlayed_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_MAGMA_BLOCK =
            register("thick_inlayed_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_MOSSY_COBBLESTONE =
            register("thick_inlayed_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_MOSSY_STONE_BRICKS =
            register("thick_inlayed_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_NETHER_BRICKS =
            register("thick_inlayed_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_NETHERRACK =
            register("thick_inlayed_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> THICK_INLAYED_OBSIDIAN =
            register("thick_inlayed_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> THICK_INLAYED_PACKED_ICE =
            register("thick_inlayed_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_PRISMARINE =
            register("thick_inlayed_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> THICK_INLAYED_PURPUR_BLOCK =
            register("thick_inlayed_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_QUARTZ_BLOCK =
            register("thick_inlayed_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_COPPER_BLOCK =
            register("thick_inlayed_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_GOLD_BLOCK =
            register("thick_inlayed_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_IRON_BLOCK =
            register("thick_inlayed_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RED_NETHER_BRICKS =
            register("thick_inlayed_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_RED_SANDSTONE =
            register("thick_inlayed_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_REDSTONE_BLOCK =
            register("thick_inlayed_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_SANDSTONE =
            register("thick_inlayed_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_SMOOTH_STONE =
            register("thick_inlayed_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_SNOW_BLOCK =
            register("thick_inlayed_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_TUFF =
            register("thick_inlayed_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TIED_BAMBOO_PLANKS =
            register("tied_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> TILED_AMETHYST_BLOCK_COLUMN =
            register("tiled_amethyst_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TILED_ANCIENT_DEBRIS_COLUMN =
            register("tiled_ancient_debris_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TILED_ANDESITE_COLUMN =
            register("tiled_andesite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TILED_BASALT_COLUMN =
            register("tiled_basalt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TILED_BLACK_STAINED_GLASS =
            register("tiled_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLACK_STAINED_GLASS_CTM =
            register("tiled_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> TILED_BLACK_STAINED_GLASS_CTM_PANE = register("tiled_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> TILED_BLACKSTONE_COLUMN =
            register("tiled_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BLUE_ICE_COLUMN =
            register("tiled_blue_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TILED_BLUE_STAINED_GLASS =
            register("tiled_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLUE_STAINED_GLASS_CTM =
            register("tiled_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> TILED_BLUE_STAINED_GLASS_CTM_PANE = register("tiled_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> TILED_BORDERED_AMETHYST_BLOCK =
            register("tiled_bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_ANCIENT_DEBRIS =
            register("tiled_bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TILED_BORDERED_ANDESITE =
            register("tiled_bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BASALT =
            register("tiled_bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TILED_BORDERED_BLACKSTONE =
            register("tiled_bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BLUE_ICE =
            register("tiled_bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BORDERLESS_BRICKS =
            register("tiled_bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_BRICKS =
            register("tiled_bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_CALCITE =
            register("tiled_bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_CLAY =
            register("tiled_bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TILED_BORDERED_COAL_BLOCK =
            register("tiled_bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_COBBLESTONE =
            register("tiled_bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_CRYING_OBSIDIAN =
            register("tiled_bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_BORDERED_DARK_PRISMARINE =
            register("tiled_bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DEEPSLATE =
            register("tiled_bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DIORITE =
            register("tiled_bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DIRT =
            register("tiled_bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TILED_BORDERED_DRIPSTONE_BLOCK =
            register("tiled_bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_END_STONE =
            register("tiled_bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_GILDED_BLACKSTONE =
            register("tiled_bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_ICE =
            register("tiled_bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_LAPIS_BLOCK =
            register("tiled_bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_LODESTONE =
            register("tiled_bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_MAGMA_BLOCK =
            register("tiled_bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_MOSSY_COBBLESTONE =
            register("tiled_bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_MOSSY_STONE_BRICKS =
            register("tiled_bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_MUD =
            register("tiled_bordered_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> TILED_BORDERED_MUD_BRICKS =
            register("tiled_bordered_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_NETHER_BRICKS =
            register("tiled_bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_NETHERRACK =
            register("tiled_bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TILED_BORDERED_OBSIDIAN =
            register("tiled_bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_BORDERED_PACKED_ICE =
            register("tiled_bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_PACKED_MUD =
            register("tiled_bordered_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> TILED_BORDERED_PRISMARINE =
            register("tiled_bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TILED_BORDERED_PURPUR_BLOCK =
            register("tiled_bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_QUARTZ_BLOCK =
            register("tiled_bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_COPPER_BLOCK =
            register("tiled_bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_GOLD_BLOCK =
            register("tiled_bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_IRON_BLOCK =
            register("tiled_bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RED_NETHER_BRICKS =
            register("tiled_bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_RED_SANDSTONE =
            register("tiled_bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_REDSTONE_BLOCK =
            register("tiled_bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_SANDSTONE =
            register("tiled_bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_SMOOTH_STONE =
            register("tiled_bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_SNOW_BLOCK =
            register("tiled_bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_TUFF =
            register("tiled_bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TILED_BORDERLESS_BRICKS_COLUMN =
            register("tiled_borderless_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BRICKS_COLUMN =
            register("tiled_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BROWN_STAINED_GLASS =
            register("tiled_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BROWN_STAINED_GLASS_CTM =
            register("tiled_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> TILED_BROWN_STAINED_GLASS_CTM_PANE = register("tiled_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> TILED_CALCITE_COLUMN =
            register("tiled_calcite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TILED_CLAY_COLUMN =
            register("tiled_clay_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TILED_COAL_BLOCK_COLUMN =
            register("tiled_coal_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TILED_COBBLESTONE_COLUMN =
            register("tiled_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_CRYING_OBSIDIAN_COLUMN =
            register("tiled_crying_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_CYAN_STAINED_GLASS =
            register("tiled_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_CYAN_STAINED_GLASS_CTM =
            register("tiled_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> TILED_CYAN_STAINED_GLASS_CTM_PANE = register("tiled_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> TILED_DARK_PRISMARINE_COLUMN =
            register("tiled_dark_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TILED_DEEPSLATE_COLUMN =
            register("tiled_deepslate_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TILED_DIORITE_COLUMN =
            register("tiled_diorite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TILED_DIRT_COLUMN =
            register("tiled_dirt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TILED_DRIPSTONE_BLOCK_COLUMN =
            register("tiled_dripstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_END_STONE_COLUMN =
            register("tiled_end_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TILED_GILDED_BLACKSTONE_COLUMN =
            register("tiled_gilded_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_GRAY_STAINED_GLASS =
            register("tiled_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GRAY_STAINED_GLASS_CTM =
            register("tiled_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> TILED_GRAY_STAINED_GLASS_CTM_PANE = register("tiled_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> TILED_GREEN_STAINED_GLASS =
            register("tiled_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GREEN_STAINED_GLASS_CTM =
            register("tiled_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<CtmPaneBlock> TILED_GREEN_STAINED_GLASS_CTM_PANE = register("tiled_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> TILED_ICE_COLUMN =
            register("tiled_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TILED_LAPIS_BLOCK_COLUMN =
            register("tiled_lapis_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TILED_LODESTONE_COLUMN =
            register("tiled_lodestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TILED_MAGMA_BLOCK_COLUMN =
            register("tiled_magma_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TILED_MOSSY_COBBLESTONE_COLUMN =
            register("tiled_mossy_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_MOSSY_STONE_BRICKS_COLUMN =
            register("tiled_mossy_stone_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TILED_MUD_BRICKS_COLUMN =
            register("tiled_mud_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> TILED_MUD_COLUMN =
            register("tiled_mud_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> TILED_NETHER_BRICKS_COLUMN =
            register("tiled_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_NETHERRACK_COLUMN =
            register("tiled_netherrack_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TILED_OBSIDIAN_COLUMN =
            register("tiled_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_PACKED_ICE_COLUMN =
            register("tiled_packed_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TILED_PACKED_MUD_COLUMN =
            register("tiled_packed_mud_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> TILED_PRISMARINE_COLUMN =
            register("tiled_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TILED_PURPUR_BLOCK_COLUMN =
            register("tiled_purpur_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TILED_QUARTZ_BLOCK_COLUMN =
            register("tiled_quartz_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_COPPER_BLOCK_COLUMN =
            register("tiled_raw_copper_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_GOLD_BLOCK_COLUMN =
            register("tiled_raw_gold_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_IRON_BLOCK_COLUMN =
            register("tiled_raw_iron_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TILED_RED_NETHER_BRICKS_COLUMN =
            register("tiled_red_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_RED_SANDSTONE_COLUMN =
            register("tiled_red_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TILED_REDSTONE_BLOCK_COLUMN =
            register("tiled_redstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_SANDSTONE_COLUMN =
            register("tiled_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TILED_SMOOTH_STONE_COLUMN =
            register("tiled_smooth_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TILED_SNOW_BLOCK_COLUMN =
            register("tiled_snow_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TILED_TUFF_COLUMN =
            register("tiled_tuff_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_AMETHYST_BLOCK =
            register("tiny_brick_bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ANCIENT_DEBRIS =
            register("tiny_brick_bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ANDESITE =
            register("tiny_brick_bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BASALT =
            register("tiny_brick_bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BLACKSTONE =
            register("tiny_brick_bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BLUE_ICE =
            register("tiny_brick_bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BORDERLESS_BRICKS =
            register("tiny_brick_bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BRICKS =
            register("tiny_brick_bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CALCITE =
            register("tiny_brick_bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CLAY =
            register("tiny_brick_bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_COAL_BLOCK =
            register("tiny_brick_bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_COBBLESTONE =
            register("tiny_brick_bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CRYING_OBSIDIAN =
            register("tiny_brick_bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DARK_PRISMARINE =
            register("tiny_brick_bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DEEPSLATE =
            register("tiny_brick_bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DIORITE =
            register("tiny_brick_bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DIRT =
            register("tiny_brick_bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DRIPSTONE_BLOCK =
            register("tiny_brick_bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_END_STONE =
            register("tiny_brick_bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_GILDED_BLACKSTONE =
            register("tiny_brick_bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ICE =
            register("tiny_brick_bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_LAPIS_BLOCK =
            register("tiny_brick_bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_LODESTONE =
            register("tiny_brick_bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MAGMA_BLOCK =
            register("tiny_brick_bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MOSSY_COBBLESTONE =
            register("tiny_brick_bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS =
            register("tiny_brick_bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_NETHER_BRICKS =
            register("tiny_brick_bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_NETHERRACK =
            register("tiny_brick_bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_OBSIDIAN =
            register("tiny_brick_bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PACKED_ICE =
            register("tiny_brick_bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PRISMARINE =
            register("tiny_brick_bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PURPUR_BLOCK =
            register("tiny_brick_bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_QUARTZ_BLOCK =
            register("tiny_brick_bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_COPPER_BLOCK =
            register("tiny_brick_bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_GOLD_BLOCK =
            register("tiny_brick_bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_IRON_BLOCK =
            register("tiny_brick_bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RED_NETHER_BRICKS =
            register("tiny_brick_bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RED_SANDSTONE =
            register("tiny_brick_bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_REDSTONE_BLOCK =
            register("tiny_brick_bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SANDSTONE =
            register("tiny_brick_bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SMOOTH_STONE =
            register("tiny_brick_bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SNOW_BLOCK =
            register("tiny_brick_bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_TUFF =
            register("tiny_brick_bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> VERTICAL_LEADED_GLASS =
            register("vertical_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BLACK_STAINED_GLASS =
            register("vertical_striped_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BLUE_STAINED_GLASS =
            register("vertical_striped_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BROWN_STAINED_GLASS =
            register("vertical_striped_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_CYAN_STAINED_GLASS =
            register("vertical_striped_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_GRAY_STAINED_GLASS =
            register("vertical_striped_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_GREEN_STAINED_GLASS =
            register("vertical_striped_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WARPED_PLANKS_PANEL =
            register("warped_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_SWIRLING_CTM_PANE = register("warped_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WHIRLWIND_ACACIA_PLANKS =
            register("whirlwind_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_BAMBOO_PLANKS =
            register("whirlwind_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_BIRCH_PLANKS =
            register("whirlwind_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_OAK_PLANKS =
            register("whirlwind_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_CTM =
            register("white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_PANEL =
            register("white_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_ACACIA_LEAVES =
            register("white_flower_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_BIRCH_LEAVES =
            register("white_flower_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_DARK_OAK_LEAVES =
            register("white_flower_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_JUNGLE_LEAVES =
            register("white_flower_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_OAK_LEAVES =
            register("white_flower_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_SPRUCE_LEAVES =
            register("white_flower_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<Block> WIRED_BLACK_CONCRETE =
            register("wired_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BLUE_CONCRETE =
            register("wired_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BROWN_CONCRETE =
            register("wired_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_CYAN_CONCRETE =
            register("wired_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_GRAY_CONCRETE =
            register("wired_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_GREEN_CONCRETE =
            register("wired_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIGHT_BLUE_CONCRETE =
            register("wired_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIGHT_GRAY_CONCRETE =
            register("wired_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIME_CONCRETE =
            register("wired_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_MAGENTA_CONCRETE =
            register("wired_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_ORANGE_CONCRETE =
            register("wired_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_PINK_CONCRETE =
            register("wired_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_PURPLE_CONCRETE =
            register("wired_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_RED_CONCRETE =
            register("wired_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_WHITE_CONCRETE =
            register("wired_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_YELLOW_CONCRETE =
            register("wired_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> WOVEN_BLACK_STAINED_GLASS =
            register("woven_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BLUE_STAINED_GLASS =
            register("woven_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BROWN_STAINED_GLASS =
            register("woven_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_CYAN_STAINED_GLASS =
            register("woven_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_GRAY_STAINED_GLASS =
            register("woven_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_GREEN_STAINED_GLASS =
            register("woven_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_CTM =
            register("yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_PANEL =
            register("yellow_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_COLUMN =
            register("yellow_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_CTM =
            register("yellow_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));


    // ===== RECOVERED PURPUR_CTM =====


    // ===== Reverted stonecutter-only diamond pavers (kept in ott) =====
    public static final DeferredBlock<Block> BLACK_MARBLE_DIAMOND_PAVERS = register("black_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_DIAMOND_PAVERS = register("white_marble_diamond_pavers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
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

}