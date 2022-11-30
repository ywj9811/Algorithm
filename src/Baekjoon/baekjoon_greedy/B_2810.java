package baekjoon_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2810 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//ÁÂ¼®ÀÇ °³¼ö
		
		int l = 0;
		String str = br.readLine();
		char sit[] = new char[n];
		for(int i = 0; i < n; i++) {
			sit[i] = str.charAt(i);
			if(sit[i] == 'L')
				l++;
		}
		
		int cup = n+1 - (l/2);
		if(n < cup)
			cup = n;
		System.out.println(cup);
	}
}
