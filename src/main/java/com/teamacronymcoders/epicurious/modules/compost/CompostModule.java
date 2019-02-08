package com.teamacronymcoders.epicurious.modules.compost;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModBlocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Module(value = Epicurious.MODID)
@Mod.EventBusSubscriber
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

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.compostBin), 0, new ModelResourceLocation("epicurious:compost_bin", "inventory"));
    }
}
