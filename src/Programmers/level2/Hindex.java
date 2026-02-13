package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hindex {
    public static void main(String[] args) {
        int solution = new Hindex().solution(new int[]{10, 10, 10});
        System.out.println(solution);
    }

    public int solution(int[] citations) {
        List<Integer> sortedList = Arrays.stream(citations)
                .boxed()
                .collect(Collectors.toList());
        sortedList.sort((o1, o2) -> o2 - o1);

        int h = 0;

        while (sortedList.size() > h) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (sortedList.get(i) >= h+1 && i == h) {
                    h++;
                    break;
                }
                if (sortedList.get(i) < h+1) {
                    return h;
                }
            }
        }

        return h;
    }
}
