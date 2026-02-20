package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        List<Node>[] nodes = new List[v+1];
        int[] sum = new int[v+1];

        for (int i = 0; i <= v; i++) {
            nodes[i] = new ArrayList<>();
            sum[i] = Integer.MAX_VALUE;
        }

        sum[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.cost - b.cost);
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            nodes[from].add(new Node(to, cost));
        }
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > sum[cur.target]) continue;
            for (Node next : nodes[cur.target]) {
                if (sum[next.target] > sum[cur.target] + next.cost) {
                    sum[next.target] = sum[cur.target] + next.cost;
                    pq.add(new Node(next.target, sum[next.target]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (sum[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(sum[i]);
        }
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
