package backjoon_function;

import java.util.Scanner;

class Test {
	Test(int[] a){
		this.a = a;
	}
	
	int a[];
	long sum(int[] a) {
		long s = 0;
		for(int i = 0; i < a.length; i++) {
			s = s + a[i];
		}
		return s;
	}
}
public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Test test = new Test(arr);
		System.out.println(test.sum(arr));
	}
}
