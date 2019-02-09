package com.teamacronymcoders.epicurious.modules.content.wine;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.api.CompostMaterialsAPI;
import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.modules.content.wine.fluid.FluidBlockGrapeJuice;
import com.teamacronymcoders.epicurious.modules.content.wine.fluid.FluidBlockWine;
import com.teamacronymcoders.epicurious.modules.content.wine.fluid.FluidGrapeJuice;
import com.teamacronymcoders.epicurious.modules.content.wine.fluid.FluidWine;
import com.teamacronymcoders.epicurious.modules.content.wine.grape.BlockCropGrape;
import com.teamacronymcoders.epicurious.modules.content.wine.recipe.RecipeBrewingWine;
import com.teamacronymcoders.epicurious.modules.content.wine.recipe.RecipeCrushingGrapeJuice;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Module(value = Epicurious.MODID)
@Mod.EventBusSubscriber
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
        itemRegistry.register(ModItems.grapes);
        itemRegistry.register(ModItems.seeds_grape);
        itemRegistry.register(ModItems.pomace);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        RecipeCrushingGrapeJuice.setupCrushingRecipe();
        RecipeBrewingWine.setupWineBrewingRecipe();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        CompostMaterialsAPI.addMaterialToList(ModItems.pomace);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ModItems.grapes, 0, new ModelResourceLocation("epicurious:grapes", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.seeds_grape, 0, new ModelResourceLocation("epicurious:seeds_grapes", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.pomace, 0, new ModelResourceLocation("epicurious:pomace", "inventory"));
    }
}
