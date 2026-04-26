package com.mrbysco.stevechair.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class SteveChairBER implements BlockEntityRenderer<SteveChairBlockEntity, SteveChairRenderState> {
	public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();
	private final BlockModelResolver blockModelResolver;

	public SteveChairBER(BlockEntityRendererProvider.Context context) {
		this.blockModelResolver = context.blockModelResolver();
	}

	@Override
	public SteveChairRenderState createRenderState() {
		return new SteveChairRenderState();
	}

	@Override
	public void extractRenderState(SteveChairBlockEntity chairBlockEntity, SteveChairRenderState renderState,
	                               float partialTick, Vec3 cameraPosition,
	                               ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(chairBlockEntity, renderState, partialTick, cameraPosition, crumblingOverlay);
		this.blockModelResolver.update(renderState.block, chairBlockEntity.getBlockState(), BLOCK_DISPLAY_CONTEXT);
		renderState.rotation = chairBlockEntity.getBlockState().getValue(SkullBlock.ROTATION);
	}

	@Override
	public void submit(SteveChairRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
		int rotation = renderState.rotation;
		float degrees = RotationSegment.convertToDegrees(rotation);
		poseStack.pushPose();

		poseStack.translate(0.5D, 0, 0.5D);
		poseStack.mulPose(Axis.YP.rotationDegrees(-degrees));
		poseStack.translate(-0.5D, 0, -0.5D);

		renderState.block.submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
		poseStack.popPose();
	}
}
