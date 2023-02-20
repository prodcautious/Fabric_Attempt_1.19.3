package net.cautious.slugcore;

import net.cautious.slugcore.block.SlugCoreBlocks;

import net.cautious.slugcore.data.SlugCoreWorldGenerator;
import net.cautious.slugcore.item.SlugCoreItemGroup;
import net.cautious.slugcore.item.SlugCoreItems;
import net.cautious.slugcore.util.FlammableBlocks;
import net.cautious.slugcore.util.StrippableBlocks;
import net.cautious.slugcore.world.gen.SlugCoreWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SlugCore implements ModInitializer {

	public static final String MOD_ID = "slugcore";
	public static final Logger LOGGER = LoggerFactory.getLogger("slugcore");

	@Override
	public void onInitialize() {
		SlugCoreItemGroup.registerItemGroups();
		SlugCoreItems.registerSlugCoreItems();
		SlugCoreBlocks.registerSlugCoreBlocks();
		SlugCoreWorldGeneration.generateSlugCoreWorldGen();


		FlammableBlocks.registerFlammableBlocks();
		StrippableBlocks.registerStrippables();
	}
}