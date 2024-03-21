package Baekjoon.baekjoon_math;

import java.util.Arrays;
import java.util.Scanner;

public class B_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int want = sc.nextInt();
        int[] num = new int[n+1];
        int[] answer = new int[n+1];
        Arrays.fill(answer, 0);

        for (int i = 1; i <= n; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            answer[i] = answer[i-1] + num[i];
        }

        for (int i = 0; i < want; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(answer[end] - answer[start-1]);
        }
    }
}
