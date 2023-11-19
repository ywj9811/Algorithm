package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {
    static String[][] board;
    static int[][] check;
    static boolean[][] visit;
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[N][M];
        visit = new boolean[N][M];
        board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        check[0][0] = 1;
        bfs(0,0);
        System.out.println(check[N-1][M-1]);
    }

    static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,m});
        visit[n][m] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (board[x][y].equals("1") && !visit[x][y]) {
                        visit[x][y] = true;
                        queue.add(new int[]{x, y});
                        check[x][y] = check[poll[0]][poll[1]]+1;
                    }
                }
            }
        }
    }
}
