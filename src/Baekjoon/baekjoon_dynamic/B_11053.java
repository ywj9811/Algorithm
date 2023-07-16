package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_11053 {
    static int[] seq;
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        seq = new int[length];
        dp = new Integer[length];

        int max = 1;

        for (int i = 0; i < length; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j]+1;
                }
            }
            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }
}
