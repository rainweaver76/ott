package com.otterly76.ott_blocks.client;

import com.otterly76.ott.client.model.ctm.ConnectingModelLoader;
import com.otterly76.ott_blocks.OttBlocksMod;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ModelEvent;

/**
 * Client-only setup for {@code ott_blocks}. Kept in a separate class so the dedicated server never
 * classloads client-only types. Wired from {@link OttBlocksMod} behind a dist check.
 */
public final class OttBlocksClient {
    private OttBlocksClient() {}

    public static void init(IEventBus modEventBus) {
        modEventBus.addListener(OttBlocksClient::onRegisterGeometryLoaders);
    }

    private static void onRegisterGeometryLoaders(ModelEvent.RegisterGeometryLoaders event) {
        // Registered under the shared "ott" namespace so existing ott:mosaic block models resolve unchanged.
        event.register(ResourceLocation.fromNamespaceAndPath(OttBlocksMod.CONTENT_NAMESPACE, "mosaic"),
                ConnectingModelLoader.INSTANCE);
    }
}
