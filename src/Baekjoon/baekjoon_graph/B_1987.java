package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1987 {
    private static String[][] board;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n;
    private static int m;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = sc.next().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = split[j];
            }
        }

        Set<String> values = new HashSet<>();
        values.add(board[0][0]);
        dfs(0, 0, 1, values);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth, Set<String> values) {
        max = Math.max(max, depth);
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m) {
                if (values.contains(board[a][b])) {
                    continue;
                }
                values.add(board[a][b]);
                dfs(a, b, depth+1, values);
                values.remove(board[a][b]);
            }
        }
    }
}
