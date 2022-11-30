package baekjoon_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_2750_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			num.add(sc.nextInt());
		}
		Collections.sort(num);
		
		for(int i = 0; i < n; i++)
			System.out.println(num.get(i));
	}
}
