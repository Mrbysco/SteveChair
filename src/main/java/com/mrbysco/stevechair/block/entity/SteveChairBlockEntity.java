package com.mrbysco.stevechair.block.entity;

import com.mrbysco.stevechair.registry.ChairRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SteveChairBlockEntity extends BlockEntity {
	public SteveChairBlockEntity(BlockPos pos, BlockState blockState) {
		super(ChairRegistry.STEVE_CHAIR_BLOCK_ENTITY.get(), pos, blockState);
	}
}
