package baekjoon_greedy;

import java.util.Scanner;

//회의 시간이 겹치지 않도록 사용할 수 있는 최대의 시간.
public class B_24918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //n개의 회의가 있음.
		
		int[][] arr = new int[n][2]; //가로에 시작, 끝 두개가 들어간다.
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		} //각각 넣어줌.
		
		
	}
}
