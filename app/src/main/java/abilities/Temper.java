package abilities;

import main.Fighter;

public class Temper extends Ability {

    public Temper() {}

    public String getName() {
        return "Temper (5)";
    }

    public void run(Fighter actor, Fighter target) {
        if (actor.getGil() >= 5) {
            actor.changeAttack(3);
            actor.changeGil(-5);
        }
    }

    public int getPrice() {
        return 5;
    }

    public String getExplanation() {
        return "Temper: Erhöhe Angriffsstärke. (5 Gil)";
    }

    public boolean enoughGils(int gils) {
        if (gils >= 5) return true;
        return false;
    }

    public int getTimer() {
        return 200;
    }
}