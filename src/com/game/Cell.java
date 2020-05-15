package com.game;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class Cell extends JLabel {
    private static Color DEAD = Color.BLACK;
    private static Color ALIVE = Color.GREEN;

    private boolean alive, aliveNext;

    public Cell(boolean alive) {
        this.alive = alive;
        this.aliveNext = false;
        this.setOpaque(true);
        setColor(alive);
    }

    public Cell() {
        this.alive = randomState();
        this.aliveNext = false;
        this.setOpaque(true);
        setColor(alive);
    }

    private boolean randomState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

        return randomNum == 1;
    }

    private void setColor(boolean alive) {
        this.setBackground(alive ? ALIVE : DEAD);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        setColor(alive);
    }

    public boolean isAliveNext() {
        return aliveNext;
    }

    public void setAliveNext(boolean aliveNext) {
        this.aliveNext = aliveNext;
    }
}
