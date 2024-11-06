package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.SteveChairMod;
import com.mrbysco.stevechair.registry.ChairRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ChairBlockstateProvider extends BlockStateProvider {
	public ChairBlockstateProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, SteveChairMod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		ModelFile model = models().getExistingFile(modLoc("block/steve_chair"));
		simpleBlock(ChairRegistry.STEVE_CHAIR.value(), model);
	}
}
