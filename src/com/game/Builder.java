package com.game;

import javax.swing.*;

public class Builder {
    private JPanel panel;
    private Cell[][] cells;
    private int height, width;

    public Builder(JPanel panel, Cell[][] cells, int height, int width) {
        this.panel = panel;
        this.cells = cells;
        this.height = height;
        this.width = width;
    }

    public void randomFill() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell();

                panel.add(cells[i][j]);
            }
        }
    }

    public void glider() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int refX = height/2 - 1;
                int refY = width/2 - 1;
                boolean alive = false;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j == refY+1) ||
                    (i == refX+1 && j >= refY-1 && j <= refY+1)) {
                    alive = true;
                }

                cells[i][j] = new Cell(alive);
                panel.add(cells[i][j]);
            }
        }
    }

    public void tumbler() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int refX = height/2 - 1;
                int refY = width/2 - 1;
                boolean alive = false;
                if ((i == refX-2 && (j == refY-3 || j == refY+3)) ||
                    (i == refX-1 && (j == refY-4 || j == refY-2 || j == refY+2 || j == refY+4)) ||
                    (i == refX && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2)) ||
                    (i == refX+1 && (j == refY-3 || j == refY-2 || j == refY+2 || j == refY+3)) ||
                    (i == refX+2 && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2))) {
                    alive = true;
                }

                cells[i][j] = new Cell(alive);
                panel.add(cells[i][j]);
            }
        }
    }

    public void tenCellRow() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int refY = width/2;
                boolean alive = i == height/2 && j > refY-5 && j < refY+6;
                cells[i][j] = new Cell(alive);
                panel.add(cells[i][j]);
            }
        }
    }

    public void smallExploder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int refX = height/2 - 1;
                int refY = width/2 - 1;
                boolean alive = false;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j >= refY-1 && j <= refY+1) ||
                    (i == refX+1 && (j == refY-1 || j == refY+1)) ||
                    (i == refX+2 && j == refY)) {
                    alive = true;
                }

                cells[i][j] = new Cell(alive);
                panel.add(cells[i][j]);
            }
        }
    }
}
