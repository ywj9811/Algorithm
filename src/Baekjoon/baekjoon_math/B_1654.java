package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int total = sc.nextInt();
        long result = 0;

        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }

        long left = 1;
        long right = max;

        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;
            for (int num : nums) {
                count += num/mid;
            }
            if (count >= total) {
                left = mid+1;
                result = mid;
            } else {
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}
