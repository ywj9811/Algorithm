package Baekjoon.baekjoon_recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M_11724 {
    private static boolean[] visited;
    private static List<Integer>[] nodes;
    private static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        nodes = new List[n+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        visited[0] = true;

        for (int i = 1; i < m+1; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            nodes[in].add(out);
            nodes[out].add(in);
        }

        dfs(1);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int in) {
        if (visited[in])
            return;
        visited[in] = true;
        for (int i : nodes[in]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
