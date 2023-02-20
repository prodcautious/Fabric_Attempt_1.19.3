package net.cautious.slugcore.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class SlugCoreFlammableBlockRegistry {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(SlugCoreBlocks.BLOOD_LOG, 5, 5);
        registry.add(SlugCoreBlocks.BLOOD_WOOD, 5, 5);
        registry.add(SlugCoreBlocks.STRIPPED_BLOOD_LOG, 5, 5);
        registry.add(SlugCoreBlocks.STRIPPED_BLOOD_WOOD, 5, 5);

        registry.add(SlugCoreBlocks.BLOOD_LEAVES, 30, 60);
        registry.add(SlugCoreBlocks.BLOOD_PLANKS, 5, 20);
    }
}
