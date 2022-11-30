package backjoon_if;

import java.util.Scanner;

public class Quadrant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		int y;
		x = sc.nextInt();
		y = sc.nextInt();
		
		if(x > 0) {
			if(y > 0)
				System.out.println(1);
		}
		
		if(x < 0) {
			if(y > 0) 
				System.out.println(2);
		}
		
		if(x < 0) {
			if(y < 0)
				System.out.println(3);
		}
		
		if(x > 0) {
			if(y < 0)
				System.out.println(4);
		}
		
		sc.close();
	}
}
