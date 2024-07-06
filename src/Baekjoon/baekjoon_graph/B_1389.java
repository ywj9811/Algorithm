package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1389 {
    private static Set<Integer>[] nodes;
    private static boolean[] visited;
    private static int[][] values;
    private static Queue<F> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        nodes = new HashSet[n+1];
        visited = new boolean[n+1];
        values = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            nodes[start].add(end);
            nodes[end].add(start);
        }

        for (int i = 0; i < nodes.length; i++) {
            queue = new LinkedList<>();
            queue.add(new F(i, 1));
            Arrays.fill(visited, false);
            visited[i] = true;
            bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sum = Arrays.stream(values[i]).sum();
            if (min > sum) {
                min = sum;
                result = i;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int me) {
        while (!queue.isEmpty()) {
            F poll = queue.poll();
            for (int friend : nodes[poll.me]) {
//                System.out.println("friend : " + friend);
                if (visited[friend])
                    continue;
                values[me][friend] = poll.count;
//                System.out.println("me : " + me + " friend : " + friend + " : " + poll.count);
                visited[friend] = true;
                queue.add(new F(friend, poll.count+1));
            }
        }
    }

    private static class F {
        public F(int me, int count) {
            this.me = me;
            this.count = count;
        }
        int me;
        int count;
    }
}
