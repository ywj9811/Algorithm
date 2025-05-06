package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_14889 {
    private static int[][] board;
    private static boolean[] visited;
    private static int n;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(1, 0);

        System.out.println(min);
    }

    private static void dfs(int start, int depth) {
        if (depth == n/2) {
            diff();
            return;
        }
        for (int i = start; i <= n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    private static void diff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i == j)
                    continue;
                if (visited[i] && visited[j]) {
                    startTeam += board[i][j];
                    startTeam += board[j][i];
                }
                if (!visited[i] && !visited[j]){
                    linkTeam += board[i][j];
                    linkTeam += board[j][i];
                }
            }
        }
        min = Math.min(Math.abs(startTeam - linkTeam), min);
    }
}
