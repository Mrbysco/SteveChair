package com.mrbysco.stevechair;

import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class SteveChairFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		CommonClass.init();

		addTabContents();
	}

	public void addTabContents() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register((entries) -> entries.accept(ChairRegistry.STEVE_CHAIR.get()));
	}
}
