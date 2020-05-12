package com.game;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class Grid extends JFrame {

    static JLabel[][] label;
    static int height = 100;
    static int width = 200;
    static List<Color> colors = Arrays.asList(Color.BLACK, Color.GREEN);

    public static void main(String[] arg) throws InterruptedException {
        Grid grid = new Grid();
        grid.setSize(2030, 1050);
        grid.setResizable(false);
        grid.setVisible(true);
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Thread.sleep(5000);
        while (true) {
            Thread.sleep(300);
            grid.move();
        }
    }

    public Grid() {
        super("Is this real life?");

        JPanel panel = new JPanel(new GridLayout(height, width));
        label = new JLabel[height][width];

        tumbler(panel);

        add(panel, BorderLayout.CENTER);
    }

    private void randomFill(JPanel panel) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);
                label[i][j].setBackground(randomColor());

                panel.add(label[i][j]);
            }
        }
    }

    private void glider(JPanel panel) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);

                int refX = height/2 - 1;
                int refY = width/2 - 1;
                int index = 0;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j == refY+1) ||
                    (i == refX+1 && j >= refY-1 && j <= refY+1)) {
                    index = 1;
                }

                label[i][j].setBackground(colors.get(index));

                panel.add(label[i][j]);
            }
        }
    }

    private void tumbler(JPanel panel) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);

                int refX = height/2 - 1;
                int refY = width/2 - 1;
                int index = 0;
                if ((i == refX-2 && (j == refY-3 || j == refY+3)) ||
                    (i == refX-1 && (j == refY-4 || j == refY-2 || j == refY+2 || j == refY+4)) ||
                    (i == refX && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2)) ||
                    (i == refX+1 && (j == refY-3 || j == refY-2 || j == refY+2 || j == refY+3)) ||
                    (i == refX+2 && (j == refY-2 || j == refY-1 || j == refY+1 || j == refY+2))) {
                    index = 1;
                }

                label[i][j].setBackground(colors.get(index));

                panel.add(label[i][j]);
            }
        }
    }

    private void tenCellRow(JPanel panel) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);

                int refY = width/2;
                int index = (i == height/2 && j > refY-5 && j < refY+6) ? 1 : 0;
                label[i][j].setBackground(colors.get(index));

                panel.add(label[i][j]);
            }
        }
    }

    private void smallExploder(JPanel panel) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);

                int refX = height/2 - 1;
                int refY = width/2 - 1;
                int index = 0;
                if ((i == refX-1 && j == refY) ||
                    (i == refX && j >= refY-1 && j <= refY+1) ||
                    (i == refX+1 && (j == refY-1 || j == refY+1)) ||
                    (i == refX+2 && j == refY)) {
                    index = 1;
                }

                label[i][j].setBackground(colors.get(index));

                panel.add(label[i][j]);
            }
        }
    }

    private void move() {
        int[][] copy = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int aliveNeighbours = countAliveNeighbours(i, j);
                boolean isAlive = isAlive(i, j);

                if (isAlive) {
                    if (aliveNeighbours < 2) {
                        copy[i][j] = 0;
                    } else if (aliveNeighbours < 4) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        copy[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean shouldLive = copy[i][j] == 1;

                if (isAlive(i, j) != shouldLive) {
                    label[i][j].setBackground(colors.get(copy[i][j]));
                }
            }
        }
    }

    private Color randomColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

        return colors.get(randomNum);
    }

    private static boolean isAlive(int i, int j) {
        return colors.indexOf(label[i][j].getBackground()) == 1;
    }

    private static int countAliveNeighbours(int i, int j) {
        int count = 0;

        int startX = (i > 0) ? i - 1 : i;
        int endX = (i < height - 1) ? i + 1 : i;
        int startY = (j > 0) ? j - 1 : j;
        int endY = (j < width - 1) ? j + 1 : j;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (x != i || y != j) {
                    if (isAlive(x, y)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
