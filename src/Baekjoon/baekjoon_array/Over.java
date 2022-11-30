package backjoon_array;

import java.util.Scanner;

public class Over {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개의 케이스를 입력할 것인가 : ");
		int n = sc.nextInt();
		
		int sum = 0;
		double avg;
		
		for(int i = 0; i < n; i++) {
			System.out.println("학생수 : ");
			int a = sc.nextInt();         //a는 학생수.
			int student[] = new int[a];
			
			for(int j = 0; j < a; j++) {
				student[j] = sc.nextInt(); //a명의 각각 학생에게 점수를 준다.
				sum += student[j];
			}
			avg = sum / (double)a;
			int cnt = 0;
			for(int k = 0; k < a; k++) {
				if(student[k] > avg)
					cnt++;
			}
			
			double avg2 = (double)cnt / a * 100;
			String avg3 = String.format("%.4f", avg2); //c처럼 .3f 하면 3번째 자리까지...
			//추후에 다시 하자.
		}
	}
}
