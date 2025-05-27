package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2206 {
    static int n, m;
    static int[][] board;
    static boolean[][][] visited; // [x][y][0: 안 부쉈음, 1: 부쉈음]
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y, dist, broken;

        Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];

        for (int i = 1; i <= n; i++) {
            String[] split = sc.next().split("");
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(split[j-1]);
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == n && curr.y == m) {
                return curr.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx < 1 || ny < 1 || nx > n || ny > m)
                    continue;

                if (board[nx][ny] == 0 && !visited[nx][ny][curr.broken]) {
                    visited[nx][ny][curr.broken] = true;
                    queue.offer(new Node(nx, ny, curr.dist + 1, curr.broken));
                }

                // 벽이고 아직 안 부쉈을 경우
                else if (board[nx][ny] == 1 && curr.broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new Node(nx, ny, curr.dist + 1, 1));
                }
            }
        }

        return -1;
    }
}