package com.mrbysco.stevechair.client.renderer;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;

public class SteveChairRenderState extends BlockEntityRenderState {
	public final BlockModelRenderState block = new BlockModelRenderState();
	public int rotation = 0;
}
