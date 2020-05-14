package com.game;

import javax.swing.*;

public class Controller {
    private int height, width;
    private JLabel[][] label;

    public Controller(int height, int width, JLabel[][] label) {
        this.height = height;
        this.width = width;
        this.label = label;
    }

    public void move() {
        int[][] copy = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int aliveNeighbours = countAliveNeighbours(i, j);
                boolean isAlive = isAlive(i, j);

                if (isAlive) {
                    if (aliveNeighbours < 2) {
                        copy[i][j] = 0;
                    } else if (aliveNeighbours < 4) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        copy[i][j] = 1;
                    }
                }
            }
        }

        fillCopy(copy);
    }

    private void fillCopy(int[][] copy) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean shouldLive = copy[i][j] == 1;

                if (isAlive(i, j) != shouldLive) {
                    label[i][j].setBackground(Builder.colors.get(copy[i][j]));
                }
            }
        }
    }

    private boolean isAlive(int i, int j) {
        return Builder.colors.indexOf(label[i][j].getBackground()) == 1;
    }

    private int countAliveNeighbours(int i, int j) {
        int count = 0;

        int startX = (i > 0) ? i - 1 : i;
        int endX = (i < height - 1) ? i + 1 : i;
        int startY = (j > 0) ? j - 1 : j;
        int endY = (j < width - 1) ? j + 1 : j;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (x != i || y != j) {
                    if (isAlive(x, y)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
