package abilities;

import java.util.Random;

import interfaces.Constants;
import main.Fighter;

public class Attack extends Ability implements Constants {

    Fighter actor;
    Fighter target;
    int seconds = 1;

    public Attack() {
    }

    Random rgen = new Random();
    int n;

    public void run(Fighter actor, Fighter target) {
        int strength = actor.getAttack();
        target.setDamage(strength);
        actor.changeGil(2);
    }

    public boolean enoughGils() {
        return true;
    }

    public String getName() {
        return "Attack";
    }

    public int getTimer() {
        return 50;
    }

    public int getPrice() {
        return 0;
    }

    public String getExplanation() {
        return "Attack: Attackiere deinen Gegner und erhalte etwas Geld.";
    }
}