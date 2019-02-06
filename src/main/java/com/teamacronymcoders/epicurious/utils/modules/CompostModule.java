package com.teamacronymcoders.epicurious.utils.modules;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.content.compost.BlockCompostBin;
import com.teamacronymcoders.epicurious.common.content.compost.ItemCompost;
import com.teamacronymcoders.epicurious.common.content.compost.TileCompostBin;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Module(value = Epicurious.MODID)
public class CompostModule extends ModuleBase {

    @Override
    public String getName() {
        return "Compost";
    }

    @Override
    public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
        blockRegistry.register(new BlockCompostBin());
        GameRegistry.registerTileEntity(TileCompostBin.class, new ResourceLocation(Epicurious.MODID, "_compost_bin"));
    }

    @Override
    public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
        itemRegistry.register(new ItemCompost());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

    }
}
