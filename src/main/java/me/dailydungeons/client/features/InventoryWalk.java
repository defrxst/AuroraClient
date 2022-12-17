package me.dailydungeons.client.features;

import me.dailydungeons.client.config.Config;
import me.dailydungeons.client.utils.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class InventoryWalk {

    //  private static final Minecraft mc = Minecraft.getMinecraft();

    public static FontUtil mainFont;
    public static FontUtil jelloarray2;

    Font d;

    ResourceLocation c = new ResourceLocation("dailydungeons:font/rat.png");


    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void LivingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving != null && event.entityLiving instanceof EntityPlayer) {

            if (Config.InventoryWalk) {
                if (Minecraft.getMinecraft().thePlayer.onGround) {
                    if (GameSettings.isKeyDown(mc.gameSettings.keyBindForward)) {
                        mc.thePlayer.moveForward = 5F;
                    }
                }
            }
        }
    }

}
