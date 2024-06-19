package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_9372 {
    private static Queue<Integer> queue;
    private static List<Integer>[] nodes;
    private static boolean[] visited;
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            count = 0;

            queue = new LinkedList<>();
            nodes = new List[n+1];
            visited = new boolean[n+1];
            Arrays.fill(nodes, new ArrayList<>());
            Arrays.fill(visited, false);
            for (int j = 0; j < m; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                nodes[start].add(end);
                nodes[end].add(start);
            }
            queue.add(1);
            visited[1] = true;
            bfs();

            System.out.println(count);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> linkedNodes = nodes[poll];

            for (int node : linkedNodes) {
                if (visited[node])
                    continue;
                count++;
                visited[node] = true;
                queue.add(node);
            }
        }
    }
}
