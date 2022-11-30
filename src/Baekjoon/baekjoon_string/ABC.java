package backjoon_string;

import java.util.ArrayList;
import java.util.Scanner;

public class ABC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 'a'; i <= 'z'; i++) {
			arr.add(i-97, -1);
			for(int j = 0; j < s.length(); j++) {
				if(i == (int)s.charAt(j)) {
					arr.set((i-97), j); //set을 해야 값을 바꿔주기 때문에
										//add로 할 경우 값이 추가되어 size가 커지게 된다.
					break;
				}
			}
		}
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
			System.out.print(" ");
		}
	}
}