package com.zsgs.cricketscoreboardmanagement.playmatch;

public interface PlayMatchControllerModelCallBack {
    void setPlayers();

    void addScore(int run, int ball);

    void swapPlayers();

    void setWicket();
}
