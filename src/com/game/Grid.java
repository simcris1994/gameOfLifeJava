package com.game;

import java.awt.*;
import java.io.IOException;

public class Grid extends Canvas {

    int width, height, rows, cols;
    Cell[][] cells;

    Grid(int w, int h, int r, int c) throws IOException {
        setSize(width = w, height = h);
        rows = r;
        cols = c;
        cells = new Cell[rows][cols];
        Builders.fromFile(this);
    }

    @Override
    public void paint(Graphics g) {
        int htOfRow = height / rows;
        int wdOfRow = width / cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g.setColor(getCell(i, j).getColor());
                g.fillRect(j * wdOfRow, i * htOfRow, wdOfRow, htOfRow);
            }
        }
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public void addCell(int i, int j) {
        Cell cell = new Cell();
        cells[i][j] = cell;
    }

    public void addCell(int i, int j, boolean alive) {
        Cell cell = new Cell(alive);
        cells[i][j] = cell;
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
        this.paint(this.getGraphics());
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

    public void move() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell currCell = getCell(i, j);
                int aliveNeighbours = countAliveNeighbours(i, j);

                boolean aliveNext;
                if (currCell.isAlive()) {
                    if (aliveNeighbours < 2) {
                        aliveNext = false;
                    } else aliveNext = aliveNeighbours < 4;
                } else {
                    aliveNext = aliveNeighbours == 3;
                }

                currCell.setAliveNext(aliveNext);
            }
        }

        changeState();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
