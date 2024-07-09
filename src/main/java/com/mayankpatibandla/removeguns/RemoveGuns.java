package com.mayankpatibandla.removeguns;

import com.mayankpatibandla.removeguns.config.ConfigurationHandler;
import com.mayankpatibandla.removeguns.proxy.Proxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "removeguns", name = "Remove Guns", version = "1.0.0", dependencies = "required-after:customnpcs",
     canBeDeactivated = false, acceptedMinecraftVersions = "[1.7.10]", useMetadata = true)
public class RemoveGuns {
    @Mod.Instance
    public static RemoveGuns instance = new RemoveGuns();

    @SidedProxy(clientSide = "com.mayankpatibandla.removeguns.proxy.ClientProxy",
                serverSide = "com.mayankpatibandla.removeguns.proxy.ServerProxy")
    public static Proxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        System.out.println("Pre-Initialization for Remove Guns");

        ConfigurationHandler.init(event.getModConfigurationDirectory().toString());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        System.out.println("Initialization for Remove Guns");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        System.out.println("Post-Initialization for Remove Guns");
    }
}
