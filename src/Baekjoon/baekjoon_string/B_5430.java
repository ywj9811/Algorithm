package Baekjoon.baekjoon_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_5430 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer;
        int testSize = Integer.parseInt(br.readLine());
        ArrayDeque<String> deque;
        for (int i = 0; i < testSize; i++) {
            deque = new ArrayDeque<>();

            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String inputValue = br.readLine();

            stringTokenizer = new StringTokenizer(inputValue, "[],");

            for (int j = 0; j < n; j++) {
                deque.add(stringTokenizer.nextToken());
            }

            extractFunction(function, deque);
        }

        System.out.println(sb);
    }

    public static void extractFunction(String function, Deque<String> deque) {

        boolean isRight = true;

        for (char cmd : function.toCharArray()) {

            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }
            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        getResult(deque, isRight);
    }

    public static void getResult(Deque<String> deque, boolean isRight) {
        sb.append('[');
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
}