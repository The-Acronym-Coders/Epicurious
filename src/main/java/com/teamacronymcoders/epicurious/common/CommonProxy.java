package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.common.content.beer.fluid.ParticleBubblesExt;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        Minecraft.getMinecraft().effectRenderer.registerParticle(420, new ParticleBubblesExt.Factory());
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
