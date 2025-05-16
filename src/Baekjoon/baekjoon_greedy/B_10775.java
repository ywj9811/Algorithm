package Baekjoon.baekjoon_greedy;

import java.util.Scanner;

public class B_10775 {
    private static int[] gate;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gateCount = sc.nextInt();
        int airPlaneCount = sc.nextInt();

        gate = new int[gateCount+1];
        for (int i = 0; i < gate.length; i++) {
            gate[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < airPlaneCount; i++) {
            int gi = sc.nextInt();
            if (!union(gi)) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean union(int gi) {
        int root = find(gate[gi]);
        if (root <= 0) {
            return false;
        }
        gate[root] = find(root-1);
        return true;
    }

    private static int find(int gi) {
        if (gate[gi] != gi) {
            gate[gi] = find(gate[gi]);
        }
        return gate[gi];
    }
}
