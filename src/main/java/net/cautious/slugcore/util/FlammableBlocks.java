package net.cautious.slugcore.util;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class FlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(SlugCoreBlocks.BLOOD_LOG, 5, 5);
        registry.add(SlugCoreBlocks.BLOOD_WOOD, 5, 5);
        registry.add(SlugCoreBlocks.STRIPPED_BLOOD_LOG, 5, 5);
        registry.add(SlugCoreBlocks.STRIPPED_BLOOD_WOOD, 5, 5);

        registry.add(SlugCoreBlocks.BLOOD_PLANKS, 5, 20);
        registry.add(SlugCoreBlocks.BLOOD_LEAVES, 30, 60);
    }
}
