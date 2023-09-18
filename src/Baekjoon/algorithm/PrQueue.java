package Baekjoon.algorithm;

import java.io.*;
import java.util.PriorityQueue;

public class PrQueue {
    // 값들을 입력받아 배열에 저장하고 있다가
    // 0을 입력받으면 배열에서 가장 작은 값 출력하고 해당 값 배열에서 제거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                if (priorityQueue.isEmpty()) {
                    bw.write("0\n");
                    continue;
                }
                bw.write(priorityQueue.poll().toString() + "\n");
                continue;
            }
            priorityQueue.add(order);
        }
        bw.close();
        br.close();
    }
}
