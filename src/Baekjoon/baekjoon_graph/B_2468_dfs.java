package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_2468_dfs {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[][] board;
    private static int water;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        water = 0;
        int max = 0;

        while (water <= 100) {
            visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] > water) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            max = Math.max(max, count);
            water++;
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < n) {
                if (board[x + dx[i]][y + dy[i]] > water && !visited[x + dx[i]][y + dy[i]]) {
                    dfs(x + dx[i], y + dy[i]);
                }
            }
        }
    }
}