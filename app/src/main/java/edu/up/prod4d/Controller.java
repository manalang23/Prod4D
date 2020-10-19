//@author Audrey Sauter, Aron Manalang, Tony Hayden, Jarren Calizo
package edu.up.prod4d;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Controller implements Button.OnClickListener {

    private EditText editText;

    @Override
    public void onClick(View view) {
        editText.setText("");
        GameState firstInstance = new GameState(null, null, null, 0, 0, 0, 0, true, null);
        GameState secondInstance = new GameState(firstInstance);

    }
}
