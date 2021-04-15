package com.dazzhub.scoreboard.Utils.configuration;

import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * This code has been created by
 * DazzHub.
 * Discord: DazzHub#3542
 */

public class configCreate
{
    private static configCreate instance;
    private File configFile;

    public static configCreate get() {
        if (instance == null) {
            instance = new configCreate();
        }
        return instance;
    }

    public void setup(Plugin p, String configname) {
        File pluginDir = p.getDataFolder();
        this.configFile = new File(pluginDir, configname + ".yml");
        if (!this.configFile.exists()) {
            p.saveResource(configname + ".yml", false);
        }
    }

    public void setupCustom(Plugin p, String configname) {
        File pluginDir = p.getDataFolder();
        this.configFile = new File(pluginDir, configname);
        if (!this.configFile.exists()) {
            p.saveResource(configname, false);
        }
    }
}
