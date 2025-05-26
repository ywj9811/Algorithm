package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1303 {
    private static int n;
    private static int m;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static String[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) {
        int me = 0;
        int you = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new String[m+1][n+1];
        visited = new boolean[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            String next = sc.next();
            String[] split = next.split("");
            for (int j = 1; j <= n; j++) {
                board[i][j] = split[j-1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j].equals("W") && !visited[i][j]) {
                    visited[i][j] = true;
                    int mc = meBfs(i, j);
                    me += mc*mc;
                }
                if (board[i][j].equals("B") && !visited[i][j]) {
                    visited[i][j] = true;
                    int yc = youBfs(i, j);
                    you += yc*yc;
                }
            }
        }

        System.out.println(me + " " + you);
    }

    private static int meBfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX > 0 && nextX <= m && nextY > 0 && nextY <= n) {
                    if (visited[nextX][nextY] || board[nextX][nextY].equals("B"))
                        continue;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return cnt;
    }

    private static int youBfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX > 0 && nextX <= m && nextY > 0 && nextY <= n) {
                    if (visited[nextX][nextY] || board[nextX][nextY].equals("W"))
                        continue;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return cnt;
    }
}
