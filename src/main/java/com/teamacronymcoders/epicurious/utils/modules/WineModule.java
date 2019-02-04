package com.teamacronymcoders.epicurious.utils.modules;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidBlockWine;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidWine;
import com.teamacronymcoders.epicurious.common.content.wine.grape.BlockCropGrape;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapeSeeds;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapes;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Module(value = Epicurious.MODID)
public class WineModule extends ModuleBase {

    @Override
    public String getName() {
        return "Wine";
    }

    @Override
    public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
        Fluid wine = new FluidWine();
        FluidRegistry.registerFluid(wine);
        FluidRegistry.addBucketForFluid(wine);
        blockRegistry.register(new BlockCropGrape());
        blockRegistry.register(new FluidBlockWine(wine));
    }

    @Override
    public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
        itemRegistry.register(new ItemGrapes());
        itemRegistry.register(new ItemGrapeSeeds());
    }
}
