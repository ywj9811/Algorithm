package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_16562 {
    private static int parent[];
    private static int want[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int money = sc.nextInt();

        parent = new int[n+1];
        want = new int[n+1];

        for (int i = 1; i < want.length; i++) {
            want[i] = sc.nextInt();
            parent[i] = i;
        }

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            checkWant(a, b);
        }

        for (int i = 1; i < parent.length; i++) {
            find(i);
        }

        List<Integer> roots = new ArrayList<>();
        for (int root : parent) {
            if (roots.contains(root) || root == 0)
                continue;
            roots.add(root);
        }

        int need = 0;

        for (int root : roots) {
            need += want[root];
        }

        if (need > money) {
            System.out.println("Oh no");
            return;
        }
        System.out.println(need);
    }

    private static void checkWant(int a, int b) {
        a = find(a);
        b = find(b);
//        System.out.println("A : " + a);
//        System.out.println("B : " + b);
        if (a == b)
            return;
        if (want[a] > want[b]) {
            union(b, a);
            return;
        }
        union(a, b);
    }

    private static void union(int a, int b) {
        parent[b] = parent[a];
    }

    private static int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
}
