package Baekjoon.baekjoon_math;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_19598 {
    private final static PriorityQueue<Meeting> startQueue = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
    private final static PriorityQueue<Meeting> endQueue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Meeting meeting = new Meeting(start, end);
            startQueue.add(meeting);
        }

        int size = 1;

        while (!startQueue.isEmpty()) {
            Meeting startPoll = startQueue.poll();
            Meeting endPoll = endQueue.poll();

            if (endPoll == null || startPoll.start >= endPoll.end) {
                endQueue.add(startPoll);
                continue;
            }
            endQueue.add(endPoll);
            endQueue.add(startPoll);
            size++;
        }

        System.out.println(size);
    }

    private static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
