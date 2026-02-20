package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sum = new int[n+1];

        List<Node>[] nodes = new List[n+1];
        for (int i = 0; i <= n; i++) {
            sum[i] = Integer.MAX_VALUE;
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            nodes[from].add(new Node(to, cost));
        }

        int from = sc.nextInt();
        int to = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.cost - b.cost);

        pq.add(new Node(from, 0));
        sum[from] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (sum[cur.to] < cur.cost)
                continue;
            for (Node next : nodes[cur.to]) {
                if (sum[next.to] <= sum[cur.to] + next.cost) {
                    continue;
                }
                sum[next.to] = sum[cur.to] + next.cost;
                pq.add(new Node(next.to, sum[next.to]));
            }
        }

        System.out.println(sum[to]);
    }

    private static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}