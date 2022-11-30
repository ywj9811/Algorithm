package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1439 {
	public static void main(String[] args)throws IOException {
		//문자열S에 모든 숫자를 전부 같게 만들려고 한다
		//S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
		//뒤집는 것은 1을 0으로 0을 1로 뒤집는것을 의미함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int sum = 0;
		int sum2 = 0;
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == '0' && s.charAt(i+1) == '1') {
				sum++;
			}
			else if(s.charAt(i) == '1' && s.charAt(i+1) == '0') {
				sum2++;
			}
		}
		if(s.charAt(s.length()-1) == '1')
			sum2++;
		if(s.charAt(s.length()-1) == '0')
			sum++;
		if(sum >= sum2) {
			System.out.println(sum2);
		}
		else
			System.out.println(sum);
		
		br.close();
	}
}
