package baekjoon_greedy;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		//오름차순으로 정리하면 최소한의 시간이 나오는것 같다.
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //몇명이 있는가.
		int arr[] = new int[n]; //각각의 사람들에 대한 기다리는 시간.
		int t; //오름차순 정리하기 위한 빈값.
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i; j < arr.length - 1; j++) {
				if(arr[i] > arr[j+1]) {
					t = arr[j+1];
					arr[j+1] = arr[i];
					arr[i] = t;
				}
			}
		}
		//오름차순 정렬 완료.
		
		int sum3 = 0; //결론 합.
		int sum2 = 0; //각각의 사람까지의 합.
		int sum[] = new int[n]; //그 각각의 사람마다의 합을 저장할 배열
		for(int i = 0; i < arr.length; i++) {
			sum2 = sum2 + arr[i];
			sum[i] = sum2;
			sum3 = sum3 + sum[i];
		}
		System.out.println(sum3);
		
		sc.close();
	}
}
