package net.cautious.slugcore.item;

import net.cautious.slugcore.SlugCore;
import net.cautious.slugcore.block.SlugCoreBlocks;
import net.cautious.slugcore.item.custom.HeartCrystalItem;
import net.cautious.slugcore.item.custom.HeartShardItem;
import net.cautious.slugcore.item.custom.LettuceItem;
import net.cautious.slugcore.item.custom.LettuceSeedItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SlugCoreItems {

    public static final Item HEART_SHARD = registerItem("heartshard",
            new HeartShardItem(new FabricItemSettings()));
    public static final Item LETTUCE_SEEDS = registerItem("lettuce_seeds",
            new LettuceSeedItem(SlugCoreBlocks.LETTUCE_CROP,
                    new FabricItemSettings()));
    public static final Item LETTUCE = registerItem("lettuce",
            new LettuceItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(4).build())));
    public static final Item HEART_CRYSTAL = registerItem("heartcrystal",
            new HeartCrystalItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SlugCore.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(SlugCoreItemGroup.CRAFTING, HEART_SHARD);
        addToItemGroup(SlugCoreItemGroup.SPECIAL, HEART_CRYSTAL);
        addToItemGroup(SlugCoreItemGroup.FARMING, LETTUCE_SEEDS);
        addToItemGroup(SlugCoreItemGroup.FARMING, LETTUCE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerSlugCoreItems() {
        SlugCore.LOGGER.info("Registering SlugCoreItems for " + SlugCore.MOD_ID);

        addItemsToItemGroup();
    }
}
