package com.zsgs.cricketscoreboardmanagement.startmatch;

import com.zsgs.cricketscoreboardmanagement.dto.ScoreBoardDetails;
import com.zsgs.cricketscoreboardmanagement.dto.Teams;

import java.util.ArrayList;

public interface StartMatchControllerViewCallBack {
    void showScoreBoard(ScoreBoardDetails scoreBoardDetails);

    void showOverallScoreBoard(ArrayList<Teams> teams);
}
