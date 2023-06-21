package items;

import interfaces.Constants;
import main.Fighter;

public class Lock extends Item implements Constants {

    public Lock() {}

    public String getName() {
        return "Lock (15)";
    }

    public void run(Fighter actor, Fighter target) {
       /* if (actor.getGil() >= 15 && t.lockIsActivated() == false) {
            actor.changeGil(-15);
            t.setLocked(true);
        } */
    }

    public String getExplanation() {
        return "Lock: Sperre RANDOM und QUICK bis zum nächsten Switch. (15 Gil)";
    }

    public boolean enoughGils(int gils) {
       // if (gils >= 15 && t.lockIsActivated() == false) return true;
        return false;
    }
}