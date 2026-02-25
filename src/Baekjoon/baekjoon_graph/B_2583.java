package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_2583 {
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 0, -1, 1};
    private static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> sizes = new ArrayList<>();

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    board[i][j] = 1;
                    // 주어진 직사각형이 1, 빈 공간이 0
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    int size = bfs(new int[]{i, j});
                    sizes.add(size);
                }
            }
        }

        Collections.sort(sizes);
        System.out.println(sizes.size());
        sizes.forEach(s -> System.out.print(s + " "));
    }

    private static int bfs(int[] first) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(first);
        int size = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (visited[poll[0]][poll[1]]) continue;
            size++;
            visited[poll[0]][poll[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length)
                    continue;
                if (!visited[nextX][nextY] && board[nextX][nextY] == 0)
                    queue.add(new int[]{nextX, nextY});
            }
        }
        return size;
    }
}
