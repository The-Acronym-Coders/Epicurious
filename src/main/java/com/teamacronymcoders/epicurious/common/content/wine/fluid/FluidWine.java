package com.teamacronymcoders.epicurious.common.content.wine.fluid;

import com.teamacronymcoders.base.util.Coloring;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.utils.EpicuriousConstants;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;

public class FluidWine extends Fluid {
    public FluidWine() {
        super("wine", EpicuriousConstants.still, EpicuriousConstants.flowing, Coloring.fromHex("8e3155").getIntColor());
        setRarity(EnumRarity.COMMON);
        setUnlocalizedName(Epicurious.MODID + ".fluid.wine");
    }
}
