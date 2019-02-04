package com.teamacronymcoders.epicurious.common.content.wine.grape;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.defaults.DefaultFoodItem;

public class ItemGrapes extends DefaultFoodItem {

    public ItemGrapes() {
        super(3, 0.1f, false);
        setUnlocalizedName(Epicurious.MODID + ".item_grape");
        setRegistryName("item_grape");
    }
}
