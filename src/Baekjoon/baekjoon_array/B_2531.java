package Baekjoon.baekjoon_array;

import java.util.*;

public class B_2531 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[] dishes = new int[n];
        int[] sushi = new int[d+1];
        int cnt = 1;
        sushi[c]++;

        for (int i = 0; i < n; i++) {
            dishes[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int dish = dishes[i];
            if (sushi[dish] == 0) {
                cnt++;
            }
            sushi[dish]++;
        }

        int max = cnt;

        for (int i = k; i < n; i++) {
            int dish = dishes[i - k];
            sushi[dish]--;
            if (sushi[dish] == 0)
                cnt--;
            dish = dishes[i];
            sushi[dish]++;
            if (sushi[dish] == 1)
                cnt++;
            max = Math.max(cnt, max);
        }

        for (int i = 0; i < k; i++) {
            int dish = dishes[n - k + i];
            sushi[dish]--;
            if (sushi[dish] == 0)
                cnt--;
            dish = dishes[i];
            sushi[dish]++;
            if (sushi[dish] == 1)
                cnt++;
            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}
