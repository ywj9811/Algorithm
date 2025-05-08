package Programmers.level2;

import java.util.*;

public class Fee {
    private static Map<String, Record> recordMap = new HashMap<>();
    private static Map<String, Integer> resultMap = new HashMap<>();
    private static Map<String, Integer> totalTime = new HashMap<>();
    public static void main(String[] args) {
        int[] solution = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int value : solution) {
            System.out.println(value);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        for (String value : records) {
            String[] splits = value.split(" ");
            String time = splits[0];
            String num = splits[1];
            String check = splits[2];
            if (check.equals("IN")) {
                Record record = new Record();
                record.in = time;
                recordMap.put(num, record);
                continue;
            }

            Record record = recordMap.get(num);
            record.out = time;

            calTime(num, record);
        }

        recordMap.keySet()
                .forEach(value -> {
                    Record record = recordMap.get(value);

                    if (record.outIsBlank()) {
                        calTime(value, record);
                    }

                    int fee = calFee(fees, totalTime.get(value));
                    resultMap.put(value, fee);
                });
        ArrayList<String> keySets = new ArrayList<>(resultMap.keySet());
        Collections.sort(keySets);

        int[] answer = new int[keySets.size()];
        for (int i = 0; i < keySets.size(); i++) {
            answer[i] = resultMap.get(keySets.get(i));
        }

        return answer;
    }

    private static void calTime(String num, Record record) {
        int time = record.cal();
        Integer orDefault = totalTime.getOrDefault(num, 0);
        totalTime.put(num, orDefault + time);
    }

    private static int calFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= basicTime) {
            return basicFee;
        }

        time -= basicTime;
        int fee = (time / unitTime) * unitFee;
        if (time % unitTime > 0)
            fee += unitFee;
        return fee + basicFee;
    }

    private static class Record {
        String in;
        String out;

        public boolean outIsBlank() {
            return out == null;
        }

        public int cal() {
            if (out == null) {
                out = "23:59";
            }
            String[] ins = in.split(":");
            String[] outs = out.split(":");
            int hours = Integer.parseInt(outs[0]) - Integer.parseInt(ins[0]);
            int minutes = Integer.parseInt(outs[1]) - Integer.parseInt(ins[1]);
            return ((hours * 60) + minutes);
        }
    }
}
