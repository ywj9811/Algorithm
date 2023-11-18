package SWEA;

import java.util.Scanner;

public class SW_5215 {
    /**
     *
     5 1000
     100 200
     300 500
     250 300
     500 1000
     400 400
     */
    static int max;
    static int[][] favorites;
    static int cnt;
    static int limit;
    static Scanner sc = new Scanner(System.in);


    static void dfs(int idx, int sum, int cal) {
        if (cal > limit)
            return;
        if (idx == cnt) {
            max = Math.max(max, sum);
            return;
        }
        dfs(idx+1, sum, cal);
        dfs(idx+1, sum + favorites[idx][0], cal + favorites[idx][1]);
    }

    static void init() {
        max = 0;
        cnt = sc.nextInt();
        limit = sc.nextInt();
        favorites = new int[cnt][2];
    }

    public static void main(String[] args) {
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            init();

            for (int i = 0; i < cnt; i++) {
                favorites[i][0] = sc.nextInt();
                favorites[i][1] = sc.nextInt();
            }

            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }
}
