package backjoon_string;

import java.util.Scanner;

public class Re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt(); //몇개의 케이스를 사용할 것인가.
		
		for(int i = 0; i < t; i++) {
			int r = sc.nextInt(); //몇번 반복
			String s = sc.next(); //입력받을 문자열
			for(int j = 0; j < r; j++) {
				System.out.println(s.charAt(j));
			}
		}
	}
}
