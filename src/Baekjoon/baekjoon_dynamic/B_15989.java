package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_15989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        int[] dp = new int[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;

        for (int i = 5; i < dp.length; i++) {
            int i1 = i / 2;
            int i2 = i % 2;
            int i3 = i1 - i2;
            dp[i] = dp[i-1] + (i3/3 + 1);
        }

        for (int i = 0; i < test; i++) {
            int input = sc.nextInt();
            System.out.println(dp[input]);
        }
    }
}
