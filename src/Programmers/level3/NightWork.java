package Programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NightWork {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,3}, 4));
    }

    public static long solution(int[] works, int n) {
        WorkManage workManage = new WorkManage(works);
        workManage.distributionWork(n);
        return workManage.findOptimalTotalTime();
    }
}

class WorkManage {
    private PriorityQueue<Work> queue;

    public WorkManage(int[] works) {
        queue = new PriorityQueue<>(((o1, o2) -> o2.getAmount() - o1.getAmount()));
        Arrays.stream(works)
                .forEach(amount -> queue.add(new Work(amount)));
    }

    public void distributionWork(int n) {
        for (int i = 0; i < n; i++) {
            Work work = queue.poll();
            work.minusAmount();
            queue.add(work);
        }
    }

    public int findOptimalTotalTime() {
        int result = 0;

        while (!queue.isEmpty()) {
            Work work = queue.poll();
            result += work.squaredTime();
        }

        return result;
    }
}

class Work {
    private int amount;

    public Work(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void minusAmount() {
        if (amount > 0)
            amount--;
    }

    public long squaredTime() {
        return amount*amount;
    }
}
