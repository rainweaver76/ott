package com.otterly76.ott.mixin.common;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Tags the axolotl bucket with custom_model_data = variant id so the bucket icon
 * reflects the captured colour. Vanilla axolotl_bucket.json carries the variant overrides
 * (1=wild, 2=gold, 3=cyan, 4=blue; variant 0/lucy = base model). The variant itself is
 * already stored/restored by vanilla, so this is purely cosmetic for the held/inventory icon.
 */
@Mixin(Axolotl.class)
public abstract class AxolotlBucketMixin {

    @Inject(method = "saveToBucketTag", at = @At("TAIL"))
    private void ott$variantBucketIcon(ItemStack stack, CallbackInfo ci) {
        Axolotl self = (Axolotl) (Object) this;
        stack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(self.getVariant().getId()));
    }
}
