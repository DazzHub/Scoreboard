package com.dazzhub.scoreboard.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * This code has been created by
 * DazzHub.
 * Discord: DazzHub#3542
 */

public class Console {

    public static void info(String message){
        Bukkit.getConsoleSender().sendMessage(c("&9Scoreboard &8> &e" + message));
    }

    public static void warning(String message){
        Bukkit.getConsoleSender().sendMessage(c("&9Scoreboard &cWARNING &8> &e" + message));
    }

    public static void error(String message){
        Bukkit.getConsoleSender().sendMessage(c("&9Scoreboard &cERROR &8> &e" + message));
    }

    public static void debug(String message){
        Bukkit.getConsoleSender().sendMessage(c("&9Scoreboard &cDEBUG &8> &e" + message));
    }

    private static String c(String msg){ return ChatColor.translateAlternateColorCodes('&', msg); }

}
