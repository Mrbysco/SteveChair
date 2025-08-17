package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup.Provider;

import java.util.concurrent.CompletableFuture;

public class ChairLanguageProvider extends FabricLanguageProvider {
	public ChairLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<Provider> completableFuture) {
		super(dataOutput, completableFuture);
	}

	@Override
	public void generateTranslations(Provider registryLookup, TranslationBuilder builder) {
		builder.add(ChairRegistry.STEVE_CHAIR.get(), "Steve Chair");

	}
}
