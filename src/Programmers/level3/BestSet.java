package Programmers.level3;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        solution(2, 1);
    }

    public static int[] solution(int n, int s) {
        int x = s / n;
        int y = s % n;
        if (x == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[n];

        for (int i = 0; i < n - y; i++) {
            answer[i] = x;
        }
        for (int i = n-y; i < n; i++) {
            answer[i] = x+1;
        }

        Arrays.stream(answer).forEach(System.out::println);

        return answer;
    }
}
