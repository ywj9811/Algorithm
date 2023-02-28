package Baekjoon.baekjoon_greedy;

import java.io.*;
import java.util.*;

/**
 * S ~ T 의 N개 수업이 있을 떄 최소의 강의실을 사용해서 모든 수업을 가능토록 하자.
 * 끝나는 시간과 시작하는 시간이 같아도 들을 수 있다.
 *
 * 첫번째 줄 N
 * N개의 줄에 각각 S, T 입력
 * 여기서 최대한 많은 수업을 할 수 있도록 하자.
 *
 * 3
 * 1 3
 * 2 4
 * 3 5
 *
 * 2
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
//            System.out.println(times[i][0]);
//            System.out.println(times[i][1]);
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
         * 끝나는 시간보다 시작하는 시간이 큰 친구가 있는지 확인
         * 없다면 cnt = 1
         * 있다면 크 친구로 시작해서 다음으로 반복
         * 
         * 시작 시간이 빠른 순으로 정렬을 해야겠음
         *
         * 1 3
         * 2 4
         * 3 5
         * 3 10
         * 5 10
         */
        int cnt = 1;
        int finCnt = 0;
        int start;

        for (int i = 0; i < total - 1; i++) {
            start = i;

            for (int j = i + 1; j < total; j++) {
                if (times[start][1] <= times[j][0]) {
                    start = j;
                    cnt++;
                }
            }
            if (finCnt < cnt)
                finCnt = cnt;
            cnt = 1;
        }

        bw.write(finCnt + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
