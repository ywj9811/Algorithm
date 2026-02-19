package Programmers.level2;

public class Fatigue {
    private int max = 0;
    private boolean visited[] = new boolean[8];

    public static void main(String[] args) {
        int solution = new Fatigue().solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(solution);
    }

    public int solution(int k, int[][] dungeons) {
        recursive(k, 0, dungeons);
        return max;
    }

    private void recursive(int k, int cnt, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            if (k >= dungeons[i][0]) {
                max = Math.max(cnt+1, max);
                recursive(k-dungeons[i][1], cnt+1, dungeons);
            }
            visited[i] = false;
        }
    }
}
