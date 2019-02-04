package com.teamacronymcoders.epicurious.utils;

import com.teamacronymcoders.base.registrysystem.config.ConfigEntry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class EpicuriousConfigs {
    public static boolean enableWineContent;
    public static boolean enableBeerContent;
    public static boolean enableBreadContent;

    private static ConfigRegistry registry = Epicurious.INSTANCE.getRegistry(ConfigRegistry.class, "CONFIG");

    public static void preInitLoadConfigs(FMLPreInitializationEvent event) {
        generateConfigs();
        getConfValues();
    }

    private static void generateConfigs() {
        ConfigEntry enableWineContent = new ConfigEntry("modules", "enableWineContent", Property.Type.BOOLEAN, "true", "Should Grape and Wine content be enabled?", false);
        ConfigEntry enableBeerContent = new ConfigEntry("modules", "enableBeerContent", Property.Type.BOOLEAN, "true", "Should Barley and Beer content be enabled?", false);
        ConfigEntry enableBreadContent = new ConfigEntry("modules", "enableBreadContent", Property.Type.BOOLEAN, "true", "Should Bread and Flour content be enabled?", false);
        addEntriesToRegistry(enableWineContent, enableBeerContent, enableBreadContent);
    }

    private static void getConfValues() {
        enableWineContent = registry.getBoolean("enableWineContent", true);
        enableBeerContent = registry.getBoolean("enableBeerContent", true);
        enableBreadContent = registry.getBoolean("enableBreadContent", true);
    }

    private static void addEntriesToRegistry(ConfigEntry... values) {
        for (ConfigEntry entry : values) {
            registry.addEntry(entry);
        }
    }
}
