package Programmers.cote;

import java.math.BigInteger;

public class 거듭제곱 {
    public static void main(String[] args) {
        System.out.println(solution(123456789, 12345));
        System.out.println(solution(2, 26));
    }
    static long solution(long a, long b) {
        BigInteger first = BigInteger.valueOf(a);
        BigInteger second = BigInteger.valueOf(b);

        BigInteger result = first.modPow(second, new BigInteger(String.valueOf(100000)));

        return result.longValue();
    }
}
