package Baekjoon.baekjoon_graph;

import java.io.IOException;
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
    private static int[][] board;
    private static int[][] result;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static Queue<Node> queue = new LinkedList<>();
    private static boolean exit = false;

    /**
     * 4 6
     * 101111
     * 101010
     * 101011
     * 111011
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        visited = new boolean[x][y];
        board = new int[x][y];
        result = new int[x][y];

        for (int i = 0; i < x; i++) {
            Arrays.fill(visited[i], false);
            Arrays.fill(result[i], 1);
        }

        for (int i = 0; i < x; i++) {
            String input = sc.next();
            String[] split = input.split("");
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        queue.add(new Node(0,0));
        bfs();
        System.out.println(result[x-1][y-1]);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                if (x+dx[i] >= 0 && y+dy[i] >= 0 && x+dx[i] < board.length && y+dy[i] < board[0].length) {
                    Node nextNode = new Node(x + dx[i], y + dy[i]);
                    if (!visited[nextNode.x][nextNode.y] && board[nextNode.x][nextNode.y] == 1) {
                        result[nextNode.x][nextNode.y] = result[x][y]+1;
                        queue.add(nextNode);
                    }
                }
            }
        }
    }
}
