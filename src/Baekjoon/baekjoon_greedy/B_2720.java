package baekjoon_greedy;

import java.util.Scanner;

public class B_2720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //case의 개수
		int value[] = {25, 10, 5, 1};
		
		int val[] = new int[n];
		for(int i = 0; i < val.length; i++) {
			val[i] = sc.nextInt(); //각 케이스의 값을 입력
		}
		
		int amount[] = new int[4]; //25, 10, 5, 1
		for(int i = 0; i < val.length; i++) {
			for(int j = 0; j < amount.length; j++) {
				amount[j] = val[i]/value[j];
				val[i] = val[i]-(value[j]*amount[j]);
				System.out.print(amount[j] + " ");
			}
			System.out.println();
		}
	}
}
