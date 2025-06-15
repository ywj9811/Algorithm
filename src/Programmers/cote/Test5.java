package Programmers.cote;

import java.util.*;

public class Test5 {

    private static final char[][] keyboard = {
            {'q','w','e','r','t','y','u','i','o'},
            {'p','a','s','d','f','g','h','j','k'},
            {'l','z','x','c','v','b','n','m',' '}
    };
    private static final int MOD = 1_000_000_007;

    public static int solution(String s) {
        Map<Character, int[]> keyMap = new HashMap<>();
        for (int row = 0; row < keyboard.length; row++) {
            for (int col = 0; col < keyboard[row].length; col++) {
                char c = keyboard[row][col];
                if (c != ' ') { // 빈 칸은 제외
                    keyMap.put(c, new int[]{row, col});
                }
            }
        }

        int n = s.length();
        long total = 0;
        for (int i = 0; i < n - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            int[] pos1 = keyMap.get(c1);
            int[] pos2 = keyMap.get(c2);

            int dist = Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);

            long count = (long)(i + 1) * (n - i - 1); // 이 인접쌍이 들어가는 부분 문자열 수
            total = (total + (dist * count)) % MOD;
        }

        return (int) total;
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(solution("abcc"));    // 7
        System.out.println(solution("tooth"));   // 11
        System.out.println(solution("zzz"));     // 0
    }
}
