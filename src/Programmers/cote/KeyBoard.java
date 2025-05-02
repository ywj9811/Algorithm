package Programmers.cote;

import java.util.HashMap;
import java.util.Map;

public class KeyBoard {
    public static void main(String[] args) {
        String input = "abcc";
        int result = totalSubstringDistance(input);
        System.out.println("총 거리 합: " + result);
    }

    static String[][] keyboard = {
            {"q", "w", "e", "r", "t", "y", "u", "i", "o"},
            {"p", "a", "s", "d", "f", "g", "h", "j", "k"},
            {"l", "z", "x", "c", "v", "b", "n", "m", " "}
    };

    public static Map<String, int[]> getMap() {
        Map<String, int[]> positionMap = new HashMap<>();
        // 1. 키보드 문자 → 좌표 매핑
        for (int row = 0; row < keyboard.length; row++) {
            for (int col = 0; col < keyboard[row].length; col++) {
                positionMap.put(keyboard[row][col], new int[]{row, col});
            }
        }
        return positionMap;
    }
    public static int getDistance(String s) {
        Map<String, int[]> positionMap = getMap();
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String from = String.valueOf(s.charAt(i));
            String to = String.valueOf(s.charAt(i + 1));
            int[] p1 = positionMap.get(from);
            int[] p2 = positionMap.get(to);

            int vertical = Math.abs(p1[0] - p2[0]);
            int horizontal = Math.abs(p1[1] - p2[1]);

            sum += vertical + horizontal;
        }
        return sum;
    }

    public static int totalSubstringDistance(String input) {
        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String substring = input.substring(i, j + 1);
                int dist = getDistance(substring);
                total += dist;

                // 디버깅 출력
                System.out.println(substring + " → 거리: " + dist);
            }
        }
        return total;
    }
}
