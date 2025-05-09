package Programmers.level2;

import java.util.*;

public class DesertIslandTravel {
    private static String[][] board;
    private static boolean[][] visited;
    private static int[] dx = new int[]{1,-1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    private static int n;
    private static int m;

    public int[] solution(String[] maps) {
        String[] splits = maps[0].split("");
        n = maps.length;
        m = splits.length;
        board = new String[n][m];
        visited = new boolean[n][m];
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            splits = maps[i].split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = splits[j];
                if (splits[j].equals("X"))
                    visited[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j].equals("X") && !visited[i][j]) {
                    visited[i][j] = true;
                    int sum = dfs(i, j);
                    results.add(sum);
                }
            }
        }
        if (results.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        Collections.sort(results);

        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private int dfs(int x, int y) {
        int sum = Integer.parseInt(board[x][y]);
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (curX >= 0 && curY >= 0 && curX < n && curY < m) {
                if (visited[curX][curY])
                    continue;
                visited[curX][curY] = true;
                sum += dfs(curX, curY);
            }
        }
        return sum;
    }
}
