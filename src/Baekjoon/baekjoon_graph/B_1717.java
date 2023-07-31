package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_1717 {
    static int[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        nodes = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int isUnion = sc.nextInt();
            int first = sc.nextInt();
            int second = sc.nextInt();

            if (isUnion == 0) {
                union(first, second);
                continue;
            }
            if (find(first) == find(second)) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    private static void union(int first, int second) {
        first = find(first);
        second = find(second);

        if (first != second)
            nodes[second] = first;
    }

    private static int find(int value) {
        if (value == nodes[value])
            return value;
        nodes[value] = find(nodes[value]);
        return nodes[value];
    }
}
