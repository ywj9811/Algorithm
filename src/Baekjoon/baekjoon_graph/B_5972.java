package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_5972 {
    private static int dp[];
    private static List<Node> nodes[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dp = new int[n+1];
        nodes = new List[n+1];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int value = sc.nextInt();
            nodes[a].add(new Node(a, b, value));
            nodes[b].add(new Node(b, a, value));
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        nodes[1].forEach(queue::add);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (dp[poll.to] > dp[poll.from]+poll.value) {
                dp[poll.to] = dp[poll.from] + poll.value;
                nodes[poll.to].forEach(queue::add);
            }
        }

        System.out.println(dp[n]);
    }

    private static class Node {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}
