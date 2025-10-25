package com.otterly76.blockparty.item;

import com.otterly76.blockparty.Constants;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredItem<Item> OTTER = ITEMS.register("otter",
            () -> new Item(new Item.Properties()));
}