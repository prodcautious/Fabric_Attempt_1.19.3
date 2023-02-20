package net.cautious.slugcore.item;

import net.cautious.slugcore.SlugCore;
import net.cautious.slugcore.block.SlugCoreBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SlugCoreItemGroup {
    public static ItemGroup ORES;
    public static ItemGroup SPECIAL;
    public static ItemGroup FARMING;
    public static ItemGroup ALCHEMY;
    public static ItemGroup CRAFTING;

    public static void registerItemGroups() {
        SPECIAL = FabricItemGroup.builder(new Identifier(SlugCore.MOD_ID, "special"))
                .displayName(Text.translatable("itemgroup.special"))
                .icon(() -> new ItemStack(SlugCoreItems.HEART_CRYSTAL)).build();

        ORES = FabricItemGroup.builder(new Identifier(SlugCore.MOD_ID, "ores"))
                .displayName(Text.translatable("itemgroup.ores"))
                .icon(() -> new ItemStack(SlugCoreBlocks.HEART_SHARD_ORE_S)).build();

        FARMING = FabricItemGroup.builder(new Identifier(SlugCore.MOD_ID, "farming"))
                .displayName(Text.translatable("itemgroup.farming"))
                .icon(() -> new ItemStack(SlugCoreItems.LETTUCE_SEEDS)).build();

        CRAFTING = FabricItemGroup.builder(new Identifier(SlugCore.MOD_ID, "crafting"))
                .displayName(Text.translatable("itemgroup.crafting"))
                .icon(() -> new ItemStack(SlugCoreItems.HEART_SHARD)).build();

        ALCHEMY = FabricItemGroup.builder(new Identifier(SlugCore.MOD_ID, "alchemy"))
                .displayName(Text.translatable("itemgroup.alchemy"))
                .icon(() -> new ItemStack(SlugCoreBlocks.BLOOD_LOG)).build();
    }
}