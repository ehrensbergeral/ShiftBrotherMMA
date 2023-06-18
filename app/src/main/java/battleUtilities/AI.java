package battleUtilities;

import abilities.Ability;
import interfaces.Constants;
import main.Fighter;

public class AI implements Constants {

    private int action;

    public AI() {
    }

    public void setActionRate(int probability) {
        action = 100 - probability;
    }

    private int det;

    public boolean isActive() {
        rint = rgen.nextInt(100);
        if (rint > action) {
            return true;
        } return false;
    }

    private int rint;

    public Ability getNextAbility(Fighter player, Fighter enemy) {
        det = rgen.nextInt(100);
        if ((enemy.getHP() < 300)) {
            if (enemy.getGil() > 10) {
                return cure1;
            } else {
                if (enemy.getGil() >= 6) {
                    return prt;
                } else {
                    return att;
                }
            }
        }
        if (player.getHP() < 500 && enemy.getHP() > 500) {
            if (det > 40) {
                return att;
            } else {
                return tmp;
            }
        }
        /*if ((t.getSeconds() < 5) && (enemy.getGil() > 10)) {
            if (enemy.getGil() > 20) {
                return don2;
            } else {
                return don1;
            }
        }*/
        if (player.getDefense() > enemy.getDefense() + 6 && enemy.getGil() >= 5) return prt;
        if (player.getAttack() > enemy.getAttack() + 6 && enemy.getGil() >= 5) return tmp;
        if (player.getSpeed() >= enemy.getSpeed() + 6 && enemy.getGil() >= 5) return haste;
        if (enemy.getHP() > 2000) {
            if (det > 70) {
                return hrm;
            } else {
                if (det > 50 && enemy.getGil()>=5) {
                    return tmp;
                } else {
                    if (det > 30 && enemy.getGil()>=10) {
                        return haste;
                    } else {
                            if (enemy.getGil() >= 10) {
                                return slow;
                            } else {
                                if (enemy.getGil() >= 5) {
                                    return prt;
                                } else {
                                    return hrm;
                                }
                            }
                    }
                }
            }
        }
        if (enemy.getHP() > 1000) {
            if (det > 70) {
                return hrm;
            } else {
                if (det > 50) {
                    return att;
                } else {
                    if (det > 20 && enemy.getGil()>=20) {
                        return rand;
                    } else {
                            if (enemy.getGil() > 10) {
                                return curex;
                            } else {
                                if (enemy.getGil() > 10) {
                                    return tmp;
                                } else {
                                    return trd;
                                }
                            }
                    }
                }
            }
        }
        if (enemy.getHP() < 1000) {
            if (det > 70) {
                return att;
            } else {
                if (det > 40 && enemy.getGil()>=5) {
                    return prt;
                } else {
                    if (det > 20 && enemy.getGil()>=10) {
                        return cure1;
                    } else {
                            if (enemy.getGil() > 10) {
                                return curex;
                            } else {
                                if (det > 10) {
                                    return trd;
                                } else {
                                    return att;
                                }
                            }
                    }
                }
            }
        }
        if (enemy.getGil() > 20) {
            return rand;
        } else {
            return trd;
        }
    }
}