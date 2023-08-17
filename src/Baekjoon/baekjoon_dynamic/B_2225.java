package Baekjoon.baekjoon_dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2225 {
    static long dp[][];
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new long[201][201];
        if (n == 1) {
            System.out.println((k)%1000000000);
            return;
        }
        if (k == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
            dp[2][i] = i+1;
        }

        dynamicOp(2);

        System.out.println(dp[k][n]);
    }

    static void dynamicOp(int use) {
        while (true) {
            if (use > k) {
                return;
            }
            for (int i = 3; i <= use; i++) {
                long value = 0;
                for (int j = 0; j <= n; j++) {
                    value += (dp[i - 1][j])%= 1000000000;
                    dp[i][j] = value%1000000000;
                }
            }
            use++;
        }
    }
}
