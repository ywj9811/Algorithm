package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1967 {
    private static List<Node>[] nodes;
    private static int farNode;
    private static int[] dp;
    private static boolean[] visited;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodes = new List[n+1];
        dp = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int value = sc.nextInt();
            nodes[from].add(new Node(to, value));
            nodes[to].add(new Node(from, value));
        }
        bfs(1);
        visited = new boolean[n+1];
        dp = new int[n+1];
        int farNodeIdx = farNode;
        bfs(farNodeIdx);
        System.out.println(max);
    }

    private static void bfs(int from) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (visited[poll]) {
                continue;
            }
            visited[poll] = true;
            List<Node> list = nodes[poll];
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if (visited[node.to])
                    continue;
                dp[node.to] = dp[poll] + node.value;
                if (max < dp[node.to]) {
                    max = dp[node.to];
                    farNode = node.to;
                }
                queue.add(node.to);
            }

        }
    }

    private static class Node {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}
