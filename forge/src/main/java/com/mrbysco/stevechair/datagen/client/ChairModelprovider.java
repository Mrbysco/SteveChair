package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class ChairModelprovider extends ModelProvider {
	public ChairModelprovider(PackOutput packOutput) {
		super(packOutput, Constants.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		blockModels.blockStateOutput.accept(
				BlockModelGenerators.createSimpleBlock(ChairRegistry.STEVE_CHAIR.get(), BlockModelGenerators.plainVariant(modLoc("block/steve_chair")))
		);
	}

	private ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
	}
}
