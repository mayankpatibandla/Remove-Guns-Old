package com.mayankpatibandla.removeguns.config;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    private static Configuration configuration;

//    public static boolean updateCheck = true;

    public static void init(String configDir) {
        if (configuration == null) {
            configuration = new Configuration(new File(configDir + "/RemoveGuns.cfg"));
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
//        updateCheck = configuration.getBoolean("updateCheck", net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL, true, "Enable update checker");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase("removeguns")) {
            loadConfiguration();
        }
    }

    public static Configuration getConfig() {
        return configuration;
    }
}
