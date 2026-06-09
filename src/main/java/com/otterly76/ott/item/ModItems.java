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


    // ===== RECOVERED GRANITE =====
    public static final DeferredHolder<Item, BlockItem> BORDERED_GRANITE =
        registerBlockItem("bordered_granite", ModBlocks.BORDERED_GRANITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_GRANITE =
        registerBlockItem("brick_bordered_granite", ModBlocks.BRICK_BORDERED_GRANITE);
    public static final DeferredHolder<Item, BlockItem> CURLY_GRANITE_CTM =
        registerBlockItem("curly_granite_ctm", ModBlocks.CURLY_GRANITE_CTM);
    public static final DeferredHolder<Item, BlockItem> CUT_GRANITE_COLUMN =
        registerBlockItem("cut_granite_column", ModBlocks.CUT_GRANITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> EDGED_GRANITE_BRICKS =
        registerBlockItem("edged_granite_bricks", ModBlocks.EDGED_GRANITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> FINE_GRANITE_CTM =
        registerBlockItem("fine_granite_ctm", ModBlocks.FINE_GRANITE_CTM);
    public static final DeferredHolder<Item, BlockItem> GRANITE_BRICK_PATTERN = registerBlockItem("granite_brick_pattern", ModBlocks.GRANITE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> GRANITE_BRICK_PAVING = registerBlockItem("granite_brick_paving", ModBlocks.GRANITE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> GRANITE_BRICKS = registerBlockItem("granite_bricks", ModBlocks.GRANITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GRANITE_CUT_POLISHED = registerBlockItem("granite_cut_polished", ModBlocks.GRANITE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> GRANITE_CUT_SMALL_BRICK = registerBlockItem("granite_cut_small_brick", ModBlocks.GRANITE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> GRANITE_DIAGONAL_BRICKS = registerBlockItem("granite_diagonal_bricks", ModBlocks.GRANITE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GRANITE_DOTTED = registerBlockItem("granite_dotted", ModBlocks.GRANITE_DOTTED);
    public static final DeferredHolder<Item, BlockItem> GRANITE_PAVING = registerBlockItem("granite_paving", ModBlocks.GRANITE_PAVING);
    public static final DeferredHolder<Item, BlockItem> GRANITE_POLISHED = registerBlockItem("granite_polished", ModBlocks.GRANITE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> GRANITE_PRISMARINE =
        registerBlockItem("granite_prismarine", ModBlocks.GRANITE_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> GRANITE_ROTATED_BRICKS = registerBlockItem("granite_rotated_bricks", ModBlocks.GRANITE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GRANITE_SQUARES = registerBlockItem("granite_squares", ModBlocks.GRANITE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> GRANITE_TILES = registerBlockItem("granite_tiles", ModBlocks.GRANITE_TILES);
    public static final DeferredHolder<Item, BlockItem> GRANITE_WAVY = registerBlockItem("granite_wavy", ModBlocks.GRANITE_WAVY);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_GRANITE_BRICKS =
        registerBlockItem("massive_granite_bricks", ModBlocks.MASSIVE_GRANITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRANITE_CTM =
        registerBlockItem("ornate_granite_ctm", ModBlocks.ORNATE_GRANITE_CTM);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_GRANITE_TILES =
        registerBlockItem("overlapping_granite_tiles", ModBlocks.OVERLAPPING_GRANITE_TILES);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_GRANITE_CTM =
        registerBlockItem("simple_granite_ctm", ModBlocks.SIMPLE_GRANITE_CTM);
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


    // ===== RECOVERED WAVE1 =====
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_BEAMS = registerBlockItem("acacia_planks_beams", ModBlocks.ACACIA_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_BRICK_PATTERN = registerBlockItem("acacia_planks_brick_pattern", ModBlocks.ACACIA_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_BRICK_PAVING = registerBlockItem("acacia_planks_brick_paving", ModBlocks.ACACIA_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_BRICKS = registerBlockItem("acacia_planks_bricks", ModBlocks.ACACIA_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_CRATE = registerBlockItem("acacia_planks_crate", ModBlocks.ACACIA_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_DIAGONAL_STRIPES = registerBlockItem("acacia_planks_diagonal_stripes", ModBlocks.ACACIA_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_DIAGONAL_TILES = registerBlockItem("acacia_planks_diagonal_tiles", ModBlocks.ACACIA_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_DOTTED = registerBlockItem("acacia_planks_dotted", ModBlocks.ACACIA_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_FLOORING = registerBlockItem("acacia_planks_flooring", ModBlocks.ACACIA_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_LARGE_TILES = registerBlockItem("acacia_planks_large_tiles", ModBlocks.ACACIA_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_PANEL =
        registerBlockItem("acacia_planks_panel", ModBlocks.ACACIA_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_PATTERN = registerBlockItem("acacia_planks_pattern", ModBlocks.ACACIA_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_ROTATED_BRICKS = registerBlockItem("acacia_planks_rotated_bricks", ModBlocks.ACACIA_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_SMALL_BRICKS = registerBlockItem("acacia_planks_small_bricks", ModBlocks.ACACIA_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_SMALL_TILES = registerBlockItem("acacia_planks_small_tiles", ModBlocks.ACACIA_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_SQUARES = registerBlockItem("acacia_planks_squares", ModBlocks.ACACIA_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_TILES = registerBlockItem("acacia_planks_tiles", ModBlocks.ACACIA_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_WAVY = registerBlockItem("acacia_planks_wavy", ModBlocks.ACACIA_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> ACACIA_PLANKS_WOVEN = registerBlockItem("acacia_planks_woven", ModBlocks.ACACIA_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_BARS_CTM = registerBlockItem("acacia_window_bars_ctm", ModBlocks.ACACIA_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_BARS_CTM_PANE = registerBlockItem("acacia_window_bars_ctm_pane", ModBlocks.ACACIA_WINDOW_BARS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_COVERED = registerBlockItem("acacia_window_covered", ModBlocks.ACACIA_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_COVERED_CTM = registerBlockItem("acacia_window_covered_ctm", ModBlocks.ACACIA_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_DIAGONAL = registerBlockItem("acacia_window_diagonal", ModBlocks.ACACIA_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_DIAGONAL_CTM = registerBlockItem("acacia_window_diagonal_ctm", ModBlocks.ACACIA_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_LARGE = registerBlockItem("acacia_window_large", ModBlocks.ACACIA_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_LARGE_CTM = registerBlockItem("acacia_window_large_ctm", ModBlocks.ACACIA_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_PANES = registerBlockItem("acacia_window_panes", ModBlocks.ACACIA_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_PANES_CTM = registerBlockItem("acacia_window_panes_ctm", ModBlocks.ACACIA_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_ROUNDED = registerBlockItem("acacia_window_rounded", ModBlocks.ACACIA_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_ROUNDED_CTM = registerBlockItem("acacia_window_rounded_ctm", ModBlocks.ACACIA_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SLIM = registerBlockItem("acacia_window_slim", ModBlocks.ACACIA_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SLIM_CTM = registerBlockItem("acacia_window_slim_ctm", ModBlocks.ACACIA_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SWIRLING = registerBlockItem("acacia_window_swirling", ModBlocks.ACACIA_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_SWIRLING_CTM = registerBlockItem("acacia_window_swirling_ctm", ModBlocks.ACACIA_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_TILES = registerBlockItem("acacia_window_tiles", ModBlocks.ACACIA_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> ACACIA_WINDOW_TILES_CTM = registerBlockItem("acacia_window_tiles_ctm", ModBlocks.ACACIA_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_BEAMS = registerBlockItem("amethyst_block_beams", ModBlocks.AMETHYST_BLOCK_BEAMS);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES = registerBlockItem("amethyst_block_bordered_diagonal_tiles", ModBlocks.AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_BRICKS = registerBlockItem("amethyst_block_bricks", ModBlocks.AMETHYST_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_CTM = registerBlockItem("amethyst_block_ctm", ModBlocks.AMETHYST_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_CUT = registerBlockItem("amethyst_block_cut", ModBlocks.AMETHYST_BLOCK_CUT);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_EDGED = registerBlockItem("amethyst_block_edged", ModBlocks.AMETHYST_BLOCK_EDGED);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_POLISHED = registerBlockItem("amethyst_block_polished", ModBlocks.AMETHYST_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_SHINY = registerBlockItem("amethyst_block_shiny", ModBlocks.AMETHYST_BLOCK_SHINY);
    public static final DeferredHolder<Item, BlockItem> AMETHYST_BLOCK_TILES = registerBlockItem("amethyst_block_tiles", ModBlocks.AMETHYST_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_BRICK_PATTERN = registerBlockItem("andesite_brick_pattern", ModBlocks.ANDESITE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_BRICK_PAVING = registerBlockItem("andesite_brick_paving", ModBlocks.ANDESITE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_BRICKS = registerBlockItem("andesite_bricks", ModBlocks.ANDESITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_CUT_POLISHED = registerBlockItem("andesite_cut_polished", ModBlocks.ANDESITE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_CUT_SMALL_BRICK = registerBlockItem("andesite_cut_small_brick", ModBlocks.ANDESITE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_DIAGONAL_BRICKS = registerBlockItem("andesite_diagonal_bricks", ModBlocks.ANDESITE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_DOTTED = registerBlockItem("andesite_dotted", ModBlocks.ANDESITE_DOTTED);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_PAVING = registerBlockItem("andesite_paving", ModBlocks.ANDESITE_PAVING);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_POLISHED = registerBlockItem("andesite_polished", ModBlocks.ANDESITE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_ROTATED_BRICKS = registerBlockItem("andesite_rotated_bricks", ModBlocks.ANDESITE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_SQUARES = registerBlockItem("andesite_squares", ModBlocks.ANDESITE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_TILES = registerBlockItem("andesite_tiles", ModBlocks.ANDESITE_TILES);
    public static final DeferredHolder<Item, BlockItem> ANDESITE_WAVY = registerBlockItem("andesite_wavy", ModBlocks.ANDESITE_WAVY);
    public static final DeferredHolder<Item, BlockItem> APPLE_ACACIA_LEAVES =
        registerBlockItem("apple_acacia_leaves", ModBlocks.APPLE_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> APPLE_BIRCH_LEAVES =
        registerBlockItem("apple_birch_leaves", ModBlocks.APPLE_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> APPLE_DARK_OAK_LEAVES =
        registerBlockItem("apple_dark_oak_leaves", ModBlocks.APPLE_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> APPLE_JUNGLE_LEAVES =
        registerBlockItem("apple_jungle_leaves", ModBlocks.APPLE_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> APPLE_OAK_LEAVES =
        registerBlockItem("apple_oak_leaves", ModBlocks.APPLE_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> APPLE_SPRUCE_LEAVES =
        registerBlockItem("apple_spruce_leaves", ModBlocks.APPLE_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ARCHED_BLACK_STAINED_GLASS_CTM =
        registerBlockItem("arched_black_stained_glass_ctm", ModBlocks.ARCHED_BLACK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_black_stained_glass_ctm_pane", ModBlocks.ARCHED_BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("arched_blue_stained_glass_ctm", ModBlocks.ARCHED_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_blue_stained_glass_ctm_pane", ModBlocks.ARCHED_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_BROWN_STAINED_GLASS_CTM =
        registerBlockItem("arched_brown_stained_glass_ctm", ModBlocks.ARCHED_BROWN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_brown_stained_glass_ctm_pane", ModBlocks.ARCHED_BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_CYAN_STAINED_GLASS_CTM =
        registerBlockItem("arched_cyan_stained_glass_ctm", ModBlocks.ARCHED_CYAN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_cyan_stained_glass_ctm_pane", ModBlocks.ARCHED_CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("arched_gray_stained_glass_ctm", ModBlocks.ARCHED_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_gray_stained_glass_ctm_pane", ModBlocks.ARCHED_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_GREEN_STAINED_GLASS_CTM =
        registerBlockItem("arched_green_stained_glass_ctm", ModBlocks.ARCHED_GREEN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_green_stained_glass_ctm_pane", ModBlocks.ARCHED_GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LEADED_GLASS_CTM =
        registerBlockItem("arched_leaded_glass_ctm", ModBlocks.ARCHED_LEADED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LEADED_GLASS_CTM_PANE = registerBlockItem("arched_leaded_glass_ctm_pane", ModBlocks.ARCHED_LEADED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("arched_light_blue_stained_glass_ctm", ModBlocks.ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_light_blue_stained_glass_ctm_pane", ModBlocks.ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("arched_light_gray_stained_glass_ctm", ModBlocks.ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_light_gray_stained_glass_ctm_pane", ModBlocks.ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIME_STAINED_GLASS_CTM =
        registerBlockItem("arched_lime_stained_glass_ctm", ModBlocks.ARCHED_LIME_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_LIME_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_lime_stained_glass_ctm_pane", ModBlocks.ARCHED_LIME_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_MAGENTA_STAINED_GLASS_CTM =
        registerBlockItem("arched_magenta_stained_glass_ctm", ModBlocks.ARCHED_MAGENTA_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_MAGENTA_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_magenta_stained_glass_ctm_pane", ModBlocks.ARCHED_MAGENTA_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_ORANGE_STAINED_GLASS_CTM =
        registerBlockItem("arched_orange_stained_glass_ctm", ModBlocks.ARCHED_ORANGE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_ORANGE_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_orange_stained_glass_ctm_pane", ModBlocks.ARCHED_ORANGE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_PINK_STAINED_GLASS_CTM =
        registerBlockItem("arched_pink_stained_glass_ctm", ModBlocks.ARCHED_PINK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_PINK_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_pink_stained_glass_ctm_pane", ModBlocks.ARCHED_PINK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_PURPLE_STAINED_GLASS_CTM =
        registerBlockItem("arched_purple_stained_glass_ctm", ModBlocks.ARCHED_PURPLE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_PURPLE_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_purple_stained_glass_ctm_pane", ModBlocks.ARCHED_PURPLE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_RED_STAINED_GLASS_CTM =
        registerBlockItem("arched_red_stained_glass_ctm", ModBlocks.ARCHED_RED_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_RED_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_red_stained_glass_ctm_pane", ModBlocks.ARCHED_RED_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_WHITE_STAINED_GLASS_CTM =
        registerBlockItem("arched_white_stained_glass_ctm", ModBlocks.ARCHED_WHITE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_WHITE_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_white_stained_glass_ctm_pane", ModBlocks.ARCHED_WHITE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ARCHED_YELLOW_STAINED_GLASS_CTM =
        registerBlockItem("arched_yellow_stained_glass_ctm", ModBlocks.ARCHED_YELLOW_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ARCHED_YELLOW_STAINED_GLASS_CTM_PANE = registerBlockItem("arched_yellow_stained_glass_ctm_pane", ModBlocks.ARCHED_YELLOW_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ASURINE_CUT_POLISHED = registerBlockItem("asurine_cut_polished", ModBlocks.ASURINE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> ASURINE_CUT_SMALL_BRICK = registerBlockItem("asurine_cut_small_brick", ModBlocks.ASURINE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_BEAMS = registerBlockItem("bamboo_planks_beams", ModBlocks.BAMBOO_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_BRICK_PATTERN = registerBlockItem("bamboo_planks_brick_pattern", ModBlocks.BAMBOO_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_BRICK_PAVING = registerBlockItem("bamboo_planks_brick_paving", ModBlocks.BAMBOO_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_BRICKS = registerBlockItem("bamboo_planks_bricks", ModBlocks.BAMBOO_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_CRATE = registerBlockItem("bamboo_planks_crate", ModBlocks.BAMBOO_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_DIAGONAL_STRIPES = registerBlockItem("bamboo_planks_diagonal_stripes", ModBlocks.BAMBOO_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_DIAGONAL_TILES = registerBlockItem("bamboo_planks_diagonal_tiles", ModBlocks.BAMBOO_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_DOTTED = registerBlockItem("bamboo_planks_dotted", ModBlocks.BAMBOO_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_FLOORING = registerBlockItem("bamboo_planks_flooring", ModBlocks.BAMBOO_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_LARGE_TILES = registerBlockItem("bamboo_planks_large_tiles", ModBlocks.BAMBOO_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_PANEL =
        registerBlockItem("bamboo_planks_panel", ModBlocks.BAMBOO_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_PATTERN = registerBlockItem("bamboo_planks_pattern", ModBlocks.BAMBOO_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_ROTATED_BRICKS = registerBlockItem("bamboo_planks_rotated_bricks", ModBlocks.BAMBOO_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_SMALL_BRICKS = registerBlockItem("bamboo_planks_small_bricks", ModBlocks.BAMBOO_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_SMALL_TILES = registerBlockItem("bamboo_planks_small_tiles", ModBlocks.BAMBOO_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_SQUARES = registerBlockItem("bamboo_planks_squares", ModBlocks.BAMBOO_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_TILES = registerBlockItem("bamboo_planks_tiles", ModBlocks.BAMBOO_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_WAVY = registerBlockItem("bamboo_planks_wavy", ModBlocks.BAMBOO_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_PLANKS_WOVEN = registerBlockItem("bamboo_planks_woven", ModBlocks.BAMBOO_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> BASALT_BEAMS = registerBlockItem("basalt_beams", ModBlocks.BASALT_BEAMS);
    public static final DeferredHolder<Item, BlockItem> BASALT_BORDERED = registerBlockItem("basalt_bordered", ModBlocks.BASALT_BORDERED);
    public static final DeferredHolder<Item, BlockItem> BASALT_BORDERED_POLISHED = registerBlockItem("basalt_bordered_polished", ModBlocks.BASALT_BORDERED_POLISHED);
    public static final DeferredHolder<Item, BlockItem> BASALT_BRICKS = registerBlockItem("basalt_bricks", ModBlocks.BASALT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BASALT_DIAGONAL_TILES = registerBlockItem("basalt_diagonal_tiles", ModBlocks.BASALT_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> BASALT_PATTERN = registerBlockItem("basalt_pattern", ModBlocks.BASALT_PATTERN);
    public static final DeferredHolder<Item, BlockItem> BASALT_PATTERNED = registerBlockItem("basalt_patterned", ModBlocks.BASALT_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> BASALT_TILES = registerBlockItem("basalt_tiles", ModBlocks.BASALT_TILES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_BEAMS = registerBlockItem("birch_planks_beams", ModBlocks.BIRCH_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_BRICK_PATTERN = registerBlockItem("birch_planks_brick_pattern", ModBlocks.BIRCH_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_BRICK_PAVING = registerBlockItem("birch_planks_brick_paving", ModBlocks.BIRCH_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_BRICKS = registerBlockItem("birch_planks_bricks", ModBlocks.BIRCH_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_CRATE = registerBlockItem("birch_planks_crate", ModBlocks.BIRCH_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_DIAGONAL_STRIPES = registerBlockItem("birch_planks_diagonal_stripes", ModBlocks.BIRCH_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_DIAGONAL_TILES = registerBlockItem("birch_planks_diagonal_tiles", ModBlocks.BIRCH_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_DOTTED = registerBlockItem("birch_planks_dotted", ModBlocks.BIRCH_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_FLOORING = registerBlockItem("birch_planks_flooring", ModBlocks.BIRCH_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_LARGE_TILES = registerBlockItem("birch_planks_large_tiles", ModBlocks.BIRCH_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_PANEL =
        registerBlockItem("birch_planks_panel", ModBlocks.BIRCH_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_PATTERN = registerBlockItem("birch_planks_pattern", ModBlocks.BIRCH_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_ROTATED_BRICKS = registerBlockItem("birch_planks_rotated_bricks", ModBlocks.BIRCH_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_SMALL_BRICKS = registerBlockItem("birch_planks_small_bricks", ModBlocks.BIRCH_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_SMALL_TILES = registerBlockItem("birch_planks_small_tiles", ModBlocks.BIRCH_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_SQUARES = registerBlockItem("birch_planks_squares", ModBlocks.BIRCH_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_TILES = registerBlockItem("birch_planks_tiles", ModBlocks.BIRCH_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_WAVY = registerBlockItem("birch_planks_wavy", ModBlocks.BIRCH_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> BIRCH_PLANKS_WOVEN = registerBlockItem("birch_planks_woven", ModBlocks.BIRCH_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_BARS = registerBlockItem("birch_window_bars", ModBlocks.BIRCH_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_BARS_CTM = registerBlockItem("birch_window_bars_ctm", ModBlocks.BIRCH_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_COVERED_CTM = registerBlockItem("birch_window_covered_ctm", ModBlocks.BIRCH_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_COVERED_CTM_PANE = registerBlockItem("birch_window_covered_ctm_pane", ModBlocks.BIRCH_WINDOW_COVERED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_DIAGONAL = registerBlockItem("birch_window_diagonal", ModBlocks.BIRCH_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_DIAGONAL_CTM = registerBlockItem("birch_window_diagonal_ctm", ModBlocks.BIRCH_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_LARGE = registerBlockItem("birch_window_large", ModBlocks.BIRCH_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_LARGE_CTM = registerBlockItem("birch_window_large_ctm", ModBlocks.BIRCH_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_PANES = registerBlockItem("birch_window_panes", ModBlocks.BIRCH_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_PANES_CTM = registerBlockItem("birch_window_panes_ctm", ModBlocks.BIRCH_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_ROUNDED = registerBlockItem("birch_window_rounded", ModBlocks.BIRCH_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_ROUNDED_CTM = registerBlockItem("birch_window_rounded_ctm", ModBlocks.BIRCH_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SLIM = registerBlockItem("birch_window_slim", ModBlocks.BIRCH_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SLIM_CTM = registerBlockItem("birch_window_slim_ctm", ModBlocks.BIRCH_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SWIRLING = registerBlockItem("birch_window_swirling", ModBlocks.BIRCH_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_SWIRLING_CTM = registerBlockItem("birch_window_swirling_ctm", ModBlocks.BIRCH_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_TILES = registerBlockItem("birch_window_tiles", ModBlocks.BIRCH_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> BIRCH_WINDOW_TILES_CTM = registerBlockItem("birch_window_tiles_ctm", ModBlocks.BIRCH_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> BLACK_CONCRETE_CTM =
        registerBlockItem("black_concrete_ctm", ModBlocks.BLACK_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> BLACK_CONCRETE_PANEL =
        registerBlockItem("black_concrete_panel", ModBlocks.BLACK_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> BLACK_TERRACOTTA_COLUMN =
        registerBlockItem("black_terracotta_column", ModBlocks.BLACK_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> BLACK_TERRACOTTA_CTM =
        registerBlockItem("black_terracotta_ctm", ModBlocks.BLACK_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_BRICK_PATTERN = registerBlockItem("blackstone_brick_pattern", ModBlocks.BLACKSTONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_BRICK_PAVING = registerBlockItem("blackstone_brick_paving", ModBlocks.BLACKSTONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_DIAGONAL_BRICKS = registerBlockItem("blackstone_diagonal_bricks", ModBlocks.BLACKSTONE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_POLISHED = registerBlockItem("blackstone_polished", ModBlocks.BLACKSTONE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_ROTATED_BRICKS = registerBlockItem("blackstone_rotated_bricks", ModBlocks.BLACKSTONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_TILES = registerBlockItem("blackstone_tiles", ModBlocks.BLACKSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> BLUE_CONCRETE_CTM =
        registerBlockItem("blue_concrete_ctm", ModBlocks.BLUE_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> BLUE_CONCRETE_PANEL =
        registerBlockItem("blue_concrete_panel", ModBlocks.BLUE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_BORDERED = registerBlockItem("blue_ice_bordered", ModBlocks.BLUE_ICE_BORDERED);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_BRICKS = registerBlockItem("blue_ice_bricks", ModBlocks.BLUE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_CHISELED = registerBlockItem("blue_ice_chiseled", ModBlocks.BLUE_ICE_CHISELED);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_CTM = registerBlockItem("blue_ice_ctm", ModBlocks.BLUE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_PATTERNED = registerBlockItem("blue_ice_patterned", ModBlocks.BLUE_ICE_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_SLANTED_TILES = registerBlockItem("blue_ice_slanted_tiles", ModBlocks.BLUE_ICE_SLANTED_TILES);
    public static final DeferredHolder<Item, BlockItem> BLUE_ICE_TILES = registerBlockItem("blue_ice_tiles", ModBlocks.BLUE_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> BLUE_TERRACOTTA_COLUMN =
        registerBlockItem("blue_terracotta_column", ModBlocks.BLUE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> BLUE_TERRACOTTA_CTM =
        registerBlockItem("blue_terracotta_ctm", ModBlocks.BLUE_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_BORDERED = registerBlockItem("bone_block_bordered", ModBlocks.BONE_BLOCK_BORDERED);
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_CHISELED = registerBlockItem("bone_block_chiseled", ModBlocks.BONE_BLOCK_CHISELED);
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_CONNECTING = registerBlockItem("bone_block_connecting", ModBlocks.BONE_BLOCK_CONNECTING);
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_DECORATED_BORDERED = registerBlockItem("bone_block_decorated_bordered", ModBlocks.BONE_BLOCK_DECORATED_BORDERED);
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_INVERTED_TILES = registerBlockItem("bone_block_inverted_tiles", ModBlocks.BONE_BLOCK_INVERTED_TILES);
    public static final DeferredHolder<Item, BlockItem> BONE_BLOCK_PATTERNED = registerBlockItem("bone_block_patterned", ModBlocks.BONE_BLOCK_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> BORDERED_AMETHYST_BLOCK =
        registerBlockItem("bordered_amethyst_block", ModBlocks.BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("bordered_ancient_debris", ModBlocks.BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_BASALT =
        registerBlockItem("bordered_basalt", ModBlocks.BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> BORDERED_BLACKSTONE =
        registerBlockItem("bordered_blackstone", ModBlocks.BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_BLUE_ICE =
        registerBlockItem("bordered_blue_ice", ModBlocks.BORDERED_BLUE_ICE);


    // ===== RECOVERED WAVE2 =====
    public static final DeferredHolder<Item, BlockItem> BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("bordered_borderless_bricks", ModBlocks.BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_BRICKS =
        registerBlockItem("bordered_bricks", ModBlocks.BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_CALCITE =
        registerBlockItem("bordered_calcite", ModBlocks.BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_CLAY =
        registerBlockItem("bordered_clay", ModBlocks.BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> BORDERED_COAL_BLOCK =
        registerBlockItem("bordered_coal_block", ModBlocks.BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_COBBLESTONE =
        registerBlockItem("bordered_cobblestone", ModBlocks.BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("bordered_crying_obsidian", ModBlocks.BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> BORDERED_DARK_PRISMARINE =
        registerBlockItem("bordered_dark_prismarine", ModBlocks.BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_DEEPSLATE =
        registerBlockItem("bordered_deepslate", ModBlocks.BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_DIORITE =
        registerBlockItem("bordered_diorite", ModBlocks.BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_DIRT =
        registerBlockItem("bordered_dirt", ModBlocks.BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("bordered_dripstone_block", ModBlocks.BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_END_STONE =
        registerBlockItem("bordered_end_stone", ModBlocks.BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("bordered_gilded_blackstone", ModBlocks.BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_ICE =
        registerBlockItem("bordered_ice", ModBlocks.BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_LAPIS_BLOCK =
        registerBlockItem("bordered_lapis_block", ModBlocks.BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_LODESTONE =
        registerBlockItem("bordered_lodestone", ModBlocks.BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_MAGMA_BLOCK =
        registerBlockItem("bordered_magma_block", ModBlocks.BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("bordered_mossy_cobblestone", ModBlocks.BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("bordered_mossy_stone_bricks", ModBlocks.BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_MUD =
        registerBlockItem("bordered_mud", ModBlocks.BORDERED_MUD);
    public static final DeferredHolder<Item, BlockItem> BORDERED_MUD_BRICKS =
        registerBlockItem("bordered_mud_bricks", ModBlocks.BORDERED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_NETHER_BRICKS =
        registerBlockItem("bordered_nether_bricks", ModBlocks.BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_NETHERRACK =
        registerBlockItem("bordered_netherrack", ModBlocks.BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_OBSIDIAN =
        registerBlockItem("bordered_obsidian", ModBlocks.BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> BORDERED_PACKED_ICE =
        registerBlockItem("bordered_packed_ice", ModBlocks.BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_PACKED_MUD =
        registerBlockItem("bordered_packed_mud", ModBlocks.BORDERED_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> BORDERED_PRISMARINE =
        registerBlockItem("bordered_prismarine", ModBlocks.BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_PURPUR_BLOCK =
        registerBlockItem("bordered_purpur_block", ModBlocks.BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_QUARTZ_BLOCK =
        registerBlockItem("bordered_quartz_block", ModBlocks.BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("bordered_raw_copper_block", ModBlocks.BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("bordered_raw_gold_block", ModBlocks.BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("bordered_raw_iron_block", ModBlocks.BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("bordered_red_nether_bricks", ModBlocks.BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BORDERED_RED_SANDSTONE =
        registerBlockItem("bordered_red_sandstone", ModBlocks.BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_REDSTONE_BLOCK =
        registerBlockItem("bordered_redstone_block", ModBlocks.BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_SANDSTONE =
        registerBlockItem("bordered_sandstone", ModBlocks.BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_SMOOTH_STONE =
        registerBlockItem("bordered_smooth_stone", ModBlocks.BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> BORDERED_SNOW_BLOCK =
        registerBlockItem("bordered_snow_block", ModBlocks.BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BORDERED_TUFF =
        registerBlockItem("bordered_tuff", ModBlocks.BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_AMETHYST_BLOCK =
        registerBlockItem("brick_bordered_amethyst_block", ModBlocks.BRICK_BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("brick_bordered_ancient_debris", ModBlocks.BRICK_BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_ANDESITE =
        registerBlockItem("brick_bordered_andesite", ModBlocks.BRICK_BORDERED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BASALT =
        registerBlockItem("brick_bordered_basalt", ModBlocks.BRICK_BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BLACKSTONE =
        registerBlockItem("brick_bordered_blackstone", ModBlocks.BRICK_BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BLUE_ICE =
        registerBlockItem("brick_bordered_blue_ice", ModBlocks.BRICK_BORDERED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("brick_bordered_borderless_bricks", ModBlocks.BRICK_BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_BRICKS =
        registerBlockItem("brick_bordered_bricks", ModBlocks.BRICK_BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_CALCITE =
        registerBlockItem("brick_bordered_calcite", ModBlocks.BRICK_BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_CLAY =
        registerBlockItem("brick_bordered_clay", ModBlocks.BRICK_BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_COAL_BLOCK =
        registerBlockItem("brick_bordered_coal_block", ModBlocks.BRICK_BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_COBBLESTONE =
        registerBlockItem("brick_bordered_cobblestone", ModBlocks.BRICK_BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("brick_bordered_crying_obsidian", ModBlocks.BRICK_BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DARK_PRISMARINE =
        registerBlockItem("brick_bordered_dark_prismarine", ModBlocks.BRICK_BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DEEPSLATE =
        registerBlockItem("brick_bordered_deepslate", ModBlocks.BRICK_BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DIORITE =
        registerBlockItem("brick_bordered_diorite", ModBlocks.BRICK_BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DIRT =
        registerBlockItem("brick_bordered_dirt", ModBlocks.BRICK_BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("brick_bordered_dripstone_block", ModBlocks.BRICK_BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_END_STONE =
        registerBlockItem("brick_bordered_end_stone", ModBlocks.BRICK_BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("brick_bordered_gilded_blackstone", ModBlocks.BRICK_BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_ICE =
        registerBlockItem("brick_bordered_ice", ModBlocks.BRICK_BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_LAPIS_BLOCK =
        registerBlockItem("brick_bordered_lapis_block", ModBlocks.BRICK_BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_LODESTONE =
        registerBlockItem("brick_bordered_lodestone", ModBlocks.BRICK_BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MAGMA_BLOCK =
        registerBlockItem("brick_bordered_magma_block", ModBlocks.BRICK_BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("brick_bordered_mossy_cobblestone", ModBlocks.BRICK_BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("brick_bordered_mossy_stone_bricks", ModBlocks.BRICK_BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MUD =
        registerBlockItem("brick_bordered_mud", ModBlocks.BRICK_BORDERED_MUD);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_MUD_BRICKS =
        registerBlockItem("brick_bordered_mud_bricks", ModBlocks.BRICK_BORDERED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_NETHER_BRICKS =
        registerBlockItem("brick_bordered_nether_bricks", ModBlocks.BRICK_BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_NETHERRACK =
        registerBlockItem("brick_bordered_netherrack", ModBlocks.BRICK_BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_OBSIDIAN =
        registerBlockItem("brick_bordered_obsidian", ModBlocks.BRICK_BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PACKED_ICE =
        registerBlockItem("brick_bordered_packed_ice", ModBlocks.BRICK_BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PACKED_MUD =
        registerBlockItem("brick_bordered_packed_mud", ModBlocks.BRICK_BORDERED_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PRISMARINE =
        registerBlockItem("brick_bordered_prismarine", ModBlocks.BRICK_BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_PURPUR_BLOCK =
        registerBlockItem("brick_bordered_purpur_block", ModBlocks.BRICK_BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_QUARTZ_BLOCK =
        registerBlockItem("brick_bordered_quartz_block", ModBlocks.BRICK_BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("brick_bordered_raw_copper_block", ModBlocks.BRICK_BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("brick_bordered_raw_gold_block", ModBlocks.BRICK_BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("brick_bordered_raw_iron_block", ModBlocks.BRICK_BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("brick_bordered_red_nether_bricks", ModBlocks.BRICK_BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_RED_SANDSTONE =
        registerBlockItem("brick_bordered_red_sandstone", ModBlocks.BRICK_BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_REDSTONE_BLOCK =
        registerBlockItem("brick_bordered_redstone_block", ModBlocks.BRICK_BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_SANDSTONE =
        registerBlockItem("brick_bordered_sandstone", ModBlocks.BRICK_BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_SMOOTH_STONE =
        registerBlockItem("brick_bordered_smooth_stone", ModBlocks.BRICK_BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_SNOW_BLOCK =
        registerBlockItem("brick_bordered_snow_block", ModBlocks.BRICK_BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> BRICK_BORDERED_TUFF =
        registerBlockItem("brick_bordered_tuff", ModBlocks.BRICK_BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> BROWN_CONCRETE_CTM =
        registerBlockItem("brown_concrete_ctm", ModBlocks.BROWN_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> BROWN_CONCRETE_PANEL =
        registerBlockItem("brown_concrete_panel", ModBlocks.BROWN_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> BROWN_TERRACOTTA_COLUMN =
        registerBlockItem("brown_terracotta_column", ModBlocks.BROWN_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> BROWN_TERRACOTTA_CTM =
        registerBlockItem("brown_terracotta_ctm", ModBlocks.BROWN_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> CALCITE_CUT_POLISHED = registerBlockItem("calcite_cut_polished", ModBlocks.CALCITE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> CALCITE_CUT_SMALL_BRICK = registerBlockItem("calcite_cut_small_brick", ModBlocks.CALCITE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> CARVED_MUD_BRICKS_CTM =
        registerBlockItem("carved_mud_bricks_ctm", ModBlocks.CARVED_MUD_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CARVED_MUD_CTM =
        registerBlockItem("carved_mud_ctm", ModBlocks.CARVED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> CARVED_PACKED_MUD_CTM =
        registerBlockItem("carved_packed_mud_ctm", ModBlocks.CARVED_PACKED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_ACACIA_LEAVES =
        registerBlockItem("cherry_acacia_leaves", ModBlocks.CHERRY_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_BIRCH_LEAVES =
        registerBlockItem("cherry_birch_leaves", ModBlocks.CHERRY_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_DARK_OAK_LEAVES =
        registerBlockItem("cherry_dark_oak_leaves", ModBlocks.CHERRY_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_JUNGLE_LEAVES =
        registerBlockItem("cherry_jungle_leaves", ModBlocks.CHERRY_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_OAK_LEAVES =
        registerBlockItem("cherry_oak_leaves", ModBlocks.CHERRY_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_BEAMS = registerBlockItem("cherry_planks_beams", ModBlocks.CHERRY_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_BRICK_PATTERN = registerBlockItem("cherry_planks_brick_pattern", ModBlocks.CHERRY_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_BRICK_PAVING = registerBlockItem("cherry_planks_brick_paving", ModBlocks.CHERRY_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_BRICKS = registerBlockItem("cherry_planks_bricks", ModBlocks.CHERRY_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_CRATE = registerBlockItem("cherry_planks_crate", ModBlocks.CHERRY_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_DIAGONAL_STRIPES = registerBlockItem("cherry_planks_diagonal_stripes", ModBlocks.CHERRY_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_DIAGONAL_TILES = registerBlockItem("cherry_planks_diagonal_tiles", ModBlocks.CHERRY_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_DOTTED = registerBlockItem("cherry_planks_dotted", ModBlocks.CHERRY_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_FLOORING = registerBlockItem("cherry_planks_flooring", ModBlocks.CHERRY_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_LARGE_TILES = registerBlockItem("cherry_planks_large_tiles", ModBlocks.CHERRY_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_PANEL =
        registerBlockItem("cherry_planks_panel", ModBlocks.CHERRY_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_PATTERN = registerBlockItem("cherry_planks_pattern", ModBlocks.CHERRY_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_ROTATED_BRICKS = registerBlockItem("cherry_planks_rotated_bricks", ModBlocks.CHERRY_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_SMALL_BRICKS = registerBlockItem("cherry_planks_small_bricks", ModBlocks.CHERRY_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_SMALL_TILES = registerBlockItem("cherry_planks_small_tiles", ModBlocks.CHERRY_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_SQUARES = registerBlockItem("cherry_planks_squares", ModBlocks.CHERRY_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_TILES = registerBlockItem("cherry_planks_tiles", ModBlocks.CHERRY_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_WAVY = registerBlockItem("cherry_planks_wavy", ModBlocks.CHERRY_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> CHERRY_PLANKS_WOVEN = registerBlockItem("cherry_planks_woven", ModBlocks.CHERRY_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> CHERRY_SPRUCE_LEAVES =
        registerBlockItem("cherry_spruce_leaves", ModBlocks.CHERRY_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> CIRCLE_OAK_GLASS = registerBlockItem("circle_oak_glass", ModBlocks.CIRCLE_OAK_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCLE_OAK_GLASS_PANE = registerBlockItem("circle_oak_glass_pane", ModBlocks.CIRCLE_OAK_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLACK_STAINED_GLASS =
        registerBlockItem("circular_black_stained_glass", ModBlocks.CIRCULAR_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLACK_STAINED_GLASS_PANE = registerBlockItem("circular_black_stained_glass_pane", ModBlocks.CIRCULAR_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLACK_TERRACOTTA =
        registerBlockItem("circular_black_terracotta", ModBlocks.CIRCULAR_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLUE_STAINED_GLASS =
        registerBlockItem("circular_blue_stained_glass", ModBlocks.CIRCULAR_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLUE_STAINED_GLASS_PANE = registerBlockItem("circular_blue_stained_glass_pane", ModBlocks.CIRCULAR_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BLUE_TERRACOTTA =
        registerBlockItem("circular_blue_terracotta", ModBlocks.CIRCULAR_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BROWN_STAINED_GLASS =
        registerBlockItem("circular_brown_stained_glass", ModBlocks.CIRCULAR_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BROWN_STAINED_GLASS_PANE = registerBlockItem("circular_brown_stained_glass_pane", ModBlocks.CIRCULAR_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_BROWN_TERRACOTTA =
        registerBlockItem("circular_brown_terracotta", ModBlocks.CIRCULAR_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_CYAN_STAINED_GLASS =
        registerBlockItem("circular_cyan_stained_glass", ModBlocks.CIRCULAR_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_CYAN_STAINED_GLASS_PANE = registerBlockItem("circular_cyan_stained_glass_pane", ModBlocks.CIRCULAR_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_CYAN_TERRACOTTA =
        registerBlockItem("circular_cyan_terracotta", ModBlocks.CIRCULAR_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GRAY_STAINED_GLASS =
        registerBlockItem("circular_gray_stained_glass", ModBlocks.CIRCULAR_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GRAY_STAINED_GLASS_PANE = registerBlockItem("circular_gray_stained_glass_pane", ModBlocks.CIRCULAR_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GRAY_TERRACOTTA =
        registerBlockItem("circular_gray_terracotta", ModBlocks.CIRCULAR_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GREEN_STAINED_GLASS =
        registerBlockItem("circular_green_stained_glass", ModBlocks.CIRCULAR_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GREEN_STAINED_GLASS_PANE = registerBlockItem("circular_green_stained_glass_pane", ModBlocks.CIRCULAR_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_GREEN_TERRACOTTA =
        registerBlockItem("circular_green_terracotta", ModBlocks.CIRCULAR_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("circular_light_blue_terracotta", ModBlocks.CIRCULAR_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("circular_light_gray_terracotta", ModBlocks.CIRCULAR_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_LIME_TERRACOTTA =
        registerBlockItem("circular_lime_terracotta", ModBlocks.CIRCULAR_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_MAGENTA_TERRACOTTA =
        registerBlockItem("circular_magenta_terracotta", ModBlocks.CIRCULAR_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_ORANGE_TERRACOTTA =
        registerBlockItem("circular_orange_terracotta", ModBlocks.CIRCULAR_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PINK_TERRACOTTA =
        registerBlockItem("circular_pink_terracotta", ModBlocks.CIRCULAR_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_PURPLE_TERRACOTTA =
        registerBlockItem("circular_purple_terracotta", ModBlocks.CIRCULAR_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_RED_TERRACOTTA =
        registerBlockItem("circular_red_terracotta", ModBlocks.CIRCULAR_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_TERRACOTTA =
        registerBlockItem("circular_terracotta", ModBlocks.CIRCULAR_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_WHITE_TERRACOTTA =
        registerBlockItem("circular_white_terracotta", ModBlocks.CIRCULAR_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CIRCULAR_YELLOW_TERRACOTTA =
        registerBlockItem("circular_yellow_terracotta", ModBlocks.CIRCULAR_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CLEAR_LEADED_GLASS =
        registerBlockItem("clear_leaded_glass", ModBlocks.CLEAR_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> CLEAR_LEADED_GLASS_CTM =
        registerBlockItem("clear_leaded_glass_ctm", ModBlocks.CLEAR_LEADED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> CLEAR_LEADED_GLASS_CTM_PANE = registerBlockItem("clear_leaded_glass_ctm_pane", ModBlocks.CLEAR_LEADED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CLEAR_LEADED_GLASS_PANE = registerBlockItem("clear_leaded_glass_pane", ModBlocks.CLEAR_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_CARVED = registerBlockItem("coal_block_carved", ModBlocks.COAL_BLOCK_CARVED);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_CHISELED = registerBlockItem("coal_block_chiseled", ModBlocks.COAL_BLOCK_CHISELED);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_CIRCLES = registerBlockItem("coal_block_circles", ModBlocks.COAL_BLOCK_CIRCLES);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_COMPACTED = registerBlockItem("coal_block_compacted", ModBlocks.COAL_BLOCK_COMPACTED);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_OVALS = registerBlockItem("coal_block_ovals", ModBlocks.COAL_BLOCK_OVALS);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_PATTERN = registerBlockItem("coal_block_pattern", ModBlocks.COAL_BLOCK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_ROTATED_BRICKS = registerBlockItem("coal_block_rotated_bricks", ModBlocks.COAL_BLOCK_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_SMALL_TILES = registerBlockItem("coal_block_small_tiles", ModBlocks.COAL_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> COAL_BLOCK_STRIPES = registerBlockItem("coal_block_stripes", ModBlocks.COAL_BLOCK_STRIPES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_BEAMS = registerBlockItem("cobbled_deepslate_beams", ModBlocks.COBBLED_DEEPSLATE_BEAMS);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_BRICK_PATTERN = registerBlockItem("cobbled_deepslate_brick_pattern", ModBlocks.COBBLED_DEEPSLATE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_BRICK_PAVING = registerBlockItem("cobbled_deepslate_brick_paving", ModBlocks.COBBLED_DEEPSLATE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_BRICKS = registerBlockItem("cobbled_deepslate_bricks", ModBlocks.COBBLED_DEEPSLATE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_LARGE_TILES = registerBlockItem("cobbled_deepslate_large_tiles", ModBlocks.COBBLED_DEEPSLATE_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_PAVING = registerBlockItem("cobbled_deepslate_paving", ModBlocks.COBBLED_DEEPSLATE_PAVING);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_PULVERIZED = registerBlockItem("cobbled_deepslate_pulverized", ModBlocks.COBBLED_DEEPSLATE_PULVERIZED);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_ROTATED_BRICKS = registerBlockItem("cobbled_deepslate_rotated_bricks", ModBlocks.COBBLED_DEEPSLATE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_SMALL_TILES = registerBlockItem("cobbled_deepslate_small_tiles", ModBlocks.COBBLED_DEEPSLATE_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_SQUARES = registerBlockItem("cobbled_deepslate_squares", ModBlocks.COBBLED_DEEPSLATE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_STRIPES = registerBlockItem("cobbled_deepslate_stripes", ModBlocks.COBBLED_DEEPSLATE_STRIPES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_TILES = registerBlockItem("cobbled_deepslate_tiles", ModBlocks.COBBLED_DEEPSLATE_TILES);
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_WORN_STRIPES = registerBlockItem("cobbled_deepslate_worn_stripes", ModBlocks.COBBLED_DEEPSLATE_WORN_STRIPES);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_BEAMS = registerBlockItem("cobblestone_beams", ModBlocks.COBBLESTONE_BEAMS);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_BRICK_PATTERN = registerBlockItem("cobblestone_brick_pattern", ModBlocks.COBBLESTONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_BRICK_PAVING = registerBlockItem("cobblestone_brick_paving", ModBlocks.COBBLESTONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_CHISELED_BORDER = registerBlockItem("cobblestone_chiseled_border", ModBlocks.COBBLESTONE_CHISELED_BORDER);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_CROSSES = registerBlockItem("cobblestone_crosses", ModBlocks.COBBLESTONE_CROSSES);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_DENTED = registerBlockItem("cobblestone_dented", ModBlocks.COBBLESTONE_DENTED);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_INVERTED_DENTED = registerBlockItem("cobblestone_inverted_dented", ModBlocks.COBBLESTONE_INVERTED_DENTED);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_PAVING = registerBlockItem("cobblestone_paving", ModBlocks.COBBLESTONE_PAVING);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_PULVERIZED = registerBlockItem("cobblestone_pulverized", ModBlocks.COBBLESTONE_PULVERIZED);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_ROTATED_BRICKS = registerBlockItem("cobblestone_rotated_bricks", ModBlocks.COBBLESTONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_SMALL_TILES = registerBlockItem("cobblestone_small_tiles", ModBlocks.COBBLESTONE_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_SQUARES = registerBlockItem("cobblestone_squares", ModBlocks.COBBLESTONE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_STRIPES = registerBlockItem("cobblestone_stripes", ModBlocks.COBBLESTONE_STRIPES);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_TILES = registerBlockItem("cobblestone_tiles", ModBlocks.COBBLESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_WORN_STRIPES = registerBlockItem("cobblestone_worn_stripes", ModBlocks.COBBLESTONE_WORN_STRIPES);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_BARS = registerBlockItem("copper_block_bars", ModBlocks.COPPER_BLOCK_BARS);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_CIRCLES = registerBlockItem("copper_block_circles", ModBlocks.COPPER_BLOCK_CIRCLES);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_GEARS = registerBlockItem("copper_block_gears", ModBlocks.COPPER_BLOCK_GEARS);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_LINES = registerBlockItem("copper_block_lines", ModBlocks.COPPER_BLOCK_LINES);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_PATTERN = registerBlockItem("copper_block_pattern", ModBlocks.COPPER_BLOCK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_POLISHED = registerBlockItem("copper_block_polished", ModBlocks.COPPER_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_SHAFTS = registerBlockItem("copper_block_shafts", ModBlocks.COPPER_BLOCK_SHAFTS);
    public static final DeferredHolder<Item, BlockItem> COPPER_BLOCK_SMALL_BRICKS = registerBlockItem("copper_block_small_bricks", ModBlocks.COPPER_BLOCK_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CORNERED_ACACIA_PLANKS =
        registerBlockItem("cornered_acacia_planks", ModBlocks.CORNERED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BAMBOO_PLANKS =
        registerBlockItem("cornered_bamboo_planks", ModBlocks.CORNERED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BIRCH_PLANKS =
        registerBlockItem("cornered_birch_planks", ModBlocks.CORNERED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BLACK_WOOL =
        registerBlockItem("cornered_black_wool", ModBlocks.CORNERED_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BLUE_WOOL =
        registerBlockItem("cornered_blue_wool", ModBlocks.CORNERED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_BROWN_WOOL =
        registerBlockItem("cornered_brown_wool", ModBlocks.CORNERED_BROWN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_CYAN_WOOL =
        registerBlockItem("cornered_cyan_wool", ModBlocks.CORNERED_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_GRAY_WOOL =
        registerBlockItem("cornered_gray_wool", ModBlocks.CORNERED_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_GREEN_WOOL =
        registerBlockItem("cornered_green_wool", ModBlocks.CORNERED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_LIGHT_BLUE_WOOL =
        registerBlockItem("cornered_light_blue_wool", ModBlocks.CORNERED_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_LIGHT_GRAY_WOOL =
        registerBlockItem("cornered_light_gray_wool", ModBlocks.CORNERED_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_LIME_WOOL =
        registerBlockItem("cornered_lime_wool", ModBlocks.CORNERED_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_MAGENTA_WOOL =
        registerBlockItem("cornered_magenta_wool", ModBlocks.CORNERED_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_OAK_PLANKS =
        registerBlockItem("cornered_oak_planks", ModBlocks.CORNERED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CORNERED_ORANGE_WOOL =
        registerBlockItem("cornered_orange_wool", ModBlocks.CORNERED_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_PINK_WOOL =
        registerBlockItem("cornered_pink_wool", ModBlocks.CORNERED_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_PURPLE_WOOL =
        registerBlockItem("cornered_purple_wool", ModBlocks.CORNERED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_RED_WOOL =
        registerBlockItem("cornered_red_wool", ModBlocks.CORNERED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_WHITE_WOOL =
        registerBlockItem("cornered_white_wool", ModBlocks.CORNERED_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CORNERED_YELLOW_WOOL =
        registerBlockItem("cornered_yellow_wool", ModBlocks.CORNERED_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_BLACK_WOOL =
        registerBlockItem("crafted_black_wool", ModBlocks.CRAFTED_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_BLUE_WOOL =
        registerBlockItem("crafted_blue_wool", ModBlocks.CRAFTED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_BROWN_WOOL =
        registerBlockItem("crafted_brown_wool", ModBlocks.CRAFTED_BROWN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_CYAN_WOOL =
        registerBlockItem("crafted_cyan_wool", ModBlocks.CRAFTED_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_GRAY_WOOL =
        registerBlockItem("crafted_gray_wool", ModBlocks.CRAFTED_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_GREEN_WOOL =
        registerBlockItem("crafted_green_wool", ModBlocks.CRAFTED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_LIGHT_BLUE_WOOL =
        registerBlockItem("crafted_light_blue_wool", ModBlocks.CRAFTED_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_LIGHT_GRAY_WOOL =
        registerBlockItem("crafted_light_gray_wool", ModBlocks.CRAFTED_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_LIME_WOOL =
        registerBlockItem("crafted_lime_wool", ModBlocks.CRAFTED_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_MAGENTA_WOOL =
        registerBlockItem("crafted_magenta_wool", ModBlocks.CRAFTED_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_ORANGE_WOOL =
        registerBlockItem("crafted_orange_wool", ModBlocks.CRAFTED_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_PINK_WOOL =
        registerBlockItem("crafted_pink_wool", ModBlocks.CRAFTED_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_PURPLE_WOOL =
        registerBlockItem("crafted_purple_wool", ModBlocks.CRAFTED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_RED_WOOL =
        registerBlockItem("crafted_red_wool", ModBlocks.CRAFTED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_WHITE_WOOL =
        registerBlockItem("crafted_white_wool", ModBlocks.CRAFTED_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRAFTED_YELLOW_WOOL =
        registerBlockItem("crafted_yellow_wool", ModBlocks.CRAFTED_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> CRATED_ACACIA_PLANKS =
        registerBlockItem("crated_acacia_planks", ModBlocks.CRATED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_BAMBOO_PLANKS =
        registerBlockItem("crated_bamboo_planks", ModBlocks.CRATED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_BIRCH_PLANKS =
        registerBlockItem("crated_birch_planks", ModBlocks.CRATED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRATED_OAK_PLANKS =
        registerBlockItem("crated_oak_planks", ModBlocks.CRATED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> CRIMSITE_CUT_POLISHED = registerBlockItem("crimsite_cut_polished", ModBlocks.CRIMSITE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> CRIMSITE_CUT_SMALL_BRICK = registerBlockItem("crimsite_cut_small_brick", ModBlocks.CRIMSITE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_BEAMS = registerBlockItem("crimson_planks_beams", ModBlocks.CRIMSON_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_BRICK_PATTERN = registerBlockItem("crimson_planks_brick_pattern", ModBlocks.CRIMSON_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_BRICK_PAVING = registerBlockItem("crimson_planks_brick_paving", ModBlocks.CRIMSON_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_BRICKS = registerBlockItem("crimson_planks_bricks", ModBlocks.CRIMSON_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_CRATE = registerBlockItem("crimson_planks_crate", ModBlocks.CRIMSON_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_DIAGONAL_STRIPES = registerBlockItem("crimson_planks_diagonal_stripes", ModBlocks.CRIMSON_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_DIAGONAL_TILES = registerBlockItem("crimson_planks_diagonal_tiles", ModBlocks.CRIMSON_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_DOTTED = registerBlockItem("crimson_planks_dotted", ModBlocks.CRIMSON_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_FLOORING = registerBlockItem("crimson_planks_flooring", ModBlocks.CRIMSON_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_LARGE_TILES = registerBlockItem("crimson_planks_large_tiles", ModBlocks.CRIMSON_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_PANEL =
        registerBlockItem("crimson_planks_panel", ModBlocks.CRIMSON_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_PATTERN = registerBlockItem("crimson_planks_pattern", ModBlocks.CRIMSON_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_ROTATED_BRICKS = registerBlockItem("crimson_planks_rotated_bricks", ModBlocks.CRIMSON_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_SMALL_BRICKS = registerBlockItem("crimson_planks_small_bricks", ModBlocks.CRIMSON_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_SMALL_TILES = registerBlockItem("crimson_planks_small_tiles", ModBlocks.CRIMSON_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_SQUARES = registerBlockItem("crimson_planks_squares", ModBlocks.CRIMSON_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_TILES = registerBlockItem("crimson_planks_tiles", ModBlocks.CRIMSON_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_WAVY = registerBlockItem("crimson_planks_wavy", ModBlocks.CRIMSON_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_PLANKS_WOVEN = registerBlockItem("crimson_planks_woven", ModBlocks.CRIMSON_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_BARS = registerBlockItem("crimson_window_bars", ModBlocks.CRIMSON_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_BARS_CTM = registerBlockItem("crimson_window_bars_ctm", ModBlocks.CRIMSON_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_COVERED = registerBlockItem("crimson_window_covered", ModBlocks.CRIMSON_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_COVERED_CTM = registerBlockItem("crimson_window_covered_ctm", ModBlocks.CRIMSON_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_DIAGONAL_CTM = registerBlockItem("crimson_window_diagonal_ctm", ModBlocks.CRIMSON_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_DIAGONAL_CTM_PANE = registerBlockItem("crimson_window_diagonal_ctm_pane", ModBlocks.CRIMSON_WINDOW_DIAGONAL_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_LARGE = registerBlockItem("crimson_window_large", ModBlocks.CRIMSON_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_LARGE_CTM = registerBlockItem("crimson_window_large_ctm", ModBlocks.CRIMSON_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_PANES = registerBlockItem("crimson_window_panes", ModBlocks.CRIMSON_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_PANES_CTM = registerBlockItem("crimson_window_panes_ctm", ModBlocks.CRIMSON_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_ROUNDED = registerBlockItem("crimson_window_rounded", ModBlocks.CRIMSON_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_ROUNDED_CTM = registerBlockItem("crimson_window_rounded_ctm", ModBlocks.CRIMSON_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SLIM = registerBlockItem("crimson_window_slim", ModBlocks.CRIMSON_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SLIM_CTM = registerBlockItem("crimson_window_slim_ctm", ModBlocks.CRIMSON_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SWIRLING = registerBlockItem("crimson_window_swirling", ModBlocks.CRIMSON_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_SWIRLING_CTM = registerBlockItem("crimson_window_swirling_ctm", ModBlocks.CRIMSON_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_TILES = registerBlockItem("crimson_window_tiles", ModBlocks.CRIMSON_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> CRIMSON_WINDOW_TILES_CTM = registerBlockItem("crimson_window_tiles_ctm", ModBlocks.CRIMSON_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLED_BLACK_TERRACOTTA =
        registerBlockItem("curled_black_terracotta", ModBlocks.CURLED_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_BLUE_TERRACOTTA =
        registerBlockItem("curled_blue_terracotta", ModBlocks.CURLED_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_BROWN_TERRACOTTA =
        registerBlockItem("curled_brown_terracotta", ModBlocks.CURLED_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_CYAN_TERRACOTTA =
        registerBlockItem("curled_cyan_terracotta", ModBlocks.CURLED_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_GRAY_TERRACOTTA =
        registerBlockItem("curled_gray_terracotta", ModBlocks.CURLED_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_GREEN_TERRACOTTA =
        registerBlockItem("curled_green_terracotta", ModBlocks.CURLED_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("curled_light_blue_terracotta", ModBlocks.CURLED_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("curled_light_gray_terracotta", ModBlocks.CURLED_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_LIME_TERRACOTTA =
        registerBlockItem("curled_lime_terracotta", ModBlocks.CURLED_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_MAGENTA_TERRACOTTA =
        registerBlockItem("curled_magenta_terracotta", ModBlocks.CURLED_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_ORANGE_TERRACOTTA =
        registerBlockItem("curled_orange_terracotta", ModBlocks.CURLED_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_PINK_TERRACOTTA =
        registerBlockItem("curled_pink_terracotta", ModBlocks.CURLED_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_PURPLE_TERRACOTTA =
        registerBlockItem("curled_purple_terracotta", ModBlocks.CURLED_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_RED_TERRACOTTA =
        registerBlockItem("curled_red_terracotta", ModBlocks.CURLED_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_TERRACOTTA =
        registerBlockItem("curled_terracotta", ModBlocks.CURLED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_WHITE_TERRACOTTA =
        registerBlockItem("curled_white_terracotta", ModBlocks.CURLED_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLED_YELLOW_TERRACOTTA =
        registerBlockItem("curled_yellow_terracotta", ModBlocks.CURLED_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> CURLY_AMETHYST_BLOCK_CTM =
        registerBlockItem("curly_amethyst_block_ctm", ModBlocks.CURLY_AMETHYST_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_ANCIENT_DEBRIS_CTM =
        registerBlockItem("curly_ancient_debris_ctm", ModBlocks.CURLY_ANCIENT_DEBRIS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_ANDESITE_CTM =
        registerBlockItem("curly_andesite_ctm", ModBlocks.CURLY_ANDESITE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_BASALT_CTM =
        registerBlockItem("curly_basalt_ctm", ModBlocks.CURLY_BASALT_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_BLACKSTONE_CTM =
        registerBlockItem("curly_blackstone_ctm", ModBlocks.CURLY_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_BLUE_ICE_CTM =
        registerBlockItem("curly_blue_ice_ctm", ModBlocks.CURLY_BLUE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_BORDERLESS_BRICKS_CTM =
        registerBlockItem("curly_borderless_bricks_ctm", ModBlocks.CURLY_BORDERLESS_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_BRICKS_CTM =
        registerBlockItem("curly_bricks_ctm", ModBlocks.CURLY_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_CALCITE_CTM =
        registerBlockItem("curly_calcite_ctm", ModBlocks.CURLY_CALCITE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_CLAY_CTM =
        registerBlockItem("curly_clay_ctm", ModBlocks.CURLY_CLAY_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_COAL_BLOCK_CTM =
        registerBlockItem("curly_coal_block_ctm", ModBlocks.CURLY_COAL_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_COBBLESTONE_CTM =
        registerBlockItem("curly_cobblestone_ctm", ModBlocks.CURLY_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_CRYING_OBSIDIAN_CTM =
        registerBlockItem("curly_crying_obsidian_ctm", ModBlocks.CURLY_CRYING_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_DARK_PRISMARINE_CTM =
        registerBlockItem("curly_dark_prismarine_ctm", ModBlocks.CURLY_DARK_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_DEEPSLATE_CTM =
        registerBlockItem("curly_deepslate_ctm", ModBlocks.CURLY_DEEPSLATE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_DIORITE_CTM =
        registerBlockItem("curly_diorite_ctm", ModBlocks.CURLY_DIORITE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_DIRT_CTM =
        registerBlockItem("curly_dirt_ctm", ModBlocks.CURLY_DIRT_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_DRIPSTONE_BLOCK_CTM =
        registerBlockItem("curly_dripstone_block_ctm", ModBlocks.CURLY_DRIPSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_END_STONE_CTM =
        registerBlockItem("curly_end_stone_ctm", ModBlocks.CURLY_END_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_GILDED_BLACKSTONE_CTM =
        registerBlockItem("curly_gilded_blackstone_ctm", ModBlocks.CURLY_GILDED_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_ICE_CTM =
        registerBlockItem("curly_ice_ctm", ModBlocks.CURLY_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_LAPIS_BLOCK_CTM =
        registerBlockItem("curly_lapis_block_ctm", ModBlocks.CURLY_LAPIS_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_LODESTONE_CTM =
        registerBlockItem("curly_lodestone_ctm", ModBlocks.CURLY_LODESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_MAGMA_BLOCK_CTM =
        registerBlockItem("curly_magma_block_ctm", ModBlocks.CURLY_MAGMA_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_MOSSY_COBBLESTONE_CTM =
        registerBlockItem("curly_mossy_cobblestone_ctm", ModBlocks.CURLY_MOSSY_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_MOSSY_STONE_BRICKS_CTM =
        registerBlockItem("curly_mossy_stone_bricks_ctm", ModBlocks.CURLY_MOSSY_STONE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_MUD_BRICKS_CTM =
        registerBlockItem("curly_mud_bricks_ctm", ModBlocks.CURLY_MUD_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_MUD_CTM =
        registerBlockItem("curly_mud_ctm", ModBlocks.CURLY_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_NETHER_BRICKS_CTM =
        registerBlockItem("curly_nether_bricks_ctm", ModBlocks.CURLY_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_NETHERRACK_CTM =
        registerBlockItem("curly_netherrack_ctm", ModBlocks.CURLY_NETHERRACK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_OBSIDIAN_CTM =
        registerBlockItem("curly_obsidian_ctm", ModBlocks.CURLY_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_PACKED_ICE_CTM =
        registerBlockItem("curly_packed_ice_ctm", ModBlocks.CURLY_PACKED_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_PACKED_MUD_CTM =
        registerBlockItem("curly_packed_mud_ctm", ModBlocks.CURLY_PACKED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_PRISMARINE_CTM =
        registerBlockItem("curly_prismarine_ctm", ModBlocks.CURLY_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_PURPUR_BLOCK_CTM =
        registerBlockItem("curly_purpur_block_ctm", ModBlocks.CURLY_PURPUR_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_QUARTZ_BLOCK_CTM =
        registerBlockItem("curly_quartz_block_ctm", ModBlocks.CURLY_QUARTZ_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_RAW_COPPER_BLOCK_CTM =
        registerBlockItem("curly_raw_copper_block_ctm", ModBlocks.CURLY_RAW_COPPER_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_RAW_GOLD_BLOCK_CTM =
        registerBlockItem("curly_raw_gold_block_ctm", ModBlocks.CURLY_RAW_GOLD_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_RAW_IRON_BLOCK_CTM =
        registerBlockItem("curly_raw_iron_block_ctm", ModBlocks.CURLY_RAW_IRON_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_RED_NETHER_BRICKS_CTM =
        registerBlockItem("curly_red_nether_bricks_ctm", ModBlocks.CURLY_RED_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_RED_SANDSTONE_CTM =
        registerBlockItem("curly_red_sandstone_ctm", ModBlocks.CURLY_RED_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_REDSTONE_BLOCK_CTM =
        registerBlockItem("curly_redstone_block_ctm", ModBlocks.CURLY_REDSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_SANDSTONE_CTM =
        registerBlockItem("curly_sandstone_ctm", ModBlocks.CURLY_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_SMOOTH_STONE_CTM =
        registerBlockItem("curly_smooth_stone_ctm", ModBlocks.CURLY_SMOOTH_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_SNOW_BLOCK_CTM =
        registerBlockItem("curly_snow_block_ctm", ModBlocks.CURLY_SNOW_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> CURLY_TUFF_CTM =
        registerBlockItem("curly_tuff_ctm", ModBlocks.CURLY_TUFF_CTM);
    public static final DeferredHolder<Item, BlockItem> CUT_AMETHYST_BLOCK_COLUMN =
        registerBlockItem("cut_amethyst_block_column", ModBlocks.CUT_AMETHYST_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_ANCIENT_DEBRIS_COLUMN =
        registerBlockItem("cut_ancient_debris_column", ModBlocks.CUT_ANCIENT_DEBRIS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_ANDESITE_COLUMN =
        registerBlockItem("cut_andesite_column", ModBlocks.CUT_ANDESITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_BASALT_COLUMN =
        registerBlockItem("cut_basalt_column", ModBlocks.CUT_BASALT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_BLACKSTONE_COLUMN =
        registerBlockItem("cut_blackstone_column", ModBlocks.CUT_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_BLANK_STONE                   = registerBlockItem("cut_blank_stone",                   ModBlocks.CUT_BLANK_STONE);
    public static final DeferredHolder<Item, BlockItem> CUT_BLUE_ICE_COLUMN =
        registerBlockItem("cut_blue_ice_column", ModBlocks.CUT_BLUE_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_BORDERLESS_BRICKS_COLUMN =
        registerBlockItem("cut_borderless_bricks_column", ModBlocks.CUT_BORDERLESS_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_BRICKS_COLUMN =
        registerBlockItem("cut_bricks_column", ModBlocks.CUT_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_CALCITE_COLUMN =
        registerBlockItem("cut_calcite_column", ModBlocks.CUT_CALCITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_CLAY_COLUMN =
        registerBlockItem("cut_clay_column", ModBlocks.CUT_CLAY_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_COAL_BLOCK_COLUMN =
        registerBlockItem("cut_coal_block_column", ModBlocks.CUT_COAL_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_COBBLESTONE_COLUMN =
        registerBlockItem("cut_cobblestone_column", ModBlocks.CUT_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_CRYING_OBSIDIAN_COLUMN =
        registerBlockItem("cut_crying_obsidian_column", ModBlocks.CUT_CRYING_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_DARK_PRISMARINE_COLUMN =
        registerBlockItem("cut_dark_prismarine_column", ModBlocks.CUT_DARK_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_DEEPSLATE_COLUMN =
        registerBlockItem("cut_deepslate_column", ModBlocks.CUT_DEEPSLATE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_DIORITE_COLUMN =
        registerBlockItem("cut_diorite_column", ModBlocks.CUT_DIORITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_DIRT_COLUMN =
        registerBlockItem("cut_dirt_column", ModBlocks.CUT_DIRT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_DRIPSTONE_BLOCK_COLUMN =
        registerBlockItem("cut_dripstone_block_column", ModBlocks.CUT_DRIPSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_END_STONE_COLUMN =
        registerBlockItem("cut_end_stone_column", ModBlocks.CUT_END_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_GILDED_BLACKSTONE_COLUMN =
        registerBlockItem("cut_gilded_blackstone_column", ModBlocks.CUT_GILDED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_ICE_COLUMN =
        registerBlockItem("cut_ice_column", ModBlocks.CUT_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_LAPIS_BLOCK_COLUMN =
        registerBlockItem("cut_lapis_block_column", ModBlocks.CUT_LAPIS_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_LODESTONE_COLUMN =
        registerBlockItem("cut_lodestone_column", ModBlocks.CUT_LODESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_MAGMA_BLOCK_COLUMN =
        registerBlockItem("cut_magma_block_column", ModBlocks.CUT_MAGMA_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_MOSSY_COBBLESTONE_COLUMN =
        registerBlockItem("cut_mossy_cobblestone_column", ModBlocks.CUT_MOSSY_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_MOSSY_STONE_BRICKS_COLUMN =
        registerBlockItem("cut_mossy_stone_bricks_column", ModBlocks.CUT_MOSSY_STONE_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_NETHER_BRICKS_COLUMN =
        registerBlockItem("cut_nether_bricks_column", ModBlocks.CUT_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_NETHERRACK_COLUMN =
        registerBlockItem("cut_netherrack_column", ModBlocks.CUT_NETHERRACK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_OBSIDIAN_COLUMN =
        registerBlockItem("cut_obsidian_column", ModBlocks.CUT_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_PACKED_ICE_COLUMN =
        registerBlockItem("cut_packed_ice_column", ModBlocks.CUT_PACKED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_PRISMARINE_COLUMN =
        registerBlockItem("cut_prismarine_column", ModBlocks.CUT_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_PURPUR_BLOCK_COLUMN =
        registerBlockItem("cut_purpur_block_column", ModBlocks.CUT_PURPUR_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_QUARTZ_BLOCK_COLUMN =
        registerBlockItem("cut_quartz_block_column", ModBlocks.CUT_QUARTZ_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_RAW_COPPER_BLOCK_COLUMN =
        registerBlockItem("cut_raw_copper_block_column", ModBlocks.CUT_RAW_COPPER_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_RAW_GOLD_BLOCK_COLUMN =
        registerBlockItem("cut_raw_gold_block_column", ModBlocks.CUT_RAW_GOLD_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_RAW_IRON_BLOCK_COLUMN =
        registerBlockItem("cut_raw_iron_block_column", ModBlocks.CUT_RAW_IRON_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_RED_NETHER_BRICKS_COLUMN =
        registerBlockItem("cut_red_nether_bricks_column", ModBlocks.CUT_RED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_RED_SANDSTONE = registerBlockItem("cut_red_sandstone", ModBlocks.CUT_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> CUT_RED_SANDSTONE_COLUMN =
        registerBlockItem("cut_red_sandstone_column", ModBlocks.CUT_RED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_REDSTONE_BLOCK_COLUMN =
        registerBlockItem("cut_redstone_block_column", ModBlocks.CUT_REDSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_SANDSTONE = registerBlockItem("cut_sandstone", ModBlocks.CUT_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> CUT_SANDSTONE_COLUMN =
        registerBlockItem("cut_sandstone_column", ModBlocks.CUT_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_SMOOTH_STONE_COLUMN =
        registerBlockItem("cut_smooth_stone_column", ModBlocks.CUT_SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_SNOW_BLOCK_COLUMN =
        registerBlockItem("cut_snow_block_column", ModBlocks.CUT_SNOW_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CUT_TUFF_COLUMN =
        registerBlockItem("cut_tuff_column", ModBlocks.CUT_TUFF_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CYAN_CONCRETE_CTM =
        registerBlockItem("cyan_concrete_ctm", ModBlocks.CYAN_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> CYAN_CONCRETE_PANEL =
        registerBlockItem("cyan_concrete_panel", ModBlocks.CYAN_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> CYAN_TERRACOTTA_COLUMN =
        registerBlockItem("cyan_terracotta_column", ModBlocks.CYAN_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> CYAN_TERRACOTTA_CTM =
        registerBlockItem("cyan_terracotta_ctm", ModBlocks.CYAN_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_BEAMS = registerBlockItem("dark_oak_planks_beams", ModBlocks.DARK_OAK_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_BRICK_PATTERN = registerBlockItem("dark_oak_planks_brick_pattern", ModBlocks.DARK_OAK_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_BRICK_PAVING = registerBlockItem("dark_oak_planks_brick_paving", ModBlocks.DARK_OAK_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_BRICKS = registerBlockItem("dark_oak_planks_bricks", ModBlocks.DARK_OAK_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_CRATE = registerBlockItem("dark_oak_planks_crate", ModBlocks.DARK_OAK_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_DIAGONAL_STRIPES = registerBlockItem("dark_oak_planks_diagonal_stripes", ModBlocks.DARK_OAK_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_DIAGONAL_TILES = registerBlockItem("dark_oak_planks_diagonal_tiles", ModBlocks.DARK_OAK_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_DOTTED = registerBlockItem("dark_oak_planks_dotted", ModBlocks.DARK_OAK_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_FLOORING = registerBlockItem("dark_oak_planks_flooring", ModBlocks.DARK_OAK_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_LARGE_TILES = registerBlockItem("dark_oak_planks_large_tiles", ModBlocks.DARK_OAK_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_PANEL =
        registerBlockItem("dark_oak_planks_panel", ModBlocks.DARK_OAK_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_PATTERN = registerBlockItem("dark_oak_planks_pattern", ModBlocks.DARK_OAK_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_ROTATED_BRICKS = registerBlockItem("dark_oak_planks_rotated_bricks", ModBlocks.DARK_OAK_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_SMALL_BRICKS = registerBlockItem("dark_oak_planks_small_bricks", ModBlocks.DARK_OAK_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_SMALL_TILES = registerBlockItem("dark_oak_planks_small_tiles", ModBlocks.DARK_OAK_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_SQUARES = registerBlockItem("dark_oak_planks_squares", ModBlocks.DARK_OAK_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_TILES = registerBlockItem("dark_oak_planks_tiles", ModBlocks.DARK_OAK_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_WAVY = registerBlockItem("dark_oak_planks_wavy", ModBlocks.DARK_OAK_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_PLANKS_WOVEN = registerBlockItem("dark_oak_planks_woven", ModBlocks.DARK_OAK_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_BARS = registerBlockItem("dark_oak_window_bars", ModBlocks.DARK_OAK_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_BARS_CTM = registerBlockItem("dark_oak_window_bars_ctm", ModBlocks.DARK_OAK_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_COVERED = registerBlockItem("dark_oak_window_covered", ModBlocks.DARK_OAK_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_COVERED_CTM = registerBlockItem("dark_oak_window_covered_ctm", ModBlocks.DARK_OAK_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_DIAGONAL = registerBlockItem("dark_oak_window_diagonal", ModBlocks.DARK_OAK_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_DIAGONAL_CTM = registerBlockItem("dark_oak_window_diagonal_ctm", ModBlocks.DARK_OAK_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_LARGE_CTM = registerBlockItem("dark_oak_window_large_ctm", ModBlocks.DARK_OAK_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_PANES = registerBlockItem("dark_oak_window_panes", ModBlocks.DARK_OAK_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_PANES_CTM = registerBlockItem("dark_oak_window_panes_ctm", ModBlocks.DARK_OAK_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_ROUNDED = registerBlockItem("dark_oak_window_rounded", ModBlocks.DARK_OAK_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_ROUNDED_CTM = registerBlockItem("dark_oak_window_rounded_ctm", ModBlocks.DARK_OAK_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SLIM = registerBlockItem("dark_oak_window_slim", ModBlocks.DARK_OAK_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SLIM_CTM = registerBlockItem("dark_oak_window_slim_ctm", ModBlocks.DARK_OAK_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SWIRLING = registerBlockItem("dark_oak_window_swirling", ModBlocks.DARK_OAK_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_SWIRLING_CTM = registerBlockItem("dark_oak_window_swirling_ctm", ModBlocks.DARK_OAK_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_TILES = registerBlockItem("dark_oak_window_tiles", ModBlocks.DARK_OAK_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_WINDOW_TILES_CTM = registerBlockItem("dark_oak_window_tiles_ctm", ModBlocks.DARK_OAK_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_BEAMS = registerBlockItem("dark_prismarine_beams", ModBlocks.DARK_PRISMARINE_BEAMS);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_BRICK_PAVING = registerBlockItem("dark_prismarine_brick_paving", ModBlocks.DARK_PRISMARINE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_BRICKS = registerBlockItem("dark_prismarine_bricks", ModBlocks.DARK_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_DOTTED = registerBlockItem("dark_prismarine_dotted", ModBlocks.DARK_PRISMARINE_DOTTED);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_FABRIC = registerBlockItem("dark_prismarine_fabric", ModBlocks.DARK_PRISMARINE_FABRIC);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_LARGE_TILES = registerBlockItem("dark_prismarine_large_tiles", ModBlocks.DARK_PRISMARINE_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_ROTATED_BRICKS = registerBlockItem("dark_prismarine_rotated_bricks", ModBlocks.DARK_PRISMARINE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_ROWS = registerBlockItem("dark_prismarine_rows", ModBlocks.DARK_PRISMARINE_ROWS);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_SQUARES = registerBlockItem("dark_prismarine_squares", ModBlocks.DARK_PRISMARINE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_TILES = registerBlockItem("dark_prismarine_tiles", ModBlocks.DARK_PRISMARINE_TILES);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_WAVY = registerBlockItem("dark_prismarine_wavy", ModBlocks.DARK_PRISMARINE_WAVY);
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_WOVEN = registerBlockItem("dark_prismarine_woven", ModBlocks.DARK_PRISMARINE_WOVEN);
    public static final DeferredHolder<Item, BlockItem> DEAD_ACACIA_LEAVES =
        registerBlockItem("dead_acacia_leaves", ModBlocks.DEAD_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> DEAD_BIRCH_LEAVES =
        registerBlockItem("dead_birch_leaves", ModBlocks.DEAD_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> DEAD_DARK_OAK_LEAVES =
        registerBlockItem("dead_dark_oak_leaves", ModBlocks.DEAD_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> DEAD_JUNGLE_LEAVES =
        registerBlockItem("dead_jungle_leaves", ModBlocks.DEAD_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> DEAD_OAK_LEAVES =
        registerBlockItem("dead_oak_leaves", ModBlocks.DEAD_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> DEAD_SPRUCE_LEAVES =
        registerBlockItem("dead_spruce_leaves", ModBlocks.DEAD_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_CUT_POLISHED = registerBlockItem("deepslate_cut_polished", ModBlocks.DEEPSLATE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_CUT_SMALL_BRICK = registerBlockItem("deepslate_cut_small_brick", ModBlocks.DEEPSLATE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> DELICATE_LAPIS_BLOCK = registerBlockItem("delicate_lapis_block", ModBlocks.DELICATE_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK = registerBlockItem("diamond_block", ModBlocks.DIAMOND_BLOCK);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_CHISELED = registerBlockItem("diamond_block_chiseled", ModBlocks.DIAMOND_BLOCK_CHISELED);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_CHISELED_CUBES = registerBlockItem("diamond_block_chiseled_cubes", ModBlocks.DIAMOND_BLOCK_CHISELED_CUBES);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_CONNECTING = registerBlockItem("diamond_block_connecting", ModBlocks.DIAMOND_BLOCK_CONNECTING);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_GRID = registerBlockItem("diamond_block_grid", ModBlocks.DIAMOND_BLOCK_GRID);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_JEWEL_BLOCK = registerBlockItem("diamond_block_jewel_block", ModBlocks.DIAMOND_BLOCK_JEWEL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_POLISHED = registerBlockItem("diamond_block_polished", ModBlocks.DIAMOND_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_RHOMBUSES = registerBlockItem("diamond_block_rhombuses", ModBlocks.DIAMOND_BLOCK_RHOMBUSES);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_SHINY_BORDERED = registerBlockItem("diamond_block_shiny_bordered", ModBlocks.DIAMOND_BLOCK_SHINY_BORDERED);
    public static final DeferredHolder<Item, BlockItem> DIAMOND_BLOCK_SMALL_TILES = registerBlockItem("diamond_block_small_tiles", ModBlocks.DIAMOND_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> DIORITE_BRICK_PATTERN = registerBlockItem("diorite_brick_pattern", ModBlocks.DIORITE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> DIORITE_BRICK_PAVING = registerBlockItem("diorite_brick_paving", ModBlocks.DIORITE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> DIORITE_BRICKS = registerBlockItem("diorite_bricks", ModBlocks.DIORITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DIORITE_CUT_POLISHED = registerBlockItem("diorite_cut_polished", ModBlocks.DIORITE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> DIORITE_CUT_SMALL_BRICK = registerBlockItem("diorite_cut_small_brick", ModBlocks.DIORITE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> DIORITE_DIAGONAL_BRICKS = registerBlockItem("diorite_diagonal_bricks", ModBlocks.DIORITE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DIORITE_DOTTED = registerBlockItem("diorite_dotted", ModBlocks.DIORITE_DOTTED);
    public static final DeferredHolder<Item, BlockItem> DIORITE_PAVING = registerBlockItem("diorite_paving", ModBlocks.DIORITE_PAVING);
    public static final DeferredHolder<Item, BlockItem> DIORITE_POLISHED = registerBlockItem("diorite_polished", ModBlocks.DIORITE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> DIORITE_ROTATED_BRICKS = registerBlockItem("diorite_rotated_bricks", ModBlocks.DIORITE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DIORITE_SQUARES = registerBlockItem("diorite_squares", ModBlocks.DIORITE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> DIORITE_TILES = registerBlockItem("diorite_tiles", ModBlocks.DIORITE_TILES);
    public static final DeferredHolder<Item, BlockItem> DIORITE_WAVY = registerBlockItem("diorite_wavy", ModBlocks.DIORITE_WAVY);
    public static final DeferredHolder<Item, BlockItem> DIRT_BLOBS = registerBlockItem("dirt_blobs", ModBlocks.DIRT_BLOBS);
    public static final DeferredHolder<Item, BlockItem> DIRT_BRICKS = registerBlockItem("dirt_bricks", ModBlocks.DIRT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DIRT_CHUNKS = registerBlockItem("dirt_chunks", ModBlocks.DIRT_CHUNKS);
    public static final DeferredHolder<Item, BlockItem> DIRT_CLUMPS = registerBlockItem("dirt_clumps", ModBlocks.DIRT_CLUMPS);
    public static final DeferredHolder<Item, BlockItem> DIRT_LARGE_TILES = registerBlockItem("dirt_large_tiles", ModBlocks.DIRT_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> DIRT_SMALL_BRICKS = registerBlockItem("dirt_small_bricks", ModBlocks.DIRT_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> DIRT_SMALL_TILES = registerBlockItem("dirt_small_tiles", ModBlocks.DIRT_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> DIRT_SMOOTH_CLUMPS = registerBlockItem("dirt_smooth_clumps", ModBlocks.DIRT_SMOOTH_CLUMPS);
    public static final DeferredHolder<Item, BlockItem> DIRT_SOIL = registerBlockItem("dirt_soil", ModBlocks.DIRT_SOIL);
    public static final DeferredHolder<Item, BlockItem> DIRT_SQUARES = registerBlockItem("dirt_squares", ModBlocks.DIRT_SQUARES);
    public static final DeferredHolder<Item, BlockItem> DIRT_TILES = registerBlockItem("dirt_tiles", ModBlocks.DIRT_TILES);
    public static final DeferredHolder<Item, BlockItem> DIRT_TILLED = registerBlockItem("dirt_tilled", ModBlocks.DIRT_TILLED);
    public static final DeferredHolder<Item, BlockItem> DRIPSTONE_CUT_POLISHED = registerBlockItem("dripstone_cut_polished", ModBlocks.DRIPSTONE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> DRIPSTONE_CUT_SMALL_BRICK = registerBlockItem("dripstone_cut_small_brick", ModBlocks.DRIPSTONE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> EDGED_AMETHYST_BLOCK_BRICKS =
        registerBlockItem("edged_amethyst_block_bricks", ModBlocks.EDGED_AMETHYST_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_ANCIENT_DEBRIS_BRICKS =
        registerBlockItem("edged_ancient_debris_bricks", ModBlocks.EDGED_ANCIENT_DEBRIS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_ANDESITE_BRICKS =
        registerBlockItem("edged_andesite_bricks", ModBlocks.EDGED_ANDESITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_BASALT_BRICKS =
        registerBlockItem("edged_basalt_bricks", ModBlocks.EDGED_BASALT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_BLACKSTONE_BRICKS =
        registerBlockItem("edged_blackstone_bricks", ModBlocks.EDGED_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_BLUE_ICE_BRICKS =
        registerBlockItem("edged_blue_ice_bricks", ModBlocks.EDGED_BLUE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_BORDERLESS_BRICKS_BRICKS =
        registerBlockItem("edged_borderless_bricks_bricks", ModBlocks.EDGED_BORDERLESS_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_BRICKS_BRICKS =
        registerBlockItem("edged_bricks_bricks", ModBlocks.EDGED_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_CALCITE_BRICKS =
        registerBlockItem("edged_calcite_bricks", ModBlocks.EDGED_CALCITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_CLAY_BRICKS =
        registerBlockItem("edged_clay_bricks", ModBlocks.EDGED_CLAY_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_COAL_BLOCK_BRICKS =
        registerBlockItem("edged_coal_block_bricks", ModBlocks.EDGED_COAL_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_COBBLESTONE_BRICKS =
        registerBlockItem("edged_cobblestone_bricks", ModBlocks.EDGED_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_CRYING_OBSIDIAN_BRICKS =
        registerBlockItem("edged_crying_obsidian_bricks", ModBlocks.EDGED_CRYING_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_DARK_PRISMARINE_BRICKS =
        registerBlockItem("edged_dark_prismarine_bricks", ModBlocks.EDGED_DARK_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_DEEPSLATE_BRICKS =
        registerBlockItem("edged_deepslate_bricks", ModBlocks.EDGED_DEEPSLATE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_DIORITE_BRICKS =
        registerBlockItem("edged_diorite_bricks", ModBlocks.EDGED_DIORITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_DIRT_BRICKS =
        registerBlockItem("edged_dirt_bricks", ModBlocks.EDGED_DIRT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_DRIPSTONE_BLOCK_BRICKS =
        registerBlockItem("edged_dripstone_block_bricks", ModBlocks.EDGED_DRIPSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_END_STONE_BRICKS =
        registerBlockItem("edged_end_stone_bricks", ModBlocks.EDGED_END_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_GILDED_BLACKSTONE_BRICKS =
        registerBlockItem("edged_gilded_blackstone_bricks", ModBlocks.EDGED_GILDED_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_ICE_BRICKS =
        registerBlockItem("edged_ice_bricks", ModBlocks.EDGED_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_LAPIS_BLOCK_BRICKS =
        registerBlockItem("edged_lapis_block_bricks", ModBlocks.EDGED_LAPIS_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_LODESTONE_BRICKS =
        registerBlockItem("edged_lodestone_bricks", ModBlocks.EDGED_LODESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_MAGMA_BLOCK_BRICKS =
        registerBlockItem("edged_magma_block_bricks", ModBlocks.EDGED_MAGMA_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_MOSSY_COBBLESTONE_BRICKS =
        registerBlockItem("edged_mossy_cobblestone_bricks", ModBlocks.EDGED_MOSSY_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_MOSSY_STONE_BRICKS_BRICKS =
        registerBlockItem("edged_mossy_stone_bricks_bricks", ModBlocks.EDGED_MOSSY_STONE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_MUD =
        registerBlockItem("edged_mud", ModBlocks.EDGED_MUD);
    public static final DeferredHolder<Item, BlockItem> EDGED_MUD_BRICKS_BRICKS =
        registerBlockItem("edged_mud_bricks_bricks", ModBlocks.EDGED_MUD_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_NETHER_BRICKS_BRICKS =
        registerBlockItem("edged_nether_bricks_bricks", ModBlocks.EDGED_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_NETHERRACK_BRICKS =
        registerBlockItem("edged_netherrack_bricks", ModBlocks.EDGED_NETHERRACK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_OBSIDIAN_BRICKS =
        registerBlockItem("edged_obsidian_bricks", ModBlocks.EDGED_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_PACKED_ICE_BRICKS =
        registerBlockItem("edged_packed_ice_bricks", ModBlocks.EDGED_PACKED_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_PACKED_MUD_BRICKS =
        registerBlockItem("edged_packed_mud_bricks", ModBlocks.EDGED_PACKED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_PRISMARINE_BRICKS =
        registerBlockItem("edged_prismarine_bricks", ModBlocks.EDGED_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_PURPUR_BLOCK_BRICKS =
        registerBlockItem("edged_purpur_block_bricks", ModBlocks.EDGED_PURPUR_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_QUARTZ_BLOCK_BRICKS =
        registerBlockItem("edged_quartz_block_bricks", ModBlocks.EDGED_QUARTZ_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_RAW_COPPER_BLOCK_BRICKS =
        registerBlockItem("edged_raw_copper_block_bricks", ModBlocks.EDGED_RAW_COPPER_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_RAW_GOLD_BLOCK_BRICKS =
        registerBlockItem("edged_raw_gold_block_bricks", ModBlocks.EDGED_RAW_GOLD_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_RAW_IRON_BLOCK_BRICKS =
        registerBlockItem("edged_raw_iron_block_bricks", ModBlocks.EDGED_RAW_IRON_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_RED_NETHER_BRICKS_BRICKS =
        registerBlockItem("edged_red_nether_bricks_bricks", ModBlocks.EDGED_RED_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_RED_SANDSTONE_BRICKS =
        registerBlockItem("edged_red_sandstone_bricks", ModBlocks.EDGED_RED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_REDSTONE_BLOCK_BRICKS =
        registerBlockItem("edged_redstone_block_bricks", ModBlocks.EDGED_REDSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_SANDSTONE_BRICKS =
        registerBlockItem("edged_sandstone_bricks", ModBlocks.EDGED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_SMOOTH_STONE_BRICKS =
        registerBlockItem("edged_smooth_stone_bricks", ModBlocks.EDGED_SMOOTH_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_SNOW_BLOCK_BRICKS =
        registerBlockItem("edged_snow_block_bricks", ModBlocks.EDGED_SNOW_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EDGED_TUFF_BRICKS =
        registerBlockItem("edged_tuff_bricks", ModBlocks.EDGED_TUFF_BRICKS);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_BORDERED_CROSSES = registerBlockItem("emerald_block_bordered_crosses", ModBlocks.EMERALD_BLOCK_BORDERED_CROSSES);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_BORDERED_PLATING = registerBlockItem("emerald_block_bordered_plating", ModBlocks.EMERALD_BLOCK_BORDERED_PLATING);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_CHISELED = registerBlockItem("emerald_block_chiseled", ModBlocks.EMERALD_BLOCK_CHISELED);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_CLOVERS = registerBlockItem("emerald_block_clovers", ModBlocks.EMERALD_BLOCK_CLOVERS);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_CRYSTAL = registerBlockItem("emerald_block_crystal", ModBlocks.EMERALD_BLOCK_CRYSTAL);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_CTM = registerBlockItem("emerald_block_ctm", ModBlocks.EMERALD_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_PATTERNED = registerBlockItem("emerald_block_patterned", ModBlocks.EMERALD_BLOCK_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_PATTERNED_SQUARES = registerBlockItem("emerald_block_patterned_squares", ModBlocks.EMERALD_BLOCK_PATTERNED_SQUARES);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_POLISHED = registerBlockItem("emerald_block_polished", ModBlocks.EMERALD_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_STRIPED = registerBlockItem("emerald_block_striped", ModBlocks.EMERALD_BLOCK_STRIPED);
    public static final DeferredHolder<Item, BlockItem> EMERALD_BLOCK_WAXED = registerBlockItem("emerald_block_waxed", ModBlocks.EMERALD_BLOCK_WAXED);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_ACACIA_PLANKS =
        registerBlockItem("enclosed_acacia_planks", ModBlocks.ENCLOSED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_BAMBOO_PLANKS =
        registerBlockItem("enclosed_bamboo_planks", ModBlocks.ENCLOSED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_BIRCH_PLANKS =
        registerBlockItem("enclosed_birch_planks", ModBlocks.ENCLOSED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> ENCLOSED_OAK_PLANKS =
        registerBlockItem("enclosed_oak_planks", ModBlocks.ENCLOSED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> END_STONE_BLOBS = registerBlockItem("end_stone_blobs", ModBlocks.END_STONE_BLOBS);
    public static final DeferredHolder<Item, BlockItem> END_STONE_BRICK_PATTERN = registerBlockItem("end_stone_brick_pattern", ModBlocks.END_STONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> END_STONE_BRICK_PAVING = registerBlockItem("end_stone_brick_paving", ModBlocks.END_STONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> END_STONE_CHISELED = registerBlockItem("end_stone_chiseled", ModBlocks.END_STONE_CHISELED);
    public static final DeferredHolder<Item, BlockItem> END_STONE_CRUSHED = registerBlockItem("end_stone_crushed", ModBlocks.END_STONE_CRUSHED);
    public static final DeferredHolder<Item, BlockItem> END_STONE_DIAGONAL_BRICKS = registerBlockItem("end_stone_diagonal_bricks", ModBlocks.END_STONE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> END_STONE_MESH = registerBlockItem("end_stone_mesh", ModBlocks.END_STONE_MESH);
    public static final DeferredHolder<Item, BlockItem> END_STONE_PAVING = registerBlockItem("end_stone_paving", ModBlocks.END_STONE_PAVING);
    public static final DeferredHolder<Item, BlockItem> END_STONE_POLISHED = registerBlockItem("end_stone_polished", ModBlocks.END_STONE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> END_STONE_ROTATED_BRICKS = registerBlockItem("end_stone_rotated_bricks", ModBlocks.END_STONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> END_STONE_SCALES = registerBlockItem("end_stone_scales", ModBlocks.END_STONE_SCALES);
    public static final DeferredHolder<Item, BlockItem> END_STONE_SMALL_TILES = registerBlockItem("end_stone_small_tiles", ModBlocks.END_STONE_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> END_STONE_SPIRAL_PATTERN = registerBlockItem("end_stone_spiral_pattern", ModBlocks.END_STONE_SPIRAL_PATTERN);
    public static final DeferredHolder<Item, BlockItem> END_STONE_SQUARES = registerBlockItem("end_stone_squares", ModBlocks.END_STONE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> END_STONE_TILES = registerBlockItem("end_stone_tiles", ModBlocks.END_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLACK_STAINED_GLASS =
        registerBlockItem("fancy_black_stained_glass", ModBlocks.FANCY_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLACK_STAINED_GLASS_CTM =
        registerBlockItem("fancy_black_stained_glass_ctm", ModBlocks.FANCY_BLACK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_black_stained_glass_ctm_pane", ModBlocks.FANCY_BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLACK_STAINED_GLASS_PANE = registerBlockItem("fancy_black_stained_glass_pane", ModBlocks.FANCY_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLUE_STAINED_GLASS =
        registerBlockItem("fancy_blue_stained_glass", ModBlocks.FANCY_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("fancy_blue_stained_glass_ctm", ModBlocks.FANCY_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_blue_stained_glass_ctm_pane", ModBlocks.FANCY_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_BLUE_STAINED_GLASS_PANE = registerBlockItem("fancy_blue_stained_glass_pane", ModBlocks.FANCY_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_BROWN_STAINED_GLASS =
        registerBlockItem("fancy_brown_stained_glass", ModBlocks.FANCY_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_BROWN_STAINED_GLASS_CTM =
        registerBlockItem("fancy_brown_stained_glass_ctm", ModBlocks.FANCY_BROWN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_brown_stained_glass_ctm_pane", ModBlocks.FANCY_BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_BROWN_STAINED_GLASS_PANE = registerBlockItem("fancy_brown_stained_glass_pane", ModBlocks.FANCY_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_CYAN_STAINED_GLASS =
        registerBlockItem("fancy_cyan_stained_glass", ModBlocks.FANCY_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_CYAN_STAINED_GLASS_CTM =
        registerBlockItem("fancy_cyan_stained_glass_ctm", ModBlocks.FANCY_CYAN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_cyan_stained_glass_ctm_pane", ModBlocks.FANCY_CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_CYAN_STAINED_GLASS_PANE = registerBlockItem("fancy_cyan_stained_glass_pane", ModBlocks.FANCY_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_GRAY_STAINED_GLASS =
        registerBlockItem("fancy_gray_stained_glass", ModBlocks.FANCY_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("fancy_gray_stained_glass_ctm", ModBlocks.FANCY_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_gray_stained_glass_ctm_pane", ModBlocks.FANCY_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_GRAY_STAINED_GLASS_PANE = registerBlockItem("fancy_gray_stained_glass_pane", ModBlocks.FANCY_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_GREEN_STAINED_GLASS =
        registerBlockItem("fancy_green_stained_glass", ModBlocks.FANCY_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_GREEN_STAINED_GLASS_CTM =
        registerBlockItem("fancy_green_stained_glass_ctm", ModBlocks.FANCY_GREEN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("fancy_green_stained_glass_ctm_pane", ModBlocks.FANCY_GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_GREEN_STAINED_GLASS_PANE = registerBlockItem("fancy_green_stained_glass_pane", ModBlocks.FANCY_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LEADED_GLASS =
        registerBlockItem("fancy_leaded_glass", ModBlocks.FANCY_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> FANCY_LEADED_GLASS_CTM =
        registerBlockItem("fancy_leaded_glass_ctm", ModBlocks.FANCY_LEADED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_LEADED_GLASS_CTM_PANE = registerBlockItem("fancy_leaded_glass_ctm_pane", ModBlocks.FANCY_LEADED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_LEADED_GLASS_PANE = registerBlockItem("fancy_leaded_glass_pane", ModBlocks.FANCY_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> FANCY_MUD_BRICKS_CTM =
        registerBlockItem("fancy_mud_bricks_ctm", ModBlocks.FANCY_MUD_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_MUD_CTM =
        registerBlockItem("fancy_mud_ctm", ModBlocks.FANCY_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> FANCY_PACKED_MUD_CTM =
        registerBlockItem("fancy_packed_mud_ctm", ModBlocks.FANCY_PACKED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_AMETHYST_BLOCK_CTM =
        registerBlockItem("fine_amethyst_block_ctm", ModBlocks.FINE_AMETHYST_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_ANCIENT_DEBRIS_CTM =
        registerBlockItem("fine_ancient_debris_ctm", ModBlocks.FINE_ANCIENT_DEBRIS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_ANDESITE_CTM =
        registerBlockItem("fine_andesite_ctm", ModBlocks.FINE_ANDESITE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_BASALT_CTM =
        registerBlockItem("fine_basalt_ctm", ModBlocks.FINE_BASALT_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_BLACKSTONE_CTM =
        registerBlockItem("fine_blackstone_ctm", ModBlocks.FINE_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_BLUE_ICE_CTM =
        registerBlockItem("fine_blue_ice_ctm", ModBlocks.FINE_BLUE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_BORDERLESS_BRICKS_CTM =
        registerBlockItem("fine_borderless_bricks_ctm", ModBlocks.FINE_BORDERLESS_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_BRICKS_CTM =
        registerBlockItem("fine_bricks_ctm", ModBlocks.FINE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_CALCITE_CTM =
        registerBlockItem("fine_calcite_ctm", ModBlocks.FINE_CALCITE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_CLAY_CTM =
        registerBlockItem("fine_clay_ctm", ModBlocks.FINE_CLAY_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_COAL_BLOCK_CTM =
        registerBlockItem("fine_coal_block_ctm", ModBlocks.FINE_COAL_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_COBBLESTONE_CTM =
        registerBlockItem("fine_cobblestone_ctm", ModBlocks.FINE_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_CRYING_OBSIDIAN_CTM =
        registerBlockItem("fine_crying_obsidian_ctm", ModBlocks.FINE_CRYING_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_DARK_PRISMARINE_CTM =
        registerBlockItem("fine_dark_prismarine_ctm", ModBlocks.FINE_DARK_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_DEEPSLATE_CTM =
        registerBlockItem("fine_deepslate_ctm", ModBlocks.FINE_DEEPSLATE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_DIORITE_CTM =
        registerBlockItem("fine_diorite_ctm", ModBlocks.FINE_DIORITE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_DIRT_CTM =
        registerBlockItem("fine_dirt_ctm", ModBlocks.FINE_DIRT_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_DRIPSTONE_BLOCK_CTM =
        registerBlockItem("fine_dripstone_block_ctm", ModBlocks.FINE_DRIPSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_END_STONE_CTM =
        registerBlockItem("fine_end_stone_ctm", ModBlocks.FINE_END_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_GILDED_BLACKSTONE_CTM =
        registerBlockItem("fine_gilded_blackstone_ctm", ModBlocks.FINE_GILDED_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_ICE_CTM =
        registerBlockItem("fine_ice_ctm", ModBlocks.FINE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_LAPIS_BLOCK_CTM =
        registerBlockItem("fine_lapis_block_ctm", ModBlocks.FINE_LAPIS_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_LODESTONE_CTM =
        registerBlockItem("fine_lodestone_ctm", ModBlocks.FINE_LODESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_MAGMA_BLOCK_CTM =
        registerBlockItem("fine_magma_block_ctm", ModBlocks.FINE_MAGMA_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_MOSSY_COBBLESTONE_CTM =
        registerBlockItem("fine_mossy_cobblestone_ctm", ModBlocks.FINE_MOSSY_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_MOSSY_STONE_BRICKS_CTM =
        registerBlockItem("fine_mossy_stone_bricks_ctm", ModBlocks.FINE_MOSSY_STONE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_MUD_BRICKS_CTM =
        registerBlockItem("fine_mud_bricks_ctm", ModBlocks.FINE_MUD_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_MUD_CTM =
        registerBlockItem("fine_mud_ctm", ModBlocks.FINE_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_NETHER_BRICKS_CTM =
        registerBlockItem("fine_nether_bricks_ctm", ModBlocks.FINE_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_NETHERRACK_CTM =
        registerBlockItem("fine_netherrack_ctm", ModBlocks.FINE_NETHERRACK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_OBSIDIAN_CTM =
        registerBlockItem("fine_obsidian_ctm", ModBlocks.FINE_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_PACKED_ICE_CTM =
        registerBlockItem("fine_packed_ice_ctm", ModBlocks.FINE_PACKED_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_PACKED_MUD_CTM =
        registerBlockItem("fine_packed_mud_ctm", ModBlocks.FINE_PACKED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_PRISMARINE_CTM =
        registerBlockItem("fine_prismarine_ctm", ModBlocks.FINE_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_PURPUR_BLOCK_CTM =
        registerBlockItem("fine_purpur_block_ctm", ModBlocks.FINE_PURPUR_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_QUARTZ_BLOCK_CTM =
        registerBlockItem("fine_quartz_block_ctm", ModBlocks.FINE_QUARTZ_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_RAW_COPPER_BLOCK_CTM =
        registerBlockItem("fine_raw_copper_block_ctm", ModBlocks.FINE_RAW_COPPER_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_RAW_GOLD_BLOCK_CTM =
        registerBlockItem("fine_raw_gold_block_ctm", ModBlocks.FINE_RAW_GOLD_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_RAW_IRON_BLOCK_CTM =
        registerBlockItem("fine_raw_iron_block_ctm", ModBlocks.FINE_RAW_IRON_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_RED_NETHER_BRICKS_CTM =
        registerBlockItem("fine_red_nether_bricks_ctm", ModBlocks.FINE_RED_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_RED_SANDSTONE_CTM =
        registerBlockItem("fine_red_sandstone_ctm", ModBlocks.FINE_RED_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_REDSTONE_BLOCK_CTM =
        registerBlockItem("fine_redstone_block_ctm", ModBlocks.FINE_REDSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_SANDSTONE_CTM =
        registerBlockItem("fine_sandstone_ctm", ModBlocks.FINE_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_SMOOTH_STONE_CTM =
        registerBlockItem("fine_smooth_stone_ctm", ModBlocks.FINE_SMOOTH_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_SNOW_BLOCK_CTM =
        registerBlockItem("fine_snow_block_ctm", ModBlocks.FINE_SNOW_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> FINE_TUFF_CTM =
        registerBlockItem("fine_tuff_ctm", ModBlocks.FINE_TUFF_CTM);
    public static final DeferredHolder<Item, BlockItem> FRAMED_ACACIA_PLANKS =
        registerBlockItem("framed_acacia_planks", ModBlocks.FRAMED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_BAMBOO_PLANKS =
        registerBlockItem("framed_bamboo_planks", ModBlocks.FRAMED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_BIRCH_PLANKS =
        registerBlockItem("framed_birch_planks", ModBlocks.FRAMED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FRAMED_OAK_PLANKS =
        registerBlockItem("framed_oak_planks", ModBlocks.FRAMED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> FROSTED_ACACIA_LEAVES =
        registerBlockItem("frosted_acacia_leaves", ModBlocks.FROSTED_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> FROSTED_BIRCH_LEAVES =
        registerBlockItem("frosted_birch_leaves", ModBlocks.FROSTED_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> FROSTED_DARK_OAK_LEAVES =
        registerBlockItem("frosted_dark_oak_leaves", ModBlocks.FROSTED_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> FROSTED_JUNGLE_LEAVES =
        registerBlockItem("frosted_jungle_leaves", ModBlocks.FROSTED_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> FROSTED_OAK_LEAVES =
        registerBlockItem("frosted_oak_leaves", ModBlocks.FROSTED_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> FROSTED_SPRUCE_LEAVES =
        registerBlockItem("frosted_spruce_leaves", ModBlocks.FROSTED_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_BRICK_PATTERN = registerBlockItem("glowstone_brick_pattern", ModBlocks.GLOWSTONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_BRICK_PAVING = registerBlockItem("glowstone_brick_paving", ModBlocks.GLOWSTONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_BRICKS = registerBlockItem("glowstone_bricks", ModBlocks.GLOWSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_CRUSHED = registerBlockItem("glowstone_crushed", ModBlocks.GLOWSTONE_CRUSHED);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_LARGE_TILES = registerBlockItem("glowstone_large_tiles", ModBlocks.GLOWSTONE_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_ROTATED_BRICKS = registerBlockItem("glowstone_rotated_bricks", ModBlocks.GLOWSTONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_SMALL_TILES = registerBlockItem("glowstone_small_tiles", ModBlocks.GLOWSTONE_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_SMOOTH = registerBlockItem("glowstone_smooth", ModBlocks.GLOWSTONE_SMOOTH);
    public static final DeferredHolder<Item, BlockItem> GLOWSTONE_TILES = registerBlockItem("glowstone_tiles", ModBlocks.GLOWSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK = registerBlockItem("gold_block", ModBlocks.GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_BEAMS = registerBlockItem("gold_block_beams", ModBlocks.GOLD_BLOCK_BEAMS);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_BORDERED = registerBlockItem("gold_block_bordered", ModBlocks.GOLD_BLOCK_BORDERED);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_LINES = registerBlockItem("gold_block_lines", ModBlocks.GOLD_BLOCK_LINES);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_PATTERN = registerBlockItem("gold_block_pattern", ModBlocks.GOLD_BLOCK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_POLISHED = registerBlockItem("gold_block_polished", ModBlocks.GOLD_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_SCALES = registerBlockItem("gold_block_scales", ModBlocks.GOLD_BLOCK_SCALES);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_SMALL_BRICKS = registerBlockItem("gold_block_small_bricks", ModBlocks.GOLD_BLOCK_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_SMALL_TILES = registerBlockItem("gold_block_small_tiles", ModBlocks.GOLD_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_STRIPED = registerBlockItem("gold_block_striped", ModBlocks.GOLD_BLOCK_STRIPED);
    public static final DeferredHolder<Item, BlockItem> GOLD_BLOCK_TILES = registerBlockItem("gold_block_tiles", ModBlocks.GOLD_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_ACACIA_LEAVES =
        registerBlockItem("golden_acacia_leaves", ModBlocks.GOLDEN_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_APPLE_ACACIA_LEAVES =
        registerBlockItem("golden_apple_acacia_leaves", ModBlocks.GOLDEN_APPLE_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_APPLE_BIRCH_LEAVES =
        registerBlockItem("golden_apple_birch_leaves", ModBlocks.GOLDEN_APPLE_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_APPLE_DARK_OAK_LEAVES =
        registerBlockItem("golden_apple_dark_oak_leaves", ModBlocks.GOLDEN_APPLE_DARK_OAK_LEAVES);


    // ===== RECOVERED WAVE3 =====
    public static final DeferredHolder<Item, BlockItem> GOLDEN_APPLE_JUNGLE_LEAVES =
        registerBlockItem("golden_apple_jungle_leaves", ModBlocks.GOLDEN_APPLE_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_APPLE_OAK_LEAVES =
        registerBlockItem("golden_apple_oak_leaves", ModBlocks.GOLDEN_APPLE_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_APPLE_SPRUCE_LEAVES =
        registerBlockItem("golden_apple_spruce_leaves", ModBlocks.GOLDEN_APPLE_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_BIRCH_LEAVES =
        registerBlockItem("golden_birch_leaves", ModBlocks.GOLDEN_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_CHERRY_ACACIA_LEAVES =
        registerBlockItem("golden_cherry_acacia_leaves", ModBlocks.GOLDEN_CHERRY_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_CHERRY_BIRCH_LEAVES =
        registerBlockItem("golden_cherry_birch_leaves", ModBlocks.GOLDEN_CHERRY_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_CHERRY_DARK_OAK_LEAVES =
        registerBlockItem("golden_cherry_dark_oak_leaves", ModBlocks.GOLDEN_CHERRY_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_CHERRY_JUNGLE_LEAVES =
        registerBlockItem("golden_cherry_jungle_leaves", ModBlocks.GOLDEN_CHERRY_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_CHERRY_OAK_LEAVES =
        registerBlockItem("golden_cherry_oak_leaves", ModBlocks.GOLDEN_CHERRY_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_CHERRY_SPRUCE_LEAVES =
        registerBlockItem("golden_cherry_spruce_leaves", ModBlocks.GOLDEN_CHERRY_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_DARK_OAK_LEAVES =
        registerBlockItem("golden_dark_oak_leaves", ModBlocks.GOLDEN_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_JUNGLE_LEAVES =
        registerBlockItem("golden_jungle_leaves", ModBlocks.GOLDEN_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_OAK_LEAVES =
        registerBlockItem("golden_oak_leaves", ModBlocks.GOLDEN_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GOLDEN_SPRUCE_LEAVES =
        registerBlockItem("golden_spruce_leaves", ModBlocks.GOLDEN_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> GRAY_CONCRETE_CTM =
        registerBlockItem("gray_concrete_ctm", ModBlocks.GRAY_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> GRAY_CONCRETE_PANEL =
        registerBlockItem("gray_concrete_panel", ModBlocks.GRAY_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> GRAY_TERRACOTTA_COLUMN =
        registerBlockItem("gray_terracotta_column", ModBlocks.GRAY_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> GRAY_TERRACOTTA_CTM =
        registerBlockItem("gray_terracotta_ctm", ModBlocks.GRAY_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> GREEN_CONCRETE_CTM =
        registerBlockItem("green_concrete_ctm", ModBlocks.GREEN_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> GREEN_CONCRETE_PANEL =
        registerBlockItem("green_concrete_panel", ModBlocks.GREEN_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> GREEN_TERRACOTTA_COLUMN =
        registerBlockItem("green_terracotta_column", ModBlocks.GREEN_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> GREEN_TERRACOTTA_CTM =
        registerBlockItem("green_terracotta_ctm", ModBlocks.GREEN_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> GRILL_BLACK_CONCRETE =
        registerBlockItem("grill_black_concrete", ModBlocks.GRILL_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_BLUE_CONCRETE =
        registerBlockItem("grill_blue_concrete", ModBlocks.GRILL_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_BROWN_CONCRETE =
        registerBlockItem("grill_brown_concrete", ModBlocks.GRILL_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_CYAN_CONCRETE =
        registerBlockItem("grill_cyan_concrete", ModBlocks.GRILL_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_GRAY_CONCRETE =
        registerBlockItem("grill_gray_concrete", ModBlocks.GRILL_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_GREEN_CONCRETE =
        registerBlockItem("grill_green_concrete", ModBlocks.GRILL_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_LIGHT_BLUE_CONCRETE =
        registerBlockItem("grill_light_blue_concrete", ModBlocks.GRILL_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_LIGHT_GRAY_CONCRETE =
        registerBlockItem("grill_light_gray_concrete", ModBlocks.GRILL_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_LIME_CONCRETE =
        registerBlockItem("grill_lime_concrete", ModBlocks.GRILL_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_MAGENTA_CONCRETE =
        registerBlockItem("grill_magenta_concrete", ModBlocks.GRILL_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_ORANGE_CONCRETE =
        registerBlockItem("grill_orange_concrete", ModBlocks.GRILL_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_PINK_CONCRETE =
        registerBlockItem("grill_pink_concrete", ModBlocks.GRILL_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_PURPLE_CONCRETE =
        registerBlockItem("grill_purple_concrete", ModBlocks.GRILL_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_RED_CONCRETE =
        registerBlockItem("grill_red_concrete", ModBlocks.GRILL_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_WHITE_CONCRETE =
        registerBlockItem("grill_white_concrete", ModBlocks.GRILL_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> GRILL_YELLOW_CONCRETE =
        registerBlockItem("grill_yellow_concrete", ModBlocks.GRILL_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> HARD_MUD =
        registerBlockItem("hard_mud", ModBlocks.HARD_MUD);
    public static final DeferredHolder<Item, BlockItem> HARD_MUD_BRICKS =
        registerBlockItem("hard_mud_bricks", ModBlocks.HARD_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> HARD_PACKED_MUD =
        registerBlockItem("hard_packed_mud", ModBlocks.HARD_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_BLACK_WOOL =
        registerBlockItem("harsh_quilted_black_wool", ModBlocks.HARSH_QUILTED_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_BLUE_WOOL =
        registerBlockItem("harsh_quilted_blue_wool", ModBlocks.HARSH_QUILTED_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_BROWN_WOOL =
        registerBlockItem("harsh_quilted_brown_wool", ModBlocks.HARSH_QUILTED_BROWN_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_CYAN_WOOL =
        registerBlockItem("harsh_quilted_cyan_wool", ModBlocks.HARSH_QUILTED_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_GRAY_WOOL =
        registerBlockItem("harsh_quilted_gray_wool", ModBlocks.HARSH_QUILTED_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_GREEN_WOOL =
        registerBlockItem("harsh_quilted_green_wool", ModBlocks.HARSH_QUILTED_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_LIGHT_BLUE_WOOL =
        registerBlockItem("harsh_quilted_light_blue_wool", ModBlocks.HARSH_QUILTED_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_LIGHT_GRAY_WOOL =
        registerBlockItem("harsh_quilted_light_gray_wool", ModBlocks.HARSH_QUILTED_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_LIME_WOOL =
        registerBlockItem("harsh_quilted_lime_wool", ModBlocks.HARSH_QUILTED_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_MAGENTA_WOOL =
        registerBlockItem("harsh_quilted_magenta_wool", ModBlocks.HARSH_QUILTED_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_ORANGE_WOOL =
        registerBlockItem("harsh_quilted_orange_wool", ModBlocks.HARSH_QUILTED_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_PINK_WOOL =
        registerBlockItem("harsh_quilted_pink_wool", ModBlocks.HARSH_QUILTED_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_PURPLE_WOOL =
        registerBlockItem("harsh_quilted_purple_wool", ModBlocks.HARSH_QUILTED_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_RED_WOOL =
        registerBlockItem("harsh_quilted_red_wool", ModBlocks.HARSH_QUILTED_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_WHITE_WOOL =
        registerBlockItem("harsh_quilted_white_wool", ModBlocks.HARSH_QUILTED_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> HARSH_QUILTED_YELLOW_WOOL =
        registerBlockItem("harsh_quilted_yellow_wool", ModBlocks.HARSH_QUILTED_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_BLACK_TERRACOTTA =
        registerBlockItem("hexagonical_black_terracotta", ModBlocks.HEXAGONICAL_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_BLUE_TERRACOTTA =
        registerBlockItem("hexagonical_blue_terracotta", ModBlocks.HEXAGONICAL_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_BROWN_TERRACOTTA =
        registerBlockItem("hexagonical_brown_terracotta", ModBlocks.HEXAGONICAL_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_CYAN_TERRACOTTA =
        registerBlockItem("hexagonical_cyan_terracotta", ModBlocks.HEXAGONICAL_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_GRAY_TERRACOTTA =
        registerBlockItem("hexagonical_gray_terracotta", ModBlocks.HEXAGONICAL_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_GREEN_TERRACOTTA =
        registerBlockItem("hexagonical_green_terracotta", ModBlocks.HEXAGONICAL_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("hexagonical_light_blue_terracotta", ModBlocks.HEXAGONICAL_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("hexagonical_light_gray_terracotta", ModBlocks.HEXAGONICAL_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_LIME_TERRACOTTA =
        registerBlockItem("hexagonical_lime_terracotta", ModBlocks.HEXAGONICAL_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_MAGENTA_TERRACOTTA =
        registerBlockItem("hexagonical_magenta_terracotta", ModBlocks.HEXAGONICAL_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_ORANGE_TERRACOTTA =
        registerBlockItem("hexagonical_orange_terracotta", ModBlocks.HEXAGONICAL_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_PINK_TERRACOTTA =
        registerBlockItem("hexagonical_pink_terracotta", ModBlocks.HEXAGONICAL_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_PURPLE_TERRACOTTA =
        registerBlockItem("hexagonical_purple_terracotta", ModBlocks.HEXAGONICAL_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_RED_TERRACOTTA =
        registerBlockItem("hexagonical_red_terracotta", ModBlocks.HEXAGONICAL_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_TERRACOTTA =
        registerBlockItem("hexagonical_terracotta", ModBlocks.HEXAGONICAL_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_WHITE_TERRACOTTA =
        registerBlockItem("hexagonical_white_terracotta", ModBlocks.HEXAGONICAL_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> HEXAGONICAL_YELLOW_TERRACOTTA =
        registerBlockItem("hexagonical_yellow_terracotta", ModBlocks.HEXAGONICAL_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_BLACK_TERRACOTTA =
        registerBlockItem("inscribed_black_terracotta", ModBlocks.INSCRIBED_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_BLUE_TERRACOTTA =
        registerBlockItem("inscribed_blue_terracotta", ModBlocks.INSCRIBED_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_BROWN_TERRACOTTA =
        registerBlockItem("inscribed_brown_terracotta", ModBlocks.INSCRIBED_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_CYAN_TERRACOTTA =
        registerBlockItem("inscribed_cyan_terracotta", ModBlocks.INSCRIBED_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_GRAY_TERRACOTTA =
        registerBlockItem("inscribed_gray_terracotta", ModBlocks.INSCRIBED_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_GREEN_TERRACOTTA =
        registerBlockItem("inscribed_green_terracotta", ModBlocks.INSCRIBED_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("inscribed_light_blue_terracotta", ModBlocks.INSCRIBED_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("inscribed_light_gray_terracotta", ModBlocks.INSCRIBED_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_LIME_TERRACOTTA =
        registerBlockItem("inscribed_lime_terracotta", ModBlocks.INSCRIBED_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_MAGENTA_TERRACOTTA =
        registerBlockItem("inscribed_magenta_terracotta", ModBlocks.INSCRIBED_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_ORANGE_TERRACOTTA =
        registerBlockItem("inscribed_orange_terracotta", ModBlocks.INSCRIBED_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_PINK_TERRACOTTA =
        registerBlockItem("inscribed_pink_terracotta", ModBlocks.INSCRIBED_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_PURPLE_TERRACOTTA =
        registerBlockItem("inscribed_purple_terracotta", ModBlocks.INSCRIBED_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_RED_TERRACOTTA =
        registerBlockItem("inscribed_red_terracotta", ModBlocks.INSCRIBED_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_TERRACOTTA =
        registerBlockItem("inscribed_terracotta", ModBlocks.INSCRIBED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_WHITE_TERRACOTTA =
        registerBlockItem("inscribed_white_terracotta", ModBlocks.INSCRIBED_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> INSCRIBED_YELLOW_TERRACOTTA =
        registerBlockItem("inscribed_yellow_terracotta", ModBlocks.INSCRIBED_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK = registerBlockItem("iron_block", ModBlocks.IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_BORDERED = registerBlockItem("iron_block_bordered", ModBlocks.IRON_BLOCK_BORDERED);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_CHISELED = registerBlockItem("iron_block_chiseled", ModBlocks.IRON_BLOCK_CHISELED);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_CONNECTING = registerBlockItem("iron_block_connecting", ModBlocks.IRON_BLOCK_CONNECTING);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_FRAMED = registerBlockItem("iron_block_framed", ModBlocks.IRON_BLOCK_FRAMED);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_GEARS = registerBlockItem("iron_block_gears", ModBlocks.IRON_BLOCK_GEARS);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_LINES = registerBlockItem("iron_block_lines", ModBlocks.IRON_BLOCK_LINES);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_PATTERNED = registerBlockItem("iron_block_patterned", ModBlocks.IRON_BLOCK_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_PIPES = registerBlockItem("iron_block_pipes", ModBlocks.IRON_BLOCK_PIPES);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_POLISHED = registerBlockItem("iron_block_polished", ModBlocks.IRON_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_PROCESSED = registerBlockItem("iron_block_processed", ModBlocks.IRON_BLOCK_PROCESSED);
    public static final DeferredHolder<Item, BlockItem> IRON_BLOCK_SMALL_BRICKS = registerBlockItem("iron_block_small_bricks", ModBlocks.IRON_BLOCK_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_BEAMS = registerBlockItem("jungle_planks_beams", ModBlocks.JUNGLE_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_BRICK_PATTERN = registerBlockItem("jungle_planks_brick_pattern", ModBlocks.JUNGLE_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_BRICK_PAVING = registerBlockItem("jungle_planks_brick_paving", ModBlocks.JUNGLE_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_BRICKS = registerBlockItem("jungle_planks_bricks", ModBlocks.JUNGLE_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_CRATE = registerBlockItem("jungle_planks_crate", ModBlocks.JUNGLE_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_DIAGONAL_STRIPES = registerBlockItem("jungle_planks_diagonal_stripes", ModBlocks.JUNGLE_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_DIAGONAL_TILES = registerBlockItem("jungle_planks_diagonal_tiles", ModBlocks.JUNGLE_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_DOTTED = registerBlockItem("jungle_planks_dotted", ModBlocks.JUNGLE_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_FLOORING = registerBlockItem("jungle_planks_flooring", ModBlocks.JUNGLE_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_LARGE_TILES = registerBlockItem("jungle_planks_large_tiles", ModBlocks.JUNGLE_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_PATTERN = registerBlockItem("jungle_planks_pattern", ModBlocks.JUNGLE_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_ROTATED_BRICKS = registerBlockItem("jungle_planks_rotated_bricks", ModBlocks.JUNGLE_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_SMALL_BRICKS = registerBlockItem("jungle_planks_small_bricks", ModBlocks.JUNGLE_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_SMALL_TILES = registerBlockItem("jungle_planks_small_tiles", ModBlocks.JUNGLE_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_SQUARES = registerBlockItem("jungle_planks_squares", ModBlocks.JUNGLE_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_TILES = registerBlockItem("jungle_planks_tiles", ModBlocks.JUNGLE_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_WAVY = registerBlockItem("jungle_planks_wavy", ModBlocks.JUNGLE_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_PLANKS_WOVEN = registerBlockItem("jungle_planks_woven", ModBlocks.JUNGLE_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_BARS = registerBlockItem("jungle_window_bars", ModBlocks.JUNGLE_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_BARS_CTM = registerBlockItem("jungle_window_bars_ctm", ModBlocks.JUNGLE_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_COVERED = registerBlockItem("jungle_window_covered", ModBlocks.JUNGLE_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_COVERED_CTM = registerBlockItem("jungle_window_covered_ctm", ModBlocks.JUNGLE_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_DIAGONAL = registerBlockItem("jungle_window_diagonal", ModBlocks.JUNGLE_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_DIAGONAL_CTM = registerBlockItem("jungle_window_diagonal_ctm", ModBlocks.JUNGLE_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_LARGE = registerBlockItem("jungle_window_large", ModBlocks.JUNGLE_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_LARGE_CTM = registerBlockItem("jungle_window_large_ctm", ModBlocks.JUNGLE_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_PANES = registerBlockItem("jungle_window_panes", ModBlocks.JUNGLE_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_PANES_CTM = registerBlockItem("jungle_window_panes_ctm", ModBlocks.JUNGLE_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_ROUNDED = registerBlockItem("jungle_window_rounded", ModBlocks.JUNGLE_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_ROUNDED_CTM = registerBlockItem("jungle_window_rounded_ctm", ModBlocks.JUNGLE_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SLIM_CTM = registerBlockItem("jungle_window_slim_ctm", ModBlocks.JUNGLE_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SLIM_CTM_PANE = registerBlockItem("jungle_window_slim_ctm_pane", ModBlocks.JUNGLE_WINDOW_SLIM_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SWIRLING = registerBlockItem("jungle_window_swirling", ModBlocks.JUNGLE_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_SWIRLING_CTM = registerBlockItem("jungle_window_swirling_ctm", ModBlocks.JUNGLE_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_TILES = registerBlockItem("jungle_window_tiles", ModBlocks.JUNGLE_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_WINDOW_TILES_CTM = registerBlockItem("jungle_window_tiles_ctm", ModBlocks.JUNGLE_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK = registerBlockItem("lapis_block", ModBlocks.LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_BORDERED = registerBlockItem("lapis_block_bordered", ModBlocks.LAPIS_BLOCK_BORDERED);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_CONNECTING = registerBlockItem("lapis_block_connecting", ModBlocks.LAPIS_BLOCK_CONNECTING);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_DECORATED = registerBlockItem("lapis_block_decorated", ModBlocks.LAPIS_BLOCK_DECORATED);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_GLOSSY = registerBlockItem("lapis_block_glossy", ModBlocks.LAPIS_BLOCK_GLOSSY);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_INVERTED_TILES = registerBlockItem("lapis_block_inverted_tiles", ModBlocks.LAPIS_BLOCK_INVERTED_TILES);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_MOSAIC = registerBlockItem("lapis_block_mosaic", ModBlocks.LAPIS_BLOCK_MOSAIC);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_PATTERN = registerBlockItem("lapis_block_pattern", ModBlocks.LAPIS_BLOCK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_POLISHED = registerBlockItem("lapis_block_polished", ModBlocks.LAPIS_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_SCALES = registerBlockItem("lapis_block_scales", ModBlocks.LAPIS_BLOCK_SCALES);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_SMALL_TILES = registerBlockItem("lapis_block_small_tiles", ModBlocks.LAPIS_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_STRIPES = registerBlockItem("lapis_block_stripes", ModBlocks.LAPIS_BLOCK_STRIPES);
    public static final DeferredHolder<Item, BlockItem> LAPIS_BLOCK_TILES = registerBlockItem("lapis_block_tiles", ModBlocks.LAPIS_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_BLACK_STAINED_GLASS =
        registerBlockItem("large_diamond_black_stained_glass", ModBlocks.LARGE_DIAMOND_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_BLACK_STAINED_GLASS_PANE = registerBlockItem("large_diamond_black_stained_glass_pane", ModBlocks.LARGE_DIAMOND_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_BLUE_STAINED_GLASS =
        registerBlockItem("large_diamond_blue_stained_glass", ModBlocks.LARGE_DIAMOND_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_BLUE_STAINED_GLASS_PANE = registerBlockItem("large_diamond_blue_stained_glass_pane", ModBlocks.LARGE_DIAMOND_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_BROWN_STAINED_GLASS =
        registerBlockItem("large_diamond_brown_stained_glass", ModBlocks.LARGE_DIAMOND_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_BROWN_STAINED_GLASS_PANE = registerBlockItem("large_diamond_brown_stained_glass_pane", ModBlocks.LARGE_DIAMOND_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_CYAN_STAINED_GLASS =
        registerBlockItem("large_diamond_cyan_stained_glass", ModBlocks.LARGE_DIAMOND_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_CYAN_STAINED_GLASS_PANE = registerBlockItem("large_diamond_cyan_stained_glass_pane", ModBlocks.LARGE_DIAMOND_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_GRAY_STAINED_GLASS =
        registerBlockItem("large_diamond_gray_stained_glass", ModBlocks.LARGE_DIAMOND_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_GRAY_STAINED_GLASS_PANE = registerBlockItem("large_diamond_gray_stained_glass_pane", ModBlocks.LARGE_DIAMOND_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_GREEN_STAINED_GLASS =
        registerBlockItem("large_diamond_green_stained_glass", ModBlocks.LARGE_DIAMOND_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_GREEN_STAINED_GLASS_PANE = registerBlockItem("large_diamond_green_stained_glass_pane", ModBlocks.LARGE_DIAMOND_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LEADED_GLASS =
        registerBlockItem("large_diamond_leaded_glass", ModBlocks.LARGE_DIAMOND_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> LARGE_DIAMOND_LEADED_GLASS_PANE = registerBlockItem("large_diamond_leaded_glass_pane", ModBlocks.LARGE_DIAMOND_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LARGE_MUD_BRICKS_SIGIL =
        registerBlockItem("large_mud_bricks_sigil", ModBlocks.LARGE_MUD_BRICKS_SIGIL);
    public static final DeferredHolder<Item, BlockItem> LARGE_MUD_SIGIL =
        registerBlockItem("large_mud_sigil", ModBlocks.LARGE_MUD_SIGIL);
    public static final DeferredHolder<Item, BlockItem> LARGE_PACKED_MUD_SIGIL =
        registerBlockItem("large_packed_mud_sigil", ModBlocks.LARGE_PACKED_MUD_SIGIL);
    public static final DeferredHolder<Item, BlockItem> LEAD_WOVEN_GLASS =
        registerBlockItem("lead_woven_glass", ModBlocks.LEAD_WOVEN_GLASS);
    public static final DeferredHolder<Item, BlockItem> LEAD_WOVEN_GLASS_PANE = registerBlockItem("lead_woven_glass_pane", ModBlocks.LEAD_WOVEN_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_CONCRETE_CTM =
        registerBlockItem("light_blue_concrete_ctm", ModBlocks.LIGHT_BLUE_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_CONCRETE_PANEL =
        registerBlockItem("light_blue_concrete_panel", ModBlocks.LIGHT_BLUE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_TERRACOTTA_COLUMN =
        registerBlockItem("light_blue_terracotta_column", ModBlocks.LIGHT_BLUE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_TERRACOTTA_CTM =
        registerBlockItem("light_blue_terracotta_ctm", ModBlocks.LIGHT_BLUE_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_CONCRETE_CTM =
        registerBlockItem("light_gray_concrete_ctm", ModBlocks.LIGHT_GRAY_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_CONCRETE_PANEL =
        registerBlockItem("light_gray_concrete_panel", ModBlocks.LIGHT_GRAY_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_TERRACOTTA_COLUMN =
        registerBlockItem("light_gray_terracotta_column", ModBlocks.LIGHT_GRAY_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_TERRACOTTA_CTM =
        registerBlockItem("light_gray_terracotta_ctm", ModBlocks.LIGHT_GRAY_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> LIME_CONCRETE_CTM =
        registerBlockItem("lime_concrete_ctm", ModBlocks.LIME_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> LIME_CONCRETE_PANEL =
        registerBlockItem("lime_concrete_panel", ModBlocks.LIME_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> LIME_TERRACOTTA_COLUMN =
        registerBlockItem("lime_terracotta_column", ModBlocks.LIME_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> LIME_TERRACOTTA_CTM =
        registerBlockItem("lime_terracotta_ctm", ModBlocks.LIME_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_CUT_POLISHED = registerBlockItem("limestone_cut_polished", ModBlocks.LIMESTONE_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> LIMESTONE_CUT_SMALL_BRICK = registerBlockItem("limestone_cut_small_brick", ModBlocks.LIMESTONE_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> LOREFUL_MUD =
        registerBlockItem("loreful_mud", ModBlocks.LOREFUL_MUD);
    public static final DeferredHolder<Item, BlockItem> LOREFUL_MUD_BRICKS =
        registerBlockItem("loreful_mud_bricks", ModBlocks.LOREFUL_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> LOREFUL_PACKED_MUD =
        registerBlockItem("loreful_packed_mud", ModBlocks.LOREFUL_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_CONCRETE_CTM =
        registerBlockItem("magenta_concrete_ctm", ModBlocks.MAGENTA_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_CONCRETE_PANEL =
        registerBlockItem("magenta_concrete_panel", ModBlocks.MAGENTA_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FLOWER_ACACIA_LEAVES =
        registerBlockItem("magenta_flower_acacia_leaves", ModBlocks.MAGENTA_FLOWER_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FLOWER_BIRCH_LEAVES =
        registerBlockItem("magenta_flower_birch_leaves", ModBlocks.MAGENTA_FLOWER_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FLOWER_DARK_OAK_LEAVES =
        registerBlockItem("magenta_flower_dark_oak_leaves", ModBlocks.MAGENTA_FLOWER_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FLOWER_JUNGLE_LEAVES =
        registerBlockItem("magenta_flower_jungle_leaves", ModBlocks.MAGENTA_FLOWER_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FLOWER_OAK_LEAVES =
        registerBlockItem("magenta_flower_oak_leaves", ModBlocks.MAGENTA_FLOWER_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_FLOWER_SPRUCE_LEAVES =
        registerBlockItem("magenta_flower_spruce_leaves", ModBlocks.MAGENTA_FLOWER_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_TERRACOTTA_COLUMN =
        registerBlockItem("magenta_terracotta_column", ModBlocks.MAGENTA_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_TERRACOTTA_CTM =
        registerBlockItem("magenta_terracotta_ctm", ModBlocks.MAGENTA_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_BEAMS = registerBlockItem("mangrove_planks_beams", ModBlocks.MANGROVE_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_BRICK_PATTERN = registerBlockItem("mangrove_planks_brick_pattern", ModBlocks.MANGROVE_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_BRICK_PAVING = registerBlockItem("mangrove_planks_brick_paving", ModBlocks.MANGROVE_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_BRICKS = registerBlockItem("mangrove_planks_bricks", ModBlocks.MANGROVE_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_CRATE = registerBlockItem("mangrove_planks_crate", ModBlocks.MANGROVE_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_DIAGONAL_STRIPES = registerBlockItem("mangrove_planks_diagonal_stripes", ModBlocks.MANGROVE_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_DIAGONAL_TILES = registerBlockItem("mangrove_planks_diagonal_tiles", ModBlocks.MANGROVE_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_DOTTED = registerBlockItem("mangrove_planks_dotted", ModBlocks.MANGROVE_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_FLOORING = registerBlockItem("mangrove_planks_flooring", ModBlocks.MANGROVE_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_LARGE_TILES = registerBlockItem("mangrove_planks_large_tiles", ModBlocks.MANGROVE_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_PANEL =
        registerBlockItem("mangrove_planks_panel", ModBlocks.MANGROVE_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_PATTERN = registerBlockItem("mangrove_planks_pattern", ModBlocks.MANGROVE_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_ROTATED_BRICKS = registerBlockItem("mangrove_planks_rotated_bricks", ModBlocks.MANGROVE_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_SMALL_BRICKS = registerBlockItem("mangrove_planks_small_bricks", ModBlocks.MANGROVE_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_SMALL_TILES = registerBlockItem("mangrove_planks_small_tiles", ModBlocks.MANGROVE_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_SQUARES = registerBlockItem("mangrove_planks_squares", ModBlocks.MANGROVE_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_TILES = registerBlockItem("mangrove_planks_tiles", ModBlocks.MANGROVE_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_WAVY = registerBlockItem("mangrove_planks_wavy", ModBlocks.MANGROVE_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_PLANKS_WOVEN = registerBlockItem("mangrove_planks_woven", ModBlocks.MANGROVE_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_BARS = registerBlockItem("mangrove_window_bars", ModBlocks.MANGROVE_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_BARS_CTM = registerBlockItem("mangrove_window_bars_ctm", ModBlocks.MANGROVE_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_COVERED = registerBlockItem("mangrove_window_covered", ModBlocks.MANGROVE_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_COVERED_CTM = registerBlockItem("mangrove_window_covered_ctm", ModBlocks.MANGROVE_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_DIAGONAL = registerBlockItem("mangrove_window_diagonal", ModBlocks.MANGROVE_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_DIAGONAL_CTM = registerBlockItem("mangrove_window_diagonal_ctm", ModBlocks.MANGROVE_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_LARGE = registerBlockItem("mangrove_window_large", ModBlocks.MANGROVE_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_LARGE_CTM = registerBlockItem("mangrove_window_large_ctm", ModBlocks.MANGROVE_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_PANES = registerBlockItem("mangrove_window_panes", ModBlocks.MANGROVE_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_PANES_CTM = registerBlockItem("mangrove_window_panes_ctm", ModBlocks.MANGROVE_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_ROUNDED_CTM = registerBlockItem("mangrove_window_rounded_ctm", ModBlocks.MANGROVE_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_ROUNDED_CTM_PANE = registerBlockItem("mangrove_window_rounded_ctm_pane", ModBlocks.MANGROVE_WINDOW_ROUNDED_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SLIM = registerBlockItem("mangrove_window_slim", ModBlocks.MANGROVE_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SLIM_CTM = registerBlockItem("mangrove_window_slim_ctm", ModBlocks.MANGROVE_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SWIRLING = registerBlockItem("mangrove_window_swirling", ModBlocks.MANGROVE_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_SWIRLING_CTM = registerBlockItem("mangrove_window_swirling_ctm", ModBlocks.MANGROVE_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_TILES = registerBlockItem("mangrove_window_tiles", ModBlocks.MANGROVE_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_WINDOW_TILES_CTM = registerBlockItem("mangrove_window_tiles_ctm", ModBlocks.MANGROVE_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_AMETHYST_BLOCK_BRICKS =
        registerBlockItem("massive_amethyst_block_bricks", ModBlocks.MASSIVE_AMETHYST_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_ANCIENT_DEBRIS_BRICKS =
        registerBlockItem("massive_ancient_debris_bricks", ModBlocks.MASSIVE_ANCIENT_DEBRIS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_ANDESITE_BRICKS =
        registerBlockItem("massive_andesite_bricks", ModBlocks.MASSIVE_ANDESITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BASALT_BRICKS =
        registerBlockItem("massive_basalt_bricks", ModBlocks.MASSIVE_BASALT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BLACKSTONE_BRICKS =
        registerBlockItem("massive_blackstone_bricks", ModBlocks.MASSIVE_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BLUE_ICE_BRICKS =
        registerBlockItem("massive_blue_ice_bricks", ModBlocks.MASSIVE_BLUE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BORDERLESS_BRICKS_BRICKS =
        registerBlockItem("massive_borderless_bricks_bricks", ModBlocks.MASSIVE_BORDERLESS_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_BRICKS_BRICKS =
        registerBlockItem("massive_bricks_bricks", ModBlocks.MASSIVE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_CALCITE_BRICKS =
        registerBlockItem("massive_calcite_bricks", ModBlocks.MASSIVE_CALCITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_CLAY_BRICKS =
        registerBlockItem("massive_clay_bricks", ModBlocks.MASSIVE_CLAY_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_COAL_BLOCK_BRICKS =
        registerBlockItem("massive_coal_block_bricks", ModBlocks.MASSIVE_COAL_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_COBBLESTONE_BRICKS =
        registerBlockItem("massive_cobblestone_bricks", ModBlocks.MASSIVE_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_CRYING_OBSIDIAN_BRICKS =
        registerBlockItem("massive_crying_obsidian_bricks", ModBlocks.MASSIVE_CRYING_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DARK_PRISMARINE_BRICKS =
        registerBlockItem("massive_dark_prismarine_bricks", ModBlocks.MASSIVE_DARK_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DEEPSLATE_BRICKS =
        registerBlockItem("massive_deepslate_bricks", ModBlocks.MASSIVE_DEEPSLATE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DIORITE_BRICKS =
        registerBlockItem("massive_diorite_bricks", ModBlocks.MASSIVE_DIORITE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DIRT_BRICKS =
        registerBlockItem("massive_dirt_bricks", ModBlocks.MASSIVE_DIRT_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_DRIPSTONE_BLOCK_BRICKS =
        registerBlockItem("massive_dripstone_block_bricks", ModBlocks.MASSIVE_DRIPSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_END_STONE_BRICKS =
        registerBlockItem("massive_end_stone_bricks", ModBlocks.MASSIVE_END_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_GILDED_BLACKSTONE_BRICKS =
        registerBlockItem("massive_gilded_blackstone_bricks", ModBlocks.MASSIVE_GILDED_BLACKSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_ICE_BRICKS =
        registerBlockItem("massive_ice_bricks", ModBlocks.MASSIVE_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_LAPIS_BLOCK_BRICKS =
        registerBlockItem("massive_lapis_block_bricks", ModBlocks.MASSIVE_LAPIS_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_LODESTONE_BRICKS =
        registerBlockItem("massive_lodestone_bricks", ModBlocks.MASSIVE_LODESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MAGMA_BLOCK_BRICKS =
        registerBlockItem("massive_magma_block_bricks", ModBlocks.MASSIVE_MAGMA_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MOSSY_COBBLESTONE_BRICKS =
        registerBlockItem("massive_mossy_cobblestone_bricks", ModBlocks.MASSIVE_MOSSY_COBBLESTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MOSSY_STONE_BRICKS_BRICKS =
        registerBlockItem("massive_mossy_stone_bricks_bricks", ModBlocks.MASSIVE_MOSSY_STONE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MUD_BRICKS =
        registerBlockItem("massive_mud_bricks", ModBlocks.MASSIVE_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_MUD_BRICKS_BRICKS =
        registerBlockItem("massive_mud_bricks_bricks", ModBlocks.MASSIVE_MUD_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_NETHER_BRICKS_BRICKS =
        registerBlockItem("massive_nether_bricks_bricks", ModBlocks.MASSIVE_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_NETHERRACK_BRICKS =
        registerBlockItem("massive_netherrack_bricks", ModBlocks.MASSIVE_NETHERRACK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_OBSIDIAN_BRICKS =
        registerBlockItem("massive_obsidian_bricks", ModBlocks.MASSIVE_OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PACKED_ICE_BRICKS =
        registerBlockItem("massive_packed_ice_bricks", ModBlocks.MASSIVE_PACKED_ICE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PACKED_MUD_BRICKS =
        registerBlockItem("massive_packed_mud_bricks", ModBlocks.MASSIVE_PACKED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PRISMARINE_BRICKS =
        registerBlockItem("massive_prismarine_bricks", ModBlocks.MASSIVE_PRISMARINE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_PURPUR_BLOCK_BRICKS =
        registerBlockItem("massive_purpur_block_bricks", ModBlocks.MASSIVE_PURPUR_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_QUARTZ_BLOCK_BRICKS =
        registerBlockItem("massive_quartz_block_bricks", ModBlocks.MASSIVE_QUARTZ_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RAW_COPPER_BLOCK_BRICKS =
        registerBlockItem("massive_raw_copper_block_bricks", ModBlocks.MASSIVE_RAW_COPPER_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RAW_GOLD_BLOCK_BRICKS =
        registerBlockItem("massive_raw_gold_block_bricks", ModBlocks.MASSIVE_RAW_GOLD_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RAW_IRON_BLOCK_BRICKS =
        registerBlockItem("massive_raw_iron_block_bricks", ModBlocks.MASSIVE_RAW_IRON_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RED_NETHER_BRICKS_BRICKS =
        registerBlockItem("massive_red_nether_bricks_bricks", ModBlocks.MASSIVE_RED_NETHER_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_RED_SANDSTONE_BRICKS =
        registerBlockItem("massive_red_sandstone_bricks", ModBlocks.MASSIVE_RED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_REDSTONE_BLOCK_BRICKS =
        registerBlockItem("massive_redstone_block_bricks", ModBlocks.MASSIVE_REDSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_SANDSTONE_BRICKS =
        registerBlockItem("massive_sandstone_bricks", ModBlocks.MASSIVE_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_SMOOTH_STONE_BRICKS =
        registerBlockItem("massive_smooth_stone_bricks", ModBlocks.MASSIVE_SMOOTH_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_SNOW_BLOCK_BRICKS =
        registerBlockItem("massive_snow_block_bricks", ModBlocks.MASSIVE_SNOW_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MASSIVE_TUFF_BRICKS =
        registerBlockItem("massive_tuff_bricks", ModBlocks.MASSIVE_TUFF_BRICKS);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_BEAMS = registerBlockItem("mossy_cobblestone_beams", ModBlocks.MOSSY_COBBLESTONE_BEAMS);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_DENTED = registerBlockItem("mossy_cobblestone_dented", ModBlocks.MOSSY_COBBLESTONE_DENTED);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_INVERTED_DENTED = registerBlockItem("mossy_cobblestone_inverted_dented", ModBlocks.MOSSY_COBBLESTONE_INVERTED_DENTED);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_PAVING = registerBlockItem("mossy_cobblestone_paving", ModBlocks.MOSSY_COBBLESTONE_PAVING);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_SMALL_TILES = registerBlockItem("mossy_cobblestone_small_tiles", ModBlocks.MOSSY_COBBLESTONE_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_SQUARES = registerBlockItem("mossy_cobblestone_squares", ModBlocks.MOSSY_COBBLESTONE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_STRIPES = registerBlockItem("mossy_cobblestone_stripes", ModBlocks.MOSSY_COBBLESTONE_STRIPES);
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_WORN_STRIPES = registerBlockItem("mossy_cobblestone_worn_stripes", ModBlocks.MOSSY_COBBLESTONE_WORN_STRIPES);
    public static final DeferredHolder<Item, BlockItem> NATURAL_ACACIA_PLANKS =
        registerBlockItem("natural_acacia_planks", ModBlocks.NATURAL_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_BAMBOO_PLANKS =
        registerBlockItem("natural_bamboo_planks", ModBlocks.NATURAL_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_BIRCH_PLANKS =
        registerBlockItem("natural_birch_planks", ModBlocks.NATURAL_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NATURAL_OAK_PLANKS =
        registerBlockItem("natural_oak_planks", ModBlocks.NATURAL_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_BEAMS = registerBlockItem("nether_bricks_beams", ModBlocks.NETHER_BRICKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_BRICK_PATTERN = registerBlockItem("nether_bricks_brick_pattern", ModBlocks.NETHER_BRICKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_BRICK_PAVING = registerBlockItem("nether_bricks_brick_paving", ModBlocks.NETHER_BRICKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_CHISELED_SQUARES = registerBlockItem("nether_bricks_chiseled_squares", ModBlocks.NETHER_BRICKS_CHISELED_SQUARES);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_DIAGONAL_BRICKS = registerBlockItem("nether_bricks_diagonal_bricks", ModBlocks.NETHER_BRICKS_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_LARGE_BRICKS = registerBlockItem("nether_bricks_large_bricks", ModBlocks.NETHER_BRICKS_LARGE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_LARGE_TILES = registerBlockItem("nether_bricks_large_tiles", ModBlocks.NETHER_BRICKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_ROTATED_BRICKS = registerBlockItem("nether_bricks_rotated_bricks", ModBlocks.NETHER_BRICKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_SMALL_TILES = registerBlockItem("nether_bricks_small_tiles", ModBlocks.NETHER_BRICKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_SMOOTH = registerBlockItem("nether_bricks_smooth", ModBlocks.NETHER_BRICKS_SMOOTH);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_SQUARES = registerBlockItem("nether_bricks_squares", ModBlocks.NETHER_BRICKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICKS_TILES = registerBlockItem("nether_bricks_tiles", ModBlocks.NETHER_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_BEAMS = registerBlockItem("netherite_block_beams", ModBlocks.NETHERITE_BLOCK_BEAMS);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_BRICKS = registerBlockItem("netherite_block_bricks", ModBlocks.NETHERITE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_CHISELED = registerBlockItem("netherite_block_chiseled", ModBlocks.NETHERITE_BLOCK_CHISELED);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_COMPACTED = registerBlockItem("netherite_block_compacted", ModBlocks.NETHERITE_BLOCK_COMPACTED);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_DECORATED = registerBlockItem("netherite_block_decorated", ModBlocks.NETHERITE_BLOCK_DECORATED);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_DIAGONAL_TILES = registerBlockItem("netherite_block_diagonal_tiles", ModBlocks.NETHERITE_BLOCK_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_INDENTED = registerBlockItem("netherite_block_indented", ModBlocks.NETHERITE_BLOCK_INDENTED);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_PATTERNED = registerBlockItem("netherite_block_patterned", ModBlocks.NETHERITE_BLOCK_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> NETHERITE_BLOCK_SMALL_TILES = registerBlockItem("netherite_block_small_tiles", ModBlocks.NETHERITE_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_BEAMS = registerBlockItem("netherrack_beams", ModBlocks.NETHERRACK_BEAMS);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_BRICK_PATTERN = registerBlockItem("netherrack_brick_pattern", ModBlocks.NETHERRACK_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_BRICK_PAVING = registerBlockItem("netherrack_brick_paving", ModBlocks.NETHERRACK_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_BRICKS = registerBlockItem("netherrack_bricks", ModBlocks.NETHERRACK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_DENTED = registerBlockItem("netherrack_dented", ModBlocks.NETHERRACK_DENTED);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_ROTATED_BRICKS = registerBlockItem("netherrack_rotated_bricks", ModBlocks.NETHERRACK_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_SMALL_TILES = registerBlockItem("netherrack_small_tiles", ModBlocks.NETHERRACK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_STRIPES = registerBlockItem("netherrack_stripes", ModBlocks.NETHERRACK_STRIPES);
    public static final DeferredHolder<Item, BlockItem> NETHERRACK_TILES = registerBlockItem("netherrack_tiles", ModBlocks.NETHERRACK_TILES);
    public static final DeferredHolder<Item, BlockItem> OAK_BARRED_GLASS = registerBlockItem("oak_barred_glass", ModBlocks.OAK_BARRED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_BARRED_GLASS_CTM =
        registerBlockItem("oak_barred_glass_ctm", ModBlocks.OAK_BARRED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_BARRED_GLASS_CTM_PANE = registerBlockItem("oak_barred_glass_ctm_pane", ModBlocks.OAK_BARRED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_BARRED_GLASS_PANE = registerBlockItem("oak_barred_glass_pane", ModBlocks.OAK_BARRED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_BORDERED_GLASS = registerBlockItem("oak_bordered_glass", ModBlocks.OAK_BORDERED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_BORDERED_GLASS_CTM =
        registerBlockItem("oak_bordered_glass_ctm", ModBlocks.OAK_BORDERED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_BORDERED_GLASS_CTM_PANE = registerBlockItem("oak_bordered_glass_ctm_pane", ModBlocks.OAK_BORDERED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_DIAMOND_BORDERED_GLASS = registerBlockItem("oak_diamond_bordered_glass", ModBlocks.OAK_DIAMOND_BORDERED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_DIAMOND_BORDERED_GLASS_CTM =
        registerBlockItem("oak_diamond_bordered_glass_ctm", ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_DIAMOND_BORDERED_GLASS_CTM_PANE = registerBlockItem("oak_diamond_bordered_glass_ctm_pane", ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_DIAMOND_BORDERED_GLASS_PANE = registerBlockItem("oak_diamond_bordered_glass_pane", ModBlocks.OAK_DIAMOND_BORDERED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_HORIZONTAL_LINED_GLASS = registerBlockItem("oak_horizontal_lined_glass", ModBlocks.OAK_HORIZONTAL_LINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_HORIZONTAL_LINED_GLASS_CTM =
        registerBlockItem("oak_horizontal_lined_glass_ctm", ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_HORIZONTAL_LINED_GLASS_CTM_PANE = registerBlockItem("oak_horizontal_lined_glass_ctm_pane", ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_HORIZONTAL_LINED_GLASS_PANE = registerBlockItem("oak_horizontal_lined_glass_pane", ModBlocks.OAK_HORIZONTAL_LINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_LARGE_DIAMOND_GLASS = registerBlockItem("oak_large_diamond_glass", ModBlocks.OAK_LARGE_DIAMOND_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_LARGE_DIAMOND_GLASS_CTM =
        registerBlockItem("oak_large_diamond_glass_ctm", ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_LARGE_DIAMOND_GLASS_CTM_PANE = registerBlockItem("oak_large_diamond_glass_ctm_pane", ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_LARGE_DIAMOND_GLASS_PANE = registerBlockItem("oak_large_diamond_glass_pane", ModBlocks.OAK_LARGE_DIAMOND_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_LINE_BARED_GLASS = registerBlockItem("oak_line_bared_glass", ModBlocks.OAK_LINE_BARED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_LINE_BARED_GLASS_CTM =
        registerBlockItem("oak_line_bared_glass_ctm", ModBlocks.OAK_LINE_BARED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_LINE_BARED_GLASS_CTM_PANE = registerBlockItem("oak_line_bared_glass_ctm_pane", ModBlocks.OAK_LINE_BARED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_LINE_BARED_GLASS_PANE = registerBlockItem("oak_line_bared_glass_pane", ModBlocks.OAK_LINE_BARED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_ORNATE_BARED_GLASS = registerBlockItem("oak_ornate_bared_glass", ModBlocks.OAK_ORNATE_BARED_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_ORNATE_BARED_GLASS_CTM =
        registerBlockItem("oak_ornate_bared_glass_ctm", ModBlocks.OAK_ORNATE_BARED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_ORNATE_BARED_GLASS_CTM_PANE = registerBlockItem("oak_ornate_bared_glass_ctm_pane", ModBlocks.OAK_ORNATE_BARED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_ORNATE_BARED_GLASS_PANE = registerBlockItem("oak_ornate_bared_glass_pane", ModBlocks.OAK_ORNATE_BARED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_BEAMS = registerBlockItem("oak_planks_beams", ModBlocks.OAK_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_BRICK_PATTERN = registerBlockItem("oak_planks_brick_pattern", ModBlocks.OAK_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_BRICK_PAVING = registerBlockItem("oak_planks_brick_paving", ModBlocks.OAK_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_BRICKS = registerBlockItem("oak_planks_bricks", ModBlocks.OAK_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_CRATE = registerBlockItem("oak_planks_crate", ModBlocks.OAK_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_DIAGONAL_STRIPES = registerBlockItem("oak_planks_diagonal_stripes", ModBlocks.OAK_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_DIAGONAL_TILES = registerBlockItem("oak_planks_diagonal_tiles", ModBlocks.OAK_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_DOTTED = registerBlockItem("oak_planks_dotted", ModBlocks.OAK_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_FLOORING = registerBlockItem("oak_planks_flooring", ModBlocks.OAK_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_LARGE_TILES = registerBlockItem("oak_planks_large_tiles", ModBlocks.OAK_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_PANEL =
        registerBlockItem("oak_planks_panel", ModBlocks.OAK_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_PATTERN = registerBlockItem("oak_planks_pattern", ModBlocks.OAK_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_ROTATED_BRICKS = registerBlockItem("oak_planks_rotated_bricks", ModBlocks.OAK_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_SMALL_BRICKS = registerBlockItem("oak_planks_small_bricks", ModBlocks.OAK_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_SMALL_TILES = registerBlockItem("oak_planks_small_tiles", ModBlocks.OAK_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_SQUARES = registerBlockItem("oak_planks_squares", ModBlocks.OAK_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_TILES = registerBlockItem("oak_planks_tiles", ModBlocks.OAK_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_WAVY = registerBlockItem("oak_planks_wavy", ModBlocks.OAK_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> OAK_PLANKS_WOVEN = registerBlockItem("oak_planks_woven", ModBlocks.OAK_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> OAK_SNOWFLAKE_GLASS = registerBlockItem("oak_snowflake_glass", ModBlocks.OAK_SNOWFLAKE_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_SNOWFLAKE_GLASS_PANE = registerBlockItem("oak_snowflake_glass_pane", ModBlocks.OAK_SNOWFLAKE_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_BARS = registerBlockItem("oak_window_bars", ModBlocks.OAK_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_BARS_CTM = registerBlockItem("oak_window_bars_ctm", ModBlocks.OAK_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_COVERED = registerBlockItem("oak_window_covered", ModBlocks.OAK_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_COVERED_CTM = registerBlockItem("oak_window_covered_ctm", ModBlocks.OAK_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_DIAGONAL = registerBlockItem("oak_window_diagonal", ModBlocks.OAK_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_DIAGONAL_CTM = registerBlockItem("oak_window_diagonal_ctm", ModBlocks.OAK_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_LARGE = registerBlockItem("oak_window_large", ModBlocks.OAK_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_LARGE_CTM = registerBlockItem("oak_window_large_ctm", ModBlocks.OAK_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_PANES_CTM = registerBlockItem("oak_window_panes_ctm", ModBlocks.OAK_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_PANES_CTM_PANE = registerBlockItem("oak_window_panes_ctm_pane", ModBlocks.OAK_WINDOW_PANES_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_ROUNDED = registerBlockItem("oak_window_rounded", ModBlocks.OAK_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_ROUNDED_CTM = registerBlockItem("oak_window_rounded_ctm", ModBlocks.OAK_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SLIM = registerBlockItem("oak_window_slim", ModBlocks.OAK_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SLIM_CTM = registerBlockItem("oak_window_slim_ctm", ModBlocks.OAK_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SWIRLING = registerBlockItem("oak_window_swirling", ModBlocks.OAK_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_SWIRLING_CTM = registerBlockItem("oak_window_swirling_ctm", ModBlocks.OAK_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_TILES = registerBlockItem("oak_window_tiles", ModBlocks.OAK_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> OAK_WINDOW_TILES_CTM = registerBlockItem("oak_window_tiles_ctm", ModBlocks.OAK_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WOVEN_GLASS = registerBlockItem("oak_woven_glass", ModBlocks.OAK_WOVEN_GLASS);
    public static final DeferredHolder<Item, BlockItem> OAK_WOVEN_GLASS_CTM =
        registerBlockItem("oak_woven_glass_ctm", ModBlocks.OAK_WOVEN_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> OAK_WOVEN_GLASS_CTM_PANE = registerBlockItem("oak_woven_glass_ctm_pane", ModBlocks.OAK_WOVEN_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> OAK_WOVEN_GLASS_PANE = registerBlockItem("oak_woven_glass_pane", ModBlocks.OAK_WOVEN_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_BORDERED = registerBlockItem("obsidian_bordered", ModBlocks.OBSIDIAN_BORDERED);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_BRICK_PATTERN = registerBlockItem("obsidian_brick_pattern", ModBlocks.OBSIDIAN_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_BRICK_PAVING = registerBlockItem("obsidian_brick_paving", ModBlocks.OBSIDIAN_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_BRICKS = registerBlockItem("obsidian_bricks", ModBlocks.OBSIDIAN_BRICKS);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_CHISELED = registerBlockItem("obsidian_chiseled", ModBlocks.OBSIDIAN_CHISELED);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_CHISELED_CIRCLES = registerBlockItem("obsidian_chiseled_circles", ModBlocks.OBSIDIAN_CHISELED_CIRCLES);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_DARK = registerBlockItem("obsidian_dark", ModBlocks.OBSIDIAN_DARK);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_ROTATED_BRICKS = registerBlockItem("obsidian_rotated_bricks", ModBlocks.OBSIDIAN_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_SPOTS = registerBlockItem("obsidian_spots", ModBlocks.OBSIDIAN_SPOTS);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_SQUARES = registerBlockItem("obsidian_squares", ModBlocks.OBSIDIAN_SQUARES);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_STRIPES = registerBlockItem("obsidian_stripes", ModBlocks.OBSIDIAN_STRIPES);
    public static final DeferredHolder<Item, BlockItem> OBSIDIAN_TILES = registerBlockItem("obsidian_tiles", ModBlocks.OBSIDIAN_TILES);
    public static final DeferredHolder<Item, BlockItem> OCHRUM_CUT_POLISHED = registerBlockItem("ochrum_cut_polished", ModBlocks.OCHRUM_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> OCHRUM_CUT_SMALL_BRICK = registerBlockItem("ochrum_cut_small_brick", ModBlocks.OCHRUM_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> ORANGE_ACACIA_LEAVES =
        registerBlockItem("orange_acacia_leaves", ModBlocks.ORANGE_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_BIRCH_LEAVES =
        registerBlockItem("orange_birch_leaves", ModBlocks.ORANGE_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_CONCRETE_CTM =
        registerBlockItem("orange_concrete_ctm", ModBlocks.ORANGE_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORANGE_CONCRETE_PANEL =
        registerBlockItem("orange_concrete_panel", ModBlocks.ORANGE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> ORANGE_DARK_OAK_LEAVES =
        registerBlockItem("orange_dark_oak_leaves", ModBlocks.ORANGE_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_JUNGLE_LEAVES =
        registerBlockItem("orange_jungle_leaves", ModBlocks.ORANGE_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_OAK_LEAVES =
        registerBlockItem("orange_oak_leaves", ModBlocks.ORANGE_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_SPRUCE_LEAVES =
        registerBlockItem("orange_spruce_leaves", ModBlocks.ORANGE_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> ORANGE_TERRACOTTA_COLUMN =
        registerBlockItem("orange_terracotta_column", ModBlocks.ORANGE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> ORANGE_TERRACOTTA_CTM =
        registerBlockItem("orange_terracotta_ctm", ModBlocks.ORANGE_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_AMETHYST_BLOCK_CTM =
        registerBlockItem("ornate_amethyst_block_ctm", ModBlocks.ORNATE_AMETHYST_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ANCIENT_DEBRIS_CTM =
        registerBlockItem("ornate_ancient_debris_ctm", ModBlocks.ORNATE_ANCIENT_DEBRIS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ANDESITE_CTM =
        registerBlockItem("ornate_andesite_ctm", ModBlocks.ORNATE_ANDESITE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BASALT_CTM =
        registerBlockItem("ornate_basalt_ctm", ModBlocks.ORNATE_BASALT_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACK_STAINED_GLASS =
        registerBlockItem("ornate_black_stained_glass", ModBlocks.ORNATE_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACK_STAINED_GLASS_CTM =
        registerBlockItem("ornate_black_stained_glass_ctm", ModBlocks.ORNATE_BLACK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_black_stained_glass_ctm_pane", ModBlocks.ORNATE_BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACK_STAINED_GLASS_PANE = registerBlockItem("ornate_black_stained_glass_pane", ModBlocks.ORNATE_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLACKSTONE_CTM =
        registerBlockItem("ornate_blackstone_ctm", ModBlocks.ORNATE_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_ICE_CTM =
        registerBlockItem("ornate_blue_ice_ctm", ModBlocks.ORNATE_BLUE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_STAINED_GLASS =
        registerBlockItem("ornate_blue_stained_glass", ModBlocks.ORNATE_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("ornate_blue_stained_glass_ctm", ModBlocks.ORNATE_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_blue_stained_glass_ctm_pane", ModBlocks.ORNATE_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BLUE_STAINED_GLASS_PANE = registerBlockItem("ornate_blue_stained_glass_pane", ModBlocks.ORNATE_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BORDERLESS_BRICKS_CTM =
        registerBlockItem("ornate_borderless_bricks_ctm", ModBlocks.ORNATE_BORDERLESS_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BRICKS_CTM =
        registerBlockItem("ornate_bricks_ctm", ModBlocks.ORNATE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BROWN_STAINED_GLASS =
        registerBlockItem("ornate_brown_stained_glass", ModBlocks.ORNATE_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BROWN_STAINED_GLASS_CTM =
        registerBlockItem("ornate_brown_stained_glass_ctm", ModBlocks.ORNATE_BROWN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_brown_stained_glass_ctm_pane", ModBlocks.ORNATE_BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_BROWN_STAINED_GLASS_PANE = registerBlockItem("ornate_brown_stained_glass_pane", ModBlocks.ORNATE_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CALCITE_CTM =
        registerBlockItem("ornate_calcite_ctm", ModBlocks.ORNATE_CALCITE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CLAY_CTM =
        registerBlockItem("ornate_clay_ctm", ModBlocks.ORNATE_CLAY_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_COAL_BLOCK_CTM =
        registerBlockItem("ornate_coal_block_ctm", ModBlocks.ORNATE_COAL_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_COBBLESTONE_CTM =
        registerBlockItem("ornate_cobblestone_ctm", ModBlocks.ORNATE_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CRYING_OBSIDIAN_CTM =
        registerBlockItem("ornate_crying_obsidian_ctm", ModBlocks.ORNATE_CRYING_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CYAN_STAINED_GLASS =
        registerBlockItem("ornate_cyan_stained_glass", ModBlocks.ORNATE_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CYAN_STAINED_GLASS_CTM =
        registerBlockItem("ornate_cyan_stained_glass_ctm", ModBlocks.ORNATE_CYAN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_cyan_stained_glass_ctm_pane", ModBlocks.ORNATE_CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_CYAN_STAINED_GLASS_PANE = registerBlockItem("ornate_cyan_stained_glass_pane", ModBlocks.ORNATE_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DARK_PRISMARINE_CTM =
        registerBlockItem("ornate_dark_prismarine_ctm", ModBlocks.ORNATE_DARK_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DEEPSLATE_CTM =
        registerBlockItem("ornate_deepslate_ctm", ModBlocks.ORNATE_DEEPSLATE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DIORITE_CTM =
        registerBlockItem("ornate_diorite_ctm", ModBlocks.ORNATE_DIORITE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DIRT_CTM =
        registerBlockItem("ornate_dirt_ctm", ModBlocks.ORNATE_DIRT_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_DRIPSTONE_BLOCK_CTM =
        registerBlockItem("ornate_dripstone_block_ctm", ModBlocks.ORNATE_DRIPSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_END_STONE_CTM =
        registerBlockItem("ornate_end_stone_ctm", ModBlocks.ORNATE_END_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GILDED_BLACKSTONE_CTM =
        registerBlockItem("ornate_gilded_blackstone_ctm", ModBlocks.ORNATE_GILDED_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRAY_STAINED_GLASS =
        registerBlockItem("ornate_gray_stained_glass", ModBlocks.ORNATE_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("ornate_gray_stained_glass_ctm", ModBlocks.ORNATE_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_gray_stained_glass_ctm_pane", ModBlocks.ORNATE_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GRAY_STAINED_GLASS_PANE = registerBlockItem("ornate_gray_stained_glass_pane", ModBlocks.ORNATE_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GREEN_STAINED_GLASS =
        registerBlockItem("ornate_green_stained_glass", ModBlocks.ORNATE_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GREEN_STAINED_GLASS_CTM =
        registerBlockItem("ornate_green_stained_glass_ctm", ModBlocks.ORNATE_GREEN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("ornate_green_stained_glass_ctm_pane", ModBlocks.ORNATE_GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_GREEN_STAINED_GLASS_PANE = registerBlockItem("ornate_green_stained_glass_pane", ModBlocks.ORNATE_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_ICE_CTM =
        registerBlockItem("ornate_ice_ctm", ModBlocks.ORNATE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LAPIS_BLOCK_CTM =
        registerBlockItem("ornate_lapis_block_ctm", ModBlocks.ORNATE_LAPIS_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LEADED_GLASS =
        registerBlockItem("ornate_leaded_glass", ModBlocks.ORNATE_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LEADED_GLASS_PANE = registerBlockItem("ornate_leaded_glass_pane", ModBlocks.ORNATE_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> ORNATE_LODESTONE_CTM =
        registerBlockItem("ornate_lodestone_ctm", ModBlocks.ORNATE_LODESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MAGMA_BLOCK_CTM =
        registerBlockItem("ornate_magma_block_ctm", ModBlocks.ORNATE_MAGMA_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MOSSY_COBBLESTONE_CTM =
        registerBlockItem("ornate_mossy_cobblestone_ctm", ModBlocks.ORNATE_MOSSY_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MOSSY_STONE_BRICKS_CTM =
        registerBlockItem("ornate_mossy_stone_bricks_ctm", ModBlocks.ORNATE_MOSSY_STONE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MUD_BRICKS_CTM =
        registerBlockItem("ornate_mud_bricks_ctm", ModBlocks.ORNATE_MUD_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_MUD_CTM =
        registerBlockItem("ornate_mud_ctm", ModBlocks.ORNATE_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_NETHER_BRICKS_CTM =
        registerBlockItem("ornate_nether_bricks_ctm", ModBlocks.ORNATE_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_NETHERRACK_CTM =
        registerBlockItem("ornate_netherrack_ctm", ModBlocks.ORNATE_NETHERRACK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_OBSIDIAN_CTM =
        registerBlockItem("ornate_obsidian_ctm", ModBlocks.ORNATE_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PACKED_ICE_CTM =
        registerBlockItem("ornate_packed_ice_ctm", ModBlocks.ORNATE_PACKED_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PACKED_MUD_CTM =
        registerBlockItem("ornate_packed_mud_ctm", ModBlocks.ORNATE_PACKED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PRISMARINE_CTM =
        registerBlockItem("ornate_prismarine_ctm", ModBlocks.ORNATE_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_PURPUR_BLOCK_CTM =
        registerBlockItem("ornate_purpur_block_ctm", ModBlocks.ORNATE_PURPUR_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_QUARTZ_BLOCK_CTM =
        registerBlockItem("ornate_quartz_block_ctm", ModBlocks.ORNATE_QUARTZ_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RAW_COPPER_BLOCK_CTM =
        registerBlockItem("ornate_raw_copper_block_ctm", ModBlocks.ORNATE_RAW_COPPER_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RAW_GOLD_BLOCK_CTM =
        registerBlockItem("ornate_raw_gold_block_ctm", ModBlocks.ORNATE_RAW_GOLD_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RAW_IRON_BLOCK_CTM =
        registerBlockItem("ornate_raw_iron_block_ctm", ModBlocks.ORNATE_RAW_IRON_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_NETHER_BRICKS_CTM =
        registerBlockItem("ornate_red_nether_bricks_ctm", ModBlocks.ORNATE_RED_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_RED_SANDSTONE_CTM =
        registerBlockItem("ornate_red_sandstone_ctm", ModBlocks.ORNATE_RED_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_REDSTONE_BLOCK_CTM =
        registerBlockItem("ornate_redstone_block_ctm", ModBlocks.ORNATE_REDSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_SANDSTONE_CTM =
        registerBlockItem("ornate_sandstone_ctm", ModBlocks.ORNATE_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_SMOOTH_STONE_CTM =
        registerBlockItem("ornate_smooth_stone_ctm", ModBlocks.ORNATE_SMOOTH_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_SNOW_BLOCK_CTM =
        registerBlockItem("ornate_snow_block_ctm", ModBlocks.ORNATE_SNOW_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> ORNATE_TUFF_CTM =
        registerBlockItem("ornate_tuff_ctm", ModBlocks.ORNATE_TUFF_CTM);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_AMETHYST_BLOCK_TILES =
        registerBlockItem("overlapping_amethyst_block_tiles", ModBlocks.OVERLAPPING_AMETHYST_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_ANCIENT_DEBRIS_TILES =
        registerBlockItem("overlapping_ancient_debris_tiles", ModBlocks.OVERLAPPING_ANCIENT_DEBRIS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_ANDESITE_TILES =
        registerBlockItem("overlapping_andesite_tiles", ModBlocks.OVERLAPPING_ANDESITE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BASALT_TILES =
        registerBlockItem("overlapping_basalt_tiles", ModBlocks.OVERLAPPING_BASALT_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BLACKSTONE_TILES =
        registerBlockItem("overlapping_blackstone_tiles", ModBlocks.OVERLAPPING_BLACKSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BLUE_ICE_TILES =
        registerBlockItem("overlapping_blue_ice_tiles", ModBlocks.OVERLAPPING_BLUE_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BORDERLESS_BRICKS_TILES =
        registerBlockItem("overlapping_borderless_bricks_tiles", ModBlocks.OVERLAPPING_BORDERLESS_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_BRICKS_TILES =
        registerBlockItem("overlapping_bricks_tiles", ModBlocks.OVERLAPPING_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_CALCITE_TILES =
        registerBlockItem("overlapping_calcite_tiles", ModBlocks.OVERLAPPING_CALCITE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_CLAY_TILES =
        registerBlockItem("overlapping_clay_tiles", ModBlocks.OVERLAPPING_CLAY_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_COAL_BLOCK_TILES =
        registerBlockItem("overlapping_coal_block_tiles", ModBlocks.OVERLAPPING_COAL_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_COBBLESTONE_TILES =
        registerBlockItem("overlapping_cobblestone_tiles", ModBlocks.OVERLAPPING_COBBLESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_CRYING_OBSIDIAN_TILES =
        registerBlockItem("overlapping_crying_obsidian_tiles", ModBlocks.OVERLAPPING_CRYING_OBSIDIAN_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DARK_PRISMARINE_TILES =
        registerBlockItem("overlapping_dark_prismarine_tiles", ModBlocks.OVERLAPPING_DARK_PRISMARINE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DEEPSLATE_TILES =
        registerBlockItem("overlapping_deepslate_tiles", ModBlocks.OVERLAPPING_DEEPSLATE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DIORITE_TILES =
        registerBlockItem("overlapping_diorite_tiles", ModBlocks.OVERLAPPING_DIORITE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DIRT_TILES =
        registerBlockItem("overlapping_dirt_tiles", ModBlocks.OVERLAPPING_DIRT_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_DRIPSTONE_BLOCK_TILES =
        registerBlockItem("overlapping_dripstone_block_tiles", ModBlocks.OVERLAPPING_DRIPSTONE_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_END_STONE_TILES =
        registerBlockItem("overlapping_end_stone_tiles", ModBlocks.OVERLAPPING_END_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_GILDED_BLACKSTONE_TILES =
        registerBlockItem("overlapping_gilded_blackstone_tiles", ModBlocks.OVERLAPPING_GILDED_BLACKSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_ICE_TILES =
        registerBlockItem("overlapping_ice_tiles", ModBlocks.OVERLAPPING_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_LAPIS_BLOCK_TILES =
        registerBlockItem("overlapping_lapis_block_tiles", ModBlocks.OVERLAPPING_LAPIS_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_LODESTONE_TILES =
        registerBlockItem("overlapping_lodestone_tiles", ModBlocks.OVERLAPPING_LODESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MAGMA_BLOCK_TILES =
        registerBlockItem("overlapping_magma_block_tiles", ModBlocks.OVERLAPPING_MAGMA_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MOSSY_COBBLESTONE_TILES =
        registerBlockItem("overlapping_mossy_cobblestone_tiles", ModBlocks.OVERLAPPING_MOSSY_COBBLESTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MOSSY_STONE_BRICKS_TILES =
        registerBlockItem("overlapping_mossy_stone_bricks_tiles", ModBlocks.OVERLAPPING_MOSSY_STONE_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MUD_BRICKS_TILES =
        registerBlockItem("overlapping_mud_bricks_tiles", ModBlocks.OVERLAPPING_MUD_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_MUD_TILES =
        registerBlockItem("overlapping_mud_tiles", ModBlocks.OVERLAPPING_MUD_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_NETHER_BRICKS_TILES =
        registerBlockItem("overlapping_nether_bricks_tiles", ModBlocks.OVERLAPPING_NETHER_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_NETHERRACK_TILES =
        registerBlockItem("overlapping_netherrack_tiles", ModBlocks.OVERLAPPING_NETHERRACK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_OBSIDIAN_TILES =
        registerBlockItem("overlapping_obsidian_tiles", ModBlocks.OVERLAPPING_OBSIDIAN_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PACKED_ICE_TILES =
        registerBlockItem("overlapping_packed_ice_tiles", ModBlocks.OVERLAPPING_PACKED_ICE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PACKED_MUD_TILES =
        registerBlockItem("overlapping_packed_mud_tiles", ModBlocks.OVERLAPPING_PACKED_MUD_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PRISMARINE_TILES =
        registerBlockItem("overlapping_prismarine_tiles", ModBlocks.OVERLAPPING_PRISMARINE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_PURPUR_BLOCK_TILES =
        registerBlockItem("overlapping_purpur_block_tiles", ModBlocks.OVERLAPPING_PURPUR_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_QUARTZ_BLOCK_TILES =
        registerBlockItem("overlapping_quartz_block_tiles", ModBlocks.OVERLAPPING_QUARTZ_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RAW_COPPER_BLOCK_TILES =
        registerBlockItem("overlapping_raw_copper_block_tiles", ModBlocks.OVERLAPPING_RAW_COPPER_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RAW_GOLD_BLOCK_TILES =
        registerBlockItem("overlapping_raw_gold_block_tiles", ModBlocks.OVERLAPPING_RAW_GOLD_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RAW_IRON_BLOCK_TILES =
        registerBlockItem("overlapping_raw_iron_block_tiles", ModBlocks.OVERLAPPING_RAW_IRON_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RED_NETHER_BRICKS_TILES =
        registerBlockItem("overlapping_red_nether_bricks_tiles", ModBlocks.OVERLAPPING_RED_NETHER_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_RED_SANDSTONE_TILES =
        registerBlockItem("overlapping_red_sandstone_tiles", ModBlocks.OVERLAPPING_RED_SANDSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_REDSTONE_BLOCK_TILES =
        registerBlockItem("overlapping_redstone_block_tiles", ModBlocks.OVERLAPPING_REDSTONE_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_SANDSTONE_TILES =
        registerBlockItem("overlapping_sandstone_tiles", ModBlocks.OVERLAPPING_SANDSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_SMOOTH_STONE_TILES =
        registerBlockItem("overlapping_smooth_stone_tiles", ModBlocks.OVERLAPPING_SMOOTH_STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_SNOW_BLOCK_TILES =
        registerBlockItem("overlapping_snow_block_tiles", ModBlocks.OVERLAPPING_SNOW_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> OVERLAPPING_TUFF_TILES =
        registerBlockItem("overlapping_tuff_tiles", ModBlocks.OVERLAPPING_TUFF_TILES);
    public static final DeferredHolder<Item, BlockItem> PEGGED_ACACIA_PLANKS =
        registerBlockItem("pegged_acacia_planks", ModBlocks.PEGGED_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BIRCH_PLANKS =
        registerBlockItem("pegged_birch_planks", ModBlocks.PEGGED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BLACK_CONCRETE =
        registerBlockItem("pegged_black_concrete", ModBlocks.PEGGED_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BLUE_CONCRETE =
        registerBlockItem("pegged_blue_concrete", ModBlocks.PEGGED_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_BROWN_CONCRETE =
        registerBlockItem("pegged_brown_concrete", ModBlocks.PEGGED_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_CYAN_CONCRETE =
        registerBlockItem("pegged_cyan_concrete", ModBlocks.PEGGED_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_GRAY_CONCRETE =
        registerBlockItem("pegged_gray_concrete", ModBlocks.PEGGED_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_GREEN_CONCRETE =
        registerBlockItem("pegged_green_concrete", ModBlocks.PEGGED_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_LIGHT_BLUE_CONCRETE =
        registerBlockItem("pegged_light_blue_concrete", ModBlocks.PEGGED_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_LIGHT_GRAY_CONCRETE =
        registerBlockItem("pegged_light_gray_concrete", ModBlocks.PEGGED_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_LIME_CONCRETE =
        registerBlockItem("pegged_lime_concrete", ModBlocks.PEGGED_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_MAGENTA_CONCRETE =
        registerBlockItem("pegged_magenta_concrete", ModBlocks.PEGGED_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_OAK_PLANKS =
        registerBlockItem("pegged_oak_planks", ModBlocks.PEGGED_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> PEGGED_ORANGE_CONCRETE =
        registerBlockItem("pegged_orange_concrete", ModBlocks.PEGGED_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_PINK_CONCRETE =
        registerBlockItem("pegged_pink_concrete", ModBlocks.PEGGED_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_PURPLE_CONCRETE =
        registerBlockItem("pegged_purple_concrete", ModBlocks.PEGGED_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_RED_CONCRETE =
        registerBlockItem("pegged_red_concrete", ModBlocks.PEGGED_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_WHITE_CONCRETE =
        registerBlockItem("pegged_white_concrete", ModBlocks.PEGGED_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PEGGED_YELLOW_CONCRETE =
        registerBlockItem("pegged_yellow_concrete", ModBlocks.PEGGED_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> PINK_CONCRETE_CTM =
        registerBlockItem("pink_concrete_ctm", ModBlocks.PINK_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> PINK_CONCRETE_PANEL =
        registerBlockItem("pink_concrete_panel", ModBlocks.PINK_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> PINK_TERRACOTTA_COLUMN =
        registerBlockItem("pink_terracotta_column", ModBlocks.PINK_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> PINK_TERRACOTTA_CTM =
        registerBlockItem("pink_terracotta_ctm", ModBlocks.PINK_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> POLISHED_AMETHYST_BLOCK =
        registerBlockItem("polished_amethyst_block", ModBlocks.POLISHED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANCIENT_DEBRIS =
        registerBlockItem("polished_ancient_debris", ModBlocks.POLISHED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BAMBOO_PLANKS =
        registerBlockItem("polished_bamboo_planks", ModBlocks.POLISHED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BASALT =
        registerBlockItem("polished_basalt", ModBlocks.POLISHED_BASALT);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BIRCH_PLANKS =
        registerBlockItem("polished_birch_planks", ModBlocks.POLISHED_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLUE_ICE =
        registerBlockItem("polished_blue_ice", ModBlocks.POLISHED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BORDERLESS_BRICKS =
        registerBlockItem("polished_borderless_bricks", ModBlocks.POLISHED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_BRICKS =
        registerBlockItem("polished_bricks", ModBlocks.POLISHED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_CALCITE =
        registerBlockItem("polished_calcite", ModBlocks.POLISHED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_CLAY =
        registerBlockItem("polished_clay", ModBlocks.POLISHED_CLAY);
    public static final DeferredHolder<Item, BlockItem> POLISHED_COAL_BLOCK =
        registerBlockItem("polished_coal_block", ModBlocks.POLISHED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_COBBLESTONE =
        registerBlockItem("polished_cobblestone", ModBlocks.POLISHED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_CRYING_OBSIDIAN =
        registerBlockItem("polished_crying_obsidian", ModBlocks.POLISHED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DARK_PRISMARINE =
        registerBlockItem("polished_dark_prismarine", ModBlocks.POLISHED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DEEPSLATE =
        registerBlockItem("polished_deepslate", ModBlocks.POLISHED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIRT =
        registerBlockItem("polished_dirt", ModBlocks.POLISHED_DIRT);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DRIPSTONE = registerBlockItem("polished_dripstone", ModBlocks.POLISHED_DRIPSTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_DRIPSTONE_BLOCK =
        registerBlockItem("polished_dripstone_block", ModBlocks.POLISHED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_END_STONE =
        registerBlockItem("polished_end_stone", ModBlocks.POLISHED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_GILDED_BLACKSTONE =
        registerBlockItem("polished_gilded_blackstone", ModBlocks.POLISHED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_ICE =
        registerBlockItem("polished_ice", ModBlocks.POLISHED_ICE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_LAPIS_BLOCK =
        registerBlockItem("polished_lapis_block", ModBlocks.POLISHED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_LODESTONE =
        registerBlockItem("polished_lodestone", ModBlocks.POLISHED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_MAGMA_BLOCK =
        registerBlockItem("polished_magma_block", ModBlocks.POLISHED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_MOSSY_COBBLESTONE =
        registerBlockItem("polished_mossy_cobblestone", ModBlocks.POLISHED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_MOSSY_STONE_BRICKS =
        registerBlockItem("polished_mossy_stone_bricks", ModBlocks.POLISHED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_NETHER_BRICKS =
        registerBlockItem("polished_nether_bricks", ModBlocks.POLISHED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_NETHERRACK =
        registerBlockItem("polished_netherrack", ModBlocks.POLISHED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_OBSIDIAN =
        registerBlockItem("polished_obsidian", ModBlocks.POLISHED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> POLISHED_PACKED_ICE =
        registerBlockItem("polished_packed_ice", ModBlocks.POLISHED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_PRISMARINE =
        registerBlockItem("polished_prismarine", ModBlocks.POLISHED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_PURPUR_BLOCK =
        registerBlockItem("polished_purpur_block", ModBlocks.POLISHED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_QUARTZ_BLOCK =
        registerBlockItem("polished_quartz_block", ModBlocks.POLISHED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RAW_COPPER_BLOCK =
        registerBlockItem("polished_raw_copper_block", ModBlocks.POLISHED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RAW_GOLD_BLOCK =
        registerBlockItem("polished_raw_gold_block", ModBlocks.POLISHED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RAW_IRON_BLOCK =
        registerBlockItem("polished_raw_iron_block", ModBlocks.POLISHED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RED_NETHER_BRICKS =
        registerBlockItem("polished_red_nether_bricks", ModBlocks.POLISHED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> POLISHED_RED_SANDSTONE =
        registerBlockItem("polished_red_sandstone", ModBlocks.POLISHED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_REDSTONE_BLOCK =
        registerBlockItem("polished_redstone_block", ModBlocks.POLISHED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_SANDSTONE =
        registerBlockItem("polished_sandstone", ModBlocks.POLISHED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_SMOOTH_STONE =
        registerBlockItem("polished_smooth_stone", ModBlocks.POLISHED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> POLISHED_SNOW_BLOCK =
        registerBlockItem("polished_snow_block", ModBlocks.POLISHED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> POLISHED_TUFF =
        registerBlockItem("polished_tuff", ModBlocks.POLISHED_TUFF);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_BEAMS = registerBlockItem("prismarine_bricks_beams", ModBlocks.PRISMARINE_BRICKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_BRICK_PATTERN = registerBlockItem("prismarine_bricks_brick_pattern", ModBlocks.PRISMARINE_BRICKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_BRICK_PAVING = registerBlockItem("prismarine_bricks_brick_paving", ModBlocks.PRISMARINE_BRICKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_BRICKS = registerBlockItem("prismarine_bricks_bricks", ModBlocks.PRISMARINE_BRICKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_CHISELED_CIRCLES = registerBlockItem("prismarine_bricks_chiseled_circles", ModBlocks.PRISMARINE_BRICKS_CHISELED_CIRCLES);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_CHISELED_SQUARES = registerBlockItem("prismarine_bricks_chiseled_squares", ModBlocks.PRISMARINE_BRICKS_CHISELED_SQUARES);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_DIAGONAL_BRICKS = registerBlockItem("prismarine_bricks_diagonal_bricks", ModBlocks.PRISMARINE_BRICKS_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_DIAGONAL_TILES = registerBlockItem("prismarine_bricks_diagonal_tiles", ModBlocks.PRISMARINE_BRICKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_DOTTED = registerBlockItem("prismarine_bricks_dotted", ModBlocks.PRISMARINE_BRICKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_PILLARS = registerBlockItem("prismarine_bricks_pillars", ModBlocks.PRISMARINE_BRICKS_PILLARS);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_POLISHED = registerBlockItem("prismarine_bricks_polished", ModBlocks.PRISMARINE_BRICKS_POLISHED);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_ROTATED_BRICKS = registerBlockItem("prismarine_bricks_rotated_bricks", ModBlocks.PRISMARINE_BRICKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_ROWS = registerBlockItem("prismarine_bricks_rows", ModBlocks.PRISMARINE_BRICKS_ROWS);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_SMALL_TILES = registerBlockItem("prismarine_bricks_small_tiles", ModBlocks.PRISMARINE_BRICKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_SQUARES = registerBlockItem("prismarine_bricks_squares", ModBlocks.PRISMARINE_BRICKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_TILES = registerBlockItem("prismarine_bricks_tiles", ModBlocks.PRISMARINE_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_WAVY = registerBlockItem("prismarine_bricks_wavy", ModBlocks.PRISMARINE_BRICKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICKS_WOVEN = registerBlockItem("prismarine_bricks_woven", ModBlocks.PRISMARINE_BRICKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> PURPLE_CONCRETE_CTM =
        registerBlockItem("purple_concrete_ctm", ModBlocks.PURPLE_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> PURPLE_CONCRETE_PANEL =
        registerBlockItem("purple_concrete_panel", ModBlocks.PURPLE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> PURPLE_TERRACOTTA_COLUMN =
        registerBlockItem("purple_terracotta_column", ModBlocks.PURPLE_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> PURPLE_TERRACOTTA_CTM =
        registerBlockItem("purple_terracotta_ctm", ModBlocks.PURPLE_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> PURPUR_BRICK_PATTERN = registerBlockItem("purpur_brick_pattern", ModBlocks.PURPUR_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PURPUR_BRICK_PAVING = registerBlockItem("purpur_brick_paving", ModBlocks.PURPUR_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> PURPUR_BRICKS = registerBlockItem("purpur_bricks", ModBlocks.PURPUR_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PURPUR_COLUMN_CTM = registerBlockItem("purpur_column_ctm", ModBlocks.PURPUR_COLUMN_CTM);
    public static final DeferredHolder<Item, BlockItem> PURPUR_DIAGONAL_BRICKS = registerBlockItem("purpur_diagonal_bricks", ModBlocks.PURPUR_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PURPUR_DIAGONAL_TILES = registerBlockItem("purpur_diagonal_tiles", ModBlocks.PURPUR_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> PURPUR_DOTTED = registerBlockItem("purpur_dotted", ModBlocks.PURPUR_DOTTED);
    public static final DeferredHolder<Item, BlockItem> PURPUR_FABRIC = registerBlockItem("purpur_fabric", ModBlocks.PURPUR_FABRIC);
    public static final DeferredHolder<Item, BlockItem> PURPUR_JAGGED_PATTERN = registerBlockItem("purpur_jagged_pattern", ModBlocks.PURPUR_JAGGED_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PURPUR_LARGE_TILES = registerBlockItem("purpur_large_tiles", ModBlocks.PURPUR_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> PURPUR_ORGANIC_PATTERN = registerBlockItem("purpur_organic_pattern", ModBlocks.PURPUR_ORGANIC_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PURPUR_ROTATED_BRICKS = registerBlockItem("purpur_rotated_bricks", ModBlocks.PURPUR_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> PURPUR_SLANTED_TILES = registerBlockItem("purpur_slanted_tiles", ModBlocks.PURPUR_SLANTED_TILES);
    public static final DeferredHolder<Item, BlockItem> PURPUR_SMALL_TILES = registerBlockItem("purpur_small_tiles", ModBlocks.PURPUR_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> PURPUR_SPIRAL_PATTERN = registerBlockItem("purpur_spiral_pattern", ModBlocks.PURPUR_SPIRAL_PATTERN);
    public static final DeferredHolder<Item, BlockItem> PURPUR_SQUARES = registerBlockItem("purpur_squares", ModBlocks.PURPUR_SQUARES);
    public static final DeferredHolder<Item, BlockItem> PURPUR_TILES = registerBlockItem("purpur_tiles", ModBlocks.PURPUR_TILES);
    public static final DeferredHolder<Item, BlockItem> PURPUR_WOVEN = registerBlockItem("purpur_woven", ModBlocks.PURPUR_WOVEN);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK = registerBlockItem("quartz_block", ModBlocks.QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_BORDERED = registerBlockItem("quartz_block_bordered", ModBlocks.QUARTZ_BLOCK_BORDERED);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_BRICK_PAVING = registerBlockItem("quartz_block_brick_paving", ModBlocks.QUARTZ_BLOCK_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_CHISELED_CTM = registerBlockItem("quartz_block_chiseled_ctm", ModBlocks.QUARTZ_BLOCK_CHISELED_CTM);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_CONNECTING = registerBlockItem("quartz_block_connecting", ModBlocks.QUARTZ_BLOCK_CONNECTING);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_CROSSES = registerBlockItem("quartz_block_crosses", ModBlocks.QUARTZ_BLOCK_CROSSES);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_DIAGONAL_TILES = registerBlockItem("quartz_block_diagonal_tiles", ModBlocks.QUARTZ_BLOCK_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_PATTERN = registerBlockItem("quartz_block_pattern", ModBlocks.QUARTZ_BLOCK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_ROTATED_BRICKS = registerBlockItem("quartz_block_rotated_bricks", ModBlocks.QUARTZ_BLOCK_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_ROWS = registerBlockItem("quartz_block_rows", ModBlocks.QUARTZ_BLOCK_ROWS);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_SCALES = registerBlockItem("quartz_block_scales", ModBlocks.QUARTZ_BLOCK_SCALES);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_SMALL_TILES = registerBlockItem("quartz_block_small_tiles", ModBlocks.QUARTZ_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_SQUARES = registerBlockItem("quartz_block_squares", ModBlocks.QUARTZ_BLOCK_SQUARES);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_STRIPES = registerBlockItem("quartz_block_stripes", ModBlocks.QUARTZ_BLOCK_STRIPES);
    public static final DeferredHolder<Item, BlockItem> QUARTZ_BLOCK_TILES = registerBlockItem("quartz_block_tiles", ModBlocks.QUARTZ_BLOCK_TILES);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLACK_STAINED_GLASS =
        registerBlockItem("raster_black_stained_glass", ModBlocks.RASTER_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLACK_STAINED_GLASS_CTM =
        registerBlockItem("raster_black_stained_glass_ctm", ModBlocks.RASTER_BLACK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_black_stained_glass_ctm_pane", ModBlocks.RASTER_BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLACK_STAINED_GLASS_PANE = registerBlockItem("raster_black_stained_glass_pane", ModBlocks.RASTER_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLUE_STAINED_GLASS =
        registerBlockItem("raster_blue_stained_glass", ModBlocks.RASTER_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("raster_blue_stained_glass_ctm", ModBlocks.RASTER_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_blue_stained_glass_ctm_pane", ModBlocks.RASTER_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_BLUE_STAINED_GLASS_PANE = registerBlockItem("raster_blue_stained_glass_pane", ModBlocks.RASTER_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_BROWN_STAINED_GLASS =
        registerBlockItem("raster_brown_stained_glass", ModBlocks.RASTER_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_BROWN_STAINED_GLASS_CTM =
        registerBlockItem("raster_brown_stained_glass_ctm", ModBlocks.RASTER_BROWN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_brown_stained_glass_ctm_pane", ModBlocks.RASTER_BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_BROWN_STAINED_GLASS_PANE = registerBlockItem("raster_brown_stained_glass_pane", ModBlocks.RASTER_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_CYAN_STAINED_GLASS =
        registerBlockItem("raster_cyan_stained_glass", ModBlocks.RASTER_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_CYAN_STAINED_GLASS_CTM =
        registerBlockItem("raster_cyan_stained_glass_ctm", ModBlocks.RASTER_CYAN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_cyan_stained_glass_ctm_pane", ModBlocks.RASTER_CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_CYAN_STAINED_GLASS_PANE = registerBlockItem("raster_cyan_stained_glass_pane", ModBlocks.RASTER_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_GRAY_STAINED_GLASS =
        registerBlockItem("raster_gray_stained_glass", ModBlocks.RASTER_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("raster_gray_stained_glass_ctm", ModBlocks.RASTER_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_gray_stained_glass_ctm_pane", ModBlocks.RASTER_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_GRAY_STAINED_GLASS_PANE = registerBlockItem("raster_gray_stained_glass_pane", ModBlocks.RASTER_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_GREEN_STAINED_GLASS =
        registerBlockItem("raster_green_stained_glass", ModBlocks.RASTER_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_GREEN_STAINED_GLASS_CTM =
        registerBlockItem("raster_green_stained_glass_ctm", ModBlocks.RASTER_GREEN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("raster_green_stained_glass_ctm_pane", ModBlocks.RASTER_GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_GREEN_STAINED_GLASS_PANE = registerBlockItem("raster_green_stained_glass_pane", ModBlocks.RASTER_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LEADED_GLASS =
        registerBlockItem("raster_leaded_glass", ModBlocks.RASTER_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> RASTER_LEADED_GLASS_CTM =
        registerBlockItem("raster_leaded_glass_ctm", ModBlocks.RASTER_LEADED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> RASTER_LEADED_GLASS_CTM_PANE = registerBlockItem("raster_leaded_glass_ctm_pane", ModBlocks.RASTER_LEADED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> RASTER_LEADED_GLASS_PANE = registerBlockItem("raster_leaded_glass_pane", ModBlocks.RASTER_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_BLACK_WOOL =
        registerBlockItem("rectangle_black_wool", ModBlocks.RECTANGLE_BLACK_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_BLUE_WOOL =
        registerBlockItem("rectangle_blue_wool", ModBlocks.RECTANGLE_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_BROWN_WOOL =
        registerBlockItem("rectangle_brown_wool", ModBlocks.RECTANGLE_BROWN_WOOL);


    // ===== RECOVERED WAVE4 =====
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_CYAN_WOOL =
        registerBlockItem("rectangle_cyan_wool", ModBlocks.RECTANGLE_CYAN_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_GRAY_WOOL =
        registerBlockItem("rectangle_gray_wool", ModBlocks.RECTANGLE_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_GREEN_WOOL =
        registerBlockItem("rectangle_green_wool", ModBlocks.RECTANGLE_GREEN_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_LIGHT_BLUE_WOOL =
        registerBlockItem("rectangle_light_blue_wool", ModBlocks.RECTANGLE_LIGHT_BLUE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_LIGHT_GRAY_WOOL =
        registerBlockItem("rectangle_light_gray_wool", ModBlocks.RECTANGLE_LIGHT_GRAY_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_LIME_WOOL =
        registerBlockItem("rectangle_lime_wool", ModBlocks.RECTANGLE_LIME_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_MAGENTA_WOOL =
        registerBlockItem("rectangle_magenta_wool", ModBlocks.RECTANGLE_MAGENTA_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_ORANGE_WOOL =
        registerBlockItem("rectangle_orange_wool", ModBlocks.RECTANGLE_ORANGE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_PINK_WOOL =
        registerBlockItem("rectangle_pink_wool", ModBlocks.RECTANGLE_PINK_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_PURPLE_WOOL =
        registerBlockItem("rectangle_purple_wool", ModBlocks.RECTANGLE_PURPLE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_RED_WOOL =
        registerBlockItem("rectangle_red_wool", ModBlocks.RECTANGLE_RED_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_WHITE_WOOL =
        registerBlockItem("rectangle_white_wool", ModBlocks.RECTANGLE_WHITE_WOOL);
    public static final DeferredHolder<Item, BlockItem> RECTANGLE_YELLOW_WOOL =
        registerBlockItem("rectangle_yellow_wool", ModBlocks.RECTANGLE_YELLOW_WOOL);
    public static final DeferredHolder<Item, BlockItem> RED_ACACIA_LEAVES =
        registerBlockItem("red_acacia_leaves", ModBlocks.RED_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_BIRCH_LEAVES =
        registerBlockItem("red_birch_leaves", ModBlocks.RED_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_CONCRETE_CTM =
        registerBlockItem("red_concrete_ctm", ModBlocks.RED_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> RED_CONCRETE_PANEL =
        registerBlockItem("red_concrete_panel", ModBlocks.RED_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> RED_DARK_OAK_LEAVES =
        registerBlockItem("red_dark_oak_leaves", ModBlocks.RED_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_JUNGLE_LEAVES =
        registerBlockItem("red_jungle_leaves", ModBlocks.RED_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_BEAMS = registerBlockItem("red_nether_bricks_beams", ModBlocks.RED_NETHER_BRICKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_BRICK_PATTERN = registerBlockItem("red_nether_bricks_brick_pattern", ModBlocks.RED_NETHER_BRICKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_BRICK_PAVING = registerBlockItem("red_nether_bricks_brick_paving", ModBlocks.RED_NETHER_BRICKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_CHISELED_SQUARES = registerBlockItem("red_nether_bricks_chiseled_squares", ModBlocks.RED_NETHER_BRICKS_CHISELED_SQUARES);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_DIAGONAL_BRICKS = registerBlockItem("red_nether_bricks_diagonal_bricks", ModBlocks.RED_NETHER_BRICKS_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_LARGE_BRICKS = registerBlockItem("red_nether_bricks_large_bricks", ModBlocks.RED_NETHER_BRICKS_LARGE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_LARGE_TILES = registerBlockItem("red_nether_bricks_large_tiles", ModBlocks.RED_NETHER_BRICKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_ROTATED_BRICKS = registerBlockItem("red_nether_bricks_rotated_bricks", ModBlocks.RED_NETHER_BRICKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_SMALL_TILES = registerBlockItem("red_nether_bricks_small_tiles", ModBlocks.RED_NETHER_BRICKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_SMOOTH = registerBlockItem("red_nether_bricks_smooth", ModBlocks.RED_NETHER_BRICKS_SMOOTH);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_SQUARES = registerBlockItem("red_nether_bricks_squares", ModBlocks.RED_NETHER_BRICKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICKS_TILES = registerBlockItem("red_nether_bricks_tiles", ModBlocks.RED_NETHER_BRICKS_TILES);
    public static final DeferredHolder<Item, BlockItem> RED_OAK_LEAVES =
        registerBlockItem("red_oak_leaves", ModBlocks.RED_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_BRICK_PATTERN = registerBlockItem("red_sandstone_brick_pattern", ModBlocks.RED_SANDSTONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_BRICK_PAVING = registerBlockItem("red_sandstone_brick_paving", ModBlocks.RED_SANDSTONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_BRICKS = registerBlockItem("red_sandstone_bricks", ModBlocks.RED_SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_DIAGONAL_BRICKS = registerBlockItem("red_sandstone_diagonal_bricks", ModBlocks.RED_SANDSTONE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_LARGE_TILES = registerBlockItem("red_sandstone_large_tiles", ModBlocks.RED_SANDSTONE_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_POLISHED = registerBlockItem("red_sandstone_polished", ModBlocks.RED_SANDSTONE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_ROTATED_BRICKS = registerBlockItem("red_sandstone_rotated_bricks", ModBlocks.RED_SANDSTONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_TILES = registerBlockItem("red_sandstone_tiles", ModBlocks.RED_SANDSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> RED_SPRUCE_LEAVES =
        registerBlockItem("red_spruce_leaves", ModBlocks.RED_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> RED_TERRACOTTA_COLUMN =
        registerBlockItem("red_terracotta_column", ModBlocks.RED_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> RED_TERRACOTTA_CTM =
        registerBlockItem("red_terracotta_ctm", ModBlocks.RED_TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_BORDERED = registerBlockItem("redstone_block_bordered", ModBlocks.REDSTONE_BLOCK_BORDERED);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_BRICKS = registerBlockItem("redstone_block_bricks", ModBlocks.REDSTONE_BLOCK_BRICKS);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_CHISELED_CLOVERS = registerBlockItem("redstone_block_chiseled_clovers", ModBlocks.REDSTONE_BLOCK_CHISELED_CLOVERS);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_CIRCLES = registerBlockItem("redstone_block_circles", ModBlocks.REDSTONE_BLOCK_CIRCLES);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_COMPRESSED = registerBlockItem("redstone_block_compressed", ModBlocks.REDSTONE_BLOCK_COMPRESSED);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_CTM = registerBlockItem("redstone_block_ctm", ModBlocks.REDSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_DIAGONAL_TILES = registerBlockItem("redstone_block_diagonal_tiles", ModBlocks.REDSTONE_BLOCK_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_PATTERNED = registerBlockItem("redstone_block_patterned", ModBlocks.REDSTONE_BLOCK_PATTERNED);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_PAVING = registerBlockItem("redstone_block_paving", ModBlocks.REDSTONE_BLOCK_PAVING);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_POLISHED = registerBlockItem("redstone_block_polished", ModBlocks.REDSTONE_BLOCK_POLISHED);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_SCALES = registerBlockItem("redstone_block_scales", ModBlocks.REDSTONE_BLOCK_SCALES);
    public static final DeferredHolder<Item, BlockItem> REDSTONE_BLOCK_SMALL_TILES = registerBlockItem("redstone_block_small_tiles", ModBlocks.REDSTONE_BLOCK_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> ROSE_QUARTZ_BRICKS = registerBlockItem("rose_quartz_bricks", ModBlocks.ROSE_QUARTZ_BRICKS);
    public static final DeferredHolder<Item, BlockItem> ROSE_QUARTZ_CHISELED = registerBlockItem("rose_quartz_chiseled", ModBlocks.ROSE_QUARTZ_CHISELED);
    public static final DeferredHolder<Item, BlockItem> ROSE_QUARTZ_CRUSHED = registerBlockItem("rose_quartz_crushed", ModBlocks.ROSE_QUARTZ_CRUSHED);
    public static final DeferredHolder<Item, BlockItem> ROSE_QUARTZ_POLISHED_BLOCK = registerBlockItem("rose_quartz_polished_block", ModBlocks.ROSE_QUARTZ_POLISHED_BLOCK);
    public static final DeferredHolder<Item, BlockItem> ROSE_QUARTZ_SQUARES = registerBlockItem("rose_quartz_squares", ModBlocks.ROSE_QUARTZ_SQUARES);
    public static final DeferredHolder<Item, BlockItem> ROSE_QUARTZ_TILES = registerBlockItem("rose_quartz_tiles", ModBlocks.ROSE_QUARTZ_TILES);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_BRICK_PATTERN = registerBlockItem("sandstone_brick_pattern", ModBlocks.SANDSTONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_BRICK_PAVING = registerBlockItem("sandstone_brick_paving", ModBlocks.SANDSTONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_BRICKS = registerBlockItem("sandstone_bricks", ModBlocks.SANDSTONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_DIAGONAL_BRICKS = registerBlockItem("sandstone_diagonal_bricks", ModBlocks.SANDSTONE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_LARGE_TILES = registerBlockItem("sandstone_large_tiles", ModBlocks.SANDSTONE_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_POLISHED = registerBlockItem("sandstone_polished", ModBlocks.SANDSTONE_POLISHED);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_ROTATED_BRICKS = registerBlockItem("sandstone_rotated_bricks", ModBlocks.SANDSTONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_TILES = registerBlockItem("sandstone_tiles", ModBlocks.SANDSTONE_TILES);
    public static final DeferredHolder<Item, BlockItem> SCALY_MUD =
        registerBlockItem("scaly_mud", ModBlocks.SCALY_MUD);
    public static final DeferredHolder<Item, BlockItem> SCALY_PACKED_MUD =
        registerBlockItem("scaly_packed_mud", ModBlocks.SCALY_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> SCORCHIA_CUT_POLISHED = registerBlockItem("scorchia_cut_polished", ModBlocks.SCORCHIA_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> SCORCHIA_CUT_SMALL_BRICK = registerBlockItem("scorchia_cut_small_brick", ModBlocks.SCORCHIA_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> SCORIA_CUT_POLISHED = registerBlockItem("scoria_cut_polished", ModBlocks.SCORIA_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> SCORIA_CUT_SMALL_BRICK = registerBlockItem("scoria_cut_small_brick", ModBlocks.SCORIA_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_AMETHYST_BLOCK_CTM =
        registerBlockItem("simple_amethyst_block_ctm", ModBlocks.SIMPLE_AMETHYST_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_ANCIENT_DEBRIS_CTM =
        registerBlockItem("simple_ancient_debris_ctm", ModBlocks.SIMPLE_ANCIENT_DEBRIS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_ANDESITE_CTM =
        registerBlockItem("simple_andesite_ctm", ModBlocks.SIMPLE_ANDESITE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BASALT_CTM =
        registerBlockItem("simple_basalt_ctm", ModBlocks.SIMPLE_BASALT_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BLACKSTONE_CTM =
        registerBlockItem("simple_blackstone_ctm", ModBlocks.SIMPLE_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BLUE_ICE_CTM =
        registerBlockItem("simple_blue_ice_ctm", ModBlocks.SIMPLE_BLUE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BORDERLESS_BRICKS_CTM =
        registerBlockItem("simple_borderless_bricks_ctm", ModBlocks.SIMPLE_BORDERLESS_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_BRICKS_CTM =
        registerBlockItem("simple_bricks_ctm", ModBlocks.SIMPLE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_CALCITE_CTM =
        registerBlockItem("simple_calcite_ctm", ModBlocks.SIMPLE_CALCITE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_CLAY_CTM =
        registerBlockItem("simple_clay_ctm", ModBlocks.SIMPLE_CLAY_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_COAL_BLOCK_CTM =
        registerBlockItem("simple_coal_block_ctm", ModBlocks.SIMPLE_COAL_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_COBBLESTONE_CTM =
        registerBlockItem("simple_cobblestone_ctm", ModBlocks.SIMPLE_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_CRYING_OBSIDIAN_CTM =
        registerBlockItem("simple_crying_obsidian_ctm", ModBlocks.SIMPLE_CRYING_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DARK_PRISMARINE_CTM =
        registerBlockItem("simple_dark_prismarine_ctm", ModBlocks.SIMPLE_DARK_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DEEPSLATE_CTM =
        registerBlockItem("simple_deepslate_ctm", ModBlocks.SIMPLE_DEEPSLATE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DIORITE_CTM =
        registerBlockItem("simple_diorite_ctm", ModBlocks.SIMPLE_DIORITE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DIRT_CTM =
        registerBlockItem("simple_dirt_ctm", ModBlocks.SIMPLE_DIRT_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_DRIPSTONE_BLOCK_CTM =
        registerBlockItem("simple_dripstone_block_ctm", ModBlocks.SIMPLE_DRIPSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_END_STONE_CTM =
        registerBlockItem("simple_end_stone_ctm", ModBlocks.SIMPLE_END_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_GILDED_BLACKSTONE_CTM =
        registerBlockItem("simple_gilded_blackstone_ctm", ModBlocks.SIMPLE_GILDED_BLACKSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_ICE_CTM =
        registerBlockItem("simple_ice_ctm", ModBlocks.SIMPLE_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_LAPIS_BLOCK_CTM =
        registerBlockItem("simple_lapis_block_ctm", ModBlocks.SIMPLE_LAPIS_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_LODESTONE_CTM =
        registerBlockItem("simple_lodestone_ctm", ModBlocks.SIMPLE_LODESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MAGMA_BLOCK_CTM =
        registerBlockItem("simple_magma_block_ctm", ModBlocks.SIMPLE_MAGMA_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MOSSY_COBBLESTONE_CTM =
        registerBlockItem("simple_mossy_cobblestone_ctm", ModBlocks.SIMPLE_MOSSY_COBBLESTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MOSSY_STONE_BRICKS_CTM =
        registerBlockItem("simple_mossy_stone_bricks_ctm", ModBlocks.SIMPLE_MOSSY_STONE_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MUD_BRICKS_CTM =
        registerBlockItem("simple_mud_bricks_ctm", ModBlocks.SIMPLE_MUD_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_MUD_CTM =
        registerBlockItem("simple_mud_ctm", ModBlocks.SIMPLE_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_NETHER_BRICKS_CTM =
        registerBlockItem("simple_nether_bricks_ctm", ModBlocks.SIMPLE_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_NETHERRACK_CTM =
        registerBlockItem("simple_netherrack_ctm", ModBlocks.SIMPLE_NETHERRACK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_OBSIDIAN_CTM =
        registerBlockItem("simple_obsidian_ctm", ModBlocks.SIMPLE_OBSIDIAN_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PACKED_ICE_CTM =
        registerBlockItem("simple_packed_ice_ctm", ModBlocks.SIMPLE_PACKED_ICE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PACKED_MUD_CTM =
        registerBlockItem("simple_packed_mud_ctm", ModBlocks.SIMPLE_PACKED_MUD_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PRISMARINE_CTM =
        registerBlockItem("simple_prismarine_ctm", ModBlocks.SIMPLE_PRISMARINE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_PURPUR_BLOCK_CTM =
        registerBlockItem("simple_purpur_block_ctm", ModBlocks.SIMPLE_PURPUR_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_QUARTZ_BLOCK_CTM =
        registerBlockItem("simple_quartz_block_ctm", ModBlocks.SIMPLE_QUARTZ_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RAW_COPPER_BLOCK_CTM =
        registerBlockItem("simple_raw_copper_block_ctm", ModBlocks.SIMPLE_RAW_COPPER_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RAW_GOLD_BLOCK_CTM =
        registerBlockItem("simple_raw_gold_block_ctm", ModBlocks.SIMPLE_RAW_GOLD_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RAW_IRON_BLOCK_CTM =
        registerBlockItem("simple_raw_iron_block_ctm", ModBlocks.SIMPLE_RAW_IRON_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RED_NETHER_BRICKS_CTM =
        registerBlockItem("simple_red_nether_bricks_ctm", ModBlocks.SIMPLE_RED_NETHER_BRICKS_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_RED_SANDSTONE_CTM =
        registerBlockItem("simple_red_sandstone_ctm", ModBlocks.SIMPLE_RED_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_REDSTONE_BLOCK_CTM =
        registerBlockItem("simple_redstone_block_ctm", ModBlocks.SIMPLE_REDSTONE_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_SANDSTONE_CTM =
        registerBlockItem("simple_sandstone_ctm", ModBlocks.SIMPLE_SANDSTONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_SMOOTH_STONE_CTM =
        registerBlockItem("simple_smooth_stone_ctm", ModBlocks.SIMPLE_SMOOTH_STONE_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_SNOW_BLOCK_CTM =
        registerBlockItem("simple_snow_block_ctm", ModBlocks.SIMPLE_SNOW_BLOCK_CTM);
    public static final DeferredHolder<Item, BlockItem> SIMPLE_TUFF_CTM =
        registerBlockItem("simple_tuff_ctm", ModBlocks.SIMPLE_TUFF_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_black_diamond_stained_glass", ModBlocks.SMALL_BLACK_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_black_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_BLACK_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_STAINED_GLASS =
        registerBlockItem("small_black_stained_glass", ModBlocks.SMALL_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_STAINED_GLASS_PANE = registerBlockItem("small_black_stained_glass_pane", ModBlocks.SMALL_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_TERRACOTTA_TILES =
        registerBlockItem("small_black_terracotta_tiles", ModBlocks.SMALL_BLACK_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_blue_diamond_stained_glass", ModBlocks.SMALL_BLUE_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_blue_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_STAINED_GLASS =
        registerBlockItem("small_blue_stained_glass", ModBlocks.SMALL_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_STAINED_GLASS_PANE = registerBlockItem("small_blue_stained_glass_pane", ModBlocks.SMALL_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_TERRACOTTA_TILES =
        registerBlockItem("small_blue_terracotta_tiles", ModBlocks.SMALL_BLUE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_brown_diamond_stained_glass", ModBlocks.SMALL_BROWN_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_brown_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_BROWN_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_STAINED_GLASS =
        registerBlockItem("small_brown_stained_glass", ModBlocks.SMALL_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_STAINED_GLASS_PANE = registerBlockItem("small_brown_stained_glass_pane", ModBlocks.SMALL_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_TERRACOTTA_TILES =
        registerBlockItem("small_brown_terracotta_tiles", ModBlocks.SMALL_BROWN_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_cyan_diamond_stained_glass", ModBlocks.SMALL_CYAN_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_cyan_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_CYAN_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_STAINED_GLASS =
        registerBlockItem("small_cyan_stained_glass", ModBlocks.SMALL_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_STAINED_GLASS_PANE = registerBlockItem("small_cyan_stained_glass_pane", ModBlocks.SMALL_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_TERRACOTTA_TILES =
        registerBlockItem("small_cyan_terracotta_tiles", ModBlocks.SMALL_CYAN_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_DIAMOND_LEADED_GLASS =
        registerBlockItem("small_diamond_leaded_glass", ModBlocks.SMALL_DIAMOND_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_DIAMOND_LEADED_GLASS_CTM =
        registerBlockItem("small_diamond_leaded_glass_ctm", ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SMALL_DIAMOND_LEADED_GLASS_CTM_PANE = registerBlockItem("small_diamond_leaded_glass_ctm_pane", ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_DIAMOND_LEADED_GLASS_PANE = registerBlockItem("small_diamond_leaded_glass_pane", ModBlocks.SMALL_DIAMOND_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_gray_diamond_stained_glass", ModBlocks.SMALL_GRAY_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_gray_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_STAINED_GLASS =
        registerBlockItem("small_gray_stained_glass", ModBlocks.SMALL_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_STAINED_GLASS_PANE = registerBlockItem("small_gray_stained_glass_pane", ModBlocks.SMALL_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_TERRACOTTA_TILES =
        registerBlockItem("small_gray_terracotta_tiles", ModBlocks.SMALL_GRAY_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_DIAMOND_STAINED_GLASS =
        registerBlockItem("small_green_diamond_stained_glass", ModBlocks.SMALL_GREEN_DIAMOND_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_DIAMOND_STAINED_GLASS_CTM_PANE = registerBlockItem("small_green_diamond_stained_glass_ctm_pane", ModBlocks.SMALL_GREEN_DIAMOND_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_STAINED_GLASS =
        registerBlockItem("small_green_stained_glass", ModBlocks.SMALL_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_STAINED_GLASS_PANE = registerBlockItem("small_green_stained_glass_pane", ModBlocks.SMALL_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_TERRACOTTA_TILES =
        registerBlockItem("small_green_terracotta_tiles", ModBlocks.SMALL_GREEN_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_TERRACOTTA_TILES =
        registerBlockItem("small_light_blue_terracotta_tiles", ModBlocks.SMALL_LIGHT_BLUE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_TERRACOTTA_TILES =
        registerBlockItem("small_light_gray_terracotta_tiles", ModBlocks.SMALL_LIGHT_GRAY_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_TERRACOTTA_TILES =
        registerBlockItem("small_lime_terracotta_tiles", ModBlocks.SMALL_LIME_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_TERRACOTTA_TILES =
        registerBlockItem("small_magenta_terracotta_tiles", ModBlocks.SMALL_MAGENTA_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_TERRACOTTA_TILES =
        registerBlockItem("small_orange_terracotta_tiles", ModBlocks.SMALL_ORANGE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_TERRACOTTA_TILES =
        registerBlockItem("small_pink_terracotta_tiles", ModBlocks.SMALL_PINK_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_TERRACOTTA_TILES =
        registerBlockItem("small_purple_terracotta_tiles", ModBlocks.SMALL_PURPLE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_TERRACOTTA_TILES =
        registerBlockItem("small_red_terracotta_tiles", ModBlocks.SMALL_RED_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_TERRACOTTA_TILES =
        registerBlockItem("small_terracotta_tiles", ModBlocks.SMALL_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_TERRACOTTA_TILES =
        registerBlockItem("small_white_terracotta_tiles", ModBlocks.SMALL_WHITE_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_TERRACOTTA_TILES =
        registerBlockItem("small_yellow_terracotta_tiles", ModBlocks.SMALL_YELLOW_TERRACOTTA_TILES);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_AMETHYST_BLOCK_COLUMN =
        registerBlockItem("smooth_amethyst_block_column", ModBlocks.SMOOTH_AMETHYST_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ANCIENT_DEBRIS_COLUMN =
        registerBlockItem("smooth_ancient_debris_column", ModBlocks.SMOOTH_ANCIENT_DEBRIS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ANDESITE_COLUMN =
        registerBlockItem("smooth_andesite_column", ModBlocks.SMOOTH_ANDESITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BASALT_COLUMN =
        registerBlockItem("smooth_basalt_column", ModBlocks.SMOOTH_BASALT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLACK_CONCRETE =
        registerBlockItem("smooth_black_concrete", ModBlocks.SMOOTH_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLACKSTONE_COLUMN =
        registerBlockItem("smooth_blackstone_column", ModBlocks.SMOOTH_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLUE_CONCRETE =
        registerBlockItem("smooth_blue_concrete", ModBlocks.SMOOTH_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BLUE_ICE_COLUMN =
        registerBlockItem("smooth_blue_ice_column", ModBlocks.SMOOTH_BLUE_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BORDERLESS_BRICKS_COLUMN =
        registerBlockItem("smooth_borderless_bricks_column", ModBlocks.SMOOTH_BORDERLESS_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BRICKS_COLUMN =
        registerBlockItem("smooth_bricks_column", ModBlocks.SMOOTH_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_BROWN_CONCRETE =
        registerBlockItem("smooth_brown_concrete", ModBlocks.SMOOTH_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CALCITE_COLUMN =
        registerBlockItem("smooth_calcite_column", ModBlocks.SMOOTH_CALCITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CLAY_COLUMN =
        registerBlockItem("smooth_clay_column", ModBlocks.SMOOTH_CLAY_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_COAL_BLOCK_COLUMN =
        registerBlockItem("smooth_coal_block_column", ModBlocks.SMOOTH_COAL_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_COBBLESTONE_COLUMN =
        registerBlockItem("smooth_cobblestone_column", ModBlocks.SMOOTH_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CRYING_OBSIDIAN_COLUMN =
        registerBlockItem("smooth_crying_obsidian_column", ModBlocks.SMOOTH_CRYING_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_CYAN_CONCRETE =
        registerBlockItem("smooth_cyan_concrete", ModBlocks.SMOOTH_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DARK_PRISMARINE_COLUMN =
        registerBlockItem("smooth_dark_prismarine_column", ModBlocks.SMOOTH_DARK_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DEEPSLATE_COLUMN =
        registerBlockItem("smooth_deepslate_column", ModBlocks.SMOOTH_DEEPSLATE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DIORITE_COLUMN =
        registerBlockItem("smooth_diorite_column", ModBlocks.SMOOTH_DIORITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DIRT_COLUMN =
        registerBlockItem("smooth_dirt_column", ModBlocks.SMOOTH_DIRT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_DRIPSTONE_BLOCK_COLUMN =
        registerBlockItem("smooth_dripstone_block_column", ModBlocks.SMOOTH_DRIPSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_END_STONE_COLUMN =
        registerBlockItem("smooth_end_stone_column", ModBlocks.SMOOTH_END_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GILDED_BLACKSTONE_COLUMN =
        registerBlockItem("smooth_gilded_blackstone_column", ModBlocks.SMOOTH_GILDED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GRAY_CONCRETE =
        registerBlockItem("smooth_gray_concrete", ModBlocks.SMOOTH_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_GREEN_CONCRETE =
        registerBlockItem("smooth_green_concrete", ModBlocks.SMOOTH_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ICE_COLUMN =
        registerBlockItem("smooth_ice_column", ModBlocks.SMOOTH_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LAPIS_BLOCK_COLUMN =
        registerBlockItem("smooth_lapis_block_column", ModBlocks.SMOOTH_LAPIS_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LIGHT_BLUE_CONCRETE =
        registerBlockItem("smooth_light_blue_concrete", ModBlocks.SMOOTH_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LIGHT_GRAY_CONCRETE =
        registerBlockItem("smooth_light_gray_concrete", ModBlocks.SMOOTH_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LIME_CONCRETE =
        registerBlockItem("smooth_lime_concrete", ModBlocks.SMOOTH_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_LODESTONE_COLUMN =
        registerBlockItem("smooth_lodestone_column", ModBlocks.SMOOTH_LODESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MAGENTA_CONCRETE =
        registerBlockItem("smooth_magenta_concrete", ModBlocks.SMOOTH_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MAGMA_BLOCK_COLUMN =
        registerBlockItem("smooth_magma_block_column", ModBlocks.SMOOTH_MAGMA_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MOSSY_COBBLESTONE_COLUMN =
        registerBlockItem("smooth_mossy_cobblestone_column", ModBlocks.SMOOTH_MOSSY_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_MOSSY_STONE_BRICKS_COLUMN =
        registerBlockItem("smooth_mossy_stone_bricks_column", ModBlocks.SMOOTH_MOSSY_STONE_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_NETHER_BRICKS_COLUMN =
        registerBlockItem("smooth_nether_bricks_column", ModBlocks.SMOOTH_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_NETHERRACK_COLUMN =
        registerBlockItem("smooth_netherrack_column", ModBlocks.SMOOTH_NETHERRACK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_OBSIDIAN_COLUMN =
        registerBlockItem("smooth_obsidian_column", ModBlocks.SMOOTH_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_ORANGE_CONCRETE =
        registerBlockItem("smooth_orange_concrete", ModBlocks.SMOOTH_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PACKED_ICE_COLUMN =
        registerBlockItem("smooth_packed_ice_column", ModBlocks.SMOOTH_PACKED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PINK_CONCRETE =
        registerBlockItem("smooth_pink_concrete", ModBlocks.SMOOTH_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PRISMARINE_COLUMN =
        registerBlockItem("smooth_prismarine_column", ModBlocks.SMOOTH_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PURPLE_CONCRETE =
        registerBlockItem("smooth_purple_concrete", ModBlocks.SMOOTH_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_PURPUR_BLOCK_COLUMN =
        registerBlockItem("smooth_purpur_block_column", ModBlocks.SMOOTH_PURPUR_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_QUARTZ_BLOCK_COLUMN =
        registerBlockItem("smooth_quartz_block_column", ModBlocks.SMOOTH_QUARTZ_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RAW_COPPER_BLOCK_COLUMN =
        registerBlockItem("smooth_raw_copper_block_column", ModBlocks.SMOOTH_RAW_COPPER_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RAW_GOLD_BLOCK_COLUMN =
        registerBlockItem("smooth_raw_gold_block_column", ModBlocks.SMOOTH_RAW_GOLD_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RAW_IRON_BLOCK_COLUMN =
        registerBlockItem("smooth_raw_iron_block_column", ModBlocks.SMOOTH_RAW_IRON_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_CONCRETE =
        registerBlockItem("smooth_red_concrete", ModBlocks.SMOOTH_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_NETHER_BRICKS_COLUMN =
        registerBlockItem("smooth_red_nether_bricks_column", ModBlocks.SMOOTH_RED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_SANDSTONE_COLUMN =
        registerBlockItem("smooth_red_sandstone_column", ModBlocks.SMOOTH_RED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_REDSTONE_BLOCK_COLUMN =
        registerBlockItem("smooth_redstone_block_column", ModBlocks.SMOOTH_REDSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SANDSTONE_COLUMN =
        registerBlockItem("smooth_sandstone_column", ModBlocks.SMOOTH_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SMOOTH_STONE_COLUMN =
        registerBlockItem("smooth_smooth_stone_column", ModBlocks.SMOOTH_SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SNOW_BLOCK_COLUMN =
        registerBlockItem("smooth_snow_block_column", ModBlocks.SMOOTH_SNOW_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_TUFF_COLUMN =
        registerBlockItem("smooth_tuff_column", ModBlocks.SMOOTH_TUFF_COLUMN);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_WHITE_CONCRETE =
        registerBlockItem("smooth_white_concrete", ModBlocks.SMOOTH_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SMOOTH_YELLOW_CONCRETE =
        registerBlockItem("smooth_yellow_concrete", ModBlocks.SMOOTH_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_BEAMS = registerBlockItem("spruce_planks_beams", ModBlocks.SPRUCE_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_BRICK_PATTERN = registerBlockItem("spruce_planks_brick_pattern", ModBlocks.SPRUCE_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_BRICK_PAVING = registerBlockItem("spruce_planks_brick_paving", ModBlocks.SPRUCE_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_BRICKS = registerBlockItem("spruce_planks_bricks", ModBlocks.SPRUCE_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_CRATE = registerBlockItem("spruce_planks_crate", ModBlocks.SPRUCE_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_DIAGONAL_STRIPES = registerBlockItem("spruce_planks_diagonal_stripes", ModBlocks.SPRUCE_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_DIAGONAL_TILES = registerBlockItem("spruce_planks_diagonal_tiles", ModBlocks.SPRUCE_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_DOTTED = registerBlockItem("spruce_planks_dotted", ModBlocks.SPRUCE_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_FLOORING = registerBlockItem("spruce_planks_flooring", ModBlocks.SPRUCE_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_LARGE_TILES = registerBlockItem("spruce_planks_large_tiles", ModBlocks.SPRUCE_PLANKS_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_PANEL =
        registerBlockItem("spruce_planks_panel", ModBlocks.SPRUCE_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_PATTERN = registerBlockItem("spruce_planks_pattern", ModBlocks.SPRUCE_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_ROTATED_BRICKS = registerBlockItem("spruce_planks_rotated_bricks", ModBlocks.SPRUCE_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_SMALL_BRICKS = registerBlockItem("spruce_planks_small_bricks", ModBlocks.SPRUCE_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_SMALL_TILES = registerBlockItem("spruce_planks_small_tiles", ModBlocks.SPRUCE_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_SQUARES = registerBlockItem("spruce_planks_squares", ModBlocks.SPRUCE_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_TILES = registerBlockItem("spruce_planks_tiles", ModBlocks.SPRUCE_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_WAVY = registerBlockItem("spruce_planks_wavy", ModBlocks.SPRUCE_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_PLANKS_WOVEN = registerBlockItem("spruce_planks_woven", ModBlocks.SPRUCE_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_BARS = registerBlockItem("spruce_window_bars", ModBlocks.SPRUCE_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_BARS_CTM = registerBlockItem("spruce_window_bars_ctm", ModBlocks.SPRUCE_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_COVERED = registerBlockItem("spruce_window_covered", ModBlocks.SPRUCE_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_COVERED_CTM = registerBlockItem("spruce_window_covered_ctm", ModBlocks.SPRUCE_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_DIAGONAL = registerBlockItem("spruce_window_diagonal", ModBlocks.SPRUCE_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_DIAGONAL_CTM = registerBlockItem("spruce_window_diagonal_ctm", ModBlocks.SPRUCE_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_LARGE = registerBlockItem("spruce_window_large", ModBlocks.SPRUCE_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_LARGE_CTM = registerBlockItem("spruce_window_large_ctm", ModBlocks.SPRUCE_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_PANES = registerBlockItem("spruce_window_panes", ModBlocks.SPRUCE_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_PANES_CTM = registerBlockItem("spruce_window_panes_ctm", ModBlocks.SPRUCE_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_ROUNDED = registerBlockItem("spruce_window_rounded", ModBlocks.SPRUCE_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_ROUNDED_CTM = registerBlockItem("spruce_window_rounded_ctm", ModBlocks.SPRUCE_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SLIM = registerBlockItem("spruce_window_slim", ModBlocks.SPRUCE_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SLIM_CTM = registerBlockItem("spruce_window_slim_ctm", ModBlocks.SPRUCE_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SWIRLING = registerBlockItem("spruce_window_swirling", ModBlocks.SPRUCE_WINDOW_SWIRLING);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SWIRLING_CTM = registerBlockItem("spruce_window_swirling_ctm", ModBlocks.SPRUCE_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("spruce_window_swirling_ctm_pane", ModBlocks.SPRUCE_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_TILES = registerBlockItem("spruce_window_tiles", ModBlocks.SPRUCE_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_WINDOW_TILES_CTM = registerBlockItem("spruce_window_tiles_ctm", ModBlocks.SPRUCE_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> SQUARE_BLACK_STAINED_GLASS =
        registerBlockItem("square_black_stained_glass", ModBlocks.SQUARE_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_BLACK_STAINED_GLASS_PANE = registerBlockItem("square_black_stained_glass_pane", ModBlocks.SQUARE_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_BLUE_STAINED_GLASS =
        registerBlockItem("square_blue_stained_glass", ModBlocks.SQUARE_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_BLUE_STAINED_GLASS_PANE = registerBlockItem("square_blue_stained_glass_pane", ModBlocks.SQUARE_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_BROWN_STAINED_GLASS =
        registerBlockItem("square_brown_stained_glass", ModBlocks.SQUARE_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_BROWN_STAINED_GLASS_PANE = registerBlockItem("square_brown_stained_glass_pane", ModBlocks.SQUARE_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_CYAN_STAINED_GLASS =
        registerBlockItem("square_cyan_stained_glass", ModBlocks.SQUARE_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_CYAN_STAINED_GLASS_PANE = registerBlockItem("square_cyan_stained_glass_pane", ModBlocks.SQUARE_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_GRAY_STAINED_GLASS =
        registerBlockItem("square_gray_stained_glass", ModBlocks.SQUARE_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_GRAY_STAINED_GLASS_PANE = registerBlockItem("square_gray_stained_glass_pane", ModBlocks.SQUARE_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_GREEN_STAINED_GLASS =
        registerBlockItem("square_green_stained_glass", ModBlocks.SQUARE_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_GREEN_STAINED_GLASS_PANE = registerBlockItem("square_green_stained_glass_pane", ModBlocks.SQUARE_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LEADED_GLASS =
        registerBlockItem("square_leaded_glass", ModBlocks.SQUARE_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_LEADED_GLASS_PANE = registerBlockItem("square_leaded_glass_pane", ModBlocks.SQUARE_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> SQUARE_OAK_GLASS = registerBlockItem("square_oak_glass", ModBlocks.SQUARE_OAK_GLASS);
    public static final DeferredHolder<Item, BlockItem> SQUARE_OAK_GLASS_CTM =
        registerBlockItem("square_oak_glass_ctm", ModBlocks.SQUARE_OAK_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> SQUARE_OAK_GLASS_CTM_PANE = registerBlockItem("square_oak_glass_ctm_pane", ModBlocks.SQUARE_OAK_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> STARRY_BLACK_TERRACOTTA =
        registerBlockItem("starry_black_terracotta", ModBlocks.STARRY_BLACK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_BLUE_TERRACOTTA =
        registerBlockItem("starry_blue_terracotta", ModBlocks.STARRY_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_BROWN_TERRACOTTA =
        registerBlockItem("starry_brown_terracotta", ModBlocks.STARRY_BROWN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_CYAN_TERRACOTTA =
        registerBlockItem("starry_cyan_terracotta", ModBlocks.STARRY_CYAN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_GRAY_TERRACOTTA =
        registerBlockItem("starry_gray_terracotta", ModBlocks.STARRY_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_GREEN_TERRACOTTA =
        registerBlockItem("starry_green_terracotta", ModBlocks.STARRY_GREEN_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_LIGHT_BLUE_TERRACOTTA =
        registerBlockItem("starry_light_blue_terracotta", ModBlocks.STARRY_LIGHT_BLUE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_LIGHT_GRAY_TERRACOTTA =
        registerBlockItem("starry_light_gray_terracotta", ModBlocks.STARRY_LIGHT_GRAY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_LIME_TERRACOTTA =
        registerBlockItem("starry_lime_terracotta", ModBlocks.STARRY_LIME_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_MAGENTA_TERRACOTTA =
        registerBlockItem("starry_magenta_terracotta", ModBlocks.STARRY_MAGENTA_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_ORANGE_TERRACOTTA =
        registerBlockItem("starry_orange_terracotta", ModBlocks.STARRY_ORANGE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_PINK_TERRACOTTA =
        registerBlockItem("starry_pink_terracotta", ModBlocks.STARRY_PINK_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_PURPLE_TERRACOTTA =
        registerBlockItem("starry_purple_terracotta", ModBlocks.STARRY_PURPLE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_RED_TERRACOTTA =
        registerBlockItem("starry_red_terracotta", ModBlocks.STARRY_RED_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_TERRACOTTA =
        registerBlockItem("starry_terracotta", ModBlocks.STARRY_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_WHITE_TERRACOTTA =
        registerBlockItem("starry_white_terracotta", ModBlocks.STARRY_WHITE_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STARRY_YELLOW_TERRACOTTA =
        registerBlockItem("starry_yellow_terracotta", ModBlocks.STARRY_YELLOW_TERRACOTTA);
    public static final DeferredHolder<Item, BlockItem> STONE_BIG_TILES = registerBlockItem("stone_big_tiles", ModBlocks.STONE_BIG_TILES);
    public static final DeferredHolder<Item, BlockItem> STONE_BORDERED = registerBlockItem("stone_bordered", ModBlocks.STONE_BORDERED);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICK_PATTERN = registerBlockItem("stone_brick_pattern", ModBlocks.STONE_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> STONE_BRICK_PAVING = registerBlockItem("stone_brick_paving", ModBlocks.STONE_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> STONE_CHISELED_BRICKS = registerBlockItem("stone_chiseled_bricks", ModBlocks.STONE_CHISELED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> STONE_CRUSHED = registerBlockItem("stone_crushed", ModBlocks.STONE_CRUSHED);
    public static final DeferredHolder<Item, BlockItem> STONE_DIAGONAL_BRICKS = registerBlockItem("stone_diagonal_bricks", ModBlocks.STONE_DIAGONAL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> STONE_PATH = registerBlockItem("stone_path", ModBlocks.STONE_PATH);
    public static final DeferredHolder<Item, BlockItem> STONE_ROTATED_BRICKS = registerBlockItem("stone_rotated_bricks", ModBlocks.STONE_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> STONE_SLATED_END = registerBlockItem("stone_slated_end", ModBlocks.STONE_SLATED_END);
    public static final DeferredHolder<Item, BlockItem> STONE_SMALL_BRICKS = registerBlockItem("stone_small_bricks", ModBlocks.STONE_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> STONE_SMALL_TILES = registerBlockItem("stone_small_tiles", ModBlocks.STONE_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> STONE_SMOOTH = registerBlockItem("stone_smooth", ModBlocks.STONE_SMOOTH);
    public static final DeferredHolder<Item, BlockItem> STONE_SMOOTH_BRICK_PAVING = registerBlockItem("stone_smooth_brick_paving", ModBlocks.STONE_SMOOTH_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> STONE_SMOOTH_LARGE_TILES = registerBlockItem("stone_smooth_large_tiles", ModBlocks.STONE_SMOOTH_LARGE_TILES);
    public static final DeferredHolder<Item, BlockItem> STONE_SMOOTH_ROTATED_BRICKS = registerBlockItem("stone_smooth_rotated_bricks", ModBlocks.STONE_SMOOTH_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> STONE_SMOOTH_TILES = registerBlockItem("stone_smooth_tiles", ModBlocks.STONE_SMOOTH_TILES);
    public static final DeferredHolder<Item, BlockItem> STONE_SQUARES = registerBlockItem("stone_squares", ModBlocks.STONE_SQUARES);
    public static final DeferredHolder<Item, BlockItem> STONE_TILES = registerBlockItem("stone_tiles", ModBlocks.STONE_TILES);
    public static final DeferredHolder<Item, BlockItem> STONE_WAVES = registerBlockItem("stone_waves", ModBlocks.STONE_WAVES);
    public static final DeferredHolder<Item, BlockItem> STRIPED_BLACK_CONCRETE =
        registerBlockItem("striped_black_concrete", ModBlocks.STRIPED_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_BLUE_CONCRETE =
        registerBlockItem("striped_blue_concrete", ModBlocks.STRIPED_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_BROWN_CONCRETE =
        registerBlockItem("striped_brown_concrete", ModBlocks.STRIPED_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_CYAN_CONCRETE =
        registerBlockItem("striped_cyan_concrete", ModBlocks.STRIPED_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_GRAY_CONCRETE =
        registerBlockItem("striped_gray_concrete", ModBlocks.STRIPED_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_GREEN_CONCRETE =
        registerBlockItem("striped_green_concrete", ModBlocks.STRIPED_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_LIGHT_BLUE_CONCRETE =
        registerBlockItem("striped_light_blue_concrete", ModBlocks.STRIPED_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_LIGHT_GRAY_CONCRETE =
        registerBlockItem("striped_light_gray_concrete", ModBlocks.STRIPED_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_LIME_CONCRETE =
        registerBlockItem("striped_lime_concrete", ModBlocks.STRIPED_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_MAGENTA_CONCRETE =
        registerBlockItem("striped_magenta_concrete", ModBlocks.STRIPED_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_ORANGE_CONCRETE =
        registerBlockItem("striped_orange_concrete", ModBlocks.STRIPED_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_PINK_CONCRETE =
        registerBlockItem("striped_pink_concrete", ModBlocks.STRIPED_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_PURPLE_CONCRETE =
        registerBlockItem("striped_purple_concrete", ModBlocks.STRIPED_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_RED_CONCRETE =
        registerBlockItem("striped_red_concrete", ModBlocks.STRIPED_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_WHITE_CONCRETE =
        registerBlockItem("striped_white_concrete", ModBlocks.STRIPED_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> STRIPED_YELLOW_CONCRETE =
        registerBlockItem("striped_yellow_concrete", ModBlocks.STRIPED_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> TERRACOTTA_COLUMN =
        registerBlockItem("terracotta_column", ModBlocks.TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TERRACOTTA_CTM =
        registerBlockItem("terracotta_ctm", ModBlocks.TERRACOTTA_CTM);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_AMETHYST_BLOCK =
        registerBlockItem("thick_inlayed_amethyst_block", ModBlocks.THICK_INLAYED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_ANCIENT_DEBRIS =
        registerBlockItem("thick_inlayed_ancient_debris", ModBlocks.THICK_INLAYED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_ANDESITE =
        registerBlockItem("thick_inlayed_andesite", ModBlocks.THICK_INLAYED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BASALT =
        registerBlockItem("thick_inlayed_basalt", ModBlocks.THICK_INLAYED_BASALT);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BLACKSTONE =
        registerBlockItem("thick_inlayed_blackstone", ModBlocks.THICK_INLAYED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BLUE_ICE =
        registerBlockItem("thick_inlayed_blue_ice", ModBlocks.THICK_INLAYED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BORDERLESS_BRICKS =
        registerBlockItem("thick_inlayed_borderless_bricks", ModBlocks.THICK_INLAYED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_BRICKS =
        registerBlockItem("thick_inlayed_bricks", ModBlocks.THICK_INLAYED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_CALCITE =
        registerBlockItem("thick_inlayed_calcite", ModBlocks.THICK_INLAYED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_CLAY =
        registerBlockItem("thick_inlayed_clay", ModBlocks.THICK_INLAYED_CLAY);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_COAL_BLOCK =
        registerBlockItem("thick_inlayed_coal_block", ModBlocks.THICK_INLAYED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_COBBLESTONE =
        registerBlockItem("thick_inlayed_cobblestone", ModBlocks.THICK_INLAYED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_CRYING_OBSIDIAN =
        registerBlockItem("thick_inlayed_crying_obsidian", ModBlocks.THICK_INLAYED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DARK_PRISMARINE =
        registerBlockItem("thick_inlayed_dark_prismarine", ModBlocks.THICK_INLAYED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DEEPSLATE =
        registerBlockItem("thick_inlayed_deepslate", ModBlocks.THICK_INLAYED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DIORITE =
        registerBlockItem("thick_inlayed_diorite", ModBlocks.THICK_INLAYED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DIRT =
        registerBlockItem("thick_inlayed_dirt", ModBlocks.THICK_INLAYED_DIRT);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_DRIPSTONE_BLOCK =
        registerBlockItem("thick_inlayed_dripstone_block", ModBlocks.THICK_INLAYED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_END_STONE =
        registerBlockItem("thick_inlayed_end_stone", ModBlocks.THICK_INLAYED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_GILDED_BLACKSTONE =
        registerBlockItem("thick_inlayed_gilded_blackstone", ModBlocks.THICK_INLAYED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_ICE =
        registerBlockItem("thick_inlayed_ice", ModBlocks.THICK_INLAYED_ICE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_LAPIS_BLOCK =
        registerBlockItem("thick_inlayed_lapis_block", ModBlocks.THICK_INLAYED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_LODESTONE =
        registerBlockItem("thick_inlayed_lodestone", ModBlocks.THICK_INLAYED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_MAGMA_BLOCK =
        registerBlockItem("thick_inlayed_magma_block", ModBlocks.THICK_INLAYED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_MOSSY_COBBLESTONE =
        registerBlockItem("thick_inlayed_mossy_cobblestone", ModBlocks.THICK_INLAYED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_MOSSY_STONE_BRICKS =
        registerBlockItem("thick_inlayed_mossy_stone_bricks", ModBlocks.THICK_INLAYED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_NETHER_BRICKS =
        registerBlockItem("thick_inlayed_nether_bricks", ModBlocks.THICK_INLAYED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_NETHERRACK =
        registerBlockItem("thick_inlayed_netherrack", ModBlocks.THICK_INLAYED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_OBSIDIAN =
        registerBlockItem("thick_inlayed_obsidian", ModBlocks.THICK_INLAYED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_PACKED_ICE =
        registerBlockItem("thick_inlayed_packed_ice", ModBlocks.THICK_INLAYED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_PRISMARINE =
        registerBlockItem("thick_inlayed_prismarine", ModBlocks.THICK_INLAYED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_PURPUR_BLOCK =
        registerBlockItem("thick_inlayed_purpur_block", ModBlocks.THICK_INLAYED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_QUARTZ_BLOCK =
        registerBlockItem("thick_inlayed_quartz_block", ModBlocks.THICK_INLAYED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RAW_COPPER_BLOCK =
        registerBlockItem("thick_inlayed_raw_copper_block", ModBlocks.THICK_INLAYED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RAW_GOLD_BLOCK =
        registerBlockItem("thick_inlayed_raw_gold_block", ModBlocks.THICK_INLAYED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RAW_IRON_BLOCK =
        registerBlockItem("thick_inlayed_raw_iron_block", ModBlocks.THICK_INLAYED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RED_NETHER_BRICKS =
        registerBlockItem("thick_inlayed_red_nether_bricks", ModBlocks.THICK_INLAYED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_RED_SANDSTONE =
        registerBlockItem("thick_inlayed_red_sandstone", ModBlocks.THICK_INLAYED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_REDSTONE_BLOCK =
        registerBlockItem("thick_inlayed_redstone_block", ModBlocks.THICK_INLAYED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_SANDSTONE =
        registerBlockItem("thick_inlayed_sandstone", ModBlocks.THICK_INLAYED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_SMOOTH_STONE =
        registerBlockItem("thick_inlayed_smooth_stone", ModBlocks.THICK_INLAYED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_SNOW_BLOCK =
        registerBlockItem("thick_inlayed_snow_block", ModBlocks.THICK_INLAYED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> THICK_INLAYED_TUFF =
        registerBlockItem("thick_inlayed_tuff", ModBlocks.THICK_INLAYED_TUFF);
    public static final DeferredHolder<Item, BlockItem> TIED_BAMBOO_PLANKS =
        registerBlockItem("tied_bamboo_planks", ModBlocks.TIED_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> TILED_AMETHYST_BLOCK_COLUMN =
        registerBlockItem("tiled_amethyst_block_column", ModBlocks.TILED_AMETHYST_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_ANCIENT_DEBRIS_COLUMN =
        registerBlockItem("tiled_ancient_debris_column", ModBlocks.TILED_ANCIENT_DEBRIS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_ANDESITE_COLUMN =
        registerBlockItem("tiled_andesite_column", ModBlocks.TILED_ANDESITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BASALT_COLUMN =
        registerBlockItem("tiled_basalt_column", ModBlocks.TILED_BASALT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACK_STAINED_GLASS =
        registerBlockItem("tiled_black_stained_glass", ModBlocks.TILED_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACK_STAINED_GLASS_CTM =
        registerBlockItem("tiled_black_stained_glass_ctm", ModBlocks.TILED_BLACK_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACK_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_black_stained_glass_ctm_pane", ModBlocks.TILED_BLACK_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACK_STAINED_GLASS_PANE = registerBlockItem("tiled_black_stained_glass_pane", ModBlocks.TILED_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_BLACKSTONE_COLUMN =
        registerBlockItem("tiled_blackstone_column", ModBlocks.TILED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_ICE_COLUMN =
        registerBlockItem("tiled_blue_ice_column", ModBlocks.TILED_BLUE_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_STAINED_GLASS =
        registerBlockItem("tiled_blue_stained_glass", ModBlocks.TILED_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_STAINED_GLASS_CTM =
        registerBlockItem("tiled_blue_stained_glass_ctm", ModBlocks.TILED_BLUE_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_blue_stained_glass_ctm_pane", ModBlocks.TILED_BLUE_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_BLUE_STAINED_GLASS_PANE = registerBlockItem("tiled_blue_stained_glass_pane", ModBlocks.TILED_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_AMETHYST_BLOCK =
        registerBlockItem("tiled_bordered_amethyst_block", ModBlocks.TILED_BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("tiled_bordered_ancient_debris", ModBlocks.TILED_BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_ANDESITE =
        registerBlockItem("tiled_bordered_andesite", ModBlocks.TILED_BORDERED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BASALT =
        registerBlockItem("tiled_bordered_basalt", ModBlocks.TILED_BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BLACKSTONE =
        registerBlockItem("tiled_bordered_blackstone", ModBlocks.TILED_BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BLUE_ICE =
        registerBlockItem("tiled_bordered_blue_ice", ModBlocks.TILED_BORDERED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("tiled_bordered_borderless_bricks", ModBlocks.TILED_BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_BRICKS =
        registerBlockItem("tiled_bordered_bricks", ModBlocks.TILED_BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_CALCITE =
        registerBlockItem("tiled_bordered_calcite", ModBlocks.TILED_BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_CLAY =
        registerBlockItem("tiled_bordered_clay", ModBlocks.TILED_BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_COAL_BLOCK =
        registerBlockItem("tiled_bordered_coal_block", ModBlocks.TILED_BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_COBBLESTONE =
        registerBlockItem("tiled_bordered_cobblestone", ModBlocks.TILED_BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("tiled_bordered_crying_obsidian", ModBlocks.TILED_BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DARK_PRISMARINE =
        registerBlockItem("tiled_bordered_dark_prismarine", ModBlocks.TILED_BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DEEPSLATE =
        registerBlockItem("tiled_bordered_deepslate", ModBlocks.TILED_BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DIORITE =
        registerBlockItem("tiled_bordered_diorite", ModBlocks.TILED_BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DIRT =
        registerBlockItem("tiled_bordered_dirt", ModBlocks.TILED_BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("tiled_bordered_dripstone_block", ModBlocks.TILED_BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_END_STONE =
        registerBlockItem("tiled_bordered_end_stone", ModBlocks.TILED_BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("tiled_bordered_gilded_blackstone", ModBlocks.TILED_BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_ICE =
        registerBlockItem("tiled_bordered_ice", ModBlocks.TILED_BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_LAPIS_BLOCK =
        registerBlockItem("tiled_bordered_lapis_block", ModBlocks.TILED_BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_LODESTONE =
        registerBlockItem("tiled_bordered_lodestone", ModBlocks.TILED_BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MAGMA_BLOCK =
        registerBlockItem("tiled_bordered_magma_block", ModBlocks.TILED_BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("tiled_bordered_mossy_cobblestone", ModBlocks.TILED_BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("tiled_bordered_mossy_stone_bricks", ModBlocks.TILED_BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MUD =
        registerBlockItem("tiled_bordered_mud", ModBlocks.TILED_BORDERED_MUD);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_MUD_BRICKS =
        registerBlockItem("tiled_bordered_mud_bricks", ModBlocks.TILED_BORDERED_MUD_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_NETHER_BRICKS =
        registerBlockItem("tiled_bordered_nether_bricks", ModBlocks.TILED_BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_NETHERRACK =
        registerBlockItem("tiled_bordered_netherrack", ModBlocks.TILED_BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_OBSIDIAN =
        registerBlockItem("tiled_bordered_obsidian", ModBlocks.TILED_BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PACKED_ICE =
        registerBlockItem("tiled_bordered_packed_ice", ModBlocks.TILED_BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PACKED_MUD =
        registerBlockItem("tiled_bordered_packed_mud", ModBlocks.TILED_BORDERED_PACKED_MUD);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PRISMARINE =
        registerBlockItem("tiled_bordered_prismarine", ModBlocks.TILED_BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_PURPUR_BLOCK =
        registerBlockItem("tiled_bordered_purpur_block", ModBlocks.TILED_BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_QUARTZ_BLOCK =
        registerBlockItem("tiled_bordered_quartz_block", ModBlocks.TILED_BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("tiled_bordered_raw_copper_block", ModBlocks.TILED_BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("tiled_bordered_raw_gold_block", ModBlocks.TILED_BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("tiled_bordered_raw_iron_block", ModBlocks.TILED_BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("tiled_bordered_red_nether_bricks", ModBlocks.TILED_BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_RED_SANDSTONE =
        registerBlockItem("tiled_bordered_red_sandstone", ModBlocks.TILED_BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_REDSTONE_BLOCK =
        registerBlockItem("tiled_bordered_redstone_block", ModBlocks.TILED_BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_SANDSTONE =
        registerBlockItem("tiled_bordered_sandstone", ModBlocks.TILED_BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_SMOOTH_STONE =
        registerBlockItem("tiled_bordered_smooth_stone", ModBlocks.TILED_BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_SNOW_BLOCK =
        registerBlockItem("tiled_bordered_snow_block", ModBlocks.TILED_BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERED_TUFF =
        registerBlockItem("tiled_bordered_tuff", ModBlocks.TILED_BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> TILED_BORDERLESS_BRICKS_COLUMN =
        registerBlockItem("tiled_borderless_bricks_column", ModBlocks.TILED_BORDERLESS_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BRICKS_COLUMN =
        registerBlockItem("tiled_bricks_column", ModBlocks.TILED_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_BROWN_STAINED_GLASS =
        registerBlockItem("tiled_brown_stained_glass", ModBlocks.TILED_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_BROWN_STAINED_GLASS_CTM =
        registerBlockItem("tiled_brown_stained_glass_ctm", ModBlocks.TILED_BROWN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> TILED_BROWN_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_brown_stained_glass_ctm_pane", ModBlocks.TILED_BROWN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_BROWN_STAINED_GLASS_PANE = registerBlockItem("tiled_brown_stained_glass_pane", ModBlocks.TILED_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_CALCITE_COLUMN =
        registerBlockItem("tiled_calcite_column", ModBlocks.TILED_CALCITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_CLAY_COLUMN =
        registerBlockItem("tiled_clay_column", ModBlocks.TILED_CLAY_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_COAL_BLOCK_COLUMN =
        registerBlockItem("tiled_coal_block_column", ModBlocks.TILED_COAL_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_COBBLESTONE_COLUMN =
        registerBlockItem("tiled_cobblestone_column", ModBlocks.TILED_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_CRYING_OBSIDIAN_COLUMN =
        registerBlockItem("tiled_crying_obsidian_column", ModBlocks.TILED_CRYING_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_CYAN_STAINED_GLASS =
        registerBlockItem("tiled_cyan_stained_glass", ModBlocks.TILED_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_CYAN_STAINED_GLASS_CTM =
        registerBlockItem("tiled_cyan_stained_glass_ctm", ModBlocks.TILED_CYAN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> TILED_CYAN_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_cyan_stained_glass_ctm_pane", ModBlocks.TILED_CYAN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_CYAN_STAINED_GLASS_PANE = registerBlockItem("tiled_cyan_stained_glass_pane", ModBlocks.TILED_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_DARK_PRISMARINE_COLUMN =
        registerBlockItem("tiled_dark_prismarine_column", ModBlocks.TILED_DARK_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_DEEPSLATE_COLUMN =
        registerBlockItem("tiled_deepslate_column", ModBlocks.TILED_DEEPSLATE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_DIORITE_COLUMN =
        registerBlockItem("tiled_diorite_column", ModBlocks.TILED_DIORITE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_DIRT_COLUMN =
        registerBlockItem("tiled_dirt_column", ModBlocks.TILED_DIRT_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_DRIPSTONE_BLOCK_COLUMN =
        registerBlockItem("tiled_dripstone_block_column", ModBlocks.TILED_DRIPSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_END_STONE_COLUMN =
        registerBlockItem("tiled_end_stone_column", ModBlocks.TILED_END_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_GILDED_BLACKSTONE_COLUMN =
        registerBlockItem("tiled_gilded_blackstone_column", ModBlocks.TILED_GILDED_BLACKSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_GRAY_STAINED_GLASS =
        registerBlockItem("tiled_gray_stained_glass", ModBlocks.TILED_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_GRAY_STAINED_GLASS_CTM =
        registerBlockItem("tiled_gray_stained_glass_ctm", ModBlocks.TILED_GRAY_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> TILED_GRAY_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_gray_stained_glass_ctm_pane", ModBlocks.TILED_GRAY_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_GRAY_STAINED_GLASS_PANE = registerBlockItem("tiled_gray_stained_glass_pane", ModBlocks.TILED_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_GREEN_STAINED_GLASS =
        registerBlockItem("tiled_green_stained_glass", ModBlocks.TILED_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> TILED_GREEN_STAINED_GLASS_CTM =
        registerBlockItem("tiled_green_stained_glass_ctm", ModBlocks.TILED_GREEN_STAINED_GLASS_CTM);
    public static final DeferredHolder<Item, BlockItem> TILED_GREEN_STAINED_GLASS_CTM_PANE = registerBlockItem("tiled_green_stained_glass_ctm_pane", ModBlocks.TILED_GREEN_STAINED_GLASS_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_GREEN_STAINED_GLASS_PANE = registerBlockItem("tiled_green_stained_glass_pane", ModBlocks.TILED_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> TILED_ICE_COLUMN =
        registerBlockItem("tiled_ice_column", ModBlocks.TILED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_LAPIS_BLOCK_COLUMN =
        registerBlockItem("tiled_lapis_block_column", ModBlocks.TILED_LAPIS_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_LODESTONE_COLUMN =
        registerBlockItem("tiled_lodestone_column", ModBlocks.TILED_LODESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_MAGMA_BLOCK_COLUMN =
        registerBlockItem("tiled_magma_block_column", ModBlocks.TILED_MAGMA_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_MOSSY_COBBLESTONE_COLUMN =
        registerBlockItem("tiled_mossy_cobblestone_column", ModBlocks.TILED_MOSSY_COBBLESTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_MOSSY_STONE_BRICKS_COLUMN =
        registerBlockItem("tiled_mossy_stone_bricks_column", ModBlocks.TILED_MOSSY_STONE_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_MUD_BRICKS_COLUMN =
        registerBlockItem("tiled_mud_bricks_column", ModBlocks.TILED_MUD_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_MUD_COLUMN =
        registerBlockItem("tiled_mud_column", ModBlocks.TILED_MUD_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_NETHER_BRICKS_COLUMN =
        registerBlockItem("tiled_nether_bricks_column", ModBlocks.TILED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_NETHERRACK_COLUMN =
        registerBlockItem("tiled_netherrack_column", ModBlocks.TILED_NETHERRACK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_OBSIDIAN_COLUMN =
        registerBlockItem("tiled_obsidian_column", ModBlocks.TILED_OBSIDIAN_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_PACKED_ICE_COLUMN =
        registerBlockItem("tiled_packed_ice_column", ModBlocks.TILED_PACKED_ICE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_PACKED_MUD_COLUMN =
        registerBlockItem("tiled_packed_mud_column", ModBlocks.TILED_PACKED_MUD_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_PRISMARINE_COLUMN =
        registerBlockItem("tiled_prismarine_column", ModBlocks.TILED_PRISMARINE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_PURPUR_BLOCK_COLUMN =
        registerBlockItem("tiled_purpur_block_column", ModBlocks.TILED_PURPUR_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_QUARTZ_BLOCK_COLUMN =
        registerBlockItem("tiled_quartz_block_column", ModBlocks.TILED_QUARTZ_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_RAW_COPPER_BLOCK_COLUMN =
        registerBlockItem("tiled_raw_copper_block_column", ModBlocks.TILED_RAW_COPPER_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_RAW_GOLD_BLOCK_COLUMN =
        registerBlockItem("tiled_raw_gold_block_column", ModBlocks.TILED_RAW_GOLD_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_RAW_IRON_BLOCK_COLUMN =
        registerBlockItem("tiled_raw_iron_block_column", ModBlocks.TILED_RAW_IRON_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_NETHER_BRICKS_COLUMN =
        registerBlockItem("tiled_red_nether_bricks_column", ModBlocks.TILED_RED_NETHER_BRICKS_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_RED_SANDSTONE_COLUMN =
        registerBlockItem("tiled_red_sandstone_column", ModBlocks.TILED_RED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_REDSTONE_BLOCK_COLUMN =
        registerBlockItem("tiled_redstone_block_column", ModBlocks.TILED_REDSTONE_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_SANDSTONE_COLUMN =
        registerBlockItem("tiled_sandstone_column", ModBlocks.TILED_SANDSTONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_SMOOTH_STONE_COLUMN =
        registerBlockItem("tiled_smooth_stone_column", ModBlocks.TILED_SMOOTH_STONE_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_SNOW_BLOCK_COLUMN =
        registerBlockItem("tiled_snow_block_column", ModBlocks.TILED_SNOW_BLOCK_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TILED_TUFF_COLUMN =
        registerBlockItem("tiled_tuff_column", ModBlocks.TILED_TUFF_COLUMN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_AMETHYST_BLOCK =
        registerBlockItem("tiny_brick_bordered_amethyst_block", ModBlocks.TINY_BRICK_BORDERED_AMETHYST_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_ANCIENT_DEBRIS =
        registerBlockItem("tiny_brick_bordered_ancient_debris", ModBlocks.TINY_BRICK_BORDERED_ANCIENT_DEBRIS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_ANDESITE =
        registerBlockItem("tiny_brick_bordered_andesite", ModBlocks.TINY_BRICK_BORDERED_ANDESITE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BASALT =
        registerBlockItem("tiny_brick_bordered_basalt", ModBlocks.TINY_BRICK_BORDERED_BASALT);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BLACKSTONE =
        registerBlockItem("tiny_brick_bordered_blackstone", ModBlocks.TINY_BRICK_BORDERED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BLUE_ICE =
        registerBlockItem("tiny_brick_bordered_blue_ice", ModBlocks.TINY_BRICK_BORDERED_BLUE_ICE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BORDERLESS_BRICKS =
        registerBlockItem("tiny_brick_bordered_borderless_bricks", ModBlocks.TINY_BRICK_BORDERED_BORDERLESS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_BRICKS =
        registerBlockItem("tiny_brick_bordered_bricks", ModBlocks.TINY_BRICK_BORDERED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_CALCITE =
        registerBlockItem("tiny_brick_bordered_calcite", ModBlocks.TINY_BRICK_BORDERED_CALCITE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_CLAY =
        registerBlockItem("tiny_brick_bordered_clay", ModBlocks.TINY_BRICK_BORDERED_CLAY);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_COAL_BLOCK =
        registerBlockItem("tiny_brick_bordered_coal_block", ModBlocks.TINY_BRICK_BORDERED_COAL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_COBBLESTONE =
        registerBlockItem("tiny_brick_bordered_cobblestone", ModBlocks.TINY_BRICK_BORDERED_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_CRYING_OBSIDIAN =
        registerBlockItem("tiny_brick_bordered_crying_obsidian", ModBlocks.TINY_BRICK_BORDERED_CRYING_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DARK_PRISMARINE =
        registerBlockItem("tiny_brick_bordered_dark_prismarine", ModBlocks.TINY_BRICK_BORDERED_DARK_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DEEPSLATE =
        registerBlockItem("tiny_brick_bordered_deepslate", ModBlocks.TINY_BRICK_BORDERED_DEEPSLATE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DIORITE =
        registerBlockItem("tiny_brick_bordered_diorite", ModBlocks.TINY_BRICK_BORDERED_DIORITE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DIRT =
        registerBlockItem("tiny_brick_bordered_dirt", ModBlocks.TINY_BRICK_BORDERED_DIRT);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_DRIPSTONE_BLOCK =
        registerBlockItem("tiny_brick_bordered_dripstone_block", ModBlocks.TINY_BRICK_BORDERED_DRIPSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_END_STONE =
        registerBlockItem("tiny_brick_bordered_end_stone", ModBlocks.TINY_BRICK_BORDERED_END_STONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_GILDED_BLACKSTONE =
        registerBlockItem("tiny_brick_bordered_gilded_blackstone", ModBlocks.TINY_BRICK_BORDERED_GILDED_BLACKSTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_ICE =
        registerBlockItem("tiny_brick_bordered_ice", ModBlocks.TINY_BRICK_BORDERED_ICE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_LAPIS_BLOCK =
        registerBlockItem("tiny_brick_bordered_lapis_block", ModBlocks.TINY_BRICK_BORDERED_LAPIS_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_LODESTONE =
        registerBlockItem("tiny_brick_bordered_lodestone", ModBlocks.TINY_BRICK_BORDERED_LODESTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_MAGMA_BLOCK =
        registerBlockItem("tiny_brick_bordered_magma_block", ModBlocks.TINY_BRICK_BORDERED_MAGMA_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_MOSSY_COBBLESTONE =
        registerBlockItem("tiny_brick_bordered_mossy_cobblestone", ModBlocks.TINY_BRICK_BORDERED_MOSSY_COBBLESTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS =
        registerBlockItem("tiny_brick_bordered_mossy_stone_bricks", ModBlocks.TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_NETHER_BRICKS =
        registerBlockItem("tiny_brick_bordered_nether_bricks", ModBlocks.TINY_BRICK_BORDERED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_NETHERRACK =
        registerBlockItem("tiny_brick_bordered_netherrack", ModBlocks.TINY_BRICK_BORDERED_NETHERRACK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_OBSIDIAN =
        registerBlockItem("tiny_brick_bordered_obsidian", ModBlocks.TINY_BRICK_BORDERED_OBSIDIAN);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_PACKED_ICE =
        registerBlockItem("tiny_brick_bordered_packed_ice", ModBlocks.TINY_BRICK_BORDERED_PACKED_ICE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_PRISMARINE =
        registerBlockItem("tiny_brick_bordered_prismarine", ModBlocks.TINY_BRICK_BORDERED_PRISMARINE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_PURPUR_BLOCK =
        registerBlockItem("tiny_brick_bordered_purpur_block", ModBlocks.TINY_BRICK_BORDERED_PURPUR_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_QUARTZ_BLOCK =
        registerBlockItem("tiny_brick_bordered_quartz_block", ModBlocks.TINY_BRICK_BORDERED_QUARTZ_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RAW_COPPER_BLOCK =
        registerBlockItem("tiny_brick_bordered_raw_copper_block", ModBlocks.TINY_BRICK_BORDERED_RAW_COPPER_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RAW_GOLD_BLOCK =
        registerBlockItem("tiny_brick_bordered_raw_gold_block", ModBlocks.TINY_BRICK_BORDERED_RAW_GOLD_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RAW_IRON_BLOCK =
        registerBlockItem("tiny_brick_bordered_raw_iron_block", ModBlocks.TINY_BRICK_BORDERED_RAW_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RED_NETHER_BRICKS =
        registerBlockItem("tiny_brick_bordered_red_nether_bricks", ModBlocks.TINY_BRICK_BORDERED_RED_NETHER_BRICKS);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_RED_SANDSTONE =
        registerBlockItem("tiny_brick_bordered_red_sandstone", ModBlocks.TINY_BRICK_BORDERED_RED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_REDSTONE_BLOCK =
        registerBlockItem("tiny_brick_bordered_redstone_block", ModBlocks.TINY_BRICK_BORDERED_REDSTONE_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_SANDSTONE =
        registerBlockItem("tiny_brick_bordered_sandstone", ModBlocks.TINY_BRICK_BORDERED_SANDSTONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_SMOOTH_STONE =
        registerBlockItem("tiny_brick_bordered_smooth_stone", ModBlocks.TINY_BRICK_BORDERED_SMOOTH_STONE);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_SNOW_BLOCK =
        registerBlockItem("tiny_brick_bordered_snow_block", ModBlocks.TINY_BRICK_BORDERED_SNOW_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TINY_BRICK_BORDERED_TUFF =
        registerBlockItem("tiny_brick_bordered_tuff", ModBlocks.TINY_BRICK_BORDERED_TUFF);
    public static final DeferredHolder<Item, BlockItem> TUFF_CUT_POLISHED = registerBlockItem("tuff_cut_polished", ModBlocks.TUFF_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> TUFF_CUT_SMALL_BRICK = registerBlockItem("tuff_cut_small_brick", ModBlocks.TUFF_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> VERIDIUM_CUT_POLISHED = registerBlockItem("veridium_cut_polished", ModBlocks.VERIDIUM_CUT_POLISHED);
    public static final DeferredHolder<Item, BlockItem> VERIDIUM_CUT_SMALL_BRICK = registerBlockItem("veridium_cut_small_brick", ModBlocks.VERIDIUM_CUT_SMALL_BRICK);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_LEADED_GLASS =
        registerBlockItem("vertical_leaded_glass", ModBlocks.VERTICAL_LEADED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_LEADED_GLASS_PANE = registerBlockItem("vertical_leaded_glass_pane", ModBlocks.VERTICAL_LEADED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_BLACK_STAINED_GLASS =
        registerBlockItem("vertical_striped_black_stained_glass", ModBlocks.VERTICAL_STRIPED_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_BLACK_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_black_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_BLUE_STAINED_GLASS =
        registerBlockItem("vertical_striped_blue_stained_glass", ModBlocks.VERTICAL_STRIPED_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_BLUE_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_blue_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_BROWN_STAINED_GLASS =
        registerBlockItem("vertical_striped_brown_stained_glass", ModBlocks.VERTICAL_STRIPED_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_BROWN_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_brown_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_CYAN_STAINED_GLASS =
        registerBlockItem("vertical_striped_cyan_stained_glass", ModBlocks.VERTICAL_STRIPED_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_CYAN_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_cyan_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_GRAY_STAINED_GLASS =
        registerBlockItem("vertical_striped_gray_stained_glass", ModBlocks.VERTICAL_STRIPED_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_GRAY_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_gray_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_GREEN_STAINED_GLASS =
        registerBlockItem("vertical_striped_green_stained_glass", ModBlocks.VERTICAL_STRIPED_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> VERTICAL_STRIPED_GREEN_STAINED_GLASS_PANE = registerBlockItem("vertical_striped_green_stained_glass_pane", ModBlocks.VERTICAL_STRIPED_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_BEAMS = registerBlockItem("warped_planks_beams", ModBlocks.WARPED_PLANKS_BEAMS);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_BRICK_PATTERN = registerBlockItem("warped_planks_brick_pattern", ModBlocks.WARPED_PLANKS_BRICK_PATTERN);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_BRICK_PAVING = registerBlockItem("warped_planks_brick_paving", ModBlocks.WARPED_PLANKS_BRICK_PAVING);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_BRICKS = registerBlockItem("warped_planks_bricks", ModBlocks.WARPED_PLANKS_BRICKS);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_CRATE = registerBlockItem("warped_planks_crate", ModBlocks.WARPED_PLANKS_CRATE);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_DIAGONAL_STRIPES = registerBlockItem("warped_planks_diagonal_stripes", ModBlocks.WARPED_PLANKS_DIAGONAL_STRIPES);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_DIAGONAL_TILES = registerBlockItem("warped_planks_diagonal_tiles", ModBlocks.WARPED_PLANKS_DIAGONAL_TILES);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_DOTTED = registerBlockItem("warped_planks_dotted", ModBlocks.WARPED_PLANKS_DOTTED);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_FLOORING = registerBlockItem("warped_planks_flooring", ModBlocks.WARPED_PLANKS_FLOORING);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_LARGE_TILES = registerBlockItem("warped_planks_large_tiles", ModBlocks.WARPED_PLANKS_LARGE_TILES);
public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_PANEL =
        registerBlockItem("warped_planks_panel", ModBlocks.WARPED_PLANKS_PANEL);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_PATTERN = registerBlockItem("warped_planks_pattern", ModBlocks.WARPED_PLANKS_PATTERN);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_ROTATED_BRICKS = registerBlockItem("warped_planks_rotated_bricks", ModBlocks.WARPED_PLANKS_ROTATED_BRICKS);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_SMALL_BRICKS = registerBlockItem("warped_planks_small_bricks", ModBlocks.WARPED_PLANKS_SMALL_BRICKS);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_SMALL_TILES = registerBlockItem("warped_planks_small_tiles", ModBlocks.WARPED_PLANKS_SMALL_TILES);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_SQUARES = registerBlockItem("warped_planks_squares", ModBlocks.WARPED_PLANKS_SQUARES);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_TILES = registerBlockItem("warped_planks_tiles", ModBlocks.WARPED_PLANKS_TILES);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_WAVY = registerBlockItem("warped_planks_wavy", ModBlocks.WARPED_PLANKS_WAVY);
    public static final DeferredHolder<Item, BlockItem> WARPED_PLANKS_WOVEN = registerBlockItem("warped_planks_woven", ModBlocks.WARPED_PLANKS_WOVEN);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_BARS = registerBlockItem("warped_window_bars", ModBlocks.WARPED_WINDOW_BARS);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_BARS_CTM = registerBlockItem("warped_window_bars_ctm", ModBlocks.WARPED_WINDOW_BARS_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_COVERED = registerBlockItem("warped_window_covered", ModBlocks.WARPED_WINDOW_COVERED);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_COVERED_CTM = registerBlockItem("warped_window_covered_ctm", ModBlocks.WARPED_WINDOW_COVERED_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_DIAGONAL = registerBlockItem("warped_window_diagonal", ModBlocks.WARPED_WINDOW_DIAGONAL);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_DIAGONAL_CTM = registerBlockItem("warped_window_diagonal_ctm", ModBlocks.WARPED_WINDOW_DIAGONAL_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_LARGE = registerBlockItem("warped_window_large", ModBlocks.WARPED_WINDOW_LARGE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_LARGE_CTM = registerBlockItem("warped_window_large_ctm", ModBlocks.WARPED_WINDOW_LARGE_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_PANES = registerBlockItem("warped_window_panes", ModBlocks.WARPED_WINDOW_PANES);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_PANES_CTM = registerBlockItem("warped_window_panes_ctm", ModBlocks.WARPED_WINDOW_PANES_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_ROUNDED = registerBlockItem("warped_window_rounded", ModBlocks.WARPED_WINDOW_ROUNDED);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_ROUNDED_CTM = registerBlockItem("warped_window_rounded_ctm", ModBlocks.WARPED_WINDOW_ROUNDED_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SLIM = registerBlockItem("warped_window_slim", ModBlocks.WARPED_WINDOW_SLIM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SLIM_CTM = registerBlockItem("warped_window_slim_ctm", ModBlocks.WARPED_WINDOW_SLIM_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SWIRLING_CTM = registerBlockItem("warped_window_swirling_ctm", ModBlocks.WARPED_WINDOW_SWIRLING_CTM);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_SWIRLING_CTM_PANE = registerBlockItem("warped_window_swirling_ctm_pane", ModBlocks.WARPED_WINDOW_SWIRLING_CTM_PANE);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_TILES = registerBlockItem("warped_window_tiles", ModBlocks.WARPED_WINDOW_TILES);
    public static final DeferredHolder<Item, BlockItem> WARPED_WINDOW_TILES_CTM = registerBlockItem("warped_window_tiles_ctm", ModBlocks.WARPED_WINDOW_TILES_CTM);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_ACACIA_PLANKS =
        registerBlockItem("whirlwind_acacia_planks", ModBlocks.WHIRLWIND_ACACIA_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_BAMBOO_PLANKS =
        registerBlockItem("whirlwind_bamboo_planks", ModBlocks.WHIRLWIND_BAMBOO_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_BIRCH_PLANKS =
        registerBlockItem("whirlwind_birch_planks", ModBlocks.WHIRLWIND_BIRCH_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHIRLWIND_OAK_PLANKS =
        registerBlockItem("whirlwind_oak_planks", ModBlocks.WHIRLWIND_OAK_PLANKS);
    public static final DeferredHolder<Item, BlockItem> WHITE_CONCRETE_CTM =
        registerBlockItem("white_concrete_ctm", ModBlocks.WHITE_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> WHITE_CONCRETE_PANEL =
        registerBlockItem("white_concrete_panel", ModBlocks.WHITE_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> WHITE_FLOWER_ACACIA_LEAVES =
        registerBlockItem("white_flower_acacia_leaves", ModBlocks.WHITE_FLOWER_ACACIA_LEAVES);
    public static final DeferredHolder<Item, BlockItem> WHITE_FLOWER_BIRCH_LEAVES =
        registerBlockItem("white_flower_birch_leaves", ModBlocks.WHITE_FLOWER_BIRCH_LEAVES);
    public static final DeferredHolder<Item, BlockItem> WHITE_FLOWER_DARK_OAK_LEAVES =
        registerBlockItem("white_flower_dark_oak_leaves", ModBlocks.WHITE_FLOWER_DARK_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> WHITE_FLOWER_JUNGLE_LEAVES =
        registerBlockItem("white_flower_jungle_leaves", ModBlocks.WHITE_FLOWER_JUNGLE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> WHITE_FLOWER_OAK_LEAVES =
        registerBlockItem("white_flower_oak_leaves", ModBlocks.WHITE_FLOWER_OAK_LEAVES);
    public static final DeferredHolder<Item, BlockItem> WHITE_FLOWER_SPRUCE_LEAVES =
        registerBlockItem("white_flower_spruce_leaves", ModBlocks.WHITE_FLOWER_SPRUCE_LEAVES);
    public static final DeferredHolder<Item, BlockItem> WIRED_BLACK_CONCRETE =
        registerBlockItem("wired_black_concrete", ModBlocks.WIRED_BLACK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_BLUE_CONCRETE =
        registerBlockItem("wired_blue_concrete", ModBlocks.WIRED_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_BROWN_CONCRETE =
        registerBlockItem("wired_brown_concrete", ModBlocks.WIRED_BROWN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_CYAN_CONCRETE =
        registerBlockItem("wired_cyan_concrete", ModBlocks.WIRED_CYAN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_GRAY_CONCRETE =
        registerBlockItem("wired_gray_concrete", ModBlocks.WIRED_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_GREEN_CONCRETE =
        registerBlockItem("wired_green_concrete", ModBlocks.WIRED_GREEN_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_LIGHT_BLUE_CONCRETE =
        registerBlockItem("wired_light_blue_concrete", ModBlocks.WIRED_LIGHT_BLUE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_LIGHT_GRAY_CONCRETE =
        registerBlockItem("wired_light_gray_concrete", ModBlocks.WIRED_LIGHT_GRAY_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_LIME_CONCRETE =
        registerBlockItem("wired_lime_concrete", ModBlocks.WIRED_LIME_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_MAGENTA_CONCRETE =
        registerBlockItem("wired_magenta_concrete", ModBlocks.WIRED_MAGENTA_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_ORANGE_CONCRETE =
        registerBlockItem("wired_orange_concrete", ModBlocks.WIRED_ORANGE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_PINK_CONCRETE =
        registerBlockItem("wired_pink_concrete", ModBlocks.WIRED_PINK_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_PURPLE_CONCRETE =
        registerBlockItem("wired_purple_concrete", ModBlocks.WIRED_PURPLE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_RED_CONCRETE =
        registerBlockItem("wired_red_concrete", ModBlocks.WIRED_RED_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_WHITE_CONCRETE =
        registerBlockItem("wired_white_concrete", ModBlocks.WIRED_WHITE_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WIRED_YELLOW_CONCRETE =
        registerBlockItem("wired_yellow_concrete", ModBlocks.WIRED_YELLOW_CONCRETE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_BLACK_STAINED_GLASS =
        registerBlockItem("woven_black_stained_glass", ModBlocks.WOVEN_BLACK_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_BLACK_STAINED_GLASS_PANE = registerBlockItem("woven_black_stained_glass_pane", ModBlocks.WOVEN_BLACK_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_BLUE_STAINED_GLASS =
        registerBlockItem("woven_blue_stained_glass", ModBlocks.WOVEN_BLUE_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_BLUE_STAINED_GLASS_PANE = registerBlockItem("woven_blue_stained_glass_pane", ModBlocks.WOVEN_BLUE_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_BROWN_STAINED_GLASS =
        registerBlockItem("woven_brown_stained_glass", ModBlocks.WOVEN_BROWN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_BROWN_STAINED_GLASS_PANE = registerBlockItem("woven_brown_stained_glass_pane", ModBlocks.WOVEN_BROWN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_CYAN_STAINED_GLASS =
        registerBlockItem("woven_cyan_stained_glass", ModBlocks.WOVEN_CYAN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_CYAN_STAINED_GLASS_PANE = registerBlockItem("woven_cyan_stained_glass_pane", ModBlocks.WOVEN_CYAN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_GRAY_STAINED_GLASS =
        registerBlockItem("woven_gray_stained_glass", ModBlocks.WOVEN_GRAY_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_GRAY_STAINED_GLASS_PANE = registerBlockItem("woven_gray_stained_glass_pane", ModBlocks.WOVEN_GRAY_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> WOVEN_GREEN_STAINED_GLASS =
        registerBlockItem("woven_green_stained_glass", ModBlocks.WOVEN_GREEN_STAINED_GLASS);
    public static final DeferredHolder<Item, BlockItem> WOVEN_GREEN_STAINED_GLASS_PANE = registerBlockItem("woven_green_stained_glass_pane", ModBlocks.WOVEN_GREEN_STAINED_GLASS_PANE);
    public static final DeferredHolder<Item, BlockItem> YELLOW_CONCRETE_CTM =
        registerBlockItem("yellow_concrete_ctm", ModBlocks.YELLOW_CONCRETE_CTM);
    public static final DeferredHolder<Item, BlockItem> YELLOW_CONCRETE_PANEL =
        registerBlockItem("yellow_concrete_panel", ModBlocks.YELLOW_CONCRETE_PANEL);
    public static final DeferredHolder<Item, BlockItem> YELLOW_TERRACOTTA_COLUMN =
        registerBlockItem("yellow_terracotta_column", ModBlocks.YELLOW_TERRACOTTA_COLUMN);
    public static final DeferredHolder<Item, BlockItem> YELLOW_TERRACOTTA_CTM =
        registerBlockItem("yellow_terracotta_ctm", ModBlocks.YELLOW_TERRACOTTA_CTM);


    // ===== RECOVERED PURPUR_CTM =====
    public static final DeferredHolder<Item, BlockItem> PURPUR_PILLAR_CTM                  = registerBlockItem("purpur_ctm",          ModBlocks.PURPUR_PILLAR_CTM);

}