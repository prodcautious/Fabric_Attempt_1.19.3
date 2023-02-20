package net.cautious.slugcore;

import net.cautious.slugcore.data.SlugCoreLootTableGenerator;
import net.cautious.slugcore.data.SlugCoreModelProvider;
import net.cautious.slugcore.data.SlugCoreRecipeGenerator;
import net.cautious.slugcore.data.SlugCoreWorldGenerator;
import net.cautious.slugcore.world.SlugCoreConfiguredFeatures;
import net.cautious.slugcore.world.SlugCorePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SlugCoreDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(SlugCoreLootTableGenerator::new);
		pack.addProvider(SlugCoreRecipeGenerator::new);
		pack.addProvider(SlugCoreModelProvider::new);
		pack.addProvider(SlugCoreWorldGenerator::new);
	}


	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, SlugCoreConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, SlugCorePlacedFeatures::bootstrap);
	}
}

