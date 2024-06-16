package Baekjoon.baekjoon_recursion;

import java.util.Scanner;

public class B_2023 {
    private static int count = 0;
    private static int input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        /**
         * 2
         * 3
         * 5
         * 7
         * 뒤에 숫자를 넣어가며 input만큼 길이가 될 때 까지 반복, 소수가 아니면 해당 숫자는 진행 X
         */
    }

    private static void dfs(int number, int depth) {
        if (depth > input) {
            System.out.println(number);
            count++;
            return;
        }
//        System.out.println("number : " + number + " depth : " + depth);
        boolean sosu = true;
        for (int i = 1; i < 10; i++) {
            int nextNumber = number*10 + i;
//            System.out.println("number : " + number);
            for (int j = 2; j <= (int) Math.sqrt(number); j++) {

                if (number % j == 0) {
                    sosu = false;
                    break;
                }
            }
            if (sosu) {
                if (depth == input) {
                    System.out.println(number);
                    count++;
                    return;
                }
                dfs(nextNumber, depth+1);
            }
        }
    }
}
