package com.mrbysco.stevechair.datagen;

import com.mrbysco.stevechair.datagen.client.ChairLanguageProvider;
import com.mrbysco.stevechair.datagen.client.ChairModelprovider;
import com.mrbysco.stevechair.datagen.server.ChairLootProvider;
import com.mrbysco.stevechair.datagen.server.ChairRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class ChairDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new ChairLootProvider(packOutput, lookupProvider));
		generator.addProvider(true, new ChairRecipeProvider.Runner(packOutput, lookupProvider));


		generator.addProvider(true, new ChairLanguageProvider(packOutput));
		generator.addProvider(true, new ChairModelprovider(packOutput));

	}
}
