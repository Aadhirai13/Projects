package com.zsgs.cricketscoreboardmanagement.playmatch;

import com.zsgs.cricketscoreboardmanagement.startmatch.StartMatchView;

import java.util.Scanner;

public class PlayMatchView implements PlayMatchControllerViewCallBack {
    private Scanner scanner = new Scanner(System.in);
    private PlayMatchViewControllerCallBack playMatchController;
    public PlayMatchView(){
        playMatchController = new PlayMatchController(this);
    }
    public void playMatch(int totalOvers) {
        playMatchController.setPlayers();
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
                    playMatchController.addScore(1, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    playMatchController.swapPlayers();
                    break;
                }
                case 2: {
                    playMatchController.addScore(2, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 3: {
                    playMatchController.addScore(4, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 4: {
                    playMatchController.addScore(6, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 5: {
                    playMatchController.addScore(1, ball);
                    ball++;
                    new StartMatchView().getScoreBoard();
                    break;
                }
                case 6: {
                    playMatchController.addScore(0, ball);
                    playMatchController.setWicket();
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
