package com.mrbysco.stevechair;

import com.mojang.logging.LogUtils;
import com.mrbysco.stevechair.client.ClientHandler;
import com.mrbysco.stevechair.registry.ChairRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(SteveChairMod.MOD_ID)
public class SteveChairMod {
	public static final String MOD_ID = "steve_chair";
	public static final Logger LOGGER = LogUtils.getLogger();

	public SteveChairMod(IEventBus eventBus, Dist dist, ModContainer container) {
		ChairRegistry.BLOCKS.register(eventBus);
		ChairRegistry.BLOCK_ENTITIES.register(eventBus);
		ChairRegistry.ITEMS.register(eventBus);

		if (dist.isClient()) {
			eventBus.addListener(ClientHandler::registerEntityRenders);
		}
	}
}