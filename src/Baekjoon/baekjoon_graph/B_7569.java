package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_7569 {
    private static int[] dx = new int[]{0, 0, 1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 0, 0, 1, -1};
    private static int[] dh;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int box = sc.nextInt();
        dh = new int[]{x, x*(-1), 0, 0, 0, 0};
        int[][] board = new int[x*box][y];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < x*box; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1)
                    queue.add(new Node(i, j, 0));
            }
        }

        int max = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollX = poll.x;
            int pollY = poll.y;
            int z = pollX / x; // 몇번째 박스인지 확인 (시작은 0)
            int floorStart = z * x; // 박스의 첫번째 x는 몇번째 박스 * x (0, x, 2x ...)
            int floorEnd = (z + 1) * x; // 박스의 끝 체크
            int depth = poll.depth;
//            System.out.println("x : " + pollX + " y : " + pollY + " depth : " + depth);
            max = Math.max(max, depth);
            for (int i = 0; i < 2; i++) {
                if (pollX + dh[i] >= 0 && pollX + dh[i] < x * box) {
                    int nextX = pollX + dh[i];
                    if (board[nextX][pollY] == 0) {
                        board[nextX][pollY] = 1;
                        queue.add(new Node(nextX, pollY, depth + 1));
                    }
                }
            }

            for (int i = 2; i < 6; i++) {
                int nextX = pollX + dx[i];
                int nextY = pollY + dy[i];
                if (nextX >= floorStart && nextX < floorEnd && nextY >= 0 && nextY < y) { // x가 박스의 시작 ~ 끝 사이에 있어야함
                    if (board[nextX][nextY] == 0) {
                        board[nextX][nextY] = 1;
                        queue.add(new Node(nextX, nextY, depth + 1));
                    }
                }
            }
        }

        for (int i = 0; i < x*box; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }

    private static class Node {
        int x, y, depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
