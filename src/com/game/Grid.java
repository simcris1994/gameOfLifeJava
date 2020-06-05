package com.game;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class Grid extends JFrame {

    private Panel panel;
    private int rows, cols;

    public Grid(int rows, int cols) throws IOException {
        super("Is this real life?");
        this.rows = rows;
        this.cols = cols;

        panel = new Panel(rows, cols);
        Builders.fromFile(this);

        add(panel, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(2500, 1000));
        this.setResizable(true);
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
