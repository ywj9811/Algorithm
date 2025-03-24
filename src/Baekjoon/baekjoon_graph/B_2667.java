package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_2667 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    private static int cnt;

    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            String[] splits = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(splits[j-1]);
                if (board[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 1 && visited[i][j] == false) {
                    cnt = 0;
                    dfs(i, j);
                    if (cnt > 0)
                        results.add(cnt);
                }
            }
        }

        results.sort((o1, o2) -> o1-o2);
        System.out.println(results.size());
        results.forEach(System.out::println);
    }

    private static void dfs(int a, int b) {
        visited[a][b] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            if (a+dx[i] > 0 && a+dx[i] <= N && b+dy[i] > 0 && b+dy[i] <= N && board[a+dx[i]][b+dy[i]] == 1) {
                if (!visited[a+dx[i]][b+dy[i]]) {
                    dfs(a+dx[i], b+dy[i]);
                }
            }
        }
    }
}
