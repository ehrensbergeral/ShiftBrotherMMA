package main;

import abilities.Ability;

public class Fighter {

    private String name;
    private int hp;
    private int maxHP;
    private int defense;
    private int speed = 22 ;
    private int attack;
    private int gil = 10;
   // private Texture tex = new Texture("warrior.png");
    private String path;

    private Ability ab = new Ability();
    private boolean isLocked = false;


    public Fighter(String path, int hp, int attack, int defense, int gil) {
        this.path = path;
        this.hp = hp;
        this.maxHP = hp;
        this.defense = defense;
        this.attack = attack;
        this.gil = gil;
    }

    private boolean isHit = false;
    public boolean isHit() {
        return isHit;
    }


    public void setHit(boolean b) {
        isHit = b;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }
    public int getMaxHP() {
        return maxHP;
    }

    public void setHP(int hp) {
        if (isLocked == false) {
            this.hp = hp;
        }
    }

    public void setMaxHP(int hp) {
        if (isLocked == false) {
            this.maxHP = hp;
        }
    }

    public void changeHP(int delta) {
        if (isLocked == false) {
            if (!(hp + delta > maxHP)) {
                hp += delta;
                if (hp <= 0) {
                    hp = 0;
                    isDead = true;
                }
            }
        }
    }

    public void setGil(int gil) {
        if (gil>=0) this.gil = gil;
    }

    public void changeGil(int delta) {
        if (gil+delta>=0) gil += delta ;
    }

    public int getGil() {
        return gil;
    }

    private boolean isDead = false;
    public boolean isDead() {
        return isDead;
    }

    public void revive() {
        isDead = false;
        hp = maxHP;
    }
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (isLocked == false) {
            this.attack = attack;
        }
    }

    public void changeAttack(int delta) {
        if (isLocked == false) {
            this.attack += delta;
        }
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (isLocked == false) {
            this.defense = defense;
        }
    }

    public void changeDefense(int delta) {
        if (isLocked == false) {
            this.defense += delta;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public String getSpeedAsString() {
        if (speed < 19) {
            return Integer.toString(speed);
        } else {
            if (speed == 1) {
                return "MIN";
            }
        }
        return "MAX";
    }

    public void setSpeed(int speed) {
        if (isLocked == false) {
            this.speed = speed;
        }
    }

    public void changeSpeed(int delta) {
        if (isLocked == false) {
            this.speed += delta;
            if (speed < 1) speed = 1;
            if (speed > 19) speed = 19;
        }
    }

    private int damage;
    private int variance;
    public void setDamage(int strength) {
        int lowerLimit = -5;
        //int variance = rgen.nextInt(5);
        if (variance == 5) variance = 10;
        if (variance < -5) variance = -5;
        damage =  strength * 4 - defense * 2 - variance;
        if (damage < 0) damage = 0;
        changeHP(-damage);
        isHit = true;
    }

    public String getDamageAsString() {
        if (variance == 5) {
            return "CRITICAL!" + "\n" + damage;
        }
        return "" + damage;
    }

    public void setAbility(Ability ab) {
        this.ab = ab;
    }

    public Ability getTempAbility() {
        if (ab != null) {
            return ab;
        } else { return new Ability(); }
    }

    private boolean activeT = false;

    public void setActiveTimer(boolean b) {
        activeT = b;
    }

    public boolean timerIsActive() {
        return activeT;
    }

    private boolean abLocked = false;
    public void setABLocked(boolean b) {
        abLocked = b;
    }

    private Ability fixedAbility;
    public void setFixedAbility(Ability tempAbility) {
        fixedAbility = tempAbility;
    }

    public Ability getFixedAbility() {
        if (fixedAbility != null) return fixedAbility;
        return new Ability();
    }
}