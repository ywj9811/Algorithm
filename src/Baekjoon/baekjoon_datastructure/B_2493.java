package Baekjoon.baekjoon_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        int[] nums = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i-1] = 0;
            } else {
                answer[i-1] = stack.peek();
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();

        for (int num : answer) {
            sb.append(num + " ");
        }

        System.out.println(sb);
    }
}
