package baekjoon_greedy;

import java.util.Scanner;

public class B_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); //식을 입력받음.
		String[] arr1 = str.split("-"); //-로 식을 나눔
		
		int sum = Integer.MAX_VALUE; //초기값으로 최대값을 일단 설정함. 첫번째임을 알 수 있도록.
		
		for(int i = 0; i < arr1.length; i++) {
			String[] arr2 = arr1[i].split("\\+"); //arr2에는 -를 기준으로 나눈 식들이 들어있음. ex 50, 50+40, 40 이 값들은 모두 빼주면 됨. 
											      //+의 경우는 더해주고 빼주면 됨.
			int add = 0;
			
			for(int j = 0; j < arr2.length; j++) {
				add = Integer.parseInt(arr2[j]) + add; //50으로 들어올 경우 그냥 add = 50임 배열의 길이가 1이니가.
			}										   //50+40으로 들어올 경우 add = 50 + 0, add = 50 + 40 순서로 진행이 된다.
			
			if(sum == Integer.MAX_VALUE)//sum이 건드려진적 없으니가 첫번째 값임.
				sum = add;
			else
				sum = sum - add;
		}
		//즉 처음부터 -로 나눠놓고 그 나뉘어진 문자열들 중 +를 가진 경우만 더해주고 그 값들을 모아 첫번째 값에서 빼주면 결과가 나온다.
			
			System.out.println(sum);
	}
}