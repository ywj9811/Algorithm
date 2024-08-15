package Baekjoon.baekjoon_greedy;

import java.util.Scanner;

public class B_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //���� ��ġ n��
		int k = sc.nextInt(); //��
		int arr[] = new int[n];//�� ���� ������
		
		int cnt = 0; //���� ����.
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = (arr.length-1); i > 0; i--) {
			if(arr[i] <= k) {
				cnt = cnt + k/arr[i];
				k = k%arr[i];
			}
			else
				continue;
		}
		System.out.println(cnt);
	}
}
