package Baekjoon.baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_3273 {
    private static int count = 0;
    private static int[] numbers;
    private static int target;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);
        target = Integer.parseInt(br.readLine());

        check(0, n-1);

        System.out.println(count);
    }

    private static void check(int one, int two) {
        if (two < 0 || one == n || one == two)
            return;
        int sum = numbers[one] + numbers[two];
        if (sum > target) {
            check(one, two - 1);
            return;
        }
        if (sum == target) {
            count++;
            check(one, two-1);
            return;
        }
        check(one+1, two);
    }
}
