package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        int a = 0;
        int b = n-1;

        while (a < b) {
            if (num[a] + num[b] < m) {
                a++;
                continue;
            }
            if (num[a] + num[b] == m) {
                cnt++;
                a++;
                continue;
            }
            b--;
        }

        System.out.println(cnt);
    }
}
