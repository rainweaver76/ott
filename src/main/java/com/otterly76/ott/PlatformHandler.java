package com.otterly76.ott;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public interface PlatformHandler {
    PlatformHandler PLATFORM_HANDLER = ServiceLoader.load(PlatformHandler.class)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No PlatformHandler implementation found. Check META-INF/services."));

    Platform getPlatform();

    Path configPath();

    default boolean hasPermission(@NotNull CommandSourceStack sourceStack, @NotNull String permission) {
        return sourceStack.hasPermission(4);
    }

        Supplier<SimpleParticleType> registerCreateParticle(String var1);

    <T> Supplier<T> register(Registry<? super T> var1, String var2, Supplier<T> var3);

    <T> Supplier<Holder.Reference<T>> registerForHolder(Registry<T> var1, String var2, Supplier<T> var3);

    enum Platform {
        NEOFORGE
    }
}