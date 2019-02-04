package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.common.content.beer.barley.ItemBarley;
import com.teamacronymcoders.epicurious.common.content.wine.grape.BlockCropGrape;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapeSeeds;
import com.teamacronymcoders.epicurious.utils.EpicuriousConfigs;
import com.teamacronymcoders.epicurious.common.content.ItemYeast;
import com.teamacronymcoders.epicurious.common.content.beer.ItemBarleySeeds;
import com.teamacronymcoders.epicurious.common.content.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidBlockWine;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        if (EpicuriousConfigs.enableWineContent) {
            FluidRegistry.registerFluid(ModFluids.wine);
            FluidRegistry.addBucketForFluid(ModFluids.wine);
            event.getRegistry().registerAll(
                    new BlockCropGrape(),
                    new FluidBlockWine()
            );
        }
        if (EpicuriousConfigs.enableBeerContent) {
            event.getRegistry().registerAll(
                    new BlockCropBarley()
            );
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemYeast()
        );

        if (EpicuriousConfigs.enableWineContent) {
            event.getRegistry().registerAll(
                    new ItemGrapes(),
                    new ItemGrapeSeeds()
            );
        }
        if (EpicuriousConfigs.enableBeerContent) {
            event.getRegistry().registerAll(
                    new ItemBarley(),
                    new ItemBarleySeeds()
            );
        }

    }

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
