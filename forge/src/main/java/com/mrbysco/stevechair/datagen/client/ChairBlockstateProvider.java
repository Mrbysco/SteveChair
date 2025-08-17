package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ChairBlockstateProvider extends BlockStateProvider {
	public ChairBlockstateProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, Constants.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		ModelFile model = models().getExistingFile(modLoc("block/steve_chair"));
		simpleBlock(ChairRegistry.STEVE_CHAIR.get(), model);
	}
}
