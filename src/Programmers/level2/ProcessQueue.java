package Programmers.level2;

import java.util.*;

public class ProcessQueue {
    public static void main(String[] args) {
        int solution = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(solution);

        int solution1 = solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(solution1);
    }

    public static int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }
        int idx = 1;
        while (!queue.isEmpty()) {
            boolean possible = true;
            Process poll = queue.poll();
//            System.out.println("cur : " + poll.idx + " priority : " + poll.priority);
            for (Process value : queue) {
//                System.out.println("value : " + value.idx + " priority : " + value.priority);
                if (poll.priority < value.priority) {
                    queue.add(poll);
                    possible = false;
//                    System.out.println("push idx : " + poll.idx + " priority : " + poll.priority);
                    break;
                }
            }
            if (possible) {
                if (poll.idx == location) {
//                    System.out.println("find idx : " + poll.idx + " priority : " + poll.priority);
                    return idx;
                }
//                System.out.println("poll idx : " + poll.idx + " priority : " + poll.priority);
                idx++;
            }
        }

        return 0;
    }

    static class Process {
        int idx, priority;
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
