package interfaces;

import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import abilities.Ability;
import abilities.Attack;
import abilities.Cure;
import abilities.CureEx;
import abilities.Donate;
import abilities.Harm;
import abilities.Haste;
import abilities.Lock;
import abilities.Protect;
import abilities.Quick;
import abilities.Randomize;
import abilities.Slow;
import abilities.Temper;
import abilities.Trade;
import battleUtilities.AI;
import main.Fighter;

public interface Constants {



        Fighter harald = new Fighter("warrior.png", 3000, 20, 10, 10);
        Fighter gustav = new Fighter("redwizard.png", 3000, 20, 10, 10);
        String[] battleRectLables = {"FIGHT", "ITEM", "DONATE", "CLOCK"};
        String[] fighterSprites = {"warrior.png", "redwizard.png"};
        final int P1X = 200;
        final int P2X = 1000;

        final int PY = 300;

        final int P1_WIDTH = 200;

        final int P1_HEIGHT = (int) ((double) P1_WIDTH * 1.47);
        public int FPS = 60;
        Attack att = new Attack();
        Temper tmp = new Temper();
        Cure cure1 = new Cure(150);
        Slow slow = new Slow();
        Haste haste = new Haste();
        Randomize rand = new Randomize();
        Lock lock = new Lock();
        Random rgen = new Random();

        Trade trd = new Trade();
        Donate don1 = new Donate(10);
        Donate don2 = new Donate(20);
        Protect prt = new Protect();

        CureEx curex = new CureEx();
        Quick quick = new Quick();
        Harm hrm = new Harm();

        Ability[] allAbilitiesP1 = {hrm, lock, cure1, tmp, slow, don1, quick, att, trd, curex, prt, haste, don2, rand};
        Ability[] allAbilitiesP2 = {att, trd, curex, prt, haste, don2, rand, hrm, lock, cure1, tmp, slow, don1, quick};

        Timer t = new Timer();
        AI ai = new AI();
        // Renderer renderer = new Renderer();

       // int pLabelY = P_Y + 260;
    }

