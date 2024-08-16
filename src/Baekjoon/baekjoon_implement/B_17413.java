package Baekjoon.baekjoon_implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stacks = new Stack<>();

        String input = br.readLine();
        String[] splits = input.split("");

        StringBuffer sb = new StringBuffer();
        boolean isTag = false;
        for (String split : splits) {
            if (isTag) {
                sb.append(split);
                if (split.equals(">"))
                    isTag = false;
                continue;
            }
            if (split.equals("<")) {
                isTag = true;
                while (!stacks.isEmpty()) {
                    String pop = stacks.pop();
                    sb.append(pop);
                }
                sb.append(split);
                continue;
            }
            if (split.equals(" ")) {
                while (!stacks.isEmpty()) {
                    String pop = stacks.pop();
                    sb.append(pop);
                }
                sb.append(split);
                continue;
            }
            stacks.push(split);
        }

        while (!stacks.isEmpty()) {
            String pop = stacks.pop();
            sb.append(pop);
        }

        System.out.println(sb);
    }
}
