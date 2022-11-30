package backjoon_array;

import java.util.Scanner;

public class Ox {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개의 케이스 대입할것인가 : ");
		int n = sc.nextInt();
		String ox[] = new String[n]; //n개의 String케이스
		
		int cnt = 0;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			ox[i] = sc.next();
			
			for(int j = 0; j < ox[i].length(); j++) {
				if(ox[i].charAt(j) == 'O') {
					if(j > 0) {
						if(ox[i].charAt(j - 1) == 'O')
							cnt++;
						else
							cnt = 1;
					}
					else
						cnt = 1;
				}
				else
					cnt = 0;
				sum = sum + cnt;
			}

			//왜 바로 여기로 넘어오는가. -> next()로 바꿨더니 괜찮아짐. 왜지
			System.out.println(sum);
			sum = 0;
		}
	}
}
