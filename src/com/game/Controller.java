package com.game;

public class Controller {
    private Grid grid;

    public Controller(Grid grid) {
        this.grid = grid;
    }

    public void move() {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                Cell currCell = grid.getCell(i, j);
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

    private void changeState() {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                Cell currCell = grid.getCell(i, j);

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
        int endX = (i < grid.getRows() - 1) ? i + 1 : i;
        int startY = (j > 0) ? j - 1 : j;
        int endY = (j < grid.getCols() - 1) ? j + 1 : j;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (x != i || y != j) {
                    Cell currCell = grid.getCell(x, y);
                    if (currCell.isAlive()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
