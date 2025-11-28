package Baekjoon.baekjoon_greedy;

import java.util.Scanner;

public class B_1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T = sc.nextLine().trim();

        int idx = 0; // T의 현재 인덱스
        int N = 0;

        // T의 모든 문자를 순서대로 매칭될 때까지
        while (idx < T.length()) {
            N++;
            String s = String.valueOf(N);

            for (int i = 0; i < s.length(); i++) {
                if (idx < T.length() && s.charAt(i) == T.charAt(idx)) {
                    idx++;
                }
            }
        }

        System.out.println(N);
    }
}
