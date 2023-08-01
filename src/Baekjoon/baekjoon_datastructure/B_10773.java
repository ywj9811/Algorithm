package Baekjoon.baekjoon_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> result = new Stack<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                result.push(input);
                sum += input;
            }
            else {
                sum -= result.pop();
            }
        }

        System.out.println(sum);
    }
}
