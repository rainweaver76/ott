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
                // ===== RECOVERED WAVE4 =====
        output.accept(ModBlocks.RECTANGLE_CYAN_WOOL);
        output.accept(ModBlocks.RECTANGLE_GRAY_WOOL);
        output.accept(ModBlocks.RECTANGLE_GREEN_WOOL);
        output.accept(ModBlocks.RECTANGLE_LIGHT_BLUE_WOOL);
        output.accept(ModBlocks.RECTANGLE_LIGHT_GRAY_WOOL);
        output.accept(ModBlocks.RECTANGLE_LIME_WOOL);
        output.accept(ModBlocks.RECTANGLE_MAGENTA_WOOL);
        output.accept(ModBlocks.RECTANGLE_ORANGE_WOOL);
        output.accept(ModBlocks.RECTANGLE_PINK_WOOL);
        output.accept(ModBlocks.RECTANGLE_PURPLE_WOOL);
        output.accept(ModBlocks.RECTANGLE_RED_WOOL);
        output.accept(ModBlocks.RECTANGLE_WHITE_WOOL);
        output.accept(ModBlocks.RECTANGLE_YELLOW_WOOL);
                output.accept(ModBlocks.RED_ACACIA_LEAVES);
                output.accept(ModBlocks.RED_BIRCH_LEAVES);
        output.accept(ModBlocks.RED_CONCRETE_CTM);
        output.accept(ModBlocks.RED_CONCRETE_PANEL);
                output.accept(ModBlocks.RED_DARK_OAK_LEAVES);
                output.accept(ModBlocks.RED_JUNGLE_LEAVES);
        output.accept(ModBlocks.RED_NETHER_BRICKS_BEAMS);
        output.accept(ModBlocks.RED_NETHER_BRICKS_BRICK_PATTERN);
        output.accept(ModBlocks.RED_NETHER_BRICKS_BRICK_PAVING);
        output.accept(ModBlocks.RED_NETHER_BRICKS_CHISELED_SQUARES);
        output.accept(ModBlocks.RED_NETHER_BRICKS_DIAGONAL_BRICKS);
        output.accept(ModBlocks.RED_NETHER_BRICKS_LARGE_BRICKS);
        output.accept(ModBlocks.RED_NETHER_BRICKS_LARGE_TILES);
        output.accept(ModBlocks.RED_NETHER_BRICKS_ROTATED_BRICKS);
        output.accept(ModBlocks.RED_NETHER_BRICKS_SMALL_TILES);
        output.accept(ModBlocks.RED_NETHER_BRICKS_SMOOTH);
        output.accept(ModBlocks.RED_NETHER_BRICKS_SQUARES);
        output.accept(ModBlocks.RED_NETHER_BRICKS_TILES);
                output.accept(ModBlocks.RED_OAK_LEAVES);
        output.accept(ModBlocks.RED_SANDSTONE_BRICK_PATTERN);
        output.accept(ModBlocks.RED_SANDSTONE_BRICK_PAVING);
        output.accept(ModBlocks.RED_SANDSTONE_BRICKS);
        output.accept(ModBlocks.RED_SANDSTONE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.RED_SANDSTONE_LARGE_TILES);
        output.accept(ModBlocks.RED_SANDSTONE_POLISHED);
        output.accept(ModBlocks.RED_SANDSTONE_ROTATED_BRICKS);
        output.accept(ModBlocks.RED_SANDSTONE_TILES);
                output.accept(ModBlocks.RED_SPRUCE_LEAVES);
        output.accept(ModBlocks.RED_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.RED_TERRACOTTA_CTM);
        output.accept(ModBlocks.REDSTONE_BLOCK_BORDERED);
        output.accept(ModBlocks.REDSTONE_BLOCK_BRICKS);
        output.accept(ModBlocks.REDSTONE_BLOCK_CHISELED_CLOVERS);
        output.accept(ModBlocks.REDSTONE_BLOCK_CIRCLES);
        output.accept(ModBlocks.REDSTONE_BLOCK_COMPRESSED);
        output.accept(ModBlocks.REDSTONE_BLOCK_CTM);
        output.accept(ModBlocks.REDSTONE_BLOCK_DIAGONAL_TILES);
        output.accept(ModBlocks.REDSTONE_BLOCK_PATTERNED);
        output.accept(ModBlocks.REDSTONE_BLOCK_PAVING);
        output.accept(ModBlocks.REDSTONE_BLOCK_POLISHED);
        output.accept(ModBlocks.REDSTONE_BLOCK_SCALES);
        output.accept(ModBlocks.REDSTONE_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.ROSE_QUARTZ_BRICKS);
        output.accept(ModBlocks.ROSE_QUARTZ_CHISELED);
        output.accept(ModBlocks.ROSE_QUARTZ_CRUSHED);
        output.accept(ModBlocks.ROSE_QUARTZ_POLISHED_BLOCK);
        output.accept(ModBlocks.ROSE_QUARTZ_SQUARES);
        output.accept(ModBlocks.ROSE_QUARTZ_TILES);
        output.accept(ModBlocks.SANDSTONE_BRICK_PATTERN);
        output.accept(ModBlocks.SANDSTONE_BRICK_PAVING);
        output.accept(ModBlocks.SANDSTONE_BRICKS);
        output.accept(ModBlocks.SANDSTONE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.SANDSTONE_LARGE_TILES);
        output.accept(ModBlocks.SANDSTONE_POLISHED);
        output.accept(ModBlocks.SANDSTONE_ROTATED_BRICKS);
        output.accept(ModBlocks.SANDSTONE_TILES);
        output.accept(ModBlocks.SCALY_MUD);
        output.accept(ModBlocks.SCALY_PACKED_MUD);
        output.accept(ModBlocks.SCORCHIA_CUT_POLISHED);
        output.accept(ModBlocks.SCORCHIA_CUT_SMALL_BRICK);
        output.accept(ModBlocks.SCORIA_CUT_POLISHED);
        output.accept(ModBlocks.SCORIA_CUT_SMALL_BRICK);
        output.accept(ModBlocks.SIMPLE_AMETHYST_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_ANCIENT_DEBRIS_CTM);
        output.accept(ModBlocks.SIMPLE_ANDESITE_CTM);
        output.accept(ModBlocks.SIMPLE_BASALT_CTM);
        output.accept(ModBlocks.SIMPLE_BLACKSTONE_CTM);
        output.accept(ModBlocks.SIMPLE_BLUE_ICE_CTM);
        output.accept(ModBlocks.SIMPLE_BORDERLESS_BRICKS_CTM);
        output.accept(ModBlocks.SIMPLE_BRICKS_CTM);
        output.accept(ModBlocks.SIMPLE_CALCITE_CTM);
        output.accept(ModBlocks.SIMPLE_CLAY_CTM);
        output.accept(ModBlocks.SIMPLE_COAL_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_COBBLESTONE_CTM);
        output.accept(ModBlocks.SIMPLE_CRYING_OBSIDIAN_CTM);
        output.accept(ModBlocks.SIMPLE_DARK_PRISMARINE_CTM);
        output.accept(ModBlocks.SIMPLE_DEEPSLATE_CTM);
        output.accept(ModBlocks.SIMPLE_DIORITE_CTM);
        output.accept(ModBlocks.SIMPLE_DIRT_CTM);
        output.accept(ModBlocks.SIMPLE_DRIPSTONE_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_END_STONE_CTM);
        output.accept(ModBlocks.SIMPLE_GILDED_BLACKSTONE_CTM);
        output.accept(ModBlocks.SIMPLE_ICE_CTM);
        output.accept(ModBlocks.SIMPLE_LAPIS_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_LODESTONE_CTM);
        output.accept(ModBlocks.SIMPLE_MAGMA_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_MOSSY_COBBLESTONE_CTM);
        output.accept(ModBlocks.SIMPLE_MOSSY_STONE_BRICKS_CTM);
        output.accept(ModBlocks.SIMPLE_MUD_BRICKS_CTM);
        output.accept(ModBlocks.SIMPLE_MUD_CTM);
        output.accept(ModBlocks.SIMPLE_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.SIMPLE_NETHERRACK_CTM);
        output.accept(ModBlocks.SIMPLE_OBSIDIAN_CTM);
        output.accept(ModBlocks.SIMPLE_PACKED_ICE_CTM);
        output.accept(ModBlocks.SIMPLE_PACKED_MUD_CTM);
        output.accept(ModBlocks.SIMPLE_PRISMARINE_CTM);
        output.accept(ModBlocks.SIMPLE_PURPUR_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_QUARTZ_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_RAW_COPPER_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_RAW_GOLD_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_RAW_IRON_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_RED_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.SIMPLE_RED_SANDSTONE_CTM);
        output.accept(ModBlocks.SIMPLE_REDSTONE_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_SANDSTONE_CTM);
        output.accept(ModBlocks.SIMPLE_SMOOTH_STONE_CTM);
        output.accept(ModBlocks.SIMPLE_SNOW_BLOCK_CTM);
        output.accept(ModBlocks.SIMPLE_TUFF_CTM);
        output.accept(ModBlocks.SMALL_BLACK_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_BLACK_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_BLACK_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_BLUE_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_BLUE_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_BROWN_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_BROWN_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_BROWN_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_CYAN_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_CYAN_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_CYAN_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_DIAMOND_LEADED_GLASS);
        output.accept(ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM);
        output.accept(ModBlocks.SMALL_DIAMOND_LEADED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_DIAMOND_LEADED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_GRAY_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_GRAY_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_GREEN_DIAMOND_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_GREEN_DIAMOND_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.SMALL_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.SMALL_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SMALL_GREEN_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_LIGHT_BLUE_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_LIGHT_GRAY_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_LIME_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_MAGENTA_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_ORANGE_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_PINK_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_PURPLE_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_RED_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_WHITE_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMALL_YELLOW_TERRACOTTA_TILES);
        output.accept(ModBlocks.SMOOTH_AMETHYST_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_ANCIENT_DEBRIS_COLUMN);
        output.accept(ModBlocks.SMOOTH_ANDESITE_COLUMN);
        output.accept(ModBlocks.SMOOTH_BASALT_COLUMN);
        output.accept(ModBlocks.SMOOTH_BLACK_CONCRETE);
        output.accept(ModBlocks.SMOOTH_BLACKSTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_BLUE_CONCRETE);
        output.accept(ModBlocks.SMOOTH_BLUE_ICE_COLUMN);
        output.accept(ModBlocks.SMOOTH_BORDERLESS_BRICKS_COLUMN);
        output.accept(ModBlocks.SMOOTH_BRICKS_COLUMN);
        output.accept(ModBlocks.SMOOTH_BROWN_CONCRETE);
        output.accept(ModBlocks.SMOOTH_CALCITE_COLUMN);
        output.accept(ModBlocks.SMOOTH_CLAY_COLUMN);
        output.accept(ModBlocks.SMOOTH_COAL_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_COBBLESTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_CRYING_OBSIDIAN_COLUMN);
        output.accept(ModBlocks.SMOOTH_CYAN_CONCRETE);
        output.accept(ModBlocks.SMOOTH_DARK_PRISMARINE_COLUMN);
        output.accept(ModBlocks.SMOOTH_DEEPSLATE_COLUMN);
        output.accept(ModBlocks.SMOOTH_DIORITE_COLUMN);
        output.accept(ModBlocks.SMOOTH_DIRT_COLUMN);
        output.accept(ModBlocks.SMOOTH_DRIPSTONE_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_END_STONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_GILDED_BLACKSTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_GRAY_CONCRETE);
        output.accept(ModBlocks.SMOOTH_GREEN_CONCRETE);
        output.accept(ModBlocks.SMOOTH_ICE_COLUMN);
        output.accept(ModBlocks.SMOOTH_LAPIS_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_LIGHT_BLUE_CONCRETE);
        output.accept(ModBlocks.SMOOTH_LIGHT_GRAY_CONCRETE);
        output.accept(ModBlocks.SMOOTH_LIME_CONCRETE);
        output.accept(ModBlocks.SMOOTH_LODESTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_MAGENTA_CONCRETE);
        output.accept(ModBlocks.SMOOTH_MAGMA_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_MOSSY_COBBLESTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_MOSSY_STONE_BRICKS_COLUMN);
        output.accept(ModBlocks.SMOOTH_NETHER_BRICKS_COLUMN);
        output.accept(ModBlocks.SMOOTH_NETHERRACK_COLUMN);
        output.accept(ModBlocks.SMOOTH_OBSIDIAN_COLUMN);
        output.accept(ModBlocks.SMOOTH_ORANGE_CONCRETE);
        output.accept(ModBlocks.SMOOTH_PACKED_ICE_COLUMN);
        output.accept(ModBlocks.SMOOTH_PINK_CONCRETE);
        output.accept(ModBlocks.SMOOTH_PRISMARINE_COLUMN);
        output.accept(ModBlocks.SMOOTH_PURPLE_CONCRETE);
        output.accept(ModBlocks.SMOOTH_PURPUR_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_QUARTZ_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_RAW_COPPER_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_RAW_GOLD_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_RAW_IRON_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_RED_CONCRETE);
        output.accept(ModBlocks.SMOOTH_RED_NETHER_BRICKS_COLUMN);
        output.accept(ModBlocks.SMOOTH_RED_SANDSTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_REDSTONE_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_SANDSTONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_SMOOTH_STONE_COLUMN);
        output.accept(ModBlocks.SMOOTH_SNOW_BLOCK_COLUMN);
        output.accept(ModBlocks.SMOOTH_TUFF_COLUMN);
        output.accept(ModBlocks.SMOOTH_WHITE_CONCRETE);
        output.accept(ModBlocks.SMOOTH_YELLOW_CONCRETE);
        output.accept(ModBlocks.SPRUCE_PLANKS_BEAMS);
        output.accept(ModBlocks.SPRUCE_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.SPRUCE_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.SPRUCE_PLANKS_BRICKS);
        output.accept(ModBlocks.SPRUCE_PLANKS_CRATE);
        output.accept(ModBlocks.SPRUCE_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.SPRUCE_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.SPRUCE_PLANKS_DOTTED);
        output.accept(ModBlocks.SPRUCE_PLANKS_FLOORING);
        output.accept(ModBlocks.SPRUCE_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.SPRUCE_PLANKS_PANEL);
        output.accept(ModBlocks.SPRUCE_PLANKS_PATTERN);
        output.accept(ModBlocks.SPRUCE_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.SPRUCE_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.SPRUCE_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.SPRUCE_PLANKS_SQUARES);
        output.accept(ModBlocks.SPRUCE_PLANKS_TILES);
        output.accept(ModBlocks.SPRUCE_PLANKS_WAVY);
        output.accept(ModBlocks.SPRUCE_PLANKS_WOVEN);
        output.accept(ModBlocks.SPRUCE_WINDOW_BARS);
        output.accept(ModBlocks.SPRUCE_WINDOW_BARS_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_COVERED);
        output.accept(ModBlocks.SPRUCE_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_DIAGONAL);
        output.accept(ModBlocks.SPRUCE_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_LARGE);
        output.accept(ModBlocks.SPRUCE_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_PANES);
        output.accept(ModBlocks.SPRUCE_WINDOW_PANES_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_ROUNDED);
        output.accept(ModBlocks.SPRUCE_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_SLIM);
        output.accept(ModBlocks.SPRUCE_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_SWIRLING);
        output.accept(ModBlocks.SPRUCE_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.SPRUCE_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_TILES);
        output.accept(ModBlocks.SPRUCE_WINDOW_TILES_CTM);
        output.accept(ModBlocks.SQUARE_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.SQUARE_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_LEADED_GLASS);
        output.accept(ModBlocks.SQUARE_LEADED_GLASS_PANE);
        output.accept(ModBlocks.SQUARE_OAK_GLASS);
        output.accept(ModBlocks.SQUARE_OAK_GLASS_CTM);
        output.accept(ModBlocks.SQUARE_OAK_GLASS_CTM_PANE);
        output.accept(ModBlocks.STARRY_BLACK_TERRACOTTA);
        output.accept(ModBlocks.STARRY_BLUE_TERRACOTTA);
        output.accept(ModBlocks.STARRY_BROWN_TERRACOTTA);
        output.accept(ModBlocks.STARRY_CYAN_TERRACOTTA);
        output.accept(ModBlocks.STARRY_GRAY_TERRACOTTA);
        output.accept(ModBlocks.STARRY_GREEN_TERRACOTTA);
        output.accept(ModBlocks.STARRY_LIGHT_BLUE_TERRACOTTA);
        output.accept(ModBlocks.STARRY_LIGHT_GRAY_TERRACOTTA);
        output.accept(ModBlocks.STARRY_LIME_TERRACOTTA);
        output.accept(ModBlocks.STARRY_MAGENTA_TERRACOTTA);
        output.accept(ModBlocks.STARRY_ORANGE_TERRACOTTA);
        output.accept(ModBlocks.STARRY_PINK_TERRACOTTA);
        output.accept(ModBlocks.STARRY_PURPLE_TERRACOTTA);
        output.accept(ModBlocks.STARRY_RED_TERRACOTTA);
        output.accept(ModBlocks.STARRY_TERRACOTTA);
        output.accept(ModBlocks.STARRY_WHITE_TERRACOTTA);
        output.accept(ModBlocks.STARRY_YELLOW_TERRACOTTA);
        output.accept(ModBlocks.STONE_BIG_TILES);
        output.accept(ModBlocks.STONE_BORDERED);
        output.accept(ModBlocks.STONE_BRICK_PATTERN);
        output.accept(ModBlocks.STONE_BRICK_PAVING);
        output.accept(ModBlocks.STONE_CHISELED_BRICKS);
        output.accept(ModBlocks.STONE_CRUSHED);
        output.accept(ModBlocks.STONE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.STONE_PATH);
        output.accept(ModBlocks.STONE_ROTATED_BRICKS);
        output.accept(ModBlocks.STONE_SLATED_END);
        output.accept(ModBlocks.STONE_SMALL_BRICKS);
        output.accept(ModBlocks.STONE_SMALL_TILES);
        output.accept(ModBlocks.STONE_SMOOTH);
        output.accept(ModBlocks.STONE_SMOOTH_BRICK_PAVING);
        output.accept(ModBlocks.STONE_SMOOTH_LARGE_TILES);
        output.accept(ModBlocks.STONE_SMOOTH_ROTATED_BRICKS);
        output.accept(ModBlocks.STONE_SMOOTH_TILES);
        output.accept(ModBlocks.STONE_SQUARES);
        output.accept(ModBlocks.STONE_TILES);
        output.accept(ModBlocks.STONE_WAVES);
        output.accept(ModBlocks.STRIPED_BLACK_CONCRETE);
        output.accept(ModBlocks.STRIPED_BLUE_CONCRETE);
        output.accept(ModBlocks.STRIPED_BROWN_CONCRETE);
        output.accept(ModBlocks.STRIPED_CYAN_CONCRETE);
        output.accept(ModBlocks.STRIPED_GRAY_CONCRETE);
        output.accept(ModBlocks.STRIPED_GREEN_CONCRETE);
        output.accept(ModBlocks.STRIPED_LIGHT_BLUE_CONCRETE);
        output.accept(ModBlocks.STRIPED_LIGHT_GRAY_CONCRETE);
        output.accept(ModBlocks.STRIPED_LIME_CONCRETE);
        output.accept(ModBlocks.STRIPED_MAGENTA_CONCRETE);
        output.accept(ModBlocks.STRIPED_ORANGE_CONCRETE);
        output.accept(ModBlocks.STRIPED_PINK_CONCRETE);
        output.accept(ModBlocks.STRIPED_PURPLE_CONCRETE);
        output.accept(ModBlocks.STRIPED_RED_CONCRETE);
        output.accept(ModBlocks.STRIPED_WHITE_CONCRETE);
        output.accept(ModBlocks.STRIPED_YELLOW_CONCRETE);
        output.accept(ModBlocks.TERRACOTTA_COLUMN);
        output.accept(ModBlocks.TERRACOTTA_CTM);
        output.accept(ModBlocks.THICK_INLAYED_AMETHYST_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_ANCIENT_DEBRIS);
        output.accept(ModBlocks.THICK_INLAYED_ANDESITE);
        output.accept(ModBlocks.THICK_INLAYED_BASALT);
        output.accept(ModBlocks.THICK_INLAYED_BLACKSTONE);
        output.accept(ModBlocks.THICK_INLAYED_BLUE_ICE);
        output.accept(ModBlocks.THICK_INLAYED_BORDERLESS_BRICKS);
        output.accept(ModBlocks.THICK_INLAYED_BRICKS);
        output.accept(ModBlocks.THICK_INLAYED_CALCITE);
        output.accept(ModBlocks.THICK_INLAYED_CLAY);
        output.accept(ModBlocks.THICK_INLAYED_COAL_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_COBBLESTONE);
        output.accept(ModBlocks.THICK_INLAYED_CRYING_OBSIDIAN);
        output.accept(ModBlocks.THICK_INLAYED_DARK_PRISMARINE);
        output.accept(ModBlocks.THICK_INLAYED_DEEPSLATE);
        output.accept(ModBlocks.THICK_INLAYED_DIORITE);
        output.accept(ModBlocks.THICK_INLAYED_DIRT);
        output.accept(ModBlocks.THICK_INLAYED_DRIPSTONE_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_END_STONE);
        output.accept(ModBlocks.THICK_INLAYED_GILDED_BLACKSTONE);
        output.accept(ModBlocks.THICK_INLAYED_ICE);
        output.accept(ModBlocks.THICK_INLAYED_LAPIS_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_LODESTONE);
        output.accept(ModBlocks.THICK_INLAYED_MAGMA_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_MOSSY_COBBLESTONE);
        output.accept(ModBlocks.THICK_INLAYED_MOSSY_STONE_BRICKS);
        output.accept(ModBlocks.THICK_INLAYED_NETHER_BRICKS);
        output.accept(ModBlocks.THICK_INLAYED_NETHERRACK);
        output.accept(ModBlocks.THICK_INLAYED_OBSIDIAN);
        output.accept(ModBlocks.THICK_INLAYED_PACKED_ICE);
        output.accept(ModBlocks.THICK_INLAYED_PRISMARINE);
        output.accept(ModBlocks.THICK_INLAYED_PURPUR_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_QUARTZ_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_RAW_COPPER_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_RAW_GOLD_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_RAW_IRON_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_RED_NETHER_BRICKS);
        output.accept(ModBlocks.THICK_INLAYED_RED_SANDSTONE);
        output.accept(ModBlocks.THICK_INLAYED_REDSTONE_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_SANDSTONE);
        output.accept(ModBlocks.THICK_INLAYED_SMOOTH_STONE);
        output.accept(ModBlocks.THICK_INLAYED_SNOW_BLOCK);
        output.accept(ModBlocks.THICK_INLAYED_TUFF);
        output.accept(ModBlocks.TIED_BAMBOO_PLANKS);
        output.accept(ModBlocks.TILED_AMETHYST_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_ANCIENT_DEBRIS_COLUMN);
        output.accept(ModBlocks.TILED_ANDESITE_COLUMN);
        output.accept(ModBlocks.TILED_BASALT_COLUMN);
        output.accept(ModBlocks.TILED_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.TILED_BLACK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.TILED_BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_BLACKSTONE_COLUMN);
        output.accept(ModBlocks.TILED_BLUE_ICE_COLUMN);
        output.accept(ModBlocks.TILED_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.TILED_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.TILED_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_BORDERED_AMETHYST_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_ANCIENT_DEBRIS);
        output.accept(ModBlocks.TILED_BORDERED_ANDESITE);
        output.accept(ModBlocks.TILED_BORDERED_BASALT);
        output.accept(ModBlocks.TILED_BORDERED_BLACKSTONE);
        output.accept(ModBlocks.TILED_BORDERED_BLUE_ICE);
        output.accept(ModBlocks.TILED_BORDERED_BORDERLESS_BRICKS);
        output.accept(ModBlocks.TILED_BORDERED_BRICKS);
        output.accept(ModBlocks.TILED_BORDERED_CALCITE);
        output.accept(ModBlocks.TILED_BORDERED_CLAY);
        output.accept(ModBlocks.TILED_BORDERED_COAL_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_COBBLESTONE);
        output.accept(ModBlocks.TILED_BORDERED_CRYING_OBSIDIAN);
        output.accept(ModBlocks.TILED_BORDERED_DARK_PRISMARINE);
        output.accept(ModBlocks.TILED_BORDERED_DEEPSLATE);
        output.accept(ModBlocks.TILED_BORDERED_DIORITE);
        output.accept(ModBlocks.TILED_BORDERED_DIRT);
        output.accept(ModBlocks.TILED_BORDERED_DRIPSTONE_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_END_STONE);
        output.accept(ModBlocks.TILED_BORDERED_GILDED_BLACKSTONE);
        output.accept(ModBlocks.TILED_BORDERED_ICE);
        output.accept(ModBlocks.TILED_BORDERED_LAPIS_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_LODESTONE);
        output.accept(ModBlocks.TILED_BORDERED_MAGMA_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_MOSSY_COBBLESTONE);
        output.accept(ModBlocks.TILED_BORDERED_MOSSY_STONE_BRICKS);
        output.accept(ModBlocks.TILED_BORDERED_MUD);
        output.accept(ModBlocks.TILED_BORDERED_MUD_BRICKS);
        output.accept(ModBlocks.TILED_BORDERED_NETHER_BRICKS);
        output.accept(ModBlocks.TILED_BORDERED_NETHERRACK);
        output.accept(ModBlocks.TILED_BORDERED_OBSIDIAN);
        output.accept(ModBlocks.TILED_BORDERED_PACKED_ICE);
        output.accept(ModBlocks.TILED_BORDERED_PACKED_MUD);
        output.accept(ModBlocks.TILED_BORDERED_PRISMARINE);
        output.accept(ModBlocks.TILED_BORDERED_PURPUR_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_QUARTZ_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_RAW_COPPER_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_RAW_GOLD_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_RAW_IRON_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_RED_NETHER_BRICKS);
        output.accept(ModBlocks.TILED_BORDERED_RED_SANDSTONE);
        output.accept(ModBlocks.TILED_BORDERED_REDSTONE_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_SANDSTONE);
        output.accept(ModBlocks.TILED_BORDERED_SMOOTH_STONE);
        output.accept(ModBlocks.TILED_BORDERED_SNOW_BLOCK);
        output.accept(ModBlocks.TILED_BORDERED_TUFF);
        output.accept(ModBlocks.TILED_BORDERLESS_BRICKS_COLUMN);
        output.accept(ModBlocks.TILED_BRICKS_COLUMN);
        output.accept(ModBlocks.TILED_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.TILED_BROWN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.TILED_BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_CALCITE_COLUMN);
        output.accept(ModBlocks.TILED_CLAY_COLUMN);
        output.accept(ModBlocks.TILED_COAL_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_COBBLESTONE_COLUMN);
        output.accept(ModBlocks.TILED_CRYING_OBSIDIAN_COLUMN);
        output.accept(ModBlocks.TILED_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.TILED_CYAN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.TILED_CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_DARK_PRISMARINE_COLUMN);
        output.accept(ModBlocks.TILED_DEEPSLATE_COLUMN);
        output.accept(ModBlocks.TILED_DIORITE_COLUMN);
        output.accept(ModBlocks.TILED_DIRT_COLUMN);
        output.accept(ModBlocks.TILED_DRIPSTONE_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_END_STONE_COLUMN);
        output.accept(ModBlocks.TILED_GILDED_BLACKSTONE_COLUMN);
        output.accept(ModBlocks.TILED_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.TILED_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.TILED_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.TILED_GREEN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.TILED_GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.TILED_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.TILED_ICE_COLUMN);
        output.accept(ModBlocks.TILED_LAPIS_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_LODESTONE_COLUMN);
        output.accept(ModBlocks.TILED_MAGMA_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_MOSSY_COBBLESTONE_COLUMN);
        output.accept(ModBlocks.TILED_MOSSY_STONE_BRICKS_COLUMN);
        output.accept(ModBlocks.TILED_MUD_BRICKS_COLUMN);
        output.accept(ModBlocks.TILED_MUD_COLUMN);
        output.accept(ModBlocks.TILED_NETHER_BRICKS_COLUMN);
        output.accept(ModBlocks.TILED_NETHERRACK_COLUMN);
        output.accept(ModBlocks.TILED_OBSIDIAN_COLUMN);
        output.accept(ModBlocks.TILED_PACKED_ICE_COLUMN);
        output.accept(ModBlocks.TILED_PACKED_MUD_COLUMN);
        output.accept(ModBlocks.TILED_PRISMARINE_COLUMN);
        output.accept(ModBlocks.TILED_PURPUR_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_QUARTZ_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_RAW_COPPER_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_RAW_GOLD_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_RAW_IRON_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_RED_NETHER_BRICKS_COLUMN);
        output.accept(ModBlocks.TILED_RED_SANDSTONE_COLUMN);
        output.accept(ModBlocks.TILED_REDSTONE_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_SANDSTONE_COLUMN);
        output.accept(ModBlocks.TILED_SMOOTH_STONE_COLUMN);
        output.accept(ModBlocks.TILED_SNOW_BLOCK_COLUMN);
        output.accept(ModBlocks.TILED_TUFF_COLUMN);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_AMETHYST_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_ANCIENT_DEBRIS);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_ANDESITE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_BASALT);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_BLACKSTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_BLUE_ICE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_BORDERLESS_BRICKS);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_BRICKS);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_CALCITE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_CLAY);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_COAL_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_COBBLESTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_CRYING_OBSIDIAN);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_DARK_PRISMARINE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_DEEPSLATE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_DIORITE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_DIRT);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_DRIPSTONE_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_END_STONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_GILDED_BLACKSTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_ICE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_LAPIS_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_LODESTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_MAGMA_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_MOSSY_COBBLESTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_NETHER_BRICKS);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_NETHERRACK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_OBSIDIAN);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_PACKED_ICE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_PRISMARINE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_PURPUR_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_QUARTZ_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_RAW_COPPER_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_RAW_GOLD_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_RAW_IRON_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_RED_NETHER_BRICKS);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_RED_SANDSTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_REDSTONE_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_SANDSTONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_SMOOTH_STONE);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_SNOW_BLOCK);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_TUFF);
        output.accept(ModBlocks.TUFF_CUT_POLISHED);
        output.accept(ModBlocks.TUFF_CUT_SMALL_BRICK);
        output.accept(ModBlocks.VERIDIUM_CUT_POLISHED);
        output.accept(ModBlocks.VERIDIUM_CUT_SMALL_BRICK);
        output.accept(ModBlocks.VERTICAL_LEADED_GLASS);
        output.accept(ModBlocks.VERTICAL_LEADED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.VERTICAL_STRIPED_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.VERTICAL_STRIPED_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WARPED_PLANKS_BEAMS);
        output.accept(ModBlocks.WARPED_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.WARPED_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.WARPED_PLANKS_BRICKS);
        output.accept(ModBlocks.WARPED_PLANKS_CRATE);
        output.accept(ModBlocks.WARPED_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.WARPED_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.WARPED_PLANKS_DOTTED);
        output.accept(ModBlocks.WARPED_PLANKS_FLOORING);
        output.accept(ModBlocks.WARPED_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.WARPED_PLANKS_PANEL);
        output.accept(ModBlocks.WARPED_PLANKS_PATTERN);
        output.accept(ModBlocks.WARPED_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.WARPED_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.WARPED_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.WARPED_PLANKS_SQUARES);
        output.accept(ModBlocks.WARPED_PLANKS_TILES);
        output.accept(ModBlocks.WARPED_PLANKS_WAVY);
        output.accept(ModBlocks.WARPED_PLANKS_WOVEN);
        output.accept(ModBlocks.WARPED_WINDOW_BARS);
        output.accept(ModBlocks.WARPED_WINDOW_BARS_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_COVERED);
        output.accept(ModBlocks.WARPED_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_DIAGONAL);
        output.accept(ModBlocks.WARPED_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_LARGE);
        output.accept(ModBlocks.WARPED_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_PANES);
        output.accept(ModBlocks.WARPED_WINDOW_PANES_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_ROUNDED);
        output.accept(ModBlocks.WARPED_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_SLIM);
        output.accept(ModBlocks.WARPED_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.WARPED_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_TILES);
        output.accept(ModBlocks.WARPED_WINDOW_TILES_CTM);
        output.accept(ModBlocks.WHIRLWIND_ACACIA_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_BAMBOO_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_BIRCH_PLANKS);
        output.accept(ModBlocks.WHIRLWIND_OAK_PLANKS);
        output.accept(ModBlocks.WHITE_CONCRETE_CTM);
        output.accept(ModBlocks.WHITE_CONCRETE_PANEL);
                output.accept(ModBlocks.WHITE_FLOWER_ACACIA_LEAVES);
                output.accept(ModBlocks.WHITE_FLOWER_BIRCH_LEAVES);
                output.accept(ModBlocks.WHITE_FLOWER_DARK_OAK_LEAVES);
                output.accept(ModBlocks.WHITE_FLOWER_JUNGLE_LEAVES);
                output.accept(ModBlocks.WHITE_FLOWER_OAK_LEAVES);
                output.accept(ModBlocks.WHITE_FLOWER_SPRUCE_LEAVES);
        output.accept(ModBlocks.WIRED_BLACK_CONCRETE);
        output.accept(ModBlocks.WIRED_BLUE_CONCRETE);
        output.accept(ModBlocks.WIRED_BROWN_CONCRETE);
        output.accept(ModBlocks.WIRED_CYAN_CONCRETE);
        output.accept(ModBlocks.WIRED_GRAY_CONCRETE);
        output.accept(ModBlocks.WIRED_GREEN_CONCRETE);
        output.accept(ModBlocks.WIRED_LIGHT_BLUE_CONCRETE);
        output.accept(ModBlocks.WIRED_LIGHT_GRAY_CONCRETE);
        output.accept(ModBlocks.WIRED_LIME_CONCRETE);
        output.accept(ModBlocks.WIRED_MAGENTA_CONCRETE);
        output.accept(ModBlocks.WIRED_ORANGE_CONCRETE);
        output.accept(ModBlocks.WIRED_PINK_CONCRETE);
        output.accept(ModBlocks.WIRED_PURPLE_CONCRETE);
        output.accept(ModBlocks.WIRED_RED_CONCRETE);
        output.accept(ModBlocks.WIRED_WHITE_CONCRETE);
        output.accept(ModBlocks.WIRED_YELLOW_CONCRETE);
        output.accept(ModBlocks.WOVEN_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.WOVEN_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.WOVEN_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.YELLOW_CONCRETE_CTM);
        output.accept(ModBlocks.YELLOW_CONCRETE_PANEL);
        output.accept(ModBlocks.YELLOW_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.YELLOW_TERRACOTTA_CTM);
                // ===== RECOVERED WAVE3 =====
                output.accept(ModBlocks.GOLDEN_APPLE_JUNGLE_LEAVES);
                output.accept(ModBlocks.GOLDEN_APPLE_OAK_LEAVES);
                output.accept(ModBlocks.GOLDEN_APPLE_SPRUCE_LEAVES);
                output.accept(ModBlocks.GOLDEN_BIRCH_LEAVES);
                output.accept(ModBlocks.GOLDEN_CHERRY_ACACIA_LEAVES);
                output.accept(ModBlocks.GOLDEN_CHERRY_BIRCH_LEAVES);
                output.accept(ModBlocks.GOLDEN_CHERRY_DARK_OAK_LEAVES);
                output.accept(ModBlocks.GOLDEN_CHERRY_JUNGLE_LEAVES);
                output.accept(ModBlocks.GOLDEN_CHERRY_OAK_LEAVES);
                output.accept(ModBlocks.GOLDEN_CHERRY_SPRUCE_LEAVES);
                output.accept(ModBlocks.GOLDEN_DARK_OAK_LEAVES);
                output.accept(ModBlocks.GOLDEN_JUNGLE_LEAVES);
                output.accept(ModBlocks.GOLDEN_OAK_LEAVES);
                output.accept(ModBlocks.GOLDEN_SPRUCE_LEAVES);
        output.accept(ModBlocks.GRAY_CONCRETE_CTM);
        output.accept(ModBlocks.GRAY_CONCRETE_PANEL);
        output.accept(ModBlocks.GRAY_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.GRAY_TERRACOTTA_CTM);
        output.accept(ModBlocks.GREEN_CONCRETE_CTM);
        output.accept(ModBlocks.GREEN_CONCRETE_PANEL);
        output.accept(ModBlocks.GREEN_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.GREEN_TERRACOTTA_CTM);
        output.accept(ModBlocks.GRILL_BLACK_CONCRETE);
        output.accept(ModBlocks.GRILL_BLUE_CONCRETE);
        output.accept(ModBlocks.GRILL_BROWN_CONCRETE);
        output.accept(ModBlocks.GRILL_CYAN_CONCRETE);
        output.accept(ModBlocks.GRILL_GRAY_CONCRETE);
        output.accept(ModBlocks.GRILL_GREEN_CONCRETE);
        output.accept(ModBlocks.GRILL_LIGHT_BLUE_CONCRETE);
        output.accept(ModBlocks.GRILL_LIGHT_GRAY_CONCRETE);
        output.accept(ModBlocks.GRILL_LIME_CONCRETE);
        output.accept(ModBlocks.GRILL_MAGENTA_CONCRETE);
        output.accept(ModBlocks.GRILL_ORANGE_CONCRETE);
        output.accept(ModBlocks.GRILL_PINK_CONCRETE);
        output.accept(ModBlocks.GRILL_PURPLE_CONCRETE);
        output.accept(ModBlocks.GRILL_RED_CONCRETE);
        output.accept(ModBlocks.GRILL_WHITE_CONCRETE);
        output.accept(ModBlocks.GRILL_YELLOW_CONCRETE);
        output.accept(ModBlocks.HARD_MUD);
        output.accept(ModBlocks.HARD_MUD_BRICKS);
        output.accept(ModBlocks.HARD_PACKED_MUD);
        output.accept(ModBlocks.HARSH_QUILTED_BLACK_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_BLUE_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_BROWN_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_CYAN_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_GRAY_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_GREEN_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_LIGHT_BLUE_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_LIGHT_GRAY_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_LIME_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_MAGENTA_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_ORANGE_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_PINK_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_PURPLE_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_RED_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_WHITE_WOOL);
        output.accept(ModBlocks.HARSH_QUILTED_YELLOW_WOOL);
        output.accept(ModBlocks.HEXAGONICAL_BLACK_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_BLUE_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_BROWN_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_CYAN_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_GRAY_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_GREEN_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_LIGHT_BLUE_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_LIGHT_GRAY_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_LIME_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_MAGENTA_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_ORANGE_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_PINK_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_PURPLE_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_RED_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_WHITE_TERRACOTTA);
        output.accept(ModBlocks.HEXAGONICAL_YELLOW_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_BLACK_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_BLUE_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_BROWN_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_CYAN_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_GRAY_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_GREEN_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_LIGHT_BLUE_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_LIGHT_GRAY_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_LIME_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_MAGENTA_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_ORANGE_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_PINK_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_PURPLE_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_RED_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_WHITE_TERRACOTTA);
        output.accept(ModBlocks.INSCRIBED_YELLOW_TERRACOTTA);
        output.accept(ModBlocks.IRON_BLOCK);
        output.accept(ModBlocks.IRON_BLOCK_BORDERED);
        output.accept(ModBlocks.IRON_BLOCK_CHISELED);
        output.accept(ModBlocks.IRON_BLOCK_CONNECTING);
        output.accept(ModBlocks.IRON_BLOCK_FRAMED);
        output.accept(ModBlocks.IRON_BLOCK_GEARS);
        output.accept(ModBlocks.IRON_BLOCK_LINES);
        output.accept(ModBlocks.IRON_BLOCK_PATTERNED);
        output.accept(ModBlocks.IRON_BLOCK_PIPES);
        output.accept(ModBlocks.IRON_BLOCK_POLISHED);
        output.accept(ModBlocks.IRON_BLOCK_PROCESSED);
        output.accept(ModBlocks.IRON_BLOCK_SMALL_BRICKS);
        output.accept(ModBlocks.JUNGLE_PLANKS_BEAMS);
        output.accept(ModBlocks.JUNGLE_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.JUNGLE_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.JUNGLE_PLANKS_BRICKS);
        output.accept(ModBlocks.JUNGLE_PLANKS_CRATE);
        output.accept(ModBlocks.JUNGLE_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.JUNGLE_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.JUNGLE_PLANKS_DOTTED);
        output.accept(ModBlocks.JUNGLE_PLANKS_FLOORING);
        output.accept(ModBlocks.JUNGLE_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.JUNGLE_PLANKS_PATTERN);
        output.accept(ModBlocks.JUNGLE_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.JUNGLE_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.JUNGLE_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.JUNGLE_PLANKS_SQUARES);
        output.accept(ModBlocks.JUNGLE_PLANKS_TILES);
        output.accept(ModBlocks.JUNGLE_PLANKS_WAVY);
        output.accept(ModBlocks.JUNGLE_PLANKS_WOVEN);
        output.accept(ModBlocks.JUNGLE_WINDOW_BARS);
        output.accept(ModBlocks.JUNGLE_WINDOW_BARS_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_COVERED);
        output.accept(ModBlocks.JUNGLE_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_DIAGONAL);
        output.accept(ModBlocks.JUNGLE_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_LARGE);
        output.accept(ModBlocks.JUNGLE_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_PANES);
        output.accept(ModBlocks.JUNGLE_WINDOW_PANES_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_ROUNDED);
        output.accept(ModBlocks.JUNGLE_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_SWIRLING);
        output.accept(ModBlocks.JUNGLE_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.JUNGLE_WINDOW_TILES);
        output.accept(ModBlocks.JUNGLE_WINDOW_TILES_CTM);
        output.accept(ModBlocks.LAPIS_BLOCK);
        output.accept(ModBlocks.LAPIS_BLOCK_BORDERED);
        output.accept(ModBlocks.LAPIS_BLOCK_CONNECTING);
        output.accept(ModBlocks.LAPIS_BLOCK_DECORATED);
        output.accept(ModBlocks.LAPIS_BLOCK_GLOSSY);
        output.accept(ModBlocks.LAPIS_BLOCK_INVERTED_TILES);
        output.accept(ModBlocks.LAPIS_BLOCK_MOSAIC);
        output.accept(ModBlocks.LAPIS_BLOCK_PATTERN);
        output.accept(ModBlocks.LAPIS_BLOCK_POLISHED);
        output.accept(ModBlocks.LAPIS_BLOCK_SCALES);
        output.accept(ModBlocks.LAPIS_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.LAPIS_BLOCK_STRIPES);
        output.accept(ModBlocks.LAPIS_BLOCK_TILES);
        output.accept(ModBlocks.LARGE_DIAMOND_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_DIAMOND_LEADED_GLASS);
        output.accept(ModBlocks.LARGE_DIAMOND_LEADED_GLASS_PANE);
        output.accept(ModBlocks.LARGE_MUD_BRICKS_SIGIL);
        output.accept(ModBlocks.LARGE_MUD_SIGIL);
        output.accept(ModBlocks.LARGE_PACKED_MUD_SIGIL);
        output.accept(ModBlocks.LEAD_WOVEN_GLASS);
        output.accept(ModBlocks.LEAD_WOVEN_GLASS_PANE);
        output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_CTM);
        output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_PANEL);
        output.accept(ModBlocks.LIGHT_BLUE_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.LIGHT_BLUE_TERRACOTTA_CTM);
        output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_CTM);
        output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_PANEL);
        output.accept(ModBlocks.LIGHT_GRAY_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.LIGHT_GRAY_TERRACOTTA_CTM);
        output.accept(ModBlocks.LIME_CONCRETE_CTM);
        output.accept(ModBlocks.LIME_CONCRETE_PANEL);
        output.accept(ModBlocks.LIME_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.LIME_TERRACOTTA_CTM);
        output.accept(ModBlocks.LIMESTONE_CUT_POLISHED);
        output.accept(ModBlocks.LIMESTONE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.LOREFUL_MUD);
        output.accept(ModBlocks.LOREFUL_MUD_BRICKS);
        output.accept(ModBlocks.LOREFUL_PACKED_MUD);
        output.accept(ModBlocks.MAGENTA_CONCRETE_CTM);
        output.accept(ModBlocks.MAGENTA_CONCRETE_PANEL);
                output.accept(ModBlocks.MAGENTA_FLOWER_ACACIA_LEAVES);
                output.accept(ModBlocks.MAGENTA_FLOWER_BIRCH_LEAVES);
                output.accept(ModBlocks.MAGENTA_FLOWER_DARK_OAK_LEAVES);
                output.accept(ModBlocks.MAGENTA_FLOWER_JUNGLE_LEAVES);
                output.accept(ModBlocks.MAGENTA_FLOWER_OAK_LEAVES);
                output.accept(ModBlocks.MAGENTA_FLOWER_SPRUCE_LEAVES);
        output.accept(ModBlocks.MAGENTA_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.MAGENTA_TERRACOTTA_CTM);
        output.accept(ModBlocks.MANGROVE_PLANKS_BEAMS);
        output.accept(ModBlocks.MANGROVE_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.MANGROVE_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.MANGROVE_PLANKS_BRICKS);
        output.accept(ModBlocks.MANGROVE_PLANKS_CRATE);
        output.accept(ModBlocks.MANGROVE_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.MANGROVE_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.MANGROVE_PLANKS_DOTTED);
        output.accept(ModBlocks.MANGROVE_PLANKS_FLOORING);
        output.accept(ModBlocks.MANGROVE_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.MANGROVE_PLANKS_PANEL);
        output.accept(ModBlocks.MANGROVE_PLANKS_PATTERN);
        output.accept(ModBlocks.MANGROVE_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.MANGROVE_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.MANGROVE_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.MANGROVE_PLANKS_SQUARES);
        output.accept(ModBlocks.MANGROVE_PLANKS_TILES);
        output.accept(ModBlocks.MANGROVE_PLANKS_WAVY);
        output.accept(ModBlocks.MANGROVE_PLANKS_WOVEN);
        output.accept(ModBlocks.MANGROVE_WINDOW_BARS);
        output.accept(ModBlocks.MANGROVE_WINDOW_BARS_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_COVERED);
        output.accept(ModBlocks.MANGROVE_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_DIAGONAL);
        output.accept(ModBlocks.MANGROVE_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_LARGE);
        output.accept(ModBlocks.MANGROVE_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_PANES);
        output.accept(ModBlocks.MANGROVE_WINDOW_PANES_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_SLIM);
        output.accept(ModBlocks.MANGROVE_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_SWIRLING);
        output.accept(ModBlocks.MANGROVE_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.MANGROVE_WINDOW_TILES);
        output.accept(ModBlocks.MANGROVE_WINDOW_TILES_CTM);
        output.accept(ModBlocks.MASSIVE_AMETHYST_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_ANCIENT_DEBRIS_BRICKS);
        output.accept(ModBlocks.MASSIVE_ANDESITE_BRICKS);
        output.accept(ModBlocks.MASSIVE_BASALT_BRICKS);
        output.accept(ModBlocks.MASSIVE_BLACKSTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_BLUE_ICE_BRICKS);
        output.accept(ModBlocks.MASSIVE_BORDERLESS_BRICKS_BRICKS);
        output.accept(ModBlocks.MASSIVE_BRICKS_BRICKS);
        output.accept(ModBlocks.MASSIVE_CALCITE_BRICKS);
        output.accept(ModBlocks.MASSIVE_CLAY_BRICKS);
        output.accept(ModBlocks.MASSIVE_COAL_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_COBBLESTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_CRYING_OBSIDIAN_BRICKS);
        output.accept(ModBlocks.MASSIVE_DARK_PRISMARINE_BRICKS);
        output.accept(ModBlocks.MASSIVE_DEEPSLATE_BRICKS);
        output.accept(ModBlocks.MASSIVE_DIORITE_BRICKS);
        output.accept(ModBlocks.MASSIVE_DIRT_BRICKS);
        output.accept(ModBlocks.MASSIVE_DRIPSTONE_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_END_STONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_GILDED_BLACKSTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_ICE_BRICKS);
        output.accept(ModBlocks.MASSIVE_LAPIS_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_LODESTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_MAGMA_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_MOSSY_COBBLESTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_MOSSY_STONE_BRICKS_BRICKS);
        output.accept(ModBlocks.MASSIVE_MUD_BRICKS);
        output.accept(ModBlocks.MASSIVE_MUD_BRICKS_BRICKS);
        output.accept(ModBlocks.MASSIVE_NETHER_BRICKS_BRICKS);
        output.accept(ModBlocks.MASSIVE_NETHERRACK_BRICKS);
        output.accept(ModBlocks.MASSIVE_OBSIDIAN_BRICKS);
        output.accept(ModBlocks.MASSIVE_PACKED_ICE_BRICKS);
        output.accept(ModBlocks.MASSIVE_PACKED_MUD_BRICKS);
        output.accept(ModBlocks.MASSIVE_PRISMARINE_BRICKS);
        output.accept(ModBlocks.MASSIVE_PURPUR_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_QUARTZ_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_RAW_COPPER_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_RAW_GOLD_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_RAW_IRON_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_RED_NETHER_BRICKS_BRICKS);
        output.accept(ModBlocks.MASSIVE_RED_SANDSTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_REDSTONE_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_SANDSTONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_SMOOTH_STONE_BRICKS);
        output.accept(ModBlocks.MASSIVE_SNOW_BLOCK_BRICKS);
        output.accept(ModBlocks.MASSIVE_TUFF_BRICKS);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_BEAMS);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_DENTED);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_INVERTED_DENTED);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_PAVING);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_SMALL_TILES);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_SQUARES);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_STRIPES);
        output.accept(ModBlocks.MOSSY_COBBLESTONE_WORN_STRIPES);
        output.accept(ModBlocks.NATURAL_ACACIA_PLANKS);
        output.accept(ModBlocks.NATURAL_BAMBOO_PLANKS);
        output.accept(ModBlocks.NATURAL_BIRCH_PLANKS);
        output.accept(ModBlocks.NATURAL_OAK_PLANKS);
        output.accept(ModBlocks.NETHER_BRICKS_BEAMS);
        output.accept(ModBlocks.NETHER_BRICKS_BRICK_PATTERN);
        output.accept(ModBlocks.NETHER_BRICKS_BRICK_PAVING);
        output.accept(ModBlocks.NETHER_BRICKS_CHISELED_SQUARES);
        output.accept(ModBlocks.NETHER_BRICKS_DIAGONAL_BRICKS);
        output.accept(ModBlocks.NETHER_BRICKS_LARGE_BRICKS);
        output.accept(ModBlocks.NETHER_BRICKS_LARGE_TILES);
        output.accept(ModBlocks.NETHER_BRICKS_ROTATED_BRICKS);
        output.accept(ModBlocks.NETHER_BRICKS_SMALL_TILES);
        output.accept(ModBlocks.NETHER_BRICKS_SMOOTH);
        output.accept(ModBlocks.NETHER_BRICKS_SQUARES);
        output.accept(ModBlocks.NETHER_BRICKS_TILES);
        output.accept(ModBlocks.NETHERITE_BLOCK_BEAMS);
        output.accept(ModBlocks.NETHERITE_BLOCK_BRICKS);
        output.accept(ModBlocks.NETHERITE_BLOCK_CHISELED);
        output.accept(ModBlocks.NETHERITE_BLOCK_COMPACTED);
        output.accept(ModBlocks.NETHERITE_BLOCK_DECORATED);
        output.accept(ModBlocks.NETHERITE_BLOCK_DIAGONAL_TILES);
        output.accept(ModBlocks.NETHERITE_BLOCK_INDENTED);
        output.accept(ModBlocks.NETHERITE_BLOCK_PATTERNED);
        output.accept(ModBlocks.NETHERITE_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.NETHERRACK_BEAMS);
        output.accept(ModBlocks.NETHERRACK_BRICK_PATTERN);
        output.accept(ModBlocks.NETHERRACK_BRICK_PAVING);
        output.accept(ModBlocks.NETHERRACK_BRICKS);
        output.accept(ModBlocks.NETHERRACK_DENTED);
        output.accept(ModBlocks.NETHERRACK_ROTATED_BRICKS);
        output.accept(ModBlocks.NETHERRACK_SMALL_TILES);
        output.accept(ModBlocks.NETHERRACK_STRIPES);
        output.accept(ModBlocks.NETHERRACK_TILES);
        output.accept(ModBlocks.OAK_BARRED_GLASS);
        output.accept(ModBlocks.OAK_BARRED_GLASS_CTM);
        output.accept(ModBlocks.OAK_BARRED_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_BARRED_GLASS_PANE);
        output.accept(ModBlocks.OAK_BORDERED_GLASS);
        output.accept(ModBlocks.OAK_BORDERED_GLASS_CTM);
        output.accept(ModBlocks.OAK_BORDERED_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_DIAMOND_BORDERED_GLASS);
        output.accept(ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM);
        output.accept(ModBlocks.OAK_DIAMOND_BORDERED_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_DIAMOND_BORDERED_GLASS_PANE);
        output.accept(ModBlocks.OAK_HORIZONTAL_LINED_GLASS);
        output.accept(ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM);
        output.accept(ModBlocks.OAK_HORIZONTAL_LINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_HORIZONTAL_LINED_GLASS_PANE);
        output.accept(ModBlocks.OAK_LARGE_DIAMOND_GLASS);
        output.accept(ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM);
        output.accept(ModBlocks.OAK_LARGE_DIAMOND_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_LARGE_DIAMOND_GLASS_PANE);
        output.accept(ModBlocks.OAK_LINE_BARED_GLASS);
        output.accept(ModBlocks.OAK_LINE_BARED_GLASS_CTM);
        output.accept(ModBlocks.OAK_LINE_BARED_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_LINE_BARED_GLASS_PANE);
        output.accept(ModBlocks.OAK_ORNATE_BARED_GLASS);
        output.accept(ModBlocks.OAK_ORNATE_BARED_GLASS_CTM);
        output.accept(ModBlocks.OAK_ORNATE_BARED_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_ORNATE_BARED_GLASS_PANE);
        output.accept(ModBlocks.OAK_PLANKS_BEAMS);
        output.accept(ModBlocks.OAK_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.OAK_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.OAK_PLANKS_BRICKS);
        output.accept(ModBlocks.OAK_PLANKS_CRATE);
        output.accept(ModBlocks.OAK_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.OAK_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.OAK_PLANKS_DOTTED);
        output.accept(ModBlocks.OAK_PLANKS_FLOORING);
        output.accept(ModBlocks.OAK_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.OAK_PLANKS_PANEL);
        output.accept(ModBlocks.OAK_PLANKS_PATTERN);
        output.accept(ModBlocks.OAK_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.OAK_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.OAK_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.OAK_PLANKS_SQUARES);
        output.accept(ModBlocks.OAK_PLANKS_TILES);
        output.accept(ModBlocks.OAK_PLANKS_WAVY);
        output.accept(ModBlocks.OAK_PLANKS_WOVEN);
        output.accept(ModBlocks.OAK_SNOWFLAKE_GLASS);
        output.accept(ModBlocks.OAK_SNOWFLAKE_GLASS_PANE);
        output.accept(ModBlocks.OAK_WINDOW_BARS);
        output.accept(ModBlocks.OAK_WINDOW_BARS_CTM);
        output.accept(ModBlocks.OAK_WINDOW_COVERED);
        output.accept(ModBlocks.OAK_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.OAK_WINDOW_DIAGONAL);
        output.accept(ModBlocks.OAK_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.OAK_WINDOW_LARGE);
        output.accept(ModBlocks.OAK_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.OAK_WINDOW_PANES_CTM);
        output.accept(ModBlocks.OAK_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_ROUNDED);
        output.accept(ModBlocks.OAK_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.OAK_WINDOW_SLIM);
        output.accept(ModBlocks.OAK_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.OAK_WINDOW_SWIRLING);
        output.accept(ModBlocks.OAK_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.OAK_WINDOW_TILES);
        output.accept(ModBlocks.OAK_WINDOW_TILES_CTM);
        output.accept(ModBlocks.OAK_WOVEN_GLASS);
        output.accept(ModBlocks.OAK_WOVEN_GLASS_CTM);
        output.accept(ModBlocks.OAK_WOVEN_GLASS_CTM_PANE);
        output.accept(ModBlocks.OAK_WOVEN_GLASS_PANE);
        output.accept(ModBlocks.OBSIDIAN_BORDERED);
        output.accept(ModBlocks.OBSIDIAN_BRICK_PATTERN);
        output.accept(ModBlocks.OBSIDIAN_BRICK_PAVING);
        output.accept(ModBlocks.OBSIDIAN_BRICKS);
        output.accept(ModBlocks.OBSIDIAN_CHISELED);
        output.accept(ModBlocks.OBSIDIAN_CHISELED_CIRCLES);
        output.accept(ModBlocks.OBSIDIAN_DARK);
        output.accept(ModBlocks.OBSIDIAN_ROTATED_BRICKS);
        output.accept(ModBlocks.OBSIDIAN_SPOTS);
        output.accept(ModBlocks.OBSIDIAN_SQUARES);
        output.accept(ModBlocks.OBSIDIAN_STRIPES);
        output.accept(ModBlocks.OBSIDIAN_TILES);
        output.accept(ModBlocks.OCHRUM_CUT_POLISHED);
        output.accept(ModBlocks.OCHRUM_CUT_SMALL_BRICK);
                output.accept(ModBlocks.ORANGE_ACACIA_LEAVES);
                output.accept(ModBlocks.ORANGE_BIRCH_LEAVES);
        output.accept(ModBlocks.ORANGE_CONCRETE_CTM);
        output.accept(ModBlocks.ORANGE_CONCRETE_PANEL);
                output.accept(ModBlocks.ORANGE_DARK_OAK_LEAVES);
                output.accept(ModBlocks.ORANGE_JUNGLE_LEAVES);
                output.accept(ModBlocks.ORANGE_OAK_LEAVES);
                output.accept(ModBlocks.ORANGE_SPRUCE_LEAVES);
        output.accept(ModBlocks.ORANGE_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.ORANGE_TERRACOTTA_CTM);
        output.accept(ModBlocks.ORNATE_AMETHYST_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_ANCIENT_DEBRIS_CTM);
        output.accept(ModBlocks.ORNATE_ANDESITE_CTM);
        output.accept(ModBlocks.ORNATE_BASALT_CTM);
        output.accept(ModBlocks.ORNATE_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_BLACK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_BLACKSTONE_CTM);
        output.accept(ModBlocks.ORNATE_BLUE_ICE_CTM);
        output.accept(ModBlocks.ORNATE_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_BORDERLESS_BRICKS_CTM);
        output.accept(ModBlocks.ORNATE_BRICKS_CTM);
        output.accept(ModBlocks.ORNATE_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_BROWN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_CALCITE_CTM);
        output.accept(ModBlocks.ORNATE_CLAY_CTM);
        output.accept(ModBlocks.ORNATE_COAL_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_COBBLESTONE_CTM);
        output.accept(ModBlocks.ORNATE_CRYING_OBSIDIAN_CTM);
        output.accept(ModBlocks.ORNATE_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_CYAN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_DARK_PRISMARINE_CTM);
        output.accept(ModBlocks.ORNATE_DEEPSLATE_CTM);
        output.accept(ModBlocks.ORNATE_DIORITE_CTM);
        output.accept(ModBlocks.ORNATE_DIRT_CTM);
        output.accept(ModBlocks.ORNATE_DRIPSTONE_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_END_STONE_CTM);
        output.accept(ModBlocks.ORNATE_GILDED_BLACKSTONE_CTM);
        output.accept(ModBlocks.ORNATE_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.ORNATE_GREEN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ORNATE_GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ORNATE_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_ICE_CTM);
        output.accept(ModBlocks.ORNATE_LAPIS_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_LEADED_GLASS);
        output.accept(ModBlocks.ORNATE_LEADED_GLASS_PANE);
        output.accept(ModBlocks.ORNATE_LODESTONE_CTM);
        output.accept(ModBlocks.ORNATE_MAGMA_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_MOSSY_COBBLESTONE_CTM);
        output.accept(ModBlocks.ORNATE_MOSSY_STONE_BRICKS_CTM);
        output.accept(ModBlocks.ORNATE_MUD_BRICKS_CTM);
        output.accept(ModBlocks.ORNATE_MUD_CTM);
        output.accept(ModBlocks.ORNATE_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.ORNATE_NETHERRACK_CTM);
        output.accept(ModBlocks.ORNATE_OBSIDIAN_CTM);
        output.accept(ModBlocks.ORNATE_PACKED_ICE_CTM);
        output.accept(ModBlocks.ORNATE_PACKED_MUD_CTM);
        output.accept(ModBlocks.ORNATE_PRISMARINE_CTM);
        output.accept(ModBlocks.ORNATE_PURPUR_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_QUARTZ_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_RAW_COPPER_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_RAW_GOLD_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_RAW_IRON_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_RED_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.ORNATE_RED_SANDSTONE_CTM);
        output.accept(ModBlocks.ORNATE_REDSTONE_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_SANDSTONE_CTM);
        output.accept(ModBlocks.ORNATE_SMOOTH_STONE_CTM);
        output.accept(ModBlocks.ORNATE_SNOW_BLOCK_CTM);
        output.accept(ModBlocks.ORNATE_TUFF_CTM);
        output.accept(ModBlocks.OVERLAPPING_AMETHYST_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_ANCIENT_DEBRIS_TILES);
        output.accept(ModBlocks.OVERLAPPING_ANDESITE_TILES);
        output.accept(ModBlocks.OVERLAPPING_BASALT_TILES);
        output.accept(ModBlocks.OVERLAPPING_BLACKSTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_BLUE_ICE_TILES);
        output.accept(ModBlocks.OVERLAPPING_BORDERLESS_BRICKS_TILES);
        output.accept(ModBlocks.OVERLAPPING_BRICKS_TILES);
        output.accept(ModBlocks.OVERLAPPING_CALCITE_TILES);
        output.accept(ModBlocks.OVERLAPPING_CLAY_TILES);
        output.accept(ModBlocks.OVERLAPPING_COAL_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_COBBLESTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_CRYING_OBSIDIAN_TILES);
        output.accept(ModBlocks.OVERLAPPING_DARK_PRISMARINE_TILES);
        output.accept(ModBlocks.OVERLAPPING_DEEPSLATE_TILES);
        output.accept(ModBlocks.OVERLAPPING_DIORITE_TILES);
        output.accept(ModBlocks.OVERLAPPING_DIRT_TILES);
        output.accept(ModBlocks.OVERLAPPING_DRIPSTONE_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_END_STONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_GILDED_BLACKSTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_ICE_TILES);
        output.accept(ModBlocks.OVERLAPPING_LAPIS_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_LODESTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_MAGMA_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_MOSSY_COBBLESTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_MOSSY_STONE_BRICKS_TILES);
        output.accept(ModBlocks.OVERLAPPING_MUD_BRICKS_TILES);
        output.accept(ModBlocks.OVERLAPPING_MUD_TILES);
        output.accept(ModBlocks.OVERLAPPING_NETHER_BRICKS_TILES);
        output.accept(ModBlocks.OVERLAPPING_NETHERRACK_TILES);
        output.accept(ModBlocks.OVERLAPPING_OBSIDIAN_TILES);
        output.accept(ModBlocks.OVERLAPPING_PACKED_ICE_TILES);
        output.accept(ModBlocks.OVERLAPPING_PACKED_MUD_TILES);
        output.accept(ModBlocks.OVERLAPPING_PRISMARINE_TILES);
        output.accept(ModBlocks.OVERLAPPING_PURPUR_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_QUARTZ_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_RAW_COPPER_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_RAW_GOLD_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_RAW_IRON_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_RED_NETHER_BRICKS_TILES);
        output.accept(ModBlocks.OVERLAPPING_RED_SANDSTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_REDSTONE_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_SANDSTONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_SMOOTH_STONE_TILES);
        output.accept(ModBlocks.OVERLAPPING_SNOW_BLOCK_TILES);
        output.accept(ModBlocks.OVERLAPPING_TUFF_TILES);
        output.accept(ModBlocks.PEGGED_ACACIA_PLANKS);
        output.accept(ModBlocks.PEGGED_BIRCH_PLANKS);
        output.accept(ModBlocks.PEGGED_BLACK_CONCRETE);
        output.accept(ModBlocks.PEGGED_BLUE_CONCRETE);
        output.accept(ModBlocks.PEGGED_BROWN_CONCRETE);
        output.accept(ModBlocks.PEGGED_CYAN_CONCRETE);
        output.accept(ModBlocks.PEGGED_GRAY_CONCRETE);
        output.accept(ModBlocks.PEGGED_GREEN_CONCRETE);
        output.accept(ModBlocks.PEGGED_LIGHT_BLUE_CONCRETE);
        output.accept(ModBlocks.PEGGED_LIGHT_GRAY_CONCRETE);
        output.accept(ModBlocks.PEGGED_LIME_CONCRETE);
        output.accept(ModBlocks.PEGGED_MAGENTA_CONCRETE);
        output.accept(ModBlocks.PEGGED_OAK_PLANKS);
        output.accept(ModBlocks.PEGGED_ORANGE_CONCRETE);
        output.accept(ModBlocks.PEGGED_PINK_CONCRETE);
        output.accept(ModBlocks.PEGGED_PURPLE_CONCRETE);
        output.accept(ModBlocks.PEGGED_RED_CONCRETE);
        output.accept(ModBlocks.PEGGED_WHITE_CONCRETE);
        output.accept(ModBlocks.PEGGED_YELLOW_CONCRETE);
        output.accept(ModBlocks.PINK_CONCRETE_CTM);
        output.accept(ModBlocks.PINK_CONCRETE_PANEL);
        output.accept(ModBlocks.PINK_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.PINK_TERRACOTTA_CTM);
        output.accept(ModBlocks.POLISHED_AMETHYST_BLOCK);
        output.accept(ModBlocks.POLISHED_ANCIENT_DEBRIS);
        output.accept(ModBlocks.POLISHED_BAMBOO_PLANKS);
        output.accept(ModBlocks.POLISHED_BASALT);
        output.accept(ModBlocks.POLISHED_BIRCH_PLANKS);
        output.accept(ModBlocks.POLISHED_BLUE_ICE);
        output.accept(ModBlocks.POLISHED_BORDERLESS_BRICKS);
        output.accept(ModBlocks.POLISHED_BRICKS);
        output.accept(ModBlocks.POLISHED_CALCITE);
        output.accept(ModBlocks.POLISHED_CLAY);
        output.accept(ModBlocks.POLISHED_COAL_BLOCK);
        output.accept(ModBlocks.POLISHED_COBBLESTONE);
        output.accept(ModBlocks.POLISHED_CRYING_OBSIDIAN);
        output.accept(ModBlocks.POLISHED_DARK_PRISMARINE);
        output.accept(ModBlocks.POLISHED_DEEPSLATE);
        output.accept(ModBlocks.POLISHED_DIRT);
        output.accept(ModBlocks.POLISHED_DRIPSTONE);
        output.accept(ModBlocks.POLISHED_DRIPSTONE_BLOCK);
        output.accept(ModBlocks.POLISHED_END_STONE);
        output.accept(ModBlocks.POLISHED_GILDED_BLACKSTONE);
        output.accept(ModBlocks.POLISHED_ICE);
        output.accept(ModBlocks.POLISHED_LAPIS_BLOCK);
        output.accept(ModBlocks.POLISHED_LODESTONE);
        output.accept(ModBlocks.POLISHED_MAGMA_BLOCK);
        output.accept(ModBlocks.POLISHED_MOSSY_COBBLESTONE);
        output.accept(ModBlocks.POLISHED_MOSSY_STONE_BRICKS);
        output.accept(ModBlocks.POLISHED_NETHER_BRICKS);
        output.accept(ModBlocks.POLISHED_NETHERRACK);
        output.accept(ModBlocks.POLISHED_OBSIDIAN);
        output.accept(ModBlocks.POLISHED_PACKED_ICE);
        output.accept(ModBlocks.POLISHED_PRISMARINE);
        output.accept(ModBlocks.POLISHED_PURPUR_BLOCK);
        output.accept(ModBlocks.POLISHED_QUARTZ_BLOCK);
        output.accept(ModBlocks.POLISHED_RAW_COPPER_BLOCK);
        output.accept(ModBlocks.POLISHED_RAW_GOLD_BLOCK);
        output.accept(ModBlocks.POLISHED_RAW_IRON_BLOCK);
        output.accept(ModBlocks.POLISHED_RED_NETHER_BRICKS);
        output.accept(ModBlocks.POLISHED_RED_SANDSTONE);
        output.accept(ModBlocks.POLISHED_REDSTONE_BLOCK);
        output.accept(ModBlocks.POLISHED_SANDSTONE);
        output.accept(ModBlocks.POLISHED_SMOOTH_STONE);
        output.accept(ModBlocks.POLISHED_SNOW_BLOCK);
        output.accept(ModBlocks.POLISHED_TUFF);
        output.accept(ModBlocks.PRISMARINE_BRICKS_BEAMS);
        output.accept(ModBlocks.PRISMARINE_BRICKS_BRICK_PATTERN);
        output.accept(ModBlocks.PRISMARINE_BRICKS_BRICK_PAVING);
        output.accept(ModBlocks.PRISMARINE_BRICKS_BRICKS);
        output.accept(ModBlocks.PRISMARINE_BRICKS_CHISELED_CIRCLES);
        output.accept(ModBlocks.PRISMARINE_BRICKS_CHISELED_SQUARES);
        output.accept(ModBlocks.PRISMARINE_BRICKS_DIAGONAL_BRICKS);
        output.accept(ModBlocks.PRISMARINE_BRICKS_DIAGONAL_TILES);
        output.accept(ModBlocks.PRISMARINE_BRICKS_DOTTED);
        output.accept(ModBlocks.PRISMARINE_BRICKS_PILLARS);
        output.accept(ModBlocks.PRISMARINE_BRICKS_POLISHED);
        output.accept(ModBlocks.PRISMARINE_BRICKS_ROTATED_BRICKS);
        output.accept(ModBlocks.PRISMARINE_BRICKS_ROWS);
        output.accept(ModBlocks.PRISMARINE_BRICKS_SMALL_TILES);
        output.accept(ModBlocks.PRISMARINE_BRICKS_SQUARES);
        output.accept(ModBlocks.PRISMARINE_BRICKS_TILES);
        output.accept(ModBlocks.PRISMARINE_BRICKS_WAVY);
        output.accept(ModBlocks.PRISMARINE_BRICKS_WOVEN);
        output.accept(ModBlocks.PURPLE_CONCRETE_CTM);
        output.accept(ModBlocks.PURPLE_CONCRETE_PANEL);
        output.accept(ModBlocks.PURPLE_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.PURPLE_TERRACOTTA_CTM);
        output.accept(ModBlocks.PURPUR_BRICK_PATTERN);
        output.accept(ModBlocks.PURPUR_BRICK_PAVING);
        output.accept(ModBlocks.PURPUR_BRICKS);
                output.accept(ModBlocks.PURPUR_COLUMN_CTM);
        output.accept(ModBlocks.PURPUR_DIAGONAL_BRICKS);
        output.accept(ModBlocks.PURPUR_DIAGONAL_TILES);
        output.accept(ModBlocks.PURPUR_DOTTED);
        output.accept(ModBlocks.PURPUR_FABRIC);
        output.accept(ModBlocks.PURPUR_JAGGED_PATTERN);
        output.accept(ModBlocks.PURPUR_LARGE_TILES);
        output.accept(ModBlocks.PURPUR_ORGANIC_PATTERN);
        output.accept(ModBlocks.PURPUR_ROTATED_BRICKS);
        output.accept(ModBlocks.PURPUR_SLANTED_TILES);
        output.accept(ModBlocks.PURPUR_SMALL_TILES);
        output.accept(ModBlocks.PURPUR_SPIRAL_PATTERN);
        output.accept(ModBlocks.PURPUR_SQUARES);
        output.accept(ModBlocks.PURPUR_TILES);
        output.accept(ModBlocks.PURPUR_WOVEN);
        output.accept(ModBlocks.QUARTZ_BLOCK);
        output.accept(ModBlocks.QUARTZ_BLOCK_BORDERED);
        output.accept(ModBlocks.QUARTZ_BLOCK_BRICK_PAVING);
        output.accept(ModBlocks.QUARTZ_BLOCK_CHISELED_CTM);
        output.accept(ModBlocks.QUARTZ_BLOCK_CONNECTING);
        output.accept(ModBlocks.QUARTZ_BLOCK_CROSSES);
        output.accept(ModBlocks.QUARTZ_BLOCK_DIAGONAL_TILES);
        output.accept(ModBlocks.QUARTZ_BLOCK_PATTERN);
        output.accept(ModBlocks.QUARTZ_BLOCK_ROTATED_BRICKS);
        output.accept(ModBlocks.QUARTZ_BLOCK_ROWS);
        output.accept(ModBlocks.QUARTZ_BLOCK_SCALES);
        output.accept(ModBlocks.QUARTZ_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.QUARTZ_BLOCK_SQUARES);
        output.accept(ModBlocks.QUARTZ_BLOCK_STRIPES);
        output.accept(ModBlocks.QUARTZ_BLOCK_TILES);
        output.accept(ModBlocks.RASTER_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_BLACK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_BROWN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_CYAN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.RASTER_GREEN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.RASTER_LEADED_GLASS);
        output.accept(ModBlocks.RASTER_LEADED_GLASS_CTM);
        output.accept(ModBlocks.RASTER_LEADED_GLASS_CTM_PANE);
        output.accept(ModBlocks.RASTER_LEADED_GLASS_PANE);
        output.accept(ModBlocks.RECTANGLE_BLACK_WOOL);
        output.accept(ModBlocks.RECTANGLE_BLUE_WOOL);
        output.accept(ModBlocks.RECTANGLE_BROWN_WOOL);
                // ===== RECOVERED WAVE2 =====
        output.accept(ModBlocks.BORDERED_BORDERLESS_BRICKS);
        output.accept(ModBlocks.BORDERED_BRICKS);
        output.accept(ModBlocks.BORDERED_CALCITE);
        output.accept(ModBlocks.BORDERED_CLAY);
        output.accept(ModBlocks.BORDERED_COAL_BLOCK);
        output.accept(ModBlocks.BORDERED_COBBLESTONE);
        output.accept(ModBlocks.BORDERED_CRYING_OBSIDIAN);
        output.accept(ModBlocks.BORDERED_DARK_PRISMARINE);
        output.accept(ModBlocks.BORDERED_DEEPSLATE);
        output.accept(ModBlocks.BORDERED_DIORITE);
        output.accept(ModBlocks.BORDERED_DIRT);
        output.accept(ModBlocks.BORDERED_DRIPSTONE_BLOCK);
        output.accept(ModBlocks.BORDERED_END_STONE);
        output.accept(ModBlocks.BORDERED_GILDED_BLACKSTONE);
        output.accept(ModBlocks.BORDERED_ICE);
        output.accept(ModBlocks.BORDERED_LAPIS_BLOCK);
        output.accept(ModBlocks.BORDERED_LODESTONE);
        output.accept(ModBlocks.BORDERED_MAGMA_BLOCK);
        output.accept(ModBlocks.BORDERED_MOSSY_COBBLESTONE);
        output.accept(ModBlocks.BORDERED_MOSSY_STONE_BRICKS);
        output.accept(ModBlocks.BORDERED_MUD);
        output.accept(ModBlocks.BORDERED_MUD_BRICKS);
        output.accept(ModBlocks.BORDERED_NETHER_BRICKS);
        output.accept(ModBlocks.BORDERED_NETHERRACK);
        output.accept(ModBlocks.BORDERED_OBSIDIAN);
        output.accept(ModBlocks.BORDERED_PACKED_ICE);
        output.accept(ModBlocks.BORDERED_PACKED_MUD);
        output.accept(ModBlocks.BORDERED_PRISMARINE);
        output.accept(ModBlocks.BORDERED_PURPUR_BLOCK);
        output.accept(ModBlocks.BORDERED_QUARTZ_BLOCK);
        output.accept(ModBlocks.BORDERED_RAW_COPPER_BLOCK);
        output.accept(ModBlocks.BORDERED_RAW_GOLD_BLOCK);
        output.accept(ModBlocks.BORDERED_RAW_IRON_BLOCK);
        output.accept(ModBlocks.BORDERED_RED_NETHER_BRICKS);
        output.accept(ModBlocks.BORDERED_RED_SANDSTONE);
        output.accept(ModBlocks.BORDERED_REDSTONE_BLOCK);
        output.accept(ModBlocks.BORDERED_SANDSTONE);
        output.accept(ModBlocks.BORDERED_SMOOTH_STONE);
        output.accept(ModBlocks.BORDERED_SNOW_BLOCK);
        output.accept(ModBlocks.BORDERED_TUFF);
        output.accept(ModBlocks.BRICK_BORDERED_AMETHYST_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_ANCIENT_DEBRIS);
        output.accept(ModBlocks.BRICK_BORDERED_ANDESITE);
        output.accept(ModBlocks.BRICK_BORDERED_BASALT);
        output.accept(ModBlocks.BRICK_BORDERED_BLACKSTONE);
        output.accept(ModBlocks.BRICK_BORDERED_BLUE_ICE);
        output.accept(ModBlocks.BRICK_BORDERED_BORDERLESS_BRICKS);
        output.accept(ModBlocks.BRICK_BORDERED_BRICKS);
        output.accept(ModBlocks.BRICK_BORDERED_CALCITE);
        output.accept(ModBlocks.BRICK_BORDERED_CLAY);
        output.accept(ModBlocks.BRICK_BORDERED_COAL_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_COBBLESTONE);
        output.accept(ModBlocks.BRICK_BORDERED_CRYING_OBSIDIAN);
        output.accept(ModBlocks.BRICK_BORDERED_DARK_PRISMARINE);
        output.accept(ModBlocks.BRICK_BORDERED_DEEPSLATE);
        output.accept(ModBlocks.BRICK_BORDERED_DIORITE);
        output.accept(ModBlocks.BRICK_BORDERED_DIRT);
        output.accept(ModBlocks.BRICK_BORDERED_DRIPSTONE_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_END_STONE);
        output.accept(ModBlocks.BRICK_BORDERED_GILDED_BLACKSTONE);
        output.accept(ModBlocks.BRICK_BORDERED_ICE);
        output.accept(ModBlocks.BRICK_BORDERED_LAPIS_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_LODESTONE);
        output.accept(ModBlocks.BRICK_BORDERED_MAGMA_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_MOSSY_COBBLESTONE);
        output.accept(ModBlocks.BRICK_BORDERED_MOSSY_STONE_BRICKS);
        output.accept(ModBlocks.BRICK_BORDERED_MUD);
        output.accept(ModBlocks.BRICK_BORDERED_MUD_BRICKS);
        output.accept(ModBlocks.BRICK_BORDERED_NETHER_BRICKS);
        output.accept(ModBlocks.BRICK_BORDERED_NETHERRACK);
        output.accept(ModBlocks.BRICK_BORDERED_OBSIDIAN);
        output.accept(ModBlocks.BRICK_BORDERED_PACKED_ICE);
        output.accept(ModBlocks.BRICK_BORDERED_PACKED_MUD);
        output.accept(ModBlocks.BRICK_BORDERED_PRISMARINE);
        output.accept(ModBlocks.BRICK_BORDERED_PURPUR_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_QUARTZ_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_RAW_COPPER_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_RAW_GOLD_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_RAW_IRON_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_RED_NETHER_BRICKS);
        output.accept(ModBlocks.BRICK_BORDERED_RED_SANDSTONE);
        output.accept(ModBlocks.BRICK_BORDERED_REDSTONE_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_SANDSTONE);
        output.accept(ModBlocks.BRICK_BORDERED_SMOOTH_STONE);
        output.accept(ModBlocks.BRICK_BORDERED_SNOW_BLOCK);
        output.accept(ModBlocks.BRICK_BORDERED_TUFF);
        output.accept(ModBlocks.BROWN_CONCRETE_CTM);
        output.accept(ModBlocks.BROWN_CONCRETE_PANEL);
        output.accept(ModBlocks.BROWN_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.BROWN_TERRACOTTA_CTM);
        output.accept(ModBlocks.CALCITE_CUT_POLISHED);
        output.accept(ModBlocks.CALCITE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.CARVED_MUD_BRICKS_CTM);
        output.accept(ModBlocks.CARVED_MUD_CTM);
        output.accept(ModBlocks.CARVED_PACKED_MUD_CTM);
                output.accept(ModBlocks.CHERRY_ACACIA_LEAVES);
                output.accept(ModBlocks.CHERRY_BIRCH_LEAVES);
                output.accept(ModBlocks.CHERRY_DARK_OAK_LEAVES);
                output.accept(ModBlocks.CHERRY_JUNGLE_LEAVES);
                output.accept(ModBlocks.CHERRY_OAK_LEAVES);
        output.accept(ModBlocks.CHERRY_PLANKS_BEAMS);
        output.accept(ModBlocks.CHERRY_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.CHERRY_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.CHERRY_PLANKS_BRICKS);
        output.accept(ModBlocks.CHERRY_PLANKS_CRATE);
        output.accept(ModBlocks.CHERRY_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.CHERRY_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.CHERRY_PLANKS_DOTTED);
        output.accept(ModBlocks.CHERRY_PLANKS_FLOORING);
        output.accept(ModBlocks.CHERRY_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.CHERRY_PLANKS_PANEL);
        output.accept(ModBlocks.CHERRY_PLANKS_PATTERN);
        output.accept(ModBlocks.CHERRY_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.CHERRY_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.CHERRY_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.CHERRY_PLANKS_SQUARES);
        output.accept(ModBlocks.CHERRY_PLANKS_TILES);
        output.accept(ModBlocks.CHERRY_PLANKS_WAVY);
        output.accept(ModBlocks.CHERRY_PLANKS_WOVEN);
                output.accept(ModBlocks.CHERRY_SPRUCE_LEAVES);
        output.accept(ModBlocks.CIRCLE_OAK_GLASS);
        output.accept(ModBlocks.CIRCLE_OAK_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.CIRCULAR_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_BLACK_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.CIRCULAR_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_BLUE_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.CIRCULAR_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_BROWN_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.CIRCULAR_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_CYAN_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.CIRCULAR_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_GRAY_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.CIRCULAR_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.CIRCULAR_GREEN_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_LIGHT_BLUE_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_LIGHT_GRAY_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_LIME_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_MAGENTA_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_ORANGE_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_PINK_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_PURPLE_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_RED_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_WHITE_TERRACOTTA);
        output.accept(ModBlocks.CIRCULAR_YELLOW_TERRACOTTA);
        output.accept(ModBlocks.CLEAR_LEADED_GLASS);
        output.accept(ModBlocks.CLEAR_LEADED_GLASS_CTM);
        output.accept(ModBlocks.CLEAR_LEADED_GLASS_CTM_PANE);
        output.accept(ModBlocks.CLEAR_LEADED_GLASS_PANE);
        output.accept(ModBlocks.COAL_BLOCK_CARVED);
        output.accept(ModBlocks.COAL_BLOCK_CHISELED);
        output.accept(ModBlocks.COAL_BLOCK_CIRCLES);
        output.accept(ModBlocks.COAL_BLOCK_COMPACTED);
        output.accept(ModBlocks.COAL_BLOCK_OVALS);
        output.accept(ModBlocks.COAL_BLOCK_PATTERN);
        output.accept(ModBlocks.COAL_BLOCK_ROTATED_BRICKS);
        output.accept(ModBlocks.COAL_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.COAL_BLOCK_STRIPES);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_BEAMS);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_BRICK_PATTERN);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_BRICK_PAVING);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_BRICKS);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_LARGE_TILES);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_PAVING);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_PULVERIZED);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_ROTATED_BRICKS);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_SMALL_TILES);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_SQUARES);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_STRIPES);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_TILES);
        output.accept(ModBlocks.COBBLED_DEEPSLATE_WORN_STRIPES);
        output.accept(ModBlocks.COBBLESTONE_BEAMS);
        output.accept(ModBlocks.COBBLESTONE_BRICK_PATTERN);
        output.accept(ModBlocks.COBBLESTONE_BRICK_PAVING);
        output.accept(ModBlocks.COBBLESTONE_CHISELED_BORDER);
        output.accept(ModBlocks.COBBLESTONE_CROSSES);
        output.accept(ModBlocks.COBBLESTONE_DENTED);
        output.accept(ModBlocks.COBBLESTONE_INVERTED_DENTED);
        output.accept(ModBlocks.COBBLESTONE_PAVING);
        output.accept(ModBlocks.COBBLESTONE_PULVERIZED);
        output.accept(ModBlocks.COBBLESTONE_ROTATED_BRICKS);
        output.accept(ModBlocks.COBBLESTONE_SMALL_TILES);
        output.accept(ModBlocks.COBBLESTONE_SQUARES);
        output.accept(ModBlocks.COBBLESTONE_STRIPES);
        output.accept(ModBlocks.COBBLESTONE_TILES);
        output.accept(ModBlocks.COBBLESTONE_WORN_STRIPES);
        output.accept(ModBlocks.COPPER_BLOCK_BARS);
        output.accept(ModBlocks.COPPER_BLOCK_CIRCLES);
        output.accept(ModBlocks.COPPER_BLOCK_GEARS);
        output.accept(ModBlocks.COPPER_BLOCK_LINES);
        output.accept(ModBlocks.COPPER_BLOCK_PATTERN);
        output.accept(ModBlocks.COPPER_BLOCK_POLISHED);
        output.accept(ModBlocks.COPPER_BLOCK_SHAFTS);
        output.accept(ModBlocks.COPPER_BLOCK_SMALL_BRICKS);
        output.accept(ModBlocks.CORNERED_ACACIA_PLANKS);
        output.accept(ModBlocks.CORNERED_BAMBOO_PLANKS);
        output.accept(ModBlocks.CORNERED_BIRCH_PLANKS);
        output.accept(ModBlocks.CORNERED_BLACK_WOOL);
        output.accept(ModBlocks.CORNERED_BLUE_WOOL);
        output.accept(ModBlocks.CORNERED_BROWN_WOOL);
        output.accept(ModBlocks.CORNERED_CYAN_WOOL);
        output.accept(ModBlocks.CORNERED_GRAY_WOOL);
        output.accept(ModBlocks.CORNERED_GREEN_WOOL);
        output.accept(ModBlocks.CORNERED_LIGHT_BLUE_WOOL);
        output.accept(ModBlocks.CORNERED_LIGHT_GRAY_WOOL);
        output.accept(ModBlocks.CORNERED_LIME_WOOL);
        output.accept(ModBlocks.CORNERED_MAGENTA_WOOL);
        output.accept(ModBlocks.CORNERED_OAK_PLANKS);
        output.accept(ModBlocks.CORNERED_ORANGE_WOOL);
        output.accept(ModBlocks.CORNERED_PINK_WOOL);
        output.accept(ModBlocks.CORNERED_PURPLE_WOOL);
        output.accept(ModBlocks.CORNERED_RED_WOOL);
        output.accept(ModBlocks.CORNERED_WHITE_WOOL);
        output.accept(ModBlocks.CORNERED_YELLOW_WOOL);
        output.accept(ModBlocks.CRAFTED_BLACK_WOOL);
        output.accept(ModBlocks.CRAFTED_BLUE_WOOL);
        output.accept(ModBlocks.CRAFTED_BROWN_WOOL);
        output.accept(ModBlocks.CRAFTED_CYAN_WOOL);
        output.accept(ModBlocks.CRAFTED_GRAY_WOOL);
        output.accept(ModBlocks.CRAFTED_GREEN_WOOL);
        output.accept(ModBlocks.CRAFTED_LIGHT_BLUE_WOOL);
        output.accept(ModBlocks.CRAFTED_LIGHT_GRAY_WOOL);
        output.accept(ModBlocks.CRAFTED_LIME_WOOL);
        output.accept(ModBlocks.CRAFTED_MAGENTA_WOOL);
        output.accept(ModBlocks.CRAFTED_ORANGE_WOOL);
        output.accept(ModBlocks.CRAFTED_PINK_WOOL);
        output.accept(ModBlocks.CRAFTED_PURPLE_WOOL);
        output.accept(ModBlocks.CRAFTED_RED_WOOL);
        output.accept(ModBlocks.CRAFTED_WHITE_WOOL);
        output.accept(ModBlocks.CRAFTED_YELLOW_WOOL);
        output.accept(ModBlocks.CRATED_ACACIA_PLANKS);
        output.accept(ModBlocks.CRATED_BAMBOO_PLANKS);
        output.accept(ModBlocks.CRATED_BIRCH_PLANKS);
        output.accept(ModBlocks.CRATED_OAK_PLANKS);
        output.accept(ModBlocks.CRIMSITE_CUT_POLISHED);
        output.accept(ModBlocks.CRIMSITE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.CRIMSON_PLANKS_BEAMS);
        output.accept(ModBlocks.CRIMSON_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.CRIMSON_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.CRIMSON_PLANKS_BRICKS);
        output.accept(ModBlocks.CRIMSON_PLANKS_CRATE);
        output.accept(ModBlocks.CRIMSON_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.CRIMSON_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.CRIMSON_PLANKS_DOTTED);
        output.accept(ModBlocks.CRIMSON_PLANKS_FLOORING);
        output.accept(ModBlocks.CRIMSON_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.CRIMSON_PLANKS_PANEL);
        output.accept(ModBlocks.CRIMSON_PLANKS_PATTERN);
        output.accept(ModBlocks.CRIMSON_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.CRIMSON_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.CRIMSON_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.CRIMSON_PLANKS_SQUARES);
        output.accept(ModBlocks.CRIMSON_PLANKS_TILES);
        output.accept(ModBlocks.CRIMSON_PLANKS_WAVY);
        output.accept(ModBlocks.CRIMSON_PLANKS_WOVEN);
        output.accept(ModBlocks.CRIMSON_WINDOW_BARS);
        output.accept(ModBlocks.CRIMSON_WINDOW_BARS_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_COVERED);
        output.accept(ModBlocks.CRIMSON_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_LARGE);
        output.accept(ModBlocks.CRIMSON_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_PANES);
        output.accept(ModBlocks.CRIMSON_WINDOW_PANES_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_ROUNDED);
        output.accept(ModBlocks.CRIMSON_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_SLIM);
        output.accept(ModBlocks.CRIMSON_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_SWIRLING);
        output.accept(ModBlocks.CRIMSON_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.CRIMSON_WINDOW_TILES);
        output.accept(ModBlocks.CRIMSON_WINDOW_TILES_CTM);
        output.accept(ModBlocks.CURLED_BLACK_TERRACOTTA);
        output.accept(ModBlocks.CURLED_BLUE_TERRACOTTA);
        output.accept(ModBlocks.CURLED_BROWN_TERRACOTTA);
        output.accept(ModBlocks.CURLED_CYAN_TERRACOTTA);
        output.accept(ModBlocks.CURLED_GRAY_TERRACOTTA);
        output.accept(ModBlocks.CURLED_GREEN_TERRACOTTA);
        output.accept(ModBlocks.CURLED_LIGHT_BLUE_TERRACOTTA);
        output.accept(ModBlocks.CURLED_LIGHT_GRAY_TERRACOTTA);
        output.accept(ModBlocks.CURLED_LIME_TERRACOTTA);
        output.accept(ModBlocks.CURLED_MAGENTA_TERRACOTTA);
        output.accept(ModBlocks.CURLED_ORANGE_TERRACOTTA);
        output.accept(ModBlocks.CURLED_PINK_TERRACOTTA);
        output.accept(ModBlocks.CURLED_PURPLE_TERRACOTTA);
        output.accept(ModBlocks.CURLED_RED_TERRACOTTA);
        output.accept(ModBlocks.CURLED_TERRACOTTA);
        output.accept(ModBlocks.CURLED_WHITE_TERRACOTTA);
        output.accept(ModBlocks.CURLED_YELLOW_TERRACOTTA);
        output.accept(ModBlocks.CURLY_AMETHYST_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_ANCIENT_DEBRIS_CTM);
        output.accept(ModBlocks.CURLY_ANDESITE_CTM);
        output.accept(ModBlocks.CURLY_BASALT_CTM);
        output.accept(ModBlocks.CURLY_BLACKSTONE_CTM);
        output.accept(ModBlocks.CURLY_BLUE_ICE_CTM);
        output.accept(ModBlocks.CURLY_BORDERLESS_BRICKS_CTM);
        output.accept(ModBlocks.CURLY_BRICKS_CTM);
        output.accept(ModBlocks.CURLY_CALCITE_CTM);
        output.accept(ModBlocks.CURLY_CLAY_CTM);
        output.accept(ModBlocks.CURLY_COAL_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_COBBLESTONE_CTM);
        output.accept(ModBlocks.CURLY_CRYING_OBSIDIAN_CTM);
        output.accept(ModBlocks.CURLY_DARK_PRISMARINE_CTM);
        output.accept(ModBlocks.CURLY_DEEPSLATE_CTM);
        output.accept(ModBlocks.CURLY_DIORITE_CTM);
        output.accept(ModBlocks.CURLY_DIRT_CTM);
        output.accept(ModBlocks.CURLY_DRIPSTONE_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_END_STONE_CTM);
        output.accept(ModBlocks.CURLY_GILDED_BLACKSTONE_CTM);
        output.accept(ModBlocks.CURLY_ICE_CTM);
        output.accept(ModBlocks.CURLY_LAPIS_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_LODESTONE_CTM);
        output.accept(ModBlocks.CURLY_MAGMA_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_MOSSY_COBBLESTONE_CTM);
        output.accept(ModBlocks.CURLY_MOSSY_STONE_BRICKS_CTM);
        output.accept(ModBlocks.CURLY_MUD_BRICKS_CTM);
        output.accept(ModBlocks.CURLY_MUD_CTM);
        output.accept(ModBlocks.CURLY_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.CURLY_NETHERRACK_CTM);
        output.accept(ModBlocks.CURLY_OBSIDIAN_CTM);
        output.accept(ModBlocks.CURLY_PACKED_ICE_CTM);
        output.accept(ModBlocks.CURLY_PACKED_MUD_CTM);
        output.accept(ModBlocks.CURLY_PRISMARINE_CTM);
        output.accept(ModBlocks.CURLY_PURPUR_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_QUARTZ_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_RAW_COPPER_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_RAW_GOLD_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_RAW_IRON_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_RED_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.CURLY_RED_SANDSTONE_CTM);
        output.accept(ModBlocks.CURLY_REDSTONE_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_SANDSTONE_CTM);
        output.accept(ModBlocks.CURLY_SMOOTH_STONE_CTM);
        output.accept(ModBlocks.CURLY_SNOW_BLOCK_CTM);
        output.accept(ModBlocks.CURLY_TUFF_CTM);
        output.accept(ModBlocks.CUT_AMETHYST_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_ANCIENT_DEBRIS_COLUMN);
        output.accept(ModBlocks.CUT_ANDESITE_COLUMN);
        output.accept(ModBlocks.CUT_BASALT_COLUMN);
        output.accept(ModBlocks.CUT_BLACKSTONE_COLUMN);
                output.accept(ModBlocks.CUT_BLANK_STONE);
        output.accept(ModBlocks.CUT_BLUE_ICE_COLUMN);
        output.accept(ModBlocks.CUT_BORDERLESS_BRICKS_COLUMN);
        output.accept(ModBlocks.CUT_BRICKS_COLUMN);
        output.accept(ModBlocks.CUT_CALCITE_COLUMN);
        output.accept(ModBlocks.CUT_CLAY_COLUMN);
        output.accept(ModBlocks.CUT_COAL_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_COBBLESTONE_COLUMN);
        output.accept(ModBlocks.CUT_CRYING_OBSIDIAN_COLUMN);
        output.accept(ModBlocks.CUT_DARK_PRISMARINE_COLUMN);
        output.accept(ModBlocks.CUT_DEEPSLATE_COLUMN);
        output.accept(ModBlocks.CUT_DIORITE_COLUMN);
        output.accept(ModBlocks.CUT_DIRT_COLUMN);
        output.accept(ModBlocks.CUT_DRIPSTONE_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_END_STONE_COLUMN);
        output.accept(ModBlocks.CUT_GILDED_BLACKSTONE_COLUMN);
        output.accept(ModBlocks.CUT_ICE_COLUMN);
        output.accept(ModBlocks.CUT_LAPIS_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_LODESTONE_COLUMN);
        output.accept(ModBlocks.CUT_MAGMA_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_MOSSY_COBBLESTONE_COLUMN);
        output.accept(ModBlocks.CUT_MOSSY_STONE_BRICKS_COLUMN);
        output.accept(ModBlocks.CUT_NETHER_BRICKS_COLUMN);
        output.accept(ModBlocks.CUT_NETHERRACK_COLUMN);
        output.accept(ModBlocks.CUT_OBSIDIAN_COLUMN);
        output.accept(ModBlocks.CUT_PACKED_ICE_COLUMN);
        output.accept(ModBlocks.CUT_PRISMARINE_COLUMN);
        output.accept(ModBlocks.CUT_PURPUR_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_QUARTZ_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_RAW_COPPER_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_RAW_GOLD_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_RAW_IRON_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_RED_NETHER_BRICKS_COLUMN);
        output.accept(ModBlocks.CUT_RED_SANDSTONE);
        output.accept(ModBlocks.CUT_RED_SANDSTONE_COLUMN);
        output.accept(ModBlocks.CUT_REDSTONE_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_SANDSTONE);
        output.accept(ModBlocks.CUT_SANDSTONE_COLUMN);
        output.accept(ModBlocks.CUT_SMOOTH_STONE_COLUMN);
        output.accept(ModBlocks.CUT_SNOW_BLOCK_COLUMN);
        output.accept(ModBlocks.CUT_TUFF_COLUMN);
        output.accept(ModBlocks.CYAN_CONCRETE_CTM);
        output.accept(ModBlocks.CYAN_CONCRETE_PANEL);
        output.accept(ModBlocks.CYAN_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.CYAN_TERRACOTTA_CTM);
        output.accept(ModBlocks.DARK_OAK_PLANKS_BEAMS);
        output.accept(ModBlocks.DARK_OAK_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.DARK_OAK_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.DARK_OAK_PLANKS_BRICKS);
        output.accept(ModBlocks.DARK_OAK_PLANKS_CRATE);
        output.accept(ModBlocks.DARK_OAK_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.DARK_OAK_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.DARK_OAK_PLANKS_DOTTED);
        output.accept(ModBlocks.DARK_OAK_PLANKS_FLOORING);
        output.accept(ModBlocks.DARK_OAK_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.DARK_OAK_PLANKS_PANEL);
        output.accept(ModBlocks.DARK_OAK_PLANKS_PATTERN);
        output.accept(ModBlocks.DARK_OAK_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.DARK_OAK_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.DARK_OAK_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.DARK_OAK_PLANKS_SQUARES);
        output.accept(ModBlocks.DARK_OAK_PLANKS_TILES);
        output.accept(ModBlocks.DARK_OAK_PLANKS_WAVY);
        output.accept(ModBlocks.DARK_OAK_PLANKS_WOVEN);
        output.accept(ModBlocks.DARK_OAK_WINDOW_BARS);
        output.accept(ModBlocks.DARK_OAK_WINDOW_BARS_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_COVERED);
        output.accept(ModBlocks.DARK_OAK_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_DIAGONAL);
        output.accept(ModBlocks.DARK_OAK_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_PANES);
        output.accept(ModBlocks.DARK_OAK_WINDOW_PANES_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_ROUNDED);
        output.accept(ModBlocks.DARK_OAK_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SLIM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SWIRLING);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.DARK_OAK_WINDOW_TILES);
        output.accept(ModBlocks.DARK_OAK_WINDOW_TILES_CTM);
        output.accept(ModBlocks.DARK_PRISMARINE_BEAMS);
        output.accept(ModBlocks.DARK_PRISMARINE_BRICK_PAVING);
        output.accept(ModBlocks.DARK_PRISMARINE_BRICKS);
        output.accept(ModBlocks.DARK_PRISMARINE_DOTTED);
        output.accept(ModBlocks.DARK_PRISMARINE_FABRIC);
        output.accept(ModBlocks.DARK_PRISMARINE_LARGE_TILES);
        output.accept(ModBlocks.DARK_PRISMARINE_ROTATED_BRICKS);
        output.accept(ModBlocks.DARK_PRISMARINE_ROWS);
        output.accept(ModBlocks.DARK_PRISMARINE_SQUARES);
        output.accept(ModBlocks.DARK_PRISMARINE_TILES);
        output.accept(ModBlocks.DARK_PRISMARINE_WAVY);
        output.accept(ModBlocks.DARK_PRISMARINE_WOVEN);
                output.accept(ModBlocks.DEAD_ACACIA_LEAVES);
                output.accept(ModBlocks.DEAD_BIRCH_LEAVES);
                output.accept(ModBlocks.DEAD_DARK_OAK_LEAVES);
                output.accept(ModBlocks.DEAD_JUNGLE_LEAVES);
                output.accept(ModBlocks.DEAD_OAK_LEAVES);
                output.accept(ModBlocks.DEAD_SPRUCE_LEAVES);
        output.accept(ModBlocks.DEEPSLATE_CUT_POLISHED);
        output.accept(ModBlocks.DEEPSLATE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.DELICATE_LAPIS_BLOCK);
        output.accept(ModBlocks.DIAMOND_BLOCK);
        output.accept(ModBlocks.DIAMOND_BLOCK_CHISELED);
        output.accept(ModBlocks.DIAMOND_BLOCK_CHISELED_CUBES);
        output.accept(ModBlocks.DIAMOND_BLOCK_CONNECTING);
        output.accept(ModBlocks.DIAMOND_BLOCK_GRID);
        output.accept(ModBlocks.DIAMOND_BLOCK_JEWEL_BLOCK);
        output.accept(ModBlocks.DIAMOND_BLOCK_POLISHED);
        output.accept(ModBlocks.DIAMOND_BLOCK_RHOMBUSES);
        output.accept(ModBlocks.DIAMOND_BLOCK_SHINY_BORDERED);
        output.accept(ModBlocks.DIAMOND_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.DIORITE_BRICK_PATTERN);
        output.accept(ModBlocks.DIORITE_BRICK_PAVING);
        output.accept(ModBlocks.DIORITE_BRICKS);
        output.accept(ModBlocks.DIORITE_CUT_POLISHED);
        output.accept(ModBlocks.DIORITE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.DIORITE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.DIORITE_DOTTED);
        output.accept(ModBlocks.DIORITE_PAVING);
        output.accept(ModBlocks.DIORITE_POLISHED);
        output.accept(ModBlocks.DIORITE_ROTATED_BRICKS);
        output.accept(ModBlocks.DIORITE_SQUARES);
        output.accept(ModBlocks.DIORITE_TILES);
        output.accept(ModBlocks.DIORITE_WAVY);
        output.accept(ModBlocks.DIRT_BLOBS);
        output.accept(ModBlocks.DIRT_BRICKS);
        output.accept(ModBlocks.DIRT_CHUNKS);
        output.accept(ModBlocks.DIRT_CLUMPS);
        output.accept(ModBlocks.DIRT_LARGE_TILES);
        output.accept(ModBlocks.DIRT_SMALL_BRICKS);
        output.accept(ModBlocks.DIRT_SMALL_TILES);
        output.accept(ModBlocks.DIRT_SMOOTH_CLUMPS);
        output.accept(ModBlocks.DIRT_SOIL);
        output.accept(ModBlocks.DIRT_SQUARES);
        output.accept(ModBlocks.DIRT_TILES);
        output.accept(ModBlocks.DIRT_TILLED);
        output.accept(ModBlocks.DRIPSTONE_CUT_POLISHED);
        output.accept(ModBlocks.DRIPSTONE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.EDGED_AMETHYST_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_ANCIENT_DEBRIS_BRICKS);
        output.accept(ModBlocks.EDGED_ANDESITE_BRICKS);
        output.accept(ModBlocks.EDGED_BASALT_BRICKS);
        output.accept(ModBlocks.EDGED_BLACKSTONE_BRICKS);
        output.accept(ModBlocks.EDGED_BLUE_ICE_BRICKS);
        output.accept(ModBlocks.EDGED_BORDERLESS_BRICKS_BRICKS);
        output.accept(ModBlocks.EDGED_BRICKS_BRICKS);
        output.accept(ModBlocks.EDGED_CALCITE_BRICKS);
        output.accept(ModBlocks.EDGED_CLAY_BRICKS);
        output.accept(ModBlocks.EDGED_COAL_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_COBBLESTONE_BRICKS);
        output.accept(ModBlocks.EDGED_CRYING_OBSIDIAN_BRICKS);
        output.accept(ModBlocks.EDGED_DARK_PRISMARINE_BRICKS);
        output.accept(ModBlocks.EDGED_DEEPSLATE_BRICKS);
        output.accept(ModBlocks.EDGED_DIORITE_BRICKS);
        output.accept(ModBlocks.EDGED_DIRT_BRICKS);
        output.accept(ModBlocks.EDGED_DRIPSTONE_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_END_STONE_BRICKS);
        output.accept(ModBlocks.EDGED_GILDED_BLACKSTONE_BRICKS);
        output.accept(ModBlocks.EDGED_ICE_BRICKS);
        output.accept(ModBlocks.EDGED_LAPIS_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_LODESTONE_BRICKS);
        output.accept(ModBlocks.EDGED_MAGMA_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_MOSSY_COBBLESTONE_BRICKS);
        output.accept(ModBlocks.EDGED_MOSSY_STONE_BRICKS_BRICKS);
        output.accept(ModBlocks.EDGED_MUD);
        output.accept(ModBlocks.EDGED_MUD_BRICKS_BRICKS);
        output.accept(ModBlocks.EDGED_NETHER_BRICKS_BRICKS);
        output.accept(ModBlocks.EDGED_NETHERRACK_BRICKS);
        output.accept(ModBlocks.EDGED_OBSIDIAN_BRICKS);
        output.accept(ModBlocks.EDGED_PACKED_ICE_BRICKS);
        output.accept(ModBlocks.EDGED_PACKED_MUD_BRICKS);
        output.accept(ModBlocks.EDGED_PRISMARINE_BRICKS);
        output.accept(ModBlocks.EDGED_PURPUR_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_QUARTZ_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_RAW_COPPER_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_RAW_GOLD_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_RAW_IRON_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_RED_NETHER_BRICKS_BRICKS);
        output.accept(ModBlocks.EDGED_RED_SANDSTONE_BRICKS);
        output.accept(ModBlocks.EDGED_REDSTONE_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_SANDSTONE_BRICKS);
        output.accept(ModBlocks.EDGED_SMOOTH_STONE_BRICKS);
        output.accept(ModBlocks.EDGED_SNOW_BLOCK_BRICKS);
        output.accept(ModBlocks.EDGED_TUFF_BRICKS);
        output.accept(ModBlocks.EMERALD_BLOCK_BORDERED_CROSSES);
        output.accept(ModBlocks.EMERALD_BLOCK_BORDERED_PLATING);
        output.accept(ModBlocks.EMERALD_BLOCK_CHISELED);
        output.accept(ModBlocks.EMERALD_BLOCK_CLOVERS);
        output.accept(ModBlocks.EMERALD_BLOCK_CRYSTAL);
                output.accept(ModBlocks.EMERALD_BLOCK_CTM);
        output.accept(ModBlocks.EMERALD_BLOCK_PATTERNED);
        output.accept(ModBlocks.EMERALD_BLOCK_PATTERNED_SQUARES);
        output.accept(ModBlocks.EMERALD_BLOCK_POLISHED);
        output.accept(ModBlocks.EMERALD_BLOCK_STRIPED);
        output.accept(ModBlocks.EMERALD_BLOCK_WAXED);
        output.accept(ModBlocks.ENCLOSED_ACACIA_PLANKS);
        output.accept(ModBlocks.ENCLOSED_BAMBOO_PLANKS);
        output.accept(ModBlocks.ENCLOSED_BIRCH_PLANKS);
        output.accept(ModBlocks.ENCLOSED_OAK_PLANKS);
        output.accept(ModBlocks.END_STONE_BLOBS);
        output.accept(ModBlocks.END_STONE_BRICK_PATTERN);
        output.accept(ModBlocks.END_STONE_BRICK_PAVING);
        output.accept(ModBlocks.END_STONE_CHISELED);
        output.accept(ModBlocks.END_STONE_CRUSHED);
        output.accept(ModBlocks.END_STONE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.END_STONE_MESH);
        output.accept(ModBlocks.END_STONE_PAVING);
        output.accept(ModBlocks.END_STONE_POLISHED);
        output.accept(ModBlocks.END_STONE_ROTATED_BRICKS);
        output.accept(ModBlocks.END_STONE_SCALES);
        output.accept(ModBlocks.END_STONE_SMALL_TILES);
        output.accept(ModBlocks.END_STONE_SPIRAL_PATTERN);
        output.accept(ModBlocks.END_STONE_SQUARES);
        output.accept(ModBlocks.END_STONE_TILES);
        output.accept(ModBlocks.FANCY_BLACK_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_BLACK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_BLACK_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_BLUE_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_BLUE_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_BROWN_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_BROWN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_BROWN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_CYAN_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_CYAN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_CYAN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_GRAY_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_GRAY_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_GREEN_STAINED_GLASS);
        output.accept(ModBlocks.FANCY_GREEN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_GREEN_STAINED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_LEADED_GLASS);
        output.accept(ModBlocks.FANCY_LEADED_GLASS_CTM);
        output.accept(ModBlocks.FANCY_LEADED_GLASS_CTM_PANE);
        output.accept(ModBlocks.FANCY_LEADED_GLASS_PANE);
        output.accept(ModBlocks.FANCY_MUD_BRICKS_CTM);
        output.accept(ModBlocks.FANCY_MUD_CTM);
        output.accept(ModBlocks.FANCY_PACKED_MUD_CTM);
        output.accept(ModBlocks.FINE_AMETHYST_BLOCK_CTM);
        output.accept(ModBlocks.FINE_ANCIENT_DEBRIS_CTM);
        output.accept(ModBlocks.FINE_ANDESITE_CTM);
        output.accept(ModBlocks.FINE_BASALT_CTM);
        output.accept(ModBlocks.FINE_BLACKSTONE_CTM);
        output.accept(ModBlocks.FINE_BLUE_ICE_CTM);
        output.accept(ModBlocks.FINE_BORDERLESS_BRICKS_CTM);
        output.accept(ModBlocks.FINE_BRICKS_CTM);
        output.accept(ModBlocks.FINE_CALCITE_CTM);
        output.accept(ModBlocks.FINE_CLAY_CTM);
        output.accept(ModBlocks.FINE_COAL_BLOCK_CTM);
        output.accept(ModBlocks.FINE_COBBLESTONE_CTM);
        output.accept(ModBlocks.FINE_CRYING_OBSIDIAN_CTM);
        output.accept(ModBlocks.FINE_DARK_PRISMARINE_CTM);
        output.accept(ModBlocks.FINE_DEEPSLATE_CTM);
        output.accept(ModBlocks.FINE_DIORITE_CTM);
        output.accept(ModBlocks.FINE_DIRT_CTM);
        output.accept(ModBlocks.FINE_DRIPSTONE_BLOCK_CTM);
        output.accept(ModBlocks.FINE_END_STONE_CTM);
        output.accept(ModBlocks.FINE_GILDED_BLACKSTONE_CTM);
        output.accept(ModBlocks.FINE_ICE_CTM);
        output.accept(ModBlocks.FINE_LAPIS_BLOCK_CTM);
        output.accept(ModBlocks.FINE_LODESTONE_CTM);
        output.accept(ModBlocks.FINE_MAGMA_BLOCK_CTM);
        output.accept(ModBlocks.FINE_MOSSY_COBBLESTONE_CTM);
        output.accept(ModBlocks.FINE_MOSSY_STONE_BRICKS_CTM);
        output.accept(ModBlocks.FINE_MUD_BRICKS_CTM);
        output.accept(ModBlocks.FINE_MUD_CTM);
        output.accept(ModBlocks.FINE_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.FINE_NETHERRACK_CTM);
        output.accept(ModBlocks.FINE_OBSIDIAN_CTM);
        output.accept(ModBlocks.FINE_PACKED_ICE_CTM);
        output.accept(ModBlocks.FINE_PACKED_MUD_CTM);
        output.accept(ModBlocks.FINE_PRISMARINE_CTM);
        output.accept(ModBlocks.FINE_PURPUR_BLOCK_CTM);
        output.accept(ModBlocks.FINE_QUARTZ_BLOCK_CTM);
        output.accept(ModBlocks.FINE_RAW_COPPER_BLOCK_CTM);
        output.accept(ModBlocks.FINE_RAW_GOLD_BLOCK_CTM);
        output.accept(ModBlocks.FINE_RAW_IRON_BLOCK_CTM);
        output.accept(ModBlocks.FINE_RED_NETHER_BRICKS_CTM);
        output.accept(ModBlocks.FINE_RED_SANDSTONE_CTM);
        output.accept(ModBlocks.FINE_REDSTONE_BLOCK_CTM);
        output.accept(ModBlocks.FINE_SANDSTONE_CTM);
        output.accept(ModBlocks.FINE_SMOOTH_STONE_CTM);
        output.accept(ModBlocks.FINE_SNOW_BLOCK_CTM);
        output.accept(ModBlocks.FINE_TUFF_CTM);
        output.accept(ModBlocks.FRAMED_ACACIA_PLANKS);
        output.accept(ModBlocks.FRAMED_BAMBOO_PLANKS);
        output.accept(ModBlocks.FRAMED_BIRCH_PLANKS);
        output.accept(ModBlocks.FRAMED_OAK_PLANKS);
                output.accept(ModBlocks.FROSTED_ACACIA_LEAVES);
                output.accept(ModBlocks.FROSTED_BIRCH_LEAVES);
                output.accept(ModBlocks.FROSTED_DARK_OAK_LEAVES);
                output.accept(ModBlocks.FROSTED_JUNGLE_LEAVES);
                output.accept(ModBlocks.FROSTED_OAK_LEAVES);
                output.accept(ModBlocks.FROSTED_SPRUCE_LEAVES);
        output.accept(ModBlocks.GLOWSTONE_BRICK_PATTERN);
        output.accept(ModBlocks.GLOWSTONE_BRICK_PAVING);
        output.accept(ModBlocks.GLOWSTONE_BRICKS);
        output.accept(ModBlocks.GLOWSTONE_CRUSHED);
        output.accept(ModBlocks.GLOWSTONE_LARGE_TILES);
        output.accept(ModBlocks.GLOWSTONE_ROTATED_BRICKS);
        output.accept(ModBlocks.GLOWSTONE_SMALL_TILES);
        output.accept(ModBlocks.GLOWSTONE_SMOOTH);
        output.accept(ModBlocks.GLOWSTONE_TILES);
        output.accept(ModBlocks.GOLD_BLOCK);
        output.accept(ModBlocks.GOLD_BLOCK_BEAMS);
        output.accept(ModBlocks.GOLD_BLOCK_BORDERED);
        output.accept(ModBlocks.GOLD_BLOCK_LINES);
        output.accept(ModBlocks.GOLD_BLOCK_PATTERN);
        output.accept(ModBlocks.GOLD_BLOCK_POLISHED);
        output.accept(ModBlocks.GOLD_BLOCK_SCALES);
        output.accept(ModBlocks.GOLD_BLOCK_SMALL_BRICKS);
        output.accept(ModBlocks.GOLD_BLOCK_SMALL_TILES);
        output.accept(ModBlocks.GOLD_BLOCK_STRIPED);
        output.accept(ModBlocks.GOLD_BLOCK_TILES);
                output.accept(ModBlocks.GOLDEN_ACACIA_LEAVES);
                output.accept(ModBlocks.GOLDEN_APPLE_ACACIA_LEAVES);
                output.accept(ModBlocks.GOLDEN_APPLE_BIRCH_LEAVES);
                output.accept(ModBlocks.GOLDEN_APPLE_DARK_OAK_LEAVES);
                // ===== RECOVERED WAVE1 =====
        output.accept(ModBlocks.ACACIA_PLANKS_BEAMS);
        output.accept(ModBlocks.ACACIA_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.ACACIA_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.ACACIA_PLANKS_BRICKS);
        output.accept(ModBlocks.ACACIA_PLANKS_CRATE);
        output.accept(ModBlocks.ACACIA_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.ACACIA_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.ACACIA_PLANKS_DOTTED);
        output.accept(ModBlocks.ACACIA_PLANKS_FLOORING);
        output.accept(ModBlocks.ACACIA_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.ACACIA_PLANKS_PANEL);
        output.accept(ModBlocks.ACACIA_PLANKS_PATTERN);
        output.accept(ModBlocks.ACACIA_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.ACACIA_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.ACACIA_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.ACACIA_PLANKS_SQUARES);
        output.accept(ModBlocks.ACACIA_PLANKS_TILES);
        output.accept(ModBlocks.ACACIA_PLANKS_WAVY);
        output.accept(ModBlocks.ACACIA_PLANKS_WOVEN);
        output.accept(ModBlocks.ACACIA_WINDOW_BARS_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_COVERED);
        output.accept(ModBlocks.ACACIA_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_DIAGONAL);
        output.accept(ModBlocks.ACACIA_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_LARGE);
        output.accept(ModBlocks.ACACIA_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_PANES);
        output.accept(ModBlocks.ACACIA_WINDOW_PANES_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_ROUNDED);
        output.accept(ModBlocks.ACACIA_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_SLIM);
        output.accept(ModBlocks.ACACIA_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_SWIRLING);
        output.accept(ModBlocks.ACACIA_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.ACACIA_WINDOW_TILES);
        output.accept(ModBlocks.ACACIA_WINDOW_TILES_CTM);
        output.accept(ModBlocks.AMETHYST_BLOCK_BEAMS);
        output.accept(ModBlocks.AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES);
        output.accept(ModBlocks.AMETHYST_BLOCK_BRICKS);
        output.accept(ModBlocks.AMETHYST_BLOCK_CTM);
        output.accept(ModBlocks.AMETHYST_BLOCK_CUT);
        output.accept(ModBlocks.AMETHYST_BLOCK_EDGED);
        output.accept(ModBlocks.AMETHYST_BLOCK_POLISHED);
        output.accept(ModBlocks.AMETHYST_BLOCK_SHINY);
        output.accept(ModBlocks.AMETHYST_BLOCK_TILES);
        output.accept(ModBlocks.ANDESITE_BRICK_PATTERN);
        output.accept(ModBlocks.ANDESITE_BRICK_PAVING);
        output.accept(ModBlocks.ANDESITE_BRICKS);
        output.accept(ModBlocks.ANDESITE_CUT_POLISHED);
        output.accept(ModBlocks.ANDESITE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.ANDESITE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.ANDESITE_DOTTED);
        output.accept(ModBlocks.ANDESITE_PAVING);
        output.accept(ModBlocks.ANDESITE_POLISHED);
        output.accept(ModBlocks.ANDESITE_ROTATED_BRICKS);
        output.accept(ModBlocks.ANDESITE_SQUARES);
        output.accept(ModBlocks.ANDESITE_TILES);
        output.accept(ModBlocks.ANDESITE_WAVY);
                output.accept(ModBlocks.APPLE_ACACIA_LEAVES);
                output.accept(ModBlocks.APPLE_BIRCH_LEAVES);
                output.accept(ModBlocks.APPLE_DARK_OAK_LEAVES);
                output.accept(ModBlocks.APPLE_JUNGLE_LEAVES);
                output.accept(ModBlocks.APPLE_OAK_LEAVES);
                output.accept(ModBlocks.APPLE_SPRUCE_LEAVES);
        output.accept(ModBlocks.ARCHED_BLACK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_BLACK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_BROWN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_BROWN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_CYAN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_CYAN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_GREEN_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_GREEN_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_LEADED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_LEADED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_LIME_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_LIME_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_MAGENTA_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_MAGENTA_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_ORANGE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_ORANGE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_PINK_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_PINK_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_PURPLE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_PURPLE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_RED_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_RED_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_WHITE_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_WHITE_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ARCHED_YELLOW_STAINED_GLASS_CTM);
        output.accept(ModBlocks.ARCHED_YELLOW_STAINED_GLASS_CTM_PANE);
        output.accept(ModBlocks.ASURINE_CUT_POLISHED);
        output.accept(ModBlocks.ASURINE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.BAMBOO_PLANKS_BEAMS);
        output.accept(ModBlocks.BAMBOO_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.BAMBOO_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.BAMBOO_PLANKS_BRICKS);
        output.accept(ModBlocks.BAMBOO_PLANKS_CRATE);
        output.accept(ModBlocks.BAMBOO_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.BAMBOO_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.BAMBOO_PLANKS_DOTTED);
        output.accept(ModBlocks.BAMBOO_PLANKS_FLOORING);
        output.accept(ModBlocks.BAMBOO_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.BAMBOO_PLANKS_PANEL);
        output.accept(ModBlocks.BAMBOO_PLANKS_PATTERN);
        output.accept(ModBlocks.BAMBOO_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.BAMBOO_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.BAMBOO_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.BAMBOO_PLANKS_SQUARES);
        output.accept(ModBlocks.BAMBOO_PLANKS_TILES);
        output.accept(ModBlocks.BAMBOO_PLANKS_WAVY);
        output.accept(ModBlocks.BAMBOO_PLANKS_WOVEN);
        output.accept(ModBlocks.BASALT_BEAMS);
        output.accept(ModBlocks.BASALT_BORDERED);
        output.accept(ModBlocks.BASALT_BORDERED_POLISHED);
        output.accept(ModBlocks.BASALT_BRICKS);
        output.accept(ModBlocks.BASALT_DIAGONAL_TILES);
        output.accept(ModBlocks.BASALT_PATTERN);
        output.accept(ModBlocks.BASALT_PATTERNED);
        output.accept(ModBlocks.BASALT_TILES);
        output.accept(ModBlocks.BIRCH_PLANKS_BEAMS);
        output.accept(ModBlocks.BIRCH_PLANKS_BRICK_PATTERN);
        output.accept(ModBlocks.BIRCH_PLANKS_BRICK_PAVING);
        output.accept(ModBlocks.BIRCH_PLANKS_BRICKS);
        output.accept(ModBlocks.BIRCH_PLANKS_CRATE);
        output.accept(ModBlocks.BIRCH_PLANKS_DIAGONAL_STRIPES);
        output.accept(ModBlocks.BIRCH_PLANKS_DIAGONAL_TILES);
        output.accept(ModBlocks.BIRCH_PLANKS_DOTTED);
        output.accept(ModBlocks.BIRCH_PLANKS_FLOORING);
        output.accept(ModBlocks.BIRCH_PLANKS_LARGE_TILES);
        output.accept(ModBlocks.BIRCH_PLANKS_PANEL);
        output.accept(ModBlocks.BIRCH_PLANKS_PATTERN);
        output.accept(ModBlocks.BIRCH_PLANKS_ROTATED_BRICKS);
        output.accept(ModBlocks.BIRCH_PLANKS_SMALL_BRICKS);
        output.accept(ModBlocks.BIRCH_PLANKS_SMALL_TILES);
        output.accept(ModBlocks.BIRCH_PLANKS_SQUARES);
        output.accept(ModBlocks.BIRCH_PLANKS_TILES);
        output.accept(ModBlocks.BIRCH_PLANKS_WAVY);
        output.accept(ModBlocks.BIRCH_PLANKS_WOVEN);
        output.accept(ModBlocks.BIRCH_WINDOW_BARS);
        output.accept(ModBlocks.BIRCH_WINDOW_BARS_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_COVERED_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_DIAGONAL);
        output.accept(ModBlocks.BIRCH_WINDOW_DIAGONAL_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_LARGE);
        output.accept(ModBlocks.BIRCH_WINDOW_LARGE_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_PANES);
        output.accept(ModBlocks.BIRCH_WINDOW_PANES_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_ROUNDED);
        output.accept(ModBlocks.BIRCH_WINDOW_ROUNDED_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_SLIM);
        output.accept(ModBlocks.BIRCH_WINDOW_SLIM_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_SWIRLING);
        output.accept(ModBlocks.BIRCH_WINDOW_SWIRLING_CTM);
        output.accept(ModBlocks.BIRCH_WINDOW_TILES);
        output.accept(ModBlocks.BIRCH_WINDOW_TILES_CTM);
        output.accept(ModBlocks.BLACK_CONCRETE_CTM);
        output.accept(ModBlocks.BLACK_CONCRETE_PANEL);
        output.accept(ModBlocks.BLACK_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.BLACK_TERRACOTTA_CTM);
        output.accept(ModBlocks.BLACKSTONE_BRICK_PATTERN);
        output.accept(ModBlocks.BLACKSTONE_BRICK_PAVING);
        output.accept(ModBlocks.BLACKSTONE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.BLACKSTONE_POLISHED);
        output.accept(ModBlocks.BLACKSTONE_ROTATED_BRICKS);
        output.accept(ModBlocks.BLACKSTONE_TILES);
        output.accept(ModBlocks.BLUE_CONCRETE_CTM);
        output.accept(ModBlocks.BLUE_CONCRETE_PANEL);
        output.accept(ModBlocks.BLUE_ICE_BORDERED);
        output.accept(ModBlocks.BLUE_ICE_BRICKS);
        output.accept(ModBlocks.BLUE_ICE_CHISELED);
        output.accept(ModBlocks.BLUE_ICE_CTM);
        output.accept(ModBlocks.BLUE_ICE_PATTERNED);
        output.accept(ModBlocks.BLUE_ICE_SLANTED_TILES);
        output.accept(ModBlocks.BLUE_ICE_TILES);
        output.accept(ModBlocks.BLUE_TERRACOTTA_COLUMN);
        output.accept(ModBlocks.BLUE_TERRACOTTA_CTM);
        output.accept(ModBlocks.BONE_BLOCK_BORDERED);
        output.accept(ModBlocks.BONE_BLOCK_CHISELED);
        output.accept(ModBlocks.BONE_BLOCK_CONNECTING);
        output.accept(ModBlocks.BONE_BLOCK_DECORATED_BORDERED);
        output.accept(ModBlocks.BONE_BLOCK_INVERTED_TILES);
        output.accept(ModBlocks.BONE_BLOCK_PATTERNED);
        output.accept(ModBlocks.BORDERED_AMETHYST_BLOCK);
        output.accept(ModBlocks.BORDERED_ANCIENT_DEBRIS);
        output.accept(ModBlocks.BORDERED_BASALT);
        output.accept(ModBlocks.BORDERED_BLACKSTONE);
        output.accept(ModBlocks.BORDERED_BLUE_ICE);
                // ===== RECOVERED GRANITE =====
        output.accept(ModBlocks.BORDERED_GRANITE);
        output.accept(ModBlocks.BRICK_BORDERED_GRANITE);
        output.accept(ModBlocks.CURLY_GRANITE_CTM);
        output.accept(ModBlocks.CUT_GRANITE_COLUMN);
        output.accept(ModBlocks.EDGED_GRANITE_BRICKS);
        output.accept(ModBlocks.FINE_GRANITE_CTM);
        output.accept(ModBlocks.GRANITE_BRICK_PATTERN);
        output.accept(ModBlocks.GRANITE_BRICK_PAVING);
        output.accept(ModBlocks.GRANITE_BRICKS);
        output.accept(ModBlocks.GRANITE_CUT_POLISHED);
        output.accept(ModBlocks.GRANITE_CUT_SMALL_BRICK);
        output.accept(ModBlocks.GRANITE_DIAGONAL_BRICKS);
        output.accept(ModBlocks.GRANITE_DOTTED);
        output.accept(ModBlocks.GRANITE_PAVING);
        output.accept(ModBlocks.GRANITE_POLISHED);
        output.accept(ModBlocks.GRANITE_PRISMARINE);
        output.accept(ModBlocks.GRANITE_ROTATED_BRICKS);
        output.accept(ModBlocks.GRANITE_SQUARES);
        output.accept(ModBlocks.GRANITE_TILES);
        output.accept(ModBlocks.GRANITE_WAVY);
        output.accept(ModBlocks.MASSIVE_GRANITE_BRICKS);
        output.accept(ModBlocks.ORNATE_GRANITE_CTM);
        output.accept(ModBlocks.OVERLAPPING_GRANITE_TILES);
        output.accept(ModBlocks.SIMPLE_GRANITE_CTM);
        output.accept(ModBlocks.SMOOTH_GRANITE_COLUMN);
        output.accept(ModBlocks.THICK_INLAYED_GRANITE);
        output.accept(ModBlocks.TILED_BORDERED_GRANITE);
        output.accept(ModBlocks.TILED_GRANITE_COLUMN);
        output.accept(ModBlocks.TINY_BRICK_BORDERED_GRANITE);
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
        // ===== RECOVERED WINDOWS =====
        output.accept(ModBlocks.ACACIA_WINDOW_BARS);
        output.accept(ModBlocks.ACACIA_WINDOW_BARS_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_PANES_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.ACACIA_WINDOW_TILES_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_BARS_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_COVERED);
        output.accept(ModBlocks.BIRCH_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_PANES_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.BIRCH_WINDOW_TILES_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_BARS_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_DIAGONAL);
        output.accept(ModBlocks.CRIMSON_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_PANES_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.CRIMSON_WINDOW_TILES_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_BARS_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_LARGE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_PANES_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.DARK_OAK_WINDOW_TILES_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_BARS_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_PANES_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_SLIM);
        output.accept(ModBlocks.JUNGLE_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.JUNGLE_WINDOW_TILES_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_BARS_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_PANES_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_ROUNDED);
        output.accept(ModBlocks.MANGROVE_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.MANGROVE_WINDOW_TILES_PANE);
        output.accept(ModBlocks.OAK_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_BARS_PANE);
        output.accept(ModBlocks.OAK_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.OAK_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.OAK_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.OAK_WINDOW_PANES);
        output.accept(ModBlocks.OAK_WINDOW_PANES_PANE);
        output.accept(ModBlocks.OAK_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.OAK_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_SWIRLING_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.OAK_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.OAK_WINDOW_TILES_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_BARS_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_PANES_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.SPRUCE_WINDOW_TILES_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_BARS_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_BARS_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_COVERED_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_COVERED_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_DIAGONAL_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_DIAGONAL_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_LARGE_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_LARGE_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_PANES_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_PANES_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_ROUNDED_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_ROUNDED_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_SLIM_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_SLIM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_SWIRLING);
        output.accept(ModBlocks.WARPED_WINDOW_SWIRLING_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_TILES_CTM_PANE);
        output.accept(ModBlocks.WARPED_WINDOW_TILES_PANE);
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