package com.teamacronymcoders.epicurious.utils;

import com.teamacronymcoders.base.registrysystem.config.ConfigEntry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class EpicuriousConfigs {

    private static ConfigRegistry registry = Epicurious.INSTANCE.getRegistry(ConfigRegistry.class, "CONFIG");

    public static void preInitLoadConfigs(FMLPreInitializationEvent event) {
        generateConfigs();
        getConfValues();
    }

    private static void generateConfigs() {
        addEntriesToRegistry();
    }

    private static void getConfValues() {

    }

    private static void addEntriesToRegistry(ConfigEntry... values) {
        for (ConfigEntry entry : values) {
            registry.addEntry(entry);
        }
    }
}
