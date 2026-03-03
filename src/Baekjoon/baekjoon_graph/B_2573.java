package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2573 {
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행(x)
        int m = sc.nextInt(); // 열(y)
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int year = 0;

        while (true) {
            // 1. 덩어리 개수 세기 (녹이기 전에 먼저 체크하는 게 정석입니다)
            int count = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j, n, m);
                        count++; // BFS가 한 번 끝날 때마다 덩어리 +1
                    }
                }
            }

            // 2. 조건 판단
            if (count >= 2) { // 두 덩어리 이상 분리됨
                System.out.println(year);
                break;
            }
            if (count == 0) { // 빙산이 다 녹을 때까지 분리 안 됨
                System.out.println(0);
                break;
            }

            // 3. 빙산 녹이기 (1년 경과)
            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k]; // [수정] i+dy[k] 오타 해결
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (board[nx][ny] <= 0) temp[i][j]++;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] -= temp[i][j];
                    if (board[i][j] < 0) board[i][j] = 0;
                }
            }
            year++;
        }
    }

    // 연결된 빙산을 찾는 BFS 메서드
    private static void bfs(int r, int c, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dx[k];
                int ny = poll[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}