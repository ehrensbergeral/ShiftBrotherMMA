package main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiftbrothers.R;

import screens.BattleScreen;

public class Main extends Activity {

    Button btn1P, btn2P;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BattleScreen battleScreen = new BattleScreen(this);
        setContentView(battleScreen);
        //setButtons();
    }

    public void setButtons() {
        btn1P = (Button) findViewById(R.id.button1);
        btn2P = (Button) findViewById(R.id.button2);
        btn1P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Button was clicked!", Toast.LENGTH_LONG).show();
            }
        });
        btn2P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Wrong Button!", Toast.LENGTH_LONG).show();
            }
        });
    }



}
