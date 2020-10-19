//@author Audrey Sauter, Aron Manalang, Tony Hayden, Jarren Calizo
package edu.up.prod4d;

public class Stage {

    private boolean drawFromDeck(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(DrawPhase)) {
            return true;
            gameState.currentPhase = playingPhase;
        } else {
            return false;
        }
    }

    private boolean drawFromDiscard(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(DrawPhase)) {
            return true;
            gameState.currentPhase = playingPhase;
        } else {
            return false;
        }
    }

    private boolean groupCards(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(playingPhase)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean autoGin(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(playingPhase)) {
            gameState.currentPhase = endPhase;
            return true;
        } else {
            return false;
        }
    }

    private boolean organizeHand(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(playingPhase)) {
            return true;
        } else {
            return false;
        }
    }

    //Player can give up anytime
    private boolean giveUp(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(anyPhase)) {
            gameState.currentPhase = drawPhase;
            return true;
        } else {
            return false;
        }
    }

    private boolean discardCard(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(discardPhase)) {
            gameState.currentPhase = drawPhase;
            return true;
        } else {
            return false;
        }
    }

    private boolean matchWithOpponent(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(endPhase)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean quitGame(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(anyPhase)) {
            gameState.currentPhase = drawPhase;
            return true;
        } else {
            return false;
        }
    }

    private boolean restartGame(GameState gameState /* Or Stage stage not sure */) {
        if (gameState.currentPhase.equals(anyPhase)) {
            gameState.currentPhase = drawPhase;
            return true;
        } else {
            return false;
        }
    }
}
