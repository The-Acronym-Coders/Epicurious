package com.teamacronymcoders.epicurious.common.defaults;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class DefaultBlockCrop extends BlockCrops {
    Item seed;
    Item crop;

    public DefaultBlockCrop(Item seed, Item crop) {
        this.seed = seed;
        this.crop = crop;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if (getAge(state) == 7) {
            EntityItem itemEntity = new EntityItem(worldIn);
            itemEntity.setItem(new ItemStack(Item.getItemFromBlock(this), MathHelper.getInt(rand, 1, 3)));
            worldIn.spawnEntity(itemEntity);
            withAge(3);
            return true;
        }
        return super.canUseBonemeal(worldIn, rand, pos, state);
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.getInt(worldIn.rand, 1, 2);
    }

    @Override
    public Item getSeed() {
        return seed;
    }

    @Override
    public Item getCrop() {
        return crop;
    }
}
