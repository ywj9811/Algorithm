package Baekjoon.baekjoon_graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class B_4195 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, String> parent;
    private static Map<String, Integer> size;

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            int n = sc.nextInt();
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String a = sc.next();
                String b = sc.next();
                System.out.println(union(a, b));
            }
        }
    }

    private static int union(String a, String b) {
        if (!parent.containsKey(a)) {
            parent.put(a, a);
            size.put(a, 1);
        }
        if (!parent.containsKey(b)) {
            parent.put(b, b);
            size.put(b, 1);
        }

        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA);
            size.put(rootA, size.get(rootA) + size.get(rootB));
        }

        return size.get(find(a));
    }

    private static String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
}
