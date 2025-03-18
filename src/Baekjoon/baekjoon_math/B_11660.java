package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_11660 {
    private static int[][] board;
    private static int[][] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int count = sc.nextInt();
        board = new int[size+1][size+1];
        sum = new int[size+1][size+1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                board[i][j] = sc.nextInt();
                if (j == 1) {
                    sum[i][j] = board[i][j] + sum[i-1][size];
                    continue;
                }
                sum[i][j] = board[i][j] + sum[i][j-1];
            }
        }

        for (int i = 0; i < count; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            int total = 0;
            for (int j = 0; j <= e1-s1; j++) {
                if (s2 == 1) {
//                    System.out.println("end : " + sum[e1-j][e2]);
//                    System.out.println("start : " + sum[e1-(j+1)][size]);
                    total += sum[e1-j][e2] - sum[e1-(j+1)][size];
                    continue;
                }
//                System.out.println("end : " + sum[e1-j][e2]);
//                System.out.println("start : " + sum[e1-j][s2-1]);
                total += sum[e1-j][e2] - sum[e1-j][s2-1];
            }

            System.out.println(total);
        }
    }
}

/**
 *
 */