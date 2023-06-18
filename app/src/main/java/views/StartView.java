package views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class StartView extends View {

    private Bitmap bitmap = BitmapFactory.decodeFile("C:/Users/phant/AndroidStudioProjects/ShiftBrothers/app/src/main/java/views/img.png");


    public StartView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }
}
