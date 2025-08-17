package com.mrbysco.stevechair.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockRenderDispatcher.class)
public interface BlockRenderDispatcherAccessor {
	@Accessor("blockColors")
	BlockColors stevechair$blockColors();
}
