package Baekjoon.baekjoon_recursion;

import java.util.*;

public class M_11724 {
    private static boolean[] visited;
    private static Set<Integer>[] nodes;
    private static Stack<Integer> stack = new Stack();
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int conn = sc.nextInt();

        nodes = new HashSet[node+1];
        visited = new boolean[node+1];

        for (int i = 1; i <= node; i++)  {
            visited[i] = false;
            nodes[i] = new HashSet<>();
        }

        for (int i = 1; i <= conn; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            nodes[start].add(end);
            nodes[end].add(start);
        }

        for (int i = 1; i < nodes.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    static void dfs(int node) {
        if (!visited[node]) {
            stack.push(node);
            visited[node] = true;
        }
        if (stack.isEmpty()) {
            return;
        }
        Integer pop = stack.pop();

        for (int conNode : nodes[pop]) {
            dfs(conNode);
        }
    }
}
