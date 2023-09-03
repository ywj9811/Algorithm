package Programmers.level2;

import java.util.*;

public class HotelRooms {
    public static void main(String[] args) {
        int solution = solution(
                new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        System.out.println(solution);
    }

    public static int solution(String[][] book_time) {
        // index 1 = 퇴실
        // index 0 = 입실
        // 퇴실 + 10 <= 입실 입장 가능
        // 최소 몇개의 방이 필요한가.
        Arrays.sort(book_time, (o1, o2) -> {
            return Integer.parseInt(o1[0].split(":")[0] + o1[0].split(":")[1])
                    - Integer.parseInt(o2[0].split(":")[0] + o2[0].split(":")[1]);
        });

        PriorityQueue<String> pr = new PriorityQueue<>((o1, o2) -> {
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        });

        pr.add(getSplit(book_time[0][1]));

        for (int i = 1; i < book_time.length; i++) {
            String peek = pr.peek();
            int can = (Integer.parseInt(peek) + 10);
            if ((Integer.parseInt(peek) + 10)%100 >= 60) {
                can -= 60;
                can += 100;
            }
            if (Integer.parseInt(getSplit(book_time[i][0]))
                    >= can) {
                pr.poll();
            }
            pr.add(getSplit(book_time[i][1]));
        }

        int answer = pr.size();

        return answer;
    }

    static String getSplit(String st) {
        String[] split = st.split(":");
        return split[0] + split[1];
    }
}
