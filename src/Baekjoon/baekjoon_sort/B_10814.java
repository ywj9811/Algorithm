package baekjoon_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B_10814 {
	public static void main(String[] args) throws Exception {
		//나이가 증가하는 순, 나이가 같으면 먼저 가입한 순으로.
		//가입한 순서대로 데이터가 주어지게 된다.
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//2차원 배열로 입력을 받음
		String user[][] = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				user[i][j] = sc.next();
				//[][0]에는 나이 [][1]에는 이름이 들어있음
				//[][0]을 기준으로 정렬을 하지만 같다면 [i][]에서 i가 낮은순으로 정렬을 하면 된다.
			}
		}
		
		//다 입력받음
		Arrays.sort(user, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0]))
					return 0;
				else
					return (Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
			}
		});
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(user[i][j] + " ");
			}
			System.out.println();
		}
	}
}
