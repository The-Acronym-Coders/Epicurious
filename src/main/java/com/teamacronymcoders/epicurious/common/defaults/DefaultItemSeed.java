package com.teamacronymcoders.epicurious.common.defaults;

import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class DefaultItemSeed extends ItemSeeds {
    public DefaultItemSeed(Block crops, Block soil) {
        super(crops, soil);
        setCreativeTab(Epicurious.TAB);
    }
}
