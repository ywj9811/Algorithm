package baekjoon_math2;

import java.util.ArrayList;
import java.util.Scanner;

public class B_2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); //m이상
		int n = sc.nextInt(); //n이하.
		int sum = 0; //m ~ n의 소수의 합.

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for(int i = m; i <= n; i++) {
			arr.add(i); //다 넣어주자.
		}
		//범위안의 첫번째 소수를 뽑아내기 위한 변수선언.
		int cnt = 0;
		int k = 0;

		out : for(int i = 0; i < arr.size(); i++) {
			for(int j = 2; j < arr.get(i); j++) {
				if(arr.get(i) % j == 0)
					continue out;
			}
			if(arr.get(i) != 1) {
				cnt++;
				sum = sum + arr.get(i);
			}
			if(cnt == 1)
				k = i;
		}
		
		if(sum != 0) {
			System.out.println(arr.get(k));
			System.out.println(sum);
		}
		else
			System.out.println(-1);
	}
}