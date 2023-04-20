package com.zsgs.cricketscoreboardmanagement.playmatch;

import com.zsgs.cricketscoreboardmanagement.dto.ScoreBoardDetails;
import com.zsgs.cricketscoreboardmanagement.repository.ScoreBoardRepository;

public class PlayMatchModel implements PlayMatchControllerModelCallBack {
    private PlayMatchModelControllerCallBack playMatchController;
    public PlayMatchModel(PlayMatchController playMatchController) {
        this.playMatchController = playMatchController;
    }

    public void setPlayers() {
        ScoreBoardRepository.getInstance().setPlayers();
    }

    public void addScore(int run,int ball) {
        ScoreBoardRepository.getInstance().addScore(run,ball);
    }

    public void swapPlayers() {
        ScoreBoardRepository.getInstance().swapPlayers();
    }

    public void setWicket() {
        ScoreBoardRepository.getInstance().setWicket();
    }

}
