package com.teamacronymcoders.epicurious.utils.modules;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.api.CompostMaterialsAPI;
import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.content.wine.ItemPomace;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidBlockGrapeJuice;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidBlockWine;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidGrapeJuice;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidWine;
import com.teamacronymcoders.epicurious.common.content.wine.grape.BlockCropGrape;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapeSeeds;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapes;
import com.teamacronymcoders.epicurious.common.recipes.brewing.RecipeBrewingWine;
import com.teamacronymcoders.epicurious.common.recipes.crushing.RecipeCrushingGrapeJuice;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

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

        Fluid grape_juice = new FluidGrapeJuice();
        FluidRegistry.registerFluid(grape_juice);
        FluidRegistry.addBucketForFluid(grape_juice);

        blockRegistry.register(new BlockCropGrape());
        blockRegistry.register(new FluidBlockWine(wine));
        blockRegistry.register(new FluidBlockGrapeJuice(grape_juice));
    }

    @Override
    public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
        itemRegistry.register(new ItemGrapes());
        itemRegistry.register(new ItemGrapeSeeds());
        itemRegistry.register(new ItemPomace());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        RecipeCrushingGrapeJuice.setupCrushingRecipe();
        RecipeBrewingWine.setupWineBrewingRecipe();
        CompostMaterialsAPI.addMaterialToList(ModItems.pomace);
    }
}
