package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1213 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		//영어를 입력받는다.
		//회문수가 되기 위해서는 일단 길이가 홀수
		//1개빼고 짝수, 나머지 하나만 홀수

		int num[] = new int[26];
		char arr[] = new char[str.length()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
			for(char a = 'A'; a < 'Z'; a++) {
				if(arr[i] == a)
					num[(int)a - 65]++;
			}
		}//arr[]에 str의 각 자리의 문자가 들어있다.
		//num[]에 A~Z까지 개수 저장
		int center = 0;
		int cnt = 0;
		for(int i = 0; i < num.length; i++) {
			if(num[i] > 0) {
				if(num[i]%2 != 0) {
					center = i;
					cnt++;
				}
			}
		}

		//arr[]에 str의 각 자리의 문자가 들어있다.
		//num[]에 A~Z까지 개수 저장
		//arr에는 str의 각 자리 문자가 들어있으니 사용x num의 값을 이용해서 i+65를 아스키코드 이용
		if(cnt > 1)
			System.out.println("I'm Sorry Hansoo");
		else {
			for(int i = 0; i < num.length; i++) {
				if(num[i]>0) {
					for(int j = 0; j < num[i]/2; j++) {
						System.out.print((char)(i+65));
					}
				}
			}
			
			if(cnt == 1)
				System.out.print((char)(center+65));
			
			for(int i = num.length-1; i >= 0; i--) {
				if(num[i]>0) {
					for(int j = 0; j < num[i]/2; j++) {
						System.out.print((char)(i+65));
					}
				}
			}
		}
	}
}
