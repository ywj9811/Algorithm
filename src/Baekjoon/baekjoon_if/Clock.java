package backjoon_if;

import java.util.Scanner;

public class Clock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int m1 = sc.nextInt();
		int time = sc.nextInt();
		
		if(m1 + time >= 60) {
			if(m1 + time >= 120) {
				h1 = h1+2;
				m1 = m1+time - 120;
				if(h1 > 23)
					h1 = h1 - 24;
			}
			else {
				h1 = h1+1;
				m1 = m1+time - 60;
				if(h1 > 23)
					h1 = h1 - 24;
			}
		}
		else
			m1 = m1 + time;
		
		System.out.println(h1 + " " + m1);
		
		sc.close();
	}
}
