package baekjoon_greedy;

import java.util.Scanner;

public class B_2864 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n1 = sc.next();
		String n2 = sc.next();
		//5와 6은 헷갈린다.
		//두 정수의 합의 최댓값, 최솟값
		//최소 -> 6을 5로, 최대 -> 5를 6으로
		
		//max 구하기
		n1 = n1.replace('5', '6');
		n2 = n2.replace('5', '6');
		int max = Integer.parseInt(n1) + Integer.parseInt(n2);
		
		n1 = n1.replace('6', '5');
		n2 = n2.replace('6', '5');
		int min = Integer.parseInt(n1) + Integer.parseInt(n2);
		
		System.out.println(min + " " + max);
	}
}
