package com.teamacronymcoders.epicurious.common.content.compost;

import com.teamacronymcoders.base.blocks.BlockBase;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.api.CompostMaterialsAPI;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCompostBin extends BlockBase {
    public static PropertyInteger Compost_Amount = PropertyInteger.create("compost", 0, 11);

    public BlockCompostBin() {
        super(Material.WOOD);
        setCreativeTab(Epicurious.TAB);
        setUnlocalizedName("compost_bin");
        setSoundType(SoundType.WOOD);
        setLightOpacity(0);
    }

    private TileCompostBin getTE(World world, BlockPos pos) {
        if (world.getTileEntity(pos) != null) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileCompostBin) {
                return (TileCompostBin) te;
            }
        }
        return null;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileCompostBin bin = getTE(worldIn, pos);

        if (bin == null) {
            return false;
        }

        if (worldIn.isRemote) {
            return true;
        }

        ItemStack materialStack = playerIn.getHeldItem(hand);

        if (CompostMaterialsAPI.doesListContainMaterial(materialStack.getItem())) {
            materialStack.shrink(1);
            bin.addCompost(playerIn);
        }

        return true;
    }

    @Override
    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
        return true;
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(Compost_Amount, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(Compost_Amount);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileCompostBin();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, Compost_Amount);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
