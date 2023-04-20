package com.zsgs.mvvm.cricketscoreboardmanagement.startmatch;

import com.zsgs.mvvm.cricketscoreboardmanagement.dto.ScoreBoardDetail;
import com.zsgs.mvvm.cricketscoreboardmanagement.dto.Team;
import com.zsgs.mvvm.cricketscoreboardmanagement.repository.ScoreBoardRepository;

import java.util.ArrayList;

public class StartMatchViewModel {
    private StartMatchView startMatchView;
    public StartMatchViewModel(StartMatchView startMatchView) {
        this.startMatchView = startMatchView;
    }

    public void getScoreBoard() {
        ScoreBoardDetail scoreBoardDetails = ScoreBoardRepository.getInstance().getScoreBoard();
        startMatchView.showScoreBoard(scoreBoardDetails);
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
        ArrayList<Team> teams = ScoreBoardRepository.getInstance().getOverallScoreBoard();
        startMatchView.showOverallScoreBoard(teams);
    }

}
