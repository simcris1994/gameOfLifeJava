package com.game;

public class Controller {
    private int height, width;
    private Cell[][] cells;

    public Controller(int height, int width, Cell[][] cells) {
        this.height = height;
        this.width = width;
        this.cells = cells;
    }

    public void move() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell currCell = cells[i][j];
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

        moveToNextState();
    }

    private void moveToNextState() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell currCell = cells[i][j];

                if (currCell.isAlive() != currCell.isAliveNext()) {
                    currCell.setAlive(currCell.isAliveNext());
                }
                currCell.setAliveNext(false);
            }
        }
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
                    if (cells[x][y].isAlive()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
