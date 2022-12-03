package Programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
        Collections.sort(Arrays.asList(participant));
        Collections.sort(Arrays.asList(completion));

        for (int i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i]))
                return participant[i];
        }

        return participant[participant.length-1];
    }

    /**
     * participant : 참여한 선수
     * completion : 완주한 선수
     * completion의 길이는 participant의 길이보다 1 작습니다.
     */
}
