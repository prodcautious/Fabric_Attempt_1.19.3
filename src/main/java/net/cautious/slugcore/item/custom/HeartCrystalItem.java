package net.cautious.slugcore.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class HeartCrystalItem extends Item {
    public HeartCrystalItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("slugcore.special.tooltip").formatted(Formatting.RED));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            //check player's max health
            if(user.getMaxHealth() < 40) {
                //give user one max heart
                Objects.requireNonNull(user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(user.getMaxHealth() + 2f);
                // heals player by one heart
                user.heal(2f);
                //add a cooldown
                user.getItemCooldownManager().set(this, 20);
                //remove item from hand
                itemStack.decrement(1);
            } else {
                //maximum of 20 hearts and output
                outputMaxHealth(user);
            }
        }

        return super.use(world, user, hand);
    }

    private void outputMaxHealth(PlayerEntity player) {
        player.sendMessage(Text.literal("You already have the maximum amount of health!").formatted(Formatting.RED));
    }

}
