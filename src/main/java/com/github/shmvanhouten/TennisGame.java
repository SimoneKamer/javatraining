package com.github.shmvanhouten;

public class TennisGame {

    String score(int player1score, int player2score){
        String[] scoreDescription = {"zero","fifteen","thirty","forty"};
        boolean advantage = Math.abs(player1score-player2score)== 1;
        boolean scoresAreEqual = (player1score == player2score);
        boolean atLeastThreePointsScored = (player1score >= 3);
        boolean atLeastOneScoreAboveForty = ((player1score >= 4) || (player2score >= 4));
        if (scoresAreEqual) {
            if (atLeastThreePointsScored) {
                return "deuce";
            } else {
                return scoreDescription[player1score] + " - all";
            }
        }
        else {
            if (atLeastOneScoreAboveForty){
                if (advantage){
                    if ((player1score-player2score)> 0){
                        return "Advantage Player 1";
                    } else {
                        return "Advantage Player 2";
                    }
                } else {
                    if ((player1score-player2score)> 0){
                        return "Win For Player 1";
                    } else {
                        return "Win For Player 2";
                    }
                }
            } else {
                return scoreDescription[player1score] + " - " + scoreDescription[player2score];
            }
        }
    };

};