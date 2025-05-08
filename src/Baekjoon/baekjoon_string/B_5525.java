package Baekjoon.baekjoon_string;

import java.util.Scanner;

public class B_5525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = sc.nextInt();
        String[] pn = new String[2*n+1];
        for (int i = 0; i < pn.length; i++) {
            if (i%2 == 0) {
                pn[i] = "I";
                continue;
            }
            pn[i] = "O";
        }
        String input = sc.next();
        String[] s = input.split("");

        int start = 0;
        int cnt = 0;

        while (start + pn.length <= length) {
            boolean equal = true;

            for (int i = start; i < (start + pn.length); i++) {
                if (!s[i].equals(pn[i-start])) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                cnt++;
            }
            start++;
        }

        System.out.println(cnt);
    }
}
