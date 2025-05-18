package Baekjoon.baekjoon_math;

import java.util.*;

public class B_3020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] up = new int[n/2];
        int[] down = new int[n/2];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                down[i/2] = sc.nextInt(); // 아래에서 올라오는 석순
            else
                up[i/2] = sc.nextInt();   // 위에서 내려오는 종유석
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= h; i++) {
            int downCrash = down.length - lowerBound(down, i);
            int upCrash = up.length - lowerBound(up, h - i + 1);
            int totalCrash = downCrash + upCrash;

            if (totalCrash == min) {
                count++;
            } else if (totalCrash < min) {
                min = totalCrash;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }

    private static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= key)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
}
