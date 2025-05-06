package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_10974 {
    private static boolean[] visited;
    private static int[] results;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n+1];
        results = new int[n];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }
    }

    private static void dfs(int num, int depth) {
        results[depth] = num;
        if (depth == n-1) {
            for (int i = 0; i < n; i++) {
                System.out.print(results[i] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(i, depth+1);
            visited[i] = false;
        }
    }
}
