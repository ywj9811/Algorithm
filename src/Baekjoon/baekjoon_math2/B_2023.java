package Baekjoon.baekjoon_math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2023 {
    static int length;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int now, int nowLength) {
        if (isPrime(now)) {
            if (nowLength == length) {
                System.out.println(now);
                return;
            }
            now *= 10;
            for (int i = 1; i <= 9; i += 2) {
                dfs(now + i, nowLength + 1);
            }
        }
    }

    static boolean isPrime(int now) {
        for (int i = 2; i < now/2; i++) {
            if (now % i == 0)
                return false;
        }
        return true;
    }
}
