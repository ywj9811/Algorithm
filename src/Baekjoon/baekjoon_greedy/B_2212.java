package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2212 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//k개의 집중국
		//n개의 센서가 적어도 하나의 집중국과는 통신이 가능
		//집중국의 유지비 문제로 인해 각 집중국의 수신가능 영역의 길이의 합을 최소화
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		String str= br.readLine();
		String[] str2 = str.split(" ");
		int[] arr = new int[str2.length];
		
		for(int i = 0; i < str2.length; i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}
		//arr[]에 각 센서들의 좌표가 들어있음
		
		Arrays.sort(arr);
		//오름차순으로 정렬
		int[] arr2 = new int[arr.length-1];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = (arr[i+1] - arr[i]);
		}
		
		Arrays.sort(arr2);
		int sum = 0;
		for(int i = 0; i < arr.length-k; i++) {
			sum += arr2[i];
		}
		System.out.println(sum);
	}
}
