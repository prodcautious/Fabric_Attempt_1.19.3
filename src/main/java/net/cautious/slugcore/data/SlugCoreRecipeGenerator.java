package net.cautious.slugcore.data;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.cautious.slugcore.item.SlugCoreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class SlugCoreRecipeGenerator extends FabricRecipeProvider {
    public SlugCoreRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(SlugCoreBlocks.HEART_SHARD_ORE_S), RecipeCategory.MISC, SlugCoreItems.HEART_SHARD,
                0.7f, 200, "heart_shard");

        offerBlasting(exporter, List.of(SlugCoreBlocks.HEART_SHARD_ORE_S), RecipeCategory.MISC, SlugCoreItems.HEART_SHARD,
                0.8f, 180, "heart_shard");

        offerSmelting(exporter, List.of(SlugCoreBlocks.HEART_SHARD_ORE_D), RecipeCategory.MISC, SlugCoreItems.HEART_SHARD,
                0.7f, 210, "heart_shard");

        offerBlasting(exporter, List.of(SlugCoreBlocks.HEART_SHARD_ORE_D), RecipeCategory.MISC, SlugCoreItems.HEART_SHARD,
                1.0f, 190, "heart_shard");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, SlugCoreItems.HEART_SHARD, RecipeCategory.MISC,
                SlugCoreItems.HEART_CRYSTAL);
    }
}
