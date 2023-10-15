package Baekjoon.ictIntern;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test2 {
    public static void main(String[] args) {
        int n = 1;
        int[][] datas = new int[][]{{0, 20}, {2, 15}, {4, 10}, {6, 5}};
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] data : datas) {
            int fin = data[0] + data[1];
            if (queue.size() < n) {
                queue.add(fin);
                continue;
            }
            int poll = queue.poll();
            if (poll >= data[0]) {
                answer += poll - data[0];
                queue.add(poll + data[1]);
                continue;
            }
            queue.add(fin);
        }

        System.out.println(answer);
    }
    // 우선순위 큐 검색 : https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
}
