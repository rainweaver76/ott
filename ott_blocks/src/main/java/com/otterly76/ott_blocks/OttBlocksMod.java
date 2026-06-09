package com.otterly76.ott_blocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * Entry point for the {@code ott_blocks} mod.
 *
 * <p>The bottom layer of the two-mod split: it owns the migrated full-cube decorative block content but
 * never depends on the functional {@code ott} mod. All content registers under the shared <b>{@code ott}</b>
 * namespace (NeoForge allows any mod to register into any namespace), so block IDs, asset paths and existing
 * worlds are unaffected by the split.</p>
 */
@Mod(OttBlocksMod.MOD_ID)
public class OttBlocksMod {
    /** The loader-facing mod id. */
    public static final String MOD_ID = "ott_blocks";
    /** The namespace all content registers under (shared with the {@code ott} mod). */
    public static final String CONTENT_NAMESPACE = "ott";

    public OttBlocksMod(IEventBus modEventBus) {
        com.otterly76.ott_blocks.block.OttBlocks.register(modEventBus);
        com.otterly76.ott_blocks.sound.OttBlockSounds.register(modEventBus);
        com.otterly76.ott_blocks.particle.OttBlockParticles.register(modEventBus);
        if (net.neoforged.fml.loading.FMLEnvironment.dist.isClient()) {
            com.otterly76.ott_blocks.client.OttBlocksClient.init(modEventBus);
        }
    }
}
