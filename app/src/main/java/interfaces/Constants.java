package interfaces;

import java.util.Random;
import java.util.Timer;

import battleUtilities.Core;
import items.Item;
import items.Attack;
import items.Cure;
import items.CureEx;
import items.Donate;
import items.Harm;
import items.Haste;
import items.Lock;
import items.Protect;
import items.Quick;
import items.Randomize;
import items.Slow;
import items.Temper;
import items.Trade;
import battleUtilities.AI;
import main.Fighter;
import main.Main;

public interface Constants {


        Core c = new Core();

        Main main = new Main();

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

        Item[] allAbilitiesP1 = {hrm, lock, cure1, tmp, slow, don1, quick, att, trd, curex, prt, haste, don2, rand};
        Item[] allAbilitiesP2 = {att, trd, curex, prt, haste, don2, rand, hrm, lock, cure1, tmp, slow, don1, quick};

        Timer t = new Timer();
        AI ai = new AI();
        // Renderer renderer = new Renderer();

       // int pLabelY = P_Y + 260;
    }

