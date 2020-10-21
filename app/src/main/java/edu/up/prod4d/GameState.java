//@author Audrey Sauter, Aron Manalang, Tony Hayden, Jarren Calizo
package edu.up.prod4d;

import android.media.audiofx.DynamicsProcessing;

import java.security.PKCS12Attribute;
import java.util.Hashtable;
import java.util.Random;

public class GameState {
    private Card[] startingDeck;
    private Card[] player1Cards;
    private Card[] player2Cards;
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

    public GameState () {
        this.startingDeck = createStartingDeck();
        this.player1Cards = createPlayerHand();
        this.player2Cards = createPlayerHand();
        this.drawPile = createDrawPile();
        this.discardedCard = createDiscardPile();
        this.totalOfP1 = 0;
        this.totalofP2 = 0;
        this.P1Points = 0;
        this.P2Points = 0;
        this.turn = true;
        this.currentPhase = null;
    }

    public Card[] createPlayerHand() {
        Random random = new Random();
        Card[] returnThis = new Card[10];
        int handCount = 0;

        while (handCount < 10) {
            int getThisCard = random.nextInt(52);
            if (this.startingDeck[getThisCard] != null) {
                returnThis[handCount] = startingDeck[getThisCard];
                this.startingDeck[getThisCard]=null;
                handCount++;
            }
        }
        return returnThis;
    }

    public Card createDiscardPile() {
        Card returnMe = null;
        Random random = new Random();

        while (returnMe == null) {
            int getThisCard = random.nextInt(52);
            if (this.startingDeck[getThisCard] != null) {
                returnMe = startingDeck[getThisCard];
                startingDeck[getThisCard] = null;
            }
        }

        return returnMe;
    }

    public Card[] createDrawPile() {
        Random random = new Random();
        Card[] returnThis = new Card[31];
        int pileAmount = 0;

        int getThisCard = random.nextInt(52);
        while (pileAmount < 31) {
            if (this.startingDeck[getThisCard] != null) {
                returnThis[pileAmount] = this.startingDeck[getThisCard];
                this.startingDeck[getThisCard] = null;
                pileAmount++;
            }
        }

        return returnThis;
    }

    public GameState (GameState gameState) {
        if (turn) {
            this.player1Cards = player1Cards;
            this.drawPile = drawPile;
            this.discardedCard = discardedCard;
            this.totalOfP1 = totalOfP1;
            this.P1Points = P1Points;
            this.P2Points = P2Points;
            this.turn = turn;
            this.currentPhase = currentPhase;
        } else {
            this.player2Cards = player2Cards;
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
        int DELETETHIS;
        String returnThis;
        returnThis = "Current phase : " + GameState.currentPhase + "\n";
        //If array.toString doesn't work, this will be a for loop that goes through the array and writes it out.
        returnThis = returnThis + "Current points for both players are, from P1 to P2 : " + GameState.P1Points + "," + GameState.P2Points + "\n";
        if (turn) {
            returnThis = returnThis + "Current player is Player 1 \n";
            returnThis = returnThis + "Your cards are : " + GameState.player1Cards.toString() + "\n";
            returnThis = returnThis + "Your hand value is : " + GameState.totalofP1 + "\n";
        } else {
            returnThis = returnThis + "Current player is Player 2 \n";
            returnThis = returnThis + "Your cards are : " + GameState.player2Cards.toString() + "\n";
            returnThis = returnThis + "Your hand value is : " + GameState.totalofP2 + "\n";
        }


    }

    public Card[] createStartingDeck() {
        //Hearts
        startingDeck[0] = new Card(1, "Hearts");
        startingDeck[1] = new Card(2, "Hearts");
        startingDeck[2] = new Card(3, "Hearts");
        startingDeck[3] = new Card(4, "Hearts");
        startingDeck[4] = new Card(5, "Hearts");
        startingDeck[5] = new Card(6, "Hearts");
        startingDeck[6] = new Card(7, "Hearts");
        startingDeck[7] = new Card(8, "Hearts");
        startingDeck[8] = new Card(9, "Hearts");
        startingDeck[9] = new Card(10, "Hearts");
        startingDeck[10] = new Card(11, "Hearts");
        startingDeck[11] = new Card(12, "Hearts");
        startingDeck[12] = new Card(13, "Hearts");

        //Diamonds
        startingDeck[13] = new Card(1, "Diamonds");
        startingDeck[14] = new Card(2, "Diamonds");
        startingDeck[15] = new Card(3, "Diamonds");
        startingDeck[16] = new Card(4, "Diamonds");
        startingDeck[17] = new Card(5, "Diamonds");
        startingDeck[18] = new Card(6, "Diamonds");
        startingDeck[19] = new Card(7, "Diamonds");
        startingDeck[20] = new Card(8, "Diamonds");
        startingDeck[21] = new Card(9, "Diamonds");
        startingDeck[22] = new Card(10, "Diamonds");
        startingDeck[23] = new Card(11, "Diamonds");
        startingDeck[24] = new Card(12, "Diamonds");
        startingDeck[25] = new Card(13, "Diamonds");

        //Spades
        startingDeck[26] = new Card(1,"Spades");
        startingDeck[27] = new Card(2,"Spades");
        startingDeck[28] = new Card(3,"Spades");
        startingDeck[29] = new Card(4,"Spades");
        startingDeck[30] = new Card(5,"Spades");
        startingDeck[31] = new Card(6,"Spades");
        startingDeck[32] = new Card(7,"Spades");
        startingDeck[33] = new Card(8,"Spades");
        startingDeck[34] = new Card(9,"Spades");
        startingDeck[35] = new Card(10,"Spades");
        startingDeck[36] = new Card(11,"Spades");
        startingDeck[37] = new Card(12,"Spades");
        startingDeck[38] = new Card(13,"Spades");

        //Clubs
        startingDeck[39] = new Card(1, "Clubs");
        startingDeck[40] = new Card(2, "Clubs");
        startingDeck[41] = new Card(3, "Clubs");
        startingDeck[42] = new Card(4, "Clubs");
        startingDeck[43] = new Card(5, "Clubs");
        startingDeck[44] = new Card(6, "Clubs");
        startingDeck[45] = new Card(7, "Clubs");
        startingDeck[46] = new Card(8, "Clubs");
        startingDeck[47] = new Card(9, "Clubs");
        startingDeck[48] = new Card(10, "Clubs");
        startingDeck[49] = new Card(11, "Clubs");
        startingDeck[50] = new Card(12, "Clubs");
        startingDeck[51] = new Card(13, "Clubs");
    }
}
