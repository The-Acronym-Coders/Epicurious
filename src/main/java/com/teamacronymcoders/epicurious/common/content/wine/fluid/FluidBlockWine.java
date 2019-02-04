package com.teamacronymcoders.epicurious.common.content.wine.fluid;

import com.teamacronymcoders.base.blocks.BlockFluidBase;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModFluids;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class FluidBlockWine extends BlockFluidBase {

    public FluidBlockWine() {
        super("wine", ModFluids.wine, new Material(MapColor.WATER));
        setUnlocalizedName(Epicurious.MODID + ".fluid.wine");
        setRegistryName("fluid_wine");
    }

}
