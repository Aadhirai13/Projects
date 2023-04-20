package com.zsgs.cricketscoreboardmanagement.startmatch;

import com.zsgs.cricketscoreboardmanagement.dto.ScoreBoardDetails;
import com.zsgs.cricketscoreboardmanagement.dto.Teams;
import com.zsgs.cricketscoreboardmanagement.repository.ScoreBoardRepository;

import java.util.ArrayList;

public class StartMatchModel implements StartMatchControllerModelCallBack {
    private StartMatchModelControllerCallBack startMatchController;
    public StartMatchModel(StartMatchController startMatchController) {
        this.startMatchController = startMatchController;
    }

    public void getScoreBoard() {
        ScoreBoardDetails scoreBoardDetails = ScoreBoardRepository.getInstance().getScoreBoard();
        startMatchController.showScoreBoard(scoreBoardDetails);
    }

    public void setBatFieldTeam(boolean isBatting) {
        ScoreBoardRepository.getInstance().setBatFieldTeam(isBatting);
    }

    public void setMatch(int match) {
        ScoreBoardRepository.getInstance().setMatch(match);
    }

    public void setTotalOvers(int totalOvers) {
        ScoreBoardRepository.getInstance().setTotalOvers(totalOvers);
    }

    public int getOverallScore() {
        return ScoreBoardRepository.getInstance().getOverallScore();
    }

    public void initializeLiveDetails(){
        ScoreBoardRepository.getInstance().initializeLiveDetails();
    }

    public void saveForOverallScoreBoard() {
        ScoreBoardRepository.getInstance().saveForOverallScoreBoard();
    }

    public void getOverallScoreBoard() {
        ArrayList<Teams> teams = ScoreBoardRepository.getInstance().getOverallScoreBoard();
        startMatchController.showOverallScoreBoard(teams);
    }

}
