package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.modules.content.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.modules.content.beer.hops.BlockCropHops;
import com.teamacronymcoders.epicurious.modules.content.compost.BlockCompostBin;
import com.teamacronymcoders.epicurious.modules.content.wine.grape.BlockCropGrape;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    @GameRegistry.ObjectHolder("epicurious:crop_grapes")
    public static BlockCropGrape grape;

    @GameRegistry.ObjectHolder("epicurious:crop_barley")
    public static BlockCropBarley barley;

    @GameRegistry.ObjectHolder("epicurious:crop_hops")
    public static BlockCropHops hops;

    @GameRegistry.ObjectHolder("epicurious:compost_bin")
    public static BlockCompostBin compostBin;
}
