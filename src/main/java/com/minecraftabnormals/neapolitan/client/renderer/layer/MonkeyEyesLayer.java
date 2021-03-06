package com.minecraftabnormals.neapolitan.client.renderer.layer;

import com.minecraftabnormals.neapolitan.client.model.MonkeyModel;
import com.minecraftabnormals.neapolitan.common.entity.MonkeyEntity;
import com.minecraftabnormals.neapolitan.core.Neapolitan;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.minecraftabnormals.abnormals_core.client.ACRenderTypes;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MonkeyEyesLayer<T extends MonkeyEntity> extends AbstractEyesLayer<T, MonkeyModel<T>> {
	private static final RenderType RENDER_TYPE = ACRenderTypes.getEmissiveEntity(new ResourceLocation(Neapolitan.MOD_ID, "textures/entity/monkey/monkey_eyes.png"));

	public MonkeyEyesLayer(IEntityRenderer<T, MonkeyModel<T>> rendererIn) {
		super(rendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T monkey, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (monkey.world.getLight(monkey.getPosition()) > 5)
			return;
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.getRenderType());
		this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public RenderType getRenderType() {
		return RENDER_TYPE;
	}
}