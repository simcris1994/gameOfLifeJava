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
        panel.tenCellRow();

        add(panel, BorderLayout.CENTER);

        this.setSize(2030, 1050);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCell(int i, int j) {
        return panel.getCell(i, j);
    }
}
