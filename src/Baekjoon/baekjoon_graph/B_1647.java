package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1647 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n+1];
        List<Node>[] nodes = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            nodes[from].add(new Node(to, cost));
            nodes[to].add(new Node(from, cost));
        }

        pq.add(new Node(1, 0));
        int max = 0;
        int cnt = 0;
        int value = 0;

        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            if (visited[poll.target])
                continue;
            visited[poll.target] = true;
            max = Math.max(max, poll.cost);
            cnt++;
            value += poll.cost;
            if (cnt == n)
                break;
            for (Node node : nodes[poll.target]) {
                if (!visited[node.target]) {
                    pq.add(node);
                }
            }
        }

        value -= max;
        System.out.println(value);
    }

    private static class Node {
        int target;
        int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}
