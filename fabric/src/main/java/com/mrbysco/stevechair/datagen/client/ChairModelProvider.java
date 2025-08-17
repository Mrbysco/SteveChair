package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceLocation;

public class ChairModelProvider extends FabricModelProvider {
	public ChairModelProvider(FabricDataOutput packOutput) {
		super(packOutput);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
		blockStateModelGenerator.blockStateOutput.accept(
				BlockModelGenerators.createSimpleBlock(ChairRegistry.STEVE_CHAIR.get(), modLoc("block/steve_chair"))
		);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {

	}

	private ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
	}
}
