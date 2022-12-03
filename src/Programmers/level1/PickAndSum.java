package Programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickAndSum {
    private List<Integer> preAnswer = new ArrayList<>();
    private int answer[];

    public int[] solution(int[] numbers) {
        preAnswer = getSum(numbers);
        Collections.sort(preAnswer);
        answer = preAnswer.stream().
                mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public List<Integer> getSum(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (!preAnswer.contains(numbers[i] + numbers[j]))
                    preAnswer.add(numbers[i] + numbers[j]);
            }
        }
        return preAnswer;
    }
}
