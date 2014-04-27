package org.joow.codingame.exercice1;

import java.util.Scanner;

class Player {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int bridgeLength = scanner.nextInt();
        final int gapLength = scanner.nextInt();
        final int platformLength = scanner.nextInt();

        while (true) {
            final int speed = scanner.nextInt();
            final int position = scanner.nextInt();

            if (position + 1 == bridgeLength) {
                System.out.println("JUMP");
            } else if (position >= bridgeLength + gapLength) {
                System.out.println("SLOW");
            } else if (speed < gapLength + 1) {
                System.out.println("SPEED");
            } else if (speed > gapLength + 1) {
                System.out.println("SLOW");
            }
            else {
                final int remainingMovesBeforeJump = bridgeLength - position - 1;
                if (remainingMovesBeforeJump % speed == 0) {
                    System.out.println("WAIT");
                } else {
                    System.out.println("SPEED");
                }
            }
        }
    }
}
