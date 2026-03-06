package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_2230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;

        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        Arrays.sort(values);

        while (left <= right) {
            int result = values[right] - values[left];
            if (result >= m) {
                min = Math.min(result, min);
                if (left < right) {
                    left++;
                } else {
                    right++;
                }
            } else {
                right++;
            }
            if (left >= n || right >= n) break;
        }

        System.out.println(min);
    }
}
