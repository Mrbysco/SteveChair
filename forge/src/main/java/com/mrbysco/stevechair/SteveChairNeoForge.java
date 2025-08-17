package com.mrbysco.stevechair;

import com.mrbysco.stevechair.client.ClientHandler;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Constants.MOD_ID)
public class SteveChairNeoForge {

	public SteveChairNeoForge(IEventBus eventBus, Dist dist) {
		CommonClass.init();

		eventBus.addListener(this::addTabContents);

		if (dist.isClient()) {
			eventBus.addListener(ClientHandler::registerEntityRenders);
		}
	}

	private void addTabContents(final BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.accept(ChairRegistry.STEVE_CHAIR.get());
		}
	}
}