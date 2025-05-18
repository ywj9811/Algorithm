package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2]; // n+1까지 필요

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            int next = i + t[i];
            if (next <= n + 1)
                dp[next] = Math.max(dp[next], p[i] + dp[i]);
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        System.out.println(dp[n+1]);
    }
}
