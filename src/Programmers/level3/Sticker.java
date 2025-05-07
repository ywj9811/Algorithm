package Programmers.level3;

public class Sticker {
    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 4});
        System.out.println(solution);
    }

    private static int solution(int[] sticker) {
        int n = sticker.length;

        if (n == 1)
            return sticker[0];

        /**
         * 0번째를 선택하는 경우
         */
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        /**
         * dp[0]은 본인
         * dp[1]은 sticker[0] vs sticker[1] 중 큰 값.
         * 왜냐하면 dp[1]은 본인을 선택하는 경우 vs 본인을 선택하지 않고, +1번째 값을 허용하는 경우 이렇게 있기 때문에 더 큰 값을 허용
         * 이어서 쭉 가게되면 dp[n] = Math.max(dp[n-1], dp[n-2] + sticker[n])
         * 이렇게 하게 된다면, dp[n-1]은 이번에 선택하지 않고 진행하는 경우가 될 것이고, dp[n-2] + sticker[n]은 이번에 선택하는 경우가 될 것
         * 이를 통해서 현재 위치까지 올 때 가장 큰 값을 알 수 있을 것.
         */
        for (int i = 2; i < n - 1; i++) { // dp1의 경우 0번째를 선택했기 때문에 마지막idx는 사용할 수 없음. 원형을 선형으로 나타냈기 때문
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        /**
         * n-1번째를 선택하는 경우
         */
        int[] dp2 = new int[n];
        dp2[0] = 0; // 첫 번째 사용 안 함
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
