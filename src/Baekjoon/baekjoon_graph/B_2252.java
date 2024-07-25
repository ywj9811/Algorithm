package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_2252 {
    private static List<Integer>[] nodes;
    private static int[] students;
    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        nodes = new List[n+1];
        students = new int[n+1];
        students[0] = -1;

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            nodes[start].add(end);
            students[end]++;
        }

        while (check()) {
        }

        results.forEach(result -> System.out.print(result + " "));
    }

    private static boolean check() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                results.add(i);
                for (int student : nodes[i]) {
                    students[student]--;
                }
                students[i]--;
                return true;
            }
        }
        return false;
    }
}
