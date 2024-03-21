package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1260 {
    private static List<Integer>[] nodes;
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visited;
    private static int total;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt();
        int num = sc.nextInt();
        int start = sc.nextInt();

        nodes = new List[total+1];
        visited = new boolean[total+1];
        for (int i = 0; i < total+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            nodes[in].add(out);
            nodes[out].add(in);
        }

        for (int i = 0; i < total+1; i++) {
            Collections.sort(nodes[i]);
        }

        dfs(start, 0);
        System.out.println();
        visited = new boolean[total+1];
        queue.add(start);
        visited[start] = true;
        bfs();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            for (int i : nodes[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(int start, int depth) {
        if (visited[start])
            return;
        visited[start] = true;
        if (depth == total)
            return;
        System.out.print(start + " ");

        for (int i : nodes[start]) {
            if (!visited[i]) {
                dfs(i, depth+1);
            }
        }
    }
}
