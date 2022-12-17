package me.dailydungeons.client.features;


import me.dailydungeons.client.config.Config;
import me.dailydungeons.client.utils.SkyBlockID;
import me.dailydungeons.client.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class TpAnywhere {

    static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onInteract(PlayerInteractEvent event) {
        if(Config.TpAnywhere && Utils.inSkyBlock && mc.thePlayer.inventory.currentItem == 0 && event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
                for (int i = 0; i < 8; i++) {
                    ItemStack item = mc.thePlayer.inventory.getStackInSlot(i);
                    String itemID = SkyBlockID.getSkyBlockID(item);

                    if ((itemID.equals("ASPECT_OF_THE_END") || itemID.equals("ASPECT_OF_THE_VOID"))) {
                        event.setCanceled(true);
                        mc.thePlayer.inventory.currentItem = i;
                        mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, item);
                        mc.thePlayer.inventory.currentItem = 0;
                        break;
                    }
                }
            }
        }
    }




