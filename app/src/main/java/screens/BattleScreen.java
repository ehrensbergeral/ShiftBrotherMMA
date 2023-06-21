package screens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

import battleUtilities.Core;
import interfaces.Constants;
import battleButtons.BattleButton;
import battleButtons.ClockButton;
import battleButtons.DonateButton;
import battleButtons.FightButton;
import main.Fighter;
import battleButtons.ItemButton;
import main.ItemMenu;

public class BattleScreen extends View implements Constants {

    private Context context;
    private BattleButton[] buttons;
    private ItemMenu itemMenu;
    private Paint paint;
    private int buttonWidth = 300;
    private int buttonHeight = 100;
    private int buttonX, buttonDistance, buttonY;

    private int[] fighterX = new int[2];
    private int fighter1X, fighter2X, fighterY, fighterWidth, fighterHeight;
    private int screenWidth, screenHeight;
    private Canvas canvas;

    public BattleScreen(Context context) {
        super(context);
        this.context = context;
        setUp();
    }

    private void setUp() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        calculatePositions();

        buttons = new BattleButton[4];
        itemMenu = new ItemMenu(context);
        buttonDistance = 50;
        buttonY = 250;
    }

    private void setBattleButtonTypes() {
        buttons[0] = new FightButton(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, context);
        buttons[1] = new ItemButton(buttonX, buttonY + buttonHeight + buttonDistance, buttonX + buttonWidth, buttonY + buttonHeight * 2 + buttonDistance, context);
        buttons[2] = new DonateButton(buttonX, buttonY + (buttonHeight + buttonDistance) * 2, buttonX + buttonWidth, buttonY + buttonHeight * 3 + buttonDistance * 2, context);
        buttons[3] = new ClockButton(buttonX, buttonY + (buttonHeight + buttonDistance) * 3, buttonX + buttonWidth, buttonY + buttonHeight * 4 + buttonDistance * 3, context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        buttonX = getWidth() / 2 - buttonWidth / 2;
        setBattleButtonTypes();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (BattleButton button : buttons) {
                    if (button.contains((int) touchX, (int) touchY) && c.itemMenuOpened() == false) {
                        button.runActionDown(touchX, touchY);
                    }
                    if (c.itemMenuOpened() == true && itemMenu.contains((int) touchX, (int) touchY) == false) {
                        c.openItemMenu(false);
                    }
                }
                invalidate(); // Aktualisieren der View, um die Änderungen anzuzeigen
                break;
            case MotionEvent.ACTION_MOVE:
                for (BattleButton button : buttons) {
                    button.runActionMove(touchX, touchY);
                }
                invalidate(); // Aktualisieren der View, um die Änderungen anzuzeigen
                break;
            case MotionEvent.ACTION_UP:
                for (BattleButton button : buttons) {
                    button.runActionUp(touchX, touchY);
                }
                invalidate(); // Aktualisieren der View, um die Änderungen anzuzeigen
                break;
        }
        return true;
    }

    private void calculatePositions() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
        fighter1X = screenWidth / 10;
        fighterWidth = screenWidth / 10;
        fighterHeight = (int) ((double) fighterWidth * 1.47);
        fighterX[0] = screenWidth / 10;
        fighterX[1] = screenWidth - (screenWidth / 10 + fighterWidth);
        fighter2X = screenWidth - (screenWidth / 10 + fighterWidth);
        fighterY = screenHeight / 3;
    }

    //--------------------------------------------------------------------
    //DRAW METHODS
    //--------------------------------------------------------------------

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        canvas.drawColor(Color.parseColor("#000033"));
        drawFighters();
        drawButtons();
        drawLabels();
       // itemMenu.draw(canvas, paint);
    }

    private void drawFighters() {
        try {
            for (int i = 0; i < 2; i++) {
                InputStream isP = context.getAssets().open(fighterSprites[i]);
                Bitmap bitmapP = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(isP), fighterWidth, fighterHeight, false);
                canvas.drawBitmap(bitmapP, fighterX[i], fighterY, null);
            }
        } catch (IOException e) {
            Log.e("GraphicsActivity", e.getMessage());
        }
    }

    private void drawButtons() {
        for (BattleButton button : buttons) {
            if (button.isTouched()) {
                paint.setColor(Color.parseColor("#FFA500"));
            } else {
                paint.setColor(Color.RED);
            }
            button.draw(canvas, paint, context);
            button.drawLabel(canvas, paint);
        }
        if (c.itemMenuOpened()) {
            itemMenu.draw(canvas, paint);
        }
    }

    private void drawLabels() {
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);

        String fighter1Text = "Fighter 1";
        String fighter2Text = "Fighter 2";

        float fighter1TextWidth = paint.measureText(fighter1Text);
        float fighter2TextWidth = paint.measureText(fighter2Text);

        float fighter1TextX = fighter1X + (fighterWidth - fighter1TextWidth) / 2;
        float fighter2TextX = fighter2X + (fighterWidth - fighter2TextWidth) / 2;
        float fighterTextY = fighterY + fighterHeight + 50;

        canvas.drawText("HP: " + c.harald.getHP(), fighter1TextX, fighterTextY, paint);
        canvas.drawText("HP: " + c.gustav.getHP(), fighter2TextX, fighterTextY, paint);
    }
}
