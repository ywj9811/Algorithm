package Programmers.level3;

import java.util.*;

public class Network {
    private boolean[] visited;
    private List<Integer>[] nodes;
    private int answer = 1;
    private int total;

    public int solution(int n, int[][] computers) {
        int[] a = new int[]{1,2,3};
        total = n-1;
        visited = new boolean[n];
        nodes = new List[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    nodes[i].add(j);
                    nodes[j].add(i);
                }
            }
        }

        dfs(0,0);

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i,0);
            }
        }

        return answer;
    }

    public void dfs(int node, int depth) {
        if (visited[node])
            return;
        visited[node] = true;
        if (depth == total)
            return;
        for (int i : nodes[node]) {
            dfs(i, depth + 1);
        }
    }
}
