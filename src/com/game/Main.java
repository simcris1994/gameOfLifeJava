package com.game;

import java.awt.*;
import java.io.IOException;

public class Main extends Frame {

    static Grid grid;

    Main(String title, int w, int h, int rows, int columns) throws IOException {
        setTitle(title);
        grid = new Grid(w, h, rows, columns);
        add(grid);
        setSize(w, h);
        setResizable(false);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Main("The Game Of Life", 1750, 900, 150, 250).setVisible(true);

        while (true) {
            Thread.sleep(150);
            grid.move();
        }
    }
}