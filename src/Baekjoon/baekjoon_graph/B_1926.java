package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1926 {
    private static boolean visited[][];
    private static int board[][];
    private static int dx[] = new int[]{1, -1, 0, 0};
    private static int dy[] = new int[]{0, 0, -1, 1};
    private static int max = 0;
    private static int cnt = 0;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1][m+1];
        board = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int input = sc.nextInt();
                board[i][j] = input;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int cur = 0;
        cnt++;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            if (board[cx][cy] == 0 || visited[cx][cy] || cx > n || cy > m)
                continue;
            cur++;
//            System.out.println("x : " + cx + " y : " + cy + " value : " + board[cx][cy]);
//            System.out.println("cnt : " + cnt);
            visited[cx][cy] = true;
            for (int i = 0; i < 4; i++) {
                if (cx + dx[i] > n || cy + dy[i] > m)
                    continue;
                if (!visited[cx+dx[i]][cy+dy[i]])
                    queue.add(new int[]{cx+dx[i], cy+dy[i]});
            }
        }

        max = Math.max(cur, max);
    }
}
