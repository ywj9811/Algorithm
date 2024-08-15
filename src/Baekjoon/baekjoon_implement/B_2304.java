package Baekjoon.baekjoon_implement;

import java.util.*;

public class B_2304 {
    private static Node[] nodes = new Node[1001];
    private static int start;
    private static int end;
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        end = 0;
        start = Integer.MAX_VALUE;
        for (int i = 0; i < 1001; i++) {
            nodes[i] = new Node(i, 0);
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node node = new Node(a, b);
            nodes[a] = node;
            end = Math.max(end, a);
            start = Math.min(start, a);
        }

        max = 0;
        int maxHeight = 0;
        for (Node node : nodes) {
            if (node.height == 0)
                continue;
            if (maxHeight < node.height) {
                max = node.idx;
                maxHeight = node.height;
            }
        }

        int sum = nodes[max].height;

        int left = findLeft(max);
        sum += (max - left) * nodes[left].height;
        while (left > start) {
            int nextLeft = findLeft(left);
            sum += (left - nextLeft) * nodes[nextLeft].height;
            left = nextLeft;
        }

        int right = findRight(max);
        sum += (right - max) * nodes[right].height;

        while (right < end) {
            int nextRight = findRight(right);
            sum += (nextRight - right) * nodes[nextRight].height;
            right = nextRight;
        }


        System.out.println(sum);
    }

    private static int findLeft(int idx) {
        int leftMax = 0;
        int ans = start;
        for (int i = start; i < idx; i++) {
            if (leftMax < nodes[i].height) {
                ans = nodes[i].idx;
                leftMax = nodes[i].height;
            }
        }
        return ans;
    }

    private static int findRight(int idx) {
        int rightMax = 0;
        int ans = end;
        for (int i = idx+1; i <= end; i++) {
            if (rightMax < nodes[i].height) {
                ans = nodes[i].idx;
                rightMax = nodes[i].height;
            }
        }
        return ans;
    }

    private static class Node {
        int idx;
        int height;

        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
