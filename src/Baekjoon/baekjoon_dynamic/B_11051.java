package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] dp = new long[n+1][m+1];

        if (m == 0) {
            System.out.println(1);
            return;
        }
        dp[1][1] = 1;
        dp[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%10007;
            }
        }

        System.out.println(dp[n][m]);
    }
}
