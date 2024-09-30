package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1325 {
    private static List<Integer>[] nodes;
    private static int n;
    private static boolean visited[];
    private static int result[];
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new List[n+1];
        result = new int[n+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            nodes[from].add(to);
        }

        for (int i = 1; i < nodes.length; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int cnt = 1;

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (int next : nodes[poll]) {
                    if (visited[next])
                        continue;
                    visited[next] = true;
                    cnt++;
                    queue.add(next);
                }
            }
            if (max < cnt)
                max = cnt;

            result[i] = cnt;
        }

        for (int i = 1; i < result.length; i++) {
            if (result[i] == max)
                System.out.print(i + " ");
        }
    }
}
