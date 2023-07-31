package Baekjoon.baekjoon_dynamic;

import java.io.*;
import java.util.Arrays;

public class B_15988 {
    static long[] dp = new long[1000001];
    static long div = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            operation(input);
            System.out.println(dp[input]);
        }

        br.close();
    }

    static void operation(int input) {
        for (int i = 4; i <= input; i++) {
            if (dp[i] != Long.MAX_VALUE)
                continue;
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%div;
        }
    }
}
