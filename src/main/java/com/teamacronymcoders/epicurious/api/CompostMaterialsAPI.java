package com.teamacronymcoders.epicurious.api;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.modules.compost.storage.CompostMaterialList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CompostMaterialsAPI {
    private static List<Item> compostMaterial = CompostMaterialList.getCompostMaterials();

    public static void addMaterialToList(Item material) {
        if (compostMaterial.contains(material)) {
            Epicurious.logger.error("Item: " + material.getItemStackDisplayName(new ItemStack(material)) + " is already defined in the Compost Material List!");
        } else {
            compostMaterial.add(material);
        }
    }

    public static void removeMaterialFromList(Item material) {
        if (compostMaterial.contains(material)) {
            compostMaterial.remove(material);
        } else {
            Epicurious.logger.error("Item: " + material.getItemStackDisplayName(new ItemStack(material)) + " is not defined as a valid Compost Material!");
        }
    }

    public static boolean doesListContainMaterial(Item material) {
        return compostMaterial.contains(material);
    }
}
