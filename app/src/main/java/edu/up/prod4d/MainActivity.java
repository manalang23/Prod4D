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

    }
}