package com.dazzhub.scoreboard.Scoreboard;

import com.google.common.base.Splitter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;

import java.util.Iterator;

/**
 * This code has been created by
 * DazzHub.
 * Discord: DazzHub#3542
 */

@Getter
public class Builder {

    private final Scoreboard scoreboard;
    private final Objective objective;

    private final BiMap<Integer, Entry> entries;

    public Builder(String score_name) {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.objective = scoreboard.registerNewObjective(score_name, "dummy");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        this.entries = HashBiMap.create();
    }

    public void createScore(String name, int value) {

        if (name.isEmpty()){
            objective.getScore(getEntry(value)).setScore(value);
            return;
        }

        if (name.length() <= 16){
            Team team = getScoreboard().registerNewTeam("score-" + value);
            team.setPrefix(name);

            Score score;
            score = getObjective().getScore(name);
            score.setScore(value);

            entries.put(value, new Entry(name, value, team, score));
            return;
        }

        Team team = getScoreboard().registerNewTeam("score-" + value);
        Iterator<String> iterator = Splitter.fixedLength(16).split(name).iterator();

        team.setPrefix(iterator.next());
        String entry = iterator.next();

        if (name.length() > 32) {
            team.setSuffix(iterator.next());
        }

        team.addEntry(entry);

        Score score;
        score = getObjective().getScore(entry);
        score.setScore(value);

        entries.put(value, new Entry(name, value, team, score));
    }

    public void updateScore(String name, int value){
        if (entries.get(value) != null){
            Entry entryC = entries.get(value);

            if (entryC.getName().equalsIgnoreCase(name)) return;

            getScoreboard().resetScores(entryC.getScore().getEntry());
            entryC.getTeam().unregister();

            if (name.length() <= 16){
                Team team = getScoreboard().registerNewTeam("score-" + value);
                team.setPrefix(name);

                Score score;
                score = getObjective().getScore(name);
                score.setScore(value);

                entries.replace(value, new Entry(name, value, team, score));
                return;
            }

            Team team = getScoreboard().registerNewTeam("score-" + value);
            Iterator<String> iterator = Splitter.fixedLength(16).split(name).iterator();

            team.setPrefix(iterator.next());
            String entry = iterator.next();

            if (name.length() > 32) {
                team.setSuffix(iterator.next());
            }

            team.addEntry(entry);

            Score score;
            score = getObjective().getScore(entry);
            score.setScore(value);

            entries.replace(value, new Entry(name, value, team, score));
        }
    }

    public void setName(String title) {
        objective.setDisplayName(title);
    }

    private String getEntry(Integer n) {
        if (n == 0) {
            return "§0";
        }
        if (n == 1) {
            return "§1";
        }
        if (n == 2) {
            return "§2";
        }
        if (n == 3) {
            return "§3";
        }
        if (n == 4) {
            return "§4";
        }
        if (n == 5) {
            return "§5";
        }
        if (n == 6) {
            return "§6";
        }
        if (n == 7) {
            return "§7";
        }
        if (n == 8) {
            return "§8";
        }
        if (n == 9) {
            return "§9";
        }
        if (n == 10) {
            return "§a";
        }
        if (n == 11) {
            return "§b";
        }
        if (n == 12) {
            return "§c";
        }
        if (n == 13) {
            return "§d";
        }
        if (n == 14) {
            return "§e";
        }
        if (n == 15) {
            return "§f";
        }
        return "";
    }
}
