package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2458 {
    static int n;
    static int m;
    static boolean[] visited;
    static List<Integer>[] in;
    static List<Integer>[] out;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        in = new List[n+1];
        out = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }
        int inIdx;
        int outIdx;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            inIdx = Integer.parseInt(st.nextToken());
            outIdx = Integer.parseInt(st.nextToken());
            out[inIdx].add(outIdx);
            in[outIdx].add(inIdx);
        }

        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            visited[0] = true;
            if (check(i))
                cnt++;
        }

        System.out.println(cnt);
    }

    static boolean check(int me) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in[me].size(); i++) {
            queue.add(in[me].get(i));
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited[poll]) {
                continue;
            }
            visited[poll] = true;
            for (int i = 0; i < in[poll].size(); i++) {
                queue.add(in[poll].get(i));
            }
        }

        for (int i = 0; i < out[me].size(); i++) {
            queue.add(out[me].get(i));
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited[poll]) {
                continue;
            }
            visited[poll] = true;
            for (int i = 0; i < out[poll].size(); i++) {
                queue.add(out[poll].get(i));
            }
        }

        for (boolean isFalse : visited) {
            if (!isFalse)
                return false;
        }
        return true;
    }
}
