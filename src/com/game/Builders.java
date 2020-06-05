package com.game;

import java.io.IOException;

public class Builders {

    public static void fromFile(Grid grid) throws IOException {
        boolean[][] cells = LifReader.read(grid.getRows(), grid.getCols());

        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.addCell(i, j, cells[i][j]);
            }
        }
    }

    public static void randomFill(Grid grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.addCell(i, j);
            }
        }
    }

    public static void glider(Grid grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {

                int refX = grid.getRows()/2 - 1;
                int refY = grid.getCols()/2 - 1;
                boolean alive = false;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j == refY+1) ||
                    (i == refX+1 && j >= refY-1 && j <= refY+1)) {
                    alive = true;
                }

                grid.addCell(i, j, alive);
            }
        }
    }

    public static void tumbler(Grid grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                int refX = grid.getRows()/2 - 1;
                int refY = grid.getCols()/2 - 1;
                boolean alive = false;
                if ((i == refX-2 && (j == refY-3 || j == refY+3)) ||
                    (i == refX-1 && (j == refY-4 || j == refY-2 || j == refY+2 || j == refY+4)) ||
                    (i == refX && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2)) ||
                    (i == refX+1 && (j == refY-3 || j == refY-2 || j == refY+2 || j == refY+3)) ||
                    (i == refX+2 && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2))) {
                    alive = true;
                }

                grid.addCell(i, j, alive);
            }
        }
    }

    public static void tenCellRow(Grid grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                int refY = grid.getCols()/2;
                boolean alive = i == grid.getRows()/2 && j > refY-5 && j < refY+6;
                grid.addCell(i, j, alive);
            }
        }
    }

    public static void smallExploder(Grid grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                int refX = grid.getRows()/2 - 1;
                int refY = grid.getCols()/2 - 1;
                boolean alive = false;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j >= refY-1 && j <= refY+1) ||
                    (i == refX+1 && (j == refY-1 || j == refY+1)) ||
                    (i == refX+2 && j == refY)) {
                    alive = true;
                }

                grid.addCell(i, j, alive);
            }
        }
    }

}
