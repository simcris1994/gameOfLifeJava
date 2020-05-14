package com.game;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class Builder {
    static List<Color> colors = Arrays.asList(Color.BLACK, Color.GREEN);

    private JPanel panel;
    private JLabel[][] label;
    private int height, width;

    public Builder(JPanel panel, JLabel[][] label, int height, int width) {
        this.panel = panel;
        this.label = label;
        this.height = height;
        this.width = width;
    }

    public void randomFill() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);
                label[i][j].setBackground(randomColor());

                panel.add(label[i][j]);
            }
        }
    }

    public void glider() {
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

    public void tumbler() {
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

    public void tenCellRow() {
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

    public void smallExploder() {
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

    private static Color randomColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

        return colors.get(randomNum);
    }
}
