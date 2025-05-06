package Baekjoon.baekjoon_backtracking;

import java.util.Scanner;

public class B_15650 {
    private static int m;
    private static int n;
    private static boolean visited[];
    private static int[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        results = new int[n];

        dfs(1, 0);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 1; i <= n; i++) {
                if (visited[i])
                    System.out.print(i + " ");
            }
            System.out.println();
        }
        for (int i = start; i <= n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
}
