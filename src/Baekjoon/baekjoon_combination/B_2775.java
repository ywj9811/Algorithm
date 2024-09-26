package Baekjoon.baekjoon_combination;

import java.util.Scanner;

public class B_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[][] dp = new int[15][15];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        dp[1][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int i = 0 ; i < test; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(dp[k][n]);
        }
    }
}
