package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Kruscal2 {
    static int[] leaf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        leaf = new int[n];
        int[][] graph = new int[n][3];

        for (int i = 1; i <= n; i++)
            leaf[i-1] = i;

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, Comparator.comparing(o -> o[2]));

        int sum = 0;

        for (int[] node : graph) {
            if(union(node[0], node[1]))
                sum += node[2];
        }

        System.out.println(sum);
    }

    static int find(int a) {
        if (leaf[a-1] == a)
            return a;
        return leaf[a-1] = find(leaf[a-1]);
    }

    static boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);

        if (a == b) {
            return false;
        }

        leaf[a-1] = b;
        return true;
    }
}
