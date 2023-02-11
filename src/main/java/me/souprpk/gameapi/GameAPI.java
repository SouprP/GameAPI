package me.souprpk.gameapi;

import me.souprpk.gameapi.api.listeners.*;
import me.souprpk.gameapi.enums.GameType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;


public final class GameAPI{
    private static Plugin plugin;

    private static File gameWorlds;

    public GameAPI(Plugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(new PlayerMovementListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new SettingsListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerPvPListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), plugin);
        //Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new ServerPingListener(), plugin);
        //getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");

        gameWorlds = new File("GameWorlds");

        if(!gameWorlds.exists()){
            gameWorlds.mkdir();
            for(GameType gameType : GameType.values()){
                File dir = new File(gameWorlds.getName() + "/" + gameType.name());
                if(!dir.exists())
                    dir.mkdir();
            }
        }
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

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
