package com.teamacronymcoders.epicurious.modules.patchouli;

import com.teamacronymcoders.epicurious.Epicurious;
import vazkii.patchouli.api.PatchouliAPI;

public class PatchouliCompat {
    public static void setupFlags() {
        PatchouliAPI.instance.setConfigFlag("epicurious:beer", Epicurious.INSTANCE.getModuleHandler().isModuleEnabled("Beer"));
        PatchouliAPI.instance.setConfigFlag("epicurious:compost", Epicurious.INSTANCE.getModuleHandler().isModuleEnabled("Compost"));
        PatchouliAPI.instance.setConfigFlag("epicurious:wine", Epicurious.INSTANCE.getModuleHandler().isModuleEnabled("Wine"));
    }
}
