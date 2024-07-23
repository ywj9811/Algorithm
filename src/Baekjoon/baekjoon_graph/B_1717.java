package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_1717 {
    private static int[] nodes;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        nodes = new int[n+1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int check = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (check == 0) {
                union(a, b);
                continue;
            }


            if (find(a) == find(b)) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
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
