package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_13023 {
    static boolean[] visited;
    static List<Integer>[] friends;
    static boolean check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        friends = new List[node];
        for (int i = 0; i < node; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            friends[one].add(two);
            friends[two].add(one);
        }

        for (int i = 0; i < node; i++) {
            visited = new boolean[node];
            dfs(i, 0);
            if (check) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int node, int depth) {
        if (depth == 4 || check) {
            check = true;
            return;
        }
        visited[node] = true;
        for (int i : friends[node]) {
            if (!visited[i])
                dfs(i, depth+1);
        }
        visited[node] = false;
    }
}
