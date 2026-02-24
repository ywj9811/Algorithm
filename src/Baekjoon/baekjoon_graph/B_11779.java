package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_11779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Value>[] values = new List[n+1];
        PriorityQueue<Value> pq = new PriorityQueue<>((Value a, Value b) -> a.cost - b.cost);
        int costs[] = new int[n+1];
        int parents[] = new int[n+1];

        Arrays.fill(costs, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            values[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            values[from].add(new Value(to, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        costs[start] = 0;

        pq.add(new Value(start, 0));

        while (!pq.isEmpty()) {
            Value cur = pq.poll();
            if (cur.cost > costs[cur.target]) continue;
            for (Value next : values[cur.target]) {
                if (costs[next.target] > costs[cur.target] + next.cost) {
                    costs[next.target] = costs[cur.target] + next.cost;
                    pq.add(next);
                    parents[next.target] = cur.target;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (true) {
            Integer peek = stack.peek();
            int parent = parents[peek];
            if (parent == 0)
                break;
            stack.push(parent);
        }
        System.out.println(costs[end]);
        System.out.println(stack.size());
        for (int i = stack.size()-1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
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
