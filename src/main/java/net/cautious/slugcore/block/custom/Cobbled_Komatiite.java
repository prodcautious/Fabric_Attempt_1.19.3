package net.cautious.slugcore.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Cobbled_Komatiite extends Block {
    public Cobbled_Komatiite(Settings settings) { super(settings); }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("slugcore.ore.tooltip").formatted(Formatting.BLUE));
    }
}


