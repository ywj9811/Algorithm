package Programmers.level2;

import java.util.*;

public class StockCalculate {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = n - 1 - pop;
        }

        return answer;
    }
}
