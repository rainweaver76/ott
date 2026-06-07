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
    public static final DeferredItem<Item> PHEASANT_FEATHER = ITEMS.register("pheasant_feather", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SOUL_GLASS = registerBlockItem("soul_glass", ModBlocks.SOUL_GLASS);
    public static final DeferredHolder<Item, BlockItem> SOUL_GLASS_PANE = registerBlockItem("soul_glass_pane", ModBlocks.SOUL_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SOUL_GLASS_CTM = registerBlockItem("soul_glass_ctm", ModBlocks.SOUL_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SOUL_GLASS_CTM_PANE = registerBlockItem("soul_glass_ctm_pane", ModBlocks.SOUL_GLASS_CTM_PANE);

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
    public static final DeferredHolder<Item, BlockItem> PALE_WILDFLOWERS = registerBlockItem("pale_wildflowers", ModBlocks.PALE_WILDFLOWERS);
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

    public static DeferredItem<ShearsItem> GOLDEN_SHEARS;
    public static DeferredItem<ShearsItem> DIAMOND_SHEARS;
    public static DeferredItem<ShearsItem> NETHERITE_SHEARS;

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
    public static final DeferredHolder<Item, BlockItem> BLACK_LEADED_STAINED_GLASS =
        registerBlockItem("black_leaded_stained_glass", ModBlocks.BLACK_LEADED_STAINED_GLASS);

    // ── Black Terracotta ──

    // ── Black Wool ──

    // ── Blue Concrete ──

    // ── Blue Ice ──

    // ── Blue Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> BLUE_LEADED_STAINED_GLASS =
        registerBlockItem("blue_leaded_stained_glass", ModBlocks.BLUE_LEADED_STAINED_GLASS);

    // ── Blue Terracotta ──

    // ── Blue Wool ──

    // ── Borderless Bricks ──

    // ── Bricks ──

    // ── Brown Concrete ──

    // ── Brown Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> BROWN_LEADED_STAINED_GLASS =
        registerBlockItem("brown_leaded_stained_glass", ModBlocks.BROWN_LEADED_STAINED_GLASS);

    // ── Brown Terracotta ──

    // ── Brown Wool ──

    // ── Calcite ──

    // ── Cherry Planks ──
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

    // ── Coal Block ──

    // ── Cobblestone ──

    // ── Crimson Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_CRIMSON_PLANKS =
        registerBlockItem("cornered_crimson_planks", ModBlocks.CORNERED_CRIMSON_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_CRIMSON_PLANKS =
        registerBlockItem("crated_crimson_planks", ModBlocks.CRATED_CRIMSON_PLANKS);
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

    // ── Cyan Concrete ──

    // ── Cyan Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CYAN_LEADED_STAINED_GLASS =
        registerBlockItem("cyan_leaded_stained_glass", ModBlocks.CYAN_LEADED_STAINED_GLASS);

    // ── Cyan Terracotta ──

    // ── Cyan Wool ──

    // ── Dark Oak Planks ──
    public static final DeferredHolder<Item, BlockItem> CORNERED_DARK_OAK_PLANKS =
        registerBlockItem("cornered_dark_oak_planks", ModBlocks.CORNERED_DARK_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_DARK_OAK_PLANKS =
        registerBlockItem("crated_dark_oak_planks", ModBlocks.CRATED_DARK_OAK_PLANKS);
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

    // ── Deepslate ──

    // ── Diorite ──

    // ── Dirt ──

    // ── Dripstone ──

    // ── End Stone ──

    // ── Gilded Blackston ──

    // ── Granite ──

    // ── Gray Concrete ──

    // ── Gray Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> GRAY_LEADED_STAINED_GLASS =
        registerBlockItem("gray_leaded_stained_glass", ModBlocks.GRAY_LEADED_STAINED_GLASS);

    // ── Gray Terracotta ──

    // ── Gray Wool ──

    // ── Green Concrete ──

    // ── Green Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> GREEN_LEADED_STAINED_GLASS =
        registerBlockItem("green_leaded_stained_glass", ModBlocks.GREEN_LEADED_STAINED_GLASS);

    // ── Green Terracotta ──

    // ── Green Wool ──

    // ── Ice ──

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

    // ── Leaded Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LEADED_STAINED_GLASS =
        registerBlockItem("circular_leaded_stained_glass", ModBlocks.CIRCULAR_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LEADED_GLASS_CTM =
        registerBlockItem("ornate_leaded_glass_ctm", ModBlocks.ORNATE_LEADED_GLASS_CTM);

    // ── Light Blue Concrete ──

    // ── Light Blue Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("circular_light_blue_stained_glass", ModBlocks.CIRCULAR_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("fancy_light_blue_stained_glass_ctm", ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("ornate_light_blue_stained_glass_ctm", ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("raster_light_blue_stained_glass_ctm", ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_light_blue_diamond_stained_glass", ModBlocks.SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("tiled_light_blue_stained_glass_ctm", ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_LEADED_STAINED_GLASS =
        registerBlockItem("light_blue_leaded_stained_glass", ModBlocks.LIGHT_BLUE_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("fancy_light_blue_stained_glass", ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("large_diamond_light_blue_stained_glass", ModBlocks.LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("ornate_light_blue_stained_glass", ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("raster_light_blue_stained_glass", ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("small_light_blue_stained_glass", ModBlocks.SMALL_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("square_light_blue_stained_glass", ModBlocks.SQUARE_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("tiled_light_blue_stained_glass", ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("vertical_striped_light_blue_stained_glass", ModBlocks.VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_LIGHT_BLUE_STAINED_GLASS =
        registerBlockItem("woven_light_blue_stained_glass", ModBlocks.WOVEN_LIGHT_BLUE_STAINED_GLASS);

    // ── Light Blue Terracotta ──

    // ── Light Blue Wool ──

    // ── Light Gray Concrete ──

    // ── Light Gray Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("circular_light_gray_stained_glass", ModBlocks.CIRCULAR_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("fancy_light_gray_stained_glass_ctm", ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("ornate_light_gray_stained_glass_ctm", ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("raster_light_gray_stained_glass_ctm", ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_light_gray_diamond_stained_glass", ModBlocks.SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("tiled_light_gray_stained_glass_ctm", ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_LEADED_STAINED_GLASS =
        registerBlockItem("light_gray_leaded_stained_glass", ModBlocks.LIGHT_GRAY_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("fancy_light_gray_stained_glass", ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("large_diamond_light_gray_stained_glass", ModBlocks.LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("ornate_light_gray_stained_glass", ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("raster_light_gray_stained_glass", ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("small_light_gray_stained_glass", ModBlocks.SMALL_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("square_light_gray_stained_glass", ModBlocks.SQUARE_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("tiled_light_gray_stained_glass", ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("vertical_striped_light_gray_stained_glass", ModBlocks.VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_LIGHT_GRAY_STAINED_GLASS =
        registerBlockItem("woven_light_gray_stained_glass", ModBlocks.WOVEN_LIGHT_GRAY_STAINED_GLASS);

    // ── Light Gray Terracotta ──

    // ── Light Gray Wool ──

    // ── Lime Concrete ──

    // ── Lime Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIME_STAINED_GLASS =
        registerBlockItem("circular_lime_stained_glass", ModBlocks.CIRCULAR_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIME_STAINED_GLASS_CTM =
        registerBlockItem("fancy_lime_stained_glass_ctm", ModBlocks.FANCY_LIME_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIME_STAINED_GLASS_CTM =
        registerBlockItem("ornate_lime_stained_glass_ctm", ModBlocks.ORNATE_LIME_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIME_STAINED_GLASS_CTM =
        registerBlockItem("raster_lime_stained_glass_ctm", ModBlocks.RASTER_LIME_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_lime_diamond_stained_glass", ModBlocks.SMALL_LIME_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIME_STAINED_GLASS_CTM =
        registerBlockItem("tiled_lime_stained_glass_ctm", ModBlocks.TILED_LIME_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> LIME_LEADED_STAINED_GLASS =
        registerBlockItem("lime_leaded_stained_glass", ModBlocks.LIME_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIME_STAINED_GLASS =
        registerBlockItem("fancy_lime_stained_glass", ModBlocks.FANCY_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LIME_STAINED_GLASS =
        registerBlockItem("large_diamond_lime_stained_glass", ModBlocks.LARGE_DIAMOND_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIME_STAINED_GLASS =
        registerBlockItem("ornate_lime_stained_glass", ModBlocks.ORNATE_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIME_STAINED_GLASS =
        registerBlockItem("raster_lime_stained_glass", ModBlocks.RASTER_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_STAINED_GLASS =
        registerBlockItem("small_lime_stained_glass", ModBlocks.SMALL_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LIME_STAINED_GLASS =
        registerBlockItem("square_lime_stained_glass", ModBlocks.SQUARE_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_LIME_STAINED_GLASS =
        registerBlockItem("tiled_lime_stained_glass", ModBlocks.TILED_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_LIME_STAINED_GLASS =
        registerBlockItem("vertical_striped_lime_stained_glass", ModBlocks.VERTICAL_STRIPED_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_LIME_STAINED_GLASS =
        registerBlockItem("woven_lime_stained_glass", ModBlocks.WOVEN_LIME_STAINED_GLASS);

    // ── Lime Terracotta ──

    // ── Lime Wool ──

    // ── Lodestone ──

    // ── Magenta Concrete ──

    // ── Magenta Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_MAGENTA_STAINED_GLASS =
        registerBlockItem("circular_magenta_stained_glass", ModBlocks.CIRCULAR_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_MAGENTA_STAINED_GLASS_CTM =
        registerBlockItem("fancy_magenta_stained_glass_ctm", ModBlocks.FANCY_MAGENTA_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGENTA_STAINED_GLASS_CTM =
        registerBlockItem("ornate_magenta_stained_glass_ctm", ModBlocks.ORNATE_MAGENTA_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_MAGENTA_STAINED_GLASS_CTM =
        registerBlockItem("raster_magenta_stained_glass_ctm", ModBlocks.RASTER_MAGENTA_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_magenta_diamond_stained_glass", ModBlocks.SMALL_MAGENTA_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGENTA_STAINED_GLASS_CTM =
        registerBlockItem("tiled_magenta_stained_glass_ctm", ModBlocks.TILED_MAGENTA_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_LEADED_STAINED_GLASS =
        registerBlockItem("magenta_leaded_stained_glass", ModBlocks.MAGENTA_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_MAGENTA_STAINED_GLASS =
        registerBlockItem("fancy_magenta_stained_glass", ModBlocks.FANCY_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_MAGENTA_STAINED_GLASS =
        registerBlockItem("large_diamond_magenta_stained_glass", ModBlocks.LARGE_DIAMOND_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGENTA_STAINED_GLASS =
        registerBlockItem("ornate_magenta_stained_glass", ModBlocks.ORNATE_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_MAGENTA_STAINED_GLASS =
        registerBlockItem("raster_magenta_stained_glass", ModBlocks.RASTER_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_STAINED_GLASS =
        registerBlockItem("small_magenta_stained_glass", ModBlocks.SMALL_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_MAGENTA_STAINED_GLASS =
        registerBlockItem("square_magenta_stained_glass", ModBlocks.SQUARE_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGENTA_STAINED_GLASS =
        registerBlockItem("tiled_magenta_stained_glass", ModBlocks.TILED_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_MAGENTA_STAINED_GLASS =
        registerBlockItem("vertical_striped_magenta_stained_glass", ModBlocks.VERTICAL_STRIPED_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_MAGENTA_STAINED_GLASS =
        registerBlockItem("woven_magenta_stained_glass", ModBlocks.WOVEN_MAGENTA_STAINED_GLASS);

    // ── Magenta Terracotta ──

    // ── Magenta Wool ──

    // ── Magma Block ──

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
    public static final DeferredHolder<Item, BlockItem> NATURAL_MANGROVE_PLANKS =
        registerBlockItem("natural_mangrove_planks", ModBlocks.NATURAL_MANGROVE_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_MANGROVE_PLANKS =
        registerBlockItem("pegged_mangrove_planks", ModBlocks.PEGGED_MANGROVE_PLANKS);

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
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_ORANGE_STAINED_GLASS =
        registerBlockItem("circular_orange_stained_glass", ModBlocks.CIRCULAR_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_ORANGE_STAINED_GLASS_CTM =
        registerBlockItem("fancy_orange_stained_glass_ctm", ModBlocks.FANCY_ORANGE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ORANGE_STAINED_GLASS_CTM =
        registerBlockItem("ornate_orange_stained_glass_ctm", ModBlocks.ORNATE_ORANGE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_ORANGE_STAINED_GLASS_CTM =
        registerBlockItem("raster_orange_stained_glass_ctm", ModBlocks.RASTER_ORANGE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_orange_diamond_stained_glass", ModBlocks.SMALL_ORANGE_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_ORANGE_STAINED_GLASS_CTM =
        registerBlockItem("tiled_orange_stained_glass_ctm", ModBlocks.TILED_ORANGE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORANGE_LEADED_STAINED_GLASS =
        registerBlockItem("orange_leaded_stained_glass", ModBlocks.ORANGE_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_ORANGE_STAINED_GLASS =
        registerBlockItem("fancy_orange_stained_glass", ModBlocks.FANCY_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_ORANGE_STAINED_GLASS =
        registerBlockItem("large_diamond_orange_stained_glass", ModBlocks.LARGE_DIAMOND_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ORANGE_STAINED_GLASS =
        registerBlockItem("ornate_orange_stained_glass", ModBlocks.ORNATE_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_ORANGE_STAINED_GLASS =
        registerBlockItem("raster_orange_stained_glass", ModBlocks.RASTER_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_STAINED_GLASS =
        registerBlockItem("small_orange_stained_glass", ModBlocks.SMALL_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_ORANGE_STAINED_GLASS =
        registerBlockItem("square_orange_stained_glass", ModBlocks.SQUARE_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_ORANGE_STAINED_GLASS =
        registerBlockItem("tiled_orange_stained_glass", ModBlocks.TILED_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_ORANGE_STAINED_GLASS =
        registerBlockItem("vertical_striped_orange_stained_glass", ModBlocks.VERTICAL_STRIPED_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_ORANGE_STAINED_GLASS =
        registerBlockItem("woven_orange_stained_glass", ModBlocks.WOVEN_ORANGE_STAINED_GLASS);

    // ── Orange Terracotta ──

    // ── Orange Wool ──

    // ── Packed Ice ──

    // ── Packed Mud ──

    // ── Pink Concrete ──

    // ── Pink Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PINK_STAINED_GLASS =
        registerBlockItem("circular_pink_stained_glass", ModBlocks.CIRCULAR_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_PINK_STAINED_GLASS_CTM =
        registerBlockItem("fancy_pink_stained_glass_ctm", ModBlocks.FANCY_PINK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PINK_STAINED_GLASS_CTM =
        registerBlockItem("ornate_pink_stained_glass_ctm", ModBlocks.ORNATE_PINK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_PINK_STAINED_GLASS_CTM =
        registerBlockItem("raster_pink_stained_glass_ctm", ModBlocks.RASTER_PINK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_pink_diamond_stained_glass", ModBlocks.SMALL_PINK_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_PINK_STAINED_GLASS_CTM =
        registerBlockItem("tiled_pink_stained_glass_ctm", ModBlocks.TILED_PINK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> PINK_LEADED_STAINED_GLASS =
        registerBlockItem("pink_leaded_stained_glass", ModBlocks.PINK_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_PINK_STAINED_GLASS =
        registerBlockItem("fancy_pink_stained_glass", ModBlocks.FANCY_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_PINK_STAINED_GLASS =
        registerBlockItem("large_diamond_pink_stained_glass", ModBlocks.LARGE_DIAMOND_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PINK_STAINED_GLASS =
        registerBlockItem("ornate_pink_stained_glass", ModBlocks.ORNATE_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_PINK_STAINED_GLASS =
        registerBlockItem("raster_pink_stained_glass", ModBlocks.RASTER_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_STAINED_GLASS =
        registerBlockItem("small_pink_stained_glass", ModBlocks.SMALL_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_PINK_STAINED_GLASS =
        registerBlockItem("square_pink_stained_glass", ModBlocks.SQUARE_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_PINK_STAINED_GLASS =
        registerBlockItem("tiled_pink_stained_glass", ModBlocks.TILED_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_PINK_STAINED_GLASS =
        registerBlockItem("vertical_striped_pink_stained_glass", ModBlocks.VERTICAL_STRIPED_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_PINK_STAINED_GLASS =
        registerBlockItem("woven_pink_stained_glass", ModBlocks.WOVEN_PINK_STAINED_GLASS);

    // ── Pink Terracotta ──

    // ── Pink Wool ──

    // ── Prismarine ──

    // ── Purple Concrete ──

    // ── Purple Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PURPLE_STAINED_GLASS =
        registerBlockItem("circular_purple_stained_glass", ModBlocks.CIRCULAR_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_PURPLE_STAINED_GLASS_CTM =
        registerBlockItem("fancy_purple_stained_glass_ctm", ModBlocks.FANCY_PURPLE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPLE_STAINED_GLASS_CTM =
        registerBlockItem("ornate_purple_stained_glass_ctm", ModBlocks.ORNATE_PURPLE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_PURPLE_STAINED_GLASS_CTM =
        registerBlockItem("raster_purple_stained_glass_ctm", ModBlocks.RASTER_PURPLE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_purple_diamond_stained_glass", ModBlocks.SMALL_PURPLE_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPLE_STAINED_GLASS_CTM =
        registerBlockItem("tiled_purple_stained_glass_ctm", ModBlocks.TILED_PURPLE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> PURPLE_LEADED_STAINED_GLASS =
        registerBlockItem("purple_leaded_stained_glass", ModBlocks.PURPLE_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_PURPLE_STAINED_GLASS =
        registerBlockItem("fancy_purple_stained_glass", ModBlocks.FANCY_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_PURPLE_STAINED_GLASS =
        registerBlockItem("large_diamond_purple_stained_glass", ModBlocks.LARGE_DIAMOND_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPLE_STAINED_GLASS =
        registerBlockItem("ornate_purple_stained_glass", ModBlocks.ORNATE_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_PURPLE_STAINED_GLASS =
        registerBlockItem("raster_purple_stained_glass", ModBlocks.RASTER_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_STAINED_GLASS =
        registerBlockItem("small_purple_stained_glass", ModBlocks.SMALL_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_PURPLE_STAINED_GLASS =
        registerBlockItem("square_purple_stained_glass", ModBlocks.SQUARE_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPLE_STAINED_GLASS =
        registerBlockItem("tiled_purple_stained_glass", ModBlocks.TILED_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_PURPLE_STAINED_GLASS =
        registerBlockItem("vertical_striped_purple_stained_glass", ModBlocks.VERTICAL_STRIPED_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_PURPLE_STAINED_GLASS =
        registerBlockItem("woven_purple_stained_glass", ModBlocks.WOVEN_PURPLE_STAINED_GLASS);

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
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_RED_STAINED_GLASS =
        registerBlockItem("circular_red_stained_glass", ModBlocks.CIRCULAR_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_RED_STAINED_GLASS_CTM =
        registerBlockItem("fancy_red_stained_glass_ctm", ModBlocks.FANCY_RED_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_STAINED_GLASS_CTM =
        registerBlockItem("ornate_red_stained_glass_ctm", ModBlocks.ORNATE_RED_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_RED_STAINED_GLASS_CTM =
        registerBlockItem("raster_red_stained_glass_ctm", ModBlocks.RASTER_RED_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_red_diamond_stained_glass", ModBlocks.SMALL_RED_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_STAINED_GLASS_CTM =
        registerBlockItem("tiled_red_stained_glass_ctm", ModBlocks.TILED_RED_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RED_LEADED_STAINED_GLASS =
        registerBlockItem("red_leaded_stained_glass", ModBlocks.RED_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_RED_STAINED_GLASS =
        registerBlockItem("fancy_red_stained_glass", ModBlocks.FANCY_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_RED_STAINED_GLASS =
        registerBlockItem("large_diamond_red_stained_glass", ModBlocks.LARGE_DIAMOND_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_STAINED_GLASS =
        registerBlockItem("ornate_red_stained_glass", ModBlocks.ORNATE_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_RED_STAINED_GLASS =
        registerBlockItem("raster_red_stained_glass", ModBlocks.RASTER_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_STAINED_GLASS =
        registerBlockItem("small_red_stained_glass", ModBlocks.SMALL_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_RED_STAINED_GLASS =
        registerBlockItem("square_red_stained_glass", ModBlocks.SQUARE_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_STAINED_GLASS =
        registerBlockItem("tiled_red_stained_glass", ModBlocks.TILED_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_RED_STAINED_GLASS =
        registerBlockItem("vertical_striped_red_stained_glass", ModBlocks.VERTICAL_STRIPED_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_RED_STAINED_GLASS =
        registerBlockItem("woven_red_stained_glass", ModBlocks.WOVEN_RED_STAINED_GLASS);

    // ── Red Terracotta ──

    // ── Red Wool ──

    // ── Sandstone ──

    // ── Smooth Stone ──

    // ── Snow Block ──

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
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_SPRUCE_PLANKS =
        registerBlockItem("whirlwind_spruce_planks", ModBlocks.WHIRLWIND_SPRUCE_PLANKS);

    // ── Terracotta ──

    // ── Tuff ──

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
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_WARPED_PLANKS =
        registerBlockItem("whirlwind_warped_planks", ModBlocks.WHIRLWIND_WARPED_PLANKS);

    // ── White Concrete ──

    // ── White Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_WHITE_STAINED_GLASS =
        registerBlockItem("circular_white_stained_glass", ModBlocks.CIRCULAR_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_WHITE_STAINED_GLASS_CTM =
        registerBlockItem("fancy_white_stained_glass_ctm", ModBlocks.FANCY_WHITE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_WHITE_STAINED_GLASS_CTM =
        registerBlockItem("ornate_white_stained_glass_ctm", ModBlocks.ORNATE_WHITE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_WHITE_STAINED_GLASS_CTM =
        registerBlockItem("raster_white_stained_glass_ctm", ModBlocks.RASTER_WHITE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_white_diamond_stained_glass", ModBlocks.SMALL_WHITE_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_WHITE_STAINED_GLASS_CTM =
        registerBlockItem("tiled_white_stained_glass_ctm", ModBlocks.TILED_WHITE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> WHITE_LEADED_STAINED_GLASS =
        registerBlockItem("white_leaded_stained_glass", ModBlocks.WHITE_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_WHITE_STAINED_GLASS =
        registerBlockItem("fancy_white_stained_glass", ModBlocks.FANCY_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_WHITE_STAINED_GLASS =
        registerBlockItem("large_diamond_white_stained_glass", ModBlocks.LARGE_DIAMOND_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_WHITE_STAINED_GLASS =
        registerBlockItem("ornate_white_stained_glass", ModBlocks.ORNATE_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_WHITE_STAINED_GLASS =
        registerBlockItem("raster_white_stained_glass", ModBlocks.RASTER_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_STAINED_GLASS =
        registerBlockItem("small_white_stained_glass", ModBlocks.SMALL_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_WHITE_STAINED_GLASS =
        registerBlockItem("square_white_stained_glass", ModBlocks.SQUARE_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_WHITE_STAINED_GLASS =
        registerBlockItem("tiled_white_stained_glass", ModBlocks.TILED_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_WHITE_STAINED_GLASS =
        registerBlockItem("vertical_striped_white_stained_glass", ModBlocks.VERTICAL_STRIPED_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_WHITE_STAINED_GLASS =
        registerBlockItem("woven_white_stained_glass", ModBlocks.WOVEN_WHITE_STAINED_GLASS);

    // ── White Terracotta ──

    // ── White Wool ──

    // ── Yellow Concrete ──

    // ── Yellow Stained Glass ──
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_YELLOW_STAINED_GLASS =
        registerBlockItem("circular_yellow_stained_glass", ModBlocks.CIRCULAR_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_YELLOW_STAINED_GLASS_CTM =
        registerBlockItem("fancy_yellow_stained_glass_ctm", ModBlocks.FANCY_YELLOW_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_YELLOW_STAINED_GLASS_CTM =
        registerBlockItem("ornate_yellow_stained_glass_ctm", ModBlocks.ORNATE_YELLOW_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_YELLOW_STAINED_GLASS_CTM =
        registerBlockItem("raster_yellow_stained_glass_ctm", ModBlocks.RASTER_YELLOW_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_yellow_diamond_stained_glass", ModBlocks.SMALL_YELLOW_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_YELLOW_STAINED_GLASS_CTM =
        registerBlockItem("tiled_yellow_stained_glass_ctm", ModBlocks.TILED_YELLOW_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> YELLOW_LEADED_STAINED_GLASS =
        registerBlockItem("yellow_leaded_stained_glass", ModBlocks.YELLOW_LEADED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_YELLOW_STAINED_GLASS =
        registerBlockItem("fancy_yellow_stained_glass", ModBlocks.FANCY_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_YELLOW_STAINED_GLASS =
        registerBlockItem("large_diamond_yellow_stained_glass", ModBlocks.LARGE_DIAMOND_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_YELLOW_STAINED_GLASS =
        registerBlockItem("ornate_yellow_stained_glass", ModBlocks.ORNATE_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_YELLOW_STAINED_GLASS =
        registerBlockItem("raster_yellow_stained_glass", ModBlocks.RASTER_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_STAINED_GLASS =
        registerBlockItem("small_yellow_stained_glass", ModBlocks.SMALL_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_YELLOW_STAINED_GLASS =
        registerBlockItem("square_yellow_stained_glass", ModBlocks.SQUARE_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_YELLOW_STAINED_GLASS =
        registerBlockItem("tiled_yellow_stained_glass", ModBlocks.TILED_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_YELLOW_STAINED_GLASS =
        registerBlockItem("vertical_striped_yellow_stained_glass", ModBlocks.VERTICAL_STRIPED_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_YELLOW_STAINED_GLASS =
        registerBlockItem("woven_yellow_stained_glass", ModBlocks.WOVEN_YELLOW_STAINED_GLASS);

    // ── Yellow Terracotta ──

    // ── Yellow Wool ──

    // ── New CTM batch blocks ──────────────────────────────────────────────
    public static final DeferredHolder<Item, BlockItem> BLACK_FRAMED_GLASS = registerBlockItem("black_framed_glass", ModBlocks.BLACK_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> BLACK_STAINED_CLEAR_GLASS = registerBlockItem("black_stained_clear_glass", ModBlocks.BLACK_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> BLUE_FRAMED_GLASS = registerBlockItem("blue_framed_glass", ModBlocks.BLUE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> BLUE_STAINED_CLEAR_GLASS = registerBlockItem("blue_stained_clear_glass", ModBlocks.BLUE_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> BROWN_FRAMED_GLASS = registerBlockItem("brown_framed_glass", ModBlocks.BROWN_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> BROWN_STAINED_CLEAR_GLASS = registerBlockItem("brown_stained_clear_glass", ModBlocks.BROWN_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> CHISELED_GLASS = registerBlockItem("chiseled_glass", ModBlocks.CHISELED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CLEAR_GLASS = registerBlockItem("clear_glass", ModBlocks.CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> CYAN_FRAMED_GLASS = registerBlockItem("cyan_framed_glass", ModBlocks.CYAN_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CYAN_STAINED_CLEAR_GLASS = registerBlockItem("cyan_stained_clear_glass", ModBlocks.CYAN_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> DIRTY_GLASS = registerBlockItem("dirty_glass", ModBlocks.DIRTY_GLASS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_GLASS = registerBlockItem("framed_glass", ModBlocks.FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FROSTED_GLASS = registerBlockItem("frosted_glass", ModBlocks.FROSTED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_BLACK_STAINED_GLASS = registerBlockItem("golden_framed_black_stained_glass", ModBlocks.GOLDEN_FRAMED_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_BLUE_STAINED_GLASS = registerBlockItem("golden_framed_blue_stained_glass", ModBlocks.GOLDEN_FRAMED_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_BROWN_STAINED_GLASS = registerBlockItem("golden_framed_brown_stained_glass", ModBlocks.GOLDEN_FRAMED_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_CYAN_STAINED_GLASS = registerBlockItem("golden_framed_cyan_stained_glass", ModBlocks.GOLDEN_FRAMED_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_GRAY_STAINED_GLASS = registerBlockItem("golden_framed_gray_stained_glass", ModBlocks.GOLDEN_FRAMED_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_GREEN_STAINED_GLASS = registerBlockItem("golden_framed_green_stained_glass", ModBlocks.GOLDEN_FRAMED_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS = registerBlockItem("golden_framed_light_blue_stained_glass", ModBlocks.GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS = registerBlockItem("golden_framed_light_gray_stained_glass", ModBlocks.GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_LIME_STAINED_GLASS = registerBlockItem("golden_framed_lime_stained_glass", ModBlocks.GOLDEN_FRAMED_LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_MAGENTA_STAINED_GLASS = registerBlockItem("golden_framed_magenta_stained_glass", ModBlocks.GOLDEN_FRAMED_MAGENTA_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_ORANGE_STAINED_GLASS = registerBlockItem("golden_framed_orange_stained_glass", ModBlocks.GOLDEN_FRAMED_ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_PINK_STAINED_GLASS = registerBlockItem("golden_framed_pink_stained_glass", ModBlocks.GOLDEN_FRAMED_PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_PURPLE_STAINED_GLASS = registerBlockItem("golden_framed_purple_stained_glass", ModBlocks.GOLDEN_FRAMED_PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_RED_STAINED_GLASS = registerBlockItem("golden_framed_red_stained_glass", ModBlocks.GOLDEN_FRAMED_RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_STAINED_GLASS = registerBlockItem("golden_framed_stained_glass", ModBlocks.GOLDEN_FRAMED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_WHITE_STAINED_GLASS = registerBlockItem("golden_framed_white_stained_glass", ModBlocks.GOLDEN_FRAMED_WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_YELLOW_STAINED_GLASS = registerBlockItem("golden_framed_yellow_stained_glass", ModBlocks.GOLDEN_FRAMED_YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GRAY_FRAMED_GLASS = registerBlockItem("gray_framed_glass", ModBlocks.GRAY_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GRAY_STAINED_CLEAR_GLASS = registerBlockItem("gray_stained_clear_glass", ModBlocks.GRAY_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> GREEN_FRAMED_GLASS = registerBlockItem("green_framed_glass", ModBlocks.GREEN_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GREEN_STAINED_CLEAR_GLASS = registerBlockItem("green_stained_clear_glass", ModBlocks.GREEN_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_FRAMED_GLASS = registerBlockItem("light_blue_framed_glass", ModBlocks.LIGHT_BLUE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_STAINED_CLEAR_GLASS = registerBlockItem("light_blue_stained_clear_glass", ModBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_FRAMED_GLASS = registerBlockItem("light_gray_framed_glass", ModBlocks.LIGHT_GRAY_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_STAINED_CLEAR_GLASS = registerBlockItem("light_gray_stained_clear_glass", ModBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIME_FRAMED_GLASS = registerBlockItem("lime_framed_glass", ModBlocks.LIME_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIME_STAINED_CLEAR_GLASS = registerBlockItem("lime_stained_clear_glass", ModBlocks.LIME_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FRAMED_GLASS = registerBlockItem("magenta_framed_glass", ModBlocks.MAGENTA_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_STAINED_CLEAR_GLASS = registerBlockItem("magenta_stained_clear_glass", ModBlocks.MAGENTA_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_FRAMED_GLASS = registerBlockItem("obsidian_framed_glass", ModBlocks.OBSIDIAN_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORANGE_FRAMED_GLASS = registerBlockItem("orange_framed_glass", ModBlocks.ORANGE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORANGE_STAINED_CLEAR_GLASS = registerBlockItem("orange_stained_clear_glass", ModBlocks.ORANGE_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_BRICK_PATTERN = registerBlockItem("pale_oak_planks_brick_pattern", ModBlocks.PALE_OAK_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PINK_FRAMED_GLASS = registerBlockItem("pink_framed_glass", ModBlocks.PINK_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> PINK_STAINED_CLEAR_GLASS = registerBlockItem("pink_stained_clear_glass", ModBlocks.PINK_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_LIMESTONE = registerBlockItem("polished_limestone", ModBlocks.POLISHED_LIMESTONE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_FRAMED_GLASS = registerBlockItem("purple_framed_glass", ModBlocks.PURPLE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> PURPLE_STAINED_CLEAR_GLASS = registerBlockItem("purple_stained_clear_glass", ModBlocks.PURPLE_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> RED_FRAMED_GLASS = registerBlockItem("red_framed_glass", ModBlocks.RED_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RED_STAINED_CLEAR_GLASS = registerBlockItem("red_stained_clear_glass", ModBlocks.RED_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_FRAMED_GLASS = registerBlockItem("sandstone_framed_glass", ModBlocks.SANDSTONE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SEA_LANTERN = registerBlockItem("sea_lantern", ModBlocks.SEA_LANTERN);
    public static final DeferredHolder<Item, BlockItem> STONE_FRAMED_GLASS = registerBlockItem("stone_framed_glass", ModBlocks.STONE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TINTED_CLEAR_GLASS = registerBlockItem("tinted_clear_glass", ModBlocks.TINTED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> WHITE_FRAMED_GLASS = registerBlockItem("white_framed_glass", ModBlocks.WHITE_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WHITE_STAINED_CLEAR_GLASS = registerBlockItem("white_stained_clear_glass", ModBlocks.WHITE_STAINED_CLEAR_GLASS);
    public static final DeferredHolder<Item, BlockItem> YELLOW_FRAMED_GLASS = registerBlockItem("yellow_framed_glass", ModBlocks.YELLOW_FRAMED_GLASS);
    public static final DeferredHolder<Item, BlockItem> YELLOW_STAINED_CLEAR_GLASS = registerBlockItem("yellow_stained_clear_glass", ModBlocks.YELLOW_STAINED_CLEAR_GLASS);

    public static final DeferredHolder<Item, BlockItem> BLACK_STAINED_GLASS = registerBlockItem("black_stained_glass", ModBlocks.BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> BLUE_STAINED_GLASS = registerBlockItem("blue_stained_glass", ModBlocks.BLUE_STAINED_GLASS);


    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS = registerBlockItem("borderless_glass", ModBlocks.BORDERLESS_GLASS);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_BLACK = registerBlockItem("borderless_glass_black", ModBlocks.BORDERLESS_GLASS_BLACK);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_BLUE = registerBlockItem("borderless_glass_blue", ModBlocks.BORDERLESS_GLASS_BLUE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_BROWN = registerBlockItem("borderless_glass_brown", ModBlocks.BORDERLESS_GLASS_BROWN);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_CYAN = registerBlockItem("borderless_glass_cyan", ModBlocks.BORDERLESS_GLASS_CYAN);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_GRAY = registerBlockItem("borderless_glass_gray", ModBlocks.BORDERLESS_GLASS_GRAY);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_GREEN = registerBlockItem("borderless_glass_green", ModBlocks.BORDERLESS_GLASS_GREEN);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_LIGHT_BLUE = registerBlockItem("borderless_glass_light_blue", ModBlocks.BORDERLESS_GLASS_LIGHT_BLUE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_LIGHT_GRAY = registerBlockItem("borderless_glass_light_gray", ModBlocks.BORDERLESS_GLASS_LIGHT_GRAY);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_LIME = registerBlockItem("borderless_glass_lime", ModBlocks.BORDERLESS_GLASS_LIME);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_MAGENTA = registerBlockItem("borderless_glass_magenta", ModBlocks.BORDERLESS_GLASS_MAGENTA);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_ORANGE = registerBlockItem("borderless_glass_orange", ModBlocks.BORDERLESS_GLASS_ORANGE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_PINK = registerBlockItem("borderless_glass_pink", ModBlocks.BORDERLESS_GLASS_PINK);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_PURPLE = registerBlockItem("borderless_glass_purple", ModBlocks.BORDERLESS_GLASS_PURPLE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_RED = registerBlockItem("borderless_glass_red", ModBlocks.BORDERLESS_GLASS_RED);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_WHITE = registerBlockItem("borderless_glass_white", ModBlocks.BORDERLESS_GLASS_WHITE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_YELLOW = registerBlockItem("borderless_glass_yellow", ModBlocks.BORDERLESS_GLASS_YELLOW);
    public static final DeferredHolder<Item, BlockItem> BROWN_STAINED_GLASS = registerBlockItem("brown_stained_glass", ModBlocks.BROWN_STAINED_GLASS);



    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK = registerBlockItem("copper_block", ModBlocks.COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> COPPER_GRATE = registerBlockItem("copper_grate", ModBlocks.COPPER_GRATE);
    public static final DeferredHolder<Item, BlockItem> CYAN_STAINED_GLASS = registerBlockItem("cyan_stained_glass", ModBlocks.CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> EXPOSED_COPPER_BLOCK = registerBlockItem("exposed_copper_block", ModBlocks.EXPOSED_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> EXPOSED_COPPER_GRATE = registerBlockItem("exposed_copper_grate", ModBlocks.EXPOSED_COPPER_GRATE);
    public static final DeferredHolder<Item, BlockItem> GRAY_STAINED_GLASS = registerBlockItem("gray_stained_glass", ModBlocks.GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GREEN_STAINED_GLASS = registerBlockItem("green_stained_glass", ModBlocks.GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ICE_GLASS = registerBlockItem("ice_glass", ModBlocks.ICE_GLASS);

    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_STAINED_GLASS = registerBlockItem("light_blue_stained_glass", ModBlocks.LIGHT_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_STAINED_GLASS = registerBlockItem("light_gray_stained_glass", ModBlocks.LIGHT_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LIME_STAINED_GLASS = registerBlockItem("lime_stained_glass", ModBlocks.LIME_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_STAINED_GLASS = registerBlockItem("magenta_stained_glass", ModBlocks.MAGENTA_STAINED_GLASS);

    public static final DeferredHolder<Item, BlockItem> ORANGE_STAINED_GLASS = registerBlockItem("orange_stained_glass", ModBlocks.ORANGE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OXIDIZED_COPPER_BLOCK = registerBlockItem("oxidized_copper_block", ModBlocks.OXIDIZED_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> OXIDIZED_COPPER_GRATE = registerBlockItem("oxidized_copper_grate", ModBlocks.OXIDIZED_COPPER_GRATE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_BEAMS = registerBlockItem("pale_oak_planks_beams", ModBlocks.PALE_OAK_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_BRICK_PAVING = registerBlockItem("pale_oak_planks_brick_paving", ModBlocks.PALE_OAK_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_CRATE = registerBlockItem("pale_oak_planks_crate", ModBlocks.PALE_OAK_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_DIAGONAL_STRIPES = registerBlockItem("pale_oak_planks_diagonal_stripes", ModBlocks.PALE_OAK_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_DIAGONAL_TILES = registerBlockItem("pale_oak_planks_diagonal_tiles", ModBlocks.PALE_OAK_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_DOTTED = registerBlockItem("pale_oak_planks_dotted", ModBlocks.PALE_OAK_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_FLOORING = registerBlockItem("pale_oak_planks_flooring", ModBlocks.PALE_OAK_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_LARGE_TILES = registerBlockItem("pale_oak_planks_large_tiles", ModBlocks.PALE_OAK_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_PATTERN = registerBlockItem("pale_oak_planks_pattern", ModBlocks.PALE_OAK_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_ROTATED_BRICKS = registerBlockItem("pale_oak_planks_rotated_bricks", ModBlocks.PALE_OAK_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_SMALL_BRICKS = registerBlockItem("pale_oak_planks_small_bricks", ModBlocks.PALE_OAK_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_SMALL_TILES = registerBlockItem("pale_oak_planks_small_tiles", ModBlocks.PALE_OAK_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_SQUARES = registerBlockItem("pale_oak_planks_squares", ModBlocks.PALE_OAK_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_TILES = registerBlockItem("pale_oak_planks_tiles", ModBlocks.PALE_OAK_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_WAVY = registerBlockItem("pale_oak_planks_wavy", ModBlocks.PALE_OAK_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_WOVEN = registerBlockItem("pale_oak_planks_woven", ModBlocks.PALE_OAK_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> PINK_STAINED_GLASS = registerBlockItem("pink_stained_glass", ModBlocks.PINK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> PURPLE_STAINED_GLASS = registerBlockItem("purple_stained_glass", ModBlocks.PURPLE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RED_STAINED_GLASS = registerBlockItem("red_stained_glass", ModBlocks.RED_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> REINFORCED_GLASS = registerBlockItem("reinforced_glass", ModBlocks.REINFORCED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS = registerBlockItem("scratched_glass", ModBlocks.SCRATCHED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_BLACK = registerBlockItem("scratched_glass_black", ModBlocks.SCRATCHED_GLASS_BLACK);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_BLUE = registerBlockItem("scratched_glass_blue", ModBlocks.SCRATCHED_GLASS_BLUE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_BROWN = registerBlockItem("scratched_glass_brown", ModBlocks.SCRATCHED_GLASS_BROWN);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_CYAN = registerBlockItem("scratched_glass_cyan", ModBlocks.SCRATCHED_GLASS_CYAN);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_GRAY = registerBlockItem("scratched_glass_gray", ModBlocks.SCRATCHED_GLASS_GRAY);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_GREEN = registerBlockItem("scratched_glass_green", ModBlocks.SCRATCHED_GLASS_GREEN);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_LIGHT_BLUE = registerBlockItem("scratched_glass_light_blue", ModBlocks.SCRATCHED_GLASS_LIGHT_BLUE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_LIGHT_GRAY = registerBlockItem("scratched_glass_light_gray", ModBlocks.SCRATCHED_GLASS_LIGHT_GRAY);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_LIME = registerBlockItem("scratched_glass_lime", ModBlocks.SCRATCHED_GLASS_LIME);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_MAGENTA = registerBlockItem("scratched_glass_magenta", ModBlocks.SCRATCHED_GLASS_MAGENTA);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_ORANGE = registerBlockItem("scratched_glass_orange", ModBlocks.SCRATCHED_GLASS_ORANGE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_PINK = registerBlockItem("scratched_glass_pink", ModBlocks.SCRATCHED_GLASS_PINK);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_PURPLE = registerBlockItem("scratched_glass_purple", ModBlocks.SCRATCHED_GLASS_PURPLE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_RED = registerBlockItem("scratched_glass_red", ModBlocks.SCRATCHED_GLASS_RED);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_WHITE = registerBlockItem("scratched_glass_white", ModBlocks.SCRATCHED_GLASS_WHITE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_YELLOW = registerBlockItem("scratched_glass_yellow", ModBlocks.SCRATCHED_GLASS_YELLOW);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS = registerBlockItem("tinted_borderless_glass", ModBlocks.TINTED_BORDERLESS_GLASS);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_BLACK = registerBlockItem("tinted_borderless_glass_black", ModBlocks.TINTED_BORDERLESS_GLASS_BLACK);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_BLUE = registerBlockItem("tinted_borderless_glass_blue", ModBlocks.TINTED_BORDERLESS_GLASS_BLUE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_BROWN = registerBlockItem("tinted_borderless_glass_brown", ModBlocks.TINTED_BORDERLESS_GLASS_BROWN);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_CYAN = registerBlockItem("tinted_borderless_glass_cyan", ModBlocks.TINTED_BORDERLESS_GLASS_CYAN);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_GRAY = registerBlockItem("tinted_borderless_glass_gray", ModBlocks.TINTED_BORDERLESS_GLASS_GRAY);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_GREEN = registerBlockItem("tinted_borderless_glass_green", ModBlocks.TINTED_BORDERLESS_GLASS_GREEN);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_LIGHT_BLUE = registerBlockItem("tinted_borderless_glass_light_blue", ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_BLUE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_LIGHT_GRAY = registerBlockItem("tinted_borderless_glass_light_gray", ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_GRAY);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_LIME = registerBlockItem("tinted_borderless_glass_lime", ModBlocks.TINTED_BORDERLESS_GLASS_LIME);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_MAGENTA = registerBlockItem("tinted_borderless_glass_magenta", ModBlocks.TINTED_BORDERLESS_GLASS_MAGENTA);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_ORANGE = registerBlockItem("tinted_borderless_glass_orange", ModBlocks.TINTED_BORDERLESS_GLASS_ORANGE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_PINK = registerBlockItem("tinted_borderless_glass_pink", ModBlocks.TINTED_BORDERLESS_GLASS_PINK);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_PURPLE = registerBlockItem("tinted_borderless_glass_purple", ModBlocks.TINTED_BORDERLESS_GLASS_PURPLE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_RED = registerBlockItem("tinted_borderless_glass_red", ModBlocks.TINTED_BORDERLESS_GLASS_RED);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_WHITE = registerBlockItem("tinted_borderless_glass_white", ModBlocks.TINTED_BORDERLESS_GLASS_WHITE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_YELLOW = registerBlockItem("tinted_borderless_glass_yellow", ModBlocks.TINTED_BORDERLESS_GLASS_YELLOW);
    public static final DeferredHolder<Item, BlockItem> TINTED_GLASS = registerBlockItem("tinted_glass", ModBlocks.TINTED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WEATHERED_COPPER_BLOCK = registerBlockItem("weathered_copper_block", ModBlocks.WEATHERED_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> WEATHERED_COPPER_GRATE = registerBlockItem("weathered_copper_grate", ModBlocks.WEATHERED_COPPER_GRATE);
    public static final DeferredHolder<Item, BlockItem> WHITE_STAINED_GLASS = registerBlockItem("white_stained_glass", ModBlocks.WHITE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> YELLOW_STAINED_GLASS = registerBlockItem("yellow_stained_glass", ModBlocks.YELLOW_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_PLANKS_BRICKS = registerBlockItem("pale_oak_planks_bricks", ModBlocks.PALE_OAK_PLANKS_BRICKS);
    // ── Bamboo Windows CTM ──
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_BARS_CTM = registerBlockItem("bamboo_window_bars_ctm", ModBlocks.BAMBOO_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_COVERED_CTM = registerBlockItem("bamboo_window_covered_ctm", ModBlocks.BAMBOO_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_DIAGONAL_CTM = registerBlockItem("bamboo_window_diagonal_ctm", ModBlocks.BAMBOO_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_LARGE_CTM = registerBlockItem("bamboo_window_large_ctm", ModBlocks.BAMBOO_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_PANES_CTM = registerBlockItem("bamboo_window_panes_ctm", ModBlocks.BAMBOO_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_ROUNDED_CTM = registerBlockItem("bamboo_window_rounded_ctm", ModBlocks.BAMBOO_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SLIM_CTM = registerBlockItem("bamboo_window_slim_ctm", ModBlocks.BAMBOO_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SWIRLING_CTM = registerBlockItem("bamboo_window_swirling_ctm", ModBlocks.BAMBOO_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_TILES_CTM = registerBlockItem("bamboo_window_tiles_ctm", ModBlocks.BAMBOO_WINDOW_TILES_CTM);
    // ── Cherry Windows CTM ──
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_BARS_CTM = registerBlockItem("cherry_window_bars_ctm", ModBlocks.CHERRY_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_COVERED_CTM = registerBlockItem("cherry_window_covered_ctm", ModBlocks.CHERRY_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_DIAGONAL_CTM = registerBlockItem("cherry_window_diagonal_ctm", ModBlocks.CHERRY_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_LARGE_CTM = registerBlockItem("cherry_window_large_ctm", ModBlocks.CHERRY_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_PANES_CTM = registerBlockItem("cherry_window_panes_ctm", ModBlocks.CHERRY_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_ROUNDED_CTM = registerBlockItem("cherry_window_rounded_ctm", ModBlocks.CHERRY_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SLIM_CTM = registerBlockItem("cherry_window_slim_ctm", ModBlocks.CHERRY_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SWIRLING_CTM = registerBlockItem("cherry_window_swirling_ctm", ModBlocks.CHERRY_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_TILES_CTM = registerBlockItem("cherry_window_tiles_ctm", ModBlocks.CHERRY_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_BARS_CTM = registerBlockItem("pale_oak_window_bars_ctm", ModBlocks.PALE_OAK_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_COVERED_CTM = registerBlockItem("pale_oak_window_covered_ctm", ModBlocks.PALE_OAK_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_DIAGONAL_CTM = registerBlockItem("pale_oak_window_diagonal_ctm", ModBlocks.PALE_OAK_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_LARGE_CTM = registerBlockItem("pale_oak_window_large_ctm", ModBlocks.PALE_OAK_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_PANES_CTM = registerBlockItem("pale_oak_window_panes_ctm", ModBlocks.PALE_OAK_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_ROUNDED_CTM = registerBlockItem("pale_oak_window_rounded_ctm", ModBlocks.PALE_OAK_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SLIM_CTM = registerBlockItem("pale_oak_window_slim_ctm", ModBlocks.PALE_OAK_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SWIRLING_CTM = registerBlockItem("pale_oak_window_swirling_ctm", ModBlocks.PALE_OAK_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_TILES_CTM = registerBlockItem("pale_oak_window_tiles_ctm", ModBlocks.PALE_OAK_WINDOW_TILES_CTM);
    // ── Bamboo Windows ──
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_BARS = registerBlockItem("bamboo_window_bars", ModBlocks.BAMBOO_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_COVERED = registerBlockItem("bamboo_window_covered", ModBlocks.BAMBOO_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_DIAGONAL = registerBlockItem("bamboo_window_diagonal", ModBlocks.BAMBOO_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_LARGE = registerBlockItem("bamboo_window_large", ModBlocks.BAMBOO_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_PANES = registerBlockItem("bamboo_window_panes", ModBlocks.BAMBOO_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_ROUNDED = registerBlockItem("bamboo_window_rounded", ModBlocks.BAMBOO_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SLIM = registerBlockItem("bamboo_window_slim", ModBlocks.BAMBOO_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SWIRLING = registerBlockItem("bamboo_window_swirling", ModBlocks.BAMBOO_WINDOW_SWIRLING);
    // ── Cherry Windows ──
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_BARS = registerBlockItem("cherry_window_bars", ModBlocks.CHERRY_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_COVERED = registerBlockItem("cherry_window_covered", ModBlocks.CHERRY_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_DIAGONAL = registerBlockItem("cherry_window_diagonal", ModBlocks.CHERRY_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_LARGE = registerBlockItem("cherry_window_large", ModBlocks.CHERRY_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_PANES = registerBlockItem("cherry_window_panes", ModBlocks.CHERRY_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_ROUNDED = registerBlockItem("cherry_window_rounded", ModBlocks.CHERRY_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SLIM = registerBlockItem("cherry_window_slim", ModBlocks.CHERRY_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SWIRLING = registerBlockItem("cherry_window_swirling", ModBlocks.CHERRY_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_BARS = registerBlockItem("pale_oak_window_bars", ModBlocks.PALE_OAK_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_COVERED = registerBlockItem("pale_oak_window_covered", ModBlocks.PALE_OAK_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_DIAGONAL = registerBlockItem("pale_oak_window_diagonal", ModBlocks.PALE_OAK_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_LARGE = registerBlockItem("pale_oak_window_large", ModBlocks.PALE_OAK_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_PANES = registerBlockItem("pale_oak_window_panes", ModBlocks.PALE_OAK_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_ROUNDED = registerBlockItem("pale_oak_window_rounded", ModBlocks.PALE_OAK_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SLIM = registerBlockItem("pale_oak_window_slim", ModBlocks.PALE_OAK_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SWIRLING = registerBlockItem("pale_oak_window_swirling", ModBlocks.PALE_OAK_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_TILES = registerBlockItem("pale_oak_window_tiles", ModBlocks.PALE_OAK_WINDOW_TILES);

    // ── Glass/ plain block items ──────────────────────────────────────────────────
    public static final DeferredHolder<Item, BlockItem> LEADED_GLASS = registerBlockItem("leaded_glass", ModBlocks.LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> GLASS_OCHRE_FROGLIGHT = registerBlockItem("glass_ochre_froglight", ModBlocks.GLASS_OCHRE_FROGLIGHT);
    public static final DeferredHolder<Item, BlockItem> GLASS_PEARLESCENT_FROGLIGHT = registerBlockItem("glass_pearlescent_froglight", ModBlocks.GLASS_PEARLESCENT_FROGLIGHT);
    public static final DeferredHolder<Item, BlockItem> GLASS_VERDANT_FROGLIGHT = registerBlockItem("glass_verdant_froglight", ModBlocks.GLASS_VERDANT_FROGLIGHT);

    // ── Pane items ────────────────────────────────────────────────────────────────
    // ── Bamboo Window Panes ──
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_BARS_PANE = registerBlockItem("bamboo_window_bars_pane", ModBlocks.BAMBOO_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_COVERED_PANE = registerBlockItem("bamboo_window_covered_pane", ModBlocks.BAMBOO_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_DIAGONAL_PANE = registerBlockItem("bamboo_window_diagonal_pane", ModBlocks.BAMBOO_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_LARGE_PANE = registerBlockItem("bamboo_window_large_pane", ModBlocks.BAMBOO_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_PANES_PANE = registerBlockItem("bamboo_window_panes_pane", ModBlocks.BAMBOO_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_ROUNDED_PANE = registerBlockItem("bamboo_window_rounded_pane", ModBlocks.BAMBOO_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SLIM_PANE = registerBlockItem("bamboo_window_slim_pane", ModBlocks.BAMBOO_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SWIRLING_PANE = registerBlockItem("bamboo_window_swirling_pane", ModBlocks.BAMBOO_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_TILES_PANE = registerBlockItem("bamboo_window_tiles_pane", ModBlocks.BAMBOO_WINDOW_TILES_PANE);
    // ── Cherry Window Panes ──
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_BARS_PANE = registerBlockItem("cherry_window_bars_pane", ModBlocks.CHERRY_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_COVERED_PANE = registerBlockItem("cherry_window_covered_pane", ModBlocks.CHERRY_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_DIAGONAL_PANE = registerBlockItem("cherry_window_diagonal_pane", ModBlocks.CHERRY_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_LARGE_PANE = registerBlockItem("cherry_window_large_pane", ModBlocks.CHERRY_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_PANES_PANE = registerBlockItem("cherry_window_panes_pane", ModBlocks.CHERRY_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_ROUNDED_PANE = registerBlockItem("cherry_window_rounded_pane", ModBlocks.CHERRY_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SLIM_PANE = registerBlockItem("cherry_window_slim_pane", ModBlocks.CHERRY_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SWIRLING_PANE = registerBlockItem("cherry_window_swirling_pane", ModBlocks.CHERRY_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_TILES_PANE = registerBlockItem("cherry_window_tiles_pane", ModBlocks.CHERRY_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_BARS_PANE = registerBlockItem("pale_oak_window_bars_pane", ModBlocks.PALE_OAK_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_COVERED_PANE = registerBlockItem("pale_oak_window_covered_pane", ModBlocks.PALE_OAK_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_DIAGONAL_PANE = registerBlockItem("pale_oak_window_diagonal_pane", ModBlocks.PALE_OAK_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_LARGE_PANE = registerBlockItem("pale_oak_window_large_pane", ModBlocks.PALE_OAK_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_PANES_PANE = registerBlockItem("pale_oak_window_panes_pane", ModBlocks.PALE_OAK_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_ROUNDED_PANE = registerBlockItem("pale_oak_window_rounded_pane", ModBlocks.PALE_OAK_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SLIM_PANE = registerBlockItem("pale_oak_window_slim_pane", ModBlocks.PALE_OAK_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SWIRLING_PANE = registerBlockItem("pale_oak_window_swirling_pane", ModBlocks.PALE_OAK_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_TILES_PANE = registerBlockItem("pale_oak_window_tiles_pane", ModBlocks.PALE_OAK_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LEADED_STAINED_GLASS_PANE = registerBlockItem("circular_leaded_stained_glass_pane", ModBlocks.CIRCULAR_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> BLACK_LEADED_STAINED_GLASS_PANE = registerBlockItem("black_leaded_stained_glass_pane", ModBlocks.BLACK_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> BLUE_LEADED_STAINED_GLASS_PANE = registerBlockItem("blue_leaded_stained_glass_pane", ModBlocks.BLUE_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> BROWN_LEADED_STAINED_GLASS_PANE = registerBlockItem("brown_leaded_stained_glass_pane", ModBlocks.BROWN_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CYAN_LEADED_STAINED_GLASS_PANE = registerBlockItem("cyan_leaded_stained_glass_pane", ModBlocks.CYAN_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> GRAY_LEADED_STAINED_GLASS_PANE = registerBlockItem("gray_leaded_stained_glass_pane", ModBlocks.GRAY_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> GREEN_LEADED_STAINED_GLASS_PANE = registerBlockItem("green_leaded_stained_glass_pane", ModBlocks.GREEN_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("circular_light_blue_stained_glass_pane", ModBlocks.CIRCULAR_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_LEADED_STAINED_GLASS_PANE = registerBlockItem("light_blue_leaded_stained_glass_pane", ModBlocks.LIGHT_BLUE_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("fancy_light_blue_stained_glass_pane", ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("large_diamond_light_blue_stained_glass_pane", ModBlocks.LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("ornate_light_blue_stained_glass_pane", ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("raster_light_blue_stained_glass_pane", ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("small_light_blue_stained_glass_pane", ModBlocks.SMALL_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("square_light_blue_stained_glass_pane", ModBlocks.SQUARE_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("tiled_light_blue_stained_glass_pane", ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_light_blue_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlockItem("woven_light_blue_stained_glass_pane", ModBlocks.WOVEN_LIGHT_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("circular_light_gray_stained_glass_pane", ModBlocks.CIRCULAR_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_LEADED_STAINED_GLASS_PANE = registerBlockItem("light_gray_leaded_stained_glass_pane", ModBlocks.LIGHT_GRAY_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("fancy_light_gray_stained_glass_pane", ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("large_diamond_light_gray_stained_glass_pane", ModBlocks.LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("ornate_light_gray_stained_glass_pane", ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("raster_light_gray_stained_glass_pane", ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("small_light_gray_stained_glass_pane", ModBlocks.SMALL_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("square_light_gray_stained_glass_pane", ModBlocks.SQUARE_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("tiled_light_gray_stained_glass_pane", ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_light_gray_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlockItem("woven_light_gray_stained_glass_pane", ModBlocks.WOVEN_LIGHT_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIME_STAINED_GLASS_PANE = registerBlockItem("circular_lime_stained_glass_pane", ModBlocks.CIRCULAR_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LIME_LEADED_STAINED_GLASS_PANE = registerBlockItem("lime_leaded_stained_glass_pane", ModBlocks.LIME_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIME_STAINED_GLASS_PANE = registerBlockItem("fancy_lime_stained_glass_pane", ModBlocks.FANCY_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LIME_STAINED_GLASS_PANE = registerBlockItem("large_diamond_lime_stained_glass_pane", ModBlocks.LARGE_DIAMOND_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIME_STAINED_GLASS_PANE = registerBlockItem("ornate_lime_stained_glass_pane", ModBlocks.ORNATE_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIME_STAINED_GLASS_PANE = registerBlockItem("raster_lime_stained_glass_pane", ModBlocks.RASTER_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_STAINED_GLASS_PANE = registerBlockItem("small_lime_stained_glass_pane", ModBlocks.SMALL_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LIME_STAINED_GLASS_PANE = registerBlockItem("square_lime_stained_glass_pane", ModBlocks.SQUARE_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_LIME_STAINED_GLASS_PANE = registerBlockItem("tiled_lime_stained_glass_pane", ModBlocks.TILED_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_LIME_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_lime_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_LIME_STAINED_GLASS_PANE = registerBlockItem("woven_lime_stained_glass_pane", ModBlocks.WOVEN_LIME_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("circular_magenta_stained_glass_pane", ModBlocks.CIRCULAR_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_LEADED_STAINED_GLASS_PANE = registerBlockItem("magenta_leaded_stained_glass_pane", ModBlocks.MAGENTA_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("fancy_magenta_stained_glass_pane", ModBlocks.FANCY_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("large_diamond_magenta_stained_glass_pane", ModBlocks.LARGE_DIAMOND_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("ornate_magenta_stained_glass_pane", ModBlocks.ORNATE_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("raster_magenta_stained_glass_pane", ModBlocks.RASTER_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("small_magenta_stained_glass_pane", ModBlocks.SMALL_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("square_magenta_stained_glass_pane", ModBlocks.SQUARE_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("tiled_magenta_stained_glass_pane", ModBlocks.TILED_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_magenta_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_MAGENTA_STAINED_GLASS_PANE = registerBlockItem("woven_magenta_stained_glass_pane", ModBlocks.WOVEN_MAGENTA_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_ORANGE_STAINED_GLASS_PANE = registerBlockItem("circular_orange_stained_glass_pane", ModBlocks.CIRCULAR_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_LEADED_STAINED_GLASS_PANE = registerBlockItem("orange_leaded_stained_glass_pane", ModBlocks.ORANGE_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_ORANGE_STAINED_GLASS_PANE = registerBlockItem("fancy_orange_stained_glass_pane", ModBlocks.FANCY_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_ORANGE_STAINED_GLASS_PANE = registerBlockItem("large_diamond_orange_stained_glass_pane", ModBlocks.LARGE_DIAMOND_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ORANGE_STAINED_GLASS_PANE = registerBlockItem("ornate_orange_stained_glass_pane", ModBlocks.ORNATE_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_ORANGE_STAINED_GLASS_PANE = registerBlockItem("raster_orange_stained_glass_pane", ModBlocks.RASTER_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_STAINED_GLASS_PANE = registerBlockItem("small_orange_stained_glass_pane", ModBlocks.SMALL_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_ORANGE_STAINED_GLASS_PANE = registerBlockItem("square_orange_stained_glass_pane", ModBlocks.SQUARE_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_ORANGE_STAINED_GLASS_PANE = registerBlockItem("tiled_orange_stained_glass_pane", ModBlocks.TILED_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_ORANGE_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_orange_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_ORANGE_STAINED_GLASS_PANE = registerBlockItem("woven_orange_stained_glass_pane", ModBlocks.WOVEN_ORANGE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PINK_STAINED_GLASS_PANE = registerBlockItem("circular_pink_stained_glass_pane", ModBlocks.CIRCULAR_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> PINK_LEADED_STAINED_GLASS_PANE = registerBlockItem("pink_leaded_stained_glass_pane", ModBlocks.PINK_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_PINK_STAINED_GLASS_PANE = registerBlockItem("fancy_pink_stained_glass_pane", ModBlocks.FANCY_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_PINK_STAINED_GLASS_PANE = registerBlockItem("large_diamond_pink_stained_glass_pane", ModBlocks.LARGE_DIAMOND_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PINK_STAINED_GLASS_PANE = registerBlockItem("ornate_pink_stained_glass_pane", ModBlocks.ORNATE_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_PINK_STAINED_GLASS_PANE = registerBlockItem("raster_pink_stained_glass_pane", ModBlocks.RASTER_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_STAINED_GLASS_PANE = registerBlockItem("small_pink_stained_glass_pane", ModBlocks.SMALL_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_PINK_STAINED_GLASS_PANE = registerBlockItem("square_pink_stained_glass_pane", ModBlocks.SQUARE_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_PINK_STAINED_GLASS_PANE = registerBlockItem("tiled_pink_stained_glass_pane", ModBlocks.TILED_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_PINK_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_pink_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_PINK_STAINED_GLASS_PANE = registerBlockItem("woven_pink_stained_glass_pane", ModBlocks.WOVEN_PINK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PURPLE_STAINED_GLASS_PANE = registerBlockItem("circular_purple_stained_glass_pane", ModBlocks.CIRCULAR_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_LEADED_STAINED_GLASS_PANE = registerBlockItem("purple_leaded_stained_glass_pane", ModBlocks.PURPLE_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_PURPLE_STAINED_GLASS_PANE = registerBlockItem("fancy_purple_stained_glass_pane", ModBlocks.FANCY_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_PURPLE_STAINED_GLASS_PANE = registerBlockItem("large_diamond_purple_stained_glass_pane", ModBlocks.LARGE_DIAMOND_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPLE_STAINED_GLASS_PANE = registerBlockItem("ornate_purple_stained_glass_pane", ModBlocks.ORNATE_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_PURPLE_STAINED_GLASS_PANE = registerBlockItem("raster_purple_stained_glass_pane", ModBlocks.RASTER_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_STAINED_GLASS_PANE = registerBlockItem("small_purple_stained_glass_pane", ModBlocks.SMALL_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_PURPLE_STAINED_GLASS_PANE = registerBlockItem("square_purple_stained_glass_pane", ModBlocks.SQUARE_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPLE_STAINED_GLASS_PANE = registerBlockItem("tiled_purple_stained_glass_pane", ModBlocks.TILED_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_PURPLE_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_purple_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_PURPLE_STAINED_GLASS_PANE = registerBlockItem("woven_purple_stained_glass_pane", ModBlocks.WOVEN_PURPLE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_RED_STAINED_GLASS_PANE = registerBlockItem("circular_red_stained_glass_pane", ModBlocks.CIRCULAR_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RED_LEADED_STAINED_GLASS_PANE = registerBlockItem("red_leaded_stained_glass_pane", ModBlocks.RED_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_RED_STAINED_GLASS_PANE = registerBlockItem("fancy_red_stained_glass_pane", ModBlocks.FANCY_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_RED_STAINED_GLASS_PANE = registerBlockItem("large_diamond_red_stained_glass_pane", ModBlocks.LARGE_DIAMOND_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_STAINED_GLASS_PANE = registerBlockItem("ornate_red_stained_glass_pane", ModBlocks.ORNATE_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_RED_STAINED_GLASS_PANE = registerBlockItem("raster_red_stained_glass_pane", ModBlocks.RASTER_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_STAINED_GLASS_PANE = registerBlockItem("small_red_stained_glass_pane", ModBlocks.SMALL_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_RED_STAINED_GLASS_PANE = registerBlockItem("square_red_stained_glass_pane", ModBlocks.SQUARE_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_STAINED_GLASS_PANE = registerBlockItem("tiled_red_stained_glass_pane", ModBlocks.TILED_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_RED_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_red_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_RED_STAINED_GLASS_PANE = registerBlockItem("woven_red_stained_glass_pane", ModBlocks.WOVEN_RED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_WHITE_STAINED_GLASS_PANE = registerBlockItem("circular_white_stained_glass_pane", ModBlocks.CIRCULAR_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WHITE_LEADED_STAINED_GLASS_PANE = registerBlockItem("white_leaded_stained_glass_pane", ModBlocks.WHITE_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_WHITE_STAINED_GLASS_PANE = registerBlockItem("fancy_white_stained_glass_pane", ModBlocks.FANCY_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_WHITE_STAINED_GLASS_PANE = registerBlockItem("large_diamond_white_stained_glass_pane", ModBlocks.LARGE_DIAMOND_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_WHITE_STAINED_GLASS_PANE = registerBlockItem("ornate_white_stained_glass_pane", ModBlocks.ORNATE_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_WHITE_STAINED_GLASS_PANE = registerBlockItem("raster_white_stained_glass_pane", ModBlocks.RASTER_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_STAINED_GLASS_PANE = registerBlockItem("small_white_stained_glass_pane", ModBlocks.SMALL_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_WHITE_STAINED_GLASS_PANE = registerBlockItem("square_white_stained_glass_pane", ModBlocks.SQUARE_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_WHITE_STAINED_GLASS_PANE = registerBlockItem("tiled_white_stained_glass_pane", ModBlocks.TILED_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_WHITE_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_white_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_WHITE_STAINED_GLASS_PANE = registerBlockItem("woven_white_stained_glass_pane", ModBlocks.WOVEN_WHITE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_YELLOW_STAINED_GLASS_PANE = registerBlockItem("circular_yellow_stained_glass_pane", ModBlocks.CIRCULAR_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_LEADED_STAINED_GLASS_PANE = registerBlockItem("yellow_leaded_stained_glass_pane", ModBlocks.YELLOW_LEADED_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_YELLOW_STAINED_GLASS_PANE = registerBlockItem("fancy_yellow_stained_glass_pane", ModBlocks.FANCY_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_YELLOW_STAINED_GLASS_PANE = registerBlockItem("large_diamond_yellow_stained_glass_pane", ModBlocks.LARGE_DIAMOND_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_YELLOW_STAINED_GLASS_PANE = registerBlockItem("ornate_yellow_stained_glass_pane", ModBlocks.ORNATE_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_YELLOW_STAINED_GLASS_PANE = registerBlockItem("raster_yellow_stained_glass_pane", ModBlocks.RASTER_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_STAINED_GLASS_PANE = registerBlockItem("small_yellow_stained_glass_pane", ModBlocks.SMALL_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_YELLOW_STAINED_GLASS_PANE = registerBlockItem("square_yellow_stained_glass_pane", ModBlocks.SQUARE_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_YELLOW_STAINED_GLASS_PANE = registerBlockItem("tiled_yellow_stained_glass_pane", ModBlocks.TILED_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_YELLOW_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_yellow_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_YELLOW_STAINED_GLASS_PANE = registerBlockItem("woven_yellow_stained_glass_pane", ModBlocks.WOVEN_YELLOW_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LEADED_GLASS_PANE = registerBlockItem("leaded_glass_pane", ModBlocks.LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CHISELED_GLASS_CTM_PANE = registerBlockItem("chiseled_glass_ctm_pane", ModBlocks.CHISELED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CLEAR_GLASS_CTM_PANE = registerBlockItem("clear_glass_ctm_pane", ModBlocks.CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DIRTY_GLASS_CTM_PANE = registerBlockItem("dirty_glass_ctm_pane", ModBlocks.DIRTY_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FROSTED_GLASS_CTM_PANE = registerBlockItem("frosted_glass_ctm_pane", ModBlocks.FROSTED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ICE_GLASS_CTM_PANE = registerBlockItem("ice_glass_ctm_pane", ModBlocks.ICE_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_FRAMED_GLASS_CTM_PANE = registerBlockItem("obsidian_framed_glass_ctm_pane", ModBlocks.OBSIDIAN_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> REINFORCED_GLASS_CTM_PANE = registerBlockItem("reinforced_glass_ctm_pane", ModBlocks.REINFORCED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_FRAMED_GLASS_CTM_PANE = registerBlockItem("sandstone_framed_glass_ctm_pane", ModBlocks.SANDSTONE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> STONE_FRAMED_GLASS_CTM_PANE = registerBlockItem("stone_framed_glass_ctm_pane", ModBlocks.STONE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_CLEAR_GLASS_CTM_PANE = registerBlockItem("tinted_clear_glass_ctm_pane", ModBlocks.TINTED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_GLASS_CTM_PANE = registerBlockItem("tinted_glass_ctm_pane", ModBlocks.TINTED_GLASS_CTM_PANE);
    // -- CTM connecting window panes -- wood types
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("cherry_window_swirling_ctm_pane", ModBlocks.CHERRY_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_BARS_CTM_PANE = registerBlockItem("cherry_window_bars_ctm_pane", ModBlocks.CHERRY_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_COVERED_CTM_PANE = registerBlockItem("cherry_window_covered_ctm_pane", ModBlocks.CHERRY_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("cherry_window_diagonal_ctm_pane", ModBlocks.CHERRY_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_LARGE_CTM_PANE = registerBlockItem("cherry_window_large_ctm_pane", ModBlocks.CHERRY_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_PANES_CTM_PANE = registerBlockItem("cherry_window_panes_ctm_pane", ModBlocks.CHERRY_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("cherry_window_rounded_ctm_pane", ModBlocks.CHERRY_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_SLIM_CTM_PANE = registerBlockItem("cherry_window_slim_ctm_pane", ModBlocks.CHERRY_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_WINDOW_TILES_CTM_PANE = registerBlockItem("cherry_window_tiles_ctm_pane", ModBlocks.CHERRY_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("bamboo_window_swirling_ctm_pane", ModBlocks.BAMBOO_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_BARS_CTM_PANE = registerBlockItem("bamboo_window_bars_ctm_pane", ModBlocks.BAMBOO_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_COVERED_CTM_PANE = registerBlockItem("bamboo_window_covered_ctm_pane", ModBlocks.BAMBOO_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("bamboo_window_diagonal_ctm_pane", ModBlocks.BAMBOO_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_LARGE_CTM_PANE = registerBlockItem("bamboo_window_large_ctm_pane", ModBlocks.BAMBOO_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_PANES_CTM_PANE = registerBlockItem("bamboo_window_panes_ctm_pane", ModBlocks.BAMBOO_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("bamboo_window_rounded_ctm_pane", ModBlocks.BAMBOO_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_SLIM_CTM_PANE = registerBlockItem("bamboo_window_slim_ctm_pane", ModBlocks.BAMBOO_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_WINDOW_TILES_CTM_PANE = registerBlockItem("bamboo_window_tiles_ctm_pane", ModBlocks.BAMBOO_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("pale_oak_window_swirling_ctm_pane", ModBlocks.PALE_OAK_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_BARS_CTM_PANE = registerBlockItem("pale_oak_window_bars_ctm_pane", ModBlocks.PALE_OAK_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_COVERED_CTM_PANE = registerBlockItem("pale_oak_window_covered_ctm_pane", ModBlocks.PALE_OAK_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("pale_oak_window_diagonal_ctm_pane", ModBlocks.PALE_OAK_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_LARGE_CTM_PANE = registerBlockItem("pale_oak_window_large_ctm_pane", ModBlocks.PALE_OAK_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_PANES_CTM_PANE = registerBlockItem("pale_oak_window_panes_ctm_pane", ModBlocks.PALE_OAK_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("pale_oak_window_rounded_ctm_pane", ModBlocks.PALE_OAK_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_SLIM_CTM_PANE = registerBlockItem("pale_oak_window_slim_ctm_pane", ModBlocks.PALE_OAK_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PALE_OAK_WINDOW_TILES_CTM_PANE = registerBlockItem("pale_oak_window_tiles_ctm_pane", ModBlocks.PALE_OAK_WINDOW_TILES_CTM_PANE);
    // -- CTM connecting panes -- stained glass patterns
    public static final DeferredHolder<Item, BlockItem> WHITE_FRAMED_GLASS_CTM_PANE = registerBlockItem("white_framed_glass_ctm_pane", ModBlocks.WHITE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("white_stained_glass_ctm_pane", ModBlocks.WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_white_stained_glass_ctm_pane", ModBlocks.FANCY_WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_white_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_white_stained_glass_ctm_pane", ModBlocks.ORNATE_WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_white_stained_glass_ctm_pane", ModBlocks.RASTER_WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_WHITE_CTM_PANE = registerBlockItem("scratched_glass_white_ctm_pane", ModBlocks.SCRATCHED_GLASS_WHITE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_white_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_white_stained_glass_ctm_pane", ModBlocks.TILED_WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_WHITE_CTM_PANE = registerBlockItem("tinted_borderless_glass_white_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_WHITE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_WHITE_CTM_PANE = registerBlockItem("borderless_glass_white_ctm_pane", ModBlocks.BORDERLESS_GLASS_WHITE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_FRAMED_GLASS_CTM_PANE = registerBlockItem("orange_framed_glass_ctm_pane", ModBlocks.ORANGE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("orange_stained_glass_ctm_pane", ModBlocks.ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_orange_stained_glass_ctm_pane", ModBlocks.FANCY_ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_orange_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_orange_stained_glass_ctm_pane", ModBlocks.ORNATE_ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_orange_stained_glass_ctm_pane", ModBlocks.RASTER_ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_ORANGE_CTM_PANE = registerBlockItem("scratched_glass_orange_ctm_pane", ModBlocks.SCRATCHED_GLASS_ORANGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_orange_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_orange_stained_glass_ctm_pane", ModBlocks.TILED_ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_ORANGE_CTM_PANE = registerBlockItem("tinted_borderless_glass_orange_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_ORANGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_ORANGE_CTM_PANE = registerBlockItem("borderless_glass_orange_ctm_pane", ModBlocks.BORDERLESS_GLASS_ORANGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FRAMED_GLASS_CTM_PANE = registerBlockItem("magenta_framed_glass_ctm_pane", ModBlocks.MAGENTA_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("magenta_stained_glass_ctm_pane", ModBlocks.MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_magenta_stained_glass_ctm_pane", ModBlocks.FANCY_MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_magenta_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_magenta_stained_glass_ctm_pane", ModBlocks.ORNATE_MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_magenta_stained_glass_ctm_pane", ModBlocks.RASTER_MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_MAGENTA_CTM_PANE = registerBlockItem("scratched_glass_magenta_ctm_pane", ModBlocks.SCRATCHED_GLASS_MAGENTA_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_magenta_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_magenta_stained_glass_ctm_pane", ModBlocks.TILED_MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_MAGENTA_CTM_PANE = registerBlockItem("tinted_borderless_glass_magenta_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_MAGENTA_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_MAGENTA_CTM_PANE = registerBlockItem("borderless_glass_magenta_ctm_pane", ModBlocks.BORDERLESS_GLASS_MAGENTA_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_FRAMED_GLASS_CTM_PANE = registerBlockItem("light_blue_framed_glass_ctm_pane", ModBlocks.LIGHT_BLUE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("light_blue_stained_glass_ctm_pane", ModBlocks.LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_light_blue_stained_glass_ctm_pane", ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_light_blue_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_light_blue_stained_glass_ctm_pane", ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_light_blue_stained_glass_ctm_pane", ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_LIGHT_BLUE_CTM_PANE = registerBlockItem("scratched_glass_light_blue_ctm_pane", ModBlocks.SCRATCHED_GLASS_LIGHT_BLUE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_light_blue_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_light_blue_stained_glass_ctm_pane", ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE = registerBlockItem("tinted_borderless_glass_light_blue_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE = registerBlockItem("borderless_glass_light_blue_ctm_pane", ModBlocks.BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_FRAMED_GLASS_CTM_PANE = registerBlockItem("yellow_framed_glass_ctm_pane", ModBlocks.YELLOW_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("yellow_stained_glass_ctm_pane", ModBlocks.YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_yellow_stained_glass_ctm_pane", ModBlocks.FANCY_YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_yellow_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_yellow_stained_glass_ctm_pane", ModBlocks.ORNATE_YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_yellow_stained_glass_ctm_pane", ModBlocks.RASTER_YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_YELLOW_CTM_PANE = registerBlockItem("scratched_glass_yellow_ctm_pane", ModBlocks.SCRATCHED_GLASS_YELLOW_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_yellow_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_yellow_stained_glass_ctm_pane", ModBlocks.TILED_YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_YELLOW_CTM_PANE = registerBlockItem("tinted_borderless_glass_yellow_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_YELLOW_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_YELLOW_CTM_PANE = registerBlockItem("borderless_glass_yellow_ctm_pane", ModBlocks.BORDERLESS_GLASS_YELLOW_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIME_FRAMED_GLASS_CTM_PANE = registerBlockItem("lime_framed_glass_ctm_pane", ModBlocks.LIME_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("lime_stained_glass_ctm_pane", ModBlocks.LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_lime_stained_glass_ctm_pane", ModBlocks.FANCY_LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_lime_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_lime_stained_glass_ctm_pane", ModBlocks.ORNATE_LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_lime_stained_glass_ctm_pane", ModBlocks.RASTER_LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_LIME_CTM_PANE = registerBlockItem("scratched_glass_lime_ctm_pane", ModBlocks.SCRATCHED_GLASS_LIME_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_lime_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_LIME_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_lime_stained_glass_ctm_pane", ModBlocks.TILED_LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_LIME_CTM_PANE = registerBlockItem("tinted_borderless_glass_lime_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_LIME_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_LIME_CTM_PANE = registerBlockItem("borderless_glass_lime_ctm_pane", ModBlocks.BORDERLESS_GLASS_LIME_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PINK_FRAMED_GLASS_CTM_PANE = registerBlockItem("pink_framed_glass_ctm_pane", ModBlocks.PINK_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("pink_stained_glass_ctm_pane", ModBlocks.PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_pink_stained_glass_ctm_pane", ModBlocks.FANCY_PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_pink_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_pink_stained_glass_ctm_pane", ModBlocks.ORNATE_PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_pink_stained_glass_ctm_pane", ModBlocks.RASTER_PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_PINK_CTM_PANE = registerBlockItem("scratched_glass_pink_ctm_pane", ModBlocks.SCRATCHED_GLASS_PINK_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_pink_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_PINK_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_pink_stained_glass_ctm_pane", ModBlocks.TILED_PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_PINK_CTM_PANE = registerBlockItem("tinted_borderless_glass_pink_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_PINK_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_PINK_CTM_PANE = registerBlockItem("borderless_glass_pink_ctm_pane", ModBlocks.BORDERLESS_GLASS_PINK_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GRAY_FRAMED_GLASS_CTM_PANE = registerBlockItem("gray_framed_glass_ctm_pane", ModBlocks.GRAY_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("gray_stained_glass_ctm_pane", ModBlocks.GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_gray_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_GRAY_CTM_PANE = registerBlockItem("scratched_glass_gray_ctm_pane", ModBlocks.SCRATCHED_GLASS_GRAY_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_GRAY_CTM_PANE = registerBlockItem("tinted_borderless_glass_gray_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_GRAY_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_GRAY_CTM_PANE = registerBlockItem("borderless_glass_gray_ctm_pane", ModBlocks.BORDERLESS_GLASS_GRAY_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_FRAMED_GLASS_CTM_PANE = registerBlockItem("light_gray_framed_glass_ctm_pane", ModBlocks.LIGHT_GRAY_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("light_gray_stained_glass_ctm_pane", ModBlocks.LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_light_gray_stained_glass_ctm_pane", ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_light_gray_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_light_gray_stained_glass_ctm_pane", ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_light_gray_stained_glass_ctm_pane", ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_LIGHT_GRAY_CTM_PANE = registerBlockItem("scratched_glass_light_gray_ctm_pane", ModBlocks.SCRATCHED_GLASS_LIGHT_GRAY_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_light_gray_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_light_gray_stained_glass_ctm_pane", ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE = registerBlockItem("tinted_borderless_glass_light_gray_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE = registerBlockItem("borderless_glass_light_gray_ctm_pane", ModBlocks.BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CYAN_FRAMED_GLASS_CTM_PANE = registerBlockItem("cyan_framed_glass_ctm_pane", ModBlocks.CYAN_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("cyan_stained_glass_ctm_pane", ModBlocks.CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_cyan_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_CYAN_CTM_PANE = registerBlockItem("scratched_glass_cyan_ctm_pane", ModBlocks.SCRATCHED_GLASS_CYAN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_CYAN_CTM_PANE = registerBlockItem("tinted_borderless_glass_cyan_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_CYAN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_CYAN_CTM_PANE = registerBlockItem("borderless_glass_cyan_ctm_pane", ModBlocks.BORDERLESS_GLASS_CYAN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_FRAMED_GLASS_CTM_PANE = registerBlockItem("purple_framed_glass_ctm_pane", ModBlocks.PURPLE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("purple_stained_glass_ctm_pane", ModBlocks.PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_purple_stained_glass_ctm_pane", ModBlocks.FANCY_PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_purple_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_purple_stained_glass_ctm_pane", ModBlocks.ORNATE_PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_purple_stained_glass_ctm_pane", ModBlocks.RASTER_PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_PURPLE_CTM_PANE = registerBlockItem("scratched_glass_purple_ctm_pane", ModBlocks.SCRATCHED_GLASS_PURPLE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_purple_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_purple_stained_glass_ctm_pane", ModBlocks.TILED_PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_PURPLE_CTM_PANE = registerBlockItem("tinted_borderless_glass_purple_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_PURPLE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_PURPLE_CTM_PANE = registerBlockItem("borderless_glass_purple_ctm_pane", ModBlocks.BORDERLESS_GLASS_PURPLE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BLUE_FRAMED_GLASS_CTM_PANE = registerBlockItem("blue_framed_glass_ctm_pane", ModBlocks.BLUE_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("blue_stained_glass_ctm_pane", ModBlocks.BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_blue_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_BLUE_CTM_PANE = registerBlockItem("scratched_glass_blue_ctm_pane", ModBlocks.SCRATCHED_GLASS_BLUE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_BLUE_CTM_PANE = registerBlockItem("tinted_borderless_glass_blue_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_BLUE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_BLUE_CTM_PANE = registerBlockItem("borderless_glass_blue_ctm_pane", ModBlocks.BORDERLESS_GLASS_BLUE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BROWN_FRAMED_GLASS_CTM_PANE = registerBlockItem("brown_framed_glass_ctm_pane", ModBlocks.BROWN_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("brown_stained_glass_ctm_pane", ModBlocks.BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_brown_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_BROWN_CTM_PANE = registerBlockItem("scratched_glass_brown_ctm_pane", ModBlocks.SCRATCHED_GLASS_BROWN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_BROWN_CTM_PANE = registerBlockItem("tinted_borderless_glass_brown_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_BROWN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_BROWN_CTM_PANE = registerBlockItem("borderless_glass_brown_ctm_pane", ModBlocks.BORDERLESS_GLASS_BROWN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GREEN_FRAMED_GLASS_CTM_PANE = registerBlockItem("green_framed_glass_ctm_pane", ModBlocks.GREEN_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("green_stained_glass_ctm_pane", ModBlocks.GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_green_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_GREEN_CTM_PANE = registerBlockItem("scratched_glass_green_ctm_pane", ModBlocks.SCRATCHED_GLASS_GREEN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_GREEN_CTM_PANE = registerBlockItem("tinted_borderless_glass_green_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_GREEN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_GREEN_CTM_PANE = registerBlockItem("borderless_glass_green_ctm_pane", ModBlocks.BORDERLESS_GLASS_GREEN_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RED_FRAMED_GLASS_CTM_PANE = registerBlockItem("red_framed_glass_ctm_pane", ModBlocks.RED_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RED_STAINED_GLASS_CTM_PANE = registerBlockItem("red_stained_glass_ctm_pane", ModBlocks.RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_RED_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_red_stained_glass_ctm_pane", ModBlocks.FANCY_RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_RED_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_red_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_red_stained_glass_ctm_pane", ModBlocks.ORNATE_RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_RED_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_red_stained_glass_ctm_pane", ModBlocks.RASTER_RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_RED_CTM_PANE = registerBlockItem("scratched_glass_red_ctm_pane", ModBlocks.SCRATCHED_GLASS_RED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_red_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_RED_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_red_stained_glass_ctm_pane", ModBlocks.TILED_RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_RED_CTM_PANE = registerBlockItem("tinted_borderless_glass_red_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_RED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_RED_CTM_PANE = registerBlockItem("borderless_glass_red_ctm_pane", ModBlocks.BORDERLESS_GLASS_RED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BLACK_FRAMED_GLASS_CTM_PANE = registerBlockItem("black_framed_glass_ctm_pane", ModBlocks.BLACK_FRAMED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("black_stained_glass_ctm_pane", ModBlocks.BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_FRAMED_BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("golden_framed_black_stained_glass_ctm_pane", ModBlocks.GOLDEN_FRAMED_BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_BLACK_CTM_PANE = registerBlockItem("scratched_glass_black_ctm_pane", ModBlocks.SCRATCHED_GLASS_BLACK_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_BLACK_CTM_PANE = registerBlockItem("tinted_borderless_glass_black_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_BLACK_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_BLACK_CTM_PANE = registerBlockItem("borderless_glass_black_ctm_pane", ModBlocks.BORDERLESS_GLASS_BLACK_CTM_PANE);
    // -- CTM connecting panes -- plain variants
    public static final DeferredHolder<Item, BlockItem> SCRATCHED_GLASS_CTM_PANE = registerBlockItem("scratched_glass_ctm_pane", ModBlocks.SCRATCHED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TINTED_BORDERLESS_GLASS_CTM_PANE = registerBlockItem("tinted_borderless_glass_ctm_pane", ModBlocks.TINTED_BORDERLESS_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BORDERLESS_GLASS_CTM_PANE = registerBlockItem("borderless_glass_ctm_pane", ModBlocks.BORDERLESS_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WHITE_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("white_stained_clear_glass_ctm_pane", ModBlocks.WHITE_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("orange_stained_clear_glass_ctm_pane", ModBlocks.ORANGE_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("magenta_stained_clear_glass_ctm_pane", ModBlocks.MAGENTA_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("light_blue_stained_clear_glass_ctm_pane", ModBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("yellow_stained_clear_glass_ctm_pane", ModBlocks.YELLOW_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIME_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("lime_stained_clear_glass_ctm_pane", ModBlocks.LIME_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PINK_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("pink_stained_clear_glass_ctm_pane", ModBlocks.PINK_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GRAY_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("gray_stained_clear_glass_ctm_pane", ModBlocks.GRAY_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("light_gray_stained_clear_glass_ctm_pane", ModBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CYAN_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("cyan_stained_clear_glass_ctm_pane", ModBlocks.CYAN_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("purple_stained_clear_glass_ctm_pane", ModBlocks.PURPLE_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BLUE_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("blue_stained_clear_glass_ctm_pane", ModBlocks.BLUE_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BROWN_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("brown_stained_clear_glass_ctm_pane", ModBlocks.BROWN_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> GREEN_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("green_stained_clear_glass_ctm_pane", ModBlocks.GREEN_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RED_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("red_stained_clear_glass_ctm_pane", ModBlocks.RED_STAINED_CLEAR_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BLACK_STAINED_CLEAR_GLASS_CTM_PANE = registerBlockItem("black_stained_clear_glass_ctm_pane", ModBlocks.BLACK_STAINED_CLEAR_GLASS_CTM_PANE);    public static final DeferredHolder<Item, BlockItem> GLASS_OCHRE_FROGLIGHT_PANE = registerBlockItem("glass_ochre_froglight_pane", ModBlocks.GLASS_OCHRE_FROGLIGHT_PANE);
    public static final DeferredHolder<Item, BlockItem> GLASS_PEARLESCENT_FROGLIGHT_PANE = registerBlockItem("glass_pearlescent_froglight_pane", ModBlocks.GLASS_PEARLESCENT_FROGLIGHT_PANE);
    public static final DeferredHolder<Item, BlockItem> GLASS_VERDANT_FROGLIGHT_PANE = registerBlockItem("glass_verdant_froglight_pane", ModBlocks.GLASS_VERDANT_FROGLIGHT_PANE);




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
    public static final DeferredHolder<Item, BlockItem> WHITE_MARBLE_DIAMOND_PAVERS = registerBlockItem("white_marble_diamond_pavers", ModBlocks.WHITE_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> BLACK_MARBLE_DIAMOND_PAVERS = registerBlockItem("black_marble_diamond_pavers", ModBlocks.BLACK_MARBLE_DIAMOND_PAVERS);

    // ── Amethyst Marble ──
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE = registerBlockItem("amethyst_marble", ModBlocks.AMETHYST_MARBLE);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_BRICKS = registerBlockItem("amethyst_marble_bricks", ModBlocks.AMETHYST_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_SMALL_BRICKS = registerBlockItem("amethyst_marble_small_bricks", ModBlocks.AMETHYST_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_TILES = registerBlockItem("amethyst_marble_tiles", ModBlocks.AMETHYST_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_POLISHED_MARBLE = registerBlockItem("amethyst_polished_marble", ModBlocks.AMETHYST_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_PILLAR = registerBlockItem("amethyst_marble_pillar", ModBlocks.AMETHYST_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_PILLAR_CAP = registerBlockItem("amethyst_marble_pillar_cap", ModBlocks.AMETHYST_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_FLOOR_TILE = registerBlockItem("amethyst_marble_floor_tile", ModBlocks.AMETHYST_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_FANCY_FENCE = registerBlockItem("amethyst_marble_fancy_fence", ModBlocks.AMETHYST_MARBLE_FANCY_FENCE);

    // ── Blue Marble ──
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE = registerBlockItem("blue_marble", ModBlocks.BLUE_MARBLE);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_BRICKS = registerBlockItem("blue_marble_bricks", ModBlocks.BLUE_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_SMALL_BRICKS = registerBlockItem("blue_marble_small_bricks", ModBlocks.BLUE_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_TILES = registerBlockItem("blue_marble_tiles", ModBlocks.BLUE_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> BLUE_POLISHED_MARBLE = registerBlockItem("blue_polished_marble", ModBlocks.BLUE_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_PILLAR = registerBlockItem("blue_marble_pillar", ModBlocks.BLUE_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_PILLAR_CAP = registerBlockItem("blue_marble_pillar_cap", ModBlocks.BLUE_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_FLOOR_TILE = registerBlockItem("blue_marble_floor_tile", ModBlocks.BLUE_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_FANCY_FENCE = registerBlockItem("blue_marble_fancy_fence", ModBlocks.BLUE_MARBLE_FANCY_FENCE);

    // ── Cyan Marble ──
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE = registerBlockItem("cyan_marble", ModBlocks.CYAN_MARBLE);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_BRICKS = registerBlockItem("cyan_marble_bricks", ModBlocks.CYAN_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_SMALL_BRICKS = registerBlockItem("cyan_marble_small_bricks", ModBlocks.CYAN_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_TILES = registerBlockItem("cyan_marble_tiles", ModBlocks.CYAN_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> CYAN_POLISHED_MARBLE = registerBlockItem("cyan_polished_marble", ModBlocks.CYAN_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_PILLAR = registerBlockItem("cyan_marble_pillar", ModBlocks.CYAN_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_PILLAR_CAP = registerBlockItem("cyan_marble_pillar_cap", ModBlocks.CYAN_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_FLOOR_TILE = registerBlockItem("cyan_marble_floor_tile", ModBlocks.CYAN_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_FANCY_FENCE = registerBlockItem("cyan_marble_fancy_fence", ModBlocks.CYAN_MARBLE_FANCY_FENCE);

    // ── Green Marble ──
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE = registerBlockItem("green_marble", ModBlocks.GREEN_MARBLE);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_BRICKS = registerBlockItem("green_marble_bricks", ModBlocks.GREEN_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_SMALL_BRICKS = registerBlockItem("green_marble_small_bricks", ModBlocks.GREEN_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_TILES = registerBlockItem("green_marble_tiles", ModBlocks.GREEN_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> GREEN_POLISHED_MARBLE = registerBlockItem("green_polished_marble", ModBlocks.GREEN_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_PILLAR = registerBlockItem("green_marble_pillar", ModBlocks.GREEN_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_PILLAR_CAP = registerBlockItem("green_marble_pillar_cap", ModBlocks.GREEN_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_FLOOR_TILE = registerBlockItem("green_marble_floor_tile", ModBlocks.GREEN_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_FANCY_FENCE = registerBlockItem("green_marble_fancy_fence", ModBlocks.GREEN_MARBLE_FANCY_FENCE);

    // ── Lime Marble ──
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE = registerBlockItem("lime_marble", ModBlocks.LIME_MARBLE);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_BRICKS = registerBlockItem("lime_marble_bricks", ModBlocks.LIME_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_SMALL_BRICKS = registerBlockItem("lime_marble_small_bricks", ModBlocks.LIME_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_TILES = registerBlockItem("lime_marble_tiles", ModBlocks.LIME_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> LIME_POLISHED_MARBLE = registerBlockItem("lime_polished_marble", ModBlocks.LIME_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_PILLAR = registerBlockItem("lime_marble_pillar", ModBlocks.LIME_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_PILLAR_CAP = registerBlockItem("lime_marble_pillar_cap", ModBlocks.LIME_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_FLOOR_TILE = registerBlockItem("lime_marble_floor_tile", ModBlocks.LIME_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_FANCY_FENCE = registerBlockItem("lime_marble_fancy_fence", ModBlocks.LIME_MARBLE_FANCY_FENCE);

    // ── Orange Marble ──
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE = registerBlockItem("orange_marble", ModBlocks.ORANGE_MARBLE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_BRICKS = registerBlockItem("orange_marble_bricks", ModBlocks.ORANGE_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_SMALL_BRICKS = registerBlockItem("orange_marble_small_bricks", ModBlocks.ORANGE_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_TILES = registerBlockItem("orange_marble_tiles", ModBlocks.ORANGE_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_POLISHED_MARBLE = registerBlockItem("orange_polished_marble", ModBlocks.ORANGE_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_PILLAR = registerBlockItem("orange_marble_pillar", ModBlocks.ORANGE_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_PILLAR_CAP = registerBlockItem("orange_marble_pillar_cap", ModBlocks.ORANGE_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_FLOOR_TILE = registerBlockItem("orange_marble_floor_tile", ModBlocks.ORANGE_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_FANCY_FENCE = registerBlockItem("orange_marble_fancy_fence", ModBlocks.ORANGE_MARBLE_FANCY_FENCE);

    // ── Pink Marble ──
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE = registerBlockItem("pink_marble", ModBlocks.PINK_MARBLE);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_BRICKS = registerBlockItem("pink_marble_bricks", ModBlocks.PINK_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_SMALL_BRICKS = registerBlockItem("pink_marble_small_bricks", ModBlocks.PINK_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_TILES = registerBlockItem("pink_marble_tiles", ModBlocks.PINK_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> PINK_POLISHED_MARBLE = registerBlockItem("pink_polished_marble", ModBlocks.PINK_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_PILLAR = registerBlockItem("pink_marble_pillar", ModBlocks.PINK_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_PILLAR_CAP = registerBlockItem("pink_marble_pillar_cap", ModBlocks.PINK_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_FLOOR_TILE = registerBlockItem("pink_marble_floor_tile", ModBlocks.PINK_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_FANCY_FENCE = registerBlockItem("pink_marble_fancy_fence", ModBlocks.PINK_MARBLE_FANCY_FENCE);

    // ── Purple Marble ──
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE = registerBlockItem("purple_marble", ModBlocks.PURPLE_MARBLE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_BRICKS = registerBlockItem("purple_marble_bricks", ModBlocks.PURPLE_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_SMALL_BRICKS = registerBlockItem("purple_marble_small_bricks", ModBlocks.PURPLE_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_TILES = registerBlockItem("purple_marble_tiles", ModBlocks.PURPLE_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> PURPLE_POLISHED_MARBLE = registerBlockItem("purple_polished_marble", ModBlocks.PURPLE_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_PILLAR = registerBlockItem("purple_marble_pillar", ModBlocks.PURPLE_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_PILLAR_CAP = registerBlockItem("purple_marble_pillar_cap", ModBlocks.PURPLE_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_FLOOR_TILE = registerBlockItem("purple_marble_floor_tile", ModBlocks.PURPLE_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_FANCY_FENCE = registerBlockItem("purple_marble_fancy_fence", ModBlocks.PURPLE_MARBLE_FANCY_FENCE);

    // ── Red Marble ──
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE = registerBlockItem("red_marble", ModBlocks.RED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_BRICKS = registerBlockItem("red_marble_bricks", ModBlocks.RED_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_SMALL_BRICKS = registerBlockItem("red_marble_small_bricks", ModBlocks.RED_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_TILES = registerBlockItem("red_marble_tiles", ModBlocks.RED_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> RED_POLISHED_MARBLE = registerBlockItem("red_polished_marble", ModBlocks.RED_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_PILLAR = registerBlockItem("red_marble_pillar", ModBlocks.RED_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_PILLAR_CAP = registerBlockItem("red_marble_pillar_cap", ModBlocks.RED_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_FLOOR_TILE = registerBlockItem("red_marble_floor_tile", ModBlocks.RED_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_FANCY_FENCE = registerBlockItem("red_marble_fancy_fence", ModBlocks.RED_MARBLE_FANCY_FENCE);

    // ── Yellow Marble ──
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE = registerBlockItem("yellow_marble", ModBlocks.YELLOW_MARBLE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_BRICKS = registerBlockItem("yellow_marble_bricks", ModBlocks.YELLOW_MARBLE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_SMALL_BRICKS = registerBlockItem("yellow_marble_small_bricks", ModBlocks.YELLOW_MARBLE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_TILES = registerBlockItem("yellow_marble_tiles", ModBlocks.YELLOW_MARBLE_TILES);
    public static final DeferredHolder<Item, BlockItem> YELLOW_POLISHED_MARBLE = registerBlockItem("yellow_polished_marble", ModBlocks.YELLOW_POLISHED_MARBLE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_PILLAR = registerBlockItem("yellow_marble_pillar", ModBlocks.YELLOW_MARBLE_PILLAR);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_PILLAR_CAP = registerBlockItem("yellow_marble_pillar_cap", ModBlocks.YELLOW_MARBLE_PILLAR_CAP);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_FLOOR_TILE = registerBlockItem("yellow_marble_floor_tile", ModBlocks.YELLOW_MARBLE_FLOOR_TILE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_FANCY_FENCE = registerBlockItem("yellow_marble_fancy_fence", ModBlocks.YELLOW_MARBLE_FANCY_FENCE);
    // ── Diamond Pavers (10 new colors) ──
    public static final DeferredHolder<Item, BlockItem> AMETHYST_MARBLE_DIAMOND_PAVERS = registerBlockItem("amethyst_marble_diamond_pavers", ModBlocks.AMETHYST_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> BLUE_MARBLE_DIAMOND_PAVERS     = registerBlockItem("blue_marble_diamond_pavers",     ModBlocks.BLUE_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> CYAN_MARBLE_DIAMOND_PAVERS     = registerBlockItem("cyan_marble_diamond_pavers",     ModBlocks.CYAN_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> GREEN_MARBLE_DIAMOND_PAVERS    = registerBlockItem("green_marble_diamond_pavers",    ModBlocks.GREEN_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> LIME_MARBLE_DIAMOND_PAVERS     = registerBlockItem("lime_marble_diamond_pavers",     ModBlocks.LIME_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> ORANGE_MARBLE_DIAMOND_PAVERS   = registerBlockItem("orange_marble_diamond_pavers",   ModBlocks.ORANGE_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> PINK_MARBLE_DIAMOND_PAVERS     = registerBlockItem("pink_marble_diamond_pavers",     ModBlocks.PINK_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> PURPLE_MARBLE_DIAMOND_PAVERS   = registerBlockItem("purple_marble_diamond_pavers",   ModBlocks.PURPLE_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> RED_MARBLE_DIAMOND_PAVERS      = registerBlockItem("red_marble_diamond_pavers",      ModBlocks.RED_MARBLE_DIAMOND_PAVERS);
    public static final DeferredHolder<Item, BlockItem> YELLOW_MARBLE_DIAMOND_PAVERS   = registerBlockItem("yellow_marble_diamond_pavers",   ModBlocks.YELLOW_MARBLE_DIAMOND_PAVERS);

    // --- Stone variant block items ---
    public static final DeferredHolder<Item, BlockItem> CHISELED_PLASTERED_STONE_PILLAR    = registerBlockItem("chiseled_plastered_stone_pillar",    ModBlocks.CHISELED_PLASTERED_STONE_PILLAR);
    // CTM vertical pillars

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

        // Tiered shears — boosted durability over basic (vanilla) shears (238); 3D models live in the ott namespace
        GOLDEN_SHEARS    = MINECRAFT_ITEMS.register("golden_shears",    () -> new ShearsItem((new Item.Properties()).durability(280)));
        DIAMOND_SHEARS   = MINECRAFT_ITEMS.register("diamond_shears",   () -> new ShearsItem((new Item.Properties()).durability(1561)));
        NETHERITE_SHEARS = MINECRAFT_ITEMS.register("netherite_shears", () -> new ShearsItem((new Item.Properties()).fireResistant().durability(2031)));

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
        registerBlockItem(ModBlocks.CUT_STONE);
        registerBlockItem(ModBlocks.ROUGH_CUT_STONE);
        // New stone pillars (RotatedPillarBlock)
        registerBlockItem(ModBlocks.SHEARED_STONE_PILLAR);
        registerBlockItem(ModBlocks.SLATED_STONE);
        registerBlockItem(ModBlocks.STONE_COLUMN);
        registerBlockItem(ModBlocks.STONE_TWISTING_COLUMN);
        // Chisel pillar blocks and legend blocks
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



    // ===== RECOVERED WINDOW ITEMS =====
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_BARS = registerBlockItem("acacia_window_bars", ModBlocks.ACACIA_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_BARS_PANE = registerBlockItem("acacia_window_bars_pane", ModBlocks.ACACIA_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_COVERED_CTM_PANE = registerBlockItem("acacia_window_covered_ctm_pane", ModBlocks.ACACIA_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_COVERED_PANE = registerBlockItem("acacia_window_covered_pane", ModBlocks.ACACIA_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("acacia_window_diagonal_ctm_pane", ModBlocks.ACACIA_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_DIAGONAL_PANE = registerBlockItem("acacia_window_diagonal_pane", ModBlocks.ACACIA_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_LARGE_CTM_PANE = registerBlockItem("acacia_window_large_ctm_pane", ModBlocks.ACACIA_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_LARGE_PANE = registerBlockItem("acacia_window_large_pane", ModBlocks.ACACIA_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_PANES_CTM_PANE = registerBlockItem("acacia_window_panes_ctm_pane", ModBlocks.ACACIA_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_PANES_PANE = registerBlockItem("acacia_window_panes_pane", ModBlocks.ACACIA_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("acacia_window_rounded_ctm_pane", ModBlocks.ACACIA_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_ROUNDED_PANE = registerBlockItem("acacia_window_rounded_pane", ModBlocks.ACACIA_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SLIM_CTM_PANE = registerBlockItem("acacia_window_slim_ctm_pane", ModBlocks.ACACIA_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SLIM_PANE = registerBlockItem("acacia_window_slim_pane", ModBlocks.ACACIA_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("acacia_window_swirling_ctm_pane", ModBlocks.ACACIA_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SWIRLING_PANE = registerBlockItem("acacia_window_swirling_pane", ModBlocks.ACACIA_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_TILES_CTM_PANE = registerBlockItem("acacia_window_tiles_ctm_pane", ModBlocks.ACACIA_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_TILES_PANE = registerBlockItem("acacia_window_tiles_pane", ModBlocks.ACACIA_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_BARS_CTM_PANE = registerBlockItem("birch_window_bars_ctm_pane", ModBlocks.BIRCH_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_BARS_PANE = registerBlockItem("birch_window_bars_pane", ModBlocks.BIRCH_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_COVERED = registerBlockItem("birch_window_covered", ModBlocks.BIRCH_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_COVERED_PANE = registerBlockItem("birch_window_covered_pane", ModBlocks.BIRCH_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("birch_window_diagonal_ctm_pane", ModBlocks.BIRCH_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_DIAGONAL_PANE = registerBlockItem("birch_window_diagonal_pane", ModBlocks.BIRCH_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_LARGE_CTM_PANE = registerBlockItem("birch_window_large_ctm_pane", ModBlocks.BIRCH_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_LARGE_PANE = registerBlockItem("birch_window_large_pane", ModBlocks.BIRCH_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_PANES_CTM_PANE = registerBlockItem("birch_window_panes_ctm_pane", ModBlocks.BIRCH_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_PANES_PANE = registerBlockItem("birch_window_panes_pane", ModBlocks.BIRCH_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("birch_window_rounded_ctm_pane", ModBlocks.BIRCH_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_ROUNDED_PANE = registerBlockItem("birch_window_rounded_pane", ModBlocks.BIRCH_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SLIM_CTM_PANE = registerBlockItem("birch_window_slim_ctm_pane", ModBlocks.BIRCH_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SLIM_PANE = registerBlockItem("birch_window_slim_pane", ModBlocks.BIRCH_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("birch_window_swirling_ctm_pane", ModBlocks.BIRCH_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SWIRLING_PANE = registerBlockItem("birch_window_swirling_pane", ModBlocks.BIRCH_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_TILES_CTM_PANE = registerBlockItem("birch_window_tiles_ctm_pane", ModBlocks.BIRCH_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_TILES_PANE = registerBlockItem("birch_window_tiles_pane", ModBlocks.BIRCH_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_BARS_CTM_PANE = registerBlockItem("crimson_window_bars_ctm_pane", ModBlocks.CRIMSON_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_BARS_PANE = registerBlockItem("crimson_window_bars_pane", ModBlocks.CRIMSON_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_COVERED_CTM_PANE = registerBlockItem("crimson_window_covered_ctm_pane", ModBlocks.CRIMSON_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_COVERED_PANE = registerBlockItem("crimson_window_covered_pane", ModBlocks.CRIMSON_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_DIAGONAL = registerBlockItem("crimson_window_diagonal", ModBlocks.CRIMSON_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_DIAGONAL_PANE = registerBlockItem("crimson_window_diagonal_pane", ModBlocks.CRIMSON_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_LARGE_CTM_PANE = registerBlockItem("crimson_window_large_ctm_pane", ModBlocks.CRIMSON_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_LARGE_PANE = registerBlockItem("crimson_window_large_pane", ModBlocks.CRIMSON_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_PANES_CTM_PANE = registerBlockItem("crimson_window_panes_ctm_pane", ModBlocks.CRIMSON_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_PANES_PANE = registerBlockItem("crimson_window_panes_pane", ModBlocks.CRIMSON_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("crimson_window_rounded_ctm_pane", ModBlocks.CRIMSON_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_ROUNDED_PANE = registerBlockItem("crimson_window_rounded_pane", ModBlocks.CRIMSON_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SLIM_CTM_PANE = registerBlockItem("crimson_window_slim_ctm_pane", ModBlocks.CRIMSON_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SLIM_PANE = registerBlockItem("crimson_window_slim_pane", ModBlocks.CRIMSON_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("crimson_window_swirling_ctm_pane", ModBlocks.CRIMSON_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SWIRLING_PANE = registerBlockItem("crimson_window_swirling_pane", ModBlocks.CRIMSON_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_TILES_CTM_PANE = registerBlockItem("crimson_window_tiles_ctm_pane", ModBlocks.CRIMSON_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_TILES_PANE = registerBlockItem("crimson_window_tiles_pane", ModBlocks.CRIMSON_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_BARS_CTM_PANE = registerBlockItem("dark_oak_window_bars_ctm_pane", ModBlocks.DARK_OAK_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_BARS_PANE = registerBlockItem("dark_oak_window_bars_pane", ModBlocks.DARK_OAK_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_COVERED_CTM_PANE = registerBlockItem("dark_oak_window_covered_ctm_pane", ModBlocks.DARK_OAK_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_COVERED_PANE = registerBlockItem("dark_oak_window_covered_pane", ModBlocks.DARK_OAK_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("dark_oak_window_diagonal_ctm_pane", ModBlocks.DARK_OAK_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_DIAGONAL_PANE = registerBlockItem("dark_oak_window_diagonal_pane", ModBlocks.DARK_OAK_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_LARGE = registerBlockItem("dark_oak_window_large", ModBlocks.DARK_OAK_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_LARGE_CTM_PANE = registerBlockItem("dark_oak_window_large_ctm_pane", ModBlocks.DARK_OAK_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_LARGE_PANE = registerBlockItem("dark_oak_window_large_pane", ModBlocks.DARK_OAK_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_PANES_CTM_PANE = registerBlockItem("dark_oak_window_panes_ctm_pane", ModBlocks.DARK_OAK_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_PANES_PANE = registerBlockItem("dark_oak_window_panes_pane", ModBlocks.DARK_OAK_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("dark_oak_window_rounded_ctm_pane", ModBlocks.DARK_OAK_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_ROUNDED_PANE = registerBlockItem("dark_oak_window_rounded_pane", ModBlocks.DARK_OAK_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SLIM_CTM_PANE = registerBlockItem("dark_oak_window_slim_ctm_pane", ModBlocks.DARK_OAK_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SLIM_PANE = registerBlockItem("dark_oak_window_slim_pane", ModBlocks.DARK_OAK_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("dark_oak_window_swirling_ctm_pane", ModBlocks.DARK_OAK_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SWIRLING_PANE = registerBlockItem("dark_oak_window_swirling_pane", ModBlocks.DARK_OAK_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_TILES_CTM_PANE = registerBlockItem("dark_oak_window_tiles_ctm_pane", ModBlocks.DARK_OAK_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_TILES_PANE = registerBlockItem("dark_oak_window_tiles_pane", ModBlocks.DARK_OAK_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_BARS_CTM_PANE = registerBlockItem("jungle_window_bars_ctm_pane", ModBlocks.JUNGLE_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_BARS_PANE = registerBlockItem("jungle_window_bars_pane", ModBlocks.JUNGLE_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_COVERED_CTM_PANE = registerBlockItem("jungle_window_covered_ctm_pane", ModBlocks.JUNGLE_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_COVERED_PANE = registerBlockItem("jungle_window_covered_pane", ModBlocks.JUNGLE_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("jungle_window_diagonal_ctm_pane", ModBlocks.JUNGLE_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_DIAGONAL_PANE = registerBlockItem("jungle_window_diagonal_pane", ModBlocks.JUNGLE_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_LARGE_CTM_PANE = registerBlockItem("jungle_window_large_ctm_pane", ModBlocks.JUNGLE_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_LARGE_PANE = registerBlockItem("jungle_window_large_pane", ModBlocks.JUNGLE_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_PANES_CTM_PANE = registerBlockItem("jungle_window_panes_ctm_pane", ModBlocks.JUNGLE_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_PANES_PANE = registerBlockItem("jungle_window_panes_pane", ModBlocks.JUNGLE_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("jungle_window_rounded_ctm_pane", ModBlocks.JUNGLE_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_ROUNDED_PANE = registerBlockItem("jungle_window_rounded_pane", ModBlocks.JUNGLE_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SLIM = registerBlockItem("jungle_window_slim", ModBlocks.JUNGLE_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SLIM_PANE = registerBlockItem("jungle_window_slim_pane", ModBlocks.JUNGLE_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("jungle_window_swirling_ctm_pane", ModBlocks.JUNGLE_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SWIRLING_PANE = registerBlockItem("jungle_window_swirling_pane", ModBlocks.JUNGLE_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_TILES_CTM_PANE = registerBlockItem("jungle_window_tiles_ctm_pane", ModBlocks.JUNGLE_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_TILES_PANE = registerBlockItem("jungle_window_tiles_pane", ModBlocks.JUNGLE_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_BARS_CTM_PANE = registerBlockItem("mangrove_window_bars_ctm_pane", ModBlocks.MANGROVE_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_BARS_PANE = registerBlockItem("mangrove_window_bars_pane", ModBlocks.MANGROVE_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_COVERED_CTM_PANE = registerBlockItem("mangrove_window_covered_ctm_pane", ModBlocks.MANGROVE_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_COVERED_PANE = registerBlockItem("mangrove_window_covered_pane", ModBlocks.MANGROVE_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("mangrove_window_diagonal_ctm_pane", ModBlocks.MANGROVE_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_DIAGONAL_PANE = registerBlockItem("mangrove_window_diagonal_pane", ModBlocks.MANGROVE_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_LARGE_CTM_PANE = registerBlockItem("mangrove_window_large_ctm_pane", ModBlocks.MANGROVE_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_LARGE_PANE = registerBlockItem("mangrove_window_large_pane", ModBlocks.MANGROVE_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_PANES_CTM_PANE = registerBlockItem("mangrove_window_panes_ctm_pane", ModBlocks.MANGROVE_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_PANES_PANE = registerBlockItem("mangrove_window_panes_pane", ModBlocks.MANGROVE_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_ROUNDED = registerBlockItem("mangrove_window_rounded", ModBlocks.MANGROVE_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_ROUNDED_PANE = registerBlockItem("mangrove_window_rounded_pane", ModBlocks.MANGROVE_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SLIM_CTM_PANE = registerBlockItem("mangrove_window_slim_ctm_pane", ModBlocks.MANGROVE_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SLIM_PANE = registerBlockItem("mangrove_window_slim_pane", ModBlocks.MANGROVE_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("mangrove_window_swirling_ctm_pane", ModBlocks.MANGROVE_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SWIRLING_PANE = registerBlockItem("mangrove_window_swirling_pane", ModBlocks.MANGROVE_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_TILES_CTM_PANE = registerBlockItem("mangrove_window_tiles_ctm_pane", ModBlocks.MANGROVE_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_TILES_PANE = registerBlockItem("mangrove_window_tiles_pane", ModBlocks.MANGROVE_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_BARS_CTM_PANE = registerBlockItem("oak_window_bars_ctm_pane", ModBlocks.OAK_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_BARS_PANE = registerBlockItem("oak_window_bars_pane", ModBlocks.OAK_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_COVERED_CTM_PANE = registerBlockItem("oak_window_covered_ctm_pane", ModBlocks.OAK_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_COVERED_PANE = registerBlockItem("oak_window_covered_pane", ModBlocks.OAK_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("oak_window_diagonal_ctm_pane", ModBlocks.OAK_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_DIAGONAL_PANE = registerBlockItem("oak_window_diagonal_pane", ModBlocks.OAK_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_LARGE_CTM_PANE = registerBlockItem("oak_window_large_ctm_pane", ModBlocks.OAK_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_LARGE_PANE = registerBlockItem("oak_window_large_pane", ModBlocks.OAK_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_PANES = registerBlockItem("oak_window_panes", ModBlocks.OAK_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_PANES_PANE = registerBlockItem("oak_window_panes_pane", ModBlocks.OAK_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("oak_window_rounded_ctm_pane", ModBlocks.OAK_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_ROUNDED_PANE = registerBlockItem("oak_window_rounded_pane", ModBlocks.OAK_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SLIM_CTM_PANE = registerBlockItem("oak_window_slim_ctm_pane", ModBlocks.OAK_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SLIM_PANE = registerBlockItem("oak_window_slim_pane", ModBlocks.OAK_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("oak_window_swirling_ctm_pane", ModBlocks.OAK_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SWIRLING_PANE = registerBlockItem("oak_window_swirling_pane", ModBlocks.OAK_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_TILES_CTM_PANE = registerBlockItem("oak_window_tiles_ctm_pane", ModBlocks.OAK_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_TILES_PANE = registerBlockItem("oak_window_tiles_pane", ModBlocks.OAK_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_BARS_CTM_PANE = registerBlockItem("spruce_window_bars_ctm_pane", ModBlocks.SPRUCE_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_BARS_PANE = registerBlockItem("spruce_window_bars_pane", ModBlocks.SPRUCE_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_COVERED_CTM_PANE = registerBlockItem("spruce_window_covered_ctm_pane", ModBlocks.SPRUCE_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_COVERED_PANE = registerBlockItem("spruce_window_covered_pane", ModBlocks.SPRUCE_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("spruce_window_diagonal_ctm_pane", ModBlocks.SPRUCE_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_DIAGONAL_PANE = registerBlockItem("spruce_window_diagonal_pane", ModBlocks.SPRUCE_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_LARGE_CTM_PANE = registerBlockItem("spruce_window_large_ctm_pane", ModBlocks.SPRUCE_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_LARGE_PANE = registerBlockItem("spruce_window_large_pane", ModBlocks.SPRUCE_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_PANES_CTM_PANE = registerBlockItem("spruce_window_panes_ctm_pane", ModBlocks.SPRUCE_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_PANES_PANE = registerBlockItem("spruce_window_panes_pane", ModBlocks.SPRUCE_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("spruce_window_rounded_ctm_pane", ModBlocks.SPRUCE_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_ROUNDED_PANE = registerBlockItem("spruce_window_rounded_pane", ModBlocks.SPRUCE_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SLIM_CTM_PANE = registerBlockItem("spruce_window_slim_ctm_pane", ModBlocks.SPRUCE_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SLIM_PANE = registerBlockItem("spruce_window_slim_pane", ModBlocks.SPRUCE_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SWIRLING_PANE = registerBlockItem("spruce_window_swirling_pane", ModBlocks.SPRUCE_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_TILES_CTM_PANE = registerBlockItem("spruce_window_tiles_ctm_pane", ModBlocks.SPRUCE_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_TILES_PANE = registerBlockItem("spruce_window_tiles_pane", ModBlocks.SPRUCE_WINDOW_TILES_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_BARS_CTM_PANE = registerBlockItem("warped_window_bars_ctm_pane", ModBlocks.WARPED_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_BARS_PANE = registerBlockItem("warped_window_bars_pane", ModBlocks.WARPED_WINDOW_BARS_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_COVERED_CTM_PANE = registerBlockItem("warped_window_covered_ctm_pane", ModBlocks.WARPED_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_COVERED_PANE = registerBlockItem("warped_window_covered_pane", ModBlocks.WARPED_WINDOW_COVERED_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("warped_window_diagonal_ctm_pane", ModBlocks.WARPED_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_DIAGONAL_PANE = registerBlockItem("warped_window_diagonal_pane", ModBlocks.WARPED_WINDOW_DIAGONAL_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_LARGE_CTM_PANE = registerBlockItem("warped_window_large_ctm_pane", ModBlocks.WARPED_WINDOW_LARGE_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_LARGE_PANE = registerBlockItem("warped_window_large_pane", ModBlocks.WARPED_WINDOW_LARGE_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_PANES_CTM_PANE = registerBlockItem("warped_window_panes_ctm_pane", ModBlocks.WARPED_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_PANES_PANE = registerBlockItem("warped_window_panes_pane", ModBlocks.WARPED_WINDOW_PANES_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("warped_window_rounded_ctm_pane", ModBlocks.WARPED_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_ROUNDED_PANE = registerBlockItem("warped_window_rounded_pane", ModBlocks.WARPED_WINDOW_ROUNDED_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SLIM_CTM_PANE = registerBlockItem("warped_window_slim_ctm_pane", ModBlocks.WARPED_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SLIM_PANE = registerBlockItem("warped_window_slim_pane", ModBlocks.WARPED_WINDOW_SLIM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SWIRLING = registerBlockItem("warped_window_swirling", ModBlocks.WARPED_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SWIRLING_PANE = registerBlockItem("warped_window_swirling_pane", ModBlocks.WARPED_WINDOW_SWIRLING_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_TILES_CTM_PANE = registerBlockItem("warped_window_tiles_ctm_pane", ModBlocks.WARPED_WINDOW_TILES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_TILES_PANE = registerBlockItem("warped_window_tiles_pane", ModBlocks.WARPED_WINDOW_TILES_PANE);

}