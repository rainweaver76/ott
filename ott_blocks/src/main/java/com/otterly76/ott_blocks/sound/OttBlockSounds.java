package com.otterly76.ott_blocks.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Block-only sound events + sound types, extracted from {@code ott}'s ModSounds so the block layer
 * (which lives in ott_blocks) does not depend back on ott. Registers into the same namespaces ModSounds
 * used: backported-vanilla block sounds under "minecraft", egg sounds under "ott". The matching
 * sounds.json/ogg definitions still live in ott's assets and merge at runtime by namespace.
 */
public class OttBlockSounds {

    public static final DeferredRegister<SoundEvent> MINECRAFT_SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "minecraft");
    public static final DeferredRegister<SoundEvent> OTT_SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "ott");

    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_BREAK = registerSoundEvent("block.resin.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_FALL = registerSoundEvent("block.resin.fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_PLACE = registerSoundEvent("block.resin.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_STEP = registerSoundEvent("block.resin.step");
    public static final DeferredSoundType RESIN = new DeferredSoundType(1.0F, 1.0F, RESIN_BREAK, RESIN_STEP, RESIN_PLACE, RESIN_PLACE, RESIN_FALL);
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_BRICKS_BREAK = registerSoundEvent("block.resin_bricks.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_BRICKS_FALL = registerSoundEvent("block.resin_bricks.fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_BRICKS_HIT = registerSoundEvent("block.resin_bricks.hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_BRICKS_PLACE = registerSoundEvent("block.resin_bricks.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> RESIN_BRICKS_STEP = registerSoundEvent("block.resin_bricks.step");
    public static final DeferredSoundType RESIN_BRICKS = new DeferredSoundType(1.0F, 1.0F, RESIN_BRICKS_BREAK, RESIN_BRICKS_STEP, RESIN_BRICKS_PLACE, RESIN_BRICKS_HIT, RESIN_BRICKS_FALL);
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_BREAK = registerSoundEvent("block.creaking_heart.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_FALL = registerSoundEvent("block.creaking_heart.fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_HIT = registerSoundEvent("block.creaking_heart.hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_HURT = registerSoundEvent("block.creaking_heart.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_PLACE = registerSoundEvent("block.creaking_heart.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_STEP = registerSoundEvent("block.creaking_heart.step");
    public static final DeferredSoundType CREAKING_HEART = new DeferredSoundType(1.0F, 1.0F, CREAKING_HEART_BREAK, CREAKING_HEART_STEP, CREAKING_HEART_PLACE, CREAKING_HEART_HIT, CREAKING_HEART_FALL);
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_IDLE = registerSoundEvent("block.creaking_heart.idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_HEART_SPAWN = registerSoundEvent("block.creaking_heart.spawn");
    public static final DeferredHolder<SoundEvent, SoundEvent> CREAKING_SPAWN = registerSoundEvent("entity.creaking.spawn");
    public static final DeferredHolder<SoundEvent, SoundEvent> EYEBLOSSOM_OPEN_LONG = registerSoundEvent("block.eyeblossom.open_long");
    public static final DeferredHolder<SoundEvent, SoundEvent> EYEBLOSSOM_OPEN = registerSoundEvent("block.eyeblossom.open");
    public static final DeferredHolder<SoundEvent, SoundEvent> EYEBLOSSOM_CLOSE_LONG = registerSoundEvent("block.eyeblossom.close_long");
    public static final DeferredHolder<SoundEvent, SoundEvent> EYEBLOSSOM_CLOSE = registerSoundEvent("block.eyeblossom.close");
    public static final DeferredHolder<SoundEvent, SoundEvent> EYEBLOSSOM_IDLE = registerSoundEvent("block.eyeblossom.idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> GHASTLING_SPAWN = registerSoundEvent("entity.ghastling.spawn");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_BREAK = registerSoundEvent("block.dried_ghast.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_STEP = registerSoundEvent("block.dried_ghast.step");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_FALL = registerSoundEvent("block.dried_ghast.fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_TRANSITION = registerSoundEvent("block.dried_ghast.transition");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_AMBIENT = registerSoundEvent("block.dried_ghast.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_AMBIENT_WATER = registerSoundEvent("block.dried_ghast.ambient_water");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_PLACE = registerSoundEvent("block.dried_ghast.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> DRIED_GHAST_PLACE_IN_WATER = registerSoundEvent("block.dried_ghast.place_in_water");
    public static final DeferredSoundType DRIED_GHAST = new DeferredSoundType(1.0F, 1.0F, DRIED_GHAST_BREAK, DRIED_GHAST_STEP, () -> net.minecraft.sounds.SoundEvents.EMPTY, () -> net.minecraft.sounds.SoundEvents.EMPTY, DRIED_GHAST_FALL);
    public static final DeferredHolder<SoundEvent, SoundEvent> FIREFLY_BUSH_IDLE = registerSoundEvent("block.firefly_bush.idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> LEAF_LITTER_BREAK = registerSoundEvent("block.leaf_litter.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> LEAF_LITTER_STEP = registerSoundEvent("block.leaf_litter.step");
    public static final DeferredHolder<SoundEvent, SoundEvent> LEAF_LITTER_PLACE = registerSoundEvent("block.leaf_litter.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> LEAF_LITTER_HIT = registerSoundEvent("block.leaf_litter.hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> LEAF_LITTER_FALL = registerSoundEvent("block.leaf_litter.fall");
    public static final DeferredSoundType LEAF_LITTER = new DeferredSoundType(1.0F, 1.0F, LEAF_LITTER_BREAK, LEAF_LITTER_STEP, LEAF_LITTER_PLACE, LEAF_LITTER_HIT, LEAF_LITTER_FALL);
    public static final DeferredHolder<SoundEvent, SoundEvent> CACTUS_FLOWER_BREAK = registerSoundEvent("block.cactus_flower.break");
    public static final DeferredHolder<SoundEvent, SoundEvent> CACTUS_FLOWER_STEP = registerSoundEvent("block.cactus_flower.step");
    public static final DeferredHolder<SoundEvent, SoundEvent> CACTUS_FLOWER_PLACE = registerSoundEvent("block.cactus_flower.place");
    public static final DeferredHolder<SoundEvent, SoundEvent> CACTUS_FLOWER_HIT = registerSoundEvent("block.cactus_flower.hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> CACTUS_FLOWER_FALL = registerSoundEvent("block.cactus_flower.fall");
    public static final DeferredSoundType CACTUS_FLOWER = new DeferredSoundType(1.0F, 1.0F, CACTUS_FLOWER_BREAK, CACTUS_FLOWER_STEP, CACTUS_FLOWER_PLACE, CACTUS_FLOWER_HIT, CACTUS_FLOWER_FALL);
    public static final DeferredHolder<SoundEvent, SoundEvent> PALE_HANGING_MOSS_IDLE = registerSoundEvent("block.pale_hanging_moss.idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> COPPER_CHEST_CLOSE = registerSoundEvent("block.copper_chest.close");
    public static final DeferredHolder<SoundEvent, SoundEvent> COPPER_CHEST_OPEN = registerSoundEvent("block.copper_chest.open");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHELF_ACTIVATE = registerSoundEvent("block.shelf.activate");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHELF_DEACTIVATE = registerSoundEvent("block.shelf.deactivate");
    public static final DeferredHolder<SoundEvent, SoundEvent> GATOR_EGG_BREAK = registerOttSoundEvent("entity.alligator.egg_break");
    public static final DeferredHolder<SoundEvent, SoundEvent> GATOR_EGG_CRACK = registerOttSoundEvent("entity.alligator.egg_crack");
    public static final DeferredHolder<SoundEvent, SoundEvent> GATOR_EGG_HATCH = registerOttSoundEvent("entity.alligator.egg_hatch");
    public static final DeferredHolder<SoundEvent, SoundEvent> TORTOISE_EGG_BREAK = registerOttSoundEvent("entity.tortoise.egg_break");
    public static final DeferredHolder<SoundEvent, SoundEvent> TORTOISE_EGG_CRACK = registerOttSoundEvent("entity.tortoise.egg_crack");
    public static final DeferredHolder<SoundEvent, SoundEvent> TORTOISE_EGG_HATCH = registerOttSoundEvent("entity.tortoise.egg_hatch");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("minecraft", name);
        return MINECRAFT_SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    private static DeferredHolder<SoundEvent, SoundEvent> registerOttSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("ott", name);
        return OTT_SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        MINECRAFT_SOUND_EVENTS.register(eventBus);
        OTT_SOUND_EVENTS.register(eventBus);
    }
}
