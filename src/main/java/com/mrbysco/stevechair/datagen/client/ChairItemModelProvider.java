package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.SteveChairMod;
import com.mrbysco.stevechair.registry.ChairRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ChairItemModelProvider extends ItemModelProvider {
	public ChairItemModelProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, SteveChairMod.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		withBlockParent(ChairRegistry.STEVE_CHAIR.getId());
	}

	private void withBlockParent(ResourceLocation location) {
		withExistingParent(location.getPath(), modLoc("block/" + location.getPath()));
	}
}
