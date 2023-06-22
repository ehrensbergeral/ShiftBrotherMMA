package battleButtons;

import android.content.Context;
import android.widget.Toast;

import battleButtons.BattleButton;
import screens.BattleScreen;

public class FightButton extends BattleButton {

    private Context context;

    public FightButton(int x1, int y1, int x2, int y2, Context context) {
        super(x1, y1, x2, y2, context);
        this.context = context;
        setLabel("Fight");
    }

    @Override
    public void runActionDown(float touchX, float touchY) {
        setTouched(true);
        setStartX(touchX);
    }

    private int swipeTolerance = 200;
    @Override
    public void runActionMove(float touchX, float touchY) {
        if (isTouched()) {
            if (touchX < getStartX() - swipeTolerance) {
                setSwipeLeft(true);
                setSwipeRight(false);
            } else if (touchX > getStartX() + swipeTolerance) {
                setSwipeRight(true);
                setSwipeLeft(false);
            } else {
                setSwipeLeft(false);
                setSwipeRight(false);
            }
        }
    }

    @Override
    public void runActionUp(float touchX, float touchY) {
        if (isSwipeLeft()) {
            rectSwipedLeft();
            setSwipeLeft(false);
        } else {
            if (isSwipeRight()) {
                rectSwipedRight();
                setSwipeRight(false);
            }
        }
        setTouched(false);
    }

    @Override
    protected void rectSwipedRight() {
        c.gustav.changeHP(-100);

    }

    @Override
    protected void rectSwipedLeft() {
        c.harald.changeHP(-100);
    }
}
