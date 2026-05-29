package com.otterly76.ott.item.custom;

import com.ldtteam.domumornamentum.block.IMateriallyTexturedBlockComponent;
import com.ldtteam.domumornamentum.client.model.data.MaterialTextureData;
import com.ldtteam.domumornamentum.item.SelfUpgradingBlockItem;
import com.ldtteam.domumornamentum.item.interfaces.IDoItem;
import com.ldtteam.domumornamentum.util.BlockUtils;
import com.otterly76.ott.block.custom.OttGlassPaneBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * BlockItem for {@link OttGlassPaneBlock} that implements {@link IDoItem} so it
 * appears in the Architect's Cutter GUI and carries material texture data.
 */
public class OttGlassPaneItem extends SelfUpgradingBlockItem implements IDoItem
{
    private final OttGlassPaneBlock glassPane;

    public OttGlassPaneItem(final @NotNull OttGlassPaneBlock block, final @NotNull Properties properties)
    {
        super(block, properties);
        this.glassPane = block;
    }

    @NotNull
    @Override
    public Component getName(final @NotNull ItemStack stack)
    {
        final MaterialTextureData textureData = MaterialTextureData.readFromItemStack(stack);
        final IMateriallyTexturedBlockComponent component = glassPane.getComponents().getFirst();
        final Block materialBlock = textureData.getTexturedComponents()
                .getOrDefault(component.getId(), component.getDefault());
        return Component.translatable("block.ott.glass_pane.name.format", BlockUtils.getHoverName(materialBlock));
    }

    @Override
    public @NotNull ResourceLocation getGroup()
    {
        return ResourceLocation.fromNamespaceAndPath("ott", "glass_pane");
    }
}
