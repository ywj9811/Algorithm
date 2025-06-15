package Programmers.cote;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] test1 = {3, -2, 8, 5, 3, 9};
        System.out.println("Test1: " + Arrays.toString(solution(test1)));

        // 테스트 케이스 2
        int[] test2 = {3, 6, 7, 7, 2, 6, 0, -2, 6, -1, 13};
        System.out.println("Test2: " + Arrays.toString(solution(test2)));

        // 테스트 케이스 3
        int[] test3 = {0};
        System.out.println("Test3: " + Arrays.toString(solution(test3)));
    }


    public static int[] solution(int[] arr) {
        // 1. 중복 제거 + 정렬
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        List<Integer> temp = new ArrayList<>(set);
        Collections.sort(temp); // 오름차순 정렬

        int n = temp.size();
        int[] result = new int[n];

        // 2. 인덱스 분류
        List<Integer> ascIndexes = new ArrayList<>();
        List<Integer> descIndexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i % 2 == 1) ascIndexes.add(i);
            if (i % 2 == 0 && i != 0) descIndexes.add(i); // 0 제외하고 짝수만
        }


        // 3. 내림차순용 값: 정렬된 temp의 앞에서부터
        List<Integer> descValues = temp.subList(0, descIndexes.size());
        Collections.reverse(descValues);

        // 4. 오름차순용 값: 정렬된 temp의 뒤에서부터
        List<Integer> ascValues = temp.subList(descIndexes.size(), n);

        // 5. 결과 채우기
        for (int i = 0; i < ascIndexes.size(); i++) {
            result[ascIndexes.get(i)] = ascValues.get(i);
        }
        for (int i = 0; i < descIndexes.size(); i++) {
            result[descIndexes.get(i)] = descValues.get(i);
        }

        return result;
    }
}
