package com.mrbysco.stevechair.datagen;

import com.mrbysco.stevechair.datagen.client.ChairLanguageProvider;
import com.mrbysco.stevechair.datagen.client.ChairModelProvider;
import com.mrbysco.stevechair.datagen.server.ChairLootProvider;
import com.mrbysco.stevechair.datagen.server.ChairRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ChairDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		var pack = generator.createPack();

		pack.addProvider(ChairLootProvider::new);
		pack.addProvider(ChairRecipeProvider::new);

		pack.addProvider(ChairLanguageProvider::new);
		pack.addProvider(ChairModelProvider::new);
	}
}
