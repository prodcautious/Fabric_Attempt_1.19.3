package net.cautious.slugcore.block.custom;

import net.minecraft.block.LeavesBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Blood_Leaves_Block extends LeavesBlock {

    public Blood_Leaves_Block(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("slugcore.alchemy.tooltip").formatted(Formatting.LIGHT_PURPLE));
    }
}
