package com.otterly76.ott_blocks.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Block-only particle types, extracted from ott's ModParticle so the block layer (in ott_blocks)
 * does not depend back on ott. Registered into the "minecraft" namespace, matching ModParticle.
 * The client-side particle providers for these still live in ott and reference these types upward.
 */
public class OttBlockParticles {
    public static final DeferredRegister<ParticleType<?>> MINECRAFT_PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, "minecraft");

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLY = MINECRAFT_PARTICLE_TYPES.register("firefly", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> COPPER_FIRE_FLAME = MINECRAFT_PARTICLE_TYPES.register("copper_fire_flame", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PALE_OAK_LEAVES = MINECRAFT_PARTICLE_TYPES.register("pale_oak_leaves", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        MINECRAFT_PARTICLE_TYPES.register(eventBus);
    }
}
