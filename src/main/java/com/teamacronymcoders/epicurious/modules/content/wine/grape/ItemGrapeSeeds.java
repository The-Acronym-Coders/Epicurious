package com.teamacronymcoders.epicurious.modules.content.wine.grape;

import com.teamacronymcoders.epicurious.common.ModBlocks;
import com.teamacronymcoders.epicurious.common.defaults.DefaultItemSeed;
import net.minecraft.init.Blocks;

public class ItemGrapeSeeds extends DefaultItemSeed {

    public ItemGrapeSeeds() {
        super(ModBlocks.grape, Blocks.FARMLAND);
        setTranslationKey("seed_grape");
    }


}
