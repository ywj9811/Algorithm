package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int goal = sc.nextInt();

        int[] nums = new int[total];

        for (int i = 0; i < total; i++) {
            nums[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int cur = 0;

        while (true) {
            if (cur >= goal) {
                cur -= nums[start++];
            } else if (end == total) {
                break;
            } else {
                cur += nums[end++];
            }

            if (cur == goal) {
                cnt++;
            }
        }


        System.out.println(cnt);
    }
}
