package com.otterly76.ott.client.gui.creative;

import com.otterly76.ott.block.ModBlocks;
import com.otterly76.ott_blocks.block.OttBlocks;
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
                    output.accept(set.concrete());
                    output.accept(set.concretePowder());
                    output.accept(set.terracotta());
                    output.accept(set.glazedTerracotta());
                    output.accept(set.wool());
                    output.accept(set.carpet());
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
            () -> OttBlocks.WATER_MOSAIC_TRADITIONAL.get().asItem(),
            (params, output) -> {
                output.accept(OttBlocks.WATER_MOSAIC_BORDER);
                output.accept(OttBlocks.WATER_MOSAIC_GEOMETRIC);
                output.accept(OttBlocks.WATER_MOSAIC_PATTERN);
                output.accept(OttBlocks.WATER_MOSAIC_DELICATE);
                output.accept(OttBlocks.EARTH_MOSAIC_BORDER);
                output.accept(OttBlocks.EARTH_MOSAIC_GEOMETRIC);
                output.accept(OttBlocks.EARTH_MOSAIC_PATTERN);
                output.accept(OttBlocks.EARTH_MOSAIC_DELICATE);
                output.accept(OttBlocks.FIRE_MOSAIC_BORDER);
                output.accept(OttBlocks.FIRE_MOSAIC_GEOMETRIC);
                output.accept(OttBlocks.FIRE_MOSAIC_PATTERN);
                output.accept(OttBlocks.FIRE_MOSAIC_DELICATE);
                output.accept(OttBlocks.SPIRIT_MOSAIC_BORDER);
                output.accept(OttBlocks.SPIRIT_MOSAIC_GEOMETRIC);
                output.accept(OttBlocks.SPIRIT_MOSAIC_PATTERN);
                output.accept(OttBlocks.SPIRIT_MOSAIC_DELICATE);
                output.accept(OttBlocks.AIR_MOSAIC_BORDER);
                output.accept(OttBlocks.AIR_MOSAIC_GEOMETRIC);
                output.accept(OttBlocks.AIR_MOSAIC_PATTERN);
                output.accept(OttBlocks.AIR_MOSAIC_DELICATE);

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
                mosaicEmit.accept(OttBlocks.WATER_MOSAIC_TRADITIONAL,  "water_mosaic_traditional");
                mosaicEmit.accept(OttBlocks.EARTH_MOSAIC_TRADITIONAL,  "earth_mosaic_traditional");
                mosaicEmit.accept(OttBlocks.FIRE_MOSAIC_TRADITIONAL,   "fire_mosaic_traditional");
                mosaicEmit.accept(OttBlocks.SPIRIT_MOSAIC_TRADITIONAL, "spirit_mosaic_traditional");
                mosaicEmit.accept(OttBlocks.AIR_MOSAIC_TRADITIONAL,    "air_mosaic_traditional");

                output.accept(OttBlocks.MOSAIC_FLOOR);
                output.accept(OttBlocks.MOSAIC_FLOOR_DELICATE);
                output.accept(OttBlocks.MOSAIC_FLOOR_ROSETTE);
                output.accept(OttBlocks.ROMAN_FRESCO_RED);
                output.accept(OttBlocks.ROMAN_FRESCO_BLACK);

                output.accept(OttBlocks.LIMESTONE_MASONRY);
                output.accept(ModBlocks.LIMESTONE_MASONRY_EDGE);
                output.accept(ModBlocks.LIMESTONE_MASONRY_PLATE);

                output.accept(OttBlocks.STONE_BRICKS_MASONRY);
                output.accept(ModBlocks.STONE_BRICKS_MASONRY_EDGE);
                output.accept(ModBlocks.STONE_BRICKS_MASONRY_PLATE);
                // (Decorative wool family moved to the ENGRAVED tab — they're engraving-system blocks.)
            }),

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

    STONE_CUSTOM("stone_custom",
            () -> OttBlocks.PLAIN_LIMESTONE.get().asItem(),
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

                output.accept(OttBlocks.PLAIN_LIMESTONE);      emit.accept("limestone");
                output.accept(OttBlocks.COBBLED_LIMESTONE);    emit.accept("cobbled_limestone");
                output.accept(OttBlocks.REFINED_GLOWSTONE);    emit.accept("refined_glowstone");
                output.accept(OttBlocks.ROOFING_SLATES);       emit.accept("roofing_slates");

                output.accept(OttBlocks.BLACK_MARBLE);                emit.accept("black_marble");
                output.accept(OttBlocks.BLACK_MARBLE_BRICKS);         emit.accept("black_marble_bricks");
                output.accept(OttBlocks.BLACK_MARBLE_SMALL_BRICKS);   emit.accept("black_marble_small_bricks");
                output.accept(OttBlocks.BLACK_MARBLE_TILES);          emit.accept("black_marble_tiles");
                output.accept(OttBlocks.BLACK_POLISHED_MARBLE);       emit.accept("black_polished_marble");
                output.accept(OttBlocks.BLACK_MARBLE_PILLAR);
                output.accept(OttBlocks.BLACK_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.BLACK_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.BLACK_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.BLACK_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.WHITE_MARBLE);                emit.accept("white_marble");
                output.accept(OttBlocks.WHITE_MARBLE_BRICKS);         emit.accept("white_marble_bricks");
                output.accept(OttBlocks.WHITE_MARBLE_SMALL_BRICKS);   emit.accept("white_marble_small_bricks");
                output.accept(OttBlocks.WHITE_MARBLE_TILES);          emit.accept("white_marble_tiles");
                output.accept(OttBlocks.WHITE_POLISHED_MARBLE);       emit.accept("white_polished_marble");
                output.accept(OttBlocks.WHITE_MARBLE_PILLAR);
                output.accept(OttBlocks.WHITE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.WHITE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.WHITE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.WHITE_MARBLE_DIAMOND_PAVERS);


                output.accept(OttBlocks.BLUE_MARBLE);                emit.accept("blue_marble");
                output.accept(OttBlocks.BLUE_MARBLE_BRICKS);         emit.accept("blue_marble_bricks");
                output.accept(OttBlocks.BLUE_MARBLE_SMALL_BRICKS);   emit.accept("blue_marble_small_bricks");
                output.accept(OttBlocks.BLUE_MARBLE_TILES);          emit.accept("blue_marble_tiles");
                output.accept(OttBlocks.BLUE_POLISHED_MARBLE);       emit.accept("blue_polished_marble");
                output.accept(OttBlocks.BLUE_MARBLE_PILLAR);
                output.accept(OttBlocks.BLUE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.BLUE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.BLUE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.BLUE_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.CYAN_MARBLE);                emit.accept("cyan_marble");
                output.accept(OttBlocks.CYAN_MARBLE_BRICKS);         emit.accept("cyan_marble_bricks");
                output.accept(OttBlocks.CYAN_MARBLE_SMALL_BRICKS);   emit.accept("cyan_marble_small_bricks");
                output.accept(OttBlocks.CYAN_MARBLE_TILES);          emit.accept("cyan_marble_tiles");
                output.accept(OttBlocks.CYAN_POLISHED_MARBLE);       emit.accept("cyan_polished_marble");
                output.accept(OttBlocks.CYAN_MARBLE_PILLAR);
                output.accept(OttBlocks.CYAN_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.CYAN_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.CYAN_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.CYAN_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.GREEN_MARBLE);                emit.accept("green_marble");
                output.accept(OttBlocks.GREEN_MARBLE_BRICKS);         emit.accept("green_marble_bricks");
                output.accept(OttBlocks.GREEN_MARBLE_SMALL_BRICKS);   emit.accept("green_marble_small_bricks");
                output.accept(OttBlocks.GREEN_MARBLE_TILES);          emit.accept("green_marble_tiles");
                output.accept(OttBlocks.GREEN_POLISHED_MARBLE);       emit.accept("green_polished_marble");
                output.accept(OttBlocks.GREEN_MARBLE_PILLAR);
                output.accept(OttBlocks.GREEN_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.GREEN_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.GREEN_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.GREEN_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.LIME_MARBLE);                emit.accept("lime_marble");
                output.accept(OttBlocks.LIME_MARBLE_BRICKS);         emit.accept("lime_marble_bricks");
                output.accept(OttBlocks.LIME_MARBLE_SMALL_BRICKS);   emit.accept("lime_marble_small_bricks");
                output.accept(OttBlocks.LIME_MARBLE_TILES);          emit.accept("lime_marble_tiles");
                output.accept(OttBlocks.LIME_POLISHED_MARBLE);       emit.accept("lime_polished_marble");
                output.accept(OttBlocks.LIME_MARBLE_PILLAR);
                output.accept(OttBlocks.LIME_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.LIME_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.LIME_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.LIME_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.ORANGE_MARBLE);                emit.accept("orange_marble");
                output.accept(OttBlocks.ORANGE_MARBLE_BRICKS);         emit.accept("orange_marble_bricks");
                output.accept(OttBlocks.ORANGE_MARBLE_SMALL_BRICKS);   emit.accept("orange_marble_small_bricks");
                output.accept(OttBlocks.ORANGE_MARBLE_TILES);          emit.accept("orange_marble_tiles");
                output.accept(OttBlocks.ORANGE_POLISHED_MARBLE);       emit.accept("orange_polished_marble");
                output.accept(OttBlocks.ORANGE_MARBLE_PILLAR);
                output.accept(OttBlocks.ORANGE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.ORANGE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.ORANGE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.ORANGE_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.PINK_MARBLE);                emit.accept("pink_marble");
                output.accept(OttBlocks.PINK_MARBLE_BRICKS);         emit.accept("pink_marble_bricks");
                output.accept(OttBlocks.PINK_MARBLE_SMALL_BRICKS);   emit.accept("pink_marble_small_bricks");
                output.accept(OttBlocks.PINK_MARBLE_TILES);          emit.accept("pink_marble_tiles");
                output.accept(OttBlocks.PINK_POLISHED_MARBLE);       emit.accept("pink_polished_marble");
                output.accept(OttBlocks.PINK_MARBLE_PILLAR);
                output.accept(OttBlocks.PINK_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.PINK_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.PINK_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.PINK_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.PURPLE_MARBLE);                emit.accept("purple_marble");
                output.accept(OttBlocks.PURPLE_MARBLE_BRICKS);         emit.accept("purple_marble_bricks");
                output.accept(OttBlocks.PURPLE_MARBLE_SMALL_BRICKS);   emit.accept("purple_marble_small_bricks");
                output.accept(OttBlocks.PURPLE_MARBLE_TILES);          emit.accept("purple_marble_tiles");
                output.accept(OttBlocks.PURPLE_POLISHED_MARBLE);       emit.accept("purple_polished_marble");
                output.accept(OttBlocks.PURPLE_MARBLE_PILLAR);
                output.accept(OttBlocks.PURPLE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.PURPLE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.PURPLE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.PURPLE_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.RED_MARBLE);                emit.accept("red_marble");
                output.accept(OttBlocks.RED_MARBLE_BRICKS);         emit.accept("red_marble_bricks");
                output.accept(OttBlocks.RED_MARBLE_SMALL_BRICKS);   emit.accept("red_marble_small_bricks");
                output.accept(OttBlocks.RED_MARBLE_TILES);          emit.accept("red_marble_tiles");
                output.accept(OttBlocks.RED_POLISHED_MARBLE);       emit.accept("red_polished_marble");
                output.accept(OttBlocks.RED_MARBLE_PILLAR);
                output.accept(OttBlocks.RED_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.RED_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.RED_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.RED_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.YELLOW_MARBLE);                emit.accept("yellow_marble");
                output.accept(OttBlocks.YELLOW_MARBLE_BRICKS);         emit.accept("yellow_marble_bricks");
                output.accept(OttBlocks.YELLOW_MARBLE_SMALL_BRICKS);   emit.accept("yellow_marble_small_bricks");
                output.accept(OttBlocks.YELLOW_MARBLE_TILES);          emit.accept("yellow_marble_tiles");
                output.accept(OttBlocks.YELLOW_POLISHED_MARBLE);       emit.accept("yellow_polished_marble");
                output.accept(OttBlocks.YELLOW_MARBLE_PILLAR);
                output.accept(OttBlocks.YELLOW_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.YELLOW_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.YELLOW_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.YELLOW_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.LIGHT_GRAY_MARBLE);                emit.accept("light_gray_marble");
                output.accept(OttBlocks.LIGHT_GRAY_MARBLE_BRICKS);         emit.accept("light_gray_marble_bricks");
                output.accept(OttBlocks.LIGHT_GRAY_MARBLE_SMALL_BRICKS);   emit.accept("light_gray_marble_small_bricks");
                output.accept(OttBlocks.LIGHT_GRAY_MARBLE_TILES);          emit.accept("light_gray_marble_tiles");
                output.accept(OttBlocks.LIGHT_GRAY_POLISHED_MARBLE);       emit.accept("light_gray_polished_marble");
                output.accept(OttBlocks.LIGHT_GRAY_MARBLE_PILLAR);
                output.accept(OttBlocks.LIGHT_GRAY_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.LIGHT_GRAY_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.LIGHT_GRAY_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.LIGHT_GRAY_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.GRAY_MARBLE);                emit.accept("gray_marble");
                output.accept(OttBlocks.GRAY_MARBLE_BRICKS);         emit.accept("gray_marble_bricks");
                output.accept(OttBlocks.GRAY_MARBLE_SMALL_BRICKS);   emit.accept("gray_marble_small_bricks");
                output.accept(OttBlocks.GRAY_MARBLE_TILES);          emit.accept("gray_marble_tiles");
                output.accept(OttBlocks.GRAY_POLISHED_MARBLE);       emit.accept("gray_polished_marble");
                output.accept(OttBlocks.GRAY_MARBLE_PILLAR);
                output.accept(OttBlocks.GRAY_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.GRAY_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.GRAY_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.GRAY_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.BROWN_MARBLE);                emit.accept("brown_marble");
                output.accept(OttBlocks.BROWN_MARBLE_BRICKS);         emit.accept("brown_marble_bricks");
                output.accept(OttBlocks.BROWN_MARBLE_SMALL_BRICKS);   emit.accept("brown_marble_small_bricks");
                output.accept(OttBlocks.BROWN_MARBLE_TILES);          emit.accept("brown_marble_tiles");
                output.accept(OttBlocks.BROWN_POLISHED_MARBLE);       emit.accept("brown_polished_marble");
                output.accept(OttBlocks.BROWN_MARBLE_PILLAR);
                output.accept(OttBlocks.BROWN_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.BROWN_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.BROWN_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.BROWN_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.LIGHT_BLUE_MARBLE);                emit.accept("light_blue_marble");
                output.accept(OttBlocks.LIGHT_BLUE_MARBLE_BRICKS);         emit.accept("light_blue_marble_bricks");
                output.accept(OttBlocks.LIGHT_BLUE_MARBLE_SMALL_BRICKS);   emit.accept("light_blue_marble_small_bricks");
                output.accept(OttBlocks.LIGHT_BLUE_MARBLE_TILES);          emit.accept("light_blue_marble_tiles");
                output.accept(OttBlocks.LIGHT_BLUE_POLISHED_MARBLE);       emit.accept("light_blue_polished_marble");
                output.accept(OttBlocks.LIGHT_BLUE_MARBLE_PILLAR);
                output.accept(OttBlocks.LIGHT_BLUE_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.LIGHT_BLUE_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.LIGHT_BLUE_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.LIGHT_BLUE_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.MAGENTA_MARBLE);                emit.accept("magenta_marble");
                output.accept(OttBlocks.MAGENTA_MARBLE_BRICKS);         emit.accept("magenta_marble_bricks");
                output.accept(OttBlocks.MAGENTA_MARBLE_SMALL_BRICKS);   emit.accept("magenta_marble_small_bricks");
                output.accept(OttBlocks.MAGENTA_MARBLE_TILES);          emit.accept("magenta_marble_tiles");
                output.accept(OttBlocks.MAGENTA_POLISHED_MARBLE);       emit.accept("magenta_polished_marble");
                output.accept(OttBlocks.MAGENTA_MARBLE_PILLAR);
                output.accept(OttBlocks.MAGENTA_MARBLE_PILLAR_CAP);
                output.accept(ModBlocks.MAGENTA_MARBLE_FLOOR_TILE);
                output.accept(ModBlocks.MAGENTA_MARBLE_FANCY_FENCE);
                output.accept(ModBlocks.MAGENTA_MARBLE_DIAMOND_PAVERS);

                output.accept(OttBlocks.SANDSTONE_SLENDER_BRICKS);          emit.accept("sandstone_slender_bricks");
                output.accept(OttBlocks.SANDSTONE_SLENDER_TURQUOISE_PATTERN); emit.accept("sandstone_slender_turquoise_pattern");
            }),

    BLOCKS("blocks",
            () -> OttBlocks.MIXED_LIMESTONE_BRICKS.get().asItem(),
            (params, output) -> {
                output.accept(OttBlocks.MIXED_LIMESTONE_BRICKS);
                ModBlocks.SEAGLASS.forEach(output::accept);  // ethereal seaglass only
                ModBlocks.TESTBLOCK.forEach(output::accept);

                output.accept(OttBlocks.PINK_SALT_BLOCK);
                output.accept(OttBlocks.POLISHED_PINK_SALT_BLOCK);

                output.accept(OttBlocks.WHEAT_THATCH);
                output.accept(ModBlocks.WHEAT_THATCH_EDGE);
                output.accept(ModBlocks.WHEAT_THATCH_PLATE);

                output.accept(OttBlocks.BAMBOO_THATCH);
                output.accept(ModBlocks.BAMBOO_THATCH_EDGE);
                output.accept(ModBlocks.BAMBOO_THATCH_PLATE);

                output.accept(OttBlocks.SOUL_GLASS);
                output.accept(OttBlocks.SOUL_GLASS_PANE);
                output.accept(OttBlocks.SOUL_GLASS_CTM);
                output.accept(OttBlocks.SOUL_GLASS_CTM_PANE);

                // Opal crystal sets — raw + decorative blocks grouped per type; loose buds/crystals are in MISC
                ModBlocks.OPAL_SETS.values().forEach(set -> {
                    output.accept(set.base());
                    output.accept(set.crystalBlock());
                    output.accept(set.budding());
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

                output.accept(OttBlocks.CHISELED_PLASTERED_STONE_PILLAR);
            }),

    ENGRAVED("engraved",
            () -> OttBlocks.CHAOTIC_STONE_BRICKS.get().asItem(),
            (params, output) -> {
                // ── Engraving tab — generated from EngravingEntries.tabItems() (single source = the engraving recipes).
                // Each engraving output is followed by its crafted pane/carpet siblings; then orphan panes/carpets;
                // then the wood-window family (grouped cube + pane); then safety sweeps for collections that may
                // include non-engraving members. `placed` dedups everything by item.
                java.util.Set<net.minecraft.world.item.Item> placed = new java.util.HashSet<>();
                java.util.function.Consumer<net.minecraft.world.level.ItemLike> emit = il -> {
                    if (il != null && placed.add(il.asItem())) output.accept(il);
                };
                java.util.function.Consumer<String> emitId = id -> {
                    net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("ott", id);
                    if (net.minecraft.core.registries.BuiltInRegistries.BLOCK.containsKey(rl))
                        emit.accept(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(rl));
                };
                for (net.minecraft.world.level.ItemLike cube : com.otterly76.ott.engraving.EngravingEntries.tabItems()) {
                    String name = net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(cube.asItem()).getPath();
                    if (name.endsWith("_pane") || name.contains("_carpet")) continue; // grouped under its cube below
                    emit.accept(cube);
                    emitId.accept(name + "_pane");
                    if (name.contains("_wool")) emitId.accept(name.replace("_wool", "_carpet"));
                }
                // Orphan engraving-output panes/carpets whose cube was not iterated.
                // When the output IS a pane (e.g. framed glass, whose full block is the engraving
                // INPUT and so never appears in tabItems()), emit the full block first so the pane
                // pairs with its cube instead of floating alone. `placed` dedups.
                for (net.minecraft.world.level.ItemLike x : com.otterly76.ott.engraving.EngravingEntries.tabItems()) {
                    String pn = net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(x.asItem()).getPath();
                    if (pn.endsWith("_pane")) emitId.accept(pn.substring(0, pn.length() - "_pane".length()));
                    emit.accept(x);
                }
                // Wood windows (grouped cube + pane) — wired separately from the engraving system
                String[] windowWoods = {"oak", "acacia", "birch", "jungle", "dark_oak", "spruce", "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak"};
                String[] windowStyles = {"bars", "covered", "diagonal", "large", "panes", "rounded", "slim", "swirling", "tiles"};
                for (String wd : windowWoods) for (String st : windowStyles) for (String suf : new String[]{"", "_ctm"}) {
                    emitId.accept(wd + "_window_" + st + suf);
                    emitId.accept(wd + "_window_" + st + suf + "_pane");
                }
                // Safety: any remaining registered ott pane not yet placed (crafted-only panes with no engraving cube)
                net.minecraft.core.registries.BuiltInRegistries.BLOCK.entrySet().forEach(e -> {
                    net.minecraft.resources.ResourceLocation rl = e.getKey().location();
                    if (rl.getNamespace().equals("ott") && rl.getPath().endsWith("_pane")) emit.accept(e.getValue());
                });
                // Safety sweeps: collections that may include non-engraving members (dedup via `placed`)
                OttBlocks.IMPORTED_WOOL_CARPETS.values().forEach(emit);
                OttBlocks.STYLED_CARPET.values().forEach(emit);
                OttBlocks.DECO_CARPET.values().forEach(emit);
                OttBlocks.WOOD_DOORS.values().forEach(m -> m.values().forEach(emit));
                OttBlocks.EXTRA_DOORS.values().forEach(emit);
                OttBlocks.WOOD_TRAPDOORS.values().forEach(emit);
                OttBlocks.GLASS_DOORS.values().forEach(emit);
                OttBlocks.GLASS_TRAPDOORS.values().forEach(emit);
                OttBlocks.CHAINS.values().forEach(emit);
                ModBlocks.BOOKSHELVES.values().forEach(emit);
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
            }),

    TOOLS("tools",
            () -> ModItems.DIAMOND_SHEARS.get(),
            (params, output) -> {
                // Shears
                output.accept(ModItems.COPPER_SHEARS);
                output.accept(ModItems.EXPOSED_COPPER_SHEARS);
                output.accept(ModItems.WEATHERED_COPPER_SHEARS);
                output.accept(ModItems.OXIDIZED_COPPER_SHEARS);
                output.accept(ModItems.GOLDEN_SHEARS);
                output.accept(ModItems.DIAMOND_SHEARS);
                output.accept(ModItems.NETHERITE_SHEARS);

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
            }),

    /**
     * Completeness net: emits every registered {@code ott} block not already surfaced by another
     * category, so no block is ever missing from the OTT tab. Doubles as a visible audit of what
     * still lacks a curated home. Must be declared last so it can observe everything others emit.
     */
    COVERAGE("coverage",
            () -> Items.CHEST,
            (params, output) -> {
                java.util.Set<Item> placed = new java.util.HashSet<>();
                for (OttCreativeCategories cat : values()) {
                    if (cat.name().equals("COVERAGE")) continue; // skip self (can't reference the constant in its own initializer)
                    cat.populateItems(params, (stack, vis) -> placed.add(stack.getItem()));
                }
                java.util.function.Consumer<Item> sweep = it -> {
                    if (it != Items.AIR && placed.add(it)) output.accept(it);
                };
                OttBlocks.BLOCKS.getEntries().forEach(h -> sweep.accept(h.get().asItem()));
                ModBlocks.BLOCKS.getEntries().forEach(h -> sweep.accept(h.get().asItem()));
            });

    public static final java.util.List<OttCreativeCategories> DISPLAY_ORDER =
            java.util.List.of(MISC, TOOLS, COLORS, DYES, GRADIENTS, WOOD_SETS, VANPLUS,
                    STONE_CUSTOM, STONE_VANILLA,
                    BACKPORT, COPPER_CHAOS, ENGRAVED, MOSAIC, BLOCKS,
                    FLORA, FAUNA, FOOD, JARS, CREATURES, COVERAGE
            );

    @Nullable
    private static OttCreativeCategories selected = MISC;

    public static @Nullable OttCreativeCategories getSelected() {
        return selected;
    }

    public static void setSelected(@Nullable OttCreativeCategories cat) {
        selected = cat;
    }

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

    public void populateItems(@Nullable CreativeModeTab.ItemDisplayParameters params,
                              @NotNull CreativeModeTab.Output output) {
        populator.accept(params, output);
    }
}