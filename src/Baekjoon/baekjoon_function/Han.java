package backjoon_function;

import java.util.Scanner;

public class Han {
	static int han(int n) {
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(i < 100)
				cnt++;
			else
				if(i/100 - i%100/10 == i%100/10 - i%10) 
					cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(Han.han(n));
	}
}
