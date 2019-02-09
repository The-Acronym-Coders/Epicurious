package com.teamacronymcoders.epicurious.modules.content.wine.fluid;

import com.teamacronymcoders.base.blocks.BlockFluidBase;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBlockWine extends BlockFluidBase {

    public FluidBlockWine(Fluid fluid) {
        super("wine", fluid, new Material(MapColor.WATER));
        setTranslationKey(Epicurious.MODID + ".fluid.wine");
    }

    @Override
    public ResourceLocation getResourceLocation(IBlockState blockState) {
        return new ResourceLocation(Epicurious.MODID, "wine");
    }
}
