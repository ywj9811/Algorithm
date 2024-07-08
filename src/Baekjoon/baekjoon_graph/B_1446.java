package Baekjoon.baekjoon_graph;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1446 {
    private static int[] dp;
    private static PriorityQueue<Road> roads;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int length = sc.nextInt();

        dp = new int[length+1];
        roads = new PriorityQueue<>();

        for (int i = 0; i <= length; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();

            if (end > length || (end - start) <= value)
                continue;

            roads.add(new Road(start, end, value));
        }

        while (!roads.isEmpty()) {
            Road road = roads.poll();

            if (dp[road.end] > dp[road.start] + road.value) {
                dp[road.end] = dp[road.start] + road.value;
                for (int i = road.end+1; i <= length; i++) {
                    if (dp[i] < dp[i-1] +1)
                        break;
                    dp[i] = dp[i-1] + 1;
                }
            }
        }

        System.out.println(dp[length]);
    }

    private static class Road implements Comparable<Road> {
        public Road(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        int start;
        int end;
        int value;

        @Override
        public int compareTo(Road o) {
            return start - o.start;
        }
    }
}
