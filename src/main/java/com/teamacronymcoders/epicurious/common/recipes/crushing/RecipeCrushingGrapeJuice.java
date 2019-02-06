package com.teamacronymcoders.epicurious.common.recipes.crushing;

import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.survivalism.common.recipe.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipeCrushingGrapeJuice {
    private static Ingredient input = Ingredient.fromItem(ModItems.grapes);
    private static ItemStack output = new ItemStack(ModItems.pomace, 1);
    private static FluidStack outputFluid = FluidRegistry.getFluidStack("grape_juice", 50);
    private static int jumps = 3;

    public static void setupCrushingRecipe() {
        RecipeHelper.addCrushingRecipe(input, output, outputFluid, jumps);
    }
}
