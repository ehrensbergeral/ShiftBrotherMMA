package abilities;

import interfaces.Constants;
import main.Fighter;

public class Randomize extends Ability implements Constants {

    public Randomize() {}

    public String getName() {
        return "Random (20)";
    }

    public void run(Fighter actor, Fighter target) {
      /*  if (t.lockIsActivated() == false && actor.getGil() >= 20) {
            actor.changeGil(-20);
            int n = rgen.nextInt(1,33);
            t.setTime(n);
            t.setRandomTime(true);
        } */
    }

    public String getExplanation() {
        return "Random: Der nächste Switch geschieht komplett zufällig. (20 Gil)";
    }

    public boolean enoughGils(int gils) {
        //if (gils >= 20 && t.lockIsActivated() == false) return true;
        return false;
    }

    public int getTimer() {
        return 500;
    }

    //------------

    public void setSwitchTime(int time) {

    }

    public void setRandomTime(boolean b) {
        isRandom = b;
    }

    private boolean isRandom = false;
    public boolean timeIsRandom() {
        return isRandom;
    }

}
