package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1260 {
    /**
     * 1 -> 2, 3, 4
     * 2 -> 4
     * 3 -> 4, 5
     * 4 -> 5
     *
     * dfs
     * 1 - 2 - 4 - 5 - 3
     *
     * bfs
     * 1 - 2 - 3 - 4 - 5
     *
     * dfs를 위해서는, 한번 다음 노드로 이동하면, 해당 노드에서 연결된 것을 탐색. 없으면 처음으로 돌아오기
     * bfs를 위해서는, 시작된 노드에서 연결된 모든 노드 탐색, 그 다음 다른 노드로 이동하여 연결된 모든 노드 탐색
     */
    static boolean[] visited;
    static List<Integer>[] nodes;
    static int total;
    static int link;
    static int start;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt();
        link = sc.nextInt();
        start = sc.nextInt();
        nodes = new List[total+1];

        for (int i = 0; i <= total; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < link; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            nodes[s].add(e);
            nodes[e].add(s);
        }
        for (int i = 0; i <= total; i++) {
            Collections.sort(nodes[i]);
        }

        visited = new boolean[total+1];
        bfs(start);
        System.out.println();
        visited = new boolean[total+1];
        dfs(start);
    }

    private static void bfs(int node) {
        if (visited[node])
            return;
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < nodes[node].size(); i++) {
            bfs(nodes[node].get(i));
        }
    }

    private static void dfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int depth = 0;

        while (!queue.isEmpty()) {
            if (depth == total)
                break;
            Integer poll = queue.poll();
            if (visited[poll])
                continue;
            depth++;
            visited[poll] = true;
            System.out.print(poll + " ");
            for (int next : nodes[poll])
                queue.add(next);
        }
    }
}
