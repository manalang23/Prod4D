//@author Audrey Sauter, Aron Manalang, Tony Hayden, Jarren Calizo
package edu.up.prod4d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.EditText);
        editText.setText("");

        Button runButton = findViewById(R.id.RunButton);
        runButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.EditText);
        editText.setText("");
        GameState firstInstance = new GameState();
        //GameState secondInstance = new GameState(firstInstance);

        //Draw from deck
        if(firstInstance.drawFromDeck()) {
            Card writeThis = firstInstance.drawDraw();
            if(writeThis != null) {
                editText.getText().append("Player 1 drew  ");
                editText.getText().append(writeThis.getNumber() + " of " + writeThis.getSuit() + "from the draw pile. ");
            } else {
                editText.getText().append("Player 1 tried to draw from draw pile but couldn't. ");
            }
        }
        else {
            editText.getText().append("Player 1 tried to draw from draw pile but couldn't. ");
        }

        //Draw from discard
        if(firstInstance.drawFromDiscard()) {
            editText.getText().append("Player 1 drew from the discard pile. ");
        }
        else {
            editText.getText().append("Player 1 tried to draw from discard pile but couldn't. ");
        }

        //Auto Gin
        if(firstInstance.autoGin()) {
            editText.getText().append("Player 1 auto gin. ");
        }
        else {
            editText.getText().append("Player cannot gin. ");
        }

        //Discard card
        if(firstInstance.discardCard()) {
            editText.getText().append("Player 1 discard a card. ");
        }

        //Match with opponent
        if(firstInstance.matchWithOpponent()) {
            editText.getText().append("Player 1 matched their cards with the opponents cards. ");
        }
        else {
            editText.getText().append("Player 1 couldn't match their cards. ");
        }

        //Quit game
        if(firstInstance.quitGame()) {
            editText.getText().append("Player 1 quit the game. ");
        }
        else {
            editText.getText().append("Player 1 didn't quit. ");
        }

        //Restart Game
        if(firstInstance.restartGame()) {
            editText.getText().append("Player 1 restarted the game. ");
        }
        else {
            editText.getText().append("Player 1 didn't restart. ");
        }

        //Give up
        if(firstInstance.giveUp()) {
            editText.getText().append("Player 1 gave up. ");
        }
        else {
            editText.getText().append("Player 1 didn't give up. ");
        }

        //Organize hand
        if(firstInstance.organizeHand()) {
            editText.getText().append("Player 1 organized their hand. ");
        }
        else {
            editText.getText().append("Player 1 didn't organize their hand. ");
        }

        //Group cards
        if(firstInstance.groupCards()) {
            editText.getText().append("Player 1 grouped their cards. ");
        }
        else {
            editText.getText().append("Player 1 didn't group their cards. ");
        }

        GameState thirdInstance = new GameState();
        //GameState fourthInstance = new GameState(thirdInstance);

       // editText.getText().append(secondInstance.toString());
        //editText.getText().append(fourthInstance.toString());
        //System.out.println(secondInstance.toString());
        //System.out.println(fourthInstance.toString());
    }
}