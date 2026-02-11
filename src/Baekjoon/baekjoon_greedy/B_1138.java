package Baekjoon.baekjoon_greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (list.size() > arr[i-1]) {
                list.add(arr[i-1], i);
                continue;
            }
            list.add(i);
        }

        list.forEach(l -> System.out.print(l + " "));
    }
}
