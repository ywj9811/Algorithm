package backjoon_array;

import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		//�Է� : n���� ����, ������ ���� 3��
		//��� : ������/�ִ����� * 100 ���� 3���� ���
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n���� ����
		int max = 0; //�ִ밪
		
		int arr[] = new int[n]; //���� ����
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > max) 
				max = arr[i];
		}
		
		double sum = 0;
		double arr1[] = new double[n]; //���ο� ����.
		for(int j = 0; j < arr.length; j++) {
			arr1[j] = (arr[j]/(double)max) * 100;
			sum = sum + arr1[j];
		}
		
		double average = sum/n;
		
		System.out.println(average);
	}
}
