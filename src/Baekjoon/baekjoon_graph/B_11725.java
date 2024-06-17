package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_11725 {
    private static List<Integer>[] nodes;
    private static int[] results;
    private static boolean[] visited;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodes = new List[n+1];
        visited = new boolean[n+1];
        results = new int[n+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            nodes[start].add(end);
            nodes[end].add(start);
        }

        visited[1] = true;
        queue.add(1);
        bfs();

        for (int i = 2; i < n+1; i++) {
            System.out.println(results[i]);
        }
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> linkedNode = nodes[now];
            for (int node : linkedNode) {
                if (visited[node])
                    continue;
                visited[node] = true;
                results[node] = now;
                queue.add(node);
            }
        }
    }
}