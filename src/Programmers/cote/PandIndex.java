package Programmers.cote;

public class PandIndex {
    public static void main(String[] args) {
        System.out.println(solution(10, 15));
        System.out.println(solution(6, 20));
        System.out.println(solution(2, 16));
    }

    static int solution(int p, int index) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (sb.length() < index) {
            sb.append(Integer.toString(num++, p)); // p진법 사용하도록 설정할 수 있음
        }
        return Integer.parseInt(String.valueOf(sb.charAt(index-1)));
        // 문자 → 정수 변환
    }
}
