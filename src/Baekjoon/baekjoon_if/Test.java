package backjoon_if;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.print("점수를 입력하시오 : ");
		input = sc.nextInt();
		if(90 <= input && input <= 100)
			System.out.println("A");
		else if(80 <= input && input < 90)
			System.out.println("B");
		else if(70 <= input && input < 80)
			System.out.println("C");
		else if(60 <= input && input < 70)
			System.out.println("D");
		else
			System.out.println("F");
		
		sc.close();
	}
}
