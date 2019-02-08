package com.teamacronymcoders.epicurious.modules.compost;

import com.teamacronymcoders.epicurious.common.defaults.DefaultItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCompost extends DefaultItem {
    public ItemCompost() {
        setUnlocalizedName("compost");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos, facing, stack)) {
            return EnumActionResult.FAIL;
        }

        BlockPos minPos = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1);
        BlockPos maxPos = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1);

        for (BlockPos truePos : BlockPos.getAllInBoxMutable(minPos, maxPos)) {
            if (ItemDye.applyBonemeal(stack, worldIn, truePos, player, hand)) {
                if (!worldIn.isRemote) {
                    worldIn.playEvent(2005, truePos, 0);
                }
            }
        }

        return EnumActionResult.PASS;
    }
}
