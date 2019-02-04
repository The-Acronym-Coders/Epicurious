package com.teamacronymcoders.epicurious.common.content.wine.grape;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModBlocks;
import com.teamacronymcoders.epicurious.common.defaults.DefaultItemSeed;
import net.minecraft.init.Blocks;

public class ItemGrapeSeeds extends DefaultItemSeed {

    public ItemGrapeSeeds() {
        super(ModBlocks.grape, Blocks.FARMLAND);
        setUnlocalizedName(Epicurious.MODID + ".seed_grape");
    }


}
