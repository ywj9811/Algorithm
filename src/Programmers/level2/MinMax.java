package Programmers.level2;

public class MinMax {
    public String solution(String s) {
        String[] splits = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < splits.length; i++) {
            min = Math.min(min, Integer.parseInt(splits[i]));
            max = Math.max(max, Integer.parseInt(splits[i]));
        }

        String answer = min + " " + max;

        return answer;
    }
}
