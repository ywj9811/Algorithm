package Programmers.cote;

public class Test3 {
    public static int solution(int p, int index) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        // 숫자를 0부터 시작해서 p진수로 변환하며 문자열에 누적
        while (sb.length() < index) {
            sb.append(Integer.toString(num, p));
            num++;
        }

        // index는 1-based, 문자열은 0-based
        char result = sb.charAt(index - 1);
        return Integer.parseInt(String.valueOf(result));
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 15)); // 1
        System.out.println(solution(6, 20));  // 0
        System.out.println(solution(2, 16));  // 1
        System.out.println(solution(5, 7));  // 1
    }
}
