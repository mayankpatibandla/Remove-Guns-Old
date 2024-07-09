package com.mayankpatibandla.removeguns;

import com.mayankpatibandla.removeguns.config.ConfigurationHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.config.Property;

public class ItemRemover {
    @SubscribeEvent
    public void removeFromInventory(TickEvent.PlayerTickEvent event) {
        // Remove guns from the player's inventory
        Property items_list = ConfigurationHandler.getItems();
        EntityPlayer player = event.player;

        for (Object x : player.inventoryContainer.getInventory()) {
            if (x instanceof ItemStack) {
                ItemStack item = (ItemStack) x;

                for (String item_name : items_list.getStringList()) {
                    if (item.getDisplayName().equals(item_name)) {
                        player.inventoryContainer.putStackInSlot(player.inventoryContainer.getInventory().indexOf(item),
                                                                 null);

                        System.out.println("Removed " + item.getDisplayName() + " from " + player.getDisplayName() +
                                           "'s inventory");
                        player.addChatMessage((IChatComponent) new ChatComponentText(
                                "Removed " + item.getDisplayName() + " from your inventory"));
                    }
                }

            }
        }
    }
}
