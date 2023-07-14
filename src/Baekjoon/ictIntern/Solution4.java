package Baekjoon.ictIntern;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result4 {

    /*
     * Complete the 'programmerStrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int programmerStrings(String s) {
        String p = "programmer";

        int[] freq = new int[26]; // 알파벳 개수
        // programmer에 등장하는 각 알파벳 문자의 빈도수를 저장

        // programmer에 등장하는 각 문자의 빈도수를 계산
        for (int i = 0; i < p.length(); i++)
            freq[p.charAt(i) - 'a']++;
        // freq[0]부터 a이기 때문에 a를 빼줌 (아스키)

        int count = p.length();
        // programmer가 다 나왔는지 검사
        int len = s.length();
        // 총 길이
        int left = 0;
        int right = len - 1;

        // 문자열의 처음부터 'programmer' 문자열을 찾습니다.
        while (left < len) {
            char currentChar = s.charAt(left);
            int index = currentChar - 'a';
            int currentFrequency = freq[index];
            freq[index] = freq[index] - 1;
            left++;
            // a~z 중 programmer에 해당하는 값이 나올 때마다 -1씩 진행

            if (currentFrequency > 0) {
                count--;
            }
            // programmer에 해당하는 값이 나왔으면 -1

            if (count == 0) {
                break;
            }
        }

        // 첫 번째 programmer 위치를 저장
        int firstProgrammer = left;

        // 두 번째 programmer 찾기 위한 작업 시작 (위 반복)
        freq = new int[26];
        for (int i = 0; i < p.length(); i++)
            freq[p.charAt(i) - 'a']++;

        // 문자열의 마지막부터 시작
        count = p.length();
        while (right >= 0) {
            if (freq[s.charAt(right--) - 'a']-- > 0)
                count--;

            if (count == 0)
                break;
        }

        while (right >= len) {
            char currentChar = s.charAt(right);
            int index = currentChar - 'a';
            int currentFrequency = freq[index];
            freq[index] = freq[index] - 1;
            right--;

            if (currentFrequency > 0) {
                count--;
            }

            if (count == 0) {
                break;
            }
        }

        // 두 번째 위치
        int secondProgrammer = right;

        return secondProgrammer - firstProgrammer + 1;
    }

}

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result4.programmerStrings(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
