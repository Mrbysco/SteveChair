package com.mrbysco.stevechair.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import com.mrbysco.stevechair.mixin.BlockRenderDispatcherAccessor;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;

public class SteveChairBER implements BlockEntityRenderer<SteveChairBlockEntity> {

	private final BlockRenderDispatcher blockRenderer;

	public SteveChairBER(BlockEntityRendererProvider.Context context) {
		this.blockRenderer = context.getBlockRenderDispatcher();
	}

	@Override
	public void render(SteveChairBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		final BlockState state = blockEntity.getBlockState();
		if (state == null) return;
		int rotation = state.getValue(SkullBlock.ROTATION);
		float degrees = RotationSegment.convertToDegrees(rotation);
		poseStack.pushPose();
		poseStack.translate(0.5D, 0, 0.5D);
		poseStack.mulPose(Axis.YP.rotationDegrees(-degrees));
		poseStack.translate(-0.5D, 0, -0.5D);
		renderActualBlock(state, poseStack, bufferSource, packedLight, packedOverlay, ItemBlockRenderTypes.getRenderType(state, false));
		poseStack.popPose();
	}

	/**
	 * A copy of BlockRenderDispatcher#renderSingleBlock but ignoring the renderShape
	 * @param state The block state to render
	 * @param poseStack The PoseStack to render the block in
	 * @param bufferSource The MultiBufferSource to render the block in
	 * @param packedLight The packed light value
	 * @param packedOverlay The packed overlay value
	 * @param renderType The RenderType to render the block with
	 */
	private void renderActualBlock(BlockState state, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, RenderType renderType) {
		BakedModel bakedmodel = blockRenderer.getBlockModel(state);
		int i = ((BlockRenderDispatcherAccessor)blockRenderer).stevechair$blockColors().getColor(state, null, null, 0);
		float r = (float) (i >> 16 & 0xFF) / 255.0F;
		float g = (float) (i >> 8 & 0xFF) / 255.0F;
		float b = (float) (i & 0xFF) / 255.0F;
		blockRenderer.getModelRenderer()
				.renderModel(
						poseStack.last(),
						bufferSource.getBuffer(renderType),
						state,
						bakedmodel,
						r,
						g,
						b,
						packedLight,
						packedOverlay
				);
	}
}
