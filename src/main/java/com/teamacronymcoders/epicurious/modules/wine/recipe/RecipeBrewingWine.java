package com.teamacronymcoders.epicurious.modules.wine.recipe;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.survivalism.common.recipe.RecipeHelper;
import net.minecraft.init.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

public class RecipeBrewingWine {
    private static ResourceLocation id = new ResourceLocation(Epicurious.MODID, "wine");
    private static FluidStack inputStack = FluidRegistry.getFluidStack("grape_juice", 1000);
    private static Map<Ingredient, Integer> wineIngredientMap = new HashMap<>();
    private static FluidStack outputStack = FluidRegistry.getFluidStack("wine", 1000);
    private static int ticks = 1600;

    private static void setupBrewIngredients() {
        wineIngredientMap.put(Ingredient.fromItem(ModItems.grapes), 1);
        wineIngredientMap.put(Ingredient.fromItem(ModItems.yeast), 1);
        wineIngredientMap.put(Ingredient.fromItem(Items.SUGAR), 1);
    }

    public static void setupWineBrewingRecipe() {
        setupBrewIngredients();
        RecipeHelper.addBrewingRecipe(id, inputStack, wineIngredientMap, outputStack, ticks);
    }
}
