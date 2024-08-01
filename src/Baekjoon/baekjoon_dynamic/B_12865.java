package Baekjoon.baekjoon_dynamic;

import java.util.Scanner;

public class B_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int w = sc.nextInt();

        int dp[] = new int[w+1];
        int update[] = new int[w+1];
        int ob[][] = new int[c][2];

        for (int i = 0; i < c; i++) {
            ob[i][0] = sc.nextInt();
            ob[i][1] = sc.nextInt();
            for (int j = 0; j <= w - ob[i][0]; j++) {
                dp[j + ob[i][0]] = Math.max(update[j + ob[i][0]], update[j] + ob[i][1]);
//                System.out.println("이번에는 : " + (j+ob[i][0]));
//                System.out.println(dp[j+ob[i][0]]);
            }
            for (int k = 0; k <= w; k++) {
                update[k] = dp[k];
            }
        }

        System.out.println(dp[w]);
    }
}
