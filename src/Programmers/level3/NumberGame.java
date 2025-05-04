package Programmers.level3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGame {
    public static void main(String[] args) {
        int solution = solution(new int[]{2,2,2,2}, new int[]{1,1,1,1});
        System.out.println(solution);
    }

    public static int solution(int[] A, int[] B) {
        List<Integer> aList = Arrays.stream(A)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        List<Integer> bList = Arrays.stream(B)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int score = 0;

        for (int i = 0; i < bList.size(); i++) {
            for (int j = 0; j < aList.size(); j++) {
                if (bList.get(i) > aList.get(j)) {
                    score++;
                    aList.remove(j);
                    break;
                }
            }
        }
        return score;
    }
}
