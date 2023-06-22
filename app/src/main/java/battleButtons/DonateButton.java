package battleButtons;

import android.content.Context;
import android.widget.Toast;

import battleButtons.BattleButton;

public class DonateButton extends BattleButton {

    private Context context;

    public DonateButton(int x1, int y1, int x2, int y2, Context context) {
        super(x1, y1, x2, y2, context);
        this.context = context;
        setLabel("Donate");
    }

    @Override
    public void runActionDown(float touchX, float touchY) {
        setTouched(true);
    }

    @Override
    public void runActionMove(float touchX, float touchY) {

    }

    @Override
    public void runActionUp(float touchX, float touchY) {
        setTouched(false);
        super.runActionUp(touchX, touchY);
        if (isSwipeLeft()) {
            // Aktion bei Wischen nach links im DonateButton
            Toast.makeText(context, "DonateButton wurde nach links gewischt!", Toast.LENGTH_SHORT).show();
        } else if (isSwipeRight()) {
            // Aktion bei Wischen nach rechts im DonateButton
            Toast.makeText(context, "DonateButton wurde nach rechts gewischt!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void rectSwipedLeft() {
    }

    @Override
    protected void rectSwipedRight() {
    }
}