package Baekjoon.baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1253 {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int goal;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int a = 0;
        int b = n-1;
        goal = n-1;

        while (goal >= 0) {
            if (a == goal) {
                a++;
                continue;
            }
            if (b == goal) {
                b--;
                continue;
            }
            if (a == b) {
                goal--;
                a = 0;
                b = n-1;
                continue;
            }
            if (nums[a] + nums[b] == nums[goal]) {
                cnt++;
                goal--;
                a = 0;
                b = n-1;
                continue;
            }
            if (nums[a] + nums[b] < nums[goal]) {
                a++;
                continue;
            }
            b--;
        }

        System.out.println(cnt);
    }
}
