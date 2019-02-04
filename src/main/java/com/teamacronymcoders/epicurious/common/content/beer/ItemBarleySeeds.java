package com.teamacronymcoders.epicurious.common.content.beer;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModBlocks;
import com.teamacronymcoders.epicurious.common.defaults.DefaultItemSeed;
import net.minecraft.init.Blocks;

public class ItemBarleySeeds extends DefaultItemSeed {

    public ItemBarleySeeds() {
        super(ModBlocks.barley, Blocks.FARMLAND);
        setUnlocalizedName(Epicurious.MODID + ".seed_barley");
        setRegistryName("seed_barley");
    }

}