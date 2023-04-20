package com.zsgs.cricketscoreboardmanagement.startmatch;

public interface StartMatchControllerModelCallBack {
    void getScoreBoard();

    void setBatFieldTeam(boolean isBatting);

    void setMatch(int match);

    void setTotalOvers(int totalOvers);

    int getOverallScore();

    void initializeLiveDetails();

    void saveForOverallScoreBoard();

    void getOverallScoreBoard();
}
