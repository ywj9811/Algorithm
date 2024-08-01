package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int dp[] = new int[n];
        int value[] = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        dp[0] = value[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+value[i], value[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
