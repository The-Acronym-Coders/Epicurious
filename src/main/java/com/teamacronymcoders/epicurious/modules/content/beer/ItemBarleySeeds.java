package com.teamacronymcoders.epicurious.modules.content.beer;

import com.teamacronymcoders.epicurious.common.ModBlocks;
import com.teamacronymcoders.epicurious.common.defaults.DefaultItemSeed;
import net.minecraft.init.Blocks;

public class ItemBarleySeeds extends DefaultItemSeed {

    public ItemBarleySeeds() {
        super(ModBlocks.barley, Blocks.FARMLAND);
        setTranslationKey("seed_barley");
    }

}
