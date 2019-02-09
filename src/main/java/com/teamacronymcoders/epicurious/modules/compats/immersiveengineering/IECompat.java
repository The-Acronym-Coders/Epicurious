package com.teamacronymcoders.epicurious.modules.compats.immersiveengineering;

import blusunrize.immersiveengineering.api.tool.BelljarHandler;
import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModBlocks;
import com.teamacronymcoders.epicurious.common.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Module(value = Epicurious.MODID)
public class IECompat extends ModuleBase {
    @Override
    public String getName() {
        return "Immersive Engineering";
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        BelljarHandler.registerBasicItemFertilizer(new ItemStack(ModItems.compost), 1.75f);
        BelljarHandler.cropHandler.register(
                new ItemStack(ModItems.seeds_grape),
                new ItemStack[]{new ItemStack(ModItems.grapes, MathHelper.getInt(Epicurious.RANDOM, 1, 3)), new ItemStack(ModItems.seeds_grape, MathHelper.getInt(Epicurious.RANDOM, 1, 2))},
                new ItemStack(Blocks.DIRT),
                ModBlocks.grape.getDefaultState());
        BelljarHandler.cropHandler.register(
                new ItemStack(ModItems.seeds_barley),
                new ItemStack[] {new ItemStack(ModItems.barley, MathHelper.getInt(Epicurious.RANDOM, 1, 3)), new ItemStack(ModItems.seeds_barley, MathHelper.getInt(Epicurious.RANDOM, 1, 2))},
                new ItemStack(Blocks.DIRT),
                ModBlocks.barley.getDefaultState());
        BelljarHandler.cropHandler.register(
                new ItemStack(ModItems.hops),
                new ItemStack[]{new ItemStack(ModItems.hops, MathHelper.getInt(Epicurious.RANDOM, 1, 3))},
                new ItemStack(Blocks.DIRT),
                ModBlocks.hops.getDefaultState()
        );
    }
}
