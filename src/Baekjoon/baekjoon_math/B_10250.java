package baekjoon_math;

import java.util.Scanner;

public class B_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //몇개의 케이스를 할까.
		for(int i = 0; i < n; i++) {
			int h = sc.nextInt(); //호텔방
			int w = sc.nextInt(); //호텔높이		
			int p = sc.nextInt(); //몇번째 손님인다.
			
			out : for(int x = 0; x < w; x++) {
				for(int y = 1; y <= h; y++) {
					if(x*h + y == p) {
						System.out.printf("%d%02d \n", y, x+1);
						break out;
					}
				}
			}
		}
	}
}