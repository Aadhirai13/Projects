package com.zsgs.mvvm.cricketscoreboardmanagement.startmatch;

import com.zsgs.mvvm.cricketscoreboardmanagement.dto.ScoreBoardDetail;
import com.zsgs.mvvm.cricketscoreboardmanagement.dto.Team;
import com.zsgs.mvvm.cricketscoreboardmanagement.playmatch.PlayMatchView;

import java.util.ArrayList;
import java.util.Scanner;

public class StartMatchView {
    private Scanner scanner = new Scanner(System.in);
    private StartMatchViewModel startMatchViewModel;
    private PlayMatchView playMatchView;
    private ScoreBoardDetail scoreBoardDetails = new ScoreBoardDetail();

    static public void main(String[] args){
        StartMatchView startMatchView = new StartMatchView();
        startMatchView.startMatch();
    }

    public StartMatchView(){
        startMatchViewModel = new StartMatchViewModel(this);
        playMatchView = new PlayMatchView();
    }
    private void startMatch() {
        System.out.println("Enter no of overs : ");
        int totalOvers = scanner.nextInt();
        startMatchViewModel.setTotalOvers(totalOvers);
        System.out.println("Press 1 to toss");
        int choice = scanner.nextInt();
        if(choice == 1)
            choseToss();
        for(int match = 1;match <= 2;match++){
            System.out.println("Match - " + match);
            startMatchViewModel.setMatch(match);
            playMatchView.playMatch(totalOvers);
            startMatchViewModel.saveForOverallScoreBoard();
            startMatchViewModel.initializeLiveDetails();
        }
        getOverallScoreBoard();
    }

    private void getOverallScoreBoard() {
        startMatchViewModel.getOverallScoreBoard();
    }


    public void getScoreBoard() {
        startMatchViewModel.getScoreBoard();
    }
    public void choseToss(){
        System.out.println("Head...CSK won the toss");
        System.out.println("1.Batting\t2.Fielding");
        int ch = scanner.nextInt();
        switch (ch){
            case 1:
            {
                System.out.println("CSK chose to bat");
                startMatchViewModel.setBatFieldTeam(true);
                break;
            }
            case 2:
            {
                System.out.println("CSK chose to field");
                startMatchViewModel.setBatFieldTeam(false);
                break;
            }
        }
    }
    public void showScoreBoard(ScoreBoardDetail scoreBoardDetails) {
        this.scoreBoardDetails = scoreBoardDetails;
        System.out.println(" ___________________________________________");
        System.out.println("| "+ scoreBoardDetails.getPlayer1() + " - " + scoreBoardDetails.getP1Score() + "\t\t\t\t\t" + scoreBoardDetails.getRunsScored() + " - " + scoreBoardDetails.getWicketsCount());
        System.out.println("| "+ scoreBoardDetails.getPlayer2() + " - " + scoreBoardDetails.getP2Score() + "\t\t\t\t\t" + scoreBoardDetails.getBallCount()/6 + "." + scoreBoardDetails.getBallCount()%6 + " / " + scoreBoardDetails.getTotalOvers());
        System.out.println("| Bowler - "+ scoreBoardDetails.getBowler() + " - " + scoreBoardDetails.getCurrOverBalls());
        System.out.println("| Current over - " + scoreBoardDetails.getOverDetails().toString());
        System.out.printf("| Run Rate - %.2f%n", (double)scoreBoardDetails.getRunsScored()/scoreBoardDetails.getOverWithBall());
        System.out.println("| "+ scoreBoardDetails.getTeamBat() + " vs " + scoreBoardDetails.getTeamField());
        System.out.println("|___________________________________________");
    }

    public void showOverallScoreBoard(ArrayList<Team> teams) {
        int cskScore = 0 , rcbScore = 0;
        for(Team team : teams){
            if(team.getTeamName().equals("CSK"))
                cskScore = team.getOverallScore();
            else if(team.getTeamName().equals("RCB"))
                rcbScore = team.getOverallScore();
        }
        if(cskScore > rcbScore)
            System.out.println("CSK WINS BY " + (cskScore-rcbScore) + " RUNS");
        else if(rcbScore > cskScore)
            System.out.println("RCB WINS BY " + (rcbScore-cskScore) + " RUNS");
        else
            System.out.println("MATCH DRAW");
//        for(Teams team : teams){
//            Teams t = team;
//            System.out.println("TEAM - " + t.getTeamName() + " SCORE - " + t.getOverallScore());
//            System.out.println("______________________________________________________");
//            System.out.println("|   PLAYERS     |     SCORE     |     BALLS     |");
//            for (int i = 0;i < t.getPlayers().size();i++){
//                System.out.println("|" + t.getPlayers().get(i) + " | " + t.getIndividualScore().get(i) + " | " + t.getBallsBowled().get(i) + "|");
//            }
//            System.out.println("______________________________________________________");
//        }
    }
}

