package baekjoon_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_10989 {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		//int[] arr = new int[n]; //원래배열
		int[] count = new int[10001]; //각 값을 count
		//int[] result = new int[n]; //정렬 후 결과 배열
		
		for(int i = 0; i < n; i++) {
			count[Integer.parseInt(br.readLine())]++;
			//count배열은 애초에 각 값이 index가 되어 각 값이 몇개인지가 저장되는 배열로 바로 이렇게 사용할 수 있다.
			//그리고 index순서대로 값>0 일때까지 값--를 해주며 index를 그대로 출력해주면 정렬이 되어서 쭉 출력되게 된다. 
		}
		
		br.close();
		
		for(int i = 1; i < count.length; i++) {
			while(count[i] > 0) {
				bw.write(String.valueOf(i)); //int형을 바로 출력시켜버리면 x박스가 나옴
				bw.newLine();
				count[i]--;
			}
		}
		
		bw.flush();
		bw.close();
	}
}
