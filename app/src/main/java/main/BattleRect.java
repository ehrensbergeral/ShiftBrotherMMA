package main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class BattleRect {

    private Rect rect;
    private String label;

    public BattleRect() {
        rect = new Rect();
    }

    public BattleRect(int x1, int y1, int x2, int y2) {
        rect = new Rect(x1, y1, x2, y2);
    }

    public Rect getRect() {
        return rect;
    }

    public boolean contains(int touchX, int touchY) {
        return rect.contains(touchX, touchY);
    }

    private boolean isTouched;

    public void setTouched(boolean b) {
        isTouched = b;
    }

    public boolean isTouched() {
        return isTouched;
    }

    private int startX;

    public void setStartX(float touchX) {
        startX = (int) touchX;
    }

    public float getStartX() {
        return startX;
    }

    private boolean swipeRight = false;
    private boolean swipeLeft = false;

    public void setSwipeLeft(boolean b) {
        swipeLeft = b;
        swipeRight = false;
    }

    public void setSwipeRight(boolean b) {
        swipeRight = b;
        swipeLeft = false;
    }

    public boolean isSwipeLeft() {
        return swipeLeft;
    }

    public boolean isSwipeRight() {
        return swipeRight;
    }

    // Labels and Images

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    private int textSize = 40;
    public void drawLabel(Canvas canvas, Paint paint) {
        if (label == null) label = "NO LABEL";
        paint.setColor(Color.WHITE);
        paint.setTextSize(textSize);
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
}
