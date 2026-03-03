package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_16234 {
    private static boolean[][] visited;
    private static int[][] board;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static int l;
    private static int r;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        board = new int[n][n];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int day = 0;

        while (true) {
            boolean flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);
                        if (union.size() > 1) {
                            flag = true;
                        }
                        int sum = union.stream()
                                .mapToInt(v -> board[v[0]][v[1]])
                                .sum()/union.size();
                        union.forEach(v -> board[v[0]][v[1]] = sum);
                    }
                }
            }

            if (!flag) break;
            day++;
        }

        System.out.println(day);
    }

    private static List<int[]> bfs(int a, int b) {
        List<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (visited[poll[0]][poll[1]])
                continue;
            visited[poll[0]][poll[1]] = true;
            result.add(new int[]{poll[0], poll[1]});

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + poll[0];
                int nextY = dy[i] + poll[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                int diff = Math.abs(board[poll[0]][poll[1]] - board[nextX][nextY]);
                if (diff >= l && diff <= r) {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return result;
    }
}
