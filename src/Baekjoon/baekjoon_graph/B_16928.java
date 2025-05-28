package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_16928 {
    private static int dm[] = new int[]{1, 2, 3, 4, 5, 6};
    private static int dp[] = new int[101];
    private static int move[] = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 1; i <= 100; i++) {
            dp[i] = Integer.MAX_VALUE;
            move[i] = i;
        }
        dp[1] = 0;

        for (int i = 0; i < a+b; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            move[start] = end;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = poll + i;
                if (dp[move[next]] > dp[poll] + 1) {
                    dp[move[next]] = dp[poll] + 1;
                    queue.add(move[next]);
                }
                if (move[next] == 100) {
                    System.out.println(dp[100]);
                    return;
                }
            }
        }
    }
}
