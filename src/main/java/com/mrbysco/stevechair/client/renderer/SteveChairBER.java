package com.mrbysco.stevechair.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.neoforged.neoforge.client.model.data.ModelData;

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
		renderActualBlock(state, poseStack, bufferSource, packedLight, packedOverlay, ModelData.EMPTY, null);
		poseStack.popPose();
	}

	/**
	 * A copy of BlockRenderDispatcher#renderSingleBlock but ignoring the renderShape
	 * @param state The block state to render
	 * @param poseStack The PoseStack to render the block in
	 * @param bufferSource The MultiBufferSource to render the block in
	 * @param packedLight The packed light value
	 * @param packedOverlay The packed overlay value
	 * @param modelData The ModelData to render the block with
	 * @param renderType The RenderType to render the block with
	 */
	private void renderActualBlock(BlockState state, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, ModelData modelData, RenderType renderType) {
		BakedModel bakedmodel = blockRenderer.getBlockModel(state);
		int i = blockRenderer.blockColors.getColor(state, null, null, 0);
		float f = (float) (i >> 16 & 0xFF) / 255.0F;
		float f1 = (float) (i >> 8 & 0xFF) / 255.0F;
		float f2 = (float) (i & 0xFF) / 255.0F;
		for (net.minecraft.client.renderer.RenderType rt : bakedmodel.getRenderTypes(state, RandomSource.create(42), ModelData
				.EMPTY))
			blockRenderer.modelRenderer
					.renderModel(
							poseStack.last(),
							bufferSource.getBuffer(renderType != null ? renderType : net.neoforged.neoforge.client.RenderTypeHelper.getEntityRenderType(rt, false)),
							state,
							bakedmodel,
							f,
							f1,
							f2,
							packedLight,
							packedOverlay,
							ModelData.EMPTY,
							rt
					);
	}
}
