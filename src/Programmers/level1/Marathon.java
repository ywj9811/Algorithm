package Programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> part = new ArrayList<>(Arrays.asList(participant));
        for (int i = 0; i < completion.length; i++) {
            part.remove(completion[i]);
        }
        for (int i = 0; i < part.size(); i++) {
            answer += part.get(i);
        }
        return answer;
    }

    /**
     * participant : 참여한 선수
     * completion : 완주한 선수
     * completion의 길이는 participant의 길이보다 1 작습니다.
     */
}
