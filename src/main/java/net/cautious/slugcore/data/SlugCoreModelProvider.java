package net.cautious.slugcore.data;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.cautious.slugcore.item.SlugCoreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class SlugCoreModelProvider extends FabricModelProvider {
    public SlugCoreModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.HEART_SHARD_ORE_S);
        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.HEART_SHARD_ORE_D);

        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.KOMATIITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.COBBLED_KOMATIITE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.KOMATIITE_STONE_BRICKS);

        blockStateModelGenerator.registerLog(SlugCoreBlocks.BLOOD_LOG).log(SlugCoreBlocks.BLOOD_LOG).wood(SlugCoreBlocks.BLOOD_WOOD);
        blockStateModelGenerator.registerLog(SlugCoreBlocks.STRIPPED_BLOOD_LOG).log(SlugCoreBlocks.STRIPPED_BLOOD_LOG).wood(SlugCoreBlocks.STRIPPED_BLOOD_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.BLOOD_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(SlugCoreBlocks.BLOOD_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(SlugCoreBlocks.BLOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SlugCoreItems.HEART_SHARD, Models.GENERATED);
        itemModelGenerator.register(SlugCoreItems.HEART_CRYSTAL, Models.GENERATED);

        itemModelGenerator.register(SlugCoreItems.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(SlugCoreItems.LETTUCE_SEEDS, Models.GENERATED);
    }
}
