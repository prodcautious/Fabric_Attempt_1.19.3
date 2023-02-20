package net.cautious.slugcore.datagen;

import net.cautious.slugcore.block.SlugCoreBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class SlugCoreLootTableGenerator extends FabricBlockLootTableProvider {

    public SlugCoreLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate() {
        addDrop(SlugCoreBlocks.BLOOD_PLANKS);
    }
}
