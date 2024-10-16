package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_7562 {
    private static int[] dx = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    private static boolean visited[][];
    private static int goalX;
    private static int goalY;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            n = sc.nextInt();
            visited = new boolean[n][n];

            int x = sc.nextInt();
            int y = sc.nextInt();

            goalX = sc.nextInt();
            goalY = sc.nextInt();

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(x, y, 0));
            int result = bfs(queue);

            System.out.println(result);
        }
    }

    static int bfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == goalX && node.y == goalY)
                return node.depth;

            for (int i = 0; i < dx.length; i++) {
                if (node.x+dx[i] < n && node.x+dx[i] >= 0 && node.y+dy[i] < n && node.y+dy[i] >= 0) {
                    if (visited[node.x+dx[i]][node.y+dy[i]])
                        continue;
                    queue.add(new Node(node.x+dx[i], node.y+dy[i], node.depth+1));
                    visited[node.x+dx[i]][node.y+dy[i]] = true;
                }
            }
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int depth;

    public Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}