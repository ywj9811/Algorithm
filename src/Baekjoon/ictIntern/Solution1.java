package Baekjoon.ictIntern;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result1 {

    /*
     * Complete the 'getMinRooms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY meetingTimings as parameter.
     */

    public static int getMinRooms(List<List<Integer>> meetingTimings) {
        // 회의실을 저장할 PriorityQueue 생성 -> 빠른순으로 정렬되어 들어감
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        // 회의 일정을 시작 시간을 기준으로 오름차순 정렬
        Collections.sort(meetingTimings, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0).compareTo(b.get(0)); // 시작 시간 비교하여 오름차순 정렬
            }
        });

        // 첫 번째 회의의 종료 시간을 rooms에 추가
        rooms.offer(meetingTimings.get(0).get(1));

        // 회의실 추가 혹은 배정 처리
        for (int i = 1; i < meetingTimings.size(); i++) {
            int startTime = meetingTimings.get(i).get(0);
            int endTime = meetingTimings.get(i).get(1);

            // 회의실에 들어있는 종료 시간중 가장 빠른 종료 시간과 회의의 종료시간 비교 -> 없으면 추가
            if (rooms.peek() <= startTime) {
                rooms.poll(); // 가장 빠른 시간의 회의실 제거 (이후에 어짜피 추가하니 합은 0이 되기 위해)
            }

            rooms.offer(endTime); // 현재 회의의 종료 시간을 추가\
        }

        // 회의실의 개수를 반환
        return rooms.size();
    }

}
public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int meetingTimingsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int meetingTimingsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> meetingTimings = new ArrayList<>();

        IntStream.range(0, meetingTimingsRows).forEach(i -> {
            try {
                meetingTimings.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result1.getMinRooms(meetingTimings);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
