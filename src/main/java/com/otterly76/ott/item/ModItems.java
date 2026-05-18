package com.otterly76.ott.item;

import com.otterly76.ott.Constants;
import com.otterly76.ott.block.ModBlocks;
import com.otterly76.ott.color.ModColorSets;
import com.otterly76.ott.color.ModPatterns;
import com.otterly76.ott.entity.ModEntities;
import com.otterly76.ott.entity.variant.ChickenVariants;
import com.otterly76.ott.registry.ModArmorMaterials;
import com.otterly76.ott.registry.ModDataComponents;
import com.otterly76.ott.registry.ModJukeboxSongs;
import com.otterly76.ott.entity.vehicle.OttWoodSetBoatEntity;
import com.otterly76.ott.entity.vehicle.OttWoodSetChestBoatEntity;
import com.otterly76.ott.entity.custom.Butterfly;
import com.otterly76.ott.item.custom.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    public static final DeferredRegister.Items MINECRAFT_ITEMS = ModBlocks.MINECRAFT_ITEMS;

    public static final Map<String, Map<String, DeferredItem<Item>>> WOOD_DOOR_ITEMS = new LinkedHashMap<>();
    public static final Map<String, DeferredItem<SignItem>> WOOD_SET_SIGNS = new HashMap<>();
    public static final Map<String, DeferredItem<HangingSignItem>> WOOD_SET_HANGING_SIGNS = new HashMap<>();
    public static final Map<String, DeferredItem<ModBoatItem>> WOOD_SET_BOATS = new HashMap<>();
    public static final Map<String, DeferredItem<ModBoatItem>> WOOD_SET_CHEST_BOATS = new HashMap<>();

    public static final Map<String, DeferredItem<Item>> CUSTOM_DYES = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> CLAY_TILES = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> HARNESSES = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> BUNDLES = new HashMap<>();

    // Creative tab icon (no gameplay use)
    public static final DeferredItem<Item> OTT_LOGO = ITEMS.register("ott_logo", () -> new Item(new Item.Properties()));

    // Standard Items
    public static final DeferredItem<Item> CLAM = ITEMS.register("clam", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KOI_FISH = ITEMS.register("koi_fish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> PEARL = ITEMS.register("pearl", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILK = ITEMS.register("silk", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SOUL_GLASS = registerBlockItem("soul_glass", ModBlocks.SOUL_GLASS);
    public static final DeferredHolder<Item, BlockItem> SOUL_GLASS_PANE = registerBlockItem("soul_glass_pane", ModBlocks.SOUL_GLASS_PANE);

    // Opal crystal drop items
    public static final DeferredItem<Item> WHITE_OPAL_CRYSTAL = ITEMS.register("white_opal_crystal", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACK_OPAL_CRYSTAL = ITEMS.register("black_opal_crystal", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FIRE_OPAL_CRYSTAL  = ITEMS.register("fire_opal_crystal",  () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, BlockItem> SILK_COCOON = registerBlockItem("silk_cocoon", ModBlocks.SILK_COCOON);
    public static final DeferredItem<Item> DRAGON_SKULL = ITEMS.register("dragon_skull", () -> new net.minecraft.world.item.StandingAndWallBlockItem(ModBlocks.DRAGON_SKULL.get(), ModBlocks.DRAGON_WALL_SKULL.get(), new net.minecraft.world.item.Item.Properties(), net.minecraft.core.Direction.DOWN));
    public static final DeferredHolder<Item, BlockItem> THORNY_HEDGE = registerBlockItem("thorny_hedge", ModBlocks.THORNY_HEDGE);
    public static final DeferredItem<Item> THORNY_HEDGE_SPROUTS = ITEMS.register("thorny_hedge_sprouts", () -> new ItemNameBlockItem(ModBlocks.THORNY_HEDGE_SPROUTS.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PROTECTIVE_LANTERN = registerBlockItem("protective_lantern", ModBlocks.PROTECTIVE_LANTERN);
    public static final DeferredHolder<Item, BlockItem> WEATHERING_STATION = registerBlockItem("weathering_station", ModBlocks.WEATHERING_STATION);
    public static final DeferredHolder<Item, BlockItem> WOODCUTTER = registerBlockItem("woodcutter", ModBlocks.WOODCUTTER);
    public static final DeferredHolder<Item, BlockItem> ENGRAVING_TABLE = registerBlockItem("engraving_table", ModBlocks.ENGRAVING_TABLE);
    public static final DeferredHolder<Item, BlockItem> WATER_LANTERN = registerBlockItem("water_lantern", ModBlocks.WATER_LANTERN);
    public static final DeferredHolder<Item, BlockItem> LAVA_LANTERN = registerBlockItem("lava_lantern", ModBlocks.LAVA_LANTERN);
    public static final DeferredHolder<Item, BlockItem> SMITE_LANTERN = registerBlockItem("smite_lantern", ModBlocks.SMITE_LANTERN);
    public static final DeferredItem<Item> BIG_LILY_PAD = ITEMS.register("big_lily_pad", () -> new PlaceOnWaterBlockItem(ModBlocks.BIG_LILY_PAD.get(), new Item.Properties()));
    public static final DeferredItem<Item> TINY_COAL = ITEMS.register("tiny_coal", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TINY_CHARCOAL = ITEMS.register("tiny_charcoal", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TORCH_ARROW = ITEMS.register("torch_arrow", () -> new TorchArrowItem(new Item.Properties()));
    public static final DeferredItem<Item> MAN_O_WAR_BUCKET = ITEMS.register("man_o_war_bucket", () -> new MobBucketItem(ModEntities.MAN_O_WAR.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> MAN_O_WAR_SPAWN_EGG = ITEMS.register("man_o_war_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.MAN_O_WAR, 0xFF4751E0, 0xFF5D33A4, new Item.Properties()));
    public static final DeferredItem<Item> DUCK_SPAWN_EGG = ITEMS.register("duck_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.DUCK, 0xFFFFFFFF, 0xFF29A832, new Item.Properties()));
    public static final DeferredItem<Item> GOOSE_SPAWN_EGG = ITEMS.register("goose_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GOOSE, 0xFFFFFFFF, 0xFF808080, new Item.Properties()));
    public static final DeferredItem<Item> STINGRAY_BUCKET = ITEMS.register("stingray_bucket", () -> new MobBucketItem(ModEntities.STINGRAY.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> STINGRAY_SPAWN_EGG = ITEMS.register("stingray_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.STINGRAY, 0xFF838788, 0xFF454748, new Item.Properties()));
    public static final DeferredItem<Item> CICHLID_SPAWN_EGG = ITEMS.register("cichlid_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CICHLID, 0x3F51B5, 0x1A237E, new Item.Properties()));
    public static final DeferredItem<Item> LEOPARD_CAT_SPAWN_EGG = ITEMS.register("leopard_cat_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.LEOPARD_CAT, 0xC4A484, 0x4B3621, new Item.Properties()));
    public static final DeferredItem<Item> ECHIDNA_SPAWN_EGG = ITEMS.register("echidna_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.ECHIDNA, 0x5C4033, 0xD2B48C, new Item.Properties()));
    public static final DeferredItem<Item> GUITARFISH_SPAWN_EGG = ITEMS.register("guitarfish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.GUITARFISH, 0x708090, 0xC0C0C0, new Item.Properties()));
    public static final DeferredItem<Item> BONNETHEAD_SHARK_SPAWN_EGG = ITEMS.register("bonnethead_shark_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BONNETHEAD_SHARK, 0x708090, 0x2F4F4F, new Item.Properties()));
    public static final DeferredItem<Item> BURROWING_OWL_SPAWN_EGG = ITEMS.register("burrowing_owl_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BURROWING_OWL, 0x8B4513, 0xD2B48C, new Item.Properties()));
    public static final DeferredItem<Item> BUSHDOG_SPAWN_EGG = ITEMS.register("bushdog_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BUSHDOG, 0x8B4513, 0x5C4033, new Item.Properties()));
    public static final DeferredItem<Item> QUAIL_SPAWN_EGG = ITEMS.register("quail_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.QUAIL, 0x808080, 0x404040, new Item.Properties()));
    public static final DeferredItem<Item> CANDYCANE_SNAIL_SPAWN_EGG = ITEMS.register("candycane_snail_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CANDYCANE_SNAIL, 0xFFFFFF, 0xFF0000, new Item.Properties()));
    public static final DeferredItem<Item> FIRE_SALAMANDER_SPAWN_EGG = ITEMS.register("fire_salamander_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.FIRE_SALAMANDER, 0x000000, 0xFFD700, new Item.Properties()));
    public static final DeferredItem<Item> RIVER_TURTLE_SPAWN_EGG = ITEMS.register("river_turtle_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.RIVER_TURTLE, 0x6B8E23, 0x556B2F, new Item.Properties()));
    public static final DeferredItem<Item> GOBLIN_SHARK_SPAWN_EGG = ITEMS.register("goblin_shark_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.GOBLIN_SHARK, 0xDB7093, 0xFFC0CB, new Item.Properties()));
    public static final DeferredItem<Item> GUINEA_FOWL_SPAWN_EGG = ITEMS.register("guinea_fowl_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.GUINEA_FOWL, 0x404040, 0xFFFFFF, new Item.Properties()));
    public static final DeferredItem<Item> IMPALA_SPAWN_EGG = ITEMS.register("impala_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.IMPALA, 0xC4A484, 0xFFFFFF, new Item.Properties()));
    public static final DeferredItem<Item> MANTA_RAY_SPAWN_EGG = ITEMS.register("manta_ray_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.MANTA_RAY, 0x2F4F4F, 0xFFFFFF, new Item.Properties()));
    public static final DeferredItem<Item> STORK_SPAWN_EGG = ITEMS.register("stork_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.STORK, 0x404040, 0xFFFFFF, new Item.Properties()));
    public static final DeferredItem<Item> MOLE_SPAWN_EGG = ITEMS.register("mole_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.MOLE, 0x2F4F4F, 0x000000, new Item.Properties()));
    public static final DeferredItem<Item> TREE_KANGAROO_SPAWN_EGG = ITEMS.register("tree_kangaroo_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.TREE_KANGAROO, 0x8B4513, 0xFFD700, new Item.Properties()));
    public static final DeferredItem<Item> PALLAS_CAT_SPAWN_EGG = ITEMS.register("pallas_cat_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.PALLAS_CAT, 0x808080, 0xC0C0C0, new Item.Properties()));
    public static final DeferredItem<Item> PINK_LAND_IGUANA_SPAWN_EGG = ITEMS.register("pink_land_iguana_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.PINK_LAND_IGUANA, 0xFFC0CB, 0xDB7093, new Item.Properties()));
    public static final DeferredItem<Item> PSYCHO_JELLY_SPAWN_EGG = ITEMS.register("psycho_jelly_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.PSYCHO_JELLY, 0xFF00FF, 0x00FFFF, new Item.Properties()));
    public static final DeferredItem<Item> SPOONBILL_SPAWN_EGG = ITEMS.register("spoonbill_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SPOONBILL, 0xFFC0CB, 0xFFFFFF, new Item.Properties()));
    public static final DeferredItem<Item> GIANT_SOFTSHELL_TURTLE_SPAWN_EGG = ITEMS.register("giant_softshell_turtle_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.GIANT_SOFTSHELL_TURTLE, 0x556B2F, 0x8B4513, new Item.Properties()));
    public static final DeferredItem<Item> SUNFISH_BUCKET = ITEMS.register("sunfish_bucket", () -> new MobBucketItem(ModEntities.SUNFISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> SUNFISH_SPAWN_EGG = ITEMS.register("sunfish_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SUNFISH, 0xFF967E67, 0xFFD6C6B0, new Item.Properties()));
    public static final DeferredItem<Item> KRILL_BUCKET = ITEMS.register("krill_bucket", () -> new MobBucketItem(ModEntities.KRILL.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> KRILL_SPAWN_EGG = ITEMS.register("krill_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.KRILL, 0xFFF09090, 0xFFD05050, new Item.Properties()));
    public static final DeferredItem<Item> ANGELFISH_BUCKET = ITEMS.register("angelfish_bucket", () -> new MobBucketItem(ModEntities.ANGELFISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> ANGELFISH_SPAWN_EGG = ITEMS.register("angelfish_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ANGELFISH, 0xFFE0E0E0, 0xFF202020, new Item.Properties()));
    public static final DeferredItem<Item> BARRELEYE_BUCKET = ITEMS.register("barreleye_bucket", () -> new MobBucketItem(ModEntities.BARRELEYE.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> BARRELEYE_SPAWN_EGG = ITEMS.register("barreleye_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BARRELEYE, 0xFF2D3233, 0xFF5A8452, new Item.Properties()));
    public static final DeferredItem<Item> FLOUNDER_BUCKET = ITEMS.register("flounder_bucket", () -> new MobBucketItem(ModEntities.FLOUNDER.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> FLOUNDER_SPAWN_EGG = ITEMS.register("flounder_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.FLOUNDER, 0xFF604D3F, 0xFF9C8A7B, new Item.Properties()));
    public static final DeferredItem<Item> MARINE_IGUANA_BUCKET = ITEMS.register("marine_iguana_bucket", () -> new MobBucketItem(ModEntities.MARINE_IGUANA.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> MARINE_IGUANA_SPAWN_EGG = ITEMS.register("marine_iguana_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.MARINE_IGUANA, 0xFF5B6149, 0xFF35392B, new Item.Properties()));
    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GECKO, 0xFFD4AF37, 0xFF4B3621, new Item.Properties()));
    public static final DeferredItem<Item> EMU_SPAWN_EGG = ITEMS.register("emu_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.EMU, 0xFF4B3621, 0xFF2D1E12, new Item.Properties()));
    public static final DeferredItem<Item> HOOPOE_SPAWN_EGG = ITEMS.register("hoopoe_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.HOOPOE, 0xFFE0C09F, 0xFF4B3621, new Item.Properties()));
    public static final DeferredItem<Item> PHEASANT_SPAWN_EGG = ITEMS.register("pheasant_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.PHEASANT, 0xFF4B3621, 0xFF8B4513, new Item.Properties()));
    public static final DeferredItem<Item> TOUCAN_SPAWN_EGG = ITEMS.register("toucan_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.TOUCAN, 0xFF000000, 0xFFFFA500, new Item.Properties()));
    public static final DeferredItem<Item> PINK_SALT = ITEMS.register("pink_salt", () -> new net.minecraft.world.item.BlockItem(ModBlocks.PINK_SALT_DUST.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_SALT_BLOCK = ITEMS.register("pink_salt_block", () -> new net.minecraft.world.item.BlockItem(ModBlocks.PINK_SALT_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_PINK_SALT_BLOCK = ITEMS.register("polished_pink_salt_block", () -> new net.minecraft.world.item.BlockItem(ModBlocks.POLISHED_PINK_SALT_BLOCK.get(), new Item.Properties()));
    public static final DeferredItem<Item> PINK_SALT_LAMP = ITEMS.register("pink_salt_lamp", () -> new net.minecraft.world.item.BlockItem(ModBlocks.PINK_SALT_LAMP.get(), new Item.Properties()));
    public static final DeferredItem<Item> OAK_NEST       = ITEMS.register("oak_nest",       () -> new net.minecraft.world.item.BlockItem(ModBlocks.OAK_NEST.get(),       new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_BEEHIVE   = ITEMS.register("acacia_beehive",   () -> new net.minecraft.world.item.BlockItem(ModBlocks.ACACIA_BEEHIVE.get(),   new Item.Properties()));
    public static final DeferredItem<Item> BAMBOO_BEEHIVE   = ITEMS.register("bamboo_beehive",   () -> new net.minecraft.world.item.BlockItem(ModBlocks.BAMBOO_BEEHIVE.get(),   new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_BEEHIVE    = ITEMS.register("birch_beehive",    () -> new net.minecraft.world.item.BlockItem(ModBlocks.BIRCH_BEEHIVE.get(),    new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_BEEHIVE   = ITEMS.register("cherry_beehive",   () -> new net.minecraft.world.item.BlockItem(ModBlocks.CHERRY_BEEHIVE.get(),   new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_BEEHIVE  = ITEMS.register("crimson_beehive",  () -> new net.minecraft.world.item.BlockItem(ModBlocks.CRIMSON_BEEHIVE.get(),  new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_BEEHIVE = ITEMS.register("dark_oak_beehive", () -> new net.minecraft.world.item.BlockItem(ModBlocks.DARK_OAK_BEEHIVE.get(), new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_BEEHIVE   = ITEMS.register("jungle_beehive",   () -> new net.minecraft.world.item.BlockItem(ModBlocks.JUNGLE_BEEHIVE.get(),   new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_BEEHIVE = ITEMS.register("mangrove_beehive", () -> new net.minecraft.world.item.BlockItem(ModBlocks.MANGROVE_BEEHIVE.get(), new Item.Properties()));
    public static final DeferredItem<Item> PALE_OAK_BEEHIVE  = ITEMS.register("pale_oak_beehive",  () -> new net.minecraft.world.item.BlockItem(ModBlocks.PALE_OAK_BEEHIVE.get(),  new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_BEEHIVE   = ITEMS.register("spruce_beehive",   () -> new net.minecraft.world.item.BlockItem(ModBlocks.SPRUCE_BEEHIVE.get(),   new Item.Properties()));
    public static final DeferredItem<Item> WARPED_BEEHIVE   = ITEMS.register("warped_beehive",   () -> new net.minecraft.world.item.BlockItem(ModBlocks.WARPED_BEEHIVE.get(),   new Item.Properties()));

    static {
        ModBlocks.WOOD_DOORS.forEach((wood, styleMap) -> {
            Map<String, DeferredItem<Item>> woodItems = new LinkedHashMap<>();
            WOOD_DOOR_ITEMS.put(wood, woodItems);
            styleMap.forEach((style, block) -> {
                String regName = style + "_" + wood + "_door";
                woodItems.put(style, ITEMS.register(regName,
                        () -> new net.minecraft.world.item.BlockItem(block.get(), new Item.Properties())));
            });
        });
    }
    public static final DeferredItem<Item> EMU_EGG = ITEMS.register("emu_egg", () -> new EmuEggItem(new Item.Properties()));
    public static final DeferredItem<Item> HOOPOE_EGG = ITEMS.register("hoopoe_egg", () -> new HoopoeEggItem(new Item.Properties()));
    public static final DeferredItem<Item> PHEASANT_EGG = ITEMS.register("pheasant_egg", () -> new PheasantEggItem(new Item.Properties()));
    public static final DeferredItem<Item> TOUCAN_EGG = ITEMS.register("toucan_egg", () -> new ToucanEggItem(new Item.Properties()));
    public static final DeferredItem<Item> RAW_FLOUNDER = ITEMS.register("raw_flounder", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> RAW_ANGELFISH = ITEMS.register("raw_angelfish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> RAW_BARRELEYE = ITEMS.register("raw_barreleye", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> RAW_KRILL = ITEMS.register("raw_krill", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> FRIED_KRILL = ITEMS.register("fried_krill", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> RAW_SUNFISH_MEAT = ITEMS.register("raw_sunfish_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_SUNFISH_MEAT = ITEMS.register("cooked_sunfish_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_GOLDEN_SUNFISH_MEAT = ITEMS.register("raw_golden_sunfish_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_GOLDEN_SUNFISH_MEAT = ITEMS.register("cooked_golden_sunfish_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> CATFISH = ITEMS.register("catfish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_CATFISH = ITEMS.register("cooked_catfish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> BASS = ITEMS.register("bass", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_BASS = ITEMS.register("cooked_bass", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> CATFISH_SPAWN_EGG = ITEMS.register("catfish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CATFISH, 8416033, 12233092, new Item.Properties()));
    public static final DeferredItem<Item> WATER_BUFFALO_SPAWN_EGG = ITEMS.register("water_buffalo_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.WATER_BUFFALO, 0x4B3621, 0x2A1B0E, new Item.Properties()));
    public static final DeferredItem<Item> BASS_SPAWN_EGG = ITEMS.register("bass_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BASS, 8159273, 14729339, new Item.Properties()));
    public static final DeferredItem<Item> BLUEJAY_SPAWN_EGG = ITEMS.register("bluejay_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BLUEJAY, 2830129, 4289464, new Item.Properties()));
    public static final DeferredItem<Item> CANARY_SPAWN_EGG = ITEMS.register("canary_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CANARY, 16704333, 13999625, new Item.Properties()));
    public static final DeferredItem<Item> CARDINAL_SPAWN_EGG = ITEMS.register("cardinal_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CARDINAL, 13772840, 4465186, new Item.Properties()));
    public static final DeferredItem<Item> FINCH_SPAWN_EGG = ITEMS.register("finch_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.FINCH, 12013877, 6576975, new Item.Properties()));
    public static final DeferredItem<Item> ROBIN_SPAWN_EGG = ITEMS.register("robin_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.ROBIN, 4865860, 16620592, new Item.Properties()));
    public static final DeferredItem<Item> SPARROW_SPAWN_EGG = ITEMS.register("sparrow_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SPARROW, 6504493, 14603707, new Item.Properties()));
    public static final DeferredItem<Item> BROWN_BEAR_SPAWN_EGG = ITEMS.register("brown_bear_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BROWN_BEAR, 0x643D27, 0xC8A911, new Item.Properties()));
    public static final DeferredItem<Item> BLACK_BEAR_SPAWN_EGG = ITEMS.register("black_bear_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BLACK_BEAR, 0x1D1D1D, 0x3D3D3D, new Item.Properties()));
    public static final DeferredItem<Item> DEER_SPAWN_EGG = ITEMS.register("deer_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.DEER, 0x9D7155, 0xDDD188, new Item.Properties()));
    public static final DeferredItem<Item> REINDEER_SPAWN_EGG = ITEMS.register("reindeer_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.REINDEER, 0x8B4513, 0xD2B48C, new Item.Properties()));
    public static final DeferredItem<Item> WHITE_DEER_SPAWN_EGG = ITEMS.register("white_deer_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.WHITE_DEER, 0xFFFFFF, 0xE0E0E0, new Item.Properties()));
    public static final DeferredItem<Item> BUTTERFLY_SPAWN_EGG = ITEMS.register("butterfly_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.BUTTERFLY, 0x3d352e, 0xef9b13, new Item.Properties()));
    public static final DeferredItem<Item> CATERPILLAR_SPAWN_EGG = ITEMS.register("caterpillar_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CATERPILLAR, 0x475e33, 0xb6c753, new Item.Properties()));
    public static final DeferredItem<Item> FIREFLY_SPAWN_EGG = ITEMS.register("firefly_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.FIREFLY, 0x1d1a18, 0xfce94f, new Item.Properties()));
    public static final DeferredItem<Item> ALLIGATOR_SPAWN_EGG = ITEMS.register("alligator_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.ALLIGATOR, 0x5E5D24, 0xD2B961, new Item.Properties()));
    public static final DeferredItem<Item> ELEPHANT_SPAWN_EGG = ITEMS.register("elephant_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.ELEPHANT, 0x918E8D, 0x655D5A, new Item.Properties()));
    public static final DeferredItem<Item> GIRAFFE_SPAWN_EGG = ITEMS.register("giraffe_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.GIRAFFE, 0xDAA86F, 0x744420, new Item.Properties()));
    public static final DeferredItem<Item> HIPPO_SPAWN_EGG = ITEMS.register("hippo_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.HIPPO, 0xEF9A9A, 0x896562, new Item.Properties()));
    public static final DeferredItem<Item> LION_SPAWN_EGG = ITEMS.register("lion_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.LION, 0xE4BD82, 0x663A11, new Item.Properties()));
    public static final DeferredItem<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.RHINO, 0x74605A, 0xA79289, new Item.Properties()));
    public static final DeferredItem<Item> LIZARD_SPAWN_EGG = ITEMS.register("lizard_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.LIZARD, 10853166, 15724462, new Item.Properties()));
    public static final DeferredItem<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SNAIL, 5457209, 8811878, new Item.Properties()));
    public static final DeferredItem<Item> TORTOISE_SPAWN_EGG = ITEMS.register("tortoise_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.TORTOISE, 15724462, 11765582, new Item.Properties()));
    public static final DeferredItem<Item> VULTURE_SPAWN_EGG = ITEMS.register("vulture_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.VULTURE, 4010022, 15325376, new Item.Properties()));
    public static final DeferredItem<Item> ZEBRA_SPAWN_EGG = ITEMS.register("zebra_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.ZEBRA, 15263457, 1710104, new Item.Properties()));
    public static final DeferredItem<Item> MOOSE_SPAWN_EGG = ITEMS.register("moose_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.MOOSE, 0x5C4033, 0x2E1D13, new Item.Properties()));
    public static final DeferredItem<Item> MAMMOTH_SPAWN_EGG = ITEMS.register("mammoth_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.MAMMOTH, 0x4B3621, 0x2A1B0E, new Item.Properties()));
    public static final DeferredItem<Item> MYCELIUM_MAMMOTH_SPAWN_EGG = ITEMS.register("mycelium_mammoth_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.MYCELIUM_MAMMOTH, 0x6E4E37, 0x93785D, new Item.Properties()));
    public static final DeferredItem<Item> FENNEC_FOX_SPAWN_EGG = ITEMS.register("fennec_fox_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.FENNEC_FOX, 0xD3A66B, 0xF7E3B6, new Item.Properties()));
    public static final DeferredItem<Item> CAPYBARA_SPAWN_EGG = ITEMS.register("capybara_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.CAPYBARA, 0x8B5A2B, 0x5C4033, new Item.Properties()));
    public static final DeferredItem<Item> HEDGEHOG_SPAWN_EGG = ITEMS.register("hedgehog_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.HEDGEHOG, 0x5C4033, 0xD2B48C, new Item.Properties()));
    public static final DeferredItem<Item> LARGE_JELLYFISH_SPAWN_EGG = ITEMS.register("large_jellyfish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.LARGE_JELLYFISH, 0xFFB6C1, 0xFF69B4, new Item.Properties()));
    public static final DeferredItem<Item> SEAHORSE_SPAWN_EGG = ITEMS.register("seahorse_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SEAHORSE, 0xFFD700, 0xFFA500, new Item.Properties()));
    public static final DeferredItem<Item> ETHEREAL_SHRIMP_SPAWN_EGG = ITEMS.register("ethereal_shrimp_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.ETHEREAL_SHRIMP, 0xFFC0CB, 0xFF69B4, new Item.Properties()));
    public static final DeferredItem<Item> STARFISH_SPAWN_EGG = ITEMS.register("starfish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.STARFISH, 0xFF4500, 0xFFFF00, new Item.Properties()));
    public static final DeferredItem<Item> SMALL_JELLYFISH_SPAWN_EGG = ITEMS.register("small_jellyfish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SMALL_JELLYFISH, 0x00FFFF, 0x0000FF, new Item.Properties()));
    public static final DeferredItem<Item> MEDIUM_JELLYFISH_SPAWN_EGG = ITEMS.register("medium_jellyfish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.MEDIUM_JELLYFISH, 0x800080, 0xFF00FF, new Item.Properties()));
    public static final DeferredItem<Item> LARGE_JELLYFISH_BUCKET = ITEMS.register("large_jellyfish_bucket", () -> new MobBucketItem(ModEntities.LARGE_JELLYFISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SMALL_JELLYFISH_BUCKET = ITEMS.register("small_jellyfish_bucket", () -> new MobBucketItem(ModEntities.SMALL_JELLYFISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MEDIUM_JELLYFISH_BUCKET = ITEMS.register("medium_jellyfish_bucket", () -> new MobBucketItem(ModEntities.MEDIUM_JELLYFISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SEAHORSE_BUCKET = ITEMS.register("seahorse_bucket", () -> new MobBucketItem(ModEntities.SEAHORSE.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ETHEREAL_SHRIMP_BUCKET = ITEMS.register("ethereal_shrimp_bucket", () -> new MobBucketItem(ModEntities.ETHEREAL_SHRIMP.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> KIWI_SPAWN_EGG = ITEMS.register("kiwi_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.KIWI, 0x8B4513, 0xD2B48C, new Item.Properties()));
    public static final DeferredItem<Item> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.PENGUIN, 0x2F4F4F, 0xFFFFFF, new Item.Properties()));
    public static final DeferredItem<Item> SEAL_SPAWN_EGG = ITEMS.register("seal_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SEAL, 0x708090, 0xC0C0C0, new Item.Properties()));
    public static final DeferredItem<Item> SEA_URCHIN_SPAWN_EGG = ITEMS.register("sea_urchin_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SEA_URCHIN, 0x4B0082, 0x000000, new Item.Properties()));
    public static final DeferredItem<Item> DRAGONFLY_SPAWN_EGG = ITEMS.register("dragonfly_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.DRAGONFLY, 0x08EECF, 0xD3FF96, new Item.Properties()));
    public static final DeferredItem<Item> DUMBO_OCTOPUS_SPAWN_EGG = ITEMS.register("dumbo_octopus_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.DUMBO_OCTOPUS, 0xFCDC4C, 0x162630, new Item.Properties()));
    public static final DeferredItem<Item> FERRET_SPAWN_EGG = ITEMS.register("ferret_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.FERRET, 0xC5AC88, 0x37212D, new Item.Properties()));
    public static final DeferredItem<Item> JUMPING_SPIDER_SPAWN_EGG = ITEMS.register("jumping_spider_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.JUMPING_SPIDER, 0x34191E, 0x865F33, new Item.Properties()));
    public static final DeferredItem<Item> KOI_FISH_SPAWN_EGG = ITEMS.register("koi_fish_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.KOI_FISH, 0xF3ECED, 0xFB5321, new Item.Properties()));
    public static final DeferredItem<Item> OTTER_SPAWN_EGG = ITEMS.register("otter_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.OTTER, 0x352C34, 0xB49494, new Item.Properties()));
    public static final DeferredItem<Item> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.RED_PANDA, 0xF4943C, 0x13131B, new Item.Properties()));
    public static final DeferredItem<Item> SEA_BUNNY_SPAWN_EGG = ITEMS.register("sea_bunny_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.SEA_BUNNY, 0xF4ECE4, 0x453337, new Item.Properties()));
    public static final DeferredItem<Item> BUG_NET = ITEMS.register("bug_net", () -> new BugNetItem(new Item.Properties().durability(64)));
    public static final DeferredItem<Item> CATERPILLAR = ITEMS.register("caterpillar", () -> new CaughtMobItem(ModEntities.CATERPILLAR, () -> net.minecraft.world.level.material.Fluids.EMPTY, () -> net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));

    public static final Map<Butterfly.Variant, DeferredItem<Item>> BUTTERFLIES = new HashMap<>();

    static {
        for (Butterfly.Variant variant : Butterfly.Variant.values()) {
            BUTTERFLIES.put(variant, ITEMS.register("butterfly_" + variant.getName(), () -> new ButterflyItem(variant, new Item.Properties().stacksTo(1))));
        }
    }

    public static final DeferredItem<Item> ALLIGATOR_EGG = ITEMS.register("alligator_egg", () -> new BlockItem(ModBlocks.ALLIGATOR_EGG.get(), new Item.Properties()));
    public static final DeferredItem<Item> DUCK_EGG = ITEMS.register("duck_egg", () -> new DuckEggItem(new Item.Properties()));
    public static final DeferredItem<Item> TORTOISE_EGG = ITEMS.register("tortoise_egg", () -> new BlockItem(ModBlocks.TORTOISE_EGG.get(), new Item.Properties()));
    public static final DeferredItem<Item> SNAIL_EGG = ITEMS.register("snail_egg", () -> new BlockItem(ModBlocks.SNAIL_EGG.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> REFINED_GLOWSTONE = registerBlockItem("refined_glowstone", ModBlocks.REFINED_GLOWSTONE);
    public static final DeferredItem<Item> GLOW_GOOP = ITEMS.register("glow_goop", () -> new GlowGoopItem(ModBlocks.GLOW_GOOP.get(), new Item.Properties()));
    public static final DeferredItem<Item> LIZARD_TAIL = ITEMS.register("lizard_tail", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_LIZARD_TAIL = ITEMS.register("cooked_lizard_tail", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> COOKED_EGG = ITEMS.register("cooked_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> SNAIL_SHELL = ITEMS.register("snail_shell", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SNAIL_BUCKET = ITEMS.register("snail_bucket", () -> new SnailBucketItem(ModEntities.SNAIL, () -> net.minecraft.world.level.material.Fluids.EMPTY, () -> net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> JELLYFISH_JELLY = ITEMS.register("jellyfish_jelly", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> SEA_URCHIN_CAVIAR = ITEMS.register("sea_urchin_caviar", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).build())));
    public static final DeferredItem<Item> KIWI_EGG = ITEMS.register("kiwi_egg", () -> new KiwiEggItem(new Item.Properties()));
    public static final DeferredItem<Item> PENGUIN_EGG = ITEMS.register("penguin_egg", () -> new PenguinEggItem(new Item.Properties()));
    public static final DeferredItem<Item> RAW_CICHLID = ITEMS.register("raw_cichlid", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_CICHLID = ITEMS.register("cooked_cichlid", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_BONNETHEAD = ITEMS.register("raw_bonnethead", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_BONNETHEAD = ITEMS.register("cooked_bonnethead", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_GUITARFISH = ITEMS.register("raw_guitarfish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_GUITARFISH = ITEMS.register("cooked_guitarfish", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_GOBLIN_SHARK = ITEMS.register("raw_goblin_shark", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_GOBLIN_SHARK = ITEMS.register("cooked_goblin_shark", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_SNAIL = ITEMS.register("raw_snail", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COOKED_SNAIL = ITEMS.register("cooked_snail", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_SHRIMP = ITEMS.register("raw_shrimp", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> STEAMED_SHRIMP = ITEMS.register("steamed_shrimp", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_WILD_BIRD_MEAT = ITEMS.register("raw_wild_bird_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> COOKED_WILD_BIRD_MEAT = ITEMS.register("cooked_wild_bird_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> RAW_WILD_GAME_MEAT = ITEMS.register("raw_wild_game_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> COOKED_WILD_GAME_MEAT = ITEMS.register("cooked_wild_game_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build())));
    public static final DeferredItem<Item> RAW_CRAB_MEAT = ITEMS.register("raw_crab_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> STEAMED_CRAB_MEAT = ITEMS.register("steamed_crab_meat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredHolder<Item, BlockItem> CHRYSALIS = registerBlockItem("chrysalis", ModBlocks.CHRYSALIS);
    public static final DeferredItem<Item> CATFISH_BUCKET = ITEMS.register("catfish_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.CATFISH.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BASS_BUCKET = ITEMS.register("bass_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.BASS.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> DUMBO_OCTOPUS_BUCKET = ITEMS.register("dumbo_octopus_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.DUMBO_OCTOPUS.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> KOI_FISH_BUCKET = ITEMS.register("koi_fish_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.KOI_FISH.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SEA_BUNNY_BUCKET = ITEMS.register("sea_bunny_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.SEA_BUNNY.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CICHLID_BUCKET = ITEMS.register("cichlid_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.CICHLID.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GUITARFISH_BUCKET = ITEMS.register("guitarfish_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.GUITARFISH.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BONNETHEAD_SHARK_BUCKET = ITEMS.register("bonnethead_shark_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.BONNETHEAD_SHARK.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GOBLIN_SHARK_BUCKET = ITEMS.register("goblin_shark_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.GOBLIN_SHARK.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PSYCHO_JELLY_BUCKET = ITEMS.register("psycho_jelly_bucket", () -> new net.minecraft.world.item.MobBucketItem(ModEntities.PSYCHO_JELLY.get(), net.minecraft.world.level.material.Fluids.WATER, net.minecraft.sounds.SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));

    // --- Paxels ---
    public static final DeferredItem<PaxelItem> WOOD_PAXEL = ITEMS.register("wood_paxel", () -> new PaxelItem(Tiers.WOOD, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.WOOD, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> STONE_PAXEL = ITEMS.register("stone_paxel", () -> new PaxelItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> IRON_PAXEL = ITEMS.register("iron_paxel", () -> new PaxelItem(Tiers.IRON, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> GOLDEN_PAXEL = ITEMS.register("golden_paxel", () -> new PaxelItem(Tiers.GOLD, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> DIAMOND_PAXEL = ITEMS.register("diamond_paxel", () -> new PaxelItem(Tiers.DIAMOND, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> NETHERITE_PAXEL = ITEMS.register("netherite_paxel", () -> new PaxelItem(Tiers.NETHERITE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 2.0F, -2.8F)).fireResistant()));
    public static final DeferredItem<PaxelItem> COPPER_PAXEL = ITEMS.register("copper_paxel", () -> new PaxelItem(ModToolMaterials.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolMaterials.COPPER, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> EXPOSED_COPPER_PAXEL = ITEMS.register("exposed_copper_paxel", () -> new PaxelItem(ModToolMaterials.EXPOSED_COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolMaterials.EXPOSED_COPPER, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> WEATHERED_COPPER_PAXEL = ITEMS.register("weathered_copper_paxel", () -> new PaxelItem(ModToolMaterials.WEATHERED_COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolMaterials.WEATHERED_COPPER, 2.0F, -2.8F))));
    public static final DeferredItem<PaxelItem> OXIDIZED_COPPER_PAXEL = ITEMS.register("oxidized_copper_paxel", () -> new PaxelItem(ModToolMaterials.OXIDIZED_COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolMaterials.OXIDIZED_COPPER, 2.0F, -2.8F))));

    // --- Reinforced Obsidian Tools ---
    public static final DeferredItem<SwordItem> REINFORCED_OBSIDIAN_SWORD = ITEMS.register("reinforced_obsidian_sword", () -> new SwordItem(ModToolMaterials.REINFORCED_OBSIDIAN, new Item.Properties().attributes(SwordItem.createAttributes(ModToolMaterials.REINFORCED_OBSIDIAN, 3, -2.4F))));
    public static final DeferredItem<ShovelItem> REINFORCED_OBSIDIAN_SHOVEL = ITEMS.register("reinforced_obsidian_shovel", () -> new ShovelItem(ModToolMaterials.REINFORCED_OBSIDIAN, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolMaterials.REINFORCED_OBSIDIAN, 1.5F, -3.0F))));
    public static final DeferredItem<PickaxeItem> REINFORCED_OBSIDIAN_PICKAXE = ITEMS.register("reinforced_obsidian_pickaxe", () -> new PickaxeItem(ModToolMaterials.REINFORCED_OBSIDIAN, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolMaterials.REINFORCED_OBSIDIAN, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> REINFORCED_OBSIDIAN_AXE = ITEMS.register("reinforced_obsidian_axe", () -> new AxeItem(ModToolMaterials.REINFORCED_OBSIDIAN, new Item.Properties().attributes(AxeItem.createAttributes(ModToolMaterials.REINFORCED_OBSIDIAN, 6.0F, -3.1F))));
    public static final DeferredItem<HoeItem> REINFORCED_OBSIDIAN_HOE = ITEMS.register("reinforced_obsidian_hoe", () -> new HoeItem(ModToolMaterials.REINFORCED_OBSIDIAN, new Item.Properties().attributes(HoeItem.createAttributes(ModToolMaterials.REINFORCED_OBSIDIAN, -3.0F, 0.0F))));
    public static final DeferredItem<PaxelItem> REINFORCED_OBSIDIAN_PAXEL = ITEMS.register("reinforced_obsidian_paxel", () -> new PaxelItem(ModToolMaterials.REINFORCED_OBSIDIAN, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolMaterials.REINFORCED_OBSIDIAN, 2.0F, -2.8F))));

    public static DeferredItem<Item> PALE_OAK_SAPLING;

    // Backport / Minecraft Namespace ItemTags
    public static DeferredItem<Item> RESIN_BRICK;
    public static DeferredItem<Item> MUSIC_DISC_TEARS;
    public static DeferredItem<Item> MUSIC_DISC_LAVA_CHICKEN;
    public static DeferredItem<Item> CREAKING_SPAWN_EGG;
    public static DeferredItem<Item> HAPPY_GHAST_SPAWN_EGG;
    public static DeferredItem<Item> BLUE_EGG;
    public static DeferredItem<Item> BROWN_EGG;

    public static DeferredItem<Item> COPPER_NUGGET;
    public static DeferredItem<SwordItem> COPPER_SWORD;
    public static DeferredItem<ShovelItem> COPPER_SHOVEL;
    public static DeferredItem<PickaxeItem> COPPER_PICKAXE;
    public static DeferredItem<AxeItem> COPPER_AXE;
    public static DeferredItem<HoeItem> COPPER_HOE;
    public static DeferredItem<ShearsItem> COPPER_SHEARS;

    public static DeferredItem<SwordItem> EXPOSED_COPPER_SWORD;
    public static DeferredItem<ShovelItem> EXPOSED_COPPER_SHOVEL;
    public static DeferredItem<PickaxeItem> EXPOSED_COPPER_PICKAXE;
    public static DeferredItem<AxeItem> EXPOSED_COPPER_AXE;
    public static DeferredItem<HoeItem> EXPOSED_COPPER_HOE;
    public static DeferredItem<ShearsItem> EXPOSED_COPPER_SHEARS;

    public static DeferredItem<SwordItem> WEATHERED_COPPER_SWORD;
    public static DeferredItem<ShovelItem> WEATHERED_COPPER_SHOVEL;
    public static DeferredItem<PickaxeItem> WEATHERED_COPPER_PICKAXE;
    public static DeferredItem<AxeItem> WEATHERED_COPPER_AXE;
    public static DeferredItem<HoeItem> WEATHERED_COPPER_HOE;
    public static DeferredItem<ShearsItem> WEATHERED_COPPER_SHEARS;

    public static DeferredItem<SwordItem> OXIDIZED_COPPER_SWORD;
    public static DeferredItem<ShovelItem> OXIDIZED_COPPER_SHOVEL;
    public static DeferredItem<PickaxeItem> OXIDIZED_COPPER_PICKAXE;
    public static DeferredItem<AxeItem> OXIDIZED_COPPER_AXE;
    public static DeferredItem<HoeItem> OXIDIZED_COPPER_HOE;
    public static DeferredItem<ShearsItem> OXIDIZED_COPPER_SHEARS;

    // --- Mounts of Mayhem: Spears ---
    public static DeferredItem<SpearItem> WOODEN_SPEAR;
    public static DeferredItem<SpearItem> STONE_SPEAR;
    public static DeferredItem<SpearItem> IRON_SPEAR;
    public static DeferredItem<SpearItem> GOLDEN_SPEAR;
    public static DeferredItem<SpearItem> DIAMOND_SPEAR;
    public static DeferredItem<SpearItem> NETHERITE_SPEAR;
    public static DeferredItem<SpearItem> COPPER_SPEAR;

    public static DeferredItem<ArmorItem> COPPER_HELMET;
    public static DeferredItem<ArmorItem> COPPER_CHESTPLATE;
    public static DeferredItem<ArmorItem> COPPER_LEGGINGS;
    public static DeferredItem<ArmorItem> COPPER_BOOTS;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_HELMET;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_CHESTPLATE;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_LEGGINGS;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_BOOTS;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_HELMET;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_CHESTPLATE;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_LEGGINGS;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_BOOTS;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_HELMET;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_CHESTPLATE;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_LEGGINGS;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_BOOTS;

    public static DeferredItem<ArmorItem> COPPER_CHAINMAIL_HELMET;
    public static DeferredItem<ArmorItem> COPPER_CHAINMAIL_CHESTPLATE;
    public static DeferredItem<ArmorItem> COPPER_CHAINMAIL_LEGGINGS;
    public static DeferredItem<ArmorItem> COPPER_CHAINMAIL_BOOTS;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_CHAINMAIL_HELMET;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_CHAINMAIL_CHESTPLATE;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_CHAINMAIL_LEGGINGS;
    public static DeferredItem<ArmorItem> EXPOSED_COPPER_CHAINMAIL_BOOTS;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_CHAINMAIL_HELMET;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_CHAINMAIL_CHESTPLATE;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_CHAINMAIL_LEGGINGS;
    public static DeferredItem<ArmorItem> WEATHERED_COPPER_CHAINMAIL_BOOTS;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_CHAINMAIL_HELMET;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_CHAINMAIL_CHESTPLATE;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_CHAINMAIL_LEGGINGS;
    public static DeferredItem<ArmorItem> OXIDIZED_COPPER_CHAINMAIL_BOOTS;

    public static DeferredItem<AnimalArmorItem> COPPER_HORSE_ARMOR;
    public static DeferredItem<AnimalArmorItem> EXPOSED_COPPER_HORSE_ARMOR;
    public static DeferredItem<AnimalArmorItem> WEATHERED_COPPER_HORSE_ARMOR;
    public static DeferredItem<AnimalArmorItem> OXIDIZED_COPPER_HORSE_ARMOR;
    public static DeferredItem<Item> COPPER_GOLEM_SPAWN_EGG;

    public static DeferredItem<CopperBucketItem> COPPER_BUCKET;
    public static DeferredItem<CopperBucketItem> COPPER_WATER_BUCKET;
    public static DeferredItem<CopperBucketItem> COPPER_LAVA_BUCKET;
    public static DeferredItem<CopperMilkBucketItem> COPPER_MILK_BUCKET;
    public static DeferredItem<CopperSolidBucketItem> COPPER_POWDER_SNOW_BUCKET;

    public static DeferredItem<AnimalArmorItem> NETHERITE_HORSE_ARMOR;

    // --- Mounts of Mayhem: Nautilus Armor ---
    public static DeferredItem<AnimalArmorItem> COPPER_NAUTILUS_ARMOR;
    public static DeferredItem<AnimalArmorItem> IRON_NAUTILUS_ARMOR;
    public static DeferredItem<AnimalArmorItem> GOLDEN_NAUTILUS_ARMOR;
    public static DeferredItem<AnimalArmorItem> DIAMOND_NAUTILUS_ARMOR;
    public static DeferredItem<AnimalArmorItem> NETHERITE_NAUTILUS_ARMOR;

    public static DeferredItem<SignItem> PALE_OAK_SIGN;
    public static DeferredItem<HangingSignItem> PALE_OAK_HANGING_SIGN;
    public static DeferredItem<PaleOakBoatItem> PALE_OAK_BOAT;
    public static DeferredItem<PaleOakBoatItem> PALE_OAK_CHEST_BOAT;

    public static final DeferredItem<BlockItem> GLASS_JAR = ITEMS.register("glass_jar", () -> new FireflyJarItem(ModBlocks.GLASS_JAR.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> FIREFLY_IN_A_JAR = ITEMS.register("firefly_in_a_jar", () -> new FireflyJarItem(ModBlocks.FIREFLY_IN_A_JAR.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> FIREFLIES_IN_A_JAR = ITEMS.register("fireflies_in_a_jar", () -> new FireflyJarItem(ModBlocks.FIREFLIES_IN_A_JAR.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> FIREFLY_JAR = ITEMS.register("firefly_jar", () -> new FireflyJarItem(ModBlocks.FIREFLY_JAR.get(), new Item.Properties()));

    public static final Map<Butterfly.Variant, DeferredItem<Item>> BUTTERFLY_JAR_ITEMS = new HashMap<>();
    public static final DeferredHolder<Item, com.otterly76.ott.item.custom.CaterpillarJarItem> CATERPILLAR_JAR = ITEMS.register("caterpillar_jar", () -> new com.otterly76.ott.item.custom.CaterpillarJarItem(ModBlocks.CATERPILLAR_JAR.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SMALL_FIREFLY_SPAWN_EGG = ITEMS.register("small_firefly_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SMALL_FIREFLY, 0x1E1E1E, 0xFFFF00, new Item.Properties()));
    public static final DeferredItem<Item> GHOST_SPAWN_EGG = ITEMS.register("ghost_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GHOST, 0xFFE0E0E0, 0xFFB0B0B0, new Item.Properties()));
    public static final DeferredItem<Item> SPECTRE_SPAWN_EGG = ITEMS.register("spectre_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SPECTRE, 0xFF404040, 0xFF800080, new Item.Properties()));
    public static final DeferredItem<Item> HAUNT_SPAWN_EGG = ITEMS.register("haunt_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.HAUNT, 0xFFD0A0A0, 0xFF808080, new Item.Properties()));
    public static final DeferredItem<Item> GEIST_SPAWN_EGG = ITEMS.register("geist_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GEIST, 0xFF408080, 0xFFC0C0C0, new Item.Properties()));
    public static final DeferredItem<Item> TREE_ENT_SPAWN_EGG = ITEMS.register("tree_ent_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.TREE_ENT, 0x4B3621, 0x2A1B0E, new Item.Properties()));
    public static final DeferredItem<Item> HERMIT_KING_SPAWN_EGG = ITEMS.register("hermit_king_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.HERMIT_KING, 0x8B4513, 0xD2B48C, new Item.Properties()));
    public static final DeferredItem<Item> SEA_VIPER_SPAWN_EGG = ITEMS.register("sea_viper_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SEA_VIPER, 0x008B8B, 0x20B2AA, new Item.Properties()));
    public static final DeferredItem<Item> YETI_SPAWN_EGG = ITEMS.register("yeti_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.YETI, 0xFFFFFF, 0xE0E0E0, new Item.Properties()));
    public static final DeferredItem<Item> VILE_GATOR_SPAWN_EGG = ITEMS.register("vile_gator_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.VILE_GATOR, 0x5E5D24, 0xD2B961, new Item.Properties()));
    public static final DeferredItem<Item> PHOENIX_SPAWN_EGG = ITEMS.register("phoenix_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.PHOENIX, 0xFF4500, 0xFFFF00, new Item.Properties()));
    public static final DeferredItem<Item> BABY_PHOENIX_SPAWN_EGG = ITEMS.register("baby_phoenix_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BABY_PHOENIX, 0xFF4500, 0xFFFF00, new Item.Properties()));
    public static final DeferredItem<Item> BONE_STALKER_SPAWN_EGG = ITEMS.register("bone_stalker_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BONE_STALKER, 0xC0C0C0, 0x808080, new Item.Properties()));
    public static final DeferredItem<Item> SHADOW_SPAWN_EGG = ITEMS.register("shadow_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SHADOW, 0x1D1D1D, 0x3D3D3D, new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_TREE_ENT_SPAWN_EGG = ITEMS.register("cherry_tree_ent_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CHERRY_TREE_ENT, 0xFFB6C1, 0xFF69B4, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_HERMIT_KING_SPAWN_EGG = ITEMS.register("golden_hermit_king_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GOLDEN_HERMIT_KING, 0xFFD700, 0xFFA500, new Item.Properties()));
    public static final DeferredItem<Item> CORAL_SEA_VIPER_SPAWN_EGG = ITEMS.register("coral_sea_viper_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CORAL_SEA_VIPER, 0xFF7F50, 0xFF6347, new Item.Properties()));
    public static final DeferredItem<Item> ARID_YETI_SPAWN_EGG = ITEMS.register("arid_yeti_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ARID_YETI, 0xD2B48C, 0xA0522D, new Item.Properties()));
    public static final DeferredItem<Item> WIND_PHOENIX_SPAWN_EGG = ITEMS.register("wind_phoenix_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WIND_PHOENIX, 0xADD8E6, 0x87CEEB, new Item.Properties()));
    public static final DeferredItem<Item> BABY_WIND_PHOENIX_SPAWN_EGG = ITEMS.register("baby_wind_phoenix_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BABY_WIND_PHOENIX, 0xADD8E6, 0x87CEEB, new Item.Properties()));
    public static final DeferredItem<Item> BOGGED_BONE_STALKER_SPAWN_EGG = ITEMS.register("bogged_bone_stalker_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BOGGED_BONE_STALKER, 0x556B2F, 0x8B4513, new Item.Properties()));
    public static final DeferredItem<Item> BOGGED_SHADOW_SPAWN_EGG = ITEMS.register("bogged_shadow_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BOGGED_SHADOW, 0x228B22, 0x006400, new Item.Properties()));
    public static final DeferredItem<Item> GILDED_TREE_ENT_SPAWN_EGG = ITEMS.register("gilded_tree_ent_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GILDED_TREE_ENT, 0xFFD700, 0xDAA520, new Item.Properties()));
    public static final DeferredItem<Item> BEAVER_SPAWN_EGG = ITEMS.register("beaver_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BEAVER, -11324642, -2528223, new Item.Properties()));
    public static final DeferredItem<Item> CHUPACABRA_SPAWN_EGG = ITEMS.register("chupacabra_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CHUPACABRA, -11905738, -5775593, new Item.Properties()));
    public static final DeferredItem<Item> COUGAR_SPAWN_EGG = ITEMS.register("cougar_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.COUGAR, -5210796, -13295334, new Item.Properties()));
    public static final DeferredItem<Item> COYOTE_SPAWN_EGG = ITEMS.register("coyote_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.COYOTE, -7050677, -3228249, new Item.Properties()));
    public static final DeferredItem<Item> HOWLER_SPAWN_EGG = ITEMS.register("howler_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.HOWLER, -11844542, -2077120, new Item.Properties()));
    public static final DeferredItem<Item> MARMOT_SPAWN_EGG = ITEMS.register("marmot_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.MARMOT, -9347768, -13162975, new Item.Properties()));
    public static final DeferredItem<Item> MOUSE_SPAWN_EGG = ITEMS.register("mouse_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.MOUSE, -7312041, -4345946, new Item.Properties()));
    public static final DeferredItem<Item> PIT_VIPER_SPAWN_EGG = ITEMS.register("pit_viper_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.PIT_VIPER, -1, -1, new Item.Properties()));
    public static final DeferredItem<Item> RATTLESNAKE_SPAWN_EGG = ITEMS.register("rattlesnake_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.RATTLESNAKE, -1, -1, new Item.Properties()));
    public static final DeferredItem<Item> RINGTAIL_SPAWN_EGG = ITEMS.register("ringtail_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.RINGTAIL, -7570582, -2899793, new Item.Properties()));
    public static final DeferredItem<Item> SASQUATCH_SPAWN_EGG = ITEMS.register("sasquatch_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SASQUATCH, -13489885, -9872300, new Item.Properties()));
    public static final DeferredItem<Item> SKINWALKER_SPAWN_EGG = ITEMS.register("skinwalker_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.BEWITCHED_TIMBER_WOLF, -10397613, -8696780, new Item.Properties()));
    public static final DeferredItem<Item> SNAKE_SPAWN_EGG = ITEMS.register("snake_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SNAKE, -1, -1, new Item.Properties()));
    public static final DeferredItem<Item> SQUONK_SPAWN_EGG = ITEMS.register("squonk_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SQUONK, -5663100, -6393507, new Item.Properties()));
    public static final DeferredItem<Item> TURKEY_SPAWN_EGG = ITEMS.register("turkey_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.TURKEY, -14144467, -7132129, new Item.Properties()));
    public static final DeferredItem<Item> WECHUGE_SPAWN_EGG = ITEMS.register("wechuge_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WECHUGE, -6902101, -12107459, new Item.Properties()));
    public static final DeferredItem<Item> WENDIGO_SPAWN_EGG = ITEMS.register("wendigo_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WENDIGO, -8421505, -8696780, new Item.Properties()));
    public static final DeferredItem<Item> WOLVERINE_SPAWN_EGG = ITEMS.register("wolverine_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WOLVERINE, -14280173, -5206418, new Item.Properties()));
    // --- Mounts of Mayhem ---
    public static final DeferredItem<Item> NAUTILUS_SPAWN_EGG = ITEMS.register("nautilus_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.NAUTILUS, 0xF5E6C8, 0xD4400A, new Item.Properties()));
    public static final DeferredItem<Item> ZOMBIE_NAUTILUS_SPAWN_EGG = ITEMS.register("zombie_nautilus_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ZOMBIE_NAUTILUS, 0x4B7A54, 0x8A2E2E, new Item.Properties()));
    public static final DeferredItem<Item> PARCHED_SPAWN_EGG = ITEMS.register("parched_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.PARCHED, 0xC8A040, 0x6B3A10, new Item.Properties()));
    public static final DeferredItem<Item> CAMEL_HUSK_SPAWN_EGG = ITEMS.register("camel_husk_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CAMEL_HUSK, 0xC09F6D, 0x4B4B3A, new Item.Properties()));
    public static final DeferredItem<Item> FIDDLER_CRAB_SPAWN_EGG = ITEMS.register("fiddler_crab_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.FIDDLER_CRAB, 0x333077, 0xFE984B, new Item.Properties()));
    public static final DeferredItem<Item> GLARE_SPAWN_EGG = ITEMS.register("glare_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GLARE, 0x70922D, 0x6A5227, new Item.Properties()));
    public static final DeferredItem<Item> ICEOLOGER_SPAWN_EGG = ITEMS.register("iceologer_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ICEOLOGER, 0x173873, 0x949B9B, new Item.Properties()));
    public static final DeferredItem<Item> ILLUSIONER_SPAWN_EGG = ITEMS.register("illusioner_spawn_egg", () -> new DeferredSpawnEggItem(() -> net.minecraft.world.entity.EntityType.ILLUSIONER, 0x603E5C, 0x888E8E, new Item.Properties()));
    public static final DeferredItem<Item> MAULER_SPAWN_EGG = ITEMS.register("mauler_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.MAULER, 0x534F25, 0x817B39, new Item.Properties()));
    public static final DeferredItem<Item> RASCAL_SPAWN_EGG = ITEMS.register("rascal_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.RASCAL, 0x05736A, 0x8A521C, new Item.Properties()));
    public static final DeferredItem<Item> TUFF_GOLEM_SPAWN_EGG = ITEMS.register("tuff_golem_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.TUFF_GOLEM, 0xA0A297, 0x5D5D52, new Item.Properties()));
    public static final DeferredItem<Item> WILDFIRE_SPAWN_EGG = ITEMS.register("wildfire_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WILDFIRE, 0x6C3100, 0xFFD528, new Item.Properties()));
    public static final DeferredItem<BlockItem> COCONUT = ITEMS.register("coconut", () -> new BlockItem(ModBlocks.COCONUT.get(), new Item.Properties()));
    public static final DeferredItem<Item> COCONUT_CRAB_SPAWN_EGG = ITEMS.register("coconut_crab_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.COCONUT_CRAB, 0xEEC97C, 0x8B4513, new Item.Properties()));
    public static final DeferredItem<Item> SAND_CRAB_SPAWN_EGG = ITEMS.register("sand_crab_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SAND_CRAB, 0xD2B48C, 0xA0522D, new Item.Properties()));
    public static final DeferredItem<Item> CRAB_CLAW = ITEMS.register("crab_claw", () -> new Item(new Item.Properties()));
    public static final DeferredItem<BlockItem> CRAB_EGG = ITEMS.register("crab_egg", () -> new BlockItem(ModBlocks.CRAB_EGG.get(), new Item.Properties()));

    // ── Batch CTM blocks ─────────────────────────────────────────────────────
    // ── Acacia Planks ──
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_PANEL =
        registerBlockItem("acacia_planks_panel", ModBlocks.ACACIA_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_ACACIA_PLANKS =
        registerBlockItem("cornered_acacia_planks", ModBlocks.CORNERED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_ACACIA_PLANKS =
        registerBlockItem("crated_acacia_planks", ModBlocks.CRATED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_ACACIA_PLANKS =
        registerBlockItem("enclosed_acacia_planks", ModBlocks.ENCLOSED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_ACACIA_PLANKS =
        registerBlockItem("framed_acacia_planks", ModBlocks.FRAMED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_ACACIA_PLANKS =
        registerBlockItem("natural_acacia_planks", ModBlocks.NATURAL_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_ACACIA_PLANKS =
        registerBlockItem("pegged_acacia_planks", ModBlocks.PEGGED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_ACACIA_PLANKS =
        registerBlockItem("whirlwind_acacia_planks", ModBlocks.WHIRLWIND_ACACIA_PLANKS);

    // ── Amethyst Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_AMETHYST_BLOCK =
        registerBlockItem("bordered_amethyst_block", ModBlocks.BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_AMETHYST_BLOCK =
        registerBlockItem("brick_bordered_amethyst_block", ModBlocks.BRICK_BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_AMETHYST_BLOCK_PILLAR =
        registerBlockItem("curly_amethyst_block_pillar", ModBlocks.CURLY_AMETHYST_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_AMETHYST_BLOCK_COLUMN =
        registerBlockItem("cut_amethyst_block_column", ModBlocks.CUT_AMETHYST_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_AMETHYST_BLOCK_BRICKS =
        registerBlockItem("edged_amethyst_block_bricks", ModBlocks.EDGED_AMETHYST_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_AMETHYST_BLOCK_PILLAR =
        registerBlockItem("fine_amethyst_block_pillar", ModBlocks.FINE_AMETHYST_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_AMETHYST_BLOCK_BRICKS =
        registerBlockItem("massive_amethyst_block_bricks", ModBlocks.MASSIVE_AMETHYST_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_AMETHYST_BLOCK_PILLAR =
        registerBlockItem("ornate_amethyst_block_pillar", ModBlocks.ORNATE_AMETHYST_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_AMETHYST_BLOCK_TILES =
        registerBlockItem("overlapping_amethyst_block_tiles", ModBlocks.OVERLAPPING_AMETHYST_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_AMETHYST_BLOCK =
        registerBlockItem("polished_amethyst_block", ModBlocks.POLISHED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_AMETHYST_BLOCK_PILLAR =
        registerBlockItem("simple_amethyst_block_pillar", ModBlocks.SIMPLE_AMETHYST_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_AMETHYST_BLOCK_COLUMN =
        registerBlockItem("smooth_amethyst_block_column", ModBlocks.SMOOTH_AMETHYST_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_AMETHYST_BLOCK =
        registerBlockItem("thick_inlayed_amethyst_block", ModBlocks.THICK_INLAYED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_AMETHYST_BLOCK_COLUMN =
        registerBlockItem("tiled_amethyst_block_column", ModBlocks.TILED_AMETHYST_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_AMETHYST_BLOCK =
        registerBlockItem("tiled_bordered_amethyst_block", ModBlocks.TILED_BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_AMETHYST_BLOCK =
        registerBlockItem("tiny_brick_bordered_amethyst_block", ModBlocks.TINY_BRICK_BORDERED_AMETHYST_BLOCK);

    // ── Ancient Debris ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("bordered_ancient_debris", ModBlocks.BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("brick_bordered_ancient_debris", ModBlocks.BRICK_BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> CURLY_ANCIENT_DEBRIS_PILLAR =
        registerBlockItem("curly_ancient_debris_pillar", ModBlocks.CURLY_ANCIENT_DEBRIS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_ANCIENT_DEBRIS_COLUMN =
        registerBlockItem("cut_ancient_debris_column", ModBlocks.CUT_ANCIENT_DEBRIS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_ANCIENT_DEBRIS_BRICKS =
        registerBlockItem("edged_ancient_debris_bricks", ModBlocks.EDGED_ANCIENT_DEBRIS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_ANCIENT_DEBRIS_PILLAR =
        registerBlockItem("fine_ancient_debris_pillar", ModBlocks.FINE_ANCIENT_DEBRIS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_ANCIENT_DEBRIS_BRICKS =
        registerBlockItem("massive_ancient_debris_bricks", ModBlocks.MASSIVE_ANCIENT_DEBRIS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ANCIENT_DEBRIS_PILLAR =
        registerBlockItem("ornate_ancient_debris_pillar", ModBlocks.ORNATE_ANCIENT_DEBRIS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_ANCIENT_DEBRIS_TILES =
        registerBlockItem("overlapping_ancient_debris_tiles", ModBlocks.OVERLAPPING_ANCIENT_DEBRIS_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANCIENT_DEBRIS =
        registerBlockItem("polished_ancient_debris", ModBlocks.POLISHED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_ANCIENT_DEBRIS_PILLAR =
        registerBlockItem("simple_ancient_debris_pillar", ModBlocks.SIMPLE_ANCIENT_DEBRIS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ANCIENT_DEBRIS_COLUMN =
        registerBlockItem("smooth_ancient_debris_column", ModBlocks.SMOOTH_ANCIENT_DEBRIS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_ANCIENT_DEBRIS =
        registerBlockItem("thick_inlayed_ancient_debris", ModBlocks.THICK_INLAYED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> TILED_ANCIENT_DEBRIS_COLUMN =
        registerBlockItem("tiled_ancient_debris_column", ModBlocks.TILED_ANCIENT_DEBRIS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("tiled_bordered_ancient_debris", ModBlocks.TILED_BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("tiny_brick_bordered_ancient_debris", ModBlocks.TINY_BRICK_BORDERED_ANCIENT_DEBRIS);

    // ── Andesite ──
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_ANDESITE =
        registerBlockItem("brick_bordered_andesite", ModBlocks.BRICK_BORDERED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> CURLY_ANDESITE_PILLAR =
        registerBlockItem("curly_andesite_pillar", ModBlocks.CURLY_ANDESITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_ANDESITE_COLUMN =
        registerBlockItem("cut_andesite_column", ModBlocks.CUT_ANDESITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_ANDESITE_BRICKS =
        registerBlockItem("edged_andesite_bricks", ModBlocks.EDGED_ANDESITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_ANDESITE_PILLAR =
        registerBlockItem("fine_andesite_pillar", ModBlocks.FINE_ANDESITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_ANDESITE_BRICKS =
        registerBlockItem("massive_andesite_bricks", ModBlocks.MASSIVE_ANDESITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ANDESITE_PILLAR =
        registerBlockItem("ornate_andesite_pillar", ModBlocks.ORNATE_ANDESITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_ANDESITE_TILES =
        registerBlockItem("overlapping_andesite_tiles", ModBlocks.OVERLAPPING_ANDESITE_TILES);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_ANDESITE_PILLAR =
        registerBlockItem("simple_andesite_pillar", ModBlocks.SIMPLE_ANDESITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ANDESITE_COLUMN =
        registerBlockItem("smooth_andesite_column", ModBlocks.SMOOTH_ANDESITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_ANDESITE =
        registerBlockItem("thick_inlayed_andesite", ModBlocks.THICK_INLAYED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> TILED_ANDESITE_COLUMN =
        registerBlockItem("tiled_andesite_column", ModBlocks.TILED_ANDESITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_ANDESITE =
        registerBlockItem("tiled_bordered_andesite", ModBlocks.TILED_BORDERED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_ANDESITE =
        registerBlockItem("tiny_brick_bordered_andesite", ModBlocks.TINY_BRICK_BORDERED_ANDESITE);

    // ── Bamboo Planks ──
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_PANEL =
        registerBlockItem("bamboo_planks_panel", ModBlocks.BAMBOO_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BAMBOO_PLANKS =
        registerBlockItem("cornered_bamboo_planks", ModBlocks.CORNERED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_BAMBOO_PLANKS =
        registerBlockItem("crated_bamboo_planks", ModBlocks.CRATED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_BAMBOO_PLANKS =
        registerBlockItem("enclosed_bamboo_planks", ModBlocks.ENCLOSED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_BAMBOO_PLANKS =
        registerBlockItem("framed_bamboo_planks", ModBlocks.FRAMED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_BAMBOO_PLANKS =
        registerBlockItem("natural_bamboo_planks", ModBlocks.NATURAL_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BAMBOO_PLANKS =
        registerBlockItem("polished_bamboo_planks", ModBlocks.POLISHED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> TIED_BAMBOO_PLANKS =
        registerBlockItem("tied_bamboo_planks", ModBlocks.TIED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_BAMBOO_PLANKS =
        registerBlockItem("whirlwind_bamboo_planks", ModBlocks.WHIRLWIND_BAMBOO_PLANKS);

    // ── Basalt ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_BASALT =
        registerBlockItem("bordered_basalt", ModBlocks.BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BASALT =
        registerBlockItem("brick_bordered_basalt", ModBlocks.BRICK_BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> CURLY_BASALT_PILLAR =
        registerBlockItem("curly_basalt_pillar", ModBlocks.CURLY_BASALT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_BASALT_COLUMN =
        registerBlockItem("cut_basalt_column", ModBlocks.CUT_BASALT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_BASALT_BRICKS =
        registerBlockItem("edged_basalt_bricks", ModBlocks.EDGED_BASALT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_BASALT_PILLAR =
        registerBlockItem("fine_basalt_pillar", ModBlocks.FINE_BASALT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BASALT_BRICKS =
        registerBlockItem("massive_basalt_bricks", ModBlocks.MASSIVE_BASALT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BASALT_PILLAR =
        registerBlockItem("ornate_basalt_pillar", ModBlocks.ORNATE_BASALT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BASALT_TILES =
        registerBlockItem("overlapping_basalt_tiles", ModBlocks.OVERLAPPING_BASALT_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BASALT =
        registerBlockItem("polished_basalt", ModBlocks.POLISHED_BASALT);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BASALT_PILLAR =
        registerBlockItem("simple_basalt_pillar", ModBlocks.SIMPLE_BASALT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BASALT_COLUMN =
        registerBlockItem("smooth_basalt_column", ModBlocks.SMOOTH_BASALT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BASALT =
        registerBlockItem("thick_inlayed_basalt", ModBlocks.THICK_INLAYED_BASALT);
    public static final DeferredHolder<Item, BlockItem> TILED_BASALT_COLUMN =
        registerBlockItem("tiled_basalt_column", ModBlocks.TILED_BASALT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BASALT =
        registerBlockItem("tiled_bordered_basalt", ModBlocks.TILED_BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BASALT =
        registerBlockItem("tiny_brick_bordered_basalt", ModBlocks.TINY_BRICK_BORDERED_BASALT);

    // ── Birch Planks ──
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_PANEL =
        registerBlockItem("birch_planks_panel", ModBlocks.BIRCH_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BIRCH_PLANKS =
        registerBlockItem("cornered_birch_planks", ModBlocks.CORNERED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_BIRCH_PLANKS =
        registerBlockItem("crated_birch_planks", ModBlocks.CRATED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_BIRCH_PLANKS =
        registerBlockItem("enclosed_birch_planks", ModBlocks.ENCLOSED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_BIRCH_PLANKS =
        registerBlockItem("framed_birch_planks", ModBlocks.FRAMED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_BIRCH_PLANKS =
        registerBlockItem("natural_birch_planks", ModBlocks.NATURAL_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BIRCH_PLANKS =
        registerBlockItem("pegged_birch_planks", ModBlocks.PEGGED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BIRCH_PLANKS =
        registerBlockItem("polished_birch_planks", ModBlocks.POLISHED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_BIRCH_PLANKS =
        registerBlockItem("whirlwind_birch_planks", ModBlocks.WHIRLWIND_BIRCH_PLANKS);

    // ── Blackstone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_BLACKSTONE =
        registerBlockItem("bordered_blackstone", ModBlocks.BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BLACKSTONE =
        registerBlockItem("brick_bordered_blackstone", ModBlocks.BRICK_BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_BLACKSTONE_PILLAR =
        registerBlockItem("curly_blackstone_pillar", ModBlocks.CURLY_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_BLACKSTONE_COLUMN =
        registerBlockItem("cut_blackstone_column", ModBlocks.CUT_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_BLACKSTONE_BRICKS =
        registerBlockItem("edged_blackstone_bricks", ModBlocks.EDGED_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_BLACKSTONE_PILLAR =
        registerBlockItem("fine_blackstone_pillar", ModBlocks.FINE_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BLACKSTONE_BRICKS =
        registerBlockItem("massive_blackstone_bricks", ModBlocks.MASSIVE_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACKSTONE_PILLAR =
        registerBlockItem("ornate_blackstone_pillar", ModBlocks.ORNATE_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BLACKSTONE_TILES =
        registerBlockItem("overlapping_blackstone_tiles", ModBlocks.OVERLAPPING_BLACKSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BLACKSTONE_PILLAR =
        registerBlockItem("simple_blackstone_pillar", ModBlocks.SIMPLE_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLACKSTONE_COLUMN =
        registerBlockItem("smooth_blackstone_column", ModBlocks.SMOOTH_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BLACKSTONE =
        registerBlockItem("thick_inlayed_blackstone", ModBlocks.THICK_INLAYED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACKSTONE_COLUMN =
        registerBlockItem("tiled_blackstone_column", ModBlocks.TILED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BLACKSTONE =
        registerBlockItem("tiled_bordered_blackstone", ModBlocks.TILED_BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BLACKSTONE =
        registerBlockItem("tiny_brick_bordered_blackstone", ModBlocks.TINY_BRICK_BORDERED_BLACKSTONE);

    // ── Black Concrete ──
    public static final DeferredHolder<Item, BlockItem> BLACK_CONCRETE_PANEL =
        registerBlockItem("black_concrete_panel", ModBlocks.BLACK_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> BLACK_CONCRETE_PILLAR =
        registerBlockItem("black_concrete_pillar", ModBlocks.BLACK_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRILL_BLACK_CONCRETE =
        registerBlockItem("grill_black_concrete", ModBlocks.GRILL_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BLACK_CONCRETE =
        registerBlockItem("pegged_black_concrete", ModBlocks.PEGGED_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLACK_CONCRETE =
        registerBlockItem("smooth_black_concrete", ModBlocks.SMOOTH_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_BLACK_CONCRETE =
        registerBlockItem("striped_black_concrete", ModBlocks.STRIPED_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_BLACK_CONCRETE =
        registerBlockItem("wired_black_concrete", ModBlocks.WIRED_BLACK_CONCRETE);

    // ── Black Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_BLACK_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_black_stained_glass_pillar", ModBlocks.ARCHED_BLACK_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLACK_STAINED_GLASS =
        registerBlockItem("fancy_black_stained_glass", ModBlocks.FANCY_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACK_STAINED_GLASS =
        registerBlockItem("ornate_black_stained_glass", ModBlocks.ORNATE_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLACK_STAINED_GLASS =
        registerBlockItem("raster_black_stained_glass", ModBlocks.RASTER_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_STAINED_GLASS =
        registerBlockItem("small_black_stained_glass", ModBlocks.SMALL_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACK_STAINED_GLASS =
        registerBlockItem("tiled_black_stained_glass", ModBlocks.TILED_BLACK_STAINED_GLASS);

    // ── Black Terracotta ──
    public static final DeferredHolder<Item, BlockItem> BLACK_TERRACOTTA_COLUMN =
        registerBlockItem("black_terracotta_column", ModBlocks.BLACK_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> BLACK_TERRACOTTA_PILLAR =
        registerBlockItem("black_terracotta_pillar", ModBlocks.BLACK_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLACK_TERRACOTTA =
        registerBlockItem("circular_black_terracotta", ModBlocks.CIRCULAR_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_BLACK_TERRACOTTA =
        registerBlockItem("curled_black_terracotta", ModBlocks.CURLED_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_BLACK_TERRACOTTA =
        registerBlockItem("hexagonical_black_terracotta", ModBlocks.HEXAGONICAL_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_BLACK_TERRACOTTA =
        registerBlockItem("inscribed_black_terracotta", ModBlocks.INSCRIBED_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_TERRACOTTA_TILES =
        registerBlockItem("small_black_terracotta_tiles", ModBlocks.SMALL_BLACK_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_BLACK_TERRACOTTA =
        registerBlockItem("starry_black_terracotta", ModBlocks.STARRY_BLACK_TERRACOTTA);

    // ── Black Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_BLACK_WOOL =
        registerBlockItem("cornered_black_wool", ModBlocks.CORNERED_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_BLACK_WOOL =
        registerBlockItem("crafted_black_wool", ModBlocks.CRAFTED_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_BLACK_WOOL =
        registerBlockItem("harsh_quilted_black_wool", ModBlocks.HARSH_QUILTED_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_BLACK_WOOL =
        registerBlockItem("rectangle_black_wool", ModBlocks.RECTANGLE_BLACK_WOOL);

    // ── Blue Concrete ──
    public static final DeferredHolder<Item, BlockItem> BLUE_CONCRETE_PANEL =
        registerBlockItem("blue_concrete_panel", ModBlocks.BLUE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> BLUE_CONCRETE_PILLAR =
        registerBlockItem("blue_concrete_pillar", ModBlocks.BLUE_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRILL_BLUE_CONCRETE =
        registerBlockItem("grill_blue_concrete", ModBlocks.GRILL_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BLUE_CONCRETE =
        registerBlockItem("pegged_blue_concrete", ModBlocks.PEGGED_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLUE_CONCRETE =
        registerBlockItem("smooth_blue_concrete", ModBlocks.SMOOTH_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_BLUE_CONCRETE =
        registerBlockItem("striped_blue_concrete", ModBlocks.STRIPED_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_BLUE_CONCRETE =
        registerBlockItem("wired_blue_concrete", ModBlocks.WIRED_BLUE_CONCRETE);

    // ── Blue Ice ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_BLUE_ICE =
        registerBlockItem("bordered_blue_ice", ModBlocks.BORDERED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BLUE_ICE =
        registerBlockItem("brick_bordered_blue_ice", ModBlocks.BRICK_BORDERED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> CURLY_BLUE_ICE_PILLAR =
        registerBlockItem("curly_blue_ice_pillar", ModBlocks.CURLY_BLUE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_BLUE_ICE_COLUMN =
        registerBlockItem("cut_blue_ice_column", ModBlocks.CUT_BLUE_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_BLUE_ICE_BRICKS =
        registerBlockItem("edged_blue_ice_bricks", ModBlocks.EDGED_BLUE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_BLUE_ICE_PILLAR =
        registerBlockItem("fine_blue_ice_pillar", ModBlocks.FINE_BLUE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BLUE_ICE_BRICKS =
        registerBlockItem("massive_blue_ice_bricks", ModBlocks.MASSIVE_BLUE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_ICE_PILLAR =
        registerBlockItem("ornate_blue_ice_pillar", ModBlocks.ORNATE_BLUE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BLUE_ICE_TILES =
        registerBlockItem("overlapping_blue_ice_tiles", ModBlocks.OVERLAPPING_BLUE_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLUE_ICE =
        registerBlockItem("polished_blue_ice", ModBlocks.POLISHED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BLUE_ICE_PILLAR =
        registerBlockItem("simple_blue_ice_pillar", ModBlocks.SIMPLE_BLUE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLUE_ICE_COLUMN =
        registerBlockItem("smooth_blue_ice_column", ModBlocks.SMOOTH_BLUE_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BLUE_ICE =
        registerBlockItem("thick_inlayed_blue_ice", ModBlocks.THICK_INLAYED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_ICE_COLUMN =
        registerBlockItem("tiled_blue_ice_column", ModBlocks.TILED_BLUE_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BLUE_ICE =
        registerBlockItem("tiled_bordered_blue_ice", ModBlocks.TILED_BORDERED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BLUE_ICE =
        registerBlockItem("tiny_brick_bordered_blue_ice", ModBlocks.TINY_BRICK_BORDERED_BLUE_ICE);

    // ── Blue Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_BLUE_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_blue_stained_glass_pillar", ModBlocks.ARCHED_BLUE_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLUE_STAINED_GLASS =
        registerBlockItem("fancy_blue_stained_glass", ModBlocks.FANCY_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_STAINED_GLASS =
        registerBlockItem("ornate_blue_stained_glass", ModBlocks.ORNATE_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLUE_STAINED_GLASS =
        registerBlockItem("raster_blue_stained_glass", ModBlocks.RASTER_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_STAINED_GLASS =
        registerBlockItem("small_blue_stained_glass", ModBlocks.SMALL_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_STAINED_GLASS =
        registerBlockItem("tiled_blue_stained_glass", ModBlocks.TILED_BLUE_STAINED_GLASS);

    // ── Blue Terracotta ──
    public static final DeferredHolder<Item, BlockItem> BLUE_TERRACOTTA_COLUMN =
        registerBlockItem("blue_terracotta_column", ModBlocks.BLUE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> BLUE_TERRACOTTA_PILLAR =
        registerBlockItem("blue_terracotta_pillar", ModBlocks.BLUE_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLUE_TERRACOTTA =
        registerBlockItem("circular_blue_terracotta", ModBlocks.CIRCULAR_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_BLUE_TERRACOTTA =
        registerBlockItem("curled_blue_terracotta", ModBlocks.CURLED_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_BLUE_TERRACOTTA =
        registerBlockItem("hexagonical_blue_terracotta", ModBlocks.HEXAGONICAL_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_BLUE_TERRACOTTA =
        registerBlockItem("inscribed_blue_terracotta", ModBlocks.INSCRIBED_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_TERRACOTTA_TILES =
        registerBlockItem("small_blue_terracotta_tiles", ModBlocks.SMALL_BLUE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_BLUE_TERRACOTTA =
        registerBlockItem("starry_blue_terracotta", ModBlocks.STARRY_BLUE_TERRACOTTA);

    // ── Blue Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_BLUE_WOOL =
        registerBlockItem("cornered_blue_wool", ModBlocks.CORNERED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_BLUE_WOOL =
        registerBlockItem("crafted_blue_wool", ModBlocks.CRAFTED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_BLUE_WOOL =
        registerBlockItem("harsh_quilted_blue_wool", ModBlocks.HARSH_QUILTED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_BLUE_WOOL =
        registerBlockItem("rectangle_blue_wool", ModBlocks.RECTANGLE_BLUE_WOOL);

    // ── Borderless Bricks ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("bordered_borderless_bricks", ModBlocks.BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("brick_bordered_borderless_bricks", ModBlocks.BRICK_BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CURLY_BORDERLESS_BRICKS_PILLAR =
        registerBlockItem("curly_borderless_bricks_pillar", ModBlocks.CURLY_BORDERLESS_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_BORDERLESS_BRICKS_COLUMN =
        registerBlockItem("cut_borderless_bricks_column", ModBlocks.CUT_BORDERLESS_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_BORDERLESS_BRICKS_BRICKS =
        registerBlockItem("edged_borderless_bricks_bricks", ModBlocks.EDGED_BORDERLESS_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_BORDERLESS_BRICKS_PILLAR =
        registerBlockItem("fine_borderless_bricks_pillar", ModBlocks.FINE_BORDERLESS_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BORDERLESS_BRICKS_BRICKS =
        registerBlockItem("massive_borderless_bricks_bricks", ModBlocks.MASSIVE_BORDERLESS_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BORDERLESS_BRICKS_PILLAR =
        registerBlockItem("ornate_borderless_bricks_pillar", ModBlocks.ORNATE_BORDERLESS_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BORDERLESS_BRICKS_TILES =
        registerBlockItem("overlapping_borderless_bricks_tiles", ModBlocks.OVERLAPPING_BORDERLESS_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BORDERLESS_BRICKS =
        registerBlockItem("polished_borderless_bricks", ModBlocks.POLISHED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BORDERLESS_BRICKS_PILLAR =
        registerBlockItem("simple_borderless_bricks_pillar", ModBlocks.SIMPLE_BORDERLESS_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BORDERLESS_BRICKS_COLUMN =
        registerBlockItem("smooth_borderless_bricks_column", ModBlocks.SMOOTH_BORDERLESS_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BORDERLESS_BRICKS =
        registerBlockItem("thick_inlayed_borderless_bricks", ModBlocks.THICK_INLAYED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("tiled_bordered_borderless_bricks", ModBlocks.TILED_BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERLESS_BRICKS_COLUMN =
        registerBlockItem("tiled_borderless_bricks_column", ModBlocks.TILED_BORDERLESS_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("tiny_brick_bordered_borderless_bricks", ModBlocks.TINY_BRICK_BORDERED_BORDERLESS_BRICKS);

    // ── Bricks ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_BRICKS =
        registerBlockItem("bordered_bricks", ModBlocks.BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BRICKS =
        registerBlockItem("brick_bordered_bricks", ModBlocks.BRICK_BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CURLY_BRICKS_PILLAR =
        registerBlockItem("curly_bricks_pillar", ModBlocks.CURLY_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_BRICKS_COLUMN =
        registerBlockItem("cut_bricks_column", ModBlocks.CUT_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_BRICKS_BRICKS =
        registerBlockItem("edged_bricks_bricks", ModBlocks.EDGED_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_BRICKS_PILLAR =
        registerBlockItem("fine_bricks_pillar", ModBlocks.FINE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BRICKS_BRICKS =
        registerBlockItem("massive_bricks_bricks", ModBlocks.MASSIVE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BRICKS_PILLAR =
        registerBlockItem("ornate_bricks_pillar", ModBlocks.ORNATE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BRICKS_TILES =
        registerBlockItem("overlapping_bricks_tiles", ModBlocks.OVERLAPPING_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BRICKS =
        registerBlockItem("polished_bricks", ModBlocks.POLISHED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BRICKS_PILLAR =
        registerBlockItem("simple_bricks_pillar", ModBlocks.SIMPLE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BRICKS_COLUMN =
        registerBlockItem("smooth_bricks_column", ModBlocks.SMOOTH_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BRICKS =
        registerBlockItem("thick_inlayed_bricks", ModBlocks.THICK_INLAYED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BRICKS =
        registerBlockItem("tiled_bordered_bricks", ModBlocks.TILED_BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BRICKS_COLUMN =
        registerBlockItem("tiled_bricks_column", ModBlocks.TILED_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BRICKS =
        registerBlockItem("tiny_brick_bordered_bricks", ModBlocks.TINY_BRICK_BORDERED_BRICKS);

    // ── Brown Concrete ──
    public static final DeferredHolder<Item, BlockItem> BROWN_CONCRETE_PANEL =
        registerBlockItem("brown_concrete_panel", ModBlocks.BROWN_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> BROWN_CONCRETE_PILLAR =
        registerBlockItem("brown_concrete_pillar", ModBlocks.BROWN_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRILL_BROWN_CONCRETE =
        registerBlockItem("grill_brown_concrete", ModBlocks.GRILL_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BROWN_CONCRETE =
        registerBlockItem("pegged_brown_concrete", ModBlocks.PEGGED_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BROWN_CONCRETE =
        registerBlockItem("smooth_brown_concrete", ModBlocks.SMOOTH_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_BROWN_CONCRETE =
        registerBlockItem("striped_brown_concrete", ModBlocks.STRIPED_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_BROWN_CONCRETE =
        registerBlockItem("wired_brown_concrete", ModBlocks.WIRED_BROWN_CONCRETE);

    // ── Brown Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_BROWN_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_brown_stained_glass_pillar", ModBlocks.ARCHED_BROWN_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_BROWN_STAINED_GLASS =
        registerBlockItem("fancy_brown_stained_glass", ModBlocks.FANCY_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BROWN_STAINED_GLASS =
        registerBlockItem("ornate_brown_stained_glass", ModBlocks.ORNATE_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_BROWN_STAINED_GLASS =
        registerBlockItem("raster_brown_stained_glass", ModBlocks.RASTER_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_STAINED_GLASS =
        registerBlockItem("small_brown_stained_glass", ModBlocks.SMALL_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_BROWN_STAINED_GLASS =
        registerBlockItem("tiled_brown_stained_glass", ModBlocks.TILED_BROWN_STAINED_GLASS);

    // ── Brown Terracotta ──
    public static final DeferredHolder<Item, BlockItem> BROWN_TERRACOTTA_COLUMN =
        registerBlockItem("brown_terracotta_column", ModBlocks.BROWN_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> BROWN_TERRACOTTA_PILLAR =
        registerBlockItem("brown_terracotta_pillar", ModBlocks.BROWN_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BROWN_TERRACOTTA =
        registerBlockItem("circular_brown_terracotta", ModBlocks.CIRCULAR_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_BROWN_TERRACOTTA =
        registerBlockItem("curled_brown_terracotta", ModBlocks.CURLED_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_BROWN_TERRACOTTA =
        registerBlockItem("hexagonical_brown_terracotta", ModBlocks.HEXAGONICAL_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_BROWN_TERRACOTTA =
        registerBlockItem("inscribed_brown_terracotta", ModBlocks.INSCRIBED_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_TERRACOTTA_TILES =
        registerBlockItem("small_brown_terracotta_tiles", ModBlocks.SMALL_BROWN_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_BROWN_TERRACOTTA =
        registerBlockItem("starry_brown_terracotta", ModBlocks.STARRY_BROWN_TERRACOTTA);

    // ── Brown Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_BROWN_WOOL =
        registerBlockItem("cornered_brown_wool", ModBlocks.CORNERED_BROWN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_BROWN_WOOL =
        registerBlockItem("crafted_brown_wool", ModBlocks.CRAFTED_BROWN_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_BROWN_WOOL =
        registerBlockItem("harsh_quilted_brown_wool", ModBlocks.HARSH_QUILTED_BROWN_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_BROWN_WOOL =
        registerBlockItem("rectangle_brown_wool", ModBlocks.RECTANGLE_BROWN_WOOL);

    // ── Calcite ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_CALCITE =
        registerBlockItem("bordered_calcite", ModBlocks.BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_CALCITE =
        registerBlockItem("brick_bordered_calcite", ModBlocks.BRICK_BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> CURLY_CALCITE_PILLAR =
        registerBlockItem("curly_calcite_pillar", ModBlocks.CURLY_CALCITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_CALCITE_COLUMN =
        registerBlockItem("cut_calcite_column", ModBlocks.CUT_CALCITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_CALCITE_BRICKS =
        registerBlockItem("edged_calcite_bricks", ModBlocks.EDGED_CALCITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_CALCITE_PILLAR =
        registerBlockItem("fine_calcite_pillar", ModBlocks.FINE_CALCITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_CALCITE_BRICKS =
        registerBlockItem("massive_calcite_bricks", ModBlocks.MASSIVE_CALCITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CALCITE_PILLAR =
        registerBlockItem("ornate_calcite_pillar", ModBlocks.ORNATE_CALCITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_CALCITE_TILES =
        registerBlockItem("overlapping_calcite_tiles", ModBlocks.OVERLAPPING_CALCITE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_CALCITE =
        registerBlockItem("polished_calcite", ModBlocks.POLISHED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_CALCITE_PILLAR =
        registerBlockItem("simple_calcite_pillar", ModBlocks.SIMPLE_CALCITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CALCITE_COLUMN =
        registerBlockItem("smooth_calcite_column", ModBlocks.SMOOTH_CALCITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_CALCITE =
        registerBlockItem("thick_inlayed_calcite", ModBlocks.THICK_INLAYED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_CALCITE =
        registerBlockItem("tiled_bordered_calcite", ModBlocks.TILED_BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> TILED_CALCITE_COLUMN =
        registerBlockItem("tiled_calcite_column", ModBlocks.TILED_CALCITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_CALCITE =
        registerBlockItem("tiny_brick_bordered_calcite", ModBlocks.TINY_BRICK_BORDERED_CALCITE);

    // ── Cherry Planks ──
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_PANEL =
        registerBlockItem("cherry_planks_panel", ModBlocks.CHERRY_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_CHERRY_PLANKS =
        registerBlockItem("cornered_cherry_planks", ModBlocks.CORNERED_CHERRY_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_CHERRY_PLANKS =
        registerBlockItem("crated_cherry_planks", ModBlocks.CRATED_CHERRY_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_CHERRY_PLANKS =
        registerBlockItem("enclosed_cherry_planks", ModBlocks.ENCLOSED_CHERRY_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_CHERRY_PLANKS =
        registerBlockItem("framed_cherry_planks", ModBlocks.FRAMED_CHERRY_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_CHERRY_PLANKS =
        registerBlockItem("natural_cherry_planks", ModBlocks.NATURAL_CHERRY_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_CHERRY_PLANKS =
        registerBlockItem("pegged_cherry_planks", ModBlocks.PEGGED_CHERRY_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_CHERRY_PLANKS =
        registerBlockItem("whirlwind_cherry_planks", ModBlocks.WHIRLWIND_CHERRY_PLANKS);

    // ── Clay ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_CLAY =
        registerBlockItem("bordered_clay", ModBlocks.BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_CLAY =
        registerBlockItem("brick_bordered_clay", ModBlocks.BRICK_BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> CURLY_CLAY_PILLAR =
        registerBlockItem("curly_clay_pillar", ModBlocks.CURLY_CLAY_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_CLAY_COLUMN =
        registerBlockItem("cut_clay_column", ModBlocks.CUT_CLAY_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_CLAY_BRICKS =
        registerBlockItem("edged_clay_bricks", ModBlocks.EDGED_CLAY_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_CLAY_PILLAR =
        registerBlockItem("fine_clay_pillar", ModBlocks.FINE_CLAY_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_CLAY_BRICKS =
        registerBlockItem("massive_clay_bricks", ModBlocks.MASSIVE_CLAY_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CLAY_PILLAR =
        registerBlockItem("ornate_clay_pillar", ModBlocks.ORNATE_CLAY_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_CLAY_TILES =
        registerBlockItem("overlapping_clay_tiles", ModBlocks.OVERLAPPING_CLAY_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_CLAY =
        registerBlockItem("polished_clay", ModBlocks.POLISHED_CLAY);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_CLAY_PILLAR =
        registerBlockItem("simple_clay_pillar", ModBlocks.SIMPLE_CLAY_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CLAY_COLUMN =
        registerBlockItem("smooth_clay_column", ModBlocks.SMOOTH_CLAY_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_CLAY =
        registerBlockItem("thick_inlayed_clay", ModBlocks.THICK_INLAYED_CLAY);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_CLAY =
        registerBlockItem("tiled_bordered_clay", ModBlocks.TILED_BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> TILED_CLAY_COLUMN =
        registerBlockItem("tiled_clay_column", ModBlocks.TILED_CLAY_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_CLAY =
        registerBlockItem("tiny_brick_bordered_clay", ModBlocks.TINY_BRICK_BORDERED_CLAY);

    // ── Coal Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_COAL_BLOCK =
        registerBlockItem("bordered_coal_block", ModBlocks.BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_COAL_BLOCK =
        registerBlockItem("brick_bordered_coal_block", ModBlocks.BRICK_BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_COAL_BLOCK_PILLAR =
        registerBlockItem("curly_coal_block_pillar", ModBlocks.CURLY_COAL_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_COAL_BLOCK_COLUMN =
        registerBlockItem("cut_coal_block_column", ModBlocks.CUT_COAL_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_COAL_BLOCK_BRICKS =
        registerBlockItem("edged_coal_block_bricks", ModBlocks.EDGED_COAL_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_COAL_BLOCK_PILLAR =
        registerBlockItem("fine_coal_block_pillar", ModBlocks.FINE_COAL_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_COAL_BLOCK_BRICKS =
        registerBlockItem("massive_coal_block_bricks", ModBlocks.MASSIVE_COAL_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_COAL_BLOCK_PILLAR =
        registerBlockItem("ornate_coal_block_pillar", ModBlocks.ORNATE_COAL_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_COAL_BLOCK_TILES =
        registerBlockItem("overlapping_coal_block_tiles", ModBlocks.OVERLAPPING_COAL_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_COAL_BLOCK =
        registerBlockItem("polished_coal_block", ModBlocks.POLISHED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_COAL_BLOCK_PILLAR =
        registerBlockItem("simple_coal_block_pillar", ModBlocks.SIMPLE_COAL_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_COAL_BLOCK_COLUMN =
        registerBlockItem("smooth_coal_block_column", ModBlocks.SMOOTH_COAL_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_COAL_BLOCK =
        registerBlockItem("thick_inlayed_coal_block", ModBlocks.THICK_INLAYED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_COAL_BLOCK =
        registerBlockItem("tiled_bordered_coal_block", ModBlocks.TILED_BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_COAL_BLOCK_COLUMN =
        registerBlockItem("tiled_coal_block_column", ModBlocks.TILED_COAL_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_COAL_BLOCK =
        registerBlockItem("tiny_brick_bordered_coal_block", ModBlocks.TINY_BRICK_BORDERED_COAL_BLOCK);

    // ── Cobblestone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_COBBLESTONE =
        registerBlockItem("bordered_cobblestone", ModBlocks.BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_COBBLESTONE =
        registerBlockItem("brick_bordered_cobblestone", ModBlocks.BRICK_BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_COBBLESTONE_PILLAR =
        registerBlockItem("curly_cobblestone_pillar", ModBlocks.CURLY_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_COBBLESTONE_COLUMN =
        registerBlockItem("cut_cobblestone_column", ModBlocks.CUT_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_COBBLESTONE_BRICKS =
        registerBlockItem("edged_cobblestone_bricks", ModBlocks.EDGED_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_COBBLESTONE_PILLAR =
        registerBlockItem("fine_cobblestone_pillar", ModBlocks.FINE_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_COBBLESTONE_BRICKS =
        registerBlockItem("massive_cobblestone_bricks", ModBlocks.MASSIVE_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_COBBLESTONE_PILLAR =
        registerBlockItem("ornate_cobblestone_pillar", ModBlocks.ORNATE_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_COBBLESTONE_TILES =
        registerBlockItem("overlapping_cobblestone_tiles", ModBlocks.OVERLAPPING_COBBLESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_COBBLESTONE =
        registerBlockItem("polished_cobblestone", ModBlocks.POLISHED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_COBBLESTONE_PILLAR =
        registerBlockItem("simple_cobblestone_pillar", ModBlocks.SIMPLE_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_COBBLESTONE_COLUMN =
        registerBlockItem("smooth_cobblestone_column", ModBlocks.SMOOTH_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_COBBLESTONE =
        registerBlockItem("thick_inlayed_cobblestone", ModBlocks.THICK_INLAYED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_COBBLESTONE =
        registerBlockItem("tiled_bordered_cobblestone", ModBlocks.TILED_BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_COBBLESTONE_COLUMN =
        registerBlockItem("tiled_cobblestone_column", ModBlocks.TILED_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_COBBLESTONE =
        registerBlockItem("tiny_brick_bordered_cobblestone", ModBlocks.TINY_BRICK_BORDERED_COBBLESTONE);

    // ── Crimson Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_CRIMSON_PLANKS =
        registerBlockItem("cornered_crimson_planks", ModBlocks.CORNERED_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_CRIMSON_PLANKS =
        registerBlockItem("crated_crimson_planks", ModBlocks.CRATED_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_PANEL =
        registerBlockItem("crimson_planks_panel", ModBlocks.CRIMSON_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_CRIMSON_PLANKS =
        registerBlockItem("enclosed_crimson_planks", ModBlocks.ENCLOSED_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_CRIMSON_PLANKS =
        registerBlockItem("framed_crimson_planks", ModBlocks.FRAMED_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_CRIMSON_PLANKS =
        registerBlockItem("natural_crimson_planks", ModBlocks.NATURAL_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_CRIMSON_PLANKS =
        registerBlockItem("pegged_crimson_planks", ModBlocks.PEGGED_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_CRIMSON_PLANKS =
        registerBlockItem("whirlwind_crimson_planks", ModBlocks.WHIRLWIND_CRIMSON_PLANKS);

    // ── Crying Obsidian ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("bordered_crying_obsidian", ModBlocks.BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("brick_bordered_crying_obsidian", ModBlocks.BRICK_BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> CURLY_CRYING_OBSIDIAN_PILLAR =
        registerBlockItem("curly_crying_obsidian_pillar", ModBlocks.CURLY_CRYING_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_CRYING_OBSIDIAN_COLUMN =
        registerBlockItem("cut_crying_obsidian_column", ModBlocks.CUT_CRYING_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_CRYING_OBSIDIAN_BRICKS =
        registerBlockItem("edged_crying_obsidian_bricks", ModBlocks.EDGED_CRYING_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_CRYING_OBSIDIAN_PILLAR =
        registerBlockItem("fine_crying_obsidian_pillar", ModBlocks.FINE_CRYING_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_CRYING_OBSIDIAN_BRICKS =
        registerBlockItem("massive_crying_obsidian_bricks", ModBlocks.MASSIVE_CRYING_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CRYING_OBSIDIAN_PILLAR =
        registerBlockItem("ornate_crying_obsidian_pillar", ModBlocks.ORNATE_CRYING_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_CRYING_OBSIDIAN_TILES =
        registerBlockItem("overlapping_crying_obsidian_tiles", ModBlocks.OVERLAPPING_CRYING_OBSIDIAN_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_CRYING_OBSIDIAN =
        registerBlockItem("polished_crying_obsidian", ModBlocks.POLISHED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_CRYING_OBSIDIAN_PILLAR =
        registerBlockItem("simple_crying_obsidian_pillar", ModBlocks.SIMPLE_CRYING_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CRYING_OBSIDIAN_COLUMN =
        registerBlockItem("smooth_crying_obsidian_column", ModBlocks.SMOOTH_CRYING_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_CRYING_OBSIDIAN =
        registerBlockItem("thick_inlayed_crying_obsidian", ModBlocks.THICK_INLAYED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("tiled_bordered_crying_obsidian", ModBlocks.TILED_BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TILED_CRYING_OBSIDIAN_COLUMN =
        registerBlockItem("tiled_crying_obsidian_column", ModBlocks.TILED_CRYING_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("tiny_brick_bordered_crying_obsidian", ModBlocks.TINY_BRICK_BORDERED_CRYING_OBSIDIAN);

    // ── Cyan Concrete ──
    public static final DeferredHolder<Item, BlockItem> CYAN_CONCRETE_PANEL =
        registerBlockItem("cyan_concrete_panel", ModBlocks.CYAN_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> CYAN_CONCRETE_PILLAR =
        registerBlockItem("cyan_concrete_pillar", ModBlocks.CYAN_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRILL_CYAN_CONCRETE =
        registerBlockItem("grill_cyan_concrete", ModBlocks.GRILL_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_CYAN_CONCRETE =
        registerBlockItem("pegged_cyan_concrete", ModBlocks.PEGGED_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CYAN_CONCRETE =
        registerBlockItem("smooth_cyan_concrete", ModBlocks.SMOOTH_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_CYAN_CONCRETE =
        registerBlockItem("striped_cyan_concrete", ModBlocks.STRIPED_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_CYAN_CONCRETE =
        registerBlockItem("wired_cyan_concrete", ModBlocks.WIRED_CYAN_CONCRETE);

    // ── Cyan Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_CYAN_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_cyan_stained_glass_pillar", ModBlocks.ARCHED_CYAN_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_CYAN_STAINED_GLASS =
        registerBlockItem("fancy_cyan_stained_glass", ModBlocks.FANCY_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CYAN_STAINED_GLASS =
        registerBlockItem("ornate_cyan_stained_glass", ModBlocks.ORNATE_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_CYAN_STAINED_GLASS =
        registerBlockItem("raster_cyan_stained_glass", ModBlocks.RASTER_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_STAINED_GLASS =
        registerBlockItem("small_cyan_stained_glass", ModBlocks.SMALL_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_CYAN_STAINED_GLASS =
        registerBlockItem("tiled_cyan_stained_glass", ModBlocks.TILED_CYAN_STAINED_GLASS);

    // ── Cyan Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_CYAN_TERRACOTTA =
        registerBlockItem("circular_cyan_terracotta", ModBlocks.CIRCULAR_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_CYAN_TERRACOTTA =
        registerBlockItem("curled_cyan_terracotta", ModBlocks.CURLED_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CYAN_TERRACOTTA_COLUMN =
        registerBlockItem("cyan_terracotta_column", ModBlocks.CYAN_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CYAN_TERRACOTTA_PILLAR =
        registerBlockItem("cyan_terracotta_pillar", ModBlocks.CYAN_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_CYAN_TERRACOTTA =
        registerBlockItem("hexagonical_cyan_terracotta", ModBlocks.HEXAGONICAL_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_CYAN_TERRACOTTA =
        registerBlockItem("inscribed_cyan_terracotta", ModBlocks.INSCRIBED_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_TERRACOTTA_TILES =
        registerBlockItem("small_cyan_terracotta_tiles", ModBlocks.SMALL_CYAN_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_CYAN_TERRACOTTA =
        registerBlockItem("starry_cyan_terracotta", ModBlocks.STARRY_CYAN_TERRACOTTA);

    // ── Cyan Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_CYAN_WOOL =
        registerBlockItem("cornered_cyan_wool", ModBlocks.CORNERED_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_CYAN_WOOL =
        registerBlockItem("crafted_cyan_wool", ModBlocks.CRAFTED_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_CYAN_WOOL =
        registerBlockItem("harsh_quilted_cyan_wool", ModBlocks.HARSH_QUILTED_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_CYAN_WOOL =
        registerBlockItem("rectangle_cyan_wool", ModBlocks.RECTANGLE_CYAN_WOOL);

    // ── Dark Oak Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_DARK_OAK_PLANKS =
        registerBlockItem("cornered_dark_oak_planks", ModBlocks.CORNERED_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_DARK_OAK_PLANKS =
        registerBlockItem("crated_dark_oak_planks", ModBlocks.CRATED_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_PANEL =
        registerBlockItem("dark_oak_planks_panel", ModBlocks.DARK_OAK_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_DARK_OAK_PLANKS =
        registerBlockItem("enclosed_dark_oak_planks", ModBlocks.ENCLOSED_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_DARK_OAK_PLANKS =
        registerBlockItem("framed_dark_oak_planks", ModBlocks.FRAMED_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_DARK_OAK_PLANKS =
        registerBlockItem("natural_dark_oak_planks", ModBlocks.NATURAL_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_DARK_OAK_PLANKS =
        registerBlockItem("pegged_dark_oak_planks", ModBlocks.PEGGED_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_DARK_OAK_PLANKS =
        registerBlockItem("whirlwind_dark_oak_planks", ModBlocks.WHIRLWIND_DARK_OAK_PLANKS);

    // ── Dark Prismarine ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_DARK_PRISMARINE =
        registerBlockItem("bordered_dark_prismarine", ModBlocks.BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DARK_PRISMARINE =
        registerBlockItem("brick_bordered_dark_prismarine", ModBlocks.BRICK_BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> CURLY_DARK_PRISMARINE_PILLAR =
        registerBlockItem("curly_dark_prismarine_pillar", ModBlocks.CURLY_DARK_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_DARK_PRISMARINE_COLUMN =
        registerBlockItem("cut_dark_prismarine_column", ModBlocks.CUT_DARK_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_DARK_PRISMARINE_BRICKS =
        registerBlockItem("edged_dark_prismarine_bricks", ModBlocks.EDGED_DARK_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_DARK_PRISMARINE_PILLAR =
        registerBlockItem("fine_dark_prismarine_pillar", ModBlocks.FINE_DARK_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DARK_PRISMARINE_BRICKS =
        registerBlockItem("massive_dark_prismarine_bricks", ModBlocks.MASSIVE_DARK_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DARK_PRISMARINE_PILLAR =
        registerBlockItem("ornate_dark_prismarine_pillar", ModBlocks.ORNATE_DARK_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DARK_PRISMARINE_TILES =
        registerBlockItem("overlapping_dark_prismarine_tiles", ModBlocks.OVERLAPPING_DARK_PRISMARINE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DARK_PRISMARINE =
        registerBlockItem("polished_dark_prismarine", ModBlocks.POLISHED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DARK_PRISMARINE_PILLAR =
        registerBlockItem("simple_dark_prismarine_pillar", ModBlocks.SIMPLE_DARK_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DARK_PRISMARINE_COLUMN =
        registerBlockItem("smooth_dark_prismarine_column", ModBlocks.SMOOTH_DARK_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DARK_PRISMARINE =
        registerBlockItem("thick_inlayed_dark_prismarine", ModBlocks.THICK_INLAYED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DARK_PRISMARINE =
        registerBlockItem("tiled_bordered_dark_prismarine", ModBlocks.TILED_BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TILED_DARK_PRISMARINE_COLUMN =
        registerBlockItem("tiled_dark_prismarine_column", ModBlocks.TILED_DARK_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DARK_PRISMARINE =
        registerBlockItem("tiny_brick_bordered_dark_prismarine", ModBlocks.TINY_BRICK_BORDERED_DARK_PRISMARINE);

    // ── Deepslate ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_DEEPSLATE =
        registerBlockItem("bordered_deepslate", ModBlocks.BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DEEPSLATE =
        registerBlockItem("brick_bordered_deepslate", ModBlocks.BRICK_BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> CURLY_DEEPSLATE_PILLAR =
        registerBlockItem("curly_deepslate_pillar", ModBlocks.CURLY_DEEPSLATE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_DEEPSLATE_COLUMN =
        registerBlockItem("cut_deepslate_column", ModBlocks.CUT_DEEPSLATE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_DEEPSLATE_BRICKS =
        registerBlockItem("edged_deepslate_bricks", ModBlocks.EDGED_DEEPSLATE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_DEEPSLATE_PILLAR =
        registerBlockItem("fine_deepslate_pillar", ModBlocks.FINE_DEEPSLATE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DEEPSLATE_BRICKS =
        registerBlockItem("massive_deepslate_bricks", ModBlocks.MASSIVE_DEEPSLATE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DEEPSLATE_PILLAR =
        registerBlockItem("ornate_deepslate_pillar", ModBlocks.ORNATE_DEEPSLATE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DEEPSLATE_TILES =
        registerBlockItem("overlapping_deepslate_tiles", ModBlocks.OVERLAPPING_DEEPSLATE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DEEPSLATE =
        registerBlockItem("polished_deepslate", ModBlocks.POLISHED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DEEPSLATE_PILLAR =
        registerBlockItem("simple_deepslate_pillar", ModBlocks.SIMPLE_DEEPSLATE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DEEPSLATE_COLUMN =
        registerBlockItem("smooth_deepslate_column", ModBlocks.SMOOTH_DEEPSLATE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DEEPSLATE =
        registerBlockItem("thick_inlayed_deepslate", ModBlocks.THICK_INLAYED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DEEPSLATE =
        registerBlockItem("tiled_bordered_deepslate", ModBlocks.TILED_BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> TILED_DEEPSLATE_COLUMN =
        registerBlockItem("tiled_deepslate_column", ModBlocks.TILED_DEEPSLATE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DEEPSLATE =
        registerBlockItem("tiny_brick_bordered_deepslate", ModBlocks.TINY_BRICK_BORDERED_DEEPSLATE);

    // ── Diorite ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_DIORITE =
        registerBlockItem("bordered_diorite", ModBlocks.BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DIORITE =
        registerBlockItem("brick_bordered_diorite", ModBlocks.BRICK_BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> CURLY_DIORITE_PILLAR =
        registerBlockItem("curly_diorite_pillar", ModBlocks.CURLY_DIORITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_DIORITE_COLUMN =
        registerBlockItem("cut_diorite_column", ModBlocks.CUT_DIORITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_DIORITE_BRICKS =
        registerBlockItem("edged_diorite_bricks", ModBlocks.EDGED_DIORITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_DIORITE_PILLAR =
        registerBlockItem("fine_diorite_pillar", ModBlocks.FINE_DIORITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DIORITE_BRICKS =
        registerBlockItem("massive_diorite_bricks", ModBlocks.MASSIVE_DIORITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DIORITE_PILLAR =
        registerBlockItem("ornate_diorite_pillar", ModBlocks.ORNATE_DIORITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DIORITE_TILES =
        registerBlockItem("overlapping_diorite_tiles", ModBlocks.OVERLAPPING_DIORITE_TILES);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DIORITE_PILLAR =
        registerBlockItem("simple_diorite_pillar", ModBlocks.SIMPLE_DIORITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DIORITE_COLUMN =
        registerBlockItem("smooth_diorite_column", ModBlocks.SMOOTH_DIORITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DIORITE =
        registerBlockItem("thick_inlayed_diorite", ModBlocks.THICK_INLAYED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DIORITE =
        registerBlockItem("tiled_bordered_diorite", ModBlocks.TILED_BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> TILED_DIORITE_COLUMN =
        registerBlockItem("tiled_diorite_column", ModBlocks.TILED_DIORITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DIORITE =
        registerBlockItem("tiny_brick_bordered_diorite", ModBlocks.TINY_BRICK_BORDERED_DIORITE);

    // ── Dirt ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_DIRT =
        registerBlockItem("bordered_dirt", ModBlocks.BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DIRT =
        registerBlockItem("brick_bordered_dirt", ModBlocks.BRICK_BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> CURLY_DIRT_PILLAR =
        registerBlockItem("curly_dirt_pillar", ModBlocks.CURLY_DIRT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_DIRT_COLUMN =
        registerBlockItem("cut_dirt_column", ModBlocks.CUT_DIRT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_DIRT_BRICKS =
        registerBlockItem("edged_dirt_bricks", ModBlocks.EDGED_DIRT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_DIRT_PILLAR =
        registerBlockItem("fine_dirt_pillar", ModBlocks.FINE_DIRT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DIRT_BRICKS =
        registerBlockItem("massive_dirt_bricks", ModBlocks.MASSIVE_DIRT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DIRT_PILLAR =
        registerBlockItem("ornate_dirt_pillar", ModBlocks.ORNATE_DIRT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DIRT_TILES =
        registerBlockItem("overlapping_dirt_tiles", ModBlocks.OVERLAPPING_DIRT_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIRT =
        registerBlockItem("polished_dirt", ModBlocks.POLISHED_DIRT);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DIRT_PILLAR =
        registerBlockItem("simple_dirt_pillar", ModBlocks.SIMPLE_DIRT_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DIRT_COLUMN =
        registerBlockItem("smooth_dirt_column", ModBlocks.SMOOTH_DIRT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DIRT =
        registerBlockItem("thick_inlayed_dirt", ModBlocks.THICK_INLAYED_DIRT);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DIRT =
        registerBlockItem("tiled_bordered_dirt", ModBlocks.TILED_BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> TILED_DIRT_COLUMN =
        registerBlockItem("tiled_dirt_column", ModBlocks.TILED_DIRT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DIRT =
        registerBlockItem("tiny_brick_bordered_dirt", ModBlocks.TINY_BRICK_BORDERED_DIRT);

    // ── Dripstone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("bordered_dripstone_block", ModBlocks.BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("brick_bordered_dripstone_block", ModBlocks.BRICK_BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_DRIPSTONE_BLOCK_PILLAR =
        registerBlockItem("curly_dripstone_block_pillar", ModBlocks.CURLY_DRIPSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_DRIPSTONE_BLOCK_COLUMN =
        registerBlockItem("cut_dripstone_block_column", ModBlocks.CUT_DRIPSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_DRIPSTONE_BLOCK_BRICKS =
        registerBlockItem("edged_dripstone_block_bricks", ModBlocks.EDGED_DRIPSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_DRIPSTONE_BLOCK_PILLAR =
        registerBlockItem("fine_dripstone_block_pillar", ModBlocks.FINE_DRIPSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DRIPSTONE_BLOCK_BRICKS =
        registerBlockItem("massive_dripstone_block_bricks", ModBlocks.MASSIVE_DRIPSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DRIPSTONE_BLOCK_PILLAR =
        registerBlockItem("ornate_dripstone_block_pillar", ModBlocks.ORNATE_DRIPSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DRIPSTONE_BLOCK_TILES =
        registerBlockItem("overlapping_dripstone_block_tiles", ModBlocks.OVERLAPPING_DRIPSTONE_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DRIPSTONE_BLOCK =
        registerBlockItem("polished_dripstone_block", ModBlocks.POLISHED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DRIPSTONE_BLOCK_PILLAR =
        registerBlockItem("simple_dripstone_block_pillar", ModBlocks.SIMPLE_DRIPSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DRIPSTONE_BLOCK_COLUMN =
        registerBlockItem("smooth_dripstone_block_column", ModBlocks.SMOOTH_DRIPSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DRIPSTONE_BLOCK =
        registerBlockItem("thick_inlayed_dripstone_block", ModBlocks.THICK_INLAYED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("tiled_bordered_dripstone_block", ModBlocks.TILED_BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_DRIPSTONE_BLOCK_COLUMN =
        registerBlockItem("tiled_dripstone_block_column", ModBlocks.TILED_DRIPSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("tiny_brick_bordered_dripstone_block", ModBlocks.TINY_BRICK_BORDERED_DRIPSTONE_BLOCK);

    // ── End Stone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_END_STONE =
        registerBlockItem("bordered_end_stone", ModBlocks.BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_END_STONE =
        registerBlockItem("brick_bordered_end_stone", ModBlocks.BRICK_BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_END_STONE_PILLAR =
        registerBlockItem("curly_end_stone_pillar", ModBlocks.CURLY_END_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_END_STONE_COLUMN =
        registerBlockItem("cut_end_stone_column", ModBlocks.CUT_END_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_END_STONE_BRICKS =
        registerBlockItem("edged_end_stone_bricks", ModBlocks.EDGED_END_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_END_STONE_PILLAR =
        registerBlockItem("fine_end_stone_pillar", ModBlocks.FINE_END_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_END_STONE_BRICKS =
        registerBlockItem("massive_end_stone_bricks", ModBlocks.MASSIVE_END_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_END_STONE_PILLAR =
        registerBlockItem("ornate_end_stone_pillar", ModBlocks.ORNATE_END_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_END_STONE_TILES =
        registerBlockItem("overlapping_end_stone_tiles", ModBlocks.OVERLAPPING_END_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_END_STONE =
        registerBlockItem("polished_end_stone", ModBlocks.POLISHED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_END_STONE_PILLAR =
        registerBlockItem("simple_end_stone_pillar", ModBlocks.SIMPLE_END_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_END_STONE_COLUMN =
        registerBlockItem("smooth_end_stone_column", ModBlocks.SMOOTH_END_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_END_STONE =
        registerBlockItem("thick_inlayed_end_stone", ModBlocks.THICK_INLAYED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_END_STONE =
        registerBlockItem("tiled_bordered_end_stone", ModBlocks.TILED_BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_END_STONE_COLUMN =
        registerBlockItem("tiled_end_stone_column", ModBlocks.TILED_END_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_END_STONE =
        registerBlockItem("tiny_brick_bordered_end_stone", ModBlocks.TINY_BRICK_BORDERED_END_STONE);

    // ── Gilded Blackston ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("bordered_gilded_blackstone", ModBlocks.BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("brick_bordered_gilded_blackstone", ModBlocks.BRICK_BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_GILDED_BLACKSTONE_PILLAR =
        registerBlockItem("curly_gilded_blackstone_pillar", ModBlocks.CURLY_GILDED_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_GILDED_BLACKSTONE_COLUMN =
        registerBlockItem("cut_gilded_blackstone_column", ModBlocks.CUT_GILDED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_GILDED_BLACKSTONE_BRICKS =
        registerBlockItem("edged_gilded_blackstone_bricks", ModBlocks.EDGED_GILDED_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_GILDED_BLACKSTONE_PILLAR =
        registerBlockItem("fine_gilded_blackstone_pillar", ModBlocks.FINE_GILDED_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_GILDED_BLACKSTONE_BRICKS =
        registerBlockItem("massive_gilded_blackstone_bricks", ModBlocks.MASSIVE_GILDED_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GILDED_BLACKSTONE_PILLAR =
        registerBlockItem("ornate_gilded_blackstone_pillar", ModBlocks.ORNATE_GILDED_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_GILDED_BLACKSTONE_TILES =
        registerBlockItem("overlapping_gilded_blackstone_tiles", ModBlocks.OVERLAPPING_GILDED_BLACKSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_GILDED_BLACKSTONE =
        registerBlockItem("polished_gilded_blackstone", ModBlocks.POLISHED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_GILDED_BLACKSTONE_PILLAR =
        registerBlockItem("simple_gilded_blackstone_pillar", ModBlocks.SIMPLE_GILDED_BLACKSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GILDED_BLACKSTONE_COLUMN =
        registerBlockItem("smooth_gilded_blackstone_column", ModBlocks.SMOOTH_GILDED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_GILDED_BLACKSTONE =
        registerBlockItem("thick_inlayed_gilded_blackstone", ModBlocks.THICK_INLAYED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("tiled_bordered_gilded_blackstone", ModBlocks.TILED_BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_GILDED_BLACKSTONE_COLUMN =
        registerBlockItem("tiled_gilded_blackstone_column", ModBlocks.TILED_GILDED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("tiny_brick_bordered_gilded_blackstone", ModBlocks.TINY_BRICK_BORDERED_GILDED_BLACKSTONE);

    // ── Granite ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_GRANITE =
        registerBlockItem("bordered_granite", ModBlocks.BORDERED_GRANITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_GRANITE =
        registerBlockItem("brick_bordered_granite", ModBlocks.BRICK_BORDERED_GRANITE);
    public static final DeferredHolder<Item, BlockItem> CURLY_GRANITE_PILLAR =
        registerBlockItem("curly_granite_pillar", ModBlocks.CURLY_GRANITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_GRANITE_COLUMN =
        registerBlockItem("cut_granite_column", ModBlocks.CUT_GRANITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_GRANITE_BRICKS =
        registerBlockItem("edged_granite_bricks", ModBlocks.EDGED_GRANITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_GRANITE_PILLAR =
        registerBlockItem("fine_granite_pillar", ModBlocks.FINE_GRANITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRANITE_PRISMARINE =
        registerBlockItem("granite_prismarine", ModBlocks.GRANITE_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_GRANITE_BRICKS =
        registerBlockItem("massive_granite_bricks", ModBlocks.MASSIVE_GRANITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRANITE_PILLAR =
        registerBlockItem("ornate_granite_pillar", ModBlocks.ORNATE_GRANITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_GRANITE_TILES =
        registerBlockItem("overlapping_granite_tiles", ModBlocks.OVERLAPPING_GRANITE_TILES);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_GRANITE_PILLAR =
        registerBlockItem("simple_granite_pillar", ModBlocks.SIMPLE_GRANITE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GRANITE_COLUMN =
        registerBlockItem("smooth_granite_column", ModBlocks.SMOOTH_GRANITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_GRANITE =
        registerBlockItem("thick_inlayed_granite", ModBlocks.THICK_INLAYED_GRANITE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_GRANITE =
        registerBlockItem("tiled_bordered_granite", ModBlocks.TILED_BORDERED_GRANITE);
    public static final DeferredHolder<Item, BlockItem> TILED_GRANITE_COLUMN =
        registerBlockItem("tiled_granite_column", ModBlocks.TILED_GRANITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_GRANITE =
        registerBlockItem("tiny_brick_bordered_granite", ModBlocks.TINY_BRICK_BORDERED_GRANITE);

    // ── Gray Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRAY_CONCRETE_PANEL =
        registerBlockItem("gray_concrete_panel", ModBlocks.GRAY_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> GRAY_CONCRETE_PILLAR =
        registerBlockItem("gray_concrete_pillar", ModBlocks.GRAY_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRILL_GRAY_CONCRETE =
        registerBlockItem("grill_gray_concrete", ModBlocks.GRILL_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_GRAY_CONCRETE =
        registerBlockItem("pegged_gray_concrete", ModBlocks.PEGGED_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GRAY_CONCRETE =
        registerBlockItem("smooth_gray_concrete", ModBlocks.SMOOTH_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_GRAY_CONCRETE =
        registerBlockItem("striped_gray_concrete", ModBlocks.STRIPED_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_GRAY_CONCRETE =
        registerBlockItem("wired_gray_concrete", ModBlocks.WIRED_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_LIGHT_GRAY_CONCRETE =
        registerBlockItem("wired_light_gray_concrete", ModBlocks.WIRED_LIGHT_GRAY_CONCRETE);

    // ── Gray Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_GRAY_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_gray_stained_glass_pillar", ModBlocks.ARCHED_GRAY_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_GRAY_STAINED_GLASS =
        registerBlockItem("fancy_gray_stained_glass", ModBlocks.FANCY_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRAY_STAINED_GLASS =
        registerBlockItem("ornate_gray_stained_glass", ModBlocks.ORNATE_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_GRAY_STAINED_GLASS =
        registerBlockItem("raster_gray_stained_glass", ModBlocks.RASTER_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_STAINED_GLASS =
        registerBlockItem("small_gray_stained_glass", ModBlocks.SMALL_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_GRAY_STAINED_GLASS =
        registerBlockItem("tiled_gray_stained_glass", ModBlocks.TILED_GRAY_STAINED_GLASS);

    // ── Gray Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GRAY_TERRACOTTA =
        registerBlockItem("circular_gray_terracotta", ModBlocks.CIRCULAR_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_GRAY_TERRACOTTA =
        registerBlockItem("curled_gray_terracotta", ModBlocks.CURLED_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> GRAY_TERRACOTTA_COLUMN =
        registerBlockItem("gray_terracotta_column", ModBlocks.GRAY_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> GRAY_TERRACOTTA_PILLAR =
        registerBlockItem("gray_terracotta_pillar", ModBlocks.GRAY_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_GRAY_TERRACOTTA =
        registerBlockItem("hexagonical_gray_terracotta", ModBlocks.HEXAGONICAL_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_GRAY_TERRACOTTA =
        registerBlockItem("inscribed_gray_terracotta", ModBlocks.INSCRIBED_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_TERRACOTTA_TILES =
        registerBlockItem("small_gray_terracotta_tiles", ModBlocks.SMALL_GRAY_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_GRAY_TERRACOTTA =
        registerBlockItem("starry_gray_terracotta", ModBlocks.STARRY_GRAY_TERRACOTTA);

    // ── Gray Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_GRAY_WOOL =
        registerBlockItem("cornered_gray_wool", ModBlocks.CORNERED_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_GRAY_WOOL =
        registerBlockItem("crafted_gray_wool", ModBlocks.CRAFTED_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_GRAY_WOOL =
        registerBlockItem("harsh_quilted_gray_wool", ModBlocks.HARSH_QUILTED_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_GRAY_WOOL =
        registerBlockItem("rectangle_gray_wool", ModBlocks.RECTANGLE_GRAY_WOOL);

    // ── Green Concrete ──
    public static final DeferredHolder<Item, BlockItem> GREEN_CONCRETE_PANEL =
        registerBlockItem("green_concrete_panel", ModBlocks.GREEN_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> GREEN_CONCRETE_PILLAR =
        registerBlockItem("green_concrete_pillar", ModBlocks.GREEN_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GRILL_GREEN_CONCRETE =
        registerBlockItem("grill_green_concrete", ModBlocks.GRILL_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_GREEN_CONCRETE =
        registerBlockItem("pegged_green_concrete", ModBlocks.PEGGED_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GREEN_CONCRETE =
        registerBlockItem("smooth_green_concrete", ModBlocks.SMOOTH_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_GREEN_CONCRETE =
        registerBlockItem("striped_green_concrete", ModBlocks.STRIPED_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_GREEN_CONCRETE =
        registerBlockItem("wired_green_concrete", ModBlocks.WIRED_GREEN_CONCRETE);

    // ── Green Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_GREEN_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_green_stained_glass_pillar", ModBlocks.ARCHED_GREEN_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_GREEN_STAINED_GLASS =
        registerBlockItem("fancy_green_stained_glass", ModBlocks.FANCY_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GREEN_STAINED_GLASS =
        registerBlockItem("ornate_green_stained_glass", ModBlocks.ORNATE_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_GREEN_STAINED_GLASS =
        registerBlockItem("raster_green_stained_glass", ModBlocks.RASTER_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_STAINED_GLASS =
        registerBlockItem("small_green_stained_glass", ModBlocks.SMALL_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_GREEN_STAINED_GLASS =
        registerBlockItem("tiled_green_stained_glass", ModBlocks.TILED_GREEN_STAINED_GLASS);

    // ── Green Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GREEN_TERRACOTTA =
        registerBlockItem("circular_green_terracotta", ModBlocks.CIRCULAR_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_GREEN_TERRACOTTA =
        registerBlockItem("curled_green_terracotta", ModBlocks.CURLED_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> GREEN_TERRACOTTA_COLUMN =
        registerBlockItem("green_terracotta_column", ModBlocks.GREEN_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> GREEN_TERRACOTTA_PILLAR =
        registerBlockItem("green_terracotta_pillar", ModBlocks.GREEN_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_GREEN_TERRACOTTA =
        registerBlockItem("hexagonical_green_terracotta", ModBlocks.HEXAGONICAL_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_GREEN_TERRACOTTA =
        registerBlockItem("inscribed_green_terracotta", ModBlocks.INSCRIBED_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_TERRACOTTA_TILES =
        registerBlockItem("small_green_terracotta_tiles", ModBlocks.SMALL_GREEN_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_GREEN_TERRACOTTA =
        registerBlockItem("starry_green_terracotta", ModBlocks.STARRY_GREEN_TERRACOTTA);

    // ── Green Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_GREEN_WOOL =
        registerBlockItem("cornered_green_wool", ModBlocks.CORNERED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_GREEN_WOOL =
        registerBlockItem("crafted_green_wool", ModBlocks.CRAFTED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_GREEN_WOOL =
        registerBlockItem("harsh_quilted_green_wool", ModBlocks.HARSH_QUILTED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_GREEN_WOOL =
        registerBlockItem("rectangle_green_wool", ModBlocks.RECTANGLE_GREEN_WOOL);

    // ── Ice ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_ICE =
        registerBlockItem("bordered_ice", ModBlocks.BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_ICE =
        registerBlockItem("brick_bordered_ice", ModBlocks.BRICK_BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> CURLY_ICE_PILLAR =
        registerBlockItem("curly_ice_pillar", ModBlocks.CURLY_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_ICE_COLUMN =
        registerBlockItem("cut_ice_column", ModBlocks.CUT_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_ICE_BRICKS =
        registerBlockItem("edged_ice_bricks", ModBlocks.EDGED_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_ICE_PILLAR =
        registerBlockItem("fine_ice_pillar", ModBlocks.FINE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_ICE_BRICKS =
        registerBlockItem("massive_ice_bricks", ModBlocks.MASSIVE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ICE_PILLAR =
        registerBlockItem("ornate_ice_pillar", ModBlocks.ORNATE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_ICE_TILES =
        registerBlockItem("overlapping_ice_tiles", ModBlocks.OVERLAPPING_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_ICE =
        registerBlockItem("polished_ice", ModBlocks.POLISHED_ICE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_ICE_PILLAR =
        registerBlockItem("simple_ice_pillar", ModBlocks.SIMPLE_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ICE_COLUMN =
        registerBlockItem("smooth_ice_column", ModBlocks.SMOOTH_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_ICE =
        registerBlockItem("thick_inlayed_ice", ModBlocks.THICK_INLAYED_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_ICE =
        registerBlockItem("tiled_bordered_ice", ModBlocks.TILED_BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_ICE_COLUMN =
        registerBlockItem("tiled_ice_column", ModBlocks.TILED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_ICE =
        registerBlockItem("tiny_brick_bordered_ice", ModBlocks.TINY_BRICK_BORDERED_ICE);

    // ── Jungle Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_JUNGLE_PLANKS =
        registerBlockItem("cornered_jungle_planks", ModBlocks.CORNERED_JUNGLE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_JUNGLE_PLANKS =
        registerBlockItem("crated_jungle_planks", ModBlocks.CRATED_JUNGLE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_JUNGLE_PLANKS =
        registerBlockItem("enclosed_jungle_planks", ModBlocks.ENCLOSED_JUNGLE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_JUNGLE_PLANKS =
        registerBlockItem("framed_jungle_planks", ModBlocks.FRAMED_JUNGLE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_JUNGLE_PLANKS =
        registerBlockItem("natural_jungle_planks", ModBlocks.NATURAL_JUNGLE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_JUNGLE_PLANKS =
        registerBlockItem("pegged_jungle_planks", ModBlocks.PEGGED_JUNGLE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_JUNGLE_PLANKS =
        registerBlockItem("whirlwind_jungle_planks", ModBlocks.WHIRLWIND_JUNGLE_PLANKS);

    // ── Lapis Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_LAPIS_BLOCK =
        registerBlockItem("bordered_lapis_block", ModBlocks.BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_LAPIS_BLOCK =
        registerBlockItem("brick_bordered_lapis_block", ModBlocks.BRICK_BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_LAPIS_BLOCK_PILLAR =
        registerBlockItem("curly_lapis_block_pillar", ModBlocks.CURLY_LAPIS_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_LAPIS_BLOCK_COLUMN =
        registerBlockItem("cut_lapis_block_column", ModBlocks.CUT_LAPIS_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_LAPIS_BLOCK_BRICKS =
        registerBlockItem("edged_lapis_block_bricks", ModBlocks.EDGED_LAPIS_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_LAPIS_BLOCK_PILLAR =
        registerBlockItem("fine_lapis_block_pillar", ModBlocks.FINE_LAPIS_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_LAPIS_BLOCK_BRICKS =
        registerBlockItem("massive_lapis_block_bricks", ModBlocks.MASSIVE_LAPIS_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LAPIS_BLOCK_PILLAR =
        registerBlockItem("ornate_lapis_block_pillar", ModBlocks.ORNATE_LAPIS_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_LAPIS_BLOCK_TILES =
        registerBlockItem("overlapping_lapis_block_tiles", ModBlocks.OVERLAPPING_LAPIS_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_LAPIS_BLOCK =
        registerBlockItem("polished_lapis_block", ModBlocks.POLISHED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_LAPIS_BLOCK_PILLAR =
        registerBlockItem("simple_lapis_block_pillar", ModBlocks.SIMPLE_LAPIS_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LAPIS_BLOCK_COLUMN =
        registerBlockItem("smooth_lapis_block_column", ModBlocks.SMOOTH_LAPIS_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_LAPIS_BLOCK =
        registerBlockItem("thick_inlayed_lapis_block", ModBlocks.THICK_INLAYED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_LAPIS_BLOCK =
        registerBlockItem("tiled_bordered_lapis_block", ModBlocks.TILED_BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_LAPIS_BLOCK_COLUMN =
        registerBlockItem("tiled_lapis_block_column", ModBlocks.TILED_LAPIS_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_LAPIS_BLOCK =
        registerBlockItem("tiny_brick_bordered_lapis_block", ModBlocks.TINY_BRICK_BORDERED_LAPIS_BLOCK);

    // ── Leaded Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_LEADED_GLASS_PILLAR =
        registerBlockItem("arched_leaded_glass_pillar", ModBlocks.ARCHED_LEADED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LEADED_GLASS =
        registerBlockItem("ornate_leaded_glass", ModBlocks.ORNATE_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LEADED_GLASS =
        registerBlockItem("raster_leaded_glass", ModBlocks.RASTER_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_DIAMOND_LEADED_GLASS =
        registerBlockItem("small_diamond_leaded_glass", ModBlocks.SMALL_DIAMOND_LEADED_GLASS);

    // ── Light Blue Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_LIGHT_BLUE_CONCRETE =
        registerBlockItem("grill_light_blue_concrete", ModBlocks.GRILL_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_CONCRETE_PANEL =
        registerBlockItem("light_blue_concrete_panel", ModBlocks.LIGHT_BLUE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_CONCRETE_PILLAR =
        registerBlockItem("light_blue_concrete_pillar", ModBlocks.LIGHT_BLUE_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PEGGED_LIGHT_BLUE_CONCRETE =
        registerBlockItem("pegged_light_blue_concrete", ModBlocks.PEGGED_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LIGHT_BLUE_CONCRETE =
        registerBlockItem("smooth_light_blue_concrete", ModBlocks.SMOOTH_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_LIGHT_BLUE_CONCRETE =
        registerBlockItem("striped_light_blue_concrete", ModBlocks.STRIPED_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_LIGHT_BLUE_CONCRETE =
        registerBlockItem("wired_light_blue_concrete", ModBlocks.WIRED_LIGHT_BLUE_CONCRETE);

    // ── Light Blue Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIGHT_BLUE_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_light_blue_stained_glass_pillar", ModBlocks.ARCHED_LIGHT_BLUE_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("fancy_light_blue_stained_glass", ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("ornate_light_blue_stained_glass", ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("raster_light_blue_stained_glass", ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("small_light_blue_stained_glass", ModBlocks.SMALL_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("tiled_light_blue_stained_glass", ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS);

    // ── Light Blue Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("circular_light_blue_terracotta", ModBlocks.CIRCULAR_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("curled_light_blue_terracotta", ModBlocks.CURLED_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("hexagonical_light_blue_terracotta", ModBlocks.HEXAGONICAL_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("inscribed_light_blue_terracotta", ModBlocks.INSCRIBED_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_TERRACOTTA_COLUMN =
        registerBlockItem("light_blue_terracotta_column", ModBlocks.LIGHT_BLUE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_TERRACOTTA_PILLAR =
        registerBlockItem("light_blue_terracotta_pillar", ModBlocks.LIGHT_BLUE_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_TERRACOTTA_TILES =
        registerBlockItem("small_light_blue_terracotta_tiles", ModBlocks.SMALL_LIGHT_BLUE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("starry_light_blue_terracotta", ModBlocks.STARRY_LIGHT_BLUE_TERRACOTTA);

    // ── Light Blue Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_LIGHT_BLUE_WOOL =
        registerBlockItem("cornered_light_blue_wool", ModBlocks.CORNERED_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_LIGHT_BLUE_WOOL =
        registerBlockItem("crafted_light_blue_wool", ModBlocks.CRAFTED_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_LIGHT_BLUE_WOOL =
        registerBlockItem("harsh_quilted_light_blue_wool", ModBlocks.HARSH_QUILTED_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_LIGHT_BLUE_WOOL =
        registerBlockItem("rectangle_light_blue_wool", ModBlocks.RECTANGLE_LIGHT_BLUE_WOOL);

    // ── Light Gray Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_LIGHT_GRAY_CONCRETE =
        registerBlockItem("grill_light_gray_concrete", ModBlocks.GRILL_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_CONCRETE_PANEL =
        registerBlockItem("light_gray_concrete_panel", ModBlocks.LIGHT_GRAY_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_CONCRETE_PILLAR =
        registerBlockItem("light_gray_concrete_pillar", ModBlocks.LIGHT_GRAY_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PEGGED_LIGHT_GRAY_CONCRETE =
        registerBlockItem("pegged_light_gray_concrete", ModBlocks.PEGGED_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LIGHT_GRAY_CONCRETE =
        registerBlockItem("smooth_light_gray_concrete", ModBlocks.SMOOTH_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_LIGHT_GRAY_CONCRETE =
        registerBlockItem("striped_light_gray_concrete", ModBlocks.STRIPED_LIGHT_GRAY_CONCRETE);

    // ── Light Gray Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIGHT_GRAY_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_light_gray_stained_glass_pillar", ModBlocks.ARCHED_LIGHT_GRAY_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("fancy_light_gray_stained_glass", ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("ornate_light_gray_stained_glass", ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("raster_light_gray_stained_glass", ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("small_light_gray_stained_glass", ModBlocks.SMALL_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("tiled_light_gray_stained_glass", ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS);

    // ── Light Gray Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("circular_light_gray_terracotta", ModBlocks.CIRCULAR_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("curled_light_gray_terracotta", ModBlocks.CURLED_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("hexagonical_light_gray_terracotta", ModBlocks.HEXAGONICAL_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("inscribed_light_gray_terracotta", ModBlocks.INSCRIBED_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_TERRACOTTA_COLUMN =
        registerBlockItem("light_gray_terracotta_column", ModBlocks.LIGHT_GRAY_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_TERRACOTTA_PILLAR =
        registerBlockItem("light_gray_terracotta_pillar", ModBlocks.LIGHT_GRAY_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_TERRACOTTA_TILES =
        registerBlockItem("small_light_gray_terracotta_tiles", ModBlocks.SMALL_LIGHT_GRAY_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("starry_light_gray_terracotta", ModBlocks.STARRY_LIGHT_GRAY_TERRACOTTA);

    // ── Light Gray Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_LIGHT_GRAY_WOOL =
        registerBlockItem("cornered_light_gray_wool", ModBlocks.CORNERED_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_LIGHT_GRAY_WOOL =
        registerBlockItem("crafted_light_gray_wool", ModBlocks.CRAFTED_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_LIGHT_GRAY_WOOL =
        registerBlockItem("harsh_quilted_light_gray_wool", ModBlocks.HARSH_QUILTED_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_LIGHT_GRAY_WOOL =
        registerBlockItem("rectangle_light_gray_wool", ModBlocks.RECTANGLE_LIGHT_GRAY_WOOL);

    // ── Lime Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_LIME_CONCRETE =
        registerBlockItem("grill_lime_concrete", ModBlocks.GRILL_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> LIME_CONCRETE_PANEL =
        registerBlockItem("lime_concrete_panel", ModBlocks.LIME_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> LIME_CONCRETE_PILLAR =
        registerBlockItem("lime_concrete_pillar", ModBlocks.LIME_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PEGGED_LIME_CONCRETE =
        registerBlockItem("pegged_lime_concrete", ModBlocks.PEGGED_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LIME_CONCRETE =
        registerBlockItem("smooth_lime_concrete", ModBlocks.SMOOTH_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_LIME_CONCRETE =
        registerBlockItem("striped_lime_concrete", ModBlocks.STRIPED_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_LIME_CONCRETE =
        registerBlockItem("wired_lime_concrete", ModBlocks.WIRED_LIME_CONCRETE);

    // ── Lime Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIME_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_lime_stained_glass_pillar", ModBlocks.ARCHED_LIME_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIME_STAINED_GLASS =
        registerBlockItem("fancy_lime_stained_glass", ModBlocks.FANCY_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIME_STAINED_GLASS =
        registerBlockItem("ornate_lime_stained_glass", ModBlocks.ORNATE_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIME_STAINED_GLASS =
        registerBlockItem("raster_lime_stained_glass", ModBlocks.RASTER_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_STAINED_GLASS =
        registerBlockItem("small_lime_stained_glass", ModBlocks.SMALL_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIME_STAINED_GLASS =
        registerBlockItem("tiled_lime_stained_glass", ModBlocks.TILED_LIME_STAINED_GLASS);

    // ── Lime Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIME_TERRACOTTA =
        registerBlockItem("circular_lime_terracotta", ModBlocks.CIRCULAR_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_LIME_TERRACOTTA =
        registerBlockItem("curled_lime_terracotta", ModBlocks.CURLED_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_LIME_TERRACOTTA =
        registerBlockItem("hexagonical_lime_terracotta", ModBlocks.HEXAGONICAL_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_LIME_TERRACOTTA =
        registerBlockItem("inscribed_lime_terracotta", ModBlocks.INSCRIBED_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> LIME_TERRACOTTA_COLUMN =
        registerBlockItem("lime_terracotta_column", ModBlocks.LIME_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> LIME_TERRACOTTA_PILLAR =
        registerBlockItem("lime_terracotta_pillar", ModBlocks.LIME_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_TERRACOTTA_TILES =
        registerBlockItem("small_lime_terracotta_tiles", ModBlocks.SMALL_LIME_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_LIME_TERRACOTTA =
        registerBlockItem("starry_lime_terracotta", ModBlocks.STARRY_LIME_TERRACOTTA);

    // ── Lime Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_LIME_WOOL =
        registerBlockItem("cornered_lime_wool", ModBlocks.CORNERED_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_LIME_WOOL =
        registerBlockItem("crafted_lime_wool", ModBlocks.CRAFTED_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_LIME_WOOL =
        registerBlockItem("harsh_quilted_lime_wool", ModBlocks.HARSH_QUILTED_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_LIME_WOOL =
        registerBlockItem("rectangle_lime_wool", ModBlocks.RECTANGLE_LIME_WOOL);

    // ── Lodestone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_LODESTONE =
        registerBlockItem("bordered_lodestone", ModBlocks.BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_LODESTONE =
        registerBlockItem("brick_bordered_lodestone", ModBlocks.BRICK_BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_LODESTONE_PILLAR =
        registerBlockItem("curly_lodestone_pillar", ModBlocks.CURLY_LODESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_LODESTONE_COLUMN =
        registerBlockItem("cut_lodestone_column", ModBlocks.CUT_LODESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_LODESTONE_BRICKS =
        registerBlockItem("edged_lodestone_bricks", ModBlocks.EDGED_LODESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_LODESTONE_PILLAR =
        registerBlockItem("fine_lodestone_pillar", ModBlocks.FINE_LODESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_LODESTONE_BRICKS =
        registerBlockItem("massive_lodestone_bricks", ModBlocks.MASSIVE_LODESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LODESTONE_PILLAR =
        registerBlockItem("ornate_lodestone_pillar", ModBlocks.ORNATE_LODESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_LODESTONE_TILES =
        registerBlockItem("overlapping_lodestone_tiles", ModBlocks.OVERLAPPING_LODESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_LODESTONE =
        registerBlockItem("polished_lodestone", ModBlocks.POLISHED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_LODESTONE_PILLAR =
        registerBlockItem("simple_lodestone_pillar", ModBlocks.SIMPLE_LODESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LODESTONE_COLUMN =
        registerBlockItem("smooth_lodestone_column", ModBlocks.SMOOTH_LODESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_LODESTONE =
        registerBlockItem("thick_inlayed_lodestone", ModBlocks.THICK_INLAYED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_LODESTONE =
        registerBlockItem("tiled_bordered_lodestone", ModBlocks.TILED_BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_LODESTONE_COLUMN =
        registerBlockItem("tiled_lodestone_column", ModBlocks.TILED_LODESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_LODESTONE =
        registerBlockItem("tiny_brick_bordered_lodestone", ModBlocks.TINY_BRICK_BORDERED_LODESTONE);

    // ── Magenta Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_MAGENTA_CONCRETE =
        registerBlockItem("grill_magenta_concrete", ModBlocks.GRILL_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_CONCRETE_PANEL =
        registerBlockItem("magenta_concrete_panel", ModBlocks.MAGENTA_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_CONCRETE_PILLAR =
        registerBlockItem("magenta_concrete_pillar", ModBlocks.MAGENTA_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PEGGED_MAGENTA_CONCRETE =
        registerBlockItem("pegged_magenta_concrete", ModBlocks.PEGGED_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MAGENTA_CONCRETE =
        registerBlockItem("smooth_magenta_concrete", ModBlocks.SMOOTH_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_MAGENTA_CONCRETE =
        registerBlockItem("striped_magenta_concrete", ModBlocks.STRIPED_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_MAGENTA_CONCRETE =
        registerBlockItem("wired_magenta_concrete", ModBlocks.WIRED_MAGENTA_CONCRETE);

    // ── Magenta Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_MAGENTA_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_magenta_stained_glass_pillar", ModBlocks.ARCHED_MAGENTA_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_MAGENTA_STAINED_GLASS =
        registerBlockItem("fancy_magenta_stained_glass", ModBlocks.FANCY_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGENTA_STAINED_GLASS =
        registerBlockItem("ornate_magenta_stained_glass", ModBlocks.ORNATE_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_MAGENTA_STAINED_GLASS =
        registerBlockItem("raster_magenta_stained_glass", ModBlocks.RASTER_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_STAINED_GLASS =
        registerBlockItem("small_magenta_stained_glass", ModBlocks.SMALL_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGENTA_STAINED_GLASS =
        registerBlockItem("tiled_magenta_stained_glass", ModBlocks.TILED_MAGENTA_STAINED_GLASS);

    // ── Magenta Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_MAGENTA_TERRACOTTA =
        registerBlockItem("circular_magenta_terracotta", ModBlocks.CIRCULAR_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_MAGENTA_TERRACOTTA =
        registerBlockItem("curled_magenta_terracotta", ModBlocks.CURLED_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_MAGENTA_TERRACOTTA =
        registerBlockItem("hexagonical_magenta_terracotta", ModBlocks.HEXAGONICAL_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_MAGENTA_TERRACOTTA =
        registerBlockItem("inscribed_magenta_terracotta", ModBlocks.INSCRIBED_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_TERRACOTTA_COLUMN =
        registerBlockItem("magenta_terracotta_column", ModBlocks.MAGENTA_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_TERRACOTTA_PILLAR =
        registerBlockItem("magenta_terracotta_pillar", ModBlocks.MAGENTA_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_TERRACOTTA_TILES =
        registerBlockItem("small_magenta_terracotta_tiles", ModBlocks.SMALL_MAGENTA_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_MAGENTA_TERRACOTTA =
        registerBlockItem("starry_magenta_terracotta", ModBlocks.STARRY_MAGENTA_TERRACOTTA);

    // ── Magenta Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_MAGENTA_WOOL =
        registerBlockItem("cornered_magenta_wool", ModBlocks.CORNERED_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_MAGENTA_WOOL =
        registerBlockItem("crafted_magenta_wool", ModBlocks.CRAFTED_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_MAGENTA_WOOL =
        registerBlockItem("harsh_quilted_magenta_wool", ModBlocks.HARSH_QUILTED_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_MAGENTA_WOOL =
        registerBlockItem("rectangle_magenta_wool", ModBlocks.RECTANGLE_MAGENTA_WOOL);

    // ── Magma Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_MAGMA_BLOCK =
        registerBlockItem("bordered_magma_block", ModBlocks.BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MAGMA_BLOCK =
        registerBlockItem("brick_bordered_magma_block", ModBlocks.BRICK_BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_MAGMA_BLOCK_PILLAR =
        registerBlockItem("curly_magma_block_pillar", ModBlocks.CURLY_MAGMA_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_MAGMA_BLOCK_COLUMN =
        registerBlockItem("cut_magma_block_column", ModBlocks.CUT_MAGMA_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_MAGMA_BLOCK_BRICKS =
        registerBlockItem("edged_magma_block_bricks", ModBlocks.EDGED_MAGMA_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_MAGMA_BLOCK_PILLAR =
        registerBlockItem("fine_magma_block_pillar", ModBlocks.FINE_MAGMA_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MAGMA_BLOCK_BRICKS =
        registerBlockItem("massive_magma_block_bricks", ModBlocks.MASSIVE_MAGMA_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGMA_BLOCK_PILLAR =
        registerBlockItem("ornate_magma_block_pillar", ModBlocks.ORNATE_MAGMA_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MAGMA_BLOCK_TILES =
        registerBlockItem("overlapping_magma_block_tiles", ModBlocks.OVERLAPPING_MAGMA_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_MAGMA_BLOCK =
        registerBlockItem("polished_magma_block", ModBlocks.POLISHED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MAGMA_BLOCK_PILLAR =
        registerBlockItem("simple_magma_block_pillar", ModBlocks.SIMPLE_MAGMA_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MAGMA_BLOCK_COLUMN =
        registerBlockItem("smooth_magma_block_column", ModBlocks.SMOOTH_MAGMA_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_MAGMA_BLOCK =
        registerBlockItem("thick_inlayed_magma_block", ModBlocks.THICK_INLAYED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MAGMA_BLOCK =
        registerBlockItem("tiled_bordered_magma_block", ModBlocks.TILED_BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGMA_BLOCK_COLUMN =
        registerBlockItem("tiled_magma_block_column", ModBlocks.TILED_MAGMA_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_MAGMA_BLOCK =
        registerBlockItem("tiny_brick_bordered_magma_block", ModBlocks.TINY_BRICK_BORDERED_MAGMA_BLOCK);

    // ── Mangrove Planks ──
    public static final DeferredHolder<Item, BlockItem> BRICKED_MANGROVE_PLANKS =
        registerBlockItem("bricked_mangrove_planks", ModBlocks.BRICKED_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CORNERED_MANGROVE_PLANKS =
        registerBlockItem("cornered_mangrove_planks", ModBlocks.CORNERED_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_MANGROVE_PLANKS =
        registerBlockItem("crated_mangrove_planks", ModBlocks.CRATED_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_MANGROVE_PLANKS =
        registerBlockItem("enclosed_mangrove_planks", ModBlocks.ENCLOSED_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_MANGROVE_PLANKS =
        registerBlockItem("framed_mangrove_planks", ModBlocks.FRAMED_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_PANEL =
        registerBlockItem("mangrove_planks_panel", ModBlocks.MANGROVE_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> NATURAL_MANGROVE_PLANKS =
        registerBlockItem("natural_mangrove_planks", ModBlocks.NATURAL_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_MANGROVE_PLANKS =
        registerBlockItem("pegged_mangrove_planks", ModBlocks.PEGGED_MANGROVE_PLANKS);

    // ── Mossy Cobblestone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("bordered_mossy_cobblestone", ModBlocks.BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("brick_bordered_mossy_cobblestone", ModBlocks.BRICK_BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_MOSSY_COBBLESTONE_PILLAR =
        registerBlockItem("curly_mossy_cobblestone_pillar", ModBlocks.CURLY_MOSSY_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_MOSSY_COBBLESTONE_COLUMN =
        registerBlockItem("cut_mossy_cobblestone_column", ModBlocks.CUT_MOSSY_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_MOSSY_COBBLESTONE_BRICKS =
        registerBlockItem("edged_mossy_cobblestone_bricks", ModBlocks.EDGED_MOSSY_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_MOSSY_COBBLESTONE_PILLAR =
        registerBlockItem("fine_mossy_cobblestone_pillar", ModBlocks.FINE_MOSSY_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MOSSY_COBBLESTONE_BRICKS =
        registerBlockItem("massive_mossy_cobblestone_bricks", ModBlocks.MASSIVE_MOSSY_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MOSSY_COBBLESTONE_PILLAR =
        registerBlockItem("ornate_mossy_cobblestone_pillar", ModBlocks.ORNATE_MOSSY_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MOSSY_COBBLESTONE_TILES =
        registerBlockItem("overlapping_mossy_cobblestone_tiles", ModBlocks.OVERLAPPING_MOSSY_COBBLESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_MOSSY_COBBLESTONE =
        registerBlockItem("polished_mossy_cobblestone", ModBlocks.POLISHED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MOSSY_COBBLESTONE_PILLAR =
        registerBlockItem("simple_mossy_cobblestone_pillar", ModBlocks.SIMPLE_MOSSY_COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MOSSY_COBBLESTONE_COLUMN =
        registerBlockItem("smooth_mossy_cobblestone_column", ModBlocks.SMOOTH_MOSSY_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_MOSSY_COBBLESTONE =
        registerBlockItem("thick_inlayed_mossy_cobblestone", ModBlocks.THICK_INLAYED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("tiled_bordered_mossy_cobblestone", ModBlocks.TILED_BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_MOSSY_COBBLESTONE_COLUMN =
        registerBlockItem("tiled_mossy_cobblestone_column", ModBlocks.TILED_MOSSY_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("tiny_brick_bordered_mossy_cobblestone", ModBlocks.TINY_BRICK_BORDERED_MOSSY_COBBLESTONE);

    // ── Mossy Stone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("bordered_mossy_stone_bricks", ModBlocks.BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("brick_bordered_mossy_stone_bricks", ModBlocks.BRICK_BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CURLY_MOSSY_STONE_BRICKS_PILLAR =
        registerBlockItem("curly_mossy_stone_bricks_pillar", ModBlocks.CURLY_MOSSY_STONE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_MOSSY_STONE_BRICKS_COLUMN =
        registerBlockItem("cut_mossy_stone_bricks_column", ModBlocks.CUT_MOSSY_STONE_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_MOSSY_STONE_BRICKS_BRICKS =
        registerBlockItem("edged_mossy_stone_bricks_bricks", ModBlocks.EDGED_MOSSY_STONE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_MOSSY_STONE_BRICKS_PILLAR =
        registerBlockItem("fine_mossy_stone_bricks_pillar", ModBlocks.FINE_MOSSY_STONE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MOSSY_STONE_BRICKS_BRICKS =
        registerBlockItem("massive_mossy_stone_bricks_bricks", ModBlocks.MASSIVE_MOSSY_STONE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MOSSY_STONE_BRICKS_PILLAR =
        registerBlockItem("ornate_mossy_stone_bricks_pillar", ModBlocks.ORNATE_MOSSY_STONE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MOSSY_STONE_BRICKS_TILES =
        registerBlockItem("overlapping_mossy_stone_bricks_tiles", ModBlocks.OVERLAPPING_MOSSY_STONE_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_MOSSY_STONE_BRICKS =
        registerBlockItem("polished_mossy_stone_bricks", ModBlocks.POLISHED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MOSSY_STONE_BRICKS_PILLAR =
        registerBlockItem("simple_mossy_stone_bricks_pillar", ModBlocks.SIMPLE_MOSSY_STONE_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MOSSY_STONE_BRICKS_COLUMN =
        registerBlockItem("smooth_mossy_stone_bricks_column", ModBlocks.SMOOTH_MOSSY_STONE_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_MOSSY_STONE_BRICKS =
        registerBlockItem("thick_inlayed_mossy_stone_bricks", ModBlocks.THICK_INLAYED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("tiled_bordered_mossy_stone_bricks", ModBlocks.TILED_BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_MOSSY_STONE_BRICKS_COLUMN =
        registerBlockItem("tiled_mossy_stone_bricks_column", ModBlocks.TILED_MOSSY_STONE_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("tiny_brick_bordered_mossy_stone_bricks", ModBlocks.TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS);

    // ── Mud ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_MUD =
        registerBlockItem("bordered_mud", ModBlocks.BORDERED_MUD);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MUD =
        registerBlockItem("brick_bordered_mud", ModBlocks.BRICK_BORDERED_MUD);
    public static final DeferredHolder<Item, BlockItem> CARVED_MUD_PILLAR =
        registerBlockItem("carved_mud_pillar", ModBlocks.CARVED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CURLY_MUD_PILLAR =
        registerBlockItem("curly_mud_pillar", ModBlocks.CURLY_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> EDGED_MUD =
        registerBlockItem("edged_mud", ModBlocks.EDGED_MUD);
    public static final DeferredHolder<Item, BlockItem> FANCY_MUD_PILLAR =
        registerBlockItem("fancy_mud_pillar", ModBlocks.FANCY_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FINE_MUD_PILLAR =
        registerBlockItem("fine_mud_pillar", ModBlocks.FINE_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> HARD_MUD =
        registerBlockItem("hard_mud", ModBlocks.HARD_MUD);
    public static final DeferredHolder<Item, BlockItem> LARGE_MUD_SIGIL =
        registerBlockItem("large_mud_sigil", ModBlocks.LARGE_MUD_SIGIL);
    public static final DeferredHolder<Item, BlockItem> LOREFUL_MUD =
        registerBlockItem("loreful_mud", ModBlocks.LOREFUL_MUD);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MUD_BRICKS =
        registerBlockItem("massive_mud_bricks", ModBlocks.MASSIVE_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MUD_PILLAR =
        registerBlockItem("ornate_mud_pillar", ModBlocks.ORNATE_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MUD_TILES =
        registerBlockItem("overlapping_mud_tiles", ModBlocks.OVERLAPPING_MUD_TILES);
    public static final DeferredHolder<Item, BlockItem> SCALY_MUD =
        registerBlockItem("scaly_mud", ModBlocks.SCALY_MUD);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MUD_PILLAR =
        registerBlockItem("simple_mud_pillar", ModBlocks.SIMPLE_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MUD =
        registerBlockItem("tiled_bordered_mud", ModBlocks.TILED_BORDERED_MUD);
    public static final DeferredHolder<Item, BlockItem> TILED_MUD_COLUMN =
        registerBlockItem("tiled_mud_column", ModBlocks.TILED_MUD_COLUMN);

    // ── Mud Bricks ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_MUD_BRICKS =
        registerBlockItem("bordered_mud_bricks", ModBlocks.BORDERED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MUD_BRICKS =
        registerBlockItem("brick_bordered_mud_bricks", ModBlocks.BRICK_BORDERED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CARVED_MUD_BRICKS_PILLAR =
        registerBlockItem("carved_mud_bricks_pillar", ModBlocks.CARVED_MUD_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CURLY_MUD_BRICKS_PILLAR =
        registerBlockItem("curly_mud_bricks_pillar", ModBlocks.CURLY_MUD_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> EDGED_MUD_BRICKS_BRICKS =
        registerBlockItem("edged_mud_bricks_bricks", ModBlocks.EDGED_MUD_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FANCY_MUD_BRICKS_PILLAR =
        registerBlockItem("fancy_mud_bricks_pillar", ModBlocks.FANCY_MUD_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FINE_MUD_BRICKS_PILLAR =
        registerBlockItem("fine_mud_bricks_pillar", ModBlocks.FINE_MUD_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> HARD_MUD_BRICKS =
        registerBlockItem("hard_mud_bricks", ModBlocks.HARD_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> LARGE_MUD_BRICKS_SIGIL =
        registerBlockItem("large_mud_bricks_sigil", ModBlocks.LARGE_MUD_BRICKS_SIGIL);
    public static final DeferredHolder<Item, BlockItem> LOREFUL_MUD_BRICKS =
        registerBlockItem("loreful_mud_bricks", ModBlocks.LOREFUL_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MUD_BRICKS_BRICKS =
        registerBlockItem("massive_mud_bricks_bricks", ModBlocks.MASSIVE_MUD_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MUD_BRICKS_PILLAR =
        registerBlockItem("ornate_mud_bricks_pillar", ModBlocks.ORNATE_MUD_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MUD_BRICKS_TILES =
        registerBlockItem("overlapping_mud_bricks_tiles", ModBlocks.OVERLAPPING_MUD_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MUD_BRICKS_PILLAR =
        registerBlockItem("simple_mud_bricks_pillar", ModBlocks.SIMPLE_MUD_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MUD_BRICKS =
        registerBlockItem("tiled_bordered_mud_bricks", ModBlocks.TILED_BORDERED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_MUD_BRICKS_COLUMN =
        registerBlockItem("tiled_mud_bricks_column", ModBlocks.TILED_MUD_BRICKS_COLUMN);

    // ── Netherrack ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_NETHERRACK =
        registerBlockItem("bordered_netherrack", ModBlocks.BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_NETHERRACK =
        registerBlockItem("brick_bordered_netherrack", ModBlocks.BRICK_BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> CURLY_NETHERRACK_PILLAR =
        registerBlockItem("curly_netherrack_pillar", ModBlocks.CURLY_NETHERRACK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_NETHERRACK_COLUMN =
        registerBlockItem("cut_netherrack_column", ModBlocks.CUT_NETHERRACK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_NETHERRACK_BRICKS =
        registerBlockItem("edged_netherrack_bricks", ModBlocks.EDGED_NETHERRACK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_NETHERRACK_PILLAR =
        registerBlockItem("fine_netherrack_pillar", ModBlocks.FINE_NETHERRACK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_NETHERRACK_BRICKS =
        registerBlockItem("massive_netherrack_bricks", ModBlocks.MASSIVE_NETHERRACK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_NETHERRACK_PILLAR =
        registerBlockItem("ornate_netherrack_pillar", ModBlocks.ORNATE_NETHERRACK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_NETHERRACK_TILES =
        registerBlockItem("overlapping_netherrack_tiles", ModBlocks.OVERLAPPING_NETHERRACK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_NETHERRACK =
        registerBlockItem("polished_netherrack", ModBlocks.POLISHED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_NETHERRACK_PILLAR =
        registerBlockItem("simple_netherrack_pillar", ModBlocks.SIMPLE_NETHERRACK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_NETHERRACK_COLUMN =
        registerBlockItem("smooth_netherrack_column", ModBlocks.SMOOTH_NETHERRACK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_NETHERRACK =
        registerBlockItem("thick_inlayed_netherrack", ModBlocks.THICK_INLAYED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_NETHERRACK =
        registerBlockItem("tiled_bordered_netherrack", ModBlocks.TILED_BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> TILED_NETHERRACK_COLUMN =
        registerBlockItem("tiled_netherrack_column", ModBlocks.TILED_NETHERRACK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_NETHERRACK =
        registerBlockItem("tiny_brick_bordered_netherrack", ModBlocks.TINY_BRICK_BORDERED_NETHERRACK);

    // ── Nether Bricks ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_NETHER_BRICKS =
        registerBlockItem("bordered_nether_bricks", ModBlocks.BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_NETHER_BRICKS =
        registerBlockItem("brick_bordered_nether_bricks", ModBlocks.BRICK_BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CURLY_NETHER_BRICKS_PILLAR =
        registerBlockItem("curly_nether_bricks_pillar", ModBlocks.CURLY_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_NETHER_BRICKS_COLUMN =
        registerBlockItem("cut_nether_bricks_column", ModBlocks.CUT_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_NETHER_BRICKS_BRICKS =
        registerBlockItem("edged_nether_bricks_bricks", ModBlocks.EDGED_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_NETHER_BRICKS_PILLAR =
        registerBlockItem("fine_nether_bricks_pillar", ModBlocks.FINE_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_NETHER_BRICKS_BRICKS =
        registerBlockItem("massive_nether_bricks_bricks", ModBlocks.MASSIVE_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_NETHER_BRICKS_PILLAR =
        registerBlockItem("ornate_nether_bricks_pillar", ModBlocks.ORNATE_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_NETHER_BRICKS_TILES =
        registerBlockItem("overlapping_nether_bricks_tiles", ModBlocks.OVERLAPPING_NETHER_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_NETHER_BRICKS =
        registerBlockItem("polished_nether_bricks", ModBlocks.POLISHED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_NETHER_BRICKS_PILLAR =
        registerBlockItem("simple_nether_bricks_pillar", ModBlocks.SIMPLE_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_NETHER_BRICKS_COLUMN =
        registerBlockItem("smooth_nether_bricks_column", ModBlocks.SMOOTH_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_NETHER_BRICKS =
        registerBlockItem("thick_inlayed_nether_bricks", ModBlocks.THICK_INLAYED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_NETHER_BRICKS =
        registerBlockItem("tiled_bordered_nether_bricks", ModBlocks.TILED_BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_NETHER_BRICKS_COLUMN =
        registerBlockItem("tiled_nether_bricks_column", ModBlocks.TILED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_NETHER_BRICKS =
        registerBlockItem("tiny_brick_bordered_nether_bricks", ModBlocks.TINY_BRICK_BORDERED_NETHER_BRICKS);

    // ── Oak Glass ──
    public static final DeferredHolder<Item, BlockItem> OAK_BORDERED_GLASS =
        registerBlockItem("oak_bordered_glass", ModBlocks.OAK_BORDERED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_DIAMOND_BORDERED_GLASS =
        registerBlockItem("oak_diamond_bordered_glass", ModBlocks.OAK_DIAMOND_BORDERED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_HORIZONTAL_LINED_GLASS =
        registerBlockItem("oak_horizontal_lined_glass", ModBlocks.OAK_HORIZONTAL_LINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_LARGE_DIAMOND_GLASS =
        registerBlockItem("oak_large_diamond_glass", ModBlocks.OAK_LARGE_DIAMOND_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_LINE_BARED_GLASS =
        registerBlockItem("oak_line_bared_glass", ModBlocks.OAK_LINE_BARED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_ORNATE_BARED_GLASS =
        registerBlockItem("oak_ornate_bared_glass", ModBlocks.OAK_ORNATE_BARED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_WOVEN_GLASS =
        registerBlockItem("oak_woven_glass", ModBlocks.OAK_WOVEN_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_OAK_GLASS =
        registerBlockItem("square_oak_glass", ModBlocks.SQUARE_OAK_GLASS);

    // ── Oak Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_OAK_PLANKS =
        registerBlockItem("cornered_oak_planks", ModBlocks.CORNERED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_OAK_PLANKS =
        registerBlockItem("crated_oak_planks", ModBlocks.CRATED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_OAK_PLANKS =
        registerBlockItem("enclosed_oak_planks", ModBlocks.ENCLOSED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_OAK_PLANKS =
        registerBlockItem("framed_oak_planks", ModBlocks.FRAMED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_OAK_PLANKS =
        registerBlockItem("natural_oak_planks", ModBlocks.NATURAL_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_PANEL =
        registerBlockItem("oak_planks_panel", ModBlocks.OAK_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> PEGGED_OAK_PLANKS =
        registerBlockItem("pegged_oak_planks", ModBlocks.PEGGED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_OAK_PLANKS =
        registerBlockItem("whirlwind_oak_planks", ModBlocks.WHIRLWIND_OAK_PLANKS);

    // ── Obsidian ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_OBSIDIAN =
        registerBlockItem("bordered_obsidian", ModBlocks.BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_OBSIDIAN =
        registerBlockItem("brick_bordered_obsidian", ModBlocks.BRICK_BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> CURLY_OBSIDIAN_PILLAR =
        registerBlockItem("curly_obsidian_pillar", ModBlocks.CURLY_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_OBSIDIAN_COLUMN =
        registerBlockItem("cut_obsidian_column", ModBlocks.CUT_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_OBSIDIAN_BRICKS =
        registerBlockItem("edged_obsidian_bricks", ModBlocks.EDGED_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_OBSIDIAN_PILLAR =
        registerBlockItem("fine_obsidian_pillar", ModBlocks.FINE_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_OBSIDIAN_BRICKS =
        registerBlockItem("massive_obsidian_bricks", ModBlocks.MASSIVE_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_OBSIDIAN_PILLAR =
        registerBlockItem("ornate_obsidian_pillar", ModBlocks.ORNATE_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_OBSIDIAN_TILES =
        registerBlockItem("overlapping_obsidian_tiles", ModBlocks.OVERLAPPING_OBSIDIAN_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_OBSIDIAN =
        registerBlockItem("polished_obsidian", ModBlocks.POLISHED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_OBSIDIAN_PILLAR =
        registerBlockItem("simple_obsidian_pillar", ModBlocks.SIMPLE_OBSIDIAN_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_OBSIDIAN_COLUMN =
        registerBlockItem("smooth_obsidian_column", ModBlocks.SMOOTH_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_OBSIDIAN =
        registerBlockItem("thick_inlayed_obsidian", ModBlocks.THICK_INLAYED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_OBSIDIAN =
        registerBlockItem("tiled_bordered_obsidian", ModBlocks.TILED_BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TILED_OBSIDIAN_COLUMN =
        registerBlockItem("tiled_obsidian_column", ModBlocks.TILED_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_OBSIDIAN =
        registerBlockItem("tiny_brick_bordered_obsidian", ModBlocks.TINY_BRICK_BORDERED_OBSIDIAN);

    // ── Orange Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_ORANGE_CONCRETE =
        registerBlockItem("grill_orange_concrete", ModBlocks.GRILL_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_CONCRETE_PANEL =
        registerBlockItem("orange_concrete_panel", ModBlocks.ORANGE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> ORANGE_CONCRETE_PILLAR =
        registerBlockItem("orange_concrete_pillar", ModBlocks.ORANGE_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PEGGED_ORANGE_CONCRETE =
        registerBlockItem("pegged_orange_concrete", ModBlocks.PEGGED_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ORANGE_CONCRETE =
        registerBlockItem("smooth_orange_concrete", ModBlocks.SMOOTH_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_ORANGE_CONCRETE =
        registerBlockItem("striped_orange_concrete", ModBlocks.STRIPED_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_ORANGE_CONCRETE =
        registerBlockItem("wired_orange_concrete", ModBlocks.WIRED_ORANGE_CONCRETE);

    // ── Orange Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_ORANGE_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_orange_stained_glass_pillar", ModBlocks.ARCHED_ORANGE_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_ORANGE_STAINED_GLASS =
        registerBlockItem("fancy_orange_stained_glass", ModBlocks.FANCY_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ORANGE_STAINED_GLASS =
        registerBlockItem("ornate_orange_stained_glass", ModBlocks.ORNATE_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_ORANGE_STAINED_GLASS =
        registerBlockItem("raster_orange_stained_glass", ModBlocks.RASTER_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_STAINED_GLASS =
        registerBlockItem("small_orange_stained_glass", ModBlocks.SMALL_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_ORANGE_STAINED_GLASS =
        registerBlockItem("tiled_orange_stained_glass", ModBlocks.TILED_ORANGE_STAINED_GLASS);

    // ── Orange Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_ORANGE_TERRACOTTA =
        registerBlockItem("circular_orange_terracotta", ModBlocks.CIRCULAR_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_ORANGE_TERRACOTTA =
        registerBlockItem("curled_orange_terracotta", ModBlocks.CURLED_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_ORANGE_TERRACOTTA =
        registerBlockItem("hexagonical_orange_terracotta", ModBlocks.HEXAGONICAL_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_ORANGE_TERRACOTTA =
        registerBlockItem("inscribed_orange_terracotta", ModBlocks.INSCRIBED_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> ORANGE_TERRACOTTA_COLUMN =
        registerBlockItem("orange_terracotta_column", ModBlocks.ORANGE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> ORANGE_TERRACOTTA_PILLAR =
        registerBlockItem("orange_terracotta_pillar", ModBlocks.ORANGE_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_TERRACOTTA_TILES =
        registerBlockItem("small_orange_terracotta_tiles", ModBlocks.SMALL_ORANGE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_ORANGE_TERRACOTTA =
        registerBlockItem("starry_orange_terracotta", ModBlocks.STARRY_ORANGE_TERRACOTTA);

    // ── Orange Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_ORANGE_WOOL =
        registerBlockItem("cornered_orange_wool", ModBlocks.CORNERED_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_ORANGE_WOOL =
        registerBlockItem("crafted_orange_wool", ModBlocks.CRAFTED_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_ORANGE_WOOL =
        registerBlockItem("harsh_quilted_orange_wool", ModBlocks.HARSH_QUILTED_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_ORANGE_WOOL =
        registerBlockItem("rectangle_orange_wool", ModBlocks.RECTANGLE_ORANGE_WOOL);

    // ── Packed Ice ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_PACKED_ICE =
        registerBlockItem("bordered_packed_ice", ModBlocks.BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PACKED_ICE =
        registerBlockItem("brick_bordered_packed_ice", ModBlocks.BRICK_BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> CURLY_PACKED_ICE_PILLAR =
        registerBlockItem("curly_packed_ice_pillar", ModBlocks.CURLY_PACKED_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_PACKED_ICE_COLUMN =
        registerBlockItem("cut_packed_ice_column", ModBlocks.CUT_PACKED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_PACKED_ICE_BRICKS =
        registerBlockItem("edged_packed_ice_bricks", ModBlocks.EDGED_PACKED_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_PACKED_ICE_PILLAR =
        registerBlockItem("fine_packed_ice_pillar", ModBlocks.FINE_PACKED_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PACKED_ICE_BRICKS =
        registerBlockItem("massive_packed_ice_bricks", ModBlocks.MASSIVE_PACKED_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PACKED_ICE_PILLAR =
        registerBlockItem("ornate_packed_ice_pillar", ModBlocks.ORNATE_PACKED_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PACKED_ICE_TILES =
        registerBlockItem("overlapping_packed_ice_tiles", ModBlocks.OVERLAPPING_PACKED_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_PACKED_ICE =
        registerBlockItem("polished_packed_ice", ModBlocks.POLISHED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PACKED_ICE_PILLAR =
        registerBlockItem("simple_packed_ice_pillar", ModBlocks.SIMPLE_PACKED_ICE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PACKED_ICE_COLUMN =
        registerBlockItem("smooth_packed_ice_column", ModBlocks.SMOOTH_PACKED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_PACKED_ICE =
        registerBlockItem("thick_inlayed_packed_ice", ModBlocks.THICK_INLAYED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PACKED_ICE =
        registerBlockItem("tiled_bordered_packed_ice", ModBlocks.TILED_BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_PACKED_ICE_COLUMN =
        registerBlockItem("tiled_packed_ice_column", ModBlocks.TILED_PACKED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_PACKED_ICE =
        registerBlockItem("tiny_brick_bordered_packed_ice", ModBlocks.TINY_BRICK_BORDERED_PACKED_ICE);

    // ── Packed Mud ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_PACKED_MUD =
        registerBlockItem("bordered_packed_mud", ModBlocks.BORDERED_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PACKED_MUD =
        registerBlockItem("brick_bordered_packed_mud", ModBlocks.BRICK_BORDERED_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> CARVED_PACKED_MUD_PILLAR =
        registerBlockItem("carved_packed_mud_pillar", ModBlocks.CARVED_PACKED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CURLY_PACKED_MUD_PILLAR =
        registerBlockItem("curly_packed_mud_pillar", ModBlocks.CURLY_PACKED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> EDGED_PACKED_MUD_BRICKS =
        registerBlockItem("edged_packed_mud_bricks", ModBlocks.EDGED_PACKED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FANCY_PACKED_MUD_PILLAR =
        registerBlockItem("fancy_packed_mud_pillar", ModBlocks.FANCY_PACKED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FINE_PACKED_MUD_PILLAR =
        registerBlockItem("fine_packed_mud_pillar", ModBlocks.FINE_PACKED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> HARD_PACKED_MUD =
        registerBlockItem("hard_packed_mud", ModBlocks.HARD_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> LARGE_PACKED_MUD_SIGIL =
        registerBlockItem("large_packed_mud_sigil", ModBlocks.LARGE_PACKED_MUD_SIGIL);
    public static final DeferredHolder<Item, BlockItem> LOREFUL_PACKED_MUD =
        registerBlockItem("loreful_packed_mud", ModBlocks.LOREFUL_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PACKED_MUD_BRICKS =
        registerBlockItem("massive_packed_mud_bricks", ModBlocks.MASSIVE_PACKED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PACKED_MUD_PILLAR =
        registerBlockItem("ornate_packed_mud_pillar", ModBlocks.ORNATE_PACKED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PACKED_MUD_TILES =
        registerBlockItem("overlapping_packed_mud_tiles", ModBlocks.OVERLAPPING_PACKED_MUD_TILES);
    public static final DeferredHolder<Item, BlockItem> SCALY_PACKED_MUD =
        registerBlockItem("scaly_packed_mud", ModBlocks.SCALY_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PACKED_MUD_PILLAR =
        registerBlockItem("simple_packed_mud_pillar", ModBlocks.SIMPLE_PACKED_MUD_PILLAR);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PACKED_MUD =
        registerBlockItem("tiled_bordered_packed_mud", ModBlocks.TILED_BORDERED_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> TILED_PACKED_MUD_COLUMN =
        registerBlockItem("tiled_packed_mud_column", ModBlocks.TILED_PACKED_MUD_COLUMN);

    // ── Pink Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_PINK_CONCRETE =
        registerBlockItem("grill_pink_concrete", ModBlocks.GRILL_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_PINK_CONCRETE =
        registerBlockItem("pegged_pink_concrete", ModBlocks.PEGGED_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PINK_CONCRETE_PANEL =
        registerBlockItem("pink_concrete_panel", ModBlocks.PINK_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> PINK_CONCRETE_PILLAR =
        registerBlockItem("pink_concrete_pillar", ModBlocks.PINK_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PINK_CONCRETE =
        registerBlockItem("smooth_pink_concrete", ModBlocks.SMOOTH_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_PINK_CONCRETE =
        registerBlockItem("striped_pink_concrete", ModBlocks.STRIPED_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_PINK_CONCRETE =
        registerBlockItem("wired_pink_concrete", ModBlocks.WIRED_PINK_CONCRETE);

    // ── Pink Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_PINK_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_pink_stained_glass_pillar", ModBlocks.ARCHED_PINK_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_PINK_STAINED_GLASS =
        registerBlockItem("fancy_pink_stained_glass", ModBlocks.FANCY_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PINK_STAINED_GLASS =
        registerBlockItem("ornate_pink_stained_glass", ModBlocks.ORNATE_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_PINK_STAINED_GLASS =
        registerBlockItem("raster_pink_stained_glass", ModBlocks.RASTER_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_STAINED_GLASS =
        registerBlockItem("small_pink_stained_glass", ModBlocks.SMALL_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_PINK_STAINED_GLASS =
        registerBlockItem("tiled_pink_stained_glass", ModBlocks.TILED_PINK_STAINED_GLASS);

    // ── Pink Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PINK_TERRACOTTA =
        registerBlockItem("circular_pink_terracotta", ModBlocks.CIRCULAR_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_PINK_TERRACOTTA =
        registerBlockItem("curled_pink_terracotta", ModBlocks.CURLED_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_PINK_TERRACOTTA =
        registerBlockItem("hexagonical_pink_terracotta", ModBlocks.HEXAGONICAL_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_PINK_TERRACOTTA =
        registerBlockItem("inscribed_pink_terracotta", ModBlocks.INSCRIBED_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> PINK_TERRACOTTA_COLUMN =
        registerBlockItem("pink_terracotta_column", ModBlocks.PINK_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> PINK_TERRACOTTA_PILLAR =
        registerBlockItem("pink_terracotta_pillar", ModBlocks.PINK_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_TERRACOTTA_TILES =
        registerBlockItem("small_pink_terracotta_tiles", ModBlocks.SMALL_PINK_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_PINK_TERRACOTTA =
        registerBlockItem("starry_pink_terracotta", ModBlocks.STARRY_PINK_TERRACOTTA);

    // ── Pink Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_PINK_WOOL =
        registerBlockItem("cornered_pink_wool", ModBlocks.CORNERED_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_PINK_WOOL =
        registerBlockItem("crafted_pink_wool", ModBlocks.CRAFTED_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_PINK_WOOL =
        registerBlockItem("harsh_quilted_pink_wool", ModBlocks.HARSH_QUILTED_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_PINK_WOOL =
        registerBlockItem("rectangle_pink_wool", ModBlocks.RECTANGLE_PINK_WOOL);

    // ── Prismarine ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_PRISMARINE =
        registerBlockItem("bordered_prismarine", ModBlocks.BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PRISMARINE =
        registerBlockItem("brick_bordered_prismarine", ModBlocks.BRICK_BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> CURLY_PRISMARINE_PILLAR =
        registerBlockItem("curly_prismarine_pillar", ModBlocks.CURLY_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_PRISMARINE_COLUMN =
        registerBlockItem("cut_prismarine_column", ModBlocks.CUT_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_PRISMARINE_BRICKS =
        registerBlockItem("edged_prismarine_bricks", ModBlocks.EDGED_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_PRISMARINE_PILLAR =
        registerBlockItem("fine_prismarine_pillar", ModBlocks.FINE_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PRISMARINE_BRICKS =
        registerBlockItem("massive_prismarine_bricks", ModBlocks.MASSIVE_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PRISMARINE_PILLAR =
        registerBlockItem("ornate_prismarine_pillar", ModBlocks.ORNATE_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PRISMARINE_TILES =
        registerBlockItem("overlapping_prismarine_tiles", ModBlocks.OVERLAPPING_PRISMARINE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_PRISMARINE =
        registerBlockItem("polished_prismarine", ModBlocks.POLISHED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PRISMARINE_PILLAR =
        registerBlockItem("simple_prismarine_pillar", ModBlocks.SIMPLE_PRISMARINE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PRISMARINE_COLUMN =
        registerBlockItem("smooth_prismarine_column", ModBlocks.SMOOTH_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_PRISMARINE =
        registerBlockItem("thick_inlayed_prismarine", ModBlocks.THICK_INLAYED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PRISMARINE =
        registerBlockItem("tiled_bordered_prismarine", ModBlocks.TILED_BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TILED_PRISMARINE_COLUMN =
        registerBlockItem("tiled_prismarine_column", ModBlocks.TILED_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_PRISMARINE =
        registerBlockItem("tiny_brick_bordered_prismarine", ModBlocks.TINY_BRICK_BORDERED_PRISMARINE);

    // ── Purple Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_PURPLE_CONCRETE =
        registerBlockItem("grill_purple_concrete", ModBlocks.GRILL_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_PURPLE_CONCRETE =
        registerBlockItem("pegged_purple_concrete", ModBlocks.PEGGED_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_CONCRETE_PANEL =
        registerBlockItem("purple_concrete_panel", ModBlocks.PURPLE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> PURPLE_CONCRETE_PILLAR =
        registerBlockItem("purple_concrete_pillar", ModBlocks.PURPLE_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PURPLE_CONCRETE =
        registerBlockItem("smooth_purple_concrete", ModBlocks.SMOOTH_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_PURPLE_CONCRETE =
        registerBlockItem("striped_purple_concrete", ModBlocks.STRIPED_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_PURPLE_CONCRETE =
        registerBlockItem("wired_purple_concrete", ModBlocks.WIRED_PURPLE_CONCRETE);

    // ── Purple Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_PURPLE_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_purple_stained_glass_pillar", ModBlocks.ARCHED_PURPLE_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_PURPLE_STAINED_GLASS =
        registerBlockItem("fancy_purple_stained_glass", ModBlocks.FANCY_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPLE_STAINED_GLASS =
        registerBlockItem("ornate_purple_stained_glass", ModBlocks.ORNATE_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_PURPLE_STAINED_GLASS =
        registerBlockItem("raster_purple_stained_glass", ModBlocks.RASTER_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_STAINED_GLASS =
        registerBlockItem("small_purple_stained_glass", ModBlocks.SMALL_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPLE_STAINED_GLASS =
        registerBlockItem("tiled_purple_stained_glass", ModBlocks.TILED_PURPLE_STAINED_GLASS);

    // ── Purple Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PURPLE_TERRACOTTA =
        registerBlockItem("circular_purple_terracotta", ModBlocks.CIRCULAR_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_PURPLE_TERRACOTTA =
        registerBlockItem("curled_purple_terracotta", ModBlocks.CURLED_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_PURPLE_TERRACOTTA =
        registerBlockItem("hexagonical_purple_terracotta", ModBlocks.HEXAGONICAL_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_PURPLE_TERRACOTTA =
        registerBlockItem("inscribed_purple_terracotta", ModBlocks.INSCRIBED_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> PURPLE_TERRACOTTA_COLUMN =
        registerBlockItem("purple_terracotta_column", ModBlocks.PURPLE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> PURPLE_TERRACOTTA_PILLAR =
        registerBlockItem("purple_terracotta_pillar", ModBlocks.PURPLE_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_TERRACOTTA_TILES =
        registerBlockItem("small_purple_terracotta_tiles", ModBlocks.SMALL_PURPLE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_PURPLE_TERRACOTTA =
        registerBlockItem("starry_purple_terracotta", ModBlocks.STARRY_PURPLE_TERRACOTTA);

    // ── Purple Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_PURPLE_WOOL =
        registerBlockItem("cornered_purple_wool", ModBlocks.CORNERED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_PURPLE_WOOL =
        registerBlockItem("crafted_purple_wool", ModBlocks.CRAFTED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_PURPLE_WOOL =
        registerBlockItem("harsh_quilted_purple_wool", ModBlocks.HARSH_QUILTED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_PURPLE_WOOL =
        registerBlockItem("rectangle_purple_wool", ModBlocks.RECTANGLE_PURPLE_WOOL);

    // ── Purpur Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_PURPUR_BLOCK =
        registerBlockItem("bordered_purpur_block", ModBlocks.BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PURPUR_BLOCK =
        registerBlockItem("brick_bordered_purpur_block", ModBlocks.BRICK_BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_PURPUR_BLOCK_PILLAR =
        registerBlockItem("curly_purpur_block_pillar", ModBlocks.CURLY_PURPUR_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_PURPUR_BLOCK_COLUMN =
        registerBlockItem("cut_purpur_block_column", ModBlocks.CUT_PURPUR_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_PURPUR_BLOCK_BRICKS =
        registerBlockItem("edged_purpur_block_bricks", ModBlocks.EDGED_PURPUR_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_PURPUR_BLOCK_PILLAR =
        registerBlockItem("fine_purpur_block_pillar", ModBlocks.FINE_PURPUR_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PURPUR_BLOCK_BRICKS =
        registerBlockItem("massive_purpur_block_bricks", ModBlocks.MASSIVE_PURPUR_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPUR_BLOCK_PILLAR =
        registerBlockItem("ornate_purpur_block_pillar", ModBlocks.ORNATE_PURPUR_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PURPUR_BLOCK_TILES =
        registerBlockItem("overlapping_purpur_block_tiles", ModBlocks.OVERLAPPING_PURPUR_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_PURPUR_BLOCK =
        registerBlockItem("polished_purpur_block", ModBlocks.POLISHED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PURPUR_BLOCK_PILLAR =
        registerBlockItem("simple_purpur_block_pillar", ModBlocks.SIMPLE_PURPUR_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PURPUR_BLOCK_COLUMN =
        registerBlockItem("smooth_purpur_block_column", ModBlocks.SMOOTH_PURPUR_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_PURPUR_BLOCK =
        registerBlockItem("thick_inlayed_purpur_block", ModBlocks.THICK_INLAYED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PURPUR_BLOCK =
        registerBlockItem("tiled_bordered_purpur_block", ModBlocks.TILED_BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPUR_BLOCK_COLUMN =
        registerBlockItem("tiled_purpur_block_column", ModBlocks.TILED_PURPUR_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_PURPUR_BLOCK =
        registerBlockItem("tiny_brick_bordered_purpur_block", ModBlocks.TINY_BRICK_BORDERED_PURPUR_BLOCK);

    // ── Quartz Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_QUARTZ_BLOCK =
        registerBlockItem("bordered_quartz_block", ModBlocks.BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_QUARTZ_BLOCK =
        registerBlockItem("brick_bordered_quartz_block", ModBlocks.BRICK_BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_QUARTZ_BLOCK_PILLAR =
        registerBlockItem("curly_quartz_block_pillar", ModBlocks.CURLY_QUARTZ_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_QUARTZ_BLOCK_COLUMN =
        registerBlockItem("cut_quartz_block_column", ModBlocks.CUT_QUARTZ_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_QUARTZ_BLOCK_BRICKS =
        registerBlockItem("edged_quartz_block_bricks", ModBlocks.EDGED_QUARTZ_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_QUARTZ_BLOCK_PILLAR =
        registerBlockItem("fine_quartz_block_pillar", ModBlocks.FINE_QUARTZ_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_QUARTZ_BLOCK_BRICKS =
        registerBlockItem("massive_quartz_block_bricks", ModBlocks.MASSIVE_QUARTZ_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_QUARTZ_BLOCK_PILLAR =
        registerBlockItem("ornate_quartz_block_pillar", ModBlocks.ORNATE_QUARTZ_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_QUARTZ_BLOCK_TILES =
        registerBlockItem("overlapping_quartz_block_tiles", ModBlocks.OVERLAPPING_QUARTZ_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_QUARTZ_BLOCK =
        registerBlockItem("polished_quartz_block", ModBlocks.POLISHED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_QUARTZ_BLOCK_PILLAR =
        registerBlockItem("simple_quartz_block_pillar", ModBlocks.SIMPLE_QUARTZ_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_QUARTZ_BLOCK_COLUMN =
        registerBlockItem("smooth_quartz_block_column", ModBlocks.SMOOTH_QUARTZ_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_QUARTZ_BLOCK =
        registerBlockItem("thick_inlayed_quartz_block", ModBlocks.THICK_INLAYED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_QUARTZ_BLOCK =
        registerBlockItem("tiled_bordered_quartz_block", ModBlocks.TILED_BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_QUARTZ_BLOCK_COLUMN =
        registerBlockItem("tiled_quartz_block_column", ModBlocks.TILED_QUARTZ_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_QUARTZ_BLOCK =
        registerBlockItem("tiny_brick_bordered_quartz_block", ModBlocks.TINY_BRICK_BORDERED_QUARTZ_BLOCK);

    // ── Raw Copper Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("bordered_raw_copper_block", ModBlocks.BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("brick_bordered_raw_copper_block", ModBlocks.BRICK_BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_RAW_COPPER_BLOCK_PILLAR =
        registerBlockItem("curly_raw_copper_block_pillar", ModBlocks.CURLY_RAW_COPPER_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_RAW_COPPER_BLOCK_COLUMN =
        registerBlockItem("cut_raw_copper_block_column", ModBlocks.CUT_RAW_COPPER_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_RAW_COPPER_BLOCK_BRICKS =
        registerBlockItem("edged_raw_copper_block_bricks", ModBlocks.EDGED_RAW_COPPER_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_RAW_COPPER_BLOCK_PILLAR =
        registerBlockItem("fine_raw_copper_block_pillar", ModBlocks.FINE_RAW_COPPER_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RAW_COPPER_BLOCK_BRICKS =
        registerBlockItem("massive_raw_copper_block_bricks", ModBlocks.MASSIVE_RAW_COPPER_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RAW_COPPER_BLOCK_PILLAR =
        registerBlockItem("ornate_raw_copper_block_pillar", ModBlocks.ORNATE_RAW_COPPER_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RAW_COPPER_BLOCK_TILES =
        registerBlockItem("overlapping_raw_copper_block_tiles", ModBlocks.OVERLAPPING_RAW_COPPER_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RAW_COPPER_BLOCK =
        registerBlockItem("polished_raw_copper_block", ModBlocks.POLISHED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RAW_COPPER_BLOCK_PILLAR =
        registerBlockItem("simple_raw_copper_block_pillar", ModBlocks.SIMPLE_RAW_COPPER_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RAW_COPPER_BLOCK_COLUMN =
        registerBlockItem("smooth_raw_copper_block_column", ModBlocks.SMOOTH_RAW_COPPER_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RAW_COPPER_BLOCK =
        registerBlockItem("thick_inlayed_raw_copper_block", ModBlocks.THICK_INLAYED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("tiled_bordered_raw_copper_block", ModBlocks.TILED_BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_RAW_COPPER_BLOCK_COLUMN =
        registerBlockItem("tiled_raw_copper_block_column", ModBlocks.TILED_RAW_COPPER_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("tiny_brick_bordered_raw_copper_block", ModBlocks.TINY_BRICK_BORDERED_RAW_COPPER_BLOCK);

    // ── Raw Gold Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("bordered_raw_gold_block", ModBlocks.BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("brick_bordered_raw_gold_block", ModBlocks.BRICK_BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_RAW_GOLD_BLOCK_PILLAR =
        registerBlockItem("curly_raw_gold_block_pillar", ModBlocks.CURLY_RAW_GOLD_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_RAW_GOLD_BLOCK_COLUMN =
        registerBlockItem("cut_raw_gold_block_column", ModBlocks.CUT_RAW_GOLD_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_RAW_GOLD_BLOCK_BRICKS =
        registerBlockItem("edged_raw_gold_block_bricks", ModBlocks.EDGED_RAW_GOLD_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_RAW_GOLD_BLOCK_PILLAR =
        registerBlockItem("fine_raw_gold_block_pillar", ModBlocks.FINE_RAW_GOLD_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RAW_GOLD_BLOCK_BRICKS =
        registerBlockItem("massive_raw_gold_block_bricks", ModBlocks.MASSIVE_RAW_GOLD_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RAW_GOLD_BLOCK_PILLAR =
        registerBlockItem("ornate_raw_gold_block_pillar", ModBlocks.ORNATE_RAW_GOLD_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RAW_GOLD_BLOCK_TILES =
        registerBlockItem("overlapping_raw_gold_block_tiles", ModBlocks.OVERLAPPING_RAW_GOLD_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RAW_GOLD_BLOCK =
        registerBlockItem("polished_raw_gold_block", ModBlocks.POLISHED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RAW_GOLD_BLOCK_PILLAR =
        registerBlockItem("simple_raw_gold_block_pillar", ModBlocks.SIMPLE_RAW_GOLD_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RAW_GOLD_BLOCK_COLUMN =
        registerBlockItem("smooth_raw_gold_block_column", ModBlocks.SMOOTH_RAW_GOLD_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RAW_GOLD_BLOCK =
        registerBlockItem("thick_inlayed_raw_gold_block", ModBlocks.THICK_INLAYED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("tiled_bordered_raw_gold_block", ModBlocks.TILED_BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_RAW_GOLD_BLOCK_COLUMN =
        registerBlockItem("tiled_raw_gold_block_column", ModBlocks.TILED_RAW_GOLD_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("tiny_brick_bordered_raw_gold_block", ModBlocks.TINY_BRICK_BORDERED_RAW_GOLD_BLOCK);

    // ── Raw Iron Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("bordered_raw_iron_block", ModBlocks.BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("brick_bordered_raw_iron_block", ModBlocks.BRICK_BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_RAW_IRON_BLOCK_PILLAR =
        registerBlockItem("curly_raw_iron_block_pillar", ModBlocks.CURLY_RAW_IRON_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_RAW_IRON_BLOCK_COLUMN =
        registerBlockItem("cut_raw_iron_block_column", ModBlocks.CUT_RAW_IRON_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_RAW_IRON_BLOCK_BRICKS =
        registerBlockItem("edged_raw_iron_block_bricks", ModBlocks.EDGED_RAW_IRON_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_RAW_IRON_BLOCK_PILLAR =
        registerBlockItem("fine_raw_iron_block_pillar", ModBlocks.FINE_RAW_IRON_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RAW_IRON_BLOCK_BRICKS =
        registerBlockItem("massive_raw_iron_block_bricks", ModBlocks.MASSIVE_RAW_IRON_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RAW_IRON_BLOCK_PILLAR =
        registerBlockItem("ornate_raw_iron_block_pillar", ModBlocks.ORNATE_RAW_IRON_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RAW_IRON_BLOCK_TILES =
        registerBlockItem("overlapping_raw_iron_block_tiles", ModBlocks.OVERLAPPING_RAW_IRON_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RAW_IRON_BLOCK =
        registerBlockItem("polished_raw_iron_block", ModBlocks.POLISHED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RAW_IRON_BLOCK_PILLAR =
        registerBlockItem("simple_raw_iron_block_pillar", ModBlocks.SIMPLE_RAW_IRON_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RAW_IRON_BLOCK_COLUMN =
        registerBlockItem("smooth_raw_iron_block_column", ModBlocks.SMOOTH_RAW_IRON_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RAW_IRON_BLOCK =
        registerBlockItem("thick_inlayed_raw_iron_block", ModBlocks.THICK_INLAYED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("tiled_bordered_raw_iron_block", ModBlocks.TILED_BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_RAW_IRON_BLOCK_COLUMN =
        registerBlockItem("tiled_raw_iron_block_column", ModBlocks.TILED_RAW_IRON_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("tiny_brick_bordered_raw_iron_block", ModBlocks.TINY_BRICK_BORDERED_RAW_IRON_BLOCK);

    // ── Redstone Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_REDSTONE_BLOCK =
        registerBlockItem("bordered_redstone_block", ModBlocks.BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_REDSTONE_BLOCK =
        registerBlockItem("brick_bordered_redstone_block", ModBlocks.BRICK_BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_REDSTONE_BLOCK_PILLAR =
        registerBlockItem("curly_redstone_block_pillar", ModBlocks.CURLY_REDSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_REDSTONE_BLOCK_COLUMN =
        registerBlockItem("cut_redstone_block_column", ModBlocks.CUT_REDSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_REDSTONE_BLOCK_BRICKS =
        registerBlockItem("edged_redstone_block_bricks", ModBlocks.EDGED_REDSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_REDSTONE_BLOCK_PILLAR =
        registerBlockItem("fine_redstone_block_pillar", ModBlocks.FINE_REDSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_REDSTONE_BLOCK_BRICKS =
        registerBlockItem("massive_redstone_block_bricks", ModBlocks.MASSIVE_REDSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_REDSTONE_BLOCK_PILLAR =
        registerBlockItem("ornate_redstone_block_pillar", ModBlocks.ORNATE_REDSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_REDSTONE_BLOCK_TILES =
        registerBlockItem("overlapping_redstone_block_tiles", ModBlocks.OVERLAPPING_REDSTONE_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_REDSTONE_BLOCK =
        registerBlockItem("polished_redstone_block", ModBlocks.POLISHED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_REDSTONE_BLOCK_PILLAR =
        registerBlockItem("simple_redstone_block_pillar", ModBlocks.SIMPLE_REDSTONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_REDSTONE_BLOCK_COLUMN =
        registerBlockItem("smooth_redstone_block_column", ModBlocks.SMOOTH_REDSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_REDSTONE_BLOCK =
        registerBlockItem("thick_inlayed_redstone_block", ModBlocks.THICK_INLAYED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_REDSTONE_BLOCK =
        registerBlockItem("tiled_bordered_redstone_block", ModBlocks.TILED_BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_REDSTONE_BLOCK_COLUMN =
        registerBlockItem("tiled_redstone_block_column", ModBlocks.TILED_REDSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_REDSTONE_BLOCK =
        registerBlockItem("tiny_brick_bordered_redstone_block", ModBlocks.TINY_BRICK_BORDERED_REDSTONE_BLOCK);

    // ── Red Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_RED_CONCRETE =
        registerBlockItem("grill_red_concrete", ModBlocks.GRILL_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_RED_CONCRETE =
        registerBlockItem("pegged_red_concrete", ModBlocks.PEGGED_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> RED_CONCRETE_PANEL =
        registerBlockItem("red_concrete_panel", ModBlocks.RED_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> RED_CONCRETE_PILLAR =
        registerBlockItem("red_concrete_pillar", ModBlocks.RED_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_CONCRETE =
        registerBlockItem("smooth_red_concrete", ModBlocks.SMOOTH_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_RED_CONCRETE =
        registerBlockItem("striped_red_concrete", ModBlocks.STRIPED_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_RED_CONCRETE =
        registerBlockItem("wired_red_concrete", ModBlocks.WIRED_RED_CONCRETE);

    // ── Red Nether Bricks ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("bordered_red_nether_bricks", ModBlocks.BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("brick_bordered_red_nether_bricks", ModBlocks.BRICK_BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CURLY_RED_NETHER_BRICKS_PILLAR =
        registerBlockItem("curly_red_nether_bricks_pillar", ModBlocks.CURLY_RED_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_RED_NETHER_BRICKS_COLUMN =
        registerBlockItem("cut_red_nether_bricks_column", ModBlocks.CUT_RED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_RED_NETHER_BRICKS_BRICKS =
        registerBlockItem("edged_red_nether_bricks_bricks", ModBlocks.EDGED_RED_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_RED_NETHER_BRICKS_PILLAR =
        registerBlockItem("fine_red_nether_bricks_pillar", ModBlocks.FINE_RED_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RED_NETHER_BRICKS_BRICKS =
        registerBlockItem("massive_red_nether_bricks_bricks", ModBlocks.MASSIVE_RED_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_NETHER_BRICKS_PILLAR =
        registerBlockItem("ornate_red_nether_bricks_pillar", ModBlocks.ORNATE_RED_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RED_NETHER_BRICKS_TILES =
        registerBlockItem("overlapping_red_nether_bricks_tiles", ModBlocks.OVERLAPPING_RED_NETHER_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RED_NETHER_BRICKS =
        registerBlockItem("polished_red_nether_bricks", ModBlocks.POLISHED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RED_NETHER_BRICKS_PILLAR =
        registerBlockItem("simple_red_nether_bricks_pillar", ModBlocks.SIMPLE_RED_NETHER_BRICKS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_NETHER_BRICKS_COLUMN =
        registerBlockItem("smooth_red_nether_bricks_column", ModBlocks.SMOOTH_RED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RED_NETHER_BRICKS =
        registerBlockItem("thick_inlayed_red_nether_bricks", ModBlocks.THICK_INLAYED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("tiled_bordered_red_nether_bricks", ModBlocks.TILED_BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_NETHER_BRICKS_COLUMN =
        registerBlockItem("tiled_red_nether_bricks_column", ModBlocks.TILED_RED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("tiny_brick_bordered_red_nether_bricks", ModBlocks.TINY_BRICK_BORDERED_RED_NETHER_BRICKS);

    // ── Red Sandstone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_RED_SANDSTONE =
        registerBlockItem("bordered_red_sandstone", ModBlocks.BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RED_SANDSTONE =
        registerBlockItem("brick_bordered_red_sandstone", ModBlocks.BRICK_BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_RED_SANDSTONE_PILLAR =
        registerBlockItem("curly_red_sandstone_pillar", ModBlocks.CURLY_RED_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_RED_SANDSTONE_COLUMN =
        registerBlockItem("cut_red_sandstone_column", ModBlocks.CUT_RED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_RED_SANDSTONE_BRICKS =
        registerBlockItem("edged_red_sandstone_bricks", ModBlocks.EDGED_RED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_RED_SANDSTONE_PILLAR =
        registerBlockItem("fine_red_sandstone_pillar", ModBlocks.FINE_RED_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RED_SANDSTONE_BRICKS =
        registerBlockItem("massive_red_sandstone_bricks", ModBlocks.MASSIVE_RED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_SANDSTONE_PILLAR =
        registerBlockItem("ornate_red_sandstone_pillar", ModBlocks.ORNATE_RED_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RED_SANDSTONE_TILES =
        registerBlockItem("overlapping_red_sandstone_tiles", ModBlocks.OVERLAPPING_RED_SANDSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RED_SANDSTONE =
        registerBlockItem("polished_red_sandstone", ModBlocks.POLISHED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RED_SANDSTONE_PILLAR =
        registerBlockItem("simple_red_sandstone_pillar", ModBlocks.SIMPLE_RED_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_SANDSTONE_COLUMN =
        registerBlockItem("smooth_red_sandstone_column", ModBlocks.SMOOTH_RED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RED_SANDSTONE =
        registerBlockItem("thick_inlayed_red_sandstone", ModBlocks.THICK_INLAYED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RED_SANDSTONE =
        registerBlockItem("tiled_bordered_red_sandstone", ModBlocks.TILED_BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_SANDSTONE_COLUMN =
        registerBlockItem("tiled_red_sandstone_column", ModBlocks.TILED_RED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RED_SANDSTONE =
        registerBlockItem("tiny_brick_bordered_red_sandstone", ModBlocks.TINY_BRICK_BORDERED_RED_SANDSTONE);

    // ── Red Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_RED_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_red_stained_glass_pillar", ModBlocks.ARCHED_RED_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_RED_STAINED_GLASS =
        registerBlockItem("fancy_red_stained_glass", ModBlocks.FANCY_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_STAINED_GLASS =
        registerBlockItem("ornate_red_stained_glass", ModBlocks.ORNATE_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_RED_STAINED_GLASS =
        registerBlockItem("raster_red_stained_glass", ModBlocks.RASTER_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_STAINED_GLASS =
        registerBlockItem("small_red_stained_glass", ModBlocks.SMALL_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_STAINED_GLASS =
        registerBlockItem("tiled_red_stained_glass", ModBlocks.TILED_RED_STAINED_GLASS);

    // ── Red Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_RED_TERRACOTTA =
        registerBlockItem("circular_red_terracotta", ModBlocks.CIRCULAR_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_RED_TERRACOTTA =
        registerBlockItem("curled_red_terracotta", ModBlocks.CURLED_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_RED_TERRACOTTA =
        registerBlockItem("hexagonical_red_terracotta", ModBlocks.HEXAGONICAL_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_RED_TERRACOTTA =
        registerBlockItem("inscribed_red_terracotta", ModBlocks.INSCRIBED_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> RED_TERRACOTTA_COLUMN =
        registerBlockItem("red_terracotta_column", ModBlocks.RED_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> RED_TERRACOTTA_PILLAR =
        registerBlockItem("red_terracotta_pillar", ModBlocks.RED_TERRACOTTA_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_TERRACOTTA_TILES =
        registerBlockItem("small_red_terracotta_tiles", ModBlocks.SMALL_RED_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_RED_TERRACOTTA =
        registerBlockItem("starry_red_terracotta", ModBlocks.STARRY_RED_TERRACOTTA);

    // ── Red Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_RED_WOOL =
        registerBlockItem("cornered_red_wool", ModBlocks.CORNERED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_RED_WOOL =
        registerBlockItem("crafted_red_wool", ModBlocks.CRAFTED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_RED_WOOL =
        registerBlockItem("harsh_quilted_red_wool", ModBlocks.HARSH_QUILTED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_RED_WOOL =
        registerBlockItem("rectangle_red_wool", ModBlocks.RECTANGLE_RED_WOOL);

    // ── Sandstone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_SANDSTONE =
        registerBlockItem("bordered_sandstone", ModBlocks.BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_SANDSTONE =
        registerBlockItem("brick_bordered_sandstone", ModBlocks.BRICK_BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_SANDSTONE_PILLAR =
        registerBlockItem("curly_sandstone_pillar", ModBlocks.CURLY_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_SANDSTONE_COLUMN =
        registerBlockItem("cut_sandstone_column", ModBlocks.CUT_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_SANDSTONE_BRICKS =
        registerBlockItem("edged_sandstone_bricks", ModBlocks.EDGED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_SANDSTONE_PILLAR =
        registerBlockItem("fine_sandstone_pillar", ModBlocks.FINE_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_SANDSTONE_BRICKS =
        registerBlockItem("massive_sandstone_bricks", ModBlocks.MASSIVE_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_SANDSTONE_PILLAR =
        registerBlockItem("ornate_sandstone_pillar", ModBlocks.ORNATE_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_SANDSTONE_TILES =
        registerBlockItem("overlapping_sandstone_tiles", ModBlocks.OVERLAPPING_SANDSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_SANDSTONE =
        registerBlockItem("polished_sandstone", ModBlocks.POLISHED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_SANDSTONE_PILLAR =
        registerBlockItem("simple_sandstone_pillar", ModBlocks.SIMPLE_SANDSTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SANDSTONE_COLUMN =
        registerBlockItem("smooth_sandstone_column", ModBlocks.SMOOTH_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_SANDSTONE =
        registerBlockItem("thick_inlayed_sandstone", ModBlocks.THICK_INLAYED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_SANDSTONE =
        registerBlockItem("tiled_bordered_sandstone", ModBlocks.TILED_BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_SANDSTONE_COLUMN =
        registerBlockItem("tiled_sandstone_column", ModBlocks.TILED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_SANDSTONE =
        registerBlockItem("tiny_brick_bordered_sandstone", ModBlocks.TINY_BRICK_BORDERED_SANDSTONE);

    // ── Smooth Stone ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_SMOOTH_STONE =
        registerBlockItem("bordered_smooth_stone", ModBlocks.BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_SMOOTH_STONE =
        registerBlockItem("brick_bordered_smooth_stone", ModBlocks.BRICK_BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_SMOOTH_STONE_PILLAR =
        registerBlockItem("curly_smooth_stone_pillar", ModBlocks.CURLY_SMOOTH_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_SMOOTH_STONE_COLUMN =
        registerBlockItem("cut_smooth_stone_column", ModBlocks.CUT_SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_SMOOTH_STONE_BRICKS =
        registerBlockItem("edged_smooth_stone_bricks", ModBlocks.EDGED_SMOOTH_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_SMOOTH_STONE_PILLAR =
        registerBlockItem("fine_smooth_stone_pillar", ModBlocks.FINE_SMOOTH_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_SMOOTH_STONE_BRICKS =
        registerBlockItem("massive_smooth_stone_bricks", ModBlocks.MASSIVE_SMOOTH_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_SMOOTH_STONE_PILLAR =
        registerBlockItem("ornate_smooth_stone_pillar", ModBlocks.ORNATE_SMOOTH_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_SMOOTH_STONE_TILES =
        registerBlockItem("overlapping_smooth_stone_tiles", ModBlocks.OVERLAPPING_SMOOTH_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_SMOOTH_STONE =
        registerBlockItem("polished_smooth_stone", ModBlocks.POLISHED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_SMOOTH_STONE_PILLAR =
        registerBlockItem("simple_smooth_stone_pillar", ModBlocks.SIMPLE_SMOOTH_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SMOOTH_STONE_COLUMN =
        registerBlockItem("smooth_smooth_stone_column", ModBlocks.SMOOTH_SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_SMOOTH_STONE =
        registerBlockItem("thick_inlayed_smooth_stone", ModBlocks.THICK_INLAYED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_SMOOTH_STONE =
        registerBlockItem("tiled_bordered_smooth_stone", ModBlocks.TILED_BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_SMOOTH_STONE_COLUMN =
        registerBlockItem("tiled_smooth_stone_column", ModBlocks.TILED_SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_SMOOTH_STONE =
        registerBlockItem("tiny_brick_bordered_smooth_stone", ModBlocks.TINY_BRICK_BORDERED_SMOOTH_STONE);

    // ── Snow Block ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_SNOW_BLOCK =
        registerBlockItem("bordered_snow_block", ModBlocks.BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_SNOW_BLOCK =
        registerBlockItem("brick_bordered_snow_block", ModBlocks.BRICK_BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> CURLY_SNOW_BLOCK_PILLAR =
        registerBlockItem("curly_snow_block_pillar", ModBlocks.CURLY_SNOW_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_SNOW_BLOCK_COLUMN =
        registerBlockItem("cut_snow_block_column", ModBlocks.CUT_SNOW_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_SNOW_BLOCK_BRICKS =
        registerBlockItem("edged_snow_block_bricks", ModBlocks.EDGED_SNOW_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_SNOW_BLOCK_PILLAR =
        registerBlockItem("fine_snow_block_pillar", ModBlocks.FINE_SNOW_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_SNOW_BLOCK_BRICKS =
        registerBlockItem("massive_snow_block_bricks", ModBlocks.MASSIVE_SNOW_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_SNOW_BLOCK_PILLAR =
        registerBlockItem("ornate_snow_block_pillar", ModBlocks.ORNATE_SNOW_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_SNOW_BLOCK_TILES =
        registerBlockItem("overlapping_snow_block_tiles", ModBlocks.OVERLAPPING_SNOW_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_SNOW_BLOCK =
        registerBlockItem("polished_snow_block", ModBlocks.POLISHED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_SNOW_BLOCK_PILLAR =
        registerBlockItem("simple_snow_block_pillar", ModBlocks.SIMPLE_SNOW_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SNOW_BLOCK_COLUMN =
        registerBlockItem("smooth_snow_block_column", ModBlocks.SMOOTH_SNOW_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_SNOW_BLOCK =
        registerBlockItem("thick_inlayed_snow_block", ModBlocks.THICK_INLAYED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_SNOW_BLOCK =
        registerBlockItem("tiled_bordered_snow_block", ModBlocks.TILED_BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_SNOW_BLOCK_COLUMN =
        registerBlockItem("tiled_snow_block_column", ModBlocks.TILED_SNOW_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_SNOW_BLOCK =
        registerBlockItem("tiny_brick_bordered_snow_block", ModBlocks.TINY_BRICK_BORDERED_SNOW_BLOCK);

    // ── Spruce Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_SPRUCE_PLANKS =
        registerBlockItem("cornered_spruce_planks", ModBlocks.CORNERED_SPRUCE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_SPRUCE_PLANKS =
        registerBlockItem("crated_spruce_planks", ModBlocks.CRATED_SPRUCE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_SPRUCE_PLANKS =
        registerBlockItem("enclosed_spruce_planks", ModBlocks.ENCLOSED_SPRUCE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_SPRUCE_PLANKS =
        registerBlockItem("framed_spruce_planks", ModBlocks.FRAMED_SPRUCE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_SPRUCE_PLANKS =
        registerBlockItem("natural_spruce_planks", ModBlocks.NATURAL_SPRUCE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_SPRUCE_PLANKS =
        registerBlockItem("pegged_spruce_planks", ModBlocks.PEGGED_SPRUCE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_PANEL =
        registerBlockItem("spruce_planks_panel", ModBlocks.SPRUCE_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_SPRUCE_PLANKS =
        registerBlockItem("whirlwind_spruce_planks", ModBlocks.WHIRLWIND_SPRUCE_PLANKS);

    // ── Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_TERRACOTTA =
        registerBlockItem("circular_terracotta", ModBlocks.CIRCULAR_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_TERRACOTTA =
        registerBlockItem("curled_terracotta", ModBlocks.CURLED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_TERRACOTTA =
        registerBlockItem("hexagonical_terracotta", ModBlocks.HEXAGONICAL_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_TERRACOTTA =
        registerBlockItem("inscribed_terracotta", ModBlocks.INSCRIBED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_TERRACOTTA_TILES =
        registerBlockItem("small_terracotta_tiles", ModBlocks.SMALL_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_TERRACOTTA =
        registerBlockItem("starry_terracotta", ModBlocks.STARRY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> TERRACOTTA_COLUMN =
        registerBlockItem("terracotta_column", ModBlocks.TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TERRACOTTA_PILLAR =
        registerBlockItem("terracotta_pillar", ModBlocks.TERRACOTTA_PILLAR);

    // ── Tuff ──
    public static final DeferredHolder<Item, BlockItem> BORDERED_TUFF =
        registerBlockItem("bordered_tuff", ModBlocks.BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_TUFF =
        registerBlockItem("brick_bordered_tuff", ModBlocks.BRICK_BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> CURLY_TUFF_PILLAR =
        registerBlockItem("curly_tuff_pillar", ModBlocks.CURLY_TUFF_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_TUFF_COLUMN =
        registerBlockItem("cut_tuff_column", ModBlocks.CUT_TUFF_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_TUFF_BRICKS =
        registerBlockItem("edged_tuff_bricks", ModBlocks.EDGED_TUFF_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_TUFF_PILLAR =
        registerBlockItem("fine_tuff_pillar", ModBlocks.FINE_TUFF_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_TUFF_BRICKS =
        registerBlockItem("massive_tuff_bricks", ModBlocks.MASSIVE_TUFF_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_TUFF_PILLAR =
        registerBlockItem("ornate_tuff_pillar", ModBlocks.ORNATE_TUFF_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_TUFF_TILES =
        registerBlockItem("overlapping_tuff_tiles", ModBlocks.OVERLAPPING_TUFF_TILES);
    public static final DeferredHolder<Item, BlockItem> POLISHED_TUFF =
        registerBlockItem("polished_tuff", ModBlocks.POLISHED_TUFF);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_TUFF_PILLAR =
        registerBlockItem("simple_tuff_pillar", ModBlocks.SIMPLE_TUFF_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_TUFF_COLUMN =
        registerBlockItem("smooth_tuff_column", ModBlocks.SMOOTH_TUFF_COLUMN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_TUFF =
        registerBlockItem("thick_inlayed_tuff", ModBlocks.THICK_INLAYED_TUFF);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_TUFF =
        registerBlockItem("tiled_bordered_tuff", ModBlocks.TILED_BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> TILED_TUFF_COLUMN =
        registerBlockItem("tiled_tuff_column", ModBlocks.TILED_TUFF_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_TUFF =
        registerBlockItem("tiny_brick_bordered_tuff", ModBlocks.TINY_BRICK_BORDERED_TUFF);

    // ── Warped Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_WARPED_PLANKS =
        registerBlockItem("cornered_warped_planks", ModBlocks.CORNERED_WARPED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_WARPED_PLANKS =
        registerBlockItem("crated_warped_planks", ModBlocks.CRATED_WARPED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_WARPED_PLANKS =
        registerBlockItem("enclosed_warped_planks", ModBlocks.ENCLOSED_WARPED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_WARPED_PLANKS =
        registerBlockItem("framed_warped_planks", ModBlocks.FRAMED_WARPED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_WARPED_PLANKS =
        registerBlockItem("natural_warped_planks", ModBlocks.NATURAL_WARPED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_WARPED_PLANKS =
        registerBlockItem("pegged_warped_planks", ModBlocks.PEGGED_WARPED_PLANKS);
    public static final DeferredHolder<Item, BlockItem> STACKED_STRIPPED_WARPED_STEM =
        registerBlockItem("stacked_stripped_warped_stem", ModBlocks.STACKED_STRIPPED_WARPED_STEM);
    public static final DeferredHolder<Item, BlockItem> STACKED_STRIPPED_WARPED_STEM_TOP =
        registerBlockItem("stacked_stripped_warped_stem_top", ModBlocks.STACKED_STRIPPED_WARPED_STEM_TOP);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_PANEL =
        registerBlockItem("warped_planks_panel", ModBlocks.WARPED_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_WARPED_PLANKS =
        registerBlockItem("whirlwind_warped_planks", ModBlocks.WHIRLWIND_WARPED_PLANKS);

    // ── White Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_WHITE_CONCRETE =
        registerBlockItem("grill_white_concrete", ModBlocks.GRILL_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_WHITE_CONCRETE =
        registerBlockItem("pegged_white_concrete", ModBlocks.PEGGED_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_WHITE_CONCRETE =
        registerBlockItem("smooth_white_concrete", ModBlocks.SMOOTH_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_WHITE_CONCRETE =
        registerBlockItem("striped_white_concrete", ModBlocks.STRIPED_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WHITE_CONCRETE_PANEL =
        registerBlockItem("white_concrete_panel", ModBlocks.WHITE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> WHITE_CONCRETE_PILLAR =
        registerBlockItem("white_concrete_pillar", ModBlocks.WHITE_CONCRETE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> WIRED_WHITE_CONCRETE =
        registerBlockItem("wired_white_concrete", ModBlocks.WIRED_WHITE_CONCRETE);

    // ── White Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_WHITE_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_white_stained_glass_pillar", ModBlocks.ARCHED_WHITE_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_WHITE_STAINED_GLASS =
        registerBlockItem("fancy_white_stained_glass", ModBlocks.FANCY_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_WHITE_STAINED_GLASS =
        registerBlockItem("ornate_white_stained_glass", ModBlocks.ORNATE_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_WHITE_STAINED_GLASS =
        registerBlockItem("raster_white_stained_glass", ModBlocks.RASTER_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_STAINED_GLASS =
        registerBlockItem("small_white_stained_glass", ModBlocks.SMALL_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_WHITE_STAINED_GLASS =
        registerBlockItem("tiled_white_stained_glass", ModBlocks.TILED_WHITE_STAINED_GLASS);

    // ── White Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_WHITE_TERRACOTTA =
        registerBlockItem("circular_white_terracotta", ModBlocks.CIRCULAR_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_WHITE_TERRACOTTA =
        registerBlockItem("curled_white_terracotta", ModBlocks.CURLED_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_WHITE_TERRACOTTA =
        registerBlockItem("hexagonical_white_terracotta", ModBlocks.HEXAGONICAL_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_WHITE_TERRACOTTA =
        registerBlockItem("inscribed_white_terracotta", ModBlocks.INSCRIBED_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_TERRACOTTA_TILES =
        registerBlockItem("small_white_terracotta_tiles", ModBlocks.SMALL_WHITE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_WHITE_TERRACOTTA =
        registerBlockItem("starry_white_terracotta", ModBlocks.STARRY_WHITE_TERRACOTTA);

    // ── White Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_WHITE_WOOL =
        registerBlockItem("cornered_white_wool", ModBlocks.CORNERED_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_WHITE_WOOL =
        registerBlockItem("crafted_white_wool", ModBlocks.CRAFTED_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_WHITE_WOOL =
        registerBlockItem("harsh_quilted_white_wool", ModBlocks.HARSH_QUILTED_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_WHITE_WOOL =
        registerBlockItem("rectangle_white_wool", ModBlocks.RECTANGLE_WHITE_WOOL);

    // ── Yellow Concrete ──
    public static final DeferredHolder<Item, BlockItem> GRILL_YELLOW_CONCRETE =
        registerBlockItem("grill_yellow_concrete", ModBlocks.GRILL_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_YELLOW_CONCRETE =
        registerBlockItem("pegged_yellow_concrete", ModBlocks.PEGGED_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_YELLOW_CONCRETE =
        registerBlockItem("smooth_yellow_concrete", ModBlocks.SMOOTH_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_YELLOW_CONCRETE =
        registerBlockItem("striped_yellow_concrete", ModBlocks.STRIPED_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_YELLOW_CONCRETE =
        registerBlockItem("wired_yellow_concrete", ModBlocks.WIRED_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_CONCRETE_PANEL =
        registerBlockItem("yellow_concrete_panel", ModBlocks.YELLOW_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> YELLOW_CONCRETE_PILLAR =
        registerBlockItem("yellow_concrete_pillar", ModBlocks.YELLOW_CONCRETE_PILLAR);

    // ── Yellow Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> ARCHED_YELLOW_STAINED_GLASS_PILLAR =
        registerBlockItem("arched_yellow_stained_glass_pillar", ModBlocks.ARCHED_YELLOW_STAINED_GLASS_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FANCY_YELLOW_STAINED_GLASS =
        registerBlockItem("fancy_yellow_stained_glass", ModBlocks.FANCY_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_YELLOW_STAINED_GLASS =
        registerBlockItem("ornate_yellow_stained_glass", ModBlocks.ORNATE_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_YELLOW_STAINED_GLASS =
        registerBlockItem("raster_yellow_stained_glass", ModBlocks.RASTER_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_STAINED_GLASS =
        registerBlockItem("small_yellow_stained_glass", ModBlocks.SMALL_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_YELLOW_STAINED_GLASS =
        registerBlockItem("tiled_yellow_stained_glass", ModBlocks.TILED_YELLOW_STAINED_GLASS);

    // ── Yellow Terracotta ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_YELLOW_TERRACOTTA =
        registerBlockItem("circular_yellow_terracotta", ModBlocks.CIRCULAR_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_YELLOW_TERRACOTTA =
        registerBlockItem("curled_yellow_terracotta", ModBlocks.CURLED_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_YELLOW_TERRACOTTA =
        registerBlockItem("hexagonical_yellow_terracotta", ModBlocks.HEXAGONICAL_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_YELLOW_TERRACOTTA =
        registerBlockItem("inscribed_yellow_terracotta", ModBlocks.INSCRIBED_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_TERRACOTTA_TILES =
        registerBlockItem("small_yellow_terracotta_tiles", ModBlocks.SMALL_YELLOW_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> STARRY_YELLOW_TERRACOTTA =
        registerBlockItem("starry_yellow_terracotta", ModBlocks.STARRY_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> YELLOW_TERRACOTTA_COLUMN =
        registerBlockItem("yellow_terracotta_column", ModBlocks.YELLOW_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> YELLOW_TERRACOTTA_PILLAR =
        registerBlockItem("yellow_terracotta_pillar", ModBlocks.YELLOW_TERRACOTTA_PILLAR);

    // ── Yellow Wool ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_YELLOW_WOOL =
        registerBlockItem("cornered_yellow_wool", ModBlocks.CORNERED_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_YELLOW_WOOL =
        registerBlockItem("crafted_yellow_wool", ModBlocks.CRAFTED_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_YELLOW_WOOL =
        registerBlockItem("harsh_quilted_yellow_wool", ModBlocks.HARSH_QUILTED_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_YELLOW_WOOL =
        registerBlockItem("rectangle_yellow_wool", ModBlocks.RECTANGLE_YELLOW_WOOL);


    public static final DeferredItem<Item> UNFIRED_CLAY_ROOF_TILE = ITEMS.register("unfired_clay_roof_tile",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLASTER_BUCKET = ITEMS.register("plaster_bucket",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<ArmorItem> WILDFIRE_CROWN = ITEMS.register("wildfire_crown", () -> new ArmorItem(ModArmorMaterials.WILDFIRE_CROWN, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(481).fireResistant()));
    public static final DeferredItem<Item> WILDFIRE_CROWN_FRAGMENT = ITEMS.register("wildfire_crown_fragment", () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, BlockItem> WATER_MOSAIC_BORDER = registerBlockItem("water_mosaic_border", ModBlocks.WATER_MOSAIC_BORDER);
    public static final DeferredHolder<Item, BlockItem> WATER_MOSAIC_GEOMETRIC = registerBlockItem("water_mosaic_geometric", ModBlocks.WATER_MOSAIC_GEOMETRIC);
    public static final DeferredHolder<Item, BlockItem> WATER_MOSAIC_PATTERN = registerBlockItem("water_mosaic_pattern", ModBlocks.WATER_MOSAIC_PATTERN);
    public static final DeferredHolder<Item, BlockItem> WATER_MOSAIC_DELICATE = registerBlockItem("water_mosaic_delicate", ModBlocks.WATER_MOSAIC_DELICATE);
    public static final DeferredHolder<Item, BlockItem> WATER_MOSAIC_TRADITIONAL = registerBlockItem("water_mosaic_traditional", ModBlocks.WATER_MOSAIC_TRADITIONAL);
    public static final DeferredHolder<Item, BlockItem> WATER_MOSAIC_RECESS = registerBlockItem("water_mosaic_recess", ModBlocks.WATER_MOSAIC_RECESS);
    public static final DeferredHolder<Item, BlockItem> SPIRIT_MOSAIC_RECESS = registerBlockItem("spirit_mosaic_recess", ModBlocks.SPIRIT_MOSAIC_RECESS);
    public static final DeferredHolder<Item, BlockItem> AIR_MOSAIC_RECESS = registerBlockItem("air_mosaic_recess", ModBlocks.AIR_MOSAIC_RECESS);
    public static final DeferredHolder<Item, BlockItem> EARTH_MOSAIC_RECESS = registerBlockItem("earth_mosaic_recess", ModBlocks.EARTH_MOSAIC_RECESS);
    public static final DeferredHolder<Item, BlockItem> FIRE_MOSAIC_RECESS = registerBlockItem("fire_mosaic_recess", ModBlocks.FIRE_MOSAIC_RECESS);
    public static final DeferredHolder<Item, BlockItem> EARTH_MOSAIC_BORDER = registerBlockItem("earth_mosaic_border", ModBlocks.EARTH_MOSAIC_BORDER);
    public static final DeferredHolder<Item, BlockItem> EARTH_MOSAIC_GEOMETRIC = registerBlockItem("earth_mosaic_geometric", ModBlocks.EARTH_MOSAIC_GEOMETRIC);
    public static final DeferredHolder<Item, BlockItem> EARTH_MOSAIC_PATTERN = registerBlockItem("earth_mosaic_pattern", ModBlocks.EARTH_MOSAIC_PATTERN);
    public static final DeferredHolder<Item, BlockItem> EARTH_MOSAIC_DELICATE = registerBlockItem("earth_mosaic_delicate", ModBlocks.EARTH_MOSAIC_DELICATE);
    public static final DeferredHolder<Item, BlockItem> EARTH_MOSAIC_TRADITIONAL = registerBlockItem("earth_mosaic_traditional", ModBlocks.EARTH_MOSAIC_TRADITIONAL);
    public static final DeferredHolder<Item, BlockItem> FIRE_MOSAIC_BORDER = registerBlockItem("fire_mosaic_border", ModBlocks.FIRE_MOSAIC_BORDER);
    public static final DeferredHolder<Item, BlockItem> FIRE_MOSAIC_GEOMETRIC = registerBlockItem("fire_mosaic_geometric", ModBlocks.FIRE_MOSAIC_GEOMETRIC);
    public static final DeferredHolder<Item, BlockItem> FIRE_MOSAIC_PATTERN = registerBlockItem("fire_mosaic_pattern", ModBlocks.FIRE_MOSAIC_PATTERN);
    public static final DeferredHolder<Item, BlockItem> FIRE_MOSAIC_DELICATE = registerBlockItem("fire_mosaic_delicate", ModBlocks.FIRE_MOSAIC_DELICATE);
    public static final DeferredHolder<Item, BlockItem> FIRE_MOSAIC_TRADITIONAL = registerBlockItem("fire_mosaic_traditional", ModBlocks.FIRE_MOSAIC_TRADITIONAL);
    public static final DeferredHolder<Item, BlockItem> SPIRIT_MOSAIC_BORDER = registerBlockItem("spirit_mosaic_border", ModBlocks.SPIRIT_MOSAIC_BORDER);
    public static final DeferredHolder<Item, BlockItem> SPIRIT_MOSAIC_GEOMETRIC = registerBlockItem("spirit_mosaic_geometric", ModBlocks.SPIRIT_MOSAIC_GEOMETRIC);
    public static final DeferredHolder<Item, BlockItem> SPIRIT_MOSAIC_PATTERN = registerBlockItem("spirit_mosaic_pattern", ModBlocks.SPIRIT_MOSAIC_PATTERN);
    public static final DeferredHolder<Item, BlockItem> SPIRIT_MOSAIC_DELICATE = registerBlockItem("spirit_mosaic_delicate", ModBlocks.SPIRIT_MOSAIC_DELICATE);
    public static final DeferredHolder<Item, BlockItem> SPIRIT_MOSAIC_TRADITIONAL = registerBlockItem("spirit_mosaic_traditional", ModBlocks.SPIRIT_MOSAIC_TRADITIONAL);
    public static final DeferredHolder<Item, BlockItem> AIR_MOSAIC_BORDER = registerBlockItem("air_mosaic_border", ModBlocks.AIR_MOSAIC_BORDER);
    public static final DeferredHolder<Item, BlockItem> AIR_MOSAIC_GEOMETRIC = registerBlockItem("air_mosaic_geometric", ModBlocks.AIR_MOSAIC_GEOMETRIC);
    public static final DeferredHolder<Item, BlockItem> AIR_MOSAIC_PATTERN = registerBlockItem("air_mosaic_pattern", ModBlocks.AIR_MOSAIC_PATTERN);
    public static final DeferredHolder<Item, BlockItem> AIR_MOSAIC_DELICATE = registerBlockItem("air_mosaic_delicate", ModBlocks.AIR_MOSAIC_DELICATE);
    public static final DeferredHolder<Item, BlockItem> AIR_MOSAIC_TRADITIONAL = registerBlockItem("air_mosaic_traditional", ModBlocks.AIR_MOSAIC_TRADITIONAL);
    public static final DeferredHolder<Item, BlockItem> MOSAIC_FLOOR = registerBlockItem("mosaic_floor", ModBlocks.MOSAIC_FLOOR);
    public static final DeferredHolder<Item, BlockItem> MOSAIC_FLOOR_DELICATE = registerBlockItem("mosaic_floor_delicate", ModBlocks.MOSAIC_FLOOR_DELICATE);
    public static final DeferredHolder<Item, BlockItem> MOSAIC_FLOOR_ROSETTE = registerBlockItem("mosaic_floor_rosette", ModBlocks.MOSAIC_FLOOR_ROSETTE);
    public static final DeferredHolder<Item, BlockItem> ROMAN_FRESCO_RED = registerBlockItem("roman_fresco_red", ModBlocks.ROMAN_FRESCO_RED);
    public static final DeferredHolder<Item, BlockItem> ROMAN_FRESCO_BLACK = registerBlockItem("roman_fresco_black", ModBlocks.ROMAN_FRESCO_BLACK);

    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_ARROWSLIT = registerBlockItem("stone_bricks_arrowslit", ModBlocks.STONE_BRICKS_ARROWSLIT);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_MACHICOLATION = registerBlockItem("stone_bricks_machicolation", ModBlocks.STONE_BRICKS_MACHICOLATION);
    public static final DeferredHolder<Item, BlockItem> WATER_SOURCE_TRICKLE = registerBlockItem("water_source_trickle", ModBlocks.WATER_SOURCE_TRICKLE);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_FAUCET = registerBlockItem("stone_bricks_faucet", ModBlocks.STONE_BRICKS_FAUCET);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_POOL = registerBlockItem("stone_bricks_pool", ModBlocks.STONE_BRICKS_POOL);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_SMALL_POOL = registerBlockItem("stone_bricks_small_pool", ModBlocks.STONE_BRICKS_SMALL_POOL);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_WATER_JET = registerBlockItem("stone_bricks_water_jet", ModBlocks.STONE_BRICKS_WATER_JET);

    public static final DeferredHolder<Item, BlockItem> LIMESTONE_MASONRY = registerBlockItem("limestone_masonry", ModBlocks.LIMESTONE_MASONRY);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_MASONRY_EDGE = registerBlockItem("limestone_masonry_edge", ModBlocks.LIMESTONE_MASONRY_EDGE);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_MASONRY_PLATE = registerBlockItem("limestone_masonry_plate", ModBlocks.LIMESTONE_MASONRY_PLATE);
    public static final DeferredHolder<Item, BlockItem> COBBLED_LIMESTONE = registerBlockItem("cobbled_limestone", ModBlocks.COBBLED_LIMESTONE);
    public static final DeferredHolder<Item, BlockItem> PLAIN_LIMESTONE = registerBlockItem("limestone", ModBlocks.PLAIN_LIMESTONE);
    public static final DeferredHolder<Item, BlockItem> MIXED_LIMESTONE_BRICKS = registerBlockItem("mixed_limestone_bricks", ModBlocks.MIXED_LIMESTONE_BRICKS);

    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE              = registerBlockItem("black_marble",              ModBlocks.BLACK_MARBLE);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_BRICKS       = registerBlockItem("black_marble_bricks",       ModBlocks.BLACK_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_SMALL_BRICKS = registerBlockItem("black_marble_small_bricks", ModBlocks.BLACK_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_TILES        = registerBlockItem("black_marble_tiles",        ModBlocks.BLACK_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> BLACK_POLISHED_MARBLE     = registerBlockItem("black_polished_marble",     ModBlocks.BLACK_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_PILLAR       = registerBlockItem("black_marble_pillar",       ModBlocks.BLACK_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_PILLAR_CAP   = registerBlockItem("black_marble_pillar_cap",   ModBlocks.BLACK_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE              = registerBlockItem("white_marble",              ModBlocks.WHITE_MARBLE);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_BRICKS       = registerBlockItem("white_marble_bricks",       ModBlocks.WHITE_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_SMALL_BRICKS = registerBlockItem("white_marble_small_bricks", ModBlocks.WHITE_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_TILES        = registerBlockItem("white_marble_tiles",        ModBlocks.WHITE_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> WHITE_POLISHED_MARBLE     = registerBlockItem("white_polished_marble",     ModBlocks.WHITE_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_PILLAR       = registerBlockItem("white_marble_pillar",       ModBlocks.WHITE_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_PILLAR_CAP   = registerBlockItem("white_marble_pillar_cap",   ModBlocks.WHITE_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_FLOOR_TILE   = registerBlockItem("black_marble_floor_tile",   ModBlocks.BLACK_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_FLOOR_TILE   = registerBlockItem("white_marble_floor_tile",   ModBlocks.WHITE_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_FANCY_FENCE = registerBlockItem("white_marble_fancy_fence", ModBlocks.WHITE_MARBLE_FANCY_FENCE);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_FANCY_FENCE = registerBlockItem("black_marble_fancy_fence", ModBlocks.BLACK_MARBLE_FANCY_FENCE);

    // --- Stone variant block items ---
    public static final DeferredHolder<Item, BlockItem> ANGRY_STONE                       = registerBlockItem("angry_stone",                       ModBlocks.ANGRY_STONE);
    public static final DeferredHolder<Item, BlockItem> BLANK_STONE_CARVING               = registerBlockItem("blank_stone_carving",               ModBlocks.BLANK_STONE_CARVING);
    public static final DeferredHolder<Item, BlockItem> BORDERED_STONE                    = registerBlockItem("bordered_stone",                    ModBlocks.BORDERED_STONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_STONE              = registerBlockItem("brick_bordered_stone",              ModBlocks.BRICK_BORDERED_STONE);
    public static final DeferredHolder<Item, BlockItem> CARVED_STONE                      = registerBlockItem("carved_stone",                      ModBlocks.CARVED_STONE);
    public static final DeferredHolder<Item, BlockItem> CHECKERED_STONE_TILES             = registerBlockItem("checkered_stone_tiles",             ModBlocks.CHECKERED_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_STONE                     = registerBlockItem("cobbled_stone",                     ModBlocks.COBBLED_STONE);
    public static final DeferredHolder<Item, BlockItem> CRACKED_DISORDERED_STONE_BRICKS   = registerBlockItem("cracked_disordered_stone_bricks",   ModBlocks.CRACKED_DISORDERED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CRACKED_FLAT_STONE_TILES          = registerBlockItem("cracked_flat_stone_tiles",          ModBlocks.CRACKED_FLAT_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> CREEPER_STONE_CARVING             = registerBlockItem("creeper_stone_carving",             ModBlocks.CREEPER_STONE_CARVING);
    public static final DeferredHolder<Item, BlockItem> CRYING_STONE                      = registerBlockItem("crying_stone",                      ModBlocks.CRYING_STONE);
    public static final DeferredHolder<Item, BlockItem> CURLY_STONE_PILLAR                = registerBlockItem("curly_stone_pillar",                ModBlocks.CURLY_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CUT_BLANK_STONE                   = registerBlockItem("cut_blank_stone",                   ModBlocks.CUT_BLANK_STONE);
    public static final DeferredHolder<Item, BlockItem> CUT_STONE_COLUMN                  = registerBlockItem("cut_stone_column",                  ModBlocks.CUT_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> DUH_STONE                         = registerBlockItem("duh_stone",                         ModBlocks.DUH_STONE);
    public static final DeferredHolder<Item, BlockItem> EDGED_STONE_BRICKS                = registerBlockItem("edged_stone_bricks",                ModBlocks.EDGED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ENGRAVED_STONE                    = registerBlockItem("engraved_stone",                    ModBlocks.ENGRAVED_STONE);
    public static final DeferredHolder<Item, BlockItem> ETCHED_STONE_BRICKS               = registerBlockItem("etched_stone_bricks",               ModBlocks.ETCHED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_STONE_PILLAR                 = registerBlockItem("fine_stone_pillar",                 ModBlocks.FINE_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> FLAT_STONE_TILES                  = registerBlockItem("flat_stone_tiles",                  ModBlocks.FLAT_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> GLAD_STONE                        = registerBlockItem("glad_stone",                        ModBlocks.GLAD_STONE);
    public static final DeferredHolder<Item, BlockItem> INLAYED_STONE                     = registerBlockItem("inlayed_stone",                     ModBlocks.INLAYED_STONE);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_STONE                   = registerBlockItem("inscribed_stone",                   ModBlocks.INSCRIBED_STONE);
    public static final DeferredHolder<Item, BlockItem> LAYED_STONE_BRICKS                = registerBlockItem("layed_stone_bricks",                ModBlocks.LAYED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> LODED_STONE                       = registerBlockItem("loded_stone",                       ModBlocks.LODED_STONE);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_STONE_BRICKS              = registerBlockItem("massive_stone_bricks",              ModBlocks.MASSIVE_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> OFFSET_STONE_BRICKS               = registerBlockItem("offset_stone_bricks",               ModBlocks.OFFSET_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_STONE_PILLAR               = registerBlockItem("ornate_stone_pillar",               ModBlocks.ORNATE_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_STONE_TILES           = registerBlockItem("overlapping_stone_tiles",           ModBlocks.OVERLAPPING_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> PILLAR_STONE_BRICKS               = registerBlockItem("pillar_stone_bricks",               ModBlocks.PILLAR_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_STONE                    = registerBlockItem("polished_stone",                    ModBlocks.POLISHED_STONE);
    public static final DeferredHolder<Item, BlockItem> PRISMAL_STONE_REMNANTS            = registerBlockItem("prismal_stone_remnants",            ModBlocks.PRISMAL_STONE_REMNANTS);
    public static final DeferredHolder<Item, BlockItem> ROUGH_STONE                       = registerBlockItem("rough_stone",                       ModBlocks.ROUGH_STONE);
    public static final DeferredHolder<Item, BlockItem> ROUNDED_STONE_BRICKS              = registerBlockItem("rounded_stone_bricks",              ModBlocks.ROUNDED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RUNIC_CARVED_STONE                = registerBlockItem("runic_carved_stone",                ModBlocks.RUNIC_CARVED_STONE);
    public static final DeferredHolder<Item, BlockItem> SAD_STONE                         = registerBlockItem("sad_stone",                         ModBlocks.SAD_STONE);
    public static final DeferredHolder<Item, BlockItem> SANDED_STONE                      = registerBlockItem("sanded_stone",                      ModBlocks.SANDED_STONE);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_STONE_PILLAR               = registerBlockItem("simple_stone_pillar",               ModBlocks.SIMPLE_STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> SMALL_STONE_BRICKS                = registerBlockItem("small_stone_bricks",                ModBlocks.SMALL_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_INLAYED_STONE              = registerBlockItem("smooth_inlayed_stone",              ModBlocks.SMOOTH_INLAYED_STONE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_STONE_COLUMN               = registerBlockItem("smooth_stone_column",               ModBlocks.SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTHED_DOUBLE_INLAYED_STONE     = registerBlockItem("smoothed_double_inlayed_stone",     ModBlocks.SMOOTHED_DOUBLE_INLAYED_STONE);
    public static final DeferredHolder<Item, BlockItem> SPIDER_STONE_CARVING              = registerBlockItem("spider_stone_carving",              ModBlocks.SPIDER_STONE_CARVING);
    public static final DeferredHolder<Item, BlockItem> SPIRALED_STONE                    = registerBlockItem("spiraled_stone",                    ModBlocks.SPIRALED_STONE);
    public static final DeferredHolder<Item, BlockItem> STACKED_STONE_BRICKS              = registerBlockItem("stacked_stone_bricks",              ModBlocks.STACKED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> STONE_MINI_TILES                  = registerBlockItem("stone_mini_tiles",                  ModBlocks.STONE_MINI_TILES);
    public static final DeferredHolder<Item, BlockItem> STONE_PILLAR                      = registerBlockItem("stone_pillar",                      ModBlocks.STONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> STONE_SCALES                      = registerBlockItem("stone_scales",                      ModBlocks.STONE_SCALES);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_STONE               = registerBlockItem("thick_inlayed_stone",               ModBlocks.THICK_INLAYED_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_STONE              = registerBlockItem("tiled_bordered_stone",              ModBlocks.TILED_BORDERED_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_STONE                       = registerBlockItem("tiled_stone",                       ModBlocks.TILED_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_STONE_COLUMN                = registerBlockItem("tiled_stone_column",                ModBlocks.TILED_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_STONE         = registerBlockItem("tiny_brick_bordered_stone",         ModBlocks.TINY_BRICK_BORDERED_STONE);
    public static final DeferredHolder<Item, BlockItem> TINY_LAYERED_STONE_BRICKS         = registerBlockItem("tiny_layered_stone_bricks",         ModBlocks.TINY_LAYERED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TINY_LAYERED_STONE_SLABS          = registerBlockItem("tiny_layered_stone_slabs",          ModBlocks.TINY_LAYERED_STONE_SLABS);
    public static final DeferredHolder<Item, BlockItem> TINY_STONE_BRICKS                 = registerBlockItem("tiny_stone_bricks",                 ModBlocks.TINY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TRODDEN_STONE                     = registerBlockItem("trodden_stone",                     ModBlocks.TRODDEN_STONE);
    public static final DeferredHolder<Item, BlockItem> UNAMUSED_STONE                    = registerBlockItem("unamused_stone",                    ModBlocks.UNAMUSED_STONE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_CUT_STONE                = registerBlockItem("vertical_cut_stone",                ModBlocks.VERTICAL_CUT_STONE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_DISORDERED_STONE_BRICKS  = registerBlockItem("vertical_disordered_stone_bricks",  ModBlocks.VERTICAL_DISORDERED_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> WEATHERED_STONE                   = registerBlockItem("weathered_stone",                   ModBlocks.WEATHERED_STONE);
    public static final DeferredHolder<Item, BlockItem> PURPUR_PILLAR_CTM                  = registerBlockItem("purpur_pillar",          ModBlocks.PURPUR_PILLAR_CTM);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_CTM                      = registerBlockItem("sandstone",              ModBlocks.SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_CTM                  = registerBlockItem("red_sandstone",          ModBlocks.RED_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> BORDERED_ANDESITE_CTM              = registerBlockItem("bordered_andesite",       ModBlocks.BORDERED_ANDESITE_CTM);
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANDESITE_CTM              = registerBlockItem("polished_andesite",       ModBlocks.POLISHED_ANDESITE_CTM);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_CTM            = registerBlockItem("polished_blackstone",     ModBlocks.POLISHED_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIORITE_CTM               = registerBlockItem("polished_diorite",        ModBlocks.POLISHED_DIORITE_CTM);
    public static final DeferredHolder<Item, BlockItem> POLISHED_GRANITE_CTM               = registerBlockItem("polished_granite",        ModBlocks.POLISHED_GRANITE_CTM);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_CTM                = registerBlockItem("netherite_block",         ModBlocks.NETHERITE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_STONE_CTM                   = registerBlockItem("smooth_stone",            ModBlocks.SMOOTH_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_CTM                  = registerBlockItem("emerald_block",           ModBlocks.EMERALD_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CHISELED_PLASTERED_STONE_PILLAR    = registerBlockItem("chiseled_plastered_stone_pillar",    ModBlocks.CHISELED_PLASTERED_STONE_PILLAR);
    // CTM vertical pillars
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_PILLAR        = registerBlockItem("bone_block_pillar",        ModBlocks.BONE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_PILLAR        = registerBlockItem("coal_block_pillar",        ModBlocks.COAL_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_PILLAR = registerBlockItem("cobbled_deepslate_pillar", ModBlocks.COBBLED_DEEPSLATE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_PILLAR       = registerBlockItem("cobblestone_pillar",       ModBlocks.COBBLESTONE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_PILLAR      = registerBlockItem("copper_block_pillar",      ModBlocks.COPPER_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_PILLAR       = registerBlockItem("lapis_block_pillar",       ModBlocks.LAPIS_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_PILLAR   = registerBlockItem("netherite_block_pillar",   ModBlocks.NETHERITE_BLOCK_PILLAR);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_PILLAR          = registerBlockItem("obsidian_pillar",          ModBlocks.OBSIDIAN_PILLAR);

    public static final DeferredHolder<Item, BlockItem> SANDSTONE_CRENELATION = registerBlockItem("sandstone_crenelation", ModBlocks.SANDSTONE_CRENELATION);

    public static final DeferredHolder<Item, BlockItem> ROOFING_SLATES = registerBlockItem("roofing_slates", ModBlocks.ROOFING_SLATES);

    public static final DeferredHolder<Item, BlockItem> WHEAT_THATCH = registerBlockItem("wheat_thatch", ModBlocks.WHEAT_THATCH);
    public static final DeferredHolder<Item, BlockItem> WHEAT_THATCH_EDGE = registerBlockItem("wheat_thatch_edge", ModBlocks.WHEAT_THATCH_EDGE);
    public static final DeferredHolder<Item, BlockItem> WHEAT_THATCH_PLATE = registerBlockItem("wheat_thatch_plate", ModBlocks.WHEAT_THATCH_PLATE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_THATCH = registerBlockItem("bamboo_thatch", ModBlocks.BAMBOO_THATCH);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_THATCH_EDGE = registerBlockItem("bamboo_thatch_edge", ModBlocks.BAMBOO_THATCH_EDGE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_THATCH_PLATE = registerBlockItem("bamboo_thatch_plate", ModBlocks.BAMBOO_THATCH_PLATE);

    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_MASONRY = registerBlockItem("stone_bricks_masonry", ModBlocks.STONE_BRICKS_MASONRY);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_MASONRY_EDGE = registerBlockItem("stone_bricks_masonry_edge", ModBlocks.STONE_BRICKS_MASONRY_EDGE);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICKS_MASONRY_PLATE = registerBlockItem("stone_bricks_masonry_plate", ModBlocks.STONE_BRICKS_MASONRY_PLATE);
    public static final DeferredHolder<Item, BlockItem> CURVED_RAKED_GRAVEL = registerBlockItem("curved_raked_gravel", ModBlocks.CURVED_RAKED_GRAVEL);
    public static final DeferredHolder<Item, BlockItem> STRAIGHT_RAKED_GRAVEL = registerBlockItem("straight_raked_gravel", ModBlocks.STRAIGHT_RAKED_GRAVEL);

    public static final DeferredHolder<Item, BlockItem> SANDSTONE_SLENDER_BRICKS = registerBlockItem("sandstone_slender_bricks", ModBlocks.SANDSTONE_SLENDER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_SLENDER_TURQUOISE_PATTERN = registerBlockItem("sandstone_slender_turquoise_pattern", ModBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN);

    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_RED_WOOL = registerBlockItem("ornamented_red_wool", ModBlocks.ORNAMENTED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> DELICATE_RED_WOOL = registerBlockItem("delicate_red_wool", ModBlocks.DELICATE_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_RED_CARPET = registerBlockItem("ornamented_red_carpet", ModBlocks.ORNAMENTED_RED_CARPET);
    public static final DeferredHolder<Item, BlockItem> DELICATE_RED_CARPET = registerBlockItem("delicate_red_carpet", ModBlocks.DELICATE_RED_CARPET);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_BLUE_WOOL = registerBlockItem("ornamented_blue_wool", ModBlocks.ORNAMENTED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> DELICATE_BLUE_WOOL = registerBlockItem("delicate_blue_wool", ModBlocks.DELICATE_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_BLUE_CARPET = registerBlockItem("ornamented_blue_carpet", ModBlocks.ORNAMENTED_BLUE_CARPET);
    public static final DeferredHolder<Item, BlockItem> DELICATE_BLUE_CARPET = registerBlockItem("delicate_blue_carpet", ModBlocks.DELICATE_BLUE_CARPET);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_GREEN_WOOL = registerBlockItem("ornamented_green_wool", ModBlocks.ORNAMENTED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> DELICATE_GREEN_WOOL = registerBlockItem("delicate_green_wool", ModBlocks.DELICATE_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_GREEN_CARPET = registerBlockItem("ornamented_green_carpet", ModBlocks.ORNAMENTED_GREEN_CARPET);
    public static final DeferredHolder<Item, BlockItem> DELICATE_GREEN_CARPET = registerBlockItem("delicate_green_carpet", ModBlocks.DELICATE_GREEN_CARPET);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_PURPLE_WOOL = registerBlockItem("ornamented_purple_wool", ModBlocks.ORNAMENTED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> DELICATE_PURPLE_WOOL = registerBlockItem("delicate_purple_wool", ModBlocks.DELICATE_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> ORNAMENTED_PURPLE_CARPET = registerBlockItem("ornamented_purple_carpet", ModBlocks.ORNAMENTED_PURPLE_CARPET);
    public static final DeferredHolder<Item, BlockItem> DELICATE_PURPLE_CARPET = registerBlockItem("delicate_purple_carpet", ModBlocks.DELICATE_PURPLE_CARPET);


    public static final DeferredHolder<Item, BlockItem> OAK_PERGOLA = registerBlockItem("oak_pergola", ModBlocks.OAK_PERGOLA);
    public static final DeferredHolder<Item, BlockItem> OAK_BEAM = registerBlockItem("oak_beam", ModBlocks.OAK_BEAM);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_PLATE = registerBlockItem("oak_planks_plate", ModBlocks.OAK_PLANKS_PLATE);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_EDGE = registerBlockItem("oak_planks_edge", ModBlocks.OAK_PLANKS_EDGE);
    public static final DeferredHolder<Item, BlockItem> OAK_BANNISTER = registerBlockItem("oak_bannister", ModBlocks.OAK_BANNISTER);
    public static final DeferredHolder<Item, BlockItem> OAK_SUPPORT_SLAB = registerBlockItem("oak_support_slab", ModBlocks.OAK_SUPPORT_SLAB);
    public static final DeferredHolder<Item, BlockItem> OAK_SUPPORT_BEAM = registerBlockItem("oak_support_beam", ModBlocks.OAK_SUPPORT_BEAM);
    public static final DeferredHolder<Item, BlockItem> OAK_GEOMETRIC_WINDOW = registerBlockItem("oak_geometric_window", ModBlocks.OAK_GEOMETRIC_WINDOW);

    public static void register(IEventBus eventBus) {
        // 1. Run dynamic logic to set up the registration entries
        initializeDynamicItems();

        // 2. Attach the registers to the mod event bus
        ITEMS.register(eventBus);
    }

    private static void initializeDynamicItems() {
        for (Butterfly.Variant variant : Butterfly.Variant.values()) {
            BUTTERFLY_JAR_ITEMS.put(variant, ITEMS.register("butterfly_jar_" + variant.getName(), () -> new com.otterly76.ott.item.custom.ButterflyJarItem(ModBlocks.BUTTERFLY_JARS.get(variant).get(), variant, new Item.Properties().stacksTo(1))));
        }

        // REGISTRATION: Gradients
        ModBlocks.getAllGradientBlocks().forEach(block -> ITEMS.register(block.getId().getPath(), () -> new GradientItem<>(new Item.Properties(), block.get())));

        // REGISTRATION: Test, Seaglass
        ModBlocks.TESTBLOCK.forEach(ModItems::registerBlockItem);
        ModBlocks.SEAGLASS.forEach(ModItems::registerBlockItem);
        ModBlocks.SEAGLASS_SETS.values().forEach(set -> {
            registerBlockItem(set.seaglass());
            registerBlockItem(set.bubblesSeaglass());
            registerBlockItem(set.smoothSeaglass());
            registerBlockItem(set.wavesSeaglass());
        });

        // REGISTRATION: Opal Sets
        ModBlocks.OPAL_SETS.values().forEach(set -> {
            registerBlockItem(set.base());
            registerBlockItem(set.crystalBlock());
            registerBlockItem(set.budding());
            registerBlockItem(set.cluster());
            registerBlockItem(set.largeBud());
            registerBlockItem(set.mediumBud());
            registerBlockItem(set.smallBud());
            registerBlockItem(set.bricks());
            registerBlockItem(set.smallBricks());
            registerBlockItem(set.polished());
            registerBlockItem(set.chiseled());
            registerBlockItem(set.pillar());
            registerBlockItem(set.cut());
            registerBlockItem(set.tiles());
            registerBlockItem(set.smallTiles());
            registerBlockItem(set.glass());
            registerBlockItem(set.glassPane());
            registerBlockItem(set.tiling());
        });

        // REGISTRATION: Hedges
        ModBlocks.PARTICLE_HEDGES.values().forEach(ModItems::registerBlockItem);
        ModBlocks.CREEPING_HEDGES.values().forEach(ModItems::registerBlockItem);

        // REGISTRATION: Wood Sets
        ModBlocks.WOOD_SETS.forEach((setName, setBlocks) -> {
            registerBlockItem(setBlocks.log());
            registerBlockItem(setBlocks.wood());
            registerBlockItem(setBlocks.strippedLog());
            registerBlockItem(setBlocks.strippedWood());
            registerBlockItem(setBlocks.planks());
            registerBlockItem(setBlocks.stairs());
            registerBlockItem(setBlocks.slab());
            registerBlockItem(setBlocks.fence());
            registerBlockItem(setBlocks.fenceGate());
            registerBlockItem(setBlocks.door());
            registerBlockItem(setBlocks.trapdoor());
            registerBlockItem(setBlocks.button());
            registerBlockItem(setBlocks.pressurePlate());
            registerBlockItem(setBlocks.leaves());
            registerBlockItem(setBlocks.sapling());
            registerBlockItem(setBlocks.pergola());
            registerBlockItem(setBlocks.beam());
            registerBlockItem(setBlocks.planksPlate());
            registerBlockItem(setBlocks.planksEdge());
            registerBlockItem(setBlocks.bannister());
            registerBlockItem(setBlocks.supportSlab());
            registerBlockItem(setBlocks.supportBeam());
            registerBlockItem(setBlocks.geometricWindow());
            registerBlockItem(setBlocks.beehive());
            registerBlockItem(setBlocks.shelf());

            WOOD_SET_SIGNS.put(setName, registerSign(setName + "_sign", setBlocks.sign(), setBlocks.wallSign()));

            WOOD_SET_HANGING_SIGNS.put(setName, registerHangingSign(setName + "_hanging_sign", setBlocks.hangingSign(), setBlocks.wallHangingSign()));

            WOOD_SET_BOATS.put(setName, ITEMS.register(setName + "_boat", () -> new ModBoatItem(ModEntities.WOOD_SET_BOATS.get(setName), new Item.Properties().stacksTo(1), boat -> {
                if (boat instanceof OttWoodSetBoatEntity b) b.setWoodSetName(setName);
            }, setName, false)));

            WOOD_SET_CHEST_BOATS.put(setName, ITEMS.register(setName + "_chest_boat", () -> new ModBoatItem(ModEntities.WOOD_SET_CHEST_BOATS.get(setName), new Item.Properties().stacksTo(1), boat -> {
                if (boat instanceof OttWoodSetChestBoatEntity b) b.setWoodSetName(setName);
            }, setName, true)));
        });

        // REGISTRATION: Vanilla Wood Structural Blocks
        // Oak structural items are already registered as static fields above; skip them here.
        ModBlocks.VANILLA_STRUCTURAL_SETS.forEach((name, set) -> {
            if (name.equals("oak")) return;
            registerBlockItem(set.pergola());
            registerBlockItem(set.beam());
            registerBlockItem(set.planksPlate());
            registerBlockItem(set.planksEdge());
            registerBlockItem(set.bannister());
            registerBlockItem(set.supportSlab());
            registerBlockItem(set.supportBeam());
            registerBlockItem(set.geometricWindow());
        });

        // REGISTRATION: Color Sets
        ModBlocks.COLOR_SETS.forEach((color, set) -> {
            registerBlockItem(set.candle());
            registerBlockItem(set.concrete());
            registerBlockItem(set.concretePowder());
            registerBlockItem(set.glazedTerracotta());
            ITEMS.register(set.shulkerBox().getId().getPath(), () -> new com.otterly76.ott.item.custom.ColorSetShulkerBoxItem(set.shulkerBox().get(), new Item.Properties().stacksTo(1)));
            registerBlockItem(set.stainedGlass());
            registerBlockItem(set.stainedGlassPane());
            registerBlockItem(set.terracotta());
            registerBlockItem(set.wool());
            registerBlockItem(set.carpet());
            ITEMS.register(set.banner().getId().getPath(), () -> new com.otterly76.ott.item.custom.ColorSetBannerItem(set.banner().get(), set.wallBanner().get(), new Item.Properties().stacksTo(16)));
            ITEMS.register(set.bed().getId().getPath(), () -> new ColorSetBedItem(set.bed().get(), new Item.Properties()));
            registerBlockItem(set.plate());
            registerBlockItem(set.edge());
            registerBlockItem(set.beam());
            registerBlockItem(set.pergola());
            registerBlockItem(set.geometricWindow());
            registerBlockItem(set.bannister());
            registerBlockItem(set.supportSlab());
            registerBlockItem(set.supportBeam());
        });

        // REGISTRATION: Stone shape sets
        ModBlocks.STONE_SETS.forEach((name, set) -> {
            registerBlockItem(set.plate());
            registerBlockItem(set.edge());
            registerBlockItem(set.beam());
            registerBlockItem(set.pergola());
            registerBlockItem(set.geometricWindow());
            registerBlockItem(set.bannister());
            registerBlockItem(set.supportSlab());
            registerBlockItem(set.supportBeam());
        });

        // REGISTRATION: Pattern Blocks
        ModBlocks.PATTERN_BLOCKS.forEach((pattern, colorMap) -> colorMap.values().forEach(ModItems::registerBlockItem));

        // REGISTRATION: Elevators
        ModBlocks.ELEVATORS.values().forEach(ModItems::registerBlockItem);

        // REGISTRATION: Custom Dyes
        ModColorSets.ALL.forEach(colorSet -> {
            CUSTOM_DYES.put(colorSet.name(), ITEMS.register(colorSet.name() + "_dye", () -> new Item(new Item.Properties())));
        });

        // REGISTRATION: Clay Tile Items (ingredient, 32 colors)
        ModPatterns.ALL_COLORS.forEach(color -> {
            CLAY_TILES.put(color.name(), ITEMS.register(color.name() + "_clay_tile", () -> new Item(new Item.Properties())));
        });

        // REGISTRATION: Static Minecraft Backports
        RESIN_BRICK = MINECRAFT_ITEMS.register("resin_brick", () -> new Item(new Item.Properties()));
        MUSIC_DISC_TEARS = MINECRAFT_ITEMS.register("music_disc_tears", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.TEARS.getKey())));
        MUSIC_DISC_LAVA_CHICKEN = MINECRAFT_ITEMS.register("music_disc_lava_chicken", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.LAVA_CHICKEN.getKey())));
        CREAKING_SPAWN_EGG = MINECRAFT_ITEMS.register("creaking_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CREAKING, 6250335, 16545810, new Item.Properties()));
        HAPPY_GHAST_SPAWN_EGG = MINECRAFT_ITEMS.register("happy_ghast_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.HAPPY_GHAST, 16382457, 12369084, new Item.Properties()));

        BLUE_EGG = MINECRAFT_ITEMS.register("blue_egg", () -> new EggItem(new Item.Properties().stacksTo(16).component(ModDataComponents.CHICKEN_VARIANT.get(), ChickenVariants.COLD)));
        BROWN_EGG = MINECRAFT_ITEMS.register("brown_egg", () -> new EggItem(new Item.Properties().stacksTo(16).component(ModDataComponents.CHICKEN_VARIANT.get(), ChickenVariants.WARM)));

        COPPER_NUGGET = MINECRAFT_ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
        COPPER_SWORD = MINECRAFT_ITEMS.register("copper_sword", () -> new SwordItem(ModToolMaterials.COPPER, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolMaterials.COPPER, 3, -2.4F))));
        COPPER_SHOVEL = MINECRAFT_ITEMS.register("copper_shovel", () -> new ShovelItem(ModToolMaterials.COPPER, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolMaterials.COPPER, 1.5F, -3.0F))));
        COPPER_PICKAXE = MINECRAFT_ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModToolMaterials.COPPER, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolMaterials.COPPER, 1.0F, -2.8F))));
        COPPER_AXE = MINECRAFT_ITEMS.register("copper_axe", () -> new AxeItem(ModToolMaterials.COPPER, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolMaterials.COPPER, 6.0F, -3.1F))));
        COPPER_HOE = MINECRAFT_ITEMS.register("copper_hoe", () -> new HoeItem(ModToolMaterials.COPPER, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolMaterials.COPPER, -2.0F, -1.0F))));
        COPPER_SHEARS = MINECRAFT_ITEMS.register("copper_shears", () -> new ShearsItem((new Item.Properties()).durability(190)));

        EXPOSED_COPPER_SWORD = MINECRAFT_ITEMS.register("exposed_copper_sword", () -> new SwordItem(ModToolMaterials.EXPOSED_COPPER, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolMaterials.EXPOSED_COPPER, 3, -2.4F))));
        EXPOSED_COPPER_SHOVEL = MINECRAFT_ITEMS.register("exposed_copper_shovel", () -> new ShovelItem(ModToolMaterials.EXPOSED_COPPER, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolMaterials.EXPOSED_COPPER, 1.5F, -3.0F))));
        EXPOSED_COPPER_PICKAXE = MINECRAFT_ITEMS.register("exposed_copper_pickaxe", () -> new PickaxeItem(ModToolMaterials.EXPOSED_COPPER, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolMaterials.EXPOSED_COPPER, 1.0F, -2.8F))));
        EXPOSED_COPPER_AXE = MINECRAFT_ITEMS.register("exposed_copper_axe", () -> new AxeItem(ModToolMaterials.EXPOSED_COPPER, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolMaterials.EXPOSED_COPPER, 6.0F, -3.1F))));
        EXPOSED_COPPER_HOE = MINECRAFT_ITEMS.register("exposed_copper_hoe", () -> new HoeItem(ModToolMaterials.EXPOSED_COPPER, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolMaterials.EXPOSED_COPPER, -2.0F, -1.0F))));
        EXPOSED_COPPER_SHEARS = MINECRAFT_ITEMS.register("exposed_copper_shears", () -> new ShearsItem((new Item.Properties()).durability(190)));

        WEATHERED_COPPER_SWORD = MINECRAFT_ITEMS.register("weathered_copper_sword", () -> new SwordItem(ModToolMaterials.WEATHERED_COPPER, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolMaterials.WEATHERED_COPPER, 3, -2.4F))));
        WEATHERED_COPPER_SHOVEL = MINECRAFT_ITEMS.register("weathered_copper_shovel", () -> new ShovelItem(ModToolMaterials.WEATHERED_COPPER, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolMaterials.WEATHERED_COPPER, 1.5F, -3.0F))));
        WEATHERED_COPPER_PICKAXE = MINECRAFT_ITEMS.register("weathered_copper_pickaxe", () -> new PickaxeItem(ModToolMaterials.WEATHERED_COPPER, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolMaterials.WEATHERED_COPPER, 1.0F, -2.8F))));
        WEATHERED_COPPER_AXE = MINECRAFT_ITEMS.register("weathered_copper_axe", () -> new AxeItem(ModToolMaterials.WEATHERED_COPPER, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolMaterials.WEATHERED_COPPER, 6.0F, -3.1F))));
        WEATHERED_COPPER_HOE = MINECRAFT_ITEMS.register("weathered_copper_hoe", () -> new HoeItem(ModToolMaterials.WEATHERED_COPPER, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolMaterials.WEATHERED_COPPER, -2.0F, -1.0F))));
        WEATHERED_COPPER_SHEARS = MINECRAFT_ITEMS.register("weathered_copper_shears", () -> new ShearsItem((new Item.Properties()).durability(190)));

        OXIDIZED_COPPER_SWORD = MINECRAFT_ITEMS.register("oxidized_copper_sword", () -> new SwordItem(ModToolMaterials.OXIDIZED_COPPER, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolMaterials.OXIDIZED_COPPER, 3, -2.4F))));
        OXIDIZED_COPPER_SHOVEL = MINECRAFT_ITEMS.register("oxidized_copper_shovel", () -> new ShovelItem(ModToolMaterials.OXIDIZED_COPPER, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolMaterials.OXIDIZED_COPPER, 1.5F, -3.0F))));
        OXIDIZED_COPPER_PICKAXE = MINECRAFT_ITEMS.register("oxidized_copper_pickaxe", () -> new PickaxeItem(ModToolMaterials.OXIDIZED_COPPER, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolMaterials.OXIDIZED_COPPER, 1.0F, -2.8F))));
        OXIDIZED_COPPER_AXE = MINECRAFT_ITEMS.register("oxidized_copper_axe", () -> new AxeItem(ModToolMaterials.OXIDIZED_COPPER, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolMaterials.OXIDIZED_COPPER, 6.0F, -3.1F))));
        OXIDIZED_COPPER_HOE = MINECRAFT_ITEMS.register("oxidized_copper_hoe", () -> new HoeItem(ModToolMaterials.OXIDIZED_COPPER, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolMaterials.OXIDIZED_COPPER, -2.0F, -1.0F))));
        OXIDIZED_COPPER_SHEARS = MINECRAFT_ITEMS.register("oxidized_copper_shears", () -> new ShearsItem((new Item.Properties()).durability(190)));

        // --- Mounts of Mayhem: Spears ---
        WOODEN_SPEAR   = MINECRAFT_ITEMS.register("wooden_spear",   () -> new SpearItem(Tiers.WOOD,      (new Item.Properties()).attributes(SpearItem.createAttributes(Tiers.WOOD,      3, -2.6F))));
        STONE_SPEAR    = MINECRAFT_ITEMS.register("stone_spear",    () -> new SpearItem(Tiers.STONE,     (new Item.Properties()).attributes(SpearItem.createAttributes(Tiers.STONE,     3, -2.6F))));
        IRON_SPEAR     = MINECRAFT_ITEMS.register("iron_spear",     () -> new SpearItem(Tiers.IRON,      (new Item.Properties()).attributes(SpearItem.createAttributes(Tiers.IRON,      3, -2.6F))));
        GOLDEN_SPEAR   = MINECRAFT_ITEMS.register("golden_spear",   () -> new SpearItem(Tiers.GOLD,      (new Item.Properties()).attributes(SpearItem.createAttributes(Tiers.GOLD,      3, -2.6F))));
        DIAMOND_SPEAR  = MINECRAFT_ITEMS.register("diamond_spear",  () -> new SpearItem(Tiers.DIAMOND,   (new Item.Properties()).attributes(SpearItem.createAttributes(Tiers.DIAMOND,   3, -2.6F))));
        NETHERITE_SPEAR = MINECRAFT_ITEMS.register("netherite_spear", () -> new SpearItem(Tiers.NETHERITE, (new Item.Properties()).fireResistant().attributes(SpearItem.createAttributes(Tiers.NETHERITE, 3, -2.6F))));
        COPPER_SPEAR   = MINECRAFT_ITEMS.register("copper_spear",   () -> new SpearItem(ModToolMaterials.COPPER, (new Item.Properties()).attributes(SpearItem.createAttributes(ModToolMaterials.COPPER, 3, -2.6F))));

        COPPER_BUCKET = MINECRAFT_ITEMS.register("copper_bucket", () -> new CopperBucketItem(Fluids.EMPTY, (new Item.Properties()).stacksTo(16)));
        COPPER_WATER_BUCKET = MINECRAFT_ITEMS.register("copper_water_bucket", () -> new CopperBucketItem(Fluids.WATER, (new Item.Properties()).craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
        COPPER_LAVA_BUCKET = MINECRAFT_ITEMS.register("copper_lava_bucket", () -> new CopperBucketItem(Fluids.LAVA, (new Item.Properties()).craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
        COPPER_MILK_BUCKET = MINECRAFT_ITEMS.register("copper_milk_bucket", () -> new CopperMilkBucketItem((new Item.Properties()).craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
        COPPER_POWDER_SNOW_BUCKET = MINECRAFT_ITEMS.register("copper_powder_snow_bucket", () -> new CopperSolidBucketItem(Blocks.POWDER_SNOW, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (new Item.Properties()).craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));

        COPPER_HELMET = MINECRAFT_ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        COPPER_CHESTPLATE = MINECRAFT_ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        COPPER_LEGGINGS = MINECRAFT_ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        COPPER_BOOTS = MINECRAFT_ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        EXPOSED_COPPER_HELMET = MINECRAFT_ITEMS.register("exposed_copper_helmet", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        EXPOSED_COPPER_CHESTPLATE = MINECRAFT_ITEMS.register("exposed_copper_chestplate", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        EXPOSED_COPPER_LEGGINGS = MINECRAFT_ITEMS.register("exposed_copper_leggings", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        EXPOSED_COPPER_BOOTS = MINECRAFT_ITEMS.register("exposed_copper_boots", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        WEATHERED_COPPER_HELMET = MINECRAFT_ITEMS.register("weathered_copper_helmet", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        WEATHERED_COPPER_CHESTPLATE = MINECRAFT_ITEMS.register("weathered_copper_chestplate", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        WEATHERED_COPPER_LEGGINGS = MINECRAFT_ITEMS.register("weathered_copper_leggings", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        WEATHERED_COPPER_BOOTS = MINECRAFT_ITEMS.register("weathered_copper_boots", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        OXIDIZED_COPPER_HELMET = MINECRAFT_ITEMS.register("oxidized_copper_helmet", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        OXIDIZED_COPPER_CHESTPLATE = MINECRAFT_ITEMS.register("oxidized_copper_chestplate", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        OXIDIZED_COPPER_LEGGINGS = MINECRAFT_ITEMS.register("oxidized_copper_leggings", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        OXIDIZED_COPPER_BOOTS = MINECRAFT_ITEMS.register("oxidized_copper_boots", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        COPPER_CHAINMAIL_HELMET = MINECRAFT_ITEMS.register("copper_chainmail_helmet", () -> new ArmorItem(ModArmorMaterials.COPPER_CHAINMAIL, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        COPPER_CHAINMAIL_CHESTPLATE = MINECRAFT_ITEMS.register("copper_chainmail_chestplate", () -> new ArmorItem(ModArmorMaterials.COPPER_CHAINMAIL, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        COPPER_CHAINMAIL_LEGGINGS = MINECRAFT_ITEMS.register("copper_chainmail_leggings", () -> new ArmorItem(ModArmorMaterials.COPPER_CHAINMAIL, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        COPPER_CHAINMAIL_BOOTS = MINECRAFT_ITEMS.register("copper_chainmail_boots", () -> new ArmorItem(ModArmorMaterials.COPPER_CHAINMAIL, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        EXPOSED_COPPER_CHAINMAIL_HELMET = MINECRAFT_ITEMS.register("exposed_copper_chainmail_helmet", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER_CHAINMAIL, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        EXPOSED_COPPER_CHAINMAIL_CHESTPLATE = MINECRAFT_ITEMS.register("exposed_copper_chainmail_chestplate", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER_CHAINMAIL, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        EXPOSED_COPPER_CHAINMAIL_LEGGINGS = MINECRAFT_ITEMS.register("exposed_copper_chainmail_leggings", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER_CHAINMAIL, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        EXPOSED_COPPER_CHAINMAIL_BOOTS = MINECRAFT_ITEMS.register("exposed_copper_chainmail_boots", () -> new ArmorItem(ModArmorMaterials.EXPOSED_COPPER_CHAINMAIL, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        WEATHERED_COPPER_CHAINMAIL_HELMET = MINECRAFT_ITEMS.register("weathered_copper_chainmail_helmet", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER_CHAINMAIL, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        WEATHERED_COPPER_CHAINMAIL_CHESTPLATE = MINECRAFT_ITEMS.register("weathered_copper_chainmail_chestplate", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER_CHAINMAIL, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        WEATHERED_COPPER_CHAINMAIL_LEGGINGS = MINECRAFT_ITEMS.register("weathered_copper_chainmail_leggings", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER_CHAINMAIL, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        WEATHERED_COPPER_CHAINMAIL_BOOTS = MINECRAFT_ITEMS.register("weathered_copper_chainmail_boots", () -> new ArmorItem(ModArmorMaterials.WEATHERED_COPPER_CHAINMAIL, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        OXIDIZED_COPPER_CHAINMAIL_HELMET = MINECRAFT_ITEMS.register("oxidized_copper_chainmail_helmet", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER_CHAINMAIL, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5))));
        OXIDIZED_COPPER_CHAINMAIL_CHESTPLATE = MINECRAFT_ITEMS.register("oxidized_copper_chainmail_chestplate", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER_CHAINMAIL, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
        OXIDIZED_COPPER_CHAINMAIL_LEGGINGS = MINECRAFT_ITEMS.register("oxidized_copper_chainmail_leggings", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER_CHAINMAIL, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
        OXIDIZED_COPPER_CHAINMAIL_BOOTS = MINECRAFT_ITEMS.register("oxidized_copper_chainmail_boots", () -> new ArmorItem(ModArmorMaterials.OXIDIZED_COPPER_CHAINMAIL, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(5))));

        COPPER_HORSE_ARMOR = MINECRAFT_ITEMS.register("copper_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        EXPOSED_COPPER_HORSE_ARMOR = MINECRAFT_ITEMS.register("exposed_copper_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.EXPOSED_COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        WEATHERED_COPPER_HORSE_ARMOR = MINECRAFT_ITEMS.register("weathered_copper_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.WEATHERED_COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        OXIDIZED_COPPER_HORSE_ARMOR = MINECRAFT_ITEMS.register("oxidized_copper_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.OXIDIZED_COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        COPPER_GOLEM_SPAWN_EGG = MINECRAFT_ITEMS.register("copper_golem_spawn_egg", () -> new net.neoforged.neoforge.common.DeferredSpawnEggItem(ModEntities.COPPER_GOLEM, 12215115, 6106649, new Item.Properties()));

        for (net.minecraft.world.item.DyeColor color : net.minecraft.world.item.DyeColor.values()) {
            HARNESSES.put(color.getName(), MINECRAFT_ITEMS.register(color.getName() + "_harness", () -> new HarnessItem(new Item.Properties().stacksTo(1))));
            BUNDLES.put(color.getName(), MINECRAFT_ITEMS.register(color.getName() + "_bundle", () -> new BundleItem(new Item.Properties().stacksTo(1).component(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY))));
        }

        NETHERITE_HORSE_ARMOR = MINECRAFT_ITEMS.register("netherite_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.NETHERITE_HORSE_ARMOR, AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1).fireResistant()));

        COPPER_NAUTILUS_ARMOR   = MINECRAFT_ITEMS.register("copper_nautilus_armor",   () -> new AnimalArmorItem(ModArmorMaterials.COPPER_NAUTILUS_ARMOR,   AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        IRON_NAUTILUS_ARMOR     = MINECRAFT_ITEMS.register("iron_nautilus_armor",     () -> new AnimalArmorItem(ModArmorMaterials.IRON_NAUTILUS_ARMOR,     AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        GOLDEN_NAUTILUS_ARMOR   = MINECRAFT_ITEMS.register("golden_nautilus_armor",   () -> new AnimalArmorItem(ModArmorMaterials.GOLDEN_NAUTILUS_ARMOR,   AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        DIAMOND_NAUTILUS_ARMOR  = MINECRAFT_ITEMS.register("diamond_nautilus_armor",  () -> new AnimalArmorItem(ModArmorMaterials.DIAMOND_NAUTILUS_ARMOR,  AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1)));
        NETHERITE_NAUTILUS_ARMOR = MINECRAFT_ITEMS.register("netherite_nautilus_armor", () -> new AnimalArmorItem(ModArmorMaterials.NETHERITE_NAUTILUS_ARMOR, AnimalArmorItem.BodyType.EQUESTRIAN, false, (new Item.Properties()).stacksTo(1).fireResistant()));

        PALE_OAK_SIGN = registerMinecraftSign();
        PALE_OAK_HANGING_SIGN = registerMinecraftHangingSign();
        PALE_OAK_BOAT = MINECRAFT_ITEMS.register("pale_oak_boat", () -> new PaleOakBoatItem(false, new Item.Properties().stacksTo(1)));
        PALE_OAK_CHEST_BOAT = MINECRAFT_ITEMS.register("pale_oak_chest_boat", () -> new PaleOakBoatItem(true, new Item.Properties().stacksTo(1)));
        PALE_OAK_SAPLING = registerMinecraftBlockItem();

        registerBlockItem(ModBlocks.STONE_LANTERN);
        registerBlockItem(ModBlocks.IRON_FANCY_LANTERN);
        registerBlockItem(ModBlocks.STARLIGHT_LAMP);
        registerBlockItem(ModBlocks.SPRUCE_LOG_FENCE);
        ModBlocks.FUTONS.values().forEach(ModItems::registerBlockItem);

        // New stone blocks (plain cube-all)
        registerBlockItem(ModBlocks.CHAOTIC_STONE_BRICKS);
        registerBlockItem(ModBlocks.CHAOTIC_MEDIUM_STONE_BRICKS);
        registerBlockItem(ModBlocks.CHAOTIC_SMALL_STONE_BRICKS);
        registerBlockItem(ModBlocks.DIAMOND_STONE_PAVERS);
        registerBlockItem(ModBlocks.ENCASED_STONE_BRICKS);
        registerBlockItem(ModBlocks.FRENCH_STONE);
        registerBlockItem(ModBlocks.LARGE_ORNATE_STONE);
        registerBlockItem(ModBlocks.LARGE_STONE_TILE);
        registerBlockItem(ModBlocks.MESSY_STONE_TILES);
        registerBlockItem(ModBlocks.MOSAIC_STONE);
        registerBlockItem(ModBlocks.NOTCHED_STONE_BRICKS);
        registerBlockItem(ModBlocks.ORNATE_STONE);
        registerBlockItem(ModBlocks.POISON_STONE);
        registerBlockItem(ModBlocks.POLISHED_CUT_STONE);
        registerBlockItem(ModBlocks.POLISHED_STONE_TILES);
        registerBlockItem(ModBlocks.PRISM_STONE);
        registerBlockItem(ModBlocks.SLANTED_STONE);
        registerBlockItem(ModBlocks.STONE_ARRAY);
        registerBlockItem(ModBlocks.STONE_BRAID);
        registerBlockItem(ModBlocks.STONE_DENT);
        registerBlockItem(ModBlocks.STONE_JELLYBEAN);
        registerBlockItem(ModBlocks.STONE_LAYERS);
        registerBlockItem(ModBlocks.STONE_PANEL);
        registerBlockItem(ModBlocks.STONE_ROAD);
        registerBlockItem(ModBlocks.STONE_ZAG);
        registerBlockItem(ModBlocks.SUNKEN_STONE);
        registerBlockItem(ModBlocks.TRIPLE_STONE_BRICKS);
        registerBlockItem(ModBlocks.WEATHERED_STONE_BRICKS);
        registerBlockItem(ModBlocks.WEATHERED_TILED_STONE);
        registerBlockItem(ModBlocks.WEAVER_STONE);
        // New stone blocks (cube-bottom-top)
        registerBlockItem(ModBlocks.CARVED_STONE_CREEPER);
        registerBlockItem(ModBlocks.CARVED_STONE_DERP);
        registerBlockItem(ModBlocks.CARVED_STONE_VILLAGER);
        registerBlockItem(ModBlocks.CARVED_STONE_WITHER);
        registerBlockItem(ModBlocks.CARVED_STONE_WRITING);
        registerBlockItem(ModBlocks.CUT_STONE);
        registerBlockItem(ModBlocks.ROUGH_CUT_STONE);
        // New stone pillars (RotatedPillarBlock)
        registerBlockItem(ModBlocks.SHEARED_STONE_PILLAR);
        registerBlockItem(ModBlocks.SLATED_STONE);
        registerBlockItem(ModBlocks.STONE_COLUMN);
        registerBlockItem(ModBlocks.STONE_TWISTING_COLUMN);
        // Chisel pillar blocks and legend blocks
        registerBlockItem(ModBlocks.CHISELED_STONE_BRICKS_LEGEND);
        ModBlocks.CHISEL_PILLARS.values().forEach(ModItems::registerBlockItem);
        ModBlocks.CHISEL_LEGEND.values().forEach(ModItems::registerBlockItem);

    }

    private static DeferredHolder<Item, BlockItem> registerBlockItem(String name, DeferredBlock<? extends Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static void registerBlockItem(DeferredBlock<? extends Block> block) {
        ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static DeferredItem<Item> registerMinecraftBlockItem() {
        return MINECRAFT_ITEMS.register("pale_oak_sapling", () -> new BlockItem(ModBlocks.PALE_OAK_SAPLING.get(), new Item.Properties()));
    }

    private static DeferredItem<SignItem> registerSign(String name, DeferredBlock<? extends Block> sign, DeferredBlock<? extends Block> wallSign) {
        return ITEMS.register(name, () -> new SignItem(new Item.Properties().stacksTo(16), sign.get(), wallSign.get()));
    }

    private static DeferredItem<SignItem> registerMinecraftSign() {
        return MINECRAFT_ITEMS.register("pale_oak_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PALE_OAK_SIGN.get(), ModBlocks.PALE_OAK_WALL_SIGN.get()));
    }

    private static DeferredItem<HangingSignItem> registerHangingSign(String name, DeferredBlock<? extends Block> sign, DeferredBlock<? extends Block> wallSign) {
        return ITEMS.register(name, () -> new HangingSignItem(sign.get(), wallSign.get(), new Item.Properties().stacksTo(16)));
    }

    private static DeferredItem<HangingSignItem> registerMinecraftHangingSign() {
        return MINECRAFT_ITEMS.register("pale_oak_hanging_sign", () -> new HangingSignItem(ModBlocks.PALE_OAK_HANGING_SIGN.get(), ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    }


}