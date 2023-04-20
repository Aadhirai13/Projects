package com.zsgs.mvvm.cricketscoreboardmanagement.playmatch;

import com.zsgs.mvvm.cricketscoreboardmanagement.repository.ScoreBoardRepository;

public class PlayMatchViewModel {
    private PlayMatchView playMatchView;
    public PlayMatchViewModel(PlayMatchView playMatchView) {
        this.playMatchView = playMatchView;
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
