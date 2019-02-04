package com.teamacronymcoders.epicurious.client;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.CommonProxy;
import com.teamacronymcoders.epicurious.common.ModBlocks;
import com.teamacronymcoders.epicurious.common.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        //Blocks
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.grape), 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModBlocks.grape.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.barley), 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModBlocks.barley.getRegistryName(), "inventory"));

        // Items
        ModelLoader.setCustomModelResourceLocation(ModItems.grapes, 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModItems.grapes.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.seeds_grape, 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModItems.seeds_grape.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.barley, 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModItems.barley.getRegistryName()));
        ModelLoader.setCustomModelResourceLocation(ModItems.seeds_barley, 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModItems.seeds_barley.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.yeast, 0, new ModelResourceLocation(Epicurious.MODID + ":" + ModItems.yeast, "inventory"));
    }
}
