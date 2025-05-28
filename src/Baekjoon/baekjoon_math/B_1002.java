package Baekjoon.baekjoon_math;

import java.util.Scanner;

public class B_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            double r = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

//            System.out.println("r : " + r);
//            System.out.println("r1 + r2 : " + (r1+r2));
//            System.out.println("r + Math.min(r1, r2) : " + (r+Math.min(r1, r2)));
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
                continue;
            }
            if (r > r1+r2) {
                System.out.println(0);
                continue;
            }
            if (r == r1+r2) {
                System.out.println(1);
                continue;
            }
            if (r < r1+r2 && r+Math.min(r1, r2) > Math.max(r1, r2)) {
                System.out.println(2);
                continue;
            }
            if (r+Math.min(r1, r2) == Math.max(r1, r2)) {
                System.out.println(1);
                continue;
            }
            if (r+Math.min(r1, r2) < Math.max(r1, r2)) {
                System.out.println(0);
            }
        }
    }
}
