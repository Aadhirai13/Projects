package com.zsgs.cricketscoreboardmanagement.repository;

import com.zsgs.cricketscoreboardmanagement.dto.Batting;
import com.zsgs.cricketscoreboardmanagement.dto.Fielding;
import com.zsgs.cricketscoreboardmanagement.dto.ScoreBoardDetails;
import com.zsgs.cricketscoreboardmanagement.dto.Teams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ScoreBoardRepository {

    public static ScoreBoardRepository scoreBoardRepository;
    private static ArrayList<Teams> teams = new ArrayList<>();
    private static ScoreBoardDetails liveMatchDetails = new ScoreBoardDetails();
    private static ArrayList<Batting> battingDetails = new ArrayList<>();
    private static ArrayList<Fielding> fieldingDetails = new ArrayList<>();
    private ScoreBoardRepository(){}

    public static ScoreBoardRepository getInstance(){
        if(scoreBoardRepository == null){
            scoreBoardRepository = new ScoreBoardRepository();
            setTeamNames();
        }
        return scoreBoardRepository;
    }

    private static void setTeamNames() {
        ArrayList<String> team1Players = new ArrayList<>(setTeamPlayers(1));
        ArrayList<Integer> individualScores = getDefault();
        ArrayList<Integer> ballsBowled = getDefault();
        ArrayList<Boolean> isOut = getOutStatus();
        teams.add(new Teams("CSK", team1Players, 0, individualScores, ballsBowled));
        ArrayList<String> team2Players = new ArrayList<>(setTeamPlayers(2));
        teams.add(new Teams("RCB", team2Players, 0, individualScores, ballsBowled));
    }

    private static ArrayList<Boolean> getOutStatus() {
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i=0;i<11;i++)
            result.add(false);
        return result;
    }

    private static ArrayList<Integer> getDefault() {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<11;i++)
            result.add(0);
        return result;
    }

    private static Queue<String> setTeamPlayers(int team) {
        Queue<String> players = new LinkedList<>();
        for(int i = 1;i <= 11;i++)
            players.add("T"+team+"-Player"+i);
        return players;
    }

    public int getOverallScore() {
        int overallScore = 0;
        for (Teams team : teams){
            if(team.getTeamName().equals(liveMatchDetails.getTeamBat()))
                overallScore = liveMatchDetails.getRunsScored();
        }
        return overallScore;
    }

    public ScoreBoardDetails getScoreBoard() {
        ScoreBoardDetails scoreBoardDetails = liveMatchDetails;
        return scoreBoardDetails;
    }

    public void setBatFieldTeam(boolean isBatting) {
        Queue<String> team1Players = setTeamPlayers(1);
        Queue<String> team2Players = setTeamPlayers(2);
        if (isBatting) {
            battingDetails.add(new Batting());
            battingDetails.get(0).setTeamName("CSK");
            battingDetails.get(0).setPlayers(team1Players);
            fieldingDetails.add(new Fielding());
            fieldingDetails.get(0).setTeamName("RCB");
            fieldingDetails.get(0).setPlayers(team2Players);
            liveMatchDetails.setTeamBat("CSK");
            liveMatchDetails.setTeamField("RCB");
        }
        else{
            battingDetails.add(new Batting());
            battingDetails.get(0).setTeamName("RCB");
            battingDetails.get(0).setPlayers(team2Players);
            fieldingDetails.add(new Fielding());
            fieldingDetails.get(0).setTeamName("CSK");
            fieldingDetails.get(0).setPlayers(team1Players);
            liveMatchDetails.setTeamBat("RCB");
            liveMatchDetails.setTeamField("CSK");
        }
    }

    public void addScore(int run,int ball) {
        if(liveMatchDetails.getCurrPlayer().equals(liveMatchDetails.getPlayer1()))
            liveMatchDetails.setP1Score(liveMatchDetails.getP1Score() + run);
        else
            liveMatchDetails.setP2Score(liveMatchDetails.getP2Score() + run);
        liveMatchDetails.setBallCount(liveMatchDetails.getBallCount()+1);
        liveMatchDetails.setRunsScored(liveMatchDetails.getRunsScored()+run);
        if(liveMatchDetails.getBallCount()%6 == 1){
            liveMatchDetails.setCurrOverBalls(1);
            liveMatchDetails.setOverDetails(new ArrayList<>());
        }
        else
            liveMatchDetails.setCurrOverBalls(liveMatchDetails.getCurrOverBalls()+1);
        if(liveMatchDetails.getBallCount() > 6 && liveMatchDetails.getBallCount()%6 == 1)
            changeBowler();
        liveMatchDetails.getOverDetails().add(ball,run);
        String overWithBall = (liveMatchDetails.getBallCount()/6) + "." + (liveMatchDetails.getBallCount()%6);
        liveMatchDetails.setOverWithBall(Double.parseDouble(overWithBall));
        if(liveMatchDetails.getBallCount() == liveMatchDetails.getTotalOvers()*6){
            for(Teams team : teams){
                if(team.getTeamName().equals(liveMatchDetails.getTeamBat())){
                    team.setOverallScore(liveMatchDetails.getRunsScored());
                }
            }
        }
        for(Teams team : teams){
            if(team.getTeamName().equals(liveMatchDetails.getTeamBat())){
                int p1Index = team.getPlayers().indexOf(liveMatchDetails.getPlayer1());
                int p2Index = team.getPlayers().indexOf(liveMatchDetails.getPlayer2());
                ArrayList<Integer> p = team.getIndividualScore();
                p.set(p1Index,liveMatchDetails.getP1Score());
                p.set(p2Index,liveMatchDetails.getP2Score());
                team.setIndividualScore(p);
            }
            else{
                int bIndex = team.getPlayers().indexOf(liveMatchDetails.getBowler());
                ArrayList<Integer> p = team.getBallsBowled();
                p.set(bIndex,p.get(bIndex)+1);
                team.setBallsBowled(p);
            }
        }
    }

    private void changeBowler() {
        for(Fielding fielding : fieldingDetails){
            if(fielding.getTeamName().equals(liveMatchDetails.getTeamField())){
                String bowler = fielding.getPlayers().poll();
                liveMatchDetails.setBowler(bowler);
                fielding.getPlayers().add(bowler);
                fielding.setPlayers(fielding.getPlayers());
            }
        }
    }

    public void setTotalOvers(int totalOvers) {
        liveMatchDetails.setTotalOvers(totalOvers);
    }

    public void swapPlayers() {
        if(liveMatchDetails.getPlayer1().equals(liveMatchDetails.getCurrPlayer()))
            liveMatchDetails.setCurrPlayer(liveMatchDetails.getPlayer2());
        else
            liveMatchDetails.setCurrPlayer(liveMatchDetails.getPlayer1());
    }

    public void setWicket() {
        int score = 0;
        if(liveMatchDetails.getCurrPlayer().equals(liveMatchDetails.getPlayer1()))
            score = liveMatchDetails.getP1Score();
        else
            score = liveMatchDetails.getP2Score();
        updateWicketAndScore(score);
        liveMatchDetails.setWicketsCount(liveMatchDetails.getWicketsCount()+1);
        //change current player to new player from queue
        String newPlayer = "";
        for(Batting batting : battingDetails){
            if(batting.getTeamName() == liveMatchDetails.getTeamBat()){
                newPlayer = batting.getPlayers().poll();
            }
        }
        if(liveMatchDetails.getCurrPlayer().equals(liveMatchDetails.getPlayer1())){
            liveMatchDetails.setCurrPlayer(newPlayer);
            liveMatchDetails.setPlayer1(newPlayer);
            liveMatchDetails.setP1Score(0);
        }
        else{
            liveMatchDetails.setCurrPlayer(newPlayer);
            liveMatchDetails.setPlayer2(newPlayer);
            liveMatchDetails.setP2Score(0);
        }
    }

    private void updateWicketAndScore(int score) {
        String currPlayer = liveMatchDetails.getCurrPlayer();
        for(Teams teams : teams){
            if(teams.getTeamName().equals(liveMatchDetails.getTeamBat())){
                int index = teams.getPlayers().indexOf(currPlayer);
                teams.getIndividualScore().set(index,score);
            }
        }
    }

    public void setMatch(int match) {
        liveMatchDetails.setMatch(match);
    }

    public void setPlayers() {
        if(liveMatchDetails.getMatch()==2)
            changeBatFieldTeam();
        //set Batting player1 , player2 , bowler , current player
        if(liveMatchDetails.getPlayer1() == null){
            for(Batting batting : battingDetails){
                if(batting.getTeamName().equals(liveMatchDetails.getTeamBat())){
                    liveMatchDetails.setPlayer1(batting.getPlayers().poll());
                    liveMatchDetails.setPlayer2(batting.getPlayers().poll());
                    liveMatchDetails.setCurrPlayer(liveMatchDetails.getPlayer1());
                    break;
                }
            }
            for(Fielding fielding : fieldingDetails){
                if(fielding.getTeamName().equals(liveMatchDetails.getTeamField())){
                    String bowler = fielding.getPlayers().poll();
                    liveMatchDetails.setBowler(bowler);
                    fielding.getPlayers().add(bowler);
                    fielding.setPlayers(fielding.getPlayers());
                    break;
                }
            }
        }
    }

    public void changeBatFieldTeam() {
        for(Teams team : teams){
            if(!liveMatchDetails.getTeamBat().equals(team.getTeamName()))
                liveMatchDetails.setTeamBat(team.getTeamName());
            else
                liveMatchDetails.setTeamField(team.getTeamName());
        }
        if(liveMatchDetails.getTeamBat().equals("CSK"))
            setBatFieldTeam(true);
        else
            setBatFieldTeam(false);
    }

    public void initializeLiveDetails(){
        liveMatchDetails.setP1Out(false);
        liveMatchDetails.setP2Out(false);
        liveMatchDetails.setP1Score(0);
        liveMatchDetails.setP2Score(0);
        liveMatchDetails.setBallCount(0);
        liveMatchDetails.setWicketsCount(0);
        liveMatchDetails.setRunsScored(0);
        liveMatchDetails.setOverWithBall(0.0);
        liveMatchDetails.setPlayer1(null);
    }

    public void saveForOverallScoreBoard() {
        for(Teams team : teams){
            if(team.getTeamName().equals(liveMatchDetails.getTeamBat())){
                team.setOverallScore(liveMatchDetails.getRunsScored());
            }
        }
    }

    public ArrayList<Teams> getOverallScoreBoard() {
        return teams;
    }

}
