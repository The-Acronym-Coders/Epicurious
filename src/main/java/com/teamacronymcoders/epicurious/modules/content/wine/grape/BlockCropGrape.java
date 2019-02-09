package com.teamacronymcoders.epicurious.modules.content.wine.grape;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.epicurious.common.defaults.DefaultBlockCrop;

public class BlockCropGrape extends DefaultBlockCrop {
    public BlockCropGrape() {
        super(ModItems.seeds_grape, ModItems.grapes);
        setTranslationKey("crop_grapes");
    }
}
