package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_17396 {
    private static int n;
    private static List<Node>[] nodes;
    private static int[] ban;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int t = sc.nextInt();
        nodes = new List[n];
        ban = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
            ban[i] = sc.nextInt();
        }
        ban[n-1] = 0;
        //ban[i] == 1 일경우 queue에 추가하지 않음

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
            //양방향 추가
        }

        long result = dstra();

        if (result == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static long dstra() {
        long[] dp = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.num]) {
                continue;
            }
            visited[poll.num] = true;
            for (Node node : nodes[poll.num]) {
                if (ban[node.num] == 1)
                    continue;
                if (dp[node.num] > (dp[poll.num] + node.value)) {
                    dp[node.num] = (dp[poll.num] + node.value);
                    queue.add(new Node(node.num, dp[node.num]));
                }
            }
        }

        return dp[n-1];
    }

    private static class Node implements Comparable<Node> {
        int num;
        long value;

        public Node(int num, long value) {
            this.num = num;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.value - o.value);
        }
    }
}
