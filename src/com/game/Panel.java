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

    public void changeState() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell currCell = getCell(i, j);

                if (currCell.isAlive() != currCell.isAliveNext()) {
                    currCell.setAlive(currCell.isAliveNext());
                }
            }
        }
    }

    public int countAliveNeighbours(int i, int j) {
        int count = 0;

        int startX = (i > 0) ? i - 1 : i;
        int endX = (i < rows-1) ? i + 1 : i;
        int startY = (j > 0) ? j - 1 : j;
        int endY = (j < cols-1) ? j + 1 : j;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (x != i || y != j) {
                    if (getCell(x, y).isAlive()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
