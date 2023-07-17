package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_11726 {
    public static void main(String[] args) {
        /**
         * N -> N-1의 경우에서 세로1 + N-2의 경우에서 가로로 2개 즉, N-1 + N-2 방법 존재
         * N = 3이상인 경우 해당
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = operation(N);
        System.out.println(result);
    }

    static int operation(int N) {
        if (N <= 2)
            return N;
        int dp[] = new int[N];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < N; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }
        return dp[N-1];
    }
}