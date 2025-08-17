package com.mrbysco.stevechair;

import com.mrbysco.stevechair.client.renderer.SteveChairBER;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class SteveChairFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockEntityRenderers.register(ChairRegistry.STEVE_CHAIR_BLOCK_ENTITY.get(), SteveChairBER::new);
	}
}
