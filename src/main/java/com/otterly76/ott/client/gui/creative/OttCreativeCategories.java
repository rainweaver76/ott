package com.otterly76.ott.client.gui.creative;

import com.otterly76.ott.block.ModBlocks;
import com.otterly76.ott.entity.custom.Butterfly;
import com.otterly76.ott.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public enum OttCreativeCategories {

    // ── Sea Creatures ─────────────────────────────────────────────────────────
    // ── Creatures: all spawn eggs + aquatic buckets ───────────────────────────
    CREATURES("creatures",
            ModItems.OTTER_SPAWN_EGG,
            (params, output) -> {
                // Aquatic buckets
                output.accept(ModItems.ANGELFISH_BUCKET);
                output.accept(ModItems.BARRELEYE_BUCKET);
                output.accept(ModItems.BASS_BUCKET);
                output.accept(ModItems.BONNETHEAD_SHARK_BUCKET);
                output.accept(ModItems.CATFISH_BUCKET);
                output.accept(ModItems.CICHLID_BUCKET);
                output.accept(ModItems.DUMBO_OCTOPUS_BUCKET);
                output.accept(ModItems.FLOUNDER_BUCKET);
                output.accept(ModItems.GOBLIN_SHARK_BUCKET);
                output.accept(ModItems.GUITARFISH_BUCKET);
                output.accept(ModItems.SMALL_JELLYFISH_BUCKET);
                output.accept(ModItems.MEDIUM_JELLYFISH_BUCKET);
                output.accept(ModItems.LARGE_JELLYFISH_BUCKET);
                output.accept(ModItems.KOI_FISH_BUCKET);
                output.accept(ModItems.KRILL_BUCKET);
                output.accept(ModItems.MAN_O_WAR_BUCKET);
                output.accept(ModItems.MARINE_IGUANA_BUCKET);
                output.accept(ModItems.PSYCHO_JELLY_BUCKET);
                output.accept(ModItems.SEA_BUNNY_BUCKET);
                output.accept(ModItems.SEAHORSE_BUCKET);
                output.accept(ModItems.ETHEREAL_SHRIMP_BUCKET);
                output.accept(ModItems.SNAIL_BUCKET);
                output.accept(ModItems.STINGRAY_BUCKET);
                output.accept(ModItems.SUNFISH_BUCKET);
                // Sea creatures
                output.accept(ModItems.ANGELFISH_SPAWN_EGG);
                output.accept(ModItems.BARRELEYE_SPAWN_EGG);
                output.accept(ModItems.BASS_SPAWN_EGG);
                output.accept(ModItems.BONNETHEAD_SHARK_SPAWN_EGG);
                output.accept(ModItems.CATFISH_SPAWN_EGG);
                output.accept(ModItems.CICHLID_SPAWN_EGG);
                output.accept(ModItems.COCONUT_CRAB_SPAWN_EGG);
                output.accept(ModItems.CORAL_SEA_VIPER_SPAWN_EGG);
                output.accept(ModItems.DUMBO_OCTOPUS_SPAWN_EGG);
                output.accept(ModItems.FIDDLER_CRAB_SPAWN_EGG);
                output.accept(ModItems.FLOUNDER_SPAWN_EGG);
                output.accept(ModItems.GOBLIN_SHARK_SPAWN_EGG);
                output.accept(ModItems.GUITARFISH_SPAWN_EGG);
                output.accept(ModItems.SMALL_JELLYFISH_SPAWN_EGG);
                output.accept(ModItems.MEDIUM_JELLYFISH_SPAWN_EGG);
                output.accept(ModItems.LARGE_JELLYFISH_SPAWN_EGG);
                output.accept(ModItems.KOI_FISH_SPAWN_EGG);
                output.accept(ModItems.KRILL_SPAWN_EGG);
                output.accept(ModItems.MAN_O_WAR_SPAWN_EGG);
                output.accept(ModItems.MANTA_RAY_SPAWN_EGG);
                output.accept(ModItems.MARINE_IGUANA_SPAWN_EGG);
                output.accept(ModItems.PSYCHO_JELLY_SPAWN_EGG);
                output.accept(ModItems.SAND_CRAB_SPAWN_EGG);
                output.accept(ModItems.SEA_BUNNY_SPAWN_EGG);
                output.accept(ModItems.SEAHORSE_SPAWN_EGG);
                output.accept(ModItems.SEAL_SPAWN_EGG);
                output.accept(ModItems.SEA_URCHIN_SPAWN_EGG);
                output.accept(ModItems.SEA_VIPER_SPAWN_EGG);
                output.accept(ModItems.SNAIL_SPAWN_EGG);
                output.accept(ModItems.STARFISH_SPAWN_EGG);
                output.accept(ModItems.STINGRAY_SPAWN_EGG);
                output.accept(ModItems.SUNFISH_SPAWN_EGG);
                output.accept(ModItems.ETHEREAL_SHRIMP_SPAWN_EGG);
                // Birds
                output.accept(ModItems.BLUEJAY_SPAWN_EGG);
                output.accept(ModItems.BURROWING_OWL_SPAWN_EGG);
                output.accept(ModItems.CANARY_SPAWN_EGG);
                output.accept(ModItems.CARDINAL_SPAWN_EGG);
                output.accept(ModItems.DUCK_SPAWN_EGG);
                output.accept(ModItems.EMU_SPAWN_EGG);
                output.accept(ModItems.FINCH_SPAWN_EGG);
                output.accept(ModItems.GOOSE_SPAWN_EGG);
                output.accept(ModItems.GUINEA_FOWL_SPAWN_EGG);
                output.accept(ModItems.HOOPOE_SPAWN_EGG);
                output.accept(ModItems.KIWI_SPAWN_EGG);
                output.accept(ModItems.PENGUIN_SPAWN_EGG);
                output.accept(ModItems.PHEASANT_SPAWN_EGG);
                output.accept(ModItems.QUAIL_SPAWN_EGG);
                output.accept(ModItems.ROBIN_SPAWN_EGG);
                output.accept(ModItems.SPARROW_SPAWN_EGG);
                output.accept(ModItems.SPOONBILL_SPAWN_EGG);
                output.accept(ModItems.STORK_SPAWN_EGG);
                output.accept(ModItems.TOUCAN_SPAWN_EGG);
                output.accept(ModItems.TURKEY_SPAWN_EGG);
                output.accept(ModItems.VULTURE_SPAWN_EGG);
                // Reptiles & Amphibians
                output.accept(ModItems.ALLIGATOR_SPAWN_EGG);
                output.accept(ModItems.FIRE_SALAMANDER_SPAWN_EGG);
                output.accept(ModItems.GECKO_SPAWN_EGG);
                output.accept(ModItems.GIANT_SOFTSHELL_TURTLE_SPAWN_EGG);
                output.accept(ModItems.LIZARD_SPAWN_EGG);
                output.accept(ModItems.PINK_LAND_IGUANA_SPAWN_EGG);
                output.accept(ModItems.PIT_VIPER_SPAWN_EGG);
                output.accept(ModItems.RATTLESNAKE_SPAWN_EGG);
                output.accept(ModItems.RIVER_TURTLE_SPAWN_EGG);
                output.accept(ModItems.SNAKE_SPAWN_EGG);
                output.accept(ModItems.TORTOISE_SPAWN_EGG);
                // Mammals
                output.accept(ModItems.BEAVER_SPAWN_EGG);
                output.accept(ModItems.BLACK_BEAR_SPAWN_EGG);
                output.accept(ModItems.BROWN_BEAR_SPAWN_EGG);
                output.accept(ModItems.BUSHDOG_SPAWN_EGG);
                output.accept(ModItems.CANDYCANE_SNAIL_SPAWN_EGG);
                output.accept(ModItems.CAPYBARA_SPAWN_EGG);
                output.accept(ModItems.COUGAR_SPAWN_EGG);
                output.accept(ModItems.COYOTE_SPAWN_EGG);
                output.accept(ModItems.DEER_SPAWN_EGG);
                output.accept(ModItems.ECHIDNA_SPAWN_EGG);
                output.accept(ModItems.ELEPHANT_SPAWN_EGG);
                output.accept(ModItems.FENNEC_FOX_SPAWN_EGG);
                output.accept(ModItems.FERRET_SPAWN_EGG);
                output.accept(ModItems.GIRAFFE_SPAWN_EGG);
                output.accept(ModItems.HEDGEHOG_SPAWN_EGG);
                output.accept(ModItems.HIPPO_SPAWN_EGG);
                output.accept(ModItems.IMPALA_SPAWN_EGG);
                output.accept(ModItems.LEOPARD_CAT_SPAWN_EGG);
                output.accept(ModItems.LION_SPAWN_EGG);
                output.accept(ModItems.MAMMOTH_SPAWN_EGG);
                output.accept(ModItems.MARMOT_SPAWN_EGG);
                output.accept(ModItems.MOLE_SPAWN_EGG);
                output.accept(ModItems.MOOSE_SPAWN_EGG);
                output.accept(ModItems.MOUSE_SPAWN_EGG);
                output.accept(ModItems.OTTER_SPAWN_EGG);
                output.accept(ModItems.PALLAS_CAT_SPAWN_EGG);
                output.accept(ModItems.RED_PANDA_SPAWN_EGG);
                output.accept(ModItems.REINDEER_SPAWN_EGG);
                output.accept(ModItems.RHINO_SPAWN_EGG);
                output.accept(ModItems.RINGTAIL_SPAWN_EGG);
                output.accept(ModItems.TREE_KANGAROO_SPAWN_EGG);
                output.accept(ModItems.WATER_BUFFALO_SPAWN_EGG);
                output.accept(ModItems.WHITE_DEER_SPAWN_EGG);
                output.accept(ModItems.WOLVERINE_SPAWN_EGG);
                output.accept(ModItems.ZEBRA_SPAWN_EGG);
                // Insects & small critters
                output.accept(ModItems.BUTTERFLY_SPAWN_EGG);
                output.accept(ModItems.CATERPILLAR_SPAWN_EGG);
                output.accept(ModItems.DRAGONFLY_SPAWN_EGG);
                output.accept(ModItems.FIREFLY_SPAWN_EGG);
                output.accept(ModItems.JUMPING_SPIDER_SPAWN_EGG);
                output.accept(ModItems.SMALL_FIREFLY_SPAWN_EGG);
                // Supernatural / undead
                output.accept(ModItems.BOGGED_BONE_STALKER_SPAWN_EGG);
                output.accept(ModItems.BOGGED_SHADOW_SPAWN_EGG);
                output.accept(ModItems.BONE_STALKER_SPAWN_EGG);
                output.accept(ModItems.GEIST_SPAWN_EGG);
                output.accept(ModItems.GHOST_SPAWN_EGG);
                output.accept(ModItems.HAUNT_SPAWN_EGG);
                output.accept(ModItems.SHADOW_SPAWN_EGG);
                output.accept(ModItems.SKINWALKER_SPAWN_EGG);
                output.accept(ModItems.SPECTRE_SPAWN_EGG);
                // Cryptids & monsters
                output.accept(ModItems.ARID_YETI_SPAWN_EGG);
                output.accept(ModItems.CHUPACABRA_SPAWN_EGG);
                output.accept(ModItems.HOWLER_SPAWN_EGG);
                output.accept(ModItems.MYCELIUM_MAMMOTH_SPAWN_EGG);
                output.accept(ModItems.SASQUATCH_SPAWN_EGG);
                output.accept(ModItems.SQUONK_SPAWN_EGG);
                output.accept(ModItems.VILE_GATOR_SPAWN_EGG);
                output.accept(ModItems.WECHUGE_SPAWN_EGG);
                output.accept(ModItems.WENDIGO_SPAWN_EGG);
                output.accept(ModItems.YETI_SPAWN_EGG);
                // Elemental / magical
                output.accept(ModItems.BABY_PHOENIX_SPAWN_EGG);
                output.accept(ModItems.BABY_WIND_PHOENIX_SPAWN_EGG);
                output.accept(ModItems.CHERRY_TREE_ENT_SPAWN_EGG);
                output.accept(ModItems.GILDED_TREE_ENT_SPAWN_EGG);
                output.accept(ModItems.PHOENIX_SPAWN_EGG);
                output.accept(ModItems.TREE_ENT_SPAWN_EGG);
                output.accept(ModItems.WIND_PHOENIX_SPAWN_EGG);
                output.accept(ModItems.GOLDEN_HERMIT_KING_SPAWN_EGG);
                output.accept(ModItems.HERMIT_KING_SPAWN_EGG);
                // Mob Vote
                output.accept(ModItems.GLARE_SPAWN_EGG);
                output.accept(ModItems.ICEOLOGER_SPAWN_EGG);
                output.accept(ModItems.ILLUSIONER_SPAWN_EGG);
                output.accept(ModItems.MAULER_SPAWN_EGG);
                output.accept(ModItems.RASCAL_SPAWN_EGG);
                output.accept(ModItems.TUFF_GOLEM_SPAWN_EGG);
                output.accept(ModItems.WILDFIRE_SPAWN_EGG);
            }),

    DYES("dyes",
            ModItems.CUSTOM_DYES.get("goldenrod"),
            (params, output) -> {
                output.accept(Items.WHITE_DYE);
                output.accept(Items.LIGHT_GRAY_DYE);
                output.accept(Items.GRAY_DYE);
                output.accept(Items.BLACK_DYE);
                output.accept(Items.BROWN_DYE);
                output.accept(Items.RED_DYE);
                output.accept(Items.ORANGE_DYE);
                output.accept(Items.YELLOW_DYE);
                output.accept(Items.LIME_DYE);
                output.accept(Items.GREEN_DYE);
                output.accept(Items.CYAN_DYE);
                output.accept(Items.LIGHT_BLUE_DYE);
                output.accept(Items.BLUE_DYE);
                output.accept(Items.PURPLE_DYE);
                output.accept(Items.MAGENTA_DYE);
                output.accept(Items.PINK_DYE);
                ModItems.CUSTOM_DYES.values().forEach(output::accept);
            }),

    COLORS("colors",
            () -> ModBlocks.COLOR_SETS.get("amethyst").wool().get().asItem(),
            (params, output) -> {
                // ── OTT custom color groups (palette order) ──────────────────
                ModBlocks.COLOR_SETS.forEach((name, set) -> {
                    output.accept(set.wool());
                    output.accept(set.carpet());
                    output.accept(set.terracotta());
                    output.accept(set.glazedTerracotta());
                    output.accept(set.concrete());
                    output.accept(set.concretePowder());
                    output.accept(set.stainedGlass());
                    output.accept(set.stainedGlassPane());
                    output.accept(set.shulkerBox());
                    output.accept(set.bed());
                    output.accept(set.candle());
                    output.accept(set.banner());
                    output.accept(set.plate());
                    output.accept(set.edge());
                    output.accept(set.beam());
                    output.accept(set.pergola());
                    output.accept(set.geometricWindow());
                    output.accept(set.bannister());
                    output.accept(set.supportSlab());
                    output.accept(set.supportBeam());
                    var sg = ModBlocks.SEAGLASS_SETS.get(name);
                    if (sg != null) {
                        output.accept(sg.seaglass());
                        output.accept(sg.bubblesSeaglass());
                        output.accept(sg.smoothSeaglass());
                        output.accept(sg.wavesSeaglass());
                    }
                    ModBlocks.PATTERN_BLOCKS.values().forEach(colorMap -> {
                        var pb = colorMap.get(name);
                        if (pb != null) output.accept(pb);
                    });
                    var elev = ModBlocks.ELEVATORS.get(name);
                    if (elev != null) output.accept(elev);
                    var ct = ModItems.CLAY_TILES.get(name);
                    if (ct != null) output.accept(ct.get());
                    var futon = ModBlocks.FUTONS.get(name);
                    if (futon != null) output.accept(futon);
                });
                // ── Vanilla dye color groups (white → black) ─────────────────
                for (net.minecraft.world.item.DyeColor dye : net.minecraft.world.item.DyeColor.values()) {
                    String name = dye.getName();
                    var sg = ModBlocks.SEAGLASS_SETS.get(name);
                    if (sg != null) {
                        output.accept(sg.seaglass());
                        output.accept(sg.bubblesSeaglass());
                        output.accept(sg.smoothSeaglass());
                        output.accept(sg.wavesSeaglass());
                    }
                    ModBlocks.PATTERN_BLOCKS.values().forEach(colorMap -> {
                        var pb = colorMap.get(name);
                        if (pb != null) output.accept(pb);
                    });
                    var elev = ModBlocks.ELEVATORS.get(name);
                    if (elev != null) output.accept(elev);
                    var ct = ModItems.CLAY_TILES.get(name);
                    if (ct != null) output.accept(ct.get());
                    var futon = ModBlocks.FUTONS.get(name);
                    if (futon != null) output.accept(futon);
                }
            }),

    WOOD_SETS("wood_sets",
            () -> ModBlocks.WOOD_SETS.get("starlight").log().get().asItem(),
            (params, output) -> {
                ModBlocks.WOOD_SETS.forEach((name, set) -> {
                    output.accept(set.log());
                    output.accept(set.wood());
                    output.accept(set.strippedLog());
                    output.accept(set.strippedWood());
                    output.accept(set.planks());
                    output.accept(set.stairs());
                    output.accept(set.slab());
                    output.accept(set.fence());
                    output.accept(set.fenceGate());
                    output.accept(set.door());
                    output.accept(set.trapdoor());
                    output.accept(set.button());
                    output.accept(set.pressurePlate());
                    output.accept(set.leaves());
                    output.accept(set.sapling());
                    output.accept(ModItems.WOOD_SET_SIGNS.get(name));
                    output.accept(ModItems.WOOD_SET_HANGING_SIGNS.get(name));
                    output.accept(ModItems.WOOD_SET_BOATS.get(name));
                    output.accept(ModItems.WOOD_SET_CHEST_BOATS.get(name));
                    output.accept(set.beehive());
                    output.accept(set.shelf());
                });
                ModBlocks.WOOD_SETS.values().forEach(set -> {
                    output.accept(set.beam());
                    output.accept(set.pergola());
                    output.accept(set.planksPlate());
                    output.accept(set.planksEdge());
                    output.accept(set.bannister());
                    output.accept(set.supportSlab());
                    output.accept(set.supportBeam());
                    output.accept(set.geometricWindow());
                });
            }),

    BACKPORT("backport",
            () -> ModBlocks.PALE_OAK_LOG.get().asItem(),
            (params, output) -> {
                output.accept(ModBlocks.PALE_OAK_LOG);
                output.accept(ModBlocks.PALE_OAK_WOOD);
                output.accept(ModBlocks.STRIPPED_PALE_OAK_LOG);
                output.accept(ModBlocks.STRIPPED_PALE_OAK_WOOD);
                output.accept(ModBlocks.PALE_OAK_PLANKS);
                output.accept(ModBlocks.PALE_OAK_STAIRS);
                output.accept(ModBlocks.PALE_OAK_SLAB);
                output.accept(ModBlocks.PALE_OAK_FENCE);
                output.accept(ModBlocks.PALE_OAK_FENCE_GATE);
                output.accept(ModBlocks.PALE_OAK_DOOR);
                output.accept(ModBlocks.PALE_OAK_TRAPDOOR);
                output.accept(ModBlocks.PALE_OAK_PRESSURE_PLATE);
                output.accept(ModBlocks.PALE_OAK_BUTTON);
                output.accept(ModItems.PALE_OAK_SIGN);
                output.accept(ModItems.PALE_OAK_HANGING_SIGN);
                output.accept(ModBlocks.PALE_OAK_LEAVES);
                output.accept(ModBlocks.PALE_OAK_SAPLING);
                output.accept(ModItems.PALE_OAK_BOAT);
                output.accept(ModItems.PALE_OAK_CHEST_BOAT);
                output.accept(ModBlocks.PALE_MOSS_BLOCK);
                output.accept(ModBlocks.PALE_MOSS_CARPET);
                output.accept(ModBlocks.PALE_HANGING_MOSS);
                output.accept(ModBlocks.CREAKING_HEART);
                output.accept(ModBlocks.OPEN_EYEBLOSSOM);
                output.accept(ModBlocks.CLOSED_EYEBLOSSOM);

                output.accept(ModBlocks.RESIN_BLOCK);
                output.accept(ModBlocks.RESIN_BRICKS);
                output.accept(ModBlocks.RESIN_BRICK_STAIRS);
                output.accept(ModBlocks.RESIN_BRICK_SLAB);
                output.accept(ModBlocks.RESIN_BRICK_WALL);
                output.accept(ModBlocks.CHISELED_RESIN_BRICKS);
                output.accept(ModBlocks.RESIN_CLUMP);

                ModBlocks.SHELVES.forEach(output::accept);

                output.accept(ModBlocks.BUSH);
                output.accept(ModBlocks.FIREFLY_BUSH);
                output.accept(ModBlocks.WILDFLOWERS);
                output.accept(ModBlocks.PALE_WILDFLOWERS);
                output.accept(ModBlocks.LEAF_LITTER);
                output.accept(ModBlocks.CACTUS_FLOWER);
                output.accept(ModBlocks.SHORT_DRY_GRASS);
                output.accept(ModBlocks.TALL_DRY_GRASS);

                output.accept(ModBlocks.DRIED_GHAST);

                output.accept(ModItems.WOODEN_SPEAR);
                output.accept(ModItems.STONE_SPEAR);
                output.accept(ModItems.IRON_SPEAR);
                output.accept(ModItems.GOLDEN_SPEAR);
                output.accept(ModItems.DIAMOND_SPEAR);
                output.accept(ModItems.NETHERITE_SPEAR);
                output.accept(ModItems.COPPER_SPEAR);

                output.accept(ModItems.NETHERITE_HORSE_ARMOR);

                output.accept(ModItems.NAUTILUS_SPAWN_EGG);
                output.accept(ModItems.ZOMBIE_NAUTILUS_SPAWN_EGG);
                output.accept(ModItems.CAMEL_HUSK_SPAWN_EGG);

                output.accept(ModItems.COPPER_NAUTILUS_ARMOR);
                output.accept(ModItems.IRON_NAUTILUS_ARMOR);
                output.accept(ModItems.GOLDEN_NAUTILUS_ARMOR);
                output.accept(ModItems.DIAMOND_NAUTILUS_ARMOR);
                output.accept(ModItems.NETHERITE_NAUTILUS_ARMOR);
            }),

    COPPER_CHAOS("copper_chaos",
            () -> ModBlocks.COPPER_CHEST.get().asItem(),
            (params, output) -> {
                // Vanilla copper base blocks
                output.accept(Items.COPPER_BLOCK);
                output.accept(Items.EXPOSED_COPPER);
                output.accept(Items.WEATHERED_COPPER);
                output.accept(Items.OXIDIZED_COPPER);
                output.accept(Items.WAXED_COPPER_BLOCK);
                output.accept(Items.WAXED_EXPOSED_COPPER);
                output.accept(Items.WAXED_WEATHERED_COPPER);
                output.accept(Items.WAXED_OXIDIZED_COPPER);
                output.accept(Items.CUT_COPPER);
                output.accept(Items.EXPOSED_CUT_COPPER);
                output.accept(Items.WEATHERED_CUT_COPPER);
                output.accept(Items.OXIDIZED_CUT_COPPER);
                output.accept(Items.WAXED_CUT_COPPER);
                output.accept(Items.WAXED_EXPOSED_CUT_COPPER);
                output.accept(Items.WAXED_WEATHERED_CUT_COPPER);
                output.accept(Items.WAXED_OXIDIZED_CUT_COPPER);
                output.accept(Items.CUT_COPPER_STAIRS);
                output.accept(Items.EXPOSED_CUT_COPPER_STAIRS);
                output.accept(Items.WEATHERED_CUT_COPPER_STAIRS);
                output.accept(Items.OXIDIZED_CUT_COPPER_STAIRS);
                output.accept(Items.WAXED_CUT_COPPER_STAIRS);
                output.accept(Items.WAXED_EXPOSED_CUT_COPPER_STAIRS);
                output.accept(Items.WAXED_WEATHERED_CUT_COPPER_STAIRS);
                output.accept(Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
                output.accept(Items.CUT_COPPER_SLAB);
                output.accept(Items.EXPOSED_CUT_COPPER_SLAB);
                output.accept(Items.WEATHERED_CUT_COPPER_SLAB);
                output.accept(Items.OXIDIZED_CUT_COPPER_SLAB);
                output.accept(Items.WAXED_CUT_COPPER_SLAB);
                output.accept(Items.WAXED_EXPOSED_CUT_COPPER_SLAB);
                output.accept(Items.WAXED_WEATHERED_CUT_COPPER_SLAB);
                output.accept(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB);
                output.accept(Items.CHISELED_COPPER);
                output.accept(Items.EXPOSED_CHISELED_COPPER);
                output.accept(Items.WEATHERED_CHISELED_COPPER);
                output.accept(Items.OXIDIZED_CHISELED_COPPER);
                output.accept(Items.WAXED_CHISELED_COPPER);
                output.accept(Items.WAXED_EXPOSED_CHISELED_COPPER);
                output.accept(Items.WAXED_WEATHERED_CHISELED_COPPER);
                output.accept(Items.WAXED_OXIDIZED_CHISELED_COPPER);
                output.accept(Items.COPPER_GRATE);
                output.accept(Items.EXPOSED_COPPER_GRATE);
                output.accept(Items.WEATHERED_COPPER_GRATE);
                output.accept(Items.OXIDIZED_COPPER_GRATE);
                output.accept(Items.WAXED_COPPER_GRATE);
                output.accept(Items.WAXED_EXPOSED_COPPER_GRATE);
                output.accept(Items.WAXED_WEATHERED_COPPER_GRATE);
                output.accept(Items.WAXED_OXIDIZED_COPPER_GRATE);
                output.accept(Items.COPPER_BULB);
                output.accept(Items.EXPOSED_COPPER_BULB);
                output.accept(Items.WEATHERED_COPPER_BULB);
                output.accept(Items.OXIDIZED_COPPER_BULB);
                output.accept(Items.WAXED_COPPER_BULB);
                output.accept(Items.WAXED_EXPOSED_COPPER_BULB);
                output.accept(Items.WAXED_WEATHERED_COPPER_BULB);
                output.accept(Items.WAXED_OXIDIZED_COPPER_BULB);
                // Chests
                output.accept(ModBlocks.COPPER_CHEST);
                output.accept(ModBlocks.EXPOSED_COPPER_CHEST);
                output.accept(ModBlocks.WEATHERED_COPPER_CHEST);
                output.accept(ModBlocks.OXIDIZED_COPPER_CHEST);
                output.accept(ModBlocks.WAXED_COPPER_CHEST);
                output.accept(ModBlocks.WAXED_EXPOSED_COPPER_CHEST);
                output.accept(ModBlocks.WAXED_WEATHERED_COPPER_CHEST);
                output.accept(ModBlocks.WAXED_OXIDIZED_COPPER_CHEST);
                // Doors & Trapdoors
                ModBlocks.COPPER_DOORS.values().forEach(s -> output.accept(s.get().asItem()));
                ModBlocks.COPPER_TRAPDOORS.values().forEach(s -> output.accept(s.get().asItem()));
                // Buttons & Pressure Plates
                ModBlocks.COPPER_BUTTONS.values().forEach(s -> output.accept(s.get().asItem()));
                ModBlocks.COPPER_PRESSURE_PLATES.values().forEach(s -> output.accept(s.get().asItem()));
                // Torch
                output.accept(ModBlocks.COPPER_TORCH);
                // Lanterns & Soul Lanterns
                ModBlocks.COPPER_LANTERNS.values().forEach(s -> output.accept(s.get().asItem()));
                ModBlocks.COPPER_SOUL_LANTERNS.values().forEach(s -> output.accept(s.get().asItem()));
                // Chains, Bars, Ladders
                ModBlocks.COPPER_CHAINS.values().forEach(s -> output.accept(s.get().asItem()));
                ModBlocks.COPPER_BARS.values().forEach(s -> output.accept(s.get().asItem()));
                ModBlocks.COPPER_LADDERS.values().forEach(s -> output.accept(s.get().asItem()));
                // Hoppers
                ModBlocks.COPPER_HOPPERS.values().forEach(s -> output.accept(s.get().asItem()));
                // Cauldrons
                ModBlocks.COPPER_CAULDRONS.values().forEach(s -> output.accept(s.get().asItem()));
                // Rails
                ModBlocks.COPPER_RAILS.values().forEach(s -> output.accept(s.get().asItem()));
                // Anvils
                ModBlocks.COPPER_ANVILS.values().forEach(s -> output.accept(s.get().asItem()));
                // Lightning Rods
                ModBlocks.LIGHTNING_RODS.values().forEach(s -> output.accept(s.get().asItem()));
                // Golem Statues
                ModBlocks.COPPER_GOLEM_STATUES.values().forEach(s -> output.accept(s.get().asItem()));
            }),

    GRADIENTS("gradients",
            () -> ModBlocks.getAllGradientBlocks().iterator().next().get().asItem(),
            (params, output) -> {
                ModBlocks.getAllGradientBlocks().forEach(output::accept);
            }),

    VANPLUS("vanplus",
            () -> ModBlocks.OAK_BANNISTER.get().asItem(),
            (params, output) -> {
                ModBlocks.VANILLA_STRUCTURAL_SETS.values().forEach(set -> {
                    output.accept(set.beam());
                    output.accept(set.pergola());
                    output.accept(set.planksPlate());
                    output.accept(set.planksEdge());
                    output.accept(set.bannister());
                    output.accept(set.supportSlab());
                    output.accept(set.supportBeam());
                    output.accept(set.geometricWindow());
                });

     }),

    MOSAIC("mosaic",
            () -> ModBlocks.WATER_MOSAIC_TRADITIONAL.get().asItem(),
            (params, output) -> {
                output.accept(ModBlocks.WATER_MOSAIC_BORDER);
                output.accept(ModBlocks.WATER_MOSAIC_GEOMETRIC);
                output.accept(ModBlocks.WATER_MOSAIC_PATTERN);
                output.accept(ModBlocks.WATER_MOSAIC_DELICATE);
                output.accept(ModBlocks.EARTH_MOSAIC_BORDER);
                output.accept(ModBlocks.EARTH_MOSAIC_GEOMETRIC);
                output.accept(ModBlocks.EARTH_MOSAIC_PATTERN);
                output.accept(ModBlocks.EARTH_MOSAIC_DELICATE);
                output.accept(ModBlocks.FIRE_MOSAIC_BORDER);
                output.accept(ModBlocks.FIRE_MOSAIC_GEOMETRIC);
                output.accept(ModBlocks.FIRE_MOSAIC_PATTERN);
                output.accept(ModBlocks.FIRE_MOSAIC_DELICATE);
                output.accept(ModBlocks.SPIRIT_MOSAIC_BORDER);
                output.accept(ModBlocks.SPIRIT_MOSAIC_GEOMETRIC);
                output.accept(ModBlocks.SPIRIT_MOSAIC_PATTERN);
                output.accept(ModBlocks.SPIRIT_MOSAIC_DELICATE);
                output.accept(ModBlocks.AIR_MOSAIC_BORDER);
                output.accept(ModBlocks.AIR_MOSAIC_GEOMETRIC);
                output.accept(ModBlocks.AIR_MOSAIC_PATTERN);
                output.accept(ModBlocks.AIR_MOSAIC_DELICATE);

                // Mosaic traditional base blocks + stone-set shapes
                java.util.function.BiConsumer<net.neoforged.neoforge.registries.DeferredBlock<?>, String> mosaicEmit =
                        (base, name) -> {
                    output.accept(base);
                    ModBlocks.StoneSetBlocks set = ModBlocks.STONE_SETS.get(name);
                    if (set == null) return;
                    output.accept(set.plate());
                    output.accept(set.edge());
                    output.accept(set.beam());
                    output.accept(set.pergola());
                    output.accept(set.geometricWindow());
                    output.accept(set.bannister());
                    output.accept(set.supportSlab());
                    output.accept(set.supportBeam());
                };
                mosaicEmit.accept(ModBlocks.WATER_MOSAIC_TRADITIONAL,  "water_mosaic_traditional");
                mosaicEmit.accept(ModBlocks.EARTH_MOSAIC_TRADITIONAL,  "earth_mosaic_traditional");
                mosaicEmit.accept(ModBlocks.FIRE_MOSAIC_TRADITIONAL,   "fire_mosaic_traditional");
                mosaicEmit.accept(ModBlocks.SPIRIT_MOSAIC_TRADITIONAL, "spirit_mosaic_traditional");
                mosaicEmit.accept(ModBlocks.AIR_MOSAIC_TRADITIONAL,    "air_mosaic_traditional");

                output.accept(ModBlocks.MOSAIC_FLOOR);
                output.accept(ModBlocks.MOSAIC_FLOOR_DELICATE);
                output.accept(ModBlocks.MOSAIC_FLOOR_ROSETTE);
                output.accept(ModBlocks.ROMAN_FRESCO_RED);
                output.accept(ModBlocks.ROMAN_FRESCO_BLACK);

                output.accept(ModBlocks.LIMESTONE_MASONRY);
                output.accept(ModBlocks.LIMESTONE_MASONRY_EDGE);
                output.accept(ModBlocks.LIMESTONE_MASONRY_PLATE);

                output.accept(ModBlocks.STONE_BRICKS_MASONRY);
                output.accept(ModBlocks.STONE_BRICKS_MASONRY_EDGE);
                output.accept(ModBlocks.STONE_BRICKS_MASONRY_PLATE);

                output.accept(ModBlocks.ORNAMENTED_RED_WOOL);
                output.accept(ModBlocks.ORNAMENTED_RED_CARPET);
                output.accept(ModBlocks.DELICATE_RED_WOOL);
                output.accept(ModBlocks.DELICATE_RED_CARPET);
                output.accept(ModBlocks.ORNAMENTED_BLUE_WOOL);
                output.accept(ModBlocks.ORNAMENTED_BLUE_CARPET);
                output.accept(ModBlocks.DELICATE_BLUE_WOOL);
                output.accept(ModBlocks.DELICATE_BLUE_CARPET);
                output.accept(ModBlocks.ORNAMENTED_GREEN_WOOL);
                output.accept(ModBlocks.ORNAMENTED_GREEN_CARPET);
                output.accept(ModBlocks.DELICATE_GREEN_WOOL);
                output.accept(ModBlocks.DELICATE_GREEN_CARPET);
                output.accept(ModBlocks.ORNAMENTED_PURPLE_WOOL);
                output.accept(ModBlocks.ORNAMENTED_PURPLE_CARPET);
                output.accept(ModBlocks.DELICATE_PURPLE_WOOL);
                output.accept(ModBlocks.DELICATE_PURPLE_CARPET);
            }),

    // ── Vanilla Plus: Stone ───────────────────────────────────────────────────
    STONE_VANILLA("stone_vanilla",
            () -> ModBlocks.STONE_SETS.get("stone").plate().get().asItem(),
            (params, output) -> {
                java.util.List<java.util.List<com.otterly76.ott.block.stone.ModStoneVariants.StoneVariant>> groups =
                        java.util.List.of(
                                com.otterly76.ott.block.stone.ModStoneVariants.CLASSIC,
                                com.otterly76.ott.block.stone.ModStoneVariants.DEEPSLATE,
                                com.otterly76.ott.block.stone.ModStoneVariants.SANDSTONE,
                                com.otterly76.ott.block.stone.ModStoneVariants.NETHER,
                                com.otterly76.ott.block.stone.ModStoneVariants.END_MISC,
                                com.otterly76.ott.block.stone.ModStoneVariants.MINERALS,
                                com.otterly76.ott.block.stone.ModStoneVariants.COPPER
                        );
                for (var group : groups) {
                    group.forEach(v -> {
                        ModBlocks.StoneSetBlocks set = ModBlocks.STONE_SETS.get(v.name());
                        if (set == null) return;
                        output.accept(set.plate());
                        output.accept(set.edge());
                        output.accept(set.beam());
                        output.accept(set.pergola());
                        output.accept(set.geometricWindow());
                        output.accept(set.bannister());
                        output.accept(set.supportSlab());
                        output.accept(set.supportBeam());
                    });
                }
            }),

    // ── Custom OTT Stone Sets ─────────────────────────────────────────────────
    STONE_CUSTOM("stone_custom",
            () -> ModBlocks.PLAIN_LIMESTONE.get().asItem(),
            (params, output) -> {
                // Helper: emit base block then its 8 stone-set shapes
                java.util.function.Consumer<String> emit = name -> {
                    ModBlocks.StoneSetBlocks set = ModBlocks.STONE_SETS.get(name);
                    if (set == null) return;
                    output.accept(set.plate());
                    output.accept(set.edge());
                    output.accept(set.beam());
                    output.accept(set.pergola());
                    output.accept(set.geometricWindow());
                    output.accept(set.bannister());
                    output.accept(set.supportSlab());
                    output.accept(set.supportBeam());
                };

                output.accept(ModBlocks.PLAIN_LIMESTONE);      emit.accept("limestone");
                output.accept(ModBlocks.COBBLED_LIMESTONE);    emit.accept("cobbled_limestone");
                output.accept(ModBlocks.REFINED_GLOWSTONE);    emit.accept("refined_glowstone");
                output.accept(ModBlocks.ROOFING_SLATES);       emit.accept("roofing_slates");

                output.accept(ModBlocks.BLACK_MARBLE);                emit.accept("black_marble");
                output.accept(ModBlocks.BLACK_MARBLE_BRICKS);         emit.accept("black_marble_bricks");
                output.accept(ModBlocks.BLACK_MARBLE_SMALL_BRICKS);   emit.accept("black_marble_small_bricks");
                output.accept(ModBlocks.BLACK_MARBLE_TILES);          emit.accept("black_marble_tiles");
                output.accept(ModBlocks.BLACK_POLISHED_MARBLE);       emit.accept("black_polished_marble");
                output.accept(ModBlocks.BLACK_MARBLE_PILLAR);
                output.accept(ModBlocks.BLACK_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.BLACK_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.BLACK_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.BLACK_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.WHITE_MARBLE);                emit.accept("white_marble");
                output.accept(ModBlocks.WHITE_MARBLE_BRICKS);         emit.accept("white_marble_bricks");
                output.accept(ModBlocks.WHITE_MARBLE_SMALL_BRICKS);   emit.accept("white_marble_small_bricks");
                output.accept(ModBlocks.WHITE_MARBLE_TILES);          emit.accept("white_marble_tiles");
                output.accept(ModBlocks.WHITE_POLISHED_MARBLE);       emit.accept("white_polished_marble");
                output.accept(ModBlocks.WHITE_MARBLE_PILLAR);
                output.accept(ModBlocks.WHITE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.WHITE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.WHITE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.WHITE_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.AMETHYST_MARBLE);                emit.accept("amethyst_marble");
                output.accept(ModBlocks.AMETHYST_MARBLE_BRICKS);         emit.accept("amethyst_marble_bricks");
                output.accept(ModBlocks.AMETHYST_MARBLE_SMALL_BRICKS);   emit.accept("amethyst_marble_small_bricks");
                output.accept(ModBlocks.AMETHYST_MARBLE_TILES);          emit.accept("amethyst_marble_tiles");
                output.accept(ModBlocks.AMETHYST_POLISHED_MARBLE);       emit.accept("amethyst_polished_marble");
                output.accept(ModBlocks.AMETHYST_MARBLE_PILLAR);
                output.accept(ModBlocks.AMETHYST_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.AMETHYST_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.AMETHYST_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.AMETHYST_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.BLUE_MARBLE);                emit.accept("blue_marble");
                output.accept(ModBlocks.BLUE_MARBLE_BRICKS);         emit.accept("blue_marble_bricks");
                output.accept(ModBlocks.BLUE_MARBLE_SMALL_BRICKS);   emit.accept("blue_marble_small_bricks");
                output.accept(ModBlocks.BLUE_MARBLE_TILES);          emit.accept("blue_marble_tiles");
                output.accept(ModBlocks.BLUE_POLISHED_MARBLE);       emit.accept("blue_polished_marble");
                output.accept(ModBlocks.BLUE_MARBLE_PILLAR);
                output.accept(ModBlocks.BLUE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.BLUE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.BLUE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.BLUE_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.CYAN_MARBLE);                emit.accept("cyan_marble");
                output.accept(ModBlocks.CYAN_MARBLE_BRICKS);         emit.accept("cyan_marble_bricks");
                output.accept(ModBlocks.CYAN_MARBLE_SMALL_BRICKS);   emit.accept("cyan_marble_small_bricks");
                output.accept(ModBlocks.CYAN_MARBLE_TILES);          emit.accept("cyan_marble_tiles");
                output.accept(ModBlocks.CYAN_POLISHED_MARBLE);       emit.accept("cyan_polished_marble");
                output.accept(ModBlocks.CYAN_MARBLE_PILLAR);
                output.accept(ModBlocks.CYAN_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.CYAN_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.CYAN_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.CYAN_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.GREEN_MARBLE);                emit.accept("green_marble");
                output.accept(ModBlocks.GREEN_MARBLE_BRICKS);         emit.accept("green_marble_bricks");
                output.accept(ModBlocks.GREEN_MARBLE_SMALL_BRICKS);   emit.accept("green_marble_small_bricks");
                output.accept(ModBlocks.GREEN_MARBLE_TILES);          emit.accept("green_marble_tiles");
                output.accept(ModBlocks.GREEN_POLISHED_MARBLE);       emit.accept("green_polished_marble");
                output.accept(ModBlocks.GREEN_MARBLE_PILLAR);
                output.accept(ModBlocks.GREEN_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.GREEN_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.GREEN_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.GREEN_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.LIME_MARBLE);                emit.accept("lime_marble");
                output.accept(ModBlocks.LIME_MARBLE_BRICKS);         emit.accept("lime_marble_bricks");
                output.accept(ModBlocks.LIME_MARBLE_SMALL_BRICKS);   emit.accept("lime_marble_small_bricks");
                output.accept(ModBlocks.LIME_MARBLE_TILES);          emit.accept("lime_marble_tiles");
                output.accept(ModBlocks.LIME_POLISHED_MARBLE);       emit.accept("lime_polished_marble");
                output.accept(ModBlocks.LIME_MARBLE_PILLAR);
                output.accept(ModBlocks.LIME_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.LIME_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.LIME_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.LIME_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.ORANGE_MARBLE);                emit.accept("orange_marble");
                output.accept(ModBlocks.ORANGE_MARBLE_BRICKS);         emit.accept("orange_marble_bricks");
                output.accept(ModBlocks.ORANGE_MARBLE_SMALL_BRICKS);   emit.accept("orange_marble_small_bricks");
                output.accept(ModBlocks.ORANGE_MARBLE_TILES);          emit.accept("orange_marble_tiles");
                output.accept(ModBlocks.ORANGE_POLISHED_MARBLE);       emit.accept("orange_polished_marble");
                output.accept(ModBlocks.ORANGE_MARBLE_PILLAR);
                output.accept(ModBlocks.ORANGE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.ORANGE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.ORANGE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.ORANGE_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.PINK_MARBLE);                emit.accept("pink_marble");
                output.accept(ModBlocks.PINK_MARBLE_BRICKS);         emit.accept("pink_marble_bricks");
                output.accept(ModBlocks.PINK_MARBLE_SMALL_BRICKS);   emit.accept("pink_marble_small_bricks");
                output.accept(ModBlocks.PINK_MARBLE_TILES);          emit.accept("pink_marble_tiles");
                output.accept(ModBlocks.PINK_POLISHED_MARBLE);       emit.accept("pink_polished_marble");
                output.accept(ModBlocks.PINK_MARBLE_PILLAR);
                output.accept(ModBlocks.PINK_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.PINK_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.PINK_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.PINK_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.PURPLE_MARBLE);                emit.accept("purple_marble");
                output.accept(ModBlocks.PURPLE_MARBLE_BRICKS);         emit.accept("purple_marble_bricks");
                output.accept(ModBlocks.PURPLE_MARBLE_SMALL_BRICKS);   emit.accept("purple_marble_small_bricks");
                output.accept(ModBlocks.PURPLE_MARBLE_TILES);          emit.accept("purple_marble_tiles");
                output.accept(ModBlocks.PURPLE_POLISHED_MARBLE);       emit.accept("purple_polished_marble");
                output.accept(ModBlocks.PURPLE_MARBLE_PILLAR);
                output.accept(ModBlocks.PURPLE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.PURPLE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.PURPLE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.PURPLE_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.RED_MARBLE);                emit.accept("red_marble");
                output.accept(ModBlocks.RED_MARBLE_BRICKS);         emit.accept("red_marble_bricks");
                output.accept(ModBlocks.RED_MARBLE_SMALL_BRICKS);   emit.accept("red_marble_small_bricks");
                output.accept(ModBlocks.RED_MARBLE_TILES);          emit.accept("red_marble_tiles");
                output.accept(ModBlocks.RED_POLISHED_MARBLE);       emit.accept("red_polished_marble");
                output.accept(ModBlocks.RED_MARBLE_PILLAR);
                output.accept(ModBlocks.RED_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.RED_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.RED_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.RED_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.YELLOW_MARBLE);                emit.accept("yellow_marble");
                output.accept(ModBlocks.YELLOW_MARBLE_BRICKS);         emit.accept("yellow_marble_bricks");
                output.accept(ModBlocks.YELLOW_MARBLE_SMALL_BRICKS);   emit.accept("yellow_marble_small_bricks");
                output.accept(ModBlocks.YELLOW_MARBLE_TILES);          emit.accept("yellow_marble_tiles");
                output.accept(ModBlocks.YELLOW_POLISHED_MARBLE);       emit.accept("yellow_polished_marble");
                output.accept(ModBlocks.YELLOW_MARBLE_PILLAR);
                output.accept(ModBlocks.YELLOW_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.YELLOW_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.YELLOW_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.YELLOW_MARBLE_DIAMOND_PAVERS);

                output.accept(ModBlocks.SANDSTONE_SLENDER_BRICKS);          emit.accept("sandstone_slender_bricks");
                output.accept(ModBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN); emit.accept("sandstone_slender_turquoise_pattern");
            }),

    BLOCKS("blocks",
            () -> ModBlocks.MIXED_LIMESTONE_BRICKS.get().asItem(),
            (params, output) -> {
                output.accept(ModBlocks.MIXED_LIMESTONE_BRICKS);
                ModBlocks.SEAGLASS.forEach(output::accept);  // ethereal seaglass only
                ModBlocks.TESTBLOCK.forEach(output::accept);

                output.accept(ModBlocks.WHEAT_THATCH);
                output.accept(ModBlocks.WHEAT_THATCH_EDGE);
                output.accept(ModBlocks.WHEAT_THATCH_PLATE);

                output.accept(ModBlocks.BAMBOO_THATCH);
                output.accept(ModBlocks.BAMBOO_THATCH_EDGE);
                output.accept(ModBlocks.BAMBOO_THATCH_PLATE);

                output.accept(ModBlocks.SOUL_GLASS);
                output.accept(ModBlocks.SOUL_GLASS_PANE);
                output.accept(ModBlocks.SOUL_GLASS_CTM);
                output.accept(ModBlocks.SOUL_GLASS_CTM_PANE);

                // Opal crystal sets — raw stone blocks only; buds/crystals are in MISC, decorative in ENGRAVED
                ModBlocks.OPAL_SETS.values().forEach(set -> {
                    output.accept(set.base());
                    output.accept(set.crystalBlock());
                    output.accept(set.budding());
                });

                output.accept(ModBlocks.CHISELED_PLASTERED_STONE_PILLAR);
            }),

    // ── Engraved / Connecting Blocks ──────────────────────────────────────────
    ENGRAVED("engraved",
            () -> ModBlocks.CHAOTIC_STONE_BRICKS.get().asItem(),
            (params, output) -> {
                // Stone variants

                // New plain cube_all stone blocks
                output.accept(ModBlocks.CHAOTIC_STONE_BRICKS);
                output.accept(ModBlocks.CHAOTIC_MEDIUM_STONE_BRICKS);
                output.accept(ModBlocks.CHAOTIC_SMALL_STONE_BRICKS);
                output.accept(ModBlocks.DIAMOND_STONE_PAVERS);
                output.accept(ModBlocks.ENCASED_STONE_BRICKS);
                output.accept(ModBlocks.FRENCH_STONE);
                output.accept(ModBlocks.LARGE_ORNATE_STONE);
                output.accept(ModBlocks.LARGE_STONE_TILE);
                output.accept(ModBlocks.MESSY_STONE_TILES);
                output.accept(ModBlocks.MOSAIC_STONE);
                output.accept(ModBlocks.NOTCHED_STONE_BRICKS);
                output.accept(ModBlocks.ORNATE_STONE);
                output.accept(ModBlocks.POISON_STONE);
                output.accept(ModBlocks.POLISHED_CUT_STONE);
                output.accept(ModBlocks.POLISHED_STONE_TILES);
                output.accept(ModBlocks.PRISM_STONE);
                output.accept(ModBlocks.SLANTED_STONE);
                output.accept(ModBlocks.STONE_ARRAY);
                output.accept(ModBlocks.STONE_BRAID);
                output.accept(ModBlocks.STONE_DENT);
                output.accept(ModBlocks.STONE_JELLYBEAN);
                output.accept(ModBlocks.STONE_LAYERS);
                output.accept(ModBlocks.STONE_PANEL);
                output.accept(ModBlocks.STONE_ROAD);
                output.accept(ModBlocks.STONE_ZAG);
                output.accept(ModBlocks.SUNKEN_STONE);
                output.accept(ModBlocks.TRIPLE_STONE_BRICKS);
                output.accept(ModBlocks.WEATHERED_STONE_BRICKS);
                output.accept(ModBlocks.WEATHERED_TILED_STONE);
                output.accept(ModBlocks.WEAVER_STONE);
                // Cube-bottom-top carved stone blocks
                output.accept(ModBlocks.CUT_STONE);
                output.accept(ModBlocks.ROUGH_CUT_STONE);
                // New pillar blocks
                output.accept(ModBlocks.SHEARED_STONE_PILLAR);
                output.accept(ModBlocks.SLATED_STONE);
                output.accept(ModBlocks.STONE_COLUMN);
                output.accept(ModBlocks.STONE_TWISTING_COLUMN);
                // Chisel pillar blocks
                ModBlocks.CHISEL_PILLARS.values().forEach(output::accept);
                // Legend blocks
                ModBlocks.CHISEL_LEGEND.values().forEach(output::accept);

                // CTM blocks
                // CTM vertical pillars

                // Opal decorative variants
                ModBlocks.OPAL_SETS.values().forEach(set -> {
                    output.accept(set.polished());
                    output.accept(set.cut());
                    output.accept(set.bricks());
                    output.accept(set.smallBricks());
                    output.accept(set.chiseled());
                    output.accept(set.pillar());
                    output.accept(set.tiles());
                    output.accept(set.smallTiles());
                    output.accept(set.glass());
                    output.accept(set.glassPane());
                    output.accept(set.tiling());
                });

                // Wood door variants
                ModItems.WOOD_DOOR_ITEMS.values().forEach(woodMap -> woodMap.values().forEach(output::accept));

                // Extra wood doors (new-style naming)
                ModBlocks.EXTRA_DOORS.values().forEach(output::accept);

                // Wood trapdoors
                ModBlocks.WOOD_TRAPDOORS.values().forEach(output::accept);

                // Bookshelves
                ModBlocks.BOOKSHELVES.values().forEach(output::accept);

                // ── Leaves ───────────────────────────────────────────────────────
                // Acacia Leaves

                // Birch Leaves

                // Dark Oak Leaves

                // Jungle Leaves

                // Oak Leaves

                // Spruce Leaves


                // ── Batch CTM blocks ──────────────────────────────────────────────
        // Acacia Planks

        // Amethyst Block

        // Ancient Debris

        // Andesite

        // Bamboo Planks

        // Basalt

        // Birch Planks

        // Blackstone

        // Black Concrete

        // Black Stained Glass
        output.accept(ModBlocks.BLACK_LEADED_STAINED_GLASS);

        // Black Terracotta

        // Black Wool

        // Blue Concrete

        // Blue Ice

        // Blue Stained Glass
        output.accept(ModBlocks.BLUE_LEADED_STAINED_GLASS);

        // Blue Terracotta

        // Blue Wool

        // Borderless Bricks

        // Bricks

        // Brown Concrete

        // Brown Stained Glass
        output.accept(ModBlocks.BROWN_LEADED_STAINED_GLASS);

        // Brown Terracotta

        // Brown Wool

        // Calcite

        // Cherry Planks
        output.accept(ModBlocks.CORNERED_CHERRY_PLANKS);
        output.accept(ModBlocks.CRATED_CHERRY_PLANKS);
        output.accept(ModBlocks.ENCLOSED_CHERRY_PLANKS);
        output.accept(ModBlocks.FRAMED_CHERRY_PLANKS);
        output.accept(ModBlocks.NATURAL_CHERRY_PLANKS);
        output.accept(ModBlocks.PEGGED_CHERRY_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_CHERRY_PLANKS);

        // Clay

        // Coal Block

        // Cobblestone

        // Crimson Planks
        output.accept(ModBlocks.CORNERED_CRIMSON_PLANKS);
        output.accept(ModBlocks.CRATED_CRIMSON_PLANKS);
        output.accept(ModBlocks.ENCLOSED_CRIMSON_PLANKS);
        output.accept(ModBlocks.FRAMED_CRIMSON_PLANKS);
        output.accept(ModBlocks.NATURAL_CRIMSON_PLANKS);
        output.accept(ModBlocks.PEGGED_CRIMSON_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_CRIMSON_PLANKS);

        // Crying Obsidian

        // Cyan Concrete

        // Cyan Stained Glass
        output.accept(ModBlocks.CYAN_LEADED_STAINED_GLASS);

        // Cyan Terracotta

        // Cyan Wool

        // Dark Oak Planks
        output.accept(ModBlocks.CORNERED_DARK_OAK_PLANKS);
        output.accept(ModBlocks.CRATED_DARK_OAK_PLANKS);
        output.accept(ModBlocks.ENCLOSED_DARK_OAK_PLANKS);
        output.accept(ModBlocks.FRAMED_DARK_OAK_PLANKS);
        output.accept(ModBlocks.NATURAL_DARK_OAK_PLANKS);
        output.accept(ModBlocks.PEGGED_DARK_OAK_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_DARK_OAK_PLANKS);

        // Dark Prismarine

        // Deepslate

        // Diorite

        // Dirt

        // Dripstone

        // End Stone

        // Gilded Blackston

        // Granite

        // Gray Concrete

        // Gray Stained Glass
        output.accept(ModBlocks.GRAY_LEADED_STAINED_GLASS);

        // Gray Terracotta

        // Gray Wool

        // Green Concrete

        // Green Stained Glass
        output.accept(ModBlocks.GREEN_LEADED_STAINED_GLASS);

        // Green Terracotta

        // Green Wool

        // Ice

        // Jungle Planks
        output.accept(ModBlocks.CORNERED_JUNGLE_PLANKS);
        output.accept(ModBlocks.CRATED_JUNGLE_PLANKS);
        output.accept(ModBlocks.ENCLOSED_JUNGLE_PLANKS);
        output.accept(ModBlocks.FRAMED_JUNGLE_PLANKS);
        output.accept(ModBlocks.NATURAL_JUNGLE_PLANKS);
        output.accept(ModBlocks.PEGGED_JUNGLE_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_JUNGLE_PLANKS);

        // Lapis Block

        // Leaded Glass
        output.accept(ModBlocks.CIRCULAR_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_LEADED_GLASS_CTM);

        // Light Blue Concrete

        // Light Blue Stained Glass
        output.accept(ModBlocks.CIRCULAR_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.LIGHT_BLUE_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_LIGHT_BLUE_STAINED_GLASS);

        // Light Blue Terracotta

        // Light Blue Wool

        // Light Gray Concrete

        // Light Gray Stained Glass
        output.accept(ModBlocks.CIRCULAR_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.LIGHT_GRAY_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_LIGHT_GRAY_STAINED_GLASS);

        // Light Gray Terracotta

        // Light Gray Wool

        // Lime Concrete

        // Lime Stained Glass
        output.accept(ModBlocks.CIRCULAR_LIME_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_LIME_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_LIME_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_LIME_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_LIME_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_LIME_STAINED_GLASS_CTM);
        output.accept(ModBlocks.LIME_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_LIME_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_LIME_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_LIME_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_LIME_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_LIME_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_LIME_STAINED_GLASS);
        output.accept(ModBlocks.TILED_LIME_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_LIME_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_LIME_STAINED_GLASS);

        // Lime Terracotta

        // Lime Wool

        // Lodestone

        // Magenta Concrete

        // Magenta Stained Glass
        output.accept(ModBlocks.CIRCULAR_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_MAGENTA_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_MAGENTA_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_MAGENTA_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_MAGENTA_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_MAGENTA_STAINED_GLASS_CTM);
        output.accept(ModBlocks.MAGENTA_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.TILED_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_MAGENTA_STAINED_GLASS);

        // Magenta Terracotta

        // Magenta Wool

        // Magma Block

        // Mangrove Planks
        output.accept(ModBlocks.BRICKED_MANGROVE_PLANKS);
        output.accept(ModBlocks.CORNERED_MANGROVE_PLANKS);
        output.accept(ModBlocks.CRATED_MANGROVE_PLANKS);
        output.accept(ModBlocks.ENCLOSED_MANGROVE_PLANKS);
        output.accept(ModBlocks.FRAMED_MANGROVE_PLANKS);
        output.accept(ModBlocks.NATURAL_MANGROVE_PLANKS);
        output.accept(ModBlocks.PEGGED_MANGROVE_PLANKS);

        // Mossy Cobblestone

        // Mossy Stone

        // Mud

        // Mud Bricks

        // Netherrack

        // Nether Bricks

        // Oak Glass

        // Oak Planks

        // Obsidian

        // Orange Concrete

        // Orange Stained Glass
        output.accept(ModBlocks.CIRCULAR_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_ORANGE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_ORANGE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_ORANGE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_ORANGE_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_ORANGE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORANGE_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.TILED_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_ORANGE_STAINED_GLASS);

        // Orange Terracotta

        // Orange Wool

        // Packed Ice

        // Packed Mud

        // Pink Concrete

        // Pink Stained Glass
        output.accept(ModBlocks.CIRCULAR_PINK_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_PINK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_PINK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_PINK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_PINK_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_PINK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.PINK_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_PINK_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_PINK_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_PINK_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_PINK_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_PINK_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_PINK_STAINED_GLASS);
        output.accept(ModBlocks.TILED_PINK_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_PINK_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_PINK_STAINED_GLASS);

        // Pink Terracotta

        // Pink Wool

        // Prismarine

        // Purple Concrete

        // Purple Stained Glass
        output.accept(ModBlocks.CIRCULAR_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_PURPLE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_PURPLE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_PURPLE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_PURPLE_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_PURPLE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.PURPLE_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.TILED_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_PURPLE_STAINED_GLASS);

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

        // Red Stained Glass
        output.accept(ModBlocks.CIRCULAR_RED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_RED_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_RED_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_RED_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_RED_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_RED_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RED_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_RED_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_RED_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_RED_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_RED_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_RED_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_RED_STAINED_GLASS);
        output.accept(ModBlocks.TILED_RED_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_RED_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_RED_STAINED_GLASS);

        // Red Terracotta

        // Red Wool

        // Sandstone

        // Smooth Stone

        // Snow Block

        // Spruce Planks
        output.accept(ModBlocks.CORNERED_SPRUCE_PLANKS);
        output.accept(ModBlocks.CRATED_SPRUCE_PLANKS);
        output.accept(ModBlocks.ENCLOSED_SPRUCE_PLANKS);
        output.accept(ModBlocks.FRAMED_SPRUCE_PLANKS);
        output.accept(ModBlocks.NATURAL_SPRUCE_PLANKS);
        output.accept(ModBlocks.PEGGED_SPRUCE_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_SPRUCE_PLANKS);

        // Terracotta

        // Tuff

        // Warped Planks
        output.accept(ModBlocks.CORNERED_WARPED_PLANKS);
        output.accept(ModBlocks.CRATED_WARPED_PLANKS);
        output.accept(ModBlocks.ENCLOSED_WARPED_PLANKS);
        output.accept(ModBlocks.FRAMED_WARPED_PLANKS);
        output.accept(ModBlocks.NATURAL_WARPED_PLANKS);
        output.accept(ModBlocks.PEGGED_WARPED_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_WARPED_PLANKS);

        // White Concrete

        // White Stained Glass
        output.accept(ModBlocks.CIRCULAR_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_WHITE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_WHITE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_WHITE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_WHITE_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_WHITE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.WHITE_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.TILED_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_WHITE_STAINED_GLASS);

        // White Terracotta

        // White Wool

        // Yellow Concrete

        // Yellow Stained Glass
        output.accept(ModBlocks.CIRCULAR_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_YELLOW_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_YELLOW_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_YELLOW_STAINED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_YELLOW_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.TILED_YELLOW_STAINED_GLASS_CTM);
        output.accept(ModBlocks.YELLOW_LEADED_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.TILED_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_YELLOW_STAINED_GLASS);

        // Yellow Terracotta

        // Yellow Wool

        // ── New CTM batch blocks ────────────────────────────────────────────
        output.accept(ModBlocks.BAMBOO_WINDOW_TILES_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_TILES_CTM);
        output.accept(ModBlocks.BLACK_FRAMED_GLASS);
        output.accept(ModBlocks.BLACK_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.BLUE_FRAMED_GLASS);
        output.accept(ModBlocks.BLUE_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.BROWN_FRAMED_GLASS);
        output.accept(ModBlocks.BROWN_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.CHISELED_GLASS);
        output.accept(ModBlocks.CLEAR_GLASS);
        output.accept(ModBlocks.CYAN_FRAMED_GLASS);
        output.accept(ModBlocks.CYAN_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.DIRTY_GLASS);
        output.accept(ModBlocks.FRAMED_GLASS);
        output.accept(ModBlocks.FROSTED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_LIME_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_MAGENTA_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_PINK_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_RED_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_WHITE_STAINED_GLASS);
        output.accept(ModBlocks.GOLDEN_FRAMED_YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.GRAY_FRAMED_GLASS);
        output.accept(ModBlocks.GRAY_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.GREEN_FRAMED_GLASS);
        output.accept(ModBlocks.GREEN_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.LIGHT_BLUE_FRAMED_GLASS);
        output.accept(ModBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.LIGHT_GRAY_FRAMED_GLASS);
        output.accept(ModBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.LIME_FRAMED_GLASS);
        output.accept(ModBlocks.LIME_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.MAGENTA_FRAMED_GLASS);
        output.accept(ModBlocks.MAGENTA_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.OBSIDIAN_FRAMED_GLASS);
        output.accept(ModBlocks.ORANGE_FRAMED_GLASS);
        output.accept(ModBlocks.ORANGE_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.PALE_OAK_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.PINK_FRAMED_GLASS);
        output.accept(ModBlocks.PINK_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.POLISHED_LIMESTONE);
        output.accept(ModBlocks.PURPLE_FRAMED_GLASS);
        output.accept(ModBlocks.PURPLE_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.RED_FRAMED_GLASS);
        output.accept(ModBlocks.RED_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.SANDSTONE_FRAMED_GLASS);
        output.accept(ModBlocks.SEA_LANTERN);
        output.accept(ModBlocks.STONE_FRAMED_GLASS);
        output.accept(ModBlocks.TINTED_CLEAR_GLASS);
        output.accept(ModBlocks.WHITE_FRAMED_GLASS);
        output.accept(ModBlocks.WHITE_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.YELLOW_FRAMED_GLASS);
        output.accept(ModBlocks.YELLOW_STAINED_CLEAR_GLASS);
        output.accept(ModBlocks.BLACK_STAINED_GLASS);
        output.accept(ModBlocks.BLUE_STAINED_GLASS);


        output.accept(ModBlocks.BORDERLESS_GLASS);
        output.accept(ModBlocks.BORDERLESS_GLASS_BLACK);
        output.accept(ModBlocks.BORDERLESS_GLASS_BLUE);
        output.accept(ModBlocks.BORDERLESS_GLASS_BROWN);
        output.accept(ModBlocks.BORDERLESS_GLASS_CYAN);
        output.accept(ModBlocks.BORDERLESS_GLASS_GRAY);
        output.accept(ModBlocks.BORDERLESS_GLASS_GREEN);
        output.accept(ModBlocks.BORDERLESS_GLASS_LIGHT_BLUE);
        output.accept(ModBlocks.BORDERLESS_GLASS_LIGHT_GRAY);
        output.accept(ModBlocks.BORDERLESS_GLASS_LIME);
        output.accept(ModBlocks.BORDERLESS_GLASS_MAGENTA);
        output.accept(ModBlocks.BORDERLESS_GLASS_ORANGE);
        output.accept(ModBlocks.BORDERLESS_GLASS_PINK);
        output.accept(ModBlocks.BORDERLESS_GLASS_PURPLE);
        output.accept(ModBlocks.BORDERLESS_GLASS_RED);
        output.accept(ModBlocks.BORDERLESS_GLASS_WHITE);
        output.accept(ModBlocks.BORDERLESS_GLASS_YELLOW);
        output.accept(ModBlocks.BROWN_STAINED_GLASS);



        output.accept(ModBlocks.COPPER_BLOCK);
        output.accept(ModBlocks.COPPER_GRATE);
        output.accept(ModBlocks.CYAN_STAINED_GLASS);
        output.accept(ModBlocks.EXPOSED_COPPER_BLOCK);
        output.accept(ModBlocks.EXPOSED_COPPER_GRATE);
        output.accept(ModBlocks.GRAY_STAINED_GLASS);
        output.accept(ModBlocks.GREEN_STAINED_GLASS);
        output.accept(ModBlocks.ICE_GLASS);

        output.accept(ModBlocks.LIGHT_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.LIGHT_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.LIME_STAINED_GLASS);
        output.accept(ModBlocks.MAGENTA_STAINED_GLASS);

        output.accept(ModBlocks.ORANGE_STAINED_GLASS);
        output.accept(ModBlocks.OXIDIZED_COPPER_BLOCK);
        output.accept(ModBlocks.OXIDIZED_COPPER_GRATE);
        output.accept(ModBlocks.PALE_OAK_PLANKS_BEAMS);
        output.accept(ModBlocks.PALE_OAK_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.PALE_OAK_PLANKS_CRATE);
        output.accept(ModBlocks.PALE_OAK_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.PALE_OAK_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.PALE_OAK_PLANKS_DOTTED);
        output.accept(ModBlocks.PALE_OAK_PLANKS_FLOORING);
        output.accept(ModBlocks.PALE_OAK_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.PALE_OAK_PLANKS_PATTERN);
        output.accept(ModBlocks.PALE_OAK_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.PALE_OAK_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.PALE_OAK_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.PALE_OAK_PLANKS_SQUARES);
        output.accept(ModBlocks.PALE_OAK_PLANKS_TILES);
        output.accept(ModBlocks.PALE_OAK_PLANKS_WAVY);
        output.accept(ModBlocks.PALE_OAK_PLANKS_WOVEN);
        output.accept(ModBlocks.PINK_STAINED_GLASS);
        output.accept(ModBlocks.PURPLE_STAINED_GLASS);
        output.accept(ModBlocks.RED_STAINED_GLASS);
        output.accept(ModBlocks.REINFORCED_GLASS);
        output.accept(ModBlocks.SCRATCHED_GLASS);
        output.accept(ModBlocks.SCRATCHED_GLASS_BLACK);
        output.accept(ModBlocks.SCRATCHED_GLASS_BLUE);
        output.accept(ModBlocks.SCRATCHED_GLASS_BROWN);
        output.accept(ModBlocks.SCRATCHED_GLASS_CYAN);
        output.accept(ModBlocks.SCRATCHED_GLASS_GRAY);
        output.accept(ModBlocks.SCRATCHED_GLASS_GREEN);
        output.accept(ModBlocks.SCRATCHED_GLASS_LIGHT_BLUE);
        output.accept(ModBlocks.SCRATCHED_GLASS_LIGHT_GRAY);
        output.accept(ModBlocks.SCRATCHED_GLASS_LIME);
        output.accept(ModBlocks.SCRATCHED_GLASS_MAGENTA);
        output.accept(ModBlocks.SCRATCHED_GLASS_ORANGE);
        output.accept(ModBlocks.SCRATCHED_GLASS_PINK);
        output.accept(ModBlocks.SCRATCHED_GLASS_PURPLE);
        output.accept(ModBlocks.SCRATCHED_GLASS_RED);
        output.accept(ModBlocks.SCRATCHED_GLASS_WHITE);
        output.accept(ModBlocks.SCRATCHED_GLASS_YELLOW);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_BLACK);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_BLUE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_BROWN);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_CYAN);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_GRAY);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_GREEN);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_BLUE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_GRAY);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_LIME);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_MAGENTA);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_ORANGE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_PINK);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_PURPLE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_RED);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_WHITE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_YELLOW);
        output.accept(ModBlocks.TINTED_GLASS);
        output.accept(ModBlocks.WEATHERED_COPPER_BLOCK);
        output.accept(ModBlocks.WEATHERED_COPPER_GRATE);
        output.accept(ModBlocks.WHITE_STAINED_GLASS);
        output.accept(ModBlocks.YELLOW_STAINED_GLASS);
        output.accept(ModBlocks.PALE_OAK_PLANKS_BRICKS);
        output.accept(ModBlocks.BAMBOO_WINDOW_BARS_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_PANES_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_TILES_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_BARS_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_PANES_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.CHERRY_WINDOW_TILES_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_BARS_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_PANES_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_TILES_CTM);
        output.accept(ModBlocks.BAMBOO_WINDOW_BARS);
        output.accept(ModBlocks.BAMBOO_WINDOW_COVERED);
        output.accept(ModBlocks.BAMBOO_WINDOW_DIAGONAL);
        output.accept(ModBlocks.BAMBOO_WINDOW_LARGE);
        output.accept(ModBlocks.BAMBOO_WINDOW_PANES);
        output.accept(ModBlocks.BAMBOO_WINDOW_ROUNDED);
        output.accept(ModBlocks.BAMBOO_WINDOW_SLIM);
        output.accept(ModBlocks.BAMBOO_WINDOW_SWIRLING);
        output.accept(ModBlocks.CHERRY_WINDOW_BARS);
        output.accept(ModBlocks.CHERRY_WINDOW_COVERED);
        output.accept(ModBlocks.CHERRY_WINDOW_DIAGONAL);
        output.accept(ModBlocks.CHERRY_WINDOW_LARGE);
        output.accept(ModBlocks.CHERRY_WINDOW_PANES);
        output.accept(ModBlocks.CHERRY_WINDOW_ROUNDED);
        output.accept(ModBlocks.CHERRY_WINDOW_SLIM);
        output.accept(ModBlocks.CHERRY_WINDOW_SWIRLING);
        output.accept(ModBlocks.PALE_OAK_WINDOW_BARS);
        output.accept(ModBlocks.PALE_OAK_WINDOW_COVERED);
        output.accept(ModBlocks.PALE_OAK_WINDOW_DIAGONAL);
        output.accept(ModBlocks.PALE_OAK_WINDOW_LARGE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_PANES);
        output.accept(ModBlocks.PALE_OAK_WINDOW_ROUNDED);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SLIM);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SWIRLING);
        output.accept(ModBlocks.PALE_OAK_WINDOW_TILES);

        // Glass/ plain blocks
        output.accept(ModBlocks.LEADED_GLASS);
        output.accept(ModBlocks.GLASS_OCHRE_FROGLIGHT);
        output.accept(ModBlocks.GLASS_PEARLESCENT_FROGLIGHT);
        output.accept(ModBlocks.GLASS_VERDANT_FROGLIGHT);
        // Window panes
        output.accept(ModBlocks.BAMBOO_WINDOW_BARS_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_PANES_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_TILES_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_BARS_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_PANES_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_TILES_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_BARS_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_PANES_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_TILES_PANE);
        // Leaded glass panes
        output.accept(ModBlocks.CIRCULAR_LEADED_STAINED_GLASS_PANE);
        // Stained glass panes
        output.accept(ModBlocks.BLACK_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.BLUE_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.BROWN_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CYAN_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.GRAY_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.GREEN_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LIGHT_BLUE_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_LIGHT_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LIGHT_GRAY_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_LIGHT_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LIME_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_LIME_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.MAGENTA_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_MAGENTA_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORANGE_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_ORANGE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.PINK_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_PINK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.PURPLE_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_PURPLE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RED_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_RED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WHITE_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_WHITE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.YELLOW_LEADED_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_YELLOW_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_YELLOW_STAINED_GLASS_PANE);
        // glass/ panes
        output.accept(ModBlocks.LEADED_GLASS_PANE);
        output.accept(ModBlocks.CHISELED_GLASS_CTM_PANE);
        output.accept(ModBlocks.CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.DIRTY_GLASS_CTM_PANE);
        output.accept(ModBlocks.FROSTED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ICE_GLASS_CTM_PANE);
        output.accept(ModBlocks.OBSIDIAN_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.REINFORCED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SANDSTONE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.STONE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_GLASS_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.CHERRY_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.BAMBOO_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.PALE_OAK_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.WHITE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_WHITE_CTM_PANE);
        output.accept(ModBlocks.SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_WHITE_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_WHITE_CTM_PANE);
        output.accept(ModBlocks.ORANGE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_ORANGE_CTM_PANE);
        output.accept(ModBlocks.SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_ORANGE_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_ORANGE_CTM_PANE);
        output.accept(ModBlocks.MAGENTA_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_MAGENTA_CTM_PANE);
        output.accept(ModBlocks.SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_MAGENTA_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_MAGENTA_CTM_PANE);
        output.accept(ModBlocks.LIGHT_BLUE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_LIGHT_BLUE_CTM_PANE);
        output.accept(ModBlocks.SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE);
        output.accept(ModBlocks.YELLOW_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_YELLOW_CTM_PANE);
        output.accept(ModBlocks.SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_YELLOW_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_YELLOW_CTM_PANE);
        output.accept(ModBlocks.LIME_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_LIME_CTM_PANE);
        output.accept(ModBlocks.SMALL_LIME_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_LIME_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_LIME_CTM_PANE);
        output.accept(ModBlocks.PINK_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_PINK_CTM_PANE);
        output.accept(ModBlocks.SMALL_PINK_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_PINK_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_PINK_CTM_PANE);
        output.accept(ModBlocks.GRAY_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_GRAY_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_GRAY_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_GRAY_CTM_PANE);
        output.accept(ModBlocks.LIGHT_GRAY_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_LIGHT_GRAY_CTM_PANE);
        output.accept(ModBlocks.SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE);
        output.accept(ModBlocks.CYAN_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_CYAN_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_CYAN_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_CYAN_CTM_PANE);
        output.accept(ModBlocks.PURPLE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_PURPLE_CTM_PANE);
        output.accept(ModBlocks.SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_PURPLE_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_PURPLE_CTM_PANE);
        output.accept(ModBlocks.BLUE_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_BLUE_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_BLUE_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_BLUE_CTM_PANE);
        output.accept(ModBlocks.BROWN_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_BROWN_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_BROWN_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_BROWN_CTM_PANE);
        output.accept(ModBlocks.GREEN_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_GREEN_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_GREEN_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_GREEN_CTM_PANE);
        output.accept(ModBlocks.RED_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_RED_CTM_PANE);
        output.accept(ModBlocks.SMALL_RED_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_RED_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_RED_CTM_PANE);
        output.accept(ModBlocks.BLACK_FRAMED_GLASS_CTM_PANE);
        output.accept(ModBlocks.BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.GOLDEN_FRAMED_BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_BLACK_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_BLACK_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_BLACK_CTM_PANE);
        output.accept(ModBlocks.SCRATCHED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TINTED_BORDERLESS_GLASS_CTM_PANE);
        output.accept(ModBlocks.BORDERLESS_GLASS_CTM_PANE);
        output.accept(ModBlocks.WHITE_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORANGE_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.MAGENTA_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.YELLOW_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.LIME_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.PINK_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.GRAY_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.CYAN_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.PURPLE_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.BLUE_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.BROWN_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.GREEN_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.RED_STAINED_CLEAR_GLASS_CTM_PANE);
        output.accept(ModBlocks.BLACK_STAINED_CLEAR_GLASS_CTM_PANE);        output.accept(ModBlocks.GLASS_OCHRE_FROGLIGHT_PANE);
        output.accept(ModBlocks.GLASS_PEARLESCENT_FROGLIGHT_PANE);
        output.accept(ModBlocks.GLASS_VERDANT_FROGLIGHT_PANE);



            }),

    JARS("jars",
            () -> ModBlocks.FIREFLY_JAR.get().asItem(),
            (params, output) -> {
                output.accept(ModBlocks.CHRYSALIS);
                output.accept(ModItems.CATERPILLAR.get());
                output.accept(ModBlocks.GLASS_JAR);
                output.accept(ModBlocks.CATERPILLAR_JAR);
                output.accept(ModBlocks.FIREFLY_IN_A_JAR);
                output.accept(ModBlocks.FIREFLIES_IN_A_JAR);
                output.accept(ModBlocks.FIREFLY_JAR);
                output.accept(ModItems.BUG_NET);
                ModBlocks.BUTTERFLY_JARS.values().forEach(output::accept);
                for (Butterfly.Variant variant : Butterfly.Variant.values()) {
                    output.accept(ModItems.BUTTERFLIES.get(variant).get());
                }
            }),

    FLORA("flora",
            ModItems.BIG_LILY_PAD,
            (params, output) -> {
                output.accept(ModBlocks.THORNY_HEDGE);
                output.accept(ModItems.THORNY_HEDGE_SPROUTS);

                ModBlocks.PARTICLE_HEDGES.values().forEach(output::accept);
                ModBlocks.CREEPING_HEDGES.values().forEach(output::accept);

                output.accept(ModItems.BIG_LILY_PAD);

                output.accept(ModBlocks.COCONUT);

                output.accept(ModItems.COCONUT);
            }),

    FAUNA("fauna",
            ModItems.CLAM,
            (params, output) -> {
                output.accept(ModItems.CLAM);
                output.accept(ModItems.KOI_FISH);
                output.accept(ModItems.PEARL);
                output.accept(ModItems.SILK);
                output.accept(ModItems.PHEASANT_FEATHER);
                output.accept(ModItems.SNAIL_SHELL);
                output.accept(ModBlocks.GLOW_GOOP);

                output.accept(ModBlocks.DRAGON_SKULL);
                output.accept(ModBlocks.SILK_COCOON);
                output.accept(ModItems.OAK_NEST);
                output.accept(ModItems.ACACIA_BEEHIVE);
                output.accept(ModItems.BAMBOO_BEEHIVE);
                output.accept(ModItems.BIRCH_BEEHIVE);
                output.accept(ModItems.CHERRY_BEEHIVE);
                output.accept(ModItems.CRIMSON_BEEHIVE);
                output.accept(ModItems.DARK_OAK_BEEHIVE);
                output.accept(ModItems.JUNGLE_BEEHIVE);
                output.accept(ModItems.MANGROVE_BEEHIVE);
                output.accept(ModItems.PALE_OAK_BEEHIVE);
                output.accept(ModItems.SPRUCE_BEEHIVE);
                output.accept(ModItems.WARPED_BEEHIVE);

                output.accept(ModItems.ALLIGATOR_EGG);
                output.accept(ModItems.CRAB_CLAW);
                output.accept(ModItems.CRAB_EGG);
                output.accept(ModItems.SNAIL_EGG);
                output.accept(ModItems.TORTOISE_EGG);
            }),

    FOOD("food",
            ModItems.COOKED_WILD_GAME_MEAT,
            (params, output) -> {
                output.accept(ModItems.BASS);
                output.accept(ModItems.COOKED_BASS);
                output.accept(ModItems.RAW_BONNETHEAD);
                output.accept(ModItems.COOKED_BONNETHEAD);
                output.accept(ModItems.CATFISH);
                output.accept(ModItems.COOKED_CATFISH);
                output.accept(ModItems.RAW_CICHLID);
                output.accept(ModItems.COOKED_CICHLID);
                output.accept(ModItems.RAW_GOBLIN_SHARK);
                output.accept(ModItems.COOKED_GOBLIN_SHARK);
                output.accept(ModItems.RAW_GUITARFISH);
                output.accept(ModItems.COOKED_GUITARFISH);
                output.accept(ModItems.RAW_SUNFISH_MEAT);
                output.accept(ModItems.COOKED_SUNFISH_MEAT);
                output.accept(ModItems.RAW_GOLDEN_SUNFISH_MEAT);
                output.accept(ModItems.COOKED_GOLDEN_SUNFISH_MEAT);
                output.accept(ModItems.RAW_CRAB_MEAT);
                output.accept(ModItems.STEAMED_CRAB_MEAT);
                output.accept(ModItems.RAW_KRILL);
                output.accept(ModItems.FRIED_KRILL);
                output.accept(ModItems.RAW_SHRIMP);
                output.accept(ModItems.STEAMED_SHRIMP);
                output.accept(ModItems.RAW_SNAIL);
                output.accept(ModItems.COOKED_SNAIL);
                output.accept(ModItems.JELLYFISH_JELLY);
                output.accept(ModItems.SEA_URCHIN_CAVIAR);
                output.accept(ModItems.RAW_WILD_GAME_MEAT);
                output.accept(ModItems.COOKED_WILD_GAME_MEAT);
                output.accept(ModItems.RAW_WILD_BIRD_MEAT);
                output.accept(ModItems.COOKED_WILD_BIRD_MEAT);
                output.accept(ModItems.LIZARD_TAIL);
                output.accept(ModItems.COOKED_LIZARD_TAIL);
                output.accept(ModItems.COOKED_EGG);
                output.accept(ModItems.BLUE_EGG);
                output.accept(ModItems.BROWN_EGG);
                output.accept(ModItems.DUCK_EGG);
                output.accept(ModItems.EMU_EGG);
                output.accept(ModItems.HOOPOE_EGG);
                output.accept(ModItems.KIWI_EGG);
                output.accept(ModItems.PENGUIN_EGG);
                output.accept(ModItems.PHEASANT_EGG);
                output.accept(ModItems.TOUCAN_EGG);
            }),

    MISC("misc",
            () -> ModBlocks.WATER_LANTERN.get().asItem(),
            (params, output) -> {
                output.accept(ModItems.PINK_SALT);
                output.accept(ModBlocks.PINK_SALT_LAMP);

                output.accept(ModBlocks.STONE_LANTERN);
                output.accept(ModBlocks.IRON_FANCY_LANTERN);
                output.accept(ModBlocks.STARLIGHT_LAMP);

                output.accept(ModBlocks.WATER_LANTERN);
                output.accept(ModBlocks.LAVA_LANTERN);
                output.accept(ModBlocks.PROTECTIVE_LANTERN);
                output.accept(ModBlocks.SMITE_LANTERN);

                output.accept(ModBlocks.WEATHERING_STATION);
                output.accept(ModBlocks.WOODCUTTER);
                output.accept(ModBlocks.ENGRAVING_TABLE);

                output.accept(ModItems.UNFIRED_CLAY_ROOF_TILE.get());
                output.accept(ModItems.PLASTER_BUCKET.get());

                output.accept(ModBlocks.CURVED_RAKED_GRAVEL);
                output.accept(ModBlocks.STRAIGHT_RAKED_GRAVEL);

                output.accept(ModBlocks.WHITE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.BLACK_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.SANDSTONE_CRENELATION);

                output.accept(ModBlocks.WATER_MOSAIC_RECESS);
                output.accept(ModBlocks.EARTH_MOSAIC_RECESS);
                output.accept(ModBlocks.FIRE_MOSAIC_RECESS);
                output.accept(ModBlocks.SPIRIT_MOSAIC_RECESS);
                output.accept(ModBlocks.AIR_MOSAIC_RECESS);

                output.accept(ModBlocks.STONE_BRICKS_ARROWSLIT);
                output.accept(ModBlocks.STONE_BRICKS_MACHICOLATION);
                output.accept(ModBlocks.STONE_BRICKS_FAUCET);
                output.accept(ModBlocks.STONE_BRICKS_POOL);
                output.accept(ModBlocks.STONE_BRICKS_SMALL_POOL);
                output.accept(ModBlocks.STONE_BRICKS_WATER_JET);
                output.accept(ModBlocks.WATER_SOURCE_TRICKLE);

                output.accept(ModItems.WILDFIRE_CROWN);
                output.accept(ModItems.WILDFIRE_CROWN_FRAGMENT);

                // Opal clusters, buds, and crystal items
                ModBlocks.OPAL_SETS.values().forEach(set -> {
                    output.accept(set.cluster());
                    output.accept(set.largeBud());
                    output.accept(set.mediumBud());
                    output.accept(set.smallBud());
                });
                output.accept(ModItems.WHITE_OPAL_CRYSTAL);
                output.accept(ModItems.BLACK_OPAL_CRYSTAL);
                output.accept(ModItems.FIRE_OPAL_CRYSTAL);

                // Paxels
                output.accept(ModItems.WOOD_PAXEL);
                output.accept(ModItems.STONE_PAXEL);
                output.accept(ModItems.IRON_PAXEL);
                output.accept(ModItems.GOLDEN_PAXEL);
                output.accept(ModItems.DIAMOND_PAXEL);
                output.accept(ModItems.NETHERITE_PAXEL);
                output.accept(ModItems.COPPER_PAXEL);
                output.accept(ModItems.EXPOSED_COPPER_PAXEL);
                output.accept(ModItems.WEATHERED_COPPER_PAXEL);
                output.accept(ModItems.OXIDIZED_COPPER_PAXEL);

                // Reinforced Obsidian Tools
                output.accept(ModItems.REINFORCED_OBSIDIAN_SWORD);
                output.accept(ModItems.REINFORCED_OBSIDIAN_SHOVEL);
                output.accept(ModItems.REINFORCED_OBSIDIAN_PICKAXE);
                output.accept(ModItems.REINFORCED_OBSIDIAN_AXE);
                output.accept(ModItems.REINFORCED_OBSIDIAN_HOE);
                output.accept(ModItems.REINFORCED_OBSIDIAN_PAXEL);
            });

    // --- Display order (top to bottom in the button list) ---
    public static final java.util.List<OttCreativeCategories> DISPLAY_ORDER =
            java.util.List.of(MISC, COLORS, DYES, GRADIENTS, WOOD_SETS, VANPLUS,
                    STONE_CUSTOM, STONE_VANILLA,
                    BACKPORT, COPPER_CHAOS, ENGRAVED, MOSAIC, BLOCKS,
                    FLORA, FAUNA, FOOD, JARS, CREATURES
            );

    // --- State ---
    @Nullable
    private static OttCreativeCategories selected = MISC;

    public static @Nullable OttCreativeCategories getSelected() {
        return selected;
    }

    public static void setSelected(@Nullable OttCreativeCategories cat) {
        selected = cat;
    }

    // --- Enum fields ---
    private final String id;
    private final Supplier<Item> iconItem;
    private final BiConsumer<CreativeModeTab.ItemDisplayParameters, CreativeModeTab.Output> populator;

    OttCreativeCategories(@NotNull String id,
                          @NotNull Supplier<Item> iconItem,
                          @NotNull BiConsumer<CreativeModeTab.ItemDisplayParameters, CreativeModeTab.Output> populator) {
        this.id = id;
        this.iconItem = iconItem;
        this.populator = populator;
    }

    public @NotNull Component getDisplayName() {
        return Component.translatable("ott.creative_category." + id);
    }

    public @NotNull Item getIconItem() {
        return iconItem.get();
    }

    /**
     * Populate items into output. Accepts null params — none of the current populators use them.
     */
    public void populateItems(@Nullable CreativeModeTab.ItemDisplayParameters params,
                              @NotNull CreativeModeTab.Output output) {
        populator.accept(params, output);
    }
}