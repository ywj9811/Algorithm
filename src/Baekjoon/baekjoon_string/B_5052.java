package Baekjoon.baekjoon_string;

import java.util.Arrays;
import java.util.Scanner;

public class B_5052 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            check(sc.nextInt());
        }
    }

    private static void check(int size) {
        String[] nums = new String[size];
        for (int i = 0; i < size; i++) {
            String num = sc.next();
            nums[i] = num;
        }
        Arrays.sort(nums);
        for (int i = 0; i < size-1; i++) {
            if (nums[i+1].startsWith(nums[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
