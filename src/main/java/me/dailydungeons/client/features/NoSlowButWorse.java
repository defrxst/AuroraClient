package me.dailydungeons.client.features;

import me.dailydungeons.client.utils.PacketUtils;
import me.dailydungeons.client.config.Config;
import me.dailydungeons.client.events.TickEndEvent;
import me.dailydungeons.client.utils.SkyBlockID;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class NoSlowButWorse {

    static Minecraft mc = Minecraft.getMinecraft();

    private final ArrayList<String> swords = new ArrayList<>(Arrays.asList(
            "HYPERION",
            "VALKYRIE",
            "SCYLLA",
            "ASTRAEA",
            "ASPECT_OF_THE_END",
            "ROGUE_SWORD"
    ));
    private static boolean isRightClickKeyDown = false;

    @SubscribeEvent
    public void onTick(TickEndEvent event) {
        isRightClickKeyDown = mc.gameSettings.keyBindUseItem.isKeyDown();
    }

    @SubscribeEvent
    public void onInteract(PlayerInteractEvent event) {
        if(Config.DontSlowMyGuy && event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
            if(mc.thePlayer.getHeldItem() != null) {
                String itemID = SkyBlockID.getSkyBlockID(mc.thePlayer.getHeldItem());
                if(swords.contains(itemID)) {
                    event.setCanceled(true);
                    if(!isRightClickKeyDown) {
                        PacketUtils.sendPacket(new C08PacketPlayerBlockPlacement(new BlockPos(-1, -1, -1), 255, mc.thePlayer.getHeldItem(), 0, 0, 0));
                    }
                }
            }
        }
    }
}
