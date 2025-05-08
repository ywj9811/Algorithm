package Baekjoon.baekjoon_array;

import java.util.Scanner;

public class B_21921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = 0;
        int start = 0;

        for (int i = start; i < start+m; i++) {
            sum += nums[i];
        }
        int max = sum;
        int cnt = 1;

        while (true) {
            sum -= nums[start];
            start++;
            if (start+(m-1) == n)
                break;
            sum += nums[start+(m-1)];
            if (max < sum) {
                max = sum;
                cnt = 1;
                continue;
            }
            if (max == sum) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}
