package com.teamacronymcoders.epicurious.modules.beer;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.TestSoaking;
import com.teamacronymcoders.epicurious.common.TestSoaking2;
import com.teamacronymcoders.epicurious.modules.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.modules.beer.fluid.FluidBeer;
import com.teamacronymcoders.epicurious.modules.beer.fluid.FluidBlockBeer;
import com.teamacronymcoders.epicurious.modules.beer.hops.BlockCropHops;
import com.teamacronymcoders.epicurious.modules.beer.recipe.RecipeBrewingBeer;
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
        itemRegistry.register(ModItems.barley);
        itemRegistry.register(ModItems.seeds_barley);
        itemRegistry.register(ModItems.hops);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        RecipeBrewingBeer.setupBeerBrewRecipe();
        TestSoaking.setupTestRecipe();
        TestSoaking2.setupTestRecipe();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ModItems.barley, 0, new ModelResourceLocation("epicurious:barley", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.seeds_barley, 0, new ModelResourceLocation("epicurious:seeds_barley", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.hops, 0, new ModelResourceLocation("epicurious:hops", "inventory"));
    }
}
