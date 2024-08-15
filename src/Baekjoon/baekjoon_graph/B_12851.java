package Baekjoon.baekjoon_graph;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_12851 {
    public static void main(String[] args) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        boolean fin = false;
        int cnt = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int start = 0;
        int end = 100000;
        boolean visited[] = new boolean[100001];

        queue.add(new Node(n, 0));
        sc.close();

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (min < poll.cnt)
                continue;

            if (poll.idx == k) {
                if (!fin) {
                    fin = true;
                }
                min = poll.cnt;
                cnt++;
                continue;
            }

            visited[poll.idx] = true;

            int first = poll.idx + 1;
            if (poll.idx < k && first <= end && !visited[first]) {
                queue.add(new Node(first, poll.cnt+1));
            }
            int second = poll.idx - 1;
            if (second >= start && !visited[second]) {
                queue.add(new Node(second, poll.cnt+1));
            }
            int third = poll.idx * 2;
            if (poll.idx < k && third <= end && !visited[third]) {
                queue.add(new Node(third, poll.cnt+1));
            }
        }

        System.out.println(min);
        System.out.println(cnt);
    }

    private static class Node implements Comparable<Node> {
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
}
