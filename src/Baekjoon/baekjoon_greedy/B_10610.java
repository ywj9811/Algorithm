package baekjoon_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_10610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next(); //입력 받음
		
		ArrayList<Integer> arr= new ArrayList<Integer>();
		
		boolean tf = false;//0이 존재하는지
		int sum = 0;
		
		for(int i = 0; i < n.length(); i++) {
			int a = n.charAt(i)-'0';
			arr.add(a);
			//char형에서 -'0'을 하거나 혹은
			//(Character.getNumericValue(n.charAt(i)))를 사용해도 된다.
			sum += a;
			if(a == 0)
				tf = true;			
		}
		if(sum%3 != 0)
			tf = false;
		
		if(tf == true) {
			Collections.sort(arr);
			for(int i = arr.size()-1; i >= 0; i--) {
				System.out.print(arr.get(i));
			}
		}
		else
			System.out.println(-1);
	}
}
//arr[0~9]0부터 순서대로 1의자리 10의자리 .... 올라간다.
//30의 배수가 되기 위해서는 1의 자리 = 0, 3의 배수.
//조건 : 0이 존재해야하고 각 자리수의 합 = 3의 배수.