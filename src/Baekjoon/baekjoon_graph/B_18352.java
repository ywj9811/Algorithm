package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_18352 {
    private static boolean[] visited;
    private static List<Integer>[] nodes;
    private static int[] values;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int start = sc.nextInt();

        visited = new boolean[n+1];
        nodes = new List[n+1];
        values = new int[n+1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[a].add(b);
        }

        queue.add(start);
        visited[start] = true;

        bfs();
        boolean tf = false;
        for (int i = 1; i <= n; i++) {
            if (values[i] == k) {
                System.out.println(i);
                tf = true;
            }
        }

        if (!tf)
            System.out.println(-1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int next : nodes[poll]) {
                if (!visited[next]) {
                    values[next] = values[poll]+1;
//                    System.out.println(next + " - value : " + values[next]);
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
