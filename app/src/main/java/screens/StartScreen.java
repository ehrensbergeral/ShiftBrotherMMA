package screens;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiftbrothers.R;

import interfaces.Constants;

public class StartScreen extends Activity implements Constants {

    Button btn1P, btn2P;

    String tutorialtext;
    int ex;
    int ey;
    int width = 400;
    int btnx1 = 300;

    Button interval;
    @Override
    public void onCreate(Bundle savedInstanceStats) {
        super.onCreate(savedInstanceStats);
        setContentView(R.layout.start_screen_activity);

        reviveCharacters();
        resetStats();
        setButtons();
        setBackground();
        setLogo();
        setCharacters();
    }

    private void setButtons() {
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

    private void setCharacters() {
    }

    private void setLogo() {
    }

    private void setBackground() {
    }

    private void reviveCharacters() {
        if (harald.isDead()) harald.revive();
        if (gustav.isDead()) gustav.revive();
    }

    private void resetStats() {
        harald.setMaxHP(3000);
        harald.setHP(3000);
        harald.setAttack(20);
        harald.setDefense(10);
        harald.setSpeed(10);
        harald.setGil(10);
        gustav.setMaxHP(3000);
        gustav.setHP(3000);
        gustav.setAttack(20);
        gustav.setDefense(10);
        gustav.setSpeed(10);
        gustav.setGil(10);
    }

    public void fillTutorialText() {
        tutorialtext = "Zwei Brüder wollen sich verkloppen.\nDoch leider sind sie Shift Brothers und\ntauschen alle 33 Sekunden ihre Körper.\n\n Ziel: Setze die HP deines Gegners auf 0.\n In wessen Körper du am Ende überlebst,\n spielt keine Rolle.\n\n Sobald du mit deinem Gegner Körper\n tauscht, übernimmst du alle seine Werte:\n HP, Angriffsstärke, Verteidigung,\n und selbstverständlich sein Geld\n (auf das du natürlich ganz\n liebevoll aufpasst).";
    }

    /*boolean startscreen = true;
    boolean setNewScreen = false;
    private int maxTime;
    private boolean oneplayer = true;
    private boolean b;

    public void render(float delta) {
        if (startscreen == true) {
            ex = Gdx.input.getX();
            ey = Gdx.graphics.getHeight() - Gdx.input.getY();
            ScreenUtils.clear(0, 0, 0, 1);
            game.batch.begin();
            if (Gdx.input.isTouched() && btn1P.isButton(ex,ey)) {
                b = true;
            }
            if (Gdx.input.isTouched() && btn2P.isButton(ex,ey)) {
                b = true;
                oneplayer = false;
            }
            if (!Gdx.input.isTouched() && b) {
                startscreen = false;
            }
            game.batch.draw(bg, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            game.batch.draw(logo, Gdx.graphics.getWidth()/2 - logo.getWidth()/2, 600);
            game.batch.draw(hartex, Gdx.graphics.getWidth()/2 - logo.getWidth()/2 - 180, 600);
            game.batch.draw(gustex, Gdx.graphics.getWidth()/2 + logo.getWidth()/2 + 180 - gustex.getWidth(), 600);
            game.batch.end();
            game.shape = new ShapeRenderer();
            game.shape.begin(ShapeRenderer.ShapeType.Filled);
            btn1P.draw(game.shape);
            btn2P.draw(game.shape);
            game.shape.end();
            game.batch.begin();
            btn1P.getLabel().drawLabel(Gdx.graphics.getWidth()/2 - 30, 310, game.batch);
            btn2P.getLabel().drawLabel(Gdx.graphics.getWidth()/2 - 30, 160, game.batch);
            game.batch.end();
        } else {
            if (setNewScreen==true) { game.setScreen(new IntroBattleScreen(maxTime, game, oneplayer));
            } else {
                ex = Gdx.input.getX();
                ey = Gdx.graphics.getHeight() - Gdx.input.getY();
                ScreenUtils.clear(0, 0, 0, 1);
                game.batch.begin();
                game.batch.draw(bg, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                game.batch.end();
                game.shape.begin(ShapeRenderer.ShapeType.Filled);
                for (int i=0; i<3; i++) displayButton(i);
                if (Gdx.input.isTouched() && blitzkrieg.isButton(ex,ey)) {
                    maxTime = 11;
                    setNewScreen = true;
                }
                if (Gdx.input.isTouched() && gemetzel.isButton(ex,ey)) {
                    maxTime = 33;
                    setNewScreen = true;
                }
                if (Gdx.input.isTouched() && kaffeklatsch.isButton(ex,ey)) {
                    maxTime = 55;
                    setNewScreen = true;
                }
                tutorial.draw(game.shape);
                //interval.draw(game.shape);
                blitzkrieg.draw(game.shape);
                gemetzel.draw(game.shape);
                kaffeklatsch.draw(game.shape);
                game.shape.end();
                game.batch.begin();
                tutorial.getLabel().drawLabel(Gdx.graphics.getWidth()/2-270, 880, game.batch);
                blitzkrieg.getLabel().drawLabel(btnx1 + width/2-90, 180, game.batch);
                gemetzel.getLabel().drawLabel(btnx2+ width/2-90, 180, game.batch);
                kaffeklatsch.getLabel().drawLabel(btnx3+ width/2-90, 180, game.batch);
                interval.getLabel().drawLabel(btnx1 + 250, 270, game.batch);
                game.batch.end();
            }
        }

    }*/

}
