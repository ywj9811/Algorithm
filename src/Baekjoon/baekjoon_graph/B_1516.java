package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1516 {
    private static List<Integer>[] nodes;
    private static int[] dp;
    private static int[] depth;
    private static int[] basic;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        nodes = new List[n+1];
        dp = new int[n+1];
        depth = new int[n+1];
        basic = new int[n+1];

        depth[0] = -1;

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            basic[i] = sc.nextInt();
            while (true) {
                int input = sc.nextInt();
                if (input == -1)
                    break;
                nodes[input].add(i);
                depth[i]++;
            }
        }

        while (check());

        for (int i = 1; i <= n; i++) {
            System.out.println((dp[i] + basic[i]));
        }
    }

    private static boolean check() {
        for (int i = 1; i < depth.length; i++) {
            if (depth[i] == 0) {
                for (int node : nodes[i]) {
                    dp[node] = Math.max(dp[node], dp[i] + basic[i]);
                    depth[node]--;
                }
                depth[i]--;
                return true;
            }
        }
        return false;
    }
}
