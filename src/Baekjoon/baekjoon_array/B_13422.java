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

    /**
     * 원형 슬라이딩 윈도우의 경우, %연산을 활용하면 쉽게 돌아올 수 있음!!
     * 0%n = 0 이니까, 0부터 시작하고
     * n-1%n = n-1이니까, n-1부터 시작할 수 있음
     * ((n-1)+1)%n = 0 이니까, 다시 0으로 돌아올 수 있음
     */
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
