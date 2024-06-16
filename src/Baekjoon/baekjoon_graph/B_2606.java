package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_2606 {
    private static int count = 0;
    private static boolean[] visited;
    private static Set<Integer> nodes[];
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        nodes = new Set[input + 1];
        visited = new boolean[input + 1];

        int n = sc.nextInt();

        for (int i = 0; i <= input; i++) {
            nodes[i] = new HashSet<>();
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            nodes[start].add(end);
            nodes[end].add(start);
        }

        stack.push(1);
        visited[1] = true;
        dfs();

        System.out.println(count);
    }

    private static void dfs() {
        if (stack.isEmpty())
            return;
        Integer node = stack.pop();
        Set<Integer> targetNode = nodes[node];
        for (int target : targetNode) {
            if (!visited[target]) {
                visited[target] = true;
                count++;
                stack.push(target);
                dfs();
            }
        }
    }
}
