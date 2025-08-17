package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceLocation;

public class ChairModelProvider extends FabricModelProvider {
	public ChairModelProvider(FabricDataOutput packOutput) {
		super(packOutput);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockModels) {
		blockModels.blockStateOutput.accept(
				BlockModelGenerators.createSimpleBlock(ChairRegistry.STEVE_CHAIR.get(), BlockModelGenerators.plainVariant(modLoc("block/steve_chair")))
		);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {

	}

	private ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
	}
}
