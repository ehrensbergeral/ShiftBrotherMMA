package main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.sql.Array;
import java.util.ArrayList;

import items.Item;

public class  ItemMenu {
    private Rect menuRect;
    private Rect[] squareRects;

    private Context context;

    private ArrayList<Item> allItems = new ArrayList<Item>();

    public ItemMenu(Context context) {
        this.context = context;

        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        int screenHeight = context.getResources().getDisplayMetrics().heightPixels;

        int squareSize = screenHeight / 8; // Anzahl der Quadrate pro Reihe
        int squareGap = squareSize / 3; // Abstand zwischen den Quadraten
        int numSquares = 8; // Gesamtanzahl der Quadrate

        int menuWidth = squareSize * 2 + squareGap * 3;
        int menuHeight = squareSize * numSquares/2 + squareGap * numSquares/2 + squareGap;

        int menuX = screenWidth/2 - menuWidth/2;
        int menuY = screenHeight - menuHeight - (screenHeight - menuHeight)/2;

        menuRect = new Rect(menuX, menuY, menuX + menuWidth, menuY + menuHeight);
        int numRows = (numSquares + 1) / 2; // Anzahl der Reihen
        int padding = 20;

        squareRects = new Rect[numSquares];

        for (int i = 0; i < numSquares; i++) {
            int row = i / 2;
            int col = i % 2;

            int squareX = menuX + col * (squareSize + squareGap) + squareGap;
            int squareY = menuY + row * (squareSize + squareGap) + squareGap;

            squareRects[i] = new Rect(squareX, squareY, squareX + squareSize, squareY + squareSize);
        }
    }

    public void draw(Canvas canvas, Paint paint) {
        // Zeichne das Menü-Rechteck
        paint.setColor(Color.RED);
        canvas.drawRect(menuRect, paint);

        // Zeichne die Quadrate
        paint.setColor(Color.LTGRAY);
        for (Rect squareRect : squareRects) {
            canvas.drawRect(squareRect, paint);
        }
    }

    public boolean contains(int touchX, int touchY) {
        if (menuRect.contains(touchX, touchY)) {
            return true;
        }
        return false;
    }

    //-------------------------------------------------
    //Item-related methods
    //-------------------------------------------------

    public void addItem(Item item) {
        allItems.add(item);
    }
}
