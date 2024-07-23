package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1043 {
    private static int[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> parties = new ArrayList<>();

        nodes = new int[n+1];

        for (int i = 1; i <=n; i++) {
            nodes[i] = i;
        }

        int t = sc.nextInt();
        int first = 0;
        if (t > 0)
            first = sc.nextInt();
        for (int i = 0; i < t-1; i ++) {
            int input = sc.nextInt();
            union(first, input);
        } // 진실을 아는자 == nodes[first] 로 통일

        for (int i = 0; i < m; i++) {
            int size = sc.nextInt();
            int[] people = new int[size];
            for (int j = 0; j < size; j++ ){
                people[j] = sc.nextInt();
            }
            parties.add(people);
            for (int j = 1; j < size; j++) {
                union(people[j-1], people[j]);
            }
        }

        for (int i = 0; i < parties.size(); i++) {
            int[] party = parties.get(i);
            for (int j = 1; j < party.length; j++) {
                union(party[j-1], party[j]);
            }
        }

        int cnt = 0;
        List<Integer> lie = new ArrayList<>();
        for (int i = 1; i <= n; i++ ) {
            if (find(i) == find(nodes[first])) {
                lie.add(i);
            }
        }

        for (int i = 0; i < parties.size(); i++) {
            int[] party = parties.get(i);
            if (check(lie, party))
                cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean check(List<Integer> lie, int[] party) {
        for (int a : party) {
            if (lie.contains(a))
                return false;
        }
        return true;
    }

    private static void union(int a, int b) {
        int first = find(a);
        int second = find(b);

        nodes[second] = first;
    }

    private static int find(int a) {
        if (nodes[a] == a)
            return a;
        return nodes[a] = nodes[nodes[a]];
    }
}
