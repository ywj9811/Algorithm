package baekjoon_greedy;

import java.util.Scanner;

public class B_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //µ·ÀÇ °¡Ä¡ n°³
		int k = sc.nextInt(); //µ·
		int arr[] = new int[n];//°¢ µ·ÀÇ ´ÜÀ§µé
		
		int cnt = 0; //µ·ÀÇ °³¼ö.
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = (arr.length-1); i > 0; i--) {
			if(arr[i] <= k) {
				cnt = cnt + k/arr[i];
				k = k%arr[i];
			}
			else
				continue;
		}
		System.out.println(cnt);
	}
}
