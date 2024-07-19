package Baekjoon.baekjoon_implement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_14502 {
    private static int map[][];
    private static int restore[][];
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static int n;
    private static int m;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][m+1];
        restore = new int[n+1][m+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        wall(0);

        System.out.println(max);
    }

    private static void wall(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    wall(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int safe = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                restore[i][j] = map[i][j];
                if (restore[i][j] == 0) {
                    safe++;
                }
                if (restore[i][j] == 2)
                    queue.add(new int[]{i, j});
            }
        } // queue에 바이러스 위치 모두 담기
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
//            System.out.println("next");
            for (int i = 0; i < 4; i++) {
                if (a + dx[i] <= 0 || a + dx[i] > n || b + dy[i] <= 0 || b + dy[i] > m)
                    continue;
                if (restore[a+dx[i]][b+dy[i]] == 0) {
                    restore[a+dx[i]][b+dy[i]] = 2;
                    queue.add(new int[]{a + dx[i], b + dy[i]});
                    safe--;
                }
            }
        }

        if (safe > max) {
            max = safe;
        }
    }
}
