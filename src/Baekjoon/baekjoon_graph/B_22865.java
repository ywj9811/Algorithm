package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_22865 {
    private static List<Node>[] nodes;
    private static int[] distances;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();

        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            nodes[start].add(new Node(end, value));
            nodes[end].add(new Node(start, value));
        }

        int[] distanceFromA = dijkstra(a, n);
        int[] distanceFromB = dijkstra(b, n);
        int[] distanceFromC = dijkstra(c, n);

        int maxDistance = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (i == a || i == b || i == c) continue;
            int minDistance = Math.min(distanceFromA[i], Math.min(distanceFromB[i], distanceFromC[i]));
            if (minDistance > maxDistance) {
                maxDistance = minDistance;
                result = i;
            }
        }

        System.out.println(result);
    }

    private static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentNode = current.end;

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Node neighbor : nodes[currentNode]) {
                if (visited[neighbor.end]) continue;

                int newDist = distances[currentNode] + neighbor.value;
                if (newDist < distances[neighbor.end]) {
                    distances[neighbor.end] = newDist;
                    queue.add(new Node(neighbor.end, newDist));
                }
            }
        }

        return distances;
    }

    private static class Node implements Comparable<Node> {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.value, node.value);
        }
    }
}


