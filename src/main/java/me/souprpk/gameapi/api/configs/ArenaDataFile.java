package me.souprpk.gameapi.api.configs;

import me.souprpk.gameapi.GameAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;


public class ArenaDataFile {

    private Plugin plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public ArenaDataFile(){
        this.plugin = GameAPI.getPlugin();
    }

    public void reloadConfig() {
        if(this.configFile == null)
            this.configFile = new File(plugin.getDataFolder(), "arenadata.yml");

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = plugin.getResource("arenadata.yml");
        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig() {
        if(this.dataConfig == null)
            reloadConfig();

        return this.dataConfig;
    }

    public void saveConfig() {
        if(this.dataConfig == null || this.configFile == null)
            return;

        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
        }
    }

    public void saveDefaultConfig() {
        if(this.configFile == null)
            this.configFile = new File(plugin.getDataFolder(), "arenadata.yml");

        if(!this.configFile.exists())
            plugin.saveResource("arenadata.yml", false);

    }
}
