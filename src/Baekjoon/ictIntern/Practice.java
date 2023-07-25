package Baekjoon.ictIntern;

import java.util.*;

public class Practice {
    /**
     * 특정 날짜에 n개의 회의가 예정되어 있습니다. 회의의 시작 및 종료 시간을 포함하는 n x m 크기의 2D 배열, meetingTimings로 제공된 회의 목록이 있습니다.
     * 회의실에서 회의가 겹치지 않도록 모든 회의를 진행하는 데 필요한 최소 회의실 수를 결정합니다.
     *
     * 참고: 회의는 한 회의실에서 동시에 종료하고 시작할 수 있습니다. 예를 들어 [10, 15], [15, 20] 시간에 회의를 같은 방에서 할 수 있습니다.
     *
     * 기능 설명
     * 아래 편집기에서 getMinRooms 함수를 완료하십시오. getMinRooms에는 다음 매개변수가 있습니다. int meetingTimings[n][2]: 회의 시작 및 종료 시간
     *
     * 보고
     * int: 필요한 최소 회의실 수
     *
     * 제약
     * 1 ≤ n ≤ 2 * 10^5
     * 1 ≤ meetingTimings[i][0] ≤ meetingTimings[i][1] ≤ 2 * 10^6
     *
     * 사용자 정의 테스트를 위한 입력 형식
     * 첫 번째 줄에는 예약할 회의 수인 정수 n이 포함됩니다. 다음 줄에는 2가 포함됩니다.
     *
     * 다음 n행 각각에는 두 개의 공백으로 구분된 정수 meetingTimings[i][0] 및 meetingTimings[i][1](회의 시작 및 종료 시간)이 포함됩니다.
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        List<List<Integer>> meetings = new ArrayList<>();
        List<Integer> times;
        int cnt = 1;

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            times = new ArrayList<>();
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            times.add(startTime);
            times.add(endTime);
            meetings.add(times);
            // 회의들을 담음
        }

        meetings.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        rooms.offer(meetings.get(0).get(1));

        for (int i = 1; i < meetings.size(); i++) {
            if (rooms.peek().compareTo(meetings.get(i).get(0)) == -1 || rooms.peek().compareTo(meetings.get(i).get(0)) == 0) {
                rooms.poll();
            }
            rooms.offer(meetings.get(i).get(1));
        }

        System.out.println(rooms.size());
    }
}
