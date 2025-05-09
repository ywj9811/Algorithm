package Programmers.level2;

import java.util.*;

public class GameMap {
    private static int[] dx = new int[]{1,-1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] board = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = maps[i-1][j-1];
            }
        }
        int answer = -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1));
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];
                if (curX > 0 && curX <= n && curY > 0 && curY <= m && board[curX][curY] == 1 && !visited[curX][curY]) {
                    visited[curX][curY] = true;
                    dp[curX][curY] = dp[x][y] + 1;
                    if (curX == n && curY == m) {
                        answer = dp[curX][curY];
                        return answer;
                    }
                    queue.add(new Node(curX, curY));
                }
            }
        }

        return answer;
    }

    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
