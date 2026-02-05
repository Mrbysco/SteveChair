package com.mrbysco.stevechair.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.BlockStateModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ARGB;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class SteveChairBER implements BlockEntityRenderer<SteveChairBlockEntity, BlockEntityRenderState> {

	private final BlockRenderDispatcher blockRenderer;

	public SteveChairBER(BlockEntityRendererProvider.Context context) {
		this.blockRenderer = context.blockRenderDispatcher();
	}

	@Override
	public BlockEntityRenderState createRenderState() {
		return new BlockEntityRenderState();
	}

	@Override
	public void extractRenderState(SteveChairBlockEntity chairBlockEntity, BlockEntityRenderState renderState,
	                               float partialTick, Vec3 cameraPosition,
	                               ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(chairBlockEntity, renderState, partialTick, cameraPosition, crumblingOverlay);
	}

	@Override
	public void submit(BlockEntityRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
		BlockState state = renderState.blockState;
		int rotation = state.getValue(SkullBlock.ROTATION);
		float degrees = RotationSegment.convertToDegrees(rotation);
		poseStack.pushPose();
		poseStack.translate(0.5D, 0, 0.5D);
		poseStack.mulPose(Axis.YP.rotationDegrees(-degrees));
		poseStack.translate(-0.5D, 0, -0.5D);
		BlockStateModel blockStateModel = blockRenderer.getBlockModel(state);
		RenderType renderType = ItemBlockRenderTypes.getRenderType(state);
		int i = blockRenderer.blockColors.getColor(state, null, null, 0);
		float r = ARGB.redFloat(i);
		float g = ARGB.greenFloat(i);
		float b = ARGB.blueFloat(i);
		nodeCollector.submitBlockModel(poseStack, renderType, blockStateModel, r, g, b,
				renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
		poseStack.popPose();
	}
}
