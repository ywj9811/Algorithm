package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_2606 {
    private static int cnt;
    private static boolean[] visited;
    private static ArrayList<Integer>[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int links = sc.nextInt();

        visited = new boolean[n+1];
        nodes = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < links; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            nodes[s].add(e);
            nodes[e].add(s);
        }

        dfs(1);
        System.out.println(cnt-1);
    }

    private static void dfs(int node) {
        if (visited[node])
            return;
        visited[node] = true;
        cnt++;

        for (int next : nodes[node]) {
            if (visited[next])
                continue;
            dfs(next);
        }
    }
}
