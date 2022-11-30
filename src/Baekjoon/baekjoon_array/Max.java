package backjoon_array;

import java.util.Scanner;

public class Max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int n = 0;
		for(int j = 0; j < arr.length; j++) {
			if(max < arr[j]) {
				max = arr[j];
				n = j + 1; 
			}
		}
		
		System.out.println(max);
		System.out.println(n);
	}
}
