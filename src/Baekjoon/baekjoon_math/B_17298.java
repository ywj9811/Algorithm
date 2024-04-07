package Baekjoon.baekjoon_math;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> values = new Stack<>();
        int[] results = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        values.push(0);

        for (int i = 1; i < nums.length; i++) {
            while (!values.isEmpty() && nums[values.peek()] < nums[i]) {
                results[values.pop()] = nums[i];
            }
            values.push(i);
        }

        while (!values.isEmpty()) {
            results[values.pop()] = -1;
        }

        for (int i = 0; i < results.length; i++) {
            bw.write(results[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
