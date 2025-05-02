package Programmers.cote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListCote {
    public static void main(String[] args) {
        solution(new int[]{50, 98, 38, 11, 13 ,90, 82, 83, 70});
        System.out.println();
    }

    public static int[] solution(int[] arr) {
        List<Integer> ascList = new ArrayList<>();
        List<Integer> descList = new ArrayList<>();

        ascList.add(arr[0]);
        descList.add(arr[0]);

        // 인덱스 기준: 짝수 → ascList, 홀수 → descList
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0) {
                descList.add(arr[i]); // 0,2,4,... 순서 → 오름차순
            } else {
                ascList.add(arr[i]); // 1,3,5,... 순서 → 내림차순
            }
        }

        ascList.sort((o1, o2) -> o1 - o2);
        descList.sort((o1, o2) -> o2 - o1);

        int ascIdx = 0;
        int descIdx = 0;

        // 다시 배열에 순서대로 넣기
        arr[0] = descList.get(0);
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = descList.get(ascIdx++);
            } else {
                arr[i] = ascList.get(descIdx++);
            }
        }
        for (int result : arr) {
            System.out.print(result + " ");
        }
        return arr;
    }
}
