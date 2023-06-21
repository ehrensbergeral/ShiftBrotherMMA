package battleUtilities;

import main.Fighter;

public class Core {

    public Fighter harald = new Fighter("warrior.png", 2000, 20, 10, 10);
    public Fighter gustav = new Fighter("redwizard.png", 2000, 20, 10, 10);

    private boolean itemMenuOpened = false;

    public boolean itemMenuOpened() {
        return itemMenuOpened;
    }

    public void openItemMenu(boolean b) {
        itemMenuOpened = b;
    }


}
