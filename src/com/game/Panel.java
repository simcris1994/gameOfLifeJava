package com.game;

import java.awt.*;

import javax.swing.*;

public class Panel extends JPanel {
    private Cell[][] cells;
    int rows, cols;

    public Panel(int rows, int cols) {
        super(new GridLayout(rows, cols));
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public void addCell(int i, int j) {
        Cell newCell = new Cell();
        cells[i][j] = newCell;
        this.add(newCell);
    }

    public void addCell(int i, int j, boolean alive) {
        Cell newCell = new Cell(alive);
        cells[i][j] = newCell;
        this.add(newCell);
    }

    public void randomFill() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                addCell(i, j);
            }
        }
    }

    public void glider() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int refX = rows/2 - 1;
                int refY = cols/2 - 1;
                boolean alive = false;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j == refY+1) ||
                    (i == refX+1 && j >= refY-1 && j <= refY+1)) {
                    alive = true;
                }

                addCell(i, j, alive);
            }
        }
    }

    public void tumbler() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int refX = rows/2 - 1;
                int refY = cols/2 - 1;
                boolean alive = false;
                if ((i == refX-2 && (j == refY-3 || j == refY+3)) ||
                    (i == refX-1 && (j == refY-4 || j == refY-2 || j == refY+2 || j == refY+4)) ||
                    (i == refX && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2)) ||
                    (i == refX+1 && (j == refY-3 || j == refY-2 || j == refY+2 || j == refY+3)) ||
                    (i == refX+2 && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2))) {
                    alive = true;
                }

                addCell(i, j, alive);
            }
        }
    }

    public void tenCellRow() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int refY = cols/2;
                boolean alive = i == rows/2 && j > refY-5 && j < refY+6;
                addCell(i, j, alive);
            }
        }
    }

    public void smallExploder() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int refX = rows/2 - 1;
                int refY = cols/2 - 1;
                boolean alive = false;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j >= refY-1 && j <= refY+1) ||
                    (i == refX+1 && (j == refY-1 || j == refY+1)) ||
                    (i == refX+2 && j == refY)) {
                    alive = true;
                }

                addCell(i, j, alive);
            }
        }
    }
}
