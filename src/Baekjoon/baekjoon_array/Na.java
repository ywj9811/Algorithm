package Baekjoon.baekjoon_array;

import java.util.Scanner;

public class Na {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		boolean bl; //n��°�� n+1��°�� ���ϱ� ���� ����
		int cnt = 0; //���� �ٸ� ���������� ������ �����ϱ� ���� ����

		for(int i=0; i<arr.length; i++ ) {
			arr[i] = sc.nextInt() % 42;
		}
		for(int i=0; i<arr.length; i++ ) {
			bl = false; //�⺻���� false�� ����
			for(int k=i+1; k<arr.length; k++ ) {
				if( arr[i] == arr[k] ) { //�迭�� n��°�� n+1��°�� ���� ��
					bl = true; //���ٸ� bl���� true�� ����
					break; //�ѹ��� ���ϸ� �Ǵ� ������ �����ϸ� �����
				}
			}
			if( bl == false ) {
				cnt ++; //bl�� ���� false�� �� ī��Ʈ�� 1����
			} //���� true�� �������� ���� ���ٴ� ���̴� ī��Ʈ�� �ø� �ʿ�x
		}
		System.out.println(cnt);
	}
}