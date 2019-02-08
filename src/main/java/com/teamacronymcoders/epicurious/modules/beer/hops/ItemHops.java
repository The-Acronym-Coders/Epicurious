package com.teamacronymcoders.epicurious.modules.beer.hops;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.defaults.DefaultFoodItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import toughasnails.api.TANPotions;
import toughasnails.api.stat.capability.IThirst;
import toughasnails.api.thirst.IDrink;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.thirst.ThirstHandler;

@Optional.Interface(modid = "toughasnails", iface = "mods.toughasnails.api.thirst.IDrink")
public class ItemHops extends DefaultFoodItem implements IDrink {

    public ItemHops() {
        super(2, 0.05f, false);
        setUnlocalizedName("hops");
    }

    @Optional.Method(modid = "toughasnails")
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (!worldIn.isRemote && entityLiving instanceof EntityPlayer && stack.getItem() instanceof ItemHops) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            IThirst thirst = ThirstHelper.getThirstData(player);
            ThirstHandler handler = (ThirstHandler) thirst;
            ItemHops hops = (ItemHops) stack.getItem();
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
                if (!player.capabilities.isCreativeMode) {
                    if (stack.isEmpty()) {
                        return new ItemStack(ModItems.seeds_grape, MathHelper.getInt(worldIn.rand, 1, 3));
                    }
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.seeds_grape, MathHelper.getInt(worldIn.rand, 1, 3)));
                }
            }
            if (handler.isThirsty()) {
                thirst.addStats(hops.getThirst(), hops.getHydration());
            }
            addEffect(player, stack);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @Optional.Method(modid = "toughasnails")
    @Override
    public int getThirst() {
        return -2;
    }

    @Optional.Method(modid = "toughasnails")
    @Override
    public float getHydration() {
        return -1;
    }

    @Optional.Method(modid = "toughasnails")
    @Override
    public float getPoisonChance() {
        return 0.15f;
    }

    @Optional.Method(modid = "toughasnails")
    private void addEffect(EntityPlayer player, ItemStack stack) {
        if (stack.getItem() instanceof ItemHops) {
            ItemHops grapes = (ItemHops) stack.getItem();
            if (player.world.rand.nextFloat() < grapes.getPoisonChance()) {
                player.addPotionEffect(new PotionEffect(TANPotions.thirst, 600));
            }
        }
    }
}
