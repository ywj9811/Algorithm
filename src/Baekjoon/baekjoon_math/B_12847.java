package Baekjoon.baekjoon_math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_12847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = 0;

        List<Integer> values = new ArrayList<>();

        int total = sc.nextInt();
        int possible = sc.nextInt();

        for (int i = 0; i < total; i++) {
            values.add(sc.nextInt());
        }

        int s = 0;
        int e = possible - 1;
        for (int i = s; i <= e; i++) {
            sum += values.get(i);
        }
        long max = sum;
        e++;

        while (e < total) {
            sum -= values.get(s);
            sum += values.get(e);
            if (sum > max) {
                max = sum;
            }
            e++;
            s++;
        }

        System.out.println(max);
    }
    /**
     * 5 3 급여 개수, 일할 수 있는 날
     * 10 20 30 20 10 -> 20 30 20 = 70이 가장 높음
     */
}
