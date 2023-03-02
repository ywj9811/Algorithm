package Baekjoon.baekjoon_greedy;

import java.io.*;
import java.util.*;

/**
 * S ~ T 의 N개 수업이 있을 떄 최소의 강의실을 사용해서 모든 수업을 가능토록 하자.
 * 끝나는 시간과 시작하는 시간이 같아도 들을 수 있다.
 *
 * 첫번째 줄 N
 * N개의 줄에 각각 S, T 입력
 * 최소한의 강의실
 *
 * 3
 * 1 3
 * 2 4
 * 3 5
 *
 * 2개의 강의실 사용
 *
 * 1 3 - 3 5 = 1개의 강의실 사용
 * 2 4 = 1개의 강의실 추가 사용
 * 총 2개의 강의실
 *
 * 겹치는 시간이 있다면 강의실을 하나 더 사용해야 한다.
 */
public class B_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine());
        String buffered;

        int[][] times = new int[total][2];

        for (int i = 0; i < total; i++) {
            buffered = br.readLine();
            times[i][0] = Integer.parseInt(buffered.split(" ")[0]);
            times[i][1] = Integer.parseInt(buffered.split(" ")[1]);
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    // 0번 위치를 비교해서 0번이 같다면 1번을 비교 정렬
                    return o1[1] - o2[1];
                } else {
                    // 다르다면 둘이 비교해서 우선 정렬
                    return o1[0] - o2[0];
                }
            }
        });
        /**
         * 여기까지 이렇게 강의 시간을 시간 순서로 정렬을 함.
         */

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(times[0][1]);

        for (int i = 1; i < total; i++) {
            if (priorityQueue.peek() <= times[i][0]) {
                priorityQueue.poll();
                /**
                 * 현재 가장 빨리 끝나는 시간과 시작하는 시간을 비교해서 시작 시간이 더 늦다면
                 * 해당 강의실에서 다음 수업을 진행하도록 한다.
                 * 즉, 강의실 추가 X -> 기존의 빠른 시간 삭제 (같은 강의실에서 이어서 할 것이기 때문에 끝나는 시간은 달라졌을 것이다)
                 */
            }
            priorityQueue.add(times[i][1]);
            /**
             * 만약 현재 가장 빨리 끝나는 시간보다 시작 시간이 빠르다면 어쩔 수 없이 강의실을 추가로 사용해야 할 것이다.
             * -> 우선순위 큐에 끝나는 시간 추가
             * -> 추가된 시간 또한 내부에서 우선순위에 따라서 정렬이 될 것이다.
             *
             * 위 과정을 반복하면서 같은 강의실에서 이어서 할 수 있다면 가장 빨리 끝나는 시간을 삭제하면서 이어가면 된다.
             */
        }

        bw.write(priorityQueue.size() + "\n");
        bw.flush();

        /**
         * 위 과정을 끝내고 나면 큐에 들어있는 크기가 강의실의 개수와 일치하게 될 것이다.
         *
         * 한 강의실에서 이어서 할 수 있으면 기존의 하나를 삭제하고 추가하기 때문에...
         * 만약 새로운 강의실이 추가되어야 하면 그냥 삭제했기 때문에...
         */

        br.close();
        bw.close();
    }
}
