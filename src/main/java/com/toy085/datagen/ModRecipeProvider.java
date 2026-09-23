package com.toy085.datagen;

import com.toy085.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.TOOLS, ModItems.Emerald_Axe)
                        .pattern("EE")
                        .pattern("ES")
                        .pattern(" S")
                        .define('E', Items.EMERALD)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.Emerald_Sword)
                        .pattern(" E")
                        .pattern(" E")
                        .pattern(" S")
                        .define('S', Items.STICK)
                        .define('E', Items.EMERALD)
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.Emerald_Pickaxe)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('E', Items.EMERALD)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.Emerald_Shovel)
                        .pattern(" E")
                        .pattern(" S")
                        .pattern(" S")
                        .define('E', Items.EMERALD)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "EmeraldTools Recipes";
    }
}
