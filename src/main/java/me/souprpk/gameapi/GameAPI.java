package me.souprpk.gameapi;

import org.bukkit.plugin.Plugin;

import java.io.File;

public final class GameAPI{
    private static Plugin plugin;

    private static File gameWorlds;

    public GameAPI(Plugin plugin){
        this.plugin = plugin;

        gameWorlds = new File("GameWorlds");

        if(!gameWorlds.exists()){
            gameWorlds.mkdir();
        }
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

    }
    /*@Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }*/

    /*public GameAPI getGameAPI(){
        return this;
    }*/

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
