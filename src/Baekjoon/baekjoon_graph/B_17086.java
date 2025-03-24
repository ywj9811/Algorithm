package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_17086 {
    private static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int[][] dp;
    private static int[][] board;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1)
                    dp[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }

        System.out.println(max);
    }

    private static void dfs(int a, int b) {
        for (int i = 0; i < 8; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                if (dp[x][y] > dp[a][b] + 1) {
                    dp[x][y] = dp[a][b] + 1;
                    dfs(x, y);
                }
            }
        }
    }
}
