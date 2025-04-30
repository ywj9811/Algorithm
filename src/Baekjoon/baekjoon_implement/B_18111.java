package Baekjoon.baekjoon_implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_18111 {
    private static int[][] board;
    private static int n;
    private static int m;
    private static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;

        for (int h = 0; h <= 256; h++) {
            int check = check(h);
            if (check < min || (check == min && h > height)) {
                min = check;
                height = h;
            }
        }

        System.out.println(min + " " + height);
    }

    private static int check(int cur) {
        int down = 0;
        int up = 0;
        int bag = b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > cur) {
                    down += board[i][j] - cur;
                } else {
                    up += cur - board[i][j];
                }
            }
        }
        bag += down;
        if (bag >= up) {
            return (2*down + up);
        }
        return Integer.MAX_VALUE;
    }
}