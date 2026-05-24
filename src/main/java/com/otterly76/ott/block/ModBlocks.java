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

    public static final List<DeferredBlock<? extends IGradientBlock>> ALL_GRADIENT_BLOCKS = new ArrayList<>();

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
    public static final List<String> DOOR_STYLES = List.of(
            "beach", "boarded", "dual_paneled", "fortified", "gated", "glass",
            "heavy", "modern", "overgrown", "paneled", "paper", "pressed",
            "screen", "secret", "shack", "sliding", "supported",
            "tile_windowed", "tiled", "windowed");
    public static final Map<String, Map<String, DeferredBlock<DoorBlock>>> WOOD_DOORS = new LinkedHashMap<>();

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

            // In 1.21.1, all 8 variants of lightning rods and copper grates are vanilla?
            // Wait, only lightning_rod is vanilla. Weathered variants of lightning rods are backported.
            // All 8 variants of copper grates ARE vanilla in 1.21.1.
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

    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Sandstone decorative (Roman) ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<PlateBlock> SANDSTONE_CRENELATION = register("sandstone_crenelation",
            () -> new PlateBlock(Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));
    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Flat/Gray Roof Tiles + Roofing Slates (General) ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<Block> ROOFING_SLATES = register("roofing_slates",
            () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Rammed Dirt, Stepping Stones (General) ---
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // --- DoTB Phase 2: Thatch (General) ---
    // -------------------------------------------------------------------------
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


    // -------------------------------------------------------------------------
    // --- DoTB Phase 3: Stone Bricks Masonry + German misc (German) ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<Block> STONE_BRICKS_MASONRY = register("stone_bricks_masonry", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<com.otterly76.ott.block.custom.EdgeBlock> STONE_BRICKS_MASONRY_EDGE = register("stone_bricks_masonry_edge", () -> new com.otterly76.ott.block.custom.EdgeBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<com.otterly76.ott.block.custom.PlateBlock> STONE_BRICKS_MASONRY_PLATE = register("stone_bricks_masonry_plate", () -> new com.otterly76.ott.block.custom.PlateBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RakedGravelBlock> CURVED_RAKED_GRAVEL = register("curved_raked_gravel", () -> new RakedGravelBlock(true, Properties.ofFullCopy(Blocks.GRAVEL)));
    public static final DeferredBlock<RakedGravelBlock> STRAIGHT_RAKED_GRAVEL = register("straight_raked_gravel", () -> new RakedGravelBlock(false, Properties.ofFullCopy(Blocks.GRAVEL)));


    // -------------------------------------------------------------------------
    // --- Sandstone Slender ---
    // -------------------------------------------------------------------------
    public static final DeferredBlock<Block> SANDSTONE_SLENDER_BRICKS = register("sandstone_slender_bricks", () -> new Block(Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SANDSTONE_SLENDER_TURQUOISE_PATTERN = register("sandstone_slender_turquoise_pattern", () -> new Block(Properties.ofFullCopy(Blocks.SANDSTONE)));

    // -------------------------------------------------------------------------
    // --- Ornamented Carpets + Wool ---
    // -------------------------------------------------------------------------
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


    // -------------------------------------------------------------------------
    // --- Oak structural blocks ---
    // -------------------------------------------------------------------------
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
    // =========================================================================
    // === DoTB Phase 5: General Decorative & Functional ===
    // =========================================================================
    public static final DeferredBlock<PlacedLanternBlock> STONE_LANTERN = register("stone_lantern", () -> new PlacedLanternBlock(Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<LitPlacedLanternBlock> IRON_FANCY_LANTERN = register("iron_fancy_lantern", () -> new LitPlacedLanternBlock(Properties.of().strength(3.5f).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion().lightLevel(s -> s.getValue(LitPlacedLanternBlock.LIT) ? 15 : 0)));
    public static final DeferredBlock<StarlightLampBlock> STARLIGHT_LAMP = register("starlight_lamp", () -> new StarlightLampBlock(Properties.of().strength(0.5F).sound(SoundType.GLASS).noOcclusion().lightLevel(s -> 15)));

    // =========================================================================
    // === DoTB Phase 2: Roman Marble extras ===
    // =========================================================================

    // =========================================================================
    // === DoTB Phase 2: Roman Birch Furniture ===
    // =========================================================================

    // =========================================================================
    // === DoTB Phase 3: German Waxed Oak extras ===
    // =========================================================================

    // =========================================================================
    // === DoTB Phase 3: Japanese Spruce extras ===
    // =========================================================================
    public static final DeferredBlock<FenceBlock> SPRUCE_LOG_FENCE = register("spruce_log_fence", () -> new FenceBlock(Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));

    // =========================================================================
    // === DoTB Phase 3: Japanese Bamboo extras ===
    // =========================================================================

    // =========================================================================
    // === DoTB Phase 3: Japanese Furniture & Decor ===
    // =========================================================================


    // =========================================================================
    // === Stone Variant Blocks (simple CTM — Chipped style) ===
    // =========================================================================
    private static final Properties ST = Properties.ofFullCopy(Blocks.STONE);

    // --- Plain cube_all ---
    public static final DeferredBlock<Block> ANGRY_STONE = register("angry_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> BLANK_STONE_CARVING = register("blank_stone_carving", () -> new Block(ST));
    public static final DeferredBlock<Block> BRICK_BORDERED_STONE = register("brick_bordered_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> CARVED_STONE = register("carved_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> CHECKERED_STONE_TILES = register("checkered_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> COBBLED_STONE = register("cobbled_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> CRACKED_DISORDERED_STONE_BRICKS = register("cracked_disordered_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> CRACKED_FLAT_STONE_TILES = register("cracked_flat_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> CREEPER_STONE_CARVING = register("creeper_stone_carving", () -> new Block(ST));
    public static final DeferredBlock<Block> CRYING_STONE = register("crying_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> CURLY_STONE_PILLAR = register("curly_stone_pillar", () -> new Block(ST));
    public static final DeferredBlock<Block> CUT_BLANK_STONE = register("cut_blank_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> DUH_STONE = register("duh_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> ENGRAVED_STONE = register("engraved_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> ETCHED_STONE_BRICKS = register("etched_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> FINE_STONE_PILLAR = register("fine_stone_pillar", () -> new Block(ST));
    public static final DeferredBlock<Block> FLAT_STONE_TILES = register("flat_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> GLAD_STONE = register("glad_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> INLAYED_STONE = register("inlayed_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> INSCRIBED_STONE = register("inscribed_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> LAYED_STONE_BRICKS = register("layed_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> LODED_STONE = register("loded_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> OFFSET_STONE_BRICKS = register("offset_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> ORNATE_STONE_PILLAR = register("ornate_stone_pillar", () -> new Block(ST));
    public static final DeferredBlock<Block> OVERLAPPING_STONE_TILES = register("overlapping_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> PILLAR_STONE_BRICKS = register("pillar_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> POLISHED_STONE = register("polished_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> PRISMAL_STONE_REMNANTS = register("prismal_stone_remnants", () -> new Block(ST));
    public static final DeferredBlock<Block> ROUGH_STONE = register("rough_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> ROUNDED_STONE_BRICKS = register("rounded_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> RUNIC_CARVED_STONE = register("runic_carved_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> SAD_STONE = register("sad_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> SANDED_STONE = register("sanded_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> SIMPLE_STONE_PILLAR = register("simple_stone_pillar", () -> new Block(ST));
    public static final DeferredBlock<Block> SMALL_STONE_BRICKS = register("small_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> SMOOTH_INLAYED_STONE = register("smooth_inlayed_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> SMOOTHED_DOUBLE_INLAYED_STONE = register("smoothed_double_inlayed_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> SPIDER_STONE_CARVING = register("spider_stone_carving", () -> new Block(ST));
    public static final DeferredBlock<Block> SPIRALED_STONE = register("spiraled_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> STACKED_STONE_BRICKS = register("stacked_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_MINI_TILES = register("stone_mini_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_SCALES = register("stone_scales", () -> new Block(ST));
    public static final DeferredBlock<Block> THICK_INLAYED_STONE = register("thick_inlayed_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> TILED_BORDERED_STONE = register("tiled_bordered_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> TILED_STONE = register("tiled_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_STONE = register("tiny_brick_bordered_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> TINY_LAYERED_STONE_BRICKS = register("tiny_layered_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> TINY_LAYERED_STONE_SLABS = register("tiny_layered_stone_slabs", () -> new Block(ST));
    public static final DeferredBlock<Block> TINY_STONE_BRICKS = register("tiny_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> TRODDEN_STONE = register("trodden_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> UNAMUSED_STONE = register("unamused_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> VERTICAL_CUT_STONE = register("vertical_cut_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> VERTICAL_DISORDERED_STONE_BRICKS = register("vertical_disordered_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> WEATHERED_STONE = register("weathered_stone", () -> new Block(ST));

    // --- Column (RotatedPillarBlock) ---
    public static final DeferredBlock<RotatedPillarBlock> STONE_PILLAR = register("stone_pillar", () -> new RotatedPillarBlock(ST));

    // --- Static decorative (plain cube_all, future CTM cousins pending) ---
    public static final DeferredBlock<Block> BORDERED_STONE = register("bordered_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> EDGED_STONE_BRICKS = register("edged_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> MASSIVE_STONE_BRICKS = register("massive_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> CUT_STONE_COLUMN = register("cut_stone_column", () -> new Block(ST));
    public static final DeferredBlock<Block> SMOOTH_STONE_COLUMN = register("smooth_stone_column", () -> new Block(ST));
    public static final DeferredBlock<Block> TILED_STONE_COLUMN = register("tiled_stone_column", () -> new Block(ST));
    public static final DeferredBlock<Block> PURPUR_PILLAR_CTM = register("purpur_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SANDSTONE_CTM = register("sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_CTM = register("red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> BORDERED_ANDESITE_CTM = register("bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> POLISHED_ANDESITE_CTM = register("polished_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)));
    public static final DeferredBlock<Block> POLISHED_BLACKSTONE_CTM = register("polished_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE)));
    public static final DeferredBlock<Block> POLISHED_DIORITE_CTM = register("polished_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE)));
    public static final DeferredBlock<Block> POLISHED_GRANITE_CTM = register("polished_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_CTM = register("netherite_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_STONE_CTM = register("smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CTM = register("emerald_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
    public static final DeferredBlock<RotatedPillarBlock> CHISELED_PLASTERED_STONE_PILLAR = register("chiseled_plastered_stone_pillar", () -> new RotatedPillarBlock(ST));
    // CTM vertical pillars
    public static final DeferredBlock<Block> BONE_BLOCK_PILLAR = register("bone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));
    public static final DeferredBlock<Block> COAL_BLOCK_PILLAR = register("coal_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_PILLAR = register("cobbled_deepslate_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)));
    public static final DeferredBlock<Block> COBBLESTONE_PILLAR = register("cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_PILLAR = register("copper_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_COPPER_BLOCK)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_PILLAR = register("lapis_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_PILLAR = register("netherite_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> OBSIDIAN_PILLAR = register("obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

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

    // --- New cube-bottom-top stone blocks ---
    public static final DeferredBlock<Block> CARVED_STONE_CREEPER = register("carved_stone_creeper", () -> new Block(ST));
    public static final DeferredBlock<Block> CARVED_STONE_DERP = register("carved_stone_derp", () -> new Block(ST));
    public static final DeferredBlock<Block> CARVED_STONE_VILLAGER = register("carved_stone_villager", () -> new Block(ST));
    public static final DeferredBlock<Block> CARVED_STONE_WITHER = register("carved_stone_wither", () -> new Block(ST));
    public static final DeferredBlock<Block> CARVED_STONE_WRITING = register("carved_stone_writing", () -> new Block(ST));
    public static final DeferredBlock<Block> CUT_STONE = register("cut_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> ROUGH_CUT_STONE = register("rough_cut_stone", () -> new Block(ST));

    // --- New RotatedPillarBlocks ---
    public static final DeferredBlock<RotatedPillarBlock> SHEARED_STONE_PILLAR = register("sheared_stone_pillar", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> SLATED_STONE = register("slated_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> STONE_COLUMN = register("stone_column", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> STONE_TWISTING_COLUMN = register("stone_twisting_column", () -> new RotatedPillarBlock(ST));

    // ── Batch CTM blocks ─────────────────────────────────────────────────────
    // ── Acacia Planks ──
    public static final DeferredBlock<Block> ACACIA_PLANKS_PANEL =
            register("acacia_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_ACACIA_PLANKS =
            register("cornered_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> CRATED_ACACIA_PLANKS =
            register("crated_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_ACACIA_PLANKS =
            register("enclosed_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_ACACIA_PLANKS =
            register("framed_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_ACACIA_PLANKS =
            register("natural_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_ACACIA_PLANKS =
            register("pegged_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_ACACIA_PLANKS =
            register("whirlwind_acacia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));

    // ── Amethyst Block ──
    public static final DeferredBlock<Block> BORDERED_AMETHYST_BLOCK =
            register("bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_AMETHYST_BLOCK =
            register("brick_bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CURLY_AMETHYST_BLOCK_PILLAR =
            register("curly_amethyst_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CUT_AMETHYST_BLOCK_COLUMN =
            register("cut_amethyst_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> EDGED_AMETHYST_BLOCK_BRICKS =
            register("edged_amethyst_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> FINE_AMETHYST_BLOCK_PILLAR =
            register("fine_amethyst_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_AMETHYST_BLOCK_BRICKS =
            register("massive_amethyst_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_AMETHYST_BLOCK_PILLAR =
            register("ornate_amethyst_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_AMETHYST_BLOCK_TILES =
            register("overlapping_amethyst_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_AMETHYST_BLOCK =
            register("polished_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_AMETHYST_BLOCK_PILLAR =
            register("simple_amethyst_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_AMETHYST_BLOCK_COLUMN =
            register("smooth_amethyst_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_AMETHYST_BLOCK =
            register("thick_inlayed_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TILED_AMETHYST_BLOCK_COLUMN =
            register("tiled_amethyst_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_AMETHYST_BLOCK =
            register("tiled_bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_AMETHYST_BLOCK =
            register("tiny_brick_bordered_amethyst_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    // ── Ancient Debris ──
    public static final DeferredBlock<Block> BORDERED_ANCIENT_DEBRIS =
            register("bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ANCIENT_DEBRIS =
            register("brick_bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> CURLY_ANCIENT_DEBRIS_PILLAR =
            register("curly_ancient_debris_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> CUT_ANCIENT_DEBRIS_COLUMN =
            register("cut_ancient_debris_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> EDGED_ANCIENT_DEBRIS_BRICKS =
            register("edged_ancient_debris_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> FINE_ANCIENT_DEBRIS_PILLAR =
            register("fine_ancient_debris_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> MASSIVE_ANCIENT_DEBRIS_BRICKS =
            register("massive_ancient_debris_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> ORNATE_ANCIENT_DEBRIS_PILLAR =
            register("ornate_ancient_debris_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> OVERLAPPING_ANCIENT_DEBRIS_TILES =
            register("overlapping_ancient_debris_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> POLISHED_ANCIENT_DEBRIS =
            register("polished_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> SIMPLE_ANCIENT_DEBRIS_PILLAR =
            register("simple_ancient_debris_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> SMOOTH_ANCIENT_DEBRIS_COLUMN =
            register("smooth_ancient_debris_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> THICK_INLAYED_ANCIENT_DEBRIS =
            register("thick_inlayed_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TILED_ANCIENT_DEBRIS_COLUMN =
            register("tiled_ancient_debris_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TILED_BORDERED_ANCIENT_DEBRIS =
            register("tiled_bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ANCIENT_DEBRIS =
            register("tiny_brick_bordered_ancient_debris", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));

    // ── Andesite ──
    public static final DeferredBlock<Block> BRICK_BORDERED_ANDESITE =
            register("brick_bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CURLY_ANDESITE_PILLAR =
            register("curly_andesite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CUT_ANDESITE_COLUMN =
            register("cut_andesite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> EDGED_ANDESITE_BRICKS =
            register("edged_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> FINE_ANDESITE_PILLAR =
            register("fine_andesite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> MASSIVE_ANDESITE_BRICKS =
            register("massive_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> ORNATE_ANDESITE_PILLAR =
            register("ornate_andesite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> OVERLAPPING_ANDESITE_TILES =
            register("overlapping_andesite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> SIMPLE_ANDESITE_PILLAR =
            register("simple_andesite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> SMOOTH_ANDESITE_COLUMN =
            register("smooth_andesite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_ANDESITE =
            register("thick_inlayed_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TILED_ANDESITE_COLUMN =
            register("tiled_andesite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_ANDESITE =
            register("tiled_bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ANDESITE =
            register("tiny_brick_bordered_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));

    // ── Bamboo Planks ──
    public static final DeferredBlock<Block> BAMBOO_PLANKS_PANEL =
            register("bamboo_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_BAMBOO_PLANKS =
            register("cornered_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> CRATED_BAMBOO_PLANKS =
            register("crated_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_BAMBOO_PLANKS =
            register("enclosed_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_BAMBOO_PLANKS =
            register("framed_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_BAMBOO_PLANKS =
            register("natural_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> POLISHED_BAMBOO_PLANKS =
            register("polished_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> TIED_BAMBOO_PLANKS =
            register("tied_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_BAMBOO_PLANKS =
            register("whirlwind_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));

    // ── Basalt ──
    public static final DeferredBlock<Block> BORDERED_BASALT =
            register("bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BASALT =
            register("brick_bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CURLY_BASALT_PILLAR =
            register("curly_basalt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CUT_BASALT_COLUMN =
            register("cut_basalt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> EDGED_BASALT_BRICKS =
            register("edged_basalt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> FINE_BASALT_PILLAR =
            register("fine_basalt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> MASSIVE_BASALT_BRICKS =
            register("massive_basalt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> ORNATE_BASALT_PILLAR =
            register("ornate_basalt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> OVERLAPPING_BASALT_TILES =
            register("overlapping_basalt_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> POLISHED_BASALT =
            register("polished_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> SIMPLE_BASALT_PILLAR =
            register("simple_basalt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> SMOOTH_BASALT_COLUMN =
            register("smooth_basalt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> THICK_INLAYED_BASALT =
            register("thick_inlayed_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TILED_BASALT_COLUMN =
            register("tiled_basalt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TILED_BORDERED_BASALT =
            register("tiled_bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BASALT =
            register("tiny_brick_bordered_basalt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));

    // ── Birch Planks ──
    public static final DeferredBlock<Block> BIRCH_PLANKS_PANEL =
            register("birch_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> CORNERED_BIRCH_PLANKS =
            register("cornered_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> CRATED_BIRCH_PLANKS =
            register("crated_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_BIRCH_PLANKS =
            register("enclosed_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_BIRCH_PLANKS =
            register("framed_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_BIRCH_PLANKS =
            register("natural_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_BIRCH_PLANKS =
            register("pegged_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> POLISHED_BIRCH_PLANKS =
            register("polished_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_BIRCH_PLANKS =
            register("whirlwind_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));

    // ── Blackstone ──
    public static final DeferredBlock<Block> BORDERED_BLACKSTONE =
            register("bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BLACKSTONE =
            register("brick_bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> CURLY_BLACKSTONE_PILLAR =
            register("curly_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> CUT_BLACKSTONE_COLUMN =
            register("cut_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> EDGED_BLACKSTONE_BRICKS =
            register("edged_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> FINE_BLACKSTONE_PILLAR =
            register("fine_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> MASSIVE_BLACKSTONE_BRICKS =
            register("massive_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> ORNATE_BLACKSTONE_PILLAR =
            register("ornate_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_BLACKSTONE_TILES =
            register("overlapping_blackstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> SIMPLE_BLACKSTONE_PILLAR =
            register("simple_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> SMOOTH_BLACKSTONE_COLUMN =
            register("smooth_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BLACKSTONE =
            register("thick_inlayed_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BLACKSTONE_COLUMN =
            register("tiled_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BLACKSTONE =
            register("tiled_bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BLACKSTONE =
            register("tiny_brick_bordered_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));

    // ── Black Concrete ──
    public static final DeferredBlock<Block> BLACK_CONCRETE_PANEL =
            register("black_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_CONCRETE_PILLAR =
            register("black_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BLACK_CONCRETE =
            register("grill_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BLACK_CONCRETE =
            register("pegged_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BLACK_CONCRETE =
            register("smooth_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BLACK_CONCRETE =
            register("striped_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BLACK_CONCRETE =
            register("wired_black_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));

    // ── Black Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_BLACK_STAINED_GLASS_PILLAR =
            register("arched_black_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BLACK_STAINED_GLASS =
            register("circular_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLACK_STAINED_GLASS_PILLAR =
            register("fancy_black_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLACK_STAINED_GLASS_PILLAR =
            register("ornate_black_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLACK_STAINED_GLASS_PILLAR =
            register("raster_black_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLACK_DIAMOND_STAINED_GLASS =
            register("small_black_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLACK_STAINED_GLASS_PILLAR =
            register("tiled_black_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLACK_LEADED_STAINED_GLASS =
            register("black_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLACK_STAINED_GLASS =
            register("fancy_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BLACK_STAINED_GLASS =
            register("large_diamond_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLACK_STAINED_GLASS =
            register("ornate_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLACK_STAINED_GLASS =
            register("raster_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLACK_STAINED_GLASS =
            register("small_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BLACK_STAINED_GLASS =
            register("square_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLACK_STAINED_GLASS =
            register("tiled_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BLACK_STAINED_GLASS =
            register("vertical_striped_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BLACK_STAINED_GLASS =
            register("woven_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));

    // ── Black Terracotta ──
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_COLUMN =
            register("black_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_PILLAR =
            register("black_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BLACK_TERRACOTTA =
            register("circular_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BLACK_TERRACOTTA =
            register("curled_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BLACK_TERRACOTTA =
            register("hexagonical_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BLACK_TERRACOTTA =
            register("inscribed_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BLACK_TERRACOTTA_TILES =
            register("small_black_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BLACK_TERRACOTTA =
            register("starry_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));

    // ── Black Wool ──
    public static final DeferredBlock<Block> CORNERED_BLACK_WOOL =
            register("cornered_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_BLACK_WOOL =
            register("crafted_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_BLACK_WOOL =
            register("harsh_quilted_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_BLACK_WOOL =
            register("rectangle_black_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));

    // ── Blue Concrete ──
    public static final DeferredBlock<Block> BLUE_CONCRETE_PANEL =
            register("blue_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_PILLAR =
            register("blue_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BLUE_CONCRETE =
            register("grill_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BLUE_CONCRETE =
            register("pegged_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BLUE_CONCRETE =
            register("smooth_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BLUE_CONCRETE =
            register("striped_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BLUE_CONCRETE =
            register("wired_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));

    // ── Blue Ice ──
    public static final DeferredBlock<Block> BORDERED_BLUE_ICE =
            register("bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BLUE_ICE =
            register("brick_bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> CURLY_BLUE_ICE_PILLAR =
            register("curly_blue_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> CUT_BLUE_ICE_COLUMN =
            register("cut_blue_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> EDGED_BLUE_ICE_BRICKS =
            register("edged_blue_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> FINE_BLUE_ICE_PILLAR =
            register("fine_blue_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> MASSIVE_BLUE_ICE_BRICKS =
            register("massive_blue_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> ORNATE_BLUE_ICE_PILLAR =
            register("ornate_blue_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_BLUE_ICE_TILES =
            register("overlapping_blue_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> POLISHED_BLUE_ICE =
            register("polished_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> SIMPLE_BLUE_ICE_PILLAR =
            register("simple_blue_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> SMOOTH_BLUE_ICE_COLUMN =
            register("smooth_blue_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BLUE_ICE =
            register("thick_inlayed_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TILED_BLUE_ICE_COLUMN =
            register("tiled_blue_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BLUE_ICE =
            register("tiled_bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BLUE_ICE =
            register("tiny_brick_bordered_blue_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));

    // ── Blue Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_BLUE_STAINED_GLASS_PILLAR =
            register("arched_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BLUE_STAINED_GLASS =
            register("circular_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLUE_STAINED_GLASS_PILLAR =
            register("fancy_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLUE_STAINED_GLASS_PILLAR =
            register("ornate_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLUE_STAINED_GLASS_PILLAR =
            register("raster_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLUE_DIAMOND_STAINED_GLASS =
            register("small_blue_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLUE_STAINED_GLASS_PILLAR =
            register("tiled_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLUE_LEADED_STAINED_GLASS =
            register("blue_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLUE_STAINED_GLASS =
            register("fancy_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BLUE_STAINED_GLASS =
            register("large_diamond_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLUE_STAINED_GLASS =
            register("ornate_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLUE_STAINED_GLASS =
            register("raster_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLUE_STAINED_GLASS =
            register("small_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BLUE_STAINED_GLASS =
            register("square_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLUE_STAINED_GLASS =
            register("tiled_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BLUE_STAINED_GLASS =
            register("vertical_striped_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BLUE_STAINED_GLASS =
            register("woven_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));

    // ── Blue Terracotta ──
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_COLUMN =
            register("blue_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_PILLAR =
            register("blue_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BLUE_TERRACOTTA =
            register("circular_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BLUE_TERRACOTTA =
            register("curled_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BLUE_TERRACOTTA =
            register("hexagonical_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BLUE_TERRACOTTA =
            register("inscribed_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BLUE_TERRACOTTA_TILES =
            register("small_blue_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BLUE_TERRACOTTA =
            register("starry_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));

    // ── Blue Wool ──
    public static final DeferredBlock<Block> CORNERED_BLUE_WOOL =
            register("cornered_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_BLUE_WOOL =
            register("crafted_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_BLUE_WOOL =
            register("harsh_quilted_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_BLUE_WOOL =
            register("rectangle_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));

    // ── Borderless Bricks ──
    public static final DeferredBlock<Block> BORDERED_BORDERLESS_BRICKS =
            register("bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BORDERLESS_BRICKS =
            register("brick_bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CURLY_BORDERLESS_BRICKS_PILLAR =
            register("curly_borderless_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CUT_BORDERLESS_BRICKS_COLUMN =
            register("cut_borderless_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> EDGED_BORDERLESS_BRICKS_BRICKS =
            register("edged_borderless_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> FINE_BORDERLESS_BRICKS_PILLAR =
            register("fine_borderless_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_BORDERLESS_BRICKS_BRICKS =
            register("massive_borderless_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> ORNATE_BORDERLESS_BRICKS_PILLAR =
            register("ornate_borderless_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_BORDERLESS_BRICKS_TILES =
            register("overlapping_borderless_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> POLISHED_BORDERLESS_BRICKS =
            register("polished_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_BORDERLESS_BRICKS_PILLAR =
            register("simple_borderless_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_BORDERLESS_BRICKS_COLUMN =
            register("smooth_borderless_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_BORDERLESS_BRICKS =
            register("thick_inlayed_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_BORDERLESS_BRICKS =
            register("tiled_bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERLESS_BRICKS_COLUMN =
            register("tiled_borderless_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BORDERLESS_BRICKS =
            register("tiny_brick_bordered_borderless_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));

    // ── Bricks ──
    public static final DeferredBlock<Block> BORDERED_BRICKS =
            register("bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BRICKS =
            register("brick_bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CURLY_BRICKS_PILLAR =
            register("curly_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CUT_BRICKS_COLUMN =
            register("cut_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> EDGED_BRICKS_BRICKS =
            register("edged_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> FINE_BRICKS_PILLAR =
            register("fine_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_BRICKS_BRICKS =
            register("massive_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> ORNATE_BRICKS_PILLAR =
            register("ornate_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_BRICKS_TILES =
            register("overlapping_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> POLISHED_BRICKS =
            register("polished_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_BRICKS_PILLAR =
            register("simple_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_BRICKS_COLUMN =
            register("smooth_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_BRICKS =
            register("thick_inlayed_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_BRICKS =
            register("tiled_bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BRICKS_COLUMN =
            register("tiled_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BRICKS =
            register("tiny_brick_bordered_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));

    // ── Brown Concrete ──
    public static final DeferredBlock<Block> BROWN_CONCRETE_PANEL =
            register("brown_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_CONCRETE_PILLAR =
            register("brown_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BROWN_CONCRETE =
            register("grill_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BROWN_CONCRETE =
            register("pegged_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BROWN_CONCRETE =
            register("smooth_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BROWN_CONCRETE =
            register("striped_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BROWN_CONCRETE =
            register("wired_brown_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));

    // ── Brown Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_BROWN_STAINED_GLASS_PILLAR =
            register("arched_brown_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BROWN_STAINED_GLASS =
            register("circular_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BROWN_STAINED_GLASS_PILLAR =
            register("fancy_brown_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BROWN_STAINED_GLASS_PILLAR =
            register("ornate_brown_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BROWN_STAINED_GLASS_PILLAR =
            register("raster_brown_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BROWN_DIAMOND_STAINED_GLASS =
            register("small_brown_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BROWN_STAINED_GLASS_PILLAR =
            register("tiled_brown_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> BROWN_LEADED_STAINED_GLASS =
            register("brown_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BROWN_STAINED_GLASS =
            register("fancy_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BROWN_STAINED_GLASS =
            register("large_diamond_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BROWN_STAINED_GLASS =
            register("ornate_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BROWN_STAINED_GLASS =
            register("raster_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BROWN_STAINED_GLASS =
            register("small_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BROWN_STAINED_GLASS =
            register("square_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BROWN_STAINED_GLASS =
            register("tiled_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BROWN_STAINED_GLASS =
            register("vertical_striped_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BROWN_STAINED_GLASS =
            register("woven_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));

    // ── Brown Terracotta ──
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_COLUMN =
            register("brown_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_PILLAR =
            register("brown_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BROWN_TERRACOTTA =
            register("circular_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BROWN_TERRACOTTA =
            register("curled_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BROWN_TERRACOTTA =
            register("hexagonical_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BROWN_TERRACOTTA =
            register("inscribed_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BROWN_TERRACOTTA_TILES =
            register("small_brown_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BROWN_TERRACOTTA =
            register("starry_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));

    // ── Brown Wool ──
    public static final DeferredBlock<Block> CORNERED_BROWN_WOOL =
            register("cornered_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_BROWN_WOOL =
            register("crafted_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_BROWN_WOOL =
            register("harsh_quilted_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_BROWN_WOOL =
            register("rectangle_brown_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));

    // ── Calcite ──
    public static final DeferredBlock<Block> BORDERED_CALCITE =
            register("bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CALCITE =
            register("brick_bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CURLY_CALCITE_PILLAR =
            register("curly_calcite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CUT_CALCITE_COLUMN =
            register("cut_calcite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> EDGED_CALCITE_BRICKS =
            register("edged_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> FINE_CALCITE_PILLAR =
            register("fine_calcite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> MASSIVE_CALCITE_BRICKS =
            register("massive_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> ORNATE_CALCITE_PILLAR =
            register("ornate_calcite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> OVERLAPPING_CALCITE_TILES =
            register("overlapping_calcite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> POLISHED_CALCITE =
            register("polished_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> SIMPLE_CALCITE_PILLAR =
            register("simple_calcite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> SMOOTH_CALCITE_COLUMN =
            register("smooth_calcite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_CALCITE =
            register("thick_inlayed_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_CALCITE =
            register("tiled_bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TILED_CALCITE_COLUMN =
            register("tiled_calcite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CALCITE =
            register("tiny_brick_bordered_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));

    // ── Cherry Planks ──
    public static final DeferredBlock<Block> CHERRY_PLANKS_PANEL =
            register("cherry_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
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
    public static final DeferredBlock<Block> BORDERED_CLAY =
            register("bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CLAY =
            register("brick_bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> CURLY_CLAY_PILLAR =
            register("curly_clay_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> CUT_CLAY_COLUMN =
            register("cut_clay_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> EDGED_CLAY_BRICKS =
            register("edged_clay_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> FINE_CLAY_PILLAR =
            register("fine_clay_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> MASSIVE_CLAY_BRICKS =
            register("massive_clay_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> ORNATE_CLAY_PILLAR =
            register("ornate_clay_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> OVERLAPPING_CLAY_TILES =
            register("overlapping_clay_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> POLISHED_CLAY =
            register("polished_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> SIMPLE_CLAY_PILLAR =
            register("simple_clay_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> SMOOTH_CLAY_COLUMN =
            register("smooth_clay_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> THICK_INLAYED_CLAY =
            register("thick_inlayed_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TILED_BORDERED_CLAY =
            register("tiled_bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TILED_CLAY_COLUMN =
            register("tiled_clay_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CLAY =
            register("tiny_brick_bordered_clay", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));

    // ── Coal Block ──
    public static final DeferredBlock<Block> BORDERED_COAL_BLOCK =
            register("bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_COAL_BLOCK =
            register("brick_bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> CURLY_COAL_BLOCK_PILLAR =
            register("curly_coal_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> CUT_COAL_BLOCK_COLUMN =
            register("cut_coal_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> EDGED_COAL_BLOCK_BRICKS =
            register("edged_coal_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> FINE_COAL_BLOCK_PILLAR =
            register("fine_coal_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_COAL_BLOCK_BRICKS =
            register("massive_coal_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_COAL_BLOCK_PILLAR =
            register("ornate_coal_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_COAL_BLOCK_TILES =
            register("overlapping_coal_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_COAL_BLOCK =
            register("polished_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_COAL_BLOCK_PILLAR =
            register("simple_coal_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_COAL_BLOCK_COLUMN =
            register("smooth_coal_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_COAL_BLOCK =
            register("thick_inlayed_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_COAL_BLOCK =
            register("tiled_bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TILED_COAL_BLOCK_COLUMN =
            register("tiled_coal_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_COAL_BLOCK =
            register("tiny_brick_bordered_coal_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    // ── Cobblestone ──
    public static final DeferredBlock<Block> BORDERED_COBBLESTONE =
            register("bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_COBBLESTONE =
            register("brick_bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> CURLY_COBBLESTONE_PILLAR =
            register("curly_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> CUT_COBBLESTONE_COLUMN =
            register("cut_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> EDGED_COBBLESTONE_BRICKS =
            register("edged_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> FINE_COBBLESTONE_PILLAR =
            register("fine_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> MASSIVE_COBBLESTONE_BRICKS =
            register("massive_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> ORNATE_COBBLESTONE_PILLAR =
            register("ornate_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_COBBLESTONE_TILES =
            register("overlapping_cobblestone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> POLISHED_COBBLESTONE =
            register("polished_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> SIMPLE_COBBLESTONE_PILLAR =
            register("simple_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> SMOOTH_COBBLESTONE_COLUMN =
            register("smooth_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_COBBLESTONE =
            register("thick_inlayed_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_COBBLESTONE =
            register("tiled_bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_COBBLESTONE_COLUMN =
            register("tiled_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_COBBLESTONE =
            register("tiny_brick_bordered_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));

    // ── Crimson Planks ──
    public static final DeferredBlock<Block> CORNERED_CRIMSON_PLANKS =
            register("cornered_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> CRATED_CRIMSON_PLANKS =
            register("crated_crimson_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_PANEL =
            register("crimson_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
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
    public static final DeferredBlock<Block> BORDERED_CRYING_OBSIDIAN =
            register("bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CRYING_OBSIDIAN =
            register("brick_bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> CURLY_CRYING_OBSIDIAN_PILLAR =
            register("curly_crying_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> CUT_CRYING_OBSIDIAN_COLUMN =
            register("cut_crying_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> EDGED_CRYING_OBSIDIAN_BRICKS =
            register("edged_crying_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> FINE_CRYING_OBSIDIAN_PILLAR =
            register("fine_crying_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> MASSIVE_CRYING_OBSIDIAN_BRICKS =
            register("massive_crying_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> ORNATE_CRYING_OBSIDIAN_PILLAR =
            register("ornate_crying_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> OVERLAPPING_CRYING_OBSIDIAN_TILES =
            register("overlapping_crying_obsidian_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> POLISHED_CRYING_OBSIDIAN =
            register("polished_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> SIMPLE_CRYING_OBSIDIAN_PILLAR =
            register("simple_crying_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> SMOOTH_CRYING_OBSIDIAN_COLUMN =
            register("smooth_crying_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> THICK_INLAYED_CRYING_OBSIDIAN =
            register("thick_inlayed_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_BORDERED_CRYING_OBSIDIAN =
            register("tiled_bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_CRYING_OBSIDIAN_COLUMN =
            register("tiled_crying_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CRYING_OBSIDIAN =
            register("tiny_brick_bordered_crying_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));

    // ── Cyan Concrete ──
    public static final DeferredBlock<Block> CYAN_CONCRETE_PANEL =
            register("cyan_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_CONCRETE_PILLAR =
            register("cyan_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_CYAN_CONCRETE =
            register("grill_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_CYAN_CONCRETE =
            register("pegged_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_CYAN_CONCRETE =
            register("smooth_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_CYAN_CONCRETE =
            register("striped_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_CYAN_CONCRETE =
            register("wired_cyan_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));

    // ── Cyan Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_CYAN_STAINED_GLASS_PILLAR =
            register("arched_cyan_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_CYAN_STAINED_GLASS =
            register("circular_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_CYAN_STAINED_GLASS_PILLAR =
            register("fancy_cyan_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_CYAN_STAINED_GLASS_PILLAR =
            register("ornate_cyan_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_CYAN_STAINED_GLASS_PILLAR =
            register("raster_cyan_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_CYAN_DIAMOND_STAINED_GLASS =
            register("small_cyan_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_CYAN_STAINED_GLASS_PILLAR =
            register("tiled_cyan_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CYAN_LEADED_STAINED_GLASS =
            register("cyan_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_CYAN_STAINED_GLASS =
            register("fancy_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_CYAN_STAINED_GLASS =
            register("large_diamond_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_CYAN_STAINED_GLASS =
            register("ornate_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_CYAN_STAINED_GLASS =
            register("raster_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_CYAN_STAINED_GLASS =
            register("small_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_CYAN_STAINED_GLASS =
            register("square_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_CYAN_STAINED_GLASS =
            register("tiled_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_CYAN_STAINED_GLASS =
            register("vertical_striped_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_CYAN_STAINED_GLASS =
            register("woven_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));

    // ── Cyan Terracotta ──
    public static final DeferredBlock<Block> CIRCULAR_CYAN_TERRACOTTA =
            register("circular_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_CYAN_TERRACOTTA =
            register("curled_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_COLUMN =
            register("cyan_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_PILLAR =
            register("cyan_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_CYAN_TERRACOTTA =
            register("hexagonical_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_CYAN_TERRACOTTA =
            register("inscribed_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_CYAN_TERRACOTTA_TILES =
            register("small_cyan_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_CYAN_TERRACOTTA =
            register("starry_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));

    // ── Cyan Wool ──
    public static final DeferredBlock<Block> CORNERED_CYAN_WOOL =
            register("cornered_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_CYAN_WOOL =
            register("crafted_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_CYAN_WOOL =
            register("harsh_quilted_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_CYAN_WOOL =
            register("rectangle_cyan_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));

    // ── Dark Oak Planks ──
    public static final DeferredBlock<Block> CORNERED_DARK_OAK_PLANKS =
            register("cornered_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> CRATED_DARK_OAK_PLANKS =
            register("crated_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_PANEL =
            register("dark_oak_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
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
    public static final DeferredBlock<Block> BORDERED_DARK_PRISMARINE =
            register("bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DARK_PRISMARINE =
            register("brick_bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CURLY_DARK_PRISMARINE_PILLAR =
            register("curly_dark_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CUT_DARK_PRISMARINE_COLUMN =
            register("cut_dark_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> EDGED_DARK_PRISMARINE_BRICKS =
            register("edged_dark_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> FINE_DARK_PRISMARINE_PILLAR =
            register("fine_dark_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> MASSIVE_DARK_PRISMARINE_BRICKS =
            register("massive_dark_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> ORNATE_DARK_PRISMARINE_PILLAR =
            register("ornate_dark_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> OVERLAPPING_DARK_PRISMARINE_TILES =
            register("overlapping_dark_prismarine_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> POLISHED_DARK_PRISMARINE =
            register("polished_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> SIMPLE_DARK_PRISMARINE_PILLAR =
            register("simple_dark_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> SMOOTH_DARK_PRISMARINE_COLUMN =
            register("smooth_dark_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DARK_PRISMARINE =
            register("thick_inlayed_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DARK_PRISMARINE =
            register("tiled_bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TILED_DARK_PRISMARINE_COLUMN =
            register("tiled_dark_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DARK_PRISMARINE =
            register("tiny_brick_bordered_dark_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));

    // ── Deepslate ──
    public static final DeferredBlock<Block> BORDERED_DEEPSLATE =
            register("bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DEEPSLATE =
            register("brick_bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> CURLY_DEEPSLATE_PILLAR =
            register("curly_deepslate_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> CUT_DEEPSLATE_COLUMN =
            register("cut_deepslate_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> EDGED_DEEPSLATE_BRICKS =
            register("edged_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> FINE_DEEPSLATE_PILLAR =
            register("fine_deepslate_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MASSIVE_DEEPSLATE_BRICKS =
            register("massive_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> ORNATE_DEEPSLATE_PILLAR =
            register("ornate_deepslate_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> OVERLAPPING_DEEPSLATE_TILES =
            register("overlapping_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> POLISHED_DEEPSLATE =
            register("polished_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SIMPLE_DEEPSLATE_PILLAR =
            register("simple_deepslate_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SMOOTH_DEEPSLATE_COLUMN =
            register("smooth_deepslate_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DEEPSLATE =
            register("thick_inlayed_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DEEPSLATE =
            register("tiled_bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TILED_DEEPSLATE_COLUMN =
            register("tiled_deepslate_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DEEPSLATE =
            register("tiny_brick_bordered_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // ── Diorite ──
    public static final DeferredBlock<Block> BORDERED_DIORITE =
            register("bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DIORITE =
            register("brick_bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CURLY_DIORITE_PILLAR =
            register("curly_diorite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CUT_DIORITE_COLUMN =
            register("cut_diorite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> EDGED_DIORITE_BRICKS =
            register("edged_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> FINE_DIORITE_PILLAR =
            register("fine_diorite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> MASSIVE_DIORITE_BRICKS =
            register("massive_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> ORNATE_DIORITE_PILLAR =
            register("ornate_diorite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> OVERLAPPING_DIORITE_TILES =
            register("overlapping_diorite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> SIMPLE_DIORITE_PILLAR =
            register("simple_diorite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> SMOOTH_DIORITE_COLUMN =
            register("smooth_diorite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DIORITE =
            register("thick_inlayed_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DIORITE =
            register("tiled_bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TILED_DIORITE_COLUMN =
            register("tiled_diorite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DIORITE =
            register("tiny_brick_bordered_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));

    // ── Dirt ──
    public static final DeferredBlock<Block> BORDERED_DIRT =
            register("bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DIRT =
            register("brick_bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> CURLY_DIRT_PILLAR =
            register("curly_dirt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> CUT_DIRT_COLUMN =
            register("cut_dirt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> EDGED_DIRT_BRICKS =
            register("edged_dirt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> FINE_DIRT_PILLAR =
            register("fine_dirt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> MASSIVE_DIRT_BRICKS =
            register("massive_dirt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> ORNATE_DIRT_PILLAR =
            register("ornate_dirt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> OVERLAPPING_DIRT_TILES =
            register("overlapping_dirt_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> POLISHED_DIRT =
            register("polished_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> SIMPLE_DIRT_PILLAR =
            register("simple_dirt_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> SMOOTH_DIRT_COLUMN =
            register("smooth_dirt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> THICK_INLAYED_DIRT =
            register("thick_inlayed_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TILED_BORDERED_DIRT =
            register("tiled_bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TILED_DIRT_COLUMN =
            register("tiled_dirt_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DIRT =
            register("tiny_brick_bordered_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    // ── Dripstone ──
    public static final DeferredBlock<Block> BORDERED_DRIPSTONE_BLOCK =
            register("bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DRIPSTONE_BLOCK =
            register("brick_bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CURLY_DRIPSTONE_BLOCK_PILLAR =
            register("curly_dripstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CUT_DRIPSTONE_BLOCK_COLUMN =
            register("cut_dripstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> EDGED_DRIPSTONE_BLOCK_BRICKS =
            register("edged_dripstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> FINE_DRIPSTONE_BLOCK_PILLAR =
            register("fine_dripstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_DRIPSTONE_BLOCK_BRICKS =
            register("massive_dripstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_DRIPSTONE_BLOCK_PILLAR =
            register("ornate_dripstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_DRIPSTONE_BLOCK_TILES =
            register("overlapping_dripstone_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_BLOCK =
            register("polished_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_DRIPSTONE_BLOCK_PILLAR =
            register("simple_dripstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_DRIPSTONE_BLOCK_COLUMN =
            register("smooth_dripstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_DRIPSTONE_BLOCK =
            register("thick_inlayed_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_DRIPSTONE_BLOCK =
            register("tiled_bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_DRIPSTONE_BLOCK_COLUMN =
            register("tiled_dripstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DRIPSTONE_BLOCK =
            register("tiny_brick_bordered_dripstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));

    // ── End Stone ──
    public static final DeferredBlock<Block> BORDERED_END_STONE =
            register("bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_END_STONE =
            register("brick_bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> CURLY_END_STONE_PILLAR =
            register("curly_end_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> CUT_END_STONE_COLUMN =
            register("cut_end_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> EDGED_END_STONE_BRICKS =
            register("edged_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> FINE_END_STONE_PILLAR =
            register("fine_end_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> MASSIVE_END_STONE_BRICKS =
            register("massive_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> ORNATE_END_STONE_PILLAR =
            register("ornate_end_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> OVERLAPPING_END_STONE_TILES =
            register("overlapping_end_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> POLISHED_END_STONE =
            register("polished_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> SIMPLE_END_STONE_PILLAR =
            register("simple_end_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> SMOOTH_END_STONE_COLUMN =
            register("smooth_end_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_END_STONE =
            register("thick_inlayed_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_END_STONE =
            register("tiled_bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TILED_END_STONE_COLUMN =
            register("tiled_end_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_END_STONE =
            register("tiny_brick_bordered_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

    // ── Gilded Blackston ──
    public static final DeferredBlock<Block> BORDERED_GILDED_BLACKSTONE =
            register("bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_GILDED_BLACKSTONE =
            register("brick_bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> CURLY_GILDED_BLACKSTONE_PILLAR =
            register("curly_gilded_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> CUT_GILDED_BLACKSTONE_COLUMN =
            register("cut_gilded_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> EDGED_GILDED_BLACKSTONE_BRICKS =
            register("edged_gilded_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> FINE_GILDED_BLACKSTONE_PILLAR =
            register("fine_gilded_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> MASSIVE_GILDED_BLACKSTONE_BRICKS =
            register("massive_gilded_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> ORNATE_GILDED_BLACKSTONE_PILLAR =
            register("ornate_gilded_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_GILDED_BLACKSTONE_TILES =
            register("overlapping_gilded_blackstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> POLISHED_GILDED_BLACKSTONE =
            register("polished_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> SIMPLE_GILDED_BLACKSTONE_PILLAR =
            register("simple_gilded_blackstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> SMOOTH_GILDED_BLACKSTONE_COLUMN =
            register("smooth_gilded_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_GILDED_BLACKSTONE =
            register("thick_inlayed_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_GILDED_BLACKSTONE =
            register("tiled_bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_GILDED_BLACKSTONE_COLUMN =
            register("tiled_gilded_blackstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_GILDED_BLACKSTONE =
            register("tiny_brick_bordered_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));

    // ── Granite ──
    public static final DeferredBlock<Block> BORDERED_GRANITE =
            register("bordered_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_GRANITE =
            register("brick_bordered_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CURLY_GRANITE_PILLAR =
            register("curly_granite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CUT_GRANITE_COLUMN =
            register("cut_granite_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> EDGED_GRANITE_BRICKS =
            register("edged_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> FINE_GRANITE_PILLAR =
            register("fine_granite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> GRANITE_PRISMARINE =
            register("granite_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> MASSIVE_GRANITE_BRICKS =
            register("massive_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> ORNATE_GRANITE_PILLAR =
            register("ornate_granite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> OVERLAPPING_GRANITE_TILES =
            register("overlapping_granite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> SIMPLE_GRANITE_PILLAR =
            register("simple_granite_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
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

    // ── Gray Concrete ──
    public static final DeferredBlock<Block> GRAY_CONCRETE_PANEL =
            register("gray_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_CONCRETE_PILLAR =
            register("gray_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_GRAY_CONCRETE =
            register("grill_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_GRAY_CONCRETE =
            register("pegged_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_GRAY_CONCRETE =
            register("smooth_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_GRAY_CONCRETE =
            register("striped_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_GRAY_CONCRETE =
            register("wired_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIGHT_GRAY_CONCRETE =
            register("wired_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));

    // ── Gray Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_GRAY_STAINED_GLASS_PILLAR =
            register("arched_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_GRAY_STAINED_GLASS =
            register("circular_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GRAY_STAINED_GLASS_PILLAR =
            register("fancy_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GRAY_STAINED_GLASS_PILLAR =
            register("ornate_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GRAY_STAINED_GLASS_PILLAR =
            register("raster_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GRAY_DIAMOND_STAINED_GLASS =
            register("small_gray_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GRAY_STAINED_GLASS_PILLAR =
            register("tiled_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> GRAY_LEADED_STAINED_GLASS =
            register("gray_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GRAY_STAINED_GLASS =
            register("fancy_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_GRAY_STAINED_GLASS =
            register("large_diamond_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GRAY_STAINED_GLASS =
            register("ornate_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GRAY_STAINED_GLASS =
            register("raster_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GRAY_STAINED_GLASS =
            register("small_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_GRAY_STAINED_GLASS =
            register("square_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GRAY_STAINED_GLASS =
            register("tiled_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_GRAY_STAINED_GLASS =
            register("vertical_striped_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_GRAY_STAINED_GLASS =
            register("woven_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));

    // ── Gray Terracotta ──
    public static final DeferredBlock<Block> CIRCULAR_GRAY_TERRACOTTA =
            register("circular_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_GRAY_TERRACOTTA =
            register("curled_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_COLUMN =
            register("gray_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_PILLAR =
            register("gray_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_GRAY_TERRACOTTA =
            register("hexagonical_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_GRAY_TERRACOTTA =
            register("inscribed_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_GRAY_TERRACOTTA_TILES =
            register("small_gray_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_GRAY_TERRACOTTA =
            register("starry_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));

    // ── Gray Wool ──
    public static final DeferredBlock<Block> CORNERED_GRAY_WOOL =
            register("cornered_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_GRAY_WOOL =
            register("crafted_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_GRAY_WOOL =
            register("harsh_quilted_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_GRAY_WOOL =
            register("rectangle_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));

    // ── Green Concrete ──
    public static final DeferredBlock<Block> GREEN_CONCRETE_PANEL =
            register("green_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_CONCRETE_PILLAR =
            register("green_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_GREEN_CONCRETE =
            register("grill_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_GREEN_CONCRETE =
            register("pegged_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_GREEN_CONCRETE =
            register("smooth_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_GREEN_CONCRETE =
            register("striped_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_GREEN_CONCRETE =
            register("wired_green_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));

    // ── Green Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_GREEN_STAINED_GLASS_PILLAR =
            register("arched_green_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_GREEN_STAINED_GLASS =
            register("circular_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GREEN_STAINED_GLASS_PILLAR =
            register("fancy_green_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GREEN_STAINED_GLASS_PILLAR =
            register("ornate_green_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GREEN_STAINED_GLASS_PILLAR =
            register("raster_green_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GREEN_DIAMOND_STAINED_GLASS =
            register("small_green_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GREEN_STAINED_GLASS_PILLAR =
            register("tiled_green_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> GREEN_LEADED_STAINED_GLASS =
            register("green_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GREEN_STAINED_GLASS =
            register("fancy_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_GREEN_STAINED_GLASS =
            register("large_diamond_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GREEN_STAINED_GLASS =
            register("ornate_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GREEN_STAINED_GLASS =
            register("raster_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GREEN_STAINED_GLASS =
            register("small_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_GREEN_STAINED_GLASS =
            register("square_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GREEN_STAINED_GLASS =
            register("tiled_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_GREEN_STAINED_GLASS =
            register("vertical_striped_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_GREEN_STAINED_GLASS =
            register("woven_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));

    // ── Green Terracotta ──
    public static final DeferredBlock<Block> CIRCULAR_GREEN_TERRACOTTA =
            register("circular_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_GREEN_TERRACOTTA =
            register("curled_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_COLUMN =
            register("green_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_PILLAR =
            register("green_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_GREEN_TERRACOTTA =
            register("hexagonical_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_GREEN_TERRACOTTA =
            register("inscribed_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_GREEN_TERRACOTTA_TILES =
            register("small_green_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_GREEN_TERRACOTTA =
            register("starry_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));

    // ── Green Wool ──
    public static final DeferredBlock<Block> CORNERED_GREEN_WOOL =
            register("cornered_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_GREEN_WOOL =
            register("crafted_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_GREEN_WOOL =
            register("harsh_quilted_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_GREEN_WOOL =
            register("rectangle_green_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));

    // ── Ice ──
    public static final DeferredBlock<Block> BORDERED_ICE =
            register("bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ICE =
            register("brick_bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> CURLY_ICE_PILLAR =
            register("curly_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> CUT_ICE_COLUMN =
            register("cut_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> EDGED_ICE_BRICKS =
            register("edged_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> FINE_ICE_PILLAR =
            register("fine_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> MASSIVE_ICE_BRICKS =
            register("massive_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> ORNATE_ICE_PILLAR =
            register("ornate_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_ICE_TILES =
            register("overlapping_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> POLISHED_ICE =
            register("polished_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> SIMPLE_ICE_PILLAR =
            register("simple_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> SMOOTH_ICE_COLUMN =
            register("smooth_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_ICE =
            register("thick_inlayed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_ICE =
            register("tiled_bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TILED_ICE_COLUMN =
            register("tiled_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ICE =
            register("tiny_brick_bordered_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));

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
    public static final DeferredBlock<Block> BORDERED_LAPIS_BLOCK =
            register("bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_LAPIS_BLOCK =
            register("brick_bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> CURLY_LAPIS_BLOCK_PILLAR =
            register("curly_lapis_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> CUT_LAPIS_BLOCK_COLUMN =
            register("cut_lapis_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> EDGED_LAPIS_BLOCK_BRICKS =
            register("edged_lapis_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> FINE_LAPIS_BLOCK_PILLAR =
            register("fine_lapis_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_LAPIS_BLOCK_BRICKS =
            register("massive_lapis_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_LAPIS_BLOCK_PILLAR =
            register("ornate_lapis_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_LAPIS_BLOCK_TILES =
            register("overlapping_lapis_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_LAPIS_BLOCK =
            register("polished_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_LAPIS_BLOCK_PILLAR =
            register("simple_lapis_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_LAPIS_BLOCK_COLUMN =
            register("smooth_lapis_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_LAPIS_BLOCK =
            register("thick_inlayed_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_LAPIS_BLOCK =
            register("tiled_bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TILED_LAPIS_BLOCK_COLUMN =
            register("tiled_lapis_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_LAPIS_BLOCK =
            register("tiny_brick_bordered_lapis_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));

    // ── Leaded Glass ──
    public static final DeferredBlock<Block> ARCHED_LEADED_GLASS_PILLAR =
            register("arched_leaded_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CIRCULAR_LEADED_STAINED_GLASS =
            register("circular_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CLEAR_LEADED_GLASS_PILLAR =
            register("clear_leaded_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_LEADED_GLASS =
            register("fancy_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_LEADED_GLASS_PILLAR =
            register("fancy_leaded_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_LEADED_GLASS_PILLAR =
            register("raster_leaded_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_DIAMOND_LEADED_GLASS_PILLAR =
            register("small_diamond_leaded_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CLEAR_LEADED_GLASS =
            register("clear_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LEADED_GLASS =
            register("large_diamond_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LEAD_WOVEN_GLASS =
            register("lead_woven_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_LEADED_GLASS =
            register("ornate_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_LEADED_GLASS =
            register("raster_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_DIAMOND_LEADED_GLASS =
            register("small_diamond_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SQUARE_LEADED_GLASS =
            register("square_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> VERTICAL_LEADED_GLASS =
            register("vertical_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));

    // ── Light Blue Concrete ──
    public static final DeferredBlock<Block> GRILL_LIGHT_BLUE_CONCRETE =
            register("grill_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_PANEL =
            register("light_blue_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_PILLAR =
            register("light_blue_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIGHT_BLUE_CONCRETE =
            register("pegged_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIGHT_BLUE_CONCRETE =
            register("smooth_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIGHT_BLUE_CONCRETE =
            register("striped_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIGHT_BLUE_CONCRETE =
            register("wired_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));

    // ── Light Blue Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_LIGHT_BLUE_STAINED_GLASS_PILLAR =
            register("arched_light_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_BLUE_STAINED_GLASS =
            register("circular_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_BLUE_STAINED_GLASS_PILLAR =
            register("fancy_light_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_BLUE_STAINED_GLASS_PILLAR =
            register("ornate_light_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_BLUE_STAINED_GLASS_PILLAR =
            register("raster_light_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS =
            register("small_light_blue_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_BLUE_STAINED_GLASS_PILLAR =
            register("tiled_light_blue_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_BLUE_TERRACOTTA =
            register("circular_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIGHT_BLUE_TERRACOTTA =
            register("curled_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIGHT_BLUE_TERRACOTTA =
            register("hexagonical_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIGHT_BLUE_TERRACOTTA =
            register("inscribed_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_COLUMN =
            register("light_blue_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_PILLAR =
            register("light_blue_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_TERRACOTTA_TILES =
            register("small_light_blue_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIGHT_BLUE_TERRACOTTA =
            register("starry_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));

    // ── Light Blue Wool ──
    public static final DeferredBlock<Block> CORNERED_LIGHT_BLUE_WOOL =
            register("cornered_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_LIGHT_BLUE_WOOL =
            register("crafted_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_LIGHT_BLUE_WOOL =
            register("harsh_quilted_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_LIGHT_BLUE_WOOL =
            register("rectangle_light_blue_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));

    // ── Light Gray Concrete ──
    public static final DeferredBlock<Block> GRILL_LIGHT_GRAY_CONCRETE =
            register("grill_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_PANEL =
            register("light_gray_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_PILLAR =
            register("light_gray_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIGHT_GRAY_CONCRETE =
            register("pegged_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIGHT_GRAY_CONCRETE =
            register("smooth_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIGHT_GRAY_CONCRETE =
            register("striped_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));

    // ── Light Gray Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_LIGHT_GRAY_STAINED_GLASS_PILLAR =
            register("arched_light_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_GRAY_STAINED_GLASS =
            register("circular_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_GRAY_STAINED_GLASS_PILLAR =
            register("fancy_light_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_GRAY_STAINED_GLASS_PILLAR =
            register("ornate_light_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_GRAY_STAINED_GLASS_PILLAR =
            register("raster_light_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS =
            register("small_light_gray_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_GRAY_STAINED_GLASS_PILLAR =
            register("tiled_light_gray_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_GRAY_TERRACOTTA =
            register("circular_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIGHT_GRAY_TERRACOTTA =
            register("curled_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIGHT_GRAY_TERRACOTTA =
            register("hexagonical_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIGHT_GRAY_TERRACOTTA =
            register("inscribed_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_COLUMN =
            register("light_gray_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_PILLAR =
            register("light_gray_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_TERRACOTTA_TILES =
            register("small_light_gray_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIGHT_GRAY_TERRACOTTA =
            register("starry_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));

    // ── Light Gray Wool ──
    public static final DeferredBlock<Block> CORNERED_LIGHT_GRAY_WOOL =
            register("cornered_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_LIGHT_GRAY_WOOL =
            register("crafted_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_LIGHT_GRAY_WOOL =
            register("harsh_quilted_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_LIGHT_GRAY_WOOL =
            register("rectangle_light_gray_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));

    // ── Lime Concrete ──
    public static final DeferredBlock<Block> GRILL_LIME_CONCRETE =
            register("grill_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> LIME_CONCRETE_PANEL =
            register("lime_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> LIME_CONCRETE_PILLAR =
            register("lime_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIME_CONCRETE =
            register("pegged_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIME_CONCRETE =
            register("smooth_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIME_CONCRETE =
            register("striped_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIME_CONCRETE =
            register("wired_lime_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));

    // ── Lime Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_LIME_STAINED_GLASS_PILLAR =
            register("arched_lime_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_LIME_STAINED_GLASS =
            register("circular_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIME_STAINED_GLASS_PILLAR =
            register("fancy_lime_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIME_STAINED_GLASS_PILLAR =
            register("ornate_lime_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIME_STAINED_GLASS_PILLAR =
            register("raster_lime_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIME_DIAMOND_STAINED_GLASS =
            register("small_lime_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIME_STAINED_GLASS_PILLAR =
            register("tiled_lime_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_LIME_TERRACOTTA =
            register("circular_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIME_TERRACOTTA =
            register("curled_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIME_TERRACOTTA =
            register("hexagonical_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIME_TERRACOTTA =
            register("inscribed_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_COLUMN =
            register("lime_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_PILLAR =
            register("lime_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIME_TERRACOTTA_TILES =
            register("small_lime_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIME_TERRACOTTA =
            register("starry_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));

    // ── Lime Wool ──
    public static final DeferredBlock<Block> CORNERED_LIME_WOOL =
            register("cornered_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_LIME_WOOL =
            register("crafted_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_LIME_WOOL =
            register("harsh_quilted_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_LIME_WOOL =
            register("rectangle_lime_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));

    // ── Lodestone ──
    public static final DeferredBlock<Block> BORDERED_LODESTONE =
            register("bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_LODESTONE =
            register("brick_bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> CURLY_LODESTONE_PILLAR =
            register("curly_lodestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> CUT_LODESTONE_COLUMN =
            register("cut_lodestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> EDGED_LODESTONE_BRICKS =
            register("edged_lodestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> FINE_LODESTONE_PILLAR =
            register("fine_lodestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> MASSIVE_LODESTONE_BRICKS =
            register("massive_lodestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> ORNATE_LODESTONE_PILLAR =
            register("ornate_lodestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_LODESTONE_TILES =
            register("overlapping_lodestone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> POLISHED_LODESTONE =
            register("polished_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> SIMPLE_LODESTONE_PILLAR =
            register("simple_lodestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> SMOOTH_LODESTONE_COLUMN =
            register("smooth_lodestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_LODESTONE =
            register("thick_inlayed_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_LODESTONE =
            register("tiled_bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TILED_LODESTONE_COLUMN =
            register("tiled_lodestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_LODESTONE =
            register("tiny_brick_bordered_lodestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));

    // ── Magenta Concrete ──
    public static final DeferredBlock<Block> GRILL_MAGENTA_CONCRETE =
            register("grill_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_PANEL =
            register("magenta_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_PILLAR =
            register("magenta_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_MAGENTA_CONCRETE =
            register("pegged_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_MAGENTA_CONCRETE =
            register("smooth_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_MAGENTA_CONCRETE =
            register("striped_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_MAGENTA_CONCRETE =
            register("wired_magenta_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));

    // ── Magenta Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_MAGENTA_STAINED_GLASS_PILLAR =
            register("arched_magenta_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_MAGENTA_STAINED_GLASS =
            register("circular_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_MAGENTA_STAINED_GLASS_PILLAR =
            register("fancy_magenta_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_MAGENTA_STAINED_GLASS_PILLAR =
            register("ornate_magenta_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_MAGENTA_STAINED_GLASS_PILLAR =
            register("raster_magenta_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_DIAMOND_STAINED_GLASS =
            register("small_magenta_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_MAGENTA_STAINED_GLASS_PILLAR =
            register("tiled_magenta_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_MAGENTA_TERRACOTTA =
            register("circular_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_MAGENTA_TERRACOTTA =
            register("curled_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_MAGENTA_TERRACOTTA =
            register("hexagonical_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_MAGENTA_TERRACOTTA =
            register("inscribed_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_COLUMN =
            register("magenta_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_PILLAR =
            register("magenta_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_TERRACOTTA_TILES =
            register("small_magenta_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_MAGENTA_TERRACOTTA =
            register("starry_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));

    // ── Magenta Wool ──
    public static final DeferredBlock<Block> CORNERED_MAGENTA_WOOL =
            register("cornered_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_MAGENTA_WOOL =
            register("crafted_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_MAGENTA_WOOL =
            register("harsh_quilted_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_MAGENTA_WOOL =
            register("rectangle_magenta_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));

    // ── Magma Block ──
    public static final DeferredBlock<Block> BORDERED_MAGMA_BLOCK =
            register("bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MAGMA_BLOCK =
            register("brick_bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> CURLY_MAGMA_BLOCK_PILLAR =
            register("curly_magma_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> CUT_MAGMA_BLOCK_COLUMN =
            register("cut_magma_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> EDGED_MAGMA_BLOCK_BRICKS =
            register("edged_magma_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> FINE_MAGMA_BLOCK_PILLAR =
            register("fine_magma_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_MAGMA_BLOCK_BRICKS =
            register("massive_magma_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_MAGMA_BLOCK_PILLAR =
            register("ornate_magma_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_MAGMA_BLOCK_TILES =
            register("overlapping_magma_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_MAGMA_BLOCK =
            register("polished_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_MAGMA_BLOCK_PILLAR =
            register("simple_magma_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_MAGMA_BLOCK_COLUMN =
            register("smooth_magma_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_MAGMA_BLOCK =
            register("thick_inlayed_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_MAGMA_BLOCK =
            register("tiled_bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TILED_MAGMA_BLOCK_COLUMN =
            register("tiled_magma_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MAGMA_BLOCK =
            register("tiny_brick_bordered_magma_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));

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
    public static final DeferredBlock<Block> MANGROVE_PLANKS_PANEL =
            register("mangrove_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_MANGROVE_PLANKS =
            register("natural_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_MANGROVE_PLANKS =
            register("pegged_mangrove_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));

    // ── Mossy Cobblestone ──
    public static final DeferredBlock<Block> BORDERED_MOSSY_COBBLESTONE =
            register("bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MOSSY_COBBLESTONE =
            register("brick_bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> CURLY_MOSSY_COBBLESTONE_PILLAR =
            register("curly_mossy_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> CUT_MOSSY_COBBLESTONE_COLUMN =
            register("cut_mossy_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> EDGED_MOSSY_COBBLESTONE_BRICKS =
            register("edged_mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> FINE_MOSSY_COBBLESTONE_PILLAR =
            register("fine_mossy_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> MASSIVE_MOSSY_COBBLESTONE_BRICKS =
            register("massive_mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> ORNATE_MOSSY_COBBLESTONE_PILLAR =
            register("ornate_mossy_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_MOSSY_COBBLESTONE_TILES =
            register("overlapping_mossy_cobblestone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> POLISHED_MOSSY_COBBLESTONE =
            register("polished_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> SIMPLE_MOSSY_COBBLESTONE_PILLAR =
            register("simple_mossy_cobblestone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> SMOOTH_MOSSY_COBBLESTONE_COLUMN =
            register("smooth_mossy_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_MOSSY_COBBLESTONE =
            register("thick_inlayed_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_MOSSY_COBBLESTONE =
            register("tiled_bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_MOSSY_COBBLESTONE_COLUMN =
            register("tiled_mossy_cobblestone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MOSSY_COBBLESTONE =
            register("tiny_brick_bordered_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));

    // ── Mossy Stone ──
    public static final DeferredBlock<Block> BORDERED_MOSSY_STONE_BRICKS =
            register("bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MOSSY_STONE_BRICKS =
            register("brick_bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> CURLY_MOSSY_STONE_BRICKS_PILLAR =
            register("curly_mossy_stone_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> CUT_MOSSY_STONE_BRICKS_COLUMN =
            register("cut_mossy_stone_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> EDGED_MOSSY_STONE_BRICKS_BRICKS =
            register("edged_mossy_stone_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> FINE_MOSSY_STONE_BRICKS_PILLAR =
            register("fine_mossy_stone_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_MOSSY_STONE_BRICKS_BRICKS =
            register("massive_mossy_stone_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_MOSSY_STONE_BRICKS_PILLAR =
            register("ornate_mossy_stone_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_MOSSY_STONE_BRICKS_TILES =
            register("overlapping_mossy_stone_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_MOSSY_STONE_BRICKS =
            register("polished_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_MOSSY_STONE_BRICKS_PILLAR =
            register("simple_mossy_stone_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_MOSSY_STONE_BRICKS_COLUMN =
            register("smooth_mossy_stone_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_MOSSY_STONE_BRICKS =
            register("thick_inlayed_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_MOSSY_STONE_BRICKS =
            register("tiled_bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TILED_MOSSY_STONE_BRICKS_COLUMN =
            register("tiled_mossy_stone_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS =
            register("tiny_brick_bordered_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));

    // ── Mud ──
    public static final DeferredBlock<Block> BORDERED_MUD =
            register("bordered_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MUD =
            register("brick_bordered_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CARVED_MUD_PILLAR =
            register("carved_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CURLY_MUD_PILLAR =
            register("curly_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> EDGED_MUD =
            register("edged_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FANCY_MUD_PILLAR =
            register("fancy_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FINE_MUD_PILLAR =
            register("fine_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> HARD_MUD =
            register("hard_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> LARGE_MUD_SIGIL =
            register("large_mud_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> LOREFUL_MUD =
            register("loreful_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> MASSIVE_MUD_BRICKS =
            register("massive_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> ORNATE_MUD_PILLAR =
            register("ornate_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> OVERLAPPING_MUD_TILES =
            register("overlapping_mud_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> SCALY_MUD =
            register("scaly_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> SIMPLE_MUD_PILLAR =
            register("simple_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> TILED_BORDERED_MUD =
            register("tiled_bordered_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> TILED_MUD_COLUMN =
            register("tiled_mud_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));

    // ── Mud Bricks ──
    public static final DeferredBlock<Block> BORDERED_MUD_BRICKS =
            register("bordered_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MUD_BRICKS =
            register("brick_bordered_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> CARVED_MUD_BRICKS_PILLAR =
            register("carved_mud_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> CURLY_MUD_BRICKS_PILLAR =
            register("curly_mud_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> EDGED_MUD_BRICKS_BRICKS =
            register("edged_mud_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> FANCY_MUD_BRICKS_PILLAR =
            register("fancy_mud_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> FINE_MUD_BRICKS_PILLAR =
            register("fine_mud_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> HARD_MUD_BRICKS =
            register("hard_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> LARGE_MUD_BRICKS_SIGIL =
            register("large_mud_bricks_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> LOREFUL_MUD_BRICKS =
            register("loreful_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_MUD_BRICKS_BRICKS =
            register("massive_mud_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_MUD_BRICKS_PILLAR =
            register("ornate_mud_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_MUD_BRICKS_TILES =
            register("overlapping_mud_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_MUD_BRICKS_PILLAR =
            register("simple_mud_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_MUD_BRICKS =
            register("tiled_bordered_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> TILED_MUD_BRICKS_COLUMN =
            register("tiled_mud_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));

    // ── Netherrack ──
    public static final DeferredBlock<Block> BORDERED_NETHERRACK =
            register("bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_NETHERRACK =
            register("brick_bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> CURLY_NETHERRACK_PILLAR =
            register("curly_netherrack_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> CUT_NETHERRACK_COLUMN =
            register("cut_netherrack_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> EDGED_NETHERRACK_BRICKS =
            register("edged_netherrack_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> FINE_NETHERRACK_PILLAR =
            register("fine_netherrack_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> MASSIVE_NETHERRACK_BRICKS =
            register("massive_netherrack_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> ORNATE_NETHERRACK_PILLAR =
            register("ornate_netherrack_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> OVERLAPPING_NETHERRACK_TILES =
            register("overlapping_netherrack_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> POLISHED_NETHERRACK =
            register("polished_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> SIMPLE_NETHERRACK_PILLAR =
            register("simple_netherrack_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> SMOOTH_NETHERRACK_COLUMN =
            register("smooth_netherrack_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> THICK_INLAYED_NETHERRACK =
            register("thick_inlayed_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TILED_BORDERED_NETHERRACK =
            register("tiled_bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TILED_NETHERRACK_COLUMN =
            register("tiled_netherrack_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_NETHERRACK =
            register("tiny_brick_bordered_netherrack", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));

    // ── Nether Bricks ──
    public static final DeferredBlock<Block> BORDERED_NETHER_BRICKS =
            register("bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_NETHER_BRICKS =
            register("brick_bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> CURLY_NETHER_BRICKS_PILLAR =
            register("curly_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> CUT_NETHER_BRICKS_COLUMN =
            register("cut_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> EDGED_NETHER_BRICKS_BRICKS =
            register("edged_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> FINE_NETHER_BRICKS_PILLAR =
            register("fine_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_NETHER_BRICKS_BRICKS =
            register("massive_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_NETHER_BRICKS_PILLAR =
            register("ornate_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_NETHER_BRICKS_TILES =
            register("overlapping_nether_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_NETHER_BRICKS =
            register("polished_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_NETHER_BRICKS_PILLAR =
            register("simple_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_NETHER_BRICKS_COLUMN =
            register("smooth_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_NETHER_BRICKS =
            register("thick_inlayed_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_NETHER_BRICKS =
            register("tiled_bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_NETHER_BRICKS_COLUMN =
            register("tiled_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_NETHER_BRICKS =
            register("tiny_brick_bordered_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));

    // ── Oak Glass ──
    public static final DeferredBlock<Block> OAK_BORDERED_GLASS =
            register("oak_bordered_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_DIAMOND_BORDERED_GLASS =
            register("oak_diamond_bordered_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_HORIZONTAL_LINED_GLASS =
            register("oak_horizontal_lined_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_LARGE_DIAMOND_GLASS =
            register("oak_large_diamond_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_LINE_BARED_GLASS =
            register("oak_line_bared_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_ORNATE_BARED_GLASS =
            register("oak_ornate_bared_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_WOVEN_GLASS =
            register("oak_woven_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SQUARE_OAK_GLASS =
            register("square_oak_glass", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

    // ── Oak Planks ──
    public static final DeferredBlock<Block> CORNERED_OAK_PLANKS =
            register("cornered_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CRATED_OAK_PLANKS =
            register("crated_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_OAK_PLANKS =
            register("enclosed_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_OAK_PLANKS =
            register("framed_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_OAK_PLANKS =
            register("natural_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> OAK_PLANKS_PANEL =
            register("oak_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_OAK_PLANKS =
            register("pegged_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_OAK_PLANKS =
            register("whirlwind_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    // ── Obsidian ──
    public static final DeferredBlock<Block> BORDERED_OBSIDIAN =
            register("bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> BRICK_BORDERED_OBSIDIAN =
            register("brick_bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> CURLY_OBSIDIAN_PILLAR =
            register("curly_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> CUT_OBSIDIAN_COLUMN =
            register("cut_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> EDGED_OBSIDIAN_BRICKS =
            register("edged_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> FINE_OBSIDIAN_PILLAR =
            register("fine_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> MASSIVE_OBSIDIAN_BRICKS =
            register("massive_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> ORNATE_OBSIDIAN_PILLAR =
            register("ornate_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> OVERLAPPING_OBSIDIAN_TILES =
            register("overlapping_obsidian_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN =
            register("polished_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> SIMPLE_OBSIDIAN_PILLAR =
            register("simple_obsidian_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> SMOOTH_OBSIDIAN_COLUMN =
            register("smooth_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> THICK_INLAYED_OBSIDIAN =
            register("thick_inlayed_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_BORDERED_OBSIDIAN =
            register("tiled_bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_OBSIDIAN_COLUMN =
            register("tiled_obsidian_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_OBSIDIAN =
            register("tiny_brick_bordered_obsidian", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

    // ── Orange Concrete ──
    public static final DeferredBlock<Block> GRILL_ORANGE_CONCRETE =
            register("grill_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_PANEL =
            register("orange_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_PILLAR =
            register("orange_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_ORANGE_CONCRETE =
            register("pegged_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_ORANGE_CONCRETE =
            register("smooth_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_ORANGE_CONCRETE =
            register("striped_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_ORANGE_CONCRETE =
            register("wired_orange_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));

    // ── Orange Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_ORANGE_STAINED_GLASS_PILLAR =
            register("arched_orange_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_ORANGE_STAINED_GLASS =
            register("circular_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_ORANGE_STAINED_GLASS_PILLAR =
            register("fancy_orange_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_ORANGE_STAINED_GLASS_PILLAR =
            register("ornate_orange_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_ORANGE_STAINED_GLASS_PILLAR =
            register("raster_orange_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_ORANGE_DIAMOND_STAINED_GLASS =
            register("small_orange_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_ORANGE_STAINED_GLASS_PILLAR =
            register("tiled_orange_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_ORANGE_TERRACOTTA =
            register("circular_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_ORANGE_TERRACOTTA =
            register("curled_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_ORANGE_TERRACOTTA =
            register("hexagonical_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_ORANGE_TERRACOTTA =
            register("inscribed_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_COLUMN =
            register("orange_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_PILLAR =
            register("orange_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_ORANGE_TERRACOTTA_TILES =
            register("small_orange_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_ORANGE_TERRACOTTA =
            register("starry_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));

    // ── Orange Wool ──
    public static final DeferredBlock<Block> CORNERED_ORANGE_WOOL =
            register("cornered_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_ORANGE_WOOL =
            register("crafted_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_ORANGE_WOOL =
            register("harsh_quilted_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_ORANGE_WOOL =
            register("rectangle_orange_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));

    // ── Packed Ice ──
    public static final DeferredBlock<Block> BORDERED_PACKED_ICE =
            register("bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PACKED_ICE =
            register("brick_bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CURLY_PACKED_ICE_PILLAR =
            register("curly_packed_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CUT_PACKED_ICE_COLUMN =
            register("cut_packed_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> EDGED_PACKED_ICE_BRICKS =
            register("edged_packed_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> FINE_PACKED_ICE_PILLAR =
            register("fine_packed_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> MASSIVE_PACKED_ICE_BRICKS =
            register("massive_packed_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> ORNATE_PACKED_ICE_PILLAR =
            register("ornate_packed_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_PACKED_ICE_TILES =
            register("overlapping_packed_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> POLISHED_PACKED_ICE =
            register("polished_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> SIMPLE_PACKED_ICE_PILLAR =
            register("simple_packed_ice_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> SMOOTH_PACKED_ICE_COLUMN =
            register("smooth_packed_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_PACKED_ICE =
            register("thick_inlayed_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_PACKED_ICE =
            register("tiled_bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TILED_PACKED_ICE_COLUMN =
            register("tiled_packed_ice_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PACKED_ICE =
            register("tiny_brick_bordered_packed_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));

    // ── Packed Mud ──
    public static final DeferredBlock<Block> BORDERED_PACKED_MUD =
            register("bordered_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PACKED_MUD =
            register("brick_bordered_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> CARVED_PACKED_MUD_PILLAR =
            register("carved_packed_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> CURLY_PACKED_MUD_PILLAR =
            register("curly_packed_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> EDGED_PACKED_MUD_BRICKS =
            register("edged_packed_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FANCY_PACKED_MUD_PILLAR =
            register("fancy_packed_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FINE_PACKED_MUD_PILLAR =
            register("fine_packed_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> HARD_PACKED_MUD =
            register("hard_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> LARGE_PACKED_MUD_SIGIL =
            register("large_packed_mud_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> LOREFUL_PACKED_MUD =
            register("loreful_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> MASSIVE_PACKED_MUD_BRICKS =
            register("massive_packed_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> ORNATE_PACKED_MUD_PILLAR =
            register("ornate_packed_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> OVERLAPPING_PACKED_MUD_TILES =
            register("overlapping_packed_mud_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> SCALY_PACKED_MUD =
            register("scaly_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> SIMPLE_PACKED_MUD_PILLAR =
            register("simple_packed_mud_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> TILED_BORDERED_PACKED_MUD =
            register("tiled_bordered_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> TILED_PACKED_MUD_COLUMN =
            register("tiled_packed_mud_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));

    // ── Pink Concrete ──
    public static final DeferredBlock<Block> GRILL_PINK_CONCRETE =
            register("grill_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_PINK_CONCRETE =
            register("pegged_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PINK_CONCRETE_PANEL =
            register("pink_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PINK_CONCRETE_PILLAR =
            register("pink_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PINK_CONCRETE =
            register("smooth_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_PINK_CONCRETE =
            register("striped_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_PINK_CONCRETE =
            register("wired_pink_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // ── Pink Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_PINK_STAINED_GLASS_PILLAR =
            register("arched_pink_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_PINK_STAINED_GLASS =
            register("circular_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PINK_STAINED_GLASS_PILLAR =
            register("fancy_pink_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PINK_STAINED_GLASS_PILLAR =
            register("ornate_pink_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PINK_STAINED_GLASS_PILLAR =
            register("raster_pink_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PINK_DIAMOND_STAINED_GLASS =
            register("small_pink_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PINK_STAINED_GLASS_PILLAR =
            register("tiled_pink_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_PINK_TERRACOTTA =
            register("circular_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_PINK_TERRACOTTA =
            register("curled_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_PINK_TERRACOTTA =
            register("hexagonical_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_PINK_TERRACOTTA =
            register("inscribed_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_COLUMN =
            register("pink_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_PILLAR =
            register("pink_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_PINK_TERRACOTTA_TILES =
            register("small_pink_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_PINK_TERRACOTTA =
            register("starry_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));

    // ── Pink Wool ──
    public static final DeferredBlock<Block> CORNERED_PINK_WOOL =
            register("cornered_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_PINK_WOOL =
            register("crafted_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_PINK_WOOL =
            register("harsh_quilted_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_PINK_WOOL =
            register("rectangle_pink_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    // ── Prismarine ──
    public static final DeferredBlock<Block> BORDERED_PRISMARINE =
            register("bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PRISMARINE =
            register("brick_bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> CURLY_PRISMARINE_PILLAR =
            register("curly_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> CUT_PRISMARINE_COLUMN =
            register("cut_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> EDGED_PRISMARINE_BRICKS =
            register("edged_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> FINE_PRISMARINE_PILLAR =
            register("fine_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> MASSIVE_PRISMARINE_BRICKS =
            register("massive_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> ORNATE_PRISMARINE_PILLAR =
            register("ornate_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> OVERLAPPING_PRISMARINE_TILES =
            register("overlapping_prismarine_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> POLISHED_PRISMARINE =
            register("polished_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> SIMPLE_PRISMARINE_PILLAR =
            register("simple_prismarine_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> SMOOTH_PRISMARINE_COLUMN =
            register("smooth_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> THICK_INLAYED_PRISMARINE =
            register("thick_inlayed_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TILED_BORDERED_PRISMARINE =
            register("tiled_bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TILED_PRISMARINE_COLUMN =
            register("tiled_prismarine_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PRISMARINE =
            register("tiny_brick_bordered_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));

    // ── Purple Concrete ──
    public static final DeferredBlock<Block> GRILL_PURPLE_CONCRETE =
            register("grill_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_PURPLE_CONCRETE =
            register("pegged_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_PANEL =
            register("purple_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_PILLAR =
            register("purple_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PURPLE_CONCRETE =
            register("smooth_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_PURPLE_CONCRETE =
            register("striped_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_PURPLE_CONCRETE =
            register("wired_purple_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));

    // ── Purple Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_PURPLE_STAINED_GLASS_PILLAR =
            register("arched_purple_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_PURPLE_STAINED_GLASS =
            register("circular_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PURPLE_STAINED_GLASS_PILLAR =
            register("fancy_purple_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PURPLE_STAINED_GLASS_PILLAR =
            register("ornate_purple_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PURPLE_STAINED_GLASS_PILLAR =
            register("raster_purple_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PURPLE_DIAMOND_STAINED_GLASS =
            register("small_purple_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PURPLE_STAINED_GLASS_PILLAR =
            register("tiled_purple_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_PURPLE_TERRACOTTA =
            register("circular_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_PURPLE_TERRACOTTA =
            register("curled_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_PURPLE_TERRACOTTA =
            register("hexagonical_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_PURPLE_TERRACOTTA =
            register("inscribed_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_COLUMN =
            register("purple_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_PILLAR =
            register("purple_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_PURPLE_TERRACOTTA_TILES =
            register("small_purple_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_PURPLE_TERRACOTTA =
            register("starry_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));

    // ── Purple Wool ──
    public static final DeferredBlock<Block> CORNERED_PURPLE_WOOL =
            register("cornered_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_PURPLE_WOOL =
            register("crafted_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_PURPLE_WOOL =
            register("harsh_quilted_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_PURPLE_WOOL =
            register("rectangle_purple_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));

    // ── Purpur Block ──
    public static final DeferredBlock<Block> BORDERED_PURPUR_BLOCK =
            register("bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PURPUR_BLOCK =
            register("brick_bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> CURLY_PURPUR_BLOCK_PILLAR =
            register("curly_purpur_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> CUT_PURPUR_BLOCK_COLUMN =
            register("cut_purpur_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> EDGED_PURPUR_BLOCK_BRICKS =
            register("edged_purpur_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> FINE_PURPUR_BLOCK_PILLAR =
            register("fine_purpur_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_PURPUR_BLOCK_BRICKS =
            register("massive_purpur_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_PURPUR_BLOCK_PILLAR =
            register("ornate_purpur_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_PURPUR_BLOCK_TILES =
            register("overlapping_purpur_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_PURPUR_BLOCK =
            register("polished_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_PURPUR_BLOCK_PILLAR =
            register("simple_purpur_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_PURPUR_BLOCK_COLUMN =
            register("smooth_purpur_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_PURPUR_BLOCK =
            register("thick_inlayed_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_PURPUR_BLOCK =
            register("tiled_bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TILED_PURPUR_BLOCK_COLUMN =
            register("tiled_purpur_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PURPUR_BLOCK =
            register("tiny_brick_bordered_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));

    // ── Quartz Block ──
    public static final DeferredBlock<Block> BORDERED_QUARTZ_BLOCK =
            register("bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_QUARTZ_BLOCK =
            register("brick_bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> CURLY_QUARTZ_BLOCK_PILLAR =
            register("curly_quartz_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> CUT_QUARTZ_BLOCK_COLUMN =
            register("cut_quartz_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> EDGED_QUARTZ_BLOCK_BRICKS =
            register("edged_quartz_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> FINE_QUARTZ_BLOCK_PILLAR =
            register("fine_quartz_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_QUARTZ_BLOCK_BRICKS =
            register("massive_quartz_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_QUARTZ_BLOCK_PILLAR =
            register("ornate_quartz_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_QUARTZ_BLOCK_TILES =
            register("overlapping_quartz_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_QUARTZ_BLOCK =
            register("polished_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_QUARTZ_BLOCK_PILLAR =
            register("simple_quartz_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_QUARTZ_BLOCK_COLUMN =
            register("smooth_quartz_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_QUARTZ_BLOCK =
            register("thick_inlayed_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_QUARTZ_BLOCK =
            register("tiled_bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TILED_QUARTZ_BLOCK_COLUMN =
            register("tiled_quartz_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_QUARTZ_BLOCK =
            register("tiny_brick_bordered_quartz_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));

    // ── Raw Copper Block ──
    public static final DeferredBlock<Block> BORDERED_RAW_COPPER_BLOCK =
            register("bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_COPPER_BLOCK =
            register("brick_bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_COPPER_BLOCK_PILLAR =
            register("curly_raw_copper_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_COPPER_BLOCK_COLUMN =
            register("cut_raw_copper_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_COPPER_BLOCK_BRICKS =
            register("edged_raw_copper_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_COPPER_BLOCK_PILLAR =
            register("fine_raw_copper_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_COPPER_BLOCK_BRICKS =
            register("massive_raw_copper_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_COPPER_BLOCK_PILLAR =
            register("ornate_raw_copper_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_COPPER_BLOCK_TILES =
            register("overlapping_raw_copper_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_COPPER_BLOCK =
            register("polished_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_COPPER_BLOCK_PILLAR =
            register("simple_raw_copper_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_COPPER_BLOCK_COLUMN =
            register("smooth_raw_copper_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_COPPER_BLOCK =
            register("thick_inlayed_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_COPPER_BLOCK =
            register("tiled_bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_COPPER_BLOCK_COLUMN =
            register("tiled_raw_copper_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_COPPER_BLOCK =
            register("tiny_brick_bordered_raw_copper_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));

    // ── Raw Gold Block ──
    public static final DeferredBlock<Block> BORDERED_RAW_GOLD_BLOCK =
            register("bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_GOLD_BLOCK =
            register("brick_bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_GOLD_BLOCK_PILLAR =
            register("curly_raw_gold_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_GOLD_BLOCK_COLUMN =
            register("cut_raw_gold_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_GOLD_BLOCK_BRICKS =
            register("edged_raw_gold_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_GOLD_BLOCK_PILLAR =
            register("fine_raw_gold_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_GOLD_BLOCK_BRICKS =
            register("massive_raw_gold_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_GOLD_BLOCK_PILLAR =
            register("ornate_raw_gold_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_GOLD_BLOCK_TILES =
            register("overlapping_raw_gold_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_GOLD_BLOCK =
            register("polished_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_GOLD_BLOCK_PILLAR =
            register("simple_raw_gold_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_GOLD_BLOCK_COLUMN =
            register("smooth_raw_gold_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_GOLD_BLOCK =
            register("thick_inlayed_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_GOLD_BLOCK =
            register("tiled_bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_GOLD_BLOCK_COLUMN =
            register("tiled_raw_gold_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_GOLD_BLOCK =
            register("tiny_brick_bordered_raw_gold_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));

    // ── Raw Iron Block ──
    public static final DeferredBlock<Block> BORDERED_RAW_IRON_BLOCK =
            register("bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_IRON_BLOCK =
            register("brick_bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_IRON_BLOCK_PILLAR =
            register("curly_raw_iron_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_IRON_BLOCK_COLUMN =
            register("cut_raw_iron_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_IRON_BLOCK_BRICKS =
            register("edged_raw_iron_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_IRON_BLOCK_PILLAR =
            register("fine_raw_iron_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_IRON_BLOCK_BRICKS =
            register("massive_raw_iron_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_IRON_BLOCK_PILLAR =
            register("ornate_raw_iron_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_IRON_BLOCK_TILES =
            register("overlapping_raw_iron_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_IRON_BLOCK =
            register("polished_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_IRON_BLOCK_PILLAR =
            register("simple_raw_iron_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_IRON_BLOCK_COLUMN =
            register("smooth_raw_iron_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_IRON_BLOCK =
            register("thick_inlayed_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_IRON_BLOCK =
            register("tiled_bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_IRON_BLOCK_COLUMN =
            register("tiled_raw_iron_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_IRON_BLOCK =
            register("tiny_brick_bordered_raw_iron_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));

    // ── Redstone Block ──
    public static final DeferredBlock<Block> BORDERED_REDSTONE_BLOCK =
            register("bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_REDSTONE_BLOCK =
            register("brick_bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> CURLY_REDSTONE_BLOCK_PILLAR =
            register("curly_redstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> CUT_REDSTONE_BLOCK_COLUMN =
            register("cut_redstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> EDGED_REDSTONE_BLOCK_BRICKS =
            register("edged_redstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> FINE_REDSTONE_BLOCK_PILLAR =
            register("fine_redstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_REDSTONE_BLOCK_BRICKS =
            register("massive_redstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_REDSTONE_BLOCK_PILLAR =
            register("ornate_redstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_REDSTONE_BLOCK_TILES =
            register("overlapping_redstone_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_REDSTONE_BLOCK =
            register("polished_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_REDSTONE_BLOCK_PILLAR =
            register("simple_redstone_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_REDSTONE_BLOCK_COLUMN =
            register("smooth_redstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_REDSTONE_BLOCK =
            register("thick_inlayed_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_REDSTONE_BLOCK =
            register("tiled_bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_REDSTONE_BLOCK_COLUMN =
            register("tiled_redstone_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_REDSTONE_BLOCK =
            register("tiny_brick_bordered_redstone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));

    // ── Red Concrete ──
    public static final DeferredBlock<Block> GRILL_RED_CONCRETE =
            register("grill_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_RED_CONCRETE =
            register("pegged_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> RED_CONCRETE_PANEL =
            register("red_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> RED_CONCRETE_PILLAR =
            register("red_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_RED_CONCRETE =
            register("smooth_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_RED_CONCRETE =
            register("striped_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_RED_CONCRETE =
            register("wired_red_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));

    // ── Red Nether Bricks ──
    public static final DeferredBlock<Block> BORDERED_RED_NETHER_BRICKS =
            register("bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RED_NETHER_BRICKS =
            register("brick_bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> CURLY_RED_NETHER_BRICKS_PILLAR =
            register("curly_red_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> CUT_RED_NETHER_BRICKS_COLUMN =
            register("cut_red_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> EDGED_RED_NETHER_BRICKS_BRICKS =
            register("edged_red_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> FINE_RED_NETHER_BRICKS_PILLAR =
            register("fine_red_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_RED_NETHER_BRICKS_BRICKS =
            register("massive_red_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_RED_NETHER_BRICKS_PILLAR =
            register("ornate_red_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_RED_NETHER_BRICKS_TILES =
            register("overlapping_red_nether_bricks_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_RED_NETHER_BRICKS =
            register("polished_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_RED_NETHER_BRICKS_PILLAR =
            register("simple_red_nether_bricks_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_RED_NETHER_BRICKS_COLUMN =
            register("smooth_red_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_RED_NETHER_BRICKS =
            register("thick_inlayed_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_RED_NETHER_BRICKS =
            register("tiled_bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_RED_NETHER_BRICKS_COLUMN =
            register("tiled_red_nether_bricks_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RED_NETHER_BRICKS =
            register("tiny_brick_bordered_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));

    // ── Red Sandstone ──
    public static final DeferredBlock<Block> BORDERED_RED_SANDSTONE =
            register("bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RED_SANDSTONE =
            register("brick_bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CURLY_RED_SANDSTONE_PILLAR =
            register("curly_red_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CUT_RED_SANDSTONE_COLUMN =
            register("cut_red_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> EDGED_RED_SANDSTONE_BRICKS =
            register("edged_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> FINE_RED_SANDSTONE_PILLAR =
            register("fine_red_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> MASSIVE_RED_SANDSTONE_BRICKS =
            register("massive_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> ORNATE_RED_SANDSTONE_PILLAR =
            register("ornate_red_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_RED_SANDSTONE_TILES =
            register("overlapping_red_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_RED_SANDSTONE =
            register("polished_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> SIMPLE_RED_SANDSTONE_PILLAR =
            register("simple_red_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> SMOOTH_RED_SANDSTONE_COLUMN =
            register("smooth_red_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_RED_SANDSTONE =
            register("thick_inlayed_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_RED_SANDSTONE =
            register("tiled_bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TILED_RED_SANDSTONE_COLUMN =
            register("tiled_red_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RED_SANDSTONE =
            register("tiny_brick_bordered_red_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));

    // ── Red Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_RED_STAINED_GLASS_PILLAR =
            register("arched_red_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_RED_STAINED_GLASS =
            register("circular_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_RED_STAINED_GLASS_PILLAR =
            register("fancy_red_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_RED_STAINED_GLASS_PILLAR =
            register("ornate_red_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_RED_STAINED_GLASS_PILLAR =
            register("raster_red_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_RED_DIAMOND_STAINED_GLASS =
            register("small_red_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_RED_STAINED_GLASS_PILLAR =
            register("tiled_red_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_RED_TERRACOTTA =
            register("circular_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_RED_TERRACOTTA =
            register("curled_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_RED_TERRACOTTA =
            register("hexagonical_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_RED_TERRACOTTA =
            register("inscribed_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_COLUMN =
            register("red_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_PILLAR =
            register("red_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_RED_TERRACOTTA_TILES =
            register("small_red_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_RED_TERRACOTTA =
            register("starry_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));

    // ── Red Wool ──
    public static final DeferredBlock<Block> CORNERED_RED_WOOL =
            register("cornered_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_RED_WOOL =
            register("crafted_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_RED_WOOL =
            register("harsh_quilted_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_RED_WOOL =
            register("rectangle_red_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));

    // ── Sandstone ──
    public static final DeferredBlock<Block> BORDERED_SANDSTONE =
            register("bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SANDSTONE =
            register("brick_bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CURLY_SANDSTONE_PILLAR =
            register("curly_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CUT_SANDSTONE_COLUMN =
            register("cut_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> EDGED_SANDSTONE_BRICKS =
            register("edged_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> FINE_SANDSTONE_PILLAR =
            register("fine_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> MASSIVE_SANDSTONE_BRICKS =
            register("massive_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> ORNATE_SANDSTONE_PILLAR =
            register("ornate_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_SANDSTONE_TILES =
            register("overlapping_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_SANDSTONE =
            register("polished_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SIMPLE_SANDSTONE_PILLAR =
            register("simple_sandstone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SMOOTH_SANDSTONE_COLUMN =
            register("smooth_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_SANDSTONE =
            register("thick_inlayed_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_SANDSTONE =
            register("tiled_bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TILED_SANDSTONE_COLUMN =
            register("tiled_sandstone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SANDSTONE =
            register("tiny_brick_bordered_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    // ── Smooth Stone ──
    public static final DeferredBlock<Block> BORDERED_SMOOTH_STONE =
            register("bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SMOOTH_STONE =
            register("brick_bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> CURLY_SMOOTH_STONE_PILLAR =
            register("curly_smooth_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> CUT_SMOOTH_STONE_COLUMN =
            register("cut_smooth_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> EDGED_SMOOTH_STONE_BRICKS =
            register("edged_smooth_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> FINE_SMOOTH_STONE_PILLAR =
            register("fine_smooth_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> MASSIVE_SMOOTH_STONE_BRICKS =
            register("massive_smooth_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> ORNATE_SMOOTH_STONE_PILLAR =
            register("ornate_smooth_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> OVERLAPPING_SMOOTH_STONE_TILES =
            register("overlapping_smooth_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> POLISHED_SMOOTH_STONE =
            register("polished_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> SIMPLE_SMOOTH_STONE_PILLAR =
            register("simple_smooth_stone_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> SMOOTH_SMOOTH_STONE_COLUMN =
            register("smooth_smooth_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_SMOOTH_STONE =
            register("thick_inlayed_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_SMOOTH_STONE =
            register("tiled_bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TILED_SMOOTH_STONE_COLUMN =
            register("tiled_smooth_stone_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SMOOTH_STONE =
            register("tiny_brick_bordered_smooth_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));

    // ── Snow Block ──
    public static final DeferredBlock<Block> BORDERED_SNOW_BLOCK =
            register("bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SNOW_BLOCK =
            register("brick_bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> CURLY_SNOW_BLOCK_PILLAR =
            register("curly_snow_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> CUT_SNOW_BLOCK_COLUMN =
            register("cut_snow_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> EDGED_SNOW_BLOCK_BRICKS =
            register("edged_snow_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> FINE_SNOW_BLOCK_PILLAR =
            register("fine_snow_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_SNOW_BLOCK_BRICKS =
            register("massive_snow_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_SNOW_BLOCK_PILLAR =
            register("ornate_snow_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_SNOW_BLOCK_TILES =
            register("overlapping_snow_block_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_SNOW_BLOCK =
            register("polished_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_SNOW_BLOCK_PILLAR =
            register("simple_snow_block_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_SNOW_BLOCK_COLUMN =
            register("smooth_snow_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_SNOW_BLOCK =
            register("thick_inlayed_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_SNOW_BLOCK =
            register("tiled_bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TILED_SNOW_BLOCK_COLUMN =
            register("tiled_snow_block_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SNOW_BLOCK =
            register("tiny_brick_bordered_snow_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));

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
    public static final DeferredBlock<Block> SPRUCE_PLANKS_PANEL =
            register("spruce_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_SPRUCE_PLANKS =
            register("whirlwind_spruce_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));

    // ── Terracotta ──
    public static final DeferredBlock<Block> CIRCULAR_TERRACOTTA =
            register("circular_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_TERRACOTTA =
            register("curled_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_TERRACOTTA =
            register("hexagonical_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_TERRACOTTA =
            register("inscribed_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_TERRACOTTA_TILES =
            register("small_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_TERRACOTTA =
            register("starry_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> TERRACOTTA_COLUMN =
            register("terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> TERRACOTTA_PILLAR =
            register("terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));

    // ── Tuff ──
    public static final DeferredBlock<Block> BORDERED_TUFF =
            register("bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> BRICK_BORDERED_TUFF =
            register("brick_bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> CURLY_TUFF_PILLAR =
            register("curly_tuff_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> CUT_TUFF_COLUMN =
            register("cut_tuff_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> EDGED_TUFF_BRICKS =
            register("edged_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> FINE_TUFF_PILLAR =
            register("fine_tuff_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> MASSIVE_TUFF_BRICKS =
            register("massive_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> ORNATE_TUFF_PILLAR =
            register("ornate_tuff_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> OVERLAPPING_TUFF_TILES =
            register("overlapping_tuff_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> POLISHED_TUFF =
            register("polished_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> SIMPLE_TUFF_PILLAR =
            register("simple_tuff_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> SMOOTH_TUFF_COLUMN =
            register("smooth_tuff_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> THICK_INLAYED_TUFF =
            register("thick_inlayed_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TILED_BORDERED_TUFF =
            register("tiled_bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TILED_TUFF_COLUMN =
            register("tiled_tuff_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_TUFF =
            register("tiny_brick_bordered_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));

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
    public static final DeferredBlock<Block> WARPED_PLANKS_PANEL =
            register("warped_planks_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_WARPED_PLANKS =
            register("whirlwind_warped_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // ── White Concrete ──
    public static final DeferredBlock<Block> GRILL_WHITE_CONCRETE =
            register("grill_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_WHITE_CONCRETE =
            register("pegged_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_WHITE_CONCRETE =
            register("smooth_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_WHITE_CONCRETE =
            register("striped_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_PANEL =
            register("white_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_PILLAR =
            register("white_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_WHITE_CONCRETE =
            register("wired_white_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    // ── White Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_WHITE_STAINED_GLASS_PILLAR =
            register("arched_white_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_WHITE_STAINED_GLASS =
            register("circular_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_WHITE_STAINED_GLASS_PILLAR =
            register("fancy_white_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_WHITE_STAINED_GLASS_PILLAR =
            register("ornate_white_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_WHITE_STAINED_GLASS_PILLAR =
            register("raster_white_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_WHITE_DIAMOND_STAINED_GLASS =
            register("small_white_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_WHITE_STAINED_GLASS_PILLAR =
            register("tiled_white_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_WHITE_TERRACOTTA =
            register("circular_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_WHITE_TERRACOTTA =
            register("curled_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_WHITE_TERRACOTTA =
            register("hexagonical_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_WHITE_TERRACOTTA =
            register("inscribed_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_WHITE_TERRACOTTA_TILES =
            register("small_white_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_WHITE_TERRACOTTA =
            register("starry_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));

    // ── White Wool ──
    public static final DeferredBlock<Block> CORNERED_WHITE_WOOL =
            register("cornered_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_WHITE_WOOL =
            register("crafted_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_WHITE_WOOL =
            register("harsh_quilted_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_WHITE_WOOL =
            register("rectangle_white_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    // ── Yellow Concrete ──
    public static final DeferredBlock<Block> GRILL_YELLOW_CONCRETE =
            register("grill_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_YELLOW_CONCRETE =
            register("pegged_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_YELLOW_CONCRETE =
            register("smooth_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_YELLOW_CONCRETE =
            register("striped_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_YELLOW_CONCRETE =
            register("wired_yellow_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_PANEL =
            register("yellow_concrete_panel", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_PILLAR =
            register("yellow_concrete_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));

    // ── Yellow Stained Glass ──
    public static final DeferredBlock<Block> ARCHED_YELLOW_STAINED_GLASS_PILLAR =
            register("arched_yellow_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_YELLOW_STAINED_GLASS =
            register("circular_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_YELLOW_STAINED_GLASS_PILLAR =
            register("fancy_yellow_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_YELLOW_STAINED_GLASS_PILLAR =
            register("ornate_yellow_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_YELLOW_STAINED_GLASS_PILLAR =
            register("raster_yellow_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_YELLOW_DIAMOND_STAINED_GLASS =
            register("small_yellow_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_YELLOW_STAINED_GLASS_PILLAR =
            register("tiled_yellow_stained_glass_pillar", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
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
    public static final DeferredBlock<Block> CIRCULAR_YELLOW_TERRACOTTA =
            register("circular_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_YELLOW_TERRACOTTA =
            register("curled_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_YELLOW_TERRACOTTA =
            register("hexagonical_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_YELLOW_TERRACOTTA =
            register("inscribed_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_YELLOW_TERRACOTTA_TILES =
            register("small_yellow_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_YELLOW_TERRACOTTA =
            register("starry_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_COLUMN =
            register("yellow_terracotta_column", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_PILLAR =
            register("yellow_terracotta_pillar", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));

    // ── Yellow Wool ──
    public static final DeferredBlock<Block> CORNERED_YELLOW_WOOL =
            register("cornered_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> CRAFTED_YELLOW_WOOL =
            register("crafted_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> HARSH_QUILTED_YELLOW_WOOL =
            register("harsh_quilted_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> RECTANGLE_YELLOW_WOOL =
            register("rectangle_yellow_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));

    // ── New CTM batch blocks ──────────────────────────────────────────────
    public static final DeferredBlock<Block> ACACIA_WINDOW_TILES_PILLAR = register("acacia_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_TILES_PILLAR = register("birch_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_TILES_PILLAR = register("crimson_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_TILES_PILLAR = register("dark_oak_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_TILES_PILLAR = register("jungle_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_TILES_PILLAR = register("mangrove_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_TILES_PILLAR = register("oak_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_TILES_PILLAR = register("spruce_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_TILES_PILLAR = register("warped_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BRICK_PATTERN = register("acacia_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BRICK_PATTERN = register("andesite_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_CUT_POLISHED = register("andesite_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_CUT_SMALL_BRICK = register("andesite_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ASURINE_CUT_POLISHED = register("asurine_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ASURINE_CUT_SMALL_BRICK = register("asurine_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BRICK_PATTERN = register("bamboo_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_PATTERN = register("basalt_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BRICK_PATTERN = register("birch_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_BRICK_PATTERN = register("blackstone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_FRAMED_GLASS = register("black_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLACK_STAINED_CLEAR_GLASS = register("black_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_FRAMED_GLASS = register("blue_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_STAINED_CLEAR_GLASS = register("blue_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BONE_BLOCK_PATTERNED = register("bone_block_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BROWN_FRAMED_GLASS = register("brown_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BROWN_STAINED_CLEAR_GLASS = register("brown_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CALCITE_CUT_POLISHED = register("calcite_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CALCITE_CUT_SMALL_BRICK = register("calcite_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_BRICK_PATTERN = register("cherry_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHISELED_GLASS = register("chiseled_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS = register("clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> COAL_BLOCK_CHISELED = register("coal_block_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BRICK_PATTERN = register("cobbled_deepslate_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_BRICK_PATTERN = register("cobblestone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_CIRCLES = register("copper_block_circles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSITE_CUT_POLISHED = register("crimsite_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSITE_CUT_SMALL_BRICK = register("crimsite_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BRICK_PATTERN = register("crimson_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_FRAMED_GLASS = register("cyan_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CYAN_STAINED_CLEAR_GLASS = register("cyan_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BRICK_PATTERN = register("dark_oak_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CUT_POLISHED = register("deepslate_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CUT_SMALL_BRICK = register("deepslate_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DELICATE_LAPIS_BLOCK = register("delicate_lapis_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_BRICK_PATTERN = register("diorite_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_CUT_POLISHED = register("diorite_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_CUT_SMALL_BRICK = register("diorite_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRTY_GLASS = register("dirty_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> DRIPSTONE_CUT_POLISHED = register("dripstone_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DRIPSTONE_CUT_SMALL_BRICK = register("dripstone_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_BRICK_PATTERN = register("end_stone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> FRAMED_GLASS = register("framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FROSTED_GLASS = register("frosted_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GLASS = register("glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GLOWSTONE_BRICK_PATTERN = register("glowstone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
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
    public static final DeferredBlock<Block> GOLD_BLOCK_LINES = register("gold_block_lines", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_PATTERN = register("gold_block_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_BRICK_PATTERN = register("granite_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_CUT_POLISHED = register("granite_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_CUT_SMALL_BRICK = register("granite_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRAY_FRAMED_GLASS = register("gray_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GRAY_STAINED_CLEAR_GLASS = register("gray_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_FRAMED_GLASS = register("green_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_STAINED_CLEAR_GLASS = register("green_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> IRON_BLOCK_LINES = register("iron_block_lines", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_PIPES = register("iron_block_pipes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BRICK_PATTERN = register("jungle_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_DECORATED = register("lapis_block_decorated", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_FRAMED_GLASS = register("light_blue_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_CLEAR_GLASS = register("light_blue_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_FRAMED_GLASS = register("light_gray_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_CLEAR_GLASS = register("light_gray_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIMESTONE_CUT_POLISHED = register("limestone_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIMESTONE_CUT_SMALL_BRICK = register("limestone_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_FRAMED_GLASS = register("lime_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_STAINED_CLEAR_GLASS = register("lime_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_FRAMED_GLASS = register("magenta_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_STAINED_CLEAR_GLASS = register("magenta_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BRICK_PATTERN = register("mangrove_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_CHISELED = register("netherite_block_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_DECORATED = register("netherite_block_decorated", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_PATTERNED = register("netherite_block_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BRICK_PATTERN = register("netherrack_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_BRICK_PATTERN = register("nether_bricks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BRICK_PATTERN = register("oak_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_PATTERN = register("obsidian_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_CHISELED_CIRCLES = register("obsidian_chiseled_circles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_FRAMED_GLASS = register("obsidian_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OCHRUM_CUT_POLISHED = register("ochrum_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OCHRUM_CUT_SMALL_BRICK = register("ochrum_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_FRAMED_GLASS = register("orange_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORANGE_STAINED_CLEAR_GLASS = register("orange_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICK_PATTERN = register("pale_oak_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_FRAMED_GLASS = register("pink_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PINK_STAINED_CLEAR_GLASS = register("pink_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = register("polished_dripstone", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE = register("polished_limestone", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BRICK_PATTERN = register("prismarine_bricks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_PILLARS = register("prismarine_bricks_pillars", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_FRAMED_GLASS = register("purple_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPLE_STAINED_CLEAR_GLASS = register("purple_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPUR_BRICK_PATTERN = register("purpur_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_FRAMED_GLASS = register("red_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_BRICK_PATTERN = register("red_nether_bricks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_BRICK_PATTERN = register("red_sandstone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_STAINED_CLEAR_GLASS = register("red_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CHISELED = register("rose_quartz_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CRUSHED = register("rose_quartz_crushed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_POLISHED_BLOCK = register("rose_quartz_polished_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_SQUARES = register("rose_quartz_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_TILES = register("rose_quartz_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_BRICK_PATTERN = register("sandstone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_FRAMED_GLASS = register("sandstone_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCORCHIA_CUT_POLISHED = register("scorchia_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SCORCHIA_CUT_SMALL_BRICK = register("scorchia_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SCORIA_CUT_POLISHED = register("scoria_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SCORIA_CUT_SMALL_BRICK = register("scoria_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SEA_LANTERN = register("sea_lantern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BRICK_PATTERN = register("spruce_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BRICK_PATTERN = register("stone_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_FRAMED_GLASS = register("stone_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_CLEAR_GLASS = register("tinted_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TUFF_CUT_POLISHED = register("tuff_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> TUFF_CUT_SMALL_BRICK = register("tuff_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> VERIDIUM_CUT_POLISHED = register("veridium_cut_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> VERIDIUM_CUT_SMALL_BRICK = register("veridium_cut_small_brick", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BRICK_PATTERN = register("warped_planks_brick_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_FRAMED_GLASS = register("white_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WHITE_STAINED_CLEAR_GLASS = register("white_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_FRAMED_GLASS = register("yellow_framed_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_STAINED_CLEAR_GLASS = register("yellow_stained_clear_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_ICE_PILLAR = register("blue_ice_pillar", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BEAMS = register("acacia_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BRICK_PAVING = register("acacia_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_CRATE = register("acacia_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_DIAGONAL_STRIPES = register("acacia_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_DIAGONAL_TILES = register("acacia_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_DOTTED = register("acacia_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_FLOORING = register("acacia_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_LARGE_TILES = register("acacia_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_PATTERN = register("acacia_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_ROTATED_BRICKS = register("acacia_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SMALL_BRICKS = register("acacia_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SMALL_TILES = register("acacia_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SQUARES = register("acacia_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_TILES = register("acacia_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_WAVY = register("acacia_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_WOVEN = register("acacia_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_BEAMS = register("amethyst_block_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES = register("amethyst_block_bordered_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_CUT = register("amethyst_block_cut", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_EDGED = register("amethyst_block_edged", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_POLISHED = register("amethyst_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_SHINY = register("amethyst_block_shiny", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_TILES = register("amethyst_block_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BRICK_PAVING = register("andesite_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_DIAGONAL_BRICKS = register("andesite_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_DOTTED = register("andesite_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_PAVING = register("andesite_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_POLISHED = register("andesite_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_ROTATED_BRICKS = register("andesite_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_SQUARES = register("andesite_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_TILES = register("andesite_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_WAVY = register("andesite_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BEAMS = register("bamboo_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BRICK_PAVING = register("bamboo_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_CRATE = register("bamboo_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_DIAGONAL_STRIPES = register("bamboo_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_DIAGONAL_TILES = register("bamboo_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_DOTTED = register("bamboo_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_FLOORING = register("bamboo_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_LARGE_TILES = register("bamboo_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_PATTERN = register("bamboo_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_ROTATED_BRICKS = register("bamboo_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SMALL_BRICKS = register("bamboo_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SMALL_TILES = register("bamboo_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SQUARES = register("bamboo_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_TILES = register("bamboo_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_WAVY = register("bamboo_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_WOVEN = register("bamboo_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BEAMS = register("basalt_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BORDERED = register("basalt_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BORDERED_POLISHED = register("basalt_bordered_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_DIAGONAL_TILES = register("basalt_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_PATTERNED = register("basalt_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_TILES = register("basalt_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BEAMS = register("birch_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BRICK_PAVING = register("birch_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_CRATE = register("birch_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_DIAGONAL_STRIPES = register("birch_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_DIAGONAL_TILES = register("birch_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_DOTTED = register("birch_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_FLOORING = register("birch_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_LARGE_TILES = register("birch_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_PATTERN = register("birch_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_ROTATED_BRICKS = register("birch_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SMALL_BRICKS = register("birch_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SMALL_TILES = register("birch_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SQUARES = register("birch_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_TILES = register("birch_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_WAVY = register("birch_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_WOVEN = register("birch_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_BRICK_PAVING = register("blackstone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_DIAGONAL_BRICKS = register("blackstone_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_POLISHED = register("blackstone_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_ROTATED_BRICKS = register("blackstone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_TILES = register("blackstone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_STAINED_GLASS = register("black_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_ICE_BORDERED = register("blue_ice_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_CHISELED = register("blue_ice_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_PATTERNED = register("blue_ice_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_SLANTED_TILES = register("blue_ice_slanted_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_TILES = register("blue_ice_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_STAINED_GLASS = register("blue_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BONE_BLOCK_BORDERED = register("bone_block_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_CHISELED = register("bone_block_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_DECORATED_BORDERED = register("bone_block_decorated_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_INVERTED_TILES = register("bone_block_inverted_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
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
    public static final DeferredBlock<Block> CHERRY_PLANKS_BEAMS = register("cherry_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_BRICK_PAVING = register("cherry_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_CRATE = register("cherry_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_DIAGONAL_STRIPES = register("cherry_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_DIAGONAL_TILES = register("cherry_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_DOTTED = register("cherry_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_FLOORING = register("cherry_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_LARGE_TILES = register("cherry_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_PATTERN = register("cherry_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_ROTATED_BRICKS = register("cherry_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SMALL_BRICKS = register("cherry_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SMALL_TILES = register("cherry_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SQUARES = register("cherry_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_TILES = register("cherry_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_WAVY = register("cherry_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_WOVEN = register("cherry_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CLEAR_GLASS_BLACK = register("clear_glass_black", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_BLUE = register("clear_glass_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_BROWN = register("clear_glass_brown", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_CYAN = register("clear_glass_cyan", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_GRAY = register("clear_glass_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_GREEN = register("clear_glass_green", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_LIGHT_BLUE = register("clear_glass_light_blue", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_LIGHT_GRAY = register("clear_glass_light_gray", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_LIME = register("clear_glass_lime", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_MAGENTA = register("clear_glass_magenta", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_ORANGE = register("clear_glass_orange", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_PINK = register("clear_glass_pink", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_PURPLE = register("clear_glass_purple", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_RED = register("clear_glass_red", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_WHITE = register("clear_glass_white", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_GLASS_YELLOW = register("clear_glass_yellow", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> COAL_BLOCK_CARVED = register("coal_block_carved", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_CIRCLES = register("coal_block_circles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_COMPACTED = register("coal_block_compacted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_OVALS = register("coal_block_ovals", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_PATTERN = register("coal_block_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_ROTATED_BRICKS = register("coal_block_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_SMALL_TILES = register("coal_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_STRIPES = register("coal_block_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BEAMS = register("cobbled_deepslate_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BRICK_PAVING = register("cobbled_deepslate_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_LARGE_TILES = register("cobbled_deepslate_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_PAVING = register("cobbled_deepslate_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_PULVERIZED = register("cobbled_deepslate_pulverized", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_ROTATED_BRICKS = register("cobbled_deepslate_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_SMALL_TILES = register("cobbled_deepslate_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_SQUARES = register("cobbled_deepslate_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_STRIPES = register("cobbled_deepslate_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_TILES = register("cobbled_deepslate_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_WORN_STRIPES = register("cobbled_deepslate_worn_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_BEAMS = register("cobblestone_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_BRICK_PAVING = register("cobblestone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_CHISELED_BORDER = register("cobblestone_chiseled_border", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_CROSSES = register("cobblestone_crosses", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_DENTED = register("cobblestone_dented", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_INVERTED_DENTED = register("cobblestone_inverted_dented", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_PAVING = register("cobblestone_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_PULVERIZED = register("cobblestone_pulverized", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_ROTATED_BRICKS = register("cobblestone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_SMALL_TILES = register("cobblestone_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_SQUARES = register("cobblestone_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_STRIPES = register("cobblestone_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_TILES = register("cobblestone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_WORN_STRIPES = register("cobblestone_worn_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK = register("copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_BARS = register("copper_block_bars", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_GEARS = register("copper_block_gears", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_LINES = register("copper_block_lines", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_PATTERN = register("copper_block_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_POLISHED = register("copper_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_SHAFTS = register("copper_block_shafts", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_GRATE = register("copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BEAMS = register("crimson_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BRICK_PAVING = register("crimson_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_CRATE = register("crimson_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_DIAGONAL_STRIPES = register("crimson_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_DIAGONAL_TILES = register("crimson_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_DOTTED = register("crimson_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_FLOORING = register("crimson_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_LARGE_TILES = register("crimson_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_PATTERN = register("crimson_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_ROTATED_BRICKS = register("crimson_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SMALL_BRICKS = register("crimson_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SMALL_TILES = register("crimson_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SQUARES = register("crimson_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_TILES = register("crimson_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_WAVY = register("crimson_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_WOVEN = register("crimson_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CUT_RED_SANDSTONE = register("cut_red_sandstone", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CUT_SANDSTONE = register("cut_sandstone", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_STAINED_GLASS = register("cyan_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BEAMS = register("dark_oak_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BRICK_PAVING = register("dark_oak_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_CRATE = register("dark_oak_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_DIAGONAL_STRIPES = register("dark_oak_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_DIAGONAL_TILES = register("dark_oak_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_DOTTED = register("dark_oak_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_FLOORING = register("dark_oak_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_LARGE_TILES = register("dark_oak_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_PATTERN = register("dark_oak_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_ROTATED_BRICKS = register("dark_oak_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SMALL_BRICKS = register("dark_oak_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SMALL_TILES = register("dark_oak_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SQUARES = register("dark_oak_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_TILES = register("dark_oak_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_WAVY = register("dark_oak_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_WOVEN = register("dark_oak_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_BEAMS = register("dark_prismarine_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_BRICK_PAVING = register("dark_prismarine_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_DOTTED = register("dark_prismarine_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_FABRIC = register("dark_prismarine_fabric", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_LARGE_TILES = register("dark_prismarine_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_ROTATED_BRICKS = register("dark_prismarine_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_ROWS = register("dark_prismarine_rows", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_SQUARES = register("dark_prismarine_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_TILES = register("dark_prismarine_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_WAVY = register("dark_prismarine_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_WOVEN = register("dark_prismarine_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK = register("diamond_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_CHISELED = register("diamond_block_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_CHISELED_CUBES = register("diamond_block_chiseled_cubes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_CONNECTING = register("diamond_block_connecting", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_GRID = register("diamond_block_grid", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_JEWEL_BLOCK = register("diamond_block_jewel_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_POLISHED = register("diamond_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_RHOMBUSES = register("diamond_block_rhombuses", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_SHINY_BORDERED = register("diamond_block_shiny_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_SMALL_TILES = register("diamond_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_BRICK_PAVING = register("diorite_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_DIAGONAL_BRICKS = register("diorite_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_DOTTED = register("diorite_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_PAVING = register("diorite_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_POLISHED = register("diorite_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_ROTATED_BRICKS = register("diorite_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_SQUARES = register("diorite_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_TILES = register("diorite_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_WAVY = register("diorite_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_BLOBS = register("dirt_blobs", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_BRICKS = register("dirt_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_CHUNKS = register("dirt_chunks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_CLUMPS = register("dirt_clumps", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_LARGE_TILES = register("dirt_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SMALL_BRICKS = register("dirt_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SMALL_TILES = register("dirt_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SMOOTH_CLUMPS = register("dirt_smooth_clumps", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SOIL = register("dirt_soil", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SQUARES = register("dirt_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_TILES = register("dirt_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_TILLED = register("dirt_tilled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ECHO_GLASS = register("echo_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ECHO_GLASS_1 = register("echo_glass_1", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ECHO_GLASS_2 = register("echo_glass_2", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ECHO_GLASS_3 = register("echo_glass_3", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_BORDERED_CROSSES = register("emerald_block_bordered_crosses", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_BORDERED_PLATING = register("emerald_block_bordered_plating", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CHISELED = register("emerald_block_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CLOVERS = register("emerald_block_clovers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CRYSTAL = register("emerald_block_crystal", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_PATTERNED = register("emerald_block_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_PATTERNED_SQUARES = register("emerald_block_patterned_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_POLISHED = register("emerald_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_STRIPED = register("emerald_block_striped", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_WAXED = register("emerald_block_waxed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_BLOBS = register("end_stone_blobs", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_BRICK_PAVING = register("end_stone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_CHISELED = register("end_stone_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_CRUSHED = register("end_stone_crushed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_DIAGONAL_BRICKS = register("end_stone_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_MESH = register("end_stone_mesh", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_PAVING = register("end_stone_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_POLISHED = register("end_stone_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_ROTATED_BRICKS = register("end_stone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SCALES = register("end_stone_scales", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SMALL_TILES = register("end_stone_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SPIRAL_PATTERN = register("end_stone_spiral_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SQUARES = register("end_stone_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_TILES = register("end_stone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EXPOSED_COPPER_BLOCK = register("exposed_copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EXPOSED_COPPER_GRATE = register("exposed_copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> GLOWSTONE_BRICK_PAVING = register("glowstone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_CRUSHED = register("glowstone_crushed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_LARGE_TILES = register("glowstone_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_ROTATED_BRICKS = register("glowstone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_SMALL_TILES = register("glowstone_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_SMOOTH = register("glowstone_smooth", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_TILES = register("glowstone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK = register("gold_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_BEAMS = register("gold_block_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_BORDERED = register("gold_block_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_POLISHED = register("gold_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_SCALES = register("gold_block_scales", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_SMALL_TILES = register("gold_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_STRIPED = register("gold_block_striped", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_TILES = register("gold_block_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_BRICK_PAVING = register("granite_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_DIAGONAL_BRICKS = register("granite_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_DOTTED = register("granite_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_PAVING = register("granite_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_POLISHED = register("granite_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_ROTATED_BRICKS = register("granite_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_SQUARES = register("granite_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_TILES = register("granite_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_WAVY = register("granite_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRAY_STAINED_GLASS = register("gray_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_STAINED_GLASS = register("green_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ICE_GLASS = register("ice_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> IRON_BLOCK = register("iron_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_BORDERED = register("iron_block_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_CHISELED = register("iron_block_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_CONNECTING = register("iron_block_connecting", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_FRAMED = register("iron_block_framed", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> IRON_BLOCK_GEARS = register("iron_block_gears", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_PATTERNED = register("iron_block_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_POLISHED = register("iron_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_PROCESSED = register("iron_block_processed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BEAMS = register("jungle_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BRICK_PAVING = register("jungle_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_CRATE = register("jungle_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_DIAGONAL_STRIPES = register("jungle_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_DIAGONAL_TILES = register("jungle_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_DOTTED = register("jungle_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_FLOORING = register("jungle_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_LARGE_TILES = register("jungle_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_PATTERN = register("jungle_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_ROTATED_BRICKS = register("jungle_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SMALL_BRICKS = register("jungle_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SMALL_TILES = register("jungle_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SQUARES = register("jungle_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_TILES = register("jungle_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_WAVY = register("jungle_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_WOVEN = register("jungle_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK = register("lapis_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_BORDERED = register("lapis_block_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_CONNECTING = register("lapis_block_connecting", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_GLOSSY = register("lapis_block_glossy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_INVERTED_TILES = register("lapis_block_inverted_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_MOSAIC = register("lapis_block_mosaic", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_PATTERN = register("lapis_block_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_POLISHED = register("lapis_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_SCALES = register("lapis_block_scales", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_SMALL_TILES = register("lapis_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_STRIPES = register("lapis_block_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_TILES = register("lapis_block_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS = register("light_blue_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS = register("light_gray_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_STAINED_GLASS = register("lime_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS = register("magenta_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BEAMS = register("mangrove_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BRICK_PAVING = register("mangrove_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_CRATE = register("mangrove_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_DIAGONAL_STRIPES = register("mangrove_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_DIAGONAL_TILES = register("mangrove_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_DOTTED = register("mangrove_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_FLOORING = register("mangrove_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_LARGE_TILES = register("mangrove_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_PATTERN = register("mangrove_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_ROTATED_BRICKS = register("mangrove_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SMALL_BRICKS = register("mangrove_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SMALL_TILES = register("mangrove_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SQUARES = register("mangrove_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_TILES = register("mangrove_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_WAVY = register("mangrove_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_WOVEN = register("mangrove_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_BEAMS = register("mossy_cobblestone_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_DENTED = register("mossy_cobblestone_dented", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_INVERTED_DENTED = register("mossy_cobblestone_inverted_dented", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_PAVING = register("mossy_cobblestone_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_SMALL_TILES = register("mossy_cobblestone_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_SQUARES = register("mossy_cobblestone_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_STRIPES = register("mossy_cobblestone_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_WORN_STRIPES = register("mossy_cobblestone_worn_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_BEAMS = register("netherite_block_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_COMPACTED = register("netherite_block_compacted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_DIAGONAL_TILES = register("netherite_block_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_INDENTED = register("netherite_block_indented", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_SMALL_TILES = register("netherite_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BEAMS = register("netherrack_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BRICK_PAVING = register("netherrack_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_DENTED = register("netherrack_dented", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_ROTATED_BRICKS = register("netherrack_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_SMALL_TILES = register("netherrack_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_STRIPES = register("netherrack_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_TILES = register("netherrack_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_BEAMS = register("nether_bricks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_BRICK_PAVING = register("nether_bricks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_CHISELED_SQUARES = register("nether_bricks_chiseled_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_DIAGONAL_BRICKS = register("nether_bricks_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_LARGE_BRICKS = register("nether_bricks_large_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_LARGE_TILES = register("nether_bricks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_ROTATED_BRICKS = register("nether_bricks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_SMALL_TILES = register("nether_bricks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_SMOOTH = register("nether_bricks_smooth", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_SQUARES = register("nether_bricks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_TILES = register("nether_bricks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BEAMS = register("oak_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BRICK_PAVING = register("oak_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_CRATE = register("oak_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_DIAGONAL_STRIPES = register("oak_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_DIAGONAL_TILES = register("oak_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_DOTTED = register("oak_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_FLOORING = register("oak_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_LARGE_TILES = register("oak_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_PATTERN = register("oak_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_ROTATED_BRICKS = register("oak_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_SMALL_BRICKS = register("oak_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_SMALL_TILES = register("oak_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_SQUARES = register("oak_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_TILES = register("oak_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_WAVY = register("oak_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_WOVEN = register("oak_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BORDERED = register("obsidian_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_PAVING = register("obsidian_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_CHISELED = register("obsidian_chiseled", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_DARK = register("obsidian_dark", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_ROTATED_BRICKS = register("obsidian_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_SPOTS = register("obsidian_spots", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_SQUARES = register("obsidian_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_STRIPES = register("obsidian_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_TILES = register("obsidian_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
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
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BEAMS = register("prismarine_bricks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BRICK_PAVING = register("prismarine_bricks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_CHISELED_CIRCLES = register("prismarine_bricks_chiseled_circles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_CHISELED_SQUARES = register("prismarine_bricks_chiseled_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_DIAGONAL_BRICKS = register("prismarine_bricks_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_DIAGONAL_TILES = register("prismarine_bricks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_DOTTED = register("prismarine_bricks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_POLISHED = register("prismarine_bricks_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_ROTATED_BRICKS = register("prismarine_bricks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_ROWS = register("prismarine_bricks_rows", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_SMALL_TILES = register("prismarine_bricks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_SQUARES = register("prismarine_bricks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_TILES = register("prismarine_bricks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_WAVY = register("prismarine_bricks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_WOVEN = register("prismarine_bricks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_STAINED_GLASS = register("purple_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPUR_BRICK_PAVING = register("purpur_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_DIAGONAL_BRICKS = register("purpur_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_DIAGONAL_TILES = register("purpur_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_DOTTED = register("purpur_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_FABRIC = register("purpur_fabric", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_JAGGED_PATTERN = register("purpur_jagged_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_LARGE_TILES = register("purpur_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_ORGANIC_PATTERN = register("purpur_organic_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_ROTATED_BRICKS = register("purpur_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SLANTED_TILES = register("purpur_slanted_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SMALL_TILES = register("purpur_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SPIRAL_PATTERN = register("purpur_spiral_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SQUARES = register("purpur_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_TILES = register("purpur_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_WOVEN = register("purpur_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK = register("quartz_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_BORDERED = register("quartz_block_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_BRICK_PAVING = register("quartz_block_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_CHISELED_PILLAR = register("quartz_block_chiseled_pillar", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_CONNECTING = register("quartz_block_connecting", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_CROSSES = register("quartz_block_crosses", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_DIAGONAL_TILES = register("quartz_block_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_PATTERN = register("quartz_block_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_ROTATED_BRICKS = register("quartz_block_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_ROWS = register("quartz_block_rows", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_SCALES = register("quartz_block_scales", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_SMALL_TILES = register("quartz_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_SQUARES = register("quartz_block_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_STRIPES = register("quartz_block_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_TILES = register("quartz_block_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUICKSOIL_GLASS = register("quicksoil_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_BORDERED = register("redstone_block_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_CHISELED_CLOVERS = register("redstone_block_chiseled_clovers", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_CIRCLES = register("redstone_block_circles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_COMPRESSED = register("redstone_block_compressed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_DIAGONAL_TILES = register("redstone_block_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PATTERNED = register("redstone_block_patterned", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PAVING = register("redstone_block_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_POLISHED = register("redstone_block_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_SCALES = register("redstone_block_scales", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_SMALL_TILES = register("redstone_block_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_BEAMS = register("red_nether_bricks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_BRICK_PAVING = register("red_nether_bricks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_CHISELED_SQUARES = register("red_nether_bricks_chiseled_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_DIAGONAL_BRICKS = register("red_nether_bricks_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_LARGE_TILES = register("red_nether_bricks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_ROTATED_BRICKS = register("red_nether_bricks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_SMALL_TILES = register("red_nether_bricks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_SMOOTH = register("red_nether_bricks_smooth", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_SQUARES = register("red_nether_bricks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_TILES = register("red_nether_bricks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_BRICK_PAVING = register("red_sandstone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_DIAGONAL_BRICKS = register("red_sandstone_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_LARGE_TILES = register("red_sandstone_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_POLISHED = register("red_sandstone_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_ROTATED_BRICKS = register("red_sandstone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_TILES = register("red_sandstone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_STAINED_GLASS = register("red_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> REINFORCED_GLASS = register("reinforced_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SANDSTONE_BRICK_PAVING = register("sandstone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_DIAGONAL_BRICKS = register("sandstone_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_LARGE_TILES = register("sandstone_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_POLISHED = register("sandstone_polished", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_ROTATED_BRICKS = register("sandstone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_TILES = register("sandstone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
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
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BEAMS = register("spruce_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BRICK_PAVING = register("spruce_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_CRATE = register("spruce_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_DIAGONAL_STRIPES = register("spruce_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_DIAGONAL_TILES = register("spruce_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_DOTTED = register("spruce_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_FLOORING = register("spruce_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_LARGE_TILES = register("spruce_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_PATTERN = register("spruce_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_ROTATED_BRICKS = register("spruce_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SMALL_BRICKS = register("spruce_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SMALL_TILES = register("spruce_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SQUARES = register("spruce_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_TILES = register("spruce_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_WAVY = register("spruce_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_WOVEN = register("spruce_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BIG_TILES = register("stone_big_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BORDERED = register("stone_bordered", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BRICK_PAVING = register("stone_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_CHISELED_BRICKS = register("stone_chiseled_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_CRUSHED = register("stone_crushed", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_DIAGONAL_BRICKS = register("stone_diagonal_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_PATH = register("stone_path", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_ROTATED_BRICKS = register("stone_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SLATED_END = register("stone_slated_end", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMALL_TILES = register("stone_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH = register("stone_smooth", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_BRICK_PAVING = register("stone_smooth_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_LARGE_TILES = register("stone_smooth_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_ROTATED_BRICKS = register("stone_smooth_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_TILES = register("stone_smooth_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SQUARES = register("stone_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_TILES = register("stone_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_WAVES = register("stone_waves", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
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
    public static final DeferredBlock<Block> WARPED_PLANKS_BEAMS = register("warped_planks_beams", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BRICK_PAVING = register("warped_planks_brick_paving", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_CRATE = register("warped_planks_crate", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_DIAGONAL_STRIPES = register("warped_planks_diagonal_stripes", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_DIAGONAL_TILES = register("warped_planks_diagonal_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_DOTTED = register("warped_planks_dotted", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_FLOORING = register("warped_planks_flooring", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_LARGE_TILES = register("warped_planks_large_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_PATTERN = register("warped_planks_pattern", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_ROTATED_BRICKS = register("warped_planks_rotated_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_SMALL_BRICKS = register("warped_planks_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_SMALL_TILES = register("warped_planks_small_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_SQUARES = register("warped_planks_squares", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_TILES = register("warped_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_WAVY = register("warped_planks_wavy", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_WOVEN = register("warped_planks_woven", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WEATHERED_COPPER_BLOCK = register("weathered_copper_block", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WEATHERED_COPPER_GRATE = register("weathered_copper_grate", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WHITE_STAINED_GLASS = register("white_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_STAINED_GLASS = register("yellow_stained_glass", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_PILLAR = register("amethyst_block_pillar", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_PILLAR = register("emerald_block_pillar", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PILLAR = register("redstone_block_pillar", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BRICKS = register("acacia_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_BRICKS = register("amethyst_block_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BRICKS = register("andesite_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BRICKS = register("bamboo_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BRICKS = register("basalt_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BRICKS = register("birch_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_BRICKS = register("blue_ice_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_BRICKS = register("cherry_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BRICKS = register("cobbled_deepslate_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_SMALL_BRICKS = register("copper_block_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BRICKS = register("crimson_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BRICKS = register("dark_oak_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_BRICKS = register("dark_prismarine_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_BRICKS = register("diorite_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_BRICKS = register("glowstone_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_SMALL_BRICKS = register("gold_block_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_BRICKS = register("granite_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_SMALL_BRICKS = register("iron_block_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BRICKS = register("jungle_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BRICKS = register("mangrove_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_BRICKS = register("netherite_block_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BRICKS = register("netherrack_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BRICKS = register("oak_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BRICKS = register("obsidian_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICKS = register("pale_oak_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BRICKS = register("prismarine_bricks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_BRICKS = register("purpur_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_BRICKS = register("redstone_block_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_LARGE_BRICKS = register("red_nether_bricks_large_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_BRICKS = register("red_sandstone_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_BRICKS = register("sandstone_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BRICKS = register("spruce_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMALL_BRICKS = register("stone_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BRICKS = register("warped_planks_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_WINDOW_BARS_PILLAR = register("acacia_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_COVERED_PILLAR = register("acacia_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_DIAGONAL_PILLAR = register("acacia_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_LARGE_PILLAR = register("acacia_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_PANES_PILLAR = register("acacia_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_ROUNDED_PILLAR = register("acacia_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SLIM_PILLAR = register("acacia_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SWIRLING_PILLAR = register("acacia_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_BARS_PILLAR = register("birch_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_COVERED_PILLAR = register("birch_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_DIAGONAL_PILLAR = register("birch_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_LARGE_PILLAR = register("birch_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_PANES_PILLAR = register("birch_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_ROUNDED_PILLAR = register("birch_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SLIM_PILLAR = register("birch_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SWIRLING_PILLAR = register("birch_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BONE_BLOCK_CONNECTING = register("bone_block_connecting", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_BARS_PILLAR = register("crimson_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_COVERED_PILLAR = register("crimson_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_DIAGONAL_PILLAR = register("crimson_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_LARGE_PILLAR = register("crimson_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_PANES_PILLAR = register("crimson_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_ROUNDED_PILLAR = register("crimson_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SLIM_PILLAR = register("crimson_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SWIRLING_PILLAR = register("crimson_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_BARS_PILLAR = register("dark_oak_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_COVERED_PILLAR = register("dark_oak_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_DIAGONAL_PILLAR = register("dark_oak_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_LARGE_PILLAR = register("dark_oak_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_PANES_PILLAR = register("dark_oak_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_ROUNDED_PILLAR = register("dark_oak_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SLIM_PILLAR = register("dark_oak_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SWIRLING_PILLAR = register("dark_oak_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_BARS_PILLAR = register("jungle_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_COVERED_PILLAR = register("jungle_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_DIAGONAL_PILLAR = register("jungle_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_LARGE_PILLAR = register("jungle_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_PANES_PILLAR = register("jungle_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_ROUNDED_PILLAR = register("jungle_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SLIM_PILLAR = register("jungle_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SWIRLING_PILLAR = register("jungle_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_BARS_PILLAR = register("mangrove_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_COVERED_PILLAR = register("mangrove_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_DIAGONAL_PILLAR = register("mangrove_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_LARGE_PILLAR = register("mangrove_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_PANES_PILLAR = register("mangrove_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_ROUNDED_PILLAR = register("mangrove_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SLIM_PILLAR = register("mangrove_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SWIRLING_PILLAR = register("mangrove_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_BARS_PILLAR = register("oak_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_COVERED_PILLAR = register("oak_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_DIAGONAL_PILLAR = register("oak_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_LARGE_PILLAR = register("oak_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_PANES_PILLAR = register("oak_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_ROUNDED_PILLAR = register("oak_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SLIM_PILLAR = register("oak_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SWIRLING_PILLAR = register("oak_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ROSE_QUARTZ_BRICKS = register("rose_quartz_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_BARS_PILLAR = register("spruce_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_COVERED_PILLAR = register("spruce_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_DIAGONAL_PILLAR = register("spruce_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_LARGE_PILLAR = register("spruce_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_PANES_PILLAR = register("spruce_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_ROUNDED_PILLAR = register("spruce_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SLIM_PILLAR = register("spruce_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SWIRLING_PILLAR = register("spruce_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_BARS_PILLAR = register("warped_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_COVERED_PILLAR = register("warped_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_DIAGONAL_PILLAR = register("warped_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_LARGE_PILLAR = register("warped_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_PANES_PILLAR = register("warped_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_ROUNDED_PILLAR = register("warped_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SLIM_PILLAR = register("warped_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SWIRLING_PILLAR = register("warped_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS_PILLAR = register("pale_oak_window_bars_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED_PILLAR = register("pale_oak_window_covered_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL_PILLAR = register("pale_oak_window_diagonal_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE_PILLAR = register("pale_oak_window_large_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES_PILLAR = register("pale_oak_window_panes_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED_PILLAR = register("pale_oak_window_rounded_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM_PILLAR = register("pale_oak_window_slim_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING_PILLAR = register("pale_oak_window_swirling_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES_PILLAR = register("pale_oak_window_tiles_pillar", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ── Plain window blocks (cube_column) ──────────────────────────────────────────
    public static final DeferredBlock<Block> ACACIA_WINDOW_BARS = register("acacia_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_COVERED = register("acacia_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_DIAGONAL = register("acacia_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_LARGE = register("acacia_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_PANES = register("acacia_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_ROUNDED = register("acacia_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SLIM = register("acacia_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SWIRLING = register("acacia_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_TILES = register("acacia_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_BARS = register("birch_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_COVERED = register("birch_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_DIAGONAL = register("birch_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_LARGE = register("birch_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_PANES = register("birch_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_ROUNDED = register("birch_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SLIM = register("birch_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SWIRLING = register("birch_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_TILES = register("birch_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_BARS = register("crimson_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_COVERED = register("crimson_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_DIAGONAL = register("crimson_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_LARGE = register("crimson_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_PANES = register("crimson_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_ROUNDED = register("crimson_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SLIM = register("crimson_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SWIRLING = register("crimson_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_TILES = register("crimson_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_BARS = register("dark_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_COVERED = register("dark_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_DIAGONAL = register("dark_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_LARGE = register("dark_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_PANES = register("dark_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_ROUNDED = register("dark_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SLIM = register("dark_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SWIRLING = register("dark_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_TILES = register("dark_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_BARS = register("jungle_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_COVERED = register("jungle_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_DIAGONAL = register("jungle_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_LARGE = register("jungle_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_PANES = register("jungle_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_ROUNDED = register("jungle_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SLIM = register("jungle_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SWIRLING = register("jungle_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_TILES = register("jungle_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_BARS = register("mangrove_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_COVERED = register("mangrove_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_DIAGONAL = register("mangrove_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_LARGE = register("mangrove_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_PANES = register("mangrove_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_ROUNDED = register("mangrove_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SLIM = register("mangrove_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SWIRLING = register("mangrove_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_TILES = register("mangrove_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_BARS = register("oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_COVERED = register("oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_DIAGONAL = register("oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_LARGE = register("oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_PANES = register("oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_ROUNDED = register("oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SLIM = register("oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SWIRLING = register("oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_TILES = register("oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS = register("pale_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED = register("pale_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL = register("pale_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE = register("pale_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES = register("pale_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED = register("pale_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM = register("pale_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING = register("pale_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES = register("pale_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_BARS = register("spruce_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_COVERED = register("spruce_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_DIAGONAL = register("spruce_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_LARGE = register("spruce_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_PANES = register("spruce_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_ROUNDED = register("spruce_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SLIM = register("spruce_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SWIRLING = register("spruce_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_TILES = register("spruce_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_BARS = register("warped_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_COVERED = register("warped_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_DIAGONAL = register("warped_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_LARGE = register("warped_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_PANES = register("warped_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_ROUNDED = register("warped_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SLIM = register("warped_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SWIRLING = register("warped_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_TILES = register("warped_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ── Glass/ plain blocks ───────────────────────────────────────────────────────
    public static final DeferredBlock<Block> CIRCLE_OAK_GLASS = register("circle_oak_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LEADED_GLASS = register("leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_BARED_GLASS = register("oak_bared_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_SNOWFLAKE_GLASS = register("oak_snowflake_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> GLASS_OCHRE_FROGLIGHT = register("glass_ochre_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GLASS_PEARLESCENT_FROGLIGHT = register("glass_pearlescent_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GLASS_VERDANT_FROGLIGHT = register("glass_verdant_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));

    // ── Pane blocks ───────────────────────────────────────────────────────────────
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_BARS_PANE = register("acacia_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_COVERED_PANE = register("acacia_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_DIAGONAL_PANE = register("acacia_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_LARGE_PANE = register("acacia_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_PANES_PANE = register("acacia_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_ROUNDED_PANE = register("acacia_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_SLIM_PANE = register("acacia_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_SWIRLING_PANE = register("acacia_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_TILES_PANE = register("acacia_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_BARS_PANE = register("birch_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_COVERED_PANE = register("birch_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_DIAGONAL_PANE = register("birch_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_LARGE_PANE = register("birch_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_PANES_PANE = register("birch_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_ROUNDED_PANE = register("birch_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_SLIM_PANE = register("birch_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_SWIRLING_PANE = register("birch_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_TILES_PANE = register("birch_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_BARS_PANE = register("crimson_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_COVERED_PANE = register("crimson_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_DIAGONAL_PANE = register("crimson_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_LARGE_PANE = register("crimson_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_PANES_PANE = register("crimson_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_ROUNDED_PANE = register("crimson_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_SLIM_PANE = register("crimson_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_SWIRLING_PANE = register("crimson_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_TILES_PANE = register("crimson_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_BARS_PANE = register("dark_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_COVERED_PANE = register("dark_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_DIAGONAL_PANE = register("dark_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_LARGE_PANE = register("dark_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_PANES_PANE = register("dark_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_ROUNDED_PANE = register("dark_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_SLIM_PANE = register("dark_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_SWIRLING_PANE = register("dark_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_TILES_PANE = register("dark_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_BARS_PANE = register("jungle_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_COVERED_PANE = register("jungle_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_DIAGONAL_PANE = register("jungle_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_LARGE_PANE = register("jungle_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_PANES_PANE = register("jungle_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_ROUNDED_PANE = register("jungle_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_SLIM_PANE = register("jungle_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_SWIRLING_PANE = register("jungle_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_TILES_PANE = register("jungle_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_BARS_PANE = register("mangrove_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_COVERED_PANE = register("mangrove_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_DIAGONAL_PANE = register("mangrove_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_LARGE_PANE = register("mangrove_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_PANES_PANE = register("mangrove_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_ROUNDED_PANE = register("mangrove_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_SLIM_PANE = register("mangrove_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_SWIRLING_PANE = register("mangrove_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_TILES_PANE = register("mangrove_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_BARS_PANE = register("oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_COVERED_PANE = register("oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_DIAGONAL_PANE = register("oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_LARGE_PANE = register("oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_PANES_PANE = register("oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_ROUNDED_PANE = register("oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_SLIM_PANE = register("oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_SWIRLING_PANE = register("oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_TILES_PANE = register("oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_BARS_PANE = register("pale_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_COVERED_PANE = register("pale_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_DIAGONAL_PANE = register("pale_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_LARGE_PANE = register("pale_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_PANES_PANE = register("pale_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_ROUNDED_PANE = register("pale_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SLIM_PANE = register("pale_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SWIRLING_PANE = register("pale_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_TILES_PANE = register("pale_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_BARS_PANE = register("spruce_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_COVERED_PANE = register("spruce_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_DIAGONAL_PANE = register("spruce_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_LARGE_PANE = register("spruce_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_PANES_PANE = register("spruce_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_ROUNDED_PANE = register("spruce_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_SLIM_PANE = register("spruce_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_SWIRLING_PANE = register("spruce_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_TILES_PANE = register("spruce_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_BARS_PANE = register("warped_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_COVERED_PANE = register("warped_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_DIAGONAL_PANE = register("warped_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_LARGE_PANE = register("warped_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_PANES_PANE = register("warped_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_ROUNDED_PANE = register("warped_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_SLIM_PANE = register("warped_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_SWIRLING_PANE = register("warped_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_TILES_PANE = register("warped_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LEADED_STAINED_GLASS_PANE = register("circular_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CLEAR_LEADED_GLASS_PANE = register("clear_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LEADED_GLASS_PANE = register("fancy_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LEADED_GLASS_PANE = register("large_diamond_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEAD_WOVEN_GLASS_PANE = register("lead_woven_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LEADED_GLASS_PANE = register("ornate_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LEADED_GLASS_PANE = register("raster_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_DIAMOND_LEADED_GLASS_PANE = register("small_diamond_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LEADED_GLASS_PANE = register("square_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_LEADED_GLASS_PANE = register("vertical_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_BLACK_STAINED_GLASS_PANE = register("circular_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BLACK_LEADED_STAINED_GLASS_PANE = register("black_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_BLACK_STAINED_GLASS_PANE = register("fancy_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_BLACK_STAINED_GLASS_PANE = register("large_diamond_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_BLACK_STAINED_GLASS_PANE = register("ornate_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_BLACK_STAINED_GLASS_PANE = register("raster_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_BLACK_STAINED_GLASS_PANE = register("small_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_BLACK_STAINED_GLASS_PANE = register("square_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_BLACK_STAINED_GLASS_PANE = register("tiled_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_BLACK_STAINED_GLASS_PANE = register("vertical_striped_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_BLACK_STAINED_GLASS_PANE = register("woven_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_BLUE_STAINED_GLASS_PANE = register("circular_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BLUE_LEADED_STAINED_GLASS_PANE = register("blue_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_BLUE_STAINED_GLASS_PANE = register("fancy_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_BLUE_STAINED_GLASS_PANE = register("large_diamond_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_BLUE_STAINED_GLASS_PANE = register("ornate_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_BLUE_STAINED_GLASS_PANE = register("raster_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_BLUE_STAINED_GLASS_PANE = register("small_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_BLUE_STAINED_GLASS_PANE = register("square_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_BLUE_STAINED_GLASS_PANE = register("tiled_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_BLUE_STAINED_GLASS_PANE = register("vertical_striped_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_BLUE_STAINED_GLASS_PANE = register("woven_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_BROWN_STAINED_GLASS_PANE = register("circular_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BROWN_LEADED_STAINED_GLASS_PANE = register("brown_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_BROWN_STAINED_GLASS_PANE = register("fancy_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_BROWN_STAINED_GLASS_PANE = register("large_diamond_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_BROWN_STAINED_GLASS_PANE = register("ornate_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_BROWN_STAINED_GLASS_PANE = register("raster_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_BROWN_STAINED_GLASS_PANE = register("small_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_BROWN_STAINED_GLASS_PANE = register("square_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_BROWN_STAINED_GLASS_PANE = register("tiled_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_BROWN_STAINED_GLASS_PANE = register("vertical_striped_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_BROWN_STAINED_GLASS_PANE = register("woven_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_CYAN_STAINED_GLASS_PANE = register("circular_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CYAN_LEADED_STAINED_GLASS_PANE = register("cyan_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_CYAN_STAINED_GLASS_PANE = register("fancy_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_CYAN_STAINED_GLASS_PANE = register("large_diamond_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_CYAN_STAINED_GLASS_PANE = register("ornate_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_CYAN_STAINED_GLASS_PANE = register("raster_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_CYAN_STAINED_GLASS_PANE = register("small_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_CYAN_STAINED_GLASS_PANE = register("square_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_CYAN_STAINED_GLASS_PANE = register("tiled_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_CYAN_STAINED_GLASS_PANE = register("vertical_striped_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_CYAN_STAINED_GLASS_PANE = register("woven_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_GRAY_STAINED_GLASS_PANE = register("circular_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GRAY_LEADED_STAINED_GLASS_PANE = register("gray_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_GRAY_STAINED_GLASS_PANE = register("fancy_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_GRAY_STAINED_GLASS_PANE = register("large_diamond_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_GRAY_STAINED_GLASS_PANE = register("ornate_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_GRAY_STAINED_GLASS_PANE = register("raster_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_GRAY_STAINED_GLASS_PANE = register("small_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_GRAY_STAINED_GLASS_PANE = register("square_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_GRAY_STAINED_GLASS_PANE = register("tiled_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_GRAY_STAINED_GLASS_PANE = register("vertical_striped_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_GRAY_STAINED_GLASS_PANE = register("woven_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_GREEN_STAINED_GLASS_PANE = register("circular_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GREEN_LEADED_STAINED_GLASS_PANE = register("green_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_GREEN_STAINED_GLASS_PANE = register("fancy_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_GREEN_STAINED_GLASS_PANE = register("large_diamond_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_GREEN_STAINED_GLASS_PANE = register("ornate_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_GREEN_STAINED_GLASS_PANE = register("raster_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_GREEN_STAINED_GLASS_PANE = register("small_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_GREEN_STAINED_GLASS_PANE = register("square_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_GREEN_STAINED_GLASS_PANE = register("tiled_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_GREEN_STAINED_GLASS_PANE = register("vertical_striped_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_GREEN_STAINED_GLASS_PANE = register("woven_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
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
    public static final DeferredBlock<IronBarsBlock> CIRCLE_OAK_GLASS_PANE = register("circle_oak_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEADED_GLASS_PANE = register("leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_BARED_GLASS_PANE = register("oak_bared_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_SNOWFLAKE_GLASS_PANE = register("oak_snowflake_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GLASS_OCHRE_FROGLIGHT_PANE = register("glass_ochre_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));
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