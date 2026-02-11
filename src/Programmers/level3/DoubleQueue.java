package Programmers.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoubleQueue {
    public static void main(String[] args) {
        int[] solution = new DoubleQueue().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            if (split[0].equals("I")) {
                pqueue.add(Integer.parseInt(split[1]));
            } else {
                if (pqueue.isEmpty())
                    continue;
                if (1 == Integer.parseInt(split[1])) {
                    pqueue.remove(Collections.max(pqueue));
                } else {
                    pqueue.poll();
                }
            }
        }

        if (pqueue.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{Collections.max(pqueue), pqueue.poll()};
    }
}

/**
 * I 숫자 큐에 주어진 숫자를 삽입합니다.
 * D 1	큐에서 최댓값을 삭제합니다.
 * D -1	큐에서 최솟값을 삭제합니다.
 *
 * 처리 후 큐가 비어있으면 0,0
 * 비어있지 않으면 최대, 최소
 *
 * i인지 체크, d인지 체크 / 숫자 처리
 *
 * 우선순위 큐를 써서 항상 오름차순 정렬
 */