package SWEA;

import java.util.Scanner;

public class SW_2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String input = sc.next();
            for (int j = 1; j <= 10; j++) {
                boolean isTrue = true;
                String sub = input.substring(0, j);
                for (int k = 0+j; k+j < input.length(); k += j) {
                    if (!input.substring(k, k+j).equals(sub)) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue) {
                    System.out.println("#" + i + " " + sub.length());
                    break;
                }
            }
        }
    }
}
