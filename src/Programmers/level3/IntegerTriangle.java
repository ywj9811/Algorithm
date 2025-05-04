package Programmers.level3;

public class IntegerTriangle {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println(solution);
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[triangle[i].length];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = triangle[i][j];
            }
        }
        for(int i = 0; i < triangle.length-1; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);

                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }

        int max = 0;
        for (int i = 0; i < triangle[triangle.length-1].length; i++) {
            max = Math.max(max, dp[triangle.length-1][i]);
        }
        return max;
    }
}
