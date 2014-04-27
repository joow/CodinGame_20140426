package org.joow.codingame.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    private static final char GAP_CHARACTER = '0';

    private static final int NB_ROADS = 4;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int nbMotos = scanner.nextInt();
        final int nbMotosToSurvive = scanner.nextInt();
        final List<String> roads = new ArrayList<String>(NB_ROADS);

        for (int i = 0; i < NB_ROADS; i++) {
            roads.add(scanner.next());
        }

        int maxGapLength = 0;
        for (final String road : roads) {
            maxGapLength = Math.max(maxGapLength, getMaxGapLengthForRoad(road));
        }

        while (true) {
            final int speed = scanner.nextInt();
            boolean gapComing = false;

            for (int i = 0; i < nbMotos; i++) {
                final int x = scanner.nextInt();
                final int y = scanner.nextInt();
                final boolean active = scanner.nextInt() == 0;

                if (active && roads.get(y).charAt(x + 1) == GAP_CHARACTER) {
                    gapComing = true;
                }
            }

            if (gapComing) {
                System.out.println("JUMP");
            } else if (speed < maxGapLength + 1) {
                System.out.println("SPEED");
            }
        }
    }

    private static int getMaxGapLengthForRoad(final String road) {
        boolean isGap = false;
        int maxGapLength = 0;
        int currentGapLength = 0;

        for (int i = 0; i < road.length(); i++) {
            if (road.charAt(i) == GAP_CHARACTER) {
                if (!isGap) {
                    isGap = true;
                }
                currentGapLength++;
            } else {
                if (isGap) {
                    maxGapLength = Math.max(maxGapLength, currentGapLength);
                    isGap = false;
                }
            }
        }

        return maxGapLength;
    }
}
