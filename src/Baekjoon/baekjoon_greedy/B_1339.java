package baekjoon_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B_1339 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//단어의 개수 구하기.
		int alpha[] = new int[26]; //a~z까지 총 26개
		String num[] = new String[n];

		for(int i = 0; i < n; i++) {
			num[i] = sc.next(); //하나씩 받음.

			int temp = (int)Math.pow(10, num[i].length()-1); //pow는 double반환.

			for(int j = 0; j < num[i].length(); j++) {
				alpha[(int)num[i].charAt(i)-65] += temp;
				//num[i].charAt(i)-65란, A의 경우 0, B의 경우 1 ...
				//이렇게 나오게 된다. 따라서 각 알파벳 위치의 배열에 값을 더하게 되는것이다.
				//temp = 10000 1000 100 이런식으로.
				temp = temp/10;
			}
		}//alpha배열에 이렇게 하면 n가지의 단어에 공통한 a~z까지의 값들을 합한 값이 들어있다

		int sum = 0;
		int mul = 9;
		Arrays.sort(alpha);
		//alpha배열을 정렬함, 오름차순으로
		for(int i = alpha.length-1; i >= 0; i--) {
			sum = sum + alpha[i] * mul;
			if(alpha[i] == 0)
				break;
			mul--;
		}
		
		System.out.println(sum);
	}
}