package com.teamacronymcoders.epicurious.common.content.beer.barley;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.defaults.DefaultBlockCrop;
import com.teamacronymcoders.epicurious.common.ModItems;

public class BlockCropBarley extends DefaultBlockCrop {
    public BlockCropBarley() {
        super(ModItems.seeds_barley, ModItems.barley);
        setUnlocalizedName(Epicurious.MODID + ".crop_barley");
        setRegistryName("crop_barley");
    }
}
