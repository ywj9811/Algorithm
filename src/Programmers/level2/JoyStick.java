package Programmers.level2;

public class JoyStick {
    public static void main(String[] args) {

    }

    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            // A 뭉탱이 찾아서 위치 알아두기.

            move = Math.min(move, Math.min(i * 2 + (len - next), (len - next) * 2 + i));
        }

        return answer + move;
    }
}
