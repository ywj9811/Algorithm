package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_15681 {
    private static int dp[];
    private static List<Integer>[] nodes;

    /**
     * 9 5 3
     * 1 3
     * 4 3
     * 5 4
     * 5 6
     * 6 7
     * 2 3
     * 9 6
     * 6 8
     * 5
     * 4
     * 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int q = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        dp = new int[n+1];
        nodes = new List[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
            dp[i] = 1;
        }
        for (int i = 0; i < n-1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            nodes[from].add(to);
            nodes[to].add(from);
        }
        for (int i = 0; i < q; i++) {
            answer.add(sc.nextInt());
        }

        dfs(r, -1);

        answer.forEach(ans -> System.out.println(dp[ans]));
    }

    private static void dfs(int next, int prev) {
        List<Integer> nextList = nodes[next];
        for (int node : nextList) {
            if (node == prev)
                continue;
            dfs(node, next);
            dp[next] += dp[node];
        }
    }
}
