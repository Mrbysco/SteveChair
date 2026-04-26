package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.resources.Identifier;

public class ChairModelProvider extends FabricModelProvider {
	public ChairModelProvider(FabricPackOutput packOutput) {
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

	private Identifier modLoc(String path) {
		return Identifier.fromNamespaceAndPath(Constants.MOD_ID, path);
	}
}
