package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_2110 {
    private static int n;
    private static int c;
    private static int[] houses;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();

        houses = new int[n];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);

        int left = 1;
        int right = houses[n-1] - houses[0];
        if (c == 2) {
            System.out.println(right);
            return;
        }
        int max = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                max = mid;
                continue;
            }
            right = mid-1;
        }

        System.out.println(max);
    }

    private static boolean check(int mid) {
        int lastIdx = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (houses[lastIdx] + mid <= houses[i]) {
                lastIdx = i;
                cnt++;
            }
        }
        if (cnt >= c)
            return true;
        return false;
    }
}
