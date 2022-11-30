package baekjoon_greedy;

import java.util.Scanner;

public class B_13305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //도시의 개수
		
		int dis[] = new int[n-1]; //각 도시 사이의 거리
		for(int i = 0; i < dis.length; i++) {
			dis[i] = sc.nextInt();
		}
		
		int val[] = new int[n]; //각 주유소의 가격
		for(int i = 0; i < val.length; i++) {
			val[i] = sc.nextInt();
		}
		
		int now;
		long sum = val[0]*(long)dis[0]; //큰 숫자 대비 long 선언
		
		for(now = 0; now < val.length-2; now++) {
			for(int i = now + 1; i < val.length-1; i++) {
				if(val[now] <= val[i])
					sum = sum + ((long)dis[i] * val[now]);
				else {
					sum = sum + ((long)dis[i] * val[i]);
					now = i - 1;
					break;
				}
				now = i - 1; //else를 안거치고 끝까지 왔을 때 now의 변화가 없기 때문에 now를 증가시켜 다시 반복할 위험 제거
			}
		}
		
		System.out.println(sum);
	}
}
