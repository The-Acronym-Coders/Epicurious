package com.teamacronymcoders.epicurious.modules.beer.fluid;

import com.teamacronymcoders.base.blocks.BlockFluidBase;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class FluidBlockBeer extends BlockFluidBase {
    public FluidBlockBeer(Fluid fluid) {
        super("beer", fluid, new Material(MapColor.WATER));
        setUnlocalizedName(Epicurious.MODID + ".fluid.beer");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        for (int i = 0; i < 1; i++) {
            double x = (double) (pos.getX() + 1) - rand.nextDouble();
            double y = (double) pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
            double z = (double) pos.getZ() + rand.nextDouble();
            worldIn.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, x, y, z, 0d, 0.155d, 0d);
            Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(420, x, y, z, 0d, 0.2d, 0d);
        }
    }

    @Override
    public ResourceLocation getResourceLocation(IBlockState blockState) {
        return new ResourceLocation(Epicurious.MODID, "beer");
    }
}
