package com.teamacronymcoders.epicurious.utils.modules;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.content.beer.ItemBarleySeeds;
import com.teamacronymcoders.epicurious.common.content.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.common.content.beer.barley.ItemBarley;
import com.teamacronymcoders.epicurious.common.content.beer.fluid.FluidBeer;
import com.teamacronymcoders.epicurious.common.content.beer.fluid.FluidBlockBeer;
import com.teamacronymcoders.epicurious.common.content.beer.hops.BlockCropHops;
import com.teamacronymcoders.epicurious.common.content.beer.hops.ItemHops;
import com.teamacronymcoders.epicurious.common.recipes.brewing.RecipeBrewingBeer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Module(value = Epicurious.MODID)
public class BeerModule extends ModuleBase {
    @Override
    public String getName() {
        return "Beer";
    }

    @Override
    public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
        Fluid beer = new FluidBeer();
        FluidRegistry.registerFluid(beer);
        FluidRegistry.addBucketForFluid(beer);
        blockRegistry.register(new BlockCropBarley());
        blockRegistry.register(new BlockCropHops());
        blockRegistry.register(new FluidBlockBeer(beer));
    }

    @Override
    public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
        itemRegistry.register(new ItemBarley());
        itemRegistry.register(new ItemBarleySeeds());
        itemRegistry.register(new ItemHops());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        RecipeBrewingBeer.setupBeerBrewRecipe();
    }
}
