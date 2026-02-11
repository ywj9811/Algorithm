package Baekjoon.baekjoon_greedy;

import java.util.*;

public class B_2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer>[] arr = new List[n];
        for (int i = 0; i < n; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j].add(sc.nextInt());
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < n; i++) {
            queue.add(new Node(arr[i].remove(arr[i].size()-1), i));
        }
        for (int i = 0; i < n-1; i++) {
            Node max = queue.poll();
            queue.add(new Node(arr[max.getIdx()].remove(arr[max.getIdx()].size()-1), max.getIdx()));
        }

        Node node = queue.poll();
        System.out.println(node.getValue());
    }

    static class Node {
        private final int value;
        private final int idx;

        Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        public int getValue() {
            return value;
        }

        public int getIdx() {
            return idx;
        }
    }
}
