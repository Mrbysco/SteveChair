package com.mrbysco.stevechair.datagen.server;

import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ChairRecipeProvider extends RecipeProvider {

	public ChairRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
		super(provider, recipeOutput);
	}

	@Override
	protected void buildRecipes() {
		shaped(RecipeCategory.MISC, ChairRegistry.STEVE_CHAIR.get())
				.pattern(" H ")
				.pattern("YCY")
				.pattern("BBB")
				.define('H', Items.BROWN_WOOL)
				.define('Y', Items.YELLOW_WOOL)
				.define('C', Items.CYAN_WOOL)
				.define('B', Items.BLUE_WOOL)
				.unlockedBy("has_brown_wool", has(Items.BROWN_WOOL))
				.unlockedBy("has_yellow_wool", has(Items.YELLOW_WOOL))
				.unlockedBy("has_cyan_wool", has(Items.CYAN_WOOL))
				.unlockedBy("has_blue_wool", has(Items.BLUE_WOOL))
				.save(output);
	}

	public static class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<Provider> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
			return new ChairRecipeProvider(provider, recipeOutput);
		}

		@Override
		public String getName() {
			return "Steve Chair recipes";
		}
	}
}
