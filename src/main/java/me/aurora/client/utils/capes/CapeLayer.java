package me.aurora.client.utils.capes;

import lombok.AllArgsConstructor;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

/**
 * @author Revxrsal Gabagooooooooooool
 * @version 1.1
 * Implemented from github.com/Revxrsal/SimpleCapes under Apache Commons 2.0 License
 */
@AllArgsConstructor
public class CapeLayer implements LayerRenderer<AbstractClientPlayer> {
    private final RenderPlayer playerRenderer;

    @Override
    public void doRenderLayer(AbstractClientPlayer entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ResourceLocation capeLoc = CapeDatabase.getInstance().getUserCape(entity.getName());
        if (capeLoc == null) return;
        if (!entity.isInvisible() && entity.isWearing(EnumPlayerModelParts.CAPE)) {
            float f9 = entity.isSneaking() ? .1F : .14F;
            float f10 = entity.isSneaking() ? .09F : 0F;
            GlStateManager.color(1F, 1F, 1F, 1F);
            this.playerRenderer.bindTexture(capeLoc);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, f10, f9);
            double d0 = entity.prevChasingPosX + (entity.chasingPosX - entity.prevChasingPosX) * partialTicks - (entity.prevPosX + (entity.posX - entity.prevPosX) * partialTicks);
            double d1 = entity.prevChasingPosY + (entity.chasingPosY - entity.prevChasingPosY) * partialTicks - (entity.prevPosY + (entity.posY - entity.prevPosY) * partialTicks);
            double d2 = entity.prevChasingPosZ + (entity.chasingPosZ - entity.prevChasingPosZ) * partialTicks - (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * partialTicks);
            float f = entity.prevRenderYawOffset + (entity.renderYawOffset - entity.prevRenderYawOffset) * partialTicks;
            double d3 = MathHelper.sin(f * .017453292F);
            double d4 = -MathHelper.cos(f * .017453292F);
            float f1 = (float) d1 * 10F;
            f1 = MathHelper.clamp_float(f1, 3F, 32F);
            float f2 = Math.max((float) (d0 * d3 + d2 * d4) * 100F, 0F);
            float f3 = (float) (d0 * d4 - d2 * d3) * 100F;
            float f4 = entity.prevCameraYaw + (entity.cameraYaw - entity.prevCameraYaw) * partialTicks;
            f1 += MathHelper.sin((entity.prevDistanceWalkedModified + (entity.distanceWalkedModified - entity.prevDistanceWalkedModified) * partialTicks) * 6F) * 32F * f4;
            if (entity.isSneaking()) f1 += 20F;
            GlStateManager.rotate(5F + f2 / 2F + f1, 1F, 0F, 0F);
            GlStateManager.rotate(f3 / 2F, 0F, 0F, 1F);
            GlStateManager.rotate(-f3 / 2F, 0F, 1F, 0F);
            GlStateManager.rotate(180F, 0F, 1F, 0F);
            this.playerRenderer.getMainModel().renderCape(.0625F);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}