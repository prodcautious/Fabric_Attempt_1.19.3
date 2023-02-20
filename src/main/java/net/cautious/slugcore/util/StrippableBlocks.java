package net.cautious.slugcore.util;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class StrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(SlugCoreBlocks.BLOOD_LOG, SlugCoreBlocks.STRIPPED_BLOOD_LOG);
        StrippableBlockRegistry.register(SlugCoreBlocks.BLOOD_WOOD, SlugCoreBlocks.STRIPPED_BLOOD_WOOD);
    }
}
