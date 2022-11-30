package baekjoon_sort;

import java.util.Scanner;

public class B_2750 {
	public static void main(String[] args) {
		//오름차순으로 정렬
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//n개의 숫자 입력
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int t = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if(arr[j] > arr[j+1]) {
					t = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = t;					
				}
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
//자료구조 책을 확인해보면 더 효율적인 방법이 있음