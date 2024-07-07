package Baekjoon.baekjoon_graph;

import java.util.*;
import java.io.*;

public class B_1916 {
    private static List<Node>[] nodes;
    private static boolean[] visited;
    private static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        nodes = new LinkedList[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new LinkedList<>();
        }
        visited = new boolean[n+1];
        values = new int[n+1];
        Arrays.fill(values, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            nodes[me].add(new Node(num, value));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        di(start, end);
    }

    private static void di(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        values[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int now = poll.num;
            if (!visited[now]) {
                visited[now] = true;
                for (Node next : nodes[poll.num]) {
                    if (!visited[next.num] && values[next.num] > values[now] + next.value) {
                        values[next.num] = values[now] + next.value;
                        queue.add(new Node(next.num, values[next.num]));
                    }
                }
            }
        }

        System.out.println(values[end]);
    }

    private static class Node implements Comparable<Node> {
        Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
        int num;
        int value;

        @Override
        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }
}