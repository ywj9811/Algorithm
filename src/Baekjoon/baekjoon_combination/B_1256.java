package Baekjoon.baekjoon_combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[202][202];
        int n = sc.nextInt(); // a 개수
        int m = sc.nextInt(); // z 개수
        long k = sc.nextLong(); // k 번째

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                if (dp[i][j] > 1000000000)
                    dp[i][j] = 1000000001;
            }
        } // 조합 초기화 완료

        if (dp[n+m][m] < k) {
            System.out.println(-1);
            return;
        }
        List<String> result = new ArrayList<>();

        while (!(n == 0 && m == 0)) {
            if (n == 0) {
                while (m > 0) {
                    result.add("z");
                    m--;
                }
                break;
            }
            if (m == 0) {
                while (n > 0) {
                    result.add("a");
                    n--;
                }
                break;
            }
            int total = n + m - 1;
            long t = dp[total][m];
            if (t >= k) {
                result.add("a");
                n--;
            } else {
                result.add("z");
                if (k < t) {
                    k = 0;
                } else {
                    k -= t;
                }
                m--;
            }
        }

        result.forEach(r -> System.out.print(r));
    }
}
