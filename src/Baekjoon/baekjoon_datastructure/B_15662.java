package Baekjoon.baekjoon_datastructure;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class B_15662 {
    static int[][] wheel;
    static int[][] copy;
    static int[] isRolls;
    static int t;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        t = sc.nextInt();
        wheel = new int[t+1][9];
        copy = new int[t+1][9];
        isRolls = new int[t+1];
        Arrays.fill(isRolls, 0);

        for (int i = 0; i < t; i++) {
            String input = sc.next();
            IntStream chars = input.chars();
            int i2 = 0;
            while (i2 < 8) {
                wheel[i+1][i2+1] = Integer.parseInt(String.valueOf(input.charAt(i2)));
                i2++;
            }
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            checkRoll();
            rolling();
        }

        int count = 0;
        for (int i = 1; i < t+1; i++) {
            if (wheel[i][1] == 1)
                count++;
        }

        System.out.println(count);
    }

    static void checkRoll() {
        int number = sc.nextInt();
        int direction = sc.nextInt();

        if (direction == 1) {
            isRolls[number] = 1;
            check(number);
        }
        else {
            isRolls[number] = -1;
            check(number);
        }
    }

    static void rolling() {
        for (int i = 1; i < isRolls.length; i++) {
            if (isRolls[i] == 1) {
                clockWise(i);
                continue;
            }
            if (isRolls[i] == -1) {
                antiClockWise(i);
            }
        }
        Arrays.fill(isRolls, 0);
    }

    static void clockWise(int num) {
        makeCopy(num);
        for (int i = 2; i < 9; i++) {
            wheel[num][i] = copy[num][i-1];
        }
        wheel[num][1] = copy[num][8];
    }

    static void antiClockWise(int num) {
        makeCopy(num);
        for (int i = 7; i > 0; i--) {
            wheel[num][i] = copy[num][i+1];
        }
        wheel[num][8] = copy[num][1];
    }

    private static void makeCopy(int num) {
        for (int i = 1; i < wheel[num].length; i++) {
            copy[num][i] = wheel[num][i];
        }
    }

    static void check(int number) {
        int left = number;
        while (left > 1) {
            if (isRolls[left] == 1) {
                if (wheel[left][7] != wheel[left-1][3])
                    isRolls[left-1] = -1;
            }
            if (isRolls[left] == -1) {
                if (wheel[left][7] != wheel[left-1][3])
                    isRolls[left-1] = 1;
            }
            if (isRolls[left] == 0)
                break;
            left--;
        }
        int right = number;
        while (right < t) {
            if (isRolls[right] == 1) {
                if (wheel[right][3] != wheel[right+1][7])
                    isRolls[right+1] = -1;
            }
            if (isRolls[right] == -1) {
                if (wheel[right][3] != wheel[right+1][7])
                    isRolls[right+1] = 1;
            }
            if (isRolls[right] == 0)
                break;
            right++;
        }
    }
}
