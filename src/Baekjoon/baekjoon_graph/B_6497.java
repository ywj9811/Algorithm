package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_6497 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;
            List<Value>[] values = new List[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                values[i] = new ArrayList<>();
            }
            long total = 0;

            for (int i = 0; i < m; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                total += cost;
                values[from].add(new Value(to, cost));
                values[to].add(new Value(from, cost));
            }

            long answer = 0;
            int cnt = 0;
            PriorityQueue<Value> pq = new PriorityQueue<>((Value a, Value b) -> a.cost - b.cost);

            pq.add(new Value(0, 0));

            while (!pq.isEmpty()) {
                Value poll = pq.poll();
                if (visited[poll.target]) continue;
                visited[poll.target] = true;
                answer += poll.cost;
                cnt++;
                if (cnt == n) break;
                for (int i = 0; i < values[poll.target].size(); i++) {
                    pq.add(values[poll.target].get(i));
                }
            }

            System.out.println(total - answer);
        }
    }

    private static class Value {
        int target;
        int cost;

        public Value(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}
