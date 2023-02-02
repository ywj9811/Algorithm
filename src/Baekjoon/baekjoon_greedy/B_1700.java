package Baekjoon.baekjoon_greedy;

import java.util.Scanner;

public class B_1700 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();

        String[] firstSplit = firstInput.split(" ");
        String[] secondSplit = secondInput.split(" ");

        int multiTap = Integer.parseInt(firstSplit[0]);
        int totalUse = Integer.parseInt(firstSplit[1]);

        int[] productUse = new int[totalUse];

        for (int i = 0; i < totalUse; i++) {
            productUse[Integer.parseInt(secondSplit[i])-1]++;
        }
    }
}
