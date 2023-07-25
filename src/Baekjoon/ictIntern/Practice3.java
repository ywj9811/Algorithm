package Baekjoon.ictIntern;

import java.util.Scanner;

public class Practice3 {
    /**
     * 품질 대리인은 생산 라인에서 완제품 샘플 검사를 담당합니다. 각 표본에는 각각 1과 0으로 표시되는 불량품과 양품이 포함됩니다.
     * 제품 샘플은 2차원 정사각형 매트릭스에 순차적으로 배치됩니다. 목표는 2차원 정사각 행렬에서 불량 제품의 가장 큰 제곱의 크기를 결정하는 것입니다.
     *
     * 예
     * n x n = 5 x 5 제품 샘플의 매트릭스 샘플 = [[1,1,1,1,1], [1,1,1,0,0], [1,1,1,0,0], [1,1,1,0,0], [1,1,1,1,1]]
     *
     * 결함 제품의 첫 번째 제곱은 (0,0)에서 시작하여 (3,3)에서 끝나는 하위 행렬 3 x 3입니다.
     * 불량 제품의 두 번째 제곱도 (1,0)에서 시작하여 (4,3)에서 끝나는 하위 행렬 3 x 3입니다.
     * 불량 제품의 세 번째 제곱도 (2,0)에서 시작하여 (5,3)에서 끝나는 하위 행렬 3 x 3입니다.
     * 불량품의 가장 큰 제곱의 크기는 3입니다.
     *
     * 기능 설명
     * 아래 편집기에서 findLargestSquareSize 함수를 완성하십시오.
     * findLargestSquareSize에는 다음 매개변수가 있습니다. int samples[n][n]: 정수의 2차원 배열
     *
     * 반품
     * int: 결함 제품의 가장 큰 정사각 부분행렬의 크기를 나타내는 정수.
     *
     * 제약
     * 0 ≤ n ≤ 500 샘플[i][j]는 세트 {0, 1}에 있습니다(0은 양품, 1은 불량품을 나타냄).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int[][] box = new int[first][second];

        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        int maxSize = getMaxSize(box);

        System.out.println(maxSize);
    }

    static int getMaxSize(int[][] box) {
        int[][] dp = new int[box[0].length+1][box[1].length+1];
        int maxSize = 0;

        for (int i = 0; i < box[0].length; i++) {
            for (int j = 0; j < box[1].length; j++) {
                if (box[i][j] == 1)
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                maxSize = Math.max(maxSize, dp[i+1][j+1]);
            }
        }

        return maxSize;
    }
}
