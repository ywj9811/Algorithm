package Baekjoon.baekjoon_math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2023 {
    static int length;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int len) {
        if (len == length) {
            if (isPrime(num))
                System.out.println(num);
        }
        int first = (num * 10) + 1;
        if (isPrime(first))
            dfs(first, len+1);
        int second = (num * 10) + 3;
        if (isPrime(second))
            dfs(second, len+1);
        int third = (num * 10) + 5;
        if (isPrime(third))
            dfs(third, len+1);
        int fourth = (num * 10) + 7;
        if (isPrime(fourth))
            dfs(fourth, len+1);
        int fifth = (num * 10) + 9;
        if (isPrime(fifth))
            dfs(fifth, len+1);
    }

    private static boolean isPrime(int prime) {
        for (int i = 2; i < prime/2; i++) {
            if (prime % i == 0)
                return false;
        }
        return true;
    }
}
