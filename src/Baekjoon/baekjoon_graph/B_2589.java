package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2589 {
    private static int n;
    private static int m;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static String[][] board;
    private static boolean[][] visited;
    private static int[][] dp;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new String[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String[] split = sc.next().split("");
            for (int j = 1; j <= m; j++) {
                board[i][j] = split[j-1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j].equals("W"))
                    continue;
                visited = new boolean[n+1][m+1];
//                System.out.println("start");
                dp = new int[n+1][m+1];
                bfs(i, j);
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
//            System.out.println("x : " + poll[0] + " y : " + poll[1]);
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if (nextX > 0 && nextX <= n && nextY > 0 && nextY <= m && !visited[nextX][nextY] && board[nextX][nextY].equals("L")) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    dp[nextX][nextY] = dp[poll[0]][poll[1]] + 1;
                    max = Math.max(dp[nextX][nextY], max);
                }
            }
        }
    }
}
