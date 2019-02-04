package com.teamacronymcoders.epicurious.common.content.wine.fluid;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.utils.EpicuriousConstants;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;

public class FluidWine extends Fluid {
    public FluidWine() {
        super("wine", EpicuriousConstants.still, EpicuriousConstants.flowing, 8722456);
        setRarity(EnumRarity.COMMON);
        setUnlocalizedName(Epicurious.MODID + ".fluid.wine");
    }


}
