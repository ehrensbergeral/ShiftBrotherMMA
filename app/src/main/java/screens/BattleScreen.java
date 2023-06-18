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
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import interfaces.Constants;
import main.BattleRect;


public class BattleScreen extends View implements Constants {

    private Context context;
    private BattleRect[] rects;
    private Paint paint;
    private int bWidth = 250;
    private int bHeight = 100;
    private int bx, bDistance, b1y;

    private int[] px = new int[2];
    private int p1x, p2x, py, p1Width, p1Height;
    private int width, height;


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

        rects = new BattleRect[4];
        bDistance = 50;
        b1y = 250;
    }

    private void drawFighters(Canvas canvas) {
        try {
            for (int i=0; i<2; i++) {
                InputStream isP = context.getAssets().open(fighterSprites[i]);
                Bitmap bitmapP = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(isP), p1Width, p1Height, false);
                canvas.drawBitmap(bitmapP, px[i], py, null);
            }
        } catch (IOException e) {
            Log.e("GraphicsActivity", e.getMessage());
        }
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        bx = getWidth() / 2 - bWidth / 2;

        for (int i = 0; i < rects.length; i++) {
            rects[i] = new BattleRect(bx, b1y + i * (bHeight + bDistance), bx + bWidth, b1y + i * (bHeight + bDistance) + bHeight);
            rects[i].setLabel(battleRectLables[i]);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#000033"));
        drawFighters(canvas);
        drawLabels(canvas);

        for (int i = 0; i < rects.length; i++) {
            if (rects[i].isTouched()) {
                paint.setColor(Color.parseColor("#FFA500"));
            } else {
                paint.setColor(Color.RED);
            }
            rects[i].draw(canvas, paint, context);
            rects[i].drawLabel(canvas, paint);
        }
    }

    private void drawLabels(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);

        String fighter1Text = "Fighter 1";
        String fighter2Text = "Fighter 2";

        float fighter1TextWidth = paint.measureText(fighter1Text);
        float fighter2TextWidth = paint.measureText(fighter2Text);

        float fighter1TextX = p1x + (p1Width - fighter1TextWidth) / 2;
        float fighter2TextX = p2x + (p1Width - fighter2TextWidth) / 2;
        float fighterTextY = py + p1Height + 50;

        canvas.drawText("HP: " + harald.getHP(), fighter1TextX, fighterTextY, paint);
        canvas.drawText("HP: " + gustav.getHP(), fighter2TextX, fighterTextY, paint);
    }

    private float startX;
    private boolean swipeLeft;
    private int swipeTolerance = 200;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i < rects.length; i++) {
                    if (rects[i].contains((int) touchX, (int) touchY)) {
                        rects[i].setTouched(true);
                        rects[i].setStartX(touchX); // Speichern Sie den Startpunkt des Wischens
                    }
                }
                invalidate(); // Aktualisieren der View, um die Änderungen anzuzeigen
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < rects.length; i++) {
                    if (rects[i].isTouched()) {
                        if (touchX < (rects[i].getStartX()-swipeTolerance)) {
                            rects[i].setSwipeLeft(true);
                        } else {
                            if (touchX > (rects[i].getStartX()+swipeTolerance)) {
                                rects[i].setSwipeRight(true);
                            }
                        }
                    }
                }
                invalidate(); // Aktualisieren der View, um die Änderungen anzuzeigen
                break;
            case MotionEvent.ACTION_UP:
                for (int i = 0; i < rects.length; i++) {
                    rects[i].setTouched(false);
                    if (rects[i].isSwipeLeft()) {
                        rectSwipedLeft(i); // Aufruf der Methode für das Wischen nach links
                    } else {
                        if (rects[i].isSwipeRight()) {
                            rectSwipedRight(i); // Aufruf der Methode für das Wischen nach rechts
                        }
                    }
                    rects[i].setSwipeLeft(false); // Zurücksetzen der Swipe-Richtung
                    rects[i].setSwipeRight(false); // Zurücksetzen der Swipe-Richtung
                }
                invalidate(); // Aktualisieren der View, um die Änderungen anzuzeigen
                break;
        }

        return true;
    }


    private void rectangleClicked(int index) {
        Toast.makeText(getContext(), "Rechteck " + index + " wurde geklickt!", Toast.LENGTH_SHORT).show();
    }



    //---------------------------------------------------------
    //---------------------------------------------------------
    //---------------------------------------------------------

    private void calculatePositions() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        px[0] = width / 10;
        px[1] = width - (width / 10 - p1Width);
        p1x = width / 10;
        p1Width = width / 10;
        p1Height = (int) ((double) p1Width * 1.47);
        p2x = width - (width / 10 + p1Width);
        py = height / 3;
    }

    private void rectSwipedLeft(int index) {
        // Methode für das Wischen nach links
        harald.changeHP(-100);
        Toast.makeText(getContext(), "Rechteck " + index + " wurde nach links gewischt!", Toast.LENGTH_SHORT).show();
    }

    private void rectSwipedRight(int index) {
        // Methode für das Wischen nach rechts
        gustav.changeHP(-100);
        Toast.makeText(getContext(), "Rechteck " + index + " wurde nach rechts gewischt!", Toast.LENGTH_SHORT).show();
    }

}