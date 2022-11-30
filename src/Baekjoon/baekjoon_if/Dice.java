package backjoon_if;

import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {
		/*
		  a == b
		  일때
		  	b == c 라면 -> 3개 같음
		  	b != c 라면 -> 2개 같음
		  
		  a != b
		  일때
		  	a != c인가?
		  		b == c인가. -> 2개 같음.
		  		b != c인가. -> 다 다름.
		  	a == c -> 2개 같음
		 */
		
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c;
		int sum;
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		if(a == b) {
			if(b == c) {
				sum = 10000 + a*1000;
				System.out.println(sum);
			}
		}
		
		else
			if(a != c) {
				if(b == c) {
					sum = 1000 + b*100;
				}
				else {
					if(a > b)
						if(a > c)
							sum = 100 * a;
						else if(a < c)
							sum = 100 * c;
				}
			}
	}
}
