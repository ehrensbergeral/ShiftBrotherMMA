package abilities;

import interfaces.Constants;
import main.Fighter;

public class Quick extends Ability implements Constants {

    public Quick() {}

    public String getName() {
        return "Quick (15)";
    }

    public void run(Fighter actor, Fighter target) {
      /*  if ((t.getCurrentSwitchTime() >= 11) && actor.getGil() >= 15 && t.lockIsActivated()==false) {
            actor.changeGil(-15);
            //harald.setCurrentSwitchTime(harald.getCurrentSwitchTime()-10);
            //game.b.setQuickIsActive(true);
            t.changeTime(10);
        } */
    }
    public String getExplanation() {
        return "Quick: Reduziere die Zeit bis zum nächsten Switch um 10 Sekunden\n(Es müssen mindestens 11 Sekunden verbleiben). (15 Gil)";
    }

    public boolean enoughGils(int gils) {
        // if (gils >= 15 && t.lockIsActivated() == false) {return true;} else {return false;}
        return false;
    }

    public int getTimer() {
        return 400;
    }
}
