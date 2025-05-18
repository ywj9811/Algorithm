package Baekjoon.baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_10815 {
    private static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int tc = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tc; i++) {
            boolean check = checkNumber(Integer.parseInt(st.nextToken()));
            if (check) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }

    private static boolean checkNumber(int check) {
        int left = 0;
        int right = cards.length-1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (cards[mid] < check) {
                left = mid+1;
                continue;
            }
            if (cards[mid] > check) {
                right = mid-1;
                continue;
            }
            if (cards[mid] == check)
                return true;
        }

        return false;
    }
}
