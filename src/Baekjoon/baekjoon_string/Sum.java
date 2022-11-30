package backjoon_string;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String input2 = sc.next();
		
		int sum = 0;
		int i = input2.length();

		while(i > 0) {
			sum = sum + (int)input2.charAt(i-1) - 48;
			i--;
		}
		
		System.out.println(sum);
	}
}
