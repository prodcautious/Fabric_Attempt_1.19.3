package net.cautious.slugcore;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class SlugCoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SlugCoreBlocks.LETTUCE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SlugCoreBlocks.BLOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SlugCoreBlocks.BLOOD_SAPLING, RenderLayer.getCutout());
    }
}
