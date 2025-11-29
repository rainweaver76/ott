package com.otterly76.ott.particles;

import com.otterly76.ott.PlatformHandler;
import net.minecraft.core.particles.SimpleParticleType;
import java.util.function.Supplier;

public class OttParticles {
    public static final Supplier<SimpleParticleType> WEEPING_LEAF = register("weeping_leaf");
    public static final Supplier<SimpleParticleType> FIREFLY = register("firefly");

    private static Supplier<SimpleParticleType> register(String id) {
        return PlatformHandler.PLATFORM_HANDLER.registerCreateParticle(id);
    }
}