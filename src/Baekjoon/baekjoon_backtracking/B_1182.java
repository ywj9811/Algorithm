package Baekjoon.baekjoon_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1182 {
    private static int n;
    private static int s;
    private static int cnt = 0;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(cnt);
    }

    private static void dfs(int start, int sum) {
        if (start != 0 && sum == s) {
            cnt++;
        }

        for (int i = start; i < n; i++) {
            dfs(i+1, sum + nums[i]);
        }
    }
}
