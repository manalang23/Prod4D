package edu.up.prod4d;

import android.media.audiofx.DynamicsProcessing;

import java.security.PKCS12Attribute;

public class GameState {
    private Card[] playerCards;
    private Card[] drawPile;
    private Card discardedCard;

    //Depending on which player, the current total of hand will display.
    private int totalOfP1;
    private int P1Points;
    private int totalofP2;
    private int P2Points;

    //Similar to a toggle, this will be true for P1 and false for P2.
    private boolean turn;

    private Stage currentPhase;

    public GameState (Cards[] playerCards, Cards[] drawPile, Card discardedCard, int totalOfP1, int totalofP2, int p1Points, int p2Points, boolean turn, Stage currentPhase) {
        this.playerCards = playerCards;
        this.drawPile = drawPile;
        this.discardedCard = discardedCard;
        this.totalOfP1 = totalOfP1;
        this.totalofP2 = totalofP2;
        this.P1Points = P1Points;
        this.P2Points = P2Points;
        this.turn = turn;
        this.currentPhase = currentPhase;
    }

    public GameState (GameState gameState) {
        if (turn) {
            this.playerCards = playerCards;
            this.drawPile = drawPile;
            this.discardedCard = discardedCard;
            this.totalOfP1 = totalOfP1;
            this.P1Points = P1Points;
            this.P2Points = P2Points;
            this.turn = turn;
            this.currentPhase = currentPhase;
        } else {
            this.playerCards = playerCards;
            this.drawPile = drawPile;
            this.discardedCard = discardedCard;
            this.totalofP2 = totalofP2;
            this.P1Points = P1Points;
            this.P2Points = P2Points;
            this.turn = turn;
            this.currentPhase = currentPhase;
        }
    }

    public String toString(GameState gameState) {
        String returnThis;
        returnThis = "Current phase : " + GameState.currentPhase + "\n";
        //If array.toString doesn't work, this will be a for loop that goes through the array and writes it out.
        returnThis = returnThis + "Your cards are : " + GameState.playerCards.toString() + "\n";
        returnThis = returnThis + "Current points for both players are, from P1 to P2 : " + GameState.P1Points + "," + GameState.P2Points + "\n";
        if (turn) {
            returnThis = returnThis + "Current player is Player 1 \n";
            returnThis = returnThis + "Your hand value is : " + GameState.totalofP1 + "\n";
        } else {
            returnThis = returnThis + "Current player is Player 2 \n";
            returnThis = returnThis + "Your hand value is : " + GameState.totalofP2 + "\n";
        }


    }
}
