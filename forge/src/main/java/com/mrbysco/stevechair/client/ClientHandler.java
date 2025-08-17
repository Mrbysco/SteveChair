package com.mrbysco.stevechair.client;

import com.mrbysco.stevechair.client.renderer.SteveChairBER;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ClientHandler {

	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ChairRegistry.STEVE_CHAIR_BLOCK_ENTITY.get(), SteveChairBER::new);
	}
}
