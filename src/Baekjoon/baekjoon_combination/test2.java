package Baekjoon.baekjoon_combination;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        System.out.println(solution("15:15:00", "15:15:15"));  // Output: 2
        System.out.println(solution("22:22:21", "22:22:23"));  // Output: 3
    }

    public static int solution(String T, String S) {
        int start = getSeconds(T);
        int end = getSeconds(S);
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (check(i )) {
                count++;
            }
        }

        return count;
    }

    // HH:MM:SS 형태의 시간을 초 단위로 변환 -> 반복을 위해
    private static int getSeconds(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        int seconds = Integer.parseInt(split[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }


    // 사용된 숫자가 2개 이하인지 확인
    private static boolean check(int seconds) {
        int[] count = new int[10];

        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;
        String[] checkTime = new String[3];
        checkTime[0] = String.format("%02d", hours);
        checkTime[1] = String.format("%02d", minutes);
        checkTime[2] = String.format("%02d", seconds);

        for (int i = 0; i < 3; i++) {
            String check = checkTime[i];
            int first = Integer.parseInt(String.valueOf(check.charAt(0)));
            int second = Integer.parseInt(String.valueOf(check.charAt(1)));

            count[first]++;
            count[second]++;
        }

        int cnt = 0;

        for (int i : count) {
            if (i > 0) {
                cnt++;
            }
        }

        return cnt <= 2;
    }

}
