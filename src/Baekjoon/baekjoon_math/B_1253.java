package Baekjoon.baekjoon_math;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B_1253 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        int n = sc.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextLong();
        }

        Arrays.sort(numbers);

        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = n-1;
            long number = numbers[k];
            while (i < j) {
                if (number == numbers[i] + numbers[j]) {
                    if (i == k) {
                        i++;
                        continue;
                    }
                    if (j == k ) {
                        j--;
                        continue;
                    }
//                    System.out.println(number + " = " + numbers[i] + " , " + numbers[j]);
                    count++;
                    break;
                }
                if (number < numbers[i] + numbers[j]) {
                    j--;
                    continue;
                }
                i++;
            }
        }

        System.out.println(count);
    }
}
