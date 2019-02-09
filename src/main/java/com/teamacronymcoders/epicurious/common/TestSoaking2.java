package com.teamacronymcoders.epicurious.common;

import com.teamacronymcoders.epicurious.Epicurious;
import com.teamacronymcoders.survivalism.common.recipe.RecipeHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TestSoaking2 {
    private static ResourceLocation id = new ResourceLocation(Epicurious.MODID, "leather2");
    private static Ingredient ingredient = Ingredient.fromItem(Items.LEATHER);
    private static FluidStack fluidStack = FluidRegistry.getFluidStack("water", 1000);
    private static ItemStack stack = new ItemStack(Items.ROTTEN_FLESH);
    private static int decrease = 250;
    private static int ticks = 1600;

    public static void setupTestRecipe() {
        RecipeHelper.addSoakingRecipe(id, fluidStack, ingredient, stack, decrease, ticks);
    }
}
