package main;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiftbrothers.R;

import screens.BattleScreen;

public class Main extends Activity {

    private int width;
    private int height;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BattleScreen battleScreen = new BattleScreen(this);
        setContentView(battleScreen);
        //setButtons();
    }

    private void calculateScreenWidth() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
    }

    public int getWidth() {
        return height; // Nur spielbar im Querformat, daher Höhe = Breite
    }

    public int getHeight() {
        return height;
    }



}
