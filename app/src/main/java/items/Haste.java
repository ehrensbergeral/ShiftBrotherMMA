package items;

import main.Fighter;

public class Haste extends Item {

    public Haste() {}

    public String getName() {
        return "Haste (10)";
    }

    public void run(Fighter actor, Fighter target) {
        if(actor.getGil() >= 10) {
            actor.changeGil(-10);
            actor.changeSpeed(2);
        }
    }

    public String getExplanation() {
        return "Haste: Erhöhe deine Geschwindigkeit (10 Gil).";
    }

    public boolean enoughGils(int gils) {
        if (gils >= 10) return true;
        return false;
    }
}