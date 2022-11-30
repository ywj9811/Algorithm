package baekjoon_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char num[] = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			num[i] = str.charAt(i);
		}
		
		Arrays.sort(num);
		
		for(int i = num.length-1; i >= 0; i--)
			System.out.print(num[i]);
	}
}
