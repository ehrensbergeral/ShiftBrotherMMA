package battleButtons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import interfaces.Constants;
import main.Fighter;

public abstract class BattleButton implements Constants {

    private Rect rect;
    private String label;

    private Context context;

    private boolean isTouched;
    private float startX;
    private boolean swipeRight;
    private boolean swipeLeft;
    private boolean itemMenuOpened;
    private boolean itemSelected;
    private Fighter fighter;
    private int swipeTolerance;

    public BattleButton(int x1, int y1, int x2, int y2, Context context) {
        this.context = context;
        rect = new Rect(x1, y1, x2, y2);
        isTouched = false;
        swipeRight = false;
        swipeLeft = false;
        itemMenuOpened = false;
        itemSelected = false;
        swipeTolerance = 200;
    }

    public Rect getRect() {
        return rect;
    }

    public boolean contains(int touchX, int touchY) {
        return rect.contains(touchX, touchY);
    }

    public void setTouched(boolean b) {
        isTouched = b;
    }

    public boolean isTouched() {
        return isTouched;
    }

    public void setStartX(float touchX) {
        startX = touchX;
    }

    public float getStartX() {
        return startX;
    }

    public void setSwipeLeft(boolean b) {
        swipeLeft = b;
    }

    public void setSwipeRight(boolean b) {
        swipeRight = b;
    }

    public boolean isSwipeLeft() {
        return swipeLeft;
    }

    public boolean isSwipeRight() {
        return swipeRight;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void drawLabel(Canvas canvas, Paint paint) {
        if (label == null) label = "NO LABEL";
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        float textX = rect.left + rect.width() * 1 / 2;
        float textY = rect.top + rect.height() * 1 / 2;
        canvas.drawText(label, textX, textY, paint);
    }

    public void draw(Canvas canvas, Paint paint, Context context) {
        canvas.drawRect(rect, paint);
        drawLabel(canvas, paint);
        drawIcon(canvas, paint, context);
    }

    private void drawIcon(Canvas canvas, Paint paint, Context context) {
        float iconX = rect.left + rect.width() * 1 / 10;
        float iconY = rect.top + rect.height() * 1 / 10;
        try {
            InputStream isP1 = context.getAssets().open("sword-icon-1.png");
            Bitmap bitmapP1 = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(isP1), 60, 60, false);
            canvas.drawBitmap(bitmapP1, iconX, iconY, null);
        } catch (IOException e) {
            Log.e("GraphicsActivity", e.getMessage());
        }
    }

    public void runActionUp(float touchX, float touchY) {
    }

    protected void rectSwipedLeft() {
    }

    protected void rectSwipedRight() {
    }

    public void runActionDown(float touchX, float touchY) {
    }

    public void runActionMove(float touchX, float touchY) {
    }
}
