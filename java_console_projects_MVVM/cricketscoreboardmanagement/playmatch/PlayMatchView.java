package com.zsgs.mvvm.cricketscoreboardmanagement.playmatch;

import com.zsgs.mvvm.cricketscoreboardmanagement.startmatch.StartMatchView;

import java.util.Scanner;

public class PlayMatchView {
    private Scanner scanner = new Scanner(System.in);
    private PlayMatchViewModel playMatchViewModel;
    public PlayMatchView(){
        playMatchViewModel = new PlayMatchViewModel(this);
    }
    public void playMatch(int totalOvers) {
        playMatchViewModel.setPlayers();
        for(int currentOver = 0;currentOver < totalOvers;currentOver++){
            System.out.println("Over - " + (currentOver+1));
            giveRunForEachBall();
        }
    }

    private void giveRunForEachBall() {
        int ball = 0;
        while (ball < 6){
            System.out.println("Enter ball " + (ball+1) + " run : ");
            System.out.println(" 1-1 | 2-2 | 3-4 | 4-6 | 5-Dot ball | 6-Wicket ");
            int run = scanner.nextInt();
            switch (run) {
                case 1: {
                    playMatchViewModel.addScore(1, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    playMatchViewModel.swapPlayers();
                    break;
                }
                case 2: {
                    playMatchViewModel.addScore(2, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 3: {
                    playMatchViewModel.addScore(4, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 4: {
                    playMatchViewModel.addScore(6, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 5: {
                    playMatchViewModel.addScore(1, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 6: {
                    playMatchViewModel.addScore(0, ball);
                    playMatchViewModel.setWicket();
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                default: {
                    System.out.println("---------- No Ball ----------");
                    new StartMatchView().getScoreBoard();
                }
            }
        }
    }
}
