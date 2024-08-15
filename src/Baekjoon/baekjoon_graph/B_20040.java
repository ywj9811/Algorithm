package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_20040 {
    private static int[] node;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        node = new int[n];
        for (int i = 0; i < n; i++) {
            node[i] = i;
        }

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();

            boolean union = union(input1, input2);
            if (union) {
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(0);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return true;

        node[b] = a;
        return false;
    }

    private static int find(int a) {
        if (node[a] == a)
            return a;
        return node[a] = find(node[a]);
    }
}
