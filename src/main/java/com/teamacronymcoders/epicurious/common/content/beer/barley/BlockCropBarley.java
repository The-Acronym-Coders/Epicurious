package com.teamacronymcoders.epicurious.common.content.beer.barley;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.defaults.DefaultBlockCrop;

public class BlockCropBarley extends DefaultBlockCrop {
    public BlockCropBarley() {
        super(ModItems.seeds_barley, ModItems.barley);
        setUnlocalizedName("crop_barley");
    }
}
