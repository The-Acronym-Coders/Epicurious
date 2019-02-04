package com.teamacronymcoders.epicurious.common.content;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.defaults.DefaultItem;

public class ItemYeast extends DefaultItem {
    public ItemYeast() {
        setUnlocalizedName(Epicurious.MODID + ".item_yeast");
        setRegistryName("item_yeast");
    }
}
