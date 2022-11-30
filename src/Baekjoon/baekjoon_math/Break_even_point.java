package baekjoon_math;

import java.util.Scanner;

public class Break_even_point {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); //그냥 고정 지출
		int b = sc.nextInt(); //한대당 비용
		int c = sc.nextInt(); //판매가

		long n = 1; //판매 갯수

		while(c*n <= (a + b*n)) {
			if(c < b) {
				break;
			}
			n++;
		}

		if(c < b)
			System.out.println("-1");
		else
			System.out.println(n);
	}
}

//나중에 BufferedReader 사용하기