package backjoon_function;

import java.util.ArrayList;

public class Self {
	static int sum(int a) {
		int sum = a;
		while(a != 0) {
			sum = sum + (a % 10);
			a = a/10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			arr.add((i+1));
			arr2.add(i+1);
		}
		
		for(int i = 0; i < arr.size(); i++) {
			for(int j = 0; j < arr2.size(); j++) {
				if(Self.sum(arr.get(i)) == arr2.get(j)) {
					arr2.remove(j);
					break;
				}
			}
		}
		for(int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));
		}
	}
}