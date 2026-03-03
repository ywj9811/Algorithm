package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        int left = 0;
        int right = n-1;
        int sum = Integer.MAX_VALUE;
        int resultL = 0;
        int resultR = n-1;
        Arrays.sort(value);
        while (left < right) {
            int temp = value[left] + value[right];
            if (Math.abs(temp) < Math.abs(sum)) {
                resultL = left;
                resultR = right;
                sum = temp;
            }
            if (temp == 0) {
                break;
            }
            if (temp < 0) {
                left++;
                continue;
            }
            right--;
        }
        System.out.println(value[resultL] + " " + value[resultR]);
    }
}
