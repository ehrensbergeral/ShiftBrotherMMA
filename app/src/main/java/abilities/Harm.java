package abilities;

import java.util.Random;

import main.Fighter;

public class Harm extends Ability {

    public Harm() {
    }

    java.util.Random rgen = new Random();

    public void run(Fighter actor, Fighter target) {
        int strength = actor.getAttack();
        actor.changeGil(1);
        actor.setDamage(strength/2);
    }

    public boolean enoughGils() {
        return true;
    }

    public String getName() {
        return "Harm";
    }

    public int getTimer() {
        return 50;
    }

    public int getPrice() {
        return 0;
    }

    public String getExplanation() {
        return "Harm: Verletze dich selbst (geringerer Schaden).";
    }
}