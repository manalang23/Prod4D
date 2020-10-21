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

        Button runButton = findViewById(R.id.RunButton);
        runButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.EditText);
        editText.setText("");
        GameState firstInstance = new GameState();
        GameState secondInstance = new GameState(firstInstance);
    }
}