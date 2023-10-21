package SWEA;

import java.util.Scanner;

public class SW_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            // n만큼 반복해서 오른쪽으로
            // n-1만큼 아래로, n-1만큼 왼쪽으로
            // n-2만큼 위로, n-2만큼 오른쪽
            // n-3만큼 아래, n-3만큼 왼쪽
            // n-4만큼 위로, n-4만큼 오른쪽
            matrix = getMatrix(n, matrix);
            System.out.println("#"+test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static int[][] getMatrix(int n, int[][] matrix) {
        int value = 1;
        for (int i = 0; i < n; i++) {
            matrix[0][i] = value++;
        }
        int[] down = {n-1, n};
        int[] up = {n-1, n-1};
        while (value <= n*n) {
            for (int i = n - down[0]; i < down[1]; i++) {
                matrix[i][down[1]-1] = value++;
            }
            for (int i = down[0]; i > n - down[1]; i--) {
                matrix[down[1]-1][i-1] = value++;
            }
            down[1] = down[0];
            down[0]--;
            if (value > n*n)
                break;
            for (int i = up[0]; i > n - up[1]; i--) {
                matrix[i-1][n-1-up[1]] = value++;
            }
            for (int i = n - up[0]; i < up[1]; i++) {
                matrix[n-up[1]][i] = value++;
            }
            up[0]--;
            up[1]--;
        }
        return matrix;
    }
}
