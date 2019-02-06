package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.common.content.ItemYeast;
import com.teamacronymcoders.epicurious.common.content.beer.ItemBarleySeeds;
import com.teamacronymcoders.epicurious.common.content.beer.barley.ItemBarley;
import com.teamacronymcoders.epicurious.common.content.beer.hops.ItemHops;
import com.teamacronymcoders.epicurious.common.content.compost.ItemCompost;
import com.teamacronymcoders.epicurious.common.content.wine.ItemPomace;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapeSeeds;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    @GameRegistry.ObjectHolder("epicurious:yeast")
    public static ItemYeast yeast = new ItemYeast();

    @GameRegistry.ObjectHolder("epicurious:compost")
    public static ItemCompost compost = new ItemCompost();


    @GameRegistry.ObjectHolder("epicurious:grape_seeds")
    public static ItemGrapeSeeds seeds_grape = new ItemGrapeSeeds();

    @GameRegistry.ObjectHolder("epicurious:grapes")
    public static ItemGrapes grapes = new ItemGrapes();

    @GameRegistry.ObjectHolder("epicurious:pomace")
    public static ItemPomace pomace = new ItemPomace();


    @GameRegistry.ObjectHolder("epicurious:barley_seeds")
    public static ItemBarleySeeds seeds_barley = new ItemBarleySeeds();

    @GameRegistry.ObjectHolder("epicurious:barley")
    public static ItemBarley barley = new ItemBarley();

    @GameRegistry.ObjectHolder("epicurious:hops")
    public static ItemHops hops = new ItemHops();
}
