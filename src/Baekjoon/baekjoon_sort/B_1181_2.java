package baekjoon_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B_1181_2 {
	public static void main(String args[]) throws IOException{
	   	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   	 
	   	 	int n = Integer.parseInt(br.readLine());
	   	 	
	   	 	String[] arr = new String[n];
	   	 	
	   	 	for(int i =  0 ; i < n ; i++) {
	   	 		arr[i] = br.readLine();
	   	 	}
	   	 	
	   	 	
	   	 	Arrays.sort(arr, 
	   	 	new Comparator<String>() { //arr라는 배열을 받아서 이것을 Comparator<String>()에 의해서 정렬을 함
	   	 							   //이때 Coparator에 의해서 정렬을 하는데 Comparotr을 재정의하여 기준을 새로 잡아줌
	   	 		@Override
	   	 		public int compare(String s1, String s2) { //compare메소드의 경우 내부 구현에 따라서 int형 반환을 함
		   	 		if(s1.length() == s2.length()) {
		   	 			return s1.compareTo(s2); //같다면 0 s1이 크다면 1 s2가 크다면 -1 --> 길이가 같을경우 사전순
		   	 		}else {
		   	 			return s1.length() - s2.length(); //s1이 크다면 양수, 작다면 음수
		   	 		}
	   	 		
	   	 		}
	   	 	});//Comparator재정의 끝 이에 의해서 정렬을 함
	   
	   	 	System.out.println(arr[0]);
	   	 	for(int i = 1; i < n; i++) {
		   		if (!arr[i].equals(arr[i - 1])) {
					System.out.println(arr[i]);
				}
		}
	}
}
