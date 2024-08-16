package Baekjoon.baekjoon_implement;

import java.util.Scanner;

public class B_14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int n = sc.nextInt();

        int numbers[] = new int[n];

        int left = 0;
        int right = n-1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int leftMax = numbers[left];
        int rightMax = numbers[right];

        while (left <= right) {
            if (leftMax <= rightMax) {
                if (leftMax > numbers[left]) {
                    sum += (leftMax - numbers[left]);
                } else {
                    leftMax = numbers[left];
                }
                left++;
            } else {
                if (rightMax >= numbers[right]) {
                    sum += (rightMax - numbers[right]);
                } else {
                    rightMax = numbers[right];
                }
                right--;
            }
        }
        System.out.println(sum);

    }
}
