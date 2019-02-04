package com.teamacronymcoders.epicurious.common.defaults;

import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraft.item.ItemFood;

public class DefaultFoodItem extends ItemFood {
    public DefaultFoodItem(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(Epicurious.TAB);
    }

}
