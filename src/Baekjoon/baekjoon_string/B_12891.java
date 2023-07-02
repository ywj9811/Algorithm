package Baekjoon.baekjoon_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12891 {
    static int[] need = new int[4];
    static int[] my = new int[4];
    public static void main(String[] args) throws IOException {
        /**
         * DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalLength = Integer.parseInt(st.nextToken());
        int subLength = Integer.parseInt(st.nextToken());
        char[] totalArray = br.readLine().toCharArray();
        String[] split = br.readLine().split(" ");
        br.close();

        //초기 세팅
        for (int i = 0; i < split.length; i++) {
            need[i] = Integer.parseInt(split[i]);
        }
        int startIdx = 0;
        int endIdx = startIdx - 1 + subLength;

        int count = 0;

        for (int i = startIdx; i <= endIdx; i++) {
            add(totalArray[i]);
        }
        if (check())
            count++;

        while (endIdx < totalLength-1) {
            minus(totalArray[startIdx]);
            startIdx++;
            endIdx++;
            add(totalArray[endIdx]);
            if (check())
                count++;
        }
        System.out.println(count);
    }

    public static void add(char checkChar) {
        switch (checkChar) {
            case 'A' :
                my[0]++;
                break;
            case 'C' :
                my[1]++;
                break;
            case 'G' :
                my[2]++;
                break;
            case 'T' :
                my[3]++;
                break;
        }
    }

    public static void minus(char checkChar) {
        switch (checkChar) {
            case 'A' :
                my[0]--;
                break;
            case 'C' :
                my[1]--;
                break;
            case 'G' :
                my[2]--;
                break;
            case 'T' :
                my[3]--;
                break;
        }
    }

    public static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (my[i] < need[i])
                return false;
        }
        return true;
    }
}
