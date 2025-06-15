package Programmers.cote;

import java.util.*;

public class Test1 {
    public static boolean solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int num = 1; // 1부터 N까지 순서대로 push
        int idx = 0; // arr의 현재 위치

        while (num <= n || !stack.isEmpty()) {
            // stack의 top이 arr[idx]와 같으면 pop
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
            }
            // 아니라면 push 진행 (num이 n 이하일 때만)
            else if (num <= n) {
                stack.push(num++);
            }
            // push도 못하고 pop도 못하면 불가능
            else {
                return false;
            }
        }

        return true;
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2})); // true
        System.out.println(solution(new int[]{3, 1, 2})); // false
    }
}
