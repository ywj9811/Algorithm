package Programmers.cote;

import java.util.Scanner;

public class Permutation {
    static int[] permutation, arr;
    static boolean[] check;
    static int total,pick;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        total = in.nextInt();
        pick = in.nextInt();
        arr = new int[total];
        for(int i=0; i<total; i++) {
            arr[i] = in.nextInt();
        }
        check = new boolean[total];
        permutation = new int[pick];
        dfs(0);
    }

    static void dfs(int level) {
        if (level == pick) {
            for(int num : permutation) {
                System.out.print(num+" ");
            }
            System.out.println();
        } else {
            for(int i=0; i<total; i++) {
                if (!check[i]) {
                    check[i] = true;
                    permutation[level] = arr[i];
                    dfs(level+1);
                    check[i]=false;
                }
            }
        }
    }
}
