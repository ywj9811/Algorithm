package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Babbling2 {
    private int answer = 0;
    private String[] canSay = {"aya", "ye", "woo", "ma"};
    private String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
    private boolean check;
    private String can;

    public int solution(String[] babbling) {
        for (int i = 0; i < babbling.length; i++) {
            check = true;
            can = "";
            for (int j = 0; j < canSay.length; j++) {
                can += containCheck(babbling[i], j);
                babbling[i] = babbling[i].replace(canSay[j], "1");
            }
            babbling[i] = babbling[i].replace("1", "");
            if (can.contains("X"))
                check = false;
            if (check)
                answer += plusAnswer(babbling[i]);
        }
        return answer;
    }

    public int plusAnswer(String babbling) {
        if (babbling.length() == 0)
            return 1;
        return 0;
    }

    public String containCheck(String babbling, int idx) {
        if (babbling.contains(repeat[idx]))
            return "X";
        if (babbling.contains(canSay[idx]))
            return "O";
        return "";
    }
}
