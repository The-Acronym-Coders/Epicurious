package com.teamacronymcoders.epicurious.modules.patchouli.componentProcessors;

import com.teamacronymcoders.survivalism.common.recipe.RecipeStorage;
import com.teamacronymcoders.survivalism.common.recipe.recipes.RecipeBarrel;
import com.teamacronymcoders.survivalism.common.recipe.recipes.barrel.BrewingRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidUtil;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariableProvider;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProcessorBrewingRecipe implements IComponentProcessor {

    private ItemStack inputFluid;
    private ItemStack outputFluid;
    private BrewingRecipe recipe;
    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public void setup(IVariableProvider<String> iVariableProvider) {
        ResourceLocation id = new ResourceLocation(iVariableProvider.get("recipeID"));
        RecipeBarrel recipe = RecipeStorage.getBrewingRecipeByID(id);
        if (recipe instanceof BrewingRecipe) {
            this.recipe = (BrewingRecipe) recipe;
        }
    }

    private void initRecipeVars() {
        inputFluid = FluidUtil.getFilledBucket(recipe.getInputFluid());
        Set<Ingredient> keys = recipe.getInputIngredientsMap().keySet();
        ingredients.addAll(keys);
        outputFluid = FluidUtil.getFilledBucket(recipe.getOutputFluid());
    }

    @Override
    public String process(String s) {
        initRecipeVars();
        switch (s) {
            case "inputFluid":
                return PatchouliAPI.instance.serializeItemStack(inputFluid);
            case "ingredient0":
                return PatchouliAPI.instance.serializeIngredient(ingredients.get(0));
            case "ingredient1":
                return PatchouliAPI.instance.serializeIngredient(ingredients.get(1));
            case "ingredient2":
                return PatchouliAPI.instance.serializeIngredient(ingredients.get(2));
            case "outputFluid":
                return PatchouliAPI.instance.serializeItemStack(outputFluid);
            case "ticks":
                return String.valueOf(recipe.getTicks());
            case "time":
                return recipe.getTicks() / 20 + " Seconds";
        }
        return null;
    }
}
