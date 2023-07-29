package Baekjoon.baekjoon_greedy;

import java.io.*;
import java.util.*;

public class B_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] check = new boolean[N+1];
        Arrays.fill(check, true);
        check[1] = false;
        for (int i = 2; i < N; i++) {
            if (!check[i])
                continue;
            for (int j = i+i; j < N+1; j += i) {
                check[j] = false;
            }
        }

        for (int i = M; i < N+1; i++) {
            if (check[i])
                System.out.println(i);
        }
    }
}
