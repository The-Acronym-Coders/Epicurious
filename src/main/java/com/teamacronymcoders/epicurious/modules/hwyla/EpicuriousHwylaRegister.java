package com.teamacronymcoders.epicurious.modules.hwyla;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.modules.compost.BlockCompostBin;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.WailaPlugin;

@WailaPlugin
public class EpicuriousHwylaRegister implements IWailaPlugin {
    @Override
    public void register(IWailaRegistrar registrar) {
        if (Epicurious.INSTANCE.getModuleHandler().isModuleEnabled("Hwyla")) {
            registrar.addConfig(Epicurious.MODID, "epicurious.compost", "Compost", true);
            registrar.registerBodyProvider(new HwylaCompatProvider(), BlockCompostBin.class);
        }
    }
}
