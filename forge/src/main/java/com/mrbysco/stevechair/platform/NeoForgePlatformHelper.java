package com.mrbysco.stevechair.platform;

import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import com.mrbysco.stevechair.platform.services.IPlatformHelper;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class NeoForgePlatformHelper implements IPlatformHelper {

	@Override
	public BlockEntityType<SteveChairBlockEntity> createBlockEntity() {
		return new BlockEntityType<>(SteveChairBlockEntity::new, ChairRegistry.STEVE_CHAIR.get());
	}
}
