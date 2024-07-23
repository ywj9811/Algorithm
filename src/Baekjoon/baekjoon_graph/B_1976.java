package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_1976 {
    private static int[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        nodes = new int[n+1];
        for (int i = 1 ; i <= n; i++) {
            nodes[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int check = sc.nextInt();
                if (check == 1) {
                    union(i, j);
                }
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int result = find(sc.nextInt());
            results.add(result);
        }

        for (int i = 1; i < results.size(); i++ ){
            if (results.get(i-1) != results.get(i)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int a, int b) {
        int first = find(a);
        int second = find(b);
        if (first != second)
            nodes[second] = first;
    }

    private static int find(int a) {
        if (nodes[a] == a)
            return a;
        return nodes[a] = find(nodes[a]);
    }
}
