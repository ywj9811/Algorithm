package Programmers.level3;

import java.util.*;

public class NumberKey {
    private static Map<Integer, int[]> keyCoords = new HashMap<>(Map.of(
            1, new int[]{0,0}, 2, new int[]{0,1}, 3, new int[]{0,2},
            4, new int[]{1,0}, 5, new int[]{1,1}, 6, new int[]{1,2},
            7, new int[]{2,0}, 8, new int[]{2,1}, 9, new int[]{2,2},
            0, new int[]{3,1}
    ));
    private static final int[][] KEYPAD = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
    };
    private static int[][] dist = new int[10][10];
    private static Map<String, Integer> memo = new HashMap<>();
    private static String num;

    public static void main(String[] args) {
//        solution("1756"); // 출력: 10
//        System.out.println(solution("1756")); // 출력: 10
//        System.out.println("next");
        System.out.println(solution("5123")); // 출력: 8
    }

    public static int solution(String numbers) {
        num = numbers;

        // 1. 좌표 저장
        buildKeyCoords();

        // 2. 거리 전처리
        for (int i = 0; i < 10; i++) {
            dist[i] = bfs(i);
        }

        // 3. DP로 최솟값 계산 (시작은 왼손 4, 오른손 6)
        return dp(0, 4, 6);

    }

    private static void buildKeyCoords() {
        for (int i = 0; i < KEYPAD.length; i++) {
            for (int j = 0; j < KEYPAD[i].length; j++) {
                int val = KEYPAD[i][j];
                if (val != -1) {
                    keyCoords.put(val, new int[]{i, j});
                }
            }
        }
    }

    private static int[] bfs(int start) {
        int[] res = new int[10];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[start] = 0; // 제자리 비용

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int[] from = keyCoords.get(curr);

            for (int next = 0; next <= 9; next++) {
                int[] to = keyCoords.get(next);
                int cost = moveCost(from, to);
                if (res[next] > res[curr] + cost) { // 이미 res[curr]에 1 포함돼 있음
                    res[next] = res[curr] + cost;
                    queue.offer(next);
                }
            }
        }

        return res;
    }

    private static int moveCost(int[] from, int[] to) { // 이동할 때 사용되는 비용을 계산함
        int dx = Math.abs(from[0] - to[0]);
        int dy = Math.abs(from[1] - to[1]);
        if (dx == 0 && dy == 0)
            return 1;        // 제자리
        if ((dx == 1 && dy == 0) || (dx == 0 && dy == 1))
            return 2; // 상하좌우
        if (dx == 1 && dy == 1)
            return 3;        // 대각선
        return 2 * (dx + dy); // 멀리 떨어진 경우 (대충 큰 비용)
    }

    private static int dp(int index, int left, int right) {
        if (index == num.length())
            return 0;

        String key = index + "," + left + "," + right;
        if (memo.containsKey(key)) // 이미 계산이 된적 있는 위치라면
            return memo.get(key);

        int target = num.charAt(index) - '0';
        int result;

        if (target == left) {
            result = 1 + dp(index + 1, target, right);
        } else if (target == right) {
            result = 1 + dp(index + 1, left, target);
        } else {
            int moveLeft = dist[left][target] + dp(index + 1, target, right);
            int moveRight = dist[right][target] + dp(index + 1, left, target);
            result = Math.min(moveLeft, moveRight);
        }

        memo.put(key, result);
        System.out.println("key : " + key + " result : " + result);
        return result;
    }
}
