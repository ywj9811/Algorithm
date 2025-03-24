package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_14888 {
    private static int[] op = new int[4];
    private static int[] nums;
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int depth) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                if (check(i)) {
                    op[i]--;
                    dfs(num + nums[depth], depth+1);
                    op[i]++;
                }
            }
            if (i == 1) {
                if (check(i)) {
                    op[i]--;
                    dfs(num - nums[depth], depth+1);
                    op[i]++;
                }
            }
            if (i == 2) {
                if (check(i)) {
                    op[i]--;
                    dfs(num * nums[depth], depth+1);
                    op[i]++;
                }
            }
            if (i == 3) {
                if (check(i)) {
                    op[i]--;
                    dfs(num / nums[depth], depth+1);
                    op[i]++;
                }
            }
        }
    }

    private static boolean check(int idx) {
        if (op[idx] > 0)
            return true;
        return false;
    }
}
