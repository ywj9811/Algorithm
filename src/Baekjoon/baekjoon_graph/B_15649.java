package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_15649 {
    public static int[] arr;
    public static boolean[] visit;
    public static int n;
    public static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visit = new boolean[n];
        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}