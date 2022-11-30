package baekjoon_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B_2751 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int n = Integer.parseInt(a);
		
		for(int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		for(int i = 0; i < n; i++) {
			bw.write(String.valueOf(arr.get(i)));
		}
		
		bw.flush();
		bw.close();
	}
}
