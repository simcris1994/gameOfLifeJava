package com.game;

import java.awt.*;

import javax.swing.*;

public class Grid extends JFrame {

    private Panel panel;
    private int rows, cols;

    public Grid(int rows, int cols) {
        super("Is this real life?");
        this.rows = rows;
        this.cols = cols;

        panel = new Panel(rows, cols);
        Builders.tenCellRow(this);

        add(panel, BorderLayout.CENTER);

        this.setSize(2030, 1050);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addCell(int i, int j) {
        panel.addCell(i, j);
    }

    public void addCell(int i, int j, boolean alive) {
        panel.addCell(i, j, alive);
    }

    public void move() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell currCell = panel.getCell(i, j);
                int aliveNeighbours = panel.countAliveNeighbours(i, j);

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

        panel.changeState();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
