package backjoon_for;

import java.util.Scanner;

public class Fast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, sum;
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			sum = a + b;
			System.out.println("case #"+ i + " : " + a + " + " + b + " = " + sum);
		}
	}
}
