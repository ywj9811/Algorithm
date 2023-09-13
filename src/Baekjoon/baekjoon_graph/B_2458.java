package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2458 {
    static int n;
    static int m;
    static List<Integer>[] in;
    static List<Integer>[] out;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        in = new List[n+1];
        out = new List[n+1];
        int inIdx;
        int outIdx;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            inIdx = Integer.parseInt(st.nextToken());
            outIdx = Integer.parseInt(st.nextToken());
            out[inIdx].add(outIdx);
            in[outIdx].add(inIdx);
        }
    }

    static void check(int me) {
        Set<Integer> checkSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < in[me].size(); i++) {
            checkSet.add(in[me].get(i));
        }
    }
}
