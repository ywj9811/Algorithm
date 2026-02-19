package Programmers.level2;

public class MakeBigNumber {
    public static void main(String[] args) {
        String solution = new MakeBigNumber().solution("4177252841", 2);
        System.out.println(solution);
    }

    public String solution(String number, int k) {
        // 결과를 담을 바구니 (Stack 대신 StringBuilder를 쓰면 마지막에 String 변환이 쉬워요)
        StringBuilder sb = new StringBuilder();
        int len = number.length();

        for (int i = 0; i < len; i++) {
            char current = number.charAt(i);

            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < current) {
                sb.deleteCharAt(sb.length() - 1); // 앞의 작은 숫자를 버림
                k--; // 지울 기회 사용
            }

            sb.append(current); // 일단 지금 숫자를 바구니에 넣음
        }

        return sb.substring(0, sb.length() - k);
    }
    /**
     * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

     * 4177252841 이렇게 들어오는 경우. k = 4라면
     * 제일 큰 숫자로 시작하는 것이 이득.
     *
     * 제일 큰 숫자의 위치를 찾아내는 것이 중요하지 않을까
     *
     * k보다 아래 숫자의 위치 중 가장 큰 숫자(위치 i)를 찾아서 앞의 숫자를 모두 지우고.
     * 제일 큰 숫자를 찾으면 뒤로 진행하다가
     *
     * k-i 보다 아래 숫자의 위치 중 가장 큰 숫자를 찾아서 앞의 숫자를 모두 지워.
     *
     * 이것을 반복하면 되지 않을까?
     *
     * 4177252841 , k=4
     * i = 2 or 3
     * 2를 선택.
     * k-i = 2
     * 7 7252841
     * 0번 선택
     * k-i = 2
     * 77 252841
     * 1번 선택
     * k-i = 1
     * 775 2841
     * 1번 선택
     * k-i = 0
     * 775841
     */
}
