package com.teamacronymcoders.epicurious.client;

import com.teamacronymcoders.epicurious.common.CommonProxy;
import com.teamacronymcoders.epicurious.modules.content.beer.fluid.ParticleBubblesExt;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {


    @Override
    public void init(FMLInitializationEvent event) {
        Minecraft.getMinecraft().effectRenderer.registerParticle(420, new ParticleBubblesExt.Factory());
    }
}
