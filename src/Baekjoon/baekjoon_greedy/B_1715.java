package baekjoon_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_1715 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int n = sc.nextInt(); //비교 몇개 할것인가.

		for(int i = 0; i < n; i++) { 
			arr.get(sc.nextInt());
		}
		Collections.sort(arr);

		if(arr.size() >= 2) {
			int sum = arr.get(0) + arr.get(1);
			for(int i = 2; i < arr.size(); i++) {
				sum = arr.get(i);
			}
		}
	}
}
