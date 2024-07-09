package com.mayankpatibandla.removeguns.config;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.Arrays;

public class ConfigurationHandler {
    private static Configuration configuration;
    private static Property items;
    //        Wooden Gun
    //        Wooden Bullet
    //        Stone Gun
    //        Stone Bullet
    //        Iron Gun
    //        Iron Bullet
    //        Golden Gun
    //        Golden Bullet
    //        Diamond Gun
    //        Diamond Bullet
    //        Bronze Gun
    //        Bronze Bullet
    //        Emerald Gun
    //        Emerald Bullet
    //        Machine Gun
    //        Black Bullet
    //        Kunai
    //        Reverse Kunai
    //        Shuriken
    //        Giant Shuriken
    //        Musket
    //        GunChainsaw
    private static final String[] DEFAULT_ITEMS = new String[]{
            "Wooden Gun",
            "Wooden Bullet",
            "Stone Gun",
            "Stone Bullet",
            "Iron Gun",
            "Iron Bullet",
            "Golden Gun",
            "Golden Bullet",
            "Diamond Gun",
            "Diamond Bullet",
            "Bronze Gun",
            "Bronze Bullet",
            "Emerald Gun",
            "Emerald Bullet",
            "Machine Gun",
            "Black Bullet",
            "Kunai",
            "Reverse Kunai",
            "Shuriken",
            "Giant Shuriken",
            "Musket",
            "GunChainsaw"};

    public static void init(String configDir) {
        System.out.println(configDir);
        if (configuration == null) {
            configuration = new Configuration(new File(configDir + "/RemoveGuns.cfg"));
            configuration.load();

             items = configuration.get("Items", "Item Names", DEFAULT_ITEMS,
                                               "Add the display names of the items you want to remove from the " +
                                               "game, one per line (case sensitive)");

            System.out.println(Arrays.toString(items.getStringList()));

            saveConfiguration();
        }
    }

    private static void saveConfiguration() {
        if (configuration.hasChanged()) {
            configuration.save();
            System.out.println("Saved configuration");
        }
    }

    public static Configuration getConfig() {
        return configuration;
    }

    public static Property getItems() {
        return items;
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase("removeguns")) {
            saveConfiguration();
        }
    }
}
