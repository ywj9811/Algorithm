package Baekjoon.baekjoon_combination;

public class test1 {
    public static void main(String[] args) {
        int solution = solution(new int[]{0, 2, 1, 1, 0, 0, 4, 1, 0, 100, 5, 5});
        System.out.println(solution);
    }

    public static int solution(int[] a) {
        int n = a.length;
        int max = 0;
        int result = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int cur = a[i];

            if (cur != 0) {
                cnt++;
                max = Math.max(max, cur);
            }

            if (cur == 0 || i == n - 1) {
                if (cnt > 0) {
                    result = Math.max(result, max * cnt);
                    cnt = 0;
                    max = 0;
                }
            }
        }

        return result;
    }
}
