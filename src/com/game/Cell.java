package com.game;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private static Color DEAD = Color.BLACK;
    private static Color ALIVE = Color.GREEN;

    private boolean alive, aliveNext;

    public Cell(boolean alive) {
        this.alive = alive;
        this.aliveNext = false;
    }

    public Cell() {
        this.alive = randomState();
        this.aliveNext = false;
    }

    private boolean randomState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

        return randomNum == 1;
    }

    public Color getColor() {
        return alive ? ALIVE : DEAD;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAliveNext() {
        return aliveNext;
    }

    public void setAliveNext(boolean aliveNext) {
        this.aliveNext = aliveNext;
    }
}
