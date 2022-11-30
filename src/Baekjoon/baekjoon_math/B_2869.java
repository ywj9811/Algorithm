package baekjoon_math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String all = br.readLine();
		
		String arr[] = (all.split(" ")); //³ª´²¼­ °¡Áö°í ÀÖÀ»³ð
		int a = Integer.parseInt(arr[0]); //³·¿¡ ¿Ã¶ó°¨.
		int b = Integer.parseInt(arr[1]); //¹ã¿¡ ³»·Á¿È.
		int v = Integer.parseInt(arr[2]); //³ôÀÌ.
		
		int n = 0;
		do {
			n++;
			if(v - (a - b)*n <= a) {
				bw.write(String.valueOf((n+1)));
				break;
			}
		} while(true);
		bw.flush();
		bw.close();
	}
}