package net.cautious.slugcore;

import net.cautious.slugcore.block.SlugCoreBlocks;

import net.cautious.slugcore.block.SlugCoreFlammableBlockRegistry;
import net.cautious.slugcore.item.SlugCoreItemGroup;
import net.cautious.slugcore.item.SlugCoreItems;
import net.cautious.slugcore.world.gen.SlugCoreWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SlugCore implements ModInitializer {

	public static final String MOD_ID = "slugcore";
	public static final Logger LOGGER = LoggerFactory.getLogger("slugcore");

	@Override
	public void onInitialize() {
		SlugCoreItemGroup.registerItemGroups();
		SlugCoreItems.registerSlugCoreItems();
		SlugCoreBlocks.registerSlugCoreblocks();
		SlugCoreWorldGeneration.generateSlugCoreWorldGen();


		SlugCoreFlammableBlockRegistry.registerFlammableBlocks();
		StrippableBlockRegistry.register(SlugCoreBlocks.BLOOD_LOG, SlugCoreBlocks.STRIPPED_BLOOD_LOG);
		StrippableBlockRegistry.register(SlugCoreBlocks.BLOOD_WOOD, SlugCoreBlocks.STRIPPED_BLOOD_WOOD);
	}
}