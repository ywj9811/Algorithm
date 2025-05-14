package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_14496 {
    private static boolean visited[];
    private static int dp[];
    private static List<Integer>[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        nodes = new List[n+1];
        dp = new int[n+1];

        for (int i = 0; i<= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            nodes[from].add(to);
            nodes[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == b) {
                System.out.println(dp[b]);
                return;
            }
            List<Integer> polls = nodes[poll];
            for (int i = 0; i < polls.size(); i++) {
                Integer integer = polls.get(i);
                if (visited[integer])
                    continue;
                visited[integer] = true;
                dp[integer] = dp[poll]+1;
                queue.add(integer);
            }
        }

        System.out.println(-1);
    }
}
