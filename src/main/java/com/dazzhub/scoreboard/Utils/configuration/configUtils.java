package com.dazzhub.scoreboard.Utils.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class configUtils
{
    public void saveConfig(Plugin plugin, String configname) {
        File pluginDir = plugin.getDataFolder();
        File configFile = new File(pluginDir, configname + ".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        try {
            config.save(configFile);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public FileConfiguration getConfig(Plugin plugin, String configname) {
        File pluginDir = plugin.getDataFolder();
        File configFile = new File(pluginDir, configname + ".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        return config;
    }

    public FileConfiguration getConfig2(Plugin plugin, String configname) {
        File pluginDir = plugin.getDataFolder();
        File configFile = new File(pluginDir, configname);
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        return config;
    }

    public File getFile(Plugin plugin, String configname) {
        File pluginDir = plugin.getDataFolder();
        File configFile = new File(pluginDir, configname + ".yml");
        return configFile;
    }
}
