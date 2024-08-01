package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        int[] value = new int[n+1];

        for (int i = 0; i < n; i++) {
            value[i+1] = sc.nextInt();
        }

        dp1[1] = value[1];

        for (int i = 2; i <= n; i++) {
            dp1[i] = value[i] + Math.max(dp1[i-2], dp2[i-2]);
            dp2[i] = value[i] + dp1[i-1];
        }

        System.out.println(Math.max(dp1[n], dp2[n]));
    }
}
