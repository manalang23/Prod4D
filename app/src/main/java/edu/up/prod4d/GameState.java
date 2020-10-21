//@author Audrey Sauter, Aron Manalang, Tony Hayden, Jarren Calizo
package edu.up.prod4d;

import java.util.Random;

public class GameState {

    //Instance Variables
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
    private int amountOfDiscards;

    //Similar to a toggle, this will be true for P1 and false for P2.
    private boolean turn;

    private String currentStage;

    //Normal Constructor
    public GameState () {
        this.startingDeck = createStartingDeck();
        this.player1Cards = createPlayerHand();
        this.player2Cards = createPlayerHand();
        this.drawPile = createDrawPile();
        this.discardedCard = createDiscardPile();

        this.currentStage = "endPhase";

        this.totalOfP1 = 0;
        this.totalofP2 = 0;
        this.P1Points = 0;
        this.P2Points = 0;
        this.turn = true;
    }

    //Player methods
    //Method for drawing a card from draw pile
    public Card drawDraw(Card[] cardPile) {

        if (!(currentStage == "drawingStage")) {
            return null;
        }
        if (this.amountOfDiscards >= 32) {
            return null;
        }

        Random random = new Random();
        int chosenCard;
        if(!(cardPile.equals(this.drawPile))) { //Just to make sure this isn't called on something else.
            return null;
        } else {
            while (true) { //repeat until it has returned a card.
                chosenCard = random.nextInt(cardPile.length);
                if (cardPile[chosenCard] != null) {
                    Card returnThis = new Card(cardPile[chosenCard].getNumber(), cardPile[chosenCard].getSuit());
                    cardPile[chosenCard] = null;
                    return returnThis;
                }
            }
        }

    }
    //Method for drawing the discarded card
    public Card drawDiscard() {
        if (currentStage == "drawingStage") {
            return this.discardedCard;
        } else {
            return null;
        }
    }

    public void discardCard(Card[] cardPile, int toRemove) {
        if (this.currentStage == "discardStage") {
            cardPile[toRemove] = null;
            for (int i = toRemove; i < cardPile.length-1; i++) {
                cardPile[toRemove] = cardPile[toRemove+1];
            }
            cardPile[cardPile.length-1] = null;
        }
    }

    //Deep Copy Constructor
    public GameState (GameState gameState) {
        if (turn) {
            for (int i = 0; i < gameState.player1Cards.length; i++) {
                this.player1Cards[i] = new Card(gameState.player1Cards[i].getNumber(), gameState.player1Cards[i].getSuit());
            }
        } else {
            for (int i = 0; i < gameState.player1Cards.length; i++) {
                this.player2Cards[i] = new Card(gameState.player2Cards[i].getNumber(), gameState.player2Cards[i].getSuit());
            }
        }

        for (int i = 0; i < gameState.drawPile.length; i++) {
            this.drawPile[i] = new Card(gameState.drawPile[i].getNumber(), gameState.drawPile[i].getSuit());
        }

        //do currentPhase deep copy style later

        this.discardedCard = new Card(gameState.discardedCard.getNumber(), gameState.discardedCard.getSuit());
        this.totalOfP1 = gameState.totalOfP1;
        this.P1Points = gameState.P1Points;
        this.P2Points = gameState.P2Points;
        this.turn = gameState.turn;
    }

    //Our String methods
    public String writeHand(Card[] cardSet) {
        String returnThis = "";
        for (int i = 0 ; i < cardSet.length; i++) {
            returnThis = returnThis + cardSet[i];
        }

        return returnThis;
    }

    //@Override
    public String toString(GameState gameState) {
        String returnThis;
        returnThis = "Current phase : " + gameState.currentStage + "\n";
        //If array.toString doesn't work, this will be a for loop that goes through the array and writes it out.
        returnThis = returnThis + "Current points for both players are, from P1 to P2 : " + gameState.P1Points + "," + gameState.P2Points + "\n";
        if (turn) {
            returnThis = returnThis + "Current player is Player 1 \n";
            returnThis = returnThis + "Your cards are : " + writeHand(gameState.player1Cards) + "\n";
            returnThis = returnThis + "Your hand value is : " + gameState.totalOfP1 + "\n";
        } else {
            returnThis = returnThis + "Current player is Player 2 \n";
            returnThis = returnThis + "Your cards are : " + writeHand(gameState.player2Cards) + "\n";
            returnThis = returnThis + "Your hand value is : " + gameState.totalofP2 + "\n";
        }

        return returnThis;
    }

    //Dealing with Card methods
    public Card[] createStartingDeck() {
        Card[] startingDeck = new Card[52];

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

        return startingDeck;
    }

    public Card[] createPlayerHand() {
        Random random = new Random();
        Card[] returnThis = new Card[11];
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

        while (pileAmount < 32) {
            int getThisCard = random.nextInt(52);
            if (this.startingDeck[getThisCard] != null) {
                returnThis[pileAmount] = this.startingDeck[getThisCard];
                this.startingDeck[getThisCard] = null;
                pileAmount++;
            }
        }

        return returnThis;
    }

    //These methods can only be taken in the drawing stage//
    public boolean drawFromDeck() {
        if (this.currentStage == "drawingStage") {
            this.currentStage = "playingStage";
            return true;
        } else {
            return false;
        }
    }

    public boolean drawFromDiscard() {
        if (this.currentStage == "drawingStage") {
            this.currentStage = "playingStage";
            return true;
        } else {
            return false;
        }
    }

    public boolean autoGin() {
        if (this.currentStage == "drawingStage") {
            this.currentStage = "endStage";
            return true;
        } else {
            return false;
        }
    }
    ////////////////////////////////////////////////////////

    //These methods can only be taken in the discard stage//
    public boolean discardCard() {
        if (this.currentStage == "discardStage") {
            this.currentStage = "drawingStage";
            return true;
        } else {
            return false;
        }
    }
    ////////////////////////////////////////////////////////

    //These methods can only be taken during the endStage///
    public boolean matchWithOpponent() {
        if (this.currentStage == "endStage") {
            return true;
        } else {
            return false;
        }
    }
    ////////////////////////////////////////////////////////

    //These actions can be taken at anytime, thus they will always return true;//
    public boolean quitGame() {
            this.currentStage = "noStage";
            return true;
    }

    public boolean restartGame() {
            this.currentStage = "drawingStage";
            return true;
    }

    public boolean giveUp() {
            this.currentStage = "noPhase";
            return true;
    }

    //Player can organize anytime
    public boolean organizeHand() {
            return true;
    }

    public boolean groupCards() {
            return true;
    }
    ////////////////////////////////////////////////////////
}
