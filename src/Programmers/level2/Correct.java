package Programmers.level2;

import java.util.*;

public class Correct {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char split : s.toCharArray()) {
            if (split == ')') {
                if (stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if (pop == ')')
                    return false;
                continue;
            }
            stack.push(split);
        }

        return stack.isEmpty();
    }
}
