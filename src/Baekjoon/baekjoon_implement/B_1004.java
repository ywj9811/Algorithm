package Baekjoon.baekjoon_implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1004 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int t = sc.nextInt();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int check = check();
            results.add(check);
        }

        results.forEach(System.out::println);
    }

    private static int check() {
        int cnt = 0;

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int c3 = sc.nextInt();

            int len1 = (int) (Math.pow(c1 - a1, 2) + Math.pow(c2 - a2, 2));
            int len2 = (int) (Math.pow(c1 - b1, 2) + Math.pow(c2 - b2, 2));
            int len4 = c3 * c3;

            if (len1 < len4 && len2 < len4) {
                continue;
            }
            if (len1 < len4 || len2 < len4) {
                cnt++;
            }
        }

        return cnt;
    }
}
