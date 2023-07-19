package Baekjoon.baekjoon_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class M_11724 {
    static boolean[] visited;
    static ArrayList<Integer>[] linked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n+1];
        linked = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            linked[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();
            linked[startIdx].add(endIdx);
            linked[endIdx].add(startIdx);
        }

        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        if (visited[i])
            return;
        visited[i] = true;
        for (int j = 0; j < linked[i].size(); j++) {
            if (!visited[linked[i].get(j)])
                dfs(linked[i].get(j));
        }
    }
}
