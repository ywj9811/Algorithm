package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_10687 {
    private static Egg[] nums;
    private static int n;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new Egg[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nums[i] = new Egg(a, b);
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int now, int cnt) {
        if (now == n-1) {
            max = Math.max(max, cnt);
            return;
        }
        if (nums[now].dur <= 0) {
            dfs(now+1, cnt);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i != now && nums[i].dur > 0) {
                int next = cnt;
                nums[now].dur -= nums[i].wei;
                nums[i].dur -= nums[now].wei;

                if (nums[now].dur <= 0)
                    next++;
                if (nums[i].dur <= 0)
                    next++;

                dfs(now+1, next);
                nums[now].dur += nums[i].wei;
                nums[i].dur += nums[now].wei;
            }
        }
    }

    private static class Egg {
        int dur;
        int wei;

        public Egg(int dur, int wei) {
            this.dur = dur;
            this.wei = wei;
        }
    }
}
