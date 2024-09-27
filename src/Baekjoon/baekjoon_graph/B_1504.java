package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1504 {
    private static int MAX = 200000000;
    private static int N;
    private static int CNT;
    private static List<Node>[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        CNT = sc.nextInt();
        nodes = new List[N+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < CNT; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        int first = sc.nextInt();
        int second = sc.nextInt();

        int firstRes = 0;
        firstRes += dstra(1, first);
        firstRes += dstra(first, second);
        firstRes += dstra(second, N);

        int secondRes = 0;
        secondRes += dstra(1, second);
        secondRes += dstra(second, first);
        secondRes += dstra(first, N);

        if (firstRes >= MAX && secondRes >= MAX) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(firstRes, secondRes));
    }

    private static int dstra(int start, int end) {
        int[] values = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(values, MAX);
        Arrays.fill(visited, false);
        values[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.num]) {
                continue;
            }
            visited[poll.num] = true;
            for (Node node : nodes[poll.num]) {
                if (values[node.num] > values[poll.num] + node.value) {
                    values[node.num] = values[poll.num] + node.value;
                    queue.add(new Node(node.num, values[node.num]));
                }
            }
        }

        return values[end];
    }

    private static class Node implements Comparable<Node> {
        int num;
        int value;

        public Node(int num, int value) {
            this.value = value;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
