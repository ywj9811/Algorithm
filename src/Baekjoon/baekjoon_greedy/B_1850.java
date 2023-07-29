package Baekjoon.baekjoon_greedy;

import java.io.*;
import java.util.StringTokenizer;

public class B_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        Long result = Long.MAX_VALUE;

        while (result != 0) {
            result = A % B;
            A = B;
            B = result;
        }

        for (int i = 0; i < A; i++) {
            bw.write("1");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
