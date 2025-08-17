package com.mrbysco.stevechair.platform.services;

import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface IPlatformHelper {
	BlockEntityType<SteveChairBlockEntity> createBlockEntity();
}
