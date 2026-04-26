package com.mrbysco.stevechair.datagen.server;

import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ChairLootProvider extends FabricBlockLootSubProvider {
	public ChairLootProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		this.dropSelf(ChairRegistry.STEVE_CHAIR.get());
	}
}
