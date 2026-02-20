package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_16398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nodes = new int[n][n];
        List<Node>[] links = new List[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = sc.nextInt();
                links[i].add(new Node(j, nodes[i][j]));
            }
        }

        pq.add(new Node(0, 0));
        int cnt = 0;
        long sum = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (visited[poll.target]) continue;
            visited[poll.target] = true;
            cnt++;
            sum += poll.cost;
            if (cnt == n)
                break;
            for (Node node : links[poll.target]) {
                if (visited[node.target])
                    continue;
                pq.add(new Node(node.target, node.cost));
            }
        }

        System.out.println(sum);
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
