package Baekjoon.baekjoon_greedy;

import java.util.Scanner;

public class B_15904 {
    private static Scanner scanner = new Scanner(System.in);
    private static char[] ucpc = {'U','C','P','C'};

    public static void main(String[] args) {
        String input = scanner.nextLine();
        int idx = checkUCPC(input);
        if (idx > 3) {
            System.out.println("I love UCPC");
            return;
        }
        System.out.println("I hate UCPC");
    }

    public static int checkUCPC(String input) {
        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ucpc[idx]) {
                idx++;
            }
            if (idx > 3)
                break;
        }
        return idx;
    }
}
