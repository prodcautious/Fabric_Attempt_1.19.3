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
        offerSmelting(exporter, List.of(SlugCoreBlocks.HEART_SHARD_ORE_S), RecipeCategory.BUILDING_BLOCKS, SlugCoreItems.HEART_SHARD,
                3f, 300,"heartshard");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, SlugCoreItems.HEART_SHARD, RecipeCategory.BUILDING_BLOCKS, SlugCoreItems.HEART_CRYSTAL);

        offerShapelessRecipe(exporter, SlugCoreBlocks.BLOOD_PLANKS, SlugCoreBlocks.BLOOD_LOG, "bloodplanks", 4);



    }

}
