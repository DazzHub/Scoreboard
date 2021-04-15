package com.dazzhub.scoreboard;

import com.dazzhub.scoreboard.Scoreboard.Builder;
import com.dazzhub.scoreboard.Utils.configuration.configCreate;
import com.dazzhub.scoreboard.Utils.configuration.configUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.security.SecureRandom;

/**
 * This code has been created by
 * DazzHub.
 * Discord: DazzHub#3542
 */

public final class Main extends JavaPlugin implements Listener {

    private Builder builder;
    private final configUtils configUtils;

    public Main() {
        this.configUtils = new configUtils();
    }

    @Override
    public void onEnable() {
        /* SIMPLE TESTING SCORE... */
        configCreate.get().setup(this, "Scoreboard");

        this.builder = new Builder(randomString());
        this.builder.setName(getScoreboard().getString("name"));

        int line = getScoreboard().getStringList("lines").size();
        for (Player p : Bukkit.getOnlinePlayers()){
            for (String s : getScoreboard().getStringList("lines")) {
                builder.createScore(charsLobby(p, s), line);
                line--;
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {


                for (Player p : Bukkit.getOnlinePlayers()){
                    int line = getScoreboard().getStringList("lines").size();

                    for (String s : getScoreboard().getStringList("lines")) {
                        builder.updateScore(charsLobby(p, s), line);
                        line--;
                    }
                }

            }
        }.runTaskTimerAsynchronously(this, 0,20);

        for (Player on : Bukkit.getOnlinePlayers()){
            on.setScoreboard(builder.getScoreboard());
        }

        getServer().getPluginManager().registerEvents(this, this);
    }

    public String charsLobby(Player p, String msg) {
        if (p == null || msg == null || msg.isEmpty()) return "";

        return PlaceholderAPI.setPlaceholders(p, msg);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().setScoreboard(builder.getScoreboard());
    }

    private String randomString() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 8; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public Configuration getScoreboard() {
        return getConfigUtils().getConfig(this, "Scoreboard");
    }

    public configUtils getConfigUtils() {
        return configUtils;
    }
}
