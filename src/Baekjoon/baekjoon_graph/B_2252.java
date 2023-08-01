package Baekjoon.baekjoon_graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2252 {
    static ArrayList<Integer>[] students;
    static int[] inDegree;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        students = new ArrayList[n+1];
        for (int i = 0 ; i < students.length; i++) {
            students[i] = new ArrayList<>();
        }
        inDegree = new int[n+1];

        for (int i = 0; i < m; i++) {
            input = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            inDegree[b]++;
            students[a].add(b);
        }

        degree();
        bw.flush();
        bw.close();
        br.close();
    }

    static void degree() throws IOException {
        boolean isFin = true;
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                bw.write(i + " ");
                inDegree[i]--;
                for (int j = 0; j < students[i].size(); j++) {
                    inDegree[students[i].get(j)]--;
                }
                isFin = false;
            }
        }
        if (isFin)
            return;
        degree();
    }
}
