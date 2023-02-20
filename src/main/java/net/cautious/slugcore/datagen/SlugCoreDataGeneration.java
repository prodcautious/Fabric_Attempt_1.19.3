package net.cautious.slugcore.datagen;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.cautious.slugcore.world.feature.SlugCoreConfiguredFeatures;
import net.cautious.slugcore.world.feature.SlugCorePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SlugCoreDataGeneration implements DataGeneratorEntrypoint {
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
