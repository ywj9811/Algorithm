package baekjoon_greedy;

import java.util.Scanner;

public class B_16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n1 = sc.next();
		String n2 = sc.next(); 
		//n1 -> n2 까지 몇단계 +1
		//불가능인 경우 -1 출력.
		
		int cnt = 1;
		
		while(true) {
			if(Integer.parseInt(n2)%2 == 0) {
				n2 = String.valueOf(Integer.parseInt(n2)/2);
			}
			else {
				if(n2.charAt(n2.length()-1) == '1') {
					n2 = n2.substring(0, n2.length()-1);	
				}
				else {
					cnt = -1;
					break;
				}
			}
			cnt++;
			if(Integer.parseInt(n2) < Integer.parseInt(n1)) {
				cnt = -1;
				break;
			}
			if(Integer.parseInt(n2) == Integer.parseInt(n1))
				break;
		}
		System.out.println(cnt);
	}
}