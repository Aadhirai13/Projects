package com.zsgs.mvvm.cricketscoreboardmanagement.dto;

import java.util.ArrayList;

public class Team {
    String teamName;
    ArrayList<String> players;
    int overallScore;
    ArrayList<Integer> individualScore;
    ArrayList<Integer> ballsBowled;

    public Team(String teamName, ArrayList<String> players, int overallScore, ArrayList<Integer> individualScore, ArrayList<Integer> ballsBowled) {
        setTeamName(teamName);
        setPlayers(players);
        setOverallScore(overallScore);
        setIndividualScore(individualScore);
        setBallsBowled(ballsBowled);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }
    public ArrayList<Integer> getIndividualScore() {
        return individualScore;
    }

    public void setIndividualScore(ArrayList<Integer> individualScore) {
        this.individualScore = individualScore;
    }

    public ArrayList<Integer> getBallsBowled() {
        return ballsBowled;
    }

    public void setBallsBowled(ArrayList<Integer> ballsBowled) {
        this.ballsBowled = ballsBowled;
    }
}
