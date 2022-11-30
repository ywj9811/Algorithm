package backjoon_string;

import java.util.Scanner;

public class Study {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		int cnt[] = new int[26];
		//문자열 입력받기와 a~z까지 비교용, 그리고 a~z까지 횟수 카운트

		int max = 0;	  //누가 최대값인지 갯수 저장용
		char max2 = ' ';  //만약 여러개 나오면 ?를 저장하기 위해
		char max3 = ' ';  //어떤 문자가 최대인지 저장(max 이용)
		int count = 0;    //최대값이 여러개 나오는지 카운트

		for(int i = 0; i < abc.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(abc.charAt(i) == input.charAt(j))
					cnt[i]++;
				else if((int)abc.charAt(i) == ((int)input.charAt(j) + 32))
					cnt[i]++;
			}
			
			if(cnt[i] > max) {
				max = cnt[i]; //이건 몇번나오는지 알게 되는것. 무엇이 가장 많이 나왓는지 알아야함.
				max3 = abc.charAt(i); //무엇이 가장 많이 나왔는지 해결.
			}
		} //각각 최대값 확인
		
		for(int i = 0; i < abc.length(); i++) {
			if(max == cnt[i])
				count++;
			if(count > 1) {
				max2 = '?';
				break;
			}
		}//여러개인지 체크

		if(max2 != '?')
			if('A' <= max3 && max3 <= 'Z')
				System.out.println(max3);
			else
				System.out.println((char)(max3-32));
		else
			System.out.println(max2);
	}
}
