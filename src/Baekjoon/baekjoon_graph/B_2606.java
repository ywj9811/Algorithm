package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_2606 {
    private static Node[] nodes;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nodes = new Node[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        int m = sc.nextInt();
        for (int i = 0 ; i < m; i++) {
            int me = sc.nextInt();
            int you = sc.nextInt();

            nodes[me].links.add(you);
            nodes[you].links.add(me);
        }

        int ans = bfs();

        System.out.println(ans);
    }

    private static int bfs() {
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[1]);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Integer> links = poll.links;
            for (int link : links) {
                if (visited[link])
                    continue;
                visited[link] = true;
                cnt++;
                queue.add(nodes[link]);
            }
        }

        return cnt;
    }

    private static class Node {
        int me;
        List<Integer> links;

        public Node(int me) {
            this.me = me;
            this.links = new ArrayList<>();
        }
    }
}
