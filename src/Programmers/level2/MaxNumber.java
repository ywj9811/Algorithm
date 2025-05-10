package Programmers.level2;

import java.util.Arrays;

public class MaxNumber {
    public static void main(String[] args) {
        String solution = solution(new int[]{6, 10, 2});
        System.out.println(solution);
    }


    public static String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (str[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String value : str) {
            sb.append(value);
        }

        return sb.toString();
    }
}
