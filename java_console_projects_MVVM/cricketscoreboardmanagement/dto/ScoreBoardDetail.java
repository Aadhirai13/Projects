package com.zsgs.mvvm.cricketscoreboardmanagement.dto;

import java.util.ArrayList;

public class ScoreBoardDetail {
    int match;
    String teamBat;
    String teamField;
    String player1;
    String player2;
    String currPlayer; //player who is batting currently
    String bowler;
    boolean isP1Out;
    boolean isP2Out;
    int p1Score;
    int p2Score;
    int totalOvers;
    int ballCount;
    int currOverBalls;
    int runsScored;
    int wicketsCount;
    double overWithBall;
    ArrayList<Integer> overDetails = new ArrayList<>(); // current over details

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public String getTeamBat() {
        return teamBat;
    }

    public void setTeamBat(String teamBat) {
        this.teamBat = teamBat;
    }

    public String getTeamField() {
        return teamField;
    }

    public void setTeamField(String teamField) {
        this.teamField = teamField;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(String currPlayer) {
        this.currPlayer = currPlayer;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public boolean isP1Out() {
        return isP1Out;
    }

    public void setP1Out(boolean p1Out) {
        isP1Out = p1Out;
    }

    public boolean isP2Out() {
        return isP2Out;
    }

    public void setP2Out(boolean p2Out) {
        isP2Out = p2Out;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public int getTotalOvers() {
        return totalOvers;
    }

    public void setTotalOvers(int totalOvers) {
        this.totalOvers = totalOvers;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getCurrOverBalls() {
        return currOverBalls;
    }

    public void setCurrOverBalls(int currOverBalls) {
        this.currOverBalls = currOverBalls;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWicketsCount() {
        return wicketsCount;
    }

    public void setWicketsCount(int wicketsCount) {
        this.wicketsCount = wicketsCount;
    }

    public ArrayList<Integer> getOverDetails() {
        return overDetails;
    }

    public void setOverDetails(ArrayList<Integer> overDetails) {
        this.overDetails = overDetails;
    }

    public double getOverWithBall() {
        return overWithBall;
    }

    public void setOverWithBall(double overWithBall) {
        this.overWithBall = overWithBall;
    }
}
