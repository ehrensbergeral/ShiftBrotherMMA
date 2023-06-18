package battleUtilities;

import interfaces.Constants;

public class Timer implements Constants {

    private int maxTime;
    public Timer() { }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    private int seconds;
    private boolean useFPS = false;
    private boolean timeOver = false;
    //private KLabel timeLabel = new KLabel();
    private int frame = 0;
    public void useCurrentFPS(boolean b) {
        useFPS = b;
    }

    public boolean timeIsOver() {
        return timeOver;
    }
    private boolean gameHasStarted = true;

    public void setTimeOver(boolean b) {
        timeOver = b;
    }

    public int getSeconds() {
        return seconds;
    }

   /* public void drawTimer(SpriteBatch batch) {
        frame++;
        // seconds = harald.getSwitchTime() - frame/30;
        if (gameHasStarted == true) {
            seconds = maxTime;
        } else {
            seconds =  getCurrentSwitchTime();
        }
        timeLabel = new KLabel("" + seconds);
        if (timeIsRandom()==false) {
            timeLabel.drawLabel("" + seconds, Gdx.graphics.getWidth()/2, CLOCK_Y, batch); }
        else {
            timeLabel.drawLabel("?", Gdx.graphics.getWidth()/2, CLOCK_Y, batch);
        }
        if (frame%FPS == 0) {
            if (gameHasStarted == true) { gameHasStarted = false; }
            setCurrentSwitchTime(maxTime - frame/FPS);
        }
        if (seconds < 0) {
            timeOver = true;
            frame = 0;
            setCurrentSwitchTime(maxTime);
        }
    } */

    public void changeTime(int time) {
        frame = frame + time * FPS;
    }

    boolean isStatic = false;
    public void setStatic(boolean b) {
        isStatic = b;
    }

    //------------Random Time

    boolean randomTime = false;
    public void setRandomTime(boolean b) {
        randomTime = b;
    }
    public boolean timeIsRandom() {
        return randomTime;
    }

    public void setTime(int n) {
        frame = n * FPS;
    }

    private int curTimer;
    private int timer;
    public void setCurrentSwitchTime(int i) {
        if (quickIsActive) {curTimer = i - 10; } else {
            curTimer = i;
        }
    }

    public int getCurrentSwitchTime() {
        return curTimer;
    }
    public void setSwitchTime(int i) {
        if (lockActivated == false)
            timer = i;
        if (timer < 3) timer = 3;
    }

    //--------LOCK-------

    boolean lockActivated = false;
    public void setLocked(boolean b) {
        lockActivated = b;
    }

    public boolean lockIsActivated() {
        return lockActivated;
    }

    //-------QUICK--------

    boolean quickIsActive = false;

    public void setQuickIsActive(boolean b) {
        quickIsActive = b;
    }


    //--------RANDOM------


    //---------SET MAX TIME-------

    public int getMaxTime() {
        return maxTime;
    }
}
