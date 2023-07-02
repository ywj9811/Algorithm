package Baekjoon.baekjoon_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int nNum[] = new int[N];
        for (int i = 0; i < N; i++) {
            nNum[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nNum);

        int startIdx = 0;
        int endIdx = 1;
        int count = 0;

        while (startIdx < N-1) {
            if (nNum[startIdx] + nNum[endIdx] < M) {
                endIdx++;
                if (endIdx == N) {
                    startIdx++;
                    endIdx = startIdx+1;
                }
            } else if (nNum[startIdx] + nNum[endIdx] > M) {
                startIdx++;
                endIdx = startIdx+1;
            } else {
                count++;
                startIdx++;
                endIdx = startIdx+1;
            }
        }
        System.out.println(count);
    }
}
