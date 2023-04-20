package com.zsgs.cricketscoreboardmanagement.playmatch;

public interface PlayMatchViewControllerCallBack {
    void setPlayers();

    void addScore(int i, int ball);

    void swapPlayers();

    void setWicket();
}
