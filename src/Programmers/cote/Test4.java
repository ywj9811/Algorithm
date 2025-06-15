package Programmers.cote;

public class Test4 { // 빠른 거듭제곱 알고리즘 -> 수학 공식 이용
    private static final long MOD = 100000;

    public static long solution(long a, long b) {
        long result = 1;

        // a를 mod로 줄여서 불필요하게 큰 수의 곱셈을 방지 (성능, 오버플로우 예방)
        a %= MOD;

        // 반복문: 지수 b가 0이 될 때까지
        while (b > 0) {
            // b가 홀수인 경우에는, 현재의 a를 결과에 곱해줌
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }

            // 지수를 절반으로 줄이기 위해 밑 a를 제곱해줌
            // a^b = (a^2)^(b/2) 이므로
            a = (a * a) % MOD;

            // b를 절반으로 나눔 (다음 반복을 위한 준비)
            b /= 2;
        }

        // 결과값 반환: a^b % 100000
        return result;
    }

    public static void main(String[] args) {
        System.out.printf("2^26 → %05d\n", solution(2, 26));                   // 기대: 08864
        System.out.printf("123456789^12345 → %05d\n", solution(123456789L, 12345)); // 기대: 38549
        System.out.printf("2^10 → %05d\n", solution(2, 10));                 // 01024
        System.out.printf("7^1,000,000,000,000 → %05d\n", solution(7, 1_000_000_000_000L));
    }
}
