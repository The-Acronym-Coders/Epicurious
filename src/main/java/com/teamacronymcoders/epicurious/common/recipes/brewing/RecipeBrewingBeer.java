package com.teamacronymcoders.epicurious.common.recipes.brewing;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.survivalism.common.recipe.RecipeHelper;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

public class RecipeBrewingBeer {
    private static FluidStack inputStack = FluidRegistry.getFluidStack("water", 1000);
    private static Map<Ingredient, Integer> beerIngredientMap = new HashMap<>();
    private static FluidStack outputStack = FluidRegistry.getFluidStack("beer", 1000);
    private static int ticks = 1600;

    private static void setupBrewIngredients() {
        beerIngredientMap.put(Ingredient.fromItem(ModItems.barley), 1);
        beerIngredientMap.put(Ingredient.fromItem(ModItems.yeast), 1);
        beerIngredientMap.put(Ingredient.fromItem(ModItems.hops), 1);
    }

    public static void setupBeerBrewRecipe() {
        setupBrewIngredients();
        RecipeHelper.addBrewingRecipe(inputStack, beerIngredientMap, outputStack, ticks);
    }

}
