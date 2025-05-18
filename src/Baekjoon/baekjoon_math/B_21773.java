package Baekjoon.baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_21773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Job> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.priority > o2.priority) {
                return -1;
            }
            if (o1.priority == o2.priority) {
                if (o1.id < o2.id)
                    return -1;
                return 1;
            }
            return 1;
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());

            Job job = new Job(id, time, priority);
            queue.add(job);
        }

        for (int i = 0; i < n; i++) {
            Job poll = queue.poll();
            sb.append(poll.id).append('\n');
            poll.time--;
            poll.priority--;
            if (poll.time > 0) {
                if (poll.time > 0) {
                    queue.add(new Job(poll.id, poll.time, poll.priority));
                }
            }
        }

        System.out.println(sb);
    }

    private static class Job {
        int id;
        int time;
        int priority;

        public Job(int id, int time, int priority) {
            this.id = id;
            this.time = time;
            this.priority = priority;
        }
    }
}
