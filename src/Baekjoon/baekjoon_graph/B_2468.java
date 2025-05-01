package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2468 {
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
                        bfs(i, j);
                    }
                }
            }
            max = Math.max(max, count);
            water++;
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.x][node.y]) {
                continue;
            }
            visited[node.x][node.y] = true;
            for (int i = 0; i < 4; i++) {
                if (node.x + dx[i] >= 0 && node.x + dx[i] < n && node.y + dy[i] >= 0 && node.y + dy[i] < n) {
                    if (board[node.x + dx[i]][node.y + dy[i]] > water && !visited[node.x + dx[i]][node.y + dy[i]]) {
                        queue.add(new Node(node.x + dx[i], node.y + dy[i]));
                    }
                }
            }
        }
    }

    private static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }
}
