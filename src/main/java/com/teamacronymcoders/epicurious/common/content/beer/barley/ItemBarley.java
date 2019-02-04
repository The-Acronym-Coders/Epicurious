package com.teamacronymcoders.epicurious.common.content.beer.barley;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.defaults.DefaultItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemBarley extends DefaultItem {

    public ItemBarley() {
        setUnlocalizedName("barley");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = new ItemStack(ModItems.seeds_barley, MathHelper.getInt(worldIn.rand, 1, 3));
        EntityItem itemEntity = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);
        worldIn.spawnEntity(itemEntity);
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
