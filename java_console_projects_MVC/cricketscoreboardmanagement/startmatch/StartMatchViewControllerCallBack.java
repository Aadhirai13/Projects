package com.zsgs.cricketscoreboardmanagement.startmatch;

public interface StartMatchViewControllerCallBack {
    void setTotalOvers(int totalOvers);

    void setMatch(int match);

    void saveForOverallScoreBoard();

    void initializeLiveDetails();

    void getOverallScoreBoard();

    void getScoreBoard();

    void setBatFieldTeam(boolean b);
}
