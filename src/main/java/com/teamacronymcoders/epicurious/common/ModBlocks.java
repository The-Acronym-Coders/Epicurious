package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.modules.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.modules.beer.hops.BlockCropHops;
import com.teamacronymcoders.epicurious.modules.compost.BlockCompostBin;
import com.teamacronymcoders.epicurious.modules.wine.grape.BlockCropGrape;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    @GameRegistry.ObjectHolder("epicurious:crop_grape")
    public static BlockCropGrape grape;

    @GameRegistry.ObjectHolder("epicurious:crop_barley")
    public static BlockCropBarley barley;

    @GameRegistry.ObjectHolder("epicurious:crop_hops")
    public static BlockCropHops hops;

    @GameRegistry.ObjectHolder("epicurious:compost_bin")
    public static BlockCompostBin compostBin;
}
