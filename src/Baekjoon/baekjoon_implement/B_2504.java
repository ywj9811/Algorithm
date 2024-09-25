package Baekjoon.baekjoon_implement;

import java.util.Scanner;
import java.util.Stack;

public class B_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int cnt =1;
        for(int i=0; i<input.length(); i++) {
            char cur = input.charAt(i);
            if(cur == '(') {
                stack.push(cur);
                cnt *= 2;
            }
            else if(cur == '[') {
                stack.push(cur);
                cnt *= 3;
            }
            else {
                if(cur == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    }
                    if(input.charAt(i-1) =='(') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 2;
                }else if(cur==']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    }
                    if(input.charAt(i-1)=='[') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                }
                else {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}
