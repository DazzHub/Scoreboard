package com.dazzhub.scoreboard.Scoreboard;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;

@Getter
@Setter
public class Entry {

    private String name;
    private Integer value;
    private Team team;
    private Score score;

    public Entry(String name, Integer value, Team team, Score score) {
        this.name = name;
        this.value = value;
        this.team = team;
        this.score = score;
    }
}
