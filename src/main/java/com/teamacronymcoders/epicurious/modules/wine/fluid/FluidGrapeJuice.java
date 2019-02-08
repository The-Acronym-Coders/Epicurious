package com.teamacronymcoders.epicurious.modules.wine.fluid;

import com.teamacronymcoders.base.util.Coloring;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.utils.EpicuriousConstants;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;

public class FluidGrapeJuice extends Fluid {
    public FluidGrapeJuice() {
        super("grape_juice", EpicuriousConstants.still, EpicuriousConstants.flowing, Coloring.fromHex("63344b").getIntColor());
        setRarity(EnumRarity.COMMON);
        setUnlocalizedName(Epicurious.MODID + ".grape_juice");
    }
}
