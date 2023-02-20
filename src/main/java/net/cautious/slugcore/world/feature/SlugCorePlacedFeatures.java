package net.cautious.slugcore.world.feature;

import net.cautious.slugcore.SlugCore;
import net.cautious.slugcore.block.SlugCoreBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class SlugCorePlacedFeatures {
    public static final RegistryKey<PlacedFeature> BLOOD_CHECKED_KEY = registerKey("blood_tree_checked");
    public static final RegistryKey<PlacedFeature> BLOOD_PLACED_KEY = registerKey("blood_tree_checked");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BLOOD_CHECKED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SlugCoreConfiguredFeatures.BLOOD_KEY),
                List.of(PlacedFeatures.wouldSurvive(SlugCoreBlocks.BLOOD_SAPLING)));
        register(context, BLOOD_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SlugCoreConfiguredFeatures.BLOOD_KEY),
                VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1,0.1f,2)));
    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE,new Identifier(SlugCore.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feautre, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feautre, configuration));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());

    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heigtModifier) {
        return modifiers(CountPlacementModifier.of(count), heigtModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModiefier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModiefier);
    }
}
