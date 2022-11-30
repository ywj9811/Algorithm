package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class B_1946 {
	public static void main(String[] args) throws IOException {
		//서류와 면접 둘중 각각의 점수가 누군가 보다 둘다 낮다면 절대 뽑힐 수 없다.
		//각각 순위가 주어진다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());//case의 갯수
		
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int arr[][]; //서류 면접 각각 저장
		for(int i = 0; i < n; i++) {
			num.add(Integer.parseInt(br.readLine()));//지원자 수 입력받음
			
			int c = num.get(i);
			arr = new int[c][2];
			
			for(int j = 0; j < c; j++) { //첫번째 케이스의 지원자들 석차 입력
				for(int k = 0; k < 2; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			for(int t = 0; t < c; t++) {
				for(int f = 0; f < c; f++) {
					if(arr[t][0] < arr[f][0] && arr[t][1] < arr[f][1])
						c--;
				}
			}
			
			cnt.add(c);
		}
		
		for(int i = 0; i < cnt.size(); i++)
			System.out.println(cnt.get(i));
	}
}
