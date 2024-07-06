package Baekjoon.baekjoon_greedy;

import java.io.*;
import java.util.*;

public class B_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        arr[0] = 0;
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long sum = 0;
        for (int i= 1; i<=N; i++) {
            sum += Math.abs(i-arr[i]);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
