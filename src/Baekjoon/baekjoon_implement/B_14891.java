package Baekjoon.baekjoon_implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class B_14891 {
    private static Map<Integer, int[]> wheels = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <=4; i++) {
            String input = sc.next();
            String[] numbers = input.split("");
            wheels.put(i, new int[]{parseInt(numbers[0]), parseInt(numbers[1]), parseInt(numbers[2]), parseInt(numbers[3]), parseInt(numbers[4]), parseInt(numbers[5]), parseInt(numbers[6]), parseInt(numbers[7])});
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            int dir = sc.nextInt();
            int[] origin = rotation(target, dir);
            if (target - 1 > 0) {
                int[] leftNumbers = wheels.get(target - 1);
                if (leftNumbers[2] != origin[6])
                    left(target-1, dir*(-1));
            }
            if (target + 1 < 5) {
                int[] rightNumbers = wheels.get(target + 1);
                if (rightNumbers[6] != origin[2])
                    right(target+1, dir*(-1));
            }
        }

        int[] first = wheels.get(1);
        int[] second = wheels.get(2);
        int[] third = wheels.get(3);
        int[] fourth = wheels.get(4);
        int f = first[0];
        int s = second[0];
        int t = third[0];
        int fo = fourth[0];
        System.out.println(f + s*2 + t*4 + fo*8);
    }

    private static void left(int target, int dir) {
        int[] tmp = rotation(target, dir);
        if (target - 1 == 0)
            return;
        int[] nextNumbers = wheels.get(target - 1);
        if (nextNumbers[2] == tmp[6])
            return;
        left(target-1, dir*(-1));
    }

    private static void right(int target, int dir) {
        int[] tmp = rotation(target, dir);
        if (target + 1 == 5)
            return;
        int[] nextNumbers = wheels.get(target + 1);
        if (nextNumbers[6] == tmp[2])
            return;
        right(target+1, dir*(-1));
    }

    private static int[] rotation(int target, int dir) {
        int[] tmp = new int[8];
        int[] numbers = wheels.get(target);
        for (int i = 0; i < 8; i++) {
            tmp[i] = numbers[i];
        }
        if (dir == 1) {
            for (int i = 0; i < 7; i++) {
                numbers[i+1] = tmp[i];
            }
            numbers[0] = tmp[7];
        } else {
            for (int i = 0; i < 7; i++) {
                numbers[i] = tmp[i+1];
            }
            numbers[7] = tmp[0];
        }
        wheels.put(target, numbers);
        return tmp;
    }
}
