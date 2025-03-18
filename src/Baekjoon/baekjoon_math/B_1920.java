package Baekjoon.baekjoon_math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_1920 {
    /**
     * 5
     * 4 1 5 2 3
     * 5
     * 1 3 7 9 5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            data.add(sc.nextInt());
        }
        int cnt = sc.nextInt();
        List<Integer> goals = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            goals.add(sc.nextInt());
        }

        Collections.sort(data);

        for (int goal : goals) {
            int check = data.size() / 2;
            while (check != 0) {
                if (data.get(check) == goal) {
                    System.out.println(1);
                    break;
                }
                if (data.get(check) > goal) {
                    check /= 2;
                }
            }
        }
    }
}
