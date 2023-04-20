package com.zsgs.cricketscoreboardmanagement.dto;

import java.util.Queue;

public class Batting {
    String teamName;
    Queue<String> players;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Queue<String> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<String> players) {
        this.players = players;
    }
}
