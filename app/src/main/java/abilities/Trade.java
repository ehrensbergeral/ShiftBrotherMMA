package abilities;

import main.Fighter;

public class Trade extends Ability {

    public Trade() {}
    public void run(Fighter actor, Fighter target) {
        actor.changeGil(2);
        target.changeHP(30);
        target.changeAttack(1);
        target.changeDefense(1);
        target.changeSpeed(1);
    }

    public String getName() {
        return "Trade";
    }

    public String getExplanation() {
        return "Trade: Erhöhe die Werte deines Gegners und erhalte 2 Gil.";
    }

    public boolean enoughGils(int gils) {
        return true;
    }

    public int getTimer() {
        return 400;
    }
}