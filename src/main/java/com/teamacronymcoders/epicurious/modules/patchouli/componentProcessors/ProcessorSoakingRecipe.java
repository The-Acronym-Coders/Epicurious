package com.teamacronymcoders.epicurious.modules.patchouli.componentProcessors;

import com.teamacronymcoders.survivalism.common.recipe.RecipeStorage;
import com.teamacronymcoders.survivalism.common.recipe.recipes.RecipeBarrel;
import com.teamacronymcoders.survivalism.common.recipe.recipes.barrel.SoakingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariableProvider;
import vazkii.patchouli.api.PatchouliAPI;

public class ProcessorSoakingRecipe implements IComponentProcessor {

    private Ingredient ingredient;
    private ItemStack fluid;
    private ItemStack stack;
    private SoakingRecipe recipe;

    @Override
    public void setup(IVariableProvider<String> iVariableProvider) {
        ResourceLocation id = new ResourceLocation(iVariableProvider.get("recipeID"));
        RecipeBarrel recipe = RecipeStorage.getSoakingRecipeByID(id);
        if (recipe instanceof SoakingRecipe) {
            this.recipe = (SoakingRecipe) recipe;
        }
    }

    private void initRecipeVars() {
        ingredient = recipe.getInputIngredient();
        fluid = new ItemStack(Items.BUCKET, 1);
        fluid.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null).fill(new FluidStack(recipe.getInputFluid().getFluid(), 1000), true);
        stack = recipe.getOutputItemStack();
    }

    @Override
    public String process(String s) {
        initRecipeVars();
        switch (s) {
            case "input":
                return PatchouliAPI.instance.serializeIngredient(ingredient);
            case "fluid":
                return PatchouliAPI.instance.serializeItemStack(fluid);
            case "output":
                return PatchouliAPI.instance.serializeItemStack(stack);
            case "ticks":
                return String.valueOf(recipe.getTicks());
            case "time":
                return recipe.getTicks() / 20 + " Seconds";
        }
        return null;
    }
}
