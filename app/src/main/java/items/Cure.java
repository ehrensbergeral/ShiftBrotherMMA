package items;

import main.Fighter;

public class Cure extends Item {

    int delta;
    public Cure(int delta) {
        this.delta = delta;
    }

    public String getName() {
        return "Cure (10)";
    }

    public void run(Fighter actor, Fighter target) {

        if (actor.getGil() >= (delta/10)) {
            actor.changeHP(delta);
            actor.changeGil(-delta/10);
        }
    }

    public int getTimer() {
        return 200;
    }

    public String getExplanation() {
        return "Cure: Erhöhe deine eigenen HP um " + delta + ". (10 Gil).";
    }

    public boolean enoughGils(int gils) {
        if (gils >= (delta/10)) return true;
        return false;
    }

}
