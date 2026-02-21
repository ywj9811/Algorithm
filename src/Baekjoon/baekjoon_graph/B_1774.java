package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1774 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        List<Value>[] values = new List[n+1];
        long[][] points = new long[n+1][2];
        PriorityQueue<Value> pq = new PriorityQueue<>((Value a, Value b) -> Double.compare(a.cost, b.cost));

        for (int i = 0; i < values.length; i++) {
            values[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            points[i][0] = a;
            points[i][1] = b;
        }
        // 신의 좌표들 저장 points

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            values[a].add(new Value(b, 0.0));
            values[b].add(new Value(a, 0.0));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                values[i].add(new Value(j, getDistance(points[i], points[j])));
                values[j].add(new Value(i, getDistance(points[i], points[j])));
            }
        }

        double answer = 0.0;
        int cnt = 0;
        pq.add(new Value(1, 0.0));
        while (!pq.isEmpty()) {
            Value poll = pq.poll();
            if (visited[poll.point]) continue;
            visited[poll.point] = true;
            answer += poll.cost;
            cnt++;
            if (cnt == n)
                break;
            for (Value next : values[poll.point]) {
                if (!visited[next.point]) {
                    pq.add(next);
                }
            }
        }

        System.out.printf("%.2f", answer);
    }

    private static double getDistance(long[] p1, long[] p2) {
        long dx = p1[0] - p2[0];
        long dy = p1[1] - p2[1];

        return Math.sqrt(dx * dx + dy * dy);
    }

    private static class Value {
        int point;
        double cost;

        public Value(int point, double cost) {
            this.point = point;
            this.cost = cost;
        }
    }
}
