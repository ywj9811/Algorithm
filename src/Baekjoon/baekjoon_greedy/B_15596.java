package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15596 {

	static long sum(int[] a) {
		long s = 0;
		for(int i = 0; i < a.length; i++) {
			s = s + a[i];
		}
		return s;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(sum(arr));
	}
}
