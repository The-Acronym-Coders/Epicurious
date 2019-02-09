package com.teamacronymcoders.epicurious.modules.wine.fluid;

import com.teamacronymcoders.base.blocks.BlockFluidBase;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBlockGrapeJuice extends BlockFluidBase {
    public FluidBlockGrapeJuice(Fluid fluid) {
        super("grape_juice", fluid, new Material(MapColor.WATER));
        setTranslationKey(Epicurious.MODID + ".fluid.grape_juice");
    }

    @Override
    public ResourceLocation getResourceLocation(IBlockState blockState) {
        return new ResourceLocation(Epicurious.MODID, "grape_juice");
    }
}
