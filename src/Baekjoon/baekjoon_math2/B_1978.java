package baekjoon_math2;

import java.util.Scanner;

public class B_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n개의 값을 입력받겠다.
		int cnt = 0; //소수 몇개
		
		int arr[] = new int[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}//값 입력받기.
		
		out : for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1)
				continue;
			for(int j = 2; j < arr[i]; j++) {
				if(arr[i] % j == 0)
					continue out;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
