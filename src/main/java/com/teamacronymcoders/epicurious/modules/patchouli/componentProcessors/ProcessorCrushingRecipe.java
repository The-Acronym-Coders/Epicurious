package com.teamacronymcoders.epicurious.modules.patchouli.componentProcessors;

import com.teamacronymcoders.survivalism.common.recipe.RecipeStorage;
import com.teamacronymcoders.survivalism.common.recipe.recipes.RecipeVat;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariableProvider;
import vazkii.patchouli.api.PatchouliAPI;

public class ProcessorCrushingRecipe implements IComponentProcessor {

    private Ingredient ingredient;
    private ItemStack fluid;
    private ItemStack output;

    private RecipeVat recipe;

    @Override
    public void setup(IVariableProvider<String> iVariableProvider) {
        ResourceLocation id = new ResourceLocation(iVariableProvider.get("recipeID"));
        this.recipe = RecipeStorage.getCrushingRecipeByID(id);
    }

    private void initRecipeVars() {
        ingredient = recipe.getInputIngredient();
        fluid = new ItemStack(Items.BUCKET, 1);
        fluid.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null).fill(new FluidStack(recipe.getOutputFluid().getFluid(), 1000), true);
        output = recipe.getOutputStack();
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
                return PatchouliAPI.instance.serializeItemStack(output);
            case "chance":
                if (recipe.getChanceOutput() <= 0 || recipe.getChanceOutput() >= 1) {
                    return "100%";
                }
                return recipe.getChanceOutput() * 100 + "%";
            case "jumps":
                return String.valueOf(recipe.getJumps());
        }
        return null;
    }
}
