package Programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BigNumber {
    public static void main(String[] args) {
        String solution = new BigNumber().solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(solution);
    }

    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) == o2.charAt(0)) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        for (String value : list) {
            answer += value;
        }
        if (answer.charAt(0) == '0')
            return "0";
        return answer;
    }

    /**
     * 값을 내림차순으로 정렬하고?
     * -> 여기서 정렬하는 방법을 단순한 sort가 아닌
     * 문자열 기반이니 charAt(0)으로 하면 되겠다.
     * 만약 같다면 charAt(1~~끝까지) 이렇게 비교하면서 가도록 하자.
     */
}
