package baekjoon_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); //각 배열의 길이.

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		//a, b 에 각각 ArrayList를 통해서 들어있음

		for(int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		for(int i = 0; i < n; i++) {
			b.add(sc.nextInt());
		}

		Collections.sort(a);
		//오름차순 정렬 !! Collections.sort함수!!
		int sum = 0;

		out : for(int i = 0; i < a.size();) {
			int max = 0; //max를 0으로 내부에서 초기화. b의 경우 가장 큰값부터 곱해야함.
			int t = 0; //인덱스 저장용
			
			for(int j = 0; j < b.size(); j++) {
				if(b.get(j) >= max) {
					max = b.get(j);
					t = j;
				}
			}
			
				if(a.size() > 1) {
					sum = sum + (a.get(0)*max);
					a.remove(0);
					b.remove(t);
				}
				else {
					sum = sum + (a.get(0)*(b.get(0)));
					break out;
				}
		
		}

		System.out.println(sum);
		sc.close();
	}
}