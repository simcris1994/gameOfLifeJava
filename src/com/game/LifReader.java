package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LifReader {

    public static boolean[][] read(int height, int width) throws IOException {
        Path path = Paths.get("./resources/aqua40.lif");

        BufferedReader reader = Files.newBufferedReader(path);

        String line = reader.readLine();

        boolean[][] arr = new boolean[height][width];
        int refX = width/2;
        int refY = height/2;
        int x = 0;
        int y = 0;

        while (line != null) {
            String[] tokens = line.split(" ");

            if (tokens[0].startsWith("#")) {
                if (tokens[0].startsWith("#P")) {
                    // it's coordinates
                    x = refX + Integer.parseInt(tokens[1]);
                    y = refY + Integer.parseInt(tokens[2]);
                }
            } else {
                // it's cells
                String cells = tokens[0];
                int copyX = x;
                for (int i = 0; i < cells.length(); i++) {
                    if (i != 0) {
                        copyX++;
                    }

                    char curr = cells.charAt(i);
                    if (curr == '*') {
                        // alive
                        arr[y][copyX] = true;
                    }

                    if (i == cells.length() - 1) {
                        y++;
                    }
                }
            }

            line = reader.readLine();
        }

        return arr;
    }
}
