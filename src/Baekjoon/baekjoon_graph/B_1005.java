package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1005 {
    private static Scanner sc = new Scanner(System.in);
    private static List<Integer>[] nodes;
    private static int[] dp;
    private static int[] time;
    private static int[] topological;
    
    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int cal = cal();
            System.out.println(cal);
        }
    }

    private static int cal() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new int[n+1];
        nodes = new List[n+1];
        time = new int[n+1];
        topological = new int[n+1];

        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            nodes[from].add(to);
            topological[to] += 1;
        }
        int target = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (topological[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int next : nodes[poll]) {
                dp[next] = Math.max(dp[next], dp[poll] + time[next]);
                topological[next]--;
                if (topological[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return dp[target];
    }
}
