package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2573 {
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static int[][] board;
    private static int[][] temp;
    private static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        board = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int year = 0;

        while (true) {
            year++;
            temp = new int[x][y];
            visited = new boolean[x][y];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            if (i + dx[k] < 0 || i + dx[k] >= x || j + dy[k] < 0 || j + dy[k] >= y) continue;
                            if (board[i+dx[k]][j+dy[k]] <= 0) temp[i][j]++;
                        }
                    }
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    board[i][j] -= temp[i][j];
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] > 0) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            if (visited[poll[0]][poll[1]]) continue;
                            visited[poll[0]][poll[1]] = true;
                            for (int k = 0; k < 4; k++) {
                                if (poll[0] + dx[k] < 0 || poll[0] + dx[k] >= x || poll[1] + dy[k] < 0 || poll[1] + dy[k] >= y) continue;
                                if (board[poll[0]+dx[k]][poll[1]+dy[k]] > 0 && !visited[poll[0]+dx[k]][poll[1]+dy[k]]) {
                                    queue.add(new int[]{poll[0]+dx[k],poll[1]+dy[k]});
                                }
                            }
                        }
                    }
                }
            }
            visited = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] > 0) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            if (visited[poll[0]][poll[1]]) continue;
                            visited[poll[0]][poll[1]] = true;
                            for (int k = 0; k < 4; k++) {
                                if (poll[0] + dx[k] < 0 || poll[0] + dx[k] >= x || poll[1] + dy[k] < 0 || poll[1] + dy[k] >= y) continue;
                                if (board[poll[0]+dx[k]][poll[1]+dy[k]] > 0 && !visited[poll[0]+dx[k]][poll[1]+dy[k]]) {
                                    queue.add(new int[]{poll[0]+dx[k],poll[1]+dy[k]});
                                }
                            }
                        }
                    }
                }
            }
            boolean flag = false;
            out : for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(board[i][j] + " ");
                    if (!visited[i][j] && board[i][j] > 0) {
                        System.out.println(year);
                        flag = true;
                        break out;
                    }
                }
                System.out.println();
            }
            if (flag)
                break;
        }
    }
}
