package Baekjoon.baekjoon_dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2293 {
    public static void main(String[] args) {
        int dp[];
        List<Integer> coins = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int goal = sc.nextInt();
        dp = new int[goal+1];

        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        Collections.sort(coins);
        dp[0] = 1;

        coins.forEach(coin -> {
                    for (int i = 0; i <= goal; i++) {
                        if (i - coin >= 0) {
                            dp[i] = dp[i] + dp[i-coin];
                        }
                    }
                });

        System.out.println(dp[goal]);
    }
}
