package Baekjoon.baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_22862 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int oddCnt = 0;
        int maxLen = 0;

        while (right < n) {
            if (values[right] % 2 != 0) {
                oddCnt++;
            }

            while (oddCnt > k) {
                if (values[left] % 2 != 0) {
                    oddCnt--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, (right - left + 1) - oddCnt);

            right++;
        }

        // 3. 결과 출력
        System.out.println(maxLen);
    }
}