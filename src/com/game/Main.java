package com.game;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    static int height = 150;
    static int width = 250;

    public static void main(String[] arg) throws InterruptedException, IOException {
        Grid grid = new Grid(height, width);

        while (true) {
            Thread.sleep(300);
            grid.move();
        }
    }
}
