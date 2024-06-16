package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(dp[end] - dp[start-1]);
        }
    }
}
