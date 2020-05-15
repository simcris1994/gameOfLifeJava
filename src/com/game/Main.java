package com.game;

import javax.swing.*;

public class Main extends JFrame {

    static int height = 100;
    static int width = 200;

    public static void main(String[] arg) throws InterruptedException {
        Grid grid = new Grid(height, width);
        Controller controller = new Controller(grid);

        while (true) {
            Thread.sleep(300);
            controller.move();
        }
    }
}
