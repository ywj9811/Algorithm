package Baekjoon.baekjoon_combination;

import java.util.Scanner;

public class B_13251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] colors = new int[n];
        double[] prob = new double[n];
        int total = 0;

        for (int i = 0 ; i < n; i++) {
            colors[i] = sc.nextInt();
            total += colors[i];
        }

        int k = sc.nextInt();

        double result = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] > k) {
                prob[i] = 1.0;
                for (int j = 0; j < k; j++) {
                    prob[i] *= (double) (colors[i] - j) / (total - k);
                }
                result += prob[i];
            }
        }

        System.out.println(result);
    }
}
