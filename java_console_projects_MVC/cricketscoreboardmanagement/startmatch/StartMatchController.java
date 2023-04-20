package com.zsgs.cricketscoreboardmanagement.startmatch;

import com.zsgs.cricketscoreboardmanagement.dto.ScoreBoardDetails;
import com.zsgs.cricketscoreboardmanagement.dto.Teams;

import java.util.ArrayList;

public class StartMatchController implements StartMatchViewControllerCallBack , StartMatchModelControllerCallBack {

    private StartMatchControllerViewCallBack startMatchView;
    private StartMatchControllerModelCallBack startMatchModel;
    public StartMatchController(StartMatchView startMatchView) {
        startMatchModel = new StartMatchModel(this);
        this.startMatchView = startMatchView;
    }

    public void getScoreBoard() {
        startMatchModel.getScoreBoard();
    }

    public void showScoreBoard(ScoreBoardDetails scoreBoardDetails) {
        startMatchView.showScoreBoard(scoreBoardDetails);
    }

    public void setBatFieldTeam(boolean isBatting) {
        startMatchModel.setBatFieldTeam(isBatting);
    }

    public void setMatch(int match) {
        startMatchModel.setMatch(match);
    }

    public void setTotalOvers(int totalOvers) {
        startMatchModel.setTotalOvers(totalOvers);
    }
    public int getOverallScore() {
        return startMatchModel.getOverallScore();
    }

    public void initializeLiveDetails(){
        startMatchModel.initializeLiveDetails();
    }

    public void saveForOverallScoreBoard() {
        startMatchModel.saveForOverallScoreBoard();
    }

    public void getOverallScoreBoard() {
        startMatchModel.getOverallScoreBoard();
    }

    public void showOverallScoreBoard(ArrayList<Teams> teams) {
        startMatchView.showOverallScoreBoard(teams);
    }

}
