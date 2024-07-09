package com.mayankpatibandla.removeguns;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ItemRemover {
    @SubscribeEvent
    public void removeFromInventory(TickEvent.PlayerTickEvent event) {
        // Remove guns from the player's inventory
        EntityPlayer player = event.player;

        for(Object x : player.inventoryContainer.getInventory()) {
            // Remove guns from the player's inventory
            if(x instanceof ItemStack) {
                ItemStack item = (ItemStack) x;
                if(item.getItem().getUnlocalizedName().toLowerCase().contains("gun")) {
                    player.inventoryContainer.putStackInSlot(player.inventoryContainer.getInventory().indexOf(item), null);
                    System.out.println("Removed " + item.getDisplayName() + " from " + player.getDisplayName() + "'s inventory");
                    player.addChatMessage((IChatComponent) new ChatComponentText("Removed " + item.getDisplayName() + " from your inventory"));
                }

            }
        }
    }
}
