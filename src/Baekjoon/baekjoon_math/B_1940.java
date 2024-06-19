package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int count = 0;

        Arrays.sort(numbers);

        int start = 0;
        int end = n-1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < m) {
                start++;
                continue;
            }
            if (sum > m) {
                end--;
                continue;
            }
            count++;
            start++;
        }

        System.out.println(count);
    }
}
