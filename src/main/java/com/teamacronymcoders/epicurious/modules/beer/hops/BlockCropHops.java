package com.teamacronymcoders.epicurious.modules.beer.hops;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.defaults.DefaultBlockCrop;

public class BlockCropHops extends DefaultBlockCrop {
    public BlockCropHops() {
        super(ModItems.hops, ModItems.hops);
        setUnlocalizedName("crop_hops");
    }
}
