package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long cnt = 0;

        long[] num = new long[n];
        long[] sum = new long[n];
        long[] sames = new long[m];
        Arrays.fill(sames, 0);

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextLong();
        }
        sum[0] = num[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + num[i];
        }

        for (int i = 0; i < n; i++) {
            sum[i] %= m;
            if (sum[i] == 0)
                cnt++;
        }

        for (int i = 0; i < n; i++) {
            sames[(int) sum[i]]++;
        }

        for (long same : sames) {
            cnt += (same*(same-1))/2;
        }

        System.out.println(cnt);
    }
}
