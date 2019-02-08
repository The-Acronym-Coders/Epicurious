package com.teamacronymcoders.epicurious.modules.theoneprobe;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Module(value = Epicurious.MODID)
public class TheOneProbeModule extends ModuleBase {
    private static boolean registered;

    @Override
    public String getName() {
        return "theoneprobe";
    }

    public static void register() {
        if (registered) {
            return;
        }

        registered = true;
        FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", "com.teamacronymcoders.epicurious.modules.theoneprobe.TOPCompat");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        register();
    }
}
