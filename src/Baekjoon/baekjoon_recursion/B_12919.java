package Baekjoon.baekjoon_recursion;

import java.util.*;

public class B_12919 {
    private static String target;
    private static boolean result = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.next();
        String start = sc.next();

        check(start);

        System.out.println(result ? 1 : 0);
    }

    private static void check(String start) {
        if (result)
            return;
        if (start.length() == target.length()) {
            if (start.equals(target))
                result = true;
            return;
        }
        if (start.startsWith("B")) {
            String reverse = new StringBuilder(start).reverse().toString();
            String next = reverse.substring(0, reverse.length() - 1);
            check(next);
        }
        if (start.endsWith("A")) {
            String next = start.substring(0, start.length() - 1);
            check(next);
        }
    }
}
