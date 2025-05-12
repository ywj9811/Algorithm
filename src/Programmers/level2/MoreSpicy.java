package Programmers.level2;

import java.util.*;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int value : scoville) {
            queue.add(value);
        }

        int cnt = 0;

        while (!queue.isEmpty()) {
            if (queue.peek() >= K)
                break;
            if (queue.size() < 2)
                return -1;
            int first = queue.poll();
            int second = queue.poll();

            int result = first + (second*2);
            queue.add(result);
            cnt++;
        }

        return cnt;
    }
}
