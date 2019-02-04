package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.common.content.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.common.content.wine.grape.BlockCropGrape;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    @GameRegistry.ObjectHolder("epicurious:crop_grape")
    public static BlockCropGrape grape;

    @GameRegistry.ObjectHolder("epicurious:crop_barley")
    public static BlockCropBarley barley;
}
