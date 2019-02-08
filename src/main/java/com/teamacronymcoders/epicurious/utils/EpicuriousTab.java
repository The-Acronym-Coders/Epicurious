package com.teamacronymcoders.epicurious.utils;

import com.teamacronymcoders.epicurious.common.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EpicuriousTab extends CreativeTabs {
    public EpicuriousTab() {
        super("epicurious");
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.grapes);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
