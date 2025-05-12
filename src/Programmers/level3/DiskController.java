package Programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int solution = solution(new int[][]{
                {1, 4},
                {7, 9},
                {1000, 3}
        });
        System.out.println(solution);
    }

    private static int solution(int[][] jobs) {
        PriorityQueue<Job> waitQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.time < o2.time)
                    return -1;
                if (o1.time == o2.time) {
                    if (o1.start < o2.start)
                        return -1;
                    if (o1.start == o2.start) {
                        if (o1.num < o2.num)
                            return -1;
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
        });

        PriorityQueue<Job> requestQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.start < o2.start)
                    return -1;
                if (o1.start == o2.start) {
                    if (o1.time < o2.time)
                        return -1;
                    if (o1.time == o2.time) {
                        if (o1.num < o2.num)
                            return -1;
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
        });

        List<Job> results = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            requestQueue.add(new Job(jobs[i][1], jobs[i][0], i));
        }

        Job poll = requestQueue.poll();
        poll.end = poll.start + poll.time;
        results.add(poll);

        while (true) {
            Job job = results.get(results.size() - 1);
            int end = job.getEnd();
            while (!requestQueue.isEmpty() && requestQueue.peek().start <= end) {
                Job pollJob = requestQueue.poll();
                waitQueue.add(pollJob);
            }
            if (waitQueue.isEmpty() && !requestQueue.isEmpty()) {
                Job add = requestQueue.poll();
                add.end = add.start + add.time;
                results.add(add);
            } if (!waitQueue.isEmpty()){
                Job add = waitQueue.poll();
                add.end = job.getEnd() + add.time;
                results.add(add);
            }

            if (requestQueue.isEmpty() && waitQueue.isEmpty())
                break;
        }
        int sum = results.stream()
                .mapToInt(result -> {
                    int time = result.getEnd() - result.start;
                    return time;
                })
                .sum();
        return sum / results.size();
    }

    private static class Job {
        int time;
        int start;
        int num;
        int end = 0;

        public int getEnd() {
            if (end == 0)
                return time + start;
            return end;
        }

        public Job(int time, int start, int num) {
            this.start = start;
            this.time = time;
            this.num = num;
        }
    }
}
