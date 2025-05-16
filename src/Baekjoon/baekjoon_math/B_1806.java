package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_1806 {
    private static int nums[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        nums = new int[n];
        int size = Integer.MAX_VALUE;
        nums[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
//                    System.out.println("start : " + start + " end : " + i + " : " + sum);
                size = Math.min(size, (i - start + 1));
                sum -= nums[start];
                start++;
            }
        }

        if (size == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(size);
    }
}
