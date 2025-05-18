package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }

        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right)/2;
            long sum = Arrays.stream(nums)
                    .mapToLong(num -> {
                        int i = num - mid;
                        if (i < 0)
                            return 0;
                        return i;
                    })
                    .sum();
            if (sum < target) {
                right = mid-1;
                continue;
            }
            left = mid+1;
            result = mid;
        }

        System.out.println(result);
    }
}
