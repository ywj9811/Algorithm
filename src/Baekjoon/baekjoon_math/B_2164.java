package Baekjoon.baekjoon_math;

import java.util.*;

public class B_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new LinkedList<>();

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        while (nums.size() > 1) {
            nums.remove(0);
            nums.add(nums.remove(0));
        }

        System.out.println(nums.get(0));
    }
}
