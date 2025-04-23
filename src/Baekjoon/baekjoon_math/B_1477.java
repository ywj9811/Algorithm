package Baekjoon.baekjoon_math;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_1477 {
    private static List<Integer> nodes = new ArrayList<>();
    private static List<Integer> values = new ArrayList<>();
    private static int N;
    private static int M;
    private static int L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        nodes.add(0);
        nodes.add(L);
        for (int i = 0; i < N; i++) {
            nodes.add(sc.nextInt());
        }
        Collections.sort(nodes);

        for (int i = 0; i < nodes.size()-1; i++) {
            values.add(nodes.get(i+1) - nodes.get(i));
        }

        int left = 1;
        int right = L-1;
        int cnt = 0;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int finalMid = mid;
            cnt = values.stream().mapToInt(value -> (value-1) / finalMid).sum();
            if (cnt <= M) {
                right = mid-1;
                continue;
            }
            left = mid+1;
        }
        System.out.println(left);
    }
}
