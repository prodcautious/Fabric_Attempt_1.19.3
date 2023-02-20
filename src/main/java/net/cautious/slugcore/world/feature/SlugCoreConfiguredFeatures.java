package net.cautious.slugcore.world.feature;

import net.cautious.slugcore.SlugCore;
import net.cautious.slugcore.block.SlugCoreBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class SlugCoreConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOOD_KEY = registerKey("blood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOOD_SPAWN_KEY = registerKey("blood_tree_spawn");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        register(context, BLOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(SlugCoreBlocks.BLOOD_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(SlugCoreBlocks.BLOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, BLOOD_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(SlugCorePlacedFeatures.BLOOD_PLACED_KEY),
                        .5f)), placedFeatureRegistryEntryLookup.getOrThrow(SlugCorePlacedFeatures.BLOOD_PLACED_KEY)));

    }+
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,new Identifier(SlugCore.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feautre, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feautre, configuration));
    }
}