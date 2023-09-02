package Programmers.level2;

import java.util.*;

class Current {
    int x;
    int y;
    int cnt;

    public Current(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
class EscapeMaze {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] board;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }
    public static int solution(String[] maps) {
        board = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        Current start = null;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = maps[i].charAt(j);
                if(board[i][j] == 'S') {
                    start = new Current(i, j, 0);
                }
            }
        }
        int answer = 0;

        start = checkLever(start);
        if (start == null)
            return -1;
        visited = new boolean[maps.length][maps[0].length()];

        answer = checkGoal(start);
        return answer;
    }

    static Current checkLever(Current start) {
        Queue<Current> queue = new LinkedList<Current>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Current now = queue.poll();

            for(int i = 0; i < 4; i++) {
                if(!(now.x+dx[i] < visited.length && now.x+dx[i] >= 0
                        && now.y+dy[i] < visited[0].length && now.y+dy[i] >= 0))
                    continue;
                if(!(visited[now.x+dx[i]][now.y+dy[i]])
                        && (board[now.x+dx[i]][now.y+dy[i]] != 'X')) {
                    if(board[now.x+dx[i]][now.y+dy[i]] == 'L') {
                        Current current = new Current(now.x + dx[i], now.y + dy[i], now.cnt + 1);
                        return current;
                    }
                    queue.add(new Current(now.x+dx[i], now.y+dy[i], now.cnt+1));
                    visited[now.x+dx[i]][now.y+dy[i]] = true;
                }
            }
        }
        return null;
    }

    static int checkGoal(Current start) {
        Queue<Current> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Current now = queue.poll();

            for(int i = 0; i < 4; i++) {
                if(!(now.x+dx[i] < visited.length && now.x+dx[i] >= 0
                        && now.y+dy[i] < visited[0].length && now.y+dy[i] >= 0))
                    continue;
                if(!(visited[now.x+dx[i]][now.y+dy[i]]) &&
                        (board[now.x+dx[i]][now.y+dy[i]] != 'X')) {
                    if(board[now.x+dx[i]][now.y+dy[i]] == 'E') {
                        return now.cnt+1;
                    }
                    visited[now.x+dx[i]][now.y+dy[i]] = true;
                    queue.add(new Current(now.x+dx[i], now.y+dy[i], now.cnt+1));
                }
            }
        }
        return -1;
    }
}
