package Baekjoon.baekjoon_array;

import java.util.Scanner;

public class B_13422 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt(); // testCase t개 진행

        for (int i = 0; i < t; i++) {
            thief();
        }
    }

    private static void thief() {
        int n = sc.nextInt(); // 집의 전체 개수
        int m = sc.nextInt(); // 연속된 집의 수
        int k = sc.nextInt(); // 최소 방범장치

        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }

        if (m == 1) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (house[i] < k) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            return;
        }

        if (n == m) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += house[i];
            }
            if (sum < k) {
                System.out.println(1);
                return;
            }
            System.out.println(0);
            return;
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += house[i];
        }
        int cnt = 0;
        if (sum < k) {
            cnt++;
        }

        for (int i = 0; i < n-1; i++) {
            sum -= house[i%n];
            sum += house[(i+m)%n];
            if (sum < k) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
