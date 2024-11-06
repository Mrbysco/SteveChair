package com.mrbysco.stevechair.datagen;

import com.mrbysco.stevechair.datagen.client.ChairBlockstateProvider;
import com.mrbysco.stevechair.datagen.client.ChairItemModelProvider;
import com.mrbysco.stevechair.datagen.client.ChairLanguageProvider;
import com.mrbysco.stevechair.datagen.server.ChairLootProvider;
import com.mrbysco.stevechair.datagen.server.ChairRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ChairDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new ChairLootProvider(packOutput, lookupProvider));
			generator.addProvider(event.includeServer(), new ChairRecipeProvider(packOutput, lookupProvider));
		}
		if (event.includeClient()) {
			generator.addProvider(event.includeClient(), new ChairLanguageProvider(packOutput));
			generator.addProvider(event.includeClient(), new ChairBlockstateProvider(packOutput, helper));
			generator.addProvider(event.includeClient(), new ChairItemModelProvider(packOutput, helper));
		}
	}
}
