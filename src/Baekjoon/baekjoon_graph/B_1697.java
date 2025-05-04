package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int me = sc.nextInt();
        int target = sc.nextInt();
        bfs(me, target);
    }

    private static void bfs(int me, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(me, 0));
        boolean[] visited = new boolean[20000000];
        visited[me] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int cur = poll.cur;
            int time = poll.time;
            if (cur == target) {
                System.out.println(time);
                return;
            }

            if (cur >= 0) {
                int minus = cur - 1;
                if (minus >= 0 && !visited[minus]) {
                    queue.add(new Node(minus, time + 1));
                    visited[minus] = true;
                }
                if (cur > target)
                    continue;
                int plus = cur + 1;
                if (!visited[plus]) {
                    queue.add(new Node(plus, time + 1));
                    visited[plus] = true;
                }
                int multi = cur * 2;
                if (!visited[multi]) {
                    queue.add(new Node(multi, time + 1));
                    visited[multi] = true;
                }
            }
        }
    }

    private static class Node {
        int cur;
        int time;

        public Node(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }
    }
}
