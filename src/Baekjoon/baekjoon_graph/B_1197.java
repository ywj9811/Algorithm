package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1197 {
    private static int[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> queue = new PriorityQueue<>();

        int v = sc.nextInt();
        int e = sc.nextInt();

        nodes = new int[v+1];

        for (int i = 0; i < e; i++) {
            int me = sc.nextInt();
            int you = sc.nextInt();
            int value = sc.nextInt();
            queue.add(new Node(me, you, value));
        }

        for (int i = 0; i <= v; i++) {
            nodes[i] = i;
        }

        List<Node> ansNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (find(poll.me) == find(poll.you)) // 사이클 검사 -> union 이전에 이미, 부모가 동일하다면 사이클 존재 -> 이미 같은 부모를 공유. 둘이 연결되면 사이클 완성됨 스킵 필요
                continue;

            union(poll.me, poll.you);
            ansNodes.add(poll);

            if (ansNodes.size() == (v-1))
                break;
        }

        int sum = ansNodes.stream()
                .mapToInt(ans -> ans.value)
                .sum();

        System.out.println(sum);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            nodes[b] = a;
        }
    }

    private static int find(int idx) {
        if (nodes[idx] == idx)
            return idx;
        return nodes[idx] = find(nodes[idx]);
    }

    /**
     * 1 2 3 4 5 6
     * 1 1 2 3 4 6
     */

    private static class Node implements Comparable<Node> {
        int me;
        int you;
        int value;

        public Node(int me, int you, int value) {
            this.me = me;
            this.you = you;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}