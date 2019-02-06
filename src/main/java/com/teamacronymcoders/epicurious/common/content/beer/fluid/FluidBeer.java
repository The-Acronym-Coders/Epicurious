package com.teamacronymcoders.epicurious.common.content.beer.fluid;

import com.teamacronymcoders.base.util.Coloring;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.utils.EpicuriousConstants;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;

public class FluidBeer extends Fluid {
    public FluidBeer() {
        super("beer", EpicuriousConstants.still, EpicuriousConstants.flowing, Coloring.fromHex("f28e1c").getIntColor());
        setRarity(EnumRarity.COMMON);
        setUnlocalizedName(Epicurious.MODID + ".beer");
    }
}
