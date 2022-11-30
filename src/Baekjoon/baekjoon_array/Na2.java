package backjoon_array;

import java.util.HashSet;
import java.util.Scanner;

public class Na2 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i <= 9; i++) {
			set.add(sc.nextInt() % 42);
		}
		
		int cnt = 0;
		for(int j = 0; j < set.size(); j++) {
			cnt++;
		}
		
		System.out.println(cnt);
	}
}

//배열 대신에 hashset을 사용하여 중복되는 숫자를 포함하지 않게함.
//따라서 중복된 나머지가 포함되지 않아서 서로 다른 나머지만 들어가게 됨.
//=> 서로 다른 나머지의 개수를 바로 알 수 있다.
