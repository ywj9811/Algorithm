package Programmers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Bridge {
    public static void main(String[] args) {

    }

    private class Value {
        int num;
        int cost;

        public Value(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        List<Value>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] edge : costs) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            nodes[u].add(new Value(v, cost));
            nodes[v].add(new Value(u, cost));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Value> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.add(new Value(0, 0));

        int count = 0; // 연결된 섬의 개수

        while (!pq.isEmpty()) {
            Value cur = pq.poll();
            if (visited[cur.num])
                continue;
            visited[cur.num] = true;
            answer += cur.cost;
            count++;
            if (count == n)
                break;
            for (Value next : nodes[cur.num]) {
                if (!visited[next.num]) {
                    pq.add(next);
                }
            }
        }

        return answer;
    }
}
