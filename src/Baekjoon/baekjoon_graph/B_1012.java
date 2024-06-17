package Baekjoon.baekjoon_graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B_1012 {
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static boolean[][] visited;
    private static boolean[][] cabbage;
    private static Stack<int[]> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int result = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            int count = sc.nextInt();
            visited = new boolean[x][y];
            cabbage = new boolean[x][y];
            stack = new Stack<>();

            for (int j = 0; j < x; j++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(cabbage[i], false);
            }

            for (int j = 0; j < count; j++) {
                int inputX = sc.nextInt();
                int inputY = sc.nextInt();
                cabbage[inputX][inputY] = true;
            }

            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (cabbage[j][k] && !visited[j][k]) {
                        stack.push(new int[]{j, k});
//                        System.out.println("x : " + j + " y : " + k);
                        result++;
                        dfs();
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void dfs() {
        if (stack.isEmpty())
            return;
        int[] pop = stack.pop();
        int x = pop[0];
        int y = pop[1];
        if (x >= 0 && y >= 0 && x < cabbage.length && y < cabbage[0].length) {
            if (cabbage[x][y]) {
                if (visited[x][y])
                    return;
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    stack.push(new int[]{x+dx[i], y+dy[i]});
                    dfs();
                }
            }
        }
    }
}
