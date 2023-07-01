package Baekjoon.baekjoon_array;

import java.util.Scanner;

public class B_2018 {
    public static void main(String[] args) {
        /**
         * n 입력 연속된 정수의 합으로 나타낼때 몇개 가능
         */
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0;
        int sum;
        int start = 0;
        int end = 0;
        int inputArray[] = new int[input];
        for (int i = 0; i < input; i++) {
            inputArray[i] = i+1;
        }

        while (end <= input) {
            sum = 0;
            for (int i = start; i < end; i++) {
                sum += inputArray[i];
            }
            if (sum == input) {
                count++;
                end++;
            }
            if (sum < input) {
                end++;
            }
            if (sum > input) {
                start++;
            }
        }

        System.out.println(count);
    }
}
