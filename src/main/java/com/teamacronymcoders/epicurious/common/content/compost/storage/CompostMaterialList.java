package com.teamacronymcoders.epicurious.common.content.compost.storage;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class CompostMaterialList {
    private static List<Item> compost_materials = new ArrayList<>();

    public static List<Item> getCompostMaterials() {
        return compost_materials;
    }
}
