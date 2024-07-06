package Baekjoon.baekjoon_implement;

import java.util.Scanner;

public class B_2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int dp[] = new int[input+1];
        dp[1] = 1;
        for (int i = 2; i < input+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[input]);
    }
}
