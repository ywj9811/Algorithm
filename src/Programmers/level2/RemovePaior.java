package Programmers.level2;

import java.util.*;

public class RemovePaior {
    public static void main(String[] args) {
        int solution = solution("baabaa");
        System.out.println(solution);
    }
    

    public static int solution(String s) {
        String[] splits = s.split("");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < splits.length; i++) {
            if (stack.isEmpty()) {
                stack.push(splits[i]);
                continue;
            }

            String peek = stack.peek();
            if (peek.equals(splits[i])) {
                stack.pop();
                continue;
            }
            stack.push(splits[i]);
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
