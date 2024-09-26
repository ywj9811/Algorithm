package Baekjoon.baekjoon_combination;

import java.util.Scanner;

public class B_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        long[][] dp = new long[31][31];

        for (int i = 0; i < dp[0].length; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        for (int i = 0 ; i < test; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(dp[n][k]);
        }
    }
}
