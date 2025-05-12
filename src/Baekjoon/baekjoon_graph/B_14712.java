package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_14712 {
    private static int n;
    private static int m;
    private static boolean[][] visited;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n][m];

        dfs(0, 0);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        if (x == n) {
            /**
             * 놓는 경우, 안놓는 경우 모두 포함해서 쭉 진행한 다음 종료지점에 도착하면 카운트
             * 만약 중간에 넴모가 만족되면 여기까지 도달하지 못할 것.
             *
             * 왼쪽 -> 오른쪽
             * 위 -> 아래
             * 이렇게 진행하기 때문에 마지막 줄을 넘어서게 되면 모든 칸을 탐색 완료한 것
             */
            cnt++;
            return;
        }

        int nextX = x;
        int nextY = y + 1;
        if (nextY == m) {
            nextX++;
            nextY = 0;
        }

        /**
         * 이번칸은 넴모를 두지 않고, 다음 칸으로 진행하기
         * 그냥 dfs진행
         */
        dfs(nextX, nextY);

        /**
         * 이번칸에 넴모를 두었을 떄 조건이 만족되는지 파악
         * 만약 조건을 만족하지 않는다면 (이번칸에 넴모를 두어도 괜찮다면)
         * 이번 칸을 넴모둘 둔 것으로 처리 (visited = true) 하고, 다음 칸으로 이동
         * 다음칸 이동이 마무리되면 (x == n)으로 dfs가 종료되면 이번 칸에 둔 것을 해제함 -> 두지 않는 경우는 위에서 이미 진행함
         */
        if (!isNemo(x, y)) {
            visited[x][y] = true;
            dfs(nextX, nextY);
            visited[x][y] = false;
        }
    }

    private static boolean isNemo(int x, int y) {
        if (x == 0 || y == 0)
            return false;
        return (visited[x - 1][y] && visited[x][y - 1] && visited[x - 1][y - 1]);
    }
}
