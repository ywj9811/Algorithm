package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_11660 {
    public static void main(String[] args) {
        int[][] board;
        int[][] answer;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int want = sc.nextInt();

        board = new int[n+1][n+1];
        answer = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(answer[i], 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j-1 == 0) {
                    answer[i][j] = answer[i-1][n] + board[i][j];
                    continue;
                }
                answer[i][j] = answer[i][j-1] + board[i][j];
            }
        }

        for (int i = 0; i < want; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            int result = 0;
            for (int j = s1; j <= e1; j++) {
                if (s2 == 1) {
                    result += answer[j][e2] - answer[j-1][n];
                    continue;
                }
                result += (answer[j][e2] - answer[j][s2-1]);
            }
            System.out.println(result);
        }
    }
}
