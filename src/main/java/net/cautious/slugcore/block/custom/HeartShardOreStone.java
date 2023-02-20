package net.cautious.slugcore.block.custom;

import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeartShardOreStone extends ExperienceDroppingBlock {
    public HeartShardOreStone(Settings settings, UniformIntProvider uniformIntProvider) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("slugcore.ore.tooltip").formatted(Formatting.BLUE));
    }
}
