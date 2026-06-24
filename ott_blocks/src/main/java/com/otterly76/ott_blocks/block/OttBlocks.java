package com.otterly76.ott_blocks.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import com.otterly76.ott_blocks.util.block.BlockSetTypeVariant;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Block registrar for the {@code ott_blocks} mod. Owns all migrated full-cube decorative blocks,
 * registered under the shared <b>{@code ott}</b> namespace so block IDs/assets/worlds are unchanged.
 *
 * <p>Each {@link #register} also registers a plain {@link net.minecraft.world.item.BlockItem} under the
 * same id, replacing the old per-block {@code ModItems.registerBlockItem} call in {@code ott}.</p>
 */
public class OttBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("ott");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("ott");

    /**
     * Stone-copy property shortcut (mirrors ModBlocks.ST), used by many migrated stone blocks.
     */
    private static final Properties ST = Properties.ofFullCopy(Blocks.STONE);

    static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> b = BLOCKS.register(name, block);
        ITEMS.registerSimpleBlockItem(name, b);
        return b;
    }

    // ===== DOORS & TRAPDOORS (migrated from ott ModBlocks) =====
    /**
     * Per-wood door styles, keyed by wood name, matching exactly the available textures.
     */
    public static final Map<String, List<String>> WOOD_DOOR_STYLES = new LinkedHashMap<>();
    /**
     * Acacia door styles (canonical reference; no {@code barred} variant).
     */
    public static final List<String> DOOR_STYLES = List.of("beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "paper", "pressed", "screen", "secret", "shack", "sliding", "supported", "tile_windowed", "tiled", "windowed");
    public static final Map<String, Map<String, DeferredBlock<DoorBlock>>> WOOD_DOORS = new LinkedHashMap<>();
    /**
     * New-style door blocks not covered by WOOD_DOORS (e.g. oak_bamboo_door, oak_barn_glass_door).
     */
    public static final Map<String, DeferredBlock<DoorBlock>> EXTRA_DOORS = new LinkedHashMap<>();
    /**
     * All custom trapdoor blocks keyed by full block name.
     */
    public static final Map<String, DeferredBlock<TrapDoorBlock>> WOOD_TRAPDOORS = new LinkedHashMap<>();
    /**
     * Full glass-material doors keyed by name ({@code glass_door}, {@code <color>_stained_glass_door}).
     * Translucent, hand-openable via the {@code glass} BlockSetType.
     */
    public static final Map<String, DeferredBlock<DoorBlock>> GLASS_DOORS = new LinkedHashMap<>();
    /** Full glass-material trapdoors keyed by name ({@code glass_trapdoor}, {@code <color>_stained_glass_trapdoor}). */
    public static final Map<String, DeferredBlock<TrapDoorBlock>> GLASS_TRAPDOORS = new LinkedHashMap<>();

    private static DeferredBlock<DoorBlock> registerDoor(String name, net.minecraft.world.level.block.state.properties.BlockSetType bst, Block template) {
        DeferredBlock<DoorBlock> ret = BLOCKS.register(name, () -> new DoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(template)));
        ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    private static DeferredBlock<TrapDoorBlock> registerTrapdoor(String name, net.minecraft.world.level.block.state.properties.BlockSetType bst, Block template) {
        DeferredBlock<TrapDoorBlock> ret = BLOCKS.register(name, () -> new TrapDoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(template)));
        ITEMS.register(name, () -> new net.minecraft.world.item.BlockItem(ret.get(), new net.minecraft.world.item.Item.Properties()));
        return ret;
    }

    static {
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
        WOOD_DOOR_STYLES.put("pale_oak", List.of("barred", "beach", "boarded", "dual_paneled", "fortified", "gated", "glass", "heavy", "modern", "overgrown", "paneled", "pressed", "screen", "secret", "shack", "sliding", "supported", "tiled", "tile_windowed", "windowed"));

        String[] woodDoorNames = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "crimson", "warped", "pale_oak"};
        BlockSetType[] woodBSTs = {BlockSetType.OAK, BlockSetType.SPRUCE, BlockSetType.BIRCH, BlockSetType.JUNGLE, BlockSetType.ACACIA, BlockSetType.DARK_OAK, BlockSetType.MANGROVE, BlockSetType.CHERRY, BlockSetType.BAMBOO, BlockSetType.CRIMSON, BlockSetType.WARPED, BlockSetTypeVariant.PALE_OAK.getBlockSetType()};
        Block[] vanillaDoors = {Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.MANGROVE_DOOR, Blocks.CHERRY_DOOR, Blocks.BAMBOO_DOOR, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR, Blocks.OAK_DOOR};
        for (int i = 0; i < woodDoorNames.length; i++) {
            String wood = woodDoorNames[i];
            BlockSetType bst = woodBSTs[i];
            Block vanillaDoor = vanillaDoors[i];
            List<String> styles = WOOD_DOOR_STYLES.get(wood);
            Map<String, DeferredBlock<DoorBlock>> woodMap = new LinkedHashMap<>();
            WOOD_DOORS.put(wood, woodMap);
            for (String style : styles) {
                woodMap.put(style, register(style + "_" + wood + "_door", () -> new DoorBlock(bst, BlockBehaviour.Properties.ofFullCopy(vanillaDoor))));
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
        EXTRA_DOORS.put("pale_oak_barn_glass_door", registerDoor("pale_oak_barn_glass_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_stable_head_door", registerDoor("pale_oak_stable_head_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));
        EXTRA_DOORS.put("pale_oak_whispering_door", registerDoor("pale_oak_whispering_door", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_DOOR));

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
        WOOD_TRAPDOORS.put("pale_oak_airy_trapdoor", registerTrapdoor("pale_oak_airy_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_barrel_trapdoor", registerTrapdoor("pale_oak_barrel_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_whispering_trapdoor", registerTrapdoor("pale_oak_whispering_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_checkered_trapdoor", registerTrapdoor("pale_oak_checkered_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_classic_windowed_trapdoor", registerTrapdoor("pale_oak_classic_windowed_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_cobweb_trapdoor", registerTrapdoor("pale_oak_cobweb_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_distorted_trapdoor", registerTrapdoor("pale_oak_distorted_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_fancy_trapdoor", registerTrapdoor("pale_oak_fancy_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_golden_barred_trapdoor", registerTrapdoor("pale_oak_golden_barred_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_heavy_trapdoor", registerTrapdoor("pale_oak_heavy_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_iron_barred_trapdoor", registerTrapdoor("pale_oak_iron_barred_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_leafy_trapdoor", registerTrapdoor("pale_oak_leafy_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_meshed_trapdoor", registerTrapdoor("pale_oak_meshed_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_overgrown_trapdoor", registerTrapdoor("pale_oak_overgrown_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_pointless_trapdoor", registerTrapdoor("pale_oak_pointless_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_slotted_trapdoor", registerTrapdoor("pale_oak_slotted_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_solid_trapdoor", registerTrapdoor("pale_oak_solid_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_suspicious_trapdoor", registerTrapdoor("pale_oak_suspicious_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_twisted_trapdoor", registerTrapdoor("pale_oak_twisted_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_vined_trapdoor", registerTrapdoor("pale_oak_vined_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_warted_trapdoor", registerTrapdoor("pale_oak_warted_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_windowed_trapdoor", registerTrapdoor("pale_oak_windowed_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));
        WOOD_TRAPDOORS.put("pale_oak_woven_trapdoor", registerTrapdoor("pale_oak_woven_trapdoor", BlockSetTypeVariant.PALE_OAK.getBlockSetType(), Blocks.OAK_TRAPDOOR));

        // Full glass-material doors & trapdoors (plain glass + 16 stained colors), translucent, hand-openable.
        BlockSetType glassBst = BlockSetTypeVariant.GLASS.getBlockSetType();
        GLASS_DOORS.put("glass_door", registerDoor("glass_door", glassBst, Blocks.GLASS));
        GLASS_TRAPDOORS.put("glass_trapdoor", registerTrapdoor("glass_trapdoor", glassBst, Blocks.GLASS));
        for (String c : new String[]{"black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray",
                "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"}) {
            Block stained = net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(
                    net.minecraft.resources.ResourceLocation.withDefaultNamespace(c + "_stained_glass"));
            GLASS_DOORS.put(c + "_stained_glass_door", registerDoor(c + "_stained_glass_door", glassBst, stained));
            GLASS_TRAPDOORS.put(c + "_stained_glass_trapdoor", registerTrapdoor(c + "_stained_glass_trapdoor", glassBst, stained));
        }
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
    }

    // ===== MARBLE (wave 1) =====
    // (marble block fields inserted here)
    // ───── acacia_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_ACACIA_LEAVES = register("apple_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_ACACIA_LEAVES = register("cherry_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_ACACIA_LEAVES = register("dead_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_ACACIA_LEAVES = register("frosted_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_ACACIA_LEAVES = register("golden_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_ACACIA_LEAVES = register("golden_apple_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_ACACIA_LEAVES = register("golden_cherry_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_ACACIA_LEAVES = register("magenta_flower_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_ACACIA_LEAVES = register("orange_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_ACACIA_LEAVES = register("red_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_ACACIA_LEAVES = register("white_flower_acacia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));

    // ───── acacia_planks ─────
    public static final DeferredBlock<Block> ACACIA_PLANKS_BEAMS = register("acacia_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BRICK_PATTERN = register("acacia_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BRICK_PAVING = register("acacia_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_BRICKS = register("acacia_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_CRATE = register("acacia_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_DIAGONAL_STRIPES = register("acacia_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_DIAGONAL_TILES = register("acacia_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_DOTTED = register("acacia_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_FLOORING = register("acacia_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_LARGE_TILES = register("acacia_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_PANEL = register("acacia_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_PATTERN = register("acacia_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_ROTATED_BRICKS = register("acacia_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SMALL_BRICKS = register("acacia_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SMALL_TILES = register("acacia_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_SQUARES = register("acacia_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_TILES_STATIC = register("acacia_planks_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_TILES = register("acacia_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_WAVY = register("acacia_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ACACIA_PLANKS_WOVEN = register("acacia_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CORNERED_ACACIA_PLANKS = register("cornered_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> CRATED_ACACIA_PLANKS = register("crated_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_ACACIA_PLANKS = register("enclosed_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_ACACIA_PLANKS = register("framed_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_ACACIA_PLANKS = register("natural_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_ACACIA_PLANKS = register("pegged_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_ACACIA_PLANKS = register("whirlwind_acacia_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));

    // ───── amethyst_block ─────
    public static final DeferredBlock<Block> AMETHYST_BLOCK_BEAMS = register("amethyst_block_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_BORDERED_DIAGONAL_TILES = register("amethyst_block_bordered_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_BRICKS = register("amethyst_block_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_CTM = register("amethyst_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_CUT = register("amethyst_block_cut_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_EDGED = register("amethyst_block_edged_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_SHINY = register("amethyst_block_shiny_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AMETHYST_BLOCK_TILES = register("amethyst_block_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BORDERED_AMETHYST_BLOCK = register("bordered_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_AMETHYST_BLOCK = register("brick_bordered_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CURLY_AMETHYST_BLOCK_CTM = register("curly_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CUT_AMETHYST_BLOCK_COLUMN = register("cut_amethyst_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> EDGED_AMETHYST_BLOCK_BRICKS = register("edged_amethyst_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> FINE_AMETHYST_BLOCK_CTM = register("fine_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_AMETHYST_BLOCK_BRICKS = register("massive_amethyst_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_AMETHYST_BLOCK_CTM = register("ornate_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_AMETHYST_BLOCK_TILES = register("overlapping_amethyst_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_AMETHYST_BLOCK = register("polished_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_AMETHYST_BLOCK_CTM = register("simple_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_AMETHYST_BLOCK_COLUMN = register("smooth_amethyst_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_AMETHYST_BLOCK = register("thick_inlayed_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TILED_AMETHYST_BLOCK_COLUMN = register("tiled_amethyst_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_AMETHYST_BLOCK = register("tiled_bordered_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_AMETHYST_BLOCK = register("tiny_brick_bordered_amethyst_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    // ───── ancient_debris ─────
    public static final DeferredBlock<Block> BORDERED_ANCIENT_DEBRIS = register("bordered_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ANCIENT_DEBRIS = register("brick_bordered_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> CURLY_ANCIENT_DEBRIS_CTM = register("curly_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> CUT_ANCIENT_DEBRIS_COLUMN = register("cut_ancient_debris_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> EDGED_ANCIENT_DEBRIS_BRICKS = register("edged_ancient_debris_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> FINE_ANCIENT_DEBRIS_CTM = register("fine_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> MASSIVE_ANCIENT_DEBRIS_BRICKS = register("massive_ancient_debris_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> ORNATE_ANCIENT_DEBRIS_CTM = register("ornate_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> OVERLAPPING_ANCIENT_DEBRIS_TILES = register("overlapping_ancient_debris_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> POLISHED_ANCIENT_DEBRIS = register("polished_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> SIMPLE_ANCIENT_DEBRIS_CTM = register("simple_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> SMOOTH_ANCIENT_DEBRIS_COLUMN = register("smooth_ancient_debris_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> THICK_INLAYED_ANCIENT_DEBRIS = register("thick_inlayed_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TILED_ANCIENT_DEBRIS_COLUMN = register("tiled_ancient_debris_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TILED_BORDERED_ANCIENT_DEBRIS = register("tiled_bordered_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ANCIENT_DEBRIS = register("tiny_brick_bordered_ancient_debris_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)));

    // ───── andesite ─────
    public static final DeferredBlock<Block> ANDESITE_BRICK_PATTERN = register("andesite_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BRICK_PAVING = register("andesite_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BRICKS = register("andesite_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_CUT_POLISHED = register("andesite_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_CUT_SMALL_BRICK = register("andesite_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_DIAGONAL_BRICKS = register("andesite_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_DOTTED = register("andesite_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_PAVING = register("andesite_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_POLISHED = register("andesite_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_ROTATED_BRICKS = register("andesite_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_SQUARES = register("andesite_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_TILES = register("andesite_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_WAVY = register("andesite_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ANDESITE = register("brick_bordered_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CURLY_ANDESITE_CTM = register("curly_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> CUT_ANDESITE_COLUMN = register("cut_andesite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> EDGED_ANDESITE_BRICKS = register("edged_andesite_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> FINE_ANDESITE_CTM = register("fine_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> MASSIVE_ANDESITE_BRICKS = register("massive_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> ORNATE_ANDESITE_CTM = register("ornate_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> OVERLAPPING_ANDESITE_TILES = register("overlapping_andesite_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> SIMPLE_ANDESITE_CTM = register("simple_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> SMOOTH_ANDESITE_COLUMN = register("smooth_andesite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_ANDESITE = register("thick_inlayed_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TILED_ANDESITE_COLUMN = register("tiled_andesite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_ANDESITE = register("tiled_bordered_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ANDESITE = register("tiny_brick_bordered_andesite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));

    // ───── asurine ─────
    public static final DeferredBlock<Block> ASURINE_CUT_POLISHED = register("asurine_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ASURINE_CUT_SMALL_BRICK = register("asurine_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── bamboo_planks ─────
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BEAMS = register("bamboo_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BRICK_PATTERN = register("bamboo_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BRICK_PAVING = register("bamboo_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_BRICKS = register("bamboo_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_CRATE = register("bamboo_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_DIAGONAL_STRIPES = register("bamboo_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_DIAGONAL_TILES = register("bamboo_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_DOTTED = register("bamboo_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_FLOORING = register("bamboo_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_LARGE_TILES = register("bamboo_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_PANEL = register("bamboo_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_PATTERN = register("bamboo_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_ROTATED_BRICKS = register("bamboo_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SMALL_BRICKS = register("bamboo_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SMALL_TILES = register("bamboo_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_SQUARES = register("bamboo_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_TILES = register("bamboo_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_WAVY = register("bamboo_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BAMBOO_PLANKS_WOVEN = register("bamboo_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CORNERED_BAMBOO_PLANKS = register("cornered_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> CRATED_BAMBOO_PLANKS = register("crated_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_BAMBOO_PLANKS = register("enclosed_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_BAMBOO_PLANKS = register("framed_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_BAMBOO_PLANKS = register("natural_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_BAMBOO_PLANKS = register("pegged_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> POLISHED_BAMBOO_PLANKS = register("polished_bamboo_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> TIED_BAMBOO_PLANKS = register("tied_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_BAMBOO_PLANKS = register("whirlwind_bamboo_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));

    // ───── basalt ─────
    public static final DeferredBlock<Block> BASALT_BEAMS = register("basalt_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BORDERED = register("basalt_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BORDERED_POLISHED = register("basalt_bordered_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_BRICKS = register("basalt_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_DIAGONAL_TILES = register("basalt_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_PATTERN = register("basalt_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_PATTERNED = register("basalt_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BASALT_TILES = register("basalt_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BORDERED_BASALT = register("bordered_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BASALT = register("brick_bordered_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CURLY_BASALT_CTM = register("curly_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> CUT_BASALT_COLUMN = register("cut_basalt_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> EDGED_BASALT_BRICKS = register("edged_basalt_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> FINE_BASALT_CTM = register("fine_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> MASSIVE_BASALT_BRICKS = register("massive_basalt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> ORNATE_BASALT_CTM = register("ornate_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> OVERLAPPING_BASALT_TILES = register("overlapping_basalt_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> POLISHED_BASALT = register("polished_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> SIMPLE_BASALT_CTM = register("simple_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> SMOOTH_BASALT_COLUMN = register("smooth_basalt_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> THICK_INLAYED_BASALT = register("thick_inlayed_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TILED_BASALT_COLUMN = register("tiled_basalt_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TILED_BORDERED_BASALT = register("tiled_bordered_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BASALT = register("tiny_brick_bordered_basalt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT)));

    // ───── birch_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_BIRCH_LEAVES = register("apple_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_BIRCH_LEAVES = register("cherry_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_BIRCH_LEAVES = register("dead_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_BIRCH_LEAVES = register("frosted_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_BIRCH_LEAVES = register("golden_apple_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_BIRCH_LEAVES = register("golden_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_BIRCH_LEAVES = register("golden_cherry_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_BIRCH_LEAVES = register("magenta_flower_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_BIRCH_LEAVES = register("orange_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_BIRCH_LEAVES = register("red_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_BIRCH_LEAVES = register("white_flower_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));

    // ───── birch_planks ─────
    public static final DeferredBlock<Block> BIRCH_PLANKS_BEAMS = register("birch_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BRICK_PATTERN = register("birch_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BRICK_PAVING = register("birch_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_BRICKS = register("birch_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_CRATE = register("birch_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_DIAGONAL_STRIPES = register("birch_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_DIAGONAL_TILES = register("birch_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_DOTTED = register("birch_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_FLOORING = register("birch_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_LARGE_TILES = register("birch_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_PANEL = register("birch_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_PATTERN = register("birch_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_ROTATED_BRICKS = register("birch_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SMALL_BRICKS = register("birch_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SMALL_TILES = register("birch_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_SQUARES = register("birch_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_TILES = register("birch_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_WAVY = register("birch_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BIRCH_PLANKS_WOVEN = register("birch_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CORNERED_BIRCH_PLANKS = register("cornered_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> CRATED_BIRCH_PLANKS = register("crated_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_BIRCH_PLANKS = register("enclosed_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_BIRCH_PLANKS = register("framed_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_BIRCH_PLANKS = register("natural_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_BIRCH_PLANKS = register("pegged_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> POLISHED_BIRCH_PLANKS = register("polished_birch_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_BIRCH_PLANKS = register("whirlwind_birch_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));

    // ───── black_concrete ─────
    public static final DeferredBlock<Block> BLACK_CONCRETE_CTM = register("black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_CONCRETE_PANEL = register("black_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BLACK_CONCRETE = register("grill_black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BLACK_CONCRETE = register("pegged_black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BLACK_CONCRETE = register("smooth_black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BLACK_CONCRETE = register("striped_black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BLACK_CONCRETE = register("wired_black_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));

    // ───── black_marble ─────
    public static final DeferredBlock<Block> BLACK_MARBLE = register("black_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_BRICKS = register("black_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR = register("black_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLACK_MARBLE_PILLAR_CAP = register("black_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACK_MARBLE_SMALL_BRICKS = register("black_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_MARBLE_TILES = register("black_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLACK_POLISHED_MARBLE = register("black_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── black_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_BLACK_STAINED_GLASS_CTM = register("arched_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLACK_LEADED_STAINED_GLASS = register("black_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLACK_STAINED_CLEAR_GLASS = register("black_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLACK_STAINED_GLASS = register("black_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BLACK_STAINED_GLASS = register("circular_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLACK_STAINED_GLASS = register("fancy_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLACK_STAINED_GLASS_CTM = register("fancy_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BLACK_STAINED_GLASS = register("large_diamond_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLACK_STAINED_GLASS = register("ornate_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLACK_STAINED_GLASS_CTM = register("ornate_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLACK_STAINED_GLASS = register("raster_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLACK_STAINED_GLASS_CTM = register("raster_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLACK_DIAMOND_STAINED_GLASS = register("small_black_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLACK_DIAMOND_STAINED_GLASS_CTM = register("small_black_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BLACK_STAINED_GLASS = register("square_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLACK_STAINED_GLASS = register("tiled_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLACK_STAINED_GLASS_CTM = register("tiled_black_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BLACK_STAINED_GLASS = register("vertical_striped_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BLACK_STAINED_GLASS = register("woven_black_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));

    // ───── black_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_BLACK_STAINED_GLASS_CTM_PANE = register("arched_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BLACK_LEADED_STAINED_GLASS_PANE = register("black_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLACK_STAINED_CLEAR_GLASS_CTM_PANE = register("black_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLACK_STAINED_GLASS_CTM_PANE = register("black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_BLACK_STAINED_GLASS_PANE = register("circular_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_BLACK_STAINED_GLASS_CTM_PANE = register("fancy_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_BLACK_STAINED_GLASS_PANE = register("fancy_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_BLACK_STAINED_GLASS_CTM_PANE = register("golden_framed_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_BLACK_STAINED_GLASS_PANE = register("large_diamond_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_BLACK_STAINED_GLASS_CTM_PANE = register("ornate_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_BLACK_STAINED_GLASS_PANE = register("ornate_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_BLACK_STAINED_GLASS_CTM_PANE = register("raster_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_BLACK_STAINED_GLASS_PANE = register("raster_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_BLACK_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_black_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_BLACK_DIAMOND_STAINED_GLASS_PANE = register("small_black_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_BLACK_STAINED_GLASS_PANE = register("square_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_BLACK_STAINED_GLASS_CTM_PANE = register("tiled_black_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_BLACK_STAINED_GLASS_PANE = register("tiled_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_BLACK_STAINED_GLASS_PANE = register("vertical_striped_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_BLACK_STAINED_GLASS_PANE = register("woven_black_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── black_terracotta ─────
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_COLUMN = register("black_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_CTM = register("black_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BLACK_TERRACOTTA = register("circular_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BLACK_TERRACOTTA = register("curled_black_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BLACK_TERRACOTTA = register("hexagonical_black_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BLACK_TERRACOTTA = register("inscribed_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BLACK_TERRACOTTA_TILES = register("small_black_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BLACK_TERRACOTTA = register("starry_black_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));

    // ───── blackstone ─────
    public static final DeferredBlock<Block> BLACKSTONE_BRICK_PATTERN = register("blackstone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_BRICK_PAVING = register("blackstone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_DIAGONAL_BRICKS = register("blackstone_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_POLISHED = register("blackstone_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_ROTATED_BRICKS = register("blackstone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLACKSTONE_TILES = register("blackstone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BORDERED_BLACKSTONE = register("bordered_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BLACKSTONE = register("brick_bordered_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> CURLY_BLACKSTONE_CTM = register("curly_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> CUT_BLACKSTONE_COLUMN = register("cut_blackstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> EDGED_BLACKSTONE_BRICKS = register("edged_blackstone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> FINE_BLACKSTONE_CTM = register("fine_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> MASSIVE_BLACKSTONE_BRICKS = register("massive_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> ORNATE_BLACKSTONE_CTM = register("ornate_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_BLACKSTONE_TILES = register("overlapping_blackstone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> SIMPLE_BLACKSTONE_CTM = register("simple_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> SMOOTH_BLACKSTONE_COLUMN = register("smooth_blackstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BLACKSTONE = register("thick_inlayed_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BLACKSTONE_COLUMN = register("tiled_blackstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BLACKSTONE = register("tiled_bordered_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BLACKSTONE = register("tiny_brick_bordered_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));

    // ───── blue_concrete ─────
    public static final DeferredBlock<Block> BLUE_CONCRETE_CTM = register("blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_PANEL = register("blue_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BLUE_CONCRETE = register("grill_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BLUE_CONCRETE = register("pegged_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BLUE_CONCRETE = register("smooth_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BLUE_CONCRETE = register("striped_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BLUE_CONCRETE = register("wired_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));

    // ───── blue_ice ─────
    public static final DeferredBlock<Block> BLUE_ICE_BORDERED = register("blue_ice_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_BRICKS = register("blue_ice_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_CHISELED = register("blue_ice_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_CTM = register("blue_ice_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_PATTERNED = register("blue_ice_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_SLANTED_TILES = register("blue_ice_slanted_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_ICE_TILES = register("blue_ice_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BORDERED_BLUE_ICE = register("bordered_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BLUE_ICE = register("brick_bordered_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> CURLY_BLUE_ICE_CTM = register("curly_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> CUT_BLUE_ICE_COLUMN = register("cut_blue_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> EDGED_BLUE_ICE_BRICKS = register("edged_blue_ice_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> FINE_BLUE_ICE_CTM = register("fine_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> MASSIVE_BLUE_ICE_BRICKS = register("massive_blue_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> ORNATE_BLUE_ICE_CTM = register("ornate_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_BLUE_ICE_TILES = register("overlapping_blue_ice_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> POLISHED_BLUE_ICE = register("polished_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> SIMPLE_BLUE_ICE_CTM = register("simple_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> SMOOTH_BLUE_ICE_COLUMN = register("smooth_blue_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_BLUE_ICE = register("thick_inlayed_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TILED_BLUE_ICE_COLUMN = register("tiled_blue_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_BLUE_ICE = register("tiled_bordered_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BLUE_ICE = register("tiny_brick_bordered_blue_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE)));

    // ───── blue_marble ─────
    public static final DeferredBlock<Block> BLUE_MARBLE = register("blue_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_BRICKS = register("blue_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR = register("blue_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_MARBLE_PILLAR_CAP = register("blue_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BLUE_MARBLE_SMALL_BRICKS = register("blue_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_MARBLE_TILES = register("blue_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BLUE_POLISHED_MARBLE = register("blue_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── blue_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_BLUE_STAINED_GLASS_CTM = register("arched_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLUE_LEADED_STAINED_GLASS = register("blue_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLUE_STAINED_CLEAR_GLASS = register("blue_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_STAINED_GLASS = register("blue_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BLUE_STAINED_GLASS = register("circular_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLUE_STAINED_GLASS = register("fancy_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BLUE_STAINED_GLASS_CTM = register("fancy_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BLUE_STAINED_GLASS = register("large_diamond_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLUE_STAINED_GLASS = register("ornate_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BLUE_STAINED_GLASS_CTM = register("ornate_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLUE_STAINED_GLASS = register("raster_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BLUE_STAINED_GLASS_CTM = register("raster_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLUE_DIAMOND_STAINED_GLASS = register("small_blue_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BLUE_DIAMOND_STAINED_GLASS_CTM = register("small_blue_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BLUE_STAINED_GLASS = register("square_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLUE_STAINED_GLASS = register("tiled_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BLUE_STAINED_GLASS_CTM = register("tiled_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BLUE_STAINED_GLASS = register("vertical_striped_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BLUE_STAINED_GLASS = register("woven_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));

    // ───── blue_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_BLUE_STAINED_GLASS_CTM_PANE = register("arched_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BLUE_LEADED_STAINED_GLASS_PANE = register("blue_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLUE_STAINED_CLEAR_GLASS_CTM_PANE = register("blue_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLUE_STAINED_GLASS_CTM_PANE = register("blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_BLUE_STAINED_GLASS_PANE = register("circular_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_BLUE_STAINED_GLASS_CTM_PANE = register("fancy_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_BLUE_STAINED_GLASS_PANE = register("fancy_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_BLUE_STAINED_GLASS_CTM_PANE = register("golden_framed_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_BLUE_STAINED_GLASS_PANE = register("large_diamond_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_BLUE_STAINED_GLASS_CTM_PANE = register("ornate_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_BLUE_STAINED_GLASS_PANE = register("ornate_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_BLUE_STAINED_GLASS_CTM_PANE = register("raster_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_BLUE_STAINED_GLASS_PANE = register("raster_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_blue_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_BLUE_DIAMOND_STAINED_GLASS_PANE = register("small_blue_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_BLUE_STAINED_GLASS_PANE = register("square_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_BLUE_STAINED_GLASS_CTM_PANE = register("tiled_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_BLUE_STAINED_GLASS_PANE = register("tiled_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_BLUE_STAINED_GLASS_PANE = register("vertical_striped_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_BLUE_STAINED_GLASS_PANE = register("woven_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── blue_terracotta ─────
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_COLUMN = register("blue_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_CTM = register("blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BLUE_TERRACOTTA = register("circular_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BLUE_TERRACOTTA = register("curled_blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BLUE_TERRACOTTA = register("hexagonical_blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BLUE_TERRACOTTA = register("inscribed_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BLUE_TERRACOTTA_TILES = register("small_blue_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BLUE_TERRACOTTA = register("starry_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));

    // ───── bone_block ─────
    public static final DeferredBlock<Block> BONE_BLOCK_BORDERED = register("bone_block_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_CHISELED = register("bone_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_CONNECTING = register("bone_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_DECORATED_BORDERED = register("bone_block_decorated_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_INVERTED_TILES = register("bone_block_inverted_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BONE_BLOCK_PATTERNED = register("bone_block_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── borderless_bricks ─────
    public static final DeferredBlock<Block> BORDERED_BORDERLESS_BRICKS = register("bordered_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BORDERLESS_BRICKS = register("brick_bordered_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CURLY_BORDERLESS_BRICKS_CTM = register("curly_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CUT_BORDERLESS_BRICKS_COLUMN = register("cut_borderless_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> EDGED_BORDERLESS_BRICKS_BRICKS = register("edged_borderless_bricks_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> FINE_BORDERLESS_BRICKS_CTM = register("fine_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_BORDERLESS_BRICKS_BRICKS = register("massive_borderless_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> ORNATE_BORDERLESS_BRICKS_CTM = register("ornate_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_BORDERLESS_BRICKS_TILES = register("overlapping_borderless_bricks_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> POLISHED_BORDERLESS_BRICKS = register("polished_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_BORDERLESS_BRICKS_CTM = register("simple_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_BORDERLESS_BRICKS_COLUMN = register("smooth_borderless_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_BORDERLESS_BRICKS = register("thick_inlayed_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_BORDERLESS_BRICKS = register("tiled_bordered_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERLESS_BRICKS_COLUMN = register("tiled_borderless_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BORDERLESS_BRICKS = register("tiny_brick_bordered_borderless_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));

    // ───── bricks ─────
    public static final DeferredBlock<Block> BORDERED_BRICKS = register("bordered_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_BRICKS = register("brick_bordered_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CURLY_BRICKS_CTM = register("curly_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> CUT_BRICKS_COLUMN = register("cut_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> DIRT_BRICKS = register("dirt_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SMALL_BRICKS = register("dirt_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_BRICKS_BRICKS = register("edged_bricks_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> EDGED_CLAY_BRICKS = register("edged_clay_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> EDGED_DIRT_BRICKS = register("edged_dirt_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> EDGED_ICE_BRICKS = register("edged_ice_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> EDGED_TUFF_BRICKS = register("edged_tuff_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> FINE_BRICKS_CTM = register("fine_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_BRICKS_BRICKS = register("massive_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_CLAY_BRICKS = register("massive_clay_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> MASSIVE_DIRT_BRICKS = register("massive_dirt_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> MASSIVE_ICE_BRICKS = register("massive_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> MASSIVE_TUFF_BRICKS = register("massive_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> ORNATE_BRICKS_CTM = register("ornate_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_BRICKS_TILES = register("overlapping_bricks_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> POLISHED_BRICKS = register("polished_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> PURPUR_BRICKS = register("purpur_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_DIAGONAL_BRICKS = register("purpur_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_ROTATED_BRICKS = register("purpur_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SIMPLE_BRICKS_CTM = register("simple_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_BRICKS_COLUMN = register("smooth_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_BRICKS = register("thick_inlayed_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_BRICKS = register("tiled_bordered_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TILED_BRICKS_COLUMN = register("tiled_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_BRICKS = register("tiny_brick_bordered_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));

    // ───── brown_concrete ─────
    public static final DeferredBlock<Block> BROWN_CONCRETE_CTM = register("brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_CONCRETE_PANEL = register("brown_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_BROWN_CONCRETE = register("grill_brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_BROWN_CONCRETE = register("pegged_brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_BROWN_CONCRETE = register("smooth_brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_BROWN_CONCRETE = register("striped_brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_BROWN_CONCRETE = register("wired_brown_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));

    // ───── brown_marble ─────
    public static final DeferredBlock<Block> BROWN_MARBLE = register("brown_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BROWN_MARBLE_BRICKS = register("brown_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> BROWN_MARBLE_PILLAR = register("brown_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> BROWN_MARBLE_PILLAR_CAP = register("brown_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> BROWN_MARBLE_SMALL_BRICKS = register("brown_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BROWN_MARBLE_TILES = register("brown_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> BROWN_POLISHED_MARBLE = register("brown_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── brown_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_BROWN_STAINED_GLASS_CTM = register("arched_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> BROWN_LEADED_STAINED_GLASS = register("brown_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> BROWN_STAINED_CLEAR_GLASS = register("brown_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BROWN_STAINED_GLASS = register("brown_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_BROWN_STAINED_GLASS = register("circular_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BROWN_STAINED_GLASS = register("fancy_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_BROWN_STAINED_GLASS_CTM = register("fancy_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_BROWN_STAINED_GLASS = register("large_diamond_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BROWN_STAINED_GLASS = register("ornate_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_BROWN_STAINED_GLASS_CTM = register("ornate_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BROWN_STAINED_GLASS = register("raster_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_BROWN_STAINED_GLASS_CTM = register("raster_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BROWN_DIAMOND_STAINED_GLASS = register("small_brown_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_BROWN_DIAMOND_STAINED_GLASS_CTM = register("small_brown_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_BROWN_STAINED_GLASS = register("square_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BROWN_STAINED_GLASS = register("tiled_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_BROWN_STAINED_GLASS_CTM = register("tiled_brown_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_BROWN_STAINED_GLASS = register("vertical_striped_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_BROWN_STAINED_GLASS = register("woven_brown_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));

    // ───── brown_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_BROWN_STAINED_GLASS_CTM_PANE = register("arched_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BROWN_LEADED_STAINED_GLASS_PANE = register("brown_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BROWN_STAINED_CLEAR_GLASS_CTM_PANE = register("brown_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BROWN_STAINED_GLASS_CTM_PANE = register("brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_BROWN_STAINED_GLASS_PANE = register("circular_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_BROWN_STAINED_GLASS_CTM_PANE = register("fancy_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_BROWN_STAINED_GLASS_PANE = register("fancy_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_BROWN_STAINED_GLASS_CTM_PANE = register("golden_framed_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_BROWN_STAINED_GLASS_PANE = register("large_diamond_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_BROWN_STAINED_GLASS_CTM_PANE = register("ornate_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_BROWN_STAINED_GLASS_PANE = register("ornate_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_BROWN_STAINED_GLASS_CTM_PANE = register("raster_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_BROWN_STAINED_GLASS_PANE = register("raster_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_BROWN_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_brown_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_BROWN_DIAMOND_STAINED_GLASS_PANE = register("small_brown_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_BROWN_STAINED_GLASS_PANE = register("square_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_BROWN_STAINED_GLASS_CTM_PANE = register("tiled_brown_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_BROWN_STAINED_GLASS_PANE = register("tiled_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_BROWN_STAINED_GLASS_PANE = register("vertical_striped_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_BROWN_STAINED_GLASS_PANE = register("woven_brown_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── brown_terracotta ─────
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_COLUMN = register("brown_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_CTM = register("brown_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CIRCULAR_BROWN_TERRACOTTA = register("circular_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_BROWN_TERRACOTTA = register("curled_brown_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_BROWN_TERRACOTTA = register("hexagonical_brown_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_BROWN_TERRACOTTA = register("inscribed_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_BROWN_TERRACOTTA_TILES = register("small_brown_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_BROWN_TERRACOTTA = register("starry_brown_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));

    // ───── calcite ─────
    public static final DeferredBlock<Block> BORDERED_CALCITE = register("bordered_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CALCITE = register("brick_bordered_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CALCITE_CUT_POLISHED = register("calcite_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CALCITE_CUT_SMALL_BRICK = register("calcite_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CURLY_CALCITE_CTM = register("curly_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> CUT_CALCITE_COLUMN = register("cut_calcite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> EDGED_CALCITE_BRICKS = register("edged_calcite_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> FINE_CALCITE_CTM = register("fine_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> MASSIVE_CALCITE_BRICKS = register("massive_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> ORNATE_CALCITE_CTM = register("ornate_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> OVERLAPPING_CALCITE_TILES = register("overlapping_calcite_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> POLISHED_CALCITE = register("polished_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> SIMPLE_CALCITE_CTM = register("simple_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> SMOOTH_CALCITE_COLUMN = register("smooth_calcite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_CALCITE = register("thick_inlayed_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_CALCITE = register("tiled_bordered_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TILED_CALCITE_COLUMN = register("tiled_calcite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CALCITE = register("tiny_brick_bordered_calcite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));

    // ───── cherry_planks ─────
    public static final DeferredBlock<Block> CHERRY_PLANKS_BEAMS = register("cherry_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_BRICK_PATTERN = register("cherry_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_BRICK_PAVING = register("cherry_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_BRICKS = register("cherry_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_CRATE = register("cherry_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_DIAGONAL_STRIPES = register("cherry_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_DIAGONAL_TILES = register("cherry_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_DOTTED = register("cherry_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_FLOORING = register("cherry_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_LARGE_TILES = register("cherry_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_PANEL = register("cherry_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_PATTERN = register("cherry_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_ROTATED_BRICKS = register("cherry_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SMALL_BRICKS = register("cherry_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SMALL_TILES = register("cherry_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_SQUARES = register("cherry_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_TILES = register("cherry_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_WAVY = register("cherry_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CHERRY_PLANKS_WOVEN = register("cherry_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CORNERED_CHERRY_PLANKS = register("cornered_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRATED_CHERRY_PLANKS = register("crated_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_CHERRY_PLANKS = register("enclosed_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_CHERRY_PLANKS = register("framed_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_CHERRY_PLANKS = register("natural_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_CHERRY_PLANKS = register("pegged_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_CHERRY_PLANKS = register("whirlwind_cherry_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    // ───── clay ─────
    public static final DeferredBlock<Block> BORDERED_CLAY = register("bordered_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CLAY = register("brick_bordered_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> CURLY_CLAY_CTM = register("curly_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> CUT_CLAY_COLUMN = register("cut_clay_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> FINE_CLAY_CTM = register("fine_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> ORNATE_CLAY_CTM = register("ornate_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> OVERLAPPING_CLAY_TILES = register("overlapping_clay_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> POLISHED_CLAY = register("polished_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> SIMPLE_CLAY_CTM = register("simple_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> SMOOTH_CLAY_COLUMN = register("smooth_clay_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> THICK_INLAYED_CLAY = register("thick_inlayed_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TILED_BORDERED_CLAY = register("tiled_bordered_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TILED_CLAY_COLUMN = register("tiled_clay_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CLAY = register("tiny_brick_bordered_clay_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));

    // ───── coal_block ─────
    public static final DeferredBlock<Block> BORDERED_COAL_BLOCK = register("bordered_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_COAL_BLOCK = register("brick_bordered_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> COAL_BLOCK_CARVED = register("coal_block_carved_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_CHISELED = register("coal_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_CIRCLES = register("coal_block_circles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_COMPACTED = register("coal_block_compacted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_OVALS = register("coal_block_ovals_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_PATTERN = register("coal_block_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_ROTATED_BRICKS = register("coal_block_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_SMALL_TILES = register("coal_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COAL_BLOCK_STRIPES = register("coal_block_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CURLY_COAL_BLOCK_CTM = register("curly_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> CUT_COAL_BLOCK_COLUMN = register("cut_coal_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> EDGED_COAL_BLOCK_BRICKS = register("edged_coal_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> FINE_COAL_BLOCK_CTM = register("fine_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_COAL_BLOCK_BRICKS = register("massive_coal_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_COAL_BLOCK_CTM = register("ornate_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_COAL_BLOCK_TILES = register("overlapping_coal_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_COAL_BLOCK = register("polished_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_COAL_BLOCK_CTM = register("simple_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_COAL_BLOCK_COLUMN = register("smooth_coal_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_COAL_BLOCK = register("thick_inlayed_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_COAL_BLOCK = register("tiled_bordered_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TILED_COAL_BLOCK_COLUMN = register("tiled_coal_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_COAL_BLOCK = register("tiny_brick_bordered_coal_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));

    // ───── cobbled_deepslate ─────
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BEAMS = register("cobbled_deepslate_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BRICK_PATTERN = register("cobbled_deepslate_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BRICK_PAVING = register("cobbled_deepslate_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_BRICKS = register("cobbled_deepslate_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_LARGE_TILES = register("cobbled_deepslate_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_PAVING = register("cobbled_deepslate_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_PULVERIZED = register("cobbled_deepslate_pulverized_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_ROTATED_BRICKS = register("cobbled_deepslate_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_SMALL_TILES = register("cobbled_deepslate_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_SQUARES = register("cobbled_deepslate_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_STRIPES = register("cobbled_deepslate_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_TILES = register("cobbled_deepslate_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_WORN_STRIPES = register("cobbled_deepslate_worn_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── cobblestone ─────
    public static final DeferredBlock<Block> BORDERED_COBBLESTONE = register("bordered_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_COBBLESTONE = register("brick_bordered_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> COBBLESTONE_BEAMS = register("cobblestone_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_BRICK_PATTERN = register("cobblestone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_BRICK_PAVING = register("cobblestone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_CHISELED_BORDER = register("cobblestone_chiseled_border_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_CROSSES = register("cobblestone_crosses_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_DENTED = register("cobblestone_dented_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_INVERTED_DENTED = register("cobblestone_inverted_dented_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_PAVING = register("cobblestone_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_PULVERIZED = register("cobblestone_pulverized_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_ROTATED_BRICKS = register("cobblestone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_SMALL_TILES = register("cobblestone_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_SQUARES = register("cobblestone_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_STRIPES = register("cobblestone_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_TILES = register("cobblestone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COBBLESTONE_WORN_STRIPES = register("cobblestone_worn_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CURLY_COBBLESTONE_CTM = register("curly_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> CUT_COBBLESTONE_COLUMN = register("cut_cobblestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> EDGED_COBBLESTONE_BRICKS = register("edged_cobblestone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> FINE_COBBLESTONE_CTM = register("fine_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> MASSIVE_COBBLESTONE_BRICKS = register("massive_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> ORNATE_COBBLESTONE_CTM = register("ornate_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_COBBLESTONE_TILES = register("overlapping_cobblestone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> POLISHED_COBBLESTONE = register("polished_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> SIMPLE_COBBLESTONE_CTM = register("simple_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> SMOOTH_COBBLESTONE_COLUMN = register("smooth_cobblestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_COBBLESTONE = register("thick_inlayed_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_COBBLESTONE = register("tiled_bordered_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_COBBLESTONE_COLUMN = register("tiled_cobblestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_COBBLESTONE = register("tiny_brick_bordered_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));

    // ───── copper_block ─────
    public static final DeferredBlock<Block> COPPER_BLOCK_BARS = register("copper_block_bars_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_CIRCLES = register("copper_block_circles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK = register("copper_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_GEARS = register("copper_block_gears_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_LINES = register("copper_block_lines_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_PATTERN = register("copper_block_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_POLISHED = register("copper_block_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_SHAFTS = register("copper_block_shafts_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> COPPER_BLOCK_SMALL_BRICKS = register("copper_block_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── copper_grate ─────
    public static final DeferredBlock<Block> COPPER_GRATE = register("copper_grate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ───── crimsite ─────
    public static final DeferredBlock<Block> CRIMSITE_CUT_POLISHED = register("crimsite_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSITE_CUT_SMALL_BRICK = register("crimsite_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── crimson_planks ─────
    public static final DeferredBlock<Block> CORNERED_CRIMSON_PLANKS = register("cornered_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> CRATED_CRIMSON_PLANKS = register("crated_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BEAMS = register("crimson_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BRICK_PATTERN = register("crimson_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BRICK_PAVING = register("crimson_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_BRICKS = register("crimson_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_CRATE = register("crimson_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_DIAGONAL_STRIPES = register("crimson_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_DIAGONAL_TILES = register("crimson_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_DOTTED = register("crimson_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_FLOORING = register("crimson_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_LARGE_TILES = register("crimson_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_PANEL = register("crimson_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_PATTERN = register("crimson_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_ROTATED_BRICKS = register("crimson_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SMALL_BRICKS = register("crimson_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SMALL_TILES = register("crimson_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_SQUARES = register("crimson_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_TILES = register("crimson_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_WAVY = register("crimson_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CRIMSON_PLANKS_WOVEN = register("crimson_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ENCLOSED_CRIMSON_PLANKS = register("enclosed_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_CRIMSON_PLANKS = register("framed_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_CRIMSON_PLANKS = register("natural_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_CRIMSON_PLANKS = register("pegged_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_CRIMSON_PLANKS = register("whirlwind_crimson_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));

    // ───── crying_obsidian ─────
    public static final DeferredBlock<Block> BORDERED_CRYING_OBSIDIAN = register("bordered_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> BRICK_BORDERED_CRYING_OBSIDIAN = register("brick_bordered_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> CURLY_CRYING_OBSIDIAN_CTM = register("curly_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> CUT_CRYING_OBSIDIAN_COLUMN = register("cut_crying_obsidian_column_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> EDGED_CRYING_OBSIDIAN_BRICKS = register("edged_crying_obsidian_bricks_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> FINE_CRYING_OBSIDIAN_CTM = register("fine_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> MASSIVE_CRYING_OBSIDIAN_BRICKS = register("massive_crying_obsidian_bricks", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> ORNATE_CRYING_OBSIDIAN_CTM = register("ornate_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> OVERLAPPING_CRYING_OBSIDIAN_TILES = register("overlapping_crying_obsidian_tiles_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> POLISHED_CRYING_OBSIDIAN = register("polished_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> SIMPLE_CRYING_OBSIDIAN_CTM = register("simple_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> SMOOTH_CRYING_OBSIDIAN_COLUMN = register("smooth_crying_obsidian_column_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> THICK_INLAYED_CRYING_OBSIDIAN = register("thick_inlayed_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_BORDERED_CRYING_OBSIDIAN = register("tiled_bordered_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_CRYING_OBSIDIAN_COLUMN = register("tiled_crying_obsidian_column_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_CRYING_OBSIDIAN = register("tiny_brick_bordered_crying_obsidian_ctm", () -> new CryingObsidianBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN)));

    // ───── cyan_concrete ─────
    public static final DeferredBlock<Block> CYAN_CONCRETE_CTM = register("cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_CONCRETE_PANEL = register("cyan_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_CYAN_CONCRETE = register("grill_cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_CYAN_CONCRETE = register("pegged_cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_CYAN_CONCRETE = register("smooth_cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_CYAN_CONCRETE = register("striped_cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_CYAN_CONCRETE = register("wired_cyan_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));

    // ───── cyan_marble ─────
    public static final DeferredBlock<Block> CYAN_MARBLE = register("cyan_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_BRICKS = register("cyan_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR = register("cyan_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> CYAN_MARBLE_PILLAR_CAP = register("cyan_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> CYAN_MARBLE_SMALL_BRICKS = register("cyan_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_MARBLE_TILES = register("cyan_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CYAN_POLISHED_MARBLE = register("cyan_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── cyan_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_CYAN_STAINED_GLASS_CTM = register("arched_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_CYAN_STAINED_GLASS = register("circular_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CYAN_LEADED_STAINED_GLASS = register("cyan_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CYAN_STAINED_CLEAR_GLASS = register("cyan_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CYAN_STAINED_GLASS = register("cyan_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FANCY_CYAN_STAINED_GLASS = register("fancy_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_CYAN_STAINED_GLASS_CTM = register("fancy_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_CYAN_STAINED_GLASS = register("large_diamond_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_CYAN_STAINED_GLASS = register("ornate_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_CYAN_STAINED_GLASS_CTM = register("ornate_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_CYAN_STAINED_GLASS = register("raster_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_CYAN_STAINED_GLASS_CTM = register("raster_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_CYAN_DIAMOND_STAINED_GLASS = register("small_cyan_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_CYAN_DIAMOND_STAINED_GLASS_CTM = register("small_cyan_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_CYAN_STAINED_GLASS = register("square_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_CYAN_STAINED_GLASS = register("tiled_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_CYAN_STAINED_GLASS_CTM = register("tiled_cyan_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_CYAN_STAINED_GLASS = register("vertical_striped_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_CYAN_STAINED_GLASS = register("woven_cyan_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));

    // ───── cyan_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_CYAN_STAINED_GLASS_CTM_PANE = register("arched_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_CYAN_STAINED_GLASS_PANE = register("circular_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CYAN_LEADED_STAINED_GLASS_PANE = register("cyan_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CYAN_STAINED_CLEAR_GLASS_CTM_PANE = register("cyan_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CYAN_STAINED_GLASS_CTM_PANE = register("cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_CYAN_STAINED_GLASS_CTM_PANE = register("fancy_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_CYAN_STAINED_GLASS_PANE = register("fancy_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_CYAN_STAINED_GLASS_CTM_PANE = register("golden_framed_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_CYAN_STAINED_GLASS_PANE = register("large_diamond_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_CYAN_STAINED_GLASS_CTM_PANE = register("ornate_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_CYAN_STAINED_GLASS_PANE = register("ornate_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_CYAN_STAINED_GLASS_CTM_PANE = register("raster_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_CYAN_STAINED_GLASS_PANE = register("raster_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_CYAN_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_cyan_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_CYAN_DIAMOND_STAINED_GLASS_PANE = register("small_cyan_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_CYAN_STAINED_GLASS_PANE = register("square_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_CYAN_STAINED_GLASS_CTM_PANE = register("tiled_cyan_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_CYAN_STAINED_GLASS_PANE = register("tiled_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_CYAN_STAINED_GLASS_PANE = register("vertical_striped_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_CYAN_STAINED_GLASS_PANE = register("woven_cyan_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── cyan_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_CYAN_TERRACOTTA = register("circular_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_CYAN_TERRACOTTA = register("curled_cyan_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_COLUMN = register("cyan_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_CTM = register("cyan_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_CYAN_TERRACOTTA = register("hexagonical_cyan_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_CYAN_TERRACOTTA = register("inscribed_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_CYAN_TERRACOTTA_TILES = register("small_cyan_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_CYAN_TERRACOTTA = register("starry_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));

    // ───── dark_oak_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_DARK_OAK_LEAVES = register("apple_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_DARK_OAK_LEAVES = register("cherry_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_DARK_OAK_LEAVES = register("dead_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_DARK_OAK_LEAVES = register("frosted_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_DARK_OAK_LEAVES = register("golden_apple_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_DARK_OAK_LEAVES = register("golden_cherry_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_DARK_OAK_LEAVES = register("golden_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_DARK_OAK_LEAVES = register("magenta_flower_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_DARK_OAK_LEAVES = register("orange_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_DARK_OAK_LEAVES = register("red_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_DARK_OAK_LEAVES = register("white_flower_dark_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));

    // ───── dark_oak_planks ─────
    public static final DeferredBlock<Block> CORNERED_DARK_OAK_PLANKS = register("cornered_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> CRATED_DARK_OAK_PLANKS = register("crated_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BEAMS = register("dark_oak_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BRICK_PATTERN = register("dark_oak_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BRICK_PAVING = register("dark_oak_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_BRICKS = register("dark_oak_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_CRATE = register("dark_oak_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_DIAGONAL_STRIPES = register("dark_oak_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_DIAGONAL_TILES = register("dark_oak_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_DOTTED = register("dark_oak_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_FLOORING = register("dark_oak_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_LARGE_TILES = register("dark_oak_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_PANEL = register("dark_oak_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_PATTERN = register("dark_oak_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_ROTATED_BRICKS = register("dark_oak_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SMALL_BRICKS = register("dark_oak_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SMALL_TILES = register("dark_oak_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_SQUARES = register("dark_oak_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_TILES = register("dark_oak_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_WAVY = register("dark_oak_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_PLANKS_WOVEN = register("dark_oak_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ENCLOSED_DARK_OAK_PLANKS = register("enclosed_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_DARK_OAK_PLANKS = register("framed_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_DARK_OAK_PLANKS = register("natural_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_DARK_OAK_PLANKS = register("pegged_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_DARK_OAK_PLANKS = register("whirlwind_dark_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));

    // ───── dark_prismarine ─────
    public static final DeferredBlock<Block> BORDERED_DARK_PRISMARINE = register("bordered_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DARK_PRISMARINE = register("brick_bordered_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CURLY_DARK_PRISMARINE_CTM = register("curly_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> CUT_DARK_PRISMARINE_COLUMN = register("cut_dark_prismarine_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_BEAMS = register("dark_prismarine_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_BRICK_PAVING = register("dark_prismarine_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_DOTTED = register("dark_prismarine_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_FABRIC = register("dark_prismarine_fabric_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_LARGE_TILES = register("dark_prismarine_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_ROWS = register("dark_prismarine_rows_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_SQUARES = register("dark_prismarine_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_TILES = register("dark_prismarine_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_WAVY = register("dark_prismarine_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_WOVEN = register("dark_prismarine_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> FINE_DARK_PRISMARINE_CTM = register("fine_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> ORNATE_DARK_PRISMARINE_CTM = register("ornate_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> OVERLAPPING_DARK_PRISMARINE_TILES = register("overlapping_dark_prismarine_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> POLISHED_DARK_PRISMARINE = register("polished_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> SIMPLE_DARK_PRISMARINE_CTM = register("simple_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> SMOOTH_DARK_PRISMARINE_COLUMN = register("smooth_dark_prismarine_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DARK_PRISMARINE = register("thick_inlayed_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DARK_PRISMARINE = register("tiled_bordered_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TILED_DARK_PRISMARINE_COLUMN = register("tiled_dark_prismarine_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DARK_PRISMARINE = register("tiny_brick_bordered_dark_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));

    // ───── deepslate ─────
    public static final DeferredBlock<Block> BORDERED_DEEPSLATE = register("bordered_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DEEPSLATE = register("brick_bordered_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> CURLY_DEEPSLATE_CTM = register("curly_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> CUT_DEEPSLATE_COLUMN = register("cut_deepslate_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> DEEPSLATE_CUT_POLISHED = register("deepslate_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CUT_SMALL_BRICK = register("deepslate_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_DEEPSLATE_BRICKS = register("edged_deepslate_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> FINE_DEEPSLATE_CTM = register("fine_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MASSIVE_DEEPSLATE_BRICKS = register("massive_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> ORNATE_DEEPSLATE_CTM = register("ornate_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> OVERLAPPING_DEEPSLATE_TILES = register("overlapping_deepslate_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> POLISHED_DEEPSLATE = register("polished_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SIMPLE_DEEPSLATE_CTM = register("simple_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> SMOOTH_DEEPSLATE_COLUMN = register("smooth_deepslate_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DEEPSLATE = register("thick_inlayed_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DEEPSLATE = register("tiled_bordered_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TILED_DEEPSLATE_COLUMN = register("tiled_deepslate_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DEEPSLATE = register("tiny_brick_bordered_deepslate_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // ───── diamond ─────
    public static final DeferredBlock<Block> DIAMOND_STONE_PAVERS = register("diamond_stone_pavers", () -> new Block(ST));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LEADED_GLASS = register("large_diamond_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_DIAMOND_BORDERED_GLASS = register("oak_diamond_bordered_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_DIAMOND_BORDERED_GLASS_CTM = register("oak_diamond_bordered_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LARGE_DIAMOND_GLASS = register("oak_large_diamond_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LARGE_DIAMOND_GLASS_CTM = register("oak_large_diamond_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_DIAMOND_LEADED_GLASS = register("small_diamond_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SMALL_DIAMOND_LEADED_GLASS_CTM = register("small_diamond_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));

    // ───── diamond_block ─────
    public static final DeferredBlock<Block> DIAMOND_BLOCK_CHISELED = register("diamond_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_CHISELED_CUBES = register("diamond_block_chiseled_cubes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_CONNECTING = register("diamond_block_connecting_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK = register("diamond_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_GRID = register("diamond_block_grid_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_JEWEL_BLOCK = register("diamond_block_jewel_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_POLISHED = register("diamond_block_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_RHOMBUSES = register("diamond_block_rhombuses_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_SHINY_BORDERED = register("diamond_block_shiny_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIAMOND_BLOCK_SMALL_TILES = register("diamond_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── diorite ─────
    public static final DeferredBlock<Block> BORDERED_DIORITE = register("bordered_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DIORITE = register("brick_bordered_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CURLY_DIORITE_CTM = register("curly_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> CUT_DIORITE_COLUMN = register("cut_diorite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> DIORITE_BRICK_PATTERN = register("diorite_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_BRICK_PAVING = register("diorite_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_BRICKS = register("diorite_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_CUT_POLISHED = register("diorite_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_CUT_SMALL_BRICK = register("diorite_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_DIAGONAL_BRICKS = register("diorite_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_DOTTED = register("diorite_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_PAVING = register("diorite_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_POLISHED = register("diorite_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_ROTATED_BRICKS = register("diorite_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_SQUARES = register("diorite_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_TILES = register("diorite_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIORITE_WAVY = register("diorite_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_DIORITE_BRICKS = register("edged_diorite_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> FINE_DIORITE_CTM = register("fine_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> MASSIVE_DIORITE_BRICKS = register("massive_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> ORNATE_DIORITE_CTM = register("ornate_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> OVERLAPPING_DIORITE_TILES = register("overlapping_diorite_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> SIMPLE_DIORITE_CTM = register("simple_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> SMOOTH_DIORITE_COLUMN = register("smooth_diorite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_DIORITE = register("thick_inlayed_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_DIORITE = register("tiled_bordered_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TILED_DIORITE_COLUMN = register("tiled_diorite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DIORITE = register("tiny_brick_bordered_diorite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));

    // ───── dirt ─────
    public static final DeferredBlock<Block> BORDERED_DIRT = register("bordered_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DIRT = register("brick_bordered_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> CURLY_DIRT_CTM = register("curly_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> CUT_DIRT_COLUMN = register("cut_dirt_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> DIRT_BLOBS = register("dirt_blobs_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_CHUNKS = register("dirt_chunks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_CLUMPS = register("dirt_clumps_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_LARGE_TILES = register("dirt_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SMALL_TILES = register("dirt_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SMOOTH_CLUMPS = register("dirt_smooth_clumps_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SOIL = register("dirt_soil_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_SQUARES = register("dirt_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_TILES = register("dirt_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DIRT_TILLED = register("dirt_tilled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> FINE_DIRT_CTM = register("fine_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> ORNATE_DIRT_CTM = register("ornate_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> OVERLAPPING_DIRT_TILES = register("overlapping_dirt_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> POLISHED_DIRT = register("polished_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> SIMPLE_DIRT_CTM = register("simple_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> SMOOTH_DIRT_COLUMN = register("smooth_dirt_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> THICK_INLAYED_DIRT = register("thick_inlayed_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TILED_BORDERED_DIRT = register("tiled_bordered_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TILED_DIRT_COLUMN = register("tiled_dirt_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DIRT = register("tiny_brick_bordered_dirt_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    // ───── dripstone ─────
    public static final DeferredBlock<Block> DRIPSTONE_CUT_POLISHED = register("dripstone_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DRIPSTONE_CUT_SMALL_BRICK = register("dripstone_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = register("polished_dripstone_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── dripstone_block ─────
    public static final DeferredBlock<Block> BORDERED_DRIPSTONE_BLOCK = register("bordered_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_DRIPSTONE_BLOCK = register("brick_bordered_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CURLY_DRIPSTONE_BLOCK_CTM = register("curly_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> CUT_DRIPSTONE_BLOCK_COLUMN = register("cut_dripstone_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> EDGED_DRIPSTONE_BLOCK_BRICKS = register("edged_dripstone_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> FINE_DRIPSTONE_BLOCK_CTM = register("fine_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_DRIPSTONE_BLOCK_BRICKS = register("massive_dripstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_DRIPSTONE_BLOCK_CTM = register("ornate_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_DRIPSTONE_BLOCK_TILES = register("overlapping_dripstone_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_DRIPSTONE_BLOCK_CTM = register("simple_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_DRIPSTONE_BLOCK_COLUMN = register("smooth_dripstone_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_DRIPSTONE_BLOCK = register("thick_inlayed_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_DRIPSTONE_BLOCK = register("tiled_bordered_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_DRIPSTONE_BLOCK_COLUMN = register("tiled_dripstone_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_DRIPSTONE_BLOCK = register("tiny_brick_bordered_dripstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));

    // ───── emerald_block ─────
    public static final DeferredBlock<Block> EMERALD_BLOCK_BORDERED_CROSSES = register("emerald_block_bordered_crosses_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_BORDERED_PLATING = register("emerald_block_bordered_plating_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CHISELED = register("emerald_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CLOVERS = register("emerald_block_clovers_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CRYSTAL = register("emerald_block_crystal_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_CTM = register("emerald_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_PATTERNED = register("emerald_block_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_PATTERNED_SQUARES = register("emerald_block_patterned_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_POLISHED = register("emerald_block_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_STRIPED = register("emerald_block_striped_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EMERALD_BLOCK_WAXED = register("emerald_block_waxed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── end_stone ─────
    public static final DeferredBlock<Block> BORDERED_END_STONE = register("bordered_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_END_STONE = register("brick_bordered_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> CURLY_END_STONE_CTM = register("curly_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> CUT_END_STONE_COLUMN = register("cut_end_stone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> END_STONE_BLOBS = register("end_stone_blobs_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_BRICK_PATTERN = register("end_stone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_BRICK_PAVING = register("end_stone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_CHISELED = register("end_stone_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_CRUSHED = register("end_stone_crushed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_MESH = register("end_stone_mesh_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_PAVING = register("end_stone_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SCALES = register("end_stone_scales_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SMALL_TILES = register("end_stone_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SPIRAL_PATTERN = register("end_stone_spiral_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_SQUARES = register("end_stone_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_TILES = register("end_stone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> FINE_END_STONE_CTM = register("fine_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> ORNATE_END_STONE_CTM = register("ornate_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> OVERLAPPING_END_STONE_TILES = register("overlapping_end_stone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> POLISHED_END_STONE = register("polished_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> SIMPLE_END_STONE_CTM = register("simple_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> STONE_SLATED_END = register("stone_slated_end", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_END_STONE = register("thick_inlayed_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_END_STONE = register("tiled_bordered_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TILED_END_STONE_COLUMN = register("tiled_end_stone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_END_STONE = register("tiny_brick_bordered_end_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

    // ───── end_stone_bricks ─────
    public static final DeferredBlock<Block> EDGED_END_STONE_BRICKS = register("edged_end_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> END_STONE_DIAGONAL_BRICKS = register("end_stone_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> END_STONE_ROTATED_BRICKS = register("end_stone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MASSIVE_END_STONE_BRICKS = register("massive_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

    // ───── exposed_copper ─────
    public static final DeferredBlock<Block> EXPOSED_COPPER_BLOCK = register("exposed_copper_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── exposed_copper_grate ─────
    public static final DeferredBlock<Block> EXPOSED_COPPER_GRATE = register("exposed_copper_grate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ───── gilded_blackstone ─────
    public static final DeferredBlock<Block> BORDERED_GILDED_BLACKSTONE = register("bordered_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_GILDED_BLACKSTONE = register("brick_bordered_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> CURLY_GILDED_BLACKSTONE_CTM = register("curly_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> CUT_GILDED_BLACKSTONE_COLUMN = register("cut_gilded_blackstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> EDGED_GILDED_BLACKSTONE_BRICKS = register("edged_gilded_blackstone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> FINE_GILDED_BLACKSTONE_CTM = register("fine_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> MASSIVE_GILDED_BLACKSTONE_BRICKS = register("massive_gilded_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> ORNATE_GILDED_BLACKSTONE_CTM = register("ornate_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_GILDED_BLACKSTONE_TILES = register("overlapping_gilded_blackstone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> POLISHED_GILDED_BLACKSTONE = register("polished_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> SIMPLE_GILDED_BLACKSTONE_CTM = register("simple_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> SMOOTH_GILDED_BLACKSTONE_COLUMN = register("smooth_gilded_blackstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_GILDED_BLACKSTONE = register("thick_inlayed_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_GILDED_BLACKSTONE = register("tiled_bordered_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TILED_GILDED_BLACKSTONE_COLUMN = register("tiled_gilded_blackstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_GILDED_BLACKSTONE = register("tiny_brick_bordered_gilded_blackstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE)));

    // ───── glass ─────
    public static final DeferredBlock<Block> ARCHED_LEADED_GLASS_CTM = register("arched_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> BLACK_FRAMED_GLASS = register("black_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BLUE_FRAMED_GLASS = register("blue_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_BLACK = register("borderless_glass_black_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_BLUE = register("borderless_glass_blue_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_BROWN = register("borderless_glass_brown_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS = register("borderless_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_CYAN = register("borderless_glass_cyan_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_GRAY = register("borderless_glass_gray_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_GREEN = register("borderless_glass_green_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_LIGHT_BLUE = register("borderless_glass_light_blue_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_LIGHT_GRAY = register("borderless_glass_light_gray_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_LIME = register("borderless_glass_lime_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_MAGENTA = register("borderless_glass_magenta_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_ORANGE = register("borderless_glass_orange_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_PINK = register("borderless_glass_pink_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_PURPLE = register("borderless_glass_purple_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_RED = register("borderless_glass_red_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_WHITE = register("borderless_glass_white_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BORDERLESS_GLASS_YELLOW = register("borderless_glass_yellow_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> BROWN_FRAMED_GLASS = register("brown_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CHISELED_GLASS = register("chiseled_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CIRCLE_OAK_GLASS = register("circle_oak_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CIRCULAR_LEADED_STAINED_GLASS = register("circular_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CLEAR_GLASS = register("clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> CLEAR_LEADED_GLASS = register("clear_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CLEAR_LEADED_GLASS_CTM = register("clear_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> CYAN_FRAMED_GLASS = register("cyan_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> DIRTY_GLASS = register("dirty_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FANCY_LEADED_GLASS = register("fancy_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> FANCY_LEADED_GLASS_CTM = register("fancy_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> FRAMED_GLASS = register("framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FROSTED_GLASS = register("frosted_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GRAY_FRAMED_GLASS = register("gray_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_FRAMED_GLASS = register("green_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ICE_GLASS = register("ice_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LEADED_GLASS = register("leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LEADED_WOVEN_GLASS = register("leaded_woven_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_BLUE_FRAMED_GLASS = register("light_blue_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_FRAMED_GLASS = register("light_gray_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_FRAMED_GLASS = register("lime_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_FRAMED_GLASS = register("magenta_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OAK_BARRED_GLASS = register("oak_barred_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_BARRED_GLASS_CTM = register("oak_barred_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_BORDERED_GLASS = register("oak_bordered_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_BORDERED_GLASS_CTM = register("oak_bordered_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_HORIZONTAL_LINED_GLASS = register("oak_horizontal_lined_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_HORIZONTAL_LINED_GLASS_CTM = register("oak_horizontal_lined_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LINE_BARED_GLASS = register("oak_line_bared_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_LINE_BARED_GLASS_CTM = register("oak_line_bared_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_ORNATE_BARED_GLASS = register("oak_ornate_bared_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_ORNATE_BARED_GLASS_CTM = register("oak_ornate_bared_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_SNOWFLAKE_GLASS = register("oak_snowflake_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WOVEN_GLASS = register("oak_woven_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WOVEN_GLASS_CTM = register("oak_woven_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ORANGE_FRAMED_GLASS = register("orange_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORNATE_LEADED_GLASS = register("ornate_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> ORNATE_LEADED_GLASS_CTM = register("ornate_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> PINK_FRAMED_GLASS = register("pink_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPLE_FRAMED_GLASS = register("purple_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RASTER_LEADED_GLASS = register("raster_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RASTER_LEADED_GLASS_CTM = register("raster_leaded_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RED_FRAMED_GLASS = register("red_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> REINFORCED_GLASS = register("reinforced_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_BLACK = register("scratched_glass_black_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_BLUE = register("scratched_glass_blue_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_BROWN = register("scratched_glass_brown_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS = register("scratched_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_CYAN = register("scratched_glass_cyan_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_GRAY = register("scratched_glass_gray_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_GREEN = register("scratched_glass_green_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_LIGHT_BLUE = register("scratched_glass_light_blue_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_LIGHT_GRAY = register("scratched_glass_light_gray_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_LIME = register("scratched_glass_lime_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_MAGENTA = register("scratched_glass_magenta_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_ORANGE = register("scratched_glass_orange_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_PINK = register("scratched_glass_pink_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_PURPLE = register("scratched_glass_purple_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_RED = register("scratched_glass_red_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_WHITE = register("scratched_glass_white_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SCRATCHED_GLASS_YELLOW = register("scratched_glass_yellow_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SOUL_GLASS = register("soul_glass", () -> new TransparentBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn((state, level, pos, type) -> false).isRedstoneConductor((state, level, pos) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<Block> SOUL_GLASS_CTM = register("soul_glass_ctm", () -> new TransparentBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn((state, level, pos, type) -> false).isRedstoneConductor((state, level, pos) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<Block> SQUARE_LEADED_GLASS = register("square_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SQUARE_OAK_GLASS = register("square_oak_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> SQUARE_OAK_GLASS_CTM = register("square_oak_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> VERTICAL_LEADED_GLASS = register("vertical_leaded_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> WHITE_FRAMED_GLASS = register("white_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_FRAMED_GLASS = register("yellow_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));

    // ───── glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LEADED_GLASS_CTM_PANE = register("arched_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLACK_FRAMED_GLASS_CTM_PANE = register("black_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BLUE_FRAMED_GLASS_CTM_PANE = register("blue_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_BLACK_CTM_PANE = register("borderless_glass_black_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_BLUE_CTM_PANE = register("borderless_glass_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_BROWN_CTM_PANE = register("borderless_glass_brown_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_CTM_PANE = register("borderless_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_CYAN_CTM_PANE = register("borderless_glass_cyan_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_GRAY_CTM_PANE = register("borderless_glass_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_GREEN_CTM_PANE = register("borderless_glass_green_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE = register("borderless_glass_light_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE = register("borderless_glass_light_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_LIME_CTM_PANE = register("borderless_glass_lime_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_MAGENTA_CTM_PANE = register("borderless_glass_magenta_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_ORANGE_CTM_PANE = register("borderless_glass_orange_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_PINK_CTM_PANE = register("borderless_glass_pink_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_PURPLE_CTM_PANE = register("borderless_glass_purple_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_RED_CTM_PANE = register("borderless_glass_red_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_WHITE_CTM_PANE = register("borderless_glass_white_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BORDERLESS_GLASS_YELLOW_CTM_PANE = register("borderless_glass_yellow_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BROWN_FRAMED_GLASS_CTM_PANE = register("brown_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHISELED_GLASS_CTM_PANE = register("chiseled_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCLE_OAK_GLASS_PANE = register("circle_oak_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LEADED_STAINED_GLASS_PANE = register("circular_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CLEAR_GLASS_CTM_PANE = register("clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CLEAR_LEADED_GLASS_CTM_PANE = register("clear_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CLEAR_LEADED_GLASS_PANE = register("clear_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CYAN_FRAMED_GLASS_CTM_PANE = register("cyan_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DIRTY_GLASS_CTM_PANE = register("dirty_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LEADED_GLASS_CTM_PANE = register("fancy_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LEADED_GLASS_PANE = register("fancy_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FRAMED_GLASS_CTM_PANE = register("framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FROSTED_GLASS_CTM_PANE = register("frosted_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GRAY_FRAMED_GLASS_CTM_PANE = register("gray_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GREEN_FRAMED_GLASS_CTM_PANE = register("green_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ICE_GLASS_CTM_PANE = register("ice_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LEADED_GLASS_PANE = register("large_diamond_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEADED_GLASS_PANE = register("leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LEADED_WOVEN_GLASS_PANE = register("leaded_woven_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_BLUE_FRAMED_GLASS_CTM_PANE = register("light_blue_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_GRAY_FRAMED_GLASS_CTM_PANE = register("light_gray_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIME_FRAMED_GLASS_CTM_PANE = register("lime_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MAGENTA_FRAMED_GLASS_CTM_PANE = register("magenta_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_BARRED_GLASS_CTM_PANE = register("oak_barred_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_BARRED_GLASS_PANE = register("oak_barred_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_BORDERED_GLASS_CTM_PANE = register("oak_bordered_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_DIAMOND_BORDERED_GLASS_CTM_PANE = register("oak_diamond_bordered_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_DIAMOND_BORDERED_GLASS_PANE = register("oak_diamond_bordered_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_HORIZONTAL_LINED_GLASS_CTM_PANE = register("oak_horizontal_lined_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_HORIZONTAL_LINED_GLASS_PANE = register("oak_horizontal_lined_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_LARGE_DIAMOND_GLASS_CTM_PANE = register("oak_large_diamond_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_LARGE_DIAMOND_GLASS_PANE = register("oak_large_diamond_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_LINE_BARED_GLASS_CTM_PANE = register("oak_line_bared_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_LINE_BARED_GLASS_PANE = register("oak_line_bared_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_ORNATE_BARED_GLASS_CTM_PANE = register("oak_ornate_bared_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_ORNATE_BARED_GLASS_PANE = register("oak_ornate_bared_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_SNOWFLAKE_GLASS_PANE = register("oak_snowflake_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WOVEN_GLASS_CTM_PANE = register("oak_woven_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WOVEN_GLASS_PANE = register("oak_woven_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OBSIDIAN_FRAMED_GLASS_CTM_PANE = register("obsidian_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORANGE_FRAMED_GLASS_CTM_PANE = register("orange_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LEADED_GLASS_CTM_PANE = register("ornate_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LEADED_GLASS_PANE = register("ornate_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PINK_FRAMED_GLASS_CTM_PANE = register("pink_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PURPLE_FRAMED_GLASS_CTM_PANE = register("purple_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LEADED_GLASS_CTM_PANE = register("raster_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LEADED_GLASS_PANE = register("raster_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RED_FRAMED_GLASS_CTM_PANE = register("red_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> REINFORCED_GLASS_CTM_PANE = register("reinforced_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SANDSTONE_FRAMED_GLASS_CTM_PANE = register("sandstone_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_BLACK_CTM_PANE = register("scratched_glass_black_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_BLUE_CTM_PANE = register("scratched_glass_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_BROWN_CTM_PANE = register("scratched_glass_brown_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_CTM_PANE = register("scratched_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_CYAN_CTM_PANE = register("scratched_glass_cyan_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_GRAY_CTM_PANE = register("scratched_glass_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_GREEN_CTM_PANE = register("scratched_glass_green_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_LIGHT_BLUE_CTM_PANE = register("scratched_glass_light_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_LIGHT_GRAY_CTM_PANE = register("scratched_glass_light_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_LIME_CTM_PANE = register("scratched_glass_lime_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_MAGENTA_CTM_PANE = register("scratched_glass_magenta_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_ORANGE_CTM_PANE = register("scratched_glass_orange_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_PINK_CTM_PANE = register("scratched_glass_pink_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_PURPLE_CTM_PANE = register("scratched_glass_purple_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_RED_CTM_PANE = register("scratched_glass_red_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_WHITE_CTM_PANE = register("scratched_glass_white_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SCRATCHED_GLASS_YELLOW_CTM_PANE = register("scratched_glass_yellow_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_DIAMOND_LEADED_GLASS_CTM_PANE = register("small_diamond_leaded_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_DIAMOND_LEADED_GLASS_PANE = register("small_diamond_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SOUL_GLASS_CTM_PANE = register("soul_glass_ctm_pane", () -> new CtmPaneBlock(Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SOUL_GLASS_PANE = register("soul_glass_pane", () -> new IronBarsBlock(Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn((state, level, pos, type) -> false).isRedstoneConductor((state, level, pos) -> false).isSuffocating((state, level, pos) -> false).isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LEADED_GLASS_PANE = register("square_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SQUARE_OAK_GLASS_CTM_PANE = register("square_oak_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> STONE_FRAMED_GLASS_CTM_PANE = register("stone_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_LEADED_GLASS_PANE = register("vertical_leaded_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WHITE_FRAMED_GLASS_CTM_PANE = register("white_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> YELLOW_FRAMED_GLASS_CTM_PANE = register("yellow_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    // ───── glowstone ─────
    public static final DeferredBlock<Block> GLOWSTONE_BRICK_PATTERN = register("glowstone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_BRICK_PAVING = register("glowstone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_BRICKS = register("glowstone_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_CRUSHED = register("glowstone_crushed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_LARGE_TILES = register("glowstone_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_ROTATED_BRICKS = register("glowstone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_SMALL_TILES = register("glowstone_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_SMOOTH = register("glowstone_smooth_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GLOWSTONE_TILES = register("glowstone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REFINED_GLOWSTONE = register("refined_glowstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)));

    // ───── gold_block ─────
    public static final DeferredBlock<Block> GOLD_BLOCK_BEAMS = register("gold_block_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_BORDERED = register("gold_block_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK = register("gold_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_LINES = register("gold_block_lines_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_PATTERN = register("gold_block_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_POLISHED = register("gold_block_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_SCALES = register("gold_block_scales_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_SMALL_BRICKS = register("gold_block_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_SMALL_TILES = register("gold_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_STRIPED = register("gold_block_striped_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GOLD_BLOCK_TILES = register("gold_block_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── golden_framed_glass ─────
    public static final DeferredBlock<Block> GOLDEN_FRAMED_BLACK_STAINED_GLASS = register("golden_framed_black_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_BLUE_STAINED_GLASS = register("golden_framed_blue_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_BROWN_STAINED_GLASS = register("golden_framed_brown_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_CYAN_STAINED_GLASS = register("golden_framed_cyan_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_GRAY_STAINED_GLASS = register("golden_framed_gray_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_GREEN_STAINED_GLASS = register("golden_framed_green_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_LIME_STAINED_GLASS = register("golden_framed_lime_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_PINK_STAINED_GLASS = register("golden_framed_pink_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_RED_STAINED_GLASS = register("golden_framed_red_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_STAINED_GLASS = register("golden_framed_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_STAINED_GLASS_CTM_PANE = register("golden_framed_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_WHITE_STAINED_GLASS = register("golden_framed_white_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));

    // ───── granite ─────
    public static final DeferredBlock<Block> BORDERED_GRANITE = register("bordered_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_GRANITE = register("brick_bordered_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CURLY_GRANITE_CTM = register("curly_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> CUT_GRANITE_COLUMN = register("cut_granite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> EDGED_GRANITE_BRICKS = register("edged_granite_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> FINE_GRANITE_CTM = register("fine_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> GRANITE_BRICK_PATTERN = register("granite_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_BRICK_PAVING = register("granite_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_BRICKS = register("granite_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_CUT_POLISHED = register("granite_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_CUT_SMALL_BRICK = register("granite_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_DIAGONAL_BRICKS = register("granite_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_DOTTED = register("granite_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_PAVING = register("granite_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_POLISHED = register("granite_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_ROTATED_BRICKS = register("granite_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_SQUARES = register("granite_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_TILES = register("granite_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRANITE_WAVY = register("granite_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MASSIVE_GRANITE_BRICKS = register("massive_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> ORNATE_GRANITE_CTM = register("ornate_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> OVERLAPPING_GRANITE_TILES = register("overlapping_granite_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> SIMPLE_GRANITE_CTM = register("simple_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> SMOOTH_GRANITE_COLUMN = register("smooth_granite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> THICK_INLAYED_GRANITE = register("thick_inlayed_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> TILED_BORDERED_GRANITE = register("tiled_bordered_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> TILED_GRANITE_COLUMN = register("tiled_granite_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_GRANITE = register("tiny_brick_bordered_granite_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));

    // ───── gray_concrete ─────
    public static final DeferredBlock<Block> GRAY_CONCRETE_CTM = register("gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_CONCRETE_PANEL = register("gray_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_GRAY_CONCRETE = register("grill_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_GRAY_CONCRETE = register("pegged_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_GRAY_CONCRETE = register("smooth_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_GRAY_CONCRETE = register("striped_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_GRAY_CONCRETE = register("wired_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));

    // ───── gray_marble ─────
    public static final DeferredBlock<Block> GRAY_MARBLE = register("gray_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRAY_MARBLE_BRICKS = register("gray_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> GRAY_MARBLE_PILLAR = register("gray_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GRAY_MARBLE_PILLAR_CAP = register("gray_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GRAY_MARBLE_SMALL_BRICKS = register("gray_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GRAY_MARBLE_TILES = register("gray_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GRAY_POLISHED_MARBLE = register("gray_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── gray_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_GRAY_STAINED_GLASS_CTM = register("arched_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_GRAY_STAINED_GLASS = register("circular_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GRAY_STAINED_GLASS = register("fancy_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GRAY_STAINED_GLASS_CTM = register("fancy_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> GRAY_LEADED_STAINED_GLASS = register("gray_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> GRAY_STAINED_CLEAR_GLASS = register("gray_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GRAY_STAINED_GLASS = register("gray_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_GRAY_STAINED_GLASS = register("large_diamond_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GRAY_STAINED_GLASS = register("ornate_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GRAY_STAINED_GLASS_CTM = register("ornate_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GRAY_STAINED_GLASS = register("raster_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GRAY_STAINED_GLASS_CTM = register("raster_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GRAY_DIAMOND_STAINED_GLASS = register("small_gray_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GRAY_DIAMOND_STAINED_GLASS_CTM = register("small_gray_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_GRAY_STAINED_GLASS = register("square_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GRAY_STAINED_GLASS = register("tiled_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GRAY_STAINED_GLASS_CTM = register("tiled_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_GRAY_STAINED_GLASS = register("vertical_striped_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_GRAY_STAINED_GLASS = register("woven_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));

    // ───── gray_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_GRAY_STAINED_GLASS_CTM_PANE = register("arched_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_GRAY_STAINED_GLASS_PANE = register("circular_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_GRAY_STAINED_GLASS_CTM_PANE = register("fancy_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_GRAY_STAINED_GLASS_PANE = register("fancy_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_GRAY_STAINED_GLASS_CTM_PANE = register("golden_framed_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GRAY_LEADED_STAINED_GLASS_PANE = register("gray_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GRAY_STAINED_CLEAR_GLASS_CTM_PANE = register("gray_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GRAY_STAINED_GLASS_CTM_PANE = register("gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_GRAY_STAINED_GLASS_PANE = register("large_diamond_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_GRAY_STAINED_GLASS_CTM_PANE = register("ornate_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_GRAY_STAINED_GLASS_PANE = register("ornate_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_GRAY_STAINED_GLASS_CTM_PANE = register("raster_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_GRAY_STAINED_GLASS_PANE = register("raster_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_gray_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_GRAY_DIAMOND_STAINED_GLASS_PANE = register("small_gray_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_GRAY_STAINED_GLASS_PANE = register("square_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_GRAY_STAINED_GLASS_CTM_PANE = register("tiled_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_GRAY_STAINED_GLASS_PANE = register("tiled_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_GRAY_STAINED_GLASS_PANE = register("vertical_striped_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_GRAY_STAINED_GLASS_PANE = register("woven_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── gray_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_GRAY_TERRACOTTA = register("circular_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_GRAY_TERRACOTTA = register("curled_gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_COLUMN = register("gray_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_CTM = register("gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_GRAY_TERRACOTTA = register("hexagonical_gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_GRAY_TERRACOTTA = register("inscribed_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_GRAY_TERRACOTTA_TILES = register("small_gray_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_GRAY_TERRACOTTA = register("starry_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));

    // ───── green_concrete ─────
    public static final DeferredBlock<Block> GREEN_CONCRETE_CTM = register("green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_CONCRETE_PANEL = register("green_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> GRILL_GREEN_CONCRETE = register("grill_green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_GREEN_CONCRETE = register("pegged_green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_GREEN_CONCRETE = register("smooth_green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_GREEN_CONCRETE = register("striped_green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_GREEN_CONCRETE = register("wired_green_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));

    // ───── green_marble ─────
    public static final DeferredBlock<Block> GREEN_MARBLE = register("green_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_BRICKS = register("green_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR = register("green_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> GREEN_MARBLE_PILLAR_CAP = register("green_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GREEN_MARBLE_SMALL_BRICKS = register("green_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_MARBLE_TILES = register("green_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GREEN_POLISHED_MARBLE = register("green_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── green_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_GREEN_STAINED_GLASS_CTM = register("arched_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_GREEN_STAINED_GLASS = register("circular_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GREEN_STAINED_GLASS = register("fancy_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_GREEN_STAINED_GLASS_CTM = register("fancy_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> GREEN_LEADED_STAINED_GLASS = register("green_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> GREEN_STAINED_CLEAR_GLASS = register("green_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> GREEN_STAINED_GLASS = register("green_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_GREEN_STAINED_GLASS = register("large_diamond_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GREEN_STAINED_GLASS = register("ornate_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_GREEN_STAINED_GLASS_CTM = register("ornate_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GREEN_STAINED_GLASS = register("raster_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_GREEN_STAINED_GLASS_CTM = register("raster_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GREEN_DIAMOND_STAINED_GLASS = register("small_green_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_GREEN_DIAMOND_STAINED_GLASS_CTM = register("small_green_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_GREEN_STAINED_GLASS = register("square_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GREEN_STAINED_GLASS = register("tiled_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_GREEN_STAINED_GLASS_CTM = register("tiled_green_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_GREEN_STAINED_GLASS = register("vertical_striped_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_GREEN_STAINED_GLASS = register("woven_green_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));

    // ───── green_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_GREEN_STAINED_GLASS_CTM_PANE = register("arched_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_GREEN_STAINED_GLASS_PANE = register("circular_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_GREEN_STAINED_GLASS_CTM_PANE = register("fancy_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_GREEN_STAINED_GLASS_PANE = register("fancy_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_GREEN_STAINED_GLASS_CTM_PANE = register("golden_framed_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> GREEN_LEADED_STAINED_GLASS_PANE = register("green_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GREEN_STAINED_CLEAR_GLASS_CTM_PANE = register("green_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GREEN_STAINED_GLASS_CTM_PANE = register("green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_GREEN_STAINED_GLASS_PANE = register("large_diamond_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_GREEN_STAINED_GLASS_CTM_PANE = register("ornate_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_GREEN_STAINED_GLASS_PANE = register("ornate_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_GREEN_STAINED_GLASS_CTM_PANE = register("raster_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_GREEN_STAINED_GLASS_PANE = register("raster_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_GREEN_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_green_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_GREEN_DIAMOND_STAINED_GLASS_PANE = register("small_green_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_GREEN_STAINED_GLASS_PANE = register("square_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_GREEN_STAINED_GLASS_CTM_PANE = register("tiled_green_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_GREEN_STAINED_GLASS_PANE = register("tiled_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_GREEN_STAINED_GLASS_PANE = register("vertical_striped_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_GREEN_STAINED_GLASS_PANE = register("woven_green_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── green_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_GREEN_TERRACOTTA = register("circular_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_GREEN_TERRACOTTA = register("curled_green_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_COLUMN = register("green_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_CTM = register("green_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_GREEN_TERRACOTTA = register("hexagonical_green_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_GREEN_TERRACOTTA = register("inscribed_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_GREEN_TERRACOTTA_TILES = register("small_green_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_GREEN_TERRACOTTA = register("starry_green_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));

    // ───── ice ─────
    public static final DeferredBlock<Block> BORDERED_ICE = register("bordered_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_ICE = register("brick_bordered_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> CURLY_ICE_CTM = register("curly_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> CUT_ICE_COLUMN = register("cut_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> FINE_ICE_CTM = register("fine_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> ORNATE_ICE_CTM = register("ornate_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_ICE_TILES = register("overlapping_ice_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> POLISHED_ICE = register("polished_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> SIMPLE_ICE_CTM = register("simple_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> SMOOTH_ICE_COLUMN = register("smooth_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_ICE = register("thick_inlayed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_ICE = register("tiled_bordered_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TILED_ICE_COLUMN = register("tiled_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_ICE = register("tiny_brick_bordered_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));

    // ───── iron_block ─────
    public static final DeferredBlock<Block> IRON_BLOCK_BORDERED = register("iron_block_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_CHISELED = register("iron_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_CONNECTING = register("iron_block_connecting_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK = register("iron_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_FRAMED = register("iron_block_framed_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> IRON_BLOCK_GEARS = register("iron_block_gears_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_LINES = register("iron_block_lines_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_PATTERNED = register("iron_block_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_PIPES = register("iron_block_pipes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_POLISHED = register("iron_block_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_PROCESSED = register("iron_block_processed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> IRON_BLOCK_SMALL_BRICKS = register("iron_block_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── jungle_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_JUNGLE_LEAVES = register("apple_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_JUNGLE_LEAVES = register("cherry_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_JUNGLE_LEAVES = register("dead_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_JUNGLE_LEAVES = register("frosted_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_JUNGLE_LEAVES = register("golden_apple_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_JUNGLE_LEAVES = register("golden_cherry_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_JUNGLE_LEAVES = register("golden_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_JUNGLE_LEAVES = register("magenta_flower_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_JUNGLE_LEAVES = register("orange_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_JUNGLE_LEAVES = register("red_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_JUNGLE_LEAVES = register("white_flower_jungle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)));

    // ───── jungle_planks ─────
    public static final DeferredBlock<Block> CORNERED_JUNGLE_PLANKS = register("cornered_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> CRATED_JUNGLE_PLANKS = register("crated_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_JUNGLE_PLANKS = register("enclosed_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_JUNGLE_PLANKS = register("framed_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BEAMS = register("jungle_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BRICK_PATTERN = register("jungle_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BRICK_PAVING = register("jungle_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_BRICKS = register("jungle_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_CRATE = register("jungle_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_DIAGONAL_STRIPES = register("jungle_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_DIAGONAL_TILES = register("jungle_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_DOTTED = register("jungle_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_FLOORING = register("jungle_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_LARGE_TILES = register("jungle_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_PANEL = register("jungle_planks_panel_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_PATTERN = register("jungle_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_ROTATED_BRICKS = register("jungle_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SMALL_BRICKS = register("jungle_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SMALL_TILES = register("jungle_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_SQUARES = register("jungle_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_TILES = register("jungle_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_WAVY = register("jungle_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> JUNGLE_PLANKS_WOVEN = register("jungle_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NATURAL_JUNGLE_PLANKS = register("natural_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_JUNGLE_PLANKS = register("pegged_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_JUNGLE_PLANKS = register("whirlwind_jungle_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));

    // ───── lapis_block ─────
    public static final DeferredBlock<Block> BORDERED_LAPIS_BLOCK = register("bordered_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_LAPIS_BLOCK = register("brick_bordered_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> CURLY_LAPIS_BLOCK_CTM = register("curly_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> CUT_LAPIS_BLOCK_COLUMN = register("cut_lapis_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> DELICATE_LAPIS_BLOCK = register("delicate_lapis_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_LAPIS_BLOCK_BRICKS = register("edged_lapis_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> FINE_LAPIS_BLOCK_CTM = register("fine_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_BORDERED = register("lapis_block_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_CONNECTING = register("lapis_block_connecting_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK = register("lapis_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_DECORATED = register("lapis_block_decorated_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_GLOSSY = register("lapis_block_glossy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_INVERTED_TILES = register("lapis_block_inverted_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_MOSAIC = register("lapis_block_mosaic_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_PATTERN = register("lapis_block_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_SCALES = register("lapis_block_scales_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_SMALL_TILES = register("lapis_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_STRIPES = register("lapis_block_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LAPIS_BLOCK_TILES = register("lapis_block_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MASSIVE_LAPIS_BLOCK_BRICKS = register("massive_lapis_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_LAPIS_BLOCK_CTM = register("ornate_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_LAPIS_BLOCK_TILES = register("overlapping_lapis_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_LAPIS_BLOCK = register("polished_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_LAPIS_BLOCK_CTM = register("simple_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_LAPIS_BLOCK_COLUMN = register("smooth_lapis_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_LAPIS_BLOCK = register("thick_inlayed_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_LAPIS_BLOCK = register("tiled_bordered_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TILED_LAPIS_BLOCK_COLUMN = register("tiled_lapis_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_LAPIS_BLOCK = register("tiny_brick_bordered_lapis_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));

    // ───── light_blue_concrete ─────
    public static final DeferredBlock<Block> GRILL_LIGHT_BLUE_CONCRETE = register("grill_light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_CTM = register("light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_PANEL = register("light_blue_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIGHT_BLUE_CONCRETE = register("pegged_light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIGHT_BLUE_CONCRETE = register("smooth_light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIGHT_BLUE_CONCRETE = register("striped_light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIGHT_BLUE_CONCRETE = register("wired_light_blue_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));

    // ───── light_blue_marble ─────
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE = register("light_blue_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_BRICKS = register("light_blue_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_BLUE_MARBLE_PILLAR = register("light_blue_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_BLUE_MARBLE_PILLAR_CAP = register("light_blue_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_SMALL_BRICKS = register("light_blue_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MARBLE_TILES = register("light_blue_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_POLISHED_MARBLE = register("light_blue_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── light_blue_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM = register("arched_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_BLUE_STAINED_GLASS = register("circular_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_BLUE_STAINED_GLASS = register("fancy_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_BLUE_STAINED_GLASS_CTM = register("fancy_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS = register("golden_framed_light_blue_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS = register("large_diamond_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_LEADED_STAINED_GLASS = register("light_blue_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_CLEAR_GLASS = register("light_blue_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS = register("light_blue_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_BLUE_STAINED_GLASS = register("ornate_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM = register("ornate_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_BLUE_STAINED_GLASS = register("raster_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_BLUE_STAINED_GLASS_CTM = register("raster_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS = register("small_light_blue_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM = register("small_light_blue_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LIGHT_BLUE_STAINED_GLASS = register("square_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_BLUE_STAINED_GLASS = register("tiled_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_BLUE_STAINED_GLASS_CTM = register("tiled_light_blue_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS = register("vertical_striped_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_LIGHT_BLUE_STAINED_GLASS = register("woven_light_blue_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));

    // ───── light_blue_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("arched_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LIGHT_BLUE_STAINED_GLASS_PANE = register("circular_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("fancy_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LIGHT_BLUE_STAINED_GLASS_PANE = register("fancy_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("golden_framed_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LIGHT_BLUE_STAINED_GLASS_PANE = register("large_diamond_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LIGHT_BLUE_LEADED_STAINED_GLASS_PANE = register("light_blue_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_BLUE_STAINED_CLEAR_GLASS_CTM_PANE = register("light_blue_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("ornate_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LIGHT_BLUE_STAINED_GLASS_PANE = register("ornate_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("raster_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LIGHT_BLUE_STAINED_GLASS_PANE = register("raster_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_light_blue_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_LIGHT_BLUE_DIAMOND_STAINED_GLASS_PANE = register("small_light_blue_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LIGHT_BLUE_STAINED_GLASS_PANE = register("square_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_LIGHT_BLUE_STAINED_GLASS_CTM_PANE = register("tiled_light_blue_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_LIGHT_BLUE_STAINED_GLASS_PANE = register("tiled_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_LIGHT_BLUE_STAINED_GLASS_PANE = register("vertical_striped_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_LIGHT_BLUE_STAINED_GLASS_PANE = register("woven_light_blue_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── light_blue_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_BLUE_TERRACOTTA = register("circular_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIGHT_BLUE_TERRACOTTA = register("curled_light_blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIGHT_BLUE_TERRACOTTA = register("hexagonical_light_blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIGHT_BLUE_TERRACOTTA = register("inscribed_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_COLUMN = register("light_blue_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_CTM = register("light_blue_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIGHT_BLUE_TERRACOTTA_TILES = register("small_light_blue_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIGHT_BLUE_TERRACOTTA = register("starry_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));

    // ───── light_gray_concrete ─────
    public static final DeferredBlock<Block> GRILL_LIGHT_GRAY_CONCRETE = register("grill_light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_CTM = register("light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_PANEL = register("light_gray_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIGHT_GRAY_CONCRETE = register("pegged_light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIGHT_GRAY_CONCRETE = register("smooth_light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIGHT_GRAY_CONCRETE = register("striped_light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIGHT_GRAY_CONCRETE = register("wired_light_gray_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));

    // ───── light_gray_marble ─────
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE = register("light_gray_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_BRICKS = register("light_gray_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_GRAY_MARBLE_PILLAR = register("light_gray_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIGHT_GRAY_MARBLE_PILLAR_CAP = register("light_gray_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_SMALL_BRICKS = register("light_gray_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MARBLE_TILES = register("light_gray_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_POLISHED_MARBLE = register("light_gray_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── light_gray_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM = register("arched_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_GRAY_STAINED_GLASS = register("circular_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_GRAY_STAINED_GLASS = register("fancy_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIGHT_GRAY_STAINED_GLASS_CTM = register("fancy_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS = register("golden_framed_light_gray_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS = register("large_diamond_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_LEADED_STAINED_GLASS = register("light_gray_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_CLEAR_GLASS = register("light_gray_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS = register("light_gray_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_GRAY_STAINED_GLASS = register("ornate_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM = register("ornate_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_GRAY_STAINED_GLASS = register("raster_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIGHT_GRAY_STAINED_GLASS_CTM = register("raster_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS = register("small_light_gray_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM = register("small_light_gray_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LIGHT_GRAY_STAINED_GLASS = register("square_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_GRAY_STAINED_GLASS = register("tiled_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIGHT_GRAY_STAINED_GLASS_CTM = register("tiled_light_gray_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS = register("vertical_striped_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_LIGHT_GRAY_STAINED_GLASS = register("woven_light_gray_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));

    // ───── light_gray_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("arched_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LIGHT_GRAY_STAINED_GLASS_PANE = register("circular_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("fancy_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LIGHT_GRAY_STAINED_GLASS_PANE = register("fancy_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("golden_framed_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LIGHT_GRAY_STAINED_GLASS_PANE = register("large_diamond_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LIGHT_GRAY_LEADED_STAINED_GLASS_PANE = register("light_gray_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_GRAY_STAINED_CLEAR_GLASS_CTM_PANE = register("light_gray_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("ornate_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LIGHT_GRAY_STAINED_GLASS_PANE = register("ornate_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("raster_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LIGHT_GRAY_STAINED_GLASS_PANE = register("raster_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_light_gray_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_LIGHT_GRAY_DIAMOND_STAINED_GLASS_PANE = register("small_light_gray_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LIGHT_GRAY_STAINED_GLASS_PANE = register("square_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_LIGHT_GRAY_STAINED_GLASS_CTM_PANE = register("tiled_light_gray_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_LIGHT_GRAY_STAINED_GLASS_PANE = register("tiled_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_LIGHT_GRAY_STAINED_GLASS_PANE = register("vertical_striped_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_LIGHT_GRAY_STAINED_GLASS_PANE = register("woven_light_gray_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── light_gray_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_LIGHT_GRAY_TERRACOTTA = register("circular_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIGHT_GRAY_TERRACOTTA = register("curled_light_gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIGHT_GRAY_TERRACOTTA = register("hexagonical_light_gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIGHT_GRAY_TERRACOTTA = register("inscribed_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_COLUMN = register("light_gray_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_CTM = register("light_gray_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIGHT_GRAY_TERRACOTTA_TILES = register("small_light_gray_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIGHT_GRAY_TERRACOTTA = register("starry_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));

    // ───── lime_concrete ─────
    public static final DeferredBlock<Block> GRILL_LIME_CONCRETE = register("grill_lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> LIME_CONCRETE_CTM = register("lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> LIME_CONCRETE_PANEL = register("lime_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_LIME_CONCRETE = register("pegged_lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_LIME_CONCRETE = register("smooth_lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_LIME_CONCRETE = register("striped_lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_LIME_CONCRETE = register("wired_lime_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));

    // ───── lime_marble ─────
    public static final DeferredBlock<Block> LIME_MARBLE = register("lime_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_BRICKS = register("lime_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR = register("lime_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> LIME_MARBLE_PILLAR_CAP = register("lime_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIME_MARBLE_SMALL_BRICKS = register("lime_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_MARBLE_TILES = register("lime_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> LIME_POLISHED_MARBLE = register("lime_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── lime_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_LIME_STAINED_GLASS_CTM = register("arched_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_LIME_STAINED_GLASS = register("circular_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIME_STAINED_GLASS = register("fancy_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_LIME_STAINED_GLASS_CTM = register("fancy_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_LIME_STAINED_GLASS = register("large_diamond_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIME_LEADED_STAINED_GLASS = register("lime_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIME_STAINED_CLEAR_GLASS = register("lime_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LIME_STAINED_GLASS = register("lime_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIME_STAINED_GLASS = register("ornate_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_LIME_STAINED_GLASS_CTM = register("ornate_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIME_STAINED_GLASS = register("raster_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_LIME_STAINED_GLASS_CTM = register("raster_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIME_DIAMOND_STAINED_GLASS = register("small_lime_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_LIME_DIAMOND_STAINED_GLASS_CTM = register("small_lime_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_LIME_STAINED_GLASS = register("square_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIME_STAINED_GLASS = register("tiled_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_LIME_STAINED_GLASS_CTM = register("tiled_lime_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_LIME_STAINED_GLASS = register("vertical_striped_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_LIME_STAINED_GLASS = register("woven_lime_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));

    // ───── lime_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_LIME_STAINED_GLASS_CTM_PANE = register("arched_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_LIME_STAINED_GLASS_PANE = register("circular_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_LIME_STAINED_GLASS_CTM_PANE = register("fancy_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_LIME_STAINED_GLASS_PANE = register("fancy_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_LIME_STAINED_GLASS_CTM_PANE = register("golden_framed_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_LIME_STAINED_GLASS_PANE = register("large_diamond_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LIME_LEADED_STAINED_GLASS_PANE = register("lime_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIME_STAINED_CLEAR_GLASS_CTM_PANE = register("lime_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> LIME_STAINED_GLASS_CTM_PANE = register("lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_LIME_STAINED_GLASS_CTM_PANE = register("ornate_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_LIME_STAINED_GLASS_PANE = register("ornate_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_LIME_STAINED_GLASS_CTM_PANE = register("raster_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_LIME_STAINED_GLASS_PANE = register("raster_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_LIME_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_lime_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_LIME_DIAMOND_STAINED_GLASS_PANE = register("small_lime_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_LIME_STAINED_GLASS_PANE = register("square_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_LIME_STAINED_GLASS_CTM_PANE = register("tiled_lime_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_LIME_STAINED_GLASS_PANE = register("tiled_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_LIME_STAINED_GLASS_PANE = register("vertical_striped_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_LIME_STAINED_GLASS_PANE = register("woven_lime_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── lime_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_LIME_TERRACOTTA = register("circular_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_LIME_TERRACOTTA = register("curled_lime_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_LIME_TERRACOTTA = register("hexagonical_lime_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_LIME_TERRACOTTA = register("inscribed_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_COLUMN = register("lime_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_CTM = register("lime_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_LIME_TERRACOTTA_TILES = register("small_lime_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_LIME_TERRACOTTA = register("starry_lime_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));

    // ───── limestone ─────
    public static final DeferredBlock<Block> COBBLED_LIMESTONE = register("cobbled_limestone", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PLAIN_LIMESTONE = register("limestone", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIMESTONE_CUT_POLISHED = register("limestone_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIMESTONE_CUT_SMALL_BRICK = register("limestone_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> LIMESTONE_MASONRY = register("limestone_masonry", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> MIXED_LIMESTONE_BRICKS = register("mixed_limestone_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE = register("polished_limestone_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── lodestone ─────
    public static final DeferredBlock<Block> BORDERED_LODESTONE = register("bordered_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_LODESTONE = register("brick_bordered_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> CURLY_LODESTONE_CTM = register("curly_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> CUT_LODESTONE_COLUMN = register("cut_lodestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> EDGED_LODESTONE_BRICKS = register("edged_lodestone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> FINE_LODESTONE_CTM = register("fine_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> MASSIVE_LODESTONE_BRICKS = register("massive_lodestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> ORNATE_LODESTONE_CTM = register("ornate_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_LODESTONE_TILES = register("overlapping_lodestone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> POLISHED_LODESTONE = register("polished_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> SIMPLE_LODESTONE_CTM = register("simple_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> SMOOTH_LODESTONE_COLUMN = register("smooth_lodestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_LODESTONE = register("thick_inlayed_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_LODESTONE = register("tiled_bordered_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TILED_LODESTONE_COLUMN = register("tiled_lodestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_LODESTONE = register("tiny_brick_bordered_lodestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)));

    // ───── magenta_concrete ─────
    public static final DeferredBlock<Block> GRILL_MAGENTA_CONCRETE = register("grill_magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_CTM = register("magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_PANEL = register("magenta_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_MAGENTA_CONCRETE = register("pegged_magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_MAGENTA_CONCRETE = register("smooth_magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_MAGENTA_CONCRETE = register("striped_magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_MAGENTA_CONCRETE = register("wired_magenta_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));

    // ───── magenta_marble ─────
    public static final DeferredBlock<Block> MAGENTA_MARBLE = register("magenta_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_BRICKS = register("magenta_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> MAGENTA_MARBLE_PILLAR = register("magenta_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> MAGENTA_MARBLE_PILLAR_CAP = register("magenta_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_SMALL_BRICKS = register("magenta_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> MAGENTA_MARBLE_TILES = register("magenta_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> MAGENTA_POLISHED_MARBLE = register("magenta_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── magenta_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_MAGENTA_STAINED_GLASS_CTM = register("arched_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_MAGENTA_STAINED_GLASS = register("circular_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_MAGENTA_STAINED_GLASS = register("fancy_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_MAGENTA_STAINED_GLASS_CTM = register("fancy_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_MAGENTA_STAINED_GLASS = register("golden_framed_magenta_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_MAGENTA_STAINED_GLASS = register("large_diamond_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> MAGENTA_LEADED_STAINED_GLASS = register("magenta_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> MAGENTA_STAINED_CLEAR_GLASS = register("magenta_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS = register("magenta_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORNATE_MAGENTA_STAINED_GLASS = register("ornate_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_MAGENTA_STAINED_GLASS_CTM = register("ornate_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_MAGENTA_STAINED_GLASS = register("raster_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_MAGENTA_STAINED_GLASS_CTM = register("raster_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_DIAMOND_STAINED_GLASS = register("small_magenta_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM = register("small_magenta_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_MAGENTA_STAINED_GLASS = register("square_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_MAGENTA_STAINED_GLASS = register("tiled_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_MAGENTA_STAINED_GLASS_CTM = register("tiled_magenta_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_MAGENTA_STAINED_GLASS = register("vertical_striped_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_MAGENTA_STAINED_GLASS = register("woven_magenta_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));

    // ───── magenta_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_MAGENTA_STAINED_GLASS_CTM_PANE = register("arched_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_MAGENTA_STAINED_GLASS_PANE = register("circular_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_MAGENTA_STAINED_GLASS_CTM_PANE = register("fancy_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_MAGENTA_STAINED_GLASS_PANE = register("fancy_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_MAGENTA_STAINED_GLASS_CTM_PANE = register("golden_framed_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_MAGENTA_STAINED_GLASS_PANE = register("large_diamond_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MAGENTA_LEADED_STAINED_GLASS_PANE = register("magenta_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MAGENTA_STAINED_CLEAR_GLASS_CTM_PANE = register("magenta_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MAGENTA_STAINED_GLASS_CTM_PANE = register("magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_MAGENTA_STAINED_GLASS_CTM_PANE = register("ornate_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_MAGENTA_STAINED_GLASS_PANE = register("ornate_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_MAGENTA_STAINED_GLASS_CTM_PANE = register("raster_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_MAGENTA_STAINED_GLASS_PANE = register("raster_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_MAGENTA_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_magenta_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_MAGENTA_DIAMOND_STAINED_GLASS_PANE = register("small_magenta_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_MAGENTA_STAINED_GLASS_PANE = register("square_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_MAGENTA_STAINED_GLASS_CTM_PANE = register("tiled_magenta_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_MAGENTA_STAINED_GLASS_PANE = register("tiled_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_MAGENTA_STAINED_GLASS_PANE = register("vertical_striped_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_MAGENTA_STAINED_GLASS_PANE = register("woven_magenta_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── magenta_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_MAGENTA_TERRACOTTA = register("circular_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_MAGENTA_TERRACOTTA = register("curled_magenta_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_MAGENTA_TERRACOTTA = register("hexagonical_magenta_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_MAGENTA_TERRACOTTA = register("inscribed_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_COLUMN = register("magenta_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_CTM = register("magenta_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_MAGENTA_TERRACOTTA_TILES = register("small_magenta_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_MAGENTA_TERRACOTTA = register("starry_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));

    // ───── magma_block ─────
    public static final DeferredBlock<Block> BORDERED_MAGMA_BLOCK = register("bordered_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MAGMA_BLOCK = register("brick_bordered_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> CURLY_MAGMA_BLOCK_CTM = register("curly_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> CUT_MAGMA_BLOCK_COLUMN = register("cut_magma_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> EDGED_MAGMA_BLOCK_BRICKS = register("edged_magma_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> FINE_MAGMA_BLOCK_CTM = register("fine_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_MAGMA_BLOCK_BRICKS = register("massive_magma_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_MAGMA_BLOCK_CTM = register("ornate_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_MAGMA_BLOCK_TILES = register("overlapping_magma_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_MAGMA_BLOCK = register("polished_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_MAGMA_BLOCK_CTM = register("simple_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_MAGMA_BLOCK_COLUMN = register("smooth_magma_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_MAGMA_BLOCK = register("thick_inlayed_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_MAGMA_BLOCK = register("tiled_bordered_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TILED_MAGMA_BLOCK_COLUMN = register("tiled_magma_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MAGMA_BLOCK = register("tiny_brick_bordered_magma_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)));

    // ───── mangrove_planks ─────
    public static final DeferredBlock<Block> CORNERED_MANGROVE_PLANKS = register("cornered_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CRATED_MANGROVE_PLANKS = register("crated_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_MANGROVE_PLANKS = register("enclosed_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_MANGROVE_PLANKS = register("framed_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BEAMS = register("mangrove_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BRICK_PATTERN = register("mangrove_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BRICK_PAVING = register("mangrove_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_BRICKS = register("mangrove_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_CRATE = register("mangrove_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_DIAGONAL_STRIPES = register("mangrove_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_DIAGONAL_TILES = register("mangrove_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_DOTTED = register("mangrove_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_FLOORING = register("mangrove_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_LARGE_TILES = register("mangrove_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_PANEL = register("mangrove_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_PATTERN = register("mangrove_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_ROTATED_BRICKS = register("mangrove_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SMALL_BRICKS = register("mangrove_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SMALL_TILES = register("mangrove_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_SQUARES = register("mangrove_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_TILES = register("mangrove_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_WAVY = register("mangrove_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MANGROVE_PLANKS_WOVEN = register("mangrove_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NATURAL_MANGROVE_PLANKS = register("natural_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_MANGROVE_PLANKS = register("pegged_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_MANGROVE_PLANKS = register("whirlwind_mangrove_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));

    // ───── mossy_cobblestone ─────
    public static final DeferredBlock<Block> BORDERED_MOSSY_COBBLESTONE = register("bordered_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MOSSY_COBBLESTONE = register("brick_bordered_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> CURLY_MOSSY_COBBLESTONE_CTM = register("curly_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> CUT_MOSSY_COBBLESTONE_COLUMN = register("cut_mossy_cobblestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> EDGED_MOSSY_COBBLESTONE_BRICKS = register("edged_mossy_cobblestone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> FINE_MOSSY_COBBLESTONE_CTM = register("fine_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> MASSIVE_MOSSY_COBBLESTONE_BRICKS = register("massive_mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_BEAMS = register("mossy_cobblestone_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_DENTED = register("mossy_cobblestone_dented_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_INVERTED_DENTED = register("mossy_cobblestone_inverted_dented_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_PAVING = register("mossy_cobblestone_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_SMALL_TILES = register("mossy_cobblestone_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_SQUARES = register("mossy_cobblestone_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_STRIPES = register("mossy_cobblestone_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_WORN_STRIPES = register("mossy_cobblestone_worn_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORNATE_MOSSY_COBBLESTONE_CTM = register("ornate_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_MOSSY_COBBLESTONE_TILES = register("overlapping_mossy_cobblestone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> POLISHED_MOSSY_COBBLESTONE = register("polished_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> SIMPLE_MOSSY_COBBLESTONE_CTM = register("simple_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> SMOOTH_MOSSY_COBBLESTONE_COLUMN = register("smooth_mossy_cobblestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_MOSSY_COBBLESTONE = register("thick_inlayed_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_MOSSY_COBBLESTONE = register("tiled_bordered_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TILED_MOSSY_COBBLESTONE_COLUMN = register("tiled_mossy_cobblestone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MOSSY_COBBLESTONE = register("tiny_brick_bordered_mossy_cobblestone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)));

    // ───── mossy_stone_bricks ─────
    public static final DeferredBlock<Block> BORDERED_MOSSY_STONE_BRICKS = register("bordered_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MOSSY_STONE_BRICKS = register("brick_bordered_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> CURLY_MOSSY_STONE_BRICKS_CTM = register("curly_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> CUT_MOSSY_STONE_BRICKS_COLUMN = register("cut_mossy_stone_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> EDGED_MOSSY_STONE_BRICKS_BRICKS = register("edged_mossy_stone_bricks_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> FINE_MOSSY_STONE_BRICKS_CTM = register("fine_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_MOSSY_STONE_BRICKS_BRICKS = register("massive_mossy_stone_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_MOSSY_STONE_BRICKS_CTM = register("ornate_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_MOSSY_STONE_BRICKS_TILES = register("overlapping_mossy_stone_bricks_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_MOSSY_STONE_BRICKS = register("polished_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_MOSSY_STONE_BRICKS_CTM = register("simple_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_MOSSY_STONE_BRICKS_COLUMN = register("smooth_mossy_stone_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_MOSSY_STONE_BRICKS = register("thick_inlayed_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_MOSSY_STONE_BRICKS = register("tiled_bordered_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TILED_MOSSY_STONE_BRICKS_COLUMN = register("tiled_mossy_stone_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_MOSSY_STONE_BRICKS = register("tiny_brick_bordered_mossy_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));

    // ───── mud ─────
    public static final DeferredBlock<Block> BORDERED_MUD = register("bordered_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MUD = register("brick_bordered_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CARVED_MUD_CTM = register("carved_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CURLY_MUD_CTM = register("curly_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> EDGED_MUD = register("edged_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FANCY_MUD_CTM = register("fancy_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FINE_MUD_CTM = register("fine_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> HARD_MUD = register("hard_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> LARGE_MUD_SIGIL = register("large_mud_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> LOREFUL_MUD = register("loreful_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> ORNATE_MUD_CTM = register("ornate_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> OVERLAPPING_MUD_TILES = register("overlapping_mud_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> SCALY_MUD = register("scaly_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> SIMPLE_MUD_CTM = register("simple_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> TILED_BORDERED_MUD = register("tiled_bordered_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> TILED_MUD_COLUMN = register("tiled_mud_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));

    // ───── mud_bricks ─────
    public static final DeferredBlock<Block> BORDERED_MUD_BRICKS = register("bordered_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_MUD_BRICKS = register("brick_bordered_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> CARVED_MUD_BRICKS_CTM = register("carved_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> CURLY_MUD_BRICKS_CTM = register("curly_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> EDGED_MUD_BRICKS_BRICKS = register("edged_mud_bricks_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> EDGED_PACKED_MUD_BRICKS = register("edged_packed_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FANCY_MUD_BRICKS_CTM = register("fancy_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> FINE_MUD_BRICKS_CTM = register("fine_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> HARD_MUD_BRICKS = register("hard_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> LARGE_MUD_BRICKS_SIGIL = register("large_mud_bricks_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> LOREFUL_MUD_BRICKS = register("loreful_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_MUD_BRICKS = register("massive_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> MASSIVE_MUD_BRICKS_BRICKS = register("massive_mud_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_PACKED_MUD_BRICKS = register("massive_packed_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> ORNATE_MUD_BRICKS_CTM = register("ornate_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_MUD_BRICKS_TILES = register("overlapping_mud_bricks_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_MUD_BRICKS_CTM = register("simple_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_MUD_BRICKS = register("tiled_bordered_mud_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
    public static final DeferredBlock<Block> TILED_MUD_BRICKS_COLUMN = register("tiled_mud_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));

    // ───── nether_bricks ─────
    public static final DeferredBlock<Block> BORDERED_NETHER_BRICKS = register("bordered_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_NETHER_BRICKS = register("brick_bordered_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> CURLY_NETHER_BRICKS_CTM = register("curly_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> CUT_NETHER_BRICKS_COLUMN = register("cut_nether_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> EDGED_NETHER_BRICKS_BRICKS = register("edged_nether_bricks_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> FINE_NETHER_BRICKS_CTM = register("fine_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_NETHER_BRICKS_BRICKS = register("massive_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> NETHER_BRICKS_BEAMS = register("nether_bricks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_BRICK_PATTERN = register("nether_bricks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_BRICK_PAVING = register("nether_bricks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_CHISELED_SQUARES = register("nether_bricks_chiseled_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_DIAGONAL_BRICKS = register("nether_bricks_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_LARGE_BRICKS = register("nether_bricks_large_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_LARGE_TILES = register("nether_bricks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_ROTATED_BRICKS = register("nether_bricks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_SMALL_TILES = register("nether_bricks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_SMOOTH = register("nether_bricks_smooth_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_SQUARES = register("nether_bricks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHER_BRICKS_TILES = register("nether_bricks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORNATE_NETHER_BRICKS_CTM = register("ornate_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_NETHER_BRICKS_TILES = register("overlapping_nether_bricks_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_NETHER_BRICKS = register("polished_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SIMPLE_NETHER_BRICKS_CTM = register("simple_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_NETHER_BRICKS_COLUMN = register("smooth_nether_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_NETHER_BRICKS = register("thick_inlayed_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_NETHER_BRICKS = register("tiled_bordered_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_NETHER_BRICKS_COLUMN = register("tiled_nether_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_NETHER_BRICKS = register("tiny_brick_bordered_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));

    // ───── netherite_block ─────
    public static final DeferredBlock<Block> NETHERITE_BLOCK_BEAMS = register("netherite_block_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_BRICKS = register("netherite_block_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_CHISELED = register("netherite_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_COMPACTED = register("netherite_block_compacted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_DECORATED = register("netherite_block_decorated_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_DIAGONAL_TILES = register("netherite_block_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_INDENTED = register("netherite_block_indented_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_PATTERNED = register("netherite_block_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERITE_BLOCK_SMALL_TILES = register("netherite_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── netherrack ─────
    public static final DeferredBlock<Block> BORDERED_NETHERRACK = register("bordered_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_NETHERRACK = register("brick_bordered_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> CURLY_NETHERRACK_CTM = register("curly_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> CUT_NETHERRACK_COLUMN = register("cut_netherrack_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> EDGED_NETHERRACK_BRICKS = register("edged_netherrack_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> FINE_NETHERRACK_CTM = register("fine_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> MASSIVE_NETHERRACK_BRICKS = register("massive_netherrack_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> NETHERRACK_BEAMS = register("netherrack_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BRICK_PATTERN = register("netherrack_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BRICK_PAVING = register("netherrack_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_BRICKS = register("netherrack_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_DENTED = register("netherrack_dented_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_ROTATED_BRICKS = register("netherrack_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_SMALL_TILES = register("netherrack_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_STRIPES = register("netherrack_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NETHERRACK_TILES = register("netherrack_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORNATE_NETHERRACK_CTM = register("ornate_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> OVERLAPPING_NETHERRACK_TILES = register("overlapping_netherrack_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> POLISHED_NETHERRACK = register("polished_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> SIMPLE_NETHERRACK_CTM = register("simple_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> SMOOTH_NETHERRACK_COLUMN = register("smooth_netherrack_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> THICK_INLAYED_NETHERRACK = register("thick_inlayed_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TILED_BORDERED_NETHERRACK = register("tiled_bordered_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TILED_NETHERRACK_COLUMN = register("tiled_netherrack_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_NETHERRACK = register("tiny_brick_bordered_netherrack_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));

    // ───── oak_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_OAK_LEAVES = register("apple_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_OAK_LEAVES = register("cherry_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_OAK_LEAVES = register("dead_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_OAK_LEAVES = register("frosted_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_OAK_LEAVES = register("golden_apple_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_OAK_LEAVES = register("golden_cherry_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_OAK_LEAVES = register("golden_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_OAK_LEAVES = register("magenta_flower_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_OAK_LEAVES = register("orange_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_OAK_LEAVES = register("red_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_OAK_LEAVES = register("white_flower_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    // ───── oak_planks ─────
    public static final DeferredBlock<Block> CORNERED_OAK_PLANKS = register("cornered_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CRATED_OAK_PLANKS = register("crated_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_OAK_PLANKS = register("enclosed_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_OAK_PLANKS = register("framed_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_OAK_PLANKS = register("natural_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> OAK_PLANKS_BEAMS = register("oak_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BRICK_PATTERN = register("oak_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BRICK_PAVING = register("oak_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_BRICKS = register("oak_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_CRATE = register("oak_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_DIAGONAL_STRIPES = register("oak_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_DIAGONAL_TILES = register("oak_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_DOTTED = register("oak_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_FLOORING = register("oak_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_LARGE_TILES = register("oak_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_PANEL = register("oak_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> OAK_PLANKS_PATTERN = register("oak_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_ROTATED_BRICKS = register("oak_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_SMALL_BRICKS = register("oak_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_SMALL_TILES = register("oak_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_SQUARES = register("oak_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_TILES = register("oak_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_WAVY = register("oak_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OAK_PLANKS_WOVEN = register("oak_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PEGGED_OAK_PLANKS = register("pegged_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> WHIRLWIND_OAK_PLANKS = register("whirlwind_oak_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    // ───── obsidian ─────
    public static final DeferredBlock<Block> BORDERED_OBSIDIAN = register("bordered_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> BRICK_BORDERED_OBSIDIAN = register("brick_bordered_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> CURLY_OBSIDIAN_CTM = register("curly_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> CUT_OBSIDIAN_COLUMN = register("cut_obsidian_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> EDGED_OBSIDIAN_BRICKS = register("edged_obsidian_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> FINE_OBSIDIAN_CTM = register("fine_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> MASSIVE_OBSIDIAN_BRICKS = register("massive_obsidian_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> OBSIDIAN_BORDERED = register("obsidian_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_PATTERN = register("obsidian_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_PAVING = register("obsidian_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_BRICKS = register("obsidian_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_CHISELED_CIRCLES = register("obsidian_chiseled_circles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_CHISELED = register("obsidian_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_DARK = register("obsidian_dark_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_FRAMED_GLASS = register("obsidian_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> OBSIDIAN_ROTATED_BRICKS = register("obsidian_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_SPOTS = register("obsidian_spots_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_SQUARES = register("obsidian_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_STRIPES = register("obsidian_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OBSIDIAN_TILES = register("obsidian_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORNATE_OBSIDIAN_CTM = register("ornate_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> OVERLAPPING_OBSIDIAN_TILES = register("overlapping_obsidian_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN = register("polished_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> SIMPLE_OBSIDIAN_CTM = register("simple_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> SMOOTH_OBSIDIAN_COLUMN = register("smooth_obsidian_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> THICK_INLAYED_OBSIDIAN = register("thick_inlayed_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_BORDERED_OBSIDIAN = register("tiled_bordered_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TILED_OBSIDIAN_COLUMN = register("tiled_obsidian_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_OBSIDIAN = register("tiny_brick_bordered_obsidian_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

    // ───── ochre_froglight ─────
    public static final DeferredBlock<Block> GLASS_OCHRE_FROGLIGHT = register("glass_ochre_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<IronBarsBlock> GLASS_OCHRE_FROGLIGHT_PANE = register("glass_ochre_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // ───── ochrum ─────
    public static final DeferredBlock<Block> OCHRUM_CUT_POLISHED = register("ochrum_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> OCHRUM_CUT_SMALL_BRICK = register("ochrum_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── orange_concrete ─────
    public static final DeferredBlock<Block> GRILL_ORANGE_CONCRETE = register("grill_orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_CTM = register("orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_PANEL = register("orange_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_ORANGE_CONCRETE = register("pegged_orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_ORANGE_CONCRETE = register("smooth_orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_ORANGE_CONCRETE = register("striped_orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_ORANGE_CONCRETE = register("wired_orange_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));

    // ───── orange_marble ─────
    public static final DeferredBlock<Block> ORANGE_MARBLE = register("orange_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_BRICKS = register("orange_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR = register("orange_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_MARBLE_PILLAR_CAP = register("orange_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_SMALL_BRICKS = register("orange_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_MARBLE_TILES = register("orange_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> ORANGE_POLISHED_MARBLE = register("orange_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── orange_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_ORANGE_STAINED_GLASS_CTM = register("arched_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_ORANGE_STAINED_GLASS = register("circular_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_ORANGE_STAINED_GLASS = register("fancy_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_ORANGE_STAINED_GLASS_CTM = register("fancy_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_ORANGE_STAINED_GLASS = register("golden_framed_orange_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_ORANGE_STAINED_GLASS = register("large_diamond_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORANGE_LEADED_STAINED_GLASS = register("orange_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORANGE_STAINED_CLEAR_GLASS = register("orange_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORANGE_STAINED_GLASS = register("orange_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> ORNATE_ORANGE_STAINED_GLASS = register("ornate_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_ORANGE_STAINED_GLASS_CTM = register("ornate_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_ORANGE_STAINED_GLASS = register("raster_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_ORANGE_STAINED_GLASS_CTM = register("raster_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_ORANGE_DIAMOND_STAINED_GLASS = register("small_orange_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM = register("small_orange_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_ORANGE_STAINED_GLASS = register("square_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_ORANGE_STAINED_GLASS = register("tiled_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_ORANGE_STAINED_GLASS_CTM = register("tiled_orange_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_ORANGE_STAINED_GLASS = register("vertical_striped_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_ORANGE_STAINED_GLASS = register("woven_orange_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));

    // ───── orange_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_ORANGE_STAINED_GLASS_CTM_PANE = register("arched_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_ORANGE_STAINED_GLASS_PANE = register("circular_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_ORANGE_STAINED_GLASS_CTM_PANE = register("fancy_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_ORANGE_STAINED_GLASS_PANE = register("fancy_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_ORANGE_STAINED_GLASS_CTM_PANE = register("golden_framed_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_ORANGE_STAINED_GLASS_PANE = register("large_diamond_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORANGE_LEADED_STAINED_GLASS_PANE = register("orange_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORANGE_STAINED_CLEAR_GLASS_CTM_PANE = register("orange_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORANGE_STAINED_GLASS_CTM_PANE = register("orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_ORANGE_STAINED_GLASS_CTM_PANE = register("ornate_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_ORANGE_STAINED_GLASS_PANE = register("ornate_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_ORANGE_STAINED_GLASS_CTM_PANE = register("raster_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_ORANGE_STAINED_GLASS_PANE = register("raster_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_ORANGE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_orange_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_ORANGE_DIAMOND_STAINED_GLASS_PANE = register("small_orange_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_ORANGE_STAINED_GLASS_PANE = register("square_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_ORANGE_STAINED_GLASS_CTM_PANE = register("tiled_orange_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_ORANGE_STAINED_GLASS_PANE = register("tiled_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_ORANGE_STAINED_GLASS_PANE = register("vertical_striped_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_ORANGE_STAINED_GLASS_PANE = register("woven_orange_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── orange_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_ORANGE_TERRACOTTA = register("circular_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_ORANGE_TERRACOTTA = register("curled_orange_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_ORANGE_TERRACOTTA = register("hexagonical_orange_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_ORANGE_TERRACOTTA = register("inscribed_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_COLUMN = register("orange_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_CTM = register("orange_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_ORANGE_TERRACOTTA_TILES = register("small_orange_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_ORANGE_TERRACOTTA = register("starry_orange_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));

    // ───── oxidized_copper ─────
    public static final DeferredBlock<Block> OXIDIZED_COPPER_BLOCK = register("oxidized_copper_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── oxidized_copper_grate ─────
    public static final DeferredBlock<Block> OXIDIZED_COPPER_GRATE = register("oxidized_copper_grate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ───── packed_ice ─────
    public static final DeferredBlock<Block> BORDERED_PACKED_ICE = register("bordered_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PACKED_ICE = register("brick_bordered_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CURLY_PACKED_ICE_CTM = register("curly_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CUT_PACKED_ICE_COLUMN = register("cut_packed_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> EDGED_PACKED_ICE_BRICKS = register("edged_packed_ice_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> FINE_PACKED_ICE_CTM = register("fine_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> MASSIVE_PACKED_ICE_BRICKS = register("massive_packed_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> ORNATE_PACKED_ICE_CTM = register("ornate_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> OVERLAPPING_PACKED_ICE_TILES = register("overlapping_packed_ice_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> POLISHED_PACKED_ICE = register("polished_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> SIMPLE_PACKED_ICE_CTM = register("simple_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> SMOOTH_PACKED_ICE_COLUMN = register("smooth_packed_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> THICK_INLAYED_PACKED_ICE = register("thick_inlayed_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TILED_BORDERED_PACKED_ICE = register("tiled_bordered_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TILED_PACKED_ICE_COLUMN = register("tiled_packed_ice_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PACKED_ICE = register("tiny_brick_bordered_packed_ice_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));

    // ───── packed_mud ─────
    public static final DeferredBlock<Block> BORDERED_PACKED_MUD = register("bordered_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PACKED_MUD = register("brick_bordered_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> CARVED_PACKED_MUD_CTM = register("carved_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> CURLY_PACKED_MUD_CTM = register("curly_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FANCY_PACKED_MUD_CTM = register("fancy_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> FINE_PACKED_MUD_CTM = register("fine_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> HARD_PACKED_MUD = register("hard_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> LARGE_PACKED_MUD_SIGIL = register("large_packed_mud_sigil", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> LOREFUL_PACKED_MUD = register("loreful_packed_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> ORNATE_PACKED_MUD_CTM = register("ornate_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> OVERLAPPING_PACKED_MUD_TILES = register("overlapping_packed_mud_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> SCALY_PACKED_MUD = register("scaly_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> SIMPLE_PACKED_MUD_CTM = register("simple_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> TILED_BORDERED_PACKED_MUD = register("tiled_bordered_packed_mud_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
    public static final DeferredBlock<Block> TILED_PACKED_MUD_COLUMN = register("tiled_packed_mud_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));

    // ───── pale_oak_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_PALE_OAK_LEAVES = register("apple_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_PALE_OAK_LEAVES = register("cherry_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_PALE_OAK_LEAVES = register("dead_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_PALE_OAK_LEAVES = register("frosted_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_PALE_OAK_LEAVES = register("golden_apple_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_PALE_OAK_LEAVES = register("golden_cherry_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_PALE_OAK_LEAVES = register("golden_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_PALE_OAK_LEAVES = register("magenta_flower_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_PALE_OAK_LEAVES = register("orange_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_PALE_OAK_LEAVES = register("red_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_PALE_OAK_LEAVES = register("white_flower_pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    // ───── pale_oak_planks ─────
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BEAMS = register("pale_oak_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICK_PATTERN = register("pale_oak_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICK_PAVING = register("pale_oak_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_BRICKS = register("pale_oak_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_CRATE = register("pale_oak_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_DIAGONAL_STRIPES = register("pale_oak_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_DIAGONAL_TILES = register("pale_oak_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_DOTTED = register("pale_oak_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_FLOORING = register("pale_oak_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_LARGE_TILES = register("pale_oak_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_PATTERN = register("pale_oak_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_ROTATED_BRICKS = register("pale_oak_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_SMALL_BRICKS = register("pale_oak_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_SMALL_TILES = register("pale_oak_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_SQUARES = register("pale_oak_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_TILES = register("pale_oak_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_WAVY = register("pale_oak_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PALE_OAK_PLANKS_WOVEN = register("pale_oak_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── pearlescent_froglight ─────
    public static final DeferredBlock<Block> GLASS_PEARLESCENT_FROGLIGHT = register("glass_pearlescent_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<IronBarsBlock> GLASS_PEARLESCENT_FROGLIGHT_PANE = register("glass_pearlescent_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // ───── pink_concrete ─────
    public static final DeferredBlock<Block> GRILL_PINK_CONCRETE = register("grill_pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_PINK_CONCRETE = register("pegged_pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PINK_CONCRETE_CTM = register("pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> PINK_CONCRETE_PANEL = register("pink_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PINK_CONCRETE = register("smooth_pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_PINK_CONCRETE = register("striped_pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_PINK_CONCRETE = register("wired_pink_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // ───── pink_marble ─────
    public static final DeferredBlock<Block> PINK_MARBLE = register("pink_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_BRICKS = register("pink_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR = register("pink_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PINK_MARBLE_PILLAR_CAP = register("pink_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PINK_MARBLE_SMALL_BRICKS = register("pink_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_MARBLE_TILES = register("pink_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PINK_POLISHED_MARBLE = register("pink_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── pink_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_PINK_STAINED_GLASS_CTM = register("arched_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_PINK_STAINED_GLASS = register("circular_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PINK_STAINED_GLASS = register("fancy_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PINK_STAINED_GLASS_CTM = register("fancy_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_PINK_STAINED_GLASS = register("large_diamond_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PINK_STAINED_GLASS = register("ornate_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PINK_STAINED_GLASS_CTM = register("ornate_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> PINK_LEADED_STAINED_GLASS = register("pink_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> PINK_STAINED_CLEAR_GLASS = register("pink_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PINK_STAINED_GLASS = register("pink_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RASTER_PINK_STAINED_GLASS = register("raster_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PINK_STAINED_GLASS_CTM = register("raster_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PINK_DIAMOND_STAINED_GLASS = register("small_pink_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PINK_DIAMOND_STAINED_GLASS_CTM = register("small_pink_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_PINK_STAINED_GLASS = register("square_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PINK_STAINED_GLASS = register("tiled_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PINK_STAINED_GLASS_CTM = register("tiled_pink_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_PINK_STAINED_GLASS = register("vertical_striped_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_PINK_STAINED_GLASS = register("woven_pink_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));

    // ───── pink_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_PINK_STAINED_GLASS_CTM_PANE = register("arched_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_PINK_STAINED_GLASS_PANE = register("circular_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_PINK_STAINED_GLASS_CTM_PANE = register("fancy_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_PINK_STAINED_GLASS_PANE = register("fancy_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_PINK_STAINED_GLASS_CTM_PANE = register("golden_framed_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_PINK_STAINED_GLASS_PANE = register("large_diamond_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_PINK_STAINED_GLASS_CTM_PANE = register("ornate_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_PINK_STAINED_GLASS_PANE = register("ornate_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PINK_LEADED_STAINED_GLASS_PANE = register("pink_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PINK_STAINED_CLEAR_GLASS_CTM_PANE = register("pink_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PINK_STAINED_GLASS_CTM_PANE = register("pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_PINK_STAINED_GLASS_CTM_PANE = register("raster_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_PINK_STAINED_GLASS_PANE = register("raster_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_PINK_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_pink_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_PINK_DIAMOND_STAINED_GLASS_PANE = register("small_pink_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_PINK_STAINED_GLASS_PANE = register("square_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_PINK_STAINED_GLASS_CTM_PANE = register("tiled_pink_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_PINK_STAINED_GLASS_PANE = register("tiled_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_PINK_STAINED_GLASS_PANE = register("vertical_striped_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_PINK_STAINED_GLASS_PANE = register("woven_pink_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── pink_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_PINK_TERRACOTTA = register("circular_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_PINK_TERRACOTTA = register("curled_pink_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_PINK_TERRACOTTA = register("hexagonical_pink_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_PINK_TERRACOTTA = register("inscribed_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_COLUMN = register("pink_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_CTM = register("pink_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_PINK_TERRACOTTA_TILES = register("small_pink_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_PINK_TERRACOTTA = register("starry_pink_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));

    // ───── prismarine ─────
    public static final DeferredBlock<Block> BORDERED_PRISMARINE = register("bordered_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PRISMARINE = register("brick_bordered_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> CURLY_PRISMARINE_CTM = register("curly_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> CUT_PRISMARINE_COLUMN = register("cut_prismarine_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> FINE_PRISMARINE_CTM = register("fine_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> GRANITE_PRISMARINE = register("granite_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> ORNATE_PRISMARINE_CTM = register("ornate_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> OVERLAPPING_PRISMARINE_TILES = register("overlapping_prismarine_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> POLISHED_PRISMARINE = register("polished_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> SIMPLE_PRISMARINE_CTM = register("simple_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> SMOOTH_PRISMARINE_COLUMN = register("smooth_prismarine_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> THICK_INLAYED_PRISMARINE = register("thick_inlayed_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TILED_BORDERED_PRISMARINE = register("tiled_bordered_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TILED_PRISMARINE_COLUMN = register("tiled_prismarine_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PRISMARINE = register("tiny_brick_bordered_prismarine_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));

    // ───── prismarine_bricks ─────
    public static final DeferredBlock<Block> DARK_PRISMARINE_BRICKS = register("dark_prismarine_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> DARK_PRISMARINE_ROTATED_BRICKS = register("dark_prismarine_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_DARK_PRISMARINE_BRICKS = register("edged_dark_prismarine_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> EDGED_PRISMARINE_BRICKS = register("edged_prismarine_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> MASSIVE_DARK_PRISMARINE_BRICKS = register("massive_dark_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)));
    public static final DeferredBlock<Block> MASSIVE_PRISMARINE_BRICKS = register("massive_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BEAMS = register("prismarine_bricks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BRICK_PATTERN = register("prismarine_bricks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BRICK_PAVING = register("prismarine_bricks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_BRICKS = register("prismarine_bricks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_CHISELED_CIRCLES = register("prismarine_bricks_chiseled_circles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_CHISELED_SQUARES = register("prismarine_bricks_chiseled_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_DIAGONAL_BRICKS = register("prismarine_bricks_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_DIAGONAL_TILES = register("prismarine_bricks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_DOTTED = register("prismarine_bricks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_PILLARS = register("prismarine_bricks_pillars_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_ROTATED_BRICKS = register("prismarine_bricks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_ROWS = register("prismarine_bricks_rows_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_SMALL_TILES = register("prismarine_bricks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_SQUARES = register("prismarine_bricks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_TILES = register("prismarine_bricks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_WAVY = register("prismarine_bricks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PRISMARINE_BRICKS_WOVEN = register("prismarine_bricks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── purple_concrete ─────
    public static final DeferredBlock<Block> GRILL_PURPLE_CONCRETE = register("grill_purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_PURPLE_CONCRETE = register("pegged_purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_CTM = register("purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_PANEL = register("purple_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_PURPLE_CONCRETE = register("smooth_purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_PURPLE_CONCRETE = register("striped_purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_PURPLE_CONCRETE = register("wired_purple_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));

    // ───── purple_marble ─────
    public static final DeferredBlock<Block> PURPLE_MARBLE = register("purple_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_BRICKS = register("purple_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR = register("purple_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> PURPLE_MARBLE_PILLAR_CAP = register("purple_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_SMALL_BRICKS = register("purple_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_MARBLE_TILES = register("purple_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> PURPLE_POLISHED_MARBLE = register("purple_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── purple_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_PURPLE_STAINED_GLASS_CTM = register("arched_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_PURPLE_STAINED_GLASS = register("circular_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PURPLE_STAINED_GLASS = register("fancy_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_PURPLE_STAINED_GLASS_CTM = register("fancy_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_PURPLE_STAINED_GLASS = register("golden_framed_purple_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_PURPLE_STAINED_GLASS = register("large_diamond_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PURPLE_STAINED_GLASS = register("ornate_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_PURPLE_STAINED_GLASS_CTM = register("ornate_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> PURPLE_LEADED_STAINED_GLASS = register("purple_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> PURPLE_STAINED_CLEAR_GLASS = register("purple_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> PURPLE_STAINED_GLASS = register("purple_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RASTER_PURPLE_STAINED_GLASS = register("raster_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_PURPLE_STAINED_GLASS_CTM = register("raster_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PURPLE_DIAMOND_STAINED_GLASS = register("small_purple_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM = register("small_purple_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_PURPLE_STAINED_GLASS = register("square_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PURPLE_STAINED_GLASS = register("tiled_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_PURPLE_STAINED_GLASS_CTM = register("tiled_purple_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_PURPLE_STAINED_GLASS = register("vertical_striped_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_PURPLE_STAINED_GLASS = register("woven_purple_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));

    // ───── purple_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_PURPLE_STAINED_GLASS_CTM_PANE = register("arched_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_PURPLE_STAINED_GLASS_PANE = register("circular_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_PURPLE_STAINED_GLASS_CTM_PANE = register("fancy_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_PURPLE_STAINED_GLASS_PANE = register("fancy_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_PURPLE_STAINED_GLASS_CTM_PANE = register("golden_framed_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_PURPLE_STAINED_GLASS_PANE = register("large_diamond_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_PURPLE_STAINED_GLASS_CTM_PANE = register("ornate_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_PURPLE_STAINED_GLASS_PANE = register("ornate_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PURPLE_LEADED_STAINED_GLASS_PANE = register("purple_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PURPLE_STAINED_CLEAR_GLASS_CTM_PANE = register("purple_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PURPLE_STAINED_GLASS_CTM_PANE = register("purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_PURPLE_STAINED_GLASS_CTM_PANE = register("raster_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_PURPLE_STAINED_GLASS_PANE = register("raster_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_PURPLE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_purple_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_PURPLE_DIAMOND_STAINED_GLASS_PANE = register("small_purple_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_PURPLE_STAINED_GLASS_PANE = register("square_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_PURPLE_STAINED_GLASS_CTM_PANE = register("tiled_purple_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_PURPLE_STAINED_GLASS_PANE = register("tiled_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_PURPLE_STAINED_GLASS_PANE = register("vertical_striped_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_PURPLE_STAINED_GLASS_PANE = register("woven_purple_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── purple_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_PURPLE_TERRACOTTA = register("circular_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_PURPLE_TERRACOTTA = register("curled_purple_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_PURPLE_TERRACOTTA = register("hexagonical_purple_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_PURPLE_TERRACOTTA = register("inscribed_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_COLUMN = register("purple_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_CTM = register("purple_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_PURPLE_TERRACOTTA_TILES = register("small_purple_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_PURPLE_TERRACOTTA = register("starry_purple_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));

    // ───── purpur_block ─────
    public static final DeferredBlock<Block> BORDERED_PURPUR_BLOCK = register("bordered_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_PURPUR_BLOCK = register("brick_bordered_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> CURLY_PURPUR_BLOCK_CTM = register("curly_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> CUT_PURPUR_BLOCK_COLUMN = register("cut_purpur_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> EDGED_PURPUR_BLOCK_BRICKS = register("edged_purpur_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> FINE_PURPUR_BLOCK_CTM = register("fine_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_PURPUR_BLOCK_BRICKS = register("massive_purpur_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_PURPUR_BLOCK_CTM = register("ornate_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_PURPUR_BLOCK_TILES = register("overlapping_purpur_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_PURPUR_BLOCK = register("polished_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_PURPUR_BLOCK_CTM = register("simple_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_PURPUR_BLOCK_COLUMN = register("smooth_purpur_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_PURPUR_BLOCK = register("thick_inlayed_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_PURPUR_BLOCK = register("tiled_bordered_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TILED_PURPUR_BLOCK_COLUMN = register("tiled_purpur_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_PURPUR_BLOCK = register("tiny_brick_bordered_purpur_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));

    // ───── quartz_block ─────
    public static final DeferredBlock<Block> BORDERED_QUARTZ_BLOCK = register("bordered_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_QUARTZ_BLOCK = register("brick_bordered_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> CURLY_QUARTZ_BLOCK_CTM = register("curly_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> CUT_QUARTZ_BLOCK_COLUMN = register("cut_quartz_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> EDGED_QUARTZ_BLOCK_BRICKS = register("edged_quartz_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> FINE_QUARTZ_BLOCK_CTM = register("fine_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_QUARTZ_BLOCK_BRICKS = register("massive_quartz_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_QUARTZ_BLOCK_CTM = register("ornate_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_QUARTZ_BLOCK_TILES = register("overlapping_quartz_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_QUARTZ_BLOCK = register("polished_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_BORDERED = register("quartz_block_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_BRICK_PAVING = register("quartz_block_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_CHISELED_CTM = register("quartz_block_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_CROSSES = register("quartz_block_crosses_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_CONNECTING = register("quartz_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_DIAGONAL_TILES = register("quartz_block_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_PATTERN = register("quartz_block_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_ROTATED_BRICKS = register("quartz_block_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_ROWS = register("quartz_block_rows_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_SCALES = register("quartz_block_scales_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_SMALL_TILES = register("quartz_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_SQUARES = register("quartz_block_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_STRIPES = register("quartz_block_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> QUARTZ_BLOCK_TILES = register("quartz_block_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_POLISHED_BLOCK = register("rose_quartz_polished_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SIMPLE_QUARTZ_BLOCK_CTM = register("simple_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_QUARTZ_BLOCK_COLUMN = register("smooth_quartz_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_QUARTZ_BLOCK = register("thick_inlayed_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_QUARTZ_BLOCK = register("tiled_bordered_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TILED_QUARTZ_BLOCK_COLUMN = register("tiled_quartz_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_QUARTZ_BLOCK = register("tiny_brick_bordered_quartz_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));

    // ───── raw_copper_block ─────
    public static final DeferredBlock<Block> BORDERED_RAW_COPPER_BLOCK = register("bordered_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_COPPER_BLOCK = register("brick_bordered_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_COPPER_BLOCK_CTM = register("curly_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_COPPER_BLOCK_COLUMN = register("cut_raw_copper_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_COPPER_BLOCK_BRICKS = register("edged_raw_copper_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_COPPER_BLOCK_CTM = register("fine_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_COPPER_BLOCK_BRICKS = register("massive_raw_copper_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_COPPER_BLOCK_CTM = register("ornate_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_COPPER_BLOCK_TILES = register("overlapping_raw_copper_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_COPPER_BLOCK = register("polished_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_COPPER_BLOCK_CTM = register("simple_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_COPPER_BLOCK_COLUMN = register("smooth_raw_copper_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_COPPER_BLOCK = register("thick_inlayed_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_COPPER_BLOCK = register("tiled_bordered_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_COPPER_BLOCK_COLUMN = register("tiled_raw_copper_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_COPPER_BLOCK = register("tiny_brick_bordered_raw_copper_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_COPPER_BLOCK)));

    // ───── raw_gold_block ─────
    public static final DeferredBlock<Block> BORDERED_RAW_GOLD_BLOCK = register("bordered_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_GOLD_BLOCK = register("brick_bordered_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_GOLD_BLOCK_CTM = register("curly_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_GOLD_BLOCK_COLUMN = register("cut_raw_gold_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_GOLD_BLOCK_BRICKS = register("edged_raw_gold_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_GOLD_BLOCK_CTM = register("fine_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_GOLD_BLOCK_BRICKS = register("massive_raw_gold_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_GOLD_BLOCK_CTM = register("ornate_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_GOLD_BLOCK_TILES = register("overlapping_raw_gold_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_GOLD_BLOCK = register("polished_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_GOLD_BLOCK_CTM = register("simple_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_GOLD_BLOCK_COLUMN = register("smooth_raw_gold_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_GOLD_BLOCK = register("thick_inlayed_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_GOLD_BLOCK = register("tiled_bordered_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_GOLD_BLOCK_COLUMN = register("tiled_raw_gold_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_GOLD_BLOCK = register("tiny_brick_bordered_raw_gold_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK)));

    // ───── raw_iron_block ─────
    public static final DeferredBlock<Block> BORDERED_RAW_IRON_BLOCK = register("bordered_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RAW_IRON_BLOCK = register("brick_bordered_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> CURLY_RAW_IRON_BLOCK_CTM = register("curly_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> CUT_RAW_IRON_BLOCK_COLUMN = register("cut_raw_iron_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> EDGED_RAW_IRON_BLOCK_BRICKS = register("edged_raw_iron_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> FINE_RAW_IRON_BLOCK_CTM = register("fine_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_RAW_IRON_BLOCK_BRICKS = register("massive_raw_iron_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_RAW_IRON_BLOCK_CTM = register("ornate_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_RAW_IRON_BLOCK_TILES = register("overlapping_raw_iron_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_RAW_IRON_BLOCK = register("polished_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_RAW_IRON_BLOCK_CTM = register("simple_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_RAW_IRON_BLOCK_COLUMN = register("smooth_raw_iron_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_RAW_IRON_BLOCK = register("thick_inlayed_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_RAW_IRON_BLOCK = register("tiled_bordered_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TILED_RAW_IRON_BLOCK_COLUMN = register("tiled_raw_iron_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RAW_IRON_BLOCK = register("tiny_brick_bordered_raw_iron_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));

    // ───── red_concrete ─────
    public static final DeferredBlock<Block> GRILL_RED_CONCRETE = register("grill_red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_RED_CONCRETE = register("pegged_red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> RED_CONCRETE_CTM = register("red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> RED_CONCRETE_PANEL = register("red_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_RED_CONCRETE = register("smooth_red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_RED_CONCRETE = register("striped_red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_RED_CONCRETE = register("wired_red_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));

    // ───── red_marble ─────
    public static final DeferredBlock<Block> RED_MARBLE = register("red_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_BRICKS = register("red_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR = register("red_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> RED_MARBLE_PILLAR_CAP = register("red_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_MARBLE_SMALL_BRICKS = register("red_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_MARBLE_TILES = register("red_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> RED_POLISHED_MARBLE = register("red_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── red_nether_bricks ─────
    public static final DeferredBlock<Block> BORDERED_RED_NETHER_BRICKS = register("bordered_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RED_NETHER_BRICKS = register("brick_bordered_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> CURLY_RED_NETHER_BRICKS_CTM = register("curly_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> CUT_RED_NETHER_BRICKS_COLUMN = register("cut_red_nether_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> EDGED_RED_NETHER_BRICKS_BRICKS = register("edged_red_nether_bricks_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> FINE_RED_NETHER_BRICKS_CTM = register("fine_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> MASSIVE_RED_NETHER_BRICKS_BRICKS = register("massive_red_nether_bricks_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> ORNATE_RED_NETHER_BRICKS_CTM = register("ornate_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> OVERLAPPING_RED_NETHER_BRICKS_TILES = register("overlapping_red_nether_bricks_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> POLISHED_RED_NETHER_BRICKS = register("polished_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_BEAMS = register("red_nether_bricks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_BRICK_PATTERN = register("red_nether_bricks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_BRICK_PAVING = register("red_nether_bricks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_CHISELED_SQUARES = register("red_nether_bricks_chiseled_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_DIAGONAL_BRICKS = register("red_nether_bricks_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_LARGE_BRICKS = register("red_nether_bricks_large_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_LARGE_TILES = register("red_nether_bricks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_ROTATED_BRICKS = register("red_nether_bricks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_SMALL_TILES = register("red_nether_bricks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_SMOOTH = register("red_nether_bricks_smooth_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_SQUARES = register("red_nether_bricks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_NETHER_BRICKS_TILES = register("red_nether_bricks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SIMPLE_RED_NETHER_BRICKS_CTM = register("simple_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> SMOOTH_RED_NETHER_BRICKS_COLUMN = register("smooth_red_nether_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> THICK_INLAYED_RED_NETHER_BRICKS = register("thick_inlayed_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_BORDERED_RED_NETHER_BRICKS = register("tiled_bordered_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TILED_RED_NETHER_BRICKS_COLUMN = register("tiled_red_nether_bricks_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RED_NETHER_BRICKS = register("tiny_brick_bordered_red_nether_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS)));

    // ───── red_sandstone ─────
    public static final DeferredBlock<Block> BORDERED_RED_SANDSTONE = register("bordered_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_RED_SANDSTONE = register("brick_bordered_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CURLY_RED_SANDSTONE_CTM = register("curly_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CUT_RED_SANDSTONE_COLUMN = register("cut_red_sandstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> CUT_RED_SANDSTONE = register("cut_red_sandstone_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_RED_SANDSTONE_BRICKS = register("edged_red_sandstone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> FINE_RED_SANDSTONE_CTM = register("fine_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> MASSIVE_RED_SANDSTONE_BRICKS = register("massive_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> ORNATE_RED_SANDSTONE_CTM = register("ornate_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_RED_SANDSTONE_TILES = register("overlapping_red_sandstone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_RED_SANDSTONE = register("polished_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_BRICK_PATTERN = register("red_sandstone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_BRICK_PAVING = register("red_sandstone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_BRICKS = register("red_sandstone_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_DIAGONAL_BRICKS = register("red_sandstone_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_FRAMED_GLASS = register("red_sandstone_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<CtmPaneBlock> RED_SANDSTONE_FRAMED_GLASS_CTM_PANE = register("red_sandstone_framed_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> RED_SANDSTONE_LARGE_TILES = register("red_sandstone_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_ROTATED_BRICKS = register("red_sandstone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RED_SANDSTONE_TILES = register("red_sandstone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SIMPLE_RED_SANDSTONE_CTM = register("simple_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_RED_SANDSTONE = register("thick_inlayed_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_RED_SANDSTONE = register("tiled_bordered_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TILED_RED_SANDSTONE_COLUMN = register("tiled_red_sandstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_RED_SANDSTONE = register("tiny_brick_bordered_red_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));

    // ───── red_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_RED_STAINED_GLASS_CTM = register("arched_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_RED_STAINED_GLASS = register("circular_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_RED_STAINED_GLASS = register("fancy_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_RED_STAINED_GLASS_CTM = register("fancy_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_RED_STAINED_GLASS = register("large_diamond_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_RED_STAINED_GLASS = register("ornate_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_RED_STAINED_GLASS_CTM = register("ornate_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_RED_STAINED_GLASS = register("raster_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_RED_STAINED_GLASS_CTM = register("raster_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RED_LEADED_STAINED_GLASS = register("red_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> RED_STAINED_CLEAR_GLASS = register("red_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> RED_STAINED_GLASS = register("red_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SMALL_RED_DIAMOND_STAINED_GLASS = register("small_red_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_RED_DIAMOND_STAINED_GLASS_CTM = register("small_red_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_RED_STAINED_GLASS = register("square_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_RED_STAINED_GLASS = register("tiled_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_RED_STAINED_GLASS_CTM = register("tiled_red_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_RED_STAINED_GLASS = register("vertical_striped_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_RED_STAINED_GLASS = register("woven_red_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));

    // ───── red_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_RED_STAINED_GLASS_CTM_PANE = register("arched_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_RED_STAINED_GLASS_PANE = register("circular_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_RED_STAINED_GLASS_CTM_PANE = register("fancy_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_RED_STAINED_GLASS_PANE = register("fancy_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_RED_STAINED_GLASS_CTM_PANE = register("golden_framed_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_RED_STAINED_GLASS_PANE = register("large_diamond_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_RED_STAINED_GLASS_CTM_PANE = register("ornate_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_RED_STAINED_GLASS_PANE = register("ornate_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_RED_STAINED_GLASS_CTM_PANE = register("raster_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_RED_STAINED_GLASS_PANE = register("raster_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RED_LEADED_STAINED_GLASS_PANE = register("red_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RED_STAINED_CLEAR_GLASS_CTM_PANE = register("red_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RED_STAINED_GLASS_CTM_PANE = register("red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_RED_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_red_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_RED_DIAMOND_STAINED_GLASS_PANE = register("small_red_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_RED_STAINED_GLASS_PANE = register("square_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_RED_STAINED_GLASS_CTM_PANE = register("tiled_red_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_RED_STAINED_GLASS_PANE = register("tiled_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_RED_STAINED_GLASS_PANE = register("vertical_striped_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_RED_STAINED_GLASS_PANE = register("woven_red_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── red_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_RED_TERRACOTTA = register("circular_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_RED_TERRACOTTA = register("curled_red_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_RED_TERRACOTTA = register("hexagonical_red_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_RED_TERRACOTTA = register("inscribed_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_COLUMN = register("red_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_CTM = register("red_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_RED_TERRACOTTA_TILES = register("small_red_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_RED_TERRACOTTA = register("starry_red_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));

    // ───── redstone_block ─────
    public static final DeferredBlock<Block> BORDERED_REDSTONE_BLOCK = register("bordered_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_REDSTONE_BLOCK = register("brick_bordered_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> CURLY_REDSTONE_BLOCK_CTM = register("curly_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> CUT_REDSTONE_BLOCK_COLUMN = register("cut_redstone_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> EDGED_REDSTONE_BLOCK_BRICKS = register("edged_redstone_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> FINE_REDSTONE_BLOCK_CTM = register("fine_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_REDSTONE_BLOCK_BRICKS = register("massive_redstone_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_REDSTONE_BLOCK_CTM = register("ornate_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_REDSTONE_BLOCK_TILES = register("overlapping_redstone_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_REDSTONE_BLOCK = register("polished_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_BORDERED = register("redstone_block_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_BRICKS = register("redstone_block_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_CHISELED_CLOVERS = register("redstone_block_chiseled_clovers_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_CIRCLES = register("redstone_block_circles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_COMPRESSED = register("redstone_block_compressed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_CTM = register("redstone_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_DIAGONAL_TILES = register("redstone_block_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PATTERNED = register("redstone_block_patterned_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PAVING = register("redstone_block_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_SCALES = register("redstone_block_scales_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> REDSTONE_BLOCK_SMALL_TILES = register("redstone_block_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SIMPLE_REDSTONE_BLOCK_CTM = register("simple_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_REDSTONE_BLOCK_COLUMN = register("smooth_redstone_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_REDSTONE_BLOCK = register("thick_inlayed_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_REDSTONE_BLOCK = register("tiled_bordered_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TILED_REDSTONE_BLOCK_COLUMN = register("tiled_redstone_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_REDSTONE_BLOCK = register("tiny_brick_bordered_redstone_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));

    // ───── rose_quartz ─────
    public static final DeferredBlock<Block> ROSE_QUARTZ_BRICKS = register("rose_quartz_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CHISELED = register("rose_quartz_chiseled_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CRUSHED = register("rose_quartz_crushed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_SQUARES = register("rose_quartz_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_TILES = register("rose_quartz_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── sandstone ─────
    public static final DeferredBlock<Block> BORDERED_SANDSTONE = register("bordered_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SANDSTONE = register("brick_bordered_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CURLY_SANDSTONE_CTM = register("curly_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CUT_SANDSTONE_COLUMN = register("cut_sandstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CUT_SANDSTONE = register("cut_sandstone_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> EDGED_SANDSTONE_BRICKS = register("edged_sandstone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> FINE_SANDSTONE_CTM = register("fine_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> MASSIVE_SANDSTONE_BRICKS = register("massive_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> ORNATE_SANDSTONE_CTM = register("ornate_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> OVERLAPPING_SANDSTONE_TILES = register("overlapping_sandstone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_SANDSTONE = register("polished_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SANDSTONE_BRICK_PATTERN = register("sandstone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_BRICK_PAVING = register("sandstone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_BRICKS = register("sandstone_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_DIAGONAL_BRICKS = register("sandstone_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_FRAMED_GLASS = register("sandstone_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> SANDSTONE_LARGE_TILES = register("sandstone_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_ROTATED_BRICKS = register("sandstone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SANDSTONE_SLENDER_BRICKS = register("sandstone_slender_bricks", () -> new Block(Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SANDSTONE_SLENDER_TURQUOISE_PATTERN = register("sandstone_slender_turquoise_pattern", () -> new Block(Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SANDSTONE_TILES = register("sandstone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SIMPLE_SANDSTONE_CTM = register("simple_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_SANDSTONE = register("thick_inlayed_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_SANDSTONE = register("tiled_bordered_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TILED_SANDSTONE_COLUMN = register("tiled_sandstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SANDSTONE = register("tiny_brick_bordered_sandstone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    // ───── scorchia ─────
    public static final DeferredBlock<Block> SCORCHIA_CUT_POLISHED = register("scorchia_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SCORCHIA_CUT_SMALL_BRICK = register("scorchia_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── scoria ─────
    public static final DeferredBlock<Block> SCORIA_CUT_POLISHED = register("scoria_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SCORIA_CUT_SMALL_BRICK = register("scoria_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── sea_lantern ─────
    public static final DeferredBlock<Block> SEA_LANTERN = register("sea_lantern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── smooth_sandstone ─────
    public static final DeferredBlock<Block> SMOOTH_RED_SANDSTONE_COLUMN = register("smooth_red_sandstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
    public static final DeferredBlock<Block> SMOOTH_SANDSTONE_COLUMN = register("smooth_sandstone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    // ───── smooth_stone ─────
    public static final DeferredBlock<Block> BORDERED_SMOOTH_STONE = register("bordered_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SMOOTH_STONE = register("brick_bordered_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> CURLY_SMOOTH_STONE_CTM = register("curly_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> CUT_SMOOTH_STONE_COLUMN = register("cut_smooth_stone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> FINE_SMOOTH_STONE_CTM = register("fine_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> ORNATE_SMOOTH_STONE_CTM = register("ornate_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> OVERLAPPING_SMOOTH_STONE_TILES = register("overlapping_smooth_stone_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> POLISHED_SMOOTH_STONE = register("polished_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> SIMPLE_SMOOTH_STONE_CTM = register("simple_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> SMOOTH_END_STONE_COLUMN = register("smooth_end_stone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
    public static final DeferredBlock<Block> SMOOTH_SMOOTH_STONE_COLUMN = register("smooth_smooth_stone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_BRICK_PAVING = register("stone_smooth_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH = register("stone_smooth_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_LARGE_TILES = register("stone_smooth_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_TILES = register("stone_smooth_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> THICK_INLAYED_SMOOTH_STONE = register("thick_inlayed_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TILED_BORDERED_SMOOTH_STONE = register("tiled_bordered_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TILED_SMOOTH_STONE_COLUMN = register("tiled_smooth_stone_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SMOOTH_STONE = register("tiny_brick_bordered_smooth_stone_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));

    // ───── snow_block ─────
    public static final DeferredBlock<Block> BORDERED_SNOW_BLOCK = register("bordered_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> BRICK_BORDERED_SNOW_BLOCK = register("brick_bordered_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> CURLY_SNOW_BLOCK_CTM = register("curly_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> CUT_SNOW_BLOCK_COLUMN = register("cut_snow_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> EDGED_SNOW_BLOCK_BRICKS = register("edged_snow_block_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> FINE_SNOW_BLOCK_CTM = register("fine_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> MASSIVE_SNOW_BLOCK_BRICKS = register("massive_snow_block_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> ORNATE_SNOW_BLOCK_CTM = register("ornate_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> OVERLAPPING_SNOW_BLOCK_TILES = register("overlapping_snow_block_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_SNOW_BLOCK = register("polished_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> SIMPLE_SNOW_BLOCK_CTM = register("simple_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> SMOOTH_SNOW_BLOCK_COLUMN = register("smooth_snow_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> THICK_INLAYED_SNOW_BLOCK = register("thick_inlayed_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TILED_BORDERED_SNOW_BLOCK = register("tiled_bordered_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TILED_SNOW_BLOCK_COLUMN = register("tiled_snow_block_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_SNOW_BLOCK = register("tiny_brick_bordered_snow_block_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));

    // ───── spruce_leaves ─────
    public static final DeferredBlock<LeavesBlock> APPLE_SPRUCE_LEAVES = register("apple_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> CHERRY_SPRUCE_LEAVES = register("cherry_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> DEAD_SPRUCE_LEAVES = register("dead_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> FROSTED_SPRUCE_LEAVES = register("frosted_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_APPLE_SPRUCE_LEAVES = register("golden_apple_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_CHERRY_SPRUCE_LEAVES = register("golden_cherry_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> GOLDEN_SPRUCE_LEAVES = register("golden_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> MAGENTA_FLOWER_SPRUCE_LEAVES = register("magenta_flower_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> ORANGE_SPRUCE_LEAVES = register("orange_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> RED_SPRUCE_LEAVES = register("red_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));
    public static final DeferredBlock<LeavesBlock> WHITE_FLOWER_SPRUCE_LEAVES = register("white_flower_spruce_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)));

    // ───── spruce_planks ─────
    public static final DeferredBlock<Block> CORNERED_SPRUCE_PLANKS = register("cornered_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> CRATED_SPRUCE_PLANKS = register("crated_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_SPRUCE_PLANKS = register("enclosed_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_SPRUCE_PLANKS = register("framed_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_SPRUCE_PLANKS = register("natural_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_SPRUCE_PLANKS = register("pegged_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BEAMS = register("spruce_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BRICK_PATTERN = register("spruce_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BRICK_PAVING = register("spruce_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_BRICKS = register("spruce_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_CRATE = register("spruce_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_DIAGONAL_STRIPES = register("spruce_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_DIAGONAL_TILES = register("spruce_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_DOTTED = register("spruce_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_FLOORING = register("spruce_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_LARGE_TILES = register("spruce_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_PANEL = register("spruce_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_PATTERN = register("spruce_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_ROTATED_BRICKS = register("spruce_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SMALL_BRICKS = register("spruce_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SMALL_TILES = register("spruce_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_SQUARES = register("spruce_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_TILES = register("spruce_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_WAVY = register("spruce_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> SPRUCE_PLANKS_WOVEN = register("spruce_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHIRLWIND_SPRUCE_PLANKS = register("whirlwind_spruce_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));

    // ───── stone ─────
    public static final DeferredBlock<RotatedPillarBlock> CHISELED_PLASTERED_STONE_PILLAR = register("chiseled_plastered_stone_pillar", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> CUT_BLANK_STONE = register("cut_blank_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> CUT_STONE = register("cut_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<Block> FRENCH_STONE = register("french_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> LARGE_ORNATE_STONE = register("large_ornate_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> LARGE_STONE_TILE = register("large_stone_tile", () -> new Block(ST));
    public static final DeferredBlock<Block> MESSY_STONE_TILES = register("messy_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> MOSAIC_STONE = register("mosaic_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> ORNATE_STONE = register("ornate_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> POISON_STONE = register("poison_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> POLISHED_CUT_STONE = register("polished_cut_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> POLISHED_STONE_TILES = register("polished_stone_tiles", () -> new Block(ST));
    public static final DeferredBlock<Block> PRISM_STONE = register("prism_stone", () -> new Block(ST));
    public static final DeferredBlock<RotatedPillarBlock> ROUGH_CUT_STONE = register("rough_cut_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<RotatedPillarBlock> SHEARED_STONE_PILLAR = register("sheared_stone_pillar", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<Block> SLANTED_STONE = register("slanted_stone", () -> new Block(ST));
    public static final DeferredBlock<RotatedPillarBlock> SLATED_STONE = register("slated_stone", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<Block> STONE_ARRAY = register("stone_array", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_BIG_TILES = register("stone_big_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BORDERED = register("stone_bordered_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BRAID = register("stone_braid", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_BRICK_PATTERN = register("stone_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_BRICK_PAVING = register("stone_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> STONE_COLUMN = register("stone_column", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<Block> STONE_CRUSHED = register("stone_crushed_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_DENT = register("stone_dent", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_FRAMED_GLASS = register("stone_framed_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> STONE_JELLYBEAN = register("stone_jellybean", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_LAYERS = register("stone_layers", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_PANEL = register("stone_panel", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_PATH = register("stone_path_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_ROAD = register("stone_road", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_SMALL_TILES = register("stone_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SQUARES = register("stone_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_TILES = register("stone_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> STONE_TWISTING_COLUMN = register("stone_twisting_column", () -> new RotatedPillarBlock(ST));
    public static final DeferredBlock<Block> STONE_WAVES = register("stone_waves_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_ZAG = register("stone_zag", () -> new Block(ST));
    public static final DeferredBlock<Block> SUNKEN_STONE = register("sunken_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> WEATHERED_TILED_STONE = register("weathered_tiled_stone", () -> new Block(ST));
    public static final DeferredBlock<Block> WEAVER_STONE = register("weaver_stone", () -> new Block(ST));

    // ───── stone_bricks ─────
    public static final DeferredBlock<Block> CHAOTIC_MEDIUM_STONE_BRICKS = register("chaotic_medium_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> CHAOTIC_SMALL_STONE_BRICKS = register("chaotic_small_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> CHAOTIC_STONE_BRICKS = register("chaotic_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> EDGED_SMOOTH_STONE_BRICKS = register("edged_smooth_stone_bricks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> ENCASED_STONE_BRICKS = register("encased_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> MASSIVE_SMOOTH_STONE_BRICKS = register("massive_smooth_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE)));
    public static final DeferredBlock<Block> MASSIVE_STONE_BRICKS = register("massive_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> NOTCHED_STONE_BRICKS = register("notched_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> STONE_BRICKS_MASONRY = register("stone_bricks_masonry", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> STONE_CHISELED_BRICKS = register("stone_chiseled_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_DIAGONAL_BRICKS = register("stone_diagonal_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_ROTATED_BRICKS = register("stone_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMALL_BRICKS = register("stone_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> STONE_SMOOTH_ROTATED_BRICKS = register("stone_smooth_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> TRIPLE_STONE_BRICKS = register("triple_stone_bricks", () -> new Block(ST));
    public static final DeferredBlock<Block> WEATHERED_STONE_BRICKS = register("weathered_stone_bricks", () -> new Block(ST));

    // ───── terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_TERRACOTTA = register("circular_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_TERRACOTTA = register("curled_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_TERRACOTTA = register("hexagonical_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_TERRACOTTA = register("inscribed_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_TERRACOTTA_TILES = register("small_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_TERRACOTTA = register("starry_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> TERRACOTTA_COLUMN = register("terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> TERRACOTTA_CTM = register("terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));

    // ───── tinted_glass ─────
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_BLACK = register("tinted_borderless_glass_black_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_BLUE = register("tinted_borderless_glass_blue_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_BROWN = register("tinted_borderless_glass_brown_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS = register("tinted_borderless_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_CYAN = register("tinted_borderless_glass_cyan_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_GRAY = register("tinted_borderless_glass_gray_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_GREEN = register("tinted_borderless_glass_green_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_LIGHT_BLUE = register("tinted_borderless_glass_light_blue_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_LIGHT_GRAY = register("tinted_borderless_glass_light_gray_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_LIME = register("tinted_borderless_glass_lime_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_MAGENTA = register("tinted_borderless_glass_magenta_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_ORANGE = register("tinted_borderless_glass_orange_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_PINK = register("tinted_borderless_glass_pink_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_PURPLE = register("tinted_borderless_glass_purple_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_RED = register("tinted_borderless_glass_red_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_WHITE = register("tinted_borderless_glass_white_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_BORDERLESS_GLASS_YELLOW = register("tinted_borderless_glass_yellow_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_CLEAR_GLASS = register("tinted_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> TINTED_GLASS = register("tinted_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));

    // ───── tinted_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_BLACK_CTM_PANE = register("tinted_borderless_glass_black_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_BLUE_CTM_PANE = register("tinted_borderless_glass_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_BROWN_CTM_PANE = register("tinted_borderless_glass_brown_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_CTM_PANE = register("tinted_borderless_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_CYAN_CTM_PANE = register("tinted_borderless_glass_cyan_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_GRAY_CTM_PANE = register("tinted_borderless_glass_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_GREEN_CTM_PANE = register("tinted_borderless_glass_green_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_LIGHT_BLUE_CTM_PANE = register("tinted_borderless_glass_light_blue_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_LIGHT_GRAY_CTM_PANE = register("tinted_borderless_glass_light_gray_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_LIME_CTM_PANE = register("tinted_borderless_glass_lime_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_MAGENTA_CTM_PANE = register("tinted_borderless_glass_magenta_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_ORANGE_CTM_PANE = register("tinted_borderless_glass_orange_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_PINK_CTM_PANE = register("tinted_borderless_glass_pink_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_PURPLE_CTM_PANE = register("tinted_borderless_glass_purple_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_RED_CTM_PANE = register("tinted_borderless_glass_red_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_WHITE_CTM_PANE = register("tinted_borderless_glass_white_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_BORDERLESS_GLASS_YELLOW_CTM_PANE = register("tinted_borderless_glass_yellow_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_CLEAR_GLASS_CTM_PANE = register("tinted_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TINTED_GLASS_CTM_PANE = register("tinted_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    // ───── tuff ─────
    public static final DeferredBlock<Block> BORDERED_TUFF = register("bordered_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> BRICK_BORDERED_TUFF = register("brick_bordered_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> CURLY_TUFF_CTM = register("curly_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> CUT_TUFF_COLUMN = register("cut_tuff_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> FINE_TUFF_CTM = register("fine_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> ORNATE_TUFF_CTM = register("ornate_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> OVERLAPPING_TUFF_TILES = register("overlapping_tuff_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> POLISHED_TUFF = register("polished_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> SIMPLE_TUFF_CTM = register("simple_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> SMOOTH_TUFF_COLUMN = register("smooth_tuff_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> THICK_INLAYED_TUFF = register("thick_inlayed_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TILED_BORDERED_TUFF = register("tiled_bordered_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TILED_TUFF_COLUMN = register("tiled_tuff_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TINY_BRICK_BORDERED_TUFF = register("tiny_brick_bordered_tuff_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
    public static final DeferredBlock<Block> TUFF_CUT_POLISHED = register("tuff_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> TUFF_CUT_SMALL_BRICK = register("tuff_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── verdant_froglight ─────
    public static final DeferredBlock<Block> GLASS_VERDANT_FROGLIGHT = register("glass_verdant_froglight", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion().lightLevel(s -> 15)));
    public static final DeferredBlock<IronBarsBlock> GLASS_VERDANT_FROGLIGHT_PANE = register("glass_verdant_froglight_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion().lightLevel(s -> 15)));

    // ───── veridium ─────
    public static final DeferredBlock<Block> VERIDIUM_CUT_POLISHED = register("veridium_cut_polished_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> VERIDIUM_CUT_SMALL_BRICK = register("veridium_cut_small_brick_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── warped_planks ─────
    public static final DeferredBlock<Block> CORNERED_WARPED_PLANKS = register("cornered_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> CRATED_WARPED_PLANKS = register("crated_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> ENCLOSED_WARPED_PLANKS = register("enclosed_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> FRAMED_WARPED_PLANKS = register("framed_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> NATURAL_WARPED_PLANKS = register("natural_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> PEGGED_WARPED_PLANKS = register("pegged_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BEAMS = register("warped_planks_beams_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BRICK_PATTERN = register("warped_planks_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BRICK_PAVING = register("warped_planks_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_BRICKS = register("warped_planks_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_CRATE = register("warped_planks_crate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_DIAGONAL_STRIPES = register("warped_planks_diagonal_stripes_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_DIAGONAL_TILES = register("warped_planks_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_DOTTED = register("warped_planks_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_FLOORING = register("warped_planks_flooring_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_LARGE_TILES = register("warped_planks_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_PANEL = register("warped_planks_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WARPED_PLANKS_PATTERN = register("warped_planks_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_ROTATED_BRICKS = register("warped_planks_rotated_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_SMALL_BRICKS = register("warped_planks_small_bricks_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_SMALL_TILES = register("warped_planks_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_SQUARES = register("warped_planks_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_TILES = register("warped_planks_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_WAVY = register("warped_planks_wavy_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WARPED_PLANKS_WOVEN = register("warped_planks_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHIRLWIND_WARPED_PLANKS = register("whirlwind_warped_planks_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // ───── weathered_copper ─────
    public static final DeferredBlock<Block> WEATHERED_COPPER_BLOCK = register("weathered_copper_block_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── weathered_copper_grate ─────
    public static final DeferredBlock<Block> WEATHERED_COPPER_GRATE = register("weathered_copper_grate_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // ───── white_concrete ─────
    public static final DeferredBlock<Block> GRILL_WHITE_CONCRETE = register("grill_white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_WHITE_CONCRETE = register("pegged_white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_WHITE_CONCRETE = register("smooth_white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_WHITE_CONCRETE = register("striped_white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_CTM = register("white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_PANEL = register("white_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_WHITE_CONCRETE = register("wired_white_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    // ───── white_marble ─────
    public static final DeferredBlock<Block> WHITE_MARBLE = register("white_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_BRICKS = register("white_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR = register("white_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> WHITE_MARBLE_PILLAR_CAP = register("white_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> WHITE_MARBLE_SMALL_BRICKS = register("white_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_MARBLE_TILES = register("white_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> WHITE_POLISHED_MARBLE = register("white_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── white_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_WHITE_STAINED_GLASS_CTM = register("arched_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_WHITE_STAINED_GLASS = register("circular_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_WHITE_STAINED_GLASS = register("fancy_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_WHITE_STAINED_GLASS_CTM = register("fancy_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_WHITE_STAINED_GLASS = register("large_diamond_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_WHITE_STAINED_GLASS = register("ornate_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_WHITE_STAINED_GLASS_CTM = register("ornate_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_WHITE_STAINED_GLASS = register("raster_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_WHITE_STAINED_GLASS_CTM = register("raster_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_WHITE_DIAMOND_STAINED_GLASS = register("small_white_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM = register("small_white_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_WHITE_STAINED_GLASS = register("square_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_WHITE_STAINED_GLASS = register("tiled_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_WHITE_STAINED_GLASS_CTM = register("tiled_white_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_WHITE_STAINED_GLASS = register("vertical_striped_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WHITE_LEADED_STAINED_GLASS = register("white_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> WHITE_STAINED_CLEAR_GLASS = register("white_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WHITE_STAINED_GLASS = register("white_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WOVEN_WHITE_STAINED_GLASS = register("woven_white_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));

    // ───── white_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_WHITE_STAINED_GLASS_CTM_PANE = register("arched_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_WHITE_STAINED_GLASS_PANE = register("circular_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_WHITE_STAINED_GLASS_CTM_PANE = register("fancy_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_WHITE_STAINED_GLASS_PANE = register("fancy_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_WHITE_STAINED_GLASS_CTM_PANE = register("golden_framed_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_WHITE_STAINED_GLASS_PANE = register("large_diamond_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_WHITE_STAINED_GLASS_CTM_PANE = register("ornate_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_WHITE_STAINED_GLASS_PANE = register("ornate_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_WHITE_STAINED_GLASS_CTM_PANE = register("raster_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_WHITE_STAINED_GLASS_PANE = register("raster_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_WHITE_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_white_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_WHITE_DIAMOND_STAINED_GLASS_PANE = register("small_white_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_WHITE_STAINED_GLASS_PANE = register("square_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_WHITE_STAINED_GLASS_CTM_PANE = register("tiled_white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_WHITE_STAINED_GLASS_PANE = register("tiled_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_WHITE_STAINED_GLASS_PANE = register("vertical_striped_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WHITE_LEADED_STAINED_GLASS_PANE = register("white_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WHITE_STAINED_CLEAR_GLASS_CTM_PANE = register("white_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WHITE_STAINED_GLASS_CTM_PANE = register("white_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_WHITE_STAINED_GLASS_PANE = register("woven_white_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));

    // ───── white_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_WHITE_TERRACOTTA = register("circular_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_WHITE_TERRACOTTA = register("curled_white_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_WHITE_TERRACOTTA = register("hexagonical_white_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_WHITE_TERRACOTTA = register("inscribed_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_WHITE_TERRACOTTA_TILES = register("small_white_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_WHITE_TERRACOTTA = register("starry_white_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_COLUMN = register("white_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_CTM = register("white_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));

    // ───── yellow_concrete ─────
    public static final DeferredBlock<Block> GRILL_YELLOW_CONCRETE = register("grill_yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> PEGGED_YELLOW_CONCRETE = register("pegged_yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> SMOOTH_YELLOW_CONCRETE = register("smooth_yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> STRIPED_YELLOW_CONCRETE = register("striped_yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> WIRED_YELLOW_CONCRETE = register("wired_yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_CTM = register("yellow_concrete_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_PANEL = register("yellow_concrete_panel_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));

    // ───── yellow_marble ─────
    public static final DeferredBlock<Block> YELLOW_MARBLE = register("yellow_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_BRICKS = register("yellow_marble_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR = register("yellow_marble_pillar", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<RotatedPillarBlock> YELLOW_MARBLE_PILLAR_CAP = register("yellow_marble_pillar_cap", () -> new RotatedPillarBlock(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_SMALL_BRICKS = register("yellow_marble_small_bricks", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_MARBLE_TILES = register("yellow_marble_tiles", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> YELLOW_POLISHED_MARBLE = register("yellow_polished_marble", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));

    // ───── yellow_stained_glass ─────
    public static final DeferredBlock<Block> ARCHED_YELLOW_STAINED_GLASS_CTM = register("arched_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> CIRCULAR_YELLOW_STAINED_GLASS = register("circular_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_YELLOW_STAINED_GLASS = register("fancy_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> FANCY_YELLOW_STAINED_GLASS_CTM = register("fancy_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> GOLDEN_FRAMED_YELLOW_STAINED_GLASS = register("golden_framed_yellow_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> LARGE_DIAMOND_YELLOW_STAINED_GLASS = register("large_diamond_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_YELLOW_STAINED_GLASS = register("ornate_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORNATE_YELLOW_STAINED_GLASS_CTM = register("ornate_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_YELLOW_STAINED_GLASS = register("raster_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> RASTER_YELLOW_STAINED_GLASS_CTM = register("raster_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_YELLOW_DIAMOND_STAINED_GLASS = register("small_yellow_diamond_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM = register("small_yellow_diamond_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> SQUARE_YELLOW_STAINED_GLASS = register("square_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_YELLOW_STAINED_GLASS = register("tiled_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> TILED_YELLOW_STAINED_GLASS_CTM = register("tiled_yellow_stained_glass_ctm", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> VERTICAL_STRIPED_YELLOW_STAINED_GLASS = register("vertical_striped_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> WOVEN_YELLOW_STAINED_GLASS = register("woven_yellow_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> YELLOW_LEADED_STAINED_GLASS = register("yellow_leaded_stained_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> YELLOW_STAINED_CLEAR_GLASS = register("yellow_stained_clear_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> YELLOW_STAINED_GLASS = register("yellow_stained_glass_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.GLASS)));

    // ───── yellow_stained_glass_pane ─────
    public static final DeferredBlock<CtmPaneBlock> ARCHED_YELLOW_STAINED_GLASS_CTM_PANE = register("arched_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CIRCULAR_YELLOW_STAINED_GLASS_PANE = register("circular_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> FANCY_YELLOW_STAINED_GLASS_CTM_PANE = register("fancy_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> FANCY_YELLOW_STAINED_GLASS_PANE = register("fancy_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> GOLDEN_FRAMED_YELLOW_STAINED_GLASS_CTM_PANE = register("golden_framed_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> LARGE_DIAMOND_YELLOW_STAINED_GLASS_PANE = register("large_diamond_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ORNATE_YELLOW_STAINED_GLASS_CTM_PANE = register("ornate_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ORNATE_YELLOW_STAINED_GLASS_PANE = register("ornate_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> RASTER_YELLOW_STAINED_GLASS_CTM_PANE = register("raster_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> RASTER_YELLOW_STAINED_GLASS_PANE = register("raster_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SMALL_YELLOW_DIAMOND_STAINED_GLASS_CTM_PANE = register("small_yellow_diamond_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SMALL_YELLOW_DIAMOND_STAINED_GLASS_PANE = register("small_yellow_diamond_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SQUARE_YELLOW_STAINED_GLASS_PANE = register("square_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> TILED_YELLOW_STAINED_GLASS_CTM_PANE = register("tiled_yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> TILED_YELLOW_STAINED_GLASS_PANE = register("tiled_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> VERTICAL_STRIPED_YELLOW_STAINED_GLASS_PANE = register("vertical_striped_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WOVEN_YELLOW_STAINED_GLASS_PANE = register("woven_yellow_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> YELLOW_LEADED_STAINED_GLASS_PANE = register("yellow_leaded_stained_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> YELLOW_STAINED_CLEAR_GLASS_CTM_PANE = register("yellow_stained_clear_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> YELLOW_STAINED_GLASS_CTM_PANE = register("yellow_stained_glass_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    // ───── yellow_terracotta ─────
    public static final DeferredBlock<Block> CIRCULAR_YELLOW_TERRACOTTA = register("circular_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> CURLED_YELLOW_TERRACOTTA = register("curled_yellow_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> HEXAGONICAL_YELLOW_TERRACOTTA = register("hexagonical_yellow_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> INSCRIBED_YELLOW_TERRACOTTA = register("inscribed_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> SMALL_YELLOW_TERRACOTTA_TILES = register("small_yellow_terracotta_tiles_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> STARRY_YELLOW_TERRACOTTA = register("starry_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_COLUMN = register("yellow_terracotta_column_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_CTM = register("yellow_terracotta_ctm", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));

    // ───── windows (by wood type) ─────
    public static final DeferredBlock<Block> ACACIA_WINDOW_BARS = register("acacia_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_BARS_CTM = register("acacia_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_BARS_CTM_PANE = register("acacia_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_BARS_PANE = register("acacia_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_COVERED = register("acacia_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_COVERED_CTM = register("acacia_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_COVERED_CTM_PANE = register("acacia_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_COVERED_PANE = register("acacia_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_DIAGONAL = register("acacia_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_DIAGONAL_CTM = register("acacia_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_DIAGONAL_CTM_PANE = register("acacia_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_DIAGONAL_PANE = register("acacia_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_LARGE = register("acacia_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_LARGE_CTM = register("acacia_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_LARGE_CTM_PANE = register("acacia_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_LARGE_PANE = register("acacia_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_PANES = register("acacia_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_PANES_CTM = register("acacia_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_PANES_CTM_PANE = register("acacia_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_PANES_PANE = register("acacia_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_ROUNDED = register("acacia_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_ROUNDED_CTM = register("acacia_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_ROUNDED_CTM_PANE = register("acacia_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_ROUNDED_PANE = register("acacia_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SLIM = register("acacia_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SLIM_CTM = register("acacia_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_SLIM_CTM_PANE = register("acacia_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_SLIM_PANE = register("acacia_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SWIRLING = register("acacia_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_SWIRLING_CTM = register("acacia_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_SWIRLING_CTM_PANE = register("acacia_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_SWIRLING_PANE = register("acacia_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_TILES = register("acacia_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WINDOW_TILES_CTM = register("acacia_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> ACACIA_WINDOW_TILES_CTM_PANE = register("acacia_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> ACACIA_WINDOW_TILES_PANE = register("acacia_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_BARS = register("bamboo_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_BARS_CTM = register("bamboo_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_BARS_CTM_PANE = register("bamboo_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_BARS_PANE = register("bamboo_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_COVERED = register("bamboo_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_COVERED_CTM = register("bamboo_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_COVERED_CTM_PANE = register("bamboo_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_COVERED_PANE = register("bamboo_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_DIAGONAL = register("bamboo_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_DIAGONAL_CTM = register("bamboo_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_DIAGONAL_CTM_PANE = register("bamboo_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_DIAGONAL_PANE = register("bamboo_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_LARGE = register("bamboo_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_LARGE_CTM = register("bamboo_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_LARGE_CTM_PANE = register("bamboo_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_LARGE_PANE = register("bamboo_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_PANES = register("bamboo_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_PANES_CTM = register("bamboo_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_PANES_CTM_PANE = register("bamboo_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_PANES_PANE = register("bamboo_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_ROUNDED = register("bamboo_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_ROUNDED_CTM = register("bamboo_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_ROUNDED_CTM_PANE = register("bamboo_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_ROUNDED_PANE = register("bamboo_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SLIM = register("bamboo_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SLIM_CTM = register("bamboo_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_SLIM_CTM_PANE = register("bamboo_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_SLIM_PANE = register("bamboo_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SWIRLING = register("bamboo_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_SWIRLING_CTM = register("bamboo_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_SWIRLING_CTM_PANE = register("bamboo_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_SWIRLING_PANE = register("bamboo_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_TILES = register("bamboo_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BAMBOO_WINDOW_TILES_CTM = register("bamboo_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BAMBOO_WINDOW_TILES_CTM_PANE = register("bamboo_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BAMBOO_WINDOW_TILES_PANE = register("bamboo_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_BARS = register("birch_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_BARS_CTM = register("birch_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_BARS_CTM_PANE = register("birch_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_BARS_PANE = register("birch_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_COVERED = register("birch_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_COVERED_CTM = register("birch_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_COVERED_CTM_PANE = register("birch_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_COVERED_PANE = register("birch_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_DIAGONAL = register("birch_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_DIAGONAL_CTM = register("birch_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_DIAGONAL_CTM_PANE = register("birch_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_DIAGONAL_PANE = register("birch_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_LARGE = register("birch_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_LARGE_CTM = register("birch_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_LARGE_CTM_PANE = register("birch_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_LARGE_PANE = register("birch_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_PANES = register("birch_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_PANES_CTM = register("birch_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_PANES_CTM_PANE = register("birch_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_PANES_PANE = register("birch_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_ROUNDED = register("birch_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_ROUNDED_CTM = register("birch_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_ROUNDED_CTM_PANE = register("birch_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_ROUNDED_PANE = register("birch_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SLIM = register("birch_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SLIM_CTM = register("birch_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_SLIM_CTM_PANE = register("birch_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_SLIM_PANE = register("birch_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SWIRLING = register("birch_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_SWIRLING_CTM = register("birch_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_SWIRLING_CTM_PANE = register("birch_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_SWIRLING_PANE = register("birch_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_TILES = register("birch_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WINDOW_TILES_CTM = register("birch_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> BIRCH_WINDOW_TILES_CTM_PANE = register("birch_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> BIRCH_WINDOW_TILES_PANE = register("birch_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_BARS = register("cherry_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_BARS_CTM = register("cherry_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_BARS_CTM_PANE = register("cherry_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_BARS_PANE = register("cherry_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_COVERED = register("cherry_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_COVERED_CTM = register("cherry_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_COVERED_CTM_PANE = register("cherry_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_COVERED_PANE = register("cherry_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_DIAGONAL = register("cherry_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_DIAGONAL_CTM = register("cherry_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_DIAGONAL_CTM_PANE = register("cherry_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_DIAGONAL_PANE = register("cherry_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_LARGE = register("cherry_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_LARGE_CTM = register("cherry_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_LARGE_CTM_PANE = register("cherry_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_LARGE_PANE = register("cherry_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_PANES = register("cherry_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_PANES_CTM = register("cherry_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_PANES_CTM_PANE = register("cherry_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_PANES_PANE = register("cherry_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_ROUNDED = register("cherry_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_ROUNDED_CTM = register("cherry_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_ROUNDED_CTM_PANE = register("cherry_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_ROUNDED_PANE = register("cherry_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SLIM = register("cherry_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SLIM_CTM = register("cherry_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_SLIM_CTM_PANE = register("cherry_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_SLIM_PANE = register("cherry_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SWIRLING = register("cherry_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_SWIRLING_CTM = register("cherry_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_SWIRLING_CTM_PANE = register("cherry_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_SWIRLING_PANE = register("cherry_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_TILES = register("cherry_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WINDOW_TILES_CTM = register("cherry_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CHERRY_WINDOW_TILES_CTM_PANE = register("cherry_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CHERRY_WINDOW_TILES_PANE = register("cherry_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_BARS = register("crimson_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_BARS_CTM = register("crimson_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_BARS_CTM_PANE = register("crimson_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_BARS_PANE = register("crimson_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_COVERED = register("crimson_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_COVERED_CTM = register("crimson_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_COVERED_CTM_PANE = register("crimson_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_COVERED_PANE = register("crimson_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_DIAGONAL = register("crimson_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_DIAGONAL_CTM = register("crimson_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_DIAGONAL_CTM_PANE = register("crimson_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_DIAGONAL_PANE = register("crimson_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_LARGE = register("crimson_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_LARGE_CTM = register("crimson_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_LARGE_CTM_PANE = register("crimson_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_LARGE_PANE = register("crimson_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_PANES = register("crimson_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_PANES_CTM = register("crimson_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_PANES_CTM_PANE = register("crimson_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_PANES_PANE = register("crimson_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_ROUNDED = register("crimson_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_ROUNDED_CTM = register("crimson_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_ROUNDED_CTM_PANE = register("crimson_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_ROUNDED_PANE = register("crimson_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SLIM = register("crimson_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SLIM_CTM = register("crimson_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_SLIM_CTM_PANE = register("crimson_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_SLIM_PANE = register("crimson_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SWIRLING = register("crimson_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_SWIRLING_CTM = register("crimson_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_SWIRLING_CTM_PANE = register("crimson_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_SWIRLING_PANE = register("crimson_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_TILES = register("crimson_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WINDOW_TILES_CTM = register("crimson_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> CRIMSON_WINDOW_TILES_CTM_PANE = register("crimson_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> CRIMSON_WINDOW_TILES_PANE = register("crimson_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_BARS = register("dark_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_BARS_CTM = register("dark_oak_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_BARS_CTM_PANE = register("dark_oak_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_BARS_PANE = register("dark_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_COVERED = register("dark_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_COVERED_CTM = register("dark_oak_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_COVERED_CTM_PANE = register("dark_oak_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_COVERED_PANE = register("dark_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_DIAGONAL = register("dark_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_DIAGONAL_CTM = register("dark_oak_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_DIAGONAL_CTM_PANE = register("dark_oak_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_DIAGONAL_PANE = register("dark_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_LARGE = register("dark_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_LARGE_CTM = register("dark_oak_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_LARGE_CTM_PANE = register("dark_oak_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_LARGE_PANE = register("dark_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_PANES = register("dark_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_PANES_CTM = register("dark_oak_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_PANES_CTM_PANE = register("dark_oak_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_PANES_PANE = register("dark_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_ROUNDED = register("dark_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_ROUNDED_CTM = register("dark_oak_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_ROUNDED_CTM_PANE = register("dark_oak_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_ROUNDED_PANE = register("dark_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SLIM = register("dark_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SLIM_CTM = register("dark_oak_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_SLIM_CTM_PANE = register("dark_oak_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_SLIM_PANE = register("dark_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SWIRLING = register("dark_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_SWIRLING_CTM = register("dark_oak_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_SWIRLING_CTM_PANE = register("dark_oak_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_SWIRLING_PANE = register("dark_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_TILES = register("dark_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WINDOW_TILES_CTM = register("dark_oak_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> DARK_OAK_WINDOW_TILES_CTM_PANE = register("dark_oak_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> DARK_OAK_WINDOW_TILES_PANE = register("dark_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_BARS = register("jungle_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_BARS_CTM = register("jungle_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_BARS_CTM_PANE = register("jungle_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_BARS_PANE = register("jungle_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_COVERED = register("jungle_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_COVERED_CTM = register("jungle_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_COVERED_CTM_PANE = register("jungle_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_COVERED_PANE = register("jungle_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_DIAGONAL = register("jungle_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_DIAGONAL_CTM = register("jungle_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_DIAGONAL_CTM_PANE = register("jungle_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_DIAGONAL_PANE = register("jungle_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_LARGE = register("jungle_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_LARGE_CTM = register("jungle_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_LARGE_CTM_PANE = register("jungle_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_LARGE_PANE = register("jungle_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_PANES = register("jungle_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_PANES_CTM = register("jungle_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_PANES_CTM_PANE = register("jungle_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_PANES_PANE = register("jungle_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_ROUNDED = register("jungle_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_ROUNDED_CTM = register("jungle_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_ROUNDED_CTM_PANE = register("jungle_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_ROUNDED_PANE = register("jungle_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SLIM = register("jungle_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SLIM_CTM = register("jungle_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_SLIM_CTM_PANE = register("jungle_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_SLIM_PANE = register("jungle_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SWIRLING = register("jungle_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_SWIRLING_CTM = register("jungle_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_SWIRLING_CTM_PANE = register("jungle_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_SWIRLING_PANE = register("jungle_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_TILES = register("jungle_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WINDOW_TILES_CTM = register("jungle_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> JUNGLE_WINDOW_TILES_CTM_PANE = register("jungle_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> JUNGLE_WINDOW_TILES_PANE = register("jungle_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_BARS = register("mangrove_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_BARS_CTM = register("mangrove_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_BARS_CTM_PANE = register("mangrove_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_BARS_PANE = register("mangrove_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_COVERED = register("mangrove_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_COVERED_CTM = register("mangrove_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_COVERED_CTM_PANE = register("mangrove_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_COVERED_PANE = register("mangrove_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_DIAGONAL = register("mangrove_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_DIAGONAL_CTM = register("mangrove_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_DIAGONAL_CTM_PANE = register("mangrove_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_DIAGONAL_PANE = register("mangrove_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_LARGE = register("mangrove_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_LARGE_CTM = register("mangrove_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_LARGE_CTM_PANE = register("mangrove_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_LARGE_PANE = register("mangrove_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_PANES = register("mangrove_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_PANES_CTM = register("mangrove_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_PANES_CTM_PANE = register("mangrove_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_PANES_PANE = register("mangrove_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_ROUNDED = register("mangrove_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_ROUNDED_CTM = register("mangrove_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_ROUNDED_CTM_PANE = register("mangrove_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_ROUNDED_PANE = register("mangrove_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SLIM = register("mangrove_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SLIM_CTM = register("mangrove_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_SLIM_CTM_PANE = register("mangrove_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_SLIM_PANE = register("mangrove_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SWIRLING = register("mangrove_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_SWIRLING_CTM = register("mangrove_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_SWIRLING_CTM_PANE = register("mangrove_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_SWIRLING_PANE = register("mangrove_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_TILES = register("mangrove_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WINDOW_TILES_CTM = register("mangrove_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> MANGROVE_WINDOW_TILES_CTM_PANE = register("mangrove_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> MANGROVE_WINDOW_TILES_PANE = register("mangrove_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_BARS = register("oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_BARS_CTM = register("oak_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_BARS_CTM_PANE = register("oak_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_BARS_PANE = register("oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_COVERED = register("oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_COVERED_CTM = register("oak_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_COVERED_CTM_PANE = register("oak_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_COVERED_PANE = register("oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_DIAGONAL = register("oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_DIAGONAL_CTM = register("oak_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_DIAGONAL_CTM_PANE = register("oak_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_DIAGONAL_PANE = register("oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_LARGE = register("oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_LARGE_CTM = register("oak_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_LARGE_CTM_PANE = register("oak_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_LARGE_PANE = register("oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_PANES = register("oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_PANES_CTM = register("oak_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_PANES_CTM_PANE = register("oak_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_PANES_PANE = register("oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_ROUNDED = register("oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_ROUNDED_CTM = register("oak_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_ROUNDED_CTM_PANE = register("oak_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_ROUNDED_PANE = register("oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SLIM = register("oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SLIM_CTM = register("oak_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_SLIM_CTM_PANE = register("oak_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_SLIM_PANE = register("oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SWIRLING = register("oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_SWIRLING_CTM = register("oak_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_SWIRLING_CTM_PANE = register("oak_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_SWIRLING_PANE = register("oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_TILES = register("oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OAK_WINDOW_TILES_CTM = register("oak_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> OAK_WINDOW_TILES_CTM_PANE = register("oak_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> OAK_WINDOW_TILES_PANE = register("oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS = register("pale_oak_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_BARS_CTM = register("pale_oak_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_BARS_CTM_PANE = register("pale_oak_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_BARS_PANE = register("pale_oak_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED = register("pale_oak_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_COVERED_CTM = register("pale_oak_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_COVERED_CTM_PANE = register("pale_oak_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_COVERED_PANE = register("pale_oak_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL = register("pale_oak_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_DIAGONAL_CTM = register("pale_oak_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_DIAGONAL_CTM_PANE = register("pale_oak_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_DIAGONAL_PANE = register("pale_oak_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE = register("pale_oak_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_LARGE_CTM = register("pale_oak_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_LARGE_CTM_PANE = register("pale_oak_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_LARGE_PANE = register("pale_oak_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES = register("pale_oak_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_PANES_CTM = register("pale_oak_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_PANES_CTM_PANE = register("pale_oak_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_PANES_PANE = register("pale_oak_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED = register("pale_oak_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_ROUNDED_CTM = register("pale_oak_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_ROUNDED_CTM_PANE = register("pale_oak_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_ROUNDED_PANE = register("pale_oak_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM = register("pale_oak_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SLIM_CTM = register("pale_oak_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_SLIM_CTM_PANE = register("pale_oak_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SLIM_PANE = register("pale_oak_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING = register("pale_oak_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_SWIRLING_CTM = register("pale_oak_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_SWIRLING_CTM_PANE = register("pale_oak_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_SWIRLING_PANE = register("pale_oak_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES = register("pale_oak_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> PALE_OAK_WINDOW_TILES_CTM = register("pale_oak_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> PALE_OAK_WINDOW_TILES_CTM_PANE = register("pale_oak_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> PALE_OAK_WINDOW_TILES_PANE = register("pale_oak_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_BARS = register("spruce_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_BARS_CTM = register("spruce_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_BARS_CTM_PANE = register("spruce_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_BARS_PANE = register("spruce_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_COVERED = register("spruce_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_COVERED_CTM = register("spruce_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_COVERED_CTM_PANE = register("spruce_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_COVERED_PANE = register("spruce_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_DIAGONAL = register("spruce_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_DIAGONAL_CTM = register("spruce_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_DIAGONAL_CTM_PANE = register("spruce_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_DIAGONAL_PANE = register("spruce_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_LARGE = register("spruce_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_LARGE_CTM = register("spruce_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_LARGE_CTM_PANE = register("spruce_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_LARGE_PANE = register("spruce_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_PANES = register("spruce_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_PANES_CTM = register("spruce_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_PANES_CTM_PANE = register("spruce_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_PANES_PANE = register("spruce_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_ROUNDED = register("spruce_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_ROUNDED_CTM = register("spruce_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_ROUNDED_CTM_PANE = register("spruce_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_ROUNDED_PANE = register("spruce_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SLIM = register("spruce_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SLIM_CTM = register("spruce_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_SLIM_CTM_PANE = register("spruce_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_SLIM_PANE = register("spruce_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SWIRLING = register("spruce_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_SWIRLING_CTM = register("spruce_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_SWIRLING_CTM_PANE = register("spruce_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_SWIRLING_PANE = register("spruce_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_TILES = register("spruce_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WINDOW_TILES_CTM = register("spruce_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> SPRUCE_WINDOW_TILES_CTM_PANE = register("spruce_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> SPRUCE_WINDOW_TILES_PANE = register("spruce_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_BARS = register("warped_window_bars", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_BARS_CTM = register("warped_window_bars_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_BARS_CTM_PANE = register("warped_window_bars_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_BARS_PANE = register("warped_window_bars_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_COVERED = register("warped_window_covered", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_COVERED_CTM = register("warped_window_covered_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_COVERED_CTM_PANE = register("warped_window_covered_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_COVERED_PANE = register("warped_window_covered_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_DIAGONAL = register("warped_window_diagonal", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_DIAGONAL_CTM = register("warped_window_diagonal_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_DIAGONAL_CTM_PANE = register("warped_window_diagonal_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_DIAGONAL_PANE = register("warped_window_diagonal_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_LARGE = register("warped_window_large", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_LARGE_CTM = register("warped_window_large_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_LARGE_CTM_PANE = register("warped_window_large_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_LARGE_PANE = register("warped_window_large_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_PANES = register("warped_window_panes", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_PANES_CTM = register("warped_window_panes_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_PANES_CTM_PANE = register("warped_window_panes_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_PANES_PANE = register("warped_window_panes_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_ROUNDED = register("warped_window_rounded", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_ROUNDED_CTM = register("warped_window_rounded_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_ROUNDED_CTM_PANE = register("warped_window_rounded_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_ROUNDED_PANE = register("warped_window_rounded_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SLIM = register("warped_window_slim", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SLIM_CTM = register("warped_window_slim_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_SLIM_CTM_PANE = register("warped_window_slim_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_SLIM_PANE = register("warped_window_slim_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SWIRLING = register("warped_window_swirling", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_SWIRLING_CTM = register("warped_window_swirling_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_SWIRLING_CTM_PANE = register("warped_window_swirling_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_SWIRLING_PANE = register("warped_window_swirling_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_TILES = register("warped_window_tiles", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WINDOW_TILES_CTM = register("warped_window_tiles_ctm", () -> new TransparentBlock(Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<CtmPaneBlock> WARPED_WINDOW_TILES_CTM_PANE = register("warped_window_tiles_ctm_pane", () -> new CtmPaneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));
    public static final DeferredBlock<IronBarsBlock> WARPED_WINDOW_TILES_PANE = register("warped_window_tiles_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).noOcclusion()));

    // ───── misc ─────
    public static final DeferredBlock<Block> AIR_MOSAIC_BORDER = register("air_mosaic_border", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_DELICATE = register("air_mosaic_delicate", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_GEOMETRIC = register("air_mosaic_geometric", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_PATTERN = register("air_mosaic_pattern", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AIR_MOSAIC_TRADITIONAL = register("air_mosaic_traditional", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BAMBOO_THATCH = register("bamboo_thatch", () -> new Block(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_BORDER = register("earth_mosaic_border", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_DELICATE = register("earth_mosaic_delicate", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_GEOMETRIC = register("earth_mosaic_geometric", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_PATTERN = register("earth_mosaic_pattern", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EARTH_MOSAIC_TRADITIONAL = register("earth_mosaic_traditional", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_BORDER = register("fire_mosaic_border", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_DELICATE = register("fire_mosaic_delicate", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_GEOMETRIC = register("fire_mosaic_geometric", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_PATTERN = register("fire_mosaic_pattern", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FIRE_MOSAIC_TRADITIONAL = register("fire_mosaic_traditional", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MOSAIC_FLOOR = register("mosaic_floor", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MOSAIC_FLOOR_DELICATE = register("mosaic_floor_delicate", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MOSAIC_FLOOR_ROSETTE = register("mosaic_floor_rosette", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> PINK_SALT_BLOCK = register("pink_salt_block", () -> new Block(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> POLISHED_PINK_SALT_BLOCK = register("polished_pink_salt_block", () -> new Block(Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> PURPUR_BRICK_PATTERN = register("purpur_brick_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_BRICK_PAVING = register("purpur_brick_paving_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_COLUMN_CTM = register("purpur_column_ctm", () -> new Block(Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> PURPUR_DIAGONAL_TILES = register("purpur_diagonal_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_DOTTED = register("purpur_dotted_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_FABRIC = register("purpur_fabric_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_JAGGED_PATTERN = register("purpur_jagged_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_LARGE_TILES = register("purpur_large_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_ORGANIC_PATTERN = register("purpur_organic_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SLANTED_TILES = register("purpur_slanted_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SMALL_TILES = register("purpur_small_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SPIRAL_PATTERN = register("purpur_spiral_pattern_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_SQUARES = register("purpur_squares_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_TILES = register("purpur_tiles_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> PURPUR_WOVEN = register("purpur_woven_ctm", () -> new Block(Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ROMAN_FRESCO_BLACK = register("roman_fresco_black", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROMAN_FRESCO_RED = register("roman_fresco_red", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROOFING_SLATES = register("roofing_slates", () -> new Block(Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_BORDER = register("spirit_mosaic_border", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_DELICATE = register("spirit_mosaic_delicate", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_GEOMETRIC = register("spirit_mosaic_geometric", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_PATTERN = register("spirit_mosaic_pattern", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SPIRIT_MOSAIC_TRADITIONAL = register("spirit_mosaic_traditional", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_BORDER = register("water_mosaic_border", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_DELICATE = register("water_mosaic_delicate", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_GEOMETRIC = register("water_mosaic_geometric", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_PATTERN = register("water_mosaic_pattern", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WATER_MOSAIC_TRADITIONAL = register("water_mosaic_traditional", () -> new Block(Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> WHEAT_THATCH = register("wheat_thatch", () -> new Block(Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(1.0f).sound(SoundType.GRASS)));
    /**
     * Patterned-wool families (cornered / crafted / harsh_quilted / rectangle × 16 colors), each with
     * a solo non-CTM block and a connecting (pieces_full) {@code _ctm} block, plus matching carpets.
     * Keyed by full block name (e.g. {@code "cornered_white_wool"}, {@code "cornered_white_wool_ctm"}).
     * {@code STYLED_WOOL} holds the wool cubes (solo + ctm); {@link #STYLED_CARPET} the carpets.
     * Populated by {@link #registerStyledWoolFamily()} just before the registry flush.
     */
    public static final Map<String, DeferredBlock<Block>> STYLED_WOOL = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<CarpetBlock>> STYLED_CARPET = new LinkedHashMap<>();

    /**
     * The four patterned-wool styles.
     */
    public static final List<String> STYLED_CARPET_STYLES = List.of("cornered", "crafted", "harsh_quilted", "rectangle");
    /**
     * The 16 vanilla dye colors, in vanilla ordinal order.
     */
    public static final List<String> STYLED_CARPET_COLORS = List.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black");

    private static void registerStyledWoolFamily() {
        for (String style : STYLED_CARPET_STYLES) {
            for (String color : STYLED_CARPET_COLORS) {
                String base = style + "_" + color;
                // Wool full-cubes (solo + ctm) copy the matching vanilla wool (mapColor/strength/sound).
                java.util.function.Supplier<Block> wool = () -> new Block(Properties.ofFullCopy(net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(net.minecraft.resources.ResourceLocation.withDefaultNamespace(color + "_wool"))));
                STYLED_WOOL.put(base + "_wool", register(base + "_wool", wool));
                STYLED_WOOL.put(base + "_wool_ctm", register(base + "_wool_ctm", wool));
                STYLED_CARPET.put(base + "_carpet", register(base + "_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL))));
                STYLED_CARPET.put(base + "_carpet_ctm", register(base + "_carpet_ctm", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL))));
            }
        }
    }

    /**
     * Plain (non-CTM) carpets for every imported 16×16 wool variant (barky/blocky/…/woved × 16 colors).
     * Derived from {@link OttTemplateBlocks#BY_NAME} {@code *_wool} entries (so it auto-tracks the CSV),
     * keyed by carpet block name (e.g. {@code "barky_black_carpet"}). Must run AFTER
     * {@link OttTemplateBlocks#init()} (which populates BY_NAME) and before the registry flush.
     */
    public static final Map<String, DeferredBlock<CarpetBlock>> IMPORTED_WOOL_CARPETS = new LinkedHashMap<>();

    private static void registerImportedWoolCarpets() {
        for (String woolName : OttTemplateBlocks.BY_NAME.keySet()) {
            if (!woolName.endsWith("_wool")) continue;
            String carpetName = woolName.substring(0, woolName.length() - "_wool".length()) + "_carpet";
            IMPORTED_WOOL_CARPETS.put(carpetName, register(carpetName, () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL))));
        }
    }

    /**
     * Decorative connecting-wool family: 4 styles × 16 colors × 4 variants = 256 blocks.
     * Variants per (style,color): {@code <style>_<color>_wool} (solo, non-CTM 16×16),
     * {@code _wool_ctm} (connecting CTM), {@code _carpet} (solo), {@code _carpet_ctm} (connecting CTM).
     * Wool blocks (solo + ctm) land in {@link #DECO_WOOL}; carpets in {@link #DECO_CARPET}; both keyed
     * by full block name. Connecting block models use the 80×16 pieces strip; solo use the 16×16 static.
     */
    public static final List<String> DECO_STYLES = List.of("delicate", "ornamented", "legacy", "llama");
    public static final Map<String, DeferredBlock<Block>> DECO_WOOL = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<CarpetBlock>> DECO_CARPET = new LinkedHashMap<>();

    private static void registerDecoWoolFamily() {
        for (String style : DECO_STYLES) {
            for (String color : STYLED_CARPET_COLORS) {
                String base = style + "_" + color;
                DECO_WOOL.put(base + "_wool", register(base + "_wool", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL))));
                DECO_WOOL.put(base + "_wool_ctm", register(base + "_wool_ctm", () -> new Block(Properties.of().strength(0.8F).sound(SoundType.WOOL))));
                DECO_CARPET.put(base + "_carpet", register(base + "_carpet", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL))));
                DECO_CARPET.put(base + "_carpet_ctm", register(base + "_carpet_ctm", () -> new CarpetBlock(Properties.of().strength(0.1F).sound(SoundType.WOOL))));
            }
        }
    }

    public static void register(IEventBus eventBus) {
        OttTemplateBlocks.init();          // queue imported cube_all blocks before the registry flush
        registerImportedWoolCarpets();     // queue plain carpets for imported wools (needs BY_NAME populated)
        registerStyledWoolFamily();        // queue patterned-wool family (solo + ctm wool & carpet)
        registerDecoWoolFamily();          // queue decorative wool family (delicate/ornamented/legacy/llama)
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}