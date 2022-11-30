package baekjoon_math;

import java.util.Scanner;

public class Bee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n = 0;
		int cnt = 2;
		
		for(int i = 2; i < 1000000001; i = i + n) {
			if(num == 1) {
				System.out.println(1);
				break;
			}
			if(num >= i && num < i + 6 + n) {
				System.out.println(cnt);
				break;
			}
			
			n = n+6;
			cnt++;
		}
		
		sc.close();
	}
}
