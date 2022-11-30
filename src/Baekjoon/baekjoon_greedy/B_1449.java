package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String all = br.readLine();
		String all2 = br.readLine();

		String arr[] = all.split(" ");
		String arr2[] = all2.split(" "); //공백을 기준으로 나누줌

		int l = Integer.parseInt(arr[1]);//테이프 길이

		int place[] = new int[arr2.length];//각 구멍의 위치
		for(int i = 0; i < place.length; i++) {
			place[i] = Integer.parseInt(arr2[i]);
		}

		Arrays.sort(place); //place를 오름차순으로 정렬함
		int n = 0;
		int sum = 1;
		double end = (place[0] - 0.5 + l);
		for(int i = 0; i < place.length; i++) {
			if(end < place[i] + 0.5) {
				sum++;
				end = place[i] - 0.5 + l;
			}
		}

		System.out.println(sum);
	}
}
