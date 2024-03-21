package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2178 {
    public static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
    }
    private static boolean[][] visited;
    private static int[][] map;
    private static int[][] board;
    private static int n;
    private static int m;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    /**
     * 4 6
     * 101111
     * 101010
     * 101011
     * 111011
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String[] split = s.split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(split[j-1]);
                board[i][j] = 1;
            }
        }

        bfs();

        System.out.println(board[n][m]);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList();
        Node nowNode = new Node(1, 1);
        queue.add(nowNode);
        visited[nowNode.x][nowNode.y] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (
                        now.y+dy[i] <= m && now.x+dx[i] <= n && now.x+dx[i] >= 0 && now.y+dy[i] >= 0
                        && !visited[now.x+dx[i]][now.y+dy[i]]
                        && map[now.x+dx[i]][now.y+dy[i]] == 1
                ) {
                    board[now.x+dx[i]][now.y+dy[i]] = board[now.x][now.y]+1;
                    queue.add(new Node(now.x+dx[i], now.y+dy[i]));
                    visited[now.x+dx[i]][now.y+dy[i]] = true;
                }
            }
        }
    }
}
