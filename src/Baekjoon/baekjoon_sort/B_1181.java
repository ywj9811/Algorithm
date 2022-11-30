package baekjoon_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_1181 {
	void swap(String[] a, int idx1, int idx2){
		String t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
		//두개를 바꿈
	}


	void quicksort(String[] a, int left, int right) {
		int pl = left; //왼쪽 커서
		int pr = right; //오른쪽 커서
		String x = a[(pl+pr)/2]; //가운데 위치값 : 기준값

		do {
			while(a[pl].length() < x.length())
				pl++; //왼쪽부터 검사하며 가운데보다 길이가 짧으면 pl을 하나 증가, 크다면 while을 탈출
			while(a[pr].length() > x.length())
				pr--; //반대
			if(pl <= pr)
				swap(a, pl++, pr--); //현 pl은 같거나 더 크고, 현 pr은 작거나 같으므로 바꿔줌 그리고 하나씩 움직임
		} while(pl <= pr); //pr과 pl이 교차할때 까지 반복

		if(left < pr) //pr이 아직 left보다 오른쪽이라면 right를 pr로 하고 내부에서 다시한번 정렬
			quicksort(a, left, pr);
		if(pl < right) //pl이 아직 right보다 왼쪽이라면 left를 pl로 내부에서 다시한번 정렬
			quicksort(a, pl, right);
	} //위의 각각의 재귀에서 반복적으로 수행을 하게된다. 완료하면 길이별로 정렬이 완료됨

	//quicksort메소드를 통해서 우선 길이순으로 정렬함

	void sort(String[] str, int i, int j) {
		int a = str[i].charAt(j);
		int b = str[i+1].charAt(j);
		if(a > b) {
			swap(str, i, i+1);
			return;
		}
		else if(a < b) {
			return;
		}

		j++;
		if(j >= str[i].length())
			return;
		sort(str, i, j); //재귀
	}

	void check(String str[], int i) {
		if(str[i].length() == str[i+1].length()) {
			int j = 0;
			sort(str, i, j);
		}
		i++;
		if(i == str.length-1)
			return;
		check(str, i); //재귀
	}

	public static void main(String[] args) throws Exception{
		
		B_1181 b = new B_1181();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); //몇개의 단어를 입력받을까.
		String str[] = new String[n];
		//길이가 짧은것이 1순위
		//같으면 사전순으로
		for(int i = 0; i < str.length; i++) {
			str[i] = br.readLine();
		}

		b.quicksort(str, 0, n-1); //길이순으로 정렬을 함

		for(int t = 0; t < str.length; t++) {
			int i = 0;
			b.check(str, i);
		}//속도를 위해 재귀로 묶음

		for(int i = 0; i < str.length-1; i++) {
			if(str[i].equals(str[i+1]))
				continue;
			bw.write(str[i]);
			bw.newLine();
			bw.flush();
			
		}

		bw.close();
		
	}
}
