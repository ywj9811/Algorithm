package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_11497 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine()); //케이스의 개수
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine()); //통나무의 개수 입력
			int max = 0;
			String[] str = new String[k];
			int[] arr = new int[k];			
			
			String height = br.readLine();
			
			str = height.split(" ");
			for(int j = 0; j < arr.length; j++)
				arr[j] = Integer.parseInt(str[j]);

			Arrays.sort(arr); //통나무 높이 오름차순 정렬
			//작은값부터 양옆에 배치
			
			for(int t = 2; t < arr.length; t++) {
				if((arr[t] - arr[t-2]) > max)
					max = (arr[t] - arr[t-2]);
			}
			
			System.out.println(max);
		}
	}
}