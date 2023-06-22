package items;

import main.Fighter;

public class Item {

    private String name;

    public Item() {}

    public void run(Fighter actor, Fighter target) {}

    public int getTimer() {
        return 200;
    }

    public String getName() {
        return "Ability";
    }

    public String getExplanation() {
        return "Select a Ability";
    }

    public int getPrice() {
        return 0;
    }

    public boolean enoughGils(int gils) {
        return true;
    }
}