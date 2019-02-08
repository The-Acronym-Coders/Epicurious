package com.teamacronymcoders.epicurious.modules.wine.grape;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.defaults.DefaultBlockCrop;
import com.teamacronymcoders.epicurious.utils.EpicuriousUtilities;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockCropGrape extends DefaultBlockCrop {
    public static final PropertyBool DIAGONAL_STATE = PropertyBool.create("diagonal");

    public BlockCropGrape() {
        super(ModItems.seeds_grape, ModItems.grapes);
        setUnlocalizedName("crop_grape");
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (EpicuriousUtilities.tryPercentage(0.5)) {
            state.withProperty(DIAGONAL_STATE, true);
        }
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, AGE, DIAGONAL_STATE);
    }
}
