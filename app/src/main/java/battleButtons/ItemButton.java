package battleButtons;

import android.content.Context;
import android.widget.Toast;

import battleButtons.BattleButton;
import items.Item;

public class ItemButton extends BattleButton {

    private Context context;

    public ItemButton(int x1, int y1, int x2, int y2, Context context) {
        super(x1, y1, x2, y2, context);
        this.context = context;
        setLabel("Item");
    }

    @Override
    public void runActionDown(float touchX, float touchY) {
        setTouched(true);
        c.openItemMenu(true);
    }

    private void openItemMenu() {
    }

    private Item item;
    private boolean itemSelected = false;
    @Override
    public void runActionMove(float touchX, float touchY) {
        if (itemSelected == true) {
            enableSwiping();
        }
    }

    private void enableSwiping() {
    }

    @Override
    public void runActionUp(float touchX, float touchY) {
        setTouched(false);
        super.runActionUp(touchX, touchY);
        if (isSwipeLeft()) {
            //item.run()
            Toast.makeText(context, "FightButton wurde nach links gewischt!", Toast.LENGTH_SHORT).show();
        } else if (isSwipeRight()) {
            // Aktion bei Wischen nach rechts im FightButton
            Toast.makeText(context, "FightButton wurde nach rechts gewischt!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void rectSwipedLeft() {
    }

    @Override
    protected void rectSwipedRight() {
    }
}
