package net.cautious.slugcore.block;

import net.cautious.slugcore.SlugCore;
import net.cautious.slugcore.block.custom.*;
import net.cautious.slugcore.item.SlugCoreItemGroup;
import net.cautious.slugcore.world.feature.tree.BloodTreeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SlugCoreBlocks {
    public static final Block HEART_SHARD_ORE_S = registerBlock("heartshardblocks",
            new HeartShardOreStone(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3,7)), SlugCoreItemGroup.ORES);

    public static final Block HEART_SHARD_ORE_D = registerBlock("heartshardblockd",
            new HeartShardOreDeepslate(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(5,9)), SlugCoreItemGroup.ORES);
    public static final Block LETTUCE_CROP = registerBlockWihoutItem("lettuce_crop",
            new LettuceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    public static final Block BLOOD_LOG = registerBlock("blood_log",
            new Blood_Log_Block(FabricBlockSettings.copy(Blocks.OAK_LOG)), SlugCoreItemGroup.ALCHEMY);
    public static final Block BLOOD_WOOD = registerBlock("blood_wood",
            new Blood_Log_Block(FabricBlockSettings.copy(Blocks.OAK_WOOD)), SlugCoreItemGroup.ALCHEMY);
    public static final Block STRIPPED_BLOOD_LOG = registerBlock("stripped_blood_log",
            new Blood_Log_Block(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), SlugCoreItemGroup.ALCHEMY);
    public static final Block STRIPPED_BLOOD_WOOD = registerBlock("stripped_blood_wood",
            new Blood_Log_Block(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), SlugCoreItemGroup.ALCHEMY);
    public static final Block BLOOD_PLANKS = registerBlock("blood_planks",
            new BloodPlanksBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), SlugCoreItemGroup.ALCHEMY);
    public static final Block BLOOD_LEAVES = registerBlock("blood_leaves",
            new Blood_Leaves_Block(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), SlugCoreItemGroup.ALCHEMY);
    public static final Block BLOOD_SAPLING = registerBlock("blood_sapling",
            new BloodSaplingBlock(new BloodTreeSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), SlugCoreItemGroup.ALCHEMY);

    public static final Block KOMATIITE = registerBlock("komatiite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.6f).requiresTool()), SlugCoreItemGroup.ORES);

    public static final Block COBBLED_KOMATIITE = registerBlock("cobbled_komatiite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.8f).requiresTool()), SlugCoreItemGroup.ORES);
    public static final Block KOMATIITE_STONE_BRICKS = registerBlock("komatiite_stone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f).requiresTool()), SlugCoreItemGroup.ORES);
    private static Block registerBlockWihoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(SlugCore.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockitem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(SlugCore.MOD_ID, name), block);
    }
    private static Item registerBlockitem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SlugCore.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerSlugCoreBlocks() {
        SlugCore.LOGGER.info("Registering SlugCoreBlocks for " + SlugCore.MOD_ID);
    }
}
