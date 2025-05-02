package Programmers.cote;

import java.util.Stack;

public class StackCote {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2}));
        System.out.println(solution(new int[]{1,3,2}));
    }

    public static boolean solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int current = 1; // 오름차순 입력 시작
        int idx = 0;     // arr의 현재 위치

        while (current <= arr.length || !stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
                continue;
            }
            if (current <= arr.length) {
                stack.push(current++);
                continue;
            }
            return false; // 더 이상 넣을 수 없고, 스택 top도 원하는 값 아님

        }

        return true;

    }
}