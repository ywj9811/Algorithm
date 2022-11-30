package baekjoon_math;

import java.math.BigInteger;
import java.util.Scanner;

public class B_10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		BigInteger bi1 = new BigInteger(a);
		BigInteger bi2 = new BigInteger(b);
		
		System.out.println(bi1.add(bi2));
	}
}

//long으로 커버되지 않는 길이의 값은 BigInteger이라는 클래스를 이용하여야 한다.
//다른 클래스 객체 생성과 마찬가지로 BigInteger 이름 = new BigInteger("값") 을 통해서 만든다.
//사용은 클래스이기 때문에 +,-,%같으 연산자가 안되고 .add, .subtract, .multiply등을 사용해야 한다.