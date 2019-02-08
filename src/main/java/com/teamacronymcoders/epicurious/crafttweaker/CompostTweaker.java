package com.teamacronymcoders.epicurious.crafttweaker;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.api.CompostMaterialsAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@ZenClass("mods.epicurious.Compost")
@ZenRegister
public class CompostTweaker {
    @ZenMethod
    public static void addCompostMaterial(IIngredient ingredient) {
        Epicurious.LATE_ADDITIONS.add(new CompostAddition(ingredient));
    }

    @ZenMethod
    public static void removeCompostMaterial(IIngredient ingredient) {
        Epicurious.LATE_REMOVALS.add(new CompostRemoval(ingredient));
    }

    private static class CompostAddition implements IAction {
        List<ItemStack> compostMaterials = new LinkedList<>();
        String commandString;

        CompostAddition(IIngredient ingredient) {
            Ingredient ingredient1 = CraftTweakerMC.getIngredient(ingredient);
            compostMaterials.addAll(Arrays.asList(ingredient1.getMatchingStacks()));
            this.commandString = ingredient.toCommandString();
        }

        @Override
        public void apply() {
            for (ItemStack stack : compostMaterials) {
                CompostMaterialsAPI.addMaterialToList(stack.getItem());
            }
        }

        @Override
        public String describe() {
            return "Added Matching ItemStacks From: " + commandString + " As A Valid Compost Materials!";
        }
    }

    private static class CompostRemoval implements IAction {
        List<ItemStack> compostMaterials = new LinkedList<>();
        String commandString;

        CompostRemoval(IIngredient ingredient) {
            Ingredient ingredient1 = CraftTweakerMC.getIngredient(ingredient);
            compostMaterials.addAll(Arrays.asList(ingredient1.getMatchingStacks()));
            this.commandString = ingredient.toCommandString();
        }

        @Override
        public void apply() {
            for (ItemStack stack : compostMaterials) {
                CompostMaterialsAPI.removeMaterialFromList(stack.getItem());
            }
        }

        @Override
        public String describe() {
            return "Removed Matching ItemStacks From: " + commandString + " As A Valid Compost Materials!";
        }
    }
}
