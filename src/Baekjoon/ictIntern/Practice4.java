package Baekjoon.ictIntern;

import java.util.Scanner;

public class Practice4 {
    /**
     * 프로그래머 문자열은 '프로그래머'라는 단어를 형성하기 위해 재정렬할 수 있는 문자를 포함하며 더 긴 문자열의 하위 문자열입니다.
     * 문자열 'programmer', 'grammproer' 및 'prozmerqgram'은 모두 이 정의에 따라 프로그래머 문자열로 분류됩니다. 주어진 문자열이 포함된 가장 오른쪽 프로그래머 문자열과 가장 왼쪽 프로그래머 문자열 사이에 있는 인덱스 수를 결정합니다.
     *
     * 예
     * s = 'programmerxxxprozmerqgram' 이 예에서 인덱스 0 - 9는 하나의 프로그래머 문자열을 형성하고 인덱스 13 - 24는 다른 문자열을 포함합니다. 프로그래머 사이에 3개의 인덱스가 있으므로 함수는 3을 반환합니다.
     *
     * 기능 설명
     *  아래 편집기에서 ProgrammerStrings 함수를 완성하십시오.
     * programmingStrings에는 다음과 같은 매개변수가 있습니다. 문자열 s: 2개의 프로그래머 문자열을 포함하는 문자열
     * 반환값: int: s 내에서 가장 오른쪽과 가장 왼쪽 프로그래머 문자열 사이에 있는 인덱스 수
     *
     * 제약
     * 문자열 s는 영문 소문자 ascii[a-z]로만 구성됩니다.
     * 1 ≤ s ≤ 10^5의 길이.
     *  항상 두 개의 겹치지 않는 프로그래머 문자열이 있습니다.
     */
    public static void main(String[] args) {
        final String PROGRAMMER = "programmer";
        //하나는 왼쪽, 하나는 오른쪽 출발
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        int length = inputString.length();

        int[] alpha = new int[26]; //모든 알파벳을 가지는 배열을 만들고 해당 배열에 programmer에 해당하는 인덱스만 +1씩 한다.
        for (int i = 0; i < PROGRAMMER.length(); i++) {
            alpha[PROGRAMMER.charAt(i) - 'a']++;
        }

        int left = 0;
        int count = PROGRAMMER.length();
        while (left < length){
            int index = inputString.charAt(left) - 'a';
            if (alpha[index] > 0)
                count--;
            alpha[index] = alpha[index] - 1;

            if (count == 0)
                break;
            left++;
        }

        alpha = new int[26];
        for (int i = 0; i < PROGRAMMER.length(); i++) {
            alpha[PROGRAMMER.charAt(i) - 'a']++;
        }

        int right = length - 1;
        count = PROGRAMMER.length();
        while (right >= 0){
            int index = inputString.charAt(right) - 'a';
            if (alpha[index] > 0)
                count--;
            alpha[index] = alpha[index] - 1;

            if (count == 0)
                break;
            right--;
        }

        System.out.println(right - left - 1);
    }
}
