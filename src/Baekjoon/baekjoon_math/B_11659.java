package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] values = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
            dp[i] = dp[i-1] + values[i];
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            int sum = dp[e] - dp[s - 1];
            System.out.println(sum);
        }
    }
}
