package Baekjoon.ictIntern;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result5 {

    /*
     * Complete the 'countWaysToColorHouses' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    private static final int MOD = 1000000007;

    public static int countWaysToColorHouses(int n) {
        // dp[i]는 i번째 쌍까지 칠할 수 있는 방법의 수입니다.
        long[] dp = new long[n/2 + 1];

        // n=2일 때는 6가지 경우의 수가 있습니다.
        dp[1] = 6;

        // n이 4 이상일 때는 각각의 쌍을 칠하는 방법의 수는 이전 쌍까지의 방법의 수의 3배입니다.
        // 새로운 쌍을 칠하는 방법은 이전에 칠해진 집의 색상에 상관없이 3가지입니다.
        for (int i = 2; i <= n/2; i++) {
            dp[i] = (dp[i-1] * 3) % MOD;
        }

        // 마지막으로, n/2번째 쌍까지 칠할 수 있는 방법의 수를 반환합니다.
        // 이것이 전체 집을 칠하는 방법의 수가 됩니다.
        return (int)dp[n/2];
    }
}


public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result5.countWaysToColorHouses(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

