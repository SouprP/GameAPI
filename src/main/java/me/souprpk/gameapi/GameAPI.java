package me.souprpk.gameapi;

import me.souprpk.gameapi.api.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;


public final class GameAPI{
    private static Plugin plugin;

    private static File gameWorlds;

    /**
     * Registers all the needed listeners,
     * if you don't do this the plugin won't work correctly
     * @param plugin
     */
    public GameAPI(Plugin plugin, File gameWorldFolder){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(new PlayerMovementListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new SettingsListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerPvPListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new ServerPingListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new ChestOpenListener(), plugin);
        //getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");

        gameWorlds = gameWorldFolder;
    }

    public static File getGameWorldsFolder(){
        return gameWorlds;
    }

    public static Plugin getPlugin(){
        return plugin;


    }

    public static void logInfo(String msg){
        System.out.println("[GameAPI] [INFO] " + msg);
    }

    public static void sendDebugMessage(String message, Plugin plugin){
        System.out.println("[GameAPI]" + (plugin.getName().equals("GameAPI") ? "" : " [" + plugin.getName() + "]") + " [DEBUG] " + message);
    }
}
