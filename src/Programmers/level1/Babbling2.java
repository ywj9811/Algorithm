package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Babbling2 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSay = {"aya", "ye", "woo", "ma"};
        String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
        boolean check;
        String can;

        for (int i = 0; i < babbling.length; i++) {
            check = true;
            can = "";
            for (int j = 0; j < canSay.length; j++) {
                if (babbling[i].contains(canSay[j]))
                    can += "O";
                if (babbling[i].contains(repeat[j]))
                    can += "X";
                babbling[i] = babbling[i].replace(canSay[j], "");
            }
            if (can.contains("X"))
                check = false;
            if (check)
                if (babbling[i].length() == 0)
                    answer++;
            System.out.println("answer = " + answer);
            System.out.println("can = " + can);
        }

        return answer;
    }

    /**
     * 연속해서 나오는 경우만 발음하지 못할 뿐 떨어져 있다면 반응할 수 있다.
     *
     * "aya", "ye", "woo", "ma"
     * 이렇게 4개를 통해 같은 단어가 연속되지 않게
     * 만들 수 있는 개수
     */
    public static void main(String[] args) {
        String babbling[] = {"aya", "yee", "u", "maa"};
    }
}
