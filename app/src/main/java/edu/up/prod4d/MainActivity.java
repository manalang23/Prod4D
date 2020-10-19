//@author Audrey Sauter, Aron Manalang, Tony Hayden, Jarren Calizo
package edu.up.prod4d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Controller eventController = new Controller();

        EditText editText = findViewById(R.id.EditText);

        Button runButton = findViewById(R.id.RunButton);
        runButton.setOnClickListener(eventController);

        //List of all the cards
        //Diamonds
        Card D1 = new Card(1, "Diamonds");
        Card D2 = new Card(2, "Diamonds");
        Card D3 = new Card(3, "Diamonds");
        Card D4 = new Card(4, "Diamonds");
        Card D5 = new Card(5, "Diamonds");
        Card D6 = new Card(6, "Diamonds");
        Card D7 = new Card(7, "Diamonds");
        Card D8 = new Card(8, "Diamonds");
        Card D9 = new Card(9, "Diamonds");
        Card D10 = new Card(10, "Diamonds");
        Card D11 = new Card(11, "Diamonds");
        Card D12 = new Card(12, "Diamonds");
        Card D13 = new Card(13, "Diamonds");

        //Hearts
        Card H1 = new Card (1, "Hearts");
        Card H2 = new Card (2, "Hearts");
        Card H3 = new Card (3, "Hearts");
        Card H4 = new Card (4, "Hearts");
        Card H5 = new Card (5, "Hearts");
        Card H6 = new Card (6, "Hearts");
        Card H7 = new Card (7, "Hearts");
        Card H8 = new Card (8, "Hearts");
        Card H19 = new Card (9, "Hearts");
        Card H10 = new Card (10, "Hearts");
        Card H11 = new Card (11, "Hearts");
        Card H12 = new Card (12, "Hearts");
        Card H13 = new Card (13, "Hearts");

        //Spades
        Card S1 = new Card (1, "Spades");
        Card S2 = new Card (2, "Spades");
        Card S3 = new Card (3, "Spades");
        Card S4 = new Card (4, "Spades");
        Card S5 = new Card (5, "Spades");
        Card S6 = new Card (6, "Spades");
        Card S7 = new Card (7, "Spades");
        Card S8 = new Card (8, "Spades");
        Card S9 = new Card (9, "Spades");
        Card S10 = new Card (10, "Spades");
        Card S11 = new Card (11, "Spades");
        Card S12 = new Card (12, "Spades");
        Card S13 = new Card (13, "Spades");

        //Clubs
        Card C1 = new Card (1, "Clubs");
        Card C2 = new Card (2, "Clubs");
        Card C3 = new Card (3, "Clubs");
        Card C4 = new Card (4, "Clubs");
        Card C5 = new Card (5, "Clubs");
        Card C6 = new Card (6, "Clubs");
        Card C7 = new Card (7, "Clubs");
        Card C8 = new Card (8, "Clubs");
        Card C9 = new Card (9, "Clubs");
        Card C10 = new Card (10, "Clubs");
        Card C11 = new Card (11, "Clubs");
        Card C12 = new Card (12, "Clubs");
        Card C13 = new Card (13, "Clubs");

        Card[] cardArray = new Card[52];
        for (int i = 0; i < 52; i++) {
            if (i < 13) {
                cardArray[i] = "D"+i;
            }
        }
        int[] intArray = new int[52];
        for (int i = 1; i<52; i++) {
            intArray[i-1] = i;
        }
        //if int < 13; diamond + i
    }
}