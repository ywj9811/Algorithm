package Programmers.level2;

import java.util.*;

public class MapMin {
    Queue<int[]> queue = new LinkedList<>();
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;
    int row;
    int col;
    int[][] a;

    public int solution(int[][] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length;
        visited = new boolean[row][col];
        a = new int[row][col];
        a[0][0] = 1;
        a[row-1][col-1] = -1;
        queue.add(new int[]{0,0});
        bfs(maps);
        return a[row-1][col-1];
    }

    public void bfs(int[][] maps) {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;
            if (now[0] == row-1 && now[1] == col-1) {
                return;
            }
            for(int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x < row && x >= 0 && y < col &&  y >= 0 && maps[x][y] == 1 && visited[x][y] == false)
                {
                    a[x][y] = a[now[0]][now[1]] + 1;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}
