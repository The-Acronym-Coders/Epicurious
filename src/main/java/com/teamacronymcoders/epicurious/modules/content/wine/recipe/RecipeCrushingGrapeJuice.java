package com.teamacronymcoders.epicurious.modules.content.wine.recipe;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.epicurious.common.ModItems;
import com.teamacronymcoders.survivalism.common.recipe.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipeCrushingGrapeJuice {
    private static ResourceLocation id = new ResourceLocation(Epicurious.MODID, "grape_juice");
    private static Ingredient input = Ingredient.fromItem(ModItems.grapes);
    private static ItemStack output = new ItemStack(ModItems.pomace, 1);
    private static FluidStack outputFluid = FluidRegistry.getFluidStack("grape_juice", 50);
    private static int jumps = 3;

    public static void setupCrushingRecipe() {
        RecipeHelper.addCrushingRecipe(id, input, output, outputFluid, jumps);
    }
}
